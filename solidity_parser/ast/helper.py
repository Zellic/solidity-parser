from typing import List

from antlr4 import InputStream, CommonTokenStream

from solidity_parser.collectors import collector

from solidity_parser.grammar.v060.SolidityLexer import SolidityLexer as SolidityLexer060
from solidity_parser.grammar.v060.SolidityParser import SolidityParser as SolidityParser060
from solidity_parser.grammar.v070.SolidityLexer import SolidityLexer as SolidityLexer070
from solidity_parser.grammar.v070.SolidityParser import SolidityParser as SolidityParser070
from solidity_parser.grammar.v080.SolidityLexer import SolidityLexer as SolidityLexer080
from solidity_parser.grammar.v080.SolidityParser import SolidityParser as SolidityParser080

from solidity_parser.ast.parsers.parsers060 import Parser060
from solidity_parser.ast.parsers.parsers070 import Parser070
from solidity_parser.ast.parsers.parsers080 import Parser080

from solidity_parser.ast import solnodes

def make_ast(input_src, version: int = None) -> List[solnodes.SourceUnit]:
    if version is None:
        version = collector.get_minor_ver(input_src)

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
        raise KeyError(f"Unsupported version: v{version}")

    contract_input = InputStream(input_src)
    lexer = grammar_lexer_type(contract_input)
    stream = CommonTokenStream(lexer)
    parser = grammar_parser_type(stream)

    parse_tree = parser.sourceUnit()
    source_units = parse_tree.children

    return list(map(ast_parser.make, source_units))


def param_type_str(parameters: List[solnodes.Parameter]) -> str:
    return '(' + ', '.join([str(p.var_type) for p in parameters]) + ')'
