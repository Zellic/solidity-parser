contract C {
    function add(uint, uint) public pure returns (uint) { return 7; }
    function g() public pure returns (uint x, uint y) {
        x = add(1, 2);
        assembly {
            y := add(1, 2)
        }
    }
}
// ----
// g() -> 7, 3
