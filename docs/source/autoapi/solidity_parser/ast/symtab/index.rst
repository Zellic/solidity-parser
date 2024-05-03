:py:mod:`solidity_parser.ast.symtab`
====================================

.. py:module:: solidity_parser.ast.symtab


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.symtab.Scopeable
   solidity_parser.ast.symtab.Symbol
   solidity_parser.ast.symtab.CrossScopeSymbolAlias
   solidity_parser.ast.symtab.Scope
   solidity_parser.ast.symtab.ScopeAndSymbol
   solidity_parser.ast.symtab.BuiltinObject
   solidity_parser.ast.symtab.BuiltinFunction
   solidity_parser.ast.symtab.BuiltinValue
   solidity_parser.ast.symtab.RootScope
   solidity_parser.ast.symtab.FileScope
   solidity_parser.ast.symtab.LibraryScope
   solidity_parser.ast.symtab.ContractOrInterfaceScope
   solidity_parser.ast.symtab.StructScope
   solidity_parser.ast.symtab.UserDefinedValueTypeScope
   solidity_parser.ast.symtab.LibraryScope
   solidity_parser.ast.symtab.EnumScope
   solidity_parser.ast.symtab.ModFunErrEvtScope
   solidity_parser.ast.symtab.ImportSymbol
   solidity_parser.ast.symtab.AliasImportSymbol
   solidity_parser.ast.symtab.UnitImportSymbol
   solidity_parser.ast.symtab.ProxyScope
   solidity_parser.ast.symtab.UsingDirectiveScope
   solidity_parser.ast.symtab.UsingFunctionSymbol
   solidity_parser.ast.symtab.UsingOperatorSymbol
   solidity_parser.ast.symtab.Builder2



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.symtab.bytes
   solidity_parser.ast.symtab.bytesn
   solidity_parser.ast.symtab.bytes32
   solidity_parser.ast.symtab.uint
   solidity_parser.ast.symtab.ACCEPT
   solidity_parser.ast.symtab.unit_scope_of
   solidity_parser.ast.symtab.ACCEPT_INHERITABLE
   solidity_parser.ast.symtab.is_top_level
   solidity_parser.ast.symtab.is_using_directive_scope
   solidity_parser.ast.symtab.predicate_ignore_inherited_usings
   solidity_parser.ast.symtab.predicate_accept_top_levels
   solidity_parser.ast.symtab.ACCEPT_NO_INHERITED_USINGS
   solidity_parser.ast.symtab.ACCEPT_CALLABLES
   solidity_parser.ast.symtab.ACCEPT_NOT
   solidity_parser.ast.symtab.ACCEPT_TOP_LEVEL_SCOPE
   solidity_parser.ast.symtab.ACCEPT_ALL
   solidity_parser.ast.symtab.test_predicate
   solidity_parser.ast.symtab._add_to_results
   solidity_parser.ast.symtab.create_builtin_scope
   solidity_parser.ast.symtab.type_key
   solidity_parser.ast.symtab.meta_type_key



Attributes
~~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.symtab.Aliases


.. py:data:: Aliases
   :type: TypeAlias

   

.. py:function:: bytes()


.. py:function:: bytesn(n)


.. py:function:: bytes32()


.. py:function:: uint(size=256)


.. py:function:: ACCEPT(x)


.. py:function:: unit_scope_of(s)


.. py:function:: ACCEPT_INHERITABLE(base_scope)


.. py:function:: is_top_level(node: solidity_parser.ast.nodebase.Node)


.. py:function:: is_using_directive_scope(sym: Symbol) -> bool


.. py:function:: predicate_ignore_inherited_usings(base_scope)


.. py:function:: predicate_accept_top_levels(sym: Symbol) -> bool


.. py:function:: ACCEPT_NO_INHERITED_USINGS(base_scope)


.. py:function:: ACCEPT_CALLABLES(x)


.. py:function:: ACCEPT_NOT(p)


.. py:function:: ACCEPT_TOP_LEVEL_SCOPE(x)


.. py:function:: ACCEPT_ALL(*predicates)


.. py:function:: test_predicate(xs, predicate=None)


.. py:function:: _add_to_results(possible_symbols: Collection, results: list, found_already: Set)


