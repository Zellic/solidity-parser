import sys
from solidity_parser.ast.parsers.common import ParserBase, get_all_subparsers, map_helper
from solidity_parser.ast.parsers.errors import ParsingException, unsupported_feature, assert_invalid_path
from solidity_parser.ast import nodes2

from solidity_parser.grammar.v060.SolidityParser import SolidityParser


class Parser060(ParserBase):
    def __init__(self):
        super().__init__({
            **get_all_subparsers(sys.modules[__name__]),
            **custom_parsers()
        })


def custom_parsers():
    return {
        'StatementContext': ParserBase.make_first,
        'BlockContext': ParserBase.make_all,
        # TODO: inline assembly
        'SimpleStatementContext': ParserBase.make_first,
        'BracketExprContext': ParserBase.make_first,
        'PrimaryContext': ParserBase.make_first,
        'NameValueListContext': ParserBase.make_all,
        'ExpressionListContext': ParserBase.make_all,
        'ReturnParametersContext': ParserBase.make_first,
        'ParameterListContext': ParserBase.make_all,
        'MappingKeyContext': ParserBase.make_first,
        'TypeNameExpressionContext': ParserBase.make_first,

        'ModifierListContext': ParserBase.make_all,

        'SourceUnitContext': ParserBase.make_first,
        'PragmaNameContext': ParserBase.make_first,
        'PragmaValueContext': ParserBase.make_first,
        'ContractPartContext': ParserBase.make_first,

        'EventParameterListContext': ParserBase.make_all,
    }


def _if(parser, stmt: 'IfStatementContext'):
    return nodes2.If(
        parser.make(stmt.expression()),
        parser.make(stmt.statement(0)),
        parser.make(stmt.statement(1))
    )


def _try(parser, stmt: 'TryStatementContext'):
    return nodes2.Try(
        parser.make(stmt.expression()),
        parser.make(stmt.returnParameters()),
        parser.make(stmt.block()),
        parser.make_all(stmt.catchClause())
    )


def _while(parser, stmt: 'WhileStatementContext'):
    return nodes2.While(
        parser.make(stmt.expression()),
        parser.make(stmt.statement())
    )


def _for(parser, stmt: 'ForStatementContext'):
    # grammar specifies expressionStatement for the condition part, but
    # it should be an expression on its own
    condition = parser.make(stmt.expressionStatement())
    condition = condition.expr if condition is not None else None

    return nodes2.For(
        parser.make(stmt.simpleStatement()),
        condition,
        parser.make(stmt.expression()),
        parser.make(stmt.statement())
    )


def _inline_assembly_statement(parser, stmt: SolidityParser.InlineAssemblyStatementContext):
    return nodes2.AssemblyStmt(stmt.getText())


def _dowhile(parser, stmt: 'DoWhileStatementContext'):
    return nodes2.DoWhile(
        parser.make(stmt.statement()),
        parser.make(stmt.expression())
    )


def _continue(parser, _: 'ContinueStatementContext'):
    return nodes2.Continue()


def _break(parser, _: 'BreakStatementContext'):
    return nodes2.Break()


def _return(parser, stmt: 'ReturnStatementContext'):
    return nodes2.Return(
        parser.make(stmt.expression())
    )


def _throw(parser, _: 'ThrowStatementContext'):
    return nodes2.Throw()


def _location(parser, loc: 'StorageLocationContext'):
    return nodes2.Location(loc.getText())


def _var(parser, stmt: 'VariableDeclarationContext'):
    return nodes2.Var(
        parser.make(stmt.typeName()),
        parser.make(stmt.storageLocation()),
        parser.make(stmt.identifier())
    )


def _expr_stmt(parser, stmt: 'ExpressionStatementContext'):
    return nodes2.ExprStmt(
        parser.make(stmt.expression())
    )


def _emit(parser, stmt: 'EmitStatementContext'):
    return nodes2.Emit(
        parser.make(stmt.functionCall())
    )


