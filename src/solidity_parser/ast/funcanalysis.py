from typing import List, Union

from solidity_parser.ast.solnodes2 import FunctionCall, ResolvedUserType, TopLevelUnit, FunctionDefinition, Type, SuperType
from solidity_parser.ast.mro_helper import c3_linearise

def find_possible_calls(declared_ttype: Union[ResolvedUserType, SuperType], name: str, arg_types: List[Type], match_filter=lambda x: True) -> List[FunctionDefinition]:
    # this is probably not the best way to do it but here the algorithm to determine what could possibly be called
    # for the given declared type and function descriptor:
    # 1. take the declared type + its subtypes and filter out the abstract types as its not possible to instantiate an
    #    abstract type
    # 2. for each of these types (t)
    #  a) calculate the MRO
    #  b) go down the MRO in order and find the first matching function (f)
    # 3. the pair (t, f) is a possible instantiated callee, add f to the results set
    # 4. return the results set
    # This algorithm is for function calls that go to a resolved user type (i.e. not to resolve abi.decode or something)
    # and not to resolve built in calls (e.g. myAddr.call(...))

    def descriptor_matches(p):
        if isinstance(p, FunctionDefinition) and str(p.name) == name:
            if len(p.inputs) == len(arg_types):
                f_types = [x.var.ttype for x in p.inputs]
                return Type.are_matching_types(f_types, arg_types)
        return False

    target_types: List[TopLevelUnit] = declared_ttype.get_types_for_declared_type()

    results = set()
    implementors = []

    for t in target_types:
        try:
            if t.is_interface() or t.is_abstract:
                continue
        except ValueError:
            pass  # not abstract, e.g. library

        implementors.append(t)

        mro: List[TopLevelUnit] = c3_linearise(t)
        for x in mro:
            candidates = []
            for p in x.parts:
                if descriptor_matches(p) and match_filter(p):
                    candidates.append(p)
            assert len(candidates) <= 1
            if len(candidates) == 1:
                results.add(candidates[0])
                break  # found for t, move onto next declarable contract

    # if len(results) == 0 and len(implementors) > 0:
    #     raise ValueError(f'{len(implementors)} type implementors for {ttype_def} but 0 matching functions for {name}{arg_types}')

    return list(results)

def find_possible_fc_calls(fc: FunctionCall, **kwargs) -> List[FunctionDefinition]:
    declared_ttype = fc.base.type_of()
    return find_possible_calls(declared_ttype, str(fc.name), [arg.type_of() for arg in fc.args], **kwargs)
