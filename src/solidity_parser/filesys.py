from dataclasses import dataclass
from pathlib import Path
from typing import List, Dict, Optional, Union, Callable, Tuple
from collections import namedtuple
from solidity_parser.ast import solnodes
from solidity_parser.ast import helper as ast_helper
from solidity_parser.util.version_util import Version

import os
import logging
import jsons
from functools import partial


@dataclass
class Source:
    """ Structure of a source unit defined in the standard JSON input """

    # keccak256: Optional[str]
    urls: Optional[List[str]]
    content: str


@dataclass
class StandardJsonInput:
    """
    Solidity standard JSON input see:
    https://docs.soliditylang.org/en/v0.8.25/using-the-compiler.html#compiler-api
    """

    # language: str # 'Solidity'
    sources: Dict[str, Source]  # source unit name -> source
    # settings, not required for now


@dataclass
class LoadedSource:
    """
    Source unit loaded inside the virtual filesystem
    """

    source_unit_name: str
    """ The computed source unit name, see the solidity docs for how this is computed """
    contents: str
    """ Source code """
    origin: Optional[Path]
    """ Path to the source unit on disk, if it was loaded from disk """
    ast_creator_callback: Optional[Callable[[str], List[solnodes.SourceUnit]]]
    """ Optional function for changing the AST creation method, e.g. for testing and forcing the parser version """

    @property
    def ast(self) -> List[solnodes.SourceUnit]:
        """ Property for getting the AST from the source code lazily """
        if not hasattr(self, '_ast'):
            logging.getLogger('VFS').debug(f'Parsing {self.source_unit_name}')
            creator = self.ast_creator_callback
            self._ast = creator(self.contents)
        return self._ast


ImportMapping = namedtuple('ImportMapping', ['context', 'prefix', 'target'])
""" An import remapping for changing the source unit name before the import is resolved """


