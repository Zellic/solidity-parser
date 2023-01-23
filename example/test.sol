// SPDX-License-Identifier: GPL-3.0-only
pragma solidity 0.8.17;

import "./Base.sol";
import {IWithdrawer} from "../interface/IWithdrawer.sol";
import {MinipoolStatus} from "../types/MinipoolStatus.sol";
import {MultisigManager} from "./MultisigManager.sol";
import {Oracle} from "./Oracle.sol";
import {ProtocolDAO} from "./ProtocolDAO.sol";
import {Staking} from "./Staking.sol";
import {Storage} from "./Storage.sol";
import {TokenggAVAX} from "./tokens/TokenggAVAX.sol";
import {TokenGGP} from "./tokens/TokenGGP.sol";
import {Vault} from "./Vault.sol";

import {ERC20} from "@rari-capital/solmate/src/mixins/ERC4626.sol";
import {FixedPointMathLib} from "@rari-capital/solmate/src/utils/FixedPointMathLib.sol";
import {ReentrancyGuard} from "@rari-capital/solmate/src/utils/ReentrancyGuard.sol";
import {SafeTransferLib} from "@rari-capital/solmate/src/utils/SafeTransferLib.sol";

/*
	Data Storage Schema
	NodeIDs are 20 bytes so can use Solidity 'address' as storage type for them
	NodeIDs can be added, but never removed. If a nodeID submits another validation request,
		it will overwrite the old one (only allowed for specific statuses).

	MinipoolManager.TotalAVAXLiquidStakerAmt = total for all active minipools (Prelaunch/Launched/Staking)

	minipool.count = Starts at 0 and counts up by 1 after a node is added.

	minipool.index<nodeID> = <index> of nodeID
	minipool.item<index>.nodeID = nodeID used as primary key (NOT the ascii "Node-123..." but the actual 20 bytes)
	minipool.item<index>.status = enum
	minipool.item<index>.duration = requested validation duration in seconds (performed as 14 day cycles)
	minipool.item<index>.delegationFee = node operator specified fee (must be between 0 and 1 ether) 2% is 0.2 ether
	minipool.item<index>.owner = owner address
	minipool.item<index>.multisigAddr = which Rialto multisig is assigned to manage this validation
	minipool.item<index>.avaxNodeOpAmt = avax deposited by node operator (for this cycle)
	minipool.item<index>.avaxNodeOpInitialAmt = avax deposited by node operator for the **first** validation cycle
	minipool.item<index>.avaxLiquidStakerAmt = avax deposited by users and assigned to this nodeID

	// Submitted by the Rialto oracle
	minipool.item<index>.txID = transaction id of the AddValidatorTx
	minipool.item<index>.initialStartTime = actual time the **first** validation cycle was started
	minipool.item<index>.startTime = actual time validation was started
	minipool.item<index>.endTime = actual time validation was finished
	minipool.item<index>.avaxTotalRewardAmt = Actual total avax rewards paid by avalanchego to the TSS P-chain addr
	minipool.item<index>.errorCode = bytes32 that encodes an error msg if something went wrong during launch of minipool

	// Calculated in recordStakingEnd()
	minipool.item<index>.avaxNodeOpRewardAmt
	minipool.item<index>.avaxLiquidStakerRewardAmt
	minipool.item<index>.ggpSlashAmt = amt of ggp bond that was slashed if necessary (expected reward amt = avaxLiquidStakerAmt * x%/yr / ggpPriceInAvax)
*/

