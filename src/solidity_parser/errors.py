import typing
from collections import namedtuple

from solidity_parser.util.version_util import Version


class AntlrParsingError(Exception):
    Detail = namedtuple('Detail', 'line_number, line_offset, msg')

    def __init__(self, unit_name: str, version: Version, input_src: str, details):
        super().__init__(f'Antlr AST v{version} parsing error in {unit_name}')
        self.input_src = input_src
        self.details = [AntlrParsingError.Detail(*d) for d in details]


CPEArgs: typing.TypeAlias = tuple[str, str, int, int]
"message, source_unit_name, line_number, line_offset"


# FIXME: Probably should be renamed to something like AST2ProcessingException
class CodeProcessingError(Exception):
    def __init__(self, message: str, source_unit_name: str, line_number, line_offset):
        super().__init__(f'{source_unit_name}@{line_number}:{line_offset} > {message}')


class UnexpectedCodeProcessingError(CodeProcessingError):
    def __init__(self, message: str, source_unit_name: str, line_number: int, line_offset: int, root_cause: Exception):
        super().__init__(message, source_unit_name, line_number, line_offset)
        self.root_cause = root_cause
