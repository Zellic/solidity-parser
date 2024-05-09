contract C {
	function preincr_u8(uint8 a) public pure returns (uint8) {
		return ++a + a;
	}
	function postincr_u8(uint8 a) public pure returns (uint8) {
		return a++ + a;
	}
	function predecr_u8(uint8 a) public pure returns (uint8) {
		return --a + a;
	}
	function postdecr_u8(uint8 a) public pure returns (uint8) {
		return a-- + a;
	}
	function preincr_s8(int8 a) public pure returns (int8 ret1, int8 ret2) {
		ret1 = ++a;
		ret2 = a;
	}
	function postincr_s8(int8 a) public pure returns (int8 ret1, int8 ret2) {
		ret1 = a++;
		ret2 = a;
	}
	function predecr_s8(int8 a) public pure returns (int8 ret1, int8 ret2) {
		ret1 = --a;
		ret2 = a;
	}
	function postdecr_s8(int8 a) public pure returns (int8 ret1, int8 ret2) {
		ret1 = a--;
		ret2 = a;
	}
	function preincr(uint a) public pure returns (uint) {
		return ++a + a;
	}
	function postincr(uint a) public pure returns (uint) {
		return a++ + a;
	}
	function predecr(uint a) public pure returns (uint) {
		return --a + a;
	}
	function postdecr(uint a) public pure returns (uint) {
		return a-- + a;
	}
	function not(bool a) public pure returns (bool)
	{
		return !a;
	}
	function bitnot(int256 a) public pure returns (int256)
	{
		return ~a;
	}
	function bitnot_u8(uint8 a) public pure returns (uint256 ret)
	{
		a = ~a;
		assembly {
			// Tests that the lower bit parts are cleaned up
			ret := a
		}
	}
	function bitnot_s8() public pure returns (int256 ret)
	{
		int8 a;
		assembly {
			a := 0x9C
		}

		a = ~a;

		assembly {
			// Tests that the lower bit parts are cleaned up
			ret := a
		}
	}
	function negate(int256 a) public pure returns (int256)
	{
		return -a;
	}
	function negate_s8(int8 a) public pure returns (int8)
	{
		return -a;
	}
	function negate_s16(int16 a) public pure returns (int16)
	{
		return -a;
	}
}
// ====
// compileViaYul: true
// ----
// preincr_s8(int8): 128 -> FAILURE
// postincr_s8(int8): 128 -> FAILURE
// preincr_s8(int8): 127 -> FAILURE, hex"4e487b71", 0x11
// postincr_s8(int8): 127 -> FAILURE, hex"4e487b71", 0x11
// preincr_s8(int8): 126 -> 127, 127
// postincr_s8(int8): 126 -> 126, 127
// predecr_s8(int8): -128 -> FAILURE, hex"4e487b71", 0x11
// postdecr_s8(int8): -128 -> FAILURE, hex"4e487b71", 0x11
// predecr_s8(int8): -127 -> -128, -128
// postdecr_s8(int8): -127 -> -127, -128
// preincr_s8(int8): -5 -> -4, -4
// postincr_s8(int8): -5 -> -5, -4
// predecr_s8(int8): -5 -> -6, -6
// postdecr_s8(int8): -5 -> -5, -6
// preincr_u8(uint8): 255 -> FAILURE, hex"4e487b71", 0x11
// postincr_u8(uint8): 255 -> FAILURE, hex"4e487b71", 0x11
// preincr_u8(uint8): 254 -> FAILURE, hex"4e487b71", 0x11
// postincr_u8(uint8): 254 -> FAILURE, hex"4e487b71", 0x11
// predecr_u8(uint8): 0 -> FAILURE, hex"4e487b71", 0x11
// postdecr_u8(uint8): 0 -> FAILURE, hex"4e487b71", 0x11
// predecr_u8(uint8): 1 -> 0
// postdecr_u8(uint8): 1 -> 1
// preincr_u8(uint8): 2 -> 6
// postincr_u8(uint8): 2 -> 5
// predecr_u8(uint8): 2 -> 2
// postdecr_u8(uint8): 2 -> 3
// preincr(uint256): 2 -> 6
// postincr(uint256): 2 -> 5
// predecr(uint256): 2 -> 2
// postdecr(uint256): 2 -> 3
// not(bool): true -> false
// not(bool): false -> true
// bitnot(int256): 5 -> -6
// bitnot(int256): 10 -> -11
// bitnot(int256): 0 -> -1
// bitnot(int256): -100 -> 99
// bitnot_u8(uint8): 100 -> 155
// bitnot_s8() -> 99
// negate(int256): -57896044618658097711785492504343953926634992332820282019728792003956564819968 -> FAILURE, hex"4e487b71", 0x11
// negate(int256): -57896044618658097711785492504343953926634992332820282019728792003956564819967 -> 57896044618658097711785492504343953926634992332820282019728792003956564819967
// negate(int256): 0 -> 0
// negate(int256): 1 -> -1
// negate(int256): -1 -> 1
// negate_s8(int8): -128 -> FAILURE, hex"4e487b71", 0x11
// negate_s8(int8): -138 -> FAILURE
// negate_s8(int8): -127 -> 127
// negate_s8(int8): 127 -> -127
// negate_s16(int16): -32768 -> FAILURE, hex"4e487b71", 0x11
// negate_s16(int16): -32767 -> 32767
