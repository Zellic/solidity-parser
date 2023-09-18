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
        self.stmts: List[Stmt] = []

        # SSA temp state
        self.insertion = 0
        self.process = 0

        self.phis: List[Phi] = []

    def __hash__(self):
        return hash(self.id)

    def key(self):
        return f'#{self.id} (0x{hex(id(self))[2:].zfill(16).upper()})'

    def __str__(self):
        return self.key()

    def ref(self):
        return f'#{self.id}'

    def code_str(self):
        return '\n'.join([s.code_str() for s in (self.phis + self.stmts)])


class ControlEdge(Enum):
    IMMEDIATE = 0
    GOTO = 1
    TRUE_BRANCH = 2
    FALSE_BRANCH = 3
    LOOP = 4
    LOOP_EXIT = 5
    CONTINUE = 6
    ERROR = 7


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

    def get_succ_count(self, node):
        key = self.get_node_key(node)
        return len(self.succ_edges.get(key, []))

    def get_pred_count(self, node):
        key = self.get_node_key(node)
        return len(self.pred_edges.get(key, []))

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

        self.pred_edges[dst_key].add((src_key, *data))

    def _check_to_cache(self, node):
        key = self.get_node_key(node)
        if key not in self.node_cache:
            self.node_cache[key] = node
            self._invalidate_cache()
        elif self.node_cache[key] != node:
            raise ValueError(f'Node already cached {key}')

    def get_succs(self, node):  # Collection[Tuple[Block, Data]]
        key = self.get_node_key(node)
        return [(self.node_cache.get(s_key), data) for s_key, data in self.succ_edges.get(key, [])]

    def get_succs_only(self, node):  # Collection[Block]
        key = self.get_node_key(node)
        return [self.node_cache.get(s_key) for s_key, _ in self.succ_edges.get(key, [])]

    def get_preds(self, node):  # Collection[Tuple[Block, Data]]
        key = self.get_node_key(node)
        return [(self.node_cache.get(p_key), data) for p_key, data in self.pred_edges.get(key, [])]

    def get_preds_only(self, node):  # Collection[Block]
        key = self.get_node_key(node)
        return [self.node_cache.get(p_key) for p_key, _ in self.pred_edges.get(key, [])]

    def _map_node_key_dict(self, ddict, collection_type=set):
        result = {}
        for u_key, u_values in ddict.items():
            result[self.node_cache[u_key]] = collection_type([self.node_cache[k] for k in u_values])
        return result

    def get_dominance_frontier(self, entry_node, as_keys=False):  # Dict[Node, Set[Node]]
        nx_graph = self.get_nx_graph()
        dom_frontier_keys = nx.dominance_frontiers(nx_graph, self.get_node_key(entry_node))
        return dom_frontier_keys if as_keys else self._map_node_key_dict(dom_frontier_keys)

    def get_iterated_dominance_frontier(self, entry_node, as_keys=False):
        dom_frontier_keys = self.get_dominance_frontier(entry_node, as_keys=True)
        post_order_keys = self.get_dfs_post_order(entry_node, as_keys=True)
        iterated_frontier_keys = {}

        # taken from mapleIR
        for n in post_order_keys:
            result = set()
            working = set()
            working.add(n)
            while True:
                new_working = set()
                for n1 in working:
                    for n2 in dom_frontier_keys[n1]:
                        if n2 not in result:
                            new_working.add(n2)
                            result.add(n2)
                working = new_working
                if not working:
                    break
            iterated_frontier_keys[n] = result

        return iterated_frontier_keys if as_keys else self._map_node_key_dict(iterated_frontier_keys)

    def get_dfs_post_order(self, entry_node, as_keys=False):
        nx_graph = self.get_nx_graph()
        post_order_keys = nx.dfs_postorder_nodes(nx_graph, self.get_node_key(entry_node))
        return post_order_keys if as_keys else [self.node_cache[k] for k in post_order_keys]

    def get_nx_graph(self):
        if self.nx_graph is None:
            self.nx_graph = self._create_nx_graph()
        return self.nx_graph

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

    def graphviz_str(self):
        lines = ['digraph "" {']

        _special_chars_map = {i: '\\' + chr(i) for i in b'"'}

        def escape(x):
            return x.translate(_special_chars_map)

        for node in self.node_cache.values():
            label = f'{node.key()}' + '\n' + node.code_str()
            lines.append(f'\t"{node.id}" [shape=box, label="{escape(label)}"]')

        for node in self.node_cache.values():
            for succ, data in self.get_succs(node):
                lines.append(f'\t"{node.id}" -> "{succ.id}" [label="{data}"]')
        lines.append('}')

        return '\n'.join(lines)


