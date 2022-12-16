pragma solidity ^0.8.0;

interface IBEP20 {
    function approve(address spender, uint256 amount) external returns (bool);
    function transferFrom(address sender, address recipient, uint256 amount) external returns (bool);
}

contract Airdropper {
  mapping (bytes32 => bool) used;
  event Sent(address indexed token, address indexed sender, address indexed recipient, uint256 tokensToTransfer, uint256 nonce);

  function validateAndRegisterClaim(address sender, bytes32 h, uint8 v, bytes32 r, bytes32 s) private {
    bytes memory prefix = "\x19Ethereum Signed Message:\n32";
    address signer = ecrecover(keccak256(abi.encodePacked(prefix, h)), v, r, s);
    require(signer == sender && signer != address(0), "invalid claim");

    require(!used[h], "re-use detected");
    used[h] = true;
  }

  function claimTokensBEP20(address token, address sender, address recipient, uint256 tokensToTransfer, uint256 nonce, uint8 v, bytes32 r, bytes32 s) public {
    bytes32 h = keccak256(abi.encodePacked(token, sender, recipient, tokensToTransfer, nonce));
    validateAndRegisterClaim(sender, h, v, r, s);
    IBEP20(token).transferFrom(sender, recipient, tokensToTransfer);
    emit Sent(token, sender, recipient, tokensToTransfer, nonce);
  }
}