contract test {
    function f() public pure returns (bytes32) {
        bytes32 escapeCharacters = "\t\n\r\'\"\\";
        return escapeCharacters;
    }
}
// ----
// f() -> 0x090a0d27225c0000000000000000000000000000000000000000000000000000
