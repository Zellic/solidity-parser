// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.22;

library SelfUsing {
    using SelfUsing for *;

    type Delay is uint112;

    function unpack(Delay self) internal returns (uint) {
        return 5;
    }

    function callSelfX(Delay self) private returns (uint) {
        uint value = self.unpack();
        return value;
    }
}
