# -*- coding: utf-8 -*-
# snapshottest: v1 - https://goo.gl/zC4yUc
from __future__ import unicode_literals

from snapshottest import GenericRepr, Snapshot


snapshots = Snapshot()

snapshots['TestSolidityTypeHelper::test_get_expr_type 1'] = [
    (
        GenericRepr("BinaryOp(left=Ident(text='arg'), right=Literal(value=2, unit=None), op=<BinaryOpCode.MUL: '*'>)"),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr('Literal(value=2, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='arg'), right=Literal(value=2, unit=None), op=<BinaryOpCode.MUL: '*'>)"),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr('Literal(value=2, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("BinaryOp(left=GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender')), right=Ident(text='addressValue'), op=<BinaryOpCode.EQ: '=='>)"),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))"),
        [
            GenericRepr('AddressType(is_payable=True)')
        ]
    ),
    (
        GenericRepr("BinaryOp(left=GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender')), right=Ident(text='addressValue'), op=<BinaryOpCode.EQ: '=='>)"),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))"),
        [
            GenericRepr('AddressType(is_payable=True)')
        ]
    ),
    (
        GenericRepr("CallFunction(callee=Ident(text='CustomError'), modifiers=[], args=[Literal(value='This is a custom error', unit=None)])"),
        [
        ]
    ),
    (
        GenericRepr("Literal(value='This is a custom error', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=22)')
    ),
    (
        GenericRepr("CallFunction(callee=Ident(text='CustomError'), modifiers=[], args=[Literal(value='This is a custom error', unit=None)])"),
        [
        ]
    ),
    (
        GenericRepr("Literal(value='This is a custom error', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=22)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='booleanValue'), right=Literal(value=True, unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr('Literal(value=True, unit=None)'),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='integerValue'), right=UnaryOp(expr=Literal(value=42, unit=None), op=<UnaryOpCode.SIGN_NEG: '-'>, is_pre=True), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr("UnaryOp(expr=Literal(value=42, unit=None), op=<UnaryOpCode.SIGN_NEG: '-'>, is_pre=True)"),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr('Literal(value=42, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='unsignedValue'), right=Literal(value=42, unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr('Literal(value=42, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='addressValue'), right=GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender')), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('AddressType(is_payable=True)')
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))"),
        [
            GenericRepr('AddressType(is_payable=True)')
        ]
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='bytesValue'), right=CallFunction(callee=ArrayType(base_type=ByteType()), modifiers=[], args=[Literal(value='Hello, Solidity!', unit=None)]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('ArrayType(base_type=ByteType())')
    ),
    (
        GenericRepr("CallFunction(callee=ArrayType(base_type=ByteType()), modifiers=[], args=[Literal(value='Hello, Solidity!', unit=None)])"),
        GenericRepr('ArrayType(base_type=ByteType())')
    ),
    (
        GenericRepr("Literal(value='Hello, Solidity!', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=16)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='stringValue'), right=Literal(value='Hello, World!', unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=13)')
    ),
    (
        GenericRepr("Literal(value='Hello, World!', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=13)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='fixedArray'), right=NewInlineArray(elements=[CallFunction(callee=IntType(is_signed=False, size=256), modifiers=[], args=[Literal(value=1, unit=None)]), Literal(value=2, unit=None), Literal(value=3, unit=None)]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('FixedLengthArrayType(base_type=IntType(is_signed=False, size=256), size=3)')
    ),
    (
        GenericRepr('NewInlineArray(elements=[CallFunction(callee=IntType(is_signed=False, size=256), modifiers=[], args=[Literal(value=1, unit=None)]), Literal(value=2, unit=None), Literal(value=3, unit=None)])'),
        GenericRepr('FixedLengthArrayType(base_type=IntType(is_signed=False, size=256), size=3)')
    ),
    (
        GenericRepr('CallFunction(callee=IntType(is_signed=False, size=256), modifiers=[], args=[Literal(value=1, unit=None)])'),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr('Literal(value=1, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=1)')
    ),
    (
        GenericRepr('Literal(value=2, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr('Literal(value=3, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("CallFunction(callee=GetMember(obj_base=Ident(text='dynamicArray'), name=Ident(text='push')), modifiers=[], args=[Literal(value=4, unit=None)])"),
        [
        ]
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='dynamicArray'), name=Ident(text='push'))"),
        [
            GenericRepr('FunctionType(inputs=[], outputs=[IntType(is_signed=False, size=256)])'),
            GenericRepr('FunctionType(inputs=[IntType(is_signed=False, size=256)], outputs=[])')
        ]
    ),
    (
        GenericRepr('Literal(value=4, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=3)')
    ),
    (
        GenericRepr("CallFunction(callee=GetMember(obj_base=Ident(text='dynamicArray'), name=Ident(text='push')), modifiers=[], args=[Literal(value=5, unit=None)])"),
        [
        ]
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='dynamicArray'), name=Ident(text='push'))"),
        [
            GenericRepr('FunctionType(inputs=[], outputs=[IntType(is_signed=False, size=256)])'),
            GenericRepr('FunctionType(inputs=[IntType(is_signed=False, size=256)], outputs=[])')
        ]
    ),
    (
        GenericRepr('Literal(value=5, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=3)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='myStructValue'), right=CallFunction(callee=Ident(text='MyStruct'), modifiers=[], args=[Literal(value=10, unit=None), Literal(value='Example', unit=None)]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('ResolvedUserType(MyStruct)')
    ),
    (
        GenericRepr("CallFunction(callee=Ident(text='MyStruct'), modifiers=[], args=[Literal(value=10, unit=None), Literal(value='Example', unit=None)])"),
        GenericRepr('ResolvedUserType(MyStruct)')
    ),
    (
        GenericRepr('Literal(value=10, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=4)')
    ),
    (
        GenericRepr("Literal(value='Example', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=7)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='enumValue'), right=GetMember(obj_base=Ident(text='MyEnum'), name=Ident(text='Option1')), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('ResolvedUserType(MyEnum)')
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='MyEnum'), name=Ident(text='Option1'))"),
        [
            GenericRepr('ResolvedUserType(MyEnum)')
        ]
    ),
    (
        GenericRepr("BinaryOp(left=GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=1, unit=None)), right=Literal(value='One', unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=3)')
    ),
    (
        GenericRepr("GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=1, unit=None))"),
        GenericRepr('StringType(base_type=ByteType())')
    ),
    (
        GenericRepr('Literal(value=1, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=1)')
    ),
    (
        GenericRepr("Literal(value='One', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=3)')
    ),
    (
        GenericRepr("BinaryOp(left=GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=2, unit=None)), right=Literal(value='Two', unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=3)')
    ),
    (
        GenericRepr("GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=2, unit=None))"),
        GenericRepr('StringType(base_type=ByteType())')
    ),
    (
        GenericRepr('Literal(value=2, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("Literal(value='Two', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=3)')
    ),
    (
        GenericRepr("BinaryOp(left=GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=3, unit=None)), right=Literal(value='Three', unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=5)')
    ),
    (
        GenericRepr("GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=3, unit=None))"),
        GenericRepr('StringType(base_type=ByteType())')
    ),
    (
        GenericRepr('Literal(value=3, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("Literal(value='Three', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=5)')
    ),
    (
        GenericRepr("CallFunction(callee=Ident(text='MyEvent'), modifiers=[], args=[GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender')), Literal(value=100, unit=None)])"),
        [
        ]
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))"),
        [
            GenericRepr('AddressType(is_payable=True)')
        ]
    ),
    (
        GenericRepr('Literal(value=100, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=7)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='payableAddress'), right=PayableConversion(args=[GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('AddressType(is_payable=True)')
    ),
    (
        GenericRepr("PayableConversion(args=[GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))])"),
        GenericRepr('AddressType(is_payable=True)')
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))"),
        [
            GenericRepr('AddressType(is_payable=True)')
        ]
    ),
    (
        GenericRepr('Literal(value=10, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=4)')
    ),
    (
        GenericRepr('Literal(value=5, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=3)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='booleanValue'), right=Literal(value=True, unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr('Literal(value=True, unit=None)'),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='integerValue'), right=UnaryOp(expr=Literal(value=42, unit=None), op=<UnaryOpCode.SIGN_NEG: '-'>, is_pre=True), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr("UnaryOp(expr=Literal(value=42, unit=None), op=<UnaryOpCode.SIGN_NEG: '-'>, is_pre=True)"),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr('Literal(value=42, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='unsignedValue'), right=Literal(value=42, unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr('Literal(value=42, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=6)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='addressValue'), right=GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender')), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('AddressType(is_payable=True)')
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))"),
        [
            GenericRepr('AddressType(is_payable=True)')
        ]
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='bytesValue'), right=CallFunction(callee=ArrayType(base_type=ByteType()), modifiers=[], args=[Literal(value='Hello, Solidity!', unit=None)]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('ArrayType(base_type=ByteType())')
    ),
    (
        GenericRepr("CallFunction(callee=ArrayType(base_type=ByteType()), modifiers=[], args=[Literal(value='Hello, Solidity!', unit=None)])"),
        GenericRepr('ArrayType(base_type=ByteType())')
    ),
    (
        GenericRepr("Literal(value='Hello, Solidity!', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=16)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='stringValue'), right=Literal(value='Hello, World!', unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=13)')
    ),
    (
        GenericRepr("Literal(value='Hello, World!', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=13)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='fixedArray'), right=NewInlineArray(elements=[CallFunction(callee=IntType(is_signed=False, size=256), modifiers=[], args=[Literal(value=1, unit=None)]), Literal(value=2, unit=None), Literal(value=3, unit=None)]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('FixedLengthArrayType(base_type=IntType(is_signed=False, size=256), size=3)')
    ),
    (
        GenericRepr('NewInlineArray(elements=[CallFunction(callee=IntType(is_signed=False, size=256), modifiers=[], args=[Literal(value=1, unit=None)]), Literal(value=2, unit=None), Literal(value=3, unit=None)])'),
        GenericRepr('FixedLengthArrayType(base_type=IntType(is_signed=False, size=256), size=3)')
    ),
    (
        GenericRepr('CallFunction(callee=IntType(is_signed=False, size=256), modifiers=[], args=[Literal(value=1, unit=None)])'),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr('Literal(value=1, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=1)')
    ),
    (
        GenericRepr('Literal(value=2, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr('Literal(value=3, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("CallFunction(callee=GetMember(obj_base=Ident(text='dynamicArray'), name=Ident(text='push')), modifiers=[], args=[Literal(value=4, unit=None)])"),
        [
        ]
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='dynamicArray'), name=Ident(text='push'))"),
        [
            GenericRepr('FunctionType(inputs=[], outputs=[IntType(is_signed=False, size=256)])'),
            GenericRepr('FunctionType(inputs=[IntType(is_signed=False, size=256)], outputs=[])')
        ]
    ),
    (
        GenericRepr('Literal(value=4, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=3)')
    ),
    (
        GenericRepr("CallFunction(callee=GetMember(obj_base=Ident(text='dynamicArray'), name=Ident(text='push')), modifiers=[], args=[Literal(value=5, unit=None)])"),
        [
        ]
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='dynamicArray'), name=Ident(text='push'))"),
        [
            GenericRepr('FunctionType(inputs=[], outputs=[IntType(is_signed=False, size=256)])'),
            GenericRepr('FunctionType(inputs=[IntType(is_signed=False, size=256)], outputs=[])')
        ]
    ),
    (
        GenericRepr('Literal(value=5, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=3)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='myStructValue'), right=CallFunction(callee=Ident(text='MyStruct'), modifiers=[], args=[Literal(value=10, unit=None), Literal(value='Example', unit=None)]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('ResolvedUserType(MyStruct)')
    ),
    (
        GenericRepr("CallFunction(callee=Ident(text='MyStruct'), modifiers=[], args=[Literal(value=10, unit=None), Literal(value='Example', unit=None)])"),
        GenericRepr('ResolvedUserType(MyStruct)')
    ),
    (
        GenericRepr('Literal(value=10, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=4)')
    ),
    (
        GenericRepr("Literal(value='Example', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=7)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='enumValue'), right=GetMember(obj_base=Ident(text='MyEnum'), name=Ident(text='Option1')), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('ResolvedUserType(MyEnum)')
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='MyEnum'), name=Ident(text='Option1'))"),
        [
            GenericRepr('ResolvedUserType(MyEnum)')
        ]
    ),
    (
        GenericRepr("BinaryOp(left=GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=1, unit=None)), right=Literal(value='One', unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=3)')
    ),
    (
        GenericRepr("GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=1, unit=None))"),
        GenericRepr('StringType(base_type=ByteType())')
    ),
    (
        GenericRepr('Literal(value=1, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=1)')
    ),
    (
        GenericRepr("Literal(value='One', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=3)')
    ),
    (
        GenericRepr("BinaryOp(left=GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=2, unit=None)), right=Literal(value='Two', unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=3)')
    ),
    (
        GenericRepr("GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=2, unit=None))"),
        GenericRepr('StringType(base_type=ByteType())')
    ),
    (
        GenericRepr('Literal(value=2, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("Literal(value='Two', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=3)')
    ),
    (
        GenericRepr("BinaryOp(left=GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=3, unit=None)), right=Literal(value='Three', unit=None), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=5)')
    ),
    (
        GenericRepr("GetArrayValue(array_base=Ident(text='keyValueMapping'), index=Literal(value=3, unit=None))"),
        GenericRepr('StringType(base_type=ByteType())')
    ),
    (
        GenericRepr('Literal(value=3, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("Literal(value='Three', unit=None)"),
        GenericRepr('PreciseStringType(base_type=ByteType(), real_size=5)')
    ),
    (
        GenericRepr("CallFunction(callee=Ident(text='MyEvent'), modifiers=[], args=[GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender')), Literal(value=100, unit=None)])"),
        [
        ]
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))"),
        [
            GenericRepr('AddressType(is_payable=True)')
        ]
    ),
    (
        GenericRepr('Literal(value=100, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=7)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='payableAddress'), right=PayableConversion(args=[GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('AddressType(is_payable=True)')
    ),
    (
        GenericRepr("PayableConversion(args=[GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))])"),
        GenericRepr('AddressType(is_payable=True)')
    ),
    (
        GenericRepr("GetMember(obj_base=Ident(text='msg'), name=Ident(text='sender'))"),
        [
            GenericRepr('AddressType(is_payable=True)')
        ]
    ),
    (
        GenericRepr('Literal(value=10, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=4)')
    ),
    (
        GenericRepr('Literal(value=5, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=3)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='integerValue'), right=CallFunction(callee=IntType(is_signed=True, size=256), modifiers=[], args=[Ident(text='newValue')]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('IntType(is_signed=True, size=256)')
    ),
    (
        GenericRepr("CallFunction(callee=IntType(is_signed=True, size=256), modifiers=[], args=[Ident(text='newValue')])"),
        GenericRepr('IntType(is_signed=True, size=256)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='integerValue'), right=CallFunction(callee=IntType(is_signed=True, size=256), modifiers=[], args=[Ident(text='newValue')]), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('IntType(is_signed=True, size=256)')
    ),
    (
        GenericRepr("CallFunction(callee=IntType(is_signed=True, size=256), modifiers=[], args=[Ident(text='newValue')])"),
        GenericRepr('IntType(is_signed=True, size=256)')
    ),
    (
        GenericRepr('Literal(value=1, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=1)')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='a'), op=<UnaryOpCode.INC: '++'>, is_pre=False)"),
        GenericRepr('IntType(is_signed=True, size=128)')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='a'), op=<UnaryOpCode.DEC: '--'>, is_pre=False)"),
        GenericRepr('IntType(is_signed=True, size=128)')
    ),
    (
        GenericRepr('Literal(value=2, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='b'), right=UnaryOp(expr=Ident(text='b'), op=<UnaryOpCode.SIGN_NEG: '-'>, is_pre=True), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='b'), op=<UnaryOpCode.SIGN_NEG: '-'>, is_pre=True)"),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr('Literal(value=5, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=3)')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='c'), op=<UnaryOpCode.BIT_NEG: '~'>, is_pre=True)"),
        GenericRepr('IntType(is_signed=False, size=8)')
    ),
    (
        GenericRepr('Literal(value=False, unit=None)'),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='k'), op=<UnaryOpCode.BOOL_NEG: '!'>, is_pre=True)"),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr('Literal(value=1, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=1)')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='a'), op=<UnaryOpCode.INC: '++'>, is_pre=False)"),
        GenericRepr('IntType(is_signed=True, size=128)')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='a'), op=<UnaryOpCode.DEC: '--'>, is_pre=False)"),
        GenericRepr('IntType(is_signed=True, size=128)')
    ),
    (
        GenericRepr('Literal(value=2, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=2)')
    ),
    (
        GenericRepr("BinaryOp(left=Ident(text='b'), right=UnaryOp(expr=Ident(text='b'), op=<UnaryOpCode.SIGN_NEG: '-'>, is_pre=True), op=<BinaryOpCode.ASSIGN: '='>)"),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='b'), op=<UnaryOpCode.SIGN_NEG: '-'>, is_pre=True)"),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr('Literal(value=5, unit=None)'),
        GenericRepr('PreciseIntType(is_signed=False, size=8, real_bit_length=3)')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='c'), op=<UnaryOpCode.BIT_NEG: '~'>, is_pre=True)"),
        GenericRepr('IntType(is_signed=False, size=8)')
    ),
    (
        GenericRepr('Literal(value=False, unit=None)'),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr("UnaryOp(expr=Ident(text='k'), op=<UnaryOpCode.BOOL_NEG: '!'>, is_pre=True)"),
        GenericRepr('BoolType()')
    ),
    (
        GenericRepr("GetMember(obj_base=CreateMetaType(base_type=UserType(name=Ident(text='AllTypesExample'))), name=Ident(text='name'))"),
        [
            GenericRepr('StringType(base_type=ByteType())')
        ]
    ),
    (
        GenericRepr("CreateMetaType(base_type=UserType(name=Ident(text='AllTypesExample')))"),
        GenericRepr('MetaTypeType(ttype=ResolvedUserType(AllTypesExample))')
    ),
    (
        GenericRepr("GetMember(obj_base=CreateMetaType(base_type=UserType(name=Ident(text='AllTypesExample'))), name=Ident(text='name'))"),
        [
            GenericRepr('StringType(base_type=ByteType())')
        ]
    ),
    (
        GenericRepr("CreateMetaType(base_type=UserType(name=Ident(text='AllTypesExample')))"),
        GenericRepr('MetaTypeType(ttype=ResolvedUserType(AllTypesExample))')
    ),
    (
        GenericRepr("Literal(value=(GetMember(obj_base=CreateMetaType(base_type=IntType(is_signed=True, size=16)), name=Ident(text='min')), GetMember(obj_base=CreateMetaType(base_type=IntType(is_signed=True, size=16)), name=Ident(text='max'))), unit=None)"),
        GenericRepr('TupleType(ttypes=[IntType(is_signed=True, size=16), IntType(is_signed=True, size=16)])')
    ),
    (
        GenericRepr("GetMember(obj_base=CreateMetaType(base_type=IntType(is_signed=True, size=16)), name=Ident(text='min'))"),
        [
            GenericRepr('IntType(is_signed=True, size=16)')
        ]
    ),
    (
        GenericRepr('CreateMetaType(base_type=IntType(is_signed=True, size=16))'),
        GenericRepr('MetaTypeType(ttype=IntType(is_signed=True, size=16))')
    ),
    (
        GenericRepr("GetMember(obj_base=CreateMetaType(base_type=IntType(is_signed=True, size=16)), name=Ident(text='max'))"),
        [
            GenericRepr('IntType(is_signed=True, size=16)')
        ]
    ),
    (
        GenericRepr('CreateMetaType(base_type=IntType(is_signed=True, size=16))'),
        GenericRepr('MetaTypeType(ttype=IntType(is_signed=True, size=16))')
    ),
    (
        GenericRepr("Literal(value=(GetMember(obj_base=CreateMetaType(base_type=IntType(is_signed=True, size=16)), name=Ident(text='min')), GetMember(obj_base=CreateMetaType(base_type=IntType(is_signed=True, size=16)), name=Ident(text='max'))), unit=None)"),
        GenericRepr('TupleType(ttypes=[IntType(is_signed=True, size=16), IntType(is_signed=True, size=16)])')
    ),
    (
        GenericRepr("GetMember(obj_base=CreateMetaType(base_type=IntType(is_signed=True, size=16)), name=Ident(text='min'))"),
        [
            GenericRepr('IntType(is_signed=True, size=16)')
        ]
    ),
    (
        GenericRepr('CreateMetaType(base_type=IntType(is_signed=True, size=16))'),
        GenericRepr('MetaTypeType(ttype=IntType(is_signed=True, size=16))')
    ),
    (
        GenericRepr("GetMember(obj_base=CreateMetaType(base_type=IntType(is_signed=True, size=16)), name=Ident(text='max'))"),
        [
            GenericRepr('IntType(is_signed=True, size=16)')
        ]
    ),
    (
        GenericRepr('CreateMetaType(base_type=IntType(is_signed=True, size=16))'),
        GenericRepr('MetaTypeType(ttype=IntType(is_signed=True, size=16))')
    ),
    (
        GenericRepr("CallFunction(callee=New(type_name=UserType(name=Ident(text='AllTypesExample'))), modifiers=[], args=[])"),
        GenericRepr('ResolvedUserType(AllTypesExample)')
    ),
    (
        GenericRepr("New(type_name=UserType(name=Ident(text='AllTypesExample')))"),
        GenericRepr('ResolvedUserType(AllTypesExample)')
    ),
    (
        GenericRepr("CallFunction(callee=New(type_name=UserType(name=Ident(text='AllTypesExample'))), modifiers=[], args=[])"),
        GenericRepr('ResolvedUserType(AllTypesExample)')
    ),
    (
        GenericRepr("New(type_name=UserType(name=Ident(text='AllTypesExample')))"),
        GenericRepr('ResolvedUserType(AllTypesExample)')
    )
]

