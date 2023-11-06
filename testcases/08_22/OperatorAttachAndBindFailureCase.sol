// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.22;

import {Int} from "./OperatorAttachAndBind.sol";

function test_invalid(Int x, Int y) pure {
    x.add(y); // ERROR: Member "add" not found or not visible after argument-dependent lookup in Int.
}