pragma solidity ^0.8.22;

type Int is int;
using {add as +} for Int global;
using {sub as -, sub} for Int global;

function add(Int a, Int b) pure returns (Int) {
    return Int.wrap(Int.unwrap(a) + Int.unwrap(b));
}

function sub(Int a, Int b) pure returns (Int) {
    return Int.wrap(Int.unwrap(a) - Int.unwrap(b));
}

function test(Int x, Int y) pure {
    x + y; // ok

    x - y;
    x.sub(y); // OK -- "sub" was also attached in "using for"
}

function test_invalid(Int x, Int y) pure {
    x.add(y); // ERROR: Member "add" not found or not visible after argument-dependent lookup in Int.
}