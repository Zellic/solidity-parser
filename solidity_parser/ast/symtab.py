from typing import Union, List, Dict, Optional
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

    def find_first_ancestor(self, predicate):
        """Walks up the symbol tree and finds the first element that satisfies the given predicate"""
        current = self.parent_scope
        while current and not predicate(current):
            current = current.parent_scope
        return current


class Symbol(Scopeable):
    def __init__(self, aliases: Optional[Aliases], value, static_type: solnodes.Type = None):
        Scopeable.__init__(self, aliases)

        self.value = value
        self.order = -1

        self.static_type = static_type

    def resolve_base_symbol(self) -> 'Symbol':
        # Return the symbol this symbol points to, if one exists.
        return self

    def type_of(self):
        return self.static_type

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

    def is_defined(self, name: str) -> bool:
        # check if the name exists in the table and it contains something
        return name in self.symbols and bool(self.symbols[name])

    def all_symbols(self):
        return set([item for sublist in self.symbols.values() for item in sublist])

    def import_symbols_from_scope(self, other_scope: 'Scope'):
        new_symbols = defaultdict(list)

        for (k, v) in self.symbols.items():
            new_symbols[k].extend(v)
        for (k,v) in other_scope.symbols.items():
            new_symbols[k].extend(v)

        self.symbols = new_symbols

    def add(self, symbol: Symbol):
        symbol.set_parent_scope(self)

        for name in symbol.aliases:
            self.symbols[name].append(symbol)

    def find_local(self, name: str) -> Optional[List[Symbol]]:
        """Finds a mapped symbol in this scope only"""
        if name in self.symbols:
            return self.symbols[name]
        return []

    def find(self, name: str, find_base_symbol: bool = False) -> Optional[List[Symbol]]:
        # check this scope first
        found_symbols = self.find_local(name)
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
        return f"Scope: {self.scope_name}" + self.str__symbols(level)


class ScopeAndSymbol(Scope, Symbol):
    def __init__(self, aliases: Optional[Aliases], ast_node):
        Scope.__init__(self, aliases)
        Symbol.__init__(self, aliases, ast_node)

    def set_parent_scope(self, parent_scope: 'Scope'):
        Symbol.set_parent_scope(self, parent_scope)

    def __str__(self, level=0):
        return f"{type(self).__name__}: {self.aliases}{self.str_type()}" + Scope.str__symbols(self, level)


class PrimitiveTypeScope(ScopeAndSymbol):
    def __init__(self, aliases: Optional[Aliases], static_type):
        ScopeAndSymbol.__init__(self, aliases)


class RootScope(Scope):
    def __init__(self):
        Scope.__init__(self, '<root>')

        msg_object = Scope('msg')
        msg_object.add(Symbol('data', None, solnodes.ArrayType(solnodes.ByteType())))
        msg_object.add(Symbol('gas', None, solnodes.IntType(False, 256)))
        msg_object.add(Symbol('sender', None, solnodes.AddressType(False)))
        msg_object.add(Symbol('sig', None, solnodes.FixedLengthArrayType(solnodes.ByteType(), 4)))
        msg_object.add(Symbol('value', None, solnodes.IntType(False, 256)))

        self.add(msg_object)

        abi_object = Scope('abi')
        # TODO: function type
        abi_object.add(Symbol('encode', None, None))
        abi_object.add(Symbol('decode', None, None))
        abi_object.add(Symbol('encodePacked', None, None))

        self.add(abi_object)

        # primitive types

        # int/int256 type
        # self.add(Symbol(['int', 'int256'], None, solnodes.IntType(True, 256)))    # signed
        # self.add(Symbol(['uint', 'uint256'], None, solnodes.IntType(False, 256))) # unsigned

        # int types, 8, 16, ... 240, 248
        # for i in range(1, 32):
        #     size = i * 8
        #     self.add(Symbol(f'int{size}', None, solnodes.IntType(True, size)))  # signed
        #     self.add(Symbol(f'uint{size}', None, solnodes.IntType(False, size)))  # unsigned


class FileScope(ScopeAndSymbol):
    def __init__(self, builder: 'Builder2', vfs: VirtualFileSystem, source_unit_name: str):
        ScopeAndSymbol.__init__(self, f'<source_unit:{source_unit_name}>', None)
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

    def type_of(self):
        # The file itself doesn't have a type associated with it,
        # only the contracts/interfaces/functions etc inside it do
        return solnodes.NoType()


