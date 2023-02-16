import sys
from solidity_parser.ast.parsers.common import ParserBase, get_all_subparsers, map_helper
from solidity_parser.ast.parsers.errors import invalid_solidity
from solidity_parser.ast import solnodes

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
        'IdentifierListContext': ParserBase.make_all,

        'SourceUnitContext': ParserBase.make_first,
        'PragmaNameContext': ParserBase.make_first,
        'PragmaValueContext': ParserBase.make_first,
        'ContractPartContext': ParserBase.make_first,

        'EventParameterListContext': ParserBase.make_all,
    }

def _block(parser, block: SolidityParser.BlockContext):
    return solnodes.Block(
        parser.make_all(block)
    )

def _if(parser, stmt: SolidityParser.IfStatementContext):
    return solnodes.If(
        parser.make(stmt.expression()),
        parser.make(stmt.statement(0)),
        parser.make(stmt.statement(1))
    )


def _try(parser, stmt: SolidityParser.TryStatementContext):
    return solnodes.Try(
        parser.make(stmt.expression()),
        parser.make(stmt.returnParameters(), default=[]),
        parser.make(stmt.block()),
        parser.make_all_rules(stmt.catchClause())
    )


def _while(parser, stmt: SolidityParser.WhileStatementContext):
    return solnodes.While(
        parser.make(stmt.expression()),
        parser.make(stmt.statement())
    )


def _for(parser, stmt: SolidityParser.ForStatementContext):
    # grammar specifies expressionStatement for the condition part, but
    # it should be an expression on its own
    condition = parser.make(stmt.expressionStatement())
    condition = condition.expr if condition is not None else None

    return solnodes.For(
        parser.make(stmt.simpleStatement()),
        condition,
        parser.make(stmt.expression()),
        parser.make(stmt.statement())
    )


def _inline_assembly_statement(parser, stmt: SolidityParser.InlineAssemblyStatementContext):
    return solnodes.AssemblyStmt(stmt.getText())


def _dowhile(parser, stmt: SolidityParser.DoWhileStatementContext):
    return solnodes.DoWhile(
        parser.make(stmt.statement()),
        parser.make(stmt.expression())
    )


def _continue(parser, _: SolidityParser.ContinueStatementContext):
    return solnodes.Continue()


def _break(parser, _: SolidityParser.BreakStatementContext):
    return solnodes.Break()


def _return(parser, stmt: SolidityParser.ReturnStatementContext):
    return solnodes.Return(
        parser.make(stmt.expression())
    )


def _throw(parser, _: SolidityParser.ThrowStatementContext):
    return solnodes.Throw()


def _location(parser, loc: SolidityParser.StorageLocationContext):
    return solnodes.Location(loc.getText())


def _var(parser, stmt: SolidityParser.VariableDeclarationContext):
    return solnodes.Var(
        parser.make(stmt.typeName()),
        parser.make(stmt.identifier()),
        parser.make(stmt.storageLocation())
    )


def _expr_stmt(parser, stmt: SolidityParser.ExpressionStatementContext):
    return solnodes.ExprStmt(
        parser.make(stmt.expression())
    )


def _emit(parser, stmt: SolidityParser.EmitStatementContext):
    return solnodes.Emit(
        parser.make(stmt.functionCall())
    )


def _var_decl_stmt(parser, stmt: SolidityParser.VariableDeclarationStatementContext):
    if stmt.identifierList() is not None:
        # e.g: var (, mantissa, exponent) = unpackPrice(price); which is deprecated in 0.4.20
        # desugar it into multiple variables, TODO: figure out the types in a later type inference pass
        names = parser.make(stmt.identifierList())
        variables = [solnodes.Var(solnodes.VarType(), name, None) for name in names]
    elif stmt.variableDeclaration() is not None:
        variables = [parser.make(stmt.variableDeclaration())]
    else:
        variables = parser.make_all(stmt.variableDeclarationList())

    return solnodes.VarDecl(
        variables,
        parser.make(stmt.expression())
    )


