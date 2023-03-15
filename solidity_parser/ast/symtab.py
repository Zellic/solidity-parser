from typing import Union, List, Dict, Optional, Type, Tuple
from collections import defaultdict

from solidity_parser.ast import solnodes
from solidity_parser.filesys import LoadedSource, VirtualFileSystem


Aliases = Union[str, List[str]]


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


class Symbol(Scopeable):
    def __init__(self, aliases: Optional[Aliases], value):
        Scopeable.__init__(self, aliases)

        self.value = value
        self.order = -1

    def resolve_base_symbol(self) -> 'Symbol':
        # Return the symbol this symbol points to, if one exists.
        return self

    def set_parent_scope(self, parent_scope: 'Scope'):
        Scopeable.set_parent_scope(self, parent_scope)
        self.order = len(parent_scope.symbols)

    def str_type(self):
        return '' if not self.value else f' @{type(self.value).__name__}'

    def __str__(self, level=0):
        return f"{type(self).__name__}: {self.aliases}{self.str_type()}"


class Scope(Scopeable):
    def __init__(self, aliases: Optional[Aliases]):
        Scopeable.__init__(self, aliases)
        # collection of known mappings that can be looked up quickly
        self.symbols: Dict[str, List[Symbol]] = defaultdict(list)
        self.imported_scopes: List[Scope] = []

    def is_defined(self, name: str) -> bool:
        # check if the name exists in the table and it contains something
        return name in self.symbols and bool(self.symbols[name])

    def all_symbols(self):
        return set([item for sublist in self.symbols.values() for item in sublist])

    def import_symbols_from_scope(self, other_scope: 'Scope'):
        self.imported_scopes.append(other_scope)
        # the scope to import may contain symbols that we already have
        # _new_symbols = defaultdict(set)
        #
        # for (k, v) in self.symbols.items():
        #     for s in v:
        #         _new_symbols[k].add(s)
        # for (k,v) in other_scope.symbols.items():
        #     for s in v:
        #         _new_symbols[k].add(s)
        #
        # new_symbols2 = defaultdict(list)
        # for k, v in _new_symbols.items():
        #     new_symbols2[k].extend(v)
        #
        # self.symbols = new_symbols2

    def add_global_symbol(self, symbol: Symbol):
        root_scope = self.find_first_ancestor_of(RootScope)
        root_scope.add(symbol)

    def add(self, symbol: Symbol):
        symbol.set_parent_scope(self)

        for name in symbol.aliases:
            self.symbols[name].append(symbol)

    def find_local(self, name: str) -> Optional[List[Symbol]]:
        """Finds a mapped symbol in this scope only"""
        if name in self.symbols:
            return self.symbols[name]
        return []

    def find_imported(self, name: str) -> Optional[List[Symbol]]:
        for scope in self.imported_scopes:
            # TODO: unsure whether this should be find_local or find. This is just the old import_symbols_from_scope
            #  functionality for now
            syms = scope.find(name)
            if syms:
                return syms
        return []

    def find(self, name: str, find_base_symbol: bool = False) -> Optional[List[Symbol]]:
        # check this scope first
        found_symbols = self.find_local(name) + self.find_imported(name)
        # check the parent scope if it wasn't in this scope
        if not found_symbols and self.parent_scope is not None:
            found_symbols = self.parent_scope.find(name)

        if not found_symbols:
            return []

        # get the base symbols if required
        if find_base_symbol:
            return [s.resolve_base_symbol() for s in found_symbols]
        else:
            return list(found_symbols)

    def find_single(self, name: str, find_base_symbol: bool = False, default=None) -> Optional[Symbol]:
        results = self.find(name, find_base_symbol)

        if len(results) == 1:
            return results[0]

        assert len(results) == 0

        return default

    def find_type(self, ttype) -> 'Scope':
        key = type_key(ttype)
        scope = self.find_single(key)

        if scope is None:
            if ttype.is_array():
                # Arrays are also kind of meta types but the key is formed as a normal type key instead of a metatype
                # key. Depending on the storage type of the array (which we don't currently associated with the Type
                # itself: this requires investigation)
                # The following members can be available:
                # https://docs.soliditylang.org/en/develop/types.html#array-members
                # We add them all regardless of the storage type and will let code later on handle the rules for
                # allowing calls to arrays with the wrong storage location.

                values = [('length', solnodes.IntType(False, 256))]
                # These are not available for String (which is a subclass of Array)
                methods = [
                    # TODO: should these be copied?
                    ('push', [], [ttype.base_type]),
                    ('push', [ttype.base_type], []),
                    ('pop', [], [])
                ] if not ttype.is_string() else []
                scope = create_builtin_scope(key, ttype, values=values, functions=methods)
            else:
                # TODO: guard for the probably bit
                # this is a primitive (probably). E.g. We look up <type: int256>
                fields = []
                if ttype.is_function():
                    # Function selector, specific to the function type itself
                    fields.append(('selector', solnodes.FixedLengthArrayType(solnodes.ByteType(), 4)))
                scope = create_builtin_scope(key, ttype, values=fields)
            self.add_global_symbol(scope)
            return scope
        elif isinstance(scope, BuiltinObject):
            # already exists as a builtin
            return scope
        else:
            # exists but this is a weird case where we have a using statement that extends the builtin,
            # that's why I've separated it out
            return scope

    def find_metatype(self, ttype, is_interface) -> 'Scope':
        # Find or create a scope with the type <metatype: {ttype}> on demand which has the builtin values that
        # type(ttype) has in Solidity
        key = meta_type_key(ttype)
        scope = self.find_single(key)

        # It doesn't exist, create it and set it as the 'scope'
        if scope is None:
            # Create a meta type entry in the symbol table
            # Fields from https://docs.soliditylang.org/en/latest/units-and-global-variables.html#type-information
            members = [
                ('name', solnodes.StringType()), ('creationCode', solnodes.ArrayType(solnodes.ByteType())),
                ('runtimeCode', solnodes.ArrayType(solnodes.ByteType()))
            ]

            # X in type(X)
            # base_ttype = ttype.ttype

            # All the int types have a min and a max
            if ttype.is_int():
                members.extend([('min', ttype), ('max', ttype)])

            # Interfaces have interfaceId (bytes4)
            if is_interface:
                members.append(('interfaceId', solnodes.FixedLengthArrayType(solnodes.ByteType(), 4)))

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

        all_syms = self.all_symbols()

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
    def __init__(self, name: str, input_types: List[solnodes.Type], output_types: List[solnodes.Type]):
        ScopeAndSymbol.__init__(self, name, None)
        self.input_types = input_types
        self.output_types = output_types


