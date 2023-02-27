from dataclasses import dataclass, field
from enum import Enum
from typing import List, Any, Union, TypeVar, Generic

from solidity_parser.ast import solnodes as solnodes1

import logging

T = TypeVar('T')


@dataclass
class Ref(Generic[T]):
    x: T


@dataclass
class Node:
    parent: 'Node' = field(init=False, repr=False, hash=False, compare=False)

    def get_children(self):
        for val in vars(self).values():
            # Don't include parent or Refs
            if val is self.parent:
                continue

            if isinstance(val, Node):
                yield val
            elif isinstance(val, (list, tuple)):
                yield from [v for v in val if isinstance(v, Node)]

    def get_all_children(self):
        for direct_child in self.get_children():
            yield direct_child
            yield from direct_child.get_all_children()

    def __post_init__(self):
        self.parent = None
        for child in self.get_children():
            child.parent = self


class Type(Node):
    pass

class Stmt(Node):
    pass


class Expr(Node):
    def type_of(self) -> Type:
        pass

class Modifier(Node):
    pass


@dataclass
class Ident(Node):
    text: str


@dataclass
class NamedArgument(Node):
    name: Ident
    expr: Expr


@dataclass
class TopLevelUnit(Node):
    source_unit_name: str



@dataclass
class ArrayType(Type):
    """ Single dimension array type with no size attributes """
    base_type: Type

    def __str__(self): return f"{self.base_type}[]"


@dataclass
class FixedLengthArrayType(ArrayType):
    """ Array type with a known length that is determined at compile time """
    size: int

    def __str__(self): return f"{self.base_type}[{self.size}]"


@dataclass
class VariableLengthArrayType(ArrayType):
    """ Array type with a length that is determined at runtime"""
    size: Expr

    def __str__(self): return f"{self.base_type}[{self.size}]"


@dataclass
class AddressType(Type):
    """ Solidity address/address payable type, functionally this is a uint160"""
    is_payable: bool

    def __str__(self): return f"address{' payable' if self.is_payable else ''}"


@dataclass
class ByteType(Type):
    """ Single 8bit byte type """

    def __str__(self): return "byte"


@dataclass
class IntType(Type):
    """ Solidity native integer type of various bit length and signedness"""

    is_signed: bool
    """ Whether the type is a signed int or unsigned int """
    size: int
    """ Size of the type in bits """

    def __str__(self): return f"{'int' if self.is_signed else 'uint'}{self.size}"


def UIntType(size=256):
    return IntType(False, size)

def Bytes(size):
    return FixedLengthArrayType(ByteType(), size)


class BoolType(Type):
    """ Solidity native boolean type"""

    def __str__(self): return "bool"


@dataclass
class StringType(ArrayType):
    """ Solidity native string type"""

    # makes this an Array[Byte] (as Solidity uses UTF8 for strings?)
    base_type: Type = field(default=ByteType(), init=False)

    def __str__(self): return "string"


@dataclass
class MappingType(Type):
    """ Type that represents a function mapping definition

    For example in the mapping '(uint => Campaign)', src would be 'unit' and the dst would be 'Campaign'
    """
    src: Type
    dst: Type

    def __str__(self): return f"({self.src} => {self.dst})"


@dataclass
class ResolvedUserType(Type):
    # Ref so that we don't set the parent of the TopLevelUnit to this type instance
    value: Ref[TopLevelUnit] = field(repr=False)

    def __str__(self):
        return f'ResolvedUserType({self.value.x.name.text})'
    def __repr__(self):
        return self.__str__()


@dataclass
class TupleType(Type):
    ttypes: List[Type]


@dataclass
class Error(Type):
    def __str__(self):
        return '<Error>()'


class ContractPart(Node):
    pass


@dataclass
class InheritSpecifier(Node):
    name: ResolvedUserType
    args: List[Expr]


@dataclass
class LibraryOverride(Node):
    overriden_type: Type
    library: ResolvedUserType


@dataclass
class ContractDefinition(TopLevelUnit):
    name: Ident
    is_abstract: bool
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]
    type_overrides: List[LibraryOverride]


@dataclass
class InterfaceDefinition(TopLevelUnit):
    name: Ident
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]
    type_overrides: List[LibraryOverride]


@dataclass
class LibraryDefinition(TopLevelUnit):
    name: Ident
    parts: List[ContractPart]
    type_overrides: List[LibraryOverride]


@dataclass
class EnumDefinition(TopLevelUnit):
    name: Ident
    values: List[Ident]


