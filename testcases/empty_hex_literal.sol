// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.8.2 <0.9.0;

contract Test {
    function implicit() public pure returns (bytes memory) {
        bytes xs = bytes(hex"");
        return xs;
    }
}