import sys
from solidity_parser.ast import nodes2
from solidity_parser.ast.parsers import parsers060
from solidity_parser.ast.parsers.parsers060 import custom_parsers as custom_parsers060
from solidity_parser.ast.parsers.common import ParserBase, get_all_subparsers


class Parser070(ParserBase):
    def __init__(self):
        super().__init__({
            # v6 subparsers (base)
            **get_all_subparsers(parsers060),
            **custom_parsers060(),
            # v7 specific ones
            **get_all_subparsers(sys.modules[__name__])
        })


def _unicode_string_literal(parser, literal: 'UnicodeStringLiteralContext'):
    total_str = ''
    for str_frag in literal.UnicodeStringLiteralFragment():
        total_str += str_frag.getText()[1:-1]
    return nodes2.Literal(total_str)


def _number_literal(parser, literal: 'NumberLiteralContext'):
    if literal.DecimalNumber() is not None:
        value = float(literal.DecimalNumber().getText())
    else:
        value = int(literal.HexNumber().getText())

    unit = None

    if literal.NumberUnit() is not None:
        unit = nodes2.Unit(literal.NumberUnit().getText().lower())
    elif literal.Gwei():
        unit = nodes2.Unit.GWEI
    elif literal.Finney():
        unit = nodes2.Unit.FINNEY
    elif literal.Szabo():
        unit = nodes2.Unit.SZABO

    return nodes2.Literal(value, unit)

# This got changed, but v6 code handles it
# def _identifier(parser, ident: 'IdentifierContext'):
#     return nodes2.Ident(ident.getText())

