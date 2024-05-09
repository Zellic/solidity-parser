contract helper {
    bool flag;

    function getBalance() public payable returns (uint256 myBalance) {
        return address(this).balance;
    }

    function setFlag() public {
        flag = true;
    }

    function getFlag() public returns (bool fl) {
        return flag;
    }
}


contract test {
    helper h;

    constructor() payable {
        h = new helper();
    }

    function sendAmount(uint256 amount) public payable returns (uint256 bal) {
        return h.getBalance{value: amount}();
    }

    function outOfGas() public returns (bool ret) {
        h.setFlag{gas: 2}(); // should fail due to OOG
        return true;
    }

    function checkState() public returns (bool flagAfter, uint256 myBal) {
        flagAfter = h.getFlag();
        myBal = address(this).balance;
    }
}
// ----
// constructor(), 20 wei ->
// gas irOptimized: 252642
// gas legacy: 391588
// gas legacyOptimized: 268089
// sendAmount(uint256): 5 -> 5
// outOfGas() -> FAILURE # call to helper should not succeed but amount should be transferred anyway #
// checkState() -> false, 15
