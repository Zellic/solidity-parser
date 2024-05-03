:py:mod:`solidity_parser.ast.ast2builder`
=========================================

.. py:module:: solidity_parser.ast.ast2builder


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.ast2builder.ErrorHandler
   solidity_parser.ast.ast2builder.TypeHelper
   solidity_parser.ast.ast2builder.Builder




Attributes
~~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.ast2builder.T


.. py:data:: T

   

.. py:class:: ErrorHandler(create_state, quiet_errors=True)


   Keeps track of what AST2Builder is doing and captures the line tracking information when errors happen. Also wraps
   Python errors in our own errors types if required and provides assertion failure checking.

   The general idea of this class is to make sure AST2Builder operations return consistent error types by wrapping
   them in CodeProcessingErrors so that the client can catch and decide what to do with them.

   .. py:method:: handle_processing_error(error: solidity_parser.errors.CodeProcessingError)

      Error callback handler for AST2Builder functions to call when a CodeProcessingError (only) occurs.


   .. py:method:: make_processing_error_args(message: str, node: solidity_parser.ast.solnodes.AST1Node) -> solidity_parser.errors.CPEArgs
      :staticmethod:

      Helper to make the input args tuple for a CodeProcessingError from a message and AST1 node 


   .. py:method:: with_error_context(func)

      Decorator that takes a function, f, and wraps it in a function that captures the current state of the builder
      before executing f and restores the state afterwards. If any errors occur in the process, a CodeProcessingError
      (specifically an UnexpectedCodeProcessingError) is raised, which should be allowed to propagate to the client of
      the builder.


   .. py:method:: todo(node) -> T

      Forces an error if the node is not supported by the builder. Since it always raises, the return type is fully
      polymorphic and can be used by the builder to do anything.
      E.g. a common pattern is to return the result of this function to mark the end of control flow in the builder
      code return self.error_handler.todo(node)


   .. py:method:: error(msg, *predicates)

      Raises an error with the given message if any of the predicates fail. This is used for user level errors, i.e.
      the input code is invalid


   .. py:method:: assert_error(msg, *predicates)

      Raises an assertion error with the given message if any of the predicates fail, very similar to error but used
      for 'internal' errors, i.e. compiler assumptions that must pass


   .. py:method:: _todo(node) -> T


   .. py:method:: _error(msg, *predicates)


   .. py:method:: _assert_error(msg, *predicates)



