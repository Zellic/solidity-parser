from typing import Union, List, Dict, Optional, Type, Tuple, Set, Collection
from collections import defaultdict
from enum import Enum

from solidity_parser.ast import solnodes, types as soltypes, nodebase
from solidity_parser.filesys import LoadedSource, VirtualFileSystem

from solidity_parser.ast.mro_helper import c3_linearise
import logging

import solidity_parser.util.version_util as version_util


Aliases = Union[str, List[str]]


def bytes():
    return soltypes.BytesType()


def bytesn(n):
    return soltypes.FixedLengthArrayType(soltypes.ByteType(), n)


def bytes32():
    return bytesn(32)


def uint(size=256):
    return soltypes.IntType(False, size)


def ACCEPT(x):
    return True


def unit_scope_of(s):
    return s.find_first_ancestor_of((FileScope, ContractOrInterfaceScope, EnumScope, LibraryScope, UserDefinedValueTypeScope))


def ACCEPT_INHERITABLE(base_scope):
    # creates a predicate. the given scope is the current scope where any lookup is allowed
    # e.g. if we are in a function in contract C we can access other members of C fine, but not
    base_unit_scope = unit_scope_of(base_scope)
    def do_test(x: 'Symbol'):
        # private accessible in its own scope
        if unit_scope_of(x) == base_unit_scope:
            return True
        is_private = solnodes.has_modifier_kind(x.value, solnodes.VisibilityModifierKind.PRIVATE)
        return not is_private
    return do_test


def is_top_level(node: nodebase.Node):
    # Error and FunctionDefinitions are set as SourceUnits in AST1 but not in AST2
    return isinstance(node, (solnodes.ContractDefinition, solnodes.InterfaceDefinition, solnodes.LibraryDefinition,
                             solnodes.EnumDefinition, solnodes.UserValueType, solnodes.StructDefinition))


def is_using_directive_scope(sym: 'Symbol') -> bool:
    return isinstance(sym, ProxyScope) and isinstance(sym.created_by.value, solnodes.UsingDirective)


def predicate_ignore_inherited_usings(base_scope):
    base_unit_scope = unit_scope_of(base_scope)

    def accept(sym: 'Symbol') -> bool:
        if is_using_directive_scope(sym):
            # dont inherit scopes created by using directives
            return unit_scope_of(sym) == base_unit_scope
        return True
    return accept


def predicate_accept_top_levels(sym: 'Symbol') -> bool:
    resolved_sym = sym.res_syms_single()
    return is_top_level(resolved_sym.value)


def ACCEPT_NO_INHERITED_USINGS(base_scope):
    base_unit_scope = unit_scope_of(base_scope)
    def accept(sym: 'Symbol'):
        resolved_sym = sym.res_syms_single()
        if isinstance(sym, ProxyScope) and isinstance(sym.created_by.value, solnodes.UsingDirective):
            return unit_scope_of(sym) == base_unit_scope  # dont inherit scopes created by using directives
        return is_top_level(resolved_sym.value)
    return accept


def ACCEPT_CALLABLES(x):
    return isinstance(x, ModFunErrEvtScope)


def ACCEPT_NOT(p):
    return lambda x: not p(x)


def ACCEPT_TOP_LEVEL_SCOPE(x):
    return isinstance(x, (FileScope, ContractOrInterfaceScope, StructScope, LibraryScope, EnumScope, UserDefinedValueTypeScope))


def ACCEPT_ALL(*predicates):
    return lambda x: all([p(x) for p in predicates])


def test_predicate(xs, predicate=None):
    if not predicate:
        predicate = ACCEPT
    return [x for x in xs if predicate(x)]


def _add_to_results(possible_symbols: Collection, results: List, found_already: Set):
    for s in possible_symbols:
        res_syms = s.get_as_dealiased_symbols()
        for base_s in res_syms:
            if base_s not in found_already:
                found_already.add(base_s)
                results.append(s)


class Scopeable:
    """Element that can be added as a child of a Scope"""
    
    def __init__(self, aliases: Optional[Aliases]):
        self.parent_scope: Optional[Scope] = None
        
        # make it into a list if it's not
        if aliases is None:
            aliases = []
        elif not isinstance(aliases, list):
            aliases = [aliases]

        self.aliases: List[str] = aliases

    def set_parent_scope(self, parent_scope: 'Scope'):
        assert self.parent_scope is None, 'Element is already scoped'
        self.parent_scope = parent_scope

    def find_first_ancestor(self, predicate, get_parent=None):
        """Walks up the symbol tree and finds the first element that satisfies the given predicate"""
        if get_parent is None:
            get_parent = lambda x: x.parent_scope

        current = self
        while current and not predicate(current):
            current = get_parent(current)
        return current

    def find_first_ancestor_of(self, ttype: Union[Type, Tuple[Type]]):
        return self.find_first_ancestor(lambda x: isinstance(x, ttype))

    def _check_single_symbol(self, name, results, default):
        if len(results) == 1:
            return results[0]

        if len(results) > 1:
            all_the_same = all([results[0] == s for s in results[1:]])
            if not all_the_same:
                raise ValueError(f'Expected 1 but got {len(results)} symbols for "{name}" in scope {self.aliases[0]}')
            else:
                return results[0]

        return default


class Symbol(Scopeable):
    def __init__(self, aliases: Optional[Aliases], value):
        Scopeable.__init__(self, aliases)

        self.value = value
        self.order = -1

    def get_as_dealiased_symbols(self) -> List['Symbol']:
        return [self]

    def res_syms(self) -> List['Symbol']:
        # Return the symbols this symbol points to, if any exist.
        return [self]

    def res_syms_single(self):
        possible_symbols = self.res_syms()
        return self._check_single_symbol('', possible_symbols, None)

    def set_parent_scope(self, parent_scope: 'Scope'):
        Scopeable.set_parent_scope(self, parent_scope)
        self.order = len(parent_scope.symbols)

    def str_type(self):
        return '' if not self.value else f' @{type(self.value).__name__}'

    def __str__(self, level=0):
        return f"{type(self).__name__}: {self.aliases}{self.str_type()}"


class CrossScopeSymbolAlias(Symbol):
    def __init__(self, aliases: Aliases, other_symbol: Symbol):
        Symbol.__init__(self, aliases, other_symbol.value)
        self.other_symbol = other_symbol

    def res_syms(self) -> List['Symbol']:
        return self.other_symbol.res_syms()

    def get_as_dealiased_symbols(self) -> List[Symbol]:
        return self.other_symbol.get_as_dealiased_symbols()


