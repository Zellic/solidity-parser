// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.22;

library MyAddLib {
    function add(uint x, uint y) public returns (uint) {
        return x + y;
    }
}

library MySubLib {
    function sub(uint x, uint y) public returns (uint) {
        return x - y;
    }
}
contract UsingDirectiveNormal {
    using MyAddLib for uint;
    using MySubLib for uint;

    function testAdd() public returns (uint) {
        uint myX = 5;
        uint myY = 6;
        uint myZ = myX.add(myY);
        return myZ;
    }

    function testSub() public returns (uint) {
        uint myX = 3;
        uint myY = 2;
        uint myZ = myX.sub(myY);
        return myZ;
    }
}
