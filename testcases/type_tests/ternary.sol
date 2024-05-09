// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;


contract BaseContract {}

contract AContract is BaseContract {
}
contract BContract is BaseContract {
}

contract ternary {
    function with_equal_ints(bool za) public returns (uint256) {
        uint256 x1 = 10;
        uint256 y1 = 15;
        return za ? x1 : y1;
    }

    function with_larger_int(bool zb) public returns (uint256, uint256) {
        uint256 x2 = 5;
        uint8 y2 = 2;

        uint256 a = zb ? x2 : y2;
        uint256 b = zb ? y2 : x2;

        return (a,b);
    }

    function same_types(bool z1, BaseContract a1, BaseContract b1) public returns (BaseContract) {
        return z1 ? a1 : b1;
    }

//    function a_first(bool z2, AContract a2, BContract b2) public returns (BaseContract) {
//        return z2 ? a2 : b2;
//    }
//
//    function b_first(bool z3, AContract a3, BContract b3) public returns (BaseContract) {
//        return z3 ? b3 : a3;
//    }
}
