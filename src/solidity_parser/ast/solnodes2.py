from abc import ABC
from dataclasses import field
from enum import Enum
from typing import Any, TypeVar, Union as U, TypeAlias
from collections import deque

from solidity_parser.ast import solnodes as solnodes1, types as soltypes, nodebase
from solidity_parser.ast.mro_helper import c3_linearise

from textwrap import indent

T = TypeVar('T')


def raiseNotPrintable():
    raise ValueError('Not a real Solidity element')


def param_def_str(ps):
    def param_out(p):
        v = p.var
        location = (' ' + v.location.value.lower()) if v.location else ''
        name = (' ' + str(v.name)) if v.name else ''
        return f'{v.ttype.code_str()}' + location + name

    return '(' + ', '.join([param_out(p) for p in ps]) + ')'


class AST2Node(nodebase.Node):
    def get_top_level_unit(self) -> 'TopLevelUnit':
        parent = self
        while parent:
            if isinstance(parent, TopLevelUnit):
                return parent
            parent = parent.parent
        raise ValueError('Node has no top level unit')


class Stmt(AST2Node, ABC):
    pass


class Expr(AST2Node, ABC):
    def type_of(self) -> soltypes.Type:
        raise NotImplementedError(f'{type(self)}')


class Modifier(AST2Node, ABC):
    pass


@nodebase.NodeDataclass
class ResolvedUserType(soltypes.Type):
    scope: 'Scope' = field(default=None, init=False, repr=False, compare=False, hash=False)
    # Ref so that we don't set the parent of the TopLevelUnit to this type instance
    value: nodebase.Ref['TopLevelUnit'] = field(repr=False)

    # FIXME: The name of the unit isn't showing in pretty prints for some reason, just outputs ResolvedUserType()

    def __str__(self):
        return f'ResolvedUserType({self.value.x.name.text})'

    def __repr__(self):
        return self.__str__()

    def type_key(self, *args, **kwargs):
        return self.value.x.name.text

    def code_str(self):
        return self.value.x.name.text

    def is_builtin(self) -> bool:
        return False

    def is_user_type(self) -> bool:
        return True

    def can_implicitly_cast_from(self, actual_type: soltypes.Type) -> bool:
        if super().can_implicitly_cast_from(actual_type):
            return True

        if actual_type.is_user_type():
            return actual_type.value.x.is_subttype_of(self.value.x)

        return False

    def get_types_for_declared_type(self) -> list['TopLevelUnit']:
        return [self.value.x] + self.value.x.get_subtypes()


@nodebase.NodeDataclass
class SuperType(soltypes.Type):

    declarer: nodebase.Ref[U['ContractDefinition', 'InterfaceDefinition']] = field(repr=False)

    def is_builtin(self) -> bool:
        return False

    def get_types_for_declared_type(self) -> list['TopLevelUnit']:
        # FIXME: return bases
        return self.declarer.x.get_supers()

    def code_str(self):
        return str(self)

    def __str__(self):
        return f'super({str(self.declarer.x.name)})'


@nodebase.NodeDataclass
class VisibilityModifier(Modifier):
    kind: solnodes1.VisibilityModifierKind

    def code_str(self):
        return str(self.kind.value)


@nodebase.NodeDataclass
class MutabilityModifier(Modifier):
    kind: solnodes1.MutabilityModifierKind

    def code_str(self):
        return str(self.kind.value)


@nodebase.NodeDataclass
class OverrideSpecifier(Modifier):
    bases: list[ResolvedUserType]

    def code_str(self):
        return f'override' + f'({", ".join(b.code_str() for b in self.bases)})' if self.bases else ''


@nodebase.NodeDataclass
class SuperConstructorInvocationModifier(Modifier):
    base_ttype: ResolvedUserType
    inputs: list[Expr]

    def code_str(self):
        return f'{self.base_ttype.code_str()}({", ".join(e.code_str() for e in self.inputs)})'


@nodebase.NodeDataclass
class FunctionInvocationModifier(Modifier):
    modifier: nodebase.Ref['ModifierDefinition']
    inputs: list[Expr]

    def code_str(self):
        return f'{self.modifier.x.name.code_str()}({", ".join(e.code_str() for e in self.inputs)})'


@nodebase.NodeDataclass
class Ident(AST2Node):
    text: str

    def code_str(self):
        return self.text

    def __str__(self):
        return self.text


@nodebase.NodeDataclass
class NamedArgument(AST2Node):
    name: Ident
    expr: Expr

    def code_str(self):
        return f'{self.name.code_str()}: {self.expr.code_str()}'


