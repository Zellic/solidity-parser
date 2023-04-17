from setuptools import setup, find_packages
import subprocess


cmds = [
    'java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v060/Solidity.g4 -o src/solidity_parser/grammar/v060/',
    'java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v070/Solidity.g4 -o src/solidity_parser/grammar/v070/',
    'java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v080/SolidityParser.g4 src/solidity_parser/grammar/v080/SolidityLexer.g4 -o src/solidity_parser/grammar/v080/',
    'java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v088/SolidityParser.g4 src/solidity_parser/grammar/v088/SolidityLexer.g4 -o src/solidity_parser/grammar/v088/'
]

print("Generating antlr parsers")

for c in cmds:
    subprocess.run(c.split(' '), check=True)

print("Generated antlr parsers")

setup(
    name='solidity-parser',

    setuptools_git_versioning={
        "enabled": True,
    },
    install_requires=[
        "setuptools-git-versioning<2",
        "antlr4-python3-runtime==4.11.1",
        "parameterized",
        "mock",
        "jsons"
    ],

    packages=find_packages(where='src'),
    package_dir={'': 'src'}
)
