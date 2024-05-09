pragma solidity 0.8.22;

library EnumerableSet {
    struct Set {
        bytes32[] _values;
        // 1-indexed to allow 0 to signify nonexistence
        mapping(bytes32 => uint256) _indexes;
    }

    struct Bytes32Set {
        Set _inner;
    }

    struct AddressSet {
        Set _inner;
    }

    struct UintSet {
        Set _inner;
    }

    function toArray(
        Bytes32Set storage set
    ) internal view returns (bytes32[] memory) {
        return set._inner._values;
    }

    function toArray(
        AddressSet storage set
    ) internal view returns (address[] memory) {
        bytes32[] storage values = set._inner._values;
        address[] storage array;

//        assembly {
//            array.slot := values.slot
//        }

        return array;
    }

    function toArray(
        UintSet storage set
    ) internal view returns (uint256[] memory) {
        bytes32[] storage values = set._inner._values;
        uint256[] storage array;

//        assembly {
//            array.slot := values.slot
//        }

        return array;
    }
}

library RelayerAccessManagerStorage {
    struct Layout {
        EnumerableSet.AddressSet whitelistedRelayers;
    }

    function layout() internal pure returns (Layout storage l) {
//        bytes32 slot = STORAGE_SLOT;
//        assembly {
//            l.slot := slot
//        }
    }
}

contract RelayerAccessManager {
    using EnumerableSet for EnumerableSet.AddressSet;

    function getWhitelistedRelayers() external view virtual returns (address[] memory relayers) {
        relayers = RelayerAccessManagerStorage.layout().whitelistedRelayers.toArray();
    }
}