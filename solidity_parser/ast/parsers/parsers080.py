import sys
from solidity_parser.ast.parsers.common import ParserBase, get_subparsers_from_methods, get_all_subparsers
import solidity_parser.ast.parsers.parsers060 as parsers060
from solidity_parser.grammar.v080.SolidityParser import SolidityParser
from solidity_parser.ast import nodes2


class Parser080(ParserBase):
    def __init__(self):
        super().__init__({
            **get_subparsers_from_methods(
                parsers060._if,
                parsers060._for,
                parsers060._while,
                parsers060._dowhile,
                parsers060._continue,
                parsers060._break,
                parsers060._try,
                parsers060._return
            ),
            **get_all_subparsers(sys.modules[__name__]),
            **custom_parsers(),

        })



def custom_parsers():
    return {
        'StatementContext': ParserBase.make_first,
        'SimpleStatementContext': ParserBase.make_first,
        'ExpOperationContext': _binary_expr,
        'MulDivModOperationContext': _binary_expr,
        'AddSubOperationContext': _binary_expr,
        'ShiftOperationContext': _binary_expr,
        'BitAndOperationContext': _binary_expr,
        'BitXorOperationContext': _binary_expr,
        'BitOrOperationContext': _binary_expr,
        'OrderComparisonContext': _binary_expr,
        'EqualityComparisonContext': _binary_expr,
        'AndOperationContext': _binary_expr,
        'OrOperationContext': _binary_expr,
        'AssignmentContext': _binary_expr,
        'LiteralContext': ParserBase.make_first,
        'PrimaryExpressionContext': ParserBase.make_first,

        # Top level directives
        'SourceUnitContext': ParserBase.make_first,
        # Imports
        'SymbolAliasesContext': ParserBase.make_all
    }


def _import_directive(parser, directive: SolidityParser.ImportDirectiveContext):
    path = directive.path().getText()

    if directive.Mul():
        # import * as symbolName from "filename";
        alias = parser.make(directive.unitAlias)
        return nodes2.UnitImportDirective(path, alias)
    elif directive.symbolAliases():
        # import {symbol1 as alias, symbol2} from "filename";
        return nodes2.SymbolImportDirective(
            path,
            parser.make(directive.symbolAliases())
        )
    else:
        if directive.unitAlias:
            # import "filename" as symbolName;
            alias = parser.make(directive.unitAlias)
            return nodes2.UnitImportDirective(path, alias)
        else:
            # import "filename"
            return nodes2.ImportDirective(path)


def _import_alias(parser, import_alias: SolidityParser.ImportAliasesContext):
    return nodes2.SymbolAlias(
        parser.make(import_alias.symbol),
        parser.make(import_alias.alias)
    )


def _contract_definition(parser, contract_definition: SolidityParser.ContractDefinitionContext):


def _block(parser, block: SolidityParser.BlockContext):
    return nodes2.Block(
        parser.make_all(block),
        False
    )


def _unchecked_block(parser, block: SolidityParser.UncheckedBlockContext):
    block_node: nodes2.Block = parser.make(block.block())
    return nodes2.Block(
        block_node.stmts,
        True
    )


def _named_argument(parser, named_arg: SolidityParser.NamedArgumentContext):
    return nodes2.NamedArg(
        parser.make(named_arg.name),
        parser.make(named_arg.value)
    )

def _call_argument_list(parser, arg_list: SolidityParser.CallArgumentListContext):
    return parser.make_all(arg_list)


def _var_decl_stmt(parser, stmt: SolidityParser.VariableDeclarationStatementContext):

    if stmt.variableDeclaration() is not None:
        variables = [parser.make(stmt.variableDeclaration())]
    else:
        variables = parser.make_all(stmt.variableDeclarationTuple())

    return nodes2.VarDecl(
        variables,
        parser.make(stmt.expression())
    )


def _data_location(parser, location: SolidityParser.DataLocationContext):
    return nodes2.Location(location.getText())


