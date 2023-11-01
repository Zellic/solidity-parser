import unittest

from solidity_parser import filesys
from solidity_parser.ast import symtab, ast2builder, solnodes2


class TestUDVT(unittest.TestCase):

    def setUp(self) -> None:
        self.vfs = filesys.VirtualFileSystem('../testcases/08_22')
        self.symtab_builder = symtab.Builder2(self.vfs)
        self.ast2_builder = ast2builder.Builder()

    def _load(self, *files):
        fs = [self.symtab_builder.process_or_find_from_base_dir(f) for f in files]
        self.ast2_builder.enqueue_files(fs)
        self.ast2_builder.process_all()

    def test_wrap_unwrap(self):
        self._load('./OperatorUsing.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.FileDefinition)]
        add = [p for p in units[0].parts if str(p.name) == 'add'][0]
        library_call1 = [c for c in add.code.get_all_children() if isinstance(c, solnodes2.Call)][0]
        self.assertEqual('Int.wrap(Int.unwrap(a) + Int.unwrap(b))', library_call1.code_str())

    def test_plus_calls_add(self):
        self._load('./OperatorUsing.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.FileDefinition)]
        test = [p for p in units[0].parts if str(p.name) == 'test'][0]

        print(test.code.code_str())

