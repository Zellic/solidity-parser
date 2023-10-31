import sys
from solidity_parser.ast import solnodes
from solidity_parser.ast.parsers import parsers080
from solidity_parser.ast.parsers import parsers088
from solidity_parser.ast.parsers.parsers080 import custom_parsers as custom_parsers080
from solidity_parser.ast.parsers.common import ParserBase, get_all_subparsers

from solidity_parser.grammar.v08_22.SolidityParser import SolidityParser

# Changes in this grammar compared to 0.8.8:
#  usingDirective and eventDefinition are added as sourceUnits, this is taken care of by make_first
#  userDefinableOperators
#  named paramteres in mapping types


class Parser08_22(ParserBase):
    def __init__(self, token_stream):
        super().__init__({
            # v8 subparsers (base)
            **get_all_subparsers(parsers080),
            **custom_parsers080(),
            **get_all_subparsers(parsers088),
            # v08_20 specific ones
            **get_all_subparsers(sys.modules[__name__])
        }, token_stream)


def _user_definable_operator(parser, rule: SolidityParser.UserDefinableOperatorContext):
    text = rule.getChild(0).getText()
    if rule.BitNot() or rule.Sub():
        return solnodes.UnaryOpCode(text)
    else:
        return solnodes.BinaryOpCode(text)


def _using_directive_alias(parser, rule: SolidityParser.UsingDirectiveAliasContext):
    if rule.userDefinableOperator():
        return solnodes.UsingOperatorBinding(
            parser.make(rule.identifierPath()),
            parser.make(rule.userDefinableOperator()),
        )
    else:
        return solnodes.UsingAttachment(
            parser.make(rule.identifierPath())
        )


def _using_directive(parser, rule: SolidityParser.UsingDirectiveContext):
    ### overrides the base UsingDirectiveContext rule ###
    if rule.Mul():
        override_type = solnodes.AnyType()
    else:
        override_type = parser.make(rule.typeName())

    if rule.usingDirectiveAlias():
        library_name = None
        attachments_or_bindings = parser.make_all_rules(rule.usingDirectiveAlias())
    else:
        library_name = parser.make(rule.identifierPath())
        attachments_or_bindings = []

    is_global = rule.Global() is not None

    return solnodes.UsingDirective(library_name, override_type, attachments_or_bindings, is_global)


def _number_literal(parser, rule: SolidityParser.NumberLiteralContext):
    ### overrides the base NumberLiteralContext rule ###
    # no units/subdenominations in this rule anymore
    if rule.DecimalNumber():
        str_val = rule.DecimalNumber().getText()
        # parse unit float() instead of int() as it handles the decimal point and exponent stuff
        value = float(str_val)
        if value.is_integer():
            value = int(value)
    else:
        value = int(rule.HexNumber().getText(), 16)
    return solnodes.Literal(value)


def _literal_with_sub_denomination(parser, rule: SolidityParser.LiteralWithSubDenominationContext):
    lit = parser.make(rule.numberLiteral())
    unit = solnodes.Unit(rule.SubDenomination().getText().lower())
    return solnodes.Literal(lit.value, unit)


def _mapping_type(parser, rule: SolidityParser.MappingTypeContext):
    ### overrides the base MappingTypeContext rule ###
    key = parser.make(rule.key)
    if isinstance(key, solnodes.Ident):
        key = solnodes.UserType(key)
    value = parser.make(rule.value)

    key_name = parser.make(rule.name1)
    value_name = parser.make(rule.name2)

    return solnodes.MappingType(key, value, key_name, value_name)
