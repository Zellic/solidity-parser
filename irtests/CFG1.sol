// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract CFG1 {

    function print(string x) {
        // stub
        return x;
    }

    function testStraightCode(uint x, uint y) returns (bool) {
        uint z = x + y;

        return z == 5;
    }

    function testMultipleReturn(uint x, uint z) returns (uint, uint) {
        return (x+1, z+2);
    }

    function testIfStmtNoElse(uint x) returns (uint) {
        print("before");

        if (x == 6) {
            return 8;
        }

        return x;
    }

    function testIfStmtWithElse(uint x, uint y, uint z) returns (uint) {
        print("precode");

        if (x == z) {
            return y;
        } else {
            return z;
        }

        print("post code");
    }

    function testIfStmtWithFallthrough(uint x, uint y) returns (uint) {
        uint myRet = 0;
        if (x == y) {
            myRet = 1;
        } else {
            myRet = 2;
        }

        myRet = 3;

        return myRet;
    }

    function testForLoopBasic(uint x) {
        print("precode");

        for(int i=0; i < x; i++) {
            print("loop body");
        }

        print("postcode");
    }

    function testForNoInit() {
        print("precode");
        uint i = 0;

        for(; i < 10; i++) {
            print("for loop body");
        }

        print("post code");
    }

    function testWhileLoop() {
        print("precode");
        uint i = 0;

        while(i < 5) {
            print("while loop body");
        }


        print("post code");
    }

    function testDowhileLoop() {
        print("precode");
        uint i = 0;

        do {
            print("dowhile loop body");
        } while(i < 5);

        print("post code");
    }

    function testNestedBlock() {
        print("abc");

        {
            print("inner1");

            {
                print("inner main");
            }

            print("inner 2");
        }

        print("def");
    }
}