.. py:class:: Scopeable(aliases: Optional[Aliases])


   Element that can be added as a child of a Scope

   .. py:attribute:: _T

      

   .. py:method:: set_parent_scope(parent_scope: Scope)

      Sets the parent scope of this element, subclasses can check the type of the parent for sanity checks 


   .. py:method:: find_first_ancestor(predicate: Callable[[Scopeable], bool], get_parent: Optional[Callable[[Scopeable], Scope]] = None) -> Optional[_T]

      Walks up the symbol tree and finds the first element that satisfies the given predicate

      :param predicate: a function that takes a Scopeable and returns a bool to determine if it matches
      :param get_parent: a function that takes a Scopeable and returns its parent, defaults to the parent_scope of a
                         Scopeable
      :return: the first Scopeable that satisfies the predicate


   .. py:method:: find_first_ancestor_of(ttype: Type[_T]) -> Optional[_T]

      Find the first ancestor that is of the given type, note: these are python types and not solc types.

      :param ttype: e.g. ContractOrInterfaceScope
      :return: the first ancestor that is of the given type


   .. py:method:: _check_single_symbol(name, results, default)



.. py:class:: Symbol(aliases: Optional[Aliases], value)


   Bases: :py:obj:`Scopeable`

   Element that can be added as a child of a Scope

   .. py:method:: get_as_dealiased_symbols() -> list[Symbol]


   .. py:method:: res_syms() -> list[Symbol]


   .. py:method:: res_syms_single()


   .. py:method:: set_parent_scope(parent_scope: Scope)

      Sets the parent scope of this element, subclasses can check the type of the parent for sanity checks 


   .. py:method:: str_type()


   .. py:method:: __str__(level=0)

      Return str(self).



.. py:class:: CrossScopeSymbolAlias(aliases: Aliases, other_symbol: Symbol)


   Bases: :py:obj:`Symbol`

   Element that can be added as a child of a Scope

   .. py:method:: res_syms() -> list[Symbol]


   .. py:method:: get_as_dealiased_symbols() -> list[Symbol]



.. py:class:: Scope(aliases: Optional[Aliases])


   Bases: :py:obj:`Scopeable`

   Element that can be added as a child of a Scope

   .. py:method:: is_defined(name: str) -> bool

      Check if the name exists in the current scopes local table, i.e. whether it was declared in the current scope


   .. py:method:: get_direct_children() -> Collection[Symbol]

      Get all children declared directly in this scope


   .. py:method:: get_all_children(collect_predicate, explore_branch_predicate)

      Tree explorer for all DECLARED children and grandchildren, i.e. doesn't look at imports


   .. py:method:: get_all_functions() -> list[ModFunErrEvtScope]

      Gets all DECLARED functions in the current scope/descendant scopes


   .. py:method:: import_symbols_from_scope(other_scope: Scope)

      Links the symbols in another scope to the current scope, i.e. makes the imported symbols visible in the current
      scope

      :param other_scope: The scope whose symbols should be imported


   .. py:method:: add_global_symbol(symbol: Symbol)

      Helper function to add a symbol to the global scope(RootScope)


   .. py:method:: add(symbol: Symbol)

      Adds a symbol to the current scope and set its parent scope to this scope


   .. py:method:: find_current_level(name: str, predicate=None, visited_scopes: Set[Scope] = None) -> list[Symbol]

      Finds symbols in this scope or any imported scopes at the current "level". A level is roughly the scopes that
      are visible by an expression in the current scope.


   .. py:method:: find_imported(name: str, predicate=None, visited_scopes: Set = None) -> list[Symbol]

      Finds the given name in all the imported scopes that are linked to the current scope. This can match many
      valid symbols so it is up to the caller to choose the right one, however, the results are deduplicated by
      checking that two symbols dealias to the same symbol.


   .. py:method:: find_local(name: str) -> list[Symbol]

      Finds symbols in this scope's symbol table only


   .. py:method:: find_from_parent(name: str, predicate=None) -> list[Symbol]


   .. py:method:: find_multi_part_symbol(name: str, find_base_symbol: bool = False, predicate=None)

      Finds a potentially multi-part/qualified symbol (e.g. a.b.c)


   .. py:method:: find(name: str, find_base_symbol: bool = False, predicate=None, dealias: bool = True) -> list[Symbol]

      Entry point for the symbol finder. Finds the given name in this scope and any imported scopes

      Parameters:
          name (str): The name to search for.
          find_base_symbol (bool): Whether to find base symbols.
          predicate (function): A function to filter symbols.
          dealias (bool): Whether to dealias symbols.

      Returns:
          list[Symbol]: A list of symbols that match the search criteria.


   .. py:method:: find_single(name: str, find_base_symbol: bool = False, default=None, predicate=None) -> Optional[Symbol]


   .. py:method:: find_user_type_scope(name, find_base_symbol: bool = False, default=None, predicate=None) -> Union[Scope, list[Scope]]

      Finds the scope of a user-defined type based on the given name.
      :param name: The name of the type
      :param find_base_symbol: Whether to find the base symbol or whether using scopes are acceptable results
      :param default: The default value to return if no matches are found
      :param predicate: Optional function to filter during the search

      :return: A single scope if find_base_symbol is True, or a list of scopes if find_base_symbol is False


   .. py:method:: find_type(ttype, predicate=None, as_single=False) -> Optional[Scope] | list[Scope]

      Finds the scope for the given type in the current scope. The type scope might be different to the scope of the
      type where the type was defined because of using statements.
      A scope is created if one isn't visible in the current scope.

      :param ttype: The type to search for, CANNOT be a user type, use `find_user_type_scope` for that case
      :param predicate: Optional function to filter during the search
      :param as_single: Whether to return a single scope or a list of scopes

      :return: The scope if as_single is True or a list of scopes if as_single is False


   .. py:method:: find_metatype(ttype, is_interface, is_enum) -> Scope


   .. py:method:: str__symbols(level=0)

      Returns a string representation of all symbols in this scope and its children with indentation 


   .. py:method:: __str__(level=0)

      Return str(self).



