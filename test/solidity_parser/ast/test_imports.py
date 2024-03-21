from snapshottest import TestCase as SnapshotTestCase

from solidity_parser import filesys
from solidity_parser.ast import symtab, ast2builder, solnodes as solnodes1


class TestImports(SnapshotTestCase):

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

    def test_imported_state_var(self):
        self._load('./ImportedStateVar.sol')

        units = self.ast2_builder.get_top_level_units()

        contract_d = [u for u in units if str(u.name) == 'D'][0]

        f_test = [p for p in contract_d.parts if str(p.name) == 'test'][0]

        self.assertEqual('this.g(this.token.f)', f_test.code.stmts[0].expr.code_str())
        self.assertEqual('return this.token.f', f_test.code.stmts[1].code_str())

        f_test2 = [p for p in contract_d.parts if str(p.name) == 'test2'][0]

        self.assertEqual('uint256 x = this.token.f2;', f_test2.code.stmts[0].code_str())

        f_test3 = [p for p in contract_d.parts if str(p.name) == 'test3'][0]

        self.assertEqual('uint256 y = this.token.f3[x];', f_test3.code.stmts[0].code_str())
        self.assertEqual('int8 z = this.token.f4[x][y];', f_test3.code.stmts[1].code_str())
        self.assertEqual('byte[32] b = this.token.f6;', f_test3.code.stmts[2].code_str())
        self.assertEqual('bytes memory b2 = this.token.f7;', f_test3.code.stmts[3].code_str())
        self.assertEqual('string memory s = this.token.f8;', f_test3.code.stmts[4].code_str())
        self.assertEqual('return z + this.token.f5[10]', f_test3.code.stmts[5].code_str())

    def test_expr_types(self):
        ast1_nodes = self.symtab_builder.process_or_find_from_base_dir('ImportedStateVar.sol').value

        cs = [c for u in ast1_nodes if u and not isinstance(u, solnodes1.PragmaDirective) for c in u.get_all_children()
              if isinstance(c, solnodes1.Stmt)]

        # dont include ident/getmember as they are ambiguous without context
        exprs = [e for c in cs for e in c.get_all_children() if
                 isinstance(e, solnodes1.Expr) and not isinstance(e, (solnodes1.Ident, solnodes1.GetMember))]

        types = []
        for e in exprs:
            t2 = self.ast2_builder.type_helper.get_expr_type(e)
            re = self.ast2_builder.refine_expr(e)
            t1 = re.type_of()
            self.assertEqual(t1, t2)
            types.append((re, t1))

        formatted_types = [e.code_str() + " :: " + str(e.type_of()) for (e, t) in types]

        self.assertMatchSnapshot(formatted_types)
