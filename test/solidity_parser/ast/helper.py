from snapshottest.formatters import TypeFormatter, format_list
from snapshottest.formatter import Formatter

from solidity_parser.ast import solnodes2


class NodeListFormatter(TypeFormatter):
    def __init__(self):
        super().__init__(solnodes2.NodeList, format_list)

    def normalize(self, value, formatter):
        return [formatter.normalize(item) for item in value]


def register_solnodes2_formatter():
    registered = False

    for formatter in Formatter.formatters:
        if isinstance(formatter, NodeListFormatter):
            registered = True

    if not registered:
        Formatter.register_formatter(NodeListFormatter())