class VirtualFileSystem:
    """
    This is the "virtual file system" defined in the Solidity docs and implemented in solc. The idea is to abstract
    away the specifics of how the sources are stored, such as on disk or in memory and the paths used in the source
    files to resolve imports. The code is not ideal but it emulates the behaviour of the c++ code of solc.

    https://docs.soliditylang.org/en/v0.8.17/path-resolution.html
    """

    def __init__(self, base_path: str | Path,
                 cwd: str | Path = None,
                 include_paths: List[str | Path] = None,
                 compiler_version: Version = None):
        """
        :param base_path: Project base path (e.g. the directory containing all project files)
        :param cwd: Current working directory(e.g. invocation directory of solc)
        :param include_paths: List of paths of libraries and source folders
        :param compiler_version: Version of the parser to use, if not specified, the version in source files will be used
        """
        if cwd is None:
            cwd = os.getcwd()
        self.cwd = cwd

        self.base_path = base_path

        if include_paths is None:
            include_paths = []
        self.include_paths = include_paths

        self.import_remaps: List[ImportMapping] = []

        self.sources: Dict[str, LoadedSource] = {}
        self.origin_sources: Dict[str, LoadedSource] = {}

        self.compiler_version = compiler_version

    @property
    def base_path(self):
        return self._base_path

    @base_path.setter
    def base_path(self, value):
        self._base_path = self._norm_vfs_path(value)

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
        return self._add_loaded_source(source_unit_name, src_code, origin='[CLI]:'+file_path)

    def process_standard_json(self, path: str):
        json_content = self._read_file(path)
        standard_input = jsons.loads(json_content, StandardJsonInput)

        for (source_unit_name, source) in standard_input.sources.items():
            self._add_loaded_source(source_unit_name, source.content, origin='[STD]:'+source_unit_name)

    def parse_import_remappings(self, remappings_file_path):
        with open(remappings_file_path, encoding='utf-8') as f:
            lines = f.read().splitlines()

        def raise_invalid_format(txt):
            raise ValueError(f'Invalid remapping syntax, expected: <context>?:<prefix>=<target>, got: {txt}')

        for line in lines:
            split1 = line.split(':')

            if len(split1) == 2:
                context = split1[0]
            elif len(split1) != 1:
                return raise_invalid_format()
            else:
                context = ''

            split2 = split1[-1].split('=')

            if len(split2) != 2:
                return raise_invalid_format()

            self.add_import_remapping(context, split2[0], split2[1])

    def add_import_remapping(self, context, prefix, target):
        self.import_remaps.append(ImportMapping(context, prefix, target))

    def lookup_import_path(self, import_path: str, importer_source_unit_name: str = None) -> LoadedSource:
        import_source_unit_names = self._compute_possible_source_unit_names(import_path, importer_source_unit_name)

        for source_unit_name in import_source_unit_names:
            if source_unit_name in self.sources:
                return self.sources[source_unit_name]

            logging.getLogger('VFS').debug(f'Possible Import path {import_path} in {importer_source_unit_name} => {source_unit_name}')

            # "When the source is not available in the virtual filesystem, the compiler passes the source unit name to the
            # import callback. The Host Filesystem Loader will attempt to use it as a path and look up the file on disk."
            try:
                origin, contents = self._read_file_callback(source_unit_name, self._base_path, self.include_paths)
            except ValueError:
                # thrown if the callback fails, try the next source unit name
                continue

            if contents:
                loaded_source = self._add_loaded_source(source_unit_name, contents, origin=origin)
                if loaded_source:
                    return loaded_source

        raise ValueError(f"Can't import {import_path} from {importer_source_unit_name}")

    def _add_loaded_source(self, source_unit_name: str, source_code: str, creator=None, origin=None) -> LoadedSource:
        if source_unit_name in self.sources:
            raise ValueError(f'{source_unit_name} has already been loaded in VFS')

        if origin in self.origin_sources:
            raise ValueError(f'{origin}({source_unit_name}) has already been loaded as {self.origin_sources[origin].source_unit_name}')

        basic_creator = creator if creator else ast_helper.make_ast
        creator_options = {
            'origin': origin
        }
        if self.compiler_version:
            creator_options['version'] = self.compiler_version
        partial_creator = partial(basic_creator, **creator_options)

        loaded_source = LoadedSource(source_unit_name, source_code, origin, partial_creator)

        self.origin_sources[origin] = loaded_source
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

        logging.getLogger('VFS').debug(f'Reading {path}')

        return self._do_read_path(path)

    def _do_read_path(self, path: Path) -> str:
        with path.open(mode='r', encoding='utf-8') as f:
            return f.read()

    def _cli_path_to_source_name(self, input_file_path) -> str:
        """Computes the source name for a source file supplied via command line invocation of solc"""
        norm_path: Union[str, Path] = self._norm_vfs_path(input_file_path)
        prefixes = [self._base_path] + self.include_paths

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

    def _read_file_callback(self, su_name: str, base_dir: str, include_paths: List[str]) -> Tuple[str, str]:
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
        return candidates[0], contents

    def _remap_import(self, source_unit_name: str, importer_source_unit_name: str) -> list[str]:
        """Takes a source unit name and checks if it should be remapped
        Note: do not pass an import path as the source unit name
        """

        possible_remappings = []

        for mapping in self.import_remaps:
            # context must match the beginning of the source unit name of the file containing the import
            if mapping.context and not importer_source_unit_name.startswith(mapping.context):
                continue

            # prefix must match the beginning of the source unit name resulting from the import
            if source_unit_name.startswith(mapping.prefix):
                # target is the value the prefix is replaced with
                possible_remappings.append(self._clean_path(mapping.target, source_unit_name[len(mapping.prefix):]))

        if not possible_remappings:
            return [source_unit_name]
        else:
            return possible_remappings

    def _compute_possible_source_unit_names(self, path: str, importer_source_unit_name: str) -> list[str]:
        """
        Computes a list of possible source unit names for an import path. Usually there is only 1, but if there are
        multiple matching import remappings, we have to test each one later on when the file lookup happens
        """

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
