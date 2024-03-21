pragma solidity ^0.8.0;

interface MyI {
    error MyE();
}

contract B {
    function x() public returns (bytes4) {
        return MyI.MyE.selector;
    }
}