class BuiltinValue(Symbol):
    def __init__(self, name: str, ttype: solnodes.Type):
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
    return f'<type:{str(ttype)}>'


def meta_type_key(ttype) -> str:
    return f'<metatype:{str(ttype)}>'


class RootScope(Scope):
    def __init__(self):
        Scope.__init__(self, '<root>')

        msg_object = BuiltinObject('msg')
        msg_object.add(BuiltinValue('value', solnodes.IntType(False, 256)))
        msg_object.add(BuiltinValue('gas', solnodes.IntType(False, 256)))
        msg_object.add(BuiltinValue('sender', solnodes.AddressType(False)))
        msg_object.add(BuiltinValue('data', solnodes.FixedLengthArrayType(solnodes.ByteType(), 4)))
        self.add(msg_object)

        def bytes():
            return solnodes.ArrayType(solnodes.ByteType())

        def bytes32():
            return solnodes.FixedLengthArrayType(solnodes.ByteType(), 32)

        def uint(size=256):
            return solnodes.IntType(False, size)

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

        # abi.decode(bytes memory encodedData, (...)) returns (...)
        abi_object.add(BuiltinFunction('decode', None, None))

        self.add(abi_object)

        block_object = BuiltinObject('block')
        block_object.add(BuiltinValue('basefee', uint()))
        block_object.add(BuiltinValue('chainid', uint()))
        block_object.add(BuiltinValue('coinbase', solnodes.AddressType(True)))
        block_object.add(BuiltinValue('difficulty', uint()))
        block_object.add(BuiltinValue('gaslimit', uint()))
        block_object.add(BuiltinValue('number', uint()))
        block_object.add(BuiltinValue('timestamp', uint()))
        self.add(block_object)

        tx_object = BuiltinObject('tx')
        tx_object.add(BuiltinValue('gasprice', uint()))
        tx_object.add(BuiltinValue('origin', solnodes.AddressType(False)))
        self.add(tx_object)

        # https://docs.soliditylang.org/en/latest/units-and-global-variables.html#members-of-address-types
        def address_object(payable):
            # key is <type: address> or <type: address payable>
            t = solnodes.AddressType(payable)
            scope = BuiltinObject(type_key(t), t)
            scope.add(BuiltinValue('balance', uint()))
            scope.add(BuiltinValue('code', bytes()))
            scope.add(BuiltinValue('codehash', bytes32()))

            if payable:
                scope.add(BuiltinFunction('transfer', [uint()], []))
                scope.add(BuiltinFunction('transfer', [uint()], [solnodes.BoolType()]))

            scope.add(BuiltinFunction('call', [bytes()], [solnodes.BoolType(), bytes()]))
            scope.add(BuiltinFunction('delegatecall', [bytes()], [solnodes.BoolType(), bytes()]))
            scope.add(BuiltinFunction('staticcall', [bytes()], [solnodes.BoolType(), bytes()]))
            return scope

        self.add(address_object(True))
        self.add(address_object(False))

        # Builtin global functions
        self.add(BuiltinFunction('keccak256', None, [bytes32()]))
        # addmod(uint x, uint y, uint k) returns (uint)
        # mulmod(uint x, uint y, uint k) returns (uint)
        self.add(BuiltinFunction('addmod', [uint(), uint(), uint()], [uint()]))
        self.add(BuiltinFunction('mulmod', [uint(), uint(), uint()], [uint()]))

        self.add(BuiltinFunction('ecrecover', [bytes32(), uint(8), bytes32(), bytes32()], [solnodes.AddressType(False)]))

        self.add(BuiltinFunction('gasleft', [], [uint()]))

        self.add(BuiltinFunction('blockhash', [uint()], [bytes32()]))

        self.add(BuiltinFunction('require', [solnodes.BoolType(), solnodes.StringType()], []))
        self.add(BuiltinFunction('require', [solnodes.BoolType()], []))

        self.add(BuiltinFunction('revert', [solnodes.StringType()], []))


