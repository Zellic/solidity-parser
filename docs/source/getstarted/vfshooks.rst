Customizing File Parsing
========================

So far, all of the guides have used the default config of the :py:class:`VirtualFileSystem <solidity_parser.filesys.VirtualFileSystem>`
to find, load, and parse the input Solidity code. This guide goes over customizing parser versions, file resolution, and
useful tips for hooking into the VFS.

Parser Version
--------------

SOLP is the only tool that's able to parse any version of Solidity source code. It doesn't require a lot of builds of
SOLP and doesn't work on EVM bytecode. To do this, the Solidity version pragma in each file is processed, and a suitable
parser version is inferred.

Sometimes this inference doesn't work; files may have conflicting versions or versions may be omitted.

To get around this, pass a :py:class:`Version <solidity_parser.util.version_util.Version>` to the VFS constructor.
This will force the parser version and the language version for different steps later on. For example, this

.. code-block:: python

   vfs = VirtualFileSystem(base_path, None, [src_path], compiler_version=Version(0, 8, 22))

would force the version to Solidity 0.8.22.

Overriding File Reading
-----------------------

Let's say you have a loaded cache of files or want to implement a check before the VFS reads a file. This is done by
setting the :py:meth:`_do_read_path <solidity_parser.filesys.VirtualFileSystem._do_read_path>` hook.

.. code-block:: python

   allowable_loads: Set[Path] = get_allowable_file_reads()
   file_data: dict[Path, str] = get_cached_files()

   def _do_read_path(self, path) -> str:
       if path in file_data:
           return file_data[path]

       if path in allowable_loads:
           return super()._do_read_path(path)

       raise PermissionError(path)

   vfs = VirtualFileSystem(base_path, None, [src_path])
   vfs._do_read_path = _do_read_path

AST1 Parser Override
--------------------

By default, SOLP uses the :py:func:`<solidity_parser.ast.helper.make_ast>` helper to choose a built-in ANTLR parser. For
custom parsers, create a shim for :py:meth:`_add_loaded_source <solidity_parser.filesys.VirtualFileSystem._add_loaded_source>`.

.. code-block:: python

   def my_creator(input_src, version = None, origin = None):
       ...

   add_loaded_source = vfs._add_loaded_source

   def shim(*args, **kwargs):
       return add_loaded_source(*args, creator=my_creator, **kwargs)

   vfs._add_loaded_source = shim

.. note:: The creator has to have the same signature as ``make_ast``.

Conclusion
----------
For most users the contents of this guide are never needed as initializer arguments are capable of changing the file
loading and parser selection characteristics automatically. However, for completeness, this guide has given some common
techniques for extending and customising the behaviour of the VirtualFileSystem
