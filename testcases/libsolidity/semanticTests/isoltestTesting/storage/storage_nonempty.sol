contract StorageNotEmpty {
    uint256 x;
    function set(uint256 _a) public { x = _a; }
}
// ----
// storageEmpty -> 1
// set(uint256): 1 ->
// storageEmpty -> 0