class FileScope(ScopeAndSymbol):
    @staticmethod
    def alias(source_unit_name: str):
        return f'<source_unit:{source_unit_name}>'

    def __init__(self, builder: 'Builder2', vfs: VirtualFileSystem, source_unit_name: str):
        ScopeAndSymbol.__init__(self, self.alias(source_unit_name), None)
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

    def set_parent_scope(self, parent_scope: Scope):
        assert isinstance(parent_scope, FileScope)
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)


class ContractOrInterfaceScope(ScopeAndSymbol):
    def __init__(self, ast_node: Union[solnodes.ContractDefinition, solnodes.InterfaceDefinition]):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)

    def set_parent_scope(self, parent_scope: Scope):
        assert isinstance(parent_scope, FileScope)
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)

    def find_local(self, name: str) -> Optional[List[Symbol]]:
        found_symbols = Scope.find_local(self, name)
        if found_symbols:
            return found_symbols
        else:
            for super_contract in self.get_supers():
                found_symbols = super_contract.find(name, False)
                if found_symbols:
                    return found_symbols
        return []

    def get_supers(self) -> List['ContractOrInterfaceScope']:
        klass_file_scope: FileScope = self.parent_scope
        superklasses: List[ContractOrInterfaceScope] = []
        for inherit_specifier in self.value.inherits:
            # inherit specifier => name type => name ident => text str
            name = inherit_specifier.name.name.text
            symbol = klass_file_scope.find_single(name, True)
            assert isinstance(symbol, ContractOrInterfaceScope), f'Got {symbol.aliases}::{type(symbol)}'
            superklasses.append(symbol)
        return superklasses


class StructScope(ScopeAndSymbol):
    def __init__(self, ast_node: solnodes.StructDefinition):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)

    def set_parent_scope(self, parent_scope: Scope):
        assert isinstance(parent_scope, (FileScope, ContractOrInterfaceScope, LibraryScope))
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)


class LibraryScope(ScopeAndSymbol):
    def __init__(self, ast_node: solnodes.LibraryDefinition):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)

    def set_parent_scope(self, parent_scope: Scope):
        assert isinstance(parent_scope, FileScope)
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)


