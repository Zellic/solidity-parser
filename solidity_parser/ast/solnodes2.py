from dataclasses import dataclass, field
from enum import Enum
from typing import List, Any, Union, Optional, Dict
from abc import ABC, abstractmethod

from solidity_parser.ast import solnodes as solnodes1
from solidity_parser.ast import symtab


@dataclass
class Node:
    parent: 'Node' = field(init=False, repr=False, hash=False, compare=False)

    def get_children(self):
        for val in vars(self).values():
            if isinstance(val, Node):
                yield val
            elif isinstance(val, list):
                yield from [v for v in val if isinstance(v, Node)]

    def get_all_children(self):
        for direct_child in self.get_children():
            yield direct_child
            yield from direct_child.get_all_children()

    def __post_init__(self):
        for child in self.get_children():
            child.parent = self


class Type(Node):
    pass

class Stmt(Node):
    pass


class Expr(Node):
    def type_of(self) -> Type:
        pass



@dataclass
class Block(Stmt):
    stmts: List[Stmt]
    is_unchecked: bool



@dataclass
class Ident(Node):
    text: str


class TopLevelUnit(Node):
    pass



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

class BoolType(Type):
    """ Solidity native boolean type"""

    def __str__(self): return "bool"


class StringType(Type):
    """ Solidity native string type"""

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
    value: TopLevelUnit


class ContractPart(Node):
    pass


@dataclass
class InheritSpecifier(Node):
    name: ResolvedUserType
    args: List[Expr]


@dataclass
class ContractDefinition(TopLevelUnit):
    name: Ident
    is_abstract: bool
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]


@dataclass
class InterfaceDefinition(TopLevelUnit):
    name: Ident
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]


@dataclass
class StructMember(Node):
    ttype: Type
    name: Ident


@dataclass
class StructDefinition(TopLevelUnit):
    name: Ident
    members: List[StructMember]


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


class Modifier(Node):
    pass


@dataclass
class FunctionDefinition(ContractPart):
    name: Ident
    inputs: List[Parameter]
    outputs: List[Parameter]
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
class ExprStmt(Stmt):
    expr: Expr


@dataclass
class Literal(Expr):
    value: Any
    unit: solnodes1.Unit = None


@dataclass
class BinaryOp(Expr):
    """ Binary/two operand expression """
    left: Expr
    right: Expr
    op: solnodes1.BinaryOpCode


@dataclass
class SelfObject(Expr):
    declarer: Union[ContractDefinition, InterfaceDefinition]


@dataclass
class StateVarLoad(Expr):
    base: Expr
    name: Ident


@dataclass
class LocalVarLoad(Expr):
    var: Var

    def type_of(self) -> Type:
        return self.var.ttype


@dataclass
class FieldVarLoad(Expr):
    obj_base: Expr
    name: Ident


@dataclass
class ArrayLoad(Expr):
    base: Expr
    index: Expr


@dataclass
class BuiltInValue(Expr):
    name: str
    ttype: Type

    def type_of(self) -> Type:
        return self.ttype


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


class TypeHelper:
    def __init__(self, builder):
        self.builder = builder

    def find_field(self, ttype: Type, name: str) -> FunctionDefinition:
        pass

