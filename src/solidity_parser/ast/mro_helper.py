from typing import TypeVar, Callable


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


T = TypeVar('T')


def c3_linearise(klass: T, get_supers: Callable[[T], list[T]] = None) -> list[T]:
    """
    A function to linearise the class hierarchy using the C3 linearisation algorithm.

    :param klass: The class to linearise.
    :param get_supers: A function to get the superclasses of a given class, must return a list of classes with the same
                       type as the input
    :return: A linearised list of classes following the C3 algorithm.
    """

    if get_supers is not None:
        superclasses = get_supers(klass)
    else:
        superclasses = klass.get_supers()

    # In solidity this is reversed for some reason
    superclasses = list(reversed(superclasses))
    if not superclasses:
        return [klass]
    else:
        return [klass] + _merge(*[c3_linearise(k, get_supers) for k in superclasses], superclasses)