def _var_decl_stmt(parser, stmt: 'VariableDeclarationStatementContext'):
    if stmt.identifierList() is not None:
        raise NotImplementedError('var is unsupported')

    if stmt.variableDeclaration() is not None:
        variables = [parser.make(stmt.variableDeclaration())]
    else:
        variables = parser.make_all(stmt.variableDeclarationList())

    return nodes2.VarDecl(
        variables,
        parser.make(stmt.expression())
    )


def _identifier(parser, ident: 'IdentifierContext'):
    return nodes2.Ident(ident.getText())


def _array_identifier(parser, ident: nodes2.Ident, array_dims: int):
    return nodes2.Ident(ident.text + ('[]' * array_dims))


def _name_value(parser, name_value: 'NameValueContext'):
    return nodes2.NamedArg(
        parser.make(name_value.identifier()),
        parser.make(name_value.expression())
    )


def _function_call_args(parser, args: 'FunctionCallArgumentsContext'):
    if args.nameValueList():
        return parser.make_all(args.nameValueList())
    elif args.expressionList():
        return parser.make_all(args.expressionList())
    else:
        return []


def _function_call(parser, expr: 'FunctionCallContext'):
    return nodes2.CallFunction(
        parser.make(expr.expression()),
        [],
        parser.make(expr.functionCallArguments())
    )


def _function_call_expr(parser, expr: 'FuncCallExprContext'):
    return nodes2.CallFunction(
        parser.make(expr.expression()),
        parser.make_all(expr.nameValueList()),
        parser.make(expr.functionCallArguments())
    )


def _payable_expr(parser, expr: 'PayableExprContext'):
    return nodes2.PayableConversion(
        [parser.make(expr.expression())]
    )


def _unary_pre_op(parser, expr: 'UnaryPreOpContext'):
    return nodes2.UnaryOp(
        parser.make(expr.getChild(1)),
        nodes2.UnaryOpCode(expr.getChild(0).getText()),
        True
    )


def _delete_expr(parser, expr: 'DeleteExprContext'):
    return nodes2.Delete(parser.make(expr.expression()))

def _unary_logic_op(parser, expr: 'LogicOpContext'):
    return nodes2.UnaryOp(
        parser.make(expr.getChild(1)),
        nodes2.UnaryOpCode(expr.getChild(0).getText()),
        True
    )


def _unary_post_op(parser, expr: 'UnaryPostOpContext'):
    return nodes2.UnaryOp(
        parser.make(expr.getChild(0)),
        nodes2.UnaryOpCode(expr.getChild(1).getText()),
        False
    )


def _type_name(parser, type_name: 'TypeNameContext'):
    if type_name.expression() is not None:
        return nodes2.VariableLengthArrayType(
            parser.make(type_name.typeName()),
            parser.make(type_name.expression())
        )
    else:
        return parser.make_first(type_name)


def _mapping_type(parser, mapping_type: 'MappingContext'):
    return nodes2.MappingType(
        parser.make(mapping_type.mappingKey()),
        parser.make(mapping_type.typeName())
    )


def _function_type_name(parser, function_type: 'FunctionTypeNameContext'):
    return nodes2.FunctionType(
        parser.make(function_type.parameterList()),
        parser.make(function_type.modifierList()),
        parser.make(function_type.returnParameters())
    )


def _new_obj(parser, expr: 'NewTypeContext'):
    return nodes2.New(
        parser.make(expr.typeName())
    )


def _array_slice(parser, expr: 'ArraySliceContext'):
    return nodes2.GetArraySlice(
        parser.make(expr.base),
        parser.make(expr.start),
        parser.make(expr.end)
    )


def _array_load(parser, expr: 'ArrayLoadContext'):
    return nodes2.GetArrayValue(
        parser.make(expr.expression(0)),
        parser.make(expr.expression(1))
    )


