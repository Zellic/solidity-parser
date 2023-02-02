from dataclasses import dataclass, field
from enum import Enum
from typing import List, Any, Union, Optional, Dict
from abc import ABC, abstractmethod

from solidity_parser.ast import solnodes as solnodes1
from solidity_parser.ast import symtab

class Node:
    pass


class Stmt(Node):
    pass


class Expr(Node):
    pass


@dataclass
class Ident(Node):
    text: str


class TopLevelUnit(Node):
    pass


class Type(Node):
    pass


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


class Block(Node):
    pass


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


class Builder:

    def __init__(self):
        self.user_types: Dict[str, ContractDefinition] = {}

    def get_user_type(self, ttype: solnodes1.UserType):
        """Maps an AST1 UserType to AST2 ResolvedUserType"""
        name = ttype.name.text
        s = ttype.scope.find(name)

        if not s:
            raise ValueError(f"Can't resolve {ttype}")

        if len(s) != 1:
            raise ValueError(f"Too many symbols for {ttype}: {s}")

        ast1_node = s[0].value

        if isinstance(ast1_node,
                      (solnodes1.ContractDefinition, solnodes1.InterfaceDefinition, solnodes1.StructDefinition)):
            if name in self.user_types:
                ast2_node = self.user_types[name]
            else:
                ast2_node = self.refine_top_level_node(ast1_node)
                self.user_types[name] = ast2_node

            return ResolvedUserType(ast2_node)
        else:
            raise ValueError(f"Invalid user type resolve: {type(ast1_node)}")


    def refine_expr(self, expr: solnodes1.Expr):
        pass

    def parameter(self, node: solnodes1.Parameter):
        return Parameter(
            Ident(node.var_name.text),
            self.map_type(node.var_type),
            # Location[]
        )
    def refine_contract_part(self, part: solnodes1.ContractPart):
        if isinstance(part, solnodes1.FunctionDefinition):
            return FunctionDefinition(
                Ident(part.name.text),
                []
            )

    def refine_top_level_node(self, node: solnodes1.ContractDefinition):
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
        else:
            raise ValueError('x')