class Scope(Scopeable):
    def __init__(self, aliases: Optional[Aliases]):
        Scopeable.__init__(self, aliases)
        # collection of known mappings that can be looked up quickly
        self.symbols: Dict[str, List[Symbol]] = defaultdict(list)
        self.imported_scopes: List[Scope] = []

    def is_defined(self, name: str) -> bool:
        # check if the name exists in the table and it contains something
        return name in self.symbols and bool(self.symbols[name])

    def get_direct_children(self) -> Collection[Symbol]:
        return set([item for sublist in self.symbols.values() for item in sublist])

    def get_all_children(self, collect_predicate, explore_branch_predicate):
        for direct_child in self.get_direct_children():
            if collect_predicate(direct_child):
                yield direct_child

            if isinstance(direct_child, Scope) and explore_branch_predicate(direct_child):
                yield from direct_child.get_all_children(collect_predicate, explore_branch_predicate)

    def get_all_functions(self):
        # common case for some operators: get child functions
        collect = lambda s: isinstance(s.value, solnodes.FunctionDefinition)
        # don't explore into UsingDirectives, don't want to collect UsingFunctionSymbols for the caller
        explore = lambda s: isinstance(s.value, solnodes.SourceUnit)
        return self.get_all_children(collect, explore)

    def import_symbols_from_scope(self, other_scope: 'Scope'):
        self.imported_scopes.append(other_scope)

    def add_global_symbol(self, symbol: Symbol):
        root_scope = self.find_first_ancestor_of(RootScope)
        root_scope.add(symbol)

    def add(self, symbol: Symbol):
        symbol.set_parent_scope(self)

        for name in symbol.aliases:
            self.symbols[name].append(symbol)

    def find_current_level(self, name: str, predicate=None, visited_scopes: Set = None) -> Optional[List[Symbol]]:
        if visited_scopes is not None:
            if self in visited_scopes:
                return []
            visited_scopes.add(self)

        found_symbols = test_predicate(self.find_local(name), predicate)

        if not found_symbols:
            found_symbols = self.find_imported(name, predicate, visited_scopes)
        return found_symbols

    def find_imported(self, name: str, predicate=None, visited_scopes: Set = None) -> Optional[List[Symbol]]:
        found_already = set()
        results = []
        for scope in self.imported_scopes:
            syms = scope.find_current_level(name, predicate, visited_scopes)
            _add_to_results(syms, results, found_already)
        return results

    def find_local(self, name: str) -> Optional[List[Symbol]]:
        """Finds a mapped symbol in this scope only"""
        if name in self.symbols:
            return list(self.symbols[name])
        return []

    def find_from_parent(self, name: str, predicate=None) -> List[Symbol]:
        return self.parent_scope.find(name, predicate=predicate) if self.parent_scope else []

    def find_multi_part_symbol(self, name, find_base_symbol: bool = False, predicate=None):
        if '.' in name:
            parts = name.split('.')
            s = self
            for p in parts:
                s = s.find_single(p, find_base_symbol=find_base_symbol, predicate=predicate)
            return s
        else:
            return self.find_single(name, find_base_symbol=find_base_symbol, predicate=predicate)

    def find(self, name: str, find_base_symbol: bool = False, predicate=None, dealias: bool = True) -> Optional[List[Symbol]]:
        visited_scopes = set()
        # check this scope first
        found_symbols = self.find_current_level(name, predicate, visited_scopes)

        # check the parent scope if it wasn't in this scope
        if not found_symbols:
            found_symbols = self.find_from_parent(name, predicate)

        if not found_symbols:
            return []

        # get the base symbols if required
        if find_base_symbol:
            return [res_sym for s in found_symbols for res_sym in s.res_syms()]
        elif dealias:
            return [dea_sym for s in found_symbols for dea_sym in s.get_as_dealiased_symbols()]
        else:
            return list(found_symbols)

    def find_single(self, name: str, find_base_symbol: bool = False, default=None, predicate=None) -> Optional[Symbol]:
        results = self.find(name, find_base_symbol=find_base_symbol, predicate=predicate)
        return self._check_single_symbol(name, results, default)

    def find_user_type_scope(self, name, find_base_symbol: bool = False, default=None, predicate=None) -> 'Scope' | List['Scope']:
        if not default and not find_base_symbol:
            default = []
        # find_base_symbol causes this function to return the single base scope(i.e. a Contract/Lib/etc Scope)
        # instead of a Proxy or Using scope that shadows the base scope.
        # If this parameter isn't supplied, you might get multiple scopes (including Proxy/Using scopes) that all
        # represent this name

        if '.' in name:
            qualifier, search_str = name.rsplit('.', 1)
            scope_to_search_in = self.find_user_type_scope(qualifier, find_base_symbol=True, predicate=predicate)
        else:
            scope_to_search_in, search_str = self, name

        pred_fs = [
            predicate_ignore_inherited_usings(scope_to_search_in),
            predicate_accept_top_levels
        ]

        if predicate:
            pred_fs.append(predicate)

        def total_pred(preds):
            def accept(symbol):
                return all([p(symbol) for p in preds])
            return accept

        def only_using_scopes(symbol):
            return isinstance(symbol, ProxyScope) and isinstance(symbol.created_by, UsingDirectiveScope)

        def do_search(using_mode):
            if using_mode:
                search_pred = total_pred(pred_fs + [only_using_scopes])
            else:
                search_pred = total_pred(pred_fs)
            results = scope_to_search_in.find(search_str, predicate=search_pred, dealias=False)

            if not find_base_symbol:
                return results

            # the only proxy scope allowed in the results is the one created in the current contract
            if len(results) > 1:
                if is_using_directive_scope(results[0]):
                    return results[0]

            return scope_to_search_in._check_single_symbol(search_str, results, default)

        # This double search, first to find using scopes only and then to find non using scopes is to fix the case in
        # testcases/using_directives/DefinedInSameScope.sol
        result = do_search(True)

        if not result:
            result = do_search(False)

        if not result:
            result = default

        return result.res_syms_single() if find_base_symbol else result

    def find_type(self, ttype, predicate=None, as_single=False) -> 'Scope':
        key = type_key(ttype)

        if as_single:
            possible_scope = self.find_single(key, predicate=predicate)
            if possible_scope:
                return possible_scope
        else:
            possible_scopes = self.find(key, predicate=predicate)
            if possible_scopes:
                return possible_scopes

        if ttype.is_array():
            # Arrays are also kind of meta types but the key is formed as a normal type key instead of a metatype
            # key. Depending on the storage type of the array (which we don't currently associated with the Type
            # itself: this requires investigation)
            # The following members can be available:
            # https://docs.soliditylang.org/en/develop/types.html#array-members
            # We add them all regardless of the storage type and will let code later on handle the rules for
            # allowing calls to arrays with the wrong storage location.

            values = [('length', soltypes.IntType(False, 256))]
            # These are not available for String (which is a subclass of Array)
            methods = [
                # TODO: should these be copied?
                ('push', [], [ttype.base_type]),
                # Before solidity 0.6, this returns the new array length, >= 0.6 returns nothing
                ('push', [ttype.base_type], []),
                ('pop', [], [])
            ] if not ttype.is_string() else []
            scope = create_builtin_scope(key, ttype, values=values, functions=methods)
        else:
            # TODO: guard for the probably bit
            # this is a primitive (probably). E.g. We look up <type: int256>
            fields = []
            methods = []
            if ttype.is_function():
                # Function selector, specific to the function type itself
                fields.append(('selector', soltypes.FixedLengthArrayType(soltypes.ByteType(), 4)))
                # before solidity 0.7 instead of f{gas: x, value: y)(args), f.gas(x).value(y)(args) was the way
                # options were passed
                # To simulate this, we stub value and gas as functions that have the function type itself as the
                # return type
                methods = [
                    ('value', [soltypes.IntType(False, 256)], [ttype]),
                    ('gas', [soltypes.IntType(False, 256)], [ttype]),
                ]
            scope = create_builtin_scope(key, ttype, values=fields, functions=methods)
        self.add_global_symbol(scope)

        return scope if as_single else [scope]

    def find_metatype(self, ttype, is_interface, is_enum) -> 'Scope':
        # Find or create a scope with the type <metatype: {ttype}> on demand which has the builtin values that
        # type(ttype) has in Solidity
        key = meta_type_key(ttype)
        scope = self.find_single(key)

        # It doesn't exist, create it and set it as the 'scope'
        if scope is None:
            # Create a meta type entry in the symbol table
            # Fields from https://docs.soliditylang.org/en/latest/units-and-global-variables.html#type-information
            members = [
                ('name', soltypes.StringType()), ('creationCode', bytes()),
                ('runtimeCode', bytes())
            ]

            # X in type(X)
            # base_ttype = ttype.ttype

            # All the int types have a min and a max
            if ttype.is_int() or is_enum:
                members.extend([('min', ttype), ('max', ttype)])

            # Interfaces have interfaceId (bytes4)
            # if is_interface:
            members.append(('interfaceId', soltypes.FixedLengthArrayType(soltypes.ByteType(), 4)))

            # Create the scope based on the above selected members
            self.add_global_symbol(scope := create_builtin_scope(key, ttype, values=members))
            return scope
        elif isinstance(scope, BuiltinObject):
            # already exists as a builtin
            return scope
        else:
            # can't base it off anything (for now)
            assert False, 'Can\'t base metatype scope on another scope'

    def str__symbols(self, level=0):
        indent = '  ' * level
        indent1 = '  ' + indent

        all_syms = self.get_direct_children()

        if all_syms:
            nl_indent = '\n' + indent1
            strs = [sym.__str__(level=level + 1) for sym in all_syms]
            symbol_str = nl_indent + nl_indent.join(strs)
        else:
            symbol_str = ''

        return symbol_str

    def __str__(self, level=0):
        return f"Scope: {self.aliases}" + self.str__symbols(level)


