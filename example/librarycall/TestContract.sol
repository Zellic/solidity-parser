// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "AdderLib.sol";

contract MyContract {
    Adder private adder;
    uint256 public myVariable;

    function addToVariable(uint256 value) public {
        myVariable = adder.add(myVariable, value);
    }

    function notALibraryCall() public {
        addToVariable(50);
    }
}