@dataclass
class Node(ABC):
    def code_str(self):
        # raise NotImplementedError(f'{type(self)}')
        return f'(RAW) {str(self)}'

    def get_uses(self) -> List['LocalVar']:
        return []

    def get_defines(self) -> List['LocalVar']:
        return []


@dataclass
class LocalVar(Node):
    id: str
    version: int
    ttype: solnodes2.Type
    location: solnodes2.Location

    def code_str(self):
        return f'{self.id}_{self.version}'

    def get_uses(self) -> List['LocalVar']:
        return [self]

    def get_defines(self) -> List['LocalVar']:
        return [self]


@dataclass
class InputParam(Node):
    index: int
    var: LocalVar

    def code_str(self):
        return f'@param{self.index}'

    def get_defines(self) -> List['LocalVar']:
        return [self.var]


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

    def get_uses(self) -> List['LocalVar']:
        return self.expr.get_uses()

    def get_defines(self) -> List['LocalVar']:
        return self.expr.get_defines()


@dataclass
class Conditional(Stmt):
    condition: LocalVar
    true_branch: BasicBlock
    false_branch: BasicBlock

    def code_str(self):
        return f'if ({self.condition.code_str()}) goto {self.true_branch.ref()} else goto {self.false_branch.ref()}'

    def get_uses(self) -> List['LocalVar']:
        return [self.condition]


@dataclass
class Goto(Stmt):
    target: BasicBlock

    def code_str(self):
        return f'goto {self.target.ref()}'


@dataclass
class LocalStore(Stmt):
    var: LocalVar
    value: Expr

    def __post_init__(self):
        if isinstance(self.value, solnodes2.Var):
            raise ValueError('')

    def code_str(self):
        return f'{self.var.code_str()} = {self.value.code_str()};'

    def get_uses(self) -> List['LocalVar']:
        return self.value.get_uses()

    def get_defines(self) -> List['LocalVar']:
        return [self.var]


@dataclass
class Phi(Node):
    var: LocalVar
    args: Dict[BasicBlock, LocalVar]

    def code_str(self):
        return f'{self.var.code_str()} = PHI({", ".join([b.ref() + ": " + v.code_str() for b, v in self.args.items()])})'

    def get_uses(self) -> List['LocalVar']:
        return self.args

    def get_defines(self) -> List['LocalVar']:
        return [self.var]


@dataclass
class StateVarStore(Stmt):
    base: LocalVar
    name: str
    value: LocalVar

    def code_str(self):
        return f'{self.base.code_str()}.{self.name} = {self.value.code_str()}'

    def get_uses(self) -> List['LocalVar']:
        return [self.base, self.value]


@dataclass
class StateVarLoad(Expr):
    base: LocalVar
    name: str

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}'

    def get_uses(self) -> List['LocalVar']:
        return [self.base]


@dataclass
class StaticVarLoad(Expr):
    base: solnodes2.ResolvedUserType
    name: str

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}'


@dataclass
class ArrayLoad(Expr):
    base: LocalVar
    index: LocalVar

    def code_str(self):
        return f'{self.base.code_str()}[{self.index.code_str()}]'

    def get_uses(self) -> List['LocalVar']:
        return [self.base, self.index]


