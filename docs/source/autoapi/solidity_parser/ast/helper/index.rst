:py:mod:`solidity_parser.ast.helper`
====================================

.. py:module:: solidity_parser.ast.helper


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.helper.MyErrorListener



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.helper.get_processors
   solidity_parser.ast.helper.make_ast
   solidity_parser.ast.helper.param_type_str



.. py:class:: MyErrorListener


   Bases: :py:obj:`antlr4.error.ErrorListener.ErrorListener`

   .. py:method:: add_error(recognizer, line, column, msg)


   .. py:method:: syntaxError(recognizer, offendingSymbol, line, column, msg, e)



.. py:function:: get_processors(version: solidity_parser.util.version_util.Version)


.. py:function:: make_ast(input_src, version: solidity_parser.util.version_util.Version = None, origin=None) -> List[solidity_parser.ast.solnodes.SourceUnit]


.. py:function:: param_type_str(parameters: List[solidity_parser.ast.solnodes.Parameter]) -> str