@nodebase.NodeDataclass
class TopLevelUnit(AST2Node, ABC):
    source_unit_name: str
    name: Ident

    def descriptor(self) -> str:
        return f'{self.source_unit_name}.{self.name.text}'

    def is_subttype_of(self, other_contract: 'TopLevelUnit') -> bool:
        to_check = deque()
        to_check.append(self)

        while to_check:
            next = to_check.popleft()
            if next == other_contract:
                return True
            to_check.extend(next.get_supers())
        return False

    def as_type(self):
        return ResolvedUserType(nodebase.Ref(self))

    def get_supers(self) -> list[U['ContractDefinition', 'InterfaceDefinition']]:
        # c.inherits are the InheritSpecifics
        # s.name is the ResolvedUserType => .value.x is the Contract/InterfaceDefinition
        return [s.name.value.x for s in self.inherits] if hasattr(self, 'inherits') else []

    def get_subtypes(self) -> list[U['ContractDefinition', 'InterfaceDefinition']]:
        return [s.x for s in self._subtypes] if hasattr(self, '_subtypes') else []

    def is_enum(self) -> bool:
        return isinstance(self, EnumDefinition)

    def is_struct(self) -> bool:
        return isinstance(self, StructDefinition)

    def is_contract(self) -> bool:
        return isinstance(self, ContractDefinition)

    def is_interface(self) -> bool:
        return isinstance(self, InterfaceDefinition)

    def is_udvt(self) -> bool:
        return isinstance(self, UserDefinedValueTypeDefinition)

    def find_named_parts(self, name: str, explore_mro: bool, matching_types):
        results = []
        for p in self.parts:
            if p.name.text == name and isinstance(p, matching_types):
                results.append(p)

        if not explore_mro:
            return results

        for super_t in self.get_supers():
            results.extend(super_t.find_named_parts(name, True, matching_types))

        return results


@nodebase.NodeDataclass
class ContractPart(AST2Node, ABC):
    def has_modifier_kind(self, *kinds: solnodes1.VisibilityModifierKind | solnodes1.MutabilityModifierKind):
        return solnodes1.has_modifier_kind(self, *kinds)


@nodebase.NodeDataclass
class InheritSpecifier(AST2Node):
    name: ResolvedUserType
    args: list[Expr]

    def code_str(self):
        return self.name.code_str() + f'({", ".join(e.code_str() for e in self.args)})'


@nodebase.NodeDataclass
class LibraryOverride(AST2Node):
    overriden_type: soltypes.Type
    library: ResolvedUserType


@nodebase.NodeDataclass
class FileDefinition(TopLevelUnit):
    # This is currently only used for ownerless definitions, i.e. contracts/interfaces/etc don't have this as a parent
    # and this isn't created for most processed source files
    scope: 'Scope' = field(default=None, init=False, repr=False, compare=False, hash=False)
    parts: list[ContractPart]

    def descriptor(self) -> str:
        if self.source_unit_name != self.name.text:
            return super().descriptor()
        return f'{self.source_unit_name}'


@nodebase.NodeDataclass
class ContractDefinition(TopLevelUnit):
    is_abstract: bool
    inherits: list[InheritSpecifier]
    parts: list[ContractPart]
    type_overrides: list[LibraryOverride]
    _subtypes: list[nodebase.Ref[U['ContractDefinition', 'InterfaceDefinition']]] = field(default_factory=list, init=False, hash=False, compare=False, repr=False)


@nodebase.NodeDataclass
class InterfaceDefinition(TopLevelUnit):
    inherits: list[InheritSpecifier]
    parts: list[ContractPart]
    type_overrides: list[LibraryOverride]
    _subtypes: list[nodebase.Ref[U['ContractDefinition', 'InterfaceDefinition']]] = field(default_factory=list, init=False, hash=False, compare=False, repr=False)


@nodebase.NodeDataclass
class LibraryDefinition(TopLevelUnit):
    parts: list[ContractPart]
    type_overrides: list[LibraryOverride]


@nodebase.NodeDataclass
class UserDefinedValueTypeDefinition(TopLevelUnit):
    ttype: soltypes.Type


@nodebase.NodeDataclass
class EnumMember(AST2Node):
    name: Ident


@nodebase.NodeDataclass
class EnumDefinition(TopLevelUnit):
    values: list[EnumMember]


@nodebase.NodeDataclass
class StructMember(AST2Node):
    ttype: soltypes.Type
    name: Ident


@nodebase.NodeDataclass
class StructDefinition(TopLevelUnit):
    members: list[StructMember]


@nodebase.NodeDataclass
class ErrorParameter(AST2Node):
    ttype: soltypes.Type
    name: Ident


@nodebase.NodeDataclass
class ErrorDefinition(ContractPart):
    name: Ident
    inputs: list[ErrorParameter]


