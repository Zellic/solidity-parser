import typing
from dataclasses import dataclass, field
from enum import Enum
from typing import Any, Optional
from solidity_parser.ast import nodebase, types as soltypes


@nodebase.NodeDataclass
class AST1Node(nodebase.Node):
    # scope doesn't get included in get_children or hash as long as it's not a subclass of nodebase.Node
    scope: 'Scope' = field(default=None, init=False, repr=False, compare=False, hash=False)
    ast2_node: 'AST2Node' = field(default=None, init=False, repr=False, compare=False, hash=False)


class Stmt(AST1Node):
    pass


class Expr(AST1Node):
    pass


@dataclass
class Ident(Expr):
    """ String identifier node """
    text: str

    def __str__(self): return self.text


class Location(Enum):
    """ Solidity reference type storage locations

    These are used to specify in what type of memory context/area a struct/array/mapping is stored
    """

    MEMORY = 'memory'
    """ An location that does not persist between function calls """

    STORAGE = 'storage'
    """ A location persists between function calls
    
    Contract state variables are stored here also
    """

    CALLDATA = 'calldata'
    """ A location that contains the function call arguments for external function call parameters """

    def __str__(self): return self.value


@dataclass
class NamedArg(Expr):
    """ A name-value pair used for calling functions with options """
    name: Ident
    value: Expr


class Unit(Enum):
    """ Solidity numerical unit types """
    WEI = ('wei', 1)
    GWEI = ('gwei', 1e9)
    SZABO = ('szabo', 1e12)
    FINNEY = ('finney', 1e15)
    ETHER = ('ether', 1e18)
    SECONDS = ('seconds', 1)
    MINUTES = ('minutes', 60)
    HOURS = ('hours', 60*60)
    DAYS = ('days', 24*60*60)
    WEEKS = ('weeks', 7*24*60*60)
    # Take care if you perform calendar calculations using these units, because not every year equals 365 days and not
    # even every day has 24 hours because of leap seconds. Due to the fact that leap seconds cannot be predicted,
    # an exact calendar library has to be updated by an external oracle.
    # The suffix years has been removed in version 0.5.0 due to the reasons above.
    YEARS = ('years', 7*24*60*60*365)

    def __new__(cls, *args, **kwargs):
        obj = object.__new__(cls)
        obj._value_ = args[0]
        return obj

    # ignore the first param since it's already set by __new__
    def __init__(self, _: str, multiplier: int):
        self._multiplier_ = multiplier

    def __str__(self):
        return self.value

    # this makes sure that the multiplier is read-only
    @property
    def multiplier(self) -> int:
        return self._multiplier_


@dataclass
class Literal(Expr):
    """ Constant value expression that can have an optional unit associated with it

    The value may be a python primitive, e.g. an integer, boolean, string, tuple, etc """
    value: Any
    unit: Unit = None

    def code_str(self):
        # shim for symtab to get type_key for ArrayType sizes, this should match the solnodes2.Literal code_str
        if isinstance(self.value, str):
            return f'"{self.value}"'
        else:
            return str(self.value)


class UnaryOpCode(Enum):
    """ Single operand operation types"""
    INC = '++'
    DEC = '--'
    SIGN_POS = '+'
    SIGN_NEG = '-'
    BOOL_NEG = '!'
    BIT_NEG = '~'
    DELETE = 'delete'


@dataclass
class UnaryOp(Expr):
    """ Single operand expression """
    expr: Expr
    op: UnaryOpCode
    is_pre: bool
    """ Whether the operation is pre or post, e.g. ++x or x++ """


class BinaryOpCode(Enum):
    """ Binary/two operand operation types, including assignment types """
    EXPONENTIATE = '**'
    MUL = '*'
    DIV = '/'
    MOD = '%'
    ADD = '+'
    SUB = '-'

    LSHIFT = '<<'
    RSHIFT = '>>'
    BIT_AND = '&'
    BIT_XOR = '^'
    BIT_OR = '|'

    LT = '<'
    GT = '>'
    LTEQ = '<='
    GTEQ = '>='
    EQ = '=='
    NEQ = '!='

    BOOL_AND = '&&'
    BOOL_OR = '||'

    ASSIGN = '='
    ASSIGN_OR = '|='
    ASSIGN_BIT_NEG = '^='
    ASSIGN_BIT_AND = '&='
    ASSIGN_LSHIFT = '<<='
    ASSIGN_RSHIFT = '>>='
    ASSIGN_ADD = '+='
    ASSIGN_SUB = '-='
    ASSIGN_MUL = '*='
    ASSIGN_DIV = '/='
    ASSIGN_MOD = '%='


