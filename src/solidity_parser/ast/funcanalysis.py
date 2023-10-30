from typing import List, Union

from solidity_parser.ast.solnodes2 import FunctionCall, DirectCall, ResolvedUserType, TopLevelUnit, FunctionDefinition, Type, SuperType, Node, SuperObject, SelfObject
from solidity_parser.ast.mro_helper import c3_linearise
from solidity_parser.ast.solnodes import VisibilityModifierKind, MutabilityModifierKind

def find_possible_calls(declared_ttype: Union[ResolvedUserType, SuperType], name: str, arg_types: List[Type], match_filter=lambda x: True, use_subtypes=True) -> List[FunctionDefinition]:
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
        if isinstance(p, FunctionDefinition) and p.name.text == name:
            if len(p.inputs) == len(arg_types):
                f_types = [x.var.ttype for x in p.inputs]
                return Type.are_matching_types(f_types, arg_types)
        return False

    # List[TopLevelUnit]
    if use_subtypes or isinstance(declared_ttype, SuperType):
        target_types = declared_ttype.get_types_for_declared_type()
    else:
        target_types = [declared_ttype.value.x]

    results = set()
    implementors = []

    for t in target_types:
        # try:
        #     if t.is_interface() or t.is_abstract:
        #         continue
        # except AttributeError:
        #     pass  # not abstract, e.g. library

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

def find_possible_fc_calls(fc: Union[FunctionCall, DirectCall], **kwargs) -> List[FunctionDefinition]:
    declared_ttype = fc.base_type()
    return find_possible_calls(declared_ttype, str(fc.name), [arg.type_of() for arg in fc.args], **kwargs)


def mark_sources(units: List[TopLevelUnit]):
    # sources = []
    for u in units:
        for p in u.parts if hasattr(u, 'parts') else []:
            if p.has_modifier_kind(VisibilityModifierKind.PUBLIC, VisibilityModifierKind.EXTERNAL) and not p.has_modifier_kind(MutabilityModifierKind.PURE, MutabilityModifierKind.VIEW):
                if isinstance(p, FunctionDefinition):
                    # "Sources are public/external functions (not view/pure function)"
                    # sources.append(p)
                    p.is_fca_source = True
    # return sources

def is_fca_important(f):
    return any('fca-important' in c for c in f.comments)


def find_important_paths2(source: FunctionDefinition):
    def dfs(f):
        # List of (call node, is_external_call)
        important_paths = []

        if not f.code:
            return []

        for code_node in f.code.get_all_children():
            if isinstance(code_node, (FunctionCall, DirectCall)):
                self_call = not ((isinstance(code_node, FunctionCall) and not isinstance(code_node.base, (SelfObject, SuperObject))) or isinstance(code_node, DirectCall))

                if self_call:
                    targets = find_possible_calls(code_node.base_type(), code_node.name.text, [arg.type_of() for arg in code_node.args], use_subtypes=False)
                    assert len(targets) == 1

                    # we only get back paths if we hit a sink and only propagate them forward if we get those paths
                    dfs_valid_paths = dfs(targets[0])
                    for p in dfs_valid_paths:
                        important_paths.append([(code_node, False), *p])

                    if not dfs_valid_paths and is_fca_important(targets[0]):
                        # sink (marked with // fca-important)
                        important_paths.append([(code_node, True)])
                else:
                    # sink (intercontract call)
                    important_paths.append([(code_node, True)])

        return important_paths

    return dfs(source)