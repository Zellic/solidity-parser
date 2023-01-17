from abc import ABC, abstractmethod
from dataclasses import dataclass
from pathlib import Path
from typing import Generator, List
from collections import namedtuple

import os
import logging


@dataclass
class LoadedFile:
    source_unit_name: str
    contents: str


# class ImportCallback(ABC):
#     @abstractmethod
#     def get_file(self, path: str) -> LoadedFile:
#         pass


class HostFileSystemLoader():
    def get_file(self, path: str, base_dir: str, include_paths: List[str]) -> LoadedFile:
        # From Solidity lang docs 0.8.17:
        # When the source is not available in the virtual filesystem, the compiler passes the source unit name to the
        # import callback. The Host Filesystem Loader will attempt to use it as a path and look up the file on disk.
        # At this point the platform-specific normalization rules kick in and names that were considered different in
        # the VFS may actually result in the same file being loaded.
        # For example /project/lib/math.sol and /project/lib/../lib///math.sol are considered completely different in
        # the VFS even though they refer to the same file on disk.
        try:
            p = Path(path).resolve(strict=True)
            # Even if an import callback ends up loading source code for two different source unit names from the same
            # file on disk, the compiler will still see them as separate source units. It is the source unit name that
            # matters, not the physical location of the code.
            # TODO: return
            # return LoadedFile(src, path)
            raise NotImplemented()
        except FileNotFoundError:
            logging.error(f'No file found during import callback: {path}')
            return None


ImportMapping = namedtuple('ImportMapping', ['context', 'prefix', 'target'])


class VirtualFileSystem:
    def __init__(self, base_path: str, file_finder: HostFileSystemLoader = None):
        self.base_path = base_path
        self.include_paths = []
        self.import_remaps: List[ImportMapping] = []

        if file_finder is None:
            file_finder = HostFileSystemLoader()
        self.file_finder = file_finder

        self.cache = {}

    def normalise_cli_path(self, path: str, cwd: str = None) -> str:
        if self.is_relative_import(path):
            if not cwd:
                raise ValueError('need current working directory for relative CLI path')
            else:
                absolute_path = os.path.join(cwd, path)

    def add_import_remapping(self, context, prefix, target):
        self.import_remaps.append(ImportMapping(context, prefix, target))

    def lookup_import(self, import_path: str, importer_source_unit_name: str = None):
        import_source_name = self.compute_source_unit_name(import_path, importer_source_unit_name)

        if import_source_name in self.cache:
            return self.cache[import_source_name]

        located_file = self.file_finder.get_file(import_path, self.base_path, self.include_paths)
        if located_file:
            self.cache[import_source_name] = located_file
            return located_file

        assert False, f"Can't import {import_path} from {importer_source_unit_name}"

    def remap_import(self, source_unit_name: str, importer_source_unit_name: str) -> str:
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
                return self.clean_path(mapping.target, source_unit_name[len(mapping.prefix):])

        return source_unit_name

    def compute_source_unit_name(self, path: str, importer_source_unit_name: str) -> str:
        if not self.is_relative_import(path):
            return self.remap_import(path, importer_source_unit_name)

        # Prefix is initialized with the source unit name of the importing source unit.
        # The last path segment with preceding slashes is removed from the prefix.
        prefix = self.remove_last_path_segment(importer_source_unit_name)

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
                    prefix = self.remove_last_path_segment(prefix)
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

        return self.remap_import(base_source_name, importer_source_unit_name)

    @staticmethod
    def clean_path(*parts: List[str]) -> str:
        return os.path.join(*parts).replace('\\', '/')

    @staticmethod
    def remove_last_path_segment(path: str) -> str:
        last_slash_index = path.rfind('/')
        if last_slash_index != -1:
            path = path[:last_slash_index]
        else:
            # we're on the last segment of the path, so it's empty now
            return ''
        return path.rstrip('/')


    @staticmethod
    def is_relative_import(path: str) -> bool:
        # Relative imports always start with ./ or ../ so import "util.sol", unlike import "./util.sol", is a direct
        # import. While both paths would be considered relative in the host filesystem, util.sol is actually absolute
        # in the VFS.
        return path[0] == '.'

    # def get_remapped_import_name(self, path: str):
