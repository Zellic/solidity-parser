:py:mod:`solidity_parser.ast.parsers.parsers080`
================================================

.. py:module:: solidity_parser.ast.parsers.parsers080


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.parsers.parsers080.Parser080



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.parsers.parsers080.custom_parsers
   solidity_parser.ast.parsers.parsers080._try
   solidity_parser.ast.parsers.parsers080._pragma_directive
   solidity_parser.ast.parsers.parsers080._import_directive
   solidity_parser.ast.parsers.parsers080._path
   solidity_parser.ast.parsers.parsers080._import_alias
   solidity_parser.ast.parsers.parsers080._contract_definition
   solidity_parser.ast.parsers.parsers080._interface_definition
   solidity_parser.ast.parsers.parsers080._library_definition
   solidity_parser.ast.parsers.parsers080._inheritance_specifier
   solidity_parser.ast.parsers.parsers080._constructor_definition
   solidity_parser.ast.parsers.parsers080._function_definition
   solidity_parser.ast.parsers.parsers080._constant_variable_declaration
   solidity_parser.ast.parsers.parsers080._modifier_definition
   solidity_parser.ast.parsers.parsers080._fallback_function_definition
   solidity_parser.ast.parsers.parsers080._receive_function_definition
   solidity_parser.ast.parsers.parsers080._struct_definition
   solidity_parser.ast.parsers.parsers080._struct_member
   solidity_parser.ast.parsers.parsers080._enum_definition
   solidity_parser.ast.parsers.parsers080._state_variable_declaration
   solidity_parser.ast.parsers.parsers080._error_definition
   solidity_parser.ast.parsers.parsers080._error_parameter
   solidity_parser.ast.parsers.parsers080._using_directive
   solidity_parser.ast.parsers.parsers080._override_specifier
   solidity_parser.ast.parsers.parsers080._visibility
   solidity_parser.ast.parsers.parsers080._state_mutability
   solidity_parser.ast.parsers.parsers080._modifier_invocation
   solidity_parser.ast.parsers.parsers080._event_definition
   solidity_parser.ast.parsers.parsers080._event_parameter
   solidity_parser.ast.parsers.parsers080._block
   solidity_parser.ast.parsers.parsers080._unchecked_block
   solidity_parser.ast.parsers.parsers080._named_argument
   solidity_parser.ast.parsers.parsers080._parameter_declaration
   solidity_parser.ast.parsers.parsers080._call_argument_list
   solidity_parser.ast.parsers.parsers080._var_decl_stmt
   solidity_parser.ast.parsers.parsers080._data_location
   solidity_parser.ast.parsers.parsers080._variable_declaration
   solidity_parser.ast.parsers.parsers080._expr_stmt
   solidity_parser.ast.parsers.parsers080._catch_clause
   solidity_parser.ast.parsers.parsers080._emit
   solidity_parser.ast.parsers.parsers080._revert
   solidity_parser.ast.parsers.parsers080._assembly
   solidity_parser.ast.parsers.parsers080._index_access
   solidity_parser.ast.parsers.parsers080._index_range_access
   solidity_parser.ast.parsers.parsers080._member_access
   solidity_parser.ast.parsers.parsers080._func_call_expr
   solidity_parser.ast.parsers.parsers080._payable_conversion
   solidity_parser.ast.parsers.parsers080._meta_type
   solidity_parser.ast.parsers.parsers080._type_name
   solidity_parser.ast.parsers.parsers080._function_type_name
   solidity_parser.ast.parsers.parsers080._mapping_type
   solidity_parser.ast.parsers.parsers080._mapping_key_type
   solidity_parser.ast.parsers.parsers080._unary_prefix_operation
   solidity_parser.ast.parsers.parsers080._unary_suffix_operation
   solidity_parser.ast.parsers.parsers080._binary_expr
   solidity_parser.ast.parsers.parsers080._conditional_expr
   solidity_parser.ast.parsers.parsers080._new_obj
   solidity_parser.ast.parsers.parsers080._tuple_expression
   solidity_parser.ast.parsers.parsers080._inline_array
   solidity_parser.ast.parsers.parsers080._identifier
   solidity_parser.ast.parsers.parsers080._identifier_path
   solidity_parser.ast.parsers.parsers080._string_literal
   solidity_parser.ast.parsers.parsers080._number_literal
   solidity_parser.ast.parsers.parsers080._boolean_literal
   solidity_parser.ast.parsers.parsers080._hex_string_literal
   solidity_parser.ast.parsers.parsers080._unicode_string_literal
   solidity_parser.ast.parsers.parsers080._elementary_type_name



