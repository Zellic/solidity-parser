Symbols and Scopes
==================

The :py:mod:`scoping module <solidity_parser.ast.symtab.py>` for AST1 is a major service in SOLP that provides scope trees
and tables to the :py:class:`AST2 Builder <solidity_parser.ast.ast2builder.Builder>`.

We'll work through using this API by considering a service that takes `LSP <https://microsoft.github.io/language-server-protocol/>`_
requests to find the definition of whatever you click on in the IDE(e.g. Visual Studio Code). This won't be the full plugin:
just the SOLP code required to make it work.

Line to Node
------------

As we saw in the :doc:`sourcecode` tutorial, SOLP lets us map nodes to source code locations easily. Usually IDEs make
requests based on the line and column number and expect the language tool to figure out what is at that location.

Let's make a function that does that: it should make a list of possible AST1 nodes and a source location and determine the
exact node that is defined at that source location. The :py:meth:`SourceLocationSpan.does_contain() <solidity_parser.ast.nodebase.SourceLocationSpan.does_contain>`,
available for every node with :py:meth:`get_source_span() <solidity_parser.ast.nodebase.Node.get_source_span>` will work
for this.

All we need to do is recurse until we find the deeepest node that is defined in that span:

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

Idents Only
-----------

If this node is an identifier then we can do the reference search:

.. code-block:: python

    if isinstance(ast1_node, Ident):
        return get_definitions_for_node(ast1_node)

Qualified vs Unqualified References
-----------------------------------

The reference could be qualified, e.g. ``x.y`` or unqualified ``y``. The way in which ``y`` is accessed changes the
scopes we need to search. The differences between the cases are:

* Unqualified: search for ``y`` in the :py:attr:`node scope <solidity_parser.ast.solnodes.AST1Node.scope>` of ``ast1_node``
* Qualified: figure out the type of ``x``, search for that type in ``ast1_node.scope`` to find a ``Type Scope`` and search for ``y`` in that type scope

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

The exact details of ``get_symbol_link`` depend on what LSP framework you're using. This guide will show you what it
needs to extract for the