def _binary_expr(parser, expr: 'BinaryExprContext'):
    return nodes2.BinaryOp(
        parser.make(expr.expression(0)),
        parser.make(expr.expression(1)),
        nodes2.BinaryOpCode(expr.getChild(1).getText())
    )


def _ternary_expr(parser, expr: 'TernaryExprContext'):
    return nodes2.TernaryOp(
        parser.make(expr.expression(0)),
        parser.make(expr.expression(1)),
        parser.make(expr.expression(2)),
    )


def _primary(parser, expr: 'PrimaryExpressionContext'):
    if expr.BooleanLiteral() is not None:
        return nodes2.Literal(bool(expr.getText()))
    elif expr.TypeKeyword() is not None:
        raise NotImplementedError('type keyword')
    elif expr.typeNameExpression() is not None:
        base_type = parser.make(expr.typeNameExpression())
        if expr.arrayBrackets():
            return nodes2.ArrayType(base_type)
        else:
            return base_type
    elif expr.identifier() is not None:
        base_type = nodes2.UserType(parser.make(expr.identifier()))
        if expr.arrayBrackets():
            return nodes2.ArrayType(base_type)
        else:
            return base_type
    else:
        return parser.make_first(expr)


def _number_literal(parser, literal: 'NumberLiteralContext'):
    if literal.DecimalNumber() is not None:
        value = float(literal.DecimalNumber().getText())
    else:
        value = int(literal.HexNumber().getText(), 16)

    if literal.NumberUnit() is not None:
        unit = nodes2.Unit(literal.NumberUnit().getText().lower())
        return nodes2.Literal(value, unit)
    else:
        return nodes2.Literal(value)


def _hex_literal(parser, literal: 'HexLiteralContext'):
    total_hex_str = ''
    for hex_frag in literal.HexLiteralFragment():
        total_hex_str += hex_frag.HexDigits().getText()
    return nodes2.Literal(int(total_hex_str, 16))


def _string_literal(parser, literal: 'StringLiteralContext'):
    total_str = ''
    for str_frag in literal.StringLiteralFragment():
        total_str += str_frag.getText()[1:-1]
    return nodes2.Literal(total_str)


def _tuple_expr(parser, expr: 'TupleExpressionContext'):
    return nodes2.Literal(tuple(parser.make_all(expr)))


def _member_load(parser, expr: 'MemberLoadContext'):
    # could be field or method ref
    return nodes2.GetMember(
        parser.make(expr.expression()),
        parser.make(expr.identifier())
    )


def _parameter(parser, stmt: 'ParameterContext'):
    return nodes2.Parameter(
        parser.make(stmt.typeName()),
        parser.make(stmt.storageLocation()),
        parser.make(stmt.identifier())
    )


def _catch_clause(parser, clause: 'CatchClauseContext'):
    return nodes2.Catch(
        parser.make(clause.identifier()),
        parser.make(clause.parameterList()),
        parser.make(clause.block())
    )


def _elementary_type_name(parser, name: 'ElementaryTypeNameContext'):
    if name.addressType():
        payable = name.addressType().PayableKeyword() is not None
        return nodes2.AddressType(payable)
    elif name.BoolType():
        return nodes2.BoolType()
    elif name.StringType():
        return nodes2.StringType()
    elif name.VarType():
        return nodes2.VarType()
    elif name.Int():
        size_str = name.Int().getText()[3:]
        size = int(size_str) if size_str else 256
        return nodes2.IntType(True, size)
    elif name.Uint():
        size_str = name.Uint().getText()[4:]
        size = int(size_str) if size_str else 256
        return nodes2.IntType(False, size)
    elif name.Byte():
        if name.Byte().getText() == 'byte':
            return nodes2.ByteType()
        elif name.Byte().getText() == 'bytes':
            return nodes2.FixedLengthArrayType(nodes2.ByteType(), 1)
        else:
            size_str = name.Byte().getText()[5:]
            size = int(size_str)
            return nodes2.FixedLengthArrayType(nodes2.ByteType(), size)
    else:
        raise NotImplementedError('fixed/ufixed')


