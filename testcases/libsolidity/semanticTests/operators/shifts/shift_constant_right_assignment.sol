contract C {
    function f() public returns (uint256 a) {
        a = 0x4200;
        a >>= 8;
    }
}
// ----
// f() -> 0x42
