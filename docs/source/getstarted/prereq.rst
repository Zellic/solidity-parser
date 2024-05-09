Prerequisites
=============

Software Requirements
---------------------

Python 3.11+
~~~~~~~~~~~~~

To run this software, you need Python version 3.11 or higher installed on your system. If you haven't installed Python
yet, you can download it from the official Python website:

    https://www.python.org/downloads/

Java 8+ (for ANTLR grammar stub generation)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

For generating ANTLR grammar stubs, you need Java version 8 or higher installed on your system. There are multiple
implementations available, but we recommend this one:

    https://adoptopenjdk.net/releases.html

After installing Java, make sure to set the ``JAVA_HOME`` environment variable to the JDK installation directory and
``PATH`` to the ``bin`` directory of the JDK installation.

Once you have both Python and Java installed, you can proceed with the installation of the software.

Resolving Conflicts
^^^^^^^^^^^^^^^^^^^

Currently, SOLP is only available on `GitHub <https://github.com/Zellic/solidity-parser>`_, and when installed, has the
module name solidity-parser. Unfortunately, there is already a module with the same name in PyPI, which can be the
cause of problems if accidentally installed.

Therefore, it's recommended that you first run this command globally (outside of an activated virtual environment) to
remove packages that can conflict with SOLP.

.. code-block:: bash

   pip uninstall solidity-parser
