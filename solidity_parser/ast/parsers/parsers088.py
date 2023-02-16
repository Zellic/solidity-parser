import sys
from solidity_parser.ast import solnodes
from solidity_parser.ast.parsers import parsers080
from solidity_parser.ast.parsers.parsers080 import custom_parsers as custom_parsers080
from solidity_parser.ast.parsers.common import ParserBase, get_all_subparsers

from solidity_parser.grammar.v088.SolidityParser import SolidityParser


class Parser088(ParserBase):
    def __init__(self):
        super().__init__({
            # v8 subparsers (base)
            **get_all_subparsers(parsers080),
            **custom_parsers080(),
            # v088 specific ones
            **get_all_subparsers(sys.modules[__name__])
        })


def _user_defined_value_type_definition(parser, user_defined_value_type_definition: SolidityParser.UserDefinedValueTypeDefinitionContext):
    return solnodes.UserValueType(
        parser.make(user_defined_value_type_definition.name),
        parser.make(user_defined_value_type_definition.elementaryTypeName())
    )
