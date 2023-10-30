from typing import List
from solidity_parser.ast.solnodes2 import Ref, TopLevelUnit


def build_hierarchy(top_level_units: List[TopLevelUnit]):
    for u in top_level_units:
        supers = u.get_supers()
        for s in supers:
            s._subtypes.append(Ref(u))

