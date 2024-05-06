Symbols and Scopes
==================

The :py:mod:`scoping module <solidity_parser.ast.symtab.py>` for AST1 is a major service in SOLP that provides scope trees
and tables to the :py:class:`AST2 Builder <solidity_parser.ast.ast2builder.Builder>`.

We'll work through using this API by considering a service that takes `LSP <https://microsoft.github.io/language-server-protocol/>`_
requests to find the definition of whatever you click on in the IDE(e.g. Visual Studio Code). This won't be the full plugin:
just the SOLP code required to make it work. The code is adapted from an existing plugin written with the `pygls <https://pygls.readthedocs.io/en/latest/>`_ and
`lsprotocol <https://github.com/microsoft/lsprotocol>`_ libraries.

Line to Node
------------

As we saw in the :doc:`sourcecode` tutorial, SOLP lets us map nodes to source code locations easily. Usually IDEs make
requests based on the line and column number and expect the language tool to figure out what is at that location.

Let's make a function that does that: it should take a list of possible AST1 nodes and a source location and determine the
exact node that is defined at that source location. The :py:meth:`SourceLocationSpan.does_contain() <solidity_parser.ast.nodebase.SourceLocationSpan.does_contain>`,
available for every node with :py:meth:`get_source_span() <solidity_parser.ast.nodebase.Node.get_source_span>` will work
for this.

All we need to do is recurse until we find the deeepest node whose span includes the location:

.. code-block:: python

   def get_containing_ast_node(src_loc: SourceLocation, nodes: List[Node]) -> Optional[Node]:
       for n in nodes:
           if not n:
               continue
           n_span = n.get_source_span()
           if n_span.does_contain(src_loc):
               children = list(n.get_children())
               return get_containing_ast_node(src_loc, children) if children else n
       return None

When a node has no more children, it must be the deepest node in the tree(a leaf).

.. note:: Since each node has a :py:meth:`get_children() <solidity_parser.ast.nodebase.get_children>` function, we can
          do this in a generic way without having to handle each Node separately using a visitor!

Idents Only
-----------

If this node is an identifier then we can do the reference search. If it's anything else(e.g. a Solidity keyword, a
punctuator, etc) then we can't get a definition.

.. code-block:: python

    if isinstance(ast1_node, Ident):
        return get_definitions_for_node(ast1_node)

Resolving the Reference
-----------------------

The reference could be qualified, e.g. ``x.y`` or unqualified ``y``. The way in which ``y`` is accessed changes the
scopes we need to search. The differences between the cases are:

* Unqualified: search for ``y`` in the :py:attr:`node scope <solidity_parser.ast.solnodes.AST1Node.scope>` of ``ast1_node``
* Qualified: figure out the type of ``x``, search for that type in ``ast1_node.scope`` to find a **type scope** and search for ``y`` in that type scope

Qualified lookups are modelled by the :py:class:`GetMember <solidity_parser.ast.solnodes.GetMember>` node in AST1. So
far we know that ``y`` is an :py:class:`Ident <solidity_parser.ast.solnodes.Ident>`, we need to determine what type of
lookup it is:

.. code-block:: python

   if isinstance(ast1_node.parent, solnodes.GetMember):
       # qualified
   else:
       # unqualified

Check the parent! Qualified lookups have a base, ``x`` and the member is ``y``.

Unqualified
^^^^^^^^^^^

.. code-block:: python

   symbols = ast1_node.scope.find(ast1_node.text)
   for s in symbols:
       for rs in s.res_syms():
           links.append(get_symbol_link(rs))

.. note:: The ``get_symbol_link`` function will be shown later

*What does ``res_syms`` do? Why not just return the symbols found in the scope?*

This is because SOLP has different types of symbols: some are actual symbols based on elements in the real source code
and some are created because of *links* created from inherits and imports or using statements. Since we want to locate
source code elements, we need to get the underlying symbol(s).