snapshots['TestSolidityTypeHelper::test_get_function_expr_type 1'] = [
    (
        GenericRepr("CallFunction(callee=Ident(text='MyError'), modifiers=[], args=[Literal(value='This is a custom error', unit=None)])"),
        [
        ]
    ),
    (
        GenericRepr("CallFunction(callee=IntType(is_signed=True, size=256), modifiers=[], args=[Ident(text='newValue')])"),
        GenericRepr('IntType(is_signed=True, size=256)')
    ),
    (
        GenericRepr("CallFunction(callee=Ident(text='functionWithInputs'), modifiers=[], args=[Literal(value=5, unit=None), Literal(value='hi', unit=None)])"),
        [
            GenericRepr('IntType(is_signed=False, size=256)')
        ]
    ),
    (
        GenericRepr("CallFunction(callee=Ident(text='functionWithoutInputs'), modifiers=[], args=[])"),
        [
            GenericRepr('IntType(is_signed=False, size=256)')
        ]
    ),
    (
        GenericRepr("CallFunction(callee=Ident(text='voidFunction'), modifiers=[], args=[Ident(text='k')])"),
        [
        ]
    )
]

snapshots['TestSolidityTypeHelper::test_get_function_expr_type_ternary 1'] = [
    (
        GenericRepr("TernaryOp(condition=Ident(text='za'), left=Ident(text='x1'), right=Ident(text='y1'))"),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr("TernaryOp(condition=Ident(text='zb'), left=Ident(text='x2'), right=Ident(text='y2'))"),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr("TernaryOp(condition=Ident(text='zb'), left=Ident(text='y2'), right=Ident(text='x2'))"),
        GenericRepr('IntType(is_signed=False, size=256)')
    ),
    (
        GenericRepr("TernaryOp(condition=Ident(text='z1'), left=Ident(text='a1'), right=Ident(text='b1'))"),
        GenericRepr('ResolvedUserType(BaseContract)')
    )
]