class EnumScope(ScopeAndSymbol):
    def __init__(self, ast_node: solnodes.EnumDefinition):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)

    def set_parent_scope(self, parent_scope: Scope):
        assert isinstance(parent_scope, (FileScope, ContractOrInterfaceScope, LibraryScope, EnumScope))
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)


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

    def get_imported_scope(self) -> Optional[FileScope]:
        source_unit: FileScope = self.parent_scope
        import_path = self.value.path
        return source_unit.get_imported_source_unit(import_path)


class AliasImportSymbol(ImportSymbol):
    def __init__(self, ast_node: solnodes.SymbolImportDirective, alias_index):
        # ast_node.aliases here is essentially [(symbol=X,alias=Y)]
        # take all the Y's and put them as this ImportSymbol Symbol.aliases, but we need
        # the X's if Y is looked up to find X

        self.alias_index = alias_index
        ImportSymbol.__init__(self, ast_node.aliases[alias_index].alias.text, ast_node)

    def resolve_base_symbol(self) -> 'Symbol':
        alias: solnodes.SymbolAlias = self.value.aliases[self.alias_index]
        symbol_name = alias.symbol.text
        imported_scope = self.get_imported_scope()
        return imported_scope.find(symbol_name)


class UnitImportSymbol(ImportSymbol):
    def __init__(self, ast_node: solnodes.UnitImportDirective):
        ImportSymbol.__init__(self, ast_node.alias.text, ast_node)

    def resolve_base_symbol(self) -> 'Symbol':
        return self.get_imported_scope()


class ProxyScope(ScopeAndSymbol):
    def __init__(self, name: str, base_scope: ScopeAndSymbol):
        ScopeAndSymbol.__init__(self, name, base_scope.value if base_scope else None)
        if base_scope:
            self.import_symbols_from_scope(base_scope)
        self.base_scope = base_scope

    def resolve_base_symbol(self) -> 'Symbol':
        if self.base_scope:
            return self.base_scope.resolve_base_symbol()
        else:
            return self


class UsingFunctionSymbol(Symbol):
    def __init__(self, target: ModFunErrEvtScope, override_type: solnodes.Type):
        assert isinstance(target.value, solnodes.FunctionDefinition)
        Symbol.__init__(self, target.aliases, target.value)
        self.target = target
        self.override_type = override_type

    def resolve_base_symbol(self) -> 'Symbol':
        return self.target


