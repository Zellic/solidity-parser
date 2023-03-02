from solidity_parser.ast.symtab import ContractOrInterfaceScope
from typing import List


def _merge(*sequences):
    result = []
    while True:
        non_empty_seqs = [s for s in sequences if s]

        if not non_empty_seqs:
            return result

        candidate = None

        for seq in non_empty_seqs:
            candidate = seq[0]
            matching_tail = [s for s in non_empty_seqs if candidate in s[1:]]
            if matching_tail:
                candidate = None
            else:
                break

        assert candidate, f'No MRO for {sequences}'
        result.append(candidate)

        for seq in non_empty_seqs:
            if seq[0] == candidate:
                del seq[0]


def c3_linearise(klass: ContractOrInterfaceScope, get_supers=None) -> List[ContractOrInterfaceScope]:
    if get_supers is not None:
        superklasses = get_supers(klass)
    else:
        superklasses = klass.get_supers()

    # In solidity this is reversed for some reason
    superklasses = list(reversed(superklasses))
    if not superklasses:
        return [klass]
    else:
        return [klass] + _merge(*[c3_linearise(k, get_supers) for k in superklasses], superklasses)
