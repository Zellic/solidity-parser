contract C {
    function f(uint x) external payable returns (uint) { return 1; }
    function f(uint x, uint y) external payable returns (uint) { return 2; }
    function call() public payable returns (uint v, uint x, uint y, uint z) {
        v = this.f{value: 10}(2);
        x = this.f{gas: 10000}(2, 3);
        y = this.f{gas: 10000, value: 10}(2, 3);
        z = this.f{value: 10, gas: 10000}(2, 3);
    }
    function bal() external returns (uint) { return address(this).balance; }
    receive() external payable {}
}
// ----
// (), 1 ether
// call() -> 1, 2, 2, 2
// bal() -> 1000000000000000000
