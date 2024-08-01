pragma solidity ^0.8.24;

import {ResultStoreHelper} from "./UsingUnimportedAttachmentsStub.sol";
import {ResultCalc} from "./UsingUnimportedAttachmentsStubB.sol";

contract UsingUnimportedAttachments {
    using ResultStoreHelper for *;
    using ResultCalc for mapping(bytes32 => ResultCalc.Result);

    mapping(uint => ResultStoreHelper.TaggedResult) public stores;

    function getResult(uint x, address a, uint24 b, bytes32 c)
        external
        view
        returns (ResultCalc.Result memory)
    {
        return stores[x].results.get(a, b, c);
    }
}