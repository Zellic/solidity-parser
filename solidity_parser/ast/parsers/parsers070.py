import sys
from solidity_parser.ast import solnodes
from solidity_parser.ast.parsers import parsers060
from solidity_parser.ast.parsers.parsers060 import custom_parsers as custom_parsers060
from solidity_parser.ast.parsers.common import ParserBase, get_all_subparsers

from solidity_parser.grammar.v070.SolidityParser import SolidityParser


class Parser070(ParserBase):
    def __init__(self):
        super().__init__({
            # v6 subparsers (base)
            **get_all_subparsers(parsers060),
            **custom_parsers060(),
            # v7 specific ones
            **get_all_subparsers(sys.modules[__name__])
        })


def _pragma_value(parser, pragma_value: SolidityParser.PragmaValueContext):
    # This overrides the v6 rule by the same name
    return pragma_value.getText()


def _unicode_string_literal(parser, literal: SolidityParser.UnicodeStringLiteralContext):
    total_str = ''
    for str_frag in literal.UnicodeStringLiteralFragment():
        total_str += str_frag.getText()[1:-1]
    return solnodes.Literal(total_str)


def _number_literal(parser, literal: SolidityParser.NumberLiteralContext):
    if literal.DecimalNumber():
        str_val = literal.DecimalNumber().getText()
        value = float(str_val)
        assert value.is_integer()
        value = int(value)
    else:
        value = int(literal.HexNumber().getText(), 16)

    unit = None

    if literal.NumberUnit() is not None:
        unit = solnodes.Unit(literal.NumberUnit().getText().lower())
    elif literal.Gwei():
        unit = solnodes.Unit.GWEI
    elif literal.Finney():
        unit = solnodes.Unit.FINNEY
    elif literal.Szabo():
        unit = solnodes.Unit.SZABO

    return solnodes.Literal(value, unit)