def _identifier(parser, ident: SolidityParser.IdentifierContext):
    return solnodes.Ident(ident.getText())


def _array_identifier(parser, ident: solnodes.Ident, array_dims: int):
    return solnodes.Ident(ident.text + ('[]' * array_dims))


def _name_value(parser, name_value: SolidityParser.NameValueContext):
    return solnodes.NamedArg(
        parser.make(name_value.identifier()),
        parser.make(name_value.expression())
    )


def _function_call_args(parser, args: SolidityParser.FunctionCallArgumentsContext):
    if args.nameValueList():
        return parser.make_all(args.nameValueList())
    elif args.expressionList():
        return parser.make_all(args.expressionList())
    else:
        return []


def _function_call(parser, expr: SolidityParser.FunctionCallContext):
    return solnodes.CallFunction(
        parser.make(expr.expression()),
        [],
        parser.make(expr.functionCallArguments())
    )


def _function_call_expr(parser, expr: SolidityParser.FuncCallExprContext):
    return solnodes.CallFunction(
        parser.make(expr.expression()),
        parser.make_all(expr.nameValueList()),
        parser.make(expr.functionCallArguments())
    )


def _meta_type(parser, meta_type: SolidityParser.MetaTypeContext):
    return solnodes.CreateMetaType(
        parser.make(meta_type.typeName())
    )


def _payable_expr(parser, expr: SolidityParser.PayableExprContext):
    return solnodes.PayableConversion(
        [parser.make(expr.expression())]
    )


def _unary_pre_op(parser, expr: SolidityParser.UnaryPreOpContext):
    return solnodes.UnaryOp(
        parser.make(expr.getChild(1)),
        solnodes.UnaryOpCode(expr.getChild(0).getText()),
        True
    )


def _delete_expr(parser, expr: SolidityParser.DeleteExprContext):
    return solnodes.UnaryOp(
        parser.make(expr.expression()),
        solnodes.UnaryOpCode.DELETE,
        True  # Doesn't matter for this
    )


def _unary_logic_op(parser, expr: SolidityParser.LogicOpContext):
    return solnodes.UnaryOp(
        parser.make(expr.getChild(1)),
        solnodes.UnaryOpCode(expr.getChild(0).getText()),
        True
    )


def _unary_post_op(parser, expr: SolidityParser.UnaryPostOpContext):
    return solnodes.UnaryOp(
        parser.make(expr.getChild(0)),
        solnodes.UnaryOpCode(expr.getChild(1).getText()),
        False
    )


def _type_name(parser, type_name: SolidityParser.TypeNameContext):
    if type_name.typeName():
        if type_name.expression():
            return solnodes.VariableLengthArrayType(
                parser.make(type_name.typeName()),
                parser.make(type_name.expression())
            )
        else:
            return solnodes.ArrayType(
                parser.make(type_name.typeName())
            )
    else:
        return parser.make_first(type_name)


def _mapping_type(parser, mapping_type: SolidityParser.MappingContext):
    return solnodes.MappingType(
        parser.make(mapping_type.mappingKey()),
        parser.make(mapping_type.typeName())
    )


def _function_type_name(parser, function_type: SolidityParser.FunctionTypeNameContext):
    return solnodes.FunctionType(
        parser.make(function_type.parameterList()),
        parser.make(function_type.modifierList()),
        parser.make(function_type.returnParameters())
    )


def _new_obj(parser, expr: SolidityParser.NewTypeContext):
    return solnodes.New(
        parser.make(expr.typeName())
    )


def _array_slice(parser, expr: SolidityParser.ArraySliceContext):
    return solnodes.GetArraySlice(
        parser.make(expr.base),
        parser.make(expr.start),
        parser.make(expr.end)
    )


def _array_load(parser, expr: SolidityParser.ArrayLoadContext):
    return solnodes.GetArrayValue(
        parser.make(expr.expression(0)),
        parser.make(expr.expression(1))
    )


