from dataclasses import dataclass
from pathlib import Path
from typing import List, Dict, Optional, Union, Callable
from collections import namedtuple
from solidity_parser.ast import solnodes
from solidity_parser.ast import helper as ast_helper

import os
import logging
import jsons


@dataclass
class Source:
    # keccak256: Optional[str]
    urls: Optional[List[str]]
    content: str


@dataclass
class StandardJsonInput:
    # language: str # 'Solidity'
    sources: Dict[str, Source]  # source unit name -> source
    # settings, not required for now


@dataclass
class LoadedSource:
    source_unit_name: str
    contents: str
    ast_creator_callback: Optional[Callable[[str], List[solnodes.SourceUnit]]]

    @property
    def ast(self) -> List[solnodes.SourceUnit]:
        # Mechanism for creating the AST on demand and caching it
        if not hasattr(self, '_ast'):
            logging.getLogger('VFS').info(f'Parsing {self.source_unit_name}')

            if not self.ast_creator_callback:
                creator = ast_helper.make_ast
            else:
                creator = self.ast_creator_callback

            self._ast = creator(self.contents)
        return self._ast


ImportMapping = namedtuple('ImportMapping', ['context', 'prefix', 'target'])


class VirtualFileSystem:
    def __init__(self, base_path: str, cwd: str = None, include_paths: List[str] = None):
        if cwd is None:
            cwd = os.getcwd()
        self.cwd = cwd

        self.base_path = self._norm_vfs_path(base_path)

        if include_paths is None:
            include_paths = []
        self.include_paths = include_paths

        self.import_remaps: List[ImportMapping] = []

        self.sources: Dict[str, LoadedSource] = {}

    @property
    def include_paths(self):
        return self._include_paths

    @include_paths.setter
    def include_paths(self, value):
        self._include_paths = [self._norm_vfs_path(p) for p in value]

    def process_cli_input_file(self, file_path):
        # CLI load method
        source_unit_name = self._cli_path_to_source_name(file_path)
        src_code = self._read_file(file_path)
        self._add_loaded_source(source_unit_name, src_code)

    def process_standard_json(self, path: str):
        json_content = self._read_file(path)
        standard_input = jsons.loads(json_content, StandardJsonInput)

        for (source_unit_name, source) in standard_input.sources.items():
            self._add_loaded_source(source_unit_name, source.content)

    def add_import_remapping(self, context, prefix, target):
        self.import_remaps.append(ImportMapping(context, prefix, target))

    def lookup_import_path(self, import_path: str, importer_source_unit_name: str = None) -> LoadedSource:
        import_source_name = self._compute_source_unit_name(import_path, importer_source_unit_name)

        if import_source_name in self.sources:
            return self.sources[import_source_name]

        # When the source is not available in the virtual filesystem, the compiler passes the source unit name to the
        # import callback. The Host Filesystem Loader will attempt to use it as a path and look up the file on disk.
        contents = self._read_file_callback(import_source_name, self.base_path, self.include_paths)

        if contents:
            loaded_source = self._add_loaded_source(import_source_name, contents)
            if loaded_source:
                return loaded_source

        raise f"Can't import {import_path} from {importer_source_unit_name}"

    def _add_loaded_source(self, source_unit_name: str, source_code: str, creator=None) -> LoadedSource:
        loaded_source = LoadedSource(source_unit_name, source_code, creator if creator else ast_helper.make_ast)
        self.sources[source_unit_name] = loaded_source
        return loaded_source

    def _read_file(self, path: str, is_cli_path=True) -> str:
        # A path that was input from the command line has a CWD. This VFS can simulate being run from another CWD
        # so if required, we can use the supplied CWD as the base for relative file references
        if is_cli_path and VirtualFileSystem._is_relative_import(path):
            path = Path(self.cwd, path)
        else:
            path = Path(path)
        path = path.resolve(strict=True)

        logging.getLogger('VFS').info(f'Reading {path}')

        with path.open(mode='r', encoding='utf-8') as f:
            return f.read()

    def _cli_path_to_source_name(self, input_file_path) -> str:
        """Computes the source name for a source file supplied via command line invocation of solc"""
        norm_path: Union[str, Path] = self._norm_vfs_path(input_file_path)
        prefixes = [self.base_path] + self.include_paths

        for prefix in prefixes:
            # make the path relative to the prefix
            stripped_path = self._strip_prefix(prefix, norm_path)
            if stripped_path is not None:
                norm_path = stripped_path
                break

        return self._path_to_generic_string(norm_path)

    def _norm_vfs_path(self, path: Union[str, Path]) -> str:
        """Path normalisation according to solidity lang docs"""
        normp = Path(self.cwd, path).resolve(strict=False)

        normp2 = self._path_to_generic_string(normp)
        # remove the drive on windows if possible (only if the cwd is on the same drive as the path)
        if normp.drive == Path(self.cwd).drive:
            normp2 = normp2[len(normp.drive):]

        return normp2

    def _read_file_callback(self, su_name: str, base_dir: str, include_paths: List[str]) -> str:
        # import callback
        su_norm = su_name
        if su_norm.startswith('file://'):
            su_norm = su_norm[7:]

        prefixes = [base_dir] + include_paths
        candidates = []

        for prefix in prefixes:
            possible_path = Path(prefix, su_norm)
            canonical_path = self._norm_vfs_path(possible_path)
            if os.path.exists(canonical_path):
                candidates.append(canonical_path)

        if len(candidates) == 0:
            raise ValueError(f'No file found: {su_name}')
        elif len(candidates) > 1:
            raise ValueError(f'Multiple candidates found for {su_name}: {candidates}')

        # TODO: allowed directory check

        contents = self._read_file(candidates[0], is_cli_path=False)
        return contents

    def _remap_import(self, source_unit_name: str, importer_source_unit_name: str) -> str:
        """Takes a source unit name and checks if it should be remapped
        Note: do not pass an import path as the source unit name
        """
        for mapping in self.import_remaps:
            # context must match the beginning of the source unit name of the file containing the import
            if mapping.context and not importer_source_unit_name.startswith(mapping.context):
                continue

            # prefix must match the beginning of the source unit name resulting from the import
            if source_unit_name.startswith(mapping.prefix):
                # target is the value the prefix is replaced with
                return self._clean_path([mapping.target, source_unit_name[len(mapping.prefix):]])

        return source_unit_name

    def _compute_source_unit_name(self, path: str, importer_source_unit_name: str) -> str:
        if not self._is_relative_import(path):
            return self._remap_import(path, importer_source_unit_name)

        # Prefix is initialized with the source unit name of the importing source unit.
        # The last path segment with preceding slashes is removed from the prefix.
        prefix = self._remove_last_path_segment(importer_source_unit_name)

        # Then, the leading part of the normalized import path, consisting only of / and . characters is considered.
        # For every .. segment found in this part the last path segment with preceding slashes is removed from
        # the prefix.

        import_path_index = 0
        import_path_length = len(path)

        def char(i: int) -> str:
            return path[i] if i < import_path_length else None

        def assert_segment_end(i: int) -> None:
            c = char(i)
            assert c == '/' or c is None

        while import_path_index < import_path_length:
            if char(import_path_index) == '.':
                if char(import_path_index+1) == '.':
                    # saw .. so remove one segment from the prefix
                    prefix = self._remove_last_path_segment(prefix)
                    assert_segment_end(import_path_index+2)
                    import_path_index += 3  # .. and /
                else:
                    # saw . so keep the prefix where it is
                    assert_segment_end(import_path_index+1)
                    import_path_index += 2  # . and /
            else:
                break  # found first segment that is not a relative one

        # Then the prefix is prepended to the normalized import path. If the prefix is non-empty, a single slash is
        # inserted between it and the import path.

        import_path = path[import_path_index:]
        normalised_import_path = os.path.normpath(import_path).replace('\\', '/')

        if len(prefix) > 0:
            base_source_name = f'{prefix}/{normalised_import_path}'
        else:
            base_source_name = normalised_import_path

        return self._remap_import(base_source_name, importer_source_unit_name)

    @staticmethod
    def _path_to_generic_string(path: Union[Path, str]) -> str:
        if isinstance(path, Path):
            path = str(path).replace('\\', '/')
        return path

    @staticmethod
    def _clean_path(*parts: List[str]) -> str:
        return os.path.join(*parts).replace('\\', '/')

    @staticmethod
    def _strip_prefix(prefix, path) -> Optional[Path]:
        # these both need to be absolute paths and normalised
        try:
            return Path(path).relative_to(prefix)
        except ValueError:
            return None

    @staticmethod
    def _remove_last_path_segment(path: str) -> str:
        last_slash_index = path.rfind('/')
        if last_slash_index != -1:
            path = path[:last_slash_index]
        else:
            # we're on the last segment of the path, so it's empty now
            return ''
        return path.rstrip('/')

    @staticmethod
    def _is_relative_import(path: str) -> bool:
        # Relative imports always start with ./ or ../ so import "util.sol", unlike import "./util.sol", is a direct
        # import. While both paths would be considered relative in the host filesystem, util.sol is actually absolute
        # in the VFS.
        return path[0] == '.'
