pragma solidity 0.8.22;

library SafeCast {
    function toUint224(int256 value) internal pure returns (uint224) {
//        if (value > type(uint224).max) revert SafeCast__ValueDoesNotFit();
        return uint224(value);
    }
}

abstract contract OracleAdapter {
    using SafeCast for int8;

    function _scale(uint224 amount, int8 factor) internal pure returns (uint224) {
        if (factor == 0) return amount;

        if (factor < 0) {
            return amount / (10 ** (-factor).toUint224());
        } else {
            return amount * (10 ** factor.toUint224());
        }
    }
}