import unittest
from parameterized import parameterized
import mock

from solidity_parser import filesys


class TestVirtualFileSystem(unittest.TestCase):
    def setUp(self):
        self.vfs = filesys.VirtualFileSystem('')

    # The removal of the last path segment with preceding slashes is understood to work as follows:
    # 1. Everything past the last slash is removed (i.e. a/b//c.sol becomes a/b//).
    # 2. All trailing slashes are removed (i.e. a/b// becomes a/b).
    # Therefore if the path ends with a slash then it only cuts the slash off? - Are the docs wrong?
    @parameterized.expand([
        ['lib1', ''],
        # ['lib2/', ''],
        ['a/b/c', 'a/b'],
        ['d/e//f', 'd/e'],
        # ['/g/h/', '/g'],
        # ['/k/', ''],
        ['//l', '']
    ])
    def test_remove_last_path_segment(self, input, expected):
        result = filesys.VirtualFileSystem.remove_last_path_segment(input)
        self.assertEqual(expected, result)

    @parameterized.expand([
        # simple relative imports
        ['./math/math.sol', 'contracts/contract.sol', 'contracts/math/math.sol'],
        ['./util.sol', '/project/lib/math.sol', '/project/lib/util.sol'],
        ['../token.sol', '/project/lib/math.sol', '/project/token.sol'],
        ['./util.sol', 'lib/math.sol', 'lib/util.sol'],
        ['../token.sol', 'lib/math.sol', 'token.sol'],
        # simple direct imports
        ['contracts/tokens/token.sol', 'contracts/contract.sol', 'contracts/tokens/token.sol'],
        ['/project/lib/util.sol', None, '/project/lib/util.sol'],
        ['lib/util.sol', 'xyz', 'lib/util.sol'],
        # complicated examples from soliditylang docs
        ['./util/./util.sol', 'lib/src/../contract.sol', 'lib/src/../util/util.sol'],
        ['./util//util.sol', 'lib/src/../contract.sol', 'lib/src/../util/util.sol'],
        ['../util/../array/util.sol', 'lib/src/../contract.sol', 'lib/src/array/util.sol'],
        ['../.././../util.sol', 'lib/src/../contract.sol', 'util.sol'],
        ['../../.././../util.sol', 'lib/src/../contract.sol', 'util.sol']
    ])
    def test_compute_source_unit_name(self, path, importer, expected):
        result = self.vfs.compute_source_unit_name(path, importer)
        self.assertEqual(expected, result)

    def test_remap_import(self):
        self.vfs.add_import_remapping(None, 'github.com/ethereum/dapp-bin/', 'dapp-bin/')
        result = self.vfs.remap_import('github.com/ethereum/dapp-bin/library/math.sol', None)
        self.assertEqual('dapp-bin/library/math.sol', result)

    def test_remap_for_source_unit_name(self):
        self.vfs.add_import_remapping(None, './', 'a/')  # won't work because dots are replaced first during translation
        self.vfs.add_import_remapping(None, '/project/', 'b')
        # /project/contract.sol is added via CLI and imports './util.sol' as util

        result = self.vfs.compute_source_unit_name('./util.sol', '/project/contract.sol')
        self.assertEqual('b/util.sol', result)

    def test_lookup_import_calls_import_callback(self):
        self.vfs.base_path = 'base'
        self.vfs.include_paths = ['include_path']

        get_file_mock = mock.MagicMock(return_value='ye')
        self.vfs.file_finder.get_file = get_file_mock

        self.vfs.lookup_import('./util.sol', '/project/contract.sol')

        get_file_mock.assert_called_once_with('./util.sol', 'base', ['include_path'])

    def test_lookup_import_from_cache(self):
        get_file_mock = mock.MagicMock()
        self.vfs.file_finder.get_file = get_file_mock
        self.vfs.cache['/project/util.sol'] = 'ye'

        self.vfs.lookup_import('./util.sol', '/project/contract.sol')

        get_file_mock.assert_not_called()


