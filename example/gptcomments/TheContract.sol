pragma solidity ^0.8.0;

contract OperationsContract {
    uint256[] public data;

    constructor() {
        data.push(10);
        data.push(20);
        data.push(30);
    }

    function mathOperations(uint256 _num1, uint256 _num2) external pure returns (uint256 result) {
        result = _num1 + _num2;
        result -= 5;
        result *= 2;
        result /= 3;
        result %= 7;
    }

    function logicalOperations(bool _a, bool _b) external pure returns (bool result) {
        result = (_a && _b) || (!_a || _b);
        result = !result;
    }

    function bitwiseOperations(uint256 _num1, uint256 _num2) external pure returns (uint256 result) {
        result = _num1 & _num2;
        result |= _num1;
        result ^= _num2;
        result <<= 2;
        result >>= 1;
    }

    function stringOperations(string memory _str1, string memory _str2) external pure returns (string memory result) {
        result = string(abi.encodePacked(_str1, _str2));
    }

    function arrayOperations() external {
        data.push(40);
        data.pop();
        data[0] = 100;
        delete data[1];
        data.push(200);
    }

    function controlStructures(uint256 _value) external pure returns (uint256) {
        uint256 result;
        if (_value > 10) {
            result = _value * 2;
        } else {
            result = _value * 3;
        }

        for (uint256 i = 0; i < 5; i++) {
            result += i;
        }

        while (result > 0) {
            result--;
        }

        return result;
    }

    function visibilityAndModifiers(uint256 _newValue) external view onlyEven(_newValue) returns (uint256) {
        return _newValue * 2;
    }

    modifier onlyEven(uint256 _value) {
        require(_value % 2 == 0, "Value must be even");
        _;
    }

    function destroyContract(address payable _recipient) external {
        selfdestruct(_recipient);
    }

    receive() external payable {}
}