def _user_defined_type(parser, name: 'UserDefinedTypeNameContext'):
    return nodes2.UserType(nodes2.Ident(name.getText()))


def _modifier_invocation(parser, modifier: 'ModifierInvocationContext'):
    return nodes2.InvocationModifier(
        parser.make(modifier.identifier()),
        parser.make(modifier.expressionList())
    )


def _state_mutability(parser, modifier: 'StateMutabilityContext'):
    return nodes2.MutabilityModifier(modifier.getText())


def _visibility_modifier(parser, modifier: 'VisibilityModifierContext'):
    return nodes2.VisibilityModifier(modifier.getText())


def _override_specifier(parser, modifier: 'OverrideSpecifierContext'):
    return nodes2.OverrideSpecifier(parser.make_all(modifier))


def _pragma_directive(parser, pragma_directive: 'PragmaDirectiveContext'):
    name = parser.make(pragma_directive.pragmaName())
    value = parser.make(pragma_directive.pragmaValue())
    return nodes2.PragmaDirective(name, value)


def _version(parser, version: 'VersionContext'):
    return parser.make_all(version)


def _version_constraint(parser, version_constraint: 'VersionConstraintContext'):
    # Set these up as expressions rather than their own node types
    operator_str = version_constraint.versionOperator().getText()
    operator = nodes2.BinaryOpCode(operator_str)

    version_literal = version_constraint.VersionLiteral().getText()

    return nodes2.BinaryOp(
        nodes2.Ident('version'),
        nodes2.Literal(version_literal),
        operator
    )


def _module_import(parser, module_import: 'ModuleImportContext'):
    path = module_import.StringLiteralFragment().getText()[1:-1]
    alias = module_import.identifier()

    if alias:
        return nodes2.UnitImportDirective(path, parser.make(alias))
    else:
        return nodes2.ImportDirective(path)


def _alias_import(parser, alias_import: 'AliasImportContext'):
    pass

def _symbol_import(parser, symbol_import: 'SymbolImportContext'):
    pass


def var_to_struct_member(var: nodes2.Var):
    if var.var_loc is not None:
        raise NotImplementedError('struct member cannot have location')
    return nodes2.StructMember(var.var_type, var.var_name)


def _struct_definition(parser, struct_definition: 'StructDefinitionContext'):
    var_decls = parser.make_all_rules(struct_definition.variableDeclaration())
    members = map_helper(var_to_struct_member, var_decls)

    return nodes2.StructDefinition(
        parser.make(struct_definition.identifier()),
        members
    )


def _enum_definition(parser, enum_definition: 'EnumDefinitionContext'):
    return nodes2.EnumDefinition(
        parser.make(enum_definition.identifier()),
        parser.make_all_rules(enum_definition.enumValue())
    )


def _enum_value(parser, enum_value: 'EnumValueContext'):
    return parser.make(enum_value.identifier())


def _contract_definition(parser, contract_definition: 'ContractDefinitionContext'):
    name = parser.make(contract_definition.identifier())
    inheritance_specifiers = parser.make_all_rules(contract_definition.inheritanceSpecifier())
    parts = parser.make_all_rules(contract_definition.contractPart())

    if contract_definition.ContractKeyword():
        return nodes2.ContractDefinition(
            name,
            contract_definition.Abstract() is not None,
            inheritance_specifiers,
            parts
        )
    elif contract_definition.InterfaceKeyword():
        return nodes2.InterfaceDefinition(name, inheritance_specifiers, parts)
    elif contract_definition.LibraryKeyword():
        return nodes2.LibraryDefinition(name, inheritance_specifiers, parts)
    else:
        raise NotImplemented('invalid contract type')


