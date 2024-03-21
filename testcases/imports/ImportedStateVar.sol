pragma solidity ^0.8.8;

interface A {
    function f() external view returns (address);
    function f2() external view returns (uint256);
    function f3(address x) external view returns (uint256);
    function f4(address x, uint256 y) external view returns (int8);
    function f5(uint256) external view returns (int8);
    function f6() external view returns (bytes32);
    function f7() external view returns (bytes memory);
    function f8() external view returns (string memory);
}

contract B is A {
    address public override f;
    uint256 public f2;
    mapping (address => uint256) public f3;
    mapping (address => mapping (uint256 => int8)) public f4;
    int8[] public f5;
    bytes32 public f6;
    bytes public f7;
    string public f8;
}

contract C is B {

}

contract D {
    C private token;

    function g(address x) public returns (uint) {
        return 5;
    }

    function test() external returns (address) {
        g(token.f());
        return token.f();
    }

    function test2() external returns (address) {
        uint256 x = token.f2();
        x += g(msg.sender);
        return msg.sender;
    }

    function test3(address x) external returns (int8) {
        uint256 y = token.f3(x);
        int8 z = token.f4(x, y);
        bytes32 b = token.f6();
        bytes memory b2 = token.f7();
        string memory s = token.f8();
        return z + token.f5(10);
    }

    function test4(address x, uint256 y) external {
        token.f4(x, y);
    }
}