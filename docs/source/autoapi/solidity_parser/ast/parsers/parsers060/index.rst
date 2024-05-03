:py:mod:`solidity_parser.ast.parsers.parsers060`
================================================

.. py:module:: solidity_parser.ast.parsers.parsers060


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.parsers.parsers060.Parser060



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.parsers.parsers060.custom_parsers
   solidity_parser.ast.parsers.parsers060._block
   solidity_parser.ast.parsers.parsers060._if
   solidity_parser.ast.parsers.parsers060._try
   solidity_parser.ast.parsers.parsers060._while
   solidity_parser.ast.parsers.parsers060._for
   solidity_parser.ast.parsers.parsers060._inline_assembly_statement
   solidity_parser.ast.parsers.parsers060._dowhile
   solidity_parser.ast.parsers.parsers060._continue
   solidity_parser.ast.parsers.parsers060._break
   solidity_parser.ast.parsers.parsers060._return
   solidity_parser.ast.parsers.parsers060._throw
   solidity_parser.ast.parsers.parsers060._location
   solidity_parser.ast.parsers.parsers060._var
   solidity_parser.ast.parsers.parsers060._expr_stmt
   solidity_parser.ast.parsers.parsers060._emit
   solidity_parser.ast.parsers.parsers060._var_decl_stmt
   solidity_parser.ast.parsers.parsers060._identifier
   solidity_parser.ast.parsers.parsers060._array_identifier
   solidity_parser.ast.parsers.parsers060._name_value
   solidity_parser.ast.parsers.parsers060._function_call_args
   solidity_parser.ast.parsers.parsers060._function_call
   solidity_parser.ast.parsers.parsers060._function_call_expr
   solidity_parser.ast.parsers.parsers060._meta_type
   solidity_parser.ast.parsers.parsers060._payable_expr
   solidity_parser.ast.parsers.parsers060._unary_pre_op
   solidity_parser.ast.parsers.parsers060._delete_expr
   solidity_parser.ast.parsers.parsers060._unary_logic_op
   solidity_parser.ast.parsers.parsers060._unary_post_op
   solidity_parser.ast.parsers.parsers060._type_name
   solidity_parser.ast.parsers.parsers060._mapping_type
   solidity_parser.ast.parsers.parsers060.params_to_types
   solidity_parser.ast.parsers.parsers060._function_type_name
   solidity_parser.ast.parsers.parsers060._new_obj
   solidity_parser.ast.parsers.parsers060._array_slice
   solidity_parser.ast.parsers.parsers060._array_load
   solidity_parser.ast.parsers.parsers060._binary_expr
   solidity_parser.ast.parsers.parsers060._ternary_expr
   solidity_parser.ast.parsers.parsers060._primary
   solidity_parser.ast.parsers.parsers060._number_literal
   solidity_parser.ast.parsers.parsers060._hex_literal
   solidity_parser.ast.parsers.parsers060._string_literal
   solidity_parser.ast.parsers.parsers060._tuple_expr
   solidity_parser.ast.parsers.parsers060._member_load
   solidity_parser.ast.parsers.parsers060._parameter
   solidity_parser.ast.parsers.parsers060._catch_clause
   solidity_parser.ast.parsers.parsers060._elementary_type_name
   solidity_parser.ast.parsers.parsers060._user_defined_type
   solidity_parser.ast.parsers.parsers060._modifier_invocation
   solidity_parser.ast.parsers.parsers060._state_mutability
   solidity_parser.ast.parsers.parsers060._visibility_modifier
   solidity_parser.ast.parsers.parsers060._pragma_directive
   solidity_parser.ast.parsers.parsers060._version
   solidity_parser.ast.parsers.parsers060._version_constraint
   solidity_parser.ast.parsers.parsers060._module_import
   solidity_parser.ast.parsers.parsers060._alias_import
   solidity_parser.ast.parsers.parsers060._symbol_import
   solidity_parser.ast.parsers.parsers060._import_declaration
   solidity_parser.ast.parsers.parsers060.var_to_struct_member
   solidity_parser.ast.parsers.parsers060._struct_definition
   solidity_parser.ast.parsers.parsers060._enum_definition
   solidity_parser.ast.parsers.parsers060._enum_value
   solidity_parser.ast.parsers.parsers060._contract_definition
   solidity_parser.ast.parsers.parsers060._inheritance_specifier
   solidity_parser.ast.parsers.parsers060._state_variable_declaration
   solidity_parser.ast.parsers.parsers060._override_specifier
   solidity_parser.ast.parsers.parsers060._using_for_declaration
   solidity_parser.ast.parsers.parsers060._modifier_definition
   solidity_parser.ast.parsers.parsers060._function_definition
   solidity_parser.ast.parsers.parsers060._event_definition
   solidity_parser.ast.parsers.parsers060._event_parameter



