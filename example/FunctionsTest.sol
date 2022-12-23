pragma solidity 0.7.5;

contract CloneFactory {
  function createClone(address target, bytes32 salt)
    internal
    returns (address payable result)
  {
    bytes20 targetBytes = bytes20(target);

	}

}