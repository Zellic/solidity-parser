contract c {
    uint64[] data1;
    uint256[] data2;

    function test() public returns (uint256 x, uint256 y) {
        data2.push(11);
        data1.push(0);
        data1.push(1);
        data1.push(2);
        data1.push(3);
        data1.push(4);
        data2 = data1;
        assert(data1[0] == data2[0]);
        x = data2.length;
        y = data2[4];
    }
}
// ----
// test() -> 5, 4
// gas irOptimized: 205044
// gas legacy: 213863
// gas legacyOptimized: 212902