def _inheritance_specifier(parser, inheritance_specifier: 'InheritanceSpecifierContext'):
    return nodes2.InheritSpecifier(
        parser.make(inheritance_specifier.userDefinedTypeName()),
        parser.make(inheritance_specifier.expressionList())
    )


def _state_variable_declaration(parser, state_variable_declaration: 'StateVariableDeclarationContext'):
    modifiers = []

    if state_variable_declaration.PublicKeyword():
        modifiers.append(nodes2.VisibilityModifier.PUBLIC)

    if state_variable_declaration.InternalKeyword():
        modifiers.append(nodes2.VisibilityModifier.INTERNAL)

    if state_variable_declaration.PrivateKeyword():
        modifiers.append(nodes2.VisibilityModifier.PRIVATE)

    if state_variable_declaration.ConstantKeyword():
        modifiers.append(nodes2.MutabilityModifier.CONSTANT)

    if state_variable_declaration.ImmutableKeyword():
        modifiers.append(nodes2.MutabilityModifier.IMMUTABLE)

    modifiers += parser.make_all_rules(state_variable_declaration.overrideSpecifier())

    return nodes2.StateVariableDeclaration(
        parser.make(state_variable_declaration.typeName()),
        modifiers,
        parser.make(state_variable_declaration.identifier()),
        parser.make(state_variable_declaration.expression())
    )


def _override_specifier(parser, override_specific: 'OverrideSpecifierContext'):
    return nodes2.OverrideSpecifier(
        parser.make_all_rules(override_specific.userDefinedTypeName())
    )


def _using_for_declaration(parser, using_for_declaration: 'UsingForDeclarationContext'):
    if using_for_declaration.typeName():
        override_type = parser.make(using_for_declaration.typeName())
    else:
        override_type = nodes2.AnyType()

    return nodes2.UsingDirective(
        parser.make(using_for_declaration.identifier()),
        override_type
    )


def _modifier_definition(parser, modifier_definition: 'ModifierDefinitionContext'):
    modifiers = []

    if modifier_definition.VirtualKeyword():
        modifiers.append(nodes2.VisibilityModifier.VIRTUAL)

    modifiers += parser.make_all_rules(modifier_definition.overrideSpecifier())

    return nodes2.ModifierDefinition(
        parser.make(modifier_definition.identifier()),
        parser.make(modifier_definition.parameterList()),
        modifiers,
        parser.make(modifier_definition.block())
    )


def _function_definition(parser, function_definition: 'FunctionDefinitionContext'):
    descriptor = function_definition.functionDescriptor()

    if descriptor.identifier():
        name = parser.make(descriptor.identifier())
    elif descriptor.ReceiveKeyword():
        name = nodes2.SpecialFunctionKind.RECEIVE
    elif descriptor.FallbackKeyword():
        name = nodes2.SpecialFunctionKind.FALLBACK
    elif descriptor.ConstructorKeyword():
        name = nodes2.SpecialFunctionKind.CONSTRUCTOR
    else:
        # no function name is specified: fallback function
        name = nodes2.SpecialFunctionKind.FALLBACK

    return nodes2.FunctionDefinition(
        name,
        parser.make(function_definition.parameterList()),
        parser.make(function_definition.modifierList()),
        parser.make(function_definition.returnParameters()),
        parser.make(function_definition.block())
    )


def _event_definition(parser, event_definition: 'EventDefinitionContext'):
    return nodes2.EventDefinition(
        parser.make(event_definition.identifier()),
        event_definition.AnonymousKeyword() is not None,
        parser.make(event_definition.eventParameterList())
    )


def _event_parameter(parser, event_parameter: 'EventParameterContext'):
    return nodes2.EventParameter(
        parser.make(event_parameter.typeName()),
        parser.make(event_parameter.identifier()),
        event_parameter.IndexedKeyword() is not None
    )
