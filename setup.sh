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
fi
java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 Solidity.g4
