pragma solidity ^0.8.24;

library ResultCalc {
    struct Result {
        uint256 r;
    }

    function get(mapping(bytes32 => Result) storage s, address x, uint24 y, bytes32 z)
        internal
        view
        returns (ResultCalc.Result storage res)
    {
        res = s[z];
    }

    function add(Result storage s, uint256 x) internal {
        s.r += x;
    }

    function sub(Result storage s, uint256 x) internal {
        s.r -= x;
    }
}
