import unittest

from solidity_parser import filesys
from solidity_parser.ast import symtab, ast2builder, solnodes2


class TestUsingDirectives(unittest.TestCase):

    def setUp(self) -> None:
        self.vfs = filesys.VirtualFileSystem('testcases/using_directives')
        self.symtab_builder = symtab.Builder2(self.vfs)
        self.ast2_builder = ast2builder.Builder()

    def _load(self, *files):
        fs = [self.symtab_builder.process_or_find_from_base_dir(f) for f in files]
        self.ast2_builder.enqueue_files(fs)
        self.ast2_builder.process_all()

    def test_basic_using_directive(self):
        self._load('./UsingDirectiveNormal.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.ContractDefinition)]
        testAdd = [p for p in units[0].parts if str(p.name) == 'testAdd'][0]
        library_call1 = [c for c in testAdd.code.get_all_children() if isinstance(c, solnodes2.Call)][0]
        self.assertEqual('MyAddLib.add(myX, myY)', library_call1.code_str())

        testAdd = [p for p in units[0].parts if str(p.name) == 'testSub'][0]
        library_call2 = [c for c in testAdd.code.get_all_children() if isinstance(c, solnodes2.Call)][0]
        self.assertEqual('MySubLib.sub(myX, myY)', library_call2.code_str())

    def test_basic_global_using_directive(self):
        self._load('./UsingWithLibrary.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.ContractDefinition)]
        testUser = [p for p in units[0].parts if str(p.name) == 'testUser'][0]
        library_call1 = [c for c in testUser.code.get_all_children() if isinstance(c, solnodes2.Call)][0]
        self.assertEqual('UserLibrary.inc(u, 5)', library_call1.code_str())

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.FileDefinition)]
        testUserOutside = [u for u in units[0].parts if str(u.name) == 'testUserOutside'][0]
        library_call2 = [c for c in testUserOutside.code.get_all_children() if isinstance(c, solnodes2.Call)][0]
        self.assertEqual('UserLibrary.dec(u)', library_call2.code_str())

    def test_import_global_using_directive(self):
        self._load('./TestImportableUser.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.ContractDefinition)]
        testFoo = [p for p in units[0].parts if str(p.name) == 'testFoo'][0]
        library_call = [c for c in testFoo.code.get_all_children() if isinstance(c, solnodes2.Call)][0]

        self.assertEqual('ImportableUser.sol.clear_count(user)', library_call.code_str())

    def test_free_functions(self):
        self._load('./FreeFunctions.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.ContractDefinition)]
        set_v = [p for p in units[0].parts if str(p.name) == 'set_v'][0]
        library_call = [c for c in set_v.code.get_all_children() if isinstance(c, solnodes2.Call)][0]
        self.assertEqual('FreeFunctions.sol.mask(n, 16)', library_call.code_str())
