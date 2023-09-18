import traceback

from antlr4 import InputStream, CommonTokenStream

from solidity_parser.grammar.v060.SolidityLexer import SolidityLexer as SolidityLexer060
from solidity_parser.grammar.v060.SolidityParser import SolidityParser as SolidityParser060


from solidity_parser.grammar.v070.SolidityLexer import SolidityLexer as SolidityLexer070
from solidity_parser.grammar.v070.SolidityParser import SolidityParser as SolidityParser070

from solidity_parser.grammar.v080.SolidityLexer import SolidityLexer as SolidityLexer080
from solidity_parser.grammar.v080.SolidityParser import SolidityParser as SolidityParser080

from solidity_parser.grammar.v088.SolidityLexer import SolidityLexer as SolidityLexer088
from solidity_parser.grammar.v088.SolidityParser import SolidityParser as SolidityParser088

from solidity_parser.collectors.collector import get_minor_ver
# from solidity_parser.ast.nodes import Contract, ContractType
import prettyprinter as pp

from solidity_parser.ast.parsers.parsers060 import Parser060
from solidity_parser.ast.parsers.parsers070 import Parser070
from solidity_parser.ast.parsers.parsers080 import Parser080
from solidity_parser.ast.parsers.parsers088 import Parser088

from solidity_parser.ast import solnodes
from solidity_parser.ast import symtab

import os
import json
import sys

from solidity_parser.filesys import VirtualFileSystem
from solidity_parser.ast.helper import make_ast

import solidity_parser.ast.solnodes2 as solnodes2
from solidity_parser.ir.irbuilder import IRBuilder

import solidity_parser.errors as errors

def fname(node):
    # id = node.functionDescriptor().identifier()
    id = node.identifier()
    if id is not None:
        return id.Identifier().getText(), False
    else:
        return '<' + node.functionDescriptor().getText() + '>', True


# def visit(node, parent=None):
#     if isinstance(node, SolidityParser.FunctionDefinitionContext):
#         name, special = fname(node)
#         if not special:
#             print(name)
#             code = node.block()
#             if code is not None:
#                 p = Parser080()
#                 ast = p.make(code)
#                 pp.pprint(ast)
#     elif not isinstance(node, TerminalNode):
#         for c in node.children:
#             visit(c, node)


def get_contracts_from_descriptors(input_files):
    for file_name in input_files:
        with open(file_name, encoding='utf-8') as file:
            descriptors = json.load(file)
            if len(descriptors) != 1:
                raise Exception("piss")
            # print(json.dumps(d, sort_keys=True, indent=2))
            # print(file_name)
            source_codes_str = descriptors[0]['SourceCode']

            if source_codes_str[0] == '{' and source_codes_str[1] == '{' and source_codes_str[-1] == '}' and \
                    source_codes_str[-2] == '}':
                # some weird descriptor object with {{ sources: { "a.sol", {content: "src" }, ... } ... }}
                source_codes_str_inner = source_codes_str[1:-1]
                descriptors2 = json.loads(source_codes_str_inner)

                source_codes = [content_desc['content'] for (name, content_desc) in descriptors2['sources'].items()]
            else:
                # source_code_str is either the source code of the contract or a json
                # object containing source codes for the contracts...
                try:
                    source_codes = json.loads(source_codes_str)
                except json.decoder.JSONDecodeError:
                    source_codes = [source_codes_str]

            for sc in source_codes:
                minor_vers = get_minor_ver(sc)
                if minor_vers is not None:
                    yield file_name, minor_vers, sc


def try_parse_contract(file_name, version, contract_source, idx):
    contract_input = InputStream(contract_source)

    if version < 7:
        grammar_parser_type = SolidityParser060
        grammar_lexer_type = SolidityLexer060
        ast_parser = Parser060()
    elif 8 > version >= 7:
        grammar_parser_type = SolidityParser070
        grammar_lexer_type = SolidityLexer070
        ast_parser = Parser070()
    elif version >= 8:
        grammar_parser_type = SolidityParser080
        grammar_lexer_type = SolidityLexer080
        ast_parser = Parser080()
    else:
        raise KeyError(f"dingle error, v{version}")

    lexer = grammar_lexer_type(contract_input)
    stream = CommonTokenStream(lexer)
    parser = grammar_parser_type(stream)

    try:
        tree = parser.sourceUnit()
        source_units = tree.children

        for su in source_units:
            u = ast_parser.make(su)
            # pp.pprint(u)
        print(f"pass, idx:{idx}")
    except Exception as e:
        print(f"piss: {file_name} {version} idx={idx}")
        print(contract_source)
        if idx is not None:
            with open(f"../example/errors/Contract{idx}.sol", "w", encoding='utf-8') as text_file:
                text_file.write(contract_source)
        raise e


