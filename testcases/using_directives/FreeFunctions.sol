pragma solidity ^0.8.22;

function mask(uint v, uint bits) returns (uint) {
    return v & ((1 << bits) - 1);
}

function odd(uint v) returns (bool) {
    return (v & 1) != 0;
}

contract c {
//    using {mask, odd} for *;
    using {mask, odd} for uint;

    uint v;

    function set_v(uint n) public {
        v = n.mask(16);
    }
}