def _variable_declaration(parser, decl: SolidityParser.VariableDeclarationContext):
    return nodes2.Var(
        parser.make(decl.typeName()),
        parser.make(decl.dataLocation()),
        parser.make(decl.identifier())
    )


def _expr_stmt(parser, stmt: SolidityParser.ExpressionStatementContext):
    return nodes2.ExprStmt(
        parser.make(stmt.expression())
    )


def _try(parser, stmt: 'TryStatementContext'):
    return nodes2.Try(
        parser.make(stmt.expression()),
        parser.make(stmt.parameterList()),
        parser.make(stmt.block()),
        parser.make_all(stmt.catchClause())
    )

def _emit(parser, stmt: SolidityParser.EmitStatementContext):
    return nodes2.Emit(
        nodes2.CallFunction(
            parser.make(stmt.expression()),
            [],
            parser.make(stmt.callArgumentList())
        )
    )

def _revert(parser, stmt: SolidityParser.RevertStatementContext):
    return nodes2.Revert(
        nodes2.CallFunction(
            parser.make(stmt.expression()),
            [],
            parser.make(stmt.callArgumentList())
        )
    )


def _assembly(parser, stmt: SolidityParser.AssemblyStatementContext):
    return nodes2.AssemblyStmt(stmt.getText())


def _index_access(parser, expr: SolidityParser.IndexAccessContext):
    return nodes2.GetArrayValue(
        parser.make(expr.expression(0)),
        parser.make(expr.expression(1))
    )

def _index_range_access(parser, expr: SolidityParser.IndexRangeAccessContext):
    return nodes2.GetArraySlice(
        parser.make(expr.expression(0)),
        parser.make(expr.start),
        parser.make(expr.end)
    )

def _member_access(parser, expr: SolidityParser.MemberAccessContext):
    return nodes2.GetMember(
        parser.make(expr.expression()),
        parser.make(expr.identifier())
    )

def _function_call_options(parser, expr: SolidityParser.FunctionCallOptionsContext):
    raise NotImplementedError()

def _function_call(parser, expr: SolidityParser.FunctionCallContext):
    return nodes2.CallFunction(
        parser.make(expr.expression()),
        [],
        parser.make(expr.callArgumentList())
    )

def _payable_conversion(parser, expr: SolidityParser.PayableConversionContext):
    return nodes2.PayableConversion(
        parser.make(expr.callArgumentList())
    )


def _type_name(parser, type_name: SolidityParser.TypeNameContext):
    if type_name.expression():
        return nodes2.VariableLengthArrayType(
            parser.make(type_name.typeName()),
            parser.make(type_name.expression())
        )
    else:
        return parser.make_first(type_name)


def _function_type_name(parser, function_type: SolidityParser.FunctionTypeNameContext):
    return nodes2.FunctionType(
        parser.make(function_type.arguments),
        parser.make_all_rules(function_type.visibility()) + parser.make_all_rules(function_type.stateMutability()),
        parser.make(function_type.returnParameters)
    )


def _mapping_type(parser, mapping: SolidityParser.MappingTypeContext):
    return nodes2.MappingType(
        parser.make(mapping.key),
        parser.make(mapping.value)
    )


def _mapping_key_type(parser, mapping_key_type: SolidityParser.MappingKeyTypeContext):
    return parser.make_first(mapping_key_type)


def _unary_prefix_operation(parser, expr: SolidityParser.UnaryPrefixOperationContext):
    return nodes2.UnaryOp(
        parser.make(expr.expression()),
        nodes2.UnaryOpCode(expr.op.text),
        True
    )

def _unary_suffix_operation(parser, expr: SolidityParser.UnarySuffixOperationContext):
    return nodes2.UnaryOp(
        parser.make(expr.expression()),
        nodes2.UnaryOpCode(expr.op.text),
        False
    )