@dataclass
class ArrayStore(Stmt):
    base: LocalVar
    index: LocalVar
    value: LocalVar

    def code_str(self):
        return f'{self.base.code_str()}[{self.index.code_str()}] = {self.value.code_str()}'

    def get_uses(self) -> List['LocalVar']:
        return [self.base, self.index, self.value]


@dataclass
class TupleLoad(Expr):
    base: LocalVar
    index: int

    def code_str(self):
        return f'__TUPLELOAD__({self.base.code_str()}, {self.index})'

    def get_uses(self) -> List['LocalVar']:
        return [self.base]


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

    def get_uses(self) -> List['LocalVar']:
        return [self.var]


@dataclass
class GlobalValue(Expr):
    name: str
    ttype: solnodes2.Type

    def code_str(self):
        return f'{self.name}'


@dataclass
class ErrorDefined(Expr):
    index: int

    def code_str(self):
        return f'@caught{self.index}'


@dataclass
class ABISelector(Expr):
    function: Union[solnodes2.FunctionDefinition, solnodes2.ErrorDefinition]

    def code_str(self):
        f = self.function
        owner_name = f.parent.source_unit_name
        return f'{owner_name}.{f.name.text}.selector'


@dataclass
class DynamicBuiltInValue(Expr):
    # <base>.name
    name: str
    ttype: solnodes2.Type
    base: LocalVar

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}'

    def get_uses(self) -> List['LocalVar']:
        return [self.base]


@dataclass
class CreateMemoryArray(Expr):
    ttype: solnodes2.ArrayType
    size: LocalVar

    def code_str(self):
        return solnodes2.CreateMemoryArray.code_str(self)

    def get_uses(self) -> List['LocalVar']:
        return [self.size]


@dataclass
class CreateStruct(Expr):
    ttype: solnodes2.ResolvedUserType
    args: List[LocalVar]

    def code_str(self):
        return f'{self.ttype.code_str()}({", ".join(e.code_str() for e in self.args)})'

    def get_uses(self) -> List['LocalVar']:
        return self.args[:]


@dataclass
class CreateInlineArray(Expr):
    elements: List[LocalVar]

    def code_str(self):
        return f'[{", ".join(e.code_str() for e in self.elements)}]'

    def get_uses(self) -> List['LocalVar']:
        return self.elements[:]


@dataclass
class GetType(Expr):
    # type(MyContract)
    ttype: solnodes2.Type

    def code_str(self):
        return f'type({self.ttype.code_str()})'


@dataclass
class GetFunctionPointer(Expr):
    func: solnodes2.FunctionDefinition

    def code_str(self):
        return f'fptr({self.func.parent.descriptor()}::{self.func.name.text})'


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
class TypeLiteral(Expr):
    ttype: solnodes2.Type

    def code_str(self):
        return f'__TYPE__({self.ttype.code_str()})'


@dataclass
class EnumLoad(Expr):
    member: solnodes2.EnumMember

    def code_str(self):
        enum_def = self.member.parent
        return f'{enum_def.name.code_str()}.{self.member.name.code_str()}'


@dataclass
class Undefined(Expr):
    # AST1/2 have variable declarations and assignemnts. IR only has assignments. In cases where a variable is
    # declared without a value in AST2, undefined is set as the RHS so that the variable has a definition point for SSA
    def code_str(self):
        return '__undefined__'


@dataclass
class Default(Expr):
    ttype: solnodes2.Type

    def code_str(self):
        return f'__default__({self.ttype.code_str()})'


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

    def get_uses(self) -> List['LocalVar']:
        return [self.value]


@dataclass
class BinaryOp(Expr):
    left: LocalVar
    right: LocalVar
    op: solnodes1.BinaryOpCode

    def code_str(self):
        return f'{self.left.code_str()} {str(self.op.value)} {self.right.code_str()}'

    def get_uses(self) -> List['LocalVar']:
        return [self.left, self.right]


