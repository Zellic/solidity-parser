contract helper {
    function getBalance() public payable returns (uint256 myBalance) {
        return address(this).balance;
    }
}


contract test {
    helper h;

    constructor() payable {
        h = new helper();
    }

    function sendAmount(uint256 amount) public returns (uint256 bal) {
        return h.getBalance{value: amount + 3, gas: 1000}();
    }
}
// ----
// constructor(), 20 wei ->
// gas irOptimized: 173271
// gas legacy: 253820
// gas legacyOptimized: 180784
// sendAmount(uint256): 5 -> 8