.. py:class:: ScopeAndSymbol(aliases: Optional[Aliases], ast_node)


   Bases: :py:obj:`Scope`, :py:obj:`Symbol`

   Element that can be added as a child of a Scope

   .. py:method:: set_parent_scope(parent_scope: Scope)

      Sets the parent scope of this element, subclasses can check the type of the parent for sanity checks 


   .. py:method:: __str__(level=0)

      Return str(self).



.. py:class:: BuiltinObject(name: str, value=None)


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope


.. py:class:: BuiltinFunction(name: str, input_types: list[solidity_parser.ast.types.Type] | None, output_types: list[solidity_parser.ast.types.Type] | None)


   Bases: :py:obj:`Symbol`

   Element that can be added as a child of a Scope


.. py:class:: BuiltinValue(name: str, ttype: solidity_parser.ast.types.Type)


   Bases: :py:obj:`Symbol`

   Element that can be added as a child of a Scope


.. py:function:: create_builtin_scope(key, value=None, values=None, functions=None)


.. py:function:: type_key(ttype) -> str


.. py:function:: meta_type_key(ttype) -> str


.. py:class:: RootScope(parser_version: solidity_parser.util.version_util.Version)


   Bases: :py:obj:`Scope`

   Element that can be added as a child of a Scope


.. py:class:: FileScope(builder: Builder2, vfs: solidity_parser.filesys.VirtualFileSystem, source_unit_name: str, ast1_units: list[solidity_parser.ast.solnodes.SourceUnit])


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope

   .. py:method:: alias(source_unit_name: str)
      :staticmethod:


   .. py:method:: get_imported_source_unit(import_path: str) -> Optional[FileScope]


   .. py:method:: set_parent_scope(parent_scope: Scope)

      Sets the parent scope of this element, subclasses can check the type of the parent for sanity checks 



.. py:class:: LibraryScope(ast_node: solidity_parser.ast.solnodes.LibraryDefinition)


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope


.. py:class:: ContractOrInterfaceScope(ast_node: Union[solidity_parser.ast.solnodes.ContractDefinition, solidity_parser.ast.solnodes.InterfaceDefinition])


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope

   .. py:method:: find_current_level(name: str, predicate=None, visited_scopes: Set = None, check_hierarchy=True) -> Optional[list[Symbol]]

      Finds symbols in this scope or any imported scopes at the current "level". A level is roughly the scopes that
      are visible by an expression in the current scope.


   .. py:method:: find_in_contract_hierarchy(name: str, predicate, visited_scopes)


   .. py:method:: get_supers() -> list[ContractOrInterfaceScope]