@nodebase.NodeDataclass
class StateVariableDeclaration(ContractPart):
    name: Ident
    ttype: soltypes.Type
    modifiers: list[Modifier]
    value: Expr


@nodebase.NodeDataclass
class ConstantVariableDeclaration(ContractPart):
    name: Ident
    ttype: soltypes.Type
    value: Expr


@nodebase.NodeDataclass
class EventParameter(AST2Node):
    name: Ident
    ttype: soltypes.Type
    is_indexed: bool


@nodebase.NodeDataclass
class EventDefinition(ContractPart):
    name: Ident
    inputs: list[EventParameter]
    is_anonymous: bool


@nodebase.NodeDataclass
class Location(Enum):
    MEMORY = 'memory'
    STORAGE = 'storage'
    CALLDATA = 'calldata'

    def __str__(self): return self.value


@nodebase.NodeDataclass
class Var(AST2Node):
    name: Ident
    ttype: soltypes.Type
    location: Location

    def code_str(self):
        return raiseNotPrintable()


@nodebase.NodeDataclass
class Parameter(AST2Node):
    var: Var


@nodebase.NodeDataclass
class Block(Stmt):
    stmts: list[Stmt]
    is_unchecked: bool

    def code_str(self, brackets=True):
        INDENT = '  '

        lines = [s.code_str() for s in self.stmts]
        if brackets:
            return ('unchecked ' if self.is_unchecked else '') + '{\n' + indent('\n'.join(lines), INDENT) + '\n}'
        else:
            return indent('\n'.join(lines), INDENT)


@nodebase.NodeDataclass
class If(Stmt):
    condition: Expr
    true_branch: Stmt
    false_branch: Stmt

    def code_str(self):
        def block_str(b):
            if isinstance(b, Block):
                return b.code_str(brackets=False)
            else:
                return b.code_str()

        lines = [
            f'if({self.condition.code_str()}) {{',
            indent(block_str(self.true_branch), '  '),
        ]

        if self.false_branch:
            lines.extend([
                '} else {',
                indent(block_str(self.false_branch), '  '),
            ])

        lines.append('}')

        return '\n'.join(lines)


@nodebase.NodeDataclass
class Catch(Stmt):
    ident: Ident
    parameters: list[Parameter]
    body: Block

    def code_str(self):
        params = ''

        if self.ident:
            # with an error name X, we output X(...ps...)
            params = f' {self.ident.text}'
        elif self.parameters:
            # without error name, just output (...ps...)
            params = ' '

        if self.parameters:
            params += param_def_str(self.parameters)

        lines = [
            f'catch{params} {{',
            indent(self.body.code_str(brackets=False), '  '),
            '}'
        ]
        return '\n'.join(lines)


@nodebase.NodeDataclass
class Try(Stmt):
    expr: Expr
    return_parameters: list[Parameter]
    body: Block
    catch_clauses: list[Catch]

    def code_str(self):
        lines = [
            f'try {self.expr.code_str()} returns {param_def_str(self.return_parameters)} {{',
            indent(self.body.code_str(brackets=False), '  '),
            '}'
        ]

        for catch in self.catch_clauses:
            catch_str = catch.code_str()
            catch_str_lines = catch_str.split('\n')
            # take the first line of the catch_str and append it to the current line
            # this looks like:
            # try ... {
            # ...
            # } catch {
            # ...
            lines[-1] += ' ' + catch_str_lines[0]
            # indent the lines between the brackets
            for c_l in catch_str_lines[1:-1]:
                lines.append(f'  {c_l}')
            # but don't indent the last line with the bracket
            lines.append(catch_str_lines[-1])  # this should just be a '}'

        return '\n'.join(lines)


@nodebase.NodeDataclass
class While(Stmt):
    condition: Expr
    body: Stmt
    is_do_while: bool

    def code_str(self):
        def c_str(b):
            if not b:
                return ''
            if isinstance(b, Block):
                return b.code_str(brackets=False)
            else:
                return b.code_str()

        if self.is_do_while:
            lines = [
                f'do {{',
                indent(c_str(self.body), '  '),
                f'}} while({c_str(self.condition)});'
            ]
        else:
            lines = [
                f'while({c_str(self.condition)}) {{',
                indent(c_str(self.body), '  '),
                '}'
            ]

        return '\n'.join(lines)


@nodebase.NodeDataclass
class For(Stmt):
    initialiser: Stmt
    condition: Expr
    advancement: Expr
    body: Stmt

    def code_str(self):
        def c_str(b):
            if not b:
                return ''
            if isinstance(b, Block):
                return b.code_str(brackets=False)
            else:
                return b.code_str()

        lines = [
            f'for({c_str(self.initialiser)}; {c_str(self.condition)}; {c_str(self.advancement)};) {{',
            indent(c_str(self.body), '  '),
            '}'
        ]

        return '\n'.join(lines)