.. py:class:: TypeHelper(builder: Builder, error_handler: ErrorHandler)


   Helper class for computing AST2 types from AST1 nodes. This is required because AST1 nodes are not linked and do not
   have type information associated with some nodes, i.e. the node trees aren't able to compute types on their own.

   .. py:method:: any_or_all(args)
      :staticmethod:

      Returns True if any or all args are True 


   .. py:method:: create_filter_using_scope(base_type: solidity_parser.ast.types.Type)


   .. py:method:: get_current_contract_type(node) -> solidity_parser.ast.solnodes2.ResolvedUserType

      Returns the ResolvedUserType the given node is declared in 


   .. py:method:: get_expr_type(expr: solidity_parser.ast.solnodes.Expr | solidity_parser.ast.types.Type, allow_multiple=False, force_tuple=False, function_callee=False) -> Union[solidity_parser.ast.solnodes2.Types, list[solidity_parser.ast.solnodes2.Types]]

      Main helper function that computes the AST2 type of the given AST1 expression

      :param expr: The AST1 expression to type, may be a Type also as types are part of both the AST1 and AST2 nodeset
      :param allow_multiple: Changes the return of this function to a list of types instead of a single type. This is
                             required for expressions that may need extra contextual information to return a single
                             resolved Type, e.g. the callee of a function call without its arguments may resolve to
                             multiple callsites and if this is set to True, the return type will be a list of function
                             types
      :param force_tuple: Forces the return type to be a TupleType instead of a single type in cases where it's
                          ambiguous, e.g. the expression (x) can be either a bracket expression or a tuple expression
      :param function_callee: Whether the expression is the callee of a function call, required to compute the type of
                              state variable lookups as Solidity generates getter functions if the variable is used as
                              a function callee
      :return: The AST2 type of the expression or a list of types if allow_multiple is True


   .. py:method:: get_function_expr_type(expr, allow_multiple=False, return_target_symbol=False)


   .. py:method:: map_as_type_arg(arg)

      This function tries to force the given expr argument into a type if it looks like a type

      The supplied grammar is ambiguous and sometimes parses types as expression e.g. byte[100] would end up as an
      array access instead of a fixed length byte array. I've only really seen this happen for arguments of function
      calls, i.e. in abi.decode hence the name of the function. Should probably see if this happens in other places in
      the grammar too...


   .. py:method:: param_types(ps)

      Returns the types of the given parameters 


   .. py:method:: symbol_to_ast2_type(symbol, function_callee=False) -> solidity_parser.ast.solnodes2.Types

      Computes the AST2 type of the given symtab Symbol


   .. py:method:: scopes_for_type(node: solidity_parser.ast.solnodes.AST1Node, ttype: solidity_parser.ast.solnodes2.Types, use_encoded_type_key=True) -> List[solidity_parser.ast.symtab.Scope]


   .. py:method:: map_type(ttype: solidity_parser.ast.types.Type) -> solidity_parser.ast.solnodes2.Types


   .. py:method:: get_contract_type(user_type_symbol: solidity_parser.ast.symtab.Symbol) -> solidity_parser.ast.solnodes2.ResolvedUserType


   .. py:method:: _symtab_top_level_predicate(base_scope)


   .. py:method:: get_user_type(ttype: solidity_parser.ast.types.UserType)

      Maps an AST1 UserType to AST2 ResolvedUserType in the scope of the AST1 node that references the type



