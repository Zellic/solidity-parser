import unittest
from snapshottest import TestCase as SnapshotTestCase
from parameterized import parameterized
import re
import os

from pathlib import Path

from solidity_parser import filesys, errors
from solidity_parser.util.version_util import Version
from solidity_parser.ast import symtab, ast2builder, solnodes, solnodes2

from .helper import register_solnodes2_formatter

register_solnodes2_formatter()


def get_test_cases(subdir, exclusions):
    base_dir = Path(os.getcwd()) / subdir
    return [(p,) for p in Path(base_dir).rglob('*.sol') if str(p.relative_to(base_dir)).replace('\\', '/') not in exclusions]


def get_test_cases_only(subdir, inclusions):
    base_dir = Path(os.getcwd()) / subdir
    return [(base_dir/p,) for p in inclusions]


def test_case_namer2(base_dir):
    def namer(testcase_func, param_num, param):
        file = str(param[0][0]).replace('\\', '/')
        dir_idx = file.find(base_dir)
        # relative to the base dir and take away .sol
        file_name = file[dir_idx + len(base_dir)+1:-4]
        return "%s_%s" % (
            testcase_func.__name__,
            file_name,
        )
    return namer

def test_case_namer(testcase_func, param_num, param):
    file = param[0][0]
    return "%s_%s" % (
        testcase_func.__name__,
        parameterized.to_safe_name(file.name),
    )


class LibSolidityTestBase(unittest.TestCase):
    def __init__(self, base_path, *args, **kwargs):
        self.base_path = base_path
        super().__init__(*args, **kwargs)

    def setUp(self) -> None:
        self.vfs = filesys.VirtualFileSystem(self.base_path, compiler_version=Version(0, 8, 22))
        self.symtab_builder = symtab.Builder2(self.vfs)
        self.ast2_builder = ast2builder.Builder()
        self.error_handler = self.ast2_builder.error_handler
        self.error_handler.quiet_errors = False

    def _load(self, *files, check_errors=True):
        # try:
        fs = [self.symtab_builder.process_or_find_from_base_dir(f) for f in files]
        self.ast2_builder.enqueue_files(fs)
        self.ast2_builder.process_all()

        if check_errors:
            self.assertEqual([], self.error_handler.caught_errors)
        # except:
        #     with open('C:/Users/Bibl/Desktop/err2.txt', 'a') as f:
        #         for x in files:
        #             f.write(str(x))
        #             f.write('\n')

    def _load_separated_file(self, file, check_errors=True):
        txt = Path(self.vfs.base_path + '/' + file).read_text()

        header_regex = '==== Source: ([a-zA-Z]+) ===='

        matches = re.split(header_regex, txt)

        srcs = []
        # skip first element, it's empty str ''
        for i in range(1, len(matches), 2):
            name, code = matches[i], matches[i+1]
            srcs.append(self.vfs._add_loaded_source(name, code, origin=f'{name}.sol'))

        fs = [self.symtab_builder.process_or_find(s) for s in srcs]
        self.ast2_builder.enqueue_files(fs)
        self.ast2_builder.process_all()

        if check_errors:
            self.assertEqual([], self.error_handler.caught_errors)


class TestASTJSONCases(LibSolidityTestBase, SnapshotTestCase):
    SRC_DIR = 'testcases/libsolidity/ASTJSON'
    SPLIT_CASES = [
        'ast_internal_function_different_ids_export.sol',
        'ast_internal_function_id_export.sol',
        'documentation.sol'
    ]
    FAILURE_CASES = [
        'fail_after_parsing.sol',
        'not_existing_import.sol'
    ]

    def __init__(self, *args, **kwargs):
        self.maxDiff = None
        super().__init__(self.SRC_DIR, *args, **kwargs)

    @parameterized.expand(
        get_test_cases(
            SRC_DIR,
            SPLIT_CASES + FAILURE_CASES
        ),
        name_func=test_case_namer
    )
    def test_success_path(self, file):
        self._load(str(file.absolute().relative_to(Path(self.vfs.base_path).absolute())), check_errors=True)

        if not self.error_handler.caught_errors:
            units = self.ast2_builder.get_top_level_units()
            self.assertMatchSnapshot(units)

    # @parameterized.expand(
    #     get_test_cases_only(
    #         SRC_DIR,
    #         FAILURE_CASES
    #     ),
    #     name_func=test_case_namer
    # )
    # def test_failure_path(self, file):
    #     self.error_handler.quiet_errors = True
    #     self._load(str(file.absolute().relative_to(Path(self.vfs.base_path).absolute())), check_errors=False)
    #
    #     if not self.error_handler.caught_errors:
    #         self.fail(f"Expected errors but parsing succeeded: {file}")
    #     else:
    #         self.assertMatchSnapshot([e.args[0] for e in self.error_handler.caught_errors])


