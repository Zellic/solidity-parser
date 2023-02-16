from dataclasses import dataclass, field
from enum import Enum
from typing import List, Any, Union, Optional, Dict, TypeVar, Generic, Set, Deque
from abc import ABC, abstractmethod
from collections import deque

from solidity_parser.ast import solnodes as solnodes1
from solidity_parser.ast import symtab


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
    """ Solidity address/address payable type """
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


@dataclass
class LibraryDefinition(TopLevelUnit):
    name: Ident
    parts: List[ContractPart]


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
    function: FunctionDefinition

    def type_of(self) -> Type:
        return Bytes(4)

    def __str__(self):
        owner_name = self.function.parent.source_unit_name
        return f'{owner_name}.{self.function.name.text}.selector'


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
    modifiers: List[Modifier]
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
class RevertStmt(Stmt):
    args: List[Expr]


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
    error: Ref[EventDefinition]
    args: List[Expr]


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


class TypeHelper:
    def __init__(self, builder):
        self.builder = builder

    def find_field(self, ttype: Type, name: str) -> FunctionDefinition:
        pass

    def find_event(self, ttype: ResolvedUserType, name: str) -> EventDefinition:
        # Not sure if inheritance is allowed for events. Afaik a contract can only call events defined in itself

        unit = ttype.value.x

        assert isinstance(unit, (ContractDefinition, InterfaceDefinition))

        def matches(x):
            # TODO: parameter type match
            return isinstance(x, EventDefinition) and x.name.text == name
        candidates = [x for x in unit.parts if matches(x)]

        assert len(candidates) == 1

        return candidates[0]

    def find_declared_target_method(self, scope: symtab.Scope, name: str, arg_types: List[Type]):
        pass