@dataclass
class StructMember(Node):
    ttype: Type
    name: Ident


@dataclass
class StructDefinition(TopLevelUnit):
    name: Ident
    members: List[StructMember]


@dataclass
class ErrorParameter(Node):
    ttype: Type
    name: Ident


@dataclass
class ErrorDefinition(TopLevelUnit, ContractPart):
    name: Ident
    inputs: List[ErrorParameter]


@dataclass
class StateVariableDeclaration(ContractPart):
    name: Ident
    ttype: Type
    modifiers: List[Modifier]
    value: Expr


@dataclass
class EventParameter(Node):
    name: Ident
    ttype: Type
    is_indexed: bool


@dataclass
class EventDefinition(ContractPart):
    name: Ident
    inputs: List[EventParameter]
    is_anonymous: bool


class Location(Enum):
    MEMORY = 'memory'
    STORAGE = 'storage'
    CALLDATA = 'calldata'

    def __str__(self): return self.value


@dataclass
class Var(Node):
    name: Ident
    ttype: Type
    location: Location


@dataclass
class Parameter(Node):
    var: Var


@dataclass
class Block(Stmt):
    stmts: List[Stmt]
    is_unchecked: bool


@dataclass
class If(Stmt):
    condition: Expr
    true_branch: Stmt
    false_branch: Stmt


@dataclass
class Catch(Stmt):
    ident: Ident
    parameters: List[Parameter]
    body: Block

@dataclass
class Try(Stmt):
    expr: Expr
    return_parameters: List[Parameter]
    body: Block
    catch_clauses: List[Catch]


@dataclass
class While(Stmt):
    condition: Expr
    body: Stmt


@dataclass
class For(Stmt):
    initialiser: Stmt
    condition: Expr
    advancement: Expr
    body: Stmt


@dataclass
class FunctionDefinition(ContractPart):
    name: Ident
    inputs: List[Parameter]
    outputs: List[Parameter]
    modifiers: List[Modifier]
    code: Block


@dataclass
class ModifierDefinition(ContractPart):
    name: Ident
    inputs: List[Parameter]
    modifiers: List[Modifier]
    code: Block


@dataclass
class TupleVarDecl(Stmt):
    vars: List[Var]
    value: Expr


@dataclass
class VarDecl(Stmt):
    var: Var
    value: Expr


@dataclass
class VarDecl(Stmt):
    var: Var
    value: Expr


@dataclass
class ExprStmt(Stmt):
    expr: Expr


@dataclass
class Literal(Expr):
    value: Any
    ttype: Type
    unit: solnodes1.Unit = None
    
    def type_of(self) -> Type:
        return self.ttype


@dataclass
class TypeLiteral(Expr):
    ttypes: TupleType

    def type_of(self):
        return self.ttypes

@dataclass
class UnaryOp(Expr):
    """ Single operand expression """
    expr: Expr
    op: solnodes1.UnaryOpCode
    is_pre: bool


@dataclass
class BinaryOp(Expr):
    left: Expr
    right: Expr
    op: solnodes1.BinaryOpCode

    def type_of(self) -> Type:
        if self.op in [solnodes1.BinaryOpCode.BOOL_AND, solnodes1.BinaryOpCode.BOOL_OR, solnodes1.BinaryOpCode.EQ,
                       solnodes1.BinaryOpCode.NEQ]:
            return BoolType()
        elif self.op in [solnodes1.BinaryOpCode.LTEQ, solnodes1.BinaryOpCode.LT, solnodes1.BinaryOpCode.GT,
                        solnodes1.BinaryOpCode.GTEQ]:
            return BoolType()
        elif self.op in [solnodes1.BinaryOpCode.LSHIFT, solnodes1.BinaryOpCode.RSHIFT]:
            # result of a shift has the type of the left operand (from docs)
            return self.left.type_of()
        elif self.op == solnodes1.BinaryOpCode.EXPONENTIATE:
            # result is type of the base
            return self.left.type_of()
        elif self.op in [solnodes1.BinaryOpCode.MUL, solnodes1.BinaryOpCode.DIV, solnodes1.BinaryOpCode.MOD,
                         solnodes1.BinaryOpCode.ADD, solnodes1.BinaryOpCode.SUB]:
            t1 = self.left.type_of()
            t2 = self.right.type_of()
            assert t1 == t2
            return t1
        else:
            raise ValueError(f'{self.op}')