@dataclass
class BinaryOp(Expr):
    """ Binary/two operand expression """
    left: Expr
    right: Expr
    op: BinaryOpCode


@dataclass
class TernaryOp(Expr):
    """ Choice expression that evaluates the given condition and returns one of the two given expressions

    If the condition evaluates to false then the left expression is returned, otherwise the right one is
    """
    condition: Expr
    left: Expr
    right: Expr


@dataclass
class New(Expr):
    """ New object allocation expression without constructor invocation

    Note that this expression only represents the 'new X' part of a new objects creation 'new X(a,b)'.
    This expression must then be used as the base object in a constructor call to instantiate it.

    """
    type_name: soltypes.Type


@dataclass
class NewInlineArray(Expr):
    """ Solidity 8 inline array creation

    An inline array is one where the elements are explicitly stated in the definition, for example:
    'int[5]   foo2 = [1, 0, 0, 0, 0];'
    """
    elements: list[Expr]


@dataclass
class PayableConversion(Expr):
    """ Converts an address to a payable address

    For example: 'payable(address(myAddressHex))'
    """
    args: list[Expr]


@dataclass
class GetArrayValue(Expr):
    """ Gets the value at the given index from the given array """
    array_base: Expr
    index: Expr


@dataclass
class GetArraySlice(Expr):
    """ Gets a subarray at the given start and end indices from the given array """
    array_base: Expr
    start_index: Expr
    end_index: Expr


@dataclass
class GetMember(Expr):
    """ Gets a member field or method from a given object """
    obj_base: Expr
    name: Ident


@dataclass
class CallFunction(Expr):
    """ Invokes the given callee """
    callee: Expr
    """ This callee is most likely a GetMember expression but can be any callable """
    special_call_options: list[NamedArg]
    """ See https://docs.soliditylang.org/en/v0.8.21/control-structures.html#external-function-calls """
    args: list[Expr]
    """ The actual arguments in the () brackets of the call, may include positional and named arguments """


@dataclass
class Var(AST1Node):
    var_type: soltypes.Type
    var_name: Ident
    var_loc: Optional[Location] = None


@dataclass
class VarDecl(Stmt):
    variables: list[Var]
    value: Expr
    is_lhs_tuple: bool = False


@dataclass
class Parameter(AST1Node):
    var_type: Ident
    var_loc: Location
    var_name: Ident

    def __str__(self):
        return f"{self.var_type} { self.var_loc.value +  ' ' if self.var_loc else ''}{self.var_name if self.var_name else '<unnamed>'}"


@dataclass
class ExprStmt(Stmt):
    expr: Expr


@dataclass
class Block(Stmt):
    stmts: list[Stmt]
    is_unchecked: bool = False


@dataclass
class If(Stmt):
    condition: Expr
    true_branch: Stmt
    false_branch: Stmt


@dataclass
class Catch(Stmt):
    ident: Ident
    parameters: list[Parameter]
    body: Block


@dataclass
class Try(Stmt):
    expr: Expr
    return_parameters: list[Parameter]
    body: Block
    catch_clauses: list[Catch]


@dataclass
class While(Stmt):
    expr: Expr
    body: Stmt


@dataclass
class For(Stmt):
    initialiser: Stmt  # TODO might also be ExprStmt or VarDecl
    condition: Expr
    advancement: Expr
    body: Stmt


@dataclass
class Emit(Stmt):
    call: CallFunction


@dataclass
class Revert(Stmt):
    call: CallFunction


@dataclass
class AssemblyStmt(Stmt):
    # TODO: full assembly code representation
    code: str


@dataclass
class DoWhile(Stmt):
    body: Stmt
    condition: Expr


class Continue(Stmt):
    pass


class Break(Stmt):
    pass


@dataclass
class Return(Stmt):
    value: Expr


@dataclass
class Throw(Stmt):
    pass


@dataclass
class Modifier(AST1Node):
    pass


class VisibilityModifierKind(Enum):
    EXTERNAL = 'external'
    PUBLIC = 'public'
    INTERNAL = 'internal'
    PRIVATE = 'private'
    VIRTUAL = 'virtual'


class MutabilityModifierKind(Enum):
    PURE = 'pure'
    CONSTANT = 'constant'
    VIEW = 'view'
    PAYABLE = 'payable'
    IMMUTABLE = 'immutable'


@dataclass
class VisibilityModifier2(Modifier):
    kind: VisibilityModifierKind


@dataclass
class MutabilityModifier2(Modifier):
    kind: MutabilityModifierKind


@dataclass
class InvocationModifier(Modifier):
    name: Ident
    arguments: list[Expr]


@dataclass
class OverrideSpecifier(Modifier):
    arguments: list[soltypes.UserType]