def get_ast(file_path):
    return make_ast(open(file_path, 'r').read())


def type_of(node):
    if isinstance(node, solnodes.GetMember):
        if isinstance(node.obj_base, solnodes.Ident):
            print(node)
            print(node.scope.find(node.obj_base.text))
def dfs(node):
    for (key,val) in vars(node).items():

        if isinstance(val, solnodes.GetMember):
            type_of(val)

        # if isinstance(val, solnodes.Ident):
        #     if not hasattr(val, 'location'):
        #         print(f"{val} has no location")
        #     elif not val.scope.find(str(val)):
        #         print(f"{val.scope.find_first_ancestor(lambda x: isinstance(x, symtab.FileScope)).get_names()} {val} @ {val.location} => {val.scope.find(str(val)) is not None}")

        if isinstance(val, solnodes.Node):
            dfs(val)
        elif isinstance(val, list):
            for x in val:
                dfs(x)


import logging
from solidity_parser.ast.ast2builder import Builder as Builder2
from glob import glob
import re
import solidity_parser.ast.helper as asthelper
from solidity_parser.collectors import collector
import shutil

version_pattern = pattern = re.compile(r"v(\d)\.(\d)\.[0-9]+", re.IGNORECASE)


if __name__ == '__main__1':
    pp.install_extras()
    logging.basicConfig( level=logging.CRITICAL)

    base_dir = 'F:/downloads/Contracts/00'
    all_files = [os.path.join(dp, f) for dp, dn, filenames in os.walk(base_dir) for f in filenames]

    out_dir = 'F:/downloads/Contracts/'
    # file_name = 'F:/downloads/Contracts/00/00/000000000000c1cb11d5c062901f32d06248ce48'

    # start_idx = 182
    start_idx = 0
    idx = 0

    for file_path in all_files:
        if idx < start_idx:
            idx += 1
            continue

        try:
            with open(file_path, encoding='utf-8') as file:
                descriptors = json.load(file)
                assert isinstance(descriptors, list)
                assert len(descriptors) == 1
                desc = descriptors[0]

                v = int(pattern.match(desc['CompilerVersion']).group(2))

                if 1 <= v <= 9:
                    name = os.path.basename(os.path.normpath(file_path))
                    dst_dir = os.path.join(out_dir, str(v))
                    dst = os.path.join(out_dir, str(v), name)

                    if not os.path.exists(dst_dir):
                        os.makedirs(dst_dir)

                    shutil.copyfile(file_path, dst)
                else:
                    raise ValueError('invalid ver')
        except Exception as e:
            print("error: " + desc['CompilerVersion'])
            # raise e
        finally:
            idx += 1



if __name__ == '__main__1':
    pp.install_extras()
    logging.basicConfig( level=logging.CRITICAL)
    vfs = VirtualFileSystem(
                            base_path='irtests/Stmts.sol',
                            # base_path='example/import_remapping',
                            # cwd=cwd,
                            include_paths=[])

    symtab_builder = symtab.Builder2(vfs)
    ast2_builder = Builder2()

    # vfs.parse_import_remappings('example/import_remapping/remappings.txt')
    # print(vfs.import_remaps)
    # vfs.add_import_remapping('', '@openzeppelin/', 'lib/openzeppelin-contracts/contracts/')
    with open('irtests/Stmts.sol', encoding='utf-8') as f:
        c_code = f.read()

    # with open('example/import_remapping/TestContract.sol', encoding='utf-8') as f:
    #     c_code = f.read()


    loaded_source = vfs._add_loaded_source('CFG1', c_code)
    file_scope = symtab_builder.process_or_find(loaded_source)

    ast2_builder.enqueue_files([file_scope])
    ast2_builder.process_all()

    ir_builder = IRBuilder()

    for u in ast2_builder.get_top_level_units():
        if hasattr(u, 'parts'):
            for p in u.parts:
                if isinstance(p, solnodes2.FunctionDefinition) and p.code:
                    ir_builder.translate_function(p)


