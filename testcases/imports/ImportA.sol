pragma solidity ^0.8.8;

library OwnableStorage {
    struct Layout {
        address owner;
    }

    function layout() internal pure returns (Layout storage l) {
        Layout storage l;
        return l;
    }
}
