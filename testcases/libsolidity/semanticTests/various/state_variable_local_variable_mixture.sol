contract A {
    uint256 x = 1;
    uint256 y = 2;

    function a() public returns (uint256 x) {
        x = A.y;
    }
}
// ----
// a() -> 2
