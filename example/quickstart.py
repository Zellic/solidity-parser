# makes this file easily runnable in Pycharm
if __name__ == '__main__':
    pass


from pathlib import Path

from solidity_parser import filesys
from solidity_parser.ast import symtab, ast2builder, solnodes2


project_dir = Path('./project')
source_dir = project_dir / 'contracts'
library_dir = project_dir / 'lib'
remappings_file = project_dir / 'remappings.txt'


# setup our VFS with all of the source directories and remappings if required, this is where AST1 parse trees come from

vfs = filesys.VirtualFileSystem(
    # base_path is the project path
    project_dir,
    # don't pass in CWD, VFS will get it
    None,
    # pass in source and library directories as "include_paths", i.e. source paths
    [source_dir, library_dir],
    # no forced compiler version
    None
)

if remappings_file.exists():
    vfs.parse_import_remappings(remappings_file)

# symbol table builder is required to get symbol info from AST1 for AST2
sym_builder = symtab.Builder2(vfs)

file_to_analyse = Path('TestContract.sol')
# searches for the file to analysis and gets us back a FileScope(the input to AST2builder)
# pass in the str representation of the Path
file_sym_info: symtab.FileScope = sym_builder.process_or_find_from_base_dir(file_to_analyse)

# setup the AST2 builder
ast2_builder = ast2builder.Builder()
ast2_builder.enqueue_files([file_sym_info])

# run the builder, this will create AST2 parse trees for the file_to_analyse and any files that are referenced from
# there and need to be analysed in the process(all lazily)
ast2_builder.process_all()

# AST2 creates "top level units" for contracts, interfaces, enums, libraries and also "synthetic top level units" for
# functions, errors, events and constants that are "free", i.e. not defined in a top level node, in our example code
# we only have a contract defined at the top level, so get that
all_units: list[solnodes2.TopLevelUnit] = ast2_builder.get_top_level_units()

# u.name is a solnodes2.Ident, str(u.name) makes it comparable to strings
# hint for ContractDefinition since we know the type
my_contract: solnodes2.ContractDefinition = [u for u in all_units if str(u.name) == 'MyContract'][0]

for p in my_contract.parts:
    if isinstance(p, solnodes2.FunctionDefinition):
        print(f'Found a function: {p.descriptor()}')

# Should print:
# Found a function: TestContract.sol.MyContract::myVariable() returns (uint256)
# Found a function: TestContract.sol.MyContract::setMyVariable(uint256) returns ()
# Found a function: TestContract.sol.MyContract::getMyVariable() returns (uint256)
# Found a function: TestContract.sol.MyContract::addToVariable(uint256) returns ()

