import unittest

from solidity_parser import filesys
from solidity_parser.ast import symtab, ast2builder, solnodes2


class TestImports(unittest.TestCase):

    def setUp(self) -> None:
        self.vfs = filesys.VirtualFileSystem('testcases/imports')
        self.symtab_builder = symtab.Builder2(self.vfs)
        self.ast2_builder = ast2builder.Builder()

    def _load(self, *files):
        fs = [self.symtab_builder.process_or_find_from_base_dir(f) for f in files]
        self.ast2_builder.enqueue_files(fs)
        self.ast2_builder.process_all()

        self.assertEqual([], self.ast2_builder.error_handler.caught_errors)

    def test_basic_using_directive(self):
        self._load('./ImportB.sol')

