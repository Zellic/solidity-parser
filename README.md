# Zellic Solidity Parser (solp)

### Description

Solp is a Python library used for reading, parsing and analysis Solidity source projects and contracts without having
to use the `solc` compiler. This is done by having different grammars for different versions of Solidity, transforming
them into a common AST and then further refining that AST into more specialised forms of IR for analysis. The resulting
ASTs and IRs are easily usable by consumer applications without any additional dependencies.

### Goals

The goal of this project are to:
  - parse Solidity source files into typed AST/IR structures
  - load code from different Solidity versions(0.4-0.8^) for common analyses
  - load entire Solidity projects for analysis with the requisite dependency context
  - enable and provide a language server and IDE support
  - be usable by developers and auditors in an IDE scripting context to generate insights for security analysis


### Status

Currently it is used in the Audit Signoff Injector where it's used for signoff comment generation and function call
analysis.

  - AST1 parsing for Solidity 0.4+ - done
  - AST1 -> AST2 refinement - done
  - AST2 -> TAC-SSA-IR - in progress
  - Integration and unit tests - partially implemented
  - Language server

### Requirements

  - Python 3.10+ is recommended
  - Java 8+ (for antlr grammar stub generation)

### Setup

`setup.py` generates the antlr Python grammar stubs, builds and installs solp as `solidity-parser` with `pip install .`


### Usage

Solp is not a standalone application so has no entry point to speak of. Example snippets and currently run
configurations for development are in `main.py` but these aren't application usecases themselves.


### How it works

