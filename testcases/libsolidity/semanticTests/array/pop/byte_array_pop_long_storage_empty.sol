contract c {
    uint256 a;
    uint256 b;
    uint256 c;
    bytes data;
    function test() public returns (bool) {
        for (uint8 i = 0; i <= 40; i++)
            data.push(bytes1(i+1));
        for (int8 j = 40; j >= 0; j--) {
            require(data[uint8(j)] == bytes1(uint8(j+1)));
            require(data.length == uint8(j+1));
            data.pop();
        }
        return true;
    }
}
// ----
// test() -> true
// gas irOptimized: 140154
// gas legacy: 178397
// gas legacyOptimized: 163832
// storageEmpty -> 1
