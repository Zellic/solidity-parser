pragma solidity ^0.8.0;

error SafeCast__NegativeValue();

library IntHelper {
   function toUint256(int256 value) internal pure returns (uint256) {
       if (value < 0) revert SafeCast__NegativeValue();
       return uint256(value);
   }
}