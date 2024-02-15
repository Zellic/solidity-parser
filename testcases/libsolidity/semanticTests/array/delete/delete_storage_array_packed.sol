contract C {
    uint120[] data;

    function f() public returns (uint120, uint120, uint120) {
        data.push(123);
        data.push(234);
        data.push(345);
        delete data;
        assembly {
            sstore(data.slot, 3)
        }
        return (data[0], data[1], data[2]);
    }
}
// ----
// f() -> 0, 0, 0
// gas irOptimized: 90992
// gas legacy: 111037
// gas legacyOptimized: 109633
