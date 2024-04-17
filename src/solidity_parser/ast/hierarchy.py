from solidity_parser.ast.nodebase import Ref
from solidity_parser.ast.solnodes2 import TopLevelUnit


def build_hierarchy(top_level_units: list[TopLevelUnit]) -> None:
    """
    Annotates the top level units with their direct subtypes, e.g. if A extends B, then A._subtypes = [B]
    """
    for u in top_level_units:
        supers = u.get_supers()
        for s in supers:
            s._subtypes.append(Ref(u))

