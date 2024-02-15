contract Base {
    function f() public returns (uint256 i) {
        return g();
    }

    function g() public virtual returns (uint256 i) {
        return 1;
    }
}


contract Derived is Base {
    function g() public override returns (uint256 i) {
        return 2;
    }
}
// ----
// g() -> 2
// f() -> 2
