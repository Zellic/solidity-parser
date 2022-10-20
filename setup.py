from distutils.core import setup

setup(name='solidity_parser',
      packages=['solidity_parser.collectors', 'solidity_parser.grammar',
                'solidity_parser.grammar.v060', 'solidity_parser.grammar.v070',
                'solidity_parser.grammar.v080'],
      )
