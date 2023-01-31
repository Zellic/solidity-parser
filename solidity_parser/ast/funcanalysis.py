from solidity_parser.ast import solnodes
from solidity_parser.ast import symtab

import prettyprinter as pp


def type_of(expr):
    if isinstance(expr, solnodes.CallFunction):
        callee = expr.callee
        callee_scope = callee.scope
        print(expr)
        # if isinstance(callee, solnodes.Ident):
    #
    elif isinstance(expr, solnodes.GetMember):
        if isinstance(expr.obj_base, solnodes.Ident):
            base_symbols = expr.scope.find(expr.obj_base.text)
            if len(base_symbols) == 1:
                base_symbol = base_symbols[0]
                member_symbols = base_symbol.find(expr.name.text)
                if not member_symbols:
                    raise ValueError(f'{expr}')
                member_symbol = member_symbols[0]
                # print(f't({expr.obj_base.text}.{expr.name.text}) = {member_symbol} :: {member_symbol.type_of()}')
                return member_symbol.type_of()
            else:
                raise ValueError(f'{expr}')
        else:
            base_type = type_of(expr.obj_base)
            # print(expr)


def dfs(node):
    for child in node.get_children():
        if isinstance(child, solnodes.Expr):
            t = type_of(child)
            if t:
                print(f'typeOf({child}) = {t}')
        dfs(child)
