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


@dataclass
class BinaryOp(Expr):
    left: Expr
    right: Expr
    op: str


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
class VarDecl(Stmt):
    var_type: Ident
    var_loc: Location
    var_name: Ident


class Parameter(VarDecl):
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
class VarDecl(Stmt):
    value: Expr


@dataclass
class If(Stmt):
    condition: Expr
    true_branch: Stmt
    false_branch: Stmt


# TODO figure out right structure
@dataclass
class Catch(Stmt):
    ident: Ident
    body: Block


@dataclass
class Try(Stmt):
    expr: Expr
    return_parameters: List[Parameter]
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


class ThrowStmt(Stmt):
    pass

