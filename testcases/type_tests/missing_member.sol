// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract missing_member {
    constructor(){
        this.unknownField = 5;
    }
}
