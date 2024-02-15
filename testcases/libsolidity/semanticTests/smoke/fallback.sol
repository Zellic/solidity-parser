contract A {
    uint public data;
    uint public balance;
    bytes public externalData;
    fallback() external payable {
        data += 1;
        balance = msg.value;
        externalData = msg.data;
    }
}
// ----
// data() -> 0
// ()
// data() -> 1
// (): hex"42ef"
// data() -> 2
// externalData() -> 0x20, 2, left(0x42ef)
// balance() -> 0
// (), 1 wei
// balance() -> 1
// (), 2 wei: hex"fefe"
// balance() -> 2
// externalData() -> 0x20, 2, left(0xfefe)
