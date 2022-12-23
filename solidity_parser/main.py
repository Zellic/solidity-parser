import sys

from antlr4 import InputStream, CommonTokenStream, TerminalNode

from solidity_parser.grammar.v060.SolidityLexer import SolidityLexer as SolidityLexer060
from solidity_parser.grammar.v060.SolidityParser import SolidityParser as SolidityParser060


from solidity_parser.grammar.v070.SolidityLexer import SolidityLexer as SolidityLexer070
from solidity_parser.grammar.v070.SolidityParser import SolidityParser as SolidityParser070

from solidity_parser.grammar.v080.SolidityLexer import SolidityLexer as SolidityLexer080
from solidity_parser.grammar.v080.SolidityParser import SolidityParser as SolidityParser080

from solidity_parser.collectors.collector import collect_top_level_objects, get_minor_ver
# from solidity_parser.ast.nodes import Contract, ContractType
import prettyprinter as pp

from solidity_parser.ast.parsers.parsers060 import Parser060
from solidity_parser.ast.parsers.parsers070 import Parser070
from solidity_parser.ast.parsers.parsers080 import Parser080

import os
import json
from json import JSONDecoder


def fname(node):
    # id = node.functionDescriptor().identifier()
    id = node.identifier()
    if id is not None:
        return id.Identifier().getText(), False
    else:
        return '<' + node.functionDescriptor().getText() + '>', True


# def visit(node, parent=None):
#     if isinstance(node, SolidityParser.FunctionDefinitionContext):
#         name, special = fname(node)
#         if not special:
#             print(name)
#             code = node.block()
#             if code is not None:
#                 p = Parser080()
#                 ast = p.make(code)
#                 pp.pprint(ast)
#     elif not isinstance(node, TerminalNode):
#         for c in node.children:
#             visit(c, node)


def get_contracts_from_descriptors(input_files):
    for file_name in input_files:
        with open(file_name, encoding='utf-8') as file:
            descriptors = json.load(file)
            if len(descriptors) != 1:
                raise Exception("piss")
            # print(json.dumps(d, sort_keys=True, indent=2))
            # print(file_name)
            source_codes_str = descriptors[0]['SourceCode']

            # source_code_str is either the source code of the contract or a json
            # object containing source codes for the contracts...
            try:
                source_codes = json.loads(source_codes_str)
            except json.decoder.JSONDecodeError:
                source_codes = [source_codes_str]

            for sc in source_codes:
                minor_vers = get_minor_ver(sc)
                if minor_vers is not None:
                    yield file_name, minor_vers, sc


def try_parse_contract(file_name, version, contract_source):
    contract_input = InputStream(contract_source)

    if version < 7:
        grammar_parser_type = SolidityParser060
        grammar_lexer_type = SolidityLexer060
        ast_parser = Parser060()
    elif 8 > version >= 7:
        grammar_parser_type = SolidityParser070
        grammar_lexer_type = SolidityLexer070
        ast_parser = Parser070()
    elif version >= 8:
        grammar_parser_type = SolidityParser080
        grammar_lexer_type = SolidityLexer080
        ast_parser = Parser080()
    else:
        raise KeyError(f"dingle error, v{version}")

    lexer = grammar_lexer_type(contract_input)
    stream = CommonTokenStream(lexer)
    parser = grammar_parser_type(stream)

    try:
        tree = parser.sourceUnit()
        source_units = tree.children

        for su in source_units:
            u = ast_parser.make(su)
            # pp.pprint(u)
        print("pass")
    except Exception as e:
        print(f"piss: {file_name} {version}")
        print(contract_source)
        raise e


if __name__ == '__main__':
    base_dir = 'C:/Users/Bilal/Downloads/contracts-30xx-only.tar/contracts-30xx-only'
    all_files = [os.path.join(dp, f) for dp, dn, filenames in os.walk(base_dir) for f in filenames]

    for info in get_contracts_from_descriptors(all_files):
        try_parse_contract(*info)

    # input_src = open(
    #     '../example/FunctionsTest.sol',
    #     'r').read()
    #
    # try_parse_contract('ft', 7, input_src)



if __name__ == "__main__1":
    # c = Contract('weth9', ContractType.CONTRACT, False, [])
    # print(c)
    pp.install_extras()
    input_src = open(
        # sys.argv[1],
        '../example/cryptokitties.sol',
        # '../example/greedy-airdropper.sol',
        # '../example/AaveToken.sol',
        'r').read()
    # minor_vers = get_minor_ver(input_src)
    # for obj in collect_top_level_objects(input_src, minor_vers):
    #     print(f'=== {obj.name} ===')
    #     print(obj.content)
    #     print(obj)
    data = InputStream(input_src)
    # lexer = SolidityLexer(data)
    # stream = CommonTokenStream(lexer)
    # parser = SolidityParser(stream)

    # tree = parser.sourceUnit()
    # source_units = tree.children

    # p = Parser060()

    # for su in source_units:
        # visit(su)
        # u = p.make(su)
        # pp.pprint(u)
