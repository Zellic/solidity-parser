:py:mod:`solidity_parser.util.version_util`
===========================================

.. py:module:: solidity_parser.util.version_util


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.util.version_util.Version



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.util.version_util.extract_version_from_src_input
   solidity_parser.util.version_util.parse_version



Attributes
~~~~~~~~~~

.. autoapisummary::

   solidity_parser.util.version_util.VERSION_PATTERN


.. py:data:: VERSION_PATTERN

   

.. py:class:: Version


   .. py:attribute:: major
      :type: int

      

   .. py:attribute:: minor
      :type: int

      

   .. py:attribute:: patch
      :type: int

      

   .. py:method:: is_enforced_in(testing_version: Version) -> bool

      Tests whether a feature that was introduced in the given testing_version is enforced in the current version
      E.g. if a feature is only available in or after version 8.0.1 but the current version is 7.0.0, that feature
           should not be enforced and this function returns False


   .. py:method:: __str__()

      Return str(self).



.. py:function:: extract_version_from_src_input(txt: str) -> Version

   Extracts the solidity version from the input source code
   :param txt: the entire source file


.. py:function:: parse_version(ver_text: str) -> Version

   Parses a solidity version string into a Version object
   :param ver_text: the version string only, e.g. "0.6.12"


