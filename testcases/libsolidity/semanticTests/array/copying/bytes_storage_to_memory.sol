contract C {
  bytes s = "abcd";
  function f() external returns (bytes1) {
    bytes memory data = s;
    return data[0];
  }
}
// ----
// f() -> "a"
