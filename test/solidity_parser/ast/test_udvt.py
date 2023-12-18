import unittest

from solidity_parser import filesys, errors
from solidity_parser.ast import symtab, ast2builder, solnodes, solnodes2


class TestUDVT(unittest.TestCase):

    def setUp(self) -> None:
        self.vfs = filesys.VirtualFileSystem('testcases/08_22')
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

    def test_plus_check_return_type(self):
        self._load('./OperatorUsing.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.FileDefinition)]
        test = [p for p in units[0].parts if str(p.name) == 'test'][0]
        library_call = [c for c in test.code.get_all_children() if isinstance(c, solnodes2.Call)][0]

        self.assertEqual(str(library_call.ttype), 'ResolvedUserType(OperatorUsing.sol)')

    def test_get_expr_type_bound_binary_operator(self):
        self._load('./OperatorUsing.sol')

        ast1_nodes = self.vfs.sources['OperatorUsing.sol'].ast
        testF = [p for p in ast1_nodes if isinstance(p, solnodes.FunctionDefinition) and str(p.name) == 'test'][0]
        binary_expr = [c for c in testF.code.get_all_children() if isinstance(c, solnodes.BinaryOp)][0]
        result_type = self.ast2_builder.type_helper.get_expr_type(binary_expr)

        self.assertEqual(str(result_type), 'ResolvedUserType(Int)')

    def test_get_expr_type_bound_unary_operator(self):
        self._load('./NegOperator.sol')

        ast1_nodes = self.vfs.sources['NegOperator.sol'].ast
        testF = [p for p in ast1_nodes if isinstance(p, solnodes.FunctionDefinition) and str(p.name) == 'test_neg'][0]
        unary_expr = [c for c in testF.code.get_all_children() if isinstance(c, solnodes.UnaryOp)][0]
        result_type = self.ast2_builder.type_helper.get_expr_type(unary_expr)

        self.assertEqual(str(result_type), 'ResolvedUserType(Int)')


    def test_plus_calls_add(self):
        self._load('./OperatorUsing.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.FileDefinition)]
        test = [p for p in units[0].parts if str(p.name) == 'test'][0]
        library_call = [c for c in test.code.get_all_children() if isinstance(c, solnodes2.Call)][0]

        self.assertEqual('OperatorUsing.sol.add(a, b)', library_call.code_str())

    def test_add_not_attached(self):
        # tests that the 'add' function wasn't attached to the Int scope, it was only bound to the + operator
        with self.assertRaises(errors.CodeProcessingError) as context:
            self._load('./OperatorAttachAndBindFailureCase.sol')

        msg = str(context.exception)

        self.assertTrue('Can\'t resolve call' in msg, msg)

    def test_add_operator_bound_with_import(self):
        self._load('./OperatorAttachAndBindWithImport.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.FileDefinition)]
        test = [p for p in units[0].parts if str(p.name) == 'test_valid'][0]
        library_call = [c for c in test.code.get_all_children() if isinstance(c, solnodes2.Call)][0]

        self.assertEqual('OperatorAttachAndBind.sol.add(x, y)', library_call.code_str())

    def test_neg_too_many_args(self):
        with self.assertRaises(errors.CodeProcessingError) as context:
            self._load('./NegOperatorNotEnoughArgs.sol')

        msg = str(context.exception)

        self.assertTrue('Mismatched arg types: [ResolvedUserType(Int)] vs [ResolvedUserType(Int), ResolvedUserType(Int)]' in msg, msg)

    def test_add_operator_bound_with_import(self):
        self._load('./NegOperator.sol')

        units = [u for u in self.ast2_builder.get_top_level_units() if isinstance(u, solnodes2.FileDefinition)]
        test = [p for p in units[0].parts if str(p.name) == 'test_neg'][0]
        library_call = [c for c in test.code.get_all_children() if isinstance(c, solnodes2.Call)][0]

        self.assertEqual('NegOperator.sol.myNeg(x)', library_call.code_str())
