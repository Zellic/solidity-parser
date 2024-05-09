// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract ContractA {

    struct MyStruct{
        int x;
    }
}

library MyLib {
    function foo(ContractA.MyStruct memory s, int x) public pure returns (int) {
        return s.x + x;
    }
}

contract ContractB is ContractA {
    using MyLib for MyStruct;

    function testIt(MyStruct memory s, int y) public pure returns (int) {
        return s.foo(y);
    }
}