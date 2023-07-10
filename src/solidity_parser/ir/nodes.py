from abc import ABC
from dataclasses import dataclass, field
from typing import Any, Dict, List, Union
from enum import Enum
import re

import networkx
import networkx as nx

import solidity_parser.ast.solnodes2 as solnodes2
import solidity_parser.ast.solnodes as solnodes1


class BasicBlock:
    def __init__(self, id):
        self.id = id
        self.stmts = []

        # SSA state
        self.assigns: List[LocalVar] = set()

    def __hash__(self):
        return hash(self.id)

    def key(self):
        return f'#{self.id} (0x{hex(id(self))[2:].zfill(16).upper()})'

    def __str__(self):
        return '\n'.join([s.code_str() for s in self.stmts])


class ControlEdge(Enum):
    IMMEDIATE = 0
    GOTO = 1
    TRUE_BRANCH = 2
    FALSE_BRANCH = 3
    LOOP = 4
    LOOP_EXIT = 5


class ControlFlowGraph:

    def __init__(self):
        self.node_cache = {}

        self.invalidated_cache = True
        self.nx_graph = None

        self.pred_edges = {}
        self.succ_edges = {}

    def _invalidate_cache(self):
        self.invalidated_cache = True
        self.nx_graph = None

    def get_nodes(self):
        return list(self.node_cache.values())

    def get_node_count(self):
        return len(self.node_cache)

    def get_entry_nodes(self):
        entry_nodes = set()
        for node_key in self.node_cache.keys():
            if node_key not in self.pred_edges or len(self.pred_edges[node_key]) == 0:
                entry_nodes.add(node_key)
        return [self.node_cache[k] for k in entry_nodes]

    def add_node(self, node):
        self._check_to_cache(node)

    def add_edge(self, src, dst, *data):
        if not src or not dst:
            return

        self._check_to_cache(src)
        self._check_to_cache(dst)

        src_key, dst_key = self.get_node_key(src), self.get_node_key(dst)

        if src_key not in self.succ_edges:
            self.succ_edges[src_key] = set()

        self.succ_edges[src_key].add((dst_key, *data))

        if dst_key not in self.pred_edges:
            self.pred_edges[dst_key] = set()

        self.pred_edges[dst_key] = (src_key, *data)

    def _check_to_cache(self, node):
        key = self.get_node_key(node)
        if key not in self.node_cache:
            self.node_cache[key] = node
            self._invalidate_cache()
        elif self.node_cache[key] != node:
            raise ValueError(f'Node already cached {key}')

    def get_succs(self, node):
        key = self.get_node_key(node)
        return [(self.node_cache.get(s_key), data) for s_key, data in self.succ_edges.get(key, [])]

    def get_preds(self, node):
        key = self.get_node_key(node)
        return [(self.node_cache.get(p_key), data) for p_key, data in self.pred_edges.get(key, [])]

    def get_dominance_frontier(self, entry_node):
        if self.nx_graph is None:
            self.nx_graph = self._create_nx_graph()

        # entry_nodes = self.get_entry_nodes()
        # start_node_key = self.get_node_key(entry_nodes[0])
        return nx.dominance_frontiers(self.nx_graph, self.get_node_key(entry_node))

    def _create_nx_graph(self):
        g = networkx.DiGraph()
        # add all nodes to the graph
        g.add_nodes_from(list(self.node_cache.keys()))
        # add all edges to the graph
        for src_key, edges in self.succ_edges.items():
            for dst_key, _ in edges:
                g.add_edge(src_key, dst_key)
        return g

    def get_node_key(self, node):
        return node.key()

    def __str__(self):
        LINE_REG = re.compile("\r?\n")

        lines = []
        for node_key, node in self.node_cache.items():
            lines.append(f'Node: {node_key}')

            node_str = str(node)
            if node_str:
                lines.extend([f' {l}' for l in LINE_REG.split(node_str)])

            for succ_key, data in self.succ_edges.get(node_key, []):
                lines.append(f'  -> {succ_key} ({data})')
        return '\n'.join(lines)


@dataclass
class Node:
    def code_str(self):
        # raise NotImplementedError(f'{type(self)}')
        return f'(RAW) {str(self)}'


@dataclass
class Expr(Node, ABC):
    pass


@dataclass
class Stmt(Node, ABC):
    pass