@dataclass
class Cast(Expr):
    ttype: solnodes2.Type
    value: LocalVar

    def code_str(self):
        return f'{self.ttype.code_str()}({self.value.code_str()})'

    def get_uses(self) -> List['LocalVar']:
        return [self.value]


@dataclass
class SelfObject(Expr):
    declarer: Union[solnodes2.ContractDefinition, solnodes2.InterfaceDefinition]

    def code_str(self):
        return 'this'


@dataclass
class SuperObject(Expr):
    ttype: solnodes2.SuperObject

    def code_str(self):
        return 'super'


@dataclass
class NamedArgument(Node):
    name: str
    expr: LocalVar

    def get_uses(self) -> List['LocalVar']:
        return [self.expr]


@dataclass
class Call(Expr, ABC):
    named_args: List[NamedArgument]
    args: List[LocalVar]

    def get_uses(self) -> List['LocalVar']:
        return [na.expr for na in self.named_args] + self.args


@dataclass
class FunctionCall(Call):
    base: LocalVar
    name: str

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}{solnodes2.Call.param_str(self)}'

    def get_uses(self) -> List['LocalVar']:
        return [self.base] + super().get_uses()


@dataclass
class DirectCall(Call):
    ttype: solnodes2.ResolvedUserType
    name: str

    def code_str(self):
        return f'{self.ttype.code_str()}.{self.name}{solnodes2.Call.param_str(self)}'


@dataclass
class DynamicBuiltInCall(Call):
    ttype: solnodes2.Type
    base: LocalVar
    name: str

    def code_str(self):
        return f'{self.base.code_str()}.{self.name}{solnodes2.Call.param_str(self)}'

    def get_uses(self) -> List['LocalVar']:
        return [self.base] + super().get_uses()


@dataclass
class BuiltInCall(Call):
    name: str
    ttype: solnodes2.Type

    def code_str(self):
        return f'{self.name}{solnodes2.Call.param_str(self)}'


@dataclass
class FunctionPointerCall(Call):
    callee: LocalVar

    def code_str(self):
        return f'{self.callee.code_str()}{solnodes2.Call.param_str(self)}'

    def get_uses(self) -> List['LocalVar']:
        return [self.callee] + super().get_uses()


@dataclass
class CreateAndDeployContract(Call):
    ttype: solnodes2.ResolvedUserType

    def code_str(self):
        return f'new {self.ttype.code_str()}{solnodes2.Call.param_str(self)}'


@dataclass
class EmitEvent(Stmt):
    event: solnodes2.EventDefinition = field(repr=False)
    args: List[LocalVar]

    def code_str(self):
        return f'emit {self.event.name.text}{solnodes2.Call.param_str(self)}'

    def get_uses(self) -> List['LocalVar']:
        return self.args[:]


@dataclass
class Require(Stmt):
    condition: LocalVar
    reason: LocalVar

    def code_str(self):
        return f'require({self.condition.code_str()}{(", " + self.reason.code_str()) if self.reason else ""})'

    def get_uses(self) -> List['LocalVar']:
        return [self.condition, self.reason]


@dataclass
class Revert(Stmt):
    pass


@dataclass
class RevertWithReason(Revert):
    reason: LocalVar

    def get_uses(self) -> List['LocalVar']:
        return [self.reason]

    def code_str(self):
        return solnodes2.RevertWithReason.code_str(self)


@dataclass
class RevertWithError(Revert):
    error: solnodes2.ErrorDefinition = field(repr=False)
    args: List[LocalVar]

    def get_uses(self) -> List['LocalVar']:
        return self.args

    def code_str(self):
        return f'revert {self.error.name.text}({", ".join(e.code_str() for e in self.args)});'


@dataclass
class Assembly(Stmt):
    code: str

    def code_str(self):
        return solnodes2.Assembly.code_str(self)