class ScopeAndSymbol(Scope, Symbol):
    def __init__(self, aliases: Optional[Aliases], ast_node):
        Scope.__init__(self, aliases)
        Symbol.__init__(self, aliases, ast_node)

    def set_parent_scope(self, parent_scope: 'Scope'):
        Symbol.set_parent_scope(self, parent_scope)

    def __str__(self, level=0):
        return f"{type(self).__name__}: {self.aliases}{self.str_type()}" + Scope.str__symbols(self, level)


class BuiltinObject(ScopeAndSymbol):
    def __init__(self, name: str, value=None):
        ScopeAndSymbol.__init__(self, name, value)
        self.name = name


class BuiltinFunction(Symbol):
    def __init__(self, name: str, input_types: list[soltypes.Type] | None, output_types: list[soltypes.Type] | None):
        ScopeAndSymbol.__init__(self, name, None)
        self.input_types = input_types
        self.output_types = output_types


class BuiltinValue(Symbol):
    def __init__(self, name: str, ttype: soltypes.Type):
        ScopeAndSymbol.__init__(self, name, None)
        self.ttype = ttype


def create_builtin_scope(key, value=None, values=None, functions=None):
    scope = BuiltinObject(key, value)

    if values:
        for args in values:
            scope.add(BuiltinValue(*args))

    if functions:
        for args in functions:
            scope.add(BuiltinFunction(*args))

    return scope


def type_key(ttype) -> str:
    return f'<type:{ttype.type_key()}>'


def meta_type_key(ttype) -> str:
    return f'<metatype:{ttype.type_key()}>'


class RootScope(Scope):
    def __init__(self, parser_version: version_util.Version):
        Scope.__init__(self, '<root>')

        self.compiler_version = None

        msg_object = BuiltinObject('msg')
        msg_object.add(BuiltinValue('value', soltypes.IntType(False, 256)))
        # The function gasleft was previously known as msg.gas, which was deprecated in version 0.4.21 and removed in
        # version 0.5.0
        msg_object.add(BuiltinValue('gas', soltypes.IntType(False, 256)))
        # Sender is actually not payable as per 0.8 breaking changes, but if we make it not payable it breaks
        #  some pre 0.8 contracts, need a way to version symtab behaviour in AST2
        if parser_version:
            sender_type = soltypes.AddressType(parser_version.minor < 8)
        else:
            # default to not payable as the majority of stuff now is >0.8
            sender_type = soltypes.AddressType(False)
        msg_object.add(BuiltinValue('sender', sender_type))
        msg_object.add(BuiltinValue('data', bytes()))
        msg_object.add(BuiltinValue('sig', soltypes.FixedLengthArrayType(soltypes.ByteType(), 4)))

        self.add(msg_object)

        abi_object = BuiltinObject('abi')
        # input_types == None means the function can take any parameters

        # abi.encode(...) returns (bytes memory)
        abi_object.add(BuiltinFunction('encode', None, [bytes()]))
        # encodePacked(...) returns (bytes memory)
        abi_object.add(BuiltinFunction('encodePacked', None, [bytes()]))
        # encodeWithSignature(string memory signature, ...) returns (bytes memory)
        abi_object.add(BuiltinFunction('encodeWithSelector', None, [bytes()]))
        # encodeWithSignature(string memory signature, ...) returns (bytes memory
        abi_object.add(BuiltinFunction('encodeWithSignature', None, [bytes()]))
        # abi.encodeCall(functionPointer, (arg1, arg2, ...))
        abi_object.add(BuiltinFunction('encodeCall', None, [bytes()]))

        # abi.decode(bytes memory encodedData, (...)) returns (...)
        abi_object.add(BuiltinFunction('decode', None, None))

        self.add(abi_object)

        block_object = BuiltinObject('block')
        block_object.add(BuiltinValue('basefee', uint()))
        block_object.add(BuiltinValue('chainid', uint()))
        block_object.add(BuiltinValue('coinbase', soltypes.AddressType(True)))
        block_object.add(BuiltinValue('difficulty', uint()))
        block_object.add(BuiltinValue('gaslimit', uint()))
        block_object.add(BuiltinValue('number', uint()))
        block_object.add(now_symbol := BuiltinValue('timestamp', uint()))  # now was used pre solidity 0.7 for block.timestamp
        self.add(block_object)

        self.add(CrossScopeSymbolAlias('now', now_symbol))

        tx_object = BuiltinObject('tx')
        tx_object.add(BuiltinValue('gasprice', uint()))
        tx_object.add(BuiltinValue('origin', soltypes.AddressType(False)))
        self.add(tx_object)

        bytes_object = BuiltinObject('bytes')
        bytes_object.add(BuiltinFunction('concat', None, [bytes()]))
        self.add(bytes_object)

        string_object = BuiltinObject('string')
        string_object.add(BuiltinFunction('concat', None, [soltypes.StringType()]))
        self.add(string_object)

        # https://docs.soliditylang.org/en/latest/units-and-global-variables.html#members-of-address-types
        def address_object(payable):
            # key is <type: address> or <type: address payable>
            t = soltypes.AddressType(payable)
            scope = BuiltinObject(type_key(t), t)
            scope.add(BuiltinValue('balance', uint()))
            scope.add(BuiltinValue('code', bytes()))
            scope.add(BuiltinValue('codehash', bytes32()))

            # These functions are only available for address payable but for some old solidity contracts this wasn't
            # enforced in the compiler...
            # if payable:
            scope.add(BuiltinFunction('transfer', [uint()], []))
            scope.add(BuiltinFunction('send', [uint()], [soltypes.BoolType()]))

            scope.add(BuiltinFunction('call', None, [soltypes.BoolType(), bytes()]))
            # scope.add(BuiltinFunction('call', [bytes()], [solnodes.BoolType(), bytes()]))
            # scope.add(BuiltinFunction('call', [], [solnodes.BoolType(), bytes()]))
            scope.add(BuiltinFunction('delegatecall', [bytes()], [soltypes.BoolType(), bytes()]))
            scope.add(BuiltinFunction('staticcall', [bytes()], [soltypes.BoolType(), bytes()]))

            return scope

        self.add(address_object(True))
        self.add(address_object(False))

        # Builtin global functions
        self.add(BuiltinFunction('keccak256', None, [bytes32()]))
        self.add(BuiltinFunction('sha256', None, [bytes32()]))
        self.add(BuiltinFunction('ripemd160', None, [bytesn(20)]))
        # addmod(uint x, uint y, uint k) returns (uint)
        # mulmod(uint x, uint y, uint k) returns (uint)
        self.add(BuiltinFunction('addmod', [uint(), uint(), uint()], [uint()]))
        self.add(BuiltinFunction('mulmod', [uint(), uint(), uint()], [uint()]))

        self.add(BuiltinFunction('ecrecover', [bytes32(), uint(8), bytes32(), bytes32()], [
            soltypes.AddressType(False)]))

        self.add(BuiltinFunction('gasleft', [], [uint()]))

        self.add(BuiltinFunction('blobhash', [uint()], [bytes32()]))
        self.add(BuiltinFunction('blockhash', [uint()], [bytes32()]))

        self.add(BuiltinFunction('require', [soltypes.BoolType(), soltypes.StringType()], []))
        self.add(BuiltinFunction('require', [soltypes.BoolType()], []))

        self.add(BuiltinFunction('assert', [soltypes.BoolType()], []))

        self.add(BuiltinFunction('revert', [soltypes.StringType()], []))
        self.add(BuiltinFunction('revert', [], []))

        self.add(BuiltinFunction('selfdestruct', [soltypes.AddressType(is_payable=False)], []))