.. py:class:: Parser080(token_stream)


   Bases: :py:obj:`solidity_parser.ast.parsers.common.ParserBase`


.. py:function:: custom_parsers()


.. py:function:: _try(parser, stmt: solidity_parser.grammar.v080.SolidityParser.SolidityParser.TryStatementContext)


.. py:function:: _pragma_directive(parser, pragma_directive: solidity_parser.grammar.v080.SolidityParser.SolidityParser.PragmaDirectiveContext)


.. py:function:: _import_directive(parser, directive: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ImportDirectiveContext)


.. py:function:: _path(parser, path: solidity_parser.grammar.v080.SolidityParser.SolidityParser.PathContext)


.. py:function:: _import_alias(parser, import_alias: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ImportAliasesContext)


.. py:function:: _contract_definition(parser, contract_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ContractDefinitionContext)


.. py:function:: _interface_definition(parser, interface_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.InterfaceDefinitionContext)


.. py:function:: _library_definition(parser, library_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.LibraryDefinitionContext)


.. py:function:: _inheritance_specifier(parser, inheritance_specifier: solidity_parser.grammar.v080.SolidityParser.SolidityParser.InheritanceSpecifierContext)


.. py:function:: _constructor_definition(parser, constructor_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ConstructorDefinitionContext)


.. py:function:: _function_definition(parser, function_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.FunctionDefinitionContext)


.. py:function:: _constant_variable_declaration(parser, constant_variable_declaration: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ConstantVariableDeclarationContext)


.. py:function:: _modifier_definition(parser, modifier_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ModifierDefinitionContext)


.. py:function:: _fallback_function_definition(parser, fallback_function_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.FallbackFunctionDefinitionContext)


.. py:function:: _receive_function_definition(parser, receive_function_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ReceiveFunctionDefinitionContext)


.. py:function:: _struct_definition(parser, struct_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.StructDefinitionContext)


.. py:function:: _struct_member(parser, struct_member: solidity_parser.grammar.v080.SolidityParser.SolidityParser.StructMemberContext)


.. py:function:: _enum_definition(parser, enum_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.EnumDefinitionContext)


.. py:function:: _state_variable_declaration(parser, state_variable_declaration: solidity_parser.grammar.v080.SolidityParser.SolidityParser.StateVariableDeclarationContext)


.. py:function:: _error_definition(parser, error_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ErrorDefinitionContext)


.. py:function:: _error_parameter(parser, error_parameter: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ErrorParameterContext)


.. py:function:: _using_directive(parser, using_directive: solidity_parser.grammar.v080.SolidityParser.SolidityParser.UsingDirectiveContext)


.. py:function:: _override_specifier(parser, override_specific: solidity_parser.grammar.v080.SolidityParser.SolidityParser.OverrideSpecifierContext)


.. py:function:: _visibility(parser, visibility: solidity_parser.grammar.v080.SolidityParser.SolidityParser.VisibilityContext)


.. py:function:: _state_mutability(parser, state_mutability: solidity_parser.grammar.v080.SolidityParser.SolidityParser.StateMutabilityContext)


.. py:function:: _modifier_invocation(parser, modifier_invocation: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ModifierInvocationContext)


.. py:function:: _event_definition(parser, event_definition: solidity_parser.grammar.v080.SolidityParser.SolidityParser.EventDefinitionContext)


.. py:function:: _event_parameter(parser, event_parameter: solidity_parser.grammar.v080.SolidityParser.SolidityParser.EventParameterContext)


.. py:function:: _block(parser, block: solidity_parser.grammar.v080.SolidityParser.SolidityParser.BlockContext)


.. py:function:: _unchecked_block(parser, block: solidity_parser.grammar.v080.SolidityParser.SolidityParser.UncheckedBlockContext)


.. py:function:: _named_argument(parser, named_arg: solidity_parser.grammar.v080.SolidityParser.SolidityParser.NamedArgumentContext)


