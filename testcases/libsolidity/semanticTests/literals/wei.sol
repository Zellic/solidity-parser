contract C {
	uint constant x = 1 wei;

	function f() public view returns(uint) { return x; }
}
// ----
// f() -> 1
