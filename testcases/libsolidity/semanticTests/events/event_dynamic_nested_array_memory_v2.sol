pragma abicoder v2;
contract C {
    event E(uint[][]);
    function createEvent(uint x) public {
        uint[][] memory arr = new uint[][](2);
        arr[0] = new uint[](2);
        arr[1] = new uint[](2);
        arr[0][0] = x;
        arr[0][1] = x + 1;
        arr[1][0] = x + 2;
        arr[1][1] = x + 3;
        emit E(arr);
    }
}
// ----
// createEvent(uint256): 42 ->
// ~ emit E(uint256[][]): 0x20, 0x02, 0x40, 0xa0, 0x02, 0x2a, 0x2b, 0x02, 0x2c, 0x2d
