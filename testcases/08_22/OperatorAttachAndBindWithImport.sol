// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.22;

import {Int} from "./OperatorAttachAndBind.sol";

function test_valid(Int x, Int y) pure returns (Int) {
    return x + y;
}