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
class NamedArgs(Expr):  # nameValue in grammar
    args: List


@dataclass
class ListedArgs(Expr):
    args: List[Expr]


############## EXPRS ####################

@dataclass
class Inc(Expr):  # var++
    # TODO, figure out exact type
    expr: Expr


@dataclass
class Dec(Expr):  # var--
    # TODO, figure out exact type
    expr: Expr


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
class GetField(Expr):
    obj_base: Expr
    field_name: Ident


@dataclass
class CallFunction(Expr):
    obj_base: Expr
    args: Expr  # (ListedArgs | NamedArgs)
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
    initialiser: VarDecl # TODO might also be ExprStmt
    condition: Expr
    advancement: Expr
    body: Stmt

# TODO inline assembly stmt


@dataclass
class DoWhile(Stmt):
    body: Stmt
    condition: Expr


class Continue(Stmt):
    pass


class Break(Stmt):
    pass


class Return(Stmt):
    value: Expr


class ThrowStmt(Stmt):
    pass

