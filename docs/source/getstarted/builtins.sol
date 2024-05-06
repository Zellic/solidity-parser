pragma solidity 0.8.22;

function selfdestruct(address addr) public {

}

function revert(/*error, reason*/) {
    // A direct revert can be triggered using the
    // revert statement and the revert function.
}

function assert(bool condition) {

}

function require(bool condition /*reason*/) {
    // The convenience functions can be used to check for conditions
    // and throw an exception if the condition is not met.
}

struct msg {
    uint256 value;
    uint256 gas;
    address sender;
    bytes data;
    bytes4 sig;
}

struct block {
    uint256 basefee;
    uint256 chainid;
    address payable conbase;
    uint256 difficulty;
    uint256 gaslimit;
    uint256 number;
    uint256 timestamp;
}

struct tx {
    uint256 gasprice;
    address origin;
}

contract _address {
    // balance of the Address in Wei
    uint256 balance;
    // code at the Address (can be empty)
    bytes code;
    // the codehash of the Address
    bytes32 codehash;

    function call(bytes memory payload) public returns (bool, bytes memory) {
        // issue low-level CALL with the given payload, returns
        // success condition and return data, forwards all available gas, adjustable
    }

    function delegatecall(bytes memory payload) public returns (bool, bytes memory) {
        // issue low-level DELEGATECALL with the given payload, returns
        // success condition and return data, forwards all available gas, adjustable
    }

    function staticcall(bytes memory payload) public returns (bool, bytes memory) {
        // issue low-level STATICCALL with the given payload, returns
        // success condition and return data, forwards all available gas, adjustable
    }
}

contract _address_payable is _address {
    function transfer(uint256 amount) public {
        // send given amount of Wei to Address, reverts on failure,
        // forwards 2300 gas stipend, not adjustable
    }

    function send(uint256 amount) public returns (bool) {
        // send given amount of Wei to Address, returns false on
        // failure, forwards 2300 gas stipend, not adjustable
    }
}

library abi {
    function encode(/*varargs*/) public returns (bytes memory) {
        // ABI encodes the arguments to bytes. Any number of arguments can be provided.
    }

    function encodePacked(/*varargs*/) public returns (bytes memory) {
        // ABI encodes the arguments to bytes. Any number of arguments can be
        // provided. The packed encoding only encodes the raw data, not the
        // lengths of strings and arrays. For example, when encoding string only
        // the string bytes will be encoded, not the length. It is not possible
        // to decode packed encoding.
    }

    function encodeWithSelector(bytes4 selector /*, varargs*/) public returns (bytes memory) {
        // ABI encodes the arguments with the function selector, which is known as the discriminator
        // on Solana. After the selector, any number of arguments can be provided.
    }

    function encodeWithSignature(string memory signature /*, varargs*/) public returns (bytes memory) {
        // ABI encodes the arguments with the hash of the signature. After the signature,
        // any number of arguments can be provided.
    }

    function encodeCall(/*function pointer, tuple of arguments*/) public returns (bytes memory) {
        // ABI encodes the function call to the function which should be specified
        // as ContractName.FunctionName. The arguments are cast and checked against
        // the function specified as the first argument. The arguments must be in a
        // tuple, e.g. (a, b, c). If there is a single argument no tuple is required.
    }

    function decode(bytes memory encodedData /*(types)*/) public /*returns (args)*/ {
        // This function decodes the first argument and returns the decoded fields.
        // type-list is a comma-separated list of types. If multiple values are
        // decoded, then a destructure statement must be used.
    }
}