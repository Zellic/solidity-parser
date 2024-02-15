contract C {
    function testFunction1() public {}
    function testFunction2() public view {}
    function testFunction3() public pure {}


    function() external [] externalArray0;
    function() external [] externalArray1;

    function() internal [] internalArray0;
    function() internal [] internalArray1;

    constructor() {
        externalArray0 = new function() external[] (3);
        externalArray1 = [
            this.testFunction1,
            this.testFunction2,
            this.testFunction3
        ];

        internalArray0 = new function() internal[] (3);
        internalArray1 = [
            testFunction1,
            testFunction2,
            testFunction3
        ];
    }


    function copyExternalStorageArraysOfFunctionType() external returns (bool)
    {
        assert(keccak256(abi.encodePacked(externalArray0)) != keccak256(abi.encodePacked(externalArray1)));
        externalArray0 = externalArray1;
        return keccak256(abi.encodePacked(externalArray0)) == keccak256(abi.encodePacked(externalArray1));
    }

    function copyInternalArrayOfFunctionType() external returns (bool)
    {
        internalArray0 = internalArray1;
        assert(internalArray0.length == 3);

        return
            internalArray0.length == internalArray1.length &&
            internalArray0[0] == internalArray1[0] &&
            internalArray0[1] == internalArray1[1] &&
            internalArray0[2] == internalArray1[2];
    }
}
// ----
// copyExternalStorageArraysOfFunctionType() -> true
// gas irOptimized: 104265
// gas legacy: 108295
// gas legacyOptimized: 102146
// copyInternalArrayOfFunctionType() -> true
// gas legacy: 104178