class FileScope(ScopeAndSymbol):
    @staticmethod
    def alias(source_unit_name: str):
        return f'<source_unit:{source_unit_name}>'

    def __init__(self, builder: 'Builder2', vfs: VirtualFileSystem, source_unit_name: str, ast1_units: List[solnodes.SourceUnit]):
        ScopeAndSymbol.__init__(self, self.alias(source_unit_name), ast1_units)
        self.builder = builder
        self.vfs = vfs
        self.source_unit_name = source_unit_name

    def get_imported_source_unit(self, import_path: str) -> Optional['FileScope']:
        # atm this throws if the file isn't found
        source = self.builder.vfs.lookup_import_path(import_path, self.source_unit_name)
        return self.builder.process_or_find(source)

    def set_parent_scope(self, parent_scope: 'Scope'):
        assert isinstance(parent_scope, RootScope)
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)


class LibraryScope(ScopeAndSymbol):
    def __init__(self, ast_node: solnodes.LibraryDefinition):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)


class ContractOrInterfaceScope(ScopeAndSymbol):
    def __init__(self, ast_node: Union[solnodes.ContractDefinition, solnodes.InterfaceDefinition]):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)

    def find_current_level(self, name: str, predicate=None, visited_scopes: Set = None, check_hierarchy=True) -> Optional[List[Symbol]]:
        found_already = set()
        results = []

        _add_to_results(super().find_current_level(name, predicate, visited_scopes), results, found_already)
        if check_hierarchy:
            _add_to_results(self.find_in_contract_hierarchy(name, predicate, visited_scopes), results, found_already)

        return results

    def find_in_contract_hierarchy(self, name: str, predicate, visited_scopes):
        # dont look in self
        lookup_order = c3_linearise(self)[1:]
        ss = []
        for c in lookup_order:
            if syms := c.find_current_level(name, predicate, visited_scopes, check_hierarchy=False):
                ss.extend(syms)
        return ss

    def get_supers(self) -> List['ContractOrInterfaceScope']:
        klass_file_scope: FileScope = self.parent_scope
        superklasses: List[ContractOrInterfaceScope] = []
        for inherit_specifier in self.value.inherits:
            # inherit specifier => name type => name ident => text str
            name = inherit_specifier.name.name.text
            symbol = klass_file_scope.find_user_type_scope(name, find_base_symbol=True)
            assert isinstance(symbol, ContractOrInterfaceScope), f'Got {symbol.aliases}::{type(symbol)}'
            superklasses.append(symbol)
        return superklasses


class StructScope(ScopeAndSymbol):
    def __init__(self, ast_node: solnodes.StructDefinition):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)


class UserDefinedValueTypeScope(ScopeAndSymbol):
    def __init__(self, ast_node: solnodes.UserValueType):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)


class LibraryScope(ScopeAndSymbol):
    def __init__(self, ast_node: solnodes.LibraryDefinition):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)


class EnumScope(ScopeAndSymbol):
    def __init__(self, ast_node: solnodes.EnumDefinition):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)


class ModFunErrEvtScope(ScopeAndSymbol):
    def __init__(self, ast_node: Union[solnodes.FunctionDefinition, solnodes.EventDefinition,
                                  solnodes.ErrorDefinition, solnodes.ModifierDefinition]):
        # name = f'{ast_node.name} {param_type_str(ast_node.parameters)}'
        # if hasattr(ast_node, 'returns'):
        #     name += f' => {param_type_str(ast_node.returns)}'
        ScopeAndSymbol.__init__(self, str(ast_node.name), ast_node)


class ImportSymbol(ScopeAndSymbol):
    def __init__(self, aliases: Optional[Aliases], ast_node: solnodes.ImportDirective):
        ScopeAndSymbol.__init__(self, aliases, ast_node)

    def get_as_dealiased_symbols(self) -> List['Symbol']:
        return [dea_sym for i_s in self._get_imported_symbols() for dea_sym in i_s.get_as_dealiased_symbols()]

    def get_imported_scope(self) -> Optional[FileScope]:
        source_unit: FileScope = self.parent_scope
        import_path = self.value.path
        return source_unit.get_imported_source_unit(import_path)

    def _get_imported_symbols(self) -> List[Symbol]:
        pass

    def res_syms(self) -> List['Symbol']:
        return [res_sym for i_s in self._get_imported_symbols() for res_sym in i_s.res_syms()]
    
    def get_direct_children(self) -> Collection[Symbol]:
        return [direct_child for i_s in self._get_imported_symbols() for direct_child in i_s.get_direct_children()]

    def find(self, name: str, find_base_symbol: bool = False, predicate=None, dealias: bool = True) -> Optional[List[Symbol]]:
        return [f_s for i_s in self._get_imported_symbols() for f_s in i_s.find(name, find_base_symbol, predicate, dealias)]

    def find_type(self, ttype, predicate=None, as_single=False) -> Scope:
        raise NotImplemented

    def find_metatype(self, ttype, is_interface, is_enum) -> Scope:
        raise NotImplemented

    def find_local(self, name: str) -> Optional[List[Symbol]]:
        return [f_s for i_s in self._get_imported_symbols() for f_s in i_s.find_local(name)]

    def find_first_ancestor(self, predicate, get_parent=None):
        raise NotImplemented

    def find_first_ancestor_of(self, ttype: Union[Type, Tuple[Type]]):
        return NotImplemented

    def find_imported(self, name: str, predicate=None, visited_scopes: Set = None) -> Optional[List[Symbol]]:
        return [f_s for i_s in self._get_imported_symbols() for f_s in i_s.find_imported(name, predicate, visited_scopes)]

    def find_current_level(self, name: str, predicate=None, visited_scopes: Set = None) -> Optional[List[Symbol]]:
        return [f_s for i_s in self._get_imported_symbols() for f_s in i_s.find_current_level(name, predicate, visited_scopes)]

    def find_single(self, name: str, find_base_symbol: bool = False, default=None, predicate=None) -> Optional[Symbol]:
        # default to [] in subcalls so if nothing is found nothing gets appended to results
        results = [f_s for i_s in self._get_imported_symbols() for f_s in i_s.find_single(name, find_base_symbol, [], predicate)]
        return self._check_single_symbol(name, results, default)

    def find_from_parent(self, name: str, predicate=None) -> List[Symbol]:
        return [f_s for i_s in self._get_imported_symbols() for f_s in i_s.find_from_parent(name, predicate)]