/// @title Minipool creation and management
contract MinipoolManager is Base, ReentrancyGuard, IWithdrawer {
	using FixedPointMathLib for uint256;
	using SafeTransferLib for address;
	using SafeTransferLib for ERC20;

	error InsufficientGGPCollateralization();
	error InsufficientAVAXForMinipoolCreation();
	error InvalidAmount();
	error InvalidAVAXAssignmentRequest();
	error InvalidStartTime();
	error InvalidEndTime();
	error InvalidMultisigAddress();
	error InvalidNodeID();
	error InvalidStateTransition();
	error MinipoolNotFound();
	error OnlyOwner();
	error CancellationTooEarly();

	event GGPSlashed(address indexed nodeID, uint256 ggp);
	event MinipoolStatusChanged(address indexed nodeID, MinipoolStatus indexed status);

	ERC20 public immutable ggp;
	TokenggAVAX public immutable ggAVAX;

	/// @dev Not used for storage, just for returning data from view functions
	struct Minipool {
		int256 index;
		address nodeID;
		uint256 status;
		uint256 duration;
		uint256 delegationFee;
		address owner;
		address multisigAddr;
		uint256 avaxNodeOpAmt;
		uint256 avaxNodeOpInitialAmt;
		uint256 avaxLiquidStakerAmt;
		// Submitted by the Rialto Oracle
		bytes32 txID;
		uint256 initialStartTime;
		uint256 startTime;
		uint256 endTime;
		uint256 avaxTotalRewardAmt;
		bytes32 errorCode;
		// Calculated in recordStakingEnd
		uint256 ggpSlashAmt;
		uint256 avaxNodeOpRewardAmt;
		uint256 avaxLiquidStakerRewardAmt;
	}

	function receiveWithdrawalAVAX() external payable {}

	//
	// GUARDS
	//

	/// @notice Look up minipool owner by minipool index
	/// @param minipoolIndex A valid minipool index
	/// @return minipool owner or revert
	function onlyOwner(int256 minipoolIndex) private view returns (address) {
		address owner = getAddress(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".owner")));
		if (msg.sender != owner) {
			revert OnlyOwner();
		}
		return owner;
	}

	/// @notice Verifies the multisig trying to use the given node ID is valid
	/// @dev Look up multisig index by minipool nodeID
	/// @param nodeID 20-byte Avalanche node ID
	/// @return minipool index or revert
	function onlyValidMultisig(address nodeID) private view returns (int256) {
		int256 minipoolIndex = requireValidMinipool(nodeID);

		address assignedMultisig = getAddress(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".multisigAddr")));
		if (msg.sender != assignedMultisig) {
			revert InvalidMultisigAddress();
		}
		return minipoolIndex;
	}

	/// @notice Look up minipool index by minipool nodeID
	/// @param nodeID 20-byte Avalanche node ID
	/// @return minipool index or revert
	function requireValidMinipool(address nodeID) private view returns (int256) {
		int256 minipoolIndex = getIndexOf(nodeID);
		if (minipoolIndex == -1) {
			revert MinipoolNotFound();
		}

		return minipoolIndex;
	}

	/// @notice Ensure a minipool is allowed to move to the "to" state
	/// @param minipoolIndex A valid minipool index
	/// @param to New status
	function requireValidStateTransition(int256 minipoolIndex, MinipoolStatus to) private view {
		bytes32 statusKey = keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".status"));
		MinipoolStatus currentStatus = MinipoolStatus(getUint(statusKey));
		bool isValid;

		if (currentStatus == MinipoolStatus.Prelaunch) {
			isValid = (to == MinipoolStatus.Launched || to == MinipoolStatus.Canceled);
		} else if (currentStatus == MinipoolStatus.Launched) {
			isValid = (to == MinipoolStatus.Staking || to == MinipoolStatus.Error);
		} else if (currentStatus == MinipoolStatus.Staking) {
			isValid = (to == MinipoolStatus.Withdrawable || to == MinipoolStatus.Error);
		} else if (currentStatus == MinipoolStatus.Withdrawable || currentStatus == MinipoolStatus.Error) {
			isValid = (to == MinipoolStatus.Finished || to == MinipoolStatus.Prelaunch);
		} else if (currentStatus == MinipoolStatus.Finished || currentStatus == MinipoolStatus.Canceled) {
			// Once a node is finished/canceled, if they re-validate they go back to beginning state
			isValid = (to == MinipoolStatus.Prelaunch);
		} else {
			isValid = false;
		}

		if (!isValid) {
			revert InvalidStateTransition();
		}
	}

	constructor(
		Storage storageAddress,
		ERC20 ggp_,
		TokenggAVAX ggAVAX_
	) Base(storageAddress) {
		version = 1;
		ggp = ggp_;
		ggAVAX = ggAVAX_;
	}

	//
	// OWNER FUNCTIONS
	//

	/// @notice Accept AVAX deposit from node operator to create a Minipool. Node Operator must be staking GGP. Open to public.
	/// @param nodeID 20-byte Avalanche node ID
	/// @param duration Requested validation period in seconds
	/// @param delegationFee Percentage delegation fee in units of ether (2% is 0.2 ether)
	/// @param avaxAssignmentRequest Amount of requested AVAX to be matched for this Minipool
	function createMinipool(
		address nodeID,
		uint256 duration,
		uint256 delegationFee,
		uint256 avaxAssignmentRequest
	) external payable whenNotPaused {
		if (nodeID == address(0)) {
			revert InvalidNodeID();
		}

		ProtocolDAO dao = ProtocolDAO(getContractAddress("ProtocolDAO"));
		if (
			// Current rule is matched funds must be 1:1 nodeOp:LiqStaker
			msg.value != avaxAssignmentRequest ||
			avaxAssignmentRequest > dao.getMinipoolMaxAVAXAssignment() ||
			avaxAssignmentRequest < dao.getMinipoolMinAVAXAssignment()
		) {
			revert InvalidAVAXAssignmentRequest();
		}

		if (msg.value + avaxAssignmentRequest < dao.getMinipoolMinAVAXStakingAmt()) {
			revert InsufficientAVAXForMinipoolCreation();
		}

		Staking staking = Staking(getContractAddress("Staking"));
		staking.increaseMinipoolCount(msg.sender);
		staking.increaseAVAXStake(msg.sender, msg.value);
		staking.increaseAVAXAssigned(msg.sender, avaxAssignmentRequest);

		if (staking.getRewardsStartTime(msg.sender) == 0) {
			staking.setRewardsStartTime(msg.sender, block.timestamp);
		}

		uint256 ratio = staking.getCollateralizationRatio(msg.sender);
		if (ratio < dao.getMinCollateralizationRatio()) {
			revert InsufficientGGPCollateralization();
		}

		// Get a Rialto multisig to assign for this minipool
		MultisigManager multisigManager = MultisigManager(getContractAddress("MultisigManager"));
		address multisig = multisigManager.requireNextActiveMultisig();

		// Create or update a minipool record for nodeID
		// If nodeID exists, only allow overwriting if node is finished or canceled
		// 		(completed its validation period and all rewards paid and processing is complete)
		int256 minipoolIndex = getIndexOf(nodeID);
		if (minipoolIndex != -1) {
			requireValidStateTransition(minipoolIndex, MinipoolStatus.Prelaunch);
			resetMinipoolData(minipoolIndex);
			// Also reset initialStartTime as we are starting a whole new validation
			setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".initialStartTime")), 0);
		} else {
			minipoolIndex = int256(getUint(keccak256("minipool.count")));
			// The minipoolIndex is stored 1 greater than actual value. The 1 is subtracted in getIndexOf()
			setUint(keccak256(abi.encodePacked("minipool.index", nodeID)), uint256(minipoolIndex + 1));
			setAddress(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".nodeID")), nodeID);
			addUint(keccak256("minipool.count"), 1);
		}

		// Save the attrs individually in the k/v store
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".status")), uint256(MinipoolStatus.Prelaunch));
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".duration")), duration);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".delegationFee")), delegationFee);
		setAddress(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".owner")), msg.sender);
		setAddress(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".multisigAddr")), multisig);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpInitialAmt")), msg.value);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpAmt")), msg.value);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxLiquidStakerAmt")), avaxAssignmentRequest);

		emit MinipoolStatusChanged(nodeID, MinipoolStatus.Prelaunch);

		Vault vault = Vault(getContractAddress("Vault"));
		vault.depositAVAX{value: msg.value}();
	}

	/// @notice Owner of a minipool can cancel the (prelaunch) minipool
	/// @param nodeID 20-byte Avalanche node ID the Owner registered with
	function cancelMinipool(address nodeID) external nonReentrant {
		Staking staking = Staking(getContractAddress("Staking"));
		ProtocolDAO dao = ProtocolDAO(getContractAddress("ProtocolDAO"));
		int256 index = requireValidMinipool(nodeID);
		onlyOwner(index);
		// make sure they meet the wait period requirement
		if (block.timestamp - staking.getRewardsStartTime(msg.sender) < dao.getMinipoolCancelMoratoriumSeconds()) {
			revert CancellationTooEarly();
		}
		_cancelMinipoolAndReturnFunds(nodeID, index);
	}

	/// @notice Withdraw function for a Node Operator to claim all AVAX funds they are due (original AVAX staked, plus any AVAX rewards)
	/// @param nodeID 20-byte Avalanche node ID the Node Operator registered with
	function withdrawMinipoolFunds(address nodeID) external nonReentrant {
		int256 minipoolIndex = requireValidMinipool(nodeID);
		address owner = onlyOwner(minipoolIndex);
		requireValidStateTransition(minipoolIndex, MinipoolStatus.Finished);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".status")), uint256(MinipoolStatus.Finished));

		uint256 avaxNodeOpAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpAmt")));
		uint256 avaxNodeOpRewardAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpRewardAmt")));
		uint256 totalAvaxAmt = avaxNodeOpAmt + avaxNodeOpRewardAmt;

		Staking staking = Staking(getContractAddress("Staking"));
		staking.decreaseAVAXStake(owner, avaxNodeOpAmt);

		Vault vault = Vault(getContractAddress("Vault"));
		vault.withdrawAVAX(totalAvaxAmt);
		owner.safeTransferETH(totalAvaxAmt);
	}

	//
	// RIALTO FUNCTIONS
	//

	/// @notice Verifies that the minipool related the the given node ID is able to a validator
	/// @dev Rialto calls this to see if a claim would succeed. Does not change state.
	/// @param nodeID 20-byte Avalanche node ID
	/// @return boolean representing if the minipool can become a validator
	function canClaimAndInitiateStaking(address nodeID) external view returns (bool) {
		int256 minipoolIndex = onlyValidMultisig(nodeID);
		requireValidStateTransition(minipoolIndex, MinipoolStatus.Launched);

		uint256 avaxLiquidStakerAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxLiquidStakerAmt")));
		return avaxLiquidStakerAmt <= ggAVAX.amountAvailableForStaking();
	}

	/// @notice Removes the AVAX associated with a minipool from the protocol to stake it on Avalanche and register the node as a validator
	/// @param nodeID 20-byte Avalanche node ID
	/// @dev Rialto calls this to initiate registering a minipool for staking and validation of the P-chain.
	function claimAndInitiateStaking(address nodeID) external {
		int256 minipoolIndex = onlyValidMultisig(nodeID);
		requireValidStateTransition(minipoolIndex, MinipoolStatus.Launched);

		uint256 avaxNodeOpAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpAmt")));
		uint256 avaxLiquidStakerAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxLiquidStakerAmt")));

		// Transfer funds to this contract and then send to multisig
		ggAVAX.withdrawForStaking(avaxLiquidStakerAmt);
		addUint(keccak256("MinipoolManager.TotalAVAXLiquidStakerAmt"), avaxLiquidStakerAmt);

		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".status")), uint256(MinipoolStatus.Launched));
		emit MinipoolStatusChanged(nodeID, MinipoolStatus.Launched);

		Vault vault = Vault(getContractAddress("Vault"));
		vault.withdrawAVAX(avaxNodeOpAmt);

		uint256 totalAvaxAmt = avaxNodeOpAmt + avaxLiquidStakerAmt;
		msg.sender.safeTransferETH(totalAvaxAmt);
	}

	/// @notice Rialto calls this after successfully registering the minipool as a validator for Avalanche
	/// @param nodeID 20-byte Avalanche node ID
	/// @param txID The ID of the transaction that successfully registered the node with Avalanche to become a validater
	/// @param startTime Time the node became a validator
	function recordStakingStart(
		address nodeID,
		bytes32 txID,
		uint256 startTime
	) external {
		int256 minipoolIndex = onlyValidMultisig(nodeID);
		requireValidStateTransition(minipoolIndex, MinipoolStatus.Staking);
		if (startTime > block.timestamp) {
			revert InvalidStartTime();
		}

		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".status")), uint256(MinipoolStatus.Staking));
		setBytes32(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".txID")), txID);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".startTime")), startTime);

		// If this is the first of many cycles, set the initialStartTime
		uint256 initialStartTime = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".initialStartTime")));
		if (initialStartTime == 0) {
			setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".initialStartTime")), startTime);
		}

		address owner = getAddress(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".owner")));
		uint256 avaxLiquidStakerAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxLiquidStakerAmt")));
		Staking staking = Staking(getContractAddress("Staking"));
		if (staking.getAVAXAssignedHighWater(owner) < staking.getAVAXAssigned(owner)) {
			staking.increaseAVAXAssignedHighWater(owner, avaxLiquidStakerAmt);
		}

		emit MinipoolStatusChanged(nodeID, MinipoolStatus.Staking);
	}

	/// @notice Records the nodeID's validation period end
	/// @param nodeID 20-byte Avalanche node ID
	/// @param endTime The time the node ID stopped validating Avalanche
	/// @param avaxTotalRewardAmt The rewards the node recieved from Avalanche for being a validator
	/// @dev Rialto will xfer back all staked avax + avax rewards. Also handles the slashing of node ops GGP bond.
	function recordStakingEnd(
		address nodeID,
		uint256 endTime,
		uint256 avaxTotalRewardAmt
	) external payable {
		int256 minipoolIndex = onlyValidMultisig(nodeID);
		requireValidStateTransition(minipoolIndex, MinipoolStatus.Withdrawable);

		uint256 startTime = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".startTime")));
		if (endTime <= startTime || endTime > block.timestamp) {
			revert InvalidEndTime();
		}

		uint256 avaxNodeOpAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpAmt")));
		uint256 avaxLiquidStakerAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxLiquidStakerAmt")));
		uint256 totalAvaxAmt = avaxNodeOpAmt + avaxLiquidStakerAmt;
		if (msg.value != totalAvaxAmt + avaxTotalRewardAmt) {
			revert InvalidAmount();
		}

		address owner = getAddress(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".owner")));

		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".status")), uint256(MinipoolStatus.Withdrawable));
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".endTime")), endTime);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxTotalRewardAmt")), avaxTotalRewardAmt);

		// Calculate rewards splits (these will all be zero if no rewards were recvd)
		// TODO Revisit this logic if we ever allow unequal matched funds
		uint256 avaxHalfRewards = avaxTotalRewardAmt / 2;

		// Node operators recv an additional commission fee
		ProtocolDAO dao = ProtocolDAO(getContractAddress("ProtocolDAO"));
		uint256 avaxLiquidStakerRewardAmt = avaxHalfRewards - avaxHalfRewards.mulWadDown(dao.getMinipoolNodeCommissionFeePct());
		uint256 avaxNodeOpRewardAmt = avaxTotalRewardAmt - avaxLiquidStakerRewardAmt;

		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpRewardAmt")), avaxNodeOpRewardAmt);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxLiquidStakerRewardAmt")), avaxLiquidStakerRewardAmt);

		// No rewards means validation period failed, must slash node ops GGP.
		if (avaxTotalRewardAmt == 0) {
			slash(minipoolIndex);
		}

		// Send the nodeOps AVAX + rewards to vault so they can claim later
		Vault vault = Vault(getContractAddress("Vault"));
		vault.depositAVAX{value: avaxNodeOpAmt + avaxNodeOpRewardAmt}();
		// Return Liq stakers funds + rewards
		ggAVAX.depositFromStaking{value: avaxLiquidStakerAmt + avaxLiquidStakerRewardAmt}(avaxLiquidStakerAmt, avaxLiquidStakerRewardAmt);
		subUint(keccak256("MinipoolManager.TotalAVAXLiquidStakerAmt"), avaxLiquidStakerAmt);

		Staking staking = Staking(getContractAddress("Staking"));
		staking.decreaseAVAXAssigned(owner, avaxLiquidStakerAmt);
		staking.decreaseMinipoolCount(owner);

		emit MinipoolStatusChanged(nodeID, MinipoolStatus.Withdrawable);
	}

	/// @notice Re-stake a minipool, compounding all rewards recvd
	/// @param nodeID 20-byte Avalanche node ID
	function recreateMinipool(address nodeID) external whenNotPaused {
		int256 minipoolIndex = onlyValidMultisig(nodeID);
		requireValidStateTransition(minipoolIndex, MinipoolStatus.Prelaunch);
		Minipool memory mp = getMinipool(minipoolIndex);
		// Compound the avax plus rewards
		// NOTE Assumes a 1:1 nodeOp:liqStaker funds ratio
		uint256 compoundedAvaxNodeOpAmt = mp.avaxNodeOpAmt + mp.avaxNodeOpRewardAmt;
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpAmt")), compoundedAvaxNodeOpAmt);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxLiquidStakerAmt")), compoundedAvaxNodeOpAmt);

		Staking staking = Staking(getContractAddress("Staking"));
		// Only increase AVAX stake by rewards amount we are compounding
		// since AVAX stake is only decreased by withdrawMinipool()
		staking.increaseAVAXStake(mp.owner, mp.avaxNodeOpRewardAmt);
		staking.increaseAVAXAssigned(mp.owner, compoundedAvaxNodeOpAmt);
		staking.increaseMinipoolCount(mp.owner);

		if (staking.getRewardsStartTime(mp.owner) == 0) {
			// Edge case where calculateAndDistributeRewards has reset their rewards time even though they are still cycling
			// So we re-set it here to their initial start time for this minipool
			staking.setRewardsStartTime(mp.owner, mp.initialStartTime);
		}

		ProtocolDAO dao = ProtocolDAO(getContractAddress("ProtocolDAO"));
		uint256 ratio = staking.getCollateralizationRatio(mp.owner);
		if (ratio < dao.getMinCollateralizationRatio()) {
			revert InsufficientGGPCollateralization();
		}

		resetMinipoolData(minipoolIndex);

		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".status")), uint256(MinipoolStatus.Prelaunch));

		emit MinipoolStatusChanged(nodeID, MinipoolStatus.Prelaunch);
	}

	/// @notice A staking error occured while registering the node as a validator
	/// @param nodeID 20-byte Avalanche node ID
	/// @param errorCode The code that represents the reason for failure
	/// @dev Rialto was unable to start the validation period, so cancel and refund all money
	function recordStakingError(address nodeID, bytes32 errorCode) external payable {
		int256 minipoolIndex = onlyValidMultisig(nodeID);
		requireValidStateTransition(minipoolIndex, MinipoolStatus.Error);

		address owner = getAddress(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".owner")));
		uint256 avaxNodeOpAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpAmt")));
		uint256 avaxLiquidStakerAmt = getUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxLiquidStakerAmt")));

		if (msg.value != (avaxNodeOpAmt + avaxLiquidStakerAmt)) {
			revert InvalidAmount();
		}

		setBytes32(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".errorCode")), errorCode);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".status")), uint256(MinipoolStatus.Error));
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxTotalRewardAmt")), 0);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxNodeOpRewardAmt")), 0);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".avaxLiquidStakerRewardAmt")), 0);

		// Send the nodeOps AVAX to vault so they can claim later
		Vault vault = Vault(getContractAddress("Vault"));
		vault.depositAVAX{value: avaxNodeOpAmt}();

		// Return Liq stakers funds
		ggAVAX.depositFromStaking{value: avaxLiquidStakerAmt}(avaxLiquidStakerAmt, 0);

		Staking staking = Staking(getContractAddress("Staking"));
		staking.decreaseAVAXAssigned(owner, avaxLiquidStakerAmt);

		subUint(keccak256("MinipoolManager.TotalAVAXLiquidStakerAmt"), avaxLiquidStakerAmt);

		emit MinipoolStatusChanged(nodeID, MinipoolStatus.Error);
	}

	/// @notice Multisig can cancel a minipool if a problem was encountered *before* claimAndInitiateStaking() was called
	/// @param nodeID 20-byte Avalanche node ID
	/// @param errorCode The code that represents the reason for failure
	function cancelMinipoolByMultisig(address nodeID, bytes32 errorCode) external {
		int256 minipoolIndex = onlyValidMultisig(nodeID);
		setBytes32(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".errorCode")), errorCode);
		_cancelMinipoolAndReturnFunds(nodeID, minipoolIndex);
	}

	/// @notice Multisig can move a minipool from the error state to the finished state, after a human review of the error
	/// @param nodeID 20-byte Avalanche node ID
	function finishFailedMinipoolByMultisig(address nodeID) external {
		int256 minipoolIndex = onlyValidMultisig(nodeID);
		requireValidStateTransition(minipoolIndex, MinipoolStatus.Finished);
		setUint(keccak256(abi.encodePacked("minipool.item", minipoolIndex, ".status")), uint256(MinipoolStatus.Finished));
		emit MinipoolStatusChanged(nodeID, MinipoolStatus.Finished);
	}

	//
	// VIEW FUNCTIONS
	//

	/// @notice Get the total amount of AVAX from liquid stakers that is being used for minipools
	/// @dev Get the total AVAX *actually* withdrawn from ggAVAX and sent to Rialto
	function getTotalAVAXLiquidStakerAmt() public view returns (uint256) {
		return getUint(keccak256("MinipoolManager.TotalAVAXLiquidStakerAmt"));
	}

	/// @notice Calculates how much GGP should be slashed given an expected avaxRewardAmt
	/// @param avaxRewardAmt The amount of AVAX that should have been awarded to the validator by Avalanche
	function calculateGGPSlashAmt(uint256 avaxRewardAmt) public view returns (uint256) {
		Oracle oracle = Oracle(getContractAddress("Oracle"));
		(uint256 ggpPriceInAvax, ) = oracle.getGGPPriceInAVAX();
		return avaxRewardAmt.divWadDown(ggpPriceInAvax);
	}

	/// @notice Given a duration and an AVAX amt, calculate how much AVAX should be earned via validation rewards
	/// @param duration The length of validation in seconds
	/// @param avaxAmt The amount of AVAX the node staked for their validation period
	/// @return The approximate rewards the node should recieve from Avalanche for beign a validator
	function getExpectedAVAXRewardsAmt(uint256 duration, uint256 avaxAmt) public view returns (uint256) {
		ProtocolDAO dao = ProtocolDAO(getContractAddress("ProtocolDAO"));
		uint256 rate = dao.getExpectedAVAXRewardsRate();
		return (avaxAmt.mulWadDown(rate) * duration) / 365 days;
	}

	/// @notice The index of a minipool. Returns -1 if the minipool is not found
	/// @param nodeID 20-byte Avalanche node ID
	/// @return The index for the given minipool
	function getIndexOf(address nodeID) public view returns (int256) {
		return int256(getUint(keccak256(abi.encodePacked("minipool.index", nodeID)))) - 1;
	}

	/// @notice Gets the minipool information from the node ID
	/// @param nodeID 20-byte Avalanche node ID
	function getMinipoolByNodeID(address nodeID) public view returns (Minipool memory mp) {
		int256 index = getIndexOf(nodeID);
		return getMinipool(index);
	}

	/// @notice Gets the minipool information using the minipool's index
	/// @param index Index of the minipool
	/// @return mp struct containing the minipool's properties
	function getMinipool(int256 index) public view returns (Minipool memory mp) {
		mp.index = index;
		mp.nodeID = getAddress(keccak256(abi.encodePacked("minipool.item", index, ".nodeID")));
		mp.status = getUint(keccak256(abi.encodePacked("minipool.item", index, ".status")));
		mp.duration = getUint(keccak256(abi.encodePacked("minipool.item", index, ".duration")));
		mp.delegationFee = getUint(keccak256(abi.encodePacked("minipool.item", index, ".delegationFee")));
		mp.owner = getAddress(keccak256(abi.encodePacked("minipool.item", index, ".owner")));
		mp.multisigAddr = getAddress(keccak256(abi.encodePacked("minipool.item", index, ".multisigAddr")));
		mp.avaxNodeOpAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxNodeOpAmt")));
		mp.avaxLiquidStakerAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxLiquidStakerAmt")));
		mp.txID = getBytes32(keccak256(abi.encodePacked("minipool.item", index, ".txID")));
		mp.initialStartTime = getUint(keccak256(abi.encodePacked("minipool.item", index, ".initialStartTime")));
		mp.startTime = getUint(keccak256(abi.encodePacked("minipool.item", index, ".startTime")));
		mp.endTime = getUint(keccak256(abi.encodePacked("minipool.item", index, ".endTime")));
		mp.avaxTotalRewardAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxTotalRewardAmt")));
		mp.errorCode = getBytes32(keccak256(abi.encodePacked("minipool.item", index, ".errorCode")));
		mp.avaxNodeOpInitialAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxNodeOpInitialAmt")));
		mp.avaxNodeOpRewardAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxNodeOpRewardAmt")));
		mp.avaxLiquidStakerRewardAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxLiquidStakerRewardAmt")));
		mp.ggpSlashAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".ggpSlashAmt")));
	}

	/// @notice Get minipools in a certain status (limit=0 means no pagination)
	/// @param status The MinipoolStatus to be used as a filter
	/// @param offset The number the result should be offset by
	/// @param limit The limit to the amount of minipools that should be returned
	/// @return minipools in the protocol that adhear to the paramaters
	function getMinipools(
		MinipoolStatus status,
		uint256 offset,
		uint256 limit
	) public view returns (Minipool[] memory minipools) {
		uint256 totalMinipools = getUint(keccak256("minipool.count"));
		uint256 max = offset + limit;
		if (max > totalMinipools || limit == 0) {
			max = totalMinipools;
		}
		minipools = new Minipool[](max - offset);
		uint256 total = 0;
		for (uint256 i = offset; i < max; i++) {
			Minipool memory mp = getMinipool(int256(i));
			if (mp.status == uint256(status)) {
				minipools[total] = mp;
				total++;
			}
		}
		// Dirty hack to cut unused elements off end of return value (from RP)
		// solhint-disable-next-line no-inline-assembly
		assembly {
			mstore(minipools, total)
		}
	}

	/// @notice The total count of minipools in the protocol
	function getMinipoolCount() public view returns (uint256) {
		return getUint(keccak256("minipool.count"));
	}

	//
	// PRIVATE FUNCTIONS
	//

	/// @notice Cancels the minipool and returns the funds related to it
	/// @dev At this point we dont have any liq staker funds withdrawn from ggAVAX so no need to return them
	/// @param nodeID 20-byte Avalanche node ID
	/// @param index Index of the minipool
	function _cancelMinipoolAndReturnFunds(address nodeID, int256 index) private {
		requireValidStateTransition(index, MinipoolStatus.Canceled);
		setUint(keccak256(abi.encodePacked("minipool.item", index, ".status")), uint256(MinipoolStatus.Canceled));

		address owner = getAddress(keccak256(abi.encodePacked("minipool.item", index, ".owner")));
		uint256 avaxNodeOpAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxNodeOpAmt")));
		uint256 avaxLiquidStakerAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxLiquidStakerAmt")));

		Staking staking = Staking(getContractAddress("Staking"));
		staking.decreaseAVAXStake(owner, avaxNodeOpAmt);
		staking.decreaseAVAXAssigned(owner, avaxLiquidStakerAmt);

		staking.decreaseMinipoolCount(owner);

		emit MinipoolStatusChanged(nodeID, MinipoolStatus.Canceled);

		Vault vault = Vault(getContractAddress("Vault"));
		vault.withdrawAVAX(avaxNodeOpAmt);
		owner.safeTransferETH(avaxNodeOpAmt);
	}

	/// @notice Slashes the GPP of the minipool with the given index
	/// @dev Extracted this because of "stack too deep" errors.
	/// @param index Index of the minipool
	function slash(int256 index) private {
		address nodeID = getAddress(keccak256(abi.encodePacked("minipool.item", index, ".nodeID")));
		address owner = getAddress(keccak256(abi.encodePacked("minipool.item", index, ".owner")));
		uint256 duration = getUint(keccak256(abi.encodePacked("minipool.item", index, ".duration")));
		uint256 avaxLiquidStakerAmt = getUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxLiquidStakerAmt")));
		uint256 expectedAVAXRewardsAmt = getExpectedAVAXRewardsAmt(duration, avaxLiquidStakerAmt);
		uint256 slashGGPAmt = calculateGGPSlashAmt(expectedAVAXRewardsAmt);
		setUint(keccak256(abi.encodePacked("minipool.item", index, ".ggpSlashAmt")), slashGGPAmt);

		emit GGPSlashed(nodeID, slashGGPAmt);

		Staking staking = Staking(getContractAddress("Staking"));
		staking.slashGGP(owner, slashGGPAmt);
	}

	/// @notice Reset all the data for a given minipool (for a previous validation cycle, so do not reset initial amounts)
	/// @param index Index of the minipool
	function resetMinipoolData(int256 index) private {
		setBytes32(keccak256(abi.encodePacked("minipool.item", index, ".txID")), 0);
		setUint(keccak256(abi.encodePacked("minipool.item", index, ".startTime")), 0);
		setUint(keccak256(abi.encodePacked("minipool.item", index, ".endTime")), 0);
		setUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxTotalRewardAmt")), 0);
		setUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxNodeOpRewardAmt")), 0);
		setUint(keccak256(abi.encodePacked("minipool.item", index, ".avaxLiquidStakerRewardAmt")), 0);
		setUint(keccak256(abi.encodePacked("minipool.item", index, ".ggpSlashAmt")), 0);
		setBytes32(keccak256(abi.encodePacked("minipool.item", index, ".errorCode")), 0);
	}
}