.. py:class:: StructScope(ast_node: solidity_parser.ast.solnodes.StructDefinition)


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope


.. py:class:: UserDefinedValueTypeScope(ast_node: solidity_parser.ast.solnodes.UserValueType)


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope


.. py:class:: LibraryScope(ast_node: solidity_parser.ast.solnodes.LibraryDefinition)


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope


.. py:class:: EnumScope(ast_node: solidity_parser.ast.solnodes.EnumDefinition)


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope


.. py:class:: ModFunErrEvtScope(ast_node: Union[solidity_parser.ast.solnodes.FunctionDefinition, solidity_parser.ast.solnodes.EventDefinition, solidity_parser.ast.solnodes.ErrorDefinition, solidity_parser.ast.solnodes.ModifierDefinition])


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope


.. py:class:: ImportSymbol(aliases: Optional[Aliases], ast_node: solidity_parser.ast.solnodes.ImportDirective)


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope

   .. py:method:: get_as_dealiased_symbols() -> list[Symbol]


   .. py:method:: get_imported_scope() -> Optional[FileScope]


   .. py:method:: _get_imported_symbols() -> list[Symbol]


   .. py:method:: res_syms() -> list[Symbol]


   .. py:method:: get_direct_children() -> Collection[Symbol]

      Get all children declared directly in this scope


   .. py:method:: find(name: str, find_base_symbol: bool = False, predicate=None, dealias: bool = True) -> Optional[list[Symbol]]

      Entry point for the symbol finder. Finds the given name in this scope and any imported scopes

      Parameters:
          name (str): The name to search for.
          find_base_symbol (bool): Whether to find base symbols.
          predicate (function): A function to filter symbols.
          dealias (bool): Whether to dealias symbols.

      Returns:
          list[Symbol]: A list of symbols that match the search criteria.


   .. py:method:: find_metatype(ttype, is_interface, is_enum) -> Scope


   .. py:method:: find_local(name: str) -> Optional[list[Symbol]]

      Finds symbols in this scope's symbol table only


   .. py:method:: find_first_ancestor(predicate, get_parent=None)

      Walks up the symbol tree and finds the first element that satisfies the given predicate

      :param predicate: a function that takes a Scopeable and returns a bool to determine if it matches
      :param get_parent: a function that takes a Scopeable and returns its parent, defaults to the parent_scope of a
                         Scopeable
      :return: the first Scopeable that satisfies the predicate


   .. py:method:: find_first_ancestor_of(ttype: Union[Type, Tuple[Type]])

      Find the first ancestor that is of the given type, note: these are python types and not solc types.

      :param ttype: e.g. ContractOrInterfaceScope
      :return: the first ancestor that is of the given type


   .. py:method:: find_imported(name: str, predicate=None, visited_scopes: Set = None) -> Optional[list[Symbol]]

      Finds the given name in all the imported scopes that are linked to the current scope. This can match many
      valid symbols so it is up to the caller to choose the right one, however, the results are deduplicated by
      checking that two symbols dealias to the same symbol.


   .. py:method:: find_current_level(name: str, predicate=None, visited_scopes: Set = None) -> Optional[list[Symbol]]

      Finds symbols in this scope or any imported scopes at the current "level". A level is roughly the scopes that
      are visible by an expression in the current scope.


   .. py:method:: find_single(name: str, find_base_symbol: bool = False, default=None, predicate=None) -> Optional[Symbol]


   .. py:method:: find_from_parent(name: str, predicate=None) -> list[Symbol]



.. py:class:: AliasImportSymbol(ast_node: solidity_parser.ast.solnodes.SymbolImportDirective, alias_index)


   Bases: :py:obj:`ImportSymbol`

   Element that can be added as a child of a Scope

   .. py:method:: _get_imported_symbols() -> list[Symbol]



