import sys

from antlr4 import InputStream, CommonTokenStream, TerminalNode

from solidity_parser.grammar.v060.SolidityLexer import SolidityLexer
from solidity_parser.grammar.v060.SolidityParser import SolidityParser

from solidity_parser.ast.builder import Builder

from solidity_parser.collectors.collector import collect_top_level_objects, get_minor_ver
# from solidity_parser.ast.nodes import Contract, ContractType

def fname(node):
    id = node.functionDescriptor().identifier()
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
                b = Builder()
                ast = b.make_ast(code)
                print(ast)
    elif not isinstance(node, TerminalNode):
        for c in node.children:
            visit(c, node)


if __name__ == "__main__":
    # c = Contract('weth9', ContractType.CONTRACT, False, [])
    # print(c)
    input_src = open(
        # sys.argv[1],
        '../example/WETH9.sol',
        'r').read()
    # minor_vers = get_minor_ver(input_src)
    # for obj in collect_top_level_objects(input_src, minor_vers):
        # print(f'=== {obj.name} ===')
        # print(obj.content)
        # print(obj)
    data = InputStream(input_src)
    lexer = SolidityLexer(data)
    stream = CommonTokenStream(lexer)
    parser = SolidityParser(stream)

    tree = parser.sourceUnit()
    source_units = tree.children

    for su in source_units:
        visit(su)