
from collections import defaultdict, deque
from typing import Set, Dict, Tuple
import solidity_parser.ir.nodes as nodes


class State:
    def __init__(self, cfg):
        self.cfg = cfg

        def _map():
            return defaultdict(set)
        # Dict[BasicBlock, Set[LocalVar]]
        self.uses = _map()
        self.defs = _map()
        self.live_in = _map()
        self.live_out = _map()
        self.phi_defs = _map()

        # Dict[BasicBlock, Dict[Block, Set[LocalVar]]]
        # phi_uses[block][succ] == phi uses
        self.phi_uses = defaultdict(_map)

        self.queue = deque()

    def init(self):
        self.queue.extend(self.cfg.get_nodes())

        for b in self.cfg.get_nodes():
            self.precompute(b)

    def precompute(self, block: nodes.BasicBlock):
        for phi in reversed(block.phis):
            self.phi_defs[block].add(phi.var)
            for succ, use in phi.args.items():
                self.phi_uses[block][succ].add(use)

        for stmt in reversed(block.stmts):
            for d in stmt.get_defines():
                self.defs[block].add(d)
                self.uses[block].discard(d)
            for u in stmt.get_uses():
                self.uses[block].add(u)

    def compute(self):
        # +use/-def affects out
        # -use/+def affects in
        # negative handling is always done after positive handling and additions

        while self.queue:
            b = self.queue.popleft()

            prev_in = self.live_in[b].copy()
            curr_in = self.uses[b].copy()
            curr_out = set()

            preds = self.cfg.get_preds_only(b)
            succs = self.cfg.get_succs_only(b)

            # out[n] = U(s in succ[n])(in[s])
            for s in succs:
                curr_out |= self.live_in[s]

            # negative phi handling for defs
            for s in succs:
                curr_out -= self.phi_defs[s]

            # positive phi handling for uses, see §5.4.2 "Meaning of copy statements in Sreedhar's method"
            for s in succs:
                curr_out |= self.phi_uses[s][b]

            # negative phi handling for uses
            for p in preds:
                curr_in -= self.phi_uses[b][p]

            # positive phi handling for defs
            curr_in |= self.phi_defs[b]

            # in[n] = use[n] U(out[n] - def[n])
            curr_in |= (self.live_out[b].difference(self.defs[b]))
            curr_in |= self.uses[b]

            self.live_in[b] = curr_in
            self.live_out[b] = curr_out

            if prev_in != curr_in:
                for p in preds:
                    if p not in self.queue:
                        self.queue.append(p)


def liveness(cfg) -> Tuple[Dict[nodes.BasicBlock, Set[nodes.LocalVar]], Dict[nodes.BasicBlock, Set[nodes.LocalVar]]]:
    s = State(cfg)
    s.init()
    s.compute()
    return s.live_in, s.live_out