@dataclass
class ExprStmt(Stmt):
    expr: Expr

    def code_str(self):
        return f'{self.expr.code_str()};'


@dataclass
class LocalVar(Node):
    id: str
    version: int

    def code_str(self):
        return f'{self.id}v{self.version}'


@dataclass
class Conditional(Stmt):
    condition: LocalVar
    true_branch: BasicBlock
    false_branch: BasicBlock


@dataclass
class Goto(Stmt):
    target: BasicBlock

    def code_str(self):
        return f'goto {self.target.key()}'


@dataclass
class LocalStore(Stmt):
    var: LocalVar
    value: Expr

    def code_str(self):
        return f'{self.var.code_str()} = {self.value.code_str()};'


@dataclass
class StateVarStore(Expr):
    base: LocalVar
    name: str
    value: LocalVar

    def code_str(self):
        return f'{self.base.code_str()}.{self.name} = {self.value.code_str()}'


@dataclass
class StateVarLoad(Expr):
    base: LocalVar
    name: str

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}'


@dataclass
class ArrayLoad(Expr):
    base: LocalVar
    index: LocalVar

    def code_str(self):
        return f'{self.base.code_str()}[{self.index.code_str()}]'


@dataclass
class ArrayStore(Expr):
    base: LocalVar
    index: LocalVar
    value: LocalVar

    def code_str(self):
        return f'{self.base.code_str()}[{self.index.code_str()}] = {self.value.code_str()}'


@dataclass
class TempStmt:
    data: str

    def __str__(self):
        return self.data


@dataclass
class Return(Stmt):
    var: LocalVar

    def code_str(self):
        return f'return {self.var.code_str()};'


@dataclass
class GlobalValue(Expr):
    name: str
    ttype: solnodes2.Type

    def code_str(self):
        return f'{self.name}'


@dataclass
class DynamicBuiltInValue(Expr):
    # <base>.name
    name: str
    ttype: solnodes2.Type
    base: LocalVar

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}'


@dataclass
class GetType(Expr):
    # type(MyContract)
    ttype: solnodes2.Type

    def code_str(self):
        return f'type({self.ttype.code_str()})'


@dataclass
class Literal(Expr):
    value: Any
    ttype: solnodes2.Type
    unit: solnodes1.Unit = None

    def code_str(self):
        if isinstance(self.value, str):
            return f'"{self.value}"'
        else:
            return str(self.value)


@dataclass
class UnaryOp(Expr):
    value: LocalVar
    op: solnodes1.UnaryOpCode
    is_pre: bool

    def code_str(self):
        if self.is_pre:
            return f'{str(self.op.value)}{self.value.code_str()}'
        else:
            return f'{self.value.code_str()}{str(self.op.value)}'


@dataclass
class BinaryOp(Expr):
    left: LocalVar
    right: LocalVar
    op: solnodes1.BinaryOpCode

    def code_str(self):
        return f'{self.left.code_str()} {str(self.op.value)} {self.right.code_str()}'


@dataclass
class Cast(Expr):
    ttype: solnodes2.Type
    value: LocalVar

    def code_str(self):
        return f'{self.ttype.code_str()}({self.value.code_str()})'


@dataclass
class SelfObject(Expr):
    declarer: Union[solnodes2.ContractDefinition, solnodes2.InterfaceDefinition]

    def code_str(self):
        return 'this'


@dataclass
class NamedArgument:
    name: str
    expr: LocalVar


@dataclass
class Call(Expr, ABC):
    named_args: List[NamedArgument]
    args: List[LocalVar]


@dataclass
class FunctionCall(Call):
    base: LocalVar
    name: str

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}{solnodes2.Call.param_str(self)}'


@dataclass
class DirectCall(Call):
    ttype: solnodes2.ResolvedUserType
    name: str

    def code_str(self):
        return f'{self.ttype.code_str()}.{self.name}{solnodes2.Call.param_str(self)}'


@dataclass
class EmitEvent(Stmt):
    event: solnodes2.EventDefinition = field(repr=False)
    args: List[LocalVar]

    def code_str(self):
        return f'emit {self.event.name.text}{solnodes2.Call.param_str(self)}'


@dataclass
class Require(Stmt):
    condition: LocalVar
    reason: LocalVar

    def code_str(self):
        return f'require({self.condition.code_str()}{(", " + self.reason.code_str()) if self.reason else ""})'
