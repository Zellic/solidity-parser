def assert_invalid_path():
    # Error indicating that the node could not be parsed as it wasn't
    # as expected from the grammar, i.e. the subparsers assumptions
    # about the antlr grammar/parse tree are not as expected
    assert False, 'Unexpected data from parsed node'


def unsupported_feature(detail):
    raise ParsingException(f'Grammar feature not supported: {detail}')


def invalid_solidity(detail):
    # Error state that represents a parse tree that is valid but code that the ast producer rejects on the grounds
    # that it is not valid solidity code. This can happen as the antlr grammars accept more input than the language
    # actually allows
    raise ParsingException(f'Invalid solidity code: {detail}')


# TODO attach parsing context
class ParsingException(Exception):
    pass
