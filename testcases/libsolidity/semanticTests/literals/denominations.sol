contract C {
	uint constant x = 1 ether + 1 gwei + 1 wei;

	function f() public view returns(uint) { return x; }
}
// ----
// f() -> 1000000001000000001
