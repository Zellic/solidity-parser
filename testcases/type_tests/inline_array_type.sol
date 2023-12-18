// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract inline_array_type {
    function ok1() {
        uint8[5] x = [0,0,0,0,0];
    }

    function ok2() {
        int[5] x = [1,0,0,0,0];
    }

    function ok3() {
        int[5] x = [int(1), int(-1), int(0), int(0), int(0)];
    }

    function ok4() {
        int8[5] foo4 = [int8(0), int8(0), int8(0), int8(0), int8(0)];
    }

    function notOk1() {
        int[5] x = [1,-1,0,0,0];
    }

    function notOk2() {
        int8[5] x = [0,0,0,0,0];
    }

}
