Client Setup
===============

.. note::
   Before installing SOLP, follow the instructions in the :doc:`prereq` document..

Who is this document for?
^^^^^^^^^^^^^^^^^^^^^^^^^
People who want to use SOLP in their own projects

Setup a Virtual Environment (optional)
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

It's always recommended to setup a virtual environment(venv) instead of installing the package in the global pip cache.

Create a venv called `venv`:

.. code-block:: bash

   python -m venv venv

Then activate the venv:

Unix:

.. code-block:: bash

   ./venv/Scripts/activate

Windows:

.. code-block:: powershell

   .\venv\Scripts\activate

Installing
^^^^^^^^^^

.. code-block:: bash

   pip install <solp>

Where `<solp>` is a path to a clone of the repository or: `git+https://github.com/Zellic/solidity-parser.git`