def _binary_expr(parser, expr):
    # Expr of the form: expr OP expr
    return nodes2.BinaryOp(
        parser.make(expr.expression(0)),
        parser.make(expr.expression(1)),
        nodes2.BinaryOpCode(expr.getChild(1).getText())
    )

def _conditional_expr(parser, expr: SolidityParser.ConditionalContext):
    return nodes2.TernaryOp(
        parser.make(expr.expression(0)),
        parser.make(expr.expression(1)),
        parser.make(expr.expression(2)),
    )

def _new_obj(parser, expr: SolidityParser.NewExpressionContext):
    return nodes2.New(
        parser.make(expr.typeName())
    )

def _tuple_expression(parser, expr: SolidityParser.TupleExpressionContext):
    return nodes2.Literal(tuple(parser.make_all(expr)))

def _inline_array(parser, expr: SolidityParser.InlineArrayExpressionContext):
    return nodes2.NewInlineArray(
        parser.make_all(expr)
    )


def _tuple(parser, expr: SolidityParser.TupleContext):
    return parser.make_first(expr.tupleExpression())


def _identifier(parser, ident: SolidityParser.IdentifierContext):
    return nodes2.Ident(ident.getText())


def _identifier_path(parser, ident_path: SolidityParser.IdentifierPathContext):
    return nodes2.Ident(ident_path.getText())


def _string_literal(parser, literal: SolidityParser.StringLiteralContext):
    total_str = ''
    for str_frag in literal.getChildren():
        total_str += str_frag.getText()[1:-1]
    return nodes2.Literal(total_str)


def _number_literal(parser, literal: SolidityParser.NumberLiteralContext):
    if literal.DecimalNumber():
        value = float(literal.DecimalNumber().getText())
    else:
        value = int(literal.HexNumber().getText())

    if literal.NumberUnit():
        unit = nodes2.Unit(literal.NumberUnit().getText().upper())
        return nodes2.Literal(value, unit)
    else:
        return nodes2.Literal(value)


def _boolean_literal(parser, literal: SolidityParser.BooleanLiteralContext):
    return nodes2.Literal(True if literal.True_() else False)


def _hex_string_literal(parser, literal: SolidityParser.HexStringLiteralContext):
    total_hex_str = ''
    for part in literal.HexString():
        # part looks like: hex "AA_AA_AA_AA"
        hex_string_str = part.getText()
        hex_string_str = hex_string_str[4:-1].replace('_', '')
        total_hex_str += hex_string_str
    return nodes2.Literal(int(total_hex_str, 16))


def _unicode_string_literal(parser, literal: SolidityParser.UnicodeStringLiteralContext):
    total_str = ''
    for part in literal.UnicodeStringLiteral():
        # part looks like: unicode"ABCD"
        unicode_string_str = part.getText()
        unicode_string_str = unicode_string_str[8:-1]
        total_str += unicode_string_str
    return nodes2.Literal(total_str)


def _elementary_type_name(parser, name: SolidityParser.ElementaryTypeNameContext):
    if name.Address():
        payable = name.Payable() is not None
        return nodes2.AddressType(payable)
    elif name.Bool():
        return nodes2.BoolType()
    elif name.String():
        return nodes2.StringType()
    elif name.Bytes():
        return nodes2.FixedLengthArrayType(nodes2.ByteType(), 1)
    elif name.SignedIntegerType():
        size_str = name.SignedIntegerType().getText()[3:]
        size = int(size_str) if size_str else 256
        return nodes2.IntType(True, size)
    elif name.UnsignedIntegerType():
        size_str = name.UnsignedIntegerType().getText()[4:]
        size = int(size_str) if size_str else 256
        return nodes2.IntType(False, size)
    elif name.FixedBytes():
        size_str = name.FixedBytes().getText()[5:]
        size = int(size_str)
        return nodes2.FixedLengthArrayType(nodes2.ByteType(), size)
    elif name.Fixed() or name.Ufixed():
        raise NotImplementedError('fixed/unfixed type')
    else:
        raise NotImplementedError('unknown elementary type')