@dataclass
class TernaryOp(Expr):
    condition: Expr
    left: Expr
    right: Expr


@dataclass
class SelfObject(Expr):
    declarer: Ref[Union[ContractDefinition, InterfaceDefinition]] = field(repr=False)

    def type_of(self) -> Type:
        return ResolvedUserType(self.declarer)


@dataclass
class SuperObject(Expr):
    declarer: Ref[Union[ContractDefinition, InterfaceDefinition]] = field(repr=False)


@dataclass
class StateVarLoad(Expr):
    base: Expr
    name: Ident

    def type_of(self) -> Type:
        base_type = self.base.type_of()
        assert isinstance(base_type, ResolvedUserType)

        unit = base_type.value.x

        matches = [p for p in unit.parts if p.name.text == self.name.text and isinstance(p, (StateVariableDeclaration))]
        assert len(matches) == 1
        return matches[0].ttype


@dataclass
class EnumMemberLoad(Expr):
    enum: ResolvedUserType
    name: Ident


@dataclass
class StateVarStore(Expr):
    base: Expr
    name: Ident
    value: Expr


@dataclass
class LocalVarLoad(Expr):
    var: Var

    def type_of(self) -> Type:
        return self.var.ttype


@dataclass
class LocalVarStore(Expr):
    var: Var
    value: Expr

    def type_of(self) -> Type:
        return self.var.ttype


@dataclass
class ArrayLoad(Expr):
    base: Expr
    index: Expr


@dataclass
class ArrayStore(Expr):
    base: Expr
    index: Expr
    value: Expr


@dataclass
class BuiltInValue(Expr):
    name: str
    ttype: Type

    def type_of(self) -> Type:
        return self.ttype


@dataclass
class ABISelector(Expr):
    function: Ref[FunctionDefinition]

    def type_of(self) -> Type:
        return Bytes(4)

    def __str__(self):
        f = self.function.x
        owner_name = f.parent.source_unit_name
        return f'{owner_name}.{f.name.text}.selector'


@dataclass
class CreateMemoryArray(Expr):
    ttype: ArrayType
    size: Expr


@dataclass
class CreateStruct(Expr):
    ttype: ResolvedUserType
    args: List[Expr]


@dataclass
class Call(Expr):
    named_args: List[NamedArgument]
    args: List[Expr]


@dataclass
class DirectCall(Call):
    ttype: ResolvedUserType
    name: Ident

    def check_arg_types(self, f: FunctionDefinition) -> bool:
        f_types = [x.var.ttype for x in f.inputs]
        c_types = [a.type_of() for a in self.args]
        return f_types == c_types

    def resolve_call(self) -> FunctionDefinition:
        unit = self.ttype.value.x
        matching_name_funcs = [p for p in unit.parts if isinstance(p, FunctionDefinition) and p.name.text == self.name.text]
        matching_param_types = [f for f in matching_name_funcs if self.check_arg_types(f)]
        assert len(matching_param_types) == 1
        return matching_param_types[0]

    def type_of(self) -> Type:
        target_callee = self.resolve_call()
        if len(target_callee.outputs) > 1:
            # For functions that return multiple values return (t(r1), ... t(rk))
            ttype = TupleType([out_param.var.ttype for out_param in target_callee.outputs])
        else:
            ttype = target_callee.outputs[0].var.ttype
        return ttype


@dataclass
class FunctionCall(Call):
    base: Expr
    name: Ident


@dataclass
class BuiltInCall(Call):
    name: str
    ttype: Type

    def type_of(self) -> Type:
        return self.ttype


@dataclass
class RequireExpr(Call):
    pass


@dataclass
class Cast(Expr):
    ttype: Type
    value: Expr

    def type_of(self) -> Type:
        return self.ttype


@dataclass
class GetType(Expr):
    # type(MyContract)
    ttype: Type


@dataclass
class EmitEvent(Stmt):
    event: Ref[EventDefinition]
    args: List[Expr]


@dataclass
class CreateError(Expr):
    error: Ref[ErrorDefinition]
    args: List[Expr]


@dataclass
class Revert(Stmt):
    error: CreateError
    reason: Expr


@dataclass
class Return(Stmt):
    values: List[Expr]


class Continue(Stmt):
    pass


class Break(Stmt):
    pass


@dataclass
class Assembly(Stmt):
    # TODO: full assembly code representation
    code: str


@dataclass
class ExecModifiedCode(Stmt):
    # _; statement in modifier code bodies that show where modified function code gets executed
    pass
