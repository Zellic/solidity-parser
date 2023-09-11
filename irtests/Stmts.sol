// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract Stmts {

    function incPost() returns (int) {
        // t0_0 = 0;
        // y_0 = t0_0;
        //
        // t1_0 = 1;
        // t2_0 = y_0;
        // y_1 = y_0 + t1_0;
        //
        // return t2_0;
        int y = 0;
        return y++;
    }

    function incPre() returns(int) {
        // t0_0 = 1;
        //
        // y_0 = t0_0;
        // t1_0 = 1;
        // y_1 = y_0 - t1_0;
        //
        // return y_1;
        int y = 1;
        return --y;
    }

    int stateVar;

    // this isn't allowed in solidity: "TypeError: Expression has to be an lvalue."
//    function incStateVar() returns (int) {
//        this.stateVar++;
//    }
}
