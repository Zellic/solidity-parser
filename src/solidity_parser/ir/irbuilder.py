from dataclasses import dataclass
from typing import Union, NamedTuple, List, Dict, Set, Tuple
from collections import deque, defaultdict

import solidity_parser.ast.solnodes as solnodes1
import solidity_parser.ast.solnodes2 as solnodes2
import solidity_parser.ir.nodes as irnodes

from solidity_parser.ir.liveness import liveness


@dataclass
class UnversionedLocal(irnodes.Node):
    id: str
    ttype: solnodes2.Type
    location: solnodes2.Location

    def code_str(self):
        return f'{self.id}'

    def __hash__(self):
        return hash(self.id)



class IRBuilder:

    # def init_state(self, func):
    #     self.local_count = 0
    #     self.state = IRBuilder.State(0)
    #
    # def temp_local(self, idx, version=0):
    #     # TODO: check no clashes
    #     return irnodes.LocalVar(f'__t{idx}__', version)
    #
    # def new_local(self):
    #     local = self.temp_local(self.state.local_count)
    #     self.state.local_count += 1
    #     return local

    def __init__(self):
        pass

    def check_assembly(self, func):
        for n in func.get_all_children():
            if isinstance(n, solnodes2.Assembly):
                raise ValueError(f'{func.descriptor()} contains unsupported assembly code; SSA translation not possible')

    def _init_state(self):
        self.current_block = None
        self.cfg = irnodes.ControlFlowGraph()
        self.loop_stack = deque()
        self.var_count = 0
        self.pre_ssa_locals = {}

    def translate_function(self, func: solnodes2.FunctionDefinition, ssa=True, force=False):
        if ssa and not force:
            self.check_assembly(func)

        self._init_state()

        start_block = self.create_new_block()

        self.add_params(func, start_block)
        self.process_block(func.code, start_block)

        print("CODE " + func.descriptor())
        print(func.code.code_str())
        dom_frontiers = self.cfg.get_iterated_dominance_frontier(start_block)
        self.insert_phis2(dom_frontiers)
        self.ssa_rename(start_block)
        # print("GRAPH")
        # print(self.cfg)
        # print("GRAPH END")
        print(self.cfg.graphviz_str())
        # print("GRAPH END2")

        self.copy_prop()

        # print(self.pre_ssa_locals)

    def make_ssa_local(self, id, version, ttype, location):
        return irnodes.LocalVar(id, version, ttype, location)

    def make_ssa_local_from_unversioned(self, var: UnversionedLocal, version):
        return self.make_ssa_local(var.id, version, var.ttype, var.location)

    def make_unversioned_local_from_var(self, var: solnodes2.Var):
        return self.make_unversioned_local(var.name.text, var.ttype, var.location)

    def make_unversioned_local(self, id, ttype, location) -> UnversionedLocal:
        # These locals are immutable but later on when SSA is formed, attributes are added to each local
        # If we made multiple copies for each local it would mess up the formation pass
        # Instead, we reuse a UnversionedLocal object for each given id
        # This also lets us check that the type of each def/use of a var is the same, i.e. no bad type store/loads
        #   same for location

        if id in self.pre_ssa_locals:
            local = self.pre_ssa_locals[id]
            # TODO: type check, i.e. compute common base type for local.ttype and ttype
        else:
            local = UnversionedLocal(id, ttype, location)
            self.pre_ssa_locals[id] = local
        return local

    def new_temp_var(self, ttype, location) -> UnversionedLocal:
        tid = self.var_count
        self.var_count += 1
        return self.make_unversioned_local(f't{tid}', ttype, location)

    def new_temp_var_of(self, var: solnodes2.Var):
        return self.new_temp_var(var.ttype, var.location)

    class LoopData(NamedTuple):
        continuation: irnodes.BasicBlock
        header: irnodes.BasicBlock

    ########### SSA Stuff #############

    def collect_vars(self):
        defines: Dict[irnodes.LocalVar, Set[irnodes.BasicBlock]] = defaultdict(set)

        for b in self.cfg.get_nodes():
            for stmt in b.stmts:
                for v in stmt.get_defines():
                    defines[v].add(b)

        return defines

    def insert_phis2(self, dom_frontiers):

        defined_in = self.collect_vars()

        live_in, _ = liveness(self.cfg)

        for var_index, var in enumerate(self.pre_ssa_locals.values()):

            worklist = deque()

            if len(defined_in[var]) < 2:
                # phi not needed if only 1 def
                continue

            for b in defined_in[var]:
                b.process = var_index
                worklist.append(b)

            while worklist:
                self.do_insert_phis2(dom_frontiers, live_in, worklist.popleft(), var, var_index, worklist)

    def do_insert_phis2(self, dom_frontiers, live_in, block, var, var_index, worklist):
        for df_block in dom_frontiers[block]:
            if df_block.insertion < var_index: # for pruned add live_in(df_block, var) here
                if var in live_in[block]:
                    preds = self.cfg.get_preds(df_block)
                    if len(preds) > 1:
                        phi = irnodes.Phi(var, {p: var for p, _ in preds})
                        df_block.phis.append(phi)

                df_block.insertion = var_index
                if df_block.process < var_index:
                    df_block.process = var_index
                    worklist.append(df_block)

    def ssa_translate(self, node: irnodes.Node, allow_none=False):
        if not node:
            assert allow_none, 'Require node for translation'
            return None

        def t_ssa_use(var: UnversionedLocal):
            version = var.stack[-1]  # top of the stack
            return self.make_ssa_local_from_unversioned(var, version)

        def t_ssa_def(var: UnversionedLocal):
            version = var.counter
            # update counter and stack
            var.counter = version + 1
            var.stack.append(version)
            # create new local
            return self.make_ssa_local_from_unversioned(var, version)

        # STMTS
        if isinstance(node, irnodes.LocalStore):
            # need to process the RHS first(uses) then the LHS(defs)
            expr = self.ssa_translate(node.value)
            new_var = t_ssa_def(node.var)
            return irnodes.LocalStore(new_var, expr)
        elif isinstance(node, irnodes.StateVarStore):
            return irnodes.StateVarStore(self.ssa_translate(node.base), node.name, self.ssa_translate(node.value))
        elif isinstance(node, irnodes.StaticVarLoad):
            return node
        elif isinstance(node, irnodes.ArrayStore):
            return irnodes.ArrayStore(self.ssa_translate(node.base), self.ssa_translate(node.index), self.ssa_translate(node.value))
        elif isinstance(node, irnodes.TupleLoad):
            return irnodes.TupleLoad(t_ssa_use(node.base), node.index)
        elif isinstance(node, irnodes.Phi):
            new_var = t_ssa_def(node.var)
            # DON'T fix phi args here, it's done in the search function on each successor visit
            return irnodes.Phi(new_var, node.args)
        elif isinstance(node, irnodes.Conditional):
            return irnodes.Conditional(t_ssa_use(node.condition), node.true_branch, node.false_branch)
        elif isinstance(node, irnodes.Return):
            return irnodes.Return(t_ssa_use(node.var))
        elif isinstance(node, irnodes.Goto):
            return node
        elif isinstance(node, irnodes.ExprStmt):
            return irnodes.ExprStmt(self.ssa_translate(node.expr))
        elif isinstance(node, irnodes.Assembly):
            return node
        elif isinstance(node, irnodes.Require):
            return irnodes.Require(self.ssa_translate(node.condition), self.ssa_translate(node.reason, allow_none=True))
        elif isinstance(node, irnodes.RevertWithReason):
            return irnodes.RevertWithReason(t_ssa_use(node.reason))
        elif isinstance(node, irnodes.RevertWithError):
            return irnodes.RevertWithError(node.error, [t_ssa_use(v) for v in node.args])
        
        def map_call_base(call: irnodes.Call):
            return [irnodes.NamedArgument(n.name, t_ssa_use(n.expr)) for n in call.named_args], [t_ssa_use(v) for v in call.args]

        # EXPRS
        if isinstance(node, UnversionedLocal):
            # Local var load (pre ssa), treated as a use. i.e. LHS/def vars never make it here
            return t_ssa_use(node)
        elif isinstance(node, irnodes.InputParam):
            # explicit function input parameter, i.e. the RHS of myArg = @param1
            return node
        elif isinstance(node, irnodes.Default):
            return node
        elif isinstance(node, irnodes.SelfObject):
            return node
        elif isinstance(node, irnodes.SuperObject):
            return node
        elif isinstance(node, irnodes.Literal):
            return node
        elif isinstance(node, irnodes.TypeLiteral):
            return node
        elif isinstance(node, irnodes.Undefined):
            return node
        elif isinstance(node, irnodes.ErrorDefined):
            return node
        elif isinstance(node, irnodes.GlobalValue):
            return node
        elif isinstance(node, irnodes.ABISelector):
            return node
        elif isinstance(node, irnodes.DynamicBuiltInValue):
            return irnodes.DynamicBuiltInValue(node.name, node.ttype, t_ssa_use(node.base))
        elif isinstance(node, irnodes.EnumLoad):
            return node
        elif isinstance(node, irnodes.StateVarLoad):
            return irnodes.StateVarLoad(t_ssa_use(node.base), node.name)
        elif isinstance(node, irnodes.ArrayLoad):
            return irnodes.ArrayLoad(t_ssa_use(node.base), t_ssa_use(node.index))
        elif isinstance(node, irnodes.CreateMemoryArray):
            return irnodes.CreateMemoryArray(node.ttype, t_ssa_use(node.size))
        elif isinstance(node, irnodes.UnaryOp):
            return irnodes.UnaryOp(t_ssa_use(node.value), node.op, node.is_pre)
        elif isinstance(node, irnodes.BinaryOp):
            return irnodes.BinaryOp(t_ssa_use(node.left), t_ssa_use(node.right), node.op)
        elif isinstance(node, irnodes.Cast):
            return irnodes.Cast(node.ttype, t_ssa_use(node.value))
        elif isinstance(node, irnodes.GetType):
            return node
        elif isinstance(node, irnodes.FunctionCall):
            return irnodes.FunctionCall(*map_call_base(node), t_ssa_use(node.base), node.name)
        elif isinstance(node, irnodes.DirectCall):
            return irnodes.DirectCall(*map_call_base(node), node.ttype, node.name)
        elif isinstance(node, irnodes.DynamicBuiltInCall):
            return irnodes.DynamicBuiltInCall(*map_call_base(node), node.ttype, t_ssa_use(node.base), node.name)
        elif isinstance(node, irnodes.BuiltInCall):
            return irnodes.BuiltInCall(*map_call_base(node), node.name, node.ttype)
        elif isinstance(node, irnodes.CreateStruct):
            return irnodes.CreateStruct(node.ttype, [t_ssa_use(v) for v in node.args])
        elif isinstance(node, irnodes.CreateInlineArray):
            return irnodes.CreateInlineArray([t_ssa_use(v) for v in node.elements])
        elif isinstance(node, irnodes.EmitEvent):
            return irnodes.EmitEvent(node.event, [t_ssa_use(n) for n in node.args])
        self._todo(node)

    def ssa_rename(self, entry):
        for var in self.pre_ssa_locals.values():
            var.counter = 0
            var.stack = deque()

        for node in self.cfg.get_nodes():
            node.visited = False

        def search(block: irnodes.BasicBlock):
            if block.visited:
                return
            block.visited = True

            # phi nodes are executed before stmts
            block.phis = [self.ssa_translate(p) for p in block.phis]
            block.stmts = [self.ssa_translate(s) for s in block.stmts]

            succs = [succ for succ, _ in self.cfg.get_succs(block)]

            # fix phi args
            for succ in succs:
                for phi in succ.phis:
                    if block in phi.args:
                        old_var = phi.args[block]
                        version = old_var.stack[-1]
                        new_var = self.make_ssa_local_from_unversioned(old_var, version)
                        phi.args[block] = new_var

            for succ in succs:
                search(succ)

            # unstack defs
            for n in block.phis + block.stmts:
                for v in n.get_defines():
                    pre_ssa_local = self.pre_ssa_locals[v.id]
                    pre_ssa_local.stack.pop()

        search(entry)

        for node in self.cfg.get_nodes():
            del node.visited

    def copy_prop(self):
        def collect_copy_defs():
            for b in self.cfg.get_nodes():
                for stmt in b.stmts:
                    if isinstance(stmt, irnodes.LocalStore):
                        if isinstance(stmt.value, irnodes.LocalVar):
                            # e.g. X = Y where X and Y are copies
                            pass
        collect_copy_defs()

    def _todo(self, x):
        # print(f'TODO: {type(x)}')
        # return irnodes.TempStmt(x.code_str())
        raise ValueError(f'{x.code_str()} :: {type(x)}')

    def create_new_block(self):
        bb = irnodes.BasicBlock(self.cfg.get_node_count())
        self.cfg.add_node(bb)
        return bb

    def create_merge_point(self, blocks: List[irnodes.BasicBlock]):
        merge_point_block = self.create_new_block()
        for b in blocks:
            self.cfg.add_edge(b, merge_point_block, irnodes.ControlEdge.IMMEDIATE)
        return merge_point_block

    def process_as_block(self, stmt, **kwargs):
        if not stmt:
            return None, None

        if isinstance(stmt, solnodes2.Block):
            return self.process_block(stmt, **kwargs)
        else:
            bb = self.create_new_block(**kwargs)
            # TODO: process stmt here
            return bb, bb

    def _translate_expr(self, cur_block, expr):
        # all translations should call this result function. This is required because some exprs may
        # change the CFG structure and the cur_block has to be updated and passed to the caller.
        # This also means that any subcalls to translate_expr should update the cur_block manually (see code
        # below that does subcalls)
        def result(val_or_var):
            return cur_block, val_or_var

        if isinstance(expr, solnodes2.GlobalValue):
            return result(irnodes.GlobalValue(expr.name, expr.ttype))
        elif isinstance(expr, solnodes2.DynamicBuiltInValue):
            cur_block, base = self.translate_expr(cur_block, expr.base)
            return result(irnodes.DynamicBuiltInValue(expr.name, expr.ttype, base))
        elif isinstance(expr, solnodes2.LocalVarLoad):
            return result(self.make_unversioned_local_from_var(expr.var))
        elif isinstance(expr, solnodes2.GetType):
            return result(irnodes.GetType(expr.ttype))
        elif isinstance(expr, solnodes2.SelfObject):
            return result(irnodes.SelfObject(expr.declarer.x))
        elif isinstance(expr, solnodes2.SuperObject):
            return result(irnodes.SuperObject(expr.ttype))
        elif isinstance(expr, solnodes2.Literal):
            return result(irnodes.Literal(expr.value, expr.ttype, expr.unit))
        elif isinstance(expr, solnodes2.TypeLiteral):
            return result(irnodes.TypeLiteral(expr.ttype))
        elif isinstance(expr, solnodes2.EnumLoad):
            return result(irnodes.EnumLoad(expr.member.x))
        elif isinstance(expr, solnodes2.ABISelector):
            return result(irnodes.ABISelector(expr.function.x))
        elif isinstance(expr, solnodes2.BinaryOp):
            cur_block, left = self.translate_expr(cur_block, expr.left)
            cur_block, right = self.translate_expr(cur_block, expr.right)
            return result(irnodes.BinaryOp(left, right, expr.op))
        elif isinstance(expr, solnodes2.UnaryOp):
            if expr.op in [solnodes1.UnaryOpCode.INC, solnodes1.UnaryOpCode.DEC]:
                # e.g. x++, BUT the translation depends on what x is.
                #  for fields, don't want to compute the base twice: y.x++;
                #    t0 = y;
                #    t1 = t0.x;
                #    t2 = t1+1;
                #    t0.x = t2;
                #    <return t1>
                #  for arrays, similarly, don't want to recompute base or index: y[z]++;
                #    t0 = y;
                #    t1 = z;
                #    t2 = t0[t1];
                #    t3 = t2+1;
                #    t0[t1] = t3;
                #    <return t2>
                value = expr.expr
                return_var = None
                op = solnodes1.BinaryOpCode.ADD if expr.op == solnodes1.UnaryOpCode.INC else solnodes1.BinaryOpCode.SUB

                if isinstance(value, solnodes2.LocalVarLoad):
                    #  for locals, simple: x++;
                    # For ++x; do the same but <return x>
                    x_old = value.var
                    x_ir = self.make_unversioned_local_from_var(x_old)
                    t_one = self.new_temp_var_of(x_old)
                    cur_block.stmts.append(irnodes.LocalStore(t_one, irnodes.Literal(int(1), x_old.ttype)))

                    if expr.is_pre:
                        # x = x + 1
                        # <return x>
                        cur_block.stmts.append(irnodes.LocalStore(x_ir, irnodes.BinaryOp(x_ir, t_one, op)))
                        return_var = x_ir
                    else:
                        # t = x;
                        # x = x+1;
                        # <return t>
                        t = self.new_temp_var_of(x_old)
                        cur_block.stmts.append(irnodes.LocalStore(t, x_ir))
                        cur_block.stmts.append(irnodes.LocalStore(x_ir, irnodes.BinaryOp(x_ir, t_one, op)))
                        return_var = t
                    return result(return_var)
                # some other base (not allowed and should fail earlier in ast2builder), update: OK scratch that I've seen ++a[x]
                elif isinstance(value, solnodes2.ArrayLoad):
                    # need to store the index first, then the array ref
                    cur_block, index_var = self.translate_expr(cur_block, value.index)
                    cur_block, array_var = self.translate_expr(cur_block, value.base)
                    value_ttype = value.type_of()

                    value_var = self.new_temp_var(value_ttype, None)
                    cur_block.stmts.append(irnodes.LocalStore(value_var, irnodes.ArrayLoad(array_var, index_var)))

                    # set the type of t_one to the element type of the array load to make LHS and RHS of the addition match
                    t_one = self.new_temp_var(value_ttype, None)
                    cur_block.stmts.append(irnodes.LocalStore(t_one, irnodes.Literal(int(1), value_ttype)))

                    # updated_value_var = value_var + t_one
                    # array_var[index_var] = updated_value_var

                    updated_value_var = self.new_temp_var(value_ttype, None)
                    cur_block.stmts.append(irnodes.LocalStore(updated_value_var, irnodes.BinaryOp(value_var, t_one, op)))
                    cur_block.stmts.append(irnodes.ArrayStore(array_var, index_var, updated_value_var))

                    if expr.is_pre:
                        return_var = updated_value_var
                    else:
                        return_var = value_var
                    return result(return_var)
                else:
                    self._todo(expr.expr)

            cur_block, value = self.translate_expr(cur_block, expr.expr)
            return result(irnodes.UnaryOp(value, expr.op, expr.is_pre))
        elif isinstance(expr, solnodes2.Call):
            cur_block, named_args = self.translate_named_args(cur_block, expr.named_args)
            cur_block, args = self.translate_exprs(cur_block, expr.args)
            if isinstance(expr, solnodes2.FunctionCall):
                cur_block, base = self.translate_expr(cur_block, expr.base)
                new_expr = irnodes.FunctionCall(named_args, args, base, expr.name.text)
                return result(new_expr)
            elif isinstance(expr, solnodes2.DirectCall):
                return result(irnodes.DirectCall(named_args, args, expr.ttype, expr.name.text))
            elif isinstance(expr, solnodes2.DynamicBuiltInCall):
                cur_block, base = self.translate_expr(cur_block, expr.base)
                return result(irnodes.DynamicBuiltInCall(named_args, args, expr.ttype, base, expr.name))
            elif isinstance(expr, solnodes2.BuiltInCall):
                return result(irnodes.BuiltInCall(named_args, args, expr.name, expr.ttype))
            elif isinstance(expr, solnodes2.FunctionPointerCall):
                cur_block, callee = self.translate_expr(cur_block, expr.callee)
                return result(irnodes.FunctionPointerCall(named_args, args, callee))
        elif isinstance(expr, solnodes2.CreateAndDeployContract):
            cur_block, named_args = self.translate_named_args(cur_block, expr.named_args)
            cur_block, args = self.translate_exprs(cur_block, expr.args)
            return result(irnodes.CreateAndDeployContract(named_args, args, expr.ttype))
        elif isinstance(expr, solnodes2.GetFunctionPointer):
            return result(irnodes.GetFunctionPointer(expr.func.x))
        elif isinstance(expr, solnodes2.StateVarStore):
            cur_block, base = self.translate_expr(cur_block, expr.base)
            cur_block, value = self.translate_expr(cur_block, expr.value)
            cur_block.stmts.append(irnodes.StateVarStore(base, expr.name.text, value))
            return result(value)
        elif isinstance(expr, solnodes2.LocalVarStore):
            new_var = self.make_unversioned_local_from_var(expr.var)
            cur_block, value = self.translate_expr(cur_block, expr.value)
            cur_block.stmts.append(irnodes.LocalStore(new_var, value))
            return result(new_var)
        elif isinstance(expr, solnodes2.StateVarLoad):
            cur_block, base = self.translate_expr(cur_block, expr.base)
            return result(irnodes.StateVarLoad(base, expr.name.text))
        elif isinstance(expr, solnodes2.StaticVarLoad):
            return result(irnodes.StaticVarLoad(expr.ttype, expr.name.text))
        elif isinstance(expr, solnodes2.TupleLoad):
            cur_block, base = self.translate_expr(cur_block, expr.base)
            return result(irnodes.TupleLoad(base, expr.index))
        elif isinstance(expr, solnodes2.ArrayLoad):
            cur_block, base = self.translate_expr(cur_block, expr.base)
            cur_block, index = self.translate_expr(cur_block, expr.index)
            return result(irnodes.ArrayLoad(base, index))
        elif isinstance(expr, solnodes2.ArrayStore):
            cur_block, base = self.translate_expr(cur_block, expr.base)
            cur_block, index = self.translate_expr(cur_block, expr.index)
            cur_block, value = self.translate_expr(cur_block, expr.value)
            cur_block.stmts.append(irnodes.ArrayStore(base, index, value))
            return result(value)
        elif isinstance(expr, solnodes2.CreateMemoryArray):
            cur_block, size = self.translate_expr(cur_block, expr.size)
            return result(irnodes.CreateMemoryArray(expr.ttype, size))
        elif isinstance(expr, solnodes2.CreateStruct):
            cur_block, args = self.translate_exprs(cur_block, expr.args)
            return result(irnodes.CreateStruct(expr.ttype, args))
        elif isinstance(expr, solnodes2.CreateInlineArray):
            cur_block, elements = self.translate_exprs(cur_block, expr.elements)
            return result(irnodes.CreateInlineArray(elements))
        elif isinstance(expr, solnodes2.Cast):
            cur_block, value = self.translate_expr(cur_block, expr.value)
            return result(irnodes.Cast(expr.ttype, value))
        elif isinstance(expr, solnodes2.TernaryOp):
            # Solidity:
            #  cond ? X : Y
            #
            # IR:
            # CurrentBlock:
            #   t0 = cond
            #   if (t0) goto XBlock else goto YBlock
            # XBlock:
            #   t1 = X
            #   goto ContinuationBlock
            # YBlock:
            #   t1 = Y
            #   goto ContinuationBlock
            # ContinuationBlock:
            #   ( return t1 to parent)
            #
            # Edges created:
            # CurrentBlock -> XBlock (true branch)
            # CurrentBlock -> YBlock (false branch)
            # XBlock -> ContinuationBlock (goto)
            # YBlock -> ContinuationBlock (goto)
            cur_block, t0 = self.translate_expr(cur_block, expr.condition)
            t1 = self.new_temp_var(expr.type_of(), None)

            xblock_start = self.create_new_block()
            yblock_start = self.create_new_block()
            continuation_block = self.create_new_block()

            conditional_stmt = irnodes.Conditional(t0, xblock_start, yblock_start)
            self.cfg.add_edge(cur_block, xblock_start, irnodes.ControlEdge.TRUE_BRANCH)
            self.cfg.add_edge(cur_block, yblock_start, irnodes.ControlEdge.FALSE_BRANCH)
            cur_block.stmts.append(conditional_stmt)

            # do xblock code, update xblock like we usually do with cur_block
            xblock_end, x_val = self.translate_expr(xblock_start, expr.left)
            xblock_end.stmts.append(irnodes.LocalStore(t1, x_val))
            xblock_end.stmts.append(irnodes.Goto(continuation_block))
            self.cfg.add_edge(xblock_end, continuation_block, irnodes.ControlEdge.GOTO)

            yblock_end, y_val = self.translate_expr(yblock_start, expr.right)
            yblock_end.stmts.append(irnodes.LocalStore(t1, y_val))
            yblock_end.stmts.append(irnodes.Goto(continuation_block))
            self.cfg.add_edge(yblock_end, continuation_block, irnodes.ControlEdge.GOTO)

            cur_block = continuation_block
            return result(t1)

        return self._todo(expr)

    def translate_expr(self, block: irnodes.BasicBlock, expr: solnodes2.Expr, unused=False, allow_void=False) -> Tuple[irnodes.BasicBlock, UnversionedLocal]:
        block, t_val = self._translate_expr(block, expr)

        def result(x):
            return block, x

        if t_val is None:
            return result(t_val)

        # TODO: if we want to allow literals and globalvalues to be RHS exprs add them here
        # if it's already a local load, avoid unnecessary store and load
        if isinstance(t_val, (UnversionedLocal, irnodes.LocalVar)):
            return result(t_val)

        ttype = expr.type_of()

        if ttype.is_void() or unused:
            # void return or unusable expr, can't be stored
            assert ttype.is_void() == allow_void
            block.stmts.append(irnodes.ExprStmt(t_val))
            return result(None)
        else:
            # else store into a temp var and return the var
            t_var = self.new_temp_var(ttype, None)
            block.stmts.append(irnodes.LocalStore(t_var, t_val))
            return result(t_var)

    def translate_exprs(self, cur_block, exprs) -> Tuple[irnodes.BasicBlock, List[UnversionedLocal]]:
        # translates the given exprs while keeping track of the continuation block (foldr)
        translated_exprs = []
        for e in exprs:
            cur_block, res = self.translate_expr(cur_block, e)
            translated_exprs.append(res)
        return cur_block, translated_exprs

    def translate_named_args(self, cur_block: irnodes.BasicBlock, ns: List[solnodes2.NamedArgument]) -> Tuple[irnodes.BasicBlock, List[irnodes.NamedArgument]]:
        translated_named_args = []
        for n in ns:
            cur_block, expr_value = self.translate_expr(cur_block, n.expr)
            translated_named_args.append(irnodes.NamedArgument(n.name.text, expr_value))
        return cur_block, translated_named_args


    def is_return_block(self, block: irnodes.BasicBlock) -> bool:
        if len(block.stmts) == 0:
            return False
        last_stmt = block.stmts[-1]
        return isinstance(last_stmt, irnodes.Return)

    def add_continuation(self, src, dst, data, add_goto=False):
        # check whether src ends with a terminating statement, if not, add an edge src -> dst

        is_terminated = False
        if src.stmts:
            last_stmt = src.stmts[-1]
            is_terminated = isinstance(last_stmt, irnodes.Return)

        if not is_terminated:
            if add_goto:
                src.stmts.append(irnodes.Goto(dst))
            self.cfg.add_edge(src, dst, data)

    def translate_stmt(self, cur_block, stmt, merge_multiple_into_single=True) -> Union[irnodes.BasicBlock, List[irnodes.BasicBlock]]:
        if isinstance(stmt, solnodes2.Block):
            # create new block boundary
            next_block_s, next_block_e = self.process_block(stmt)
            self.cfg.add_edge(cur_block, next_block_s, irnodes.ControlEdge.IMMEDIATE)
            continuation_block = self.create_new_block()
            self.cfg.add_edge(next_block_e, continuation_block, irnodes.ControlEdge.IMMEDIATE)
            cur_block = continuation_block
        elif isinstance(stmt, solnodes2.If):
            # Solidity:
            #   if (x == 10) { f(); } else { g(); }
            #
            # IR:
            #
            # CurrentBlock:
            #  if (x == 10)  goto TrueBlock else goto FalseBlock
            # TrueBlock:
            #  f();
            #  goto ContinuationBlock
            # FalseBlock:
            #  g();
            #  goto ContinuationBlock
            # ContinuationBlock:
            #  ...
            #
            # Edges created:
            # CurrentBlock -> TrueBlock (true branch)
            # CurrentBlock -> FalseBlock (false branch)
            # FalseBlock -> ContinuationBlock (goto)
            # TrueBlock -> ContinuationBlock (goto)

            true_branch_block_s, true_branch_block_e = self.process_as_block(stmt.true_branch)
            false_branch_block_s, false_branch_block_e = self.process_as_block(stmt.false_branch)
            continuation_block = self.create_new_block()

            cur_block, condition_var = self.translate_expr(cur_block, stmt.condition)

            conditional_stmt = irnodes.Conditional(condition_var, true_branch_block_s, false_branch_block_s or continuation_block)
            cur_block.stmts.append(conditional_stmt)

            self.add_continuation(true_branch_block_e, continuation_block, irnodes.ControlEdge.GOTO, True)
            self.cfg.add_edge(cur_block, true_branch_block_s, irnodes.ControlEdge.TRUE_BRANCH)

            if stmt.false_branch:
                self.add_continuation(false_branch_block_e, continuation_block, irnodes.ControlEdge.GOTO, True)
                self.cfg.add_edge(cur_block, false_branch_block_s, irnodes.ControlEdge.FALSE_BRANCH)
            else:
                self.add_continuation(cur_block, continuation_block, irnodes.ControlEdge.FALSE_BRANCH)

            # the next statement we process will go into the continuation block
            cur_block = continuation_block
        elif isinstance(stmt, solnodes2.For):
            # Solidity:
            #   for (int i=0; i < 10; i++) {
            #       f();
            #   }
            #
            # IR:
            #
            # CurrentBlock:
            #  int i=0;
            #  goto HeaderBlock
            # LoopBlock:
            #  f();
            #  i++;
            # HeaderBlock:
            #  if (i < 10) goto LoopBlock else goto ContinuationBlock
            # ContinuationBlock:
            #  ...
            #
            # Edges created:
            # CurrentBlock -> HeaderBlock (goto)
            # LoopBlock -> HeaderBlock (immediate)
            # HeaderBlock -> LoopBlock (loop)
            # HeaderBlock -> ContinuationBlock (loop_exit)

            continuation_block = self.create_new_block()
            header_block = self.create_new_block()

            self.loop_stack.append(self.LoopData(continuation_block, header_block))

            loop_block_s, loop_block_e = self.process_as_block(stmt.body)

            # Current block
            if stmt.initialiser:
                # FIXME: this assumes that initialiser doesn't create a new block when it's translated
                # TODO: after translate_expr change to return contination block, this might be fixed, need to check
                cur_block = self.translate_stmt(cur_block, stmt.initialiser)

            cur_block.stmts.append(irnodes.Goto(header_block))

            if stmt.advancement:
                # the advancedment is an expr not a stmt, e.g. i++ but the value is not used
                loop_block_e, _ = self.translate_expr(loop_block_e, stmt.advancement, unused=True)

            # Header block
            header_block_, t_condition_var = self.translate_expr(header_block, stmt.condition)
            header_block.stmts.append(irnodes.Conditional(t_condition_var, loop_block_s, continuation_block))

            self.cfg.add_edge(cur_block, header_block, irnodes.ControlEdge.GOTO)
            self.cfg.add_edge(loop_block_e, header_block, irnodes.ControlEdge.IMMEDIATE)
            self.cfg.add_edge(header_block, loop_block_s, irnodes.ControlEdge.LOOP)
            self.cfg.add_edge(header_block, continuation_block, irnodes.ControlEdge.LOOP_EXIT)

            self.loop_stack.pop()

            # the next statement we process will go into the continuation block
            cur_block = continuation_block
        elif isinstance(stmt, solnodes2.While) and not stmt.is_do_while:
            # Solidity:
            #   while(condition) {
            #       f();
            #   }
            #
            # IR:
            #
            # CurrentBlock:
            #  ...
            #  goto HeaderBlock
            # LoopBlock:
            #  f();
            # HeaderBlock:
            #  if condition goto LoopBlock else goto ContinuationBlock
            # ContinuationBlock:
            #  ...
            #
            # Edges created:
            # CurrentBlock -> HeaderBlock (goto)
            # LoopBlock -> HeaderBlock (immediate)
            # HeaderBlock -> LoopBlock (loop)
            # HeaderBlock -> ContinuationBlock (loop_exit)

            continuation_block = self.create_new_block()
            header_block = self.create_new_block()

            self.loop_stack.append(self.LoopData(continuation_block, header_block))

            loop_block_s, loop_block_e = self.process_as_block(stmt.body)

            # Current block
            cur_block.stmts.append(irnodes.Goto(header_block))

            # Header block
            header_block, t_condition_var = self.translate_expr(header_block, stmt.condition)
            header_block.stmts.append(irnodes.Conditional(t_condition_var, loop_block_s, continuation_block))

            self.cfg.add_edge(cur_block, header_block, irnodes.ControlEdge.GOTO)
            self.cfg.add_edge(loop_block_e, header_block, irnodes.ControlEdge.IMMEDIATE)
            self.cfg.add_edge(header_block, loop_block_s, irnodes.ControlEdge.LOOP)
            self.cfg.add_edge(header_block, continuation_block, irnodes.ControlEdge.LOOP_EXIT)

            self.loop_stack.pop()

            # the next statement we process will go into the continuation block
            cur_block = continuation_block
        elif isinstance(stmt, solnodes2.While) and stmt.is_do_while:
            # Solidity:
            #   do {
            #       f();
            #   } while(condition);
            #
            # IR:
            #
            # CurrentBlock:
            #  ...
            #  goto LoopBlock
            # LoopBlock:
            #  f();
            # HeaderBlock:
            #  if condition goto LoopBlock else goto ContinuationBlock
            # ContinuationBlock:
            #  ...
            #
            # Edges created:
            # CurrentBlock -> LoopBlock (immediate)
            # LoopBlock -> HeaderBlock (immediate)
            # HeaderBlock -> LoopBlock (loop)
            # HeaderBlock -> ContinuationBlock (loop_exit)

            continuation_block = self.create_new_block()
            header_block = self.create_new_block()

            self.loop_stack.append(self.LoopData(continuation_block, header_block))

            loop_block_s, loop_block_e = self.process_as_block(stmt.body)

            # don't add this as it's an immediate TODO: check
            # cur_block.stmts.append(irnodes.Goto(loop_block_s))

            header_block, t_condition_var = self.translate_expr(header_block, stmt.condition)
            header_block.stmts.append(irnodes.Conditional(t_condition_var, loop_block_s, continuation_block))

            self.cfg.add_edge(cur_block, loop_block_s, irnodes.ControlEdge.IMMEDIATE)
            self.cfg.add_edge(loop_block_e, header_block, irnodes.ControlEdge.IMMEDIATE)
            self.cfg.add_edge(header_block, loop_block_s, irnodes.ControlEdge.LOOP)
            self.cfg.add_edge(header_block, continuation_block, irnodes.ControlEdge.LOOP_EXIT)

            self.loop_stack.pop()

            # the next statement we process will go into the continuation block
            cur_block = continuation_block
        elif isinstance(stmt, solnodes2.Break):
            # find the current loop, go to the loop continuation block
            current_loop = self.loop_stack[-1]
            cur_block.stmts.append(irnodes.Goto(current_loop.continuation))
            self.cfg.add_edge(cur_block, current_loop.continuation, irnodes.ControlEdge.LOOP_EXIT)
        elif isinstance(stmt, solnodes2.Continue):
            # find the current loop, go to the loop header block
            current_loop = self.loop_stack[-1]
            cur_block.stmts.append(irnodes.Goto(current_loop.header))
            self.cfg.add_edge(cur_block, current_loop.continuation, irnodes.ControlEdge.CONTINUE)
        elif isinstance(stmt, solnodes2.EmitEvent):
            cur_block, args = self.translate_exprs(cur_block, stmt.args)
            cur_block.stmts.append(irnodes.EmitEvent(stmt.event.x, args))
        elif isinstance(stmt, solnodes2.ExprStmt):
            cur_block, _ = self.translate_expr(cur_block, stmt.expr, unused=True, allow_void=stmt.expr.type_of().is_void())
        elif isinstance(stmt, solnodes2.Return):
            cur_block, vs = self.translate_exprs(cur_block, stmt.values)
            for v in vs:
                cur_block.stmts.append(irnodes.Return(v))
        elif isinstance(stmt, solnodes2.VarDecl):
            # E.g. if the stmt is uint x; then don't emit this in the IR since we don't differentiate assigns and decls
            new_local = self.make_unversioned_local_from_var(stmt.var)
            if stmt.value:
                cur_block, value = self.translate_expr(cur_block, stmt.value)
            else:
                value = irnodes.Undefined()
            cur_block.stmts.append(irnodes.LocalStore(new_local, value))
        elif isinstance(stmt, solnodes2.Require):
            cur_block, condition = self.translate_expr(cur_block, stmt.condition)
            if stmt.reason:
                cur_block, reason = self.translate_expr(cur_block, stmt.reason)
            else:
                reason = None
            cur_block.stmts.append(irnodes.Require(condition, reason))
        elif isinstance(stmt, solnodes2.TupleVarDecl):
            # (x,y,z) = A; to
            # t = A;
            # x = TUPLELOAD(A, 0);  ..., z = TUPLELOAD(A, 2);
            t = self.new_temp_var(stmt.value.type_of(), None)
            cur_block, value = self.translate_expr(cur_block, stmt.value)
            cur_block.stmts.append(irnodes.LocalStore(t, value))

            for idx, v in enumerate(stmt.vars):
                v_new = self.make_unversioned_local_from_var(v)
                rhs = irnodes.TupleLoad(t, idx)
                cur_block.stmts.append(irnodes.LocalStore(v_new, rhs))
        elif isinstance(stmt, solnodes2.Assembly):
            cur_block.stmts.append(irnodes.Assembly(stmt.code))
        elif isinstance(stmt, solnodes2.RevertWithReason):
            cur_block, reason = self.translate_expr(cur_block, stmt.reason)
            cur_block.stmts.append(irnodes.RevertWithReason(reason))
        elif isinstance(stmt, solnodes2.RevertWithError):
            cur_block, args = self.translate_exprs(cur_block, stmt.args)
            cur_block.stmts.append(irnodes.RevertWithError(stmt.error, args))
        elif isinstance(stmt, solnodes2.Try):
            # E.g. Solidity:
            #   try Target(target).doSomething() returns (string memory) {}
            # Create a new block for this:
            #   (string memory) = Target(target).doSomething() ;
            #
            # In general: try f() returns X
            #  if X is a tuple of vars, then we have to store f() as a tuple and do tuple loads for

            new_block = self.create_new_block()
            self.cfg.add_edge(cur_block, new_block, irnodes.ControlEdge.IMMEDIATE)
            cur_block = new_block

            if len(stmt.return_parameters) > 1:
                cur_block, t_var = self.translate_expr(cur_block, stmt.expr)
                for idx, param in enumerate(stmt.return_parameters):
                    v_new = self.make_unversioned_local_from_var(param.var)
                    rhs = irnodes.TupleLoad(t_var, idx)
                    cur_block.stmts.append(irnodes.LocalStore(v_new, rhs))
            else:
                param_var = self.make_unversioned_local_from_var(stmt.return_parameters[0].var)
                cur_block, value = self.translate_expr(cur_block, stmt.expr)
                cur_block.stmts.append(irnodes.LocalStore(param_var, value))

            try_code_block = cur_block
            success_block_start, success_block_end = self.process_block(stmt.body)
            self.cfg.add_edge(try_code_block, success_block_start, irnodes.ControlEdge.IMMEDIATE)

            # success block + error blocks are the "next blocks", i.e. each of these will have an immediate edge to the
            # next block we create
            next_blocks = [success_block_end]

            for idx, catch in enumerate(stmt.catch_clauses):
                c_start = self.create_new_block()
                for param in catch.parameters:
                    v = self.make_unversioned_local_from_var(param.var)
                    c_start.stmts.append(irnodes.LocalStore(v, irnodes.ErrorDefined(idx)))
                c_start, c_end = self.process_block(catch.body, ir_block=c_start)
                self.cfg.add_edge(try_code_block, c_start, irnodes.ControlEdge.ERROR)
                next_blocks.append(c_end)

            return self.create_merge_point(next_blocks) if merge_multiple_into_single else next_blocks
        else:
            raise ValueError(f'TODO: {type(stmt)}')

        return cur_block

    def add_params(self, func, block: irnodes.BasicBlock):
        for index, input_param in enumerate(func.inputs):
            old_var = input_param.var
            new_var = self.make_unversioned_local_from_var(old_var)
            block.stmts.append(irnodes.LocalStore(new_var, irnodes.InputParam(index, new_var)))

        # Define return parameters with their defaults
        for output_param in func.outputs:
            old_var = output_param.var
            if old_var.name and old_var.name.text:
                # named parameter
                new_var = self.make_unversioned_local_from_var(old_var)
                block.stmts.append(irnodes.LocalStore(new_var, irnodes.Default(new_var.ttype)))

    def process_block(self, ast2_block: solnodes2.Block, ir_block: irnodes.BasicBlock = None):
        start_block = cur_block = ir_block if ir_block else self.create_new_block()

        for stmt in ast2_block.stmts:
            cur_block = self.translate_stmt(cur_block, stmt)

        return start_block, cur_block

