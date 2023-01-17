from typing import Union, List, Dict, Optional
from pathlib import Path
import os
from abc import ABC, abstractmethod

from solidity_parser.ast import solnodes


class Resolvable(ABC):
    """Trait for an element that resolves to a concrete symbol, e.g. a referenced import"""
    @abstractmethod
    def resolve(self) -> 'Symbol':
        """Finds the actual symbol for this resolvable"""


class Deferred(ABC):
    """Trait for an element that must do an online lookup to find an element.
    This is needed because the entire namespace of a file can be imported into file A.sol
    using 'import "B.sol"'.
    When the import is seen, instead of creating a new symbol table immediately for B.sol, we
    defer looking up symbols in it until something is looked up in A.sol's symbol table. This
    is what this class provides for.
    """
    @abstractmethod
    def find_deferred_symbol(self, name) -> Union['Symbol', Resolvable]:
        """Finds the symbol with the given name using a lookup mechanism"""


class Scopeable(ABC):
    """Element that can be added as a child of a Scope"""
    
    def __init__(self):
        self.parent_scope: Optional[Scope] = None

    @abstractmethod
    def get_names(self) -> Optional[List[str]]:
        """Gets the names or aliases this scopeable is known by"""

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
    def __init__(self, aliases: Optional[Union[str, List[str]]], value):
        Scopeable.__init__(self)

        # make it into a list if it's not
        if aliases is None:
            aliases = []
        elif not isinstance(aliases, list):
            aliases = [aliases]

        self.aliases: List[str] = aliases
        self.value = value
        self.order = -1

    def get_names(self) -> Optional[List[str]]:
        return self.aliases

    def set_parent_scope(self, parent_scope: 'Scope'):
        Scopeable.set_parent_scope(self, parent_scope)
        self.order = len(parent_scope.symbols)

    def str_type(self):
        return '' if not self.value else f' @{type(self.value).__name__}'

    def __str__(self, level=0):
        return f"Symbol: {self.aliases}{self.str_type()}"


Scopee = Union[Symbol, Resolvable]


class Scope(Scopeable):
    def __init__(self, scope_name: Optional[str] = None):
        Scopeable.__init__(self)
        self.scope_name: str = scope_name
        # collection of known mappings that can be looked up quickly
        self.symbols: Dict[str, Symbol] = {}
        # list of objects that have a specific lookup mechanism that needs to be
        # invoked for every symbol lookup
        # TODO: cache positive results
        self.links: List[Deferred] = []

    def get_names(self) -> Optional[List[str]]:
        return [self.scope_name] if self.scope_name else None

    def is_defined(self, name: str) -> bool:
        return name in self.symbols

    def add(self, args: Optional[Union[Scopee, List[Scopee]]]):
        if not args:
            return
        if isinstance(args, list):
            for a in args:
                if a:
                    self._add(a)
        else:
            self._add(args)

    def _add(self, child: Scopee):
        if isinstance(child, Symbol):
            child.set_parent_scope(self)
            aliases = child.get_names()

            for name in aliases:
                if self.is_defined(name):
                    raise KeyError(f"{name} already exists in scope: {self.scope_name}")

            for name in aliases:
                self.symbols[name] = child

        # Do this check for all scopees, including symbols (in case they're both)
        if isinstance(child, Deferred):
            self.links.append(child)

    def find_local(self, name: str) -> Optional[Symbol]:
        """Finds a mapped symbol in this scope only"""
        if name in self.symbols:
            return self.symbols[name]
        return None

    def find_linked(self, name: str) -> Optional[Union[Resolvable, Symbol]]:
        """Searches the deferred links that are registered for the given symbol"""
        for link in self.links:
            symbol = link.find_deferred_symbol(name)
            if symbol:
                return symbol
        return None

    def resolve_found_symbol(self, sym: Union[Symbol, Resolvable]) -> Symbol:
        """Resolves the given Resolvable to a Symbol if required"""
        if isinstance(sym, Resolvable):
            return sym.resolve()
        else:
            return sym

    def find(self, name: str) -> Optional[Symbol]:
        """Looks up the given Symbol by name using all mechanisms available in the scope
        The search order is as follows:
        1. Check for a direct name => value mapping this scope
        2. Check the registered deferred links
        3. Check the parent scope recursively with 1 and 2
        """
        symbol = self.find_local(name)
        if symbol:
            return self.resolve_found_symbol(symbol)
        symbol = self.find_linked(name)
        if symbol:
            return self.resolve_found_symbol(symbol)
        if self.parent_scope:
            symbol = self.parent_scope.find(name)
            if symbol:
                return self.resolve_found_symbol(symbol)
        return None

    def follow_find(self, *names):
        # TODO: remove
        current = self
        for name in names:
            current = current.find_local(name)
            if not current:
                return None
        return current

    def str__symbols(self, level=0):
        indent = '  ' * level
        indent1 = '  ' + indent

        all_syms = set(self.symbols.values())

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
    def __init__(self, name, ast_node):
        Scope.__init__(self, name)
        Symbol.__init__(self, name, ast_node)

    def get_names(self) -> Optional[List[str]]:
        return Symbol.get_names(self)

    def set_parent_scope(self, parent_scope: 'Scope'):
        Symbol.set_parent_scope(self, parent_scope)

    def __str__(self, level=0):
        # if the scope alias is the same as the symbol aliases then just use the scope alias, else dump all of them
        if len(self.aliases) == 1 and self.aliases[0] == self.scope_name:
            name = self.scope_name
        else:
            name = f"{self.scope_name}/{self.aliases}"

        return f"Scope/Symbol: {name}{Symbol.str_type(self)}" + Scope.str__symbols(self, level)


