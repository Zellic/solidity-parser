from dataclasses import dataclass
from enum import Enum
from typing import List, Any, Union


class Node:
    pass


@dataclass
class Ident(Node):
    text: str


class Location(Enum):
    MEMORY = 'memory'
    STORAGE = 'storage'
    CALLDATA = 'calldata'


class Stmt(Node):
    pass


class Expr(Node):
    pass


@dataclass
class NamedArg(Expr):
    name: Ident
    value: Expr


############## EXPRS ####################

class Unit(Enum):
    GWEI = 'gwei'
    WEI = 'wei'
    SZABO = 'szabo'
    FINNEY = 'finney'
    ETHER = 'ether'
    SECONDS = 'seconds'
    MINUTES = 'minutes'
    HOURS = 'hours'
    DAYS = 'days'
    WEEKS = 'weeks'
    YEARS = 'years'


@dataclass
class Literal(Expr):
    value: Any
    unit: Unit = None


class UnaryOpCode(Enum):
    INC = '++'
    DEC = '--'
    SIGN_POS = '+'
    SIGN_NEG = '-'
    BOOL_NEG = '!'
    BIT_NEG = '~'
    DELETE = 'delete'


@dataclass
class UnaryOp(Expr):  # var++
    expr: Expr
    op: UnaryOpCode
    is_pre: bool  # pre or post


class BinaryOpCode(Enum):
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
    left: Expr
    right: Expr
    op: BinaryOpCode


@dataclass
class TernaryOp(Expr):
    condition: Expr
    left: Expr
    right: Expr


@dataclass
class New(Expr):  # new X
    type_name: Ident


@dataclass
class NewInlineArray(Expr):
    elements: List[Expr]


@dataclass
class PayableConversion(Expr):
    args: List[Expr]


@dataclass
class GetArrayValue(Expr):
    array_base: Expr
    index: Expr


@dataclass
class GetArraySlice(Expr):
    array_base: Expr
    start_index: Expr
    end_index: Expr


@dataclass
class GetMember(Expr):
    obj_base: Expr
    name: Ident


@dataclass
class CallFunction(Expr):
    callee: Expr
    modifiers: List
    args: List[Expr]
#########################################


@dataclass
class Var(Node):
    var_type: Ident
    var_loc: Location
    var_name: Ident


@dataclass
class VarDecl(Stmt):
    variables: List[Var]
    value: Expr


@dataclass
class Parameter(Node):
    var_type: Ident
    var_loc: Location
    var_name: Ident


@dataclass
class ExprStmt(Stmt):
    expr: Expr


@dataclass
class Block(Stmt):
    stmts: List[Stmt]
    is_unchecked: bool = False


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


class Throw(Stmt):
    pass


#### Types

class Type:
    pass


class InferredType(Type):
    # represents a type in the code that wasn't explicitly identified and is meant to be inferred
    pass


@dataclass
class UserType(Type):
    name: Ident


@dataclass
class ArrayType:
    base_type: Type


@dataclass
class FixedLengthArrayType(ArrayType):
    size: int


@dataclass
class VariableLengthArrayType(ArrayType):
    size: Expr


@dataclass
class AddressType(Type):
    is_payable: bool


@dataclass
class ByteType(Type):
    pass


@dataclass
class IntType(Type):
    is_signed: bool
    size: int


class BoolType(Type):
    pass


class StringType(Type):
    pass


class VarType(Type):
    pass


class AnyType(Type):
    pass


@dataclass
class MappingType(Type):
    src: Type
    dst: Type


class Modifier:
    pass


class VisibilityModifier(Modifier, Enum):
    EXTERNAL = 'external'
    PUBLIC = 'public'
    INTERNAL = 'internal'
    PRIVATE = 'private'
    VIRTUAL = 'virtual'


class MutabilityModifier(Modifier, Enum):
    PURE = 'pure'
    CONSTANT = 'constant'
    VIEW = 'view'
    PAYABLE = 'payable'
    IMMUTABLE = 'immutable'


@dataclass
class InvocationModifier(Modifier):
    name: Ident
    arguments: List[Expr]


@dataclass
class OverrideSpecifier(Modifier):
    arguments: List[UserType]


@dataclass
class FunctionType(Type):
    parameters: List[Parameter]
    modifiers: List[Modifier]
    return_parameters: List[Parameter]


class SourceUnit(Node):
    pass


@dataclass
class PragmaDirective(SourceUnit):
    name: str
    value: Union[str, Expr]


@dataclass
class ImportDirective(SourceUnit):
    path: str


@dataclass
class UnitImportDirective(ImportDirective):
    alias: Ident


@dataclass
class SymbolAlias(Node):
    symbol: Ident
    alias: Ident


@dataclass
class SymbolImportDirective(ImportDirective):
    aliases: List[SymbolAlias]


@dataclass
class ContractPart(Node):
    pass


class SpecialFunctionKind(Enum):
    CONSTRUCTOR = '<<constructor>>'
    RECEIVE = '<<receive>>'
    FALLBACK = '<<fallback>>'


@dataclass
class FunctionDefinition(SourceUnit, ContractPart):
    name: Ident
    args: List[Parameter]
    modifiers: List[Modifier]
    returns: List[Parameter]
    code: Block


@dataclass
class ModifierDefinition(ContractPart):
    name: Ident
    args: List[Parameter]
    modifiers: List[Modifier]
    code: Block


@dataclass
class StructMember(Node):
    member_type: Type
    name: Ident


@dataclass
class StructDefinition(SourceUnit, ContractPart):
    name: Ident
    members: List[StructMember]


@dataclass
class EnumDefinition(SourceUnit, ContractPart):
    name: Ident
    values: List[Ident]


@dataclass
class StateVariableDeclaration(ContractPart):
    var_type: Type
    modifiers: List[Modifier]
    name: Ident
    initial_value: Expr


@dataclass
class ConstantVariableDeclaration(SourceUnit):
    var_type: Type
    name: Ident
    initial_value: Expr


@dataclass
class EventParameter(Node):
    param_type: Type
    name: Ident
    is_indexed: bool


@dataclass
class EventDefinition(ContractPart):
    name: Ident
    is_anonymous: bool
    parameters: List[EventParameter]


@dataclass
class ErrorParameter(Node):
    error_type: Type
    name: Ident


@dataclass
class ErrorDefinition(SourceUnit, ContractPart):
    name: Ident
    parameters: List[ErrorParameter]


@dataclass
class UsingDirective(ContractPart):
    library_name: Ident
    override_type: Type


@dataclass
class InheritSpecifier(Node):
    name: Ident
    args: List[Expr]


@dataclass
class ContractDefinition(SourceUnit):
    name: Ident
    is_abstract: bool
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]


@dataclass
class InterfaceDefinition(SourceUnit):
    name: Ident
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]


@dataclass
class LibraryDefinition(SourceUnit):
    name: Ident
    parts: List[ContractPart]


@dataclass
class CreateMetaType(Expr):
    base_type: Type