def _binary_expr(parser, expr: SolidityParser.BinaryExprContext):
    return solnodes.BinaryOp(
        parser.make(expr.expression(0)),
        parser.make(expr.expression(1)),
        solnodes.BinaryOpCode(expr.getChild(1).getText())
    )


def _ternary_expr(parser, expr: SolidityParser.TernaryExprContext):
    return solnodes.TernaryOp(
        parser.make(expr.expression(0)),
        parser.make(expr.expression(1)),
        parser.make(expr.expression(2)),
    )


def _primary(parser, expr: SolidityParser.PrimaryExpressionContext):
    if expr.BooleanLiteral() is not None:
        return solnodes.Literal(bool(expr.getText()))
    elif expr.typeNameExpression() is not None:
        base_type = parser.make(expr.typeNameExpression())
        if expr.arrayBrackets():
            return solnodes.ArrayType(base_type)
        else:
            return base_type
    elif expr.identifier() is not None:
        # In the 080 grammar primary expressions hit 'identifier' first. To match this, if this isn't
        # an array type, return as an ident
        if expr.arrayBrackets():
            base_type = solnodes.UserType(parser.make(expr.identifier()))
            return solnodes.ArrayType(base_type)
        else:
            return parser.make(expr.identifier())
    else:
        return parser.make_first(expr)


def _number_literal(parser, literal: SolidityParser.NumberLiteralContext):
    if literal.DecimalNumber():
        str_val = literal.DecimalNumber().getText()
        value = float(str_val)
        assert value.is_integer()
        value = int(value)
    else:
        value = int(literal.HexNumber().getText(), 16)

    if literal.NumberUnit() is not None:
        unit = solnodes.Unit(literal.NumberUnit().getText().lower())
        return solnodes.Literal(value, unit)
    else:
        return solnodes.Literal(value)


def _hex_literal(parser, literal: SolidityParser.HexLiteralContext):
    total_hex_str = ''
    for hex_frag in literal.HexLiteralFragment():
        total_hex_str += hex_frag.getText()[4:-1]  # remove 'hex' and (" or ') from start and end

    if total_hex_str == '':
        value = 0x0
    else:
        value = int(total_hex_str, 16)

    return solnodes.Literal(value)


def _string_literal(parser, literal: SolidityParser.StringLiteralContext):
    total_str = ''
    for str_frag in literal.StringLiteralFragment():
        total_str += str_frag.getText()[1:-1]
    return solnodes.Literal(total_str)


def _tuple_expr(parser, expr: SolidityParser.TupleExpressionContext):
    return solnodes.Literal(tuple(parser.make_all(expr)))


def _member_load(parser, expr: SolidityParser.MemberLoadContext):
    # could be field or method ref
    return solnodes.GetMember(
        parser.make(expr.expression()),
        parser.make(expr.identifier())
    )


def _parameter(parser, stmt: SolidityParser.ParameterContext):
    return solnodes.Parameter(
        parser.make(stmt.typeName()),
        parser.make(stmt.storageLocation()),
        parser.make(stmt.identifier())
    )


def _catch_clause(parser, clause: SolidityParser.CatchClauseContext):
    return solnodes.Catch(
        parser.make(clause.identifier()),
        parser.make(clause.parameterList(), default=[]),
        parser.make(clause.block())
    )


def _elementary_type_name(parser, name: SolidityParser.ElementaryTypeNameContext):
    if name.addressType():
        payable = name.addressType().PayableKeyword() is not None
        return solnodes.AddressType(payable)
    elif name.BoolType():
        return solnodes.BoolType()
    elif name.StringType():
        return solnodes.StringType()
    elif name.VarType():
        return solnodes.VarType()
    elif name.Int():
        size_str = name.Int().getText()[3:]
        size = int(size_str) if size_str else 256
        return solnodes.IntType(True, size)
    elif name.Uint():
        size_str = name.Uint().getText()[4:]
        size = int(size_str) if size_str else 256
        return solnodes.IntType(False, size)
    elif name.AByte():
        return solnodes.ByteType()
    elif name.Byte():
        if name.Byte().getText() == 'bytes':
            return solnodes.ArrayType(solnodes.ByteType())
        else:
            size_str = name.Byte().getText()[5:]
            size = int(size_str)
            return solnodes.FixedLengthArrayType(solnodes.ByteType(), size)
    else:
        raise NotImplementedError('fixed/ufixed')


