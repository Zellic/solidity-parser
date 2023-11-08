from setuptools import setup, find_packages
import subprocess
import setuptools.command.build_py

class BuildPyWithGenerateCommand(setuptools.command.build_py.build_py):
    """Custom build command."""

    def run(self):
        self.gen()
        setuptools.command.build_py.build_py.run(self)

    def gen(self):
        cmds = [
            'java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v060/Solidity.g4 -o src/solidity_parser/grammar/v060/ -Xexact-output-dir',
            'java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v070/Solidity.g4 -o src/solidity_parser/grammar/v070/ -Xexact-output-dir',
            'java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v080/SolidityParser.g4 src/solidity_parser/grammar/v080/SolidityLexer.g4 -o src/solidity_parser/grammar/v080/ -Xexact-output-dir',
            'java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v088/SolidityParser.g4 src/solidity_parser/grammar/v088/SolidityLexer.g4 -o src/solidity_parser/grammar/v088/ -Xexact-output-dir',
            'java -jar vendor/antlr-4.11.1-complete.jar -Dlanguage=Python3 src/solidity_parser/grammar/v08_22/SolidityParser.g4 src/solidity_parser/grammar/v08_22/SolidityLexer.g4 -o src/solidity_parser/grammar/v08_22/ -Xexact-output-dir']

        print("Generating antlr parsers")

        for c in cmds:
            subprocess.run(c.split(' '), check=True)

        print("Generated antlr parsers")

setup(
    name='solidity-parser',
    version='0.1.1',

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
    cmdclass={
        'build_py': BuildPyWithGenerateCommand,
    },

    packages=find_packages(where='src'),
    package_dir={'': 'src'}
)
