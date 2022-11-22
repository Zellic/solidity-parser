from solidity_parser.grammar.v060.SolidityParser import SolidityParser
from solidity_parser.ast import nodes2
import antlr4


class Builder:

    def __init__(self):
        self.builders = {
            SolidityParser.StatementContext: self._first,
            SolidityParser.IfStatementContext: self._if,
            # TODO: SolidityParser.TryStatementContext: self._try,
            SolidityParser.WhileStatementContext: self._while,
            SolidityParser.ForStatementContext: self._for,
            SolidityParser.BlockContext: self._block,
            # TODO: inline assembly
            SolidityParser.DoWhileStatementContext: self._dowhile,
            SolidityParser.ContinueKeyword: self._continue,
            SolidityParser.BreakKeyword: self._break,
            SolidityParser.ReturnStatementContext: self._return,
            # Not valid: SolidityParser.ThrowStatementContext: self._throw,
            SolidityParser.SimpleStatementContext: self._first,
            SolidityParser.ExpressionStatementContext: self._expr_stmt,
            SolidityParser.EmitStatementContext: self._emit,

            # Exprs
            SolidityParser.ExpressionContext: self.make_expr,
            SolidityParser.UnaryPostOpContext: self._unary_post_op,
            SolidityParser.ArrayLoadContext: self._array_load,
            # TODO: arrayslice
            SolidityParser.MemberLoadContext: self._member_load,
            # this is a generic function call expression
            SolidityParser.FuncCallExprContext: self._function_call_expr,
            # TODO: payable expr
            SolidityParser.BracketExprContext: self._first,
            SolidityParser.UnaryPreOpContext: self._unary_pre_op,
            SolidityParser.LogicOpContext: self._unary_pre_op,
            SolidityParser.BinaryExprContext: self._binary_expr,
            SolidityParser.PrimaryContext: self._first,

            SolidityParser.PrimaryExpressionContext: self._primary,

            # misc

            SolidityParser.IdentifierContext: self._identifier,
            SolidityParser.FunctionCallContext: self._function_call,
            SolidityParser.NameValueContext: self._name_value,
            SolidityParser.NameValueListContext: self._all,
            SolidityParser.ExpressionListContext: self._all,
            # this is used for emit stmts only
            SolidityParser.FunctionCallContext: self._function_call,
        }

    def make_ast(self, code: SolidityParser.BlockContext):
        return self._make(code)

    def _make(self, rule: antlr4.ParserRuleContext):
        # Default case
        if rule is None:
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
        return self._make(stmt)

    def make_expr(self, expr: SolidityParser.ExpressionContext):
        return self._make(expr)

    def _first(self, rule: antlr4.ParserRuleContext):
        for c in self.get_grammar_children(rule):
            return self._make(c)
        return None

    def _all(self, rule: antlr4.ParserRuleContext):
        if rule is None:
            return []
        else:
            return self.map_helper(self._make, self.get_grammar_children(rule))

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

    def _while(self, stmt: SolidityParser.WhileStatementContext):
        return nodes2.While(
            self.make_expr(stmt.expression()),
            self.make_stmt(stmt.statement())
        )

    def _for(self, stmt: SolidityParser.ForStatementContext):
        # grammar specifies expressionStatement for the condition part but
        # it should be an expression on its own
        condition = self.make_stmt(stmt.expressionStatement())
        condition = condition.expression() if condition is not None else None

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

    def _continue(self, _):
        return nodes2.Continue()

    def _break(self, _):
        return nodes2.Break()

    def _return(self, stmt: SolidityParser.ReturnStatementContext):
        return nodes2.Return(
            self.make_expr(stmt.expression())
        )

    def _var_decl(self, stmt: SolidityParser.VariableDeclarationContext):
        pass

    def _expr_stmt(self, stmt: SolidityParser.ExpressionStatementContext):
        return nodes2.ExprStmt(
            self.make_expr(stmt.expression())
        )

    def _emit(self, stmt: SolidityParser.EmitStatementContext):
        return nodes2.Emit(
            self._function_call(stmt.functionCall())
        )

    def _identifier(self, rule: antlr4.ParserRuleContext):
        return nodes2.Ident(rule.getText())

    def _array_identifier(self, ident: nodes2.Ident, array_dims: int):
        return nodes2.Ident(ident.text + ('[]' * array_dims))

    def _name_value(self, name_value: SolidityParser.NameValueContext):
        return nodes2.NamedArg(
            self._identifier(name_value.identifier()),
            self.make_expr(name_value.expression())
        )

    def _function_call_args(self, args: SolidityParser.FunctionCallArgumentsContext):
        list_args = args.getChild(0)
        return self._all(list_args)

    def _function_call(self, expr: SolidityParser.FunctionCallContext):
        return nodes2.CallFunction(
            self.make_expr(expr.expression()),
            [],
            self._function_call_args(expr.functionCallArguments())
        )

    def _function_call_expr(self, expr: SolidityParser.FuncCallExprContext):
        return nodes2.CallFunction(
            self.make_expr(expr.expression()),
            self._all(expr.nameValueList()),
            self._function_call_args(expr.functionCallArguments())
        )

    def _unary_pre_op(self, expr: antlr4.ParserRuleContext):
        return nodes2.UnaryOp(
            self.make_expr(expr.getChild(1)),
            nodes2.UnaryOpCode(expr.getChild(0).getText()),
            True
        )

    def _unary_post_op(self, expr: antlr4.ParserRuleContext):
        return nodes2.UnaryOp(
            self.make_expr(expr.getChild(0)),
            nodes2.UnaryOpCode(expr.getChild(1).getText()),
            False
        )

    def _type_name(self, type_name: SolidityParser.TypeNameContext):
        # TODO: split into different subtypes?
        return nodes2.Ident(type_name.getText())

    def _new_obj(self, expr: SolidityParser.NewTypeContext):
        return nodes2.New(
            self._type_name(expr.typeName())
        )

    def _array_load(self, expr: SolidityParser.ArrayLoadContext):
        return nodes2.GetArrayValue(
            self.make_expr(expr.expression(0)),
            self.make_expr(expr.expression(1))
        )

    def _binary_expr(self, expr: SolidityParser.BinaryExprContext):
        op = expr.getChild(1).getText()  # middle child

        return nodes2.BinaryOp(
            self.make_expr(expr.expression(0)),
            self.make_expr(expr.expression(1)),
            op
        )

    def _primary(self, expr: SolidityParser.PrimaryExpressionContext):
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
            base_ident = self._identifier(expr.identifier())
            return self._array_identifier(base_ident, dims)
        elif expr.TypeKeyword() is not None:
            raise NotImplementedError('type keyword')
        elif expr.tupleExpression() is not None:
            return self._tuple_expr(expr.tupleExpression())
        elif expr.typeNameExpression() is not None:
            # TODO: make more specific types, for now use ident
            dims = 1 if expr.arrayBrackets() is not None else 0
            base_ident = self._identifier(expr.typeNameExpression())
            return self._array_identifier(base_ident, dims)
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
            for dqsc in str_frag.DoubleQuotedStringCharacter():
                total_str += dqsc.getText()
            for sqsc in str_frag.SingleQuotedStringCharacter():
                total_str += sqsc.getText()
        return nodes2.Literal(total_str)

    def _tuple_expr(self, expr: SolidityParser.TupleExpressionContext):
        return nodes2.Literal(tuple(self._all(expr)))

    def _member_load(self, expr: SolidityParser.MemberLoadContext):
        # could be field or method ref
        return nodes2.GetMember(
            self.make_expr(expr.expression()),
            self._identifier(expr.identifier())
        )

    def map_helper(self, func, xs):
        # helper to switch between list comprehension for debugging and
        # using map() for performance
        return [func(x) for x in xs]