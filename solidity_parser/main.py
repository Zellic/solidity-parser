import sys

from antlr4 import InputStream, CommonTokenStream, TerminalNode

from solidity_parser.grammar.v060.SolidityLexer import SolidityLexer as SolidityLexer060
from solidity_parser.grammar.v060.SolidityParser import SolidityParser as SolidityParser060


from solidity_parser.grammar.v070.SolidityLexer import SolidityLexer as SolidityLexer070
from solidity_parser.grammar.v070.SolidityParser import SolidityParser as SolidityParser070

from solidity_parser.grammar.v080.SolidityLexer import SolidityLexer as SolidityLexer080
from solidity_parser.grammar.v080.SolidityParser import SolidityParser as SolidityParser080

from solidity_parser.collectors.collector import collect_top_level_objects, get_minor_ver
# from solidity_parser.ast.nodes import Contract, ContractType
import prettyprinter as pp

from solidity_parser.ast.parsers.parsers060 import Parser060
from solidity_parser.ast.parsers.parsers070 import Parser070
from solidity_parser.ast.parsers.parsers080 import Parser080

from solidity_parser.ast import solnodes, symtab

import os
import json
from json import JSONDecoder

from pathlib import Path

from solidity_parser.filesys import VirtualFileSystem

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
    input_src = open(file_path, 'r').read()
    version = get_minor_ver(input_src)

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

    contract_input = InputStream(input_src)
    lexer = grammar_lexer_type(contract_input)
    stream = CommonTokenStream(lexer)
    parser = grammar_parser_type(stream)

    parse_tree = parser.sourceUnit()
    source_units = parse_tree.children

    ast_nodes = list(map(ast_parser.make, source_units))

    return ast_nodes


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

if __name__ == '__main__':
    vfs = VirtualFileSystem('')
    print(vfs.compute_source_unit_name("./util/./util.sol", "lib/src/../contract.sol"))

if __name__ == '__main__1':
    base_dir = 'C:/Users/Bilal/Downloads/contracts-30xx-only.tar/contracts-30xx-only'
    all_files = [os.path.join(dp, f) for dp, dn, filenames in os.walk(base_dir) for f in filenames]
    # all_files = ['C:/Users/Bilal/Downloads/contracts-30xx-only.tar/contracts-30xx-only\\contracts\\30\\00\\30002861577da4ea6aa23966964172ad75dca9c7']
    # start_idx = 10516
    # start_idx = 0
    #
    # idx = 0
    # for info in get_contracts_from_descriptors(all_files):
    #     if idx >= start_idx:
    #         try_parse_contract(*info, idx=idx)
    #     idx += 1

    # input_src = open(
    #     '../example/AaveToken.sol',
    #     'r').read()

    # try_parse_contract('ft', 8, input_src, None)

    # lexer = SolidityLexer080(InputStream(input_src))
    # stream = CommonTokenStream(lexer)
    # parser = SolidityParser080(stream)
    # ast_parser = Parser080()
    #
    # tree = parser.sourceUnit()
    # source_units = tree.children

    symtab_builder = symtab.Builder2()

    # ast_nodes = list(map(ast_parser.make, source_units))

    # file_path = Path('../example/AaveToken.sol').resolve()
    # symtab_builder.process_file(file_path, ast_nodes)

    base_dir = '../example/Aave/'
    base_dir = 'C:/Users/Bilal/Downloads/solidity-examples-main/solidity-examples-main/contracts'

    # base_dir = 'C:/Users/Bilal/Downloads/solidity-examples-main/solidity-examples-main/contracts/mocks'
    file_paths = [os.path.join(dirpath, f) for (dirpath, dirnames, filenames) in os.walk(base_dir) for f in filenames if f.endswith('.sol')]

    all_ast_nodes = []
    for fp in file_paths:
        # if not fp.endswith('ProxyOFTV2.sol'):
        #     continue
        ast_nodes = get_ast(fp)
        full_path = Path(fp).resolve()
        symtab_builder.process_file(full_path, ast_nodes)
        all_ast_nodes = all_ast_nodes + ast_nodes


    # for su in source_units:
    #     u = ast_parser.make(su)
    #
    #     if isinstance(u, solnodes.ContractDefinition) and str(u.name) == 'ClockAuctionBase':
    #         symtab_builder.process_source_unit(u)

    root_scope = symtab_builder.root_scope

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

    for n in all_ast_nodes:
        if n and isinstance(n, solnodes.ContractDefinition) and n.name.text == 'StargateComposed':
            dfs(n)
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
        '../example/cryptokitties.sol',
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