class FunctionMarker(Enum):
    """ Special function type markers """
    CONSTRUCTOR = 1  # TODO: implement this
    SYNTHETIC_FIELD_GETTER = 2


@nodebase.NodeDataclass
class FunctionDefinition(ContractPart):
    name: Ident
    inputs: list[Parameter]
    outputs: list[Parameter]
    modifiers: list[Modifier]
    code: Block
    markers: list[FunctionMarker]

    @staticmethod
    def param_str(ps) -> str:
        return ', '.join([p.var.ttype.code_str() for p in ps])

    def descriptor(self) -> str:
        parent_descriptor = self.parent.descriptor()
        return f'{parent_descriptor}::{self.name.text}({self.param_str(self.inputs)}) returns ({self.param_str(self.outputs)})'

    def __str__(self):
        return self.descriptor()


@nodebase.NodeDataclass
class BuiltinFunction(AST2Node):
    name: Ident
    inputs: list[Parameter]
    outputs: list[Parameter]


@nodebase.NodeDataclass
class ModifierDefinition(ContractPart):
    name: Ident
    inputs: list[Parameter]
    modifiers: list[Modifier]
    code: Block


@nodebase.NodeDataclass
class TupleVarDecl(Stmt):
    vars: list[Var]
    value: Expr

    def code_str(self):
        rhs = f' = {self.value.code_str()}' if self.value else ''
        vs = [f'{v.ttype.code_str()} {(v.location.value + " ") if v.location else ""}{v.name.text}' for v in self.vars]
        return f'({", ".join(vs)}){rhs}'


@nodebase.NodeDataclass
class VarDecl(Stmt):
    var: Var
    value: Expr

    def code_str(self):
        rhs = f' = {self.value.code_str()}' if self.value else ''
        return f'{self.var.ttype.code_str()} {(self.var.location.value + " ") if self.var.location else ""}{self.var.name.text}{rhs};'


@nodebase.NodeDataclass
class ExprStmt(Stmt):
    expr: Expr

    def code_str(self):
        return f'{self.expr.code_str()};'


@nodebase.NodeDataclass
class Literal(Expr):
    value: Any
    ttype: soltypes.Type
    unit: solnodes1.Unit = None

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        if isinstance(self.value, str):
            return f'"{self.value}"'
        else:
            return str(self.value)


@nodebase.NodeDataclass
class TypeLiteral(Expr):
    ttype: soltypes.Type

    def type_of(self):
        return self.ttype

    def code_str(self):
        return self.ttype.code_str()


@nodebase.NodeDataclass
class UnaryOp(Expr):
    """ Single operand expression """
    expr: Expr
    op: solnodes1.UnaryOpCode
    is_pre: bool

    def type_of(self) -> soltypes.Type:
        expr_ttype = self.expr.type_of()
        if self.op == solnodes1.UnaryOpCode.BOOL_NEG:
            assert expr_ttype.is_bool()
        elif self.op == solnodes1.UnaryOpCode.BIT_NEG:
            assert expr_ttype.is_byte_array() or expr_ttype.is_int()
        elif self.op != solnodes1.UnaryOpCode.DELETE:
            assert expr_ttype.is_int()
        return expr_ttype

    def code_str(self):
        if self.is_pre:
            return f'{str(self.op.value)}{self.expr.code_str()}'
        else:
            return f'{self.expr.code_str()}{str(self.op.value)}'


@nodebase.NodeDataclass
class BinaryOp(Expr):
    left: Expr
    right: Expr
    op: solnodes1.BinaryOpCode

    def type_of(self) -> soltypes.Type:
        if self.op in [solnodes1.BinaryOpCode.BOOL_AND, solnodes1.BinaryOpCode.BOOL_OR, solnodes1.BinaryOpCode.EQ,
                       solnodes1.BinaryOpCode.NEQ]:
            return soltypes.BoolType()
        elif self.op in [solnodes1.BinaryOpCode.LTEQ, solnodes1.BinaryOpCode.LT, solnodes1.BinaryOpCode.GT,
                         solnodes1.BinaryOpCode.GTEQ]:
            return soltypes.BoolType()
        elif self.op in [solnodes1.BinaryOpCode.LSHIFT, solnodes1.BinaryOpCode.RSHIFT]:
            # result of a shift has the type of the left operand (from docs)
            return self.left.type_of()
        elif self.op == solnodes1.BinaryOpCode.EXPONENTIATE:
            # result is type of the base
            return self.left.type_of()
        elif self.op in [solnodes1.BinaryOpCode.MUL, solnodes1.BinaryOpCode.DIV, solnodes1.BinaryOpCode.MOD,
                         solnodes1.BinaryOpCode.ADD, solnodes1.BinaryOpCode.SUB,
                         solnodes1.BinaryOpCode.BIT_AND, solnodes1.BinaryOpCode.BIT_OR,
                         solnodes1.BinaryOpCode.BIT_XOR
                         ]:
            t1 = self.left.type_of()
            t2 = self.right.type_of()
            return t1 if t1.size > t2.size else t2
        else:
            raise ValueError(f'{self.op}')

    def code_str(self):
        return f'{self.left.code_str()} {str(self.op.value)} {self.right.code_str()}'


