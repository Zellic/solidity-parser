pragma abicoder               v2;

struct S {
    uint x;
    uint y;
}

contract C {
    function f(S calldata s) internal pure returns (uint, uint) {
        return (s.x, s.y);
    }
    function f(uint, S calldata s, uint) external pure returns (uint, uint) {
        return f(s);
    }
}
// ----
// f(uint256,(uint256,uint256),uint256): 7, 1, 2, 4 -> 1, 2