Qualified
^^^^^^^^^

To get the base type of ``x``, we're going to cheat a bit and use the :py:class:`TypeHelper <solidity_parser.ast.ast2builder.TypeHelper>`
that's built into the AST2 builder.

.. code-block:: python

   type_helper = ast2builder.type_helper

   base_obj: solnodes1.AST1Node = ast1_node.parent.obj_base
   base_type: solnodes2.Types = type_helper.get_expr_type(base_obj)

This bit of code is tricky so it's best to use Python typehints here. The :py:class:`Type <solidity_parser.ast.types.Type>`
returned from the TypeHelper is an :py:attr:`AST2 type <solidity_parser.ast.solnodes2.Types>`.

This AST2 type is passed back to the type helper to find the scopes to search:

.. code-block:: python

   base_scopes = type_helper.scopes_for_type(base_obj, base_type)

Search these scopes in the same way as the previous case:

.. code-block:: python

   for scope in base_scopes:
       symbols = scope.find(n.text)
       for s in symbols:
           for rs in s.res_syms():
               links.append(get_symbol_link(rs))

get_symbol_link
---------------

The exact details of ``get_symbol_link`` depend on what LSP framework you're using. Usually the following info is needed
from the reference that's found:

* Whether it's a builtin type/object
* The file it's is defined in
* The span of the Node that defines the Symbol and the span of the Node's descriptor/name

Scope vs Node
^^^^^^^^^^^^^

The AST1 node is found by the :py:attr:`value <solidity_parser.ast.symtab.Symbol.value>` attribute of the Symbol. In
general you can think of the value as being the Node that caused the Symbol to be created in the symbol's scope.

For Solidity builtin symbols, the ``value`` is usually None, but obviously even if it has a value, it can't
be a real AST1 node: SOLP doesn't parse the builtins, they are created only in the symbol table.

Checking for Builtins
^^^^^^^^^^^^^^^^^^^^^

This part is easy, check if the Symbol is any of the following types:

* :py:class:`BuiltinFunction <solidity_parser.ast.symtab.BuiltinFunction>`: self explanatory, e.g. ``keccak256()`` or ``abi.encode()``
* :py:class:`BuiltinObject <solidity_parser.ast.symtab.BuiltinObject>`: this is the ``msg`` part of ``msg.value``, i.e. the container object that has other builtins
* :py:class:`BuiltinValue <solidity_parser.ast.symtab.BuiltinValue>`: e.g. ``msg.value``

.. code-block:: python

   def is_builtin(sym):
       return isinstance(sym, (symtab.BuiltinFunction, symtab.BuiltinObject, symtab.BuiltinValue))

