:py:mod:`solidity_parser.ast.hierarchy`
=======================================

.. py:module:: solidity_parser.ast.hierarchy


Module Contents
---------------


Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.hierarchy.build_hierarchy



.. py:function:: build_hierarchy(top_level_units: list[solidity_parser.ast.solnodes2.TopLevelUnit]) -> None

   Annotates the top level units with their direct subtypes, e.g. if A extends B, then A._subtypes = [B]


