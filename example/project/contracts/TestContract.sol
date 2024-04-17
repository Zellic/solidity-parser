// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "@openzeppelin/access/Ownable.sol";

contract MyContract is Ownable {
    uint256 public myVariable;

    // Function to set the value of myVariable
    function setMyVariable(uint256 newValue) public onlyOwner {
        myVariable = newValue;
    }

    function getMyVariable() public view returns (uint256) {
        return myVariable;
    }

    function addToVariable(uint256 value) public onlyOwner {
        myVariable += value;
    }
}