class AliasImportSymbol(ImportSymbol):
    def __init__(self, ast_node: solnodes.SymbolImportDirective, alias_index):
        # ast_node.aliases here is essentially [(symbol=X,alias=Y)]
        # take all the Y's and put them as this ImportSymbol Symbol.aliases, but we need
        # the X's if Y is looked up to find X

        self.alias_index = alias_index
        ImportSymbol.__init__(self, ast_node.aliases[alias_index].alias.text, ast_node)

    def _get_imported_symbols(self) -> List['Symbol']:
        alias: solnodes.SymbolAlias = self.value.aliases[self.alias_index]
        symbol_name = alias.symbol.text
        imported_scope = self.get_imported_scope()
        imported_symbols = imported_scope.find(symbol_name)
        # the imported symbols may themselves resolve to multiple symbols
        return [single_sym for i_s in imported_symbols for single_sym in i_s.res_syms()]


class UnitImportSymbol(ImportSymbol):
    def __init__(self, ast_node: solnodes.UnitImportDirective):
        ImportSymbol.__init__(self, ast_node.alias.text, ast_node)

    def _get_imported_symbols(self) -> List['Symbol']:
        return self.get_imported_scope().res_syms()


class ProxyScope(ScopeAndSymbol):
    def __init__(self, name: str, base_scope: ScopeAndSymbol):
        ScopeAndSymbol.__init__(self, name, base_scope.value if base_scope else None)
        if base_scope:
            self.import_symbols_from_scope(base_scope)
        self.base_scope = base_scope
        self.created_by = None

    def res_syms(self) -> List['Symbol']:
        if self.base_scope:
            return self.base_scope.res_syms()
        else:
            return [self]


class UsingDirectiveScope(ScopeAndSymbol):
    def __init__(self, node: solnodes.UsingDirective):
        ScopeAndSymbol.__init__(self, f'Using:{node.location}', node)


class UsingFunctionSymbol(Symbol):
    def __init__(self, target: ModFunErrEvtScope, override_type: soltypes.Type):
        assert isinstance(target.value, solnodes.FunctionDefinition)
        Symbol.__init__(self, target.aliases, target.value)
        self.target = target
        self.override_type = override_type

    def res_syms(self) -> List['Symbol']:
        return self.target.res_syms()


class UsingOperatorSymbol(Symbol):
    def __init__(self, target: ModFunErrEvtScope, override_type: soltypes.Type, operator: Union[solnodes.UnaryOpCode, solnodes.BinaryOpCode]):
        assert isinstance(target.value, solnodes.FunctionDefinition)
        Symbol.__init__(self, f'{str(operator.value)}', target.value)
        self.target = target
        self.override_type = override_type
        self.operator = operator

    def res_syms(self) -> List['Symbol']:
        return self.target.res_syms()