.. py:class:: Parser060(token_stream)


   Bases: :py:obj:`solidity_parser.ast.parsers.common.ParserBase`


.. py:function:: custom_parsers()


.. py:function:: _block(parser, block: solidity_parser.grammar.v060.SolidityParser.SolidityParser.BlockContext)


.. py:function:: _if(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.IfStatementContext)


.. py:function:: _try(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.TryStatementContext)


.. py:function:: _while(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.WhileStatementContext)


.. py:function:: _for(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ForStatementContext)


.. py:function:: _inline_assembly_statement(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.InlineAssemblyStatementContext)


.. py:function:: _dowhile(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.DoWhileStatementContext)


.. py:function:: _continue(parser, _: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ContinueStatementContext)


.. py:function:: _break(parser, _: solidity_parser.grammar.v060.SolidityParser.SolidityParser.BreakStatementContext)


.. py:function:: _return(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ReturnStatementContext)


.. py:function:: _throw(parser, _: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ThrowStatementContext)


.. py:function:: _location(parser, loc: solidity_parser.grammar.v060.SolidityParser.SolidityParser.StorageLocationContext)


.. py:function:: _var(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.VariableDeclarationContext)


.. py:function:: _expr_stmt(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ExpressionStatementContext)


.. py:function:: _emit(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.EmitStatementContext)


.. py:function:: _var_decl_stmt(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.VariableDeclarationStatementContext)


.. py:function:: _identifier(parser, ident: solidity_parser.grammar.v060.SolidityParser.SolidityParser.IdentifierContext)


.. py:function:: _array_identifier(parser, ident: solidity_parser.ast.solnodes.Ident, array_dims: int)


.. py:function:: _name_value(parser, name_value: solidity_parser.grammar.v060.SolidityParser.SolidityParser.NameValueContext)


.. py:function:: _function_call_args(parser, args: solidity_parser.grammar.v060.SolidityParser.SolidityParser.FunctionCallArgumentsContext)


.. py:function:: _function_call(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.FunctionCallContext)


.. py:function:: _function_call_expr(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.FuncCallExprContext)


.. py:function:: _meta_type(parser, meta_type: solidity_parser.grammar.v060.SolidityParser.SolidityParser.MetaTypeContext)


.. py:function:: _payable_expr(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.PayableExprContext)


.. py:function:: _unary_pre_op(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.UnaryPreOpContext)


.. py:function:: _delete_expr(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.DeleteExprContext)


.. py:function:: _unary_logic_op(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.LogicOpContext)


.. py:function:: _unary_post_op(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.UnaryPostOpContext)


.. py:function:: _type_name(parser, type_name: solidity_parser.grammar.v060.SolidityParser.SolidityParser.TypeNameContext)


.. py:function:: _mapping_type(parser, mapping_type: solidity_parser.grammar.v060.SolidityParser.SolidityParser.MappingContext)


.. py:function:: params_to_types(params: solidity_parser.ast.solnodes.Parameter)


.. py:function:: _function_type_name(parser, function_type: solidity_parser.grammar.v060.SolidityParser.SolidityParser.FunctionTypeNameContext)


.. py:function:: _new_obj(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.NewTypeContext)


.. py:function:: _array_slice(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ArraySliceContext)


.. py:function:: _array_load(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ArrayLoadContext)


.. py:function:: _binary_expr(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.BinaryExprContext)


.. py:function:: _ternary_expr(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.TernaryExprContext)


.. py:function:: _primary(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.PrimaryExpressionContext)


.. py:function:: _number_literal(parser, literal: solidity_parser.grammar.v060.SolidityParser.SolidityParser.NumberLiteralContext)


