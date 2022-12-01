from dataclasses import dataclass
from enum import Enum
from typing import List, Any


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
    WEI = 'wei'
    SZABO = 'szabo'
    FINNEY = 'finney'
    ETHER = 'either'
    SECONDS = 'seconds'
    MINUTES = 'minutes'
    HOURS = 'hour'
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


@dataclass
class UnaryOp(Expr):  # var++
    expr: Expr
    op: UnaryOpCode
    pre: bool  # pre or post


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
    op: str


@dataclass
class TernaryOp(Expr):
    condition: Expr
    left: Expr
    right: Expr


@dataclass
class New(Expr):  # new X
    type_name: Ident


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
    args: List
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


@dataclass
class If(Stmt):
    condition: Expr
    true_branch: Stmt
    false_branch: Stmt


# TODO figure out right structure
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
    initialiser: Stmt # TODO might also be ExprStmt or VarDecl
    condition: Expr
    advancement: Expr
    body: Stmt

@dataclass
class Emit(Stmt):
    call: CallFunction
# TODO inline assembly stmt

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
    payable: bool


@dataclass
class ByteType(Type):
    pass


@dataclass
class IntType(Type):
    signed: bool
    size: int


class BoolType(Type):
    pass


class StringType(Type):
    pass


class VarType(Type):
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

