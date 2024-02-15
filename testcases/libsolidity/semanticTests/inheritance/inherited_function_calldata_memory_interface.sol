interface I {
    function f(uint256[] calldata a) external returns (uint256);
}


contract A is I {
    function f(uint256[] memory a) public override returns (uint256) {
        return 42;
    }
}


contract B {
    function f(uint256[] memory a) public returns (uint256) {
        return a[1];
    }

    function g() public returns (uint256) {
        I i = I(new A());
        return i.f(new uint256[](2));
    }
}
// ----
// g() -> 42
// gas irOptimized: 100282
// gas legacy: 180440
// gas legacyOptimized: 112596
