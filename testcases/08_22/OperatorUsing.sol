pragma solidity ^0.8.22;
//pragma solidity ^0.8.19;

type Int is int;
// An operator can only be bound in a global directive and its definition must be a pure free function. The type
// specified in using for must be a user-defined value type and must be the type of all the parameters of the function
// and its return value. The only exception are comparison operator definitions, where the return type must be bool.
using {add as +} for Int global;

function add(Int a, Int b) pure returns (Int) {
    return Int.wrap(Int.unwrap(a) + Int.unwrap(b));
}

function test(Int a, Int b) pure returns (Int) {
    return a + b; // Equivalent to add(a, b)
}