# legacy-solidity-parser

Parses and pretty-prints Solidity files

# Setup

See setup.sh

# Usage

python3 main.py example/AaveToken.sol

# Notes

Solidity versions>=0.8 use language targeted code in the grammar (Java), this prevents
the generation of ANTLR bindings into python. The solution for this was modifying the grammar files
themselves which means the Solidity grammar in this repo is custom.