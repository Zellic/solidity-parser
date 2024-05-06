Client Setup
===============

.. note::
   Before installing SOLP, follow the instructions in the :doc:`prereq` document..

Who Is This Document For?
^^^^^^^^^^^^^^^^^^^^^^^^^
This is for people who want to use SOLP in their own projects.

Set Up a Virtual Environment (Optional)
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

It's always recommended to set up a virtual environment (venv) instead of installing the package in the global pip cache.

Create a venv called ``venv``.

.. code-block:: bash

   python -m venv venv

Then activate the venv.

Unix:

.. code-block:: bash

   ./venv/Scripts/activate

Windows:

.. code-block:: powershell

   .\venv\Scripts\activate

Installing
^^^^^^^^^^

Finally, install the SOLP python package.

.. code-block:: bash

   pip install <solp>

Where ``<solp>`` is a path to a clone of the repository or ``git+https://github.com/Zellic/solidity-parser.git``.