class TestSemanticTestCases(LibSolidityTestBase, SnapshotTestCase):
    SRC_DIR = 'testcases/libsolidity/semanticTests'
    def __init__(self, *args, **kwargs):
        super().__init__(self.SRC_DIR, *args, **kwargs)

        self.snapshot_should_update = True

    @parameterized.expand(
        get_test_cases(
            SRC_DIR,
            [
                # need to split
                'abiEncoderV2/abi_encode_v2_in_function_inherited_in_v1_contract.sol',
                'abiEncoderV2/abi_encode_v2_in_modifier_used_in_v1_contract.sol',
                "modifiers/access_through_module_name.sol",
                "externalContracts/base64.sol",
                "inlineAssembly/basefee_berlin_function.sol",
                "multiSource/circular_import_2.sol",
                "multiSource/circular_import.sol",
                "multiSource/circular_reimport_2.sol",
                "multiSource/circular_reimport.sol",
                "constants/constants_at_file_level_referencing.sol",
                "functionCall/file_level_call_via_module.sol",
                "multiSource/free_different_interger_types.sol",
                "multiSource/free_function_resolution_base_contract.sol",
                "multiSource/free_function_resolution_override_virtual.sol",
                "multiSource/free_function_resolution_override_virtual_super.sol",
                "multiSource/free_function_resolution_override_virtual_transitive.sol",
                "multiSource/free_function_transitive_import.sol",
                "multiSource/import_overloaded_function.sol",
                "multiSource/import.sol",
                "multiSource/imported_free_function_via_alias_direct_call.sol",
                "multiSource/imported_free_function_via_alias.sol",
                "using/imported_functions.sol",
                "libraries/library_address_via_module.sol",
                "using/library_through_module.sol",
                "inheritance/member_notation_ctor.sol",
                "expressions/module_from_ternary_expression.sol",
                "deployedCodeExclusion/module_function_deployed.sol",
                "deployedCodeExclusion/module_function.sol",
                "using/module_renamed.sol",
                "externalSource/multiple_equals_signs.sol",
                "externalSource/multiple_external_source.sol",
                "userDefinedValueType/multisource_module.sol",
                "userDefinedValueType/multisource.sol",
                "externalSource/non_normalized_paths.sol",
                "errors/panic_via_import.sol",
                "externalContracts/prbmath_signed.sol",
                "externalContracts/prbmath_unsigned.sol",
                "externalContracts/ramanujan_pi.sol",
                "using/recursive_import.sol",
                "multiSource/reimport_imported_function.sol",
                "externalSource/relative_imports.sol",
                "constants/same_constants_different_files.sol",
                "externalSource/source_import.sol",
                "externalSource/source_import_subdir.sol",
                "externalSource/source_name_starting_with_dots.sol",
                "externalSource/source_remapping.sol",
                "externalSource/source.sol",
                "functionTypes/stack_height_check_on_adding_gas_variable_to_function.sol",
                "experimental/type_class.sol",
                "using/using_global_all_the_types.sol",
                "using/using_global_for_global.sol",
                "using/using_global_invisible.sol",
                "using/using_global_library.sol",
                "errors/via_import.sol",
                # not real solidity
                "experimental/stub.sol",
                "experimental/type_class.sol",
                # import errors
                "externalContracts/strings.sol",
                "externalSource/_external/import.sol",
                "externalSource/_external/subdir/import.sol",
                # broken,

                "modifiers/access_through_contract_name.sol",  # issues/24
                "functionTypes/address_member.sol",  # issues/25
                "operators/userDefined/all_possible_user_defined_value_types_with_operators.sol",  # issues/26
                # "array/array_function_pointers.sol",
                "array/copying/array_nested_storage_to_memory.sol",  # issues/27
                # "array/pop/array_pop_isolated.sol",
                "array/array_push_return_reference.sol",  # issues/28
                "underscore/as_function.sol",
                "inheritance/base_access_to_function_type_variables.sol",
                "state/blobhash.sol",
                "state/block_blobbasefee.sol",
                "state/block_prevrandao_pre_paris.sol",
                "state/block_prevrandao.sol",
                "deployedCodeExclusion/bound_function.sol",
                "array/pop/byte_array_pop_isolated.sol",
                "functionCall/call_attached_library_function_on_function.sol",
                "functionCall/call_attached_library_function_on_storage_variable.sol",
                "functionCall/call_function_returning_function.sol",
                "functionCall/call_internal_function_via_expression.sol",
                "functionCall/call_internal_function_with_multislot_arguments_via_pointer.sol",
                "functionTypes/call_to_zero_initialized_function_type_ir.sol",
                "functionTypes/call_to_zero_initialized_function_type_legacy.sol",
                "abiEncoderV2/calldata_array_function_types.sol",
                "calldata/calldata_array_index_range_access.sol",
                "calldata/calldata_attached_to_static_array.sol",
                "calldata/calldata_internal_function_pointer.sol",
                "functionCall/calling_uninitialized_function_in_detail.sol",
                "functionCall/calling_uninitialized_function_through_array.sol",
                "various/code_access_content.sol",
                "functionCall/conditional_with_arguments.sol",
                "array/copying/copy_function_internal_storage_array.sol",
                "array/copying/copy_internal_function_array_to_storage.sol",
                "viaYul/copy_struct_invalid_ir_bug.sol",
                "various/crazy_elementary_typenames_on_stack.sol",
                "errors/error_selector.sol",
                "viaYul/conversion/explicit_cast_function_call.sol",
                "inlineAssembly/external_function_pointer_address_assignment.sol",
                "inlineAssembly/external_function_pointer_address.sol",
                "types/external_function_to_address.sol",
                "functionCall/failed_create.sol",
                "using/free_functions_individual.sol",
                "viaYul/function_address.sol",
                "array/function_array_cross_calls.sol",
                "viaYul/conversion/function_cast.sol",
                "functionTypes/function_delete_storage.sol",
                "functionTypes/function_external_delete_storage.sol",
                "array/function_memory_array.sol",
                "modifiers/function_modifier_library_inheritance.sol",
                "modifiers/function_modifier_library.sol",
                "viaYul/function_pointers.sol",
                "conversions/function_type_array_to_storage.sol",
                "builtinFunctions/function_types_sig.sol",
                "freeFunctions/import.sol",
                "externalSource/_external/import_with_subdir.sol",
                "userDefinedValueType/in_parenthesis.sol",
                "functionTypes/inline_array_with_value_call_option.sol",
                "libraries/internal_call_attached_with_parentheses.sol",
                "libraries/internal_call_unattached_with_parentheses.sol",
                "immutable/internal_function_pointer.sol",
                "libraries/internal_library_function_attached_to_fixed_array.sol",
                "libraries/internal_library_function_attached_to_internal_function_type_named_selector.sol",
                "libraries/internal_library_function_attached_to_literal.sol",
                "uninitializedFunctionPointer/invalidStoredInConstructor.sol",
                "various/iszero_bnot_correct.sol",
                "libraries/library_address_homestead.sol",
                "libraries/library_address.sol",
                "libraries/library_delegatecall_guard_pure.sol",
                "libraries/library_delegatecall_guard_view_needed.sol",
                "libraries/library_delegatecall_guard_view_not_needed.sol",
                "libraries/library_delegatecall_guard_view_staticcall.sol",
                "libraries/library_enum_as_an_expression.sol",
                "deployedCodeExclusion/library_function_deployed.sol",
                "libraries/library_function_selectors.sol",
                "libraries/library_function_selectors_struct.sol",
                "revertStrings/library_non_view_call.sol",
                "using/library_on_interface.sol",
                "libraries/library_stray_values.sol",
                "libraries/library_struct_as_an_expression.sol",
                "structs/lone_struct_array_type.sol",
                "tryCatch/lowLevel.sol",
                "functionTypes/mapping_of_functions.sol",
                "immutable/multiple_initializations.sol",
                "structs/multislot_struct_allocation.sol",
                "externalSource/multisource.sol",
                "errors/named_parameters_shadowing_types.sol",
                "constantEvaluator/negative_fractional_mod.sol",
                "tryCatch/nested.sol",
                "types/nested_tuples.sol",
                "storage/packed_functions.sol",
                "tryCatch/panic.sol",
                "array/pop/parenthesized.sol",
                "array/push/push_no_args_1d.sol",
                "array/push/push_no_args_2d.sol",
                "array/push/push_no_args_bytes.sol",
                "functionTypes/selector_assignment_expression.sol",
                "functionTypes/selector_ternary_function_pointer_from_function_call.sol",
                "functionTypes/selector_ternary.sol",
                "externalContracts/snark.sol",
                "various/state_variable_local_variable_mixture.sol",
                "various/state_variable_under_contract_name.sol",
                "deployedCodeExclusion/static_base_function_deployed.sol",
                "uninitializedFunctionPointer/store2.sol",
                "uninitializedFunctionPointer/storeInConstructor.sol",
                "constructor/store_function_in_constructor_packed.sol",
                "constructor/store_function_in_constructor.sol",
                "functionTypes/store_function.sol",
                "constructor/store_internal_unused_function_in_constructor.sol",
                "constructor/store_internal_unused_library_function_in_constructor.sol",
                "abiEncoderV2/struct/struct_function.sol",
                "structs/struct_memory_to_storage_function_ptr.sol",
                "structs/struct_storage_to_memory_function_ptr.sol",
                "functionTypes/struct_with_external_function.sol",
                "functionTypes/struct_with_functions.sol",
                "tryCatch/structuredAndLowLevel.sol",
                "tryCatch/structured.sol",
                "deployedCodeExclusion/super_function_deployed.sol",
                "inheritance/super_in_constructor_assignment.sol",
                "various/super_parentheses.sol",
                "functionTypes/ternary_contract_internal_function.sol",
                "functionTypes/ternary_contract_library_internal_function.sol",
                "functionTypes/ternary_contract_public_function.sol",
                "revertStrings/transfer.sol",
                "types/tuple_assign_multi_slot_grow.sol",
                "expressions/tuple_from_ternary_expression.sol",
                "expressions/uncalled_address_transfer_send.sol",
                "state/uncalled_blobhash.sol",
                "state/uncalled_blockhash.sol",
                "functionTypes/uninitialized_internal_storage_function_call.sol",
                "errors/using_structs.sol",
                "inheritance/value_for_constructor.sol",
                "deployedCodeExclusion/virtual_function_deployed.sol",
                "userDefinedValueType/wrap_unwrap.sol",
            ]
        ),
        name_func=test_case_namer2(SRC_DIR)
    )
    def test_success_path(self, file):
        self._load(str(file.absolute().relative_to(Path(self.vfs.base_path).absolute())), check_errors=True)

        if not self.error_handler.caught_errors:
            units = self.ast2_builder.get_top_level_units()
            self.assertMatchSnapshot(units)

    def test_debug(self):
        register_solnodes2_formatter()
        self._load('libraries/internal_library_function_attached_to_array_named_pop_push.sol')
        units = self.ast2_builder.get_top_level_units()
        self.assertMatchSnapshot(units)

        print("x")