def _user_defined_type(parser, name: SolidityParser.UserDefinedTypeNameContext):
    return solnodes.UserType(solnodes.Ident(name.getText()))


def _modifier_invocation(parser, modifier: SolidityParser.ModifierInvocationContext):
    return solnodes.InvocationModifier(
        parser.make(modifier.identifier()),
        parser.make(modifier.expressionList())
    )


def _state_mutability(parser, modifier: SolidityParser.StateMutabilityContext):
    return solnodes.MutabilityModifier(modifier.getText())


def _visibility_modifier(parser, modifier: SolidityParser.VisibilityModifierContext):
    return solnodes.VisibilityModifier(modifier.getText())


def _pragma_directive(parser, pragma_directive: SolidityParser.PragmaDirectiveContext):
    name = parser.make(pragma_directive.pragmaName())
    value = parser.make(pragma_directive.pragmaValue())
    return solnodes.PragmaDirective(name, value)


def _version(parser, version: SolidityParser.VersionContext):
    return parser.make_all(version)


def _version_constraint(parser, version_constraint: SolidityParser.VersionConstraintContext):
    # Set these up as expressions rather than their own node types
    if version_constraint.versionOperator():
        operator_str = version_constraint.versionOperator().getText()
        operator = solnodes.BinaryOpCode(operator_str)
    else:
        operator = solnodes.BinaryOpCode.EQ

    version_literal = version_constraint.VersionLiteral().getText()

    return solnodes.BinaryOp(
        solnodes.Ident('version'),
        solnodes.Literal(version_literal),
        operator
    )


def _module_import(parser, module_import: SolidityParser.ModuleImportContext):
    path = module_import.StringLiteralFragment().getText()[1:-1]
    alias = module_import.identifier()

    if alias:
        return solnodes.UnitImportDirective(path, parser.make(alias))
    else:
        return solnodes.GlobalImportDirective(path)


def _alias_import(parser, alias_import: SolidityParser.AliasImportContext):
    pass


def _symbol_import(parser, symbol_import: SolidityParser.SymbolImportContext):
    pass


def var_to_struct_member(var: solnodes.Var):
    if var.var_loc is not None:
        raise NotImplementedError('struct member cannot have location')
    return solnodes.StructMember(var.var_type, var.var_name)


def _struct_definition(parser, struct_definition: SolidityParser.StructDefinitionContext):
    var_decls = parser.make_all_rules(struct_definition.variableDeclaration())
    members = map_helper(var_to_struct_member, var_decls)

    return solnodes.StructDefinition(
        parser.make(struct_definition.identifier()),
        members
    )


def _enum_definition(parser, enum_definition: SolidityParser.EnumDefinitionContext):
    return solnodes.EnumDefinition(
        parser.make(enum_definition.identifier()),
        parser.make_all_rules(enum_definition.enumValue())
    )


def _enum_value(parser, enum_value: SolidityParser.EnumValueContext):
    return parser.make(enum_value.identifier())


def _contract_definition(parser, contract_definition: SolidityParser.ContractDefinitionContext):
    name = parser.make(contract_definition.identifier())
    inheritance_specifiers = parser.make_all_rules(contract_definition.inheritanceSpecifier())
    parts = parser.make_all_rules(contract_definition.contractPart())

    if contract_definition.ContractKeyword():
        return solnodes.ContractDefinition(
            name,
            contract_definition.Abstract() is not None,
            inheritance_specifiers,
            parts
        )
    elif contract_definition.InterfaceKeyword():
        return solnodes.InterfaceDefinition(name, inheritance_specifiers, parts)
    elif contract_definition.LibraryKeyword():
        if inheritance_specifiers:
            return invalid_solidity('inheritance specifiers for library definition')
        else:
            return solnodes.LibraryDefinition(name, parts)
    else:
        raise NotImplemented('invalid contract type')


