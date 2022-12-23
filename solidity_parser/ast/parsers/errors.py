def assert_invalid_path():
    # Error indicating that the node could not be parsed as it wasn't
    # as expected from the grammar, i.e. the subparsers assumptions
    # about the antlr grammar/parse tree are not as expected
    assert False, 'Unexpected data from parsed node'


def unsupported_feature(detail):
    raise ParsingException(f'Grammar feature not supported: {detail}')


# TODO attach parsing context
class ParsingException(Exception):
    pass