.. py:class:: Builder


   .. py:class:: State


      .. py:attribute:: current_node
         :type: solidity_parser.ast.solnodes.AST1Node

         


   .. py:class:: FunctionCallee


      .. py:attribute:: base
         :type: Optional[solidity_parser.ast.solnodes2.Expr | solidity_parser.ast.symtab.Symbol]

         

      .. py:attribute:: symbols
         :type: List[solidity_parser.ast.symtab.Symbol]

         


   .. py:class:: PartialFunctionCallee


      Bases: :py:obj:`FunctionCallee`

      .. py:attribute:: named_args
         :type: Dict[str, solidity_parser.ast.solnodes2.Expr]

         


   .. py:attribute:: ASSIGN_TO_OP

      

   .. py:method:: link_with_ast1()


   .. py:method:: get_top_level_units() -> List[solidity_parser.ast.solnodes2.TopLevelUnit]


   .. py:method:: enqueue_files(files: List[solidity_parser.ast.symtab.FileScope])


   .. py:method:: process_all()


   .. py:method:: load_non_top_level_if_required(ast1_node: solidity_parser.ast.solnodes.SourceUnit | solidity_parser.ast.solnodes.ContractPart) -> solidity_parser.ast.solnodes2.ContractPart

      Ensures the given AST1 non top level node has been skeletoned as an AST2 node. This will
      in turn skeleton any parent nodes that need to be made.

      For top level nodes use the load_if_required function instead


   .. py:method:: load_if_required(user_type_symbol: solidity_parser.ast.symtab.Symbol) -> solidity_parser.ast.solnodes2.TopLevelUnit


   .. py:method:: refine_stmt(node: solidity_parser.ast.solnodes.Stmt, allow_none=False)


   .. py:method:: get_declaring_contract_scope(node: solidity_parser.ast.solnodes.AST1Node) -> Union[solidity_parser.ast.symtab.ContractOrInterfaceScope, solidity_parser.ast.symtab.LibraryScope, solidity_parser.ast.symtab.EnumScope, solidity_parser.ast.symtab.StructScope, solidity_parser.ast.symtab.EnumScope, solidity_parser.ast.symtab.FileScope]


   .. py:method:: get_declaring_contract_scope_in_scope(scope: solidity_parser.ast.symtab.Symbol) -> Union[solidity_parser.ast.symtab.ContractOrInterfaceScope, solidity_parser.ast.symtab.LibraryScope, solidity_parser.ast.symtab.EnumScope, solidity_parser.ast.symtab.StructScope, solidity_parser.ast.symtab.EnumScope, solidity_parser.ast.symtab.FileScope]


   .. py:method:: get_self_object(node: Union[solidity_parser.ast.solnodes.Stmt, solidity_parser.ast.solnodes.Expr])


   .. py:method:: get_super_object(node: Union[solidity_parser.ast.solnodes.Stmt, solidity_parser.ast.solnodes.Expr])


   .. py:method:: refine_call_function(expr, allow_error=False, allow_stmt=False, allow_event=False)


   .. py:method:: is_subcontract(a: solidity_parser.ast.symtab.Scope, b: solidity_parser.ast.symtab.Scope)


   .. py:method:: find_bound_operator_symbol(expr: solidity_parser.ast.solnodes.UnaryOp | solidity_parser.ast.solnodes.BinaryOp, input_types: list[solidity_parser.ast.solnodes2.Types])


   .. py:method:: refine_bound_operator(expr: Union[solidity_parser.ast.solnodes.UnaryOp, solidity_parser.ast.solnodes.BinaryOp], inputs: List[solidity_parser.ast.solnodes2.Expr])


   .. py:method:: get_function_call_symbol_base(s: solidity_parser.ast.symtab.Symbol)


   .. py:method:: get_function_callee_buckets(symbols: List[solidity_parser.ast.symtab.Symbol])


   .. py:method:: refine_expr(expr: solidity_parser.ast.solnodes.Expr, is_function_callee=False, allow_type=False, allow_tuple_exprs=False, allow_multiple_exprs=False, allow_none=True, allow_stmt=False, is_argument=False, is_assign_rhs=False, allow_event=False)


   .. py:method:: find_method(possible_matches: list[solidity_parser.ast.symtab.Symbol], arg_types: list[solidity_parser.ast.solnodes2.Types])


   .. py:method:: var(node: Union[solidity_parser.ast.solnodes.Var, solidity_parser.ast.solnodes.Parameter])


   .. py:method:: parameter(node: solidity_parser.ast.solnodes.Parameter)


   .. py:method:: error_parameter(node: solidity_parser.ast.solnodes.ErrorParameter)


   .. py:method:: ident(node: solidity_parser.ast.solnodes.Ident)


   .. py:method:: modifiers(node_with_modifiers)


   .. py:method:: modifier(node: solidity_parser.ast.solnodes.Modifier)


   .. py:method:: process_code_block(node: solidity_parser.ast.solnodes.Block)


   .. py:method:: block(node: solidity_parser.ast.solnodes.Block)


   .. py:method:: get_synthetic_owner(source_unit_name, file_scope: solidity_parser.ast.symtab.FileScope) -> solidity_parser.ast.solnodes2.FileDefinition


   .. py:method:: define_skeleton(ast1_node: solidity_parser.ast.solnodes.SourceUnit, source_unit_name: Optional[str]) -> solidity_parser.ast.solnodes2.TopLevelUnit | solidity_parser.ast.solnodes2.ContractPart


   .. py:method:: refine_unit_or_part(ast1_node: Union[solidity_parser.ast.solnodes.SourceUnit, solidity_parser.ast.solnodes2.FileDefinition])


   .. py:method:: is_top_level(node: solidity_parser.ast.solnodes.AST1Node)


   .. py:method:: should_create_skeleton(node: solidity_parser.ast.solnodes.AST1Node) -> bool



