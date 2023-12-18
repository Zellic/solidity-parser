pragma solidity ^0.8.0;

contract function_call_types {

    function functionWithInputs(uint256 arg, string x) public returns (uint256) {
        return arg * 2;
    }

    function functionWithoutInputs() public returns (uint256) {
        return 5;
    }

    function voidFunction(int y) public {
        int x = 5;
        int z = x * y;
    }

    event MyEvent(address sender, uint256 value);

    modifier MyModifier(uint256 x) {}

    error MyError(string message);

    function throwError() public pure {
        revert MyError("This is a custom error");
    }

    function useModifier(uint256 newValue) public MyModifier(5) {
        integerValue = int256(newValue);
    }

    function callFunctions() {
        int z = functionWithInputs(5, "hi");
        int k = functionWithoutInputs();

        voidFunction(k);
    }
}
