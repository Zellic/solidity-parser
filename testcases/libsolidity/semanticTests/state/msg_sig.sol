contract C {
    function f() public returns (bytes4) {
        return msg.sig;
    }
    function g() public returns (bytes4) {
        return msg.sig;
    }
}
// ----
// f() -> 0x26121ff000000000000000000000000000000000000000000000000000000000
// g() -> 0xe2179b8e00000000000000000000000000000000000000000000000000000000
