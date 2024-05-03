:py:mod:`solidity_parser.errors`
================================

.. py:module:: solidity_parser.errors


Module Contents
---------------

.. py:exception:: AntlrParsingError(unit_name: str, version: solidity_parser.util.version_util.Version, input_src: str, details)


   Bases: :py:obj:`Exception`

   Common base class for all non-exit exceptions.

   .. py:attribute:: Detail

      


.. py:data:: CPEArgs
   :type: TypeAlias

   message, source_unit_name, line_number, line_offset


.. py:exception:: CodeProcessingError(message: str, source_unit_name: str, line_number, line_offset)


   Bases: :py:obj:`Exception`

   Common base class for all non-exit exceptions.


.. py:exception:: UnexpectedCodeProcessingError(message: str, source_unit_name: str, line_number: int, line_offset: int, root_cause: Exception)


   Bases: :py:obj:`CodeProcessingError`

   Common base class for all non-exit exceptions.


