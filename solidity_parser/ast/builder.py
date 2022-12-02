from solidity_parser.grammar.v060.SolidityParser import SolidityParser
from solidity_parser.ast import nodes2
import antlr4
import inspect


class Builder:

    def __init__(self):
        # builders that don't need their own specific handling that can be parsed using
        # prebuilt parser helpers like make_first/make_all
        custom_builders = {
            SolidityParser.StatementContext: self.make_first,
            # TODO: inline assembly
            SolidityParser.SimpleStatementContext: self.make_first,
            SolidityParser.ExpressionContext: self.make_expr,
            # TODO: payable expr
            SolidityParser.BracketExprContext: self.make_first,
            SolidityParser.LogicOpContext: self._unary_pre_op,
            SolidityParser.PrimaryContext: self.make_first,
            SolidityParser.NameValueListContext: self.make_all,
            SolidityParser.ExpressionListContext: self.make_all,
            SolidityParser.ReturnParametersContext: self.make_first,
            SolidityParser.ParameterListContext: self.make_all,

            SolidityParser.TypeNameExpressionContext: self.make_first,

            SolidityParser.ModifierListContext: self.make_all,
        }

        # these parsers are the ones that begin with _ in this class and have
        # a typed parameter for the antlr generated rule context
        all_methods = inspect.getmembers(self, inspect.ismethod)
        discovered_builders = [self.check_parser_method(n, m) for (n, m) in all_methods]
        discovered_builders = dict([p for p in discovered_builders if p is not None])

        self.builders = {**discovered_builders, **custom_builders}

    def check_parser_method(self, name, method):
        # parsers are methods with the form
        #  _f(self, rule) where rule is a subtype of antlr4.ParserRuleContext

        if not name.startswith('_'):
            return None

        (args, _, _, _, _, _, annotations) = inspect.getfullargspec(method)

        # match (self, rule) method signature
        if len(args) != 2 or args[0] != 'self':
            return None

        rule_param_name = args[1]

        if rule_param_name not in annotations:
            return None

        rule_param_type = annotations[rule_param_name]

        if not issubclass(rule_param_type, antlr4.ParserRuleContext):
            return None

        return rule_param_type, method

    def map_helper(self, func, xs):
        # helper to switch between list comprehension for debugging and
        # using map() for performance
        return [func(x) for x in xs]

    def make_ast(self, code: SolidityParser.BlockContext):
        return self.make(code)

    def make(self, rule: antlr4.ParserRuleContext):
        # Default case
        if rule is None:
            return None

        # this can happen with rule labels like in array slice if the
        # subrule doesn't match
        if isinstance(rule, antlr4.Token):
            return None

        # find the appropriate _<type> creation method based on
        # the stmt/rule type
        rule_type = type(rule)

        if rule_type in self.builders:
            builder = self.builders[rule_type]
            return builder(rule)
        else:
            raise KeyError('Unsupported type: ' + rule_type.__name__)

    def make_stmt(self, stmt: SolidityParser.StatementContext):
        return self.make(stmt)

    def make_expr(self, expr: SolidityParser.ExpressionContext):
        return self.make(expr)

    def make_first(self, rule: antlr4.ParserRuleContext):
        for c in self.get_grammar_children(rule):
            return self.make(c)
        raise NotImplementedError()

    def make_all(self, rule: antlr4.ParserRuleContext):
        if rule is None:
            return []
        else:
            return self.map_helper(self.make, self.get_grammar_children(rule))

    def get_grammar_children(self, rule):
        return rule.getChildren(self.is_grammar_rule)

    def is_grammar_rule(self, rule):
        return isinstance(rule, antlr4.ParserRuleContext)

    def _if(self, stmt: SolidityParser.IfStatementContext):
        return nodes2.If(
            self.make_expr(stmt.expression()),
            self.make_stmt(stmt.statement(0)),
            self.make_stmt(stmt.statement(1))
        )

    def _try(self, stmt: SolidityParser.TryStatementContext):
        return nodes2.Try(
            self.make_expr(stmt.expression()),
            self.make(stmt.returnParameters()),
            self.make_stmt(stmt.block()),
            self.make_all(stmt.catchClause())
        )

    def _while(self, stmt: SolidityParser.WhileStatementContext):
        return nodes2.While(
            self.make_expr(stmt.expression()),
            self.make_stmt(stmt.statement())
        )

    def _for(self, stmt: SolidityParser.ForStatementContext):
        # grammar specifies expressionStatement for the condition part, but
        # it should be an expression on its own
        condition = self.make_stmt(stmt.expressionStatement())
        condition = condition.expr if condition is not None else None

        return nodes2.For(
            self.make_stmt(stmt.simpleStatement()),
            condition,
            self.make_expr(stmt.expression()),
            self.make_stmt(stmt.statement())
        )

    def _block(self, block: SolidityParser.BlockContext):
        return self.map_helper(self.make_stmt, block.statement())

    def _dowhile(self, stmt: SolidityParser.DoWhileStatementContext):
        return nodes2.DoWhile(
            self.make_stmt(stmt.statement()),
            self.make_expr(stmt.expression())
        )

    def _continue(self, _: SolidityParser.ContinueStatementContext):
        return nodes2.Continue()

    def _break(self, _: SolidityParser.BreakStatementContext):
        return nodes2.Break()

    def _return(self, stmt: SolidityParser.ReturnStatementContext):
        return nodes2.Return(
            self.make_expr(stmt.expression())
        )

    def _throw(self, _: SolidityParser.ThrowStatementContext):
        return nodes2.Throw()

    def _location(self, loc: SolidityParser.StorageLocationContext):
        return nodes2.Location(loc.getText())

    def _var(self, stmt: SolidityParser.VariableDeclarationContext):
        return nodes2.Var(
            self.make(stmt.typeName()),
            self.make(stmt.storageLocation()),
            self.make(stmt.identifier())
        )

    def _expr_stmt(self, stmt: SolidityParser.ExpressionStatementContext):
        return nodes2.ExprStmt(
            self.make_expr(stmt.expression())
        )

    def _emit(self, stmt: SolidityParser.EmitStatementContext):
        return nodes2.Emit(
            self._function_call(stmt.functionCall())
        )

    def _var_decl_stmt(self, stmt: SolidityParser.VariableDeclarationStatementContext):
        if stmt.identifierList() is not None:
            raise NotImplementedError('var is unsupported')

        if stmt.variableDeclaration() is not None:
            variables = [self._var(stmt.variableDeclaration())]
        else:
            variables = self.make_all(stmt.variableDeclarationList())

        return nodes2.VarDecl(
            variables,
            self.make_expr(stmt.expression())
        )

    def _identifier(self, ident: SolidityParser.IdentifierContext):
        return nodes2.Ident(ident.getText())

    def _array_identifier(self, ident: nodes2.Ident, array_dims: int):
        return nodes2.Ident(ident.text + ('[]' * array_dims))

    def _name_value(self, name_value: SolidityParser.NameValueContext):
        return nodes2.NamedArg(
            self.make(name_value.identifier()),
            self.make_expr(name_value.expression())
        )

    def _function_call_args(self, args: SolidityParser.FunctionCallArgumentsContext):
        list_args = args.getChild(0)
        return self.make_all(list_args)

    def _function_call(self, expr: SolidityParser.FunctionCallContext):
        return nodes2.CallFunction(
            self.make_expr(expr.expression()),
            [],
            self.make(expr.functionCallArguments())
        )

    def _function_call_expr(self, expr: SolidityParser.FuncCallExprContext):
        return nodes2.CallFunction(
            self.make_expr(expr.expression()),
            self.make_all(expr.nameValueList()),
            self.make(expr.functionCallArguments())
        )

    def _unary_pre_op(self, expr: SolidityParser.UnaryPreOpContext):
        return nodes2.UnaryOp(
            self.make_expr(expr.getChild(1)),
            nodes2.UnaryOpCode(expr.getChild(0).getText()),
            True
        )

    def _unary_post_op(self, expr: SolidityParser.UnaryPostOpContext):
        return nodes2.UnaryOp(
            self.make_expr(expr.getChild(0)),
            nodes2.UnaryOpCode(expr.getChild(1).getText()),
            False
        )

    def _type_name(self, type_name: SolidityParser.TypeNameContext):
        if type_name.expression() is not None:
            return nodes2.VariableLengthArrayType(
                self.make(type_name.typeName()),
                self.make_expr(type_name.expression())
            )
        else:
            return self.make_first(type_name)

    def _mapping_type(self, mapping_type: SolidityParser.MappingContext):
        return nodes2.MappingType(
            self.make(mapping_type.mappingKey()),
            self.make(mapping_type.typeName())
        )

    def _function_type_name(self, function_type: SolidityParser.FunctionTypeNameContext):
        return nodes2.FunctionType(
            self.make(function_type.parameterList()),
            self.make(function_type.modifierList()),
            self.make(function_type.returnParameters())
        )

    def _new_obj(self, expr: SolidityParser.NewTypeContext):
        return nodes2.New(
            self.make(expr.typeName())
        )

    def _array_slice(self, expr: SolidityParser.ArraySliceContext):
        return nodes2.GetArraySlice(
            self.make_expr(expr.base),
            self.make_expr(expr.start),
            self.make_expr(expr.end)
        )

    def _array_load(self, expr: SolidityParser.ArrayLoadContext):
        return nodes2.GetArrayValue(
            self.make_expr(expr.expression(0)),
            self.make_expr(expr.expression(1))
        )

    def _binary_expr(self, expr: SolidityParser.BinaryExprContext):
        return nodes2.BinaryOp(
            self.make_expr(expr.expression(0)),
            self.make_expr(expr.expression(1)),
            nodes2.BinaryOpCode(expr.getChild(1).getText())
        )

    def _ternary_expr(self, expr: SolidityParser.TernaryExprContext):
        return nodes2.TernaryOp(
            self.make_expr(expr.expression(0)),
            self.make_expr(expr.expression(1)),
            self.make_expr(expr.expression(2)),
        )

    def _primary(self, expr: SolidityParser.PrimaryExpressionContext):
        # most of the subrules for primary are just other rules
        # but the ones with arrayBrackets? need them added on the end
        # if expr.getChildCount() == 1:
        #     return self.make_first(expr)
        #
        if expr.BooleanLiteral() is not None:
            return nodes2.Literal(bool(expr.getText()))
        elif expr.numberLiteral() is not None:
            return self._number_literal(expr.numberLiteral())
        elif expr.hexLiteral() is not None:
            return self._hex_literal(expr.hexLiteral())
        elif expr.stringLiteral() is not None:
            return self._string_literal(expr.stringLiteral())
        elif expr.identifier() is not None:
            dims = 1 if expr.arrayBrackets() is not None else 0
            base_ident = self.make(expr.identifier())
            return self._array_identifier(base_ident, dims)
        elif expr.TypeKeyword() is not None:
            raise NotImplementedError('type keyword')
        elif expr.tupleExpression() is not None:
            return self._tuple_expr(expr.tupleExpression())
        elif expr.typeNameExpression() is not None:
            base_type = self.make(expr.typeNameExpression())
            if expr.arrayBrackets():
                return nodes2.ArrayType(base_type)
            else:
                return base_type
        else:
            raise NotImplementedError(type(expr.getChild(0)).__name__)

    def _number_literal(self, literal: SolidityParser.NumberLiteralContext):
        if literal.DecimalNumber() is not None:
            value = float(literal.DecimalNumber().getText())
        else:
            value = int(literal.HexNumber().getText())

        if literal.NumberUnit() is not None:
            unit = nodes2.Unit(literal.NumberUnit().getText().upper())
            return nodes2.Literal(value, unit)
        else:
            return nodes2.Literal(value)

    def _hex_literal(self, literal: SolidityParser.HexLiteralContext):
        total_hex_str = ''
        for hex_frag in literal.HexLiteralFragment():
            total_hex_str += hex_frag.HexDigits().getText()
        return nodes2.Literal(int(total_hex_str))

    def _string_literal(self, literal: SolidityParser.StringLiteralContext):
        total_str = ''
        for str_frag in literal.StringLiteralFragment():
            total_str += str_frag.getText()[1:-1]
        return nodes2.Literal(total_str)

    def _tuple_expr(self, expr: SolidityParser.TupleExpressionContext):
        return nodes2.Literal(tuple(self.make_all(expr)))

    def _member_load(self, expr: SolidityParser.MemberLoadContext):
        # could be field or method ref
        return nodes2.GetMember(
            self.make_expr(expr.expression()),
            self.make(expr.identifier())
        )

    def _parameter(self, stmt: SolidityParser.ParameterContext):
        return nodes2.Parameter(
            self.make(stmt.typeName()),
            self.make(stmt.storageLocation()),
            self.make(stmt.identifier())
        )

    def _catch_clause(self, clause: SolidityParser.CatchClauseContext):
        return nodes2.Catch(
            self.make(clause.identifier()),
            self.make(clause.parameterList()),
            self.make_stmt(clause.block())
        )

    def _elementary_type_name(self, name: SolidityParser.ElementaryTypeNameContext):
        if name.AddressType():
            payable = name.AddressType().PayableKeyword() is not None
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

    def _user_defined_type(self, name: SolidityParser.UserDefinedTypeNameContext):
        return nodes2.UserType(nodes2.Ident(name.getText()))

    def _modifier_invocation(self, modifier: SolidityParser.ModifierInvocationContext):
        return nodes2.InvocationModifier(
            self.make(modifier.identifier()),
            self.make(modifier.expressionList())
        )

    def _state_mutability(self, modifier: SolidityParser.StateMutabilityContext):
        return nodes2.MutabilityModifier(modifier.getText())

    def _visibility_modifier(self, modifier: SolidityParser.VisibilityModifierContext):
        return nodes2.VisibilityModifier(modifier.getText())

    def _override_specifier(self, modifier: SolidityParser.OverrideSpecifierContext):
        return nodes2.OverrideSpecifier(self.make_all(modifier))