class ContractOrInterfaceScope(ScopeAndSymbol):
    def __init__(self, ast_node: Union[solnodes.ContractDefinition, solnodes.InterfaceDefinition]):
        ScopeAndSymbol.__init__(self, ast_node.name.text, ast_node)

    def set_parent_scope(self, parent_scope: Scope):
        assert isinstance(parent_scope, FileScope)
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)

    def type_of(self):
        return self.value.name.text

    def get_supers(self) -> List['ContractOrInterfaceScope']:
        klass_file_scope: FileScope = self.parent_scope
        superklasses: List[ContractOrInterfaceScope] = []
        for inherit_specifier in self.value.inherits:
            # inherit specifier => name type => name ident => text str
            name = inherit_specifier.name.name.text
            symbol = klass_file_scope.find(name, True)
            assert isinstance(symbol, ContractOrInterfaceScope), f'Got {symbol.aliases}::{type(symbol)}'
            superklasses.append(symbol)
        return superklasses

    def get_local_method(self, name):
        def matches(symbol: Symbol):
            return isinstance(symbol.value, solnodes.FunctionDefinition) and str(symbol.value.name) == name

        candidates = [s.value for s in self.symbols.values() if matches(s)]

        return candidates


class ModFunErrEvtScope(ScopeAndSymbol):
    def __init__(self, ast_node: [solnodes.FunctionDefinition, solnodes.EventDefinition,
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

    def type_of(self):
        return solnodes.NoType()


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


class Builder2:

    class Context:
        def __init__(self, file_scope):
            self.file_scope = file_scope

    def __init__(self, vfs: VirtualFileSystem):
        self.root_scope = RootScope()
        self.vfs = vfs

    def process_or_find(self, loaded_source: LoadedSource):
        found_fs = [s for s in self.root_scope.symbols if isinstance(s, FileScope) and str(s.value.name) == loaded_source.source_unit_name]
        print(f'FS {loaded_source.source_unit_name} exists={bool(found_fs)}')

        if not found_fs:
            found_fs = self.process_file(loaded_source.source_unit_name, loaded_source.ast)

        return found_fs

    def process_file(self, source_unit_name: str, source_units: List[solnodes.SourceUnit] = None):
        if source_units is None:
            source = self.vfs.lookup_import_path(source_unit_name, '')
            source_units = source.ast
            if not source_units:
                raise ValueError(f'Could not load {source_unit_name} from root')

        fs = FileScope(self, self.vfs, source_unit_name)

        context = Builder2.Context(fs)

        for node in source_units:
            self.add_node_dfs(fs, node, context)

        self.add_to_scope(self.root_scope, fs)

        return fs

    def add_node_dfs(self, parent_scope, node, context: Context):
        if node is None:
            return None

        assert parent_scope is not None, 'No parent scope'

        node.scope = parent_scope

        current_scope = parent_scope

        scope_or_symbols = self.process_node(node, context)
        if scope_or_symbols is None:
            new_symbols = []
        elif isinstance(scope_or_symbols, list):
            # this is assumed to be a list of symbols
            new_symbols = scope_or_symbols
        elif isinstance(scope_or_symbols, Symbol):
            new_symbols = [scope_or_symbols]
        else:
            assert False, f'Invalid processing of {node} => {scope_or_symbols}'

        if isinstance(scope_or_symbols, Scope):
            current_scope = scope_or_symbols

        for new_child_sym in new_symbols:
            self.add_to_scope(parent_scope, new_child_sym)

        for child_node in node.get_children():
            self.add_node_dfs(current_scope, child_node, context)

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

    def process_node(self, node, context: Context):
        if isinstance(node, solnodes.UsingDirective):
            if isinstance(node.override_type, solnodes.AnyType):
                raise NotImplemented("using X for *")
            else:
                # get the functions in the target library and import them under the scope of the 1st param type
                current_file_scope: FileScope = context.file_scope
                library_file_scope: FileScope = current_file_scope.find(node.library_name.text)[0]
                target_type = node.override_type

                for s in library_file_scope.all_symbols():
                    func_def: solnodes.FunctionDefinition = s.value
                    if func_def.parameters:
                        first_parameter_type = func_def.parameters[0].var_type
                        print(first_parameter_type)
                        if first_parameter_type == target_type:
                            print("BONG")
                        else:
                            print("BING")
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
        elif isinstance(node, (solnodes.ContractDefinition, solnodes.InterfaceDefinition)):
            return ContractOrInterfaceScope(node)
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
        elif isinstance(node, solnodes.StructDefinition):
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
            return self.make_symbol(node)
        elif isinstance(node, solnodes.VarDecl):
            return [self.make_symbol(var, name=var.var_name.text) for var in node.variables]
        elif isinstance(node, solnodes.Block):
            return ScopeAndSymbol(self.scope_name('block', node), node)
        return None
