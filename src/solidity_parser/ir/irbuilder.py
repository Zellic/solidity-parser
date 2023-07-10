from dataclasses import dataclass
from typing import Union, NamedTuple, List
from collections import deque

import solidity_parser.ast.solnodes2 as solnodes2
import solidity_parser.ir.nodes as irnodes


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

    def _init_state(self):
        self.current_block = None
        self.cfg = irnodes.ControlFlowGraph()
        self.loop_stack = deque()
        self.var_count = 0
        self.locals = set()

    def make_unversioned_local(self, id, ttype, location) -> UnversionedLocal:
        local = UnversionedLocal(id, ttype, location)
        self.locals.add(local)
        return local

    def new_temp_var(self, ttype, location) -> UnversionedLocal:
        tid = self.var_count
        self.var_count += 1
        return self.make_unversioned_local(f't{tid}', ttype, location)

    class LoopData(NamedTuple):
        continuation: irnodes.BasicBlock

    def translate_function(self, func):
        self._init_state()

        start_block, _ = self.process_block(func.code)

        print("CODE " + func.descriptor())
        print(func.code.code_str())
        print("GRAPH")
        print(self.cfg)
        print("GRAPH END")

        print(self.locals)

        print(self.cfg.get_dominance_frontier(start_block))
        for u, df in self.cfg.get_dominance_frontier(start_block).items():
            print(f'{u} = {df}')


    def _todo(self, x):
        # print(f'TODO: {type(x)}')
        # return irnodes.TempStmt(x.code_str())
        raise ValueError(f'{x.code_str()} :: {type(x)}')

    def create_new_block(self):
        bb = irnodes.BasicBlock(self.cfg.get_node_count())
        self.cfg.add_node(bb)
        return bb

    def process_as_block(self, stmt, **kwargs):
        if not stmt:
            return None, None

        if isinstance(stmt, solnodes2.Block):
            return self.process_block(stmt, **kwargs)
        else:
            bb = self.create_new_block(**kwargs)
            # TODO: process stmt here
            return bb, bb

    def named_args(self, cur_block: irnodes.BasicBlock, ns: List[solnodes2.NamedArgument]) -> List[irnodes.NamedArgument]:
        return [irnodes.NamedArgument(n.name.text, self.translate_expr(cur_block, n.expr)) for n in ns]

    def _translate_expr(self, cur_block, expr):

        if isinstance(expr, solnodes2.GlobalValue):
            return irnodes.GlobalValue(expr.name, expr.ttype)
        elif isinstance(expr, solnodes2.DynamicBuiltInValue):
            return irnodes.DynamicBuiltInValue(expr.name, expr.ttype, self.translate_expr(cur_block, expr.base))
        elif isinstance(expr, solnodes2.LocalVarLoad):
            var = expr.var
            return self.make_unversioned_local(var.name.text, var.ttype, var.location)
        elif isinstance(expr, solnodes2.GetType):
            return irnodes.GetType(expr.ttype)
        elif isinstance(expr, solnodes2.SelfObject):
            return irnodes.SelfObject(expr.declarer.x)
        elif isinstance(expr, solnodes2.Literal):
            return irnodes.Literal(expr.value, expr.ttype, expr.unit)
        elif isinstance(expr, solnodes2.BinaryOp):
            return irnodes.BinaryOp(
                self.translate_expr(cur_block, expr.left),
                self.translate_expr(cur_block, expr.right),
                expr.op
            )
        elif isinstance(expr, solnodes2.UnaryOp):
            return irnodes.UnaryOp(
                self.translate_expr(cur_block, expr.expr),
                expr.op,
                expr.is_pre
            )
        elif isinstance(expr, solnodes2.Call):
            named_args = self.named_args(cur_block, expr.named_args)
            args = [self.translate_expr(cur_block, e) for e in expr.args]
            if isinstance(expr, solnodes2.FunctionCall):
                base = self.translate_expr(cur_block, expr.base)
                new_expr = irnodes.FunctionCall(named_args, args, base, expr.name.text)
                return new_expr
            elif isinstance(expr, solnodes2.DirectCall):
                return irnodes.DirectCall(named_args, args, expr.ttype, expr.name.text)
        elif isinstance(expr, solnodes2.StateVarStore):
            base = self.translate_expr(cur_block, expr.base)
            value = self.translate_expr(cur_block, expr.value)
            cur_block.stmts.append(irnodes.StateVarStore(base, expr.name.text, value))
            return value
        elif isinstance(expr, solnodes2.LocalVarStore):
            var = expr.var
            new_var = self.make_unversioned_local(var.name.text, var.ttype, var.location)
            cur_block.stmts.append(irnodes.LocalStore(new_var, self.translate_expr(cur_block, expr.value)))
            return new_var
        elif isinstance(expr, solnodes2.StateVarLoad):
            return irnodes.StateVarLoad(self.translate_expr(cur_block, expr.base), expr.name.text)
        elif isinstance(expr, solnodes2.ArrayLoad):
            return irnodes.ArrayLoad(
                self.translate_expr(cur_block, expr.base),
                self.translate_expr(cur_block, expr.index)
            )
        elif isinstance(expr, solnodes2.ArrayStore):
            return irnodes.ArrayStore(
                self.translate_expr(cur_block, expr.base),
                self.translate_expr(cur_block, expr.index),
                self.translate_expr(cur_block, expr.base)
            )
        elif isinstance(expr, solnodes2.Cast):
            return irnodes.Cast(expr.ttype, self.translate_expr(cur_block, expr.value))
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
            # t0 = self.translate_expr(cur_block, expr.condition)
            # t1 = self.new_temp_var(expr.type_of())
            #
            # xblock = self.create_new_block()
            # yblock = self.create_new_block()
            # continuation_block = self.create_new_block()
            #
            # conditional_stmt = irnodes.Conditional(t0, xblock, yblock)
            # cur_block.stmts.append(conditional_stmt)
            #
            # xblock.stmts.append(irnodes.LocalStore(t1, self.translate_expr(xblock, expr.left)))
            # xblock.stmts.append(irnodes.Goto(continuation_block))
            # self.cfg.add_edge(cur_block, xblock, irnodes.ControlEdge.TRUE_BRANCH)
            # self.cfg.add_edge(xblock, continuation_block, irnodes.ControlEdge.GOTO)
            #
            # yblock.stmts.append(irnodes.LocalStore(t1, self.translate_expr(xblock, expr.right)))
            # yblock.stmts.append(irnodes.Goto(continuation_block))
            # self.cfg.add_edge(cur_block, yblock, irnodes.ControlEdge.FALSE_BRANCH)
            # self.cfg.add_edge(yblock, continuation_block, irnodes.ControlEdge.GOTO)
            #
            # continuation_block.stmts.append(irnodes.LocalStore())
            # # the next statement we process will go into the continuation block
            # cur_block = continuation_block
            pass

        return self._todo(expr)

    def translate_exprs(self, block: irnodes.BasicBlock, exprs: List[solnodes2.Expr]) -> List[UnversionedLocal]:
        return [self.translate_expr(block, e) for e in exprs]

    def translate_expr(self, block: irnodes.BasicBlock, expr: solnodes2.Expr, unused=False, allow_void=False) -> UnversionedLocal:
        t_val = self._translate_expr(block, expr)

        if t_val is None:
            return t_val

        # TODO: if we want to allow literals and globalvalues to be RHS exprs add them here
        # if it's already a local load, avoid unnecessary store and load
        if isinstance(t_val, (UnversionedLocal, irnodes.LocalVar)):
            return t_val

        ttype = expr.type_of()

        if ttype.is_void() or unused:
            # void return or unusable expr, can't be stored
            assert ttype.is_void() == allow_void
            block.stmts.append(irnodes.ExprStmt(t_val))
            return None
        else:
            # else store into a temp var and return the var
            t_var = self.new_temp_var(ttype, None)
            block.stmts.append(irnodes.LocalStore(t_var, t_val))
            return t_var

    def is_return_block(self, block: irnodes.BasicBlock) -> bool:
        if len(block.stmts) == 0:
            return False
        last_stmt = block.stmts[-1]
        return isinstance(last_stmt, irnodes.Return)

    def translate_stmt(self, cur_block, stmt):
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

            condition_var = self.translate_expr(cur_block, stmt.condition)

            conditional_stmt = irnodes.Conditional(condition_var, true_branch_block_s, false_branch_block_s or continuation_block)
            cur_block.stmts.append(conditional_stmt)

            true_branch_block_e.stmts.append(irnodes.Goto(continuation_block))
            self.cfg.add_edge(cur_block, true_branch_block_s, irnodes.ControlEdge.TRUE_BRANCH)
            self.cfg.add_edge(true_branch_block_e, continuation_block, irnodes.ControlEdge.GOTO)

            if stmt.false_branch:
                false_branch_block_e.stmts.append(irnodes.Goto(continuation_block))
                self.cfg.add_edge(cur_block, false_branch_block_s, irnodes.ControlEdge.FALSE_BRANCH)
                self.cfg.add_edge(false_branch_block_e, continuation_block, irnodes.ControlEdge.GOTO)
            else:
                self.cfg.add_edge(cur_block, continuation_block, irnodes.ControlEdge.FALSE_BRANCH)

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

            self.loop_stack.append(self.LoopData(continuation_block))

            loop_block_s, loop_block_e = self.process_as_block(stmt.body)

            # Current block
            if stmt.initialiser:
                # FIXME: this assumes that initialiser doesn't create a new block when it's translated
                cur_block = self.translate_stmt(cur_block, stmt.initialiser)

            cur_block.stmts.append(irnodes.Goto(header_block))

            # the advancedment is an expr not a stmt, e.g. i++ but the value is not used
            self.translate_expr(loop_block_e, stmt.advancement, unused=True)

            # Header block
            t_condition_var = self.translate_expr(header_block, stmt.condition)
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

            self.loop_stack.append(self.LoopData(continuation_block))

            loop_block_s, loop_block_e = self.process_as_block(stmt.body)

            # Current block
            cur_block.stmts.append(irnodes.Goto(header_block))

            # Header block
            t_condition_var = self.translate_expr(header_block, stmt.condition)
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

            self.loop_stack.append(self.LoopData(continuation_block))

            loop_block_s, loop_block_e = self.process_as_block(stmt.body)

            # don't add this as it's an immediate TODO: check
            # cur_block.stmts.append(irnodes.Goto(loop_block_s))

            t_condition_var = self.translate_expr(header_block, stmt.condition)
            header_block.stmts.append(irnodes.Conditional(t_condition_var, loop_block_s, continuation_block))

            self.cfg.add_edge(cur_block, loop_block_s, irnodes.ControlEdge.IMMEDIATE)
            self.cfg.add_edge(loop_block_e, header_block, irnodes.ControlEdge.IMMEDIATE)
            self.cfg.add_edge(header_block, loop_block_s, irnodes.ControlEdge.LOOP)
            self.cfg.add_edge(header_block, continuation_block, irnodes.ControlEdge.LOOP_EXIT)

            self.loop_stack.pop()

            # the next statement we process will go into the continuation block
            cur_block = continuation_block
        elif isinstance(stmt, solnodes2.Break):
            # find the current loop block
            current_loop = self.loop_stack[-1]

            cur_block.stmts.append(irnodes.Goto(current_loop.continuation))
            self.cfg.add_edge(cur_block, current_loop.continuation, irnodes.ControlEdge.LOOP_EXIT)
        elif isinstance(stmt, solnodes2.EmitEvent):
            new_stmt = irnodes.EmitEvent(stmt.event.x, self.translate_exprs(cur_block, stmt.args))
            cur_block.stmts.append(new_stmt)
        elif isinstance(stmt, solnodes2.ExprStmt):
            self.translate_expr(cur_block, stmt.expr, unused=True, allow_void=stmt.expr.type_of().is_void())
        elif isinstance(stmt, solnodes2.Return):
            vs = self.translate_exprs(cur_block, stmt.values)
            for v in vs:
                cur_block.stmts.append(irnodes.Return(v))
        elif isinstance(stmt, solnodes2.VarDecl):
            old_var = stmt.var
            new_local = self.make_unversioned_local(old_var.name.text, old_var.ttype, old_var.location)
            cur_block.stmts.append(irnodes.LocalStore(new_local, self.translate_expr(cur_block, stmt.value)))
        elif isinstance(stmt, solnodes2.Require):

            cur_block.stmts.append(irnodes.Require(
                self.translate_expr(cur_block, stmt.condition),
                self.translate_expr(cur_block, stmt.reason)
            ))
        else:
            raise ValueError(f'TODO: {type(stmt)}')

        return cur_block

    def process_block(self, ast2_block):
        start_block = cur_block = self.create_new_block()

        for stmt in ast2_block.stmts:
            cur_block = self.translate_stmt(cur_block, stmt)

        return start_block, cur_block

