// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract ternary_assign_prec {
    constructor(bool _payInZRO){
        uint protocolFee = 1;
        uint zroFee = 2;
        uint nativeFee = 3;
        // Weird antlr grammar issue means we had to add brackets around expr ? (expr : expr) to change precedence
        // behaviour for ternarys that contain assignments
        _payInZRO ? zroFee = protocolFee : nativeFee = protocolFee;
// TernaryOp(condition=LocalVarLo        // This should get parsed asad(var=Var(name=Ident(text='_payInZRO'), ttype=BoolType(), location=None)),
//    left=LocalVarStore(var=Var(name=Ident(text='zroFee'), ttype=IntType(is_signed=False, size=256), location=None),
//    value=LocalVarLoad(var=Var(name=Ident(text='protocolFee'), ttype=IntType(is_signed=False, size=256), location=None))),
//    right=LocalVarStore(var=Var(name=Ident(text='nativeFee'), ttype=IntType(is_signed=False, size=256), location=None),
//    value=LocalVarLoad(var=Var(name=Ident(text='protocolFee'), ttype=IntType(is_signed=False, size=256), location=None))))

        // NOT AS:
        // BinaryOp(
        //    left=TernaryOp(
        //        condition=Ident(text='_payInZRO')
        //        left=BinaryOp(
        //            left=Ident(text='zroFee'),
        //            right=Ident(text='protocolFee'),
        //            op=<BinaryOpCode.ASSIGN: '='>
        //        ),
        //        right=Ident(text='nativeFee')
        //    ),
        //    right=Ident(text='protocolFee'),
        //    op=<BinaryOpCode.ASSIGN: '='>
        //)
    }
}
