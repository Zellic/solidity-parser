#!/bin/bash
set -e
set -x
if [[ "$VIRTUAL_ENV" == "" ]]; then
  echo "Looks like youre not in a venv, setting up for you :)"
  python3 -m virtualenv venv
  source venv/bin/activate
  python3 -m pip install -r requirements.txt
else
  echo "Looks like youre already in a venv :)"
\fi
java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 grammar/v060/Solidity.g4 -o grammar/v060/
java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 grammar/v070/Solidity.g4 -o grammar/v070/
java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 grammar/v080/SolidityParser.g4 grammar/v080/SolidityLexer.g4 -o grammar/v080/
