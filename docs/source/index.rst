.. SOLP documentation master file, created by
   sphinx-quickstart on Fri Apr 19 14:32:50 2024.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Welcome to SOLP's documentation!
================================

**SOLP** is a Python library used for reading, parsing and analysing Solidity source projects and contracts without
having to use the solc compiler. Multiple versions of Solidity from 0.4 to the latest are supported. This is done by
having different grammars for different versions of Solidity, transforming them into a common AST and then further
refining that AST into more specialised forms of IR for analysis.
The resulting ASTs and IRs are easily usable by consumer applications without any additional dependencies.


.. toctree::
   :maxdepth: 2

   getstarted/index



Indices and tables
==================

* :ref:`genindex`
* :ref:`modindex`
* :ref:`search`
