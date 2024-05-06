:py:mod:`solidity_parser.filesys`
=================================

.. py:module:: solidity_parser.filesys


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.filesys.Source
   solidity_parser.filesys.StandardJsonInput
   solidity_parser.filesys.LoadedSource
   solidity_parser.filesys.VirtualFileSystem




Attributes
~~~~~~~~~~

.. autoapisummary::

   solidity_parser.filesys.ImportMapping


.. py:class:: Source


   Structure of a source unit defined in the standard JSON input 

   .. py:attribute:: urls
      :type: Optional[List[str]]

      

   .. py:attribute:: content
      :type: str

      


.. py:class:: StandardJsonInput


   Solidity standard JSON input see:
   https://docs.soliditylang.org/en/v0.8.25/using-the-compiler.html#compiler-api

   .. py:attribute:: sources
      :type: Dict[str, Source]

      


.. py:class:: LoadedSource


   Source unit loaded inside the virtual filesystem

   .. py:property:: ast
      :type: List[solidity_parser.ast.solnodes.SourceUnit]

      Property for getting the AST from the source code lazily 


   .. py:attribute:: source_unit_name
      :type: str

      The computed source unit name, see the solidity docs for how this is computed 


   .. py:attribute:: contents
      :type: str

      Source code 


   .. py:attribute:: origin
      :type: Optional[pathlib.Path]

      Path to the source unit on disk, if it was loaded from disk 


   .. py:attribute:: ast_creator_callback
      :type: Optional[Callable[[str], List[solidity_parser.ast.solnodes.SourceUnit]]]

      Optional function for changing the AST creation method, e.g. for testing and forcing the parser version 



.. py:data:: ImportMapping

   An import remapping for changing the source unit name before the import is resolved 


.. py:class:: VirtualFileSystem(base_path: str | pathlib.Path, cwd: str | pathlib.Path = None, include_paths: List[str | pathlib.Path] = None, compiler_version: solidity_parser.util.version_util.Version = None)


   This is the "virtual file system" defined in the Solidity docs and implemented in solc. The idea is to abstract
   away the specifics of how the sources are stored, such as on disk or in memory and the paths used in the source
   files to resolve imports. The code is not ideal but it emulates the behaviour of the c++ code of solc.

   https://docs.soliditylang.org/en/v0.8.17/path-resolution.html

   .. py:property:: base_path


   .. py:property:: include_paths


   .. py:method:: process_cli_input_file(file_path)


   .. py:method:: process_standard_json(path: str)


   .. py:method:: parse_import_remappings(remappings_file_path)


   .. py:method:: add_import_remapping(context, prefix, target)


   .. py:method:: lookup_import_path(import_path: str, importer_source_unit_name: str = None) -> LoadedSource


   .. py:method:: _add_loaded_source(source_unit_name: str, source_code: str, creator=None, origin=None) -> LoadedSource


   .. py:method:: _read_file(path: str, is_cli_path=True) -> str


   .. py:method:: _do_read_path(path: pathlib.Path) -> str


   .. py:method:: _cli_path_to_source_name(input_file_path) -> str

      Computes the source name for a source file supplied via command line invocation of solc


   .. py:method:: _norm_vfs_path(path: Union[str, pathlib.Path]) -> str

      Path normalisation according to solidity lang docs


   .. py:method:: _read_file_callback(su_name: str, base_dir: str, include_paths: List[str]) -> Tuple[str, str]


   .. py:method:: _remap_import(source_unit_name: str, importer_source_unit_name: str) -> str

      Takes a source unit name and checks if it should be remapped
      Note: do not pass an import path as the source unit name


   .. py:method:: _compute_source_unit_name(path: str, importer_source_unit_name: str) -> str


   .. py:method:: _path_to_generic_string(path: Union[pathlib.Path, str]) -> str
      :staticmethod:


   .. py:method:: _clean_path(*parts: List[str]) -> str
      :staticmethod:


   .. py:method:: _strip_prefix(prefix, path) -> Optional[pathlib.Path]
      :staticmethod:


   .. py:method:: _remove_last_path_segment(path: str) -> str
      :staticmethod:


   .. py:method:: _is_relative_import(path: str) -> bool
      :staticmethod:



