contract A {
    function f() external {}
    function g(uint256) external {}
}
contract B {
    function f() external returns (uint256) {}
    function g(uint256) external returns (uint256) {}
}
contract C {
    function test1() external returns(bytes4, bytes4, bytes4, bytes4) {
        return (A.f.selector, A.g.selector, B.f.selector, B.g.selector);
    }
    function test2() external returns(bytes4, bytes4, bytes4, bytes4) {
        A a; B b;
        return (a.f.selector, a.g.selector, b.f.selector, b.g.selector);
    }
}
// ----
// test1() -> left(0x26121ff0), left(0xe420264a), left(0x26121ff0), left(0xe420264a)
// test2() -> left(0x26121ff0), left(0xe420264a), left(0x26121ff0), left(0xe420264a)