class Builder2:

    class Context:
        def __init__(self, file_scope, unit_scope):
            self.file_scope = file_scope
            self.unit_scope = unit_scope

    def __init__(self, vfs: VirtualFileSystem, parser_version: version_util.Version = None):
        self.root_scope = RootScope(parser_version)
        self.vfs = vfs
        self.parser_version = parser_version

    def process_or_find(self, loaded_source: LoadedSource):
        found_fs = self.root_scope.symbols.get(FileScope.alias(loaded_source.source_unit_name))
        if found_fs:
            assert len(found_fs) == 1
            found_fs = found_fs[0]

        if not found_fs:
            found_fs = self.process_file(loaded_source.source_unit_name, loaded_source.ast)

        return found_fs

    def process_or_find_from_base_dir(self, relative_source_unit_name: str):
        # sanitise inputs if windows paths are given
        relative_source_unit_name = relative_source_unit_name.replace('\\', '/')

        source_unit_name = self.vfs._compute_source_unit_name(relative_source_unit_name, '')
        fs = self.root_scope.find_single(FileScope.alias(source_unit_name))
        if fs:
            return fs
        return self.process_file(source_unit_name)

    def process_file(self, source_unit_name: str, source_units: List[solnodes.SourceUnit] = None):
        if source_units is None:
            source = self.vfs.lookup_import_path(source_unit_name, '')
            source_units = source.ast
            if not source_units:
                raise ValueError(f'Could not load {source_unit_name} from root')

        logging.getLogger('ST').debug(f'FS Processing {source_unit_name}')

        fs = FileScope(self, self.vfs, source_unit_name, source_units)

        self.add_to_scope(self.root_scope, fs)

        for index, node in self.sort_ast_nodes(source_units):
            self.add_node_dfs(fs, node, Builder2.Context(fs, None), True, index)

        for index, node in self.sort_ast_nodes(source_units):
            self.add_node_dfs(fs, node, Builder2.Context(fs, None), False, index)

        return fs

    def sort_ast_nodes(self, nodes):
        type_defining_nodes = []
        other_nodes = []
        for n in nodes:
            if isinstance(n, solnodes.UserValueType):
                type_defining_nodes.append(n)
            else:
                other_nodes.append(n)
        return enumerate(type_defining_nodes + other_nodes)


    def add_node_dfs(self, parent_scope, node, context: Context, build_skeletons, visit_index=0):
        """
        Recursively traverse a node and its children and create symbols and scopes in a nested hierarchy

        This function adds newly created symbols and scopes to the given parent scope and does not return anything
        """

        if node is None:
            # base case, nothing to do
            return

        # we need to add any created symbols/scope to a parent
        assert parent_scope is not None, 'No parent scope'

        if build_skeletons:
            assert not node.scope
            # the nodes scope is the scope it was created in always
            node.scope = parent_scope

        # track the scope for the nodes children later
        current_scope = parent_scope

        # Process the node for new symbols or a new scope
        scope_or_symbols = self.make_symbols_for_node(node, context, build_skeletons, visit_index)
        if scope_or_symbols is None:
            new_symbols = []
        elif isinstance(scope_or_symbols, list):
            # this is assumed to be a list of symbols, i.e. doesn't contain a scope
            new_symbols = scope_or_symbols
        elif isinstance(scope_or_symbols, Symbol):
            # single symbol(or scope), collect into list
            new_symbols = [scope_or_symbols]
        else:
            assert False, f'Invalid processing of {node} => {scope_or_symbols}'

        # if it created a new scope, set the current scope to it so the nodes children are in that scope
        if isinstance(scope_or_symbols, Scope):
            assert build_skeletons
            current_scope = scope_or_symbols
            node.owning_scope = current_scope

            # update the context for the children if a new top level scope was made
            if isinstance(scope_or_symbols, (ContractOrInterfaceScope, LibraryScope, StructScope, EnumScope)):
                context = Builder2.Context(context.file_scope, scope_or_symbols)

        if not build_skeletons and hasattr(node, 'owning_scope'):
            # if we're not in skeleton building mode, make_symbols_for_node will not give us a new scope for this node(in the
            # case this node defines a new scope, e.g. node == ContractDefinition, VarDecl, etc).
            # The scope this node defines is set as its 'owning_scope'. The current scope for the child processing
            # below is the scope defined by this node: the owning_scope.
            assert not scope_or_symbols
            current_scope = node.owning_scope

            # update the context for the children this node defines a new top level scope
            if isinstance(current_scope, (ContractOrInterfaceScope, LibraryScope, StructScope, EnumScope)):
                context = Builder2.Context(context.file_scope, current_scope)

        # add the created symbols under the parent scope. The make_symbols_for_node call above either makes a new
        # scope or new symbols, so don't think of this as adding new symbols to a newly created scope, that is
        # invalid behaviour
        for new_child_sym in new_symbols:
            self.add_to_scope(parent_scope, new_child_sym)

        # process children nodes in the current scope(whether it's the parent scope or a newly created one)

        # updated algorithm for name shadowing when we encounter a VarDecl (r1,.., rk = value)
        #  1. Make a new child scope of the current scope where the rhs variables are defined
        #  2. Process the value under the current scope (not the newly created one)

        # Example: unit decimals = decimals()
        #  where decimals() is a function call that returns a uint
        #
        # Later on when the resolver sees the call to decimals() (expr C) and looks up 'decimals' in C.scope, it
        # would return a scope that defines 'decimals' as a local variable (var V). In this modified algorithm,
        # V.scope.parent_scope == E.scope, so E.scope.find('decimals') == function scope for 'decimals' and
        # V.scope.find('decimals') == variable 'decimals'.

        # Note we also do this for using directives now

        latest_scope = current_scope
        # TODO: order these
        for child_index, child_node in self.sort_ast_nodes(node.get_children()):
            # Enums values are shared between nodes, so they'd end up getting processed multiple times and their
            # 'scope' would be inaccurate
            if isinstance(child_node, Enum):
                continue

            if isinstance(child_node, (solnodes.VarDecl, solnodes.UsingDirective)):
                # create or get the scope that the VarDecl defines, so we can propagate it on the same level to the next
                # child
                if build_skeletons:
                    if isinstance(child_node, solnodes.VarDecl):
                        newly_created_scope = self.make_var_decl_scope(child_node)
                    else:
                        if child_node.is_global:
                            # global usings: don't need to make a new scope as the symbols from the library attach to
                            # the target type directly
                            continue
                        else:

                            # latest == last contract scope

                            latest_contract = latest_scope.find_first_ancestor_of((ContractOrInterfaceScope, LibraryScope))


                            # non global using: create the new enclosing scope
                            newly_created_scope = self.make_using_scope(child_node)
                            # add an import link from the latest scope(LAT) to the newly created one(NEW). The NEW scope
                            # also ends up being added as a normal symbol to the LAT scope but the alias for NEW is
                            # not a real symbol name, e.g. 'Using:25:735'. If NEW wasn't imported into LAT, no symbols
                            # in NEW would be visible as they would have to be qualified with the mangled name. The
                            # import mechanism in scope looks directly into imported scopes which is what you would
                            # expect if all the symbols of NEW were brought into LAT.
                            # Note: we still need to add NEW to LAT as a symbol in this case to make sure the child
                            # parent relationship is correct so traversing up and down the scope tree works.
                            latest_scope.import_symbols_from_scope(newly_created_scope)

                    child_node.owning_scope = newly_created_scope

                    if isinstance(child_node, solnodes.VarDecl):
                        # continue with scoping
                        self.add_to_scope(latest_scope, newly_created_scope)
                    else:
                        # using directive
                        self.add_to_scope(latest_contract, newly_created_scope)

                # recurse the child node. note that for all code stmts/exprs make_symbols_for_node() won't create new symbols or
                # scopes(returns None/[]) so this is really to attach the 'newly_created_scope' to the AST child nodes
                # 'scope' of this VarDecl. This is also why we only do this during skeleton building, as the subnodes
                # here don't affect the scope tree themselves: we just want to tell them their 'scope'.
                self.add_node_dfs(latest_scope, child_node, context, build_skeletons, child_index)

                if isinstance(child_node, solnodes.VarDecl):
                    latest_scope = child_node.owning_scope
            else:
                self.add_node_dfs(latest_scope, child_node, context, build_skeletons, child_index)

    def make_using_scope(self, node: solnodes.UsingDirective):
        # return self.make_scope(node, f'Using:{node.location}')
        return UsingDirectiveScope(node)

    def make_var_decl_scope(self, node: solnodes.VarDecl):
        # This is the synthetic scope in which the VarDecl is live
        scope_name = f"<vardecl:{','.join([var.var_name.text for var in node.variables])}>"
        var_decl_scope = self.make_scope(node, name=scope_name)

        # Define the LHS vars as symbols in this scope
        var_symbols = [self.make_symbol(var, name=var.var_name.text) for var in node.variables]
        self.add_to_scope(var_decl_scope, *var_symbols)

        return var_decl_scope

    def add_to_scope(self, parent: Scope, *children: Symbol):
        if children is not None:
            for child in children:
                parent.add(child)

    def make_scope(self, node: nodebase.Node, name=None):
        if name is None:
            name = node.name.text
        return ScopeAndSymbol(name, node)

    def make_symbol(self, node: nodebase.Node, sym_type=Symbol, name=None):
        if name is None:
            name = node.name.text
        return sym_type(name, node)

    def scope_name(self, base_name, node):
        return f'<{base_name}>@{node.location}'

    def find_using_target_scope_and_name(self, current_scope, target_type: soltypes.Type):
        # TODO: Not sure if this is possible and I don't want to handle it(yet), just want to handle Types
        #  for target_type
        if isinstance(target_type, solnodes.Ident):
            raise NotImplementedError('target_type: Ident')

        # Need to get the symbol name/alias/key for the target type, for primitives this is easy: just encode it
        # as a type key. For user reference types, it depends on how it's referenced, e.g. it could be just
        # MyT or could be qualified as A.B.MyT where B is in the scope of A and MyT is in the scope of B (etc)
        if isinstance(target_type, soltypes.UserType):
            raw_name = target_type.name.text
            target_type_scope = current_scope.find_user_type_scope(raw_name, find_base_symbol=True)

            # Resolve the name used here to the actual contract/struct/etc (symbol)
            # Use the name as defined by the actual symbol itself so that we can do consistent checks against
            # this type and the first parameter type later, i.e. for A.B.MyT, use MyT as the type key
            target_scope_name = target_type_scope.res_syms_single().value.name.text
        else:
            # Solidity type, e.g. <type:int>, <type:byte[]}, etc

            # find a single type, this should be the Builtin version. ignore any proxy scopes, i.e. any previously
            # processed using directives for this type
            target_type_scope = current_scope.find_type(target_type, predicate=lambda x: not isinstance(x, ProxyScope), as_single=True)
            target_scope_name = target_type_scope.aliases[0]
        return target_type_scope, target_scope_name

    def make_proxy_scope(self, scope_name, creator_scope, base_scope, library_scope=None):
        new_proxy_scope = ProxyScope(scope_name, base_scope)
        new_proxy_scope.created_by = creator_scope

        if library_scope:
            # this is just tracking which libraries are attached (for debugging atm)
            libs = base_scope.libraries[:] if base_scope and hasattr(base_scope, 'libraries') else []
            lib = library_scope.value.name.text
            if lib not in libs:
                libs.append(lib)
            new_proxy_scope.libraries = libs

        creator_scope.add(new_proxy_scope)
        return new_proxy_scope

    def get_proxy_scope_for_type(self, cur_scope, target_type, target_scope_name, target_type_scope, library_scope=None,
                                 check_lib=True):
        # We find the scope for the target type T and create a proxy of that scope in
        # our own local scope and add the functions from L to the proxy(not the base scope of T)
        # This is so we can lookup functions in like x.z() in the proxy scope (as it will not exist in the base
        # scope) as the Using directive is only 'active' in the current scope (as opposed to on a global level)

        if not target_type_scope:
            # We don't have a solid scope for this type, create the proxy as the base scope
            # proxy_scope = self.make_proxy_scope(target_scope_name, unit_scope, None, library_scope)
            raise ValueError(f'No scope for type: {target_type}({target_scope_name})')
        elif isinstance(target_type_scope, ProxyScope):

            # FIXME: deprecated case as proxy scopes aren't nested anymore, need to recheck this with tests

            # Got the scope for T but it's a proxy scope; this can mean a couple of things:
            #  if this scope was not created by us then it must've come from some other source:
            #   1. Before, using directives weren't allowed at the file level so the scope came from another unit
            #      scope(parent contract) and isn't inheritable
            #      TODO: check this with new global keyword
            #      "The use of global is possible only with UDVTs, structs, and enums that are defined in its source
            #      unit."
            #      In this case we have to create a new proxy scope that is based on the real scope of T: do this by
            #      traversing the proxy base scopes until we come to one that isn't a proxy scope
            #   2. Now, using directives can be declared at the file scope level and contracts in that file fall under
            #     the influence of the directive. we don't want to add members to this parent proxy scope so we use it
            #     as the base for a new proxy scope.
            # Technically (1) could be fixed by improving the target type scope lookup and filtering the result based on
            # what type of scope we allow here but I am just documenting the code that's already here and not changing
            # the functionality for now.

            if target_type_scope.created_by != cur_scope:
                t_proxy_file = target_type_scope.created_by.find_first_ancestor_of(FileScope)
                cur_scope_file = cur_scope.find_first_ancestor_of(FileScope)

                if t_proxy_file == cur_scope_file:
                    # case 1, new proxy scope is based on the proxy scope target_type_scope (inheritable)
                    proxy_scope = self.make_proxy_scope(target_scope_name, cur_scope, target_type_scope, library_scope)
                else:
                    # case 2, need to find a real base for the new proxy scope
                    # don't extend the parent proxy scope(using directives aren't inherited and even if we allow them
                    # to be we would need to check the libraries to ensure symbols aren't duplicated)
                    real_target_scope = target_type_scope.find_first_ancestor(lambda x: not isinstance(x, ProxyScope),
                                                                              lambda x: x.base_scope)
                    if not real_target_scope:
                        # should be impossible
                        raise ValueError(f'No real base for: {target_type_scope.aliases[0]}({target_scope_name})')
                    proxy_scope = self.make_proxy_scope(target_scope_name, cur_scope, real_target_scope, library_scope)
            else:
                # a proxy scope created by this current contract but for a different lib (this can happen when
                # multiple libraries are used for the same type)
                if library_scope:
                    lib = library_scope.value.name.text
                    if lib not in target_type_scope.libraries:
                        target_type_scope.libraries.append(lib)
                    else:
                        assert not check_lib, f'{lib} already added to scope: {target_scope_name}'
                proxy_scope = target_type_scope
        else:
            # there exists a scope for this type but it's not a proxy scope, so it's most likely a
            # user type or builtin scope: create a proxy for this using directive
            proxy_scope = self.make_proxy_scope(target_scope_name, cur_scope, target_type_scope, library_scope)

        return proxy_scope

    def get_using_function_symbol_for_func(self, target_type, target_type_scope, symbol, operator=None):
        def make_using_symbol(s, t):
            if operator:
                return UsingOperatorSymbol(s, t, operator)
            else:
                return UsingFunctionSymbol(s, t)

        # TODO: filter private functions
        func_def = symbol.value
        if func_def.parameters:
            first_parameter_type = func_def.parameters[0].var_type
            # from: https://github.com/ethereum/solidity/blob/develop/docs/contracts/using-for.rst
            # "If you specify a library, all non-private functions in the library get attached, even those where the
            # type of the first parameter does not match the type of the object. The type is checked at the point the
            # function is called and function overload resolution is performed."
            # if isinstance(first_parameter_type, solnodes.UserType):
            #     param_type_symbol = symbol.find_user_type_scope(first_parameter_type.name.text)
            #     if param_type_symbol.res_syms_single() == target_type_scope.res_syms_single():
            #         return make_using_symbol(symbol, target_type)
            # elif first_parameter_type == target_type:
            #     return make_using_symbol(symbol, target_type)
            return make_using_symbol(symbol, first_parameter_type)
        return None

    def process_using_any_type(self, context: Context, node: solnodes.UsingDirective):
        # using L for *
        # For each function in the library, f(a0,...), target type is type(a0), add a symbol for it
        cur_scope = self.find_using_current_scope(node, context)
        # require the base symbol here, don't want to collect any functions below that are themselves from a using scope
        library_scope: Scope = cur_scope.find_user_type_scope(node.library_name.text, find_base_symbol=True)

        for symbol in library_scope.get_all_functions():
            func_def = symbol.value
            if not func_def.parameters:
                continue
            target_type = func_def.parameters[0].var_type
            target_type_scope, target_scope_name = self.find_using_target_scope_and_name(cur_scope, target_type)

            scope_to_add_to = self.get_proxy_scope_for_type(cur_scope, target_type, target_scope_name, target_type_scope, library_scope, check_lib=False)

            self.add_to_scope(scope_to_add_to, UsingFunctionSymbol(symbol, target_type))

    def process_using_library_type(self, context: Context, node: solnodes.UsingDirective):
        # Stmts in the form: using L for T

        # the owning_scope is the scope that was created by this using directive during the skeleton pass
        cur_scope = self.find_using_current_scope(node, context)

        # This is L
        # require the base symbol here, don't want to collect any functions below that are themselves from a using scope
        library_scope: Scope = cur_scope.find_user_type_scope(node.library_name.text, find_base_symbol=True)
        # This is T
        target_type = node.override_type

        target_type_scope, target_scope_name = self.find_using_target_scope_and_name(cur_scope, target_type)

        using_symbols = [self.get_using_function_symbol_for_func(target_type, target_type_scope, s)
                         for s in library_scope.get_all_functions()]

        if node.is_global:
            scope_to_add_to = target_type_scope
        else:
            scope_to_add_to = self.get_proxy_scope_for_type(cur_scope, target_type, target_scope_name, target_type_scope, library_scope)

        # get the functions in the target library and import them under the scope of the 1st param type
        for s in using_symbols:
            if s:
                self.add_to_scope(scope_to_add_to, s)

    def find_using_current_scope(self, node, context):
        if hasattr(node, 'owning_scope'):
            return node.owning_scope
        # required since now usings can be put in the file scope
        return context.unit_scope if context.unit_scope else context.file_scope

    def process_using_functions(self, node: solnodes.UsingDirective, context: Context):
        # find the referenced free or library functions

        # using allowed in the file scope, not just unit scope since (FIND OUT WHICH VERSION)
        cur_scope = self.find_using_current_scope(node, context)
        target_type = node.override_type
        target_type_scope, target_scope_name = self.find_using_target_scope_and_name(cur_scope, target_type)

        if node.is_global:
            scope_to_add_to = target_type_scope
        else:
            scope_to_add_to = self.get_proxy_scope_for_type(cur_scope, target_type, target_scope_name, target_type_scope, None)

        operator_symbols = []
        function_symbols = {}

        for attachment in node.attachments_or_bindings:
            # attachment, e.g. using { myF, ... } for MyType ;
            # operator binding, e.g. using { myF as - } for MyType ;
            symbol = cur_scope.find_multi_part_symbol(attachment.member_name.text)
            if not symbol:
                raise ValueError(f'No symbol found in using directive: {str(attachment.member_name)}')

            is_operator = hasattr(attachment, 'operator')

            if is_operator:
                operator = attachment.operator
            else:
                operator = None

            using_symbol = self.get_using_function_symbol_for_func(target_type, target_type_scope, symbol, operator)

            if using_symbol:
                if is_operator:
                    operator_symbols.append(using_symbol)
                else:
                    # use a table here so statemnets like
                    # using {id, zero, zero, id} for uint;
                    # dont register 'id' twice
                    function_symbols[using_symbol.aliases[0]] = using_symbol


        for s in operator_symbols:
            self.add_to_scope(scope_to_add_to, s)

        for s in function_symbols.values():
            self.add_to_scope(scope_to_add_to, s)

    def process_using_directive(self, node: solnodes.UsingDirective, context: Context):
        if isinstance(node.override_type, soltypes.AnyType):
            if node.is_global:
                raise ValueError(f'Using @{node.location} can\'t be global')
            self.process_using_any_type(context, node)
        else:
            # Two cases here, before 0.8.19 this was the only form this statement could take:
            # CASE 1
            #  using L for T
            # which attaches all non-private functions from library L to type T

            # Now we can also have
            # CASE 2
            #  using {f, L.g, ...} for T
            # which attaches given free or library functions f, L.g, ... to type T

            if node.library_name and node.attachments_or_bindings:
                raise ValueError('Using directive has too many components')

            if node.library_name:
                self.process_using_library_type(context, node)
            else:
                self.process_using_functions(node, context)

    def make_symbols_for_node(self, node, context: Context, build_skeletons: bool, visit_index: int):
        # Only process these when not building skeletons as they can reference other nodes during creation
        #  i.e. first pass we make a skeleton of the scope tree, second pass we fill in any links
        #  this is required because of circular references
        # Note also that during the first pass we can return a new scope to insert into the tree.
        # During the second pass we can only return symbols(this is enforced in add_node_dfs)
        # For VarDecls that define their own scope this is achieved in add_node_dfs.
        if not build_skeletons:
            if isinstance(node, solnodes.UsingDirective):
                self.process_using_directive(node, context)
                return None
            elif isinstance(node, solnodes.SymbolImportDirective):
                new_symbols = []
                for idx, symbol_alias in enumerate(node.aliases):
                    if symbol_alias.alias.text in node.scope.symbols:
                        existing_symbols = node.scope.symbols[symbol_alias.alias.text]
                        for sym in existing_symbols:
                            if isinstance(sym, AliasImportSymbol):
                                existing_import_alias = sym.value
                                existing_symbol_alias = existing_import_alias.aliases[sym.alias_index]
                                if existing_symbol_alias.symbol.text == symbol_alias.symbol.text and existing_import_alias.path == node.path:
                                    # shallow check for duplicated symbol import statements
                                    # TODO: proper error (and proper check?)
                                    continue  # don't double add
                    new_symbols.append(AliasImportSymbol(node, idx))
                return new_symbols
            elif isinstance(node, solnodes.UnitImportDirective):
                # wrap this in a list as UnitImportSymbol is a scope and symbol and the caller will
                # scope the next nodes as children of this which breaks some resolution stuff in ast2
                return [UnitImportSymbol(node)]
            elif isinstance(node, solnodes.ImportDirective):
                # This is an import that looks like: import "myfile.sol". All the symbols from myfile are loaded into
                # the current file scope, so we have to load myfile, take its symbols and add them to the current file
                # scope
                current_file_scope = context.file_scope
                imported_file = current_file_scope.get_imported_source_unit(node.path)
                current_file_scope.import_symbols_from_scope(imported_file)
                return None  # no new node is made from this
            elif isinstance(node, solnodes.UserValueType):
                # Import the target type symbols into this user defined value type
                target_scope, _ = self.find_using_target_scope_and_name(node.scope, node.value)
                node.owning_scope.import_symbols_from_scope(target_scope)
                # also add the builtin helper methods

                udvt_type = soltypes.UserType(solnodes.Ident(node.name.text))
                # set the scope of this node: when it's looked up later, it needs a scope
                udvt_type.scope = node.owning_scope

                methods = [
                    ('wrap', [node.value], [udvt_type]),
                    ('unwrap', [udvt_type], [node.value]),
                ]

                for m in methods:
                    self.add_to_scope(node.owning_scope, BuiltinFunction(*m))

                return None
            else:
                # all other nodes are handled during skeleton building mode (below)
                return []

        # Skeleton building node processing
        if isinstance(node, solnodes.UsingDirective):
            # For UsingDirectives we need more logic to determine how to build the scope tree, logic which requires
            # lookups during building, which we can't do in pass 1: we create a dummy proxy scope for each using
            # directive that applies like VarDecls scopes(i.e. it becomes the current scope for the next child that is
            # processed)
            # Note we can't add stuff to the target type via lookup here in either the global or local using case, so
            # return None always
            return None
        elif isinstance(node, solnodes.PragmaDirective):
            if node.name.text == 'solidity':
                value = node.value
                # if isinstance(value, str):
                #     print(f"ver: {version_util.parse_version(value)}")
                # else:
                #     value = node.value[0]
                #     # specifying a minimum version for this file
                #     assert value.op in [solnodes.BinaryOpCode.BIT_XOR, solnodes.BinaryOpCode.EQ, solnodes.BinaryOpCode.GTEQ]
                #     print(f"ver: {version_util.parse_version(value.right.value)}")
            return None
        elif isinstance(node, (solnodes.FunctionDefinition, solnodes.EventDefinition,
                               solnodes.ErrorDefinition, solnodes.ModifierDefinition)):
            return ModFunErrEvtScope(node)
        elif isinstance(node, solnodes.LibraryDefinition):
            return LibraryScope(node)
        elif isinstance(node, (solnodes.ContractDefinition, solnodes.InterfaceDefinition)):
            return ContractOrInterfaceScope(node)
        elif isinstance(node, solnodes.UserValueType):
            return UserDefinedValueTypeScope(node)
        elif isinstance(node, solnodes.StructDefinition):
            return StructScope(node)
        elif isinstance(node, solnodes.EnumDefinition):
            # enums children are Idents, which don't get handled on their own, so we process them
            # here as children of the new scope
            scope = EnumScope(node)
            for c in node.get_children():
                assert isinstance(c, solnodes.Ident)
                scope.add(self.make_symbol(c, name=c.text))
            return scope
        elif isinstance(node, (solnodes.StateVariableDeclaration, solnodes.ConstantVariableDeclaration)):
            return self.make_symbol(node)
        elif isinstance(node, solnodes.StructMember):
            return self.make_symbol(node)
        elif isinstance(node, solnodes.Parameter):
            if node.var_name is None:
                # Return parameters can have no name
                return None
            else:
                return self.make_symbol(node, name=node.var_name.text)
        elif isinstance(node, solnodes.EventParameter):
            if node.name is None:
                name = f'<unnamed_paramter:{visit_index}'
            else:
                name = node.name.text
            return self.make_symbol(node, name=name)
        elif isinstance(node, solnodes.VarDecl):
            return None  # TODO: this is a sentinel
            # return [self.make_symbol(var, name=var.var_name.text) for var in node.variables]
        elif isinstance(node, solnodes.Block):
            return ScopeAndSymbol(self.scope_name('block', node), node)
        return None
