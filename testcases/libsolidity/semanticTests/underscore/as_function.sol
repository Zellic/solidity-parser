contract C {
    function _() public pure returns (uint) {
        return 88;
    }

    function g() public pure returns (uint){
        return _();
    }

    function h() public pure returns (uint) {
        _;
        return 33;
    }
}
// ----
// _() -> 88
// g() -> 88
// h() -> 33
