:py:mod:`solidity_parser.ast.mro_helper`
========================================

.. py:module:: solidity_parser.ast.mro_helper


Module Contents
---------------


Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.mro_helper._merge
   solidity_parser.ast.mro_helper.c3_linearise



Attributes
~~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.mro_helper.T


.. py:function:: _merge(*sequences)


.. py:data:: T

   

.. py:function:: c3_linearise(klass: T, get_supers: Callable[[T], list[T]] = None) -> list[T]

   A function to linearise the class hierarchy using the C3 linearisation algorithm.

   :param klass: The class to linearise.
   :param get_supers: A function to get the superclasses of a given class, must return a list of classes with the same
                      type as the input
   :return: A linearised list of classes following the C3 algorithm.


