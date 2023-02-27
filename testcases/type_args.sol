// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract type_args {
    constructor(bytes _payload){
        // Solidity grammar parses this as a GetArray(Int) of ArrayType(Int)
        // i.e
        // CallFunction(callee=GetMember(obj_base=Ident(text='abi'), name=Ident(text='decode')), modifiers=[],
        // args=[Ident(text='_payload'), Literal(value=(ArrayType(base_type=ByteType()),
        // GetArrayValue(array_base=IntType(is_signed=False, size=256), index=None)), unit=None)])
         abi.decode(_payload, (bytes, uint[]));
        // in AST2 this should be converted to
        // Literal(value=(ArrayType(base_type=ByteType()), ArrayType(base_type=IntType(is_signed=False, size=256))),
        // unit=None)
    }
}