Mock Builtin File
"""""""""""""""""

When the user tries to find the definition for a builtin, let's give them a file to view that contains pseudocode with
documentation, e.g. when they click on ``msg.sender`` it opens a file called ``builtins.sol`` and goes to a struct
member in a struct named ``Msg``.

To do this, we need to take our builtin symbol table object from above, parse the ``builtins.sol`` file and find a
corresponding AST1 node that we will use for the rest of ``get_symbol_link``.

To do this let's say we have another VFS and symbol table builder setup with just the ``builtins.sol`` file
loaded(to avoid any nasty mixing with the real Solidity code of the project open in the IDE):

.. code-block:: python

   builtin_symbol = ...
   # getting this env(ironment) is an implementation detail
   # it just contains the vfs and symtab builder for builtins.sol only
   env = LSP_SERVER.builtin_env
   builtins_fs = env.symtab_builder.process_or_find_from_base_dir('solsrc/builtins.sol')
   symbol_path = compute_symbol_root_name(builtin_symbol)
   real_builtins_symbol = builtins_fs.find_multi_part_symbol(symbol_path)


We compute a `root path`, i.e. a fully qualified path from the FileScope of the ``builtin_symbol`` to the symbol itself.
For example, if we had the BuiltinValue representing ``msg.sender``, the key we get is ``msg.sender``.

``find_multi_part_symbol`` does the qualified search using the key and finds the real symbol.

To actually compute the key, there are a few tricky details:

.. code-block:: python
   :linenos:

   def compute_symbol_root_name(symbol) -> str:
       parts = []
       s = symbol
       while not isinstance(s, (symtab.FileScope, symtab.RootScope)):
           name = s.aliases[0]
           if name == '<type:address>':
               name = '_address'
           elif name == '<type:address payable>':
               name = '_address_payable'
           parts.append(name)
           s = s.parent_scope
       parts.reverse()

       if parts[0] == '_address' and parts[1] in ['transfer', 'send']:
           parts[0] = '_address_payable'

       return '.'.join(parts)

The general algorithm goes like this:

* Take the current symbol, find its parents recursively until we get to the FileScope(or RootScope for builtins)
   * store the primary alias of the symbol as part of the key(most symbols only have 1 alias)
   * this gives a reversed list of each of the parts of the key, e.g. ``['sender', 'msg']``
* reverse the list and join the parts together with dots

The tricky parts are:

* Lines 6-9: we can't name a contract address or address payable in Solidity as it's a language keyword, instead
  prefix these names with an underscore
* Lines 14-15: the ``transfer`` and ``send`` functions are stored under the address object in the symtab as old
  versions of Solidity allowed this whereas now it's only supported for for address payable: remap these functions to
  address payable in ``builtins.sol``

Finding the File
^^^^^^^^^^^^^^^^

The symbol table creates a :py:class:`FileScope <solidity_parser.ast.symtab.FileScope>` when it parses each file from
the VFS. It has the `source unit name <https://docs.soliditylang.org/en/latest/path-resolution.html#virtual-filesystem>`_
which we use to find the file path from the VFS.

.. code-block:: python

   def get_symbol_file_uri(vfs, symbol):
       file_scope = symbol.find_first_ancestor_of(symtab.FileScope)
       sun = file_scope.source_unit_name
       file_path = vfs.sources[sun].origin

The LSP deals with URIs, not paths, so convert the resultant path:

.. code-block:: python

   from pygls import uris

   uris.from_fs_path(str(file_path))


.. note:: If we pass in the appropriate VFS and real symbol for the builtins case, this same function works to give the
          URI of the ``builtins.sol``!

Node Spans
^^^^^^^^^^

To recap, we can take a source location, find the AST node there, check if it's a reference, resolve the reference and
find a corresponding AST node that the reference may be referring to. Now all we need to do is get the range of the
name of this node and the range of the entire node to return to the LSP client.

.. code-block:: python

   def get_node_range(n: Node) -> lsp.Range:
       solp_start, solp_end = n.start_location, n.end_location
       start = lsp.Position(solp_start.line-1, solp_start.column-1)
       end = lsp.Position(solp_end.line-1, solp_end.column-1)
       return lsp.Range(start, end)

This function is very simple, it just copies the data from the node into the ``lsp.Range`` object. I've shown it as it
highlights how SOLP source locations are `1 based` whereas LSP/IDE locations for this usecase are `0 based`, hence the
``-1``s on each position.

Definition Name Span
""""""""""""""""""""

This gets the range of the name of the target node only, e.g. it would highlight just the name of the function or the
name of the contract that has been referenced.

.. code-block:: python

   if hasattr(node, 'name'):
       return get_node_range(node.name)
   else:
       return None

Definition Span
"""""""""""""""

This gets the range of the entire target node, e.g. from the keyword ``function`` all the way to the closing curly brace
of a function definition.

.. code-block:: python

   return get_node_range(node)

Closing Notes
-------------

While this tutorial can't cover the entire plumbing required to make a language server for Solidity, the concepts
introduced here will help you get there. In fact, most of the code in this guide is taken from our open source demo
implementation available on `Github <https://github.com/Zellic>`_.

