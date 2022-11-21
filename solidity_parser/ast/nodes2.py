from dataclasses import dataclass

from typing import List


class Node:
    pass


@dataclass
class Ident(Node):
    text: str


@dataclass
class Location(Node):
    text: str


class Stmt(Node):
    pass


class Expr(Node):
    pass


@dataclass
class NamedArg(Expr):
    name: Ident
    value: Expr


############## EXPRS ####################

@dataclass
class Literal(Expr):
    value: 'typing.Any'


@dataclass
class UnitLiteral(Literal):
    unit: str


@dataclass
class UnaryOp(Expr):  # var++
    # TODO, figure out exact type
    expr: Expr
    op: str  # e.g. ++, --, +, -
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
    member_load: Expr
    modifiers: List
    args: List
#########################################


@dataclass
class VarDecl(Stmt):
    var_type: Ident
    var_loc: Location
    var_name: Ident


class Parameter(VarDecl):
    pass


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