def _inheritance_specifier(parser, inheritance_specifier: SolidityParser.InheritanceSpecifierContext):
    return solnodes.InheritSpecifier(
        parser.make(inheritance_specifier.userDefinedTypeName()),
        parser.make(inheritance_specifier.expressionList(), default=[])
    )


def _state_variable_declaration(parser, state_variable_declaration: SolidityParser.StateVariableDeclarationContext):
    modifiers = []

    if state_variable_declaration.PublicKeyword():
        modifiers.append(solnodes.VisibilityModifier.PUBLIC)

    if state_variable_declaration.InternalKeyword():
        modifiers.append(solnodes.VisibilityModifier.INTERNAL)

    if state_variable_declaration.PrivateKeyword():
        modifiers.append(solnodes.VisibilityModifier.PRIVATE)

    if state_variable_declaration.ConstantKeyword():
        modifiers.append(solnodes.MutabilityModifier.CONSTANT)

    if state_variable_declaration.ImmutableKeyword():
        modifiers.append(solnodes.MutabilityModifier.IMMUTABLE)

    modifiers += parser.make_all_rules(state_variable_declaration.overrideSpecifier())

    return solnodes.StateVariableDeclaration(
        parser.make(state_variable_declaration.typeName()),
        modifiers,
        parser.make(state_variable_declaration.identifier()),
        parser.make(state_variable_declaration.expression())
    )


def _override_specifier(parser, override_specific: SolidityParser.OverrideSpecifierContext):
    return solnodes.OverrideSpecifier(
        parser.make_all_rules(override_specific.userDefinedTypeName())
    )


def _using_for_declaration(parser, using_for_declaration: SolidityParser.UsingForDeclarationContext):
    if using_for_declaration.typeName():
        override_type = parser.make(using_for_declaration.typeName())
    else:
        override_type = solnodes.AnyType()

    return solnodes.UsingDirective(
        parser.make(using_for_declaration.identifier()),
        override_type
    )


def _modifier_definition(parser, modifier_definition: SolidityParser.ModifierDefinitionContext):
    modifiers = []

    if modifier_definition.VirtualKeyword():
        modifiers.append(solnodes.VisibilityModifier.VIRTUAL)

    modifiers += parser.make_all_rules(modifier_definition.overrideSpecifier())

    return solnodes.ModifierDefinition(
        parser.make(modifier_definition.identifier()),
        parser.make(modifier_definition.parameterList(), default=[]),
        modifiers,
        parser.make(modifier_definition.block())
    )


def _function_definition(parser, function_definition: SolidityParser.FunctionDefinitionContext):
    descriptor = function_definition.functionDescriptor()

    if descriptor.identifier():
        name = parser.make(descriptor.identifier())
    elif descriptor.ReceiveKeyword():
        name = solnodes.SpecialFunctionKind.RECEIVE
    elif descriptor.FallbackKeyword():
        name = solnodes.SpecialFunctionKind.FALLBACK
    elif descriptor.ConstructorKeyword():
        name = solnodes.SpecialFunctionKind.CONSTRUCTOR
    else:
        # no function name is specified: fallback function
        name = solnodes.SpecialFunctionKind.FALLBACK

    return solnodes.FunctionDefinition(
        name,
        parser.make(function_definition.parameterList(), default=[]),
        parser.make(function_definition.modifierList()),
        parser.make(function_definition.returnParameters(), default=[]),
        parser.make(function_definition.block())
    )


def _event_definition(parser, event_definition: SolidityParser.EventDefinitionContext):
    return solnodes.EventDefinition(
        parser.make(event_definition.identifier()),
        event_definition.AnonymousKeyword() is not None,
        parser.make(event_definition.eventParameterList())
    )


def _event_parameter(parser, event_parameter: SolidityParser.EventParameterContext):
    return solnodes.EventParameter(
        parser.make(event_parameter.typeName()),
        parser.make(event_parameter.identifier()),
        event_parameter.IndexedKeyword() is not None
    )
