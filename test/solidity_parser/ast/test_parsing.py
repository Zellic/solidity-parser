import unittest
from parameterized import parameterized
import re
import os

from pathlib import Path

from solidity_parser import filesys, errors
from solidity_parser.util.version_util import Version
from solidity_parser.ast import symtab, ast2builder, solnodes, solnodes2


def get_ast_json_case_name(testcase_func, param_num, param):
    file = param[0][0]
    return "%s_%s" %(
        testcase_func.__name__,
        parameterized.to_safe_name(file.name),
    )


def get_ast_json_test_cases():
    exclusions = [
        # needs to be split, see test_ast_internal_function_different_ids_export
        'ast_internal_function_different_ids_export.sol',
        'documentation.sol',  # same
        'fail_after_parsing.sol',  # shouldn't pass ast2
        'not_existing_import.sol',  #
        'ast_internal_function_id_export.sol'  # actually broken
    ]

    base_dir = Path(os.getcwd()) / 'testcases/libsolidity/ASTJSON'
    return [(p, ) for p in Path(base_dir).iterdir() if str(p).endswith('.sol') and p.name not in exclusions]


class TestParsing(unittest.TestCase):
    def setUp(self) -> None:
        self.vfs = filesys.VirtualFileSystem('testcases/libsolidity/ASTJSON', compiler_version=Version(0, 8, 22))
        self.symtab_builder = symtab.Builder2(self.vfs)
        self.ast2_builder = ast2builder.Builder()

    def _load(self, *files):
        fs = [self.symtab_builder.process_or_find_from_base_dir(f) for f in files]
        self.ast2_builder.enqueue_files(fs)
        self.ast2_builder.process_all()

    @parameterized.expand(get_ast_json_test_cases, name_func=get_ast_json_case_name)
    def test_success_path(self, file):
        self._load(str(file.absolute().relative_to(Path(self.vfs.base_path).absolute())))
        self.assertEquals([], self.ast2_builder.code_errors)

    @unittest.skip("FIXME")
    def test_ast_internal_function_different_ids_export(self):
        # TODO: actual broken test
        txt = Path(self.vfs.base_path + '/ast_internal_function_different_ids_export.sol').read_text()

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

        self.assertEquals([], self.ast2_builder.code_errors)

