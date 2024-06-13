pragma solidity 0.8.20;

interface IBar {
    function hasFoo(bytes32 f, address account) external view returns (bool);
}

abstract contract Bar is IBar {
    function hasFoo(bytes32 f, address account) public view virtual returns (bool) {
        return false;
    }
}

contract HierarchyTest is Bar {

  bytes32 public constant FOO = keccak256("FOO");

  modifier testMyFoo() {
    require(hasFoo(FOO, msg.sender), "Foofail");
    _;
  }
}