class Builder:

    def __init__(self):
        self.user_types: Dict[str, ContractDefinition] = {}
        self.type_helper = TypeHelper(self)
        self.processed: Set[solnodes1.SourceUnit] = set()
        self.to_process: Deque[solnodes1.SourceUnit] = deque()

    def process_all(self):
        while self.to_process:
            print(f"process: {self.to_process[0]}")
            print(f" in {self.to_process[0].scope.find_first_ancestor_of(symtab.FileScope).source_unit_name}")
            self.refine_unit_or_part(self.to_process.popleft())

    def load_if_required(self, user_type_symbol: symtab.Symbol) -> TopLevelUnit:
        ast1_node: solnodes1.SourceUnit = user_type_symbol.value

        if isinstance(ast1_node, (solnodes1.ContractDefinition, solnodes1.InterfaceDefinition,
                                  solnodes1.StructDefinition, solnodes1.LibraryDefinition, solnodes1.EnumDefinition)):

            if hasattr(ast1_node, 'ast2_node'):
                ast2_node = ast1_node.ast2_node
            else:
                parent_scope = user_type_symbol.parent_scope

                if isinstance(parent_scope, symtab.FileScope):
                    source_unit_name = parent_scope.source_unit_name
                else:
                    parent_type = self.load_if_required(parent_scope)
                    source_unit_name = f'{parent_type.source_unit_name}${parent_type.name.text}'

                print(f'LOAD {source_unit_name}')
                ast2_node = self.define_skeleton(ast1_node, source_unit_name)

            return ast2_node
        else:
            raise ValueError(f"Invalid user type resolve: {type(ast1_node)}")

    def get_contract_type(self, user_type_symbol: symtab.Symbol) -> ResolvedUserType:
        return ResolvedUserType(Ref(self.load_if_required(user_type_symbol)))

    def get_user_type(self, ttype: solnodes1.UserType):
        """Maps an AST1 UserType to AST2 ResolvedUserType"""
        name = ttype.name.text
        s = ttype.scope.find(name)

        if not s:
            raise ValueError(f"Can't resolve {ttype}")

        if len(s) != 1:
            raise ValueError(f"Too many symbols for {ttype}: {s}")

        return self.get_contract_type(s[0])

    def _todo(self, node):
        raise ValueError(f'TODO: {type(node)}')

    def map_type(self, ttype: solnodes1.Type):
        if isinstance(ttype, solnodes1.UserType):
            return self.get_user_type(ttype)
        elif isinstance(ttype, solnodes1.VariableLengthArrayType):
            return VariableLengthArrayType(self.map_type(ttype.base_type), self.refine_expr(ttype.size))
        elif isinstance(ttype, solnodes1.FixedLengthArrayType):
            return FixedLengthArrayType(self.map_type(ttype.base_type), ttype.size)
        elif isinstance(ttype, solnodes1.ArrayType):
            return ArrayType(self.map_type(ttype.base_type))
        elif isinstance(ttype, solnodes1.AddressType):
            return AddressType(ttype.is_payable)
        elif isinstance(ttype, solnodes1.ByteType):
            return ByteType()
        elif isinstance(ttype, solnodes1.IntType):
            return IntType(ttype.is_signed, ttype.size)
        elif isinstance(ttype, solnodes1.BoolType):
            return BoolType()
        elif isinstance(ttype, solnodes1.StringType):
            return StringType()
        elif isinstance(ttype, solnodes1.MappingType):
            return MappingType(self.map_type(ttype.src), self.map_type(ttype.dst))

        self._todo(ttype)

    def symbol_to_ref(self, symbol: symtab.Symbol):
        ast1_node = symbol.value




    def refine_stmt(self, node: solnodes1.Stmt):
        if isinstance(node, solnodes1.VarDecl):
            if len(node.variables) == 1:
                return VarDecl(self.var(node.variables[0]), self.refine_expr(node.value) if node.value else None)
            else:
                return TupleVarDecl([self.var(x) for x in node.variables], self.refine_expr(node.value))
        elif isinstance(node, solnodes1.ExprStmt):
            return ExprStmt(self.refine_expr(node.expr))
        elif isinstance(node, solnodes1.Block):
            return self.block(node)
        elif isinstance(node, solnodes1.If):
            return If(
                self.refine_expr(node.condition),
                self.refine_stmt(node.true_branch) if node.true_branch else None,
                self.refine_stmt(node.false_branch) if node.false_branch else None
            )
        elif isinstance(node, solnodes1.Try):
            return Try(
                self.refine_expr(node.expr),
                [self.parameter(x) for x in node.return_parameters],
                self.refine_stmt(node.body),
                [Catch(
                    # TODO: figure out what this is
                    x.ident.text if x.ident else None,
                    [self.parameter(y) for y in x.parameters],
                    self.block(x.body)
                ) for x in node.catch_clauses]
            )
        elif isinstance(node, solnodes1.Emit):
            assert isinstance(node.call.callee, solnodes1.Ident)
            callee_symbol = node.scope.find_single(node.call.callee.text)
            assert isinstance(callee_symbol.value, solnodes1.EventDefinition)
            assert len(node.call.modifiers) == 0

            # Get the AST2 EventDefinition. This requires the parent contract to be loaded so we have to do that first
            parent_type = self.get_contract_type(callee_symbol.parent_scope)

            assert parent_type

            event_name = callee_symbol.value.name.text
            event = self.type_helper.find_event(parent_type, event_name)

            return EmitEvent(Ref(event), [self.refine_expr(x) for x in node.call.args])
        elif isinstance(node, solnodes1.Return):
            # see case of Literal where value is of type tuple
            val_or_vals = self.refine_expr(node.value)
            assert isinstance(val_or_vals, (Expr, list))

            if not isinstance(val_or_vals, list):
                val_or_vals = [val_or_vals]
            return Return(val_or_vals)
        elif isinstance(node, solnodes1.AssemblyStmt):
            return Assembly(node.code)
        elif isinstance(node, solnodes1.While):
            return While(self.refine_expr(node.expr), self.refine_stmt(node.body))
        elif isinstance(node, solnodes1.For):
            return For(self.refine_stmt(node.initialiser), self.refine_expr(node.condition),
                       self.refine_expr(node.advancement), self.refine_stmt(node.body))
        elif isinstance(node, solnodes1.Break):
            return Break()
        elif isinstance(node, solnodes1.Continue):
            return Continue()
        self._todo(node)

    def get_declaring_contract(self, node: solnodes1.Node) -> Union[symtab.ContractOrInterfaceScope, symtab.LibraryScope]:
        return node.scope.find_first_ancestor_of((symtab.ContractOrInterfaceScope, symtab.LibraryScope))

    def get_self_object(self, node: Union[solnodes1.Stmt, solnodes1.Expr]):
        ast1_current_contract = self.get_declaring_contract(node)
        contract_type: ResolvedUserType = self.get_contract_type(ast1_current_contract)
        return SelfObject(contract_type.value)

    def get_super_object(self, node: Union[solnodes1.Stmt, solnodes1.Expr]):
        ast1_current_contract = self.get_declaring_contract(node)
        contract_type: ResolvedUserType = self.get_contract_type(ast1_current_contract)
        return SuperObject(contract_type.value)

    def check_builtin_function(self, name: str, new_args: List[Expr], new_mods: List[Modifier]) -> Optional[BuiltInCall]:
        def assert_simple_call(arg_len=1, mod_len=0):
            assert len(new_args) == arg_len and len(new_mods) == mod_len

        if name == 'keccak256':
            assert_simple_call()
            return BuiltInCall([], new_args, name, FixedLengthArrayType(ByteType(), 32))
        elif name == 'addmod' or name == 'mulmod':
            # (uint x, uint y, uint k) returns (uint)
            assert_simple_call(arg_len=3)
            return BuiltInCall([], new_args, name, UIntType())
        elif name == 'sub' or name == 'div' or name == 'mod' or name == 'min' or name == 'max':
            # mod(uint x, uint y) returns (uint)
            assert_simple_call(arg_len=2)
            return BuiltInCall([], new_args, name, UIntType())
        elif name == 'exp' or name == 'log2' or name == 'sqrt':
            # (uint x) returns (uint)
            assert_simple_call()
            return BuiltInCall([], new_args, name, UIntType())

    def refine_call_function(self, expr):
        # solnodes1.CallFunction is very confusing because the grammar allows basically any expression into it and
        # doesn't parse the name of the function call as a separate entity. So we have to do our own analysis
        # of expr.callee to figure out wtf was accepted by the parser
        callee = expr.callee

        new_args = [self.refine_expr(x) for x in expr.args]
        new_modifiers = [self.modifier(x) for x in expr.modifiers]

        # helper for a few cases
        def assert_simple_call(arg_len=1, mod_len=0):
            assert len(new_args) == arg_len and len(new_modifiers) == mod_len

        if isinstance(callee, solnodes1.Ident):
            if callee.text == 'require':
                return RequireExpr(new_modifiers, new_args)
            elif callee.text == 'revert':
                assert_simple_call()
                assert isinstance(new_args[0].type_of(), StringType)
                return RevertStmt(new_args)
            elif callee.text == 'gasleft':
                assert_simple_call(arg_len=0)
                # this is the same as msg.gas
                return BuiltInValue('msg.gas', UIntType(256))
            else:
                builtin_call = self.check_builtin_function(callee.text, new_args, new_modifiers)
                if builtin_call:
                    return builtin_call

                ident_target_symbols = expr.scope.find(callee.text)

                if len(ident_target_symbols) == 0:
                    raise ValueError('No resolve')

                if len(ident_target_symbols) == 1:
                    ident_target_symbol = ident_target_symbols[0]
                else:
                    # We have multiple things this call could resolve to, this should be a polymorphic call so
                    # check that all the symbols are functions
                    type_a = type(ident_target_symbols[0])
                    all([type(x) == type_a for x in ident_target_symbols])

                    assert isinstance(ident_target_symbols[0], symtab.ModFunErrEvtScope)

                    ident_target_symbol = self.find_method(ident_target_symbols, [arg.type_of() for arg in new_args])

                if isinstance(ident_target_symbol, symtab.ContractOrInterfaceScope):
                    assert_simple_call()
                    return Cast(self.get_contract_type(ident_target_symbol), new_args[0])
                elif isinstance(ident_target_symbol, symtab.ModFunErrEvtScope):
                    target = ident_target_symbol.value

                    if isinstance(target, solnodes1.FunctionDefinition):
                        # This is an unqualified function call, i.e. the statement 'my_func(x,y)'. The base
                        # is set as self
                        return FunctionCall(new_modifiers, new_args, self.get_self_object(expr), Ident(target.name.text))
        elif isinstance(callee, solnodes1.AddressType):
            # address(my_obj) but we treat it as a Cast expr type instead of its own separate node
            assert_simple_call()
            return Cast(self.map_type(callee), new_args[0])
        elif isinstance(callee, solnodes1.GetMember):
            base = callee.obj_base
            if isinstance(base, solnodes1.GetMember):
                new_base = self.refine_expr(base)
            elif isinstance(base, solnodes1.CallFunction):
                new_base = self.refine_expr(base)
            elif isinstance(base, solnodes1.Ident):
                if base.text == 'abi':
                    if callee.name.text == 'encode' or callee.name.text == 'encodePacked' or callee.name.text == 'encodeWithSelector':
                        return BuiltInCall(
                            new_modifiers,
                            new_args,
                            f'abi.{callee.name.text}',
                            ArrayType(ByteType())
                        )
                    elif callee.name.text == 'decode':
                        assert_simple_call(arg_len=2)
                        assert isinstance(new_args[1], TypeLiteral)

                        return BuiltInCall(
                            new_modifiers,
                            [new_args[1]],
                            'abi.decode',
                            TupleType(new_args[1].type_of())
                        )
                elif base.text == 'super':
                    new_base = self.get_super_object(expr)
                elif base.text == 'this':
                    new_base = self.get_self_object(expr)
                else:
                    ident_symbol = expr.scope.find_single(base.text)
                    ident_node = ident_symbol.value
                    if isinstance(ident_node, solnodes1.StateVariableDeclaration):
                        # state_var.xyz() => self.state_var.xyz()
                        new_base = StateVarLoad(self.get_self_object(expr), Ident(ident_node.name.text))
                    elif isinstance(ident_node, (solnodes1.Parameter, solnodes1.Var)):
                        new_base = LocalVarLoad(self.var(ident_node))
                    else:
                        assert isinstance(ident_symbol, symtab.Scope)
                        target_symbols = ident_symbol.find(callee.name.text)

                        if len(target_symbols) == 0:
                            raise ValueError('No resolve')

                        if len(target_symbols) == 1:
                            target_symbol = target_symbols[0]
                        else:
                            # check homogenous
                            type_a = type(target_symbols[0])
                            all([type(x) == type_a for x in target_symbols])

                            assert isinstance(target_symbols[0], symtab.ModFunErrEvtScope)

                            target_symbol = self.find_method(target_symbols, [arg.type_of() for arg in new_args])

                        if isinstance(target_symbol, symtab.ModFunErrEvtScope):
                            assert isinstance(ident_node, (solnodes1.LibraryDefinition, solnodes1.ContractDefinition))
                            # static library call, e.g. MyLib.xyz()
                            return DirectCall(new_modifiers, new_args, self.get_contract_type(ident_symbol), Ident(target_symbol.value.name.text))
                        else:
                            assert isinstance(target_symbol, symtab.StructScope)
                            return CreateStruct(self.get_contract_type(target_symbol), new_args)
            else:
                # This is here so that I can stop on each pattern, the above creation of new_base are approved patterns
                self._todo(expr)

            # Check to see if the call resolves to something and if so create a FunctionCall

            # target: solnodes1.FunctionDefinition = self.find_method(expr.scope, new_base,
            #                                                         [x.type_of() for x in new_args],
            #                                                         callee.name.text)
            # assert target

            return FunctionCall(
                new_modifiers,
                new_args,
                new_base,
                Ident(callee.name.text)
            )
        elif isinstance(callee, solnodes1.New):
            if isinstance(callee.type_name, (solnodes1.ArrayType, solnodes1.StringType)):
                # 'new bytes(0)' -> CreateMemoryArray(ttype = FixedLengthArrayType(ttype=ByteType, size=32), size=Literal(0))
                # Note, I've also seen 'new string(len)' , this seems to be valid as strings are arrays of bytes. This is
                # made valid by StringType being a subtype of ArrayType
                assert_simple_call()
                size_expr = self.refine_expr(expr.args[0])
                return CreateMemoryArray(self.map_type(callee.type_name), size_expr)
            # SELF NOTE: don't pass the type_name to refine expr on a whim, it can resolve to too many things
        elif isinstance(callee, (solnodes1.ArrayType, solnodes1.StringType, solnodes1.IntType)):
            assert_simple_call()
            # E.g. 'bytes32(0)' -> Cast(ttype = FixedLengthArrayType(ttype=ByteType, size=32), size=Literal(0))
            # E.g. 'bytes(baseURI)'
            return Cast(self.map_type(callee), new_args[0])

        self._todo(expr)

    ASSIGN_TO_OP = {
        solnodes1.BinaryOpCode.ASSIGN: solnodes1.BinaryOpCode.ASSIGN,
        solnodes1.BinaryOpCode.ASSIGN_OR: solnodes1.BinaryOpCode.BIT_OR,
        solnodes1.BinaryOpCode.ASSIGN_BIT_NEG: solnodes1.BinaryOpCode.BIT_XOR,
        solnodes1.BinaryOpCode.ASSIGN_BIT_AND: solnodes1.BinaryOpCode.BIT_AND,
        solnodes1.BinaryOpCode.ASSIGN_LSHIFT: solnodes1.BinaryOpCode.LSHIFT,
        solnodes1.BinaryOpCode.ASSIGN_RSHIFT: solnodes1.BinaryOpCode.RSHIFT,
        solnodes1.BinaryOpCode.ASSIGN_ADD: solnodes1.BinaryOpCode.ADD,
        solnodes1.BinaryOpCode.ASSIGN_SUB: solnodes1.BinaryOpCode.SUB,
        solnodes1.BinaryOpCode.ASSIGN_MUL: solnodes1.BinaryOpCode.MUL,
        solnodes1.BinaryOpCode.ASSIGN_DIV: solnodes1.BinaryOpCode.DIV,
        solnodes1.BinaryOpCode.ASSIGN_MOD: solnodes1.BinaryOpCode.MOD
    }

    def any_or_all(self, args):
        return all(args) == any(args)

    def refine_expr(self, expr: solnodes1.Expr):
        if isinstance(expr, solnodes1.UnaryOp):
            return UnaryOp(self.refine_expr(expr.expr), expr.op, expr.is_pre)
        elif isinstance(expr, solnodes1.BinaryOp):
            left = self.refine_expr(expr.left)
            right = self.refine_expr(expr.right)

            if expr.op in self.ASSIGN_TO_OP:
                # this is an assign, make sure the lhs is a valid assignment target.
                # if the OP does some other mathematical operation then split the rhs into a load lhs + rhs
                assert isinstance(left, (StateVarLoad, LocalVarLoad, ArrayLoad))

                if expr.op != solnodes1.BinaryOpCode.ASSIGN:
                    value = BinaryOp(left, right, self.ASSIGN_TO_OP[expr.op])
                else:
                    value = right

                if isinstance(left, StateVarLoad):
                    return StateVarStore(left.base, left.name, value)
                elif isinstance(left, ArrayLoad):
                    return ArrayStore(left.base, left.index, value)
                else:
                    return LocalVarStore(left.var, value)
            else:
                return BinaryOp(left, right, expr.op)
        elif isinstance(expr, solnodes1.Ident):
            # We should only reach this if this Ident is a reference to a variable load. This shouldn't be
            # hit when resolving other uses of Idents

            if expr.text == 'this':
                return self.get_self_object(expr)
            elif expr.text == '_':
                # NOTE: we return a Stmt here instead of an Expr. In a later pass, ExprStmt(ExecModifiedCode)
                # gets reduced to just ExecModifiedCode in place of ExprStmt
                return ExecModifiedCode()

            ident_symbol = expr.scope.find_single(expr.text)
            assert ident_symbol  # must be resolved to something

            ident_target = ident_symbol.value  # the AST1 node that this Ident is referring to

            if isinstance(ident_target, solnodes1.StateVariableDeclaration):
                # i.e. Say we are in contract C and ident is 'x', check that 'x' is declared in C
                # this is so that we know the 'base' of this load will be 'self'
                ast1_current_contract = self.get_declaring_contract(expr)
                var_declaring_contract = self.get_declaring_contract(ident_target)

                assert ast1_current_contract is var_declaring_contract

                contract_type: ResolvedUserType = self.get_contract_type(ast1_current_contract)

                return StateVarLoad(SelfObject(contract_type.value), Ident(expr.text))
            elif isinstance(ident_target, (solnodes1.Parameter, solnodes1.Var)):
                return LocalVarLoad(self.var(ident_target))
            else:
                self._todo(ident_target)
        elif isinstance(expr, solnodes1.CallFunction):
            return self.refine_call_function(expr)
        elif isinstance(expr, solnodes1.GetMember):
            base = expr.obj_base

            if expr.name.text == 'selector':
                # the selector is a bytes4 ABI function selector
                assert isinstance(base, solnodes1.GetMember)

                return ABISelector(None)

            if isinstance(base, solnodes1.Ident):
                if base.text == 'msg':
                    if expr.name.text == 'value':
                        return BuiltInValue('msg.value', UIntType())
                    elif expr.name.text == 'gas':
                        return BuiltInValue('msg.gas', UIntType())
                    elif expr.name.text == 'sender':
                        return BuiltInValue('msg.sender', AddressType(False))
                    elif expr.name.text == 'data':
                        return BuiltInValue('msg.data', ArrayType(ByteType()))
                    elif expr.name.text == 'sig':
                        return BuiltInValue('msg.sig', FixedLengthArrayType(UIntType()))

                # MyEnum.MYVALUE, don't want to pass Ident(text='MyEnum') to refine_expr as it's not an Expr that can
                # be loaded as a base itself
                target_symbols = base.scope.find(base.text)
                if len(target_symbols) == 1 and isinstance(target_symbols[0], symtab.EnumScope):
                    return EnumMemberLoad(self.get_contract_type(target_symbols[0]), Ident(expr.name.text))

            # this is assumed to be a field load only, i.e. x.y (in AST1 x.y would be a child of a FunctionCall
            # so x.y() should be a FunctionCall instead of the child of a FC)
            new_base = self.refine_expr(base)
            return StateVarLoad(new_base, expr.name.text)
        elif isinstance(expr, solnodes1.Literal):
            if isinstance(expr.value, tuple):
                assert not expr.unit
                # the grammar has 'TupleExpression' s, e.g. '(' exprList ')'. The exprs it allows can also be types.
                # Either all or none of the exprs must be types
                type_args = [isinstance(arg, solnodes1.Type) for arg in expr.value]
                assert self.any_or_all(type_args)

                if any(type_args):
                    return TypeLiteral(TupleType([self.map_type(t) for t in expr.value]))
                elif len(expr.value) == 1:
                    # Bracketed expressions, not tuples, e.g. (x).y() , (x) isn't a tuple so unpack here
                    assert isinstance(expr.value[0], solnodes1.Expr)
                    return self.refine_expr(expr.value[0])
                else:
                    # Actual tuple but tuples aren't part of solidity properly, they are just syntactic sugar
                    # e.g. for returning multiple values or unpacking calls that return multiple values. So check
                    # that the parent is a return and as a special case to function, we return a list of the values
                    # instead of an Expr type. The parent case for Return can handle returning a list as well
                    assert isinstance(expr.parent, solnodes1.Return)
                    return [self.refine_expr(e) for e in expr.value]
            elif isinstance(expr.value, solnodes1.Type):
                self._todo(expr)
            else:
                assert not isinstance(expr.value, solnodes1.Expr)
                return Literal(expr.value, self.literal_type(expr.value), expr.unit)
        elif isinstance(expr, solnodes1.GetArrayValue):
            return ArrayLoad(self.refine_expr(expr.array_base), self.refine_expr(expr.index))
        elif isinstance(expr, solnodes1.PayableConversion):
            # address payable cast
            assert len(expr.args) == 1
            return Cast(AddressType(True), self.refine_expr(expr.args[0]))
        elif isinstance(expr, solnodes1.CreateMetaType):
            return GetType(self.map_type(expr.base_type))
        elif isinstance(expr, solnodes1.TernaryOp):
            return TernaryOp(self.refine_expr(expr.condition), self.refine_expr(expr.left), self.refine_expr(expr.right))
        self._todo(expr)

    def literal_type(self, value):
        if isinstance(value, int):
            return UIntType()
        elif isinstance(value, str):
            return StringType()
        return self._todo(value)


    def find_method(self, possible_matches: List[symtab.Symbol], arg_types: List[Type]):
        # base_type: Type = base.type_of()
        #
        # if not base_type:
        #     self._todo(base)
        #
        # # FIXME: this is wrong, don't lookup with str
        # base_type_name: str = str(base_type)
        # base_scope: symtab.Scope = scope.find_single(base_type_name)
        # possible_matches: List[symtab.Symbol] = base_scope.find(name, find_base_symbol=False)

        def check_arg_types(s: symtab.Symbol) -> bool:
            def get_arg_types(func_scope: symtab.ModFunErrEvtScope):
                assert isinstance(func_scope, symtab.ModFunErrEvtScope)
                return [self.map_type(p.var_type) for p in func_scope.value.parameters]

            if isinstance(s, symtab.UsingFunctionSymbol):
                # Consider the expression x.sub(y) where x and y are vars of type 'int256' and there's a Using directive
                # that's added the 'sub' method to the int256 type. This UsingFunctionSymbol points to a function
                # 'sub (int256, int256)' but the actual function call in the expression takes 1 parameter. If we just
                # parse the expression for the argument types we would only have [unit256] for 'y' but the actual
                # method we want to find has [int256, int256].

                # resolved symbol is the function scope
                target_param_types = get_arg_types(s.resolve_base_symbol())
                actual_param_types = [self.map_type(s.override_type)] + arg_types
            else:
                assert isinstance(s, symtab.ModFunErrEvtScope)
                # In Solidity x.sub(y) is only valid with a Using declaration, so we check the actual parameter type
                # lists supplied.
                target_param_types = get_arg_types(s)
                actual_param_types = arg_types

            return len(target_param_types) == len(actual_param_types)

        actual_matches = [x for x in possible_matches if check_arg_types(x)]

        assert len(actual_matches) == 1, 'Invalid resolve'
        assert isinstance(actual_matches[0].value, solnodes1.FunctionDefinition)

        return actual_matches[0]

    def var(self, node: Union[solnodes1.Var, solnodes1.Parameter]):
        location = None
        if node.var_loc:
            location = Location(node.var_loc.name.lower())

        # Solidity allowed unnamed parameters apparently...
        # function sgReceive(uint16 /*_chainId*/, bytes memory /*_srcAddress*/, uint /*_nonce*/, address _token,
        # uint amountLD, bytes memory payload) override external {
        name = None
        if node.var_name:
            name = node.var_name.text

        return Var(
            Ident(name),
            self.map_type(node.var_type),
            location
        )

    def parameter(self, node: solnodes1.Parameter):
        return Parameter(self.var(node))

    def modifier(self, node: solnodes1.Modifier):
        pass

    def block(self, node: solnodes1.Block):
        if node:
            return Block(
                [self.refine_stmt(s) for s in node.stmts],
                node.is_unchecked
            )
        else:
            return Block([], False)

    def define_skeleton(self, ast1_node: solnodes1.SourceUnit, source_unit_name: str) -> TopLevelUnit:
        """
        Makes a skeleton of the given AST1 node without processing the details. This is required as user types are
        loaded on demand(when they're used in code/parameter lists/declarations, etc). This skeleton is used as a
        reference and then filled in later on. """

        assert not hasattr(ast1_node, 'ast2_node')

        # Source unit name is only used for source units/top level units
        assert bool(source_unit_name) == self.is_top_level(ast1_node)

        def _make_new_node(n):
            if isinstance(n, solnodes1.FunctionDefinition):
                return FunctionDefinition(Ident(str(n.name)), [], [], [], None)

            name = Ident(n.name.text)
            if isinstance(n, solnodes1.ContractDefinition):
                return ContractDefinition(source_unit_name, name, [], [], [], [])
            elif isinstance(n, solnodes1.InterfaceDefinition):
                return InterfaceDefinition(source_unit_name, name, [], [])
            elif isinstance(n, solnodes1.StructDefinition):
                return StructDefinition(source_unit_name, name, [])
            elif isinstance(n, solnodes1.LibraryDefinition):
                return LibraryDefinition(source_unit_name, name, [])
            elif isinstance(n, solnodes1.EnumDefinition):
                return EnumDefinition(source_unit_name, name, [])
            elif isinstance(n, solnodes1.StateVariableDeclaration):
                return StateVariableDeclaration(name, None, [], None)
            elif isinstance(n, solnodes1.EventDefinition):
                return EventDefinition(name, [], None)
            elif isinstance(n, solnodes1.ModifierDefinition):
                return ModifierDefinition(name, [], [], None)
            else:
                self._todo(ast1_node)

        ast2_node = _make_new_node(ast1_node)
        ast1_node.ast2_node = ast2_node

        if hasattr(ast1_node, 'parts'):
            for p in ast1_node.parts:
                if self.is_top_level(p):
                    # these units don't get added as parts in AST2, e.g. an embedded contract B in parent contract A
                    # gets loaded as a separate ContractDefinition with the name as A$B
                    self.load_if_required(p.scope)
                elif not isinstance(p, (solnodes1.UsingDirective, solnodes1.PragmaDirective)):
                    # don't need usings or pragmas for AST2
                    ast2_node.parts.append(self.define_skeleton(p, None))

        if self.is_top_level(ast1_node):
            self.to_process.append(ast1_node)

        return ast2_node

    def refine_unit_or_part(self, ast1_node: solnodes1.SourceUnit):
        if not isinstance(ast1_node, (solnodes1.ContractDefinition, solnodes1.InterfaceDefinition,
                                      solnodes1.StructDefinition, solnodes1.LibraryDefinition,
                                      solnodes1.EnumDefinition,
                                      solnodes1.FunctionDefinition, solnodes1.EventDefinition,
                                      solnodes1.StateVariableDeclaration, solnodes1.ModifierDefinition)):
            raise ValueError('x')
            
        ast2_node = ast1_node.ast2_node

        if hasattr(ast2_node, 'refined') and ast2_node.refined:
            return

        if self.is_top_level(ast1_node):
            if isinstance(ast1_node, solnodes1.ContractDefinition):
                ast2_node.is_abstract = ast1_node.is_abstract

            # contracts, interfaces
            if hasattr(ast1_node, 'inherits'):
                ast2_node.inherits = [
                    InheritSpecifier(self.get_user_type(x.name), [self.refine_expr(arg) for arg in x.args])
                    for x in ast1_node.inherits
                ]

            # contracts, interfaces, libraries
            if hasattr(ast1_node, 'parts'):
                for part in ast1_node.parts:
                    if isinstance(part, solnodes1.UsingDirective):
                        # Not sure if things other than contracts can have usings, if this should errors, we can investigate
                        library_scope = part.scope.find_single(part.library_name.text)
                        assert isinstance(library_scope.value, solnodes1.LibraryDefinition)
                        library = self.get_contract_type(part.scope.find_single(part.library_name.text))
                        ast2_node.type_overrides.append(LibraryOverride(self.map_type(part.override_type), library))

                    if hasattr(part, 'ast2_node'):
                        self.refine_unit_or_part(part)

            # structs
            if hasattr(ast1_node, 'members'):
                ast2_node.members = [StructMember(self.map_type(x.member_type), Ident(x.name.text)) for x in
                                     ast1_node.members]

            # enums
            if hasattr(ast1_node, 'values'):
                ast2_node.values = [Ident(n.text) for n in ast1_node.values]

        if isinstance(ast1_node, solnodes1.FunctionDefinition):
            ast2_node.inputs = [self.parameter(x) for x in ast1_node.parameters]
            ast2_node.outputs = [self.parameter(x) for x in ast1_node.returns]
            ast2_node.modifiers = [self.modifier(x) for x in ast1_node.modifiers]
            ast2_node.code = self.block(ast1_node.code) if ast1_node.code else None
            ast2_node.refined = True
            return ast2_node

        if isinstance(ast1_node, solnodes1.StateVariableDeclaration):
            ast2_node.ttype = self.map_type(ast1_node.var_type)
            ast2_node.modifiers = [self.modifier(x) for x in ast1_node.modifiers]
            ast2_node.value = self.refine_expr(ast1_node.initial_value) if ast1_node.initial_value else None
            ast2_node.refined = True
            return ast2_node

        if isinstance(ast1_node, solnodes1.EventDefinition):
            ast2_node.inputs = [EventParameter(Ident(p.name.text), self.map_type(p.var_type), p.is_indexed)
                                for p in ast1_node.parameters]
            ast2_node.is_anonymous = ast1_node.is_anonymous
            ast2_node.refined = True
            return ast2_node

        if isinstance(ast1_node, solnodes1.ModifierDefinition):
            ast2_node.inputs = [self.parameter(x) for x in ast1_node.parameters]
            ast2_node.modifiers = [self.modifier(x) for x in ast1_node.modifiers]
            ast2_node.code = self.block(ast1_node.code) if ast1_node.code else None
            ast2_node.refined = True
            return ast2_node

        ast2_node.refined = True
        return None

    def is_top_level(self, node: solnodes1.Node):
        # FunctionDefinitions are set as SourceUnits in AST1 but not in AST2
        return isinstance(node, solnodes1.SourceUnit) and not isinstance(node, solnodes1.FunctionDefinition)
