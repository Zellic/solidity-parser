library L {
	function f() internal returns (uint) {
		return 3;
	}
}

contract C {
	function foo() public returns (uint) {
		return (L.f)();
	}
}
// ----
// foo() -> 3
