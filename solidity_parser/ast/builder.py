from solidity_parser.grammar.v060.SolidityParser import SolidityParser
from solidity_parser.ast import nodes2
import antlr4

class Builder:

    def __init__(self):
        self.stmt_builders = {
            SolidityParser.IfStatementContext: self._if,
            # SolidityParser.TryStatementContext: self._try,
            SolidityParser.WhileStatementContext: self._while,
            # SolidityParser.ForStatementContext: self._for,
            # SolidityParser.BlockContext: self._block,
            # SolidityParser.DoWhileStatementContext: self._dowhile,
            # SolidityParser.ContinueKeyword: self._continue,
            # SolidityParser.BreakKeyword: self._break,
            # SolidityParser.ReturnStatementContext: self._return,
            # SolidityParser.ThrowStatementContext: self._throw,
            SolidityParser.SimpleStatementContext: self._first_stmt
        }

    def make_ast(self, code: SolidityParser.BlockContext):
        stmts = []

        for stmt in code.statement():
            stmts.append(self.make_stmt(stmt))

        return stmts

    def make_stmt(self, stmt: SolidityParser.StatementContext):
        # Default case
        if stmt is None:
            return None

        real_stmt = stmt.children[0]
        real_stmt_type = type(real_stmt)

        if real_stmt_type in self.stmt_builders:
            stmt_builder = self.stmt_builders[real_stmt_type]
            return stmt_builder(real_stmt)
        else:
            raise KeyError('Unsupported type: ' + real_stmt_type.__name__)


    def make_expr(self, stmt: SolidityParser.ExpressionContext):
        return None


    def _first_stmt(self, stmt: antlr4.ParserRuleContext):
        for c in stmt.getChildren():
            return self.make_stmt(c)
        return None

    def _if(self, stmt: SolidityParser.IfStatementContext):
        return nodes2.If(
            self.make_expr(stmt.expression()),
            self.make_stmt(stmt.statement(self, 0)),
            self.make_stmt(stmt.statement(self, 1))
        )


    def _while(self, stmt: SolidityParser.WhileStatementContext):
        return nodes2.While(
            self.make_expr(stmt.expression()),
            self.make_stmt(stmt.statement())
        )

