# legacy-solidity-parser

Parses and pretty-prints the top level objects from Solidity files

# Requirements
requirements.txt
recent jdk

# Setup

See setup.sh

# Usage

`python3 main.py example/AaveToken.sol` to directly run the program on a Solidity file
<br>
OR
<br>
`pip install .` to install the package and use it as a library (run setup.sh before doing this)

# Notes

Solidity versions>=0.8 use language targeted code in the grammar (Java), this prevents
the generation of ANTLR bindings into python. The solution for this was modifying the grammar files
themselves which means the Solidity grammar in this repo is custom for versions>=0.8.