@nodebase.NodeDataclass
class TernaryOp(Expr):
    condition: Expr
    left: Expr
    right: Expr

    def type_of(self) -> soltypes.Type:
        t1 = self.left.type_of()
        t2 = self.right.type_of()

        assert t1.is_int() == t2.is_int()

        if t1.is_int():
            # if they're both ints, then take the bigger type
            return t1 if t1.size > t2.size else t2
        elif t1.is_string() and t2.is_string():
            # TODO: precise string vs non precise string? precise string(x) vs precise string (y)
            return soltypes.StringType()
        else:
            try:
                assert t1 == t2, f'{t1} vs {t2}'
                return t1
            except AssertionError:
                # t1 = addr payable, t2 = addr
                # TODO: actually we need to check if there is a base type here
                if t2.can_implicitly_cast_from(t1):
                    return t1
                elif t1.can_implicitly_cast_from(t2):
                    return t2
                else:
                    assert False, f'No base type? {t1} vs {t2}'

    def code_str(self):
        return f'{self.condition.code_str()} ? {self.left.code_str()} : {self.right.code_str()}'


@nodebase.NodeDataclass
class SelfObject(Expr):
    declarer: nodebase.Ref[ContractDefinition | InterfaceDefinition] = field(repr=False)

    def type_of(self) -> soltypes.Type:
        return ResolvedUserType(self.declarer)

    def code_str(self):
        return 'this'


@nodebase.NodeDataclass
class SuperObject(Expr):
    ttype: SuperType

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        return 'super'


@nodebase.NodeDataclass
class StateVarLoad(Expr):
    base: Expr
    name: Ident

    def type_of(self) -> soltypes.Type:
        base_type = self.base.type_of()
        assert isinstance(base_type, ResolvedUserType)

        unit = base_type.value.x

        if isinstance(unit, StructDefinition):
            matches = [m for m in unit.members if
                       m.name.text == self.name.text and isinstance(m, StructMember)]
        else:
            matches = unit.find_named_parts(self.name.text, True, StateVariableDeclaration)

        assert len(matches) == 1
        return matches[0].ttype

    def code_str(self):
        return f'{self.base.code_str()}.{self.name.code_str()}'


@nodebase.NodeDataclass
class StaticVarLoad(Expr):
    ttype: ResolvedUserType
    name: Ident

    def type_of(self) -> soltypes.Type:
        unit = self.ttype.value.x
        for p in unit.parts:
            if p.name.text == self.name.text and isinstance(p, (StateVariableDeclaration, ConstantVariableDeclaration)):
                return p.ttype
        raise ValueError(f'No field: {self.code_str()}')

    def code_str(self):
        return f'{self.ttype.code_str()}.{self.name.code_str()}'


@nodebase.NodeDataclass
class EnumLoad(Expr):
    member: nodebase.Ref[EnumMember]

    def type_of(self) -> soltypes.Type:
        # enum members type is its parent type
        return self.member.x.parent.as_type()

    def code_str(self):
        enum_def = self.member.x.parent
        return f'{enum_def.name.code_str()}.{self.member.x.name.code_str()}'


@nodebase.NodeDataclass
class StateVarStore(Expr):
    base: Expr
    name: Ident
    value: Expr

    def type_of(self) -> soltypes.Type:
        return self.value.type_of()

    def state_var(self):
        unit = self.base.type_of().value.x
        matches = unit.find_named_parts(self.name.text, True, StateVariableDeclaration)
        assert len(matches) == 1
        return matches[0]

    def code_str(self):
        return f'{self.base.code_str()}.{self.name.code_str()} = {self.value.code_str()}'


@nodebase.NodeDataclass
class LocalVarLoad(Expr):
    var: Var

    def type_of(self) -> soltypes.Type:
        return self.var.ttype

    def code_str(self):
        return self.var.name.code_str()