.. py:class:: UnitImportSymbol(ast_node: solidity_parser.ast.solnodes.UnitImportDirective)


   Bases: :py:obj:`ImportSymbol`

   Element that can be added as a child of a Scope

   .. py:method:: _get_imported_symbols() -> list[Symbol]



.. py:class:: ProxyScope(name: str, base_scope: ScopeAndSymbol)


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope

   .. py:method:: res_syms() -> list[Symbol]



.. py:class:: UsingDirectiveScope(node: solidity_parser.ast.solnodes.UsingDirective)


   Bases: :py:obj:`ScopeAndSymbol`

   Element that can be added as a child of a Scope


.. py:class:: UsingFunctionSymbol(target: ModFunErrEvtScope, override_type: solidity_parser.ast.types.Type)


   Bases: :py:obj:`Symbol`

   Symbol for a function that was added to the current scope by a Solidity using statement. Solidity docs state that
   all functions, even those that don't match the type specifier in the using statement have to be added to the scope
   the using statement is declared in. This symbol type is required instead of the usual ModFunErrEvtSymbol as we need
   to be able to associate the bound type from the using statement and the first parameter type of the "value" of this
   symbol(i.e. the FunctionDefinition) may or may not be the same as the specified one.

   .. py:method:: res_syms() -> list[Symbol]



.. py:class:: UsingOperatorSymbol(target: ModFunErrEvtScope, override_type: solidity_parser.ast.types.Type, operator: Union[solidity_parser.ast.solnodes.UnaryOpCode, solidity_parser.ast.solnodes.BinaryOpCode])


   Bases: :py:obj:`Symbol`

   Similar to UsingFunctionSymbol except for operator overloads

   .. py:method:: res_syms() -> list[Symbol]



.. py:class:: Builder2(vfs: solidity_parser.filesys.VirtualFileSystem, parser_version: solidity_parser.util.version_util.Version = None)


   .. py:class:: Context(file_scope, unit_scope)



   .. py:method:: process_or_find(loaded_source: solidity_parser.filesys.LoadedSource)


   .. py:method:: process_or_find_from_base_dir(relative_source_unit_name: str | pathlib.Path)


   .. py:method:: process_file(source_unit_name: str, source_units: list[solidity_parser.ast.solnodes.SourceUnit] = None)


   .. py:method:: sort_ast_nodes(nodes)


   .. py:method:: add_node_dfs(parent_scope, node, context: Context, build_skeletons, visit_index=0)

      Recursively traverse a node and its children and create symbols and scopes in a nested hierarchy

      This function adds newly created symbols and scopes to the given parent scope and does not return anything


   .. py:method:: make_using_scope(node: solidity_parser.ast.solnodes.UsingDirective)


   .. py:method:: make_var_decl_scope(node: solidity_parser.ast.solnodes.VarDecl)


   .. py:method:: add_to_scope(parent: Scope, *children: Symbol)


   .. py:method:: make_scope(node: solidity_parser.ast.nodebase.Node, name=None)


   .. py:method:: make_symbol(node: solidity_parser.ast.nodebase.Node, sym_type=Symbol, name=None)


   .. py:method:: scope_name(base_name, node)


   .. py:method:: find_using_target_scope_and_name(current_scope, target_type: solidity_parser.ast.types.Type)


   .. py:method:: make_proxy_scope(scope_name, creator_scope, base_scope, library_scope=None)


   .. py:method:: get_proxy_scope_for_type(cur_scope, target_type, target_scope_name, target_type_scope, library_scope=None, check_lib=True)


   .. py:method:: get_using_function_symbol_for_func(target_type, target_type_scope, symbol, operator=None)


   .. py:method:: process_using_any_type(context: Context, node: solidity_parser.ast.solnodes.UsingDirective)


   .. py:method:: process_using_library_type(context: Context, node: solidity_parser.ast.solnodes.UsingDirective)


   .. py:method:: find_using_current_scope(node, context)


   .. py:method:: process_using_functions(node: solidity_parser.ast.solnodes.UsingDirective, context: Context)


   .. py:method:: process_using_directive(node: solidity_parser.ast.solnodes.UsingDirective, context: Context)


   .. py:method:: make_symbols_for_node(node, context: Context, build_skeletons: bool, visit_index: int)



