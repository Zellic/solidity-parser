from antlr4 import InputStream, CommonTokenStream, TerminalNode

from solidity_parser.grammar.v060.SolidityLexer import SolidityLexer
from solidity_parser.grammar.v060.SolidityParser import SolidityParser
from solidity_parser.collectors.v000 import TopLevelObjectCollector, TopLevelObject


class TopLevelObjectCollectorV060(TopLevelObjectCollector):
    TOP_LEVEL_OBJECT_TYPES = [SolidityParser.StructDefinitionContext, SolidityParser.EnumDefinitionContext,
                              SolidityParser.ContractDefinitionContext]

    def __init__(self):
        super().__init__()

    def visit(self, node, parent=None):
        if isinstance(node, TerminalNode):
            self.visit_terminal_node(node, parent)
        elif node.children is None:
            return ''
        elif isinstance(node, SolidityParser.StatementContext):
            assert len(node.children) == 1
            self.visit(node.children[0], node)
            self.newline()
        elif isinstance(node, SolidityParser.ContractPartContext):
            assert len(node.children) == 1
            self.visit(node.children[0], node)
            self.cur_line += '\n'
            self.newline()
        else:
            for c in node.children:
                self.visit(c, node)

    def collect(self, stream):
        data = InputStream(stream)
        lexer = SolidityLexer(data)
        stream = CommonTokenStream(lexer)
        parser = SolidityParser(stream)

        tree = parser.sourceUnit()
        source_units = tree.children

        result = []
        for su in source_units:
            if type(su) in TopLevelObjectCollectorV060.TOP_LEVEL_OBJECT_TYPES:
                self.reset()
                self.visit(su)
                result.append(TopLevelObject(str(su.identifier().Identifier()), self.collect_lines()))

        return result