@nodebase.NodeDataclass
class LocalVarStore(Expr):
    var: Var
    value: Expr

    def type_of(self) -> soltypes.Type:
        return self.var.ttype

    def code_str(self):
        return f'{self.var.name.text} = {self.value.code_str()}'


@nodebase.NodeDataclass
class ArrayLengthStore(Expr):
    # resizing array length is deprecated since solidity 0.6
    # The expr that loads the array e.g. this.myArray
    base: Expr
    value: Expr

    def type_of(self) -> soltypes.Type:
        return soltypes.UIntType(256)

    def code_str(self):
        raise NotImplementedError()


@nodebase.NodeDataclass
class TupleLoad(Expr):
    base: Expr
    index: int

    def type_of(self) -> soltypes.Type:
        tuple_type = self.base.type_of()
        assert isinstance(tuple_type, soltypes.TupleType)

        assert 0 <= self.index < len(tuple_type.ttypes)

        return tuple_type.ttypes[self.index]

    def code_str(self):
        return f'{self.base.code_str()}[{self.index}]'


@nodebase.NodeDataclass
class ArrayLoad(Expr):
    base: Expr
    index: Expr

    def type_of(self) -> soltypes.Type:
        base_type = self.base.type_of()

        if isinstance(base_type, soltypes.MappingType):
            assert base_type.src.can_implicitly_cast_from(self.index.type_of())
            return base_type.dst
        elif isinstance(base_type, soltypes.ArrayType):
            assert self.index.type_of().is_int()
            return base_type.base_type
        else:
            raise ValueError(f'unknown base type: {base_type}')

    def code_str(self):
        return f'{self.base.code_str()}[{self.index.code_str()}]'


@nodebase.NodeDataclass
class ArrayStore(Expr):
    base: Expr
    index: Expr
    value: Expr

    def type_of(self) -> soltypes.Type:
        return ArrayLoad.type_of(self)

    def code_str(self):
        return f'{self.base.code_str()}[{self.index.code_str()}] = {self.value.code_str()}'


@nodebase.NodeDataclass
class ArraySliceLoad(Expr):
    """ Gets a subarray at the given start and end indices from the given array """
    base: Expr
    start_index: Expr
    end_index: Expr

    def type_of(self) -> soltypes.Type:
        return self.base.type_of()

    def code_str(self):
        start_str = self.start_index.code_str() if self.start_index else ''
        end_str = self.end_index.code_str() if self.end_index else ''
        return f'{self.base.code_str()}[{start_str}:{end_str}]'


@nodebase.NodeDataclass
class CreateInlineArray(Expr):
    """ Solidity 8 inline array creation

    An inline array is one where the elements are explicitly stated in the definition, for example:
    'int[5]   foo2 = [1, 0, 0, 0, 0];'
    """
    elements: list[Expr]

    def type_of(self) -> soltypes.Type:
        arg_types = [arg.type_of() for arg in self.elements]
        are_ints = any([t.is_int() for t in arg_types])

        if are_ints:
            # if any of the elements is signed, the resultant type can't bn unsigned
            # e.g. [-1, 0, 0] can't be uint8[]
            is_signed = any([t.is_signed for t in arg_types])

            max_real_bit_length = 0
            max_total_length = 0

            for t in arg_types:
                max_total_length = max(max_total_length, t.size)
                if t.is_literal_type():
                    max_real_bit_length = max(max_real_bit_length, t.real_bit_length)

            if any([not t.is_literal_type() for t in arg_types]):
                # if there are any non precise ones, the whole thing can't be precise, e.g. [0, 1, this.myInt] can't
                # have a base_type of uint8(1), instead it must be uint(T(this.myInt))
                base_type = soltypes.IntType(is_signed, max_total_length)
            else:
                base_type = soltypes.PreciseIntType(is_signed, max_total_length, max_real_bit_length)

            return soltypes.FixedLengthArrayType(base_type, len(self.elements))

    def code_str(self):
        return f'[{", ".join(e.code_str() for e in self.elements)}]'


@nodebase.NodeDataclass
class MappingLoad(Expr):
    base: Expr
    key: Expr

    def code_str(self):
        return f'{self.base.code_str()}[{self.key.code_str()}]'

    def type_of(self) -> soltypes.Type:
        base_ttype = self.base.type_of()
        return base_ttype.dst


@nodebase.NodeDataclass
class MappingStore(Expr):
    base: Expr
    key: Expr
    value: Expr

    def code_str(self):
        return f'{self.base.code_str()}[{self.key.code_str()}] = {self.value.code_str()}'


@nodebase.NodeDataclass
class GlobalValue(Expr):
    name: str
    ttype: soltypes.Type

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        return self.name


