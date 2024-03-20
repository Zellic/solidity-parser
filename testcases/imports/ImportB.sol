pragma solidity ^0.8.8;

import { OwnableStorage } from './ImportA.sol';

contract OwnableInternal {

    function _owner() internal view virtual returns (address) {
        // This is a test because 'OwnableStorage.Layout' isnt imported in this contract
        // but the 'owner' lookup here requires that type scope. If the resolver looks up 'Layout' here
        // it won't find anything as it's not imported but it needs to find the base scope from OwnableStorage
        return OwnableStorage.layout().owner;
    }
}
