from enum import  Enum


def create_list(*args):
    return [a for a in args if a is not None]


class AstNode:
    def __init__(self, *children):
        self.children = create_list(children) # List<AstNode>


class Identifier(AstNode):
    def __init__(self):
        super().__init__(self, [])


class IdentifierPath(Identifier):
    def __init__(self, parts):
        self.parts = parts


class Location(Enum, AstNode):
    MEMORY = 1
    STORAGE = 2
    CALL_DATA = 3


class ContractVariant(Enum, AstNode):
    CONTRACT = 1
    LIBRARY = 2
    INTERFACE = 3


class SType(AstNode):
    def __init__(self, name):
        self.name = name


class StorageLocation(AstNode):
    def __init__(self, location: str):
        self.location = location


class Parameter(AstNode):
    def __init__(self, stype: SType, location: StorageLocation = None, name: Identifier = None):
        super().__init__(self, [stype, location, name])


class Contract(AstNode):
    def __init__(self, name: Identifier, variant: ContractVariant, abstract: bool, base_classes: list[Identifier], parts:list[AstNode]):
        super().__init__(self, [name, variant, *base_classes, *parts])
        self.abstract = abstract


class EnumDecl(AstNode):
    def __init__(self, types, *children):
        super().__init__(*children)
        self.types = types


class Stmt(AstNode):
    def __init__(self, *children):
        super().__init__(*children)


class Block(Stmt):
    def __init__(self, *stmts):
        super().__init__(*stmts)


class Expr(AstNode):
    def __init__(self, *children):
        super().__init__(*children)


class IfStmt(Stmt):
    def __init__(self, condition: Expr, true_branch: Stmt, false_branch: Stmt):
        super().__init__(self, [condition, true_branch, false_branch])


# TODO figure out right structure
class CatchStmt(Stmt):
    def __init__(self, ident, block: Block):
        super().__init__([ident, block])


class TryStmt(Stmt):
    def __init__(self, expr, block: Block, return_params=[], catch_clauses=[]):
        super().__init__(self, [expr, block, *return_params, *catch_clauses])

