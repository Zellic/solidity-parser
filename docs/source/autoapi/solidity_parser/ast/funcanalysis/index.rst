:py:mod:`solidity_parser.ast.funcanalysis`
==========================================

.. py:module:: solidity_parser.ast.funcanalysis


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.funcanalysis.PathEdgeKind



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.funcanalysis.find_matching_function_in_type
   solidity_parser.ast.funcanalysis.find_possible_matching_functions_for_declared_type
   solidity_parser.ast.funcanalysis.add_function_to_cg
   solidity_parser.ast.funcanalysis.find_possible_calls
   solidity_parser.ast.funcanalysis.mark_sources
   solidity_parser.ast.funcanalysis.is_fca_important
   solidity_parser.ast.funcanalysis.is_blackbox_node
   solidity_parser.ast.funcanalysis.has_inline_yul
   solidity_parser.ast.funcanalysis.find_important_paths2



.. py:function:: find_matching_function_in_type(ttype: solidity_parser.ast.solnodes2.TopLevelUnit, name, arg_types, ignore_current_type=False)


.. py:function:: find_possible_matching_functions_for_declared_type(declared_ttype: solidity_parser.ast.solnodes2.ResolvedUserType, name, arg_types, is_super_call)


.. py:function:: add_function_to_cg(cg: networkx.DiGraph, finished_functions, function: solidity_parser.ast.solnodes2.FunctionDefinition)


.. py:function:: find_possible_calls(declared_ttype: Union[solidity_parser.ast.solnodes2.ResolvedUserType, solidity_parser.ast.solnodes2.SuperType], name: str, arg_types: List[solidity_parser.ast.types.Type], match_filter=lambda x: True, use_subtypes=True) -> List[solidity_parser.ast.solnodes2.FunctionDefinition]


.. py:function:: mark_sources(units: List[solidity_parser.ast.solnodes2.TopLevelUnit])


.. py:function:: is_fca_important(f: solidity_parser.ast.solnodes2.FunctionDefinition)


.. py:function:: is_blackbox_node(f: solidity_parser.ast.solnodes2.FunctionDefinition)


.. py:function:: has_inline_yul(f: solidity_parser.ast.solnodes2.FunctionDefinition)


.. py:class:: PathEdgeKind(*args, **kwds)


   Bases: :py:obj:`enum.Enum`

   Create a collection of name/value pairs.

   Example enumeration:

   >>> class Color(Enum):
   ...     RED = 1
   ...     BLUE = 2
   ...     GREEN = 3

   Access them by:

   - attribute access::

   >>> Color.RED
   <Color.RED: 1>

   - value lookup:

   >>> Color(1)
   <Color.RED: 1>

   - name lookup:

   >>> Color['RED']
   <Color.RED: 1>

   Enumerations can be iterated over, and know how many members they have:

   >>> len(Color)
   3

   >>> list(Color)
   [<Color.RED: 1>, <Color.BLUE: 2>, <Color.GREEN: 3>]

   Methods can be added to enumerations, and members can have their own
   attributes -- see the documentation for details.

   .. py:attribute:: INTRA_CALL
      :value: 1

      

   .. py:attribute:: SINK_INTER
      :value: 2

      

   .. py:attribute:: SINK_NO_CODE
      :value: 3

      

   .. py:attribute:: SINK_FCA_IMPORTANT
      :value: 4

      

   .. py:attribute:: SINK_INLINE_YUL
      :value: 5

      


.. py:function:: find_important_paths2(source: solidity_parser.ast.solnodes2.FunctionDefinition)