class Builder2:

    class Context:
        def __init__(self, file_scope, unit_scope):
            self.file_scope = file_scope
            self.unit_scope = unit_scope

    def __init__(self, vfs: VirtualFileSystem):
        self.root_scope = RootScope()
        self.vfs = vfs

    def process_or_find(self, loaded_source: LoadedSource):
        # found_fs = [s for s in self.root_scope.symbols if isinstance(s, FileScope) and s.source_unit_name == loaded_source.source_unit_name]
        found_fs = self.root_scope.symbols.get(FileScope.alias(loaded_source.source_unit_name))
        if found_fs:
            assert len(found_fs) == 1
            found_fs = found_fs[0]

        print(f'FS {loaded_source.source_unit_name} exists={bool(found_fs)}')

        if not found_fs:
            found_fs = self.process_file(loaded_source.source_unit_name, loaded_source.ast)

        return found_fs

    def process_or_find_from_base_dir(self, relative_source_unit_name: str):
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

        fs = FileScope(self, self.vfs, source_unit_name)

        context = Builder2.Context(fs, None)

        self.add_to_scope(self.root_scope, fs)

        for index, node in enumerate(source_units):
            self.add_node_dfs(fs, node, context, index)


        return fs

    def add_node_dfs(self, parent_scope, node, context: Context, visit_index=0):
        """
        Recursively traverse a node and its children and create symbols and scopes in a nested hierarchy

        This function adds newly created symbols and scopes to the given parent scope and does not return anything
        """

        if node is None:
            # base case, nothing to do
            return

        # we need to add any created symbols/scope to a parent
        assert parent_scope is not None, 'No parent scope'

        # the nodes scope is the scope it was created in always
        node.scope = parent_scope

        # track the scope for the nodes children later
        current_scope = parent_scope

        # Process the node for new symbols or a new scope
        scope_or_symbols = self.process_node(node, context, visit_index)
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
            current_scope = scope_or_symbols
            node.owning_scope = current_scope

        # add the created symbols under the parent scope. The process_node call above either makes a new
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

        if isinstance(scope_or_symbols, (ContractOrInterfaceScope, LibraryScope, StructScope, EnumScope)):
            # update the context for the children if a new top level scope was made
            context = Builder2.Context(context.file_scope, scope_or_symbols)

        child_scope = current_scope
        for child_index, child_node in enumerate(node.get_children()):
            if isinstance(child_node, solnodes.VarDecl):
                scope_name = ','.join([var.var_name.text for var in child_node.variables])
                new_scope = self.make_scope(child_node, name=f'<vardecl:{scope_name}>')

                self.add_to_scope(child_scope, new_scope)

                var_symbols = [self.make_symbol(var, name=var.var_name.text) for var in child_node.variables]
                self.add_to_scope(new_scope, *var_symbols)

                # do this before setting the child scope
                self.add_node_dfs(child_scope, child_node, context, child_index)
                child_scope = new_scope
            else:
                self.add_node_dfs(child_scope, child_node, context, child_index)

    def add_to_scope(self, parent: Scope, *children: Symbol):
        if children is not None:
            for child in children:
                parent.add(child)

    def make_scope(self, node: solnodes.Node, name=None):
        if name is None:
            name = node.name.text
        return ScopeAndSymbol(name, node)

    def make_symbol(self, node: solnodes.Node, sym_type=Symbol, name=None):
        if name is None:
            name = node.name.text
        return sym_type(name, node)

    def scope_name(self, base_name, node):
        return f'<{base_name}>@{node.location}'

    def lookup_name_in_scope(self, scope, name):
        if '.' in name:
            parts = name.split('.')
            s = scope
            for p in parts:
                s = s.find_single(p)
            return s
        else:
            return scope.find_single(name)

    def process_node(self, node, context: Context, visit_index: int):
        if isinstance(node, solnodes.UsingDirective):
            if isinstance(node.override_type, solnodes.AnyType):
                raise NotImplemented("using X for *")
            else:
                # get the functions in the target library and import them under the scope of the 1st param type
                # current_file_scope: FileScope = context.file_scope
                unit_scope = context.unit_scope
                library_scope: Scope = unit_scope.find(node.library_name.text)[0]
                target_type = node.override_type

                # Not sure if this is possible and I don't want to handle it(yet), just want to handle Types
                # for target_type
                if isinstance(target_type, solnodes.Ident):
                    raise ValueError()

                target_type_scope = None
                target_scope_name = None

                # Need to get the symbol name/alias/key for the target type, for primitives this is easy: just encode it
                # as a type key. For user reference types, it depends on how it's referenced, e.g. it could be just
                # MyT or could be qualified as A.B.MyT where B is in the scope of A and MyT is in the scope of B (etc)
                if isinstance(target_type, solnodes.UserType):
                    # Resolve the name used here to the actual contract/struct/etc (symbol)
                    raw_name = target_type.name.text
                    target_type = self.lookup_name_in_scope(unit_scope, raw_name)
                    # Use the name as defined by the target type symbol itself so that we can do definite checks against
                    # this type and the first parameter type later, i.e. for A.B.MyT, use MyT as the type key
                    target_scope_name = target_type.value.name.text
                else:
                    # Solidity type, e.g. <type:int>, <type:byte[]}, etc
                    # needs to be a list because
                    target_type_scope = unit_scope.find_type(target_type)
                    target_scope_name = target_type_scope.aliases[0]

                # We find the scope for the target type (i.e. X in 'using Y for X') and create a proxy of that scope in
                # our own local scope and add the functions from Y to the proxy(not the base scope of X)
                # This is so we can lookup functions in like x.z() in the proxy scope (as it will not exist in the base
                # scope) as the Using directive is only 'active' in the current scope (as opposed to on a global level)

                def make_proxy_scope(base_scope):
                    new_proxy_scope = ProxyScope(target_scope_name, base_scope)
                    new_proxy_scope.created_by = unit_scope

                    libs = base_scope.libraries[:] if base_scope and hasattr(base_scope, 'libraries') else []
                    lib = library_scope.value.name.text
                    if lib not in libs:
                        libs.append(lib)
                    new_proxy_scope.libraries = libs

                    unit_scope.add(new_proxy_scope)
                    return new_proxy_scope

                if not target_type_scope:
                    target_type_scope = unit_scope.find_single(target_scope_name)

                if not target_type_scope:
                    # We don't have a solid scope for this type, create the proxy as the base scope
                    proxy_scope = make_proxy_scope(None)
                elif isinstance(target_type_scope, ProxyScope):
                    if target_type_scope.created_by != unit_scope:
                        # don't extend the parent proxy scope(using directives aren't inherited and even we allow them
                        # to be we would need to check the libraries to ensure symbols aren't duplicated)
                        # find its real base
                        real_base = target_type_scope.find_first_ancestor(lambda x: not isinstance(x, ProxyScope),
                                                                          lambda x: x.base_scope)
                        assert real_base
                        proxy_scope = make_proxy_scope(real_base)
                    else:
                        # a proxy scope created by this current contract but for a different lib (this can happen when
                        # multiple libraries are used for the same type)
                        lib = library_scope.value.name.text
                        assert lib not in target_type_scope.libraries
                        target_type_scope.libraries.append(lib)
                        proxy_scope = target_type_scope
                else:
                    # there exists a scope for this type but it's not a proxy scope, so it's most likely a
                    # user type or builtin scope: create a proxy for this using directive
                    proxy_scope = make_proxy_scope(target_type_scope)

                for s in library_scope.all_symbols():
                    func_def = s.value
                    if not isinstance(func_def, solnodes.FunctionDefinition):
                        continue
                    if func_def.parameters:
                        first_parameter_type = func_def.parameters[0].var_type
                        # Resolve the parameter type if required (if it's a user defined type) and compared to the
                        # target type
                        if isinstance(first_parameter_type, solnodes.UserType):
                            param_symbol = self.lookup_name_in_scope(library_scope, first_parameter_type.name.text)
                            if param_symbol == target_type:
                                proxy_scope.add(UsingFunctionSymbol(s, target_type))
                        elif first_parameter_type == target_type:
                            proxy_scope.add(UsingFunctionSymbol(s, target_type))
        elif isinstance(node, solnodes.PragmaDirective):
            return None
        elif isinstance(node, solnodes.SymbolImportDirective):
            return [AliasImportSymbol(node, i) for i in range(0, len(node.aliases))]
        elif isinstance(node, solnodes.UnitImportDirective):
            return UnitImportSymbol(node)
        elif isinstance(node, solnodes.ImportDirective):
            # This is an import that looks like: import "myfile.sol". All the symbols from myfile are loaded into
            # the current file scope, so we have to load myfile, take its symbols and add them to the current file scope
            current_file_scope = context.file_scope
            imported_file = current_file_scope.get_imported_source_unit(node.path)
            current_file_scope.import_symbols_from_scope(imported_file)
            return None  # no new node is made from this
        elif isinstance(node, (solnodes.FunctionDefinition, solnodes.EventDefinition,
                               solnodes.ErrorDefinition, solnodes.ModifierDefinition)):
            return ModFunErrEvtScope(node)
        elif isinstance(node, solnodes.LibraryDefinition):
            return LibraryScope(node)
        elif isinstance(node, (solnodes.ContractDefinition, solnodes.InterfaceDefinition)):
            return ContractOrInterfaceScope(node)
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
        elif isinstance(node, solnodes.ContractPart):
            # This catches: ModifierDefinition, StructDefinition, EnumDefinition,
            # StateVariableDeclaration, EventDefinition, ErrorDefinition. These all have a 'name'
            # UsingDirective and FunctionDefinition also are ContractParts but this needs to be handled differently
            # (above)
            return self.make_scope(node)
        elif isinstance(node, solnodes.SourceUnit):
            # This catches: PragmaDirective, ImportDirective, UnitImportDirective, SymbolImportDirective,
            # ConstantVariableDeclaration, ContractDefinition, InterfaceDefinition, LibraryDefinition.
            # Some ContractParts, import directives and PragmaDirective are also SourceUnits but handled separately
            # above
            return self.make_scope(node)
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
