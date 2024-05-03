# makes this file easily runnable in Pycharm
if __name__ == '__main__':
    pass


from pathlib import Path
from dataclasses import dataclass

from solidity_parser import filesys
from solidity_parser.ast import symtab, ast2builder, solnodes2, solnodes

# this is user input
files_to_annotate = ['TheContract.sol']
project_dir = Path('./gptcomments')

# setup VFS
vfs = filesys.VirtualFileSystem(project_dir, None, [])
sym_builder = symtab.Builder2(vfs)


def should_annotate_part(part: solnodes.ContractPart):
    return True


from gpt4all import GPT4All
model = GPT4All("orca-mini-3b-gguf2-q4_0.gguf")

system_template = 'A chat between a Solidity developer and an artificial intelligence assistant who can audit Solidity code.\n'
# many models use triple hash '###' for keywords, Vicunas are simpler:
prompt_template = 'USER: Write a short comment detailing what this function does:{0}: '


def annotate_func(func_code, func: solnodes.FunctionDefinition):
    # with model.chat_session(system_template, prompt_template):
    #     response1 = model.generate(func_code)
    #     return response1
    return f'This is a test comment for: {func.name}'


@dataclass
class Insertion:
    func: solnodes.FunctionDefinition
    comment: str

import re

INDENT_REG = re.compile(r'[ \t]+$')

def get_trailing_whitespace(s) -> str:
    match = INDENT_REG.search(s)
    if match:
        return match.group(0)
    else:
        return ""

LINE_REG = re.compile("\r?\n")

def indent_by(s, indentation) -> str:
    return ("\n" + indentation).join(LINE_REG.split(s))


def modify_text(src_code, insertions):
    reverse_sorted_insertions = sorted(insertions, key=lambda x: (-x.func.start_location.line, x.func.start_location.column))
    current_source_code = src_code

    for ins in reverse_sorted_insertions:
        func_text_offset = ins.func.start_buffer_index
        left, right = (current_source_code[0:func_text_offset], current_source_code[func_text_offset:])

        # for formatting the comments nicely
        whitespace = get_trailing_whitespace(left)
        formatted_comment = indent_by(f'// {ins.comment}', whitespace)
        current_source_code = left + formatted_comment + '\n' + whitespace + right

    return current_source_code


def annotate_file(file_name):
    file_sym_info = sym_builder.process_or_find_from_base_dir(file_name)
    loaded_src = vfs.sources[file_name]

    ast1_nodes, src_code = loaded_src.ast, loaded_src.contents

    insertions = []

    for node in ast1_nodes:
        if not node:
            continue

        for func in node.get_all_children(lambda x: isinstance(x, solnodes.FunctionDefinition)):
            if should_annotate_part(func):
                func_code = src_code[func.start_buffer_index:func.end_buffer_index]
                comment_contents = annotate_func(func_code, func)
                insertions.append(Insertion(func, comment_contents))

    print(modify_text(src_code, insertions))

for f in files_to_annotate:
    annotate_file(f)
annotate_file('TheContract.sol')

