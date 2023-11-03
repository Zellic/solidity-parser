// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.22;

type Int is int;

function myNeg(Int a) pure returns (Int) {
    return Int.wrap(-Int.unwrap(a));
}

using {myNeg as -} for Int global;

function test_neg(Int x) pure {
    Int z = -x;
}