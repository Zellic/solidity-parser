from typing import List
from collections import namedtuple

from solidity_parser.util.version_util import Version


class AntlrParsingError(Exception):
    Detail = namedtuple('Detail', 'line_number, line_offset, msg')

    def __init__(self, version: Version, input_src: str, details):
        super().__init__(f'Antlr AST v{version} parsing error')
        self.input_src = input_src
        self.details = [AntlrParsingError.Detail(*d) for d in details]


class CodeProcessingError(Exception):
    def __init__(self, message, source_unit_name, line_number, line_offset):
        super().__init__(f'{source_unit_name}@{line_number}:{line_offset} > {message}')