@nodebase.NodeDataclass
class ABISelector(Expr):
    function: nodebase.Ref[FunctionDefinition | ErrorDefinition] | Expr

    def type_of(self) -> soltypes.Type:
        return soltypes.Bytes(4)

    def __str__(self):
        return self.code_str()

    def code_str(self):
        if isinstance(self.function, nodebase.Ref):
            f = self.function.x
            owner_name = f.parent.source_unit_name
            return f'{owner_name}.{f.name.text}.selector'
        else:
            return f'{self.function.code_str()}.selector'


@nodebase.NodeDataclass
class DynamicBuiltInValue(Expr):
    # <base>.name
    name: str
    ttype: soltypes.Type
    base: Expr

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}'


@nodebase.NodeDataclass
class CreateMemoryArray(Expr):
    ttype: soltypes.ArrayType
    size: Expr

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        return f'new {self.ttype.code_str()}[{self.size.code_str()}]'


@nodebase.NodeDataclass
class CreateStruct(Expr):
    ttype: ResolvedUserType
    args: list[Expr]

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        return f'{self.ttype.code_str()}({", ".join(e.code_str() for e in self.args)})'


@nodebase.NodeDataclass
class CreateAndDeployContract(Expr):
    ttype: ResolvedUserType
    named_args: list[NamedArgument]
    args: list[Expr]

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        return f"new {self.ttype.code_str()}" + Call.param_str(self)


@nodebase.NodeDataclass
class Call(Expr, ABC):
    named_args: list[NamedArgument]
    args: list[Expr]

    def check_arg_types(self, f: FunctionDefinition) -> bool:
        f_types = [x.var.ttype for x in f.inputs]
        c_types = [a.type_of() for a in self.args]
        return soltypes.Type.are_matching_types(f_types, c_types)

    def param_str(self):
        return (('{' + ', '.join(e.code_str() for e in self.named_args) + '}') if hasattr(self, 'named_args') and len(
            self.named_args) > 0 else '') + f'({", ".join(e.code_str() for e in self.args)})'


@nodebase.NodeDataclass
class DirectCall(Call):
    ttype: ResolvedUserType
    name: Ident

    def base_type(self):
        return self.ttype

    def resolve_call(self) -> FunctionDefinition:
        unit = self.ttype.value.x
        matching_name_funcs = [p for p in unit.parts if isinstance(p, FunctionDefinition) and p.name.text == self.name.text]
        matching_param_types = [f for f in matching_name_funcs if self.check_arg_types(f)]
        assert len(matching_param_types) == 1
        return matching_param_types[0]

    def type_of(self) -> soltypes.Type:
        target_callee = self.resolve_call()
        if not target_callee.outputs:
            ttype = soltypes.VoidType()
        elif len(target_callee.outputs) > 1:
            # For functions that return multiple values return (t(r1), ... t(rk))
            ttype = soltypes.TupleType([out_param.var.ttype for out_param in target_callee.outputs])
        else:
            ttype = target_callee.outputs[0].var.ttype
        return ttype

    def code_str(self):
        return f'{self.ttype.code_str()}.{self.name.code_str()}{self.param_str()}'

    def __str__(self):
        return f'"{self.code_str()}"'


@nodebase.NodeDataclass
class FunctionCall(Call):
    base: Expr
    name: Ident

    def base_type(self):
        return self.base.type_of()

    def resolve_call(self) -> FunctionDefinition:
        if isinstance(self.base, SuperObject):
            # E.g. super.xyz()
            # First element will be the base type which we don't want to include in the MRO as its super call lookup
            ref_lookup_order = c3_linearise(self.base.type_of().declarer.x)[1:]
        else:
            # e.g. this.xyz() or abc.xyz()
            ref_lookup_order = c3_linearise(self.base.type_of().value.x)

        for unit in ref_lookup_order:
            matching_name_funcs = [p for p in unit.parts if isinstance(p, FunctionDefinition) and p.name.text == self.name.text]
            matching_param_types = [f for f in matching_name_funcs if self.check_arg_types(f)]
            if len(matching_param_types) == 1:
                return matching_param_types[0]
            elif len(matching_param_types) > 1:
                assert False, 'Too many matches'

        raise ValueError('No match')

    def type_of(self) -> soltypes.Type:
        target_callee = self.resolve_call()
        if not target_callee.outputs:
            ttype = soltypes.VoidType()
        elif len(target_callee.outputs) > 1:
            # For functions that return multiple values return (t(r1), ... t(rk))
            ttype = soltypes.TupleType([out_param.var.ttype for out_param in target_callee.outputs])
        else:
            ttype = target_callee.outputs[0].var.ttype
        return ttype

    def code_str(self):
        return f'{self.base.code_str()}.{self.name.code_str()}{self.param_str()}'

    def __str__(self):
        return f'"{self.code_str()}"'


