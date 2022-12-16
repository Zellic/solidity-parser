import sys

from antlr4 import InputStream, CommonTokenStream, TerminalNode

from solidity_parser.grammar.v080.SolidityLexer import SolidityLexer
from solidity_parser.grammar.v080.SolidityParser import SolidityParser

from solidity_parser.collectors.collector import collect_top_level_objects, get_minor_ver
# from solidity_parser.ast.nodes import Contract, ContractType
import prettyprinter as pp

from solidity_parser.ast.parsers.parsers060 import Parser060
from solidity_parser.ast.parsers.parsers070 import Parser070
from solidity_parser.ast.parsers.parsers080 import Parser080

def fname(node):
    # id = node.functionDescriptor().identifier()
    id = node.identifier()
    if id is not None:
        return id.Identifier().getText(), False
    else:
        return '<' + node.functionDescriptor().getText() + '>', True


def visit(node, parent=None):
    if isinstance(node, SolidityParser.FunctionDefinitionContext):
        name, special = fname(node)
        if not special:
            print(name)
            code = node.block()
            if code is not None:
                p = Parser080()
                ast = p.make(code)
                pp.pprint(ast)
    elif not isinstance(node, TerminalNode):
        for c in node.children:
            visit(c, node)


if __name__ == "__main__":
    # c = Contract('weth9', ContractType.CONTRACT, False, [])
    # print(c)
    pp.install_extras()
    input_src = open(
        # sys.argv[1],
        # '../example/greedy-airdropper.sol',
        '../example/AaveToken.sol',
        'r').read()
    # minor_vers = get_minor_ver(input_src)
    # for obj in collect_top_level_objects(input_src, minor_vers):
    #     print(f'=== {obj.name} ===')
    #     print(obj.content)
    #     print(obj)
    data = InputStream(input_src)
    lexer = SolidityLexer(data)
    stream = CommonTokenStream(lexer)
    parser = SolidityParser(stream)

    tree = parser.sourceUnit()
    source_units = tree.children

    p = Parser080()

    for su in source_units:
        # visit(su)
        u = p.make(su)
        pp.pprint(u)
