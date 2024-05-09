// Tests that rational numbers (even negative ones) are encoded properly.
pragma abicoder               v2;


contract C {
    function f() public pure returns (bytes memory) {
        return abi.encode(1, -2);
    }
}
// ----
// f() -> 0x20, 0x40, 0x1, -2