class RootScope(Scope):
    def __init__(self):
        Scope.__init__(self, '<root>')


class PathPartScope(ScopeAndSymbol):
    @staticmethod
    def part_name(part_name: str) -> str:
        return f'<path:{part_name}>'

    def __init__(self, part_name: str):
        ScopeAndSymbol.__init__(self, self.part_name(part_name), None)

    def set_parent_scope(self, parent_scope: 'Scope'):
        assert isinstance(parent_scope, (PathPartScope, RootScope))
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)

    @staticmethod
    def get_next_part(current, part_name, is_file=False) -> Optional[Union['FileScope', 'PathPartScope']]:
        if part_name == '.':
            return current
        elif part_name == '..':
            assert not isinstance(current, RootScope)
            return current.parent_scope
        else:
            key = FileScope.file_name(part_name) if is_file else PathPartScope.part_name(part_name)
            next_part = current.find_local(key)
            if next_part is None:
                return None

            assert isinstance(next_part, (FileScope, PathPartScope))
            return next_part

    def find_file(self, relative_path) -> Optional['FileScope']:
        # split the parts up, e.g. 
        parts = os.path.normpath(relative_path).split(os.sep)
        assert len(parts) > 0  # need at least the file name, so has to be more than 0

        first_part = parts[0]

        if first_part == '.' or first_part == '..':
            # Relative import, start searching from this path element
            current = self
        else:
            # Absolute import in Solidity terms, search from the root
            current = self.find_first_ancestor(lambda scope: isinstance(scope, RootScope))

        # search the path elements only(not the file name)
        for part in parts[:-1]:
            current = PathPartScope.get_next_part(current, part)
            if not current:
                return None

        return current.get_next_part(parts[-1], is_file=True)


class FileScope(ScopeAndSymbol):
    @staticmethod
    def file_name(file_name: str) -> str:
        return f'<file:{file_name}>'

    def __init__(self, file_name: str):
        """
        param file_name: The files simple name, i.e. for a file A://B/C, this would be C
        """
        ScopeAndSymbol.__init__(self, self.file_name(file_name), None)

    def set_parent_scope(self, parent_scope: 'Scope'):
        assert isinstance(parent_scope, PathPartScope)
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)


class ContractScope(ScopeAndSymbol):
    def __init__(self, ast_node: solnodes.ContractDefinition):
        ScopeAndSymbol.__init__(self, [ast_node.name.text], ast_node)

    def set_parent_scope(self, parent_scope: Scope):
        assert isinstance(parent_scope, FileScope)
        return ScopeAndSymbol.set_parent_scope(self, parent_scope)

    def find_linked(self, name: str) -> Optional[Symbol]:
        file_scope: FileScope = self.parent_scope
        for inherit in self.value.inherits:
            inherit_name = inherit.name.name.text
            inherit_scope: Scope = file_scope.find(inherit_name)

            if not inherit_scope:
                continue

            if inherit_name == name:
                return inherit_scope

            symbol = inherit_scope.find(name)
            if symbol:
                return symbol

        return ScopeAndSymbol.find_linked(self, name)

    # def resolve(self, name) -> Symbol:
    #     file_scope: FileScope = self.parent_scope
    #     for inherit in self.value.inherits:
    #         inherit_name = inherit.name.name.text
    #         inherit_scope: Scope = file_scope.find(inherit_name)
    #         print(inherit_scope)
            # symbol = inherit_scope.find(name)
            # if symbol:
            #     return symbol
        # return None



