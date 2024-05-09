contract C {
    address[] addressArray;
    function set_get_length(uint256 len) public returns (uint256)
    {
        while(addressArray.length < len)
            addressArray.push();
        while(addressArray.length > len)
            addressArray.pop();
        return addressArray.length;
    }
}
// ====
// EVMVersion: >=petersburg
// ----
// set_get_length(uint256): 0 -> 0
// set_get_length(uint256): 1 -> 1
// set_get_length(uint256): 10 -> 10
// set_get_length(uint256): 20 -> 20
// set_get_length(uint256): 0 -> 0
// gas irOptimized: 77628
// gas legacy: 77730
// gas legacyOptimized: 77162
// set_get_length(uint256): 0xFF -> 0xFF
// gas irOptimized: 158881
// gas legacy: 696850
// gas legacyOptimized: 134488
// set_get_length(uint256): 0xFFF -> 0xFFF
// gas irOptimized: 1762213
// gas legacy: 9857362
// gas legacyOptimized: 1393660
// set_get_length(uint256): 0xFFFFF -> FAILURE # Out-of-gas #
// gas irOptimized: 100000000
// gas legacyOptimized: 100000000