class SourceUnit(AST1Node):
    pass


@dataclass
class PragmaDirective(SourceUnit):
    name: Ident
    value: str | Expr


@dataclass
class ImportDirective(SourceUnit):
    path: str


@dataclass
class GlobalImportDirective(ImportDirective):
    pass


@dataclass
class UnitImportDirective(ImportDirective):
    alias: Ident


@dataclass
class SymbolAlias(AST1Node):
    symbol: Ident
    alias: Ident


@dataclass
class SymbolImportDirective(ImportDirective):
    aliases: list[SymbolAlias]


@dataclass
class ContractPart(AST1Node):
    pass


class SpecialFunctionKind(Enum):
    CONSTRUCTOR = '<<constructor>>'
    RECEIVE = '<<receive>>'
    FALLBACK = '<<fallback>>'

    def __str__(self):
        return self.value[2:-2]


@dataclass
class FunctionDefinition(SourceUnit, ContractPart):
    name: Ident | SpecialFunctionKind
    parameters: list[Parameter]
    modifiers: list[Modifier]
    returns: list[Parameter]
    code: Block


@dataclass
class ModifierDefinition(ContractPart):
    name: Ident
    parameters: list[Parameter]
    modifiers: list[Modifier]
    code: Block


@dataclass
class StructMember(AST1Node):
    member_type: soltypes.Type
    name: Ident


@dataclass
class StructDefinition(SourceUnit, ContractPart):
    name: Ident
    members: list[StructMember]


@dataclass
class EnumDefinition(SourceUnit, ContractPart):
    name: Ident
    values: list[Ident]


@dataclass
class StateVariableDeclaration(ContractPart):
    var_type: soltypes.Type
    modifiers: list[Modifier]
    name: Ident
    initial_value: Expr


@dataclass
class ConstantVariableDeclaration(SourceUnit):
    var_type: soltypes.Type
    name: Ident
    initial_value: Expr


# TODO: rename with -Definition suffix
@dataclass
class UserValueType(SourceUnit, ContractPart):
    name: Ident
    value: soltypes.Type


@dataclass
class EventParameter(AST1Node):
    var_type: soltypes.Type
    name: Ident
    is_indexed: bool


@dataclass
class EventDefinition(ContractPart):
    name: Ident
    is_anonymous: bool
    parameters: list[EventParameter]


@dataclass
class ErrorParameter(AST1Node):
    var_type: soltypes.Type
    name: Ident


@dataclass
class ErrorDefinition(SourceUnit, ContractPart):
    name: Ident
    parameters: list[ErrorParameter]


@dataclass
class UsingAttachment(AST1Node):
    member_name: Ident


@dataclass
class UsingOperatorBinding(AST1Node):
    member_name: Ident
    operator: UnaryOpCode | BinaryOpCode


@dataclass
class UsingDirective(ContractPart):
    library_name: Ident
    # either override_type or bindings is allowed but not both at the same time
    override_type: soltypes.Type
    attachments_or_bindings: list[UsingAttachment | UsingOperatorBinding] = field(default_factory=list)
    is_global: bool = field(default=False)


@dataclass
class InheritSpecifier(AST1Node):
    name: soltypes.UserType
    args: list[Expr]


@dataclass
class ContractDefinition(SourceUnit):
    name: Ident
    is_abstract: bool
    inherits: list[InheritSpecifier]
    parts: list[ContractPart]


@dataclass
class InterfaceDefinition(SourceUnit):
    name: Ident
    inherits: list[InheritSpecifier]
    parts: list[ContractPart]


@dataclass
class LibraryDefinition(SourceUnit):
    name: Ident
    parts: list[ContractPart]


@dataclass
class CreateMetaType(Expr):
    base_type: soltypes.Type


def has_modifier_kind(node, *kinds: VisibilityModifierKind | MutabilityModifierKind):
    if hasattr(node, 'modifiers'):
        own_kinds = [m.kind for m in node.modifiers if hasattr(m, 'kind')]
        for k in kinds:
            if k in own_kinds:
                return True
    return False


ModFunErrEvt: typing.TypeAlias = ModifierDefinition | FunctionDefinition | ErrorDefinition | EventDefinition


Types: typing.TypeAlias = (soltypes.VariableLengthArrayType | soltypes.VoidType | soltypes.IntType
                           | soltypes.FunctionType | soltypes.ArrayType | soltypes.BytesType | soltypes.BoolType
                           | soltypes.AnyType | soltypes.MappingType | soltypes.UserType | soltypes.StringType
                           | soltypes.FixedLengthArrayType | soltypes.AddressType | soltypes.ByteType)