class Builder:

    def __init__(self):
        self.user_types: Dict[str, ContractDefinition] = {}

    def get_contract_type(self, ast1_node: solnodes1.SourceUnit, name: str = None) -> ResolvedUserType:
        if isinstance(ast1_node,
                      (solnodes1.ContractDefinition, solnodes1.InterfaceDefinition, solnodes1.StructDefinition)):

            if name is not None:
                assert name == ast1_node.name.text
            else:
                name = ast1_node.name.text

            if name in self.user_types:
                ast2_node = self.user_types[name]
            else:
                ast2_node = self.refine_top_level_node(ast1_node)
                self.user_types[name] = ast2_node

            return ResolvedUserType(ast2_node)
        else:
            raise ValueError(f"Invalid user type resolve: {type(ast1_node)}")

    def get_user_type(self, ttype: solnodes1.UserType):
        """Maps an AST1 UserType to AST2 ResolvedUserType"""
        name = ttype.name.text
        s = ttype.scope.find(name)

        if not s:
            raise ValueError(f"Can't resolve {ttype}")

        if len(s) != 1:
            raise ValueError(f"Too many symbols for {ttype}: {s}")

        return self.get_contract_type(s[0].value)

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

        self._todo(node)


    def get_declaring_contract(self, node: solnodes1.Node) -> symtab.ContractOrInterfaceScope:
        return node.scope.find_first_ancestor_of(symtab.ContractOrInterfaceScope)

    def refine_call_function(self, expr):
        # solnodes1.CallFunction is very confusing because the grammar allows basically any expression into it and
        # doesn't parse the name of the function call as a separate entity. So we have to do our own analysis
        # of expr.callee to figure out wtf was accepted by the parser
        callee = expr.callee

        new_args = [self.refine_expr(x) for x in expr.args]

        if isinstance(callee, solnodes1.Ident):
            if callee.text == 'require':
                return RequireExpr(
                    [self.modifier(x) for x in expr.modifiers],
                    new_args
                )
            else:
                # cast?
                ident_target_symbol = expr.scope.find_single(callee.text)
                assert isinstance(ident_target_symbol, symtab.ContractOrInterfaceScope)
                assert len(new_args) == 1
                return Cast(self.get_contract_type(ident_target_symbol.value), new_args[0])
        elif isinstance(callee, solnodes1.AddressType):
            # address(my_obj) but we treat it as a Cast expr type instead of its own separate node
            assert len(new_args) == 1
            return Cast(self.map_type(callee), new_args[0])
        elif isinstance(callee, solnodes1.GetMember):
            base = callee.obj_base
            if isinstance(base, solnodes1.GetMember):
                new_base = self.refine_expr(base)
            elif isinstance(base, solnodes1.CallFunction):
                new_base = self.refine_expr(base)
            elif isinstance(base, solnodes1.Ident):
                if base.text == 'abi':
                    if callee.name.text == 'encode' or callee.name.text == 'encodePacked':
                        return BuiltInCall(
                            [self.modifier(x) for x in expr.modifiers],
                            new_args,
                            f'abi.{callee.name.text}',
                            ArrayType(ByteType())
                        )
                    elif callee.name.text == 'decode':
                        return BuiltInCall(
                            [self.modifier(x) for x in expr.modifiers],
                            new_args,
                            f'abi.{callee.name.text}',
                            None
                        )
                else:
                    ident_symbol = expr.scope.find_single(base.text)
                    target_symbol = ident_symbol.find_single(callee.name.text)
                    assert isinstance(target_symbol, symtab.StructScope)
                    return CreateStruct(self.get_contract_type(target_symbol.value), new_args)
            else:
                # This is here so that I can stop on each pattern, the above creation of new_base are approved patterns
                self._todo(expr)

            # Check to see if the call resolves to something and if so create a FunctionCall

            # target: solnodes1.FunctionDefinition = self.find_method(expr.scope, new_base,
            #                                                         [x.type_of() for x in new_args],
            #                                                         callee.name.text)
            # assert target

            return FunctionCall(
                [self.modifier(x) for x in expr.modifiers],
                new_args,
                new_base,
                Ident(callee.name.text)
            )
        elif isinstance(callee, solnodes1.New):
            if isinstance(callee.type_name, solnodes1.ArrayType):
                assert len(expr.modifiers) == 0
                assert len(expr.args) == 1
                size_expr = self.refine_expr(expr.args[0])
                assert isinstance(size_expr, Literal)
                return CreateMemoryArray(self.map_type(callee.type_name), size_expr)
            # SELF NOTE: don't pass the type name to refine expr on a whim, it can resolve to too many things

        self._todo(expr)

    def refine_expr(self, expr: solnodes1.Expr):
        if isinstance(expr, solnodes1.BinaryOp):
            return BinaryOp(self.refine_expr(expr.left), self.refine_expr(expr.right), expr.op)
        elif isinstance(expr, solnodes1.Ident):
            # We should only reach this if this Ident is a reference to a variable load. This shouldn't be
            # hit when resolving other uses of Idents

            if expr.text == 'this':
                return SelfObject(self.get_declaring_contract(expr).value)

            ident_symbol = expr.scope.find_single(expr.text)
            assert ident_symbol  # must be resolved to something

            ident_target = ident_symbol.value  # the AST1 node that this Ident is referring to

            if isinstance(ident_target, solnodes1.StateVariableDeclaration):
                # i.e. Say we are in contract C and ident is 'x', check that 'x' is declared in C
                # this is so that we know the 'base' of this load will be 'self'
                current_contract = self.get_declaring_contract(expr)
                var_declaring_contract = self.get_declaring_contract(ident_target)

                assert current_contract is var_declaring_contract

                return StateVarLoad(SelfObject(current_contract.value), Ident(expr.text))
            elif isinstance(ident_target, (solnodes1.Parameter, solnodes1.Var)):
                return LocalVarLoad(self.var(ident_target))
            else:
                self._todo(ident_target)
        elif isinstance(expr, solnodes1.CallFunction):
            return self.refine_call_function(expr)
        elif isinstance(expr, solnodes1.GetMember):
            base = expr.obj_base
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
            else:
                # this is assumed to be a field load only, i.e. x.y (in AST1 x.y would be a child of a FunctionCall
                # so x.y() should be a FunctionCall instead of the child of a FC)
                new_base = self.refine_expr(base)
                pass

        elif isinstance(expr, solnodes1.Literal):
            return Literal(expr.value, expr.unit)
        elif isinstance(expr, solnodes1.GetArrayValue):
            return ArrayLoad(self.refine_expr(expr.array_base), self.refine_expr(expr.index))
        elif isinstance(expr, solnodes1.PayableConversion):
            # address payable cast
            assert len(expr.args) == 1
            return Cast(AddressType(True), self.refine_expr(expr.args[0]))
        self._todo(expr)

    def find_method(self, scope: symtab.Scope, base: Expr, arg_types: List[Type], name: str):
        base_type: Type = base.type_of()

        if not base_type:
            self._todo(base)

        # FIXME: this is wrong, don't lookup with str
        base_type_name: str = str(base_type)
        base_scope: symtab.Scope = scope.find_single(base_type_name)
        possible_matches: List[symtab.Symbol] = base_scope.find(name, find_base_symbol=False)

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

            # TODO: subtyping matching
            return target_param_types == actual_param_types

        actual_matches = [x for x in possible_matches if check_arg_types(x)]

        assert len(actual_matches) == 1, 'Invalid resolve'
        assert isinstance(actual_matches[0].value, solnodes1.FunctionDefinition)

        return actual_matches[0].value

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

    def refine_contract_part(self, part: solnodes1.ContractPart):
        if isinstance(part, solnodes1.FunctionDefinition):
            return FunctionDefinition(
                Ident(str(part.name)),
                [self.parameter(x) for x in part.parameters],
                [self.parameter(x) for x in part.returns],
                [self.modifier(x) for x in part.modifiers],
                self.block(part.code)
            )

    def refine_top_level_node(self, node: solnodes1.SourceUnit):
        if isinstance(node, solnodes1.ContractDefinition):
            return ContractDefinition(
                Ident(node.name.text),
                node.is_abstract,
                [
                    InheritSpecifier(self.get_user_type(x.name), [self.refine_expr(arg) for arg in x.args])
                    for x in node.inherits
                ],
                [self.refine_contract_part(part) for part in node.parts]
            )
        elif isinstance(node, solnodes1.InterfaceDefinition):
            return InterfaceDefinition(
                Ident(node.name.text),
                [
                    InheritSpecifier(self.get_user_type(x.name), [self.refine_expr(arg) for arg in x.args])
                    for x in node.inherits
                ],
                [self.refine_contract_part(part) for part in node.parts]
            )
        elif isinstance(node, solnodes1.StructDefinition):
            return StructDefinition(
                Ident(node.name.text),
                [StructMember(self.map_type(x.member_type), Ident(x.name.text)) for x in node.members]
            )
        else:
            raise ValueError('x')