class ImportSymbol(ScopeAndSymbol):
    def __init__(self, aliases: List[str], ast_node: solnodes.ImportDirective):
        ScopeAndSymbol.__init__(self, aliases, ast_node)

    def get_imported_scope(self) -> Optional[FileScope]:
        # Get the current file scope, i.e. the one where this import statement is in
        file_scope = self.parent_scope
        # Parent of the file scope is the directory scope, from there we can explore the path
        directory_scope = file_scope.parent_scope
        # Traverse the import path from the directory
        import_file_scope = directory_scope.find_file(self.value.path)
        return import_file_scope


class AliasImportSymbol(ImportSymbol, Resolvable):
    def __init__(self, ast_node: solnodes.SymbolImportDirective, alias_index):
        # ast_node.aliases here is essentially [(symbol=X,alias=Y)]
        # take all the Y's and put them as this ImportSymbol Symbol.aliases, but we need
        # the X's if Y is looked up to find X

        self.alias_index = alias_index
        ImportSymbol.__init__(self, [ast_node.aliases[alias_index].alias.text], ast_node)

    def resolve(self) -> 'Symbol':
        alias: solnodes.SymbolAlias = self.value.aliases[self.alias_index]
        symbol_name = alias.symbol.text
        imported_scope = self.get_imported_scope()
        return imported_scope.find(symbol_name)


class GlobalImportSymbol(ImportSymbol, Deferred):
    def __init__(self, ast_node: solnodes.GlobalImportDirective):
        # This is an import of the form: import “./MySolidityFile.sol”;
        # i.e. it doesn't declare a symbol itself, it drags all the symbols from
        # MySolidityFile into this files context
        ImportSymbol.__init__(self, [], ast_node)

    def find_deferred_symbol(self, name) -> Union['Symbol', Resolvable]:
        imported_file_scope = self.get_imported_scope()
        if not imported_file_scope:
            return None
        return imported_file_scope.find(name)


class UnitImportSymbol(ImportSymbol):
    def __init__(self, ast_node: solnodes.UnitImportDirective):
        ImportSymbol.__init__(self, [ast_node.alias.text], ast_node)

    def resolve(self, name):
        assert [name] == self.aliases, f"Can't resolve {name} with this import symbol: {self.aliases}"
        return self.get_imported_scope()


class UsingSymbol(Symbol, Resolvable):
    def __init__(self, ast_node: solnodes.UsingDirective):
        Symbol.__init__(self, [str(ast_node.override_type)], ast_node)

    def set_parent_scope(self, parent_scope: Scope):
        assert isinstance(parent_scope, ContractScope)
        return Symbol.set_parent_scope(self, parent_scope)

    def resolve(self) -> 'Symbol':
        scope: ContractScope = self.parent_scope
        return scope.find(self.value.library_name.text)


class Builder2:
    def __init__(self):
        self.root_scope = RootScope()

    def build_or_find_path(self, directory_names: List[str]) -> PathPartScope:
        current_scope = self.root_scope
        for part in directory_names:
            next_scope = current_scope.find_local(PathPartScope.part_name(part))

            if next_scope is None:
                next_scope = PathPartScope(part)
                current_scope.add(next_scope)

            current_scope = next_scope
        return current_scope

    def process_file(self, file_path: Path, source_units):
        # Remove the last part which contains the file name (e.g. ABC.sol)
        directory_scope = self.build_or_find_path(list(file_path.parts)[:-1])
        file_scope = FileScope(file_path.name)

        for node in source_units:
            self.add_node_dfs(file_scope, node)

        self.add_to_scope(directory_scope, file_scope)

    def add_node_dfs(self, parent_scope, node):
        if node is None:
            return None

        assert parent_scope is not None, 'No parent scope'

        node.scope = parent_scope

        current_scope = parent_scope

        scope_or_symbols = self.process_node(node)
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
            self.add_node_dfs(current_scope, child_node)

    def add_to_scope(self, parent: Scope, child: Union[Scopee, List[Scopee]]):
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

    def process_node(self, node):

        if isinstance(node, solnodes.UsingDirective):
            if isinstance(node.override_type, solnodes.AnyType):
                raise NotImplemented("using X for *")
            else:
                return UsingSymbol(node)
        if isinstance(node, solnodes.PragmaDirective):
            return None
        elif isinstance(node, solnodes.SymbolImportDirective):
            return [AliasImportSymbol(node, i) for i in range(0, len(node.aliases))]
        elif isinstance(node, solnodes.UnitImportDirective):
            return UnitImportSymbol(node)
        elif isinstance(node, solnodes.ImportDirective):
            return GlobalImportSymbol(node)
        elif isinstance(node, solnodes.FunctionDefinition):
            return self.make_scope(node, name=node.name.value if isinstance(node.name,
                                                                            solnodes.SpecialFunctionKind) else None)
        elif isinstance(node, solnodes.ContractDefinition):
            return ContractScope(node)
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