.. py:function:: _hex_literal(parser, literal: solidity_parser.grammar.v060.SolidityParser.SolidityParser.HexLiteralContext)


.. py:function:: _string_literal(parser, literal: solidity_parser.grammar.v060.SolidityParser.SolidityParser.StringLiteralContext)


.. py:function:: _tuple_expr(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.TupleExpressionContext)


.. py:function:: _member_load(parser, expr: solidity_parser.grammar.v060.SolidityParser.SolidityParser.MemberLoadContext)


.. py:function:: _parameter(parser, stmt: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ParameterContext)


.. py:function:: _catch_clause(parser, clause: solidity_parser.grammar.v060.SolidityParser.SolidityParser.CatchClauseContext)


.. py:function:: _elementary_type_name(parser, name: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ElementaryTypeNameContext)


.. py:function:: _user_defined_type(parser, name: solidity_parser.grammar.v060.SolidityParser.SolidityParser.UserDefinedTypeNameContext)


.. py:function:: _modifier_invocation(parser, modifier: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ModifierInvocationContext)


.. py:function:: _state_mutability(parser, modifier: solidity_parser.grammar.v060.SolidityParser.SolidityParser.StateMutabilityContext)


.. py:function:: _visibility_modifier(parser, modifier: solidity_parser.grammar.v060.SolidityParser.SolidityParser.VisibilityModifierContext)


.. py:function:: _pragma_directive(parser, pragma_directive: solidity_parser.grammar.v060.SolidityParser.SolidityParser.PragmaDirectiveContext)


.. py:function:: _version(parser, version: solidity_parser.grammar.v060.SolidityParser.SolidityParser.VersionContext)


.. py:function:: _version_constraint(parser, version_constraint: solidity_parser.grammar.v060.SolidityParser.SolidityParser.VersionConstraintContext)


.. py:function:: _module_import(parser, module_import: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ModuleImportContext)


.. py:function:: _alias_import(parser, alias_import: solidity_parser.grammar.v060.SolidityParser.SolidityParser.AliasImportContext)


.. py:function:: _symbol_import(parser, symbol_import: solidity_parser.grammar.v060.SolidityParser.SolidityParser.SymbolImportContext)


.. py:function:: _import_declaration(parser, import_declaration: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ImportDeclarationContext)


.. py:function:: var_to_struct_member(var: solidity_parser.ast.solnodes.Var)


.. py:function:: _struct_definition(parser, struct_definition: solidity_parser.grammar.v060.SolidityParser.SolidityParser.StructDefinitionContext)


.. py:function:: _enum_definition(parser, enum_definition: solidity_parser.grammar.v060.SolidityParser.SolidityParser.EnumDefinitionContext)


.. py:function:: _enum_value(parser, enum_value: solidity_parser.grammar.v060.SolidityParser.SolidityParser.EnumValueContext)


.. py:function:: _contract_definition(parser, contract_definition: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ContractDefinitionContext)


.. py:function:: _inheritance_specifier(parser, inheritance_specifier: solidity_parser.grammar.v060.SolidityParser.SolidityParser.InheritanceSpecifierContext)


.. py:function:: _state_variable_declaration(parser, state_variable_declaration: solidity_parser.grammar.v060.SolidityParser.SolidityParser.StateVariableDeclarationContext)


.. py:function:: _override_specifier(parser, override_specific: solidity_parser.grammar.v060.SolidityParser.SolidityParser.OverrideSpecifierContext)


.. py:function:: _using_for_declaration(parser, using_for_declaration: solidity_parser.grammar.v060.SolidityParser.SolidityParser.UsingForDeclarationContext)


.. py:function:: _modifier_definition(parser, modifier_definition: solidity_parser.grammar.v060.SolidityParser.SolidityParser.ModifierDefinitionContext)


.. py:function:: _function_definition(parser, function_definition: solidity_parser.grammar.v060.SolidityParser.SolidityParser.FunctionDefinitionContext)


.. py:function:: _event_definition(parser, event_definition: solidity_parser.grammar.v060.SolidityParser.SolidityParser.EventDefinitionContext)


.. py:function:: _event_parameter(parser, event_parameter: solidity_parser.grammar.v060.SolidityParser.SolidityParser.EventParameterContext)