@nodebase.NodeDataclass
class FunctionPointerCall(Call):
    callee: Expr

    def type_of(self) -> soltypes.Type:
        callee_ttype: soltypes.FunctionType = self.callee.type_of()
        output_ttypes = callee_ttype.outputs
        assert len(output_ttypes) > 0

        if not output_ttypes:
            return soltypes.VoidType()
        elif len(output_ttypes) == 1:
            return output_ttypes[0]
        else:
            return soltypes.TupleType(output_ttypes)

    def code_str(self):
        return f'{self.callee.code_str()}{self.param_str()}'


@nodebase.NodeDataclass
class DynamicBuiltInCall(Call):
    ttype: soltypes.Type
    base: Expr | ResolvedUserType
    name: str

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}{self.param_str()}'


@nodebase.NodeDataclass
class BuiltInCall(Call):
    name: str
    ttype: soltypes.Type

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        return f'{self.name}{self.param_str()}'


@nodebase.NodeDataclass
class Cast(Expr):
    ttype: soltypes.Type
    value: Expr

    def type_of(self) -> soltypes.Type:
        return self.ttype

    def code_str(self):
        return f'{self.ttype.code_str()}({self.value.code_str()})'


@nodebase.NodeDataclass
class GetType(Expr):
    # type(MyContract)
    ttype: soltypes.Type

    def type_of(self) -> soltypes.Type:
        return soltypes.MetaTypeType(self.ttype)

    def code_str(self):
        return f'type({self.ttype.code_str()})'


@nodebase.NodeDataclass
class GetFunctionPointer(Expr):
    func: nodebase.Ref[U[FunctionDefinition, ErrorDefinition, EventDefinition, 'BuiltinFunction']]

    def type_of(self) -> soltypes.Type:
        def ts(params):
            return [p.var.ttype for p in params]
        f = self.func.x
        modifiers = f.modifiers if hasattr(f, 'modifiers') else []
        return soltypes.FunctionType(ts(f.inputs), ts(f.outputs), modifiers)

    def code_str(self):
        return f'fptr({self.func.x.parent.descriptor()}::{self.func.x.name.text})'


@nodebase.NodeDataclass
class EmitEvent(Stmt):
    event: nodebase.Ref[EventDefinition]
    args: list[Expr]

    def code_str(self):
        return f'emit {self.event.x.name.text}{Call.param_str(self)}'


@nodebase.NodeDataclass
class Revert(Stmt):
    pass


@nodebase.NodeDataclass
class RevertWithError(Revert):
    error: nodebase.Ref[ErrorDefinition]
    args: list[Expr]

    def code_str(self):
        return f'revert {self.error.x.name.text}({", ".join(e.code_str() for e in self.args)});'


@nodebase.NodeDataclass
class RevertWithReason(Revert):
    reason: Expr

    def code_str(self):
        return f'revert({self.reason.code_str()});'


@nodebase.NodeDataclass
class Require(Stmt):
    condition: Expr
    reason: Expr

    def code_str(self):
        return f'require({self.condition.code_str()}{(", " + self.reason.code_str()) if self.reason else ""})'


@nodebase.NodeDataclass
class Return(Stmt):
    values: list[Expr]

    def code_str(self):
        return f'return {", ".join([v.code_str() for v in self.values])}'


@nodebase.NodeDataclass
class Continue(Stmt):
    def code_str(self):
        return 'continue;'


@nodebase.NodeDataclass
class Break(Stmt):
    def code_str(self):
        return 'break;'


@nodebase.NodeDataclass
class Assembly(Stmt):
    # TODO: full assembly code representation
    code: str

    def code_str(self):
        return f'assembly {{{self.code}}}'


@nodebase.NodeDataclass
class ExecModifiedCode(Stmt):
    # _; statement in modifier code bodies that show where modified function code gets executed
    pass


@nodebase.NodeDataclass
class UnprocessedCode(Stmt):
    error: Exception = field(repr=False, hash=False, compare=False)


Types: TypeAlias = (soltypes.VariableLengthArrayType | soltypes.VoidType | soltypes.IntType
                    | soltypes.FunctionType | soltypes.ArrayType | soltypes.BytesType | soltypes.BoolType
                    | soltypes.AnyType | soltypes.MappingType | soltypes.StringType | soltypes.AddressType
                    | soltypes.FixedLengthArrayType | soltypes.ByteType | soltypes.MetaTypeType
                    | soltypes.TupleType | soltypes.PreciseIntType | soltypes.PreciseIntType
                    | soltypes.BuiltinType | ResolvedUserType | SuperType | soltypes.FloatType)
