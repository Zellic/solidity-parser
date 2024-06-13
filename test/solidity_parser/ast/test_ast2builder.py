from unittest import TestCase, main
from unittest.mock import Mock, MagicMock, patch, sentinel

from .helper import register_solnodes2_formatter

from solidity_parser.filesys import VirtualFileSystem
from solidity_parser.ast.symtab import Builder2 as SymtabBuilder
from solidity_parser.ast import solnodes as solnodes1, solnodes2, helper, types as soltypes, nodebase
from solidity_parser.ast.ast2builder import Builder as AST2Builder, TypeHelper, ErrorHandler

from snapshottest import TestCase as SnapshotTestCase
from snapshottest.file import FileSnapshot

from pathlib import Path

register_solnodes2_formatter()


class TestSolidityTypeHelper(SnapshotTestCase):

    def setUp(self):
        super().setUp()
        self.maxDiff = None
        self.vfs = VirtualFileSystem('../solidity-parser/testcases/type_tests')
        self.symtab_builder = SymtabBuilder(self.vfs)
        self.ast2_builder = AST2Builder()
        self.type_helper = self.ast2_builder.type_helper

    def test_get_expr_type(self):
        file_scope = self.symtab_builder.process_or_find_from_base_dir('basic_types.sol')
        ast1_nodes = file_scope.value

        cs = [c for u in ast1_nodes if u and not isinstance(u, solnodes1.PragmaDirective) for c in u.get_all_children()
              if isinstance(c, solnodes1.Stmt)]

        exprs = [e for c in cs for e in c.get_all_children() if
                 isinstance(e, solnodes1.Expr) and not isinstance(e, solnodes1.Ident)]

        # test get_expr_type
        types = [(e, self.type_helper.get_expr_type(e, allow_multiple=True)) for e in exprs]

        formatted_types = [str(e) + " :: " + str(t) for (e,t) in types]

        self.assertMatchSnapshot(formatted_types)

    def test_get_expr_type_member_not_found(self):
        file_scope = self.symtab_builder.process_or_find_from_base_dir('missing_member.sol')
        ast1_nodes = file_scope.value

        exprs = [c for u in ast1_nodes if u for c in u.get_all_children() if isinstance(c, solnodes1.GetMember)]

        self.assertEqual(len(exprs), 1)
        self.assertEqual(self.type_helper.get_expr_type(exprs[0]), [])
        self.assertEqual(self.type_helper.get_expr_type(exprs[0], allow_multiple=True), [])

    def test_get_expr_type_function_call_hierarchy(self):
        file_scope = self.symtab_builder.process_or_find_from_base_dir('HierarchyFunctions.sol')
        ast1_nodes = file_scope.value

        expr = [c for u in ast1_nodes if u for c in u.get_all_children() if isinstance(c, solnodes1.CallFunction) and str(c.callee) == 'hasFoo'][0]

        self.assertEqual(self.type_helper.get_function_expr_type(expr), soltypes.BoolType())

    def test_get_expr_type_float(self):
        file_scope = self.symtab_builder.process_or_find_from_base_dir('float_type.sol')
        ast1_nodes = file_scope.value

        binary_op = [c for u in ast1_nodes if u for c in u.get_all_children() if isinstance(c, solnodes1.BinaryOp)][0]

        # print(self.type_helper.get_expr_type(binary_op.left))
        # print(self.type_helper.get_expr_type(binary_op.right))
        # print(self.type_helper.get_expr_type(binary_op))
        # self.assertEqual(len(exprs), 1)
        # self.assertEqual(self.type_helper.get_expr_type(exprs[0]), [])
        # self.assertEqual(self.type_helper.get_expr_type(exprs[0], allow_multiple=True), [])

    def test_get_function_expr_type(self):
        file_scope = self.symtab_builder.process_or_find_from_base_dir('function_call_types.sol')
        ast1_nodes = file_scope.value

        exprs = [c for u in ast1_nodes if u for c in u.get_all_children() if isinstance(c, solnodes1.CallFunction)]

        types = [(e, self.type_helper.get_function_expr_type(e, allow_multiple=True)) for e in exprs]

        formatted_types = [str(e) + " :: " + str(t) for (e,t) in types]

        self.assertMatchSnapshot(formatted_types)

    def test_get_function_expr_type_ternary(self):
        file_scope = self.symtab_builder.process_or_find_from_base_dir('ternary.sol')
        ast1_nodes = file_scope.value
        exprs = [c for u in ast1_nodes if u for c in u.get_all_children() if isinstance(c, solnodes1.TernaryOp)]
        types = [(e, self.type_helper.get_expr_type(e)) for e in exprs]

        formatted_types = [str(e) + " :: " + str(t) for (e,t) in types]

        self.assertMatchSnapshot(formatted_types)

    def test_get_function_expr_type_inline_arrays(self):
        file_scope = self.symtab_builder.process_or_find_from_base_dir('inline_array_type.sol')
        ast1_nodes = file_scope.value
        exprs = [c for u in ast1_nodes if u for c in u.get_all_children() if isinstance(c, solnodes1.NewInlineArray)]
        types = [(e, self.type_helper.get_expr_type(e)) for e in exprs]

        formatted_types = [str(e) + " :: " + str(t) for (e,t) in types]

        self.assertMatchSnapshot(formatted_types)


class TestSolidityAnalyzer(TestCase):

    def setUp(self):
        self.builder = AST2Builder()
        self.type_helper = self.builder.type_helper

    def test_get_expr_type_ast1_type(self):
        with patch.object(self.type_helper, 'map_type') as mock_map_type:
            expr = Mock(spec=soltypes.Type)

            self.type_helper.get_expr_type(expr)

            mock_map_type.assert_called_once_with(expr)

    def test_get_expr_type_ident_this(self):
        expr = Mock(spec=solnodes1.Ident)
        expr.text = 'this'

        with patch.object(self.type_helper, 'get_current_contract_type') as mock_get_current_contract_type:
            mock_get_current_contract_type.return_value = sentinel.current_contract_type

            result = self.type_helper.get_expr_type(expr)

            mock_get_current_contract_type.assert_called_once_with(expr)
            self.assertEqual(result, sentinel.current_contract_type)

    def test_get_expr_type_ident_super(self):
        expr = Mock(spec=solnodes1.Ident)
        expr.text = 'super'

        with patch.object(self.type_helper, 'get_current_contract_type') as mock_get_current_contract_type:
            resolved_type_mock = Mock(spec=solnodes2.ResolvedUserType)
            resolved_type_mock.value = nodebase.Ref(sentinel.current_contract)
            mock_get_current_contract_type.return_value = resolved_type_mock

            result = self.type_helper.get_expr_type(expr)

            mock_get_current_contract_type.assert_called_once_with(expr)
            self.assertIsInstance(result, solnodes2.SuperType)
            self.assertEqual(result.declarer.x, sentinel.current_contract)

    def test_get_expr_type_ident_single(self):
        expr = Mock(spec=solnodes1.Ident)
        expr.text = 'myAbc'

    # def test_get_expr_type_literal_int(self):
    #     expr = YourMockLiteralIntExpression()  # Replace with your mock expression
    #     result_type = self.analyzer.get_expr_type(expr)
    #     self.assertEqual(result_type, solnodes2.PreciseIntType(is_signed=False, size=8, real_bit_length=1, value=42))

    # Add more test cases for other branches in get_expr_type


if __name__ == '__main__':
    main()