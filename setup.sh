#!/bin/bash
set -e
set -x
if [[ "$VIRTUAL_ENV" == "" ]]; then
  echo "Looks like youre not in a venv, setting up for you :)"
  python -m virtualenv venv
  source venv/bin/activate
  python -m pip install -r requirements.txt
else
  echo "Looks like youre already in a venv :)"
fi
java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v060/Solidity.g4 -o src/solidity_parser/grammar/v060/ -Xexact-output-dir
java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v070/Solidity.g4 -o src/solidity_parser/grammar/v070/ -Xexact-output-dir
java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v080/SolidityParser.g4 src/solidity_parser/grammar/v080/SolidityLexer.g4 -o src/solidity_parser/grammar/v080/ -Xexact-output-dir
java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v088/SolidityParser.g4 src/solidity_parser/grammar/v088/SolidityLexer.g4 -o src/solidity_parser/grammar/v088/ -Xexact-output-dir
java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v08_22/SolidityParser.g4 src/solidity_parser/grammar/v08_22/SolidityLexer.g4 -o src/solidity_parser/grammar/v08_22/ -Xexact-output-dir
