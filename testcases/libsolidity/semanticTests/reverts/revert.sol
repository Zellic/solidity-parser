contract C {
    uint256 public a = 42;

    function f() public {
        a = 1;
        revert();
    }

    function g() public {
        a = 1;
        assembly {
            revert(0, 0)
        }
    }
}
// ----
// f() -> FAILURE
// a() -> 42
// g() -> FAILURE
// a() -> 42