.. py:function:: _parameter_declaration(parser, parameter_declaration: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ParameterDeclarationContext)


.. py:function:: _call_argument_list(parser, arg_list: solidity_parser.grammar.v080.SolidityParser.SolidityParser.CallArgumentListContext)


.. py:function:: _var_decl_stmt(parser, stmt: solidity_parser.grammar.v080.SolidityParser.SolidityParser.VariableDeclarationStatementContext)


.. py:function:: _data_location(parser, location: solidity_parser.grammar.v080.SolidityParser.SolidityParser.DataLocationContext)


.. py:function:: _variable_declaration(parser, decl: solidity_parser.grammar.v080.SolidityParser.SolidityParser.VariableDeclarationContext)


.. py:function:: _expr_stmt(parser, stmt: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ExpressionStatementContext)


.. py:function:: _catch_clause(parser, catch_clause: solidity_parser.grammar.v080.SolidityParser.SolidityParser.CatchClauseContext)


.. py:function:: _emit(parser, stmt: solidity_parser.grammar.v080.SolidityParser.SolidityParser.EmitStatementContext)


.. py:function:: _revert(parser, stmt: solidity_parser.grammar.v080.SolidityParser.SolidityParser.RevertStatementContext)


.. py:function:: _assembly(parser, stmt: solidity_parser.grammar.v080.SolidityParser.SolidityParser.AssemblyStatementContext)


.. py:function:: _index_access(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.IndexAccessContext)


.. py:function:: _index_range_access(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.IndexRangeAccessContext)


.. py:function:: _member_access(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.MemberAccessContext)


.. py:function:: _func_call_expr(parser, func_call_expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.FuncCallExprContext)


.. py:function:: _payable_conversion(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.PayableConversionContext)


.. py:function:: _meta_type(parser, meta_type: solidity_parser.grammar.v080.SolidityParser.SolidityParser.MetaTypeContext)


.. py:function:: _type_name(parser, type_name: solidity_parser.grammar.v080.SolidityParser.SolidityParser.TypeNameContext)


.. py:function:: _function_type_name(parser, function_type: solidity_parser.grammar.v080.SolidityParser.SolidityParser.FunctionTypeNameContext)


.. py:function:: _mapping_type(parser, mapping: solidity_parser.grammar.v080.SolidityParser.SolidityParser.MappingTypeContext)


.. py:function:: _mapping_key_type(parser, mapping_key_type: solidity_parser.grammar.v080.SolidityParser.SolidityParser.MappingKeyTypeContext)


.. py:function:: _unary_prefix_operation(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.UnaryPrefixOperationContext)


.. py:function:: _unary_suffix_operation(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.UnarySuffixOperationContext)


.. py:function:: _binary_expr(parser, expr)


.. py:function:: _conditional_expr(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ConditionalContext)


.. py:function:: _new_obj(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.NewExpressionContext)


.. py:function:: _tuple_expression(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.TupleExpressionContext)


.. py:function:: _inline_array(parser, expr: solidity_parser.grammar.v080.SolidityParser.SolidityParser.InlineArrayExpressionContext)


.. py:function:: _identifier(parser, ident: solidity_parser.grammar.v080.SolidityParser.SolidityParser.IdentifierContext)


.. py:function:: _identifier_path(parser, ident_path: solidity_parser.grammar.v080.SolidityParser.SolidityParser.IdentifierPathContext)


.. py:function:: _string_literal(parser, literal: solidity_parser.grammar.v080.SolidityParser.SolidityParser.StringLiteralContext)


.. py:function:: _number_literal(parser, literal: solidity_parser.grammar.v080.SolidityParser.SolidityParser.NumberLiteralContext)


.. py:function:: _boolean_literal(parser, literal: solidity_parser.grammar.v080.SolidityParser.SolidityParser.BooleanLiteralContext)


.. py:function:: _hex_string_literal(parser, literal: solidity_parser.grammar.v080.SolidityParser.SolidityParser.HexStringLiteralContext)


.. py:function:: _unicode_string_literal(parser, literal: solidity_parser.grammar.v080.SolidityParser.SolidityParser.UnicodeStringLiteralContext)


.. py:function:: _elementary_type_name(parser, name: solidity_parser.grammar.v080.SolidityParser.SolidityParser.ElementaryTypeNameContext)


