from typing import List

from antlr4 import InputStream, CommonTokenStream, BailErrorStrategy
from antlr4.error.ErrorListener import ErrorListener

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

from solidity_parser.errors import AntlrParsingError


class MyErrorListener(ErrorListener):

    def __init__(self):
        super().__init__()

    def add_error(self, recognizer, line, column, msg):
        try:
            errors = recognizer.errors
        except AttributeError:
            errors = []
            recognizer.errors = errors

        errors.append((line, column, msg))

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        self.add_error(recognizer, line, column, msg)


def get_processors(version: int):
    def _wrap(clazz):
        def create_lexer(*args, **kwargs):
            obj = clazz(*args, **kwargs)
            obj.removeErrorListeners()
            obj.addErrorListener(BailErrorStrategy())
            return obj
        return create_lexer

    def get():
        if version < 7:
            return SolidityParser060, SolidityLexer060, Parser060()
        elif 8 > version >= 7:
            return SolidityParser070, SolidityLexer070, Parser070()
        elif version >= 8:
            return SolidityParser080, SolidityLexer080, Parser080()
        else:
            raise KeyError(f"Unsupported version: v{version}")

    # sp, sl, p = get()
    # return _wrap(sp), _wrap(sl), p
    return get()


def make_ast(input_src, version: int = None) -> List[solnodes.SourceUnit]:
    if version is None:
        version = collector.get_minor_ver(input_src)

    grammar_parser_type, grammar_lexer_type, ast_parser = get_processors(version)

    contract_input = InputStream(input_src)
    lexer = grammar_lexer_type(contract_input)
    stream = CommonTokenStream(lexer)
    parser = grammar_parser_type(stream)
    parser.addErrorListener(MyErrorListener())

    parse_tree = parser.sourceUnit()
    source_units = parse_tree.children

    if hasattr(parser, 'errors') and parser.errors:
        raise AntlrParsingError(version, input_src, parser.errors)

    return list(map(ast_parser.make, source_units))


def param_type_str(parameters: List[solnodes.Parameter]) -> str:
    return '(' + ', '.join([str(p.var_type) for p in parameters]) + ')'
