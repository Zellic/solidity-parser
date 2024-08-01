pragma solidity ^0.8.24;

import {ResultCalc} from "./UsingUnimportedAttachmentsStubB.sol";

library ResultStoreHelper {
    using ResultCalc for mapping(bytes32 => ResultCalc.Result);
    using ResultCalc for ResultCalc.Result;

    struct IntData {
        uint24 x;
        uint24 y;
        uint24 z;
    }

    struct TaggedResult {
        IntData slot0;
        mapping(bytes32 => ResultCalc.Result) results;
    }

    function subRes(TaggedResult storage s, address a, uint24 b, bytes32 c, uint256 xx) internal {
        s.results.get(a, b, c).sub(xx);
    }

    function addRes(TaggedResult storage s, address a, uint24 b, bytes32 c, uint256 xx) internal {
        s.results.get(a, b, c).add(xx);
    }
}