if __name__ == '__main__':
    pp.install_extras()
    logging.basicConfig( level=logging.CRITICAL)

    base_dir = 'F:/downloads/Contracts/8'
    all_files = [os.path.join(dp, f) for dp, dn, filenames in os.walk(base_dir) for f in filenames]

    # file_name = 'F:/downloads/Contracts/00/00/000000000000c1cb11d5c062901f32d06248ce48'

    # start_idx = 182
    start_idx = 7
    idx = 0

    for file_path in all_files:
        if idx < start_idx:
            idx += 1
            continue

        try:
            with open(file_path, encoding='utf-8') as file:
                descriptors = json.load(file)
                assert isinstance(descriptors, list)
                assert len(descriptors) == 1
                desc = descriptors[0]

                vfs = VirtualFileSystem(base_path='',
                                        # cwd=cwd,
                                        include_paths=[])

                symtab_builder = symtab.Builder2(vfs)

                file_scopes = []

                try:
                    def creator(input_src):
                        v = collector.get_minor_ver(input_src) or int(pattern.match(desc['CompilerVersion']).group(2))
                        nodes = asthelper.make_ast(input_src, v)
                        for n in nodes:
                            if n:
                                n.ver = v
                        return nodes

                    if desc['SourceCode'].startswith('{{') and desc['SourceCode'].endswith('}}'):
                        source_contents = {}


                        def _read_file_callback(su_name, base_dir, include_paths) -> str:
                            return source_contents[su_name]


                        add_loaded_source_original = vfs._add_loaded_source


                        def _add_loaded_source(source_unit_name: str, source_code: str, _=None):
                            return add_loaded_source_original(source_unit_name, source_code, creator)


                        # required shims
                        vfs._read_file_callback = _read_file_callback
                        vfs._add_loaded_source = _add_loaded_source

                        srcs = json.loads(desc['SourceCode'][1:-1])['sources']
                        for c_name, vv in srcs.items():
                            c_code = vv['content']
                            source_contents[c_name] = c_code

                        for f in source_contents.keys():
                            fs = symtab_builder.process_or_find_from_base_dir(f)
                            file_scopes.append(fs)
                    else:
                        c_name = desc['ContractName'] + '.sol'
                        c_code = desc['SourceCode']
                        loaded_source = vfs._add_loaded_source(c_name, c_code, creator)
                        file_scope = symtab_builder.process_or_find(loaded_source)
                        file_scopes.append(file_scope)
                except errors.AntlrParsingError as e:
                    # i.e. malformed syntax inputs
                    print(f"ast1 parsing error idx={idx}", file=sys.stderr)
                    traceback.print_exc()
                    continue

                ast2_builder = Builder2()
                ast2_builder.enqueue_files(file_scopes)
                ast2_builder.process_all()

                ir_builder = IRBuilder()

                for u in ast2_builder.get_top_level_units():
                    if hasattr(u, 'parts'):
                        for p in u.parts:
                            if isinstance(p, solnodes2.FunctionDefinition) and p.code:
                                try:
                                    ir_builder.translate_function(p)
                                except ValueError as e:
                                    if 'SSA translation not possible' not in e.args[0]:
                                        raise e

                print(f"donezo {file_path} idx={idx}")

        except Exception as e:
            print(f"failure: idx={idx} {file_path}", file=sys.stderr)
            raise e
            # print(contract_source)
            # if idx is not None:
            #     with open(f"../example/errors/Contract{idx}.sol", "w", encoding='utf-8') as text_file:
            #         text_file.write(contract_source)
        finally:
            idx += 1



if __name__ == '__main__1':
    pp.install_extras()
    logging.basicConfig( level=logging.DEBUG)
    # p = Path('../example/TestInput.json').resolve()
    # with p.open(mode='r', encoding='utf-8') as f:
    #     data = f.read()
    # input = jsons.loads(data, StandardJsonInput)
    # print(input)
    # x = json.loads(data, object_hook=lambda d: SimpleNamespace(**d))
    # print(x.name, x.hometown.name, x.hometown.id)

    # base_dir = 'C:/Users/Bilal/Downloads/solidity-examples-main/solidity-examples-main/contracts'
    base_dir = 'C:/Users/bibl/Downloads/solidity-examples-main/contracts'
    # base_dir = 'C:/Users/bibl/Downloads/ERC721A/contracts'
    # base_dir = 'C:/Users/bibl/Downloads/debridge-contracts-v1'
    # base_dir = 'F:/Zellic/Workspace/solidity-parser/testcases'
    # lets say we're in the /examples folder and go backwards to StargateComposed.sol in CLI
    # cwd = 'C:/Users/Bilal/Downloads/solidity-examples-main/solidity-examples-main/contracts/examples'
    # node_modules_dir = 'C:/Users/Bilal/node_modules'
    node_modules_dir = 'C:/Users/bibl/AppData/Roaming/npm/node_modules'
    vfs = VirtualFileSystem(base_path=base_dir,
                            # cwd=cwd,
                            include_paths=[node_modules_dir])

    # vfs.process_cli_input_file('C:/Users/Bilal/Downloads/solidity-examples-main/solidity-examples-main/contracts/StargateComposed.sol')
    # vfs.process_cli_input_file('C:/Users/Bilal/Downloads/solidity-examples-main/solidity-examples-main/contracts/examples/ExampleOFT.sol')
    # vfs.process_cli_input_file('.././StargateComposed.sol')

    # vfs.process_standard_json('../example/TestInput.json')

    symtab_builder = symtab.Builder2(vfs)
    
    # file_scope = builder.process_file('@openzeppelin/contracts-upgradeable/proxy/utils/Initializable.sol')
    # contract_scope = file_scope.find('Initializable')
    
    # file_scope = builder.process_file('lzApp/NonblockingLzApp.sol')
    # contract_scope = file_scope.find('NonblockingLzApp')[0].value

    # file_scope = builder.process_file('@openzeppelin/contracts/token/ERC721/ERC721.sol')
    # contract_scope = file_scope.find('ERC721')[0].value

    # pp.pprint(contract_scope[0].value)
    ast2_builder = Builder2()

    # b2.define_skeleton(contract_scope, file_scope.source_unit_name)

    all_files = [y for x in os.walk(base_dir) for y in glob(os.path.join(x[0], '*.sol'))]
    all_files = [r[len(base_dir)+len('\\'):] for r in all_files]
    all_files = [f'./{f}' for f in all_files]

    for f in all_files:
        fs = symtab_builder.process_or_find_from_base_dir(f)
        for s in fs.symbols.values():
            if len(s) != 1 or s[0].parent_scope != fs:
                continue
            n = s[0].value
            if not hasattr(n, 'ast2_node') and ast2_builder.is_top_level(n):
                ast2_builder.define_skeleton(n, fs.source_unit_name)

    # fs = symtab_builder.process_or_find_from_base_dir('contracts/libraries/Flags.sol')
    # for s in fs.symbols.values():
    #     if len(s) != 1:
    #         continue
    #     n = s[0].value
    #     if not hasattr(n, 'ast2_node') and ast2_builder.is_top_level(n):
    #         ast2_builder.define_skeleton(n, fs.source_unit_name)


    ast2_builder.process_all()

    print("donezo")


    # syms = [x for xs in builder.root_scope.symbols.values() for x in xs if isinstance(x, symtab.FileScope)]
    # print(syms)
    # c2 = contract_scope[0].value.ast2_node
    # c2.get_children()
    # with open('output.txt', 'wt') as out:
    #     pp.pprint(c2, stream=out)

    # print([str(c.value.name) for c in c3_linearise(contract_scope)])

    # funcanalysis.dfs(contract_scope[0].value)
    # print(contract_scope.get_local_method('swapNativeForNative'))

if __name__ == '__main__1':
    # base_dir = 'C:/Users/Bilal/Downloads/contracts-30xx-only.tar/contracts-30xx-only'
    # all_files = [os.path.join(dp, f) for dp, dn, filenames in os.walk(base_dir) for f in filenames]
    # all_files = ['C:/Users/Bilal/Downloads/contracts-30xx-only.tar/contracts-30xx-only\\contracts\\30\\00\\30002861577da4ea6aa23966964172ad75dca9c7']
    # # start_idx = 10516
    # start_idx = 0
    # #
    # idx = 0
    # for info in get_contracts_from_descriptors(all_files):
    #     if idx >= start_idx:
    #         try_parse_contract(*info, idx=idx)
    #     idx += 1

    input_src = open(
        'C:/Users/bibl/Downloads/x/RLPReader.sol',
        'r').read()

    # try_parse_contract('ft', 8, input_src, None)

    lexer = SolidityLexer088(InputStream(input_src))
    stream = CommonTokenStream(lexer)
    parser = SolidityParser088(stream)
    ast_parser = Parser088()

    tree = parser.sourceUnit()
    source_units = tree.children

    # symtab_builder = symtab.Builder2(None)

    # ast_nodes = list(map(ast_parser.make, source_units))

    # file_path = Path('../example/AaveToken.sol').resolve()
    # symtab_builder.process_file(file_path, ast_nodes)

    # base_dir = '../example/Aave/'
    # base_dir = 'C:/Users/Bilal/Downloads/solidity-examples-main/solidity-examples-main/contracts'

    # base_dir = 'C:/Users/Bilal/Downloads/solidity-examples-main/solidity-examples-main/contracts/mocks'
    # file_paths = [os.path.join(dirpath, f) for (dirpath, dirnames, filenames) in os.walk(base_dir) for f in filenames if f.endswith('.sol')]

    # all_ast_nodes = []
    # for fp in file_paths:
    #     # if not fp.endswith('ProxyOFTV2.sol'):
    #     #     continue
    #     ast_nodes = get_ast(fp)
    #     full_path = Path(fp).resolve()
    #     symtab_builder.process_file(full_path, ast_nodes)
    #     all_ast_nodes = all_ast_nodes + ast_nodes


    # for su in source_units:
    #     u = ast_parser.make(su)
    #
    #     if isinstance(u, solnodes.ContractDefinition) and str(u.name) == 'ClockAuctionBase':
    #         symtab_builder.process_source_unit(u)

    # root_scope = symtab_builder.root_scope

    # print(root_scope)

    # file_scope = root_scope.follow_find('<path:C:\\>', '<path:Users>', '<path:Bilal>',
    #                              '<path:zellicworkspace>', '<path:solidity-parser>',
    #                              '<path:example>', '<path:Aave>', '<path:main>', '<file:AaveToken.sol>')
    # print(root_scope)
    # contract_scope = file_scope.find_local('AaveToken')
    # This text is 'ITransferHook'
    # itransferhook_type = contract_scope.find_local('_aaveGovernance').value.var_type.text
    # scope that is valid at this decl
    # aavegovernance_state_var_decl_scope: symtab.Scope = contract_scope

    # print(aavegovernance_state_var_decl_scope.find(itransferhook_type))
    # print(root_scope)
    # print(contract_scope.find('VersionedInitializable').resolve('VersionedInitializable'))

    # scope_in_bid_func = root_scope.find('ClockAuctionBase').find('_bid')

    # im in bid function, now I see the symbol 'Auction' => find it for me pls

    # auction_sym = scope_in_bid_func.find('Auction')
    #
    # print(root_scope)

    # for n in all_ast_nodes:
    #     if n and isinstance(n, solnodes.ContractDefinition) and n.name.text == 'StargateComposed':
    #         dfs(n)
    # print(len(all_ast_nodes))


        # if hasattr(u, 'parts'):
        #     parts = u.parts

            # for p in parts:
            #     if isinstance(p, solnodes.FunctionDefinition):
            #         arg_string = ', '.join(map(str, p.args))
            #         return_string = ', '.join(map(str, p.returns))
            #         print(f"FUNC {u.name}.{p.name} takes ({arg_string}) and returns ({return_string})")
            #
            #         pp.pprint(p.code)
            #
            #
            #         break



if __name__ == "__main__1":
    # c = Contract('weth9', ContractType.CONTRACT, False, [])
    # print(c)
    pp.install_extras()
    input_src = open(
        # sys.argv[1],
        'example/cryptokitties.sol',
        # '../example/greedy-airdropper.sol',
        # '../example/AaveToken.sol',
        'r').read()
    # minor_vers = get_minor_ver(input_src)
    # for obj in collect_top_level_objects(input_src, minor_vers):
    #     print(f'=== {obj.name} ===')
    #     print(obj.content)
    #     print(obj)
    data = InputStream(input_src)
    # lexer = SolidityLexer(data)
    # stream = CommonTokenStream(lexer)
    # parser = SolidityParser(stream)

    # tree = parser.sourceUnit()
    # source_units = tree.children

    # p = Parser060()

    # for su in source_units:
        # visit(su)
        # u = p.make(su)
        # pp.pprint(u)
