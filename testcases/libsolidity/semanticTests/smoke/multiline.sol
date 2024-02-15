contract C {
    function f(uint a, uint b, uint c, uint d, uint e) public returns (uint) {
        return a + b + c + d + e;
    }
}
// ====
// allowNonExistingFunctions: true
// ----
// f(uint256,uint256,uint256,uint256,uint256): 1, 1, 1, 1, 1
// -> 5
// g()
// # g() does not exist #
// -> FAILURE
