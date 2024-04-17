import logging
from typing import List, Union
from enum import Enum

from solidity_parser.ast.solnodes2 import (FunctionCall, DirectCall, ResolvedUserType, TopLevelUnit, FunctionDefinition,
                                           SuperType, AST2Node, SuperObject, SelfObject, UnprocessedCode, Stmt,
                                           Assembly)
from solidity_parser.ast.types import Type
from solidity_parser.ast.mro_helper import c3_linearise
from solidity_parser.ast.solnodes import VisibilityModifierKind, MutabilityModifierKind

from networkx import DiGraph


def find_matching_function_in_type(ttype: TopLevelUnit, name, arg_types, ignore_current_type=False):
    def descriptor_matches(p):
        if isinstance(p, FunctionDefinition) and p.name.text == name:
            if len(p.inputs) == len(arg_types):
                f_types = [x.var.ttype for x in p.inputs]
                return Type.are_matching_types(f_types, arg_types)
        return False

    mro: List[TopLevelUnit] = c3_linearise(ttype)

    if ignore_current_type:
        # super calls: don't want to check the current contract
        mro = mro[1:]

    for candidate_unit in mro:
        candidates = []
        for p in candidate_unit.parts:
            if descriptor_matches(p):
                candidates.append(p)
        assert len(candidates) <= 1
        if len(candidates) == 1:
            return candidates[0]

    return None


def find_possible_matching_functions_for_declared_type(declared_ttype: ResolvedUserType, name, arg_types, is_super_call):
    results = set()

    if hasattr(declared_ttype, 'declarer'):
        declared_unit = declared_ttype.declarer.x
    else:
        declared_unit = declared_ttype.value.x

    inst_units = [declared_unit] if is_super_call else [declared_unit, *declared_ttype.value.x.get_supers()]

    for instantiated_type_unit in inst_units:
        call_target = find_matching_function_in_type(instantiated_type_unit, name, arg_types)
        if call_target:
            results.add(call_target)

    return results


def add_function_to_cg(cg: DiGraph, finished_functions, function: FunctionDefinition):
    if function in finished_functions:
        return
    finished_functions.add(function)

    if function not in cg:
        cg.add_node(function)

    if not function.code:
        return

    for code_node in function.code.get_all_children():
        if isinstance(code_node, (FunctionCall, DirectCall)):
            cg.add_edge(function, code_node)

            is_super_call = isinstance(code_node, FunctionCall) and isinstance(code_node.base, SuperObject)
            declared_ttype = code_node.base_type()

            target_functions = find_possible_matching_functions_for_declared_type(declared_ttype, code_node.name.text,
                                                                                  [arg.type_of() for arg in
                                                                                   code_node.args], is_super_call)

            for t_f in target_functions:
                cg.add_edge(code_node, t_f)

            for t_f in target_functions:
                add_function_to_cg(cg, finished_functions, t_f)


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

    is_super_call = isinstance(declared_ttype, SuperType)

    if is_super_call:
        target_types = [declared_ttype.declarer.x]
    else:
        target_types = declared_ttype.get_types_for_declared_type()

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

        if is_super_call:
            mro = mro[1:]

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


def mark_sources(units: List[TopLevelUnit]):
    sources = []
    for u in units:
        for p in u.parts if hasattr(u, 'parts') else []:
            if p.has_modifier_kind(VisibilityModifierKind.PUBLIC, VisibilityModifierKind.EXTERNAL) and not p.has_modifier_kind(MutabilityModifierKind.PURE, MutabilityModifierKind.VIEW):
                if isinstance(p, FunctionDefinition):
                    # "Sources are public/external functions (not view/pure function)"
                    sources.append(p)
                    p.is_fca_source = True
    return sources


def is_fca_important(f: FunctionDefinition):
    return any('fca-important' in c for c in f.comments)


def is_blackbox_node(f: FunctionDefinition):
    return isinstance(f.code, UnprocessedCode)


def has_inline_yul(f: FunctionDefinition):
    return any([isinstance(s, Assembly) for s in f.get_all_children(lambda n: isinstance(n, Stmt))])


class PathEdgeKind(Enum):
    INTRA_CALL = 1
    SINK_INTER = 2
    SINK_NO_CODE = 3
    SINK_FCA_IMPORTANT = 4
    SINK_INLINE_YUL = 5


def find_important_paths2(source: FunctionDefinition):
    def dfs(f, visited, prefix):
        # List of (call node, is_external_call)
        if not f.code:
            return []

        if f in visited:
            # print("RECURSIVE")
            return []

        visited.add(f)

        if is_blackbox_node(f):
            # sink because function couldn't be processed in AST, no further analysis possible along this path
            return [[(f, PathEdgeKind.SINK_NO_CODE)]]

        important_paths = []

        for code_node in f.code.get_all_children():
            if isinstance(code_node, (FunctionCall, DirectCall)):
                self_call = not ((isinstance(code_node, FunctionCall) and not isinstance(code_node.base, (SelfObject, SuperObject))) or isinstance(code_node, DirectCall))

                if self_call:
                    targets = find_possible_calls(code_node.base_type(), code_node.name.text, [arg.type_of() for arg in code_node.args], use_subtypes=False)
                    assert len(targets) >= 1

                    # we only get back paths if we hit a sink and only propagate them forward if we get those paths
                    for t in targets:
                        dfs_valid_paths = dfs(t, visited, prefix + '  ')
                        for p in dfs_valid_paths:
                            important_paths.append([(code_node, PathEdgeKind.INTRA_CALL), *p])

                        if not dfs_valid_paths and is_fca_important(t):
                            # sink (marked with // fca-important)
                            important_paths.append([(code_node, PathEdgeKind.SINK_FCA_IMPORTANT)])

                        if has_inline_yul(t):
                            # sink because of inline asm
                            important_paths.append([(code_node, PathEdgeKind.SINK_INLINE_YUL)])

                else:
                    # sink (intercontract call)
                    important_paths.append([(code_node, PathEdgeKind.SINK_INTER)])

        return important_paths

    return dfs(source, set(), '')