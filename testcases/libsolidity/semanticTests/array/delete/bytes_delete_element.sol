contract c {
    bytes data;

    function test1() external returns (bool) {
        data = new bytes(100);
        for (uint256 i = 0; i < data.length; i++) data[i] = bytes1(uint8(i));
        delete data[94];
        delete data[96];
        delete data[98];
        return
            data[94] == 0 &&
            uint8(data[95]) == 95 &&
            data[96] == 0 &&
            uint8(data[97]) == 97;
    }
}
// ----
// test1() -> true
// gas irOptimized: 204782
// gas legacy: 242256
// gas legacyOptimized: 241192
