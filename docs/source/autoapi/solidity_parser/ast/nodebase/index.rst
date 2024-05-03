:py:mod:`solidity_parser.ast.nodebase`
======================================

.. py:module:: solidity_parser.ast.nodebase


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.nodebase.SourceLocation
   solidity_parser.ast.nodebase.SourceLocationSpan
   solidity_parser.ast.nodebase.NodeList
   solidity_parser.ast.nodebase.Ref
   solidity_parser.ast.nodebase.Node



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.nodebase.NodeDataclass



Attributes
~~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.nodebase.__REASON_CHILD__
   solidity_parser.ast.nodebase.__FIELD_PARENT__
   solidity_parser.ast.nodebase.__REASON_INIT__
   solidity_parser.ast.nodebase.T


.. py:class:: SourceLocation


   Bases: :py:obj:`NamedTuple`

   .. py:attribute:: line
      :type: int

      Line number, beginning at 1


   .. py:attribute:: column
      :type: int

      Column number, beginning at 1. E.g. the first character on the line is at column 1.



.. py:class:: SourceLocationSpan


   Bases: :py:obj:`NamedTuple`

   .. py:attribute:: start
      :type: SourceLocation

      

   .. py:attribute:: end
      :type: SourceLocation

      

   .. py:method:: does_contain(loc: SourceLocation)

      Checks whether the given 'loc' location is contained within this span.
      E.g. if this span represents ((5,1), (10, 1)), i.e lines 5 to 10 and loc is (6, 1), the location is contained
      :param loc:
      :return:



.. py:data:: __REASON_CHILD__
   :value: '__child__'

   

.. py:data:: __FIELD_PARENT__
   :value: 'parent'

   

.. py:data:: __REASON_INIT__
   :value: '__init__'

   

.. py:function:: NodeDataclass(cls, *args, **kwargs)

   AST node decorator to add an updatable and cachable element based hash to the dataclass


.. py:data:: T

   

.. py:class:: NodeList(parent: T, seq=())


   Bases: :py:obj:`list`\ [\ :py:obj:`T`\ ]

   Built-in mutable sequence.

   If no argument is given, the constructor creates a new empty list.
   The argument must be an iterable if specified.

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: __repr__()

      Return repr(self).


   .. py:method:: __setitem__(key, value)

      Set self[key] to value.


   .. py:method:: __delitem__(key)

      Delete self[key].


   .. py:method:: __setslice__(i, j, sequence)


   .. py:method:: __eq__(other)

      Return self==value.


   .. py:method:: append(__object)

      Append object to the end of the list.


   .. py:method:: clear()

      Remove all items from list.


   .. py:method:: extend(__iterable)

      Extend list by appending elements from the iterable.


   .. py:method:: insert(__index, __object)

      Insert object before index.


   .. py:method:: pop(__index)

      Remove and return item at index (default last).

      Raises IndexError if list is empty or index is out of range.


   .. py:method:: remove(__value)

      Remove first occurrence of value.

      Raises ValueError if the value is not present.


   .. py:method:: reverse()

      Reverse *IN PLACE*.


   .. py:method:: sort(*args, **kwargs)

      Sort the list in ascending order and return None.

      The sort is in-place (i.e. the list itself is modified) and stable (i.e. the
      order of two equal elements is maintained).

      If a key function is given, apply it once to each list item and sort them,
      ascending or descending, according to their function values.

      The reverse flag can be set to sort in descending order.



.. py:class:: Ref


   Bases: :py:obj:`Generic`\ [\ :py:obj:`T`\ ]

   A weak AST reference to another Node. This is needed when we want to associate a Node with another Node but don't
   want it to be marked as a child of the other Node. This is useful if we want to create circular or back references
   to help the client use the AST more naturally, e.g. ResolvedUserTypes have a reference to the actual TopLevelUnit
   they reference.

   .. py:attribute:: x
      :type: T

      The item being referenced


   .. py:method:: __repr__()

      Return repr(self).



.. py:class:: Node


   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: id_location
      :type: str

      LineNumber:LinePosition, this is set dynamically in common.make


   .. py:attribute:: start_location
      :type: SourceLocation

      Source start location of this node (column is inclusive)


   .. py:attribute:: end_location
      :type: SourceLocation

      Source end location of this node (column is exclusive)


   .. py:attribute:: start_buffer_index
      :type: int

      Source start (0-based) position in the input text buffer(inclusive)


   .. py:attribute:: end_buffer_index
      :type: int

      Source end (0-based) position in the input text buffer(exclusive)


   .. py:attribute:: parent
      :type: Optional[Node]

      

   .. py:attribute:: comments
      :type: Optional[list[str]]

      

   .. py:method:: __post_init__()


   .. py:method:: get_source_span()


   .. py:method:: linenumber() -> int


   .. py:method:: source_location()


   .. py:method:: offset() -> int


   .. py:method:: get_children(predicate: Callable[[Node], bool] = None) -> Generator[Node, None, None]


   .. py:method:: get_all_children(predicate: Callable[[Node], bool] = None) -> Generator[Node, None, None]


   .. py:method:: _set_child_parents()


   .. py:method:: __deepcopy__(memodict)


   .. py:method:: code_str()
      :abstractmethod:



