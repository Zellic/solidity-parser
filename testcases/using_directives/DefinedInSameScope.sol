// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

library MyLib {
    using MyLib for MyStruct;

    struct MyStruct {
        uint x;
    }

    function add(MyStruct memory s, uint y) internal returns (uint) {
        return s.x + y;
    }

    function testIt(MyStruct memory s, MyStruct memory s2) public returns (uint) {
        return s.add(s2.x);
    }
}