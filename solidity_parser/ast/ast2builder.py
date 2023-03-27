from dataclasses import dataclass, replace as copy_dataclass
from typing import List, Tuple, Union, Optional, Dict, Set, Deque, NamedTuple
from collections import deque, namedtuple


from solidity_parser.ast import solnodes as solnodes1
from solidity_parser.ast import solnodes2 as solnodes2
from solidity_parser.ast import symtab

import logging
import math
from solidity_parser.ast.mro_helper import c3_linearise


class TypeHelper:
    def __init__(self, builder):
        self.builder = builder

    @staticmethod
    def any_or_all(args):
        return (len(args) == 0) or (any(args) == all(args))

    def find_event(self, ttype: solnodes2.ResolvedUserType, name: str) -> solnodes2.EventDefinition:
        # Not sure if inheritance is allowed for events. Afaik a contract can only call events defined in itself

        unit = ttype.value.x

        assert isinstance(unit, (solnodes2.ContractDefinition, solnodes2.InterfaceDefinition))

        def matches(x):
            # TODO: parameter type match
            return isinstance(x, solnodes2.EventDefinition) and x.name.text == name
        candidates = [x for x in unit.parts if matches(x)]

        assert len(candidates) == 1

        return candidates[0]

    def get_expr_type(self, expr: solnodes1.Expr, allow_multiple=False, force_tuple=False) -> solnodes2.Type:
        if isinstance(expr, solnodes1.Type):
            return self.map_type(expr)
        elif isinstance(expr, solnodes1.Ident):
            def get_current_contract():
                return self.symbol_to_ast2_type(self.builder.get_declaring_contract(expr))

            text = expr.text
            if text == 'this':
                return get_current_contract()
            elif text == 'super':
                return solnodes2.SuperType(get_current_contract())
            else:
                if allow_multiple:
                    return [self.symbol_to_ast2_type(s) for s in expr.scope.find(text)]
                else:
                    return self.symbol_to_ast2_type(expr.scope.find_single(text))
        elif isinstance(expr, solnodes1.GetMember):
            base_type = self.get_expr_type(expr.obj_base)
            member = expr.name.text

            # check the scope of the base type
            # then check the current contract/interface/library/scope to see if it's an overriden type with the using
            # directive
            scopes = self.scope_for_type(expr, base_type)

            if allow_multiple:
                for s in scopes:
                    symbols = s.find(member)
                    if symbols:
                        return [self.symbol_to_ast2_type(s) for s in symbols]
            else:
                for s in scopes:
                    symbol = s.find_single(member)
                    if symbol:
                        return self.symbol_to_ast2_type(symbol)
            return []
        elif isinstance(expr, solnodes1.Literal):
            value = expr.value
            if isinstance(value, bool):
                # this needs to go before the int check as bool is a subclass of int in python
                return solnodes2.BoolType()
            elif isinstance(value, int):

                if value == 0:
                    return solnodes2.UIntType(8)

                if value > 0:
                    # uint
                    signed = False
                else:
                    # int
                    if value < 0:
                        value = -value - 1

                    value = value * 2
                    signed = True

                # count number of bytes required
                bytes = 1
                while value >= (1 << (bytes * 8)):
                    bytes += 1
                bits = bytes * 8

                if bits > 256:
                    raise ValueError('too many bits')

                return solnodes2.IntType(is_signed=signed, size=bits)
            elif isinstance(value, str):
                return solnodes2.StringType()
            elif isinstance(value, tuple):
                type_args = [self.map_as_type_arg(arg) for arg in value]
                are_type_args = [isinstance(arg, (solnodes1.Type, solnodes2.Type)) for arg in type_args]
                assert TypeHelper.any_or_all(are_type_args)

                if any(are_type_args):
                    # the grammar has 'TupleExpression' s, e.g. '(' exprList ')'. The exprs it allows can also be types.
                    # Either all or none of the exprs must be types
                    # but the parser is weird
                    if len(type_args) == 1 and not force_tuple:
                        return self.map_type(type_args[0])
                    else:
                        return solnodes2.TupleType([self.map_type(t) for t in type_args])

                assert all([isinstance(e, solnodes1.Expr) for e in value])
                if len(value) == 1:
                    if force_tuple:
                        return solnodes2.TupleType([self.get_expr_type(value[0])])
                    else:
                        # Bracketed expressions, not tuples, e.g. (x).y() , (x) isn't a tuple so unpack here
                        return self.get_expr_type(value[0])
                else:
                    return solnodes2.TupleType([self.get_expr_type(e) for e in value])
            else:
                return self.builder._todo(value)
        elif isinstance(expr, solnodes1.GetArrayValue):
            base_type = self.get_expr_type(expr.array_base)
            if isinstance(base_type, solnodes2.MappingType):
                return base_type.dst
            elif isinstance(base_type, solnodes2.ArrayType):
                return base_type.base_type
            else:
                return self.builder._todo(base_type)
        elif isinstance(expr, solnodes1.BinaryOp):
            if expr.op in [solnodes1.BinaryOpCode.BOOL_AND, solnodes1.BinaryOpCode.BOOL_OR, solnodes1.BinaryOpCode.EQ,
                           solnodes1.BinaryOpCode.NEQ]:
                return solnodes2.BoolType()
            elif expr.op in [solnodes1.BinaryOpCode.LTEQ, solnodes1.BinaryOpCode.LT, solnodes1.BinaryOpCode.GT,
                             solnodes1.BinaryOpCode.GTEQ]:
                return solnodes2.BoolType()
            elif expr.op in [solnodes1.BinaryOpCode.LSHIFT, solnodes1.BinaryOpCode.RSHIFT,
                             solnodes1.BinaryOpCode.ASSIGN_LSHIFT, solnodes1.BinaryOpCode.ASSIGN_RSHIFT]:
                # result of a shift has the type of the left operand (from docs)
                return self.get_expr_type(expr.left)
            elif expr.op == solnodes1.BinaryOpCode.EXPONENTIATE:
                # result is type of the base
                return self.get_expr_type(expr.left)
            elif expr.op in [solnodes1.BinaryOpCode.MUL, solnodes1.BinaryOpCode.DIV, solnodes1.BinaryOpCode.MOD,
                             solnodes1.BinaryOpCode.ADD, solnodes1.BinaryOpCode.SUB,
                             solnodes1.BinaryOpCode.BIT_AND, solnodes1.BinaryOpCode.BIT_OR,
                             solnodes1.BinaryOpCode.BIT_XOR,
                             solnodes1.BinaryOpCode.ASSIGN_BIT_NEG, solnodes1.BinaryOpCode.ASSIGN_BIT_AND,
                             solnodes1.BinaryOpCode.ASSIGN, solnodes1.BinaryOpCode.ASSIGN_OR,
                             solnodes1.BinaryOpCode.ASSIGN_MUL, solnodes1.BinaryOpCode.ASSIGN_DIV,
                             solnodes1.BinaryOpCode.ASSIGN_MOD,solnodes1.BinaryOpCode.ASSIGN_ADD,
                             solnodes1.BinaryOpCode.ASSIGN_SUB]:
                # If this is an assign, i.e. X = Y, then X can be a tuple (synthetically in Solidity) but
                # otherwise tuples don't exist
                # i.e. allow (a,b) = f() but not x + f() where f() returns (int, int)
                t1 = self.get_expr_type(expr.left, force_tuple=expr.op.name.startswith('ASSIGN'))
                t2 = self.get_expr_type(expr.right)
                if expr.op != solnodes1.BinaryOpCode.ASSIGN:
                    # can only compare ints, but we can't use t1 == t2 as we can compare different int types, e.g.
                    # this.x (uint256) == 0 (uint8)
                    assert (t1.is_int() and t2.is_int()) or\
                           (solnodes2.is_byte_array(t1) and solnodes2.is_byte_array(t2)) or \
                           (solnodes2.is_byte_array(t1) and t2.is_int())

                    if t1.is_int():  # t2 is also an int here
                        return t1 if t1.size > t2.size else t2
                else:
                    if not isinstance(t2, solnodes2.TupleType):
                        # tuple assign, note the lhs can have a subset of the RHS, e.g. (a, ) = f()
                        # FIXME: check this properly, myBytes[i] = "x";
                        assert (t1.can_implicitly_cast_from(t2)) or (
                                    isinstance(t1, solnodes2.ByteType) and isinstance(t2, solnodes2.StringType))
                return t2
            else:
                return self.builder._todo(expr.op)
        elif isinstance(expr, solnodes1.TernaryOp):
            t1 = self.get_expr_type(expr.left)
            t2 = self.get_expr_type(expr.right)

            assert isinstance(t1, solnodes2.IntType) == isinstance(t2, solnodes2.IntType)
            if isinstance(t1, solnodes2.IntType):
                # if they're both ints, then take the bigger type
                return t1 if t1.size > t2.size else t2
            else:
                assert t1 == t2
                return t1
        elif isinstance(expr, solnodes1.UnaryOp):
            if expr.op in [solnodes1.UnaryOpCode.INC, solnodes1.UnaryOpCode.DEC, solnodes1.UnaryOpCode.SIGN_NEG,
                           solnodes1.UnaryOpCode.SIGN_POS, solnodes1.UnaryOpCode.BIT_NEG]:
                return self.get_expr_type(expr.expr)
            elif expr.op == solnodes1.UnaryOpCode.BOOL_NEG:
                return solnodes2.BoolType()
            else:
                return self.builder._todo(expr.op)
        elif isinstance(expr, solnodes1.CallFunction):
            return self.get_function_expr_type(expr, allow_multiple=allow_multiple)
        elif isinstance(expr, solnodes1.CreateMetaType):
            return solnodes2.MetaTypeType(self.map_type(expr.base_type))
        elif isinstance(expr, solnodes1.New):
            return self.map_type(expr.type_name)
        elif isinstance(expr, solnodes1.PayableConversion):
            return solnodes2.AddressType(is_payable=True)
        elif isinstance(expr, solnodes1.NamedArg):
            return self.get_expr_type(expr.value)
        return self.builder._todo(expr)

    def get_function_expr_type(self, expr, allow_multiple=False, return_target_symbol=False):

        def do_return(symbol, ttype):
            if return_target_symbol:
                return symbol, ttype
            else:
                return ttype

        callee = expr.callee
        if isinstance(callee, solnodes1.Type):
            if callee.is_address():
                # special case where address(uint160) maps to address payable:
                # see https://docs.soliditylang.org/en/develop/050-breaking-changes.html
                assert len(expr.args) == 1
                arg_type = self.get_expr_type(expr.args[0])

                if arg_type.is_int() and not arg_type.is_signed and arg_type.size == 160:
                    return solnodes2.AddressType(is_payable=True)

            # e.g. int(...), string(...), address(...) => cast expr
            return self.map_type(callee)

        arg_types = [self.get_expr_type(arg) for arg in expr.args]

        func_types = self.get_expr_type(callee, allow_multiple=True)

        if not isinstance(func_types, list):
            func_types = [func_types]

        def is_not_func(t):
            return isinstance(t, solnodes2.Type) and not isinstance(t, solnodes2.FunctionType)

        type_calls = [is_not_func(ft) for ft in func_types]
        assert TypeHelper.any_or_all(type_calls)

        if any(type_calls):
            assert len(func_types) == 1
            tc = func_types[0]
            # constructor call/new type
            if tc.is_builtin():
                # e.g. new string(xxx)
                return tc
            else:
                # e.g. new MyX(), or MyX(val)
                # TODO: check if we should return the constructor function type here instead
                return tc

        assert all([isinstance(ft, solnodes2.FunctionType) for ft in func_types])

        candidates = []
        for ft in func_types:
            # None is a sentinel, do NOT do if ft.inputs:
            if ft.inputs is not None:
                # match input types
                if len(ft.inputs) == len(arg_types):
                    if all([targ.can_implicitly_cast_from(actual) for targ, actual in zip(ft.inputs, arg_types)]):
                        candidates.append(ft)
            else:
                # input types == None => polymorphic builtin function. This isn't the same as a no arg function,
                # where input types == []
                candidates.append(ft)

        if len(candidates) != 1:
            raise ValueError('Can\'t resolve call')

        output_types = candidates[0].outputs

        # Special case: check if abi.decode is called as its output types depend on its input types
        #  i.e. output_types is set to None in the symbol table as it's inputs and outputs are completely
        #       generic
        if isinstance(callee, solnodes1.GetMember) and isinstance(callee.obj_base, solnodes1.Ident):
            if callee.obj_base.text == 'abi' and callee.name.text == 'decode':
                assert output_types is None
                # drop the first argument type so output types are t1, t2...
                #  abi.decode(bytes memory encodedData, (t1, t2...)) returns (t1, t2...)
                output_types = arg_types[1:]

        if allow_multiple:
            return output_types
        else:
            if len(output_types) == 1:
                return output_types[0]
            else:
                return solnodes2.TupleType(output_types)

    def map_as_type_arg(self, arg):
        # grammar shenanigans again...
        # sometimes stuff like uint[] gets parsed as GetArrayValue(array_base=IntType(...), index=None))
        if isinstance(arg, solnodes1.Type):
            # simple case
            return arg
        if isinstance(arg, solnodes1.Ident):
            # lookup the ident in the current scope and if it's a top level type, it's a type
            symbols = arg.scope.find(arg.text)
            if len(symbols) == 1 and self.builder.is_top_level(symbols[0].value):
                return self.symbol_to_ast2_type(symbols[0])
        if isinstance(arg, solnodes1.GetArrayValue):
            if isinstance(arg.array_base, solnodes1.Type):
                assert arg.index is None
                # make a copy of the base type and put it in an array
                type_copy = copy_dataclass(arg.array_base)
                return solnodes1.ArrayType(type_copy)
            elif arg.index is None:
                # could possibly be but haven't seen an array_base for this case yet...
                assert False
        return arg

    def param_types(self, ps):
        return [self.map_type(p.var_type) for p in ps]

    def symbol_to_ast2_type(self, symbol) -> solnodes2.Type:

        if isinstance(symbol, symtab.UsingFunctionSymbol):
            value = symbol.value
            # X.abc(), remove the type of X to the start of the input types
            return solnodes2.FunctionType(self.param_types(value.parameters)[1:], self.param_types(value.returns))

        symbol = symbol.resolve_base_symbol()
        if isinstance(symbol, symtab.BuiltinObject):
            if v:=symbol.value:
                # if this builtin object was created to scope a type, e.g. an byte[] or int256, etc, just
                # resolve to the type directly instead of shadowing it as a builtin type
                assert isinstance(v, (solnodes1.Type, solnodes2.Type))
                return self.map_type(v)
            else:
                return solnodes2.BuiltinType(symbol.name)
        elif isinstance(symbol, symtab.BuiltinFunction):
            # These input type checks need to be 'is not None' instead of just if symbol.input_types as some of these
            # might be empty lists (meaning to inputs or outputs in the function) whereas 'None' indicates that the
            # function accepts any parameter types there (fully polymorphic).
            #  At the moment 'None' output_types is only used for abi.decode
            input_types = [self.map_type(ttype) for ttype in symbol.input_types] if symbol.input_types is not None else None
            output_types = [self.map_type(ttype) for ttype in symbol.output_types] if symbol.output_types is not None else None
            return solnodes2.FunctionType(input_types, output_types)
        elif isinstance(symbol, symtab.BuiltinValue):
            ttype = symbol.ttype

            if isinstance(ttype, solnodes2.Type):
                # For builtin values that we create in scope_for_type, we pass in an AST2 Type instead of AST1 Type
                return ttype
            else:
                return self.map_type(ttype)

        value = symbol.value

        if self.builder.is_top_level(value):
            # Contract, interface, struct, library
            return self.get_contract_type(symbol)
        elif isinstance(value, (solnodes1.Parameter, solnodes1.Var)):
            return self.map_type(value.var_type)
        elif isinstance(value, solnodes1.FunctionDefinition):
            return solnodes2.FunctionType(self.param_types(value.parameters), self.param_types(value.returns))
        elif isinstance(value, solnodes1.ErrorDefinition):
            # AFAIK this is only used for MyError.selector
            return solnodes2.FunctionType(self.param_types(value.parameters), [])
        elif isinstance(value, (solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration)):
            # Mappings are stored as fields but have mapping types
            return self.map_type(value.var_type)
        elif isinstance(value, solnodes1.StructMember):
            return self.map_type(value.member_type)
        elif isinstance(value, solnodes1.Ident):
            if isinstance(value.parent, solnodes1.EnumDefinition):
                # this is an enum member, the type is the enum itself
                assert isinstance(value.scope, symtab.EnumScope)
                return self.symbol_to_ast2_type(value.scope)
        assert False, f'{type(value)}'

    def scope_for_type(self, node: solnodes1.Node, ttype: solnodes2.Type) -> List[symtab.Scope]:
        # TODO: remove this comment
        # Important note for creating dynamic scopes: we pass in AST2 Types instead of AST1 Types as they're easier to
        # work with and often provide more information(i.e. AST12 ResolvedUserTypes are linked to actual contracts
        # whereas AST1 UserTypes aren't). This is against the type constraints annotating the symbol table code, but we
        # can still make it work using duck typing 🤮. When AST2 code does lookups in the symbol table and finds AST2
        # types, it shortcuts and uses them instead of trying to convert them from AST1 to AST2 types so be careful.

        if isinstance(ttype, solnodes2.SuperType):
            return c3_linearise(self.builder.get_declaring_contract(node))
        elif isinstance(ttype, solnodes2.ResolvedUserType):
            scope = node.scope.find_single(ttype.value.x.name.text)

            if scope is None:
                # Weird situation where an object of type T is used in a contract during an intermediate computation but
                # T isn't imported. E.g. (x.y).z = f() where x.y is of type T and f returns an object of type S but
                # T isn't imported in the contract. This is the AddressSlot case in ERC1967Upgrade
                scope = ttype.scope
        elif isinstance(ttype, solnodes2.BuiltinType):
            scope = node.scope.find_single(ttype.name)
        elif isinstance(ttype, solnodes2.MetaTypeType):
            # HEY! CHECK NOTE at start of function
            is_interface = isinstance(ttype.ttype, solnodes2.ResolvedUserType)\
                           and isinstance(ttype.ttype.value.x, solnodes2.InterfaceDefinition)
            scope = node.scope.find_metatype(ttype.ttype, is_interface)
        else:
            scope = node.scope.find_type(ttype)

        assert isinstance(scope, symtab.Scope)
        return [scope]
    
    def map_type(self, ttype: Union[solnodes1.Type, solnodes2.Type]) -> solnodes2.Type:
        if isinstance(ttype, solnodes2.Type):
            return ttype

        if isinstance(ttype, solnodes1.UserType):
            return self.get_user_type(ttype)
        elif isinstance(ttype, solnodes1.VariableLengthArrayType):
            return solnodes2.VariableLengthArrayType(self.map_type(ttype.base_type), self.builder.refine_expr(ttype.size))
        elif isinstance(ttype, solnodes1.FixedLengthArrayType):
            return solnodes2.FixedLengthArrayType(self.map_type(ttype.base_type), ttype.size)
        elif isinstance(ttype, solnodes1.ArrayType):
            return solnodes2.ArrayType(self.map_type(ttype.base_type))
        elif isinstance(ttype, solnodes1.AddressType):
            return solnodes2.AddressType(ttype.is_payable)
        elif isinstance(ttype, solnodes1.ByteType):
            return solnodes2.ByteType()
        elif isinstance(ttype, solnodes1.IntType):
            return solnodes2.IntType(ttype.is_signed, ttype.size)
        elif isinstance(ttype, solnodes1.BoolType):
            return solnodes2.BoolType()
        elif isinstance(ttype, solnodes1.StringType):
            return solnodes2.StringType()
        elif isinstance(ttype, solnodes1.MappingType):
            return solnodes2.MappingType(self.map_type(ttype.src), self.map_type(ttype.dst))

        self.builder._todo(ttype)

    def get_contract_type(self, user_type_symbol: symtab.Symbol) -> solnodes2.ResolvedUserType:
        assert isinstance(user_type_symbol, symtab.Scope)
        ttype = solnodes2.ResolvedUserType(solnodes2.Ref(self.builder.load_if_required(user_type_symbol)))
        ttype.scope = user_type_symbol
        return ttype

    def get_user_type(self, ttype: solnodes1.UserType):
        """Maps an AST1 UserType to AST2 ResolvedUserType"""
        name = ttype.name.text

        # This is needed for old contracts before the 'constructor' keyword was used so that when we look up 'X'
        # we don't hit 'function X' i.e. the constructor in the current contract, instead we only look for a user type
        symtab_type_predicate = lambda scope: self.builder.is_top_level(scope.value)

        if '.' in name:
            # this is a qualified identifier, i.e. X.Y or X.Y.Z, etc
            parts = name.split('.')
            scope = ttype.scope

            for p in parts:
                scope = scope.find_single(p, predicate=symtab_type_predicate)
            s = scope
        else:
            s = ttype.scope.find_single(name, predicate=symtab_type_predicate)

        if not s:
            raise ValueError(f"Can't resolve {ttype}")

        return self.get_contract_type(s)


class Builder:

    def __init__(self):
        self.user_types: Dict[str, solnodes2.ContractDefinition] = {}
        self.type_helper = TypeHelper(self)
        self.to_refine: Deque[solnodes1.SourceUnit] = deque()

    def process_all(self):
        while self.to_refine:
            n = self.to_refine.popleft()

            sun = n.scope.find_first_ancestor_of(symtab.FileScope).source_unit_name
            logging.getLogger('AST2').info(f'Processing {type(n).__name__}({n.name}) in {sun}')

            self.refine_unit_or_part(n)

    def load_if_required(self, user_type_symbol: symtab.Symbol) -> solnodes2.TopLevelUnit:
        ast1_node: solnodes1.SourceUnit = user_type_symbol.value

        if isinstance(ast1_node, (solnodes1.ContractDefinition, solnodes1.InterfaceDefinition,
                                  solnodes1.StructDefinition, solnodes1.LibraryDefinition, solnodes1.EnumDefinition)):

            if hasattr(ast1_node, 'ast2_node'):
                ast2_node = ast1_node.ast2_node
            else:
                parent_scope = user_type_symbol.parent_scope

                if isinstance(parent_scope, symtab.FileScope):
                    source_unit_name = parent_scope.source_unit_name
                    logging.getLogger('AST2').info(f'Defining top level unit {source_unit_name}::{ast1_node.name.text}')
                    ast2_node = self.define_skeleton(ast1_node, source_unit_name)
                else:
                    # load the parent which will in turn define skeletons for its children, including the current
                    # ast1_node
                    parent_was_loaded = hasattr(parent_scope.value, 'ast2_node')
                    logging.getLogger('AST2').info(f'Loading parent {parent_scope.aliases[0]}::{ast1_node.name.text}')
                    parent_type = self.load_if_required(parent_scope)
                    source_unit_name = f'{parent_type.source_unit_name}${parent_type.name.text}'

                    if parent_was_loaded:
                        # if the parent was previously loaded but the current ast node wasn't, then load_if_required
                        # won't attempt to define skeletons for its children(including ast1_node) so we have to manually
                        # do it here.
                        # This case is a bit weird and happens with circular references, i.e. MyLib defines MyEnum and
                        # MyLib defines a function f that takes MyEnum as a parameter. Loading MyEnum requires MyLib to
                        # be loaded but loading MyLib requires MyEnum to be loaded for the parameter type in f.
                        logging.getLogger('AST2').info(
                            f'Defining circular ref type {source_unit_name}::{ast1_node.name.text}')
                        ast2_node = self.define_skeleton(ast1_node, source_unit_name)
                    else:
                        # Parent wasn't previously defined and so it was loaded, in turn creating skeletons for its
                        # children and therefore ast2_node is set
                        ast2_node = ast1_node.ast2_node
            return ast2_node
        else:
            raise ValueError(f"Invalid user type resolve: {type(ast1_node)}")


    def _todo(self, node):
        raise ValueError(f'TODO: {type(node)}')

    def refine_stmt(self, node: solnodes1.Stmt, allow_none=False):
        if node is None:
            assert allow_none
            return None

        if isinstance(node, solnodes1.VarDecl):
            if len(node.variables) == 1:
                return solnodes2.VarDecl(self.var(node.variables[0]), self.refine_expr(node.value) if node.value else None)
            else:
                return solnodes2.TupleVarDecl([self.var(x) for x in node.variables], self.refine_expr(node.value))
        elif isinstance(node, solnodes1.ExprStmt):
            def map_node(x):
                if isinstance(x, solnodes2.Expr):
                    return solnodes2.ExprStmt(x)
                else:
                    assert isinstance(x, solnodes2.Stmt)
                    return x
            nodes = self.refine_expr(node.expr, allow_multiple_exprs=True, allow_stmt=True)
            if not isinstance(nodes, list):
                return map_node(nodes)
            else:
                return solnodes2.Block([map_node(n) for n in nodes], is_unchecked=False)
        elif isinstance(node, solnodes1.Block):
            return self.block(node)
        elif isinstance(node, solnodes1.If):
            return solnodes2.If(
                self.refine_expr(node.condition),
                self.refine_stmt(node.true_branch) if node.true_branch else None,
                self.refine_stmt(node.false_branch) if node.false_branch else None
            )
        elif isinstance(node, solnodes1.Try):
            return solnodes2.Try(
                self.refine_expr(node.expr),
                [self.parameter(x) for x in node.return_parameters],
                self.refine_stmt(node.body),
                [solnodes2.Catch(
                    # TODO: figure out what this is
                    x.ident.text if x.ident else None,
                    [self.parameter(y) for y in x.parameters],
                    self.block(x.body)
                ) for x in node.catch_clauses]
            )
        elif isinstance(node, solnodes1.Emit):
            assert isinstance(node.call.callee, solnodes1.Ident)
            callee_symbol = node.scope.find_single(node.call.callee.text)
            assert isinstance(callee_symbol.value, solnodes1.EventDefinition)
            assert len(node.call.modifiers) == 0

            # Get the AST2 EventDefinition. This requires the parent contract to be loaded so we have to do that first
            parent_type = self.type_helper.get_contract_type(callee_symbol.parent_scope)

            assert parent_type

            event_name = callee_symbol.value.name.text
            event = self.type_helper.find_event(parent_type, event_name)

            return solnodes2.EmitEvent(solnodes2.Ref(event), [self.refine_expr(x) for x in node.call.args])
        elif isinstance(node, solnodes1.Return):
            # see case of Literal in refine_expr where value is of type tuple
            rval = node.value
            if not rval:
                # return ;
                val_or_vals = []
            else:
                # return <expr> ;
                val_or_vals = self.refine_expr(rval, allow_tuple_exprs=True)

            assert isinstance(val_or_vals, (solnodes2.Expr, list))

            if not isinstance(val_or_vals, list):
                val_or_vals = [val_or_vals]
            return solnodes2.Return(val_or_vals)
        elif isinstance(node, solnodes1.AssemblyStmt):
            return solnodes2.Assembly(node.code)
        elif isinstance(node, solnodes1.While):
            return solnodes2.While(self.refine_expr(node.expr, allow_none=True),
                                   self.refine_stmt(node.body, allow_none=True),
                                   False)
        elif isinstance(node, solnodes1.DoWhile):
            return solnodes2.While(self.refine_expr(node.condition, allow_none=True),
                                   self.refine_stmt(node.body, allow_none=True),
                                   True)
        elif isinstance(node, solnodes1.For):
            return solnodes2.For(self.refine_stmt(node.initialiser, allow_none=True),
                                 self.refine_expr(node.condition, allow_none=True),
                                 self.refine_expr(node.advancement, allow_none=True),
                                 self.refine_stmt(node.body, allow_none=True))
        elif isinstance(node, solnodes1.Break):
            return solnodes2.Break()
        elif isinstance(node, solnodes1.Continue):
            return solnodes2.Continue()
        elif isinstance(node, solnodes1.Revert):
            # Special case of refine_function_call
            error_def, new_args = self.refine_call_function(node.call, allow_error=True)
            assert isinstance(error_def, solnodes2.ErrorDefinition)
            return solnodes2.RevertWithError(solnodes2.Ref(error_def), new_args)
        self._todo(node)

    def get_declaring_contract(self, node: solnodes1.Node) -> Union[symtab.ContractOrInterfaceScope, symtab.LibraryScope,
                                                                 symtab.EnumScope, symtab.StructScope, symtab.EnumScope]:
        return self.get_declaring_contract_in_scope(node.scope)

    def get_declaring_contract_in_scope(self, scope: symtab.Scope) -> Union[symtab.ContractOrInterfaceScope, symtab.LibraryScope, symtab.EnumScope, symtab.StructScope, symtab.EnumScope]:
        return scope.find_first_ancestor_of((symtab.ContractOrInterfaceScope, symtab.LibraryScope,
                                                  symtab.EnumScope, symtab.StructScope, symtab.EnumScope))

    def get_self_object(self, node: Union[solnodes1.Stmt, solnodes1.Expr]):
        ast1_current_contract = self.get_declaring_contract(node)
        contract_type: solnodes2.ResolvedUserType = self.type_helper.get_contract_type(ast1_current_contract)
        return solnodes2.SelfObject(contract_type.value)

    def get_super_object(self, node: Union[solnodes1.Stmt, solnodes1.Expr]):
        ast1_current_contract = self.get_declaring_contract(node)
        contract_type: solnodes2.ResolvedUserType = self.type_helper.get_contract_type(ast1_current_contract)
        return solnodes2.SuperObject(solnodes2.SuperType(contract_type.value))

    @dataclass
    class FunctionCallee:
        base: Union[solnodes2.Expr, symtab.Symbol]
        symbols: List[symtab.Symbol]

    @dataclass
    class PartialFunctionCallee(FunctionCallee):
        named_args: Dict[str, solnodes2.Expr]

    def refine_call_function(self, expr, allow_error=False, allow_stmt=False):
        def create_new_args():
            return [self.refine_expr(arg, is_argument=True) for arg in expr.args]

        def create_option_args():
            return [solnodes2.NamedArgument(solnodes2.Ident(arg.name), self.refine_expr(arg.value)) for arg in expr.modifiers]

        callee = expr.callee

        if isinstance(callee, solnodes1.New):
            # special case since new can only be in the form of new X()
            base_type = self.type_helper.map_type(callee.type_name)
            if base_type.is_array():
                assert len(expr.args) == 1
                assert self.type_helper.get_expr_type(expr.args[0]).is_int()
                return solnodes2.CreateMemoryArray(base_type, self.refine_expr(expr.args[0]))
            elif base_type.is_user_type():
                return solnodes2.CreateAndDeployContract(base_type, create_option_args(), create_new_args())

        # possible_base could be a Type or an expr:
        #  expr case is straight forward, i.e. myVar.xyz(), 'myVar' is the base
        #  or myVar.myField.xyz(), 'myVar.myField' is the base
        # type case is for expressions like MyLib.xyz() or MyX.MyY.xyz() where MyX.MyY is just a qualified name
        # we can't/don't handle myVar.MyX.xyz() where myVar is an expr and MyX is a type
        #
        # Symbols are matches by name only
        callees: List[Builder.FunctionCallee] = self.refine_expr(callee, is_function_callee=True)

        option_args = create_option_args()

        if any([isinstance(c, Builder.PartialFunctionCallee) for c in callees]):
            assert len(callees) == 1
            c = callees[0]

            unmatched_keys = [key for key in c.named_args.keys() if c.named_args[key] is None]

            if len(unmatched_keys) > 0:
                # Atm only allow f.gas(x) and f.value(x) i.e. 1 arg, this can be improved by checking against the symtab
                # entries for gas and value
                assert len(expr.args) == 1
                # parse x in f.gas(x) and add it as a named arg
                c.named_args[unmatched_keys[0]] = self.refine_expr(expr.args[0])
                return callees
            else:
                # if there are no unmatched keys, i.e. this partial function call has been fully filled out, then
                # continue with function call node determination as normal as PartialFunctionCallee is a FunctionCallee
                option_args.extend([solnodes2.NamedArgument(solnodes2.Ident(name), value) for name, value in c.named_args.items()])

        arg_types = [self.type_helper.get_expr_type(arg) for arg in expr.args]

        def is_type_call(s):
            # type calls when X in X(a) is a type, e.g. MyContract(_addr), bytes(xx), etc, which are casts
            return isinstance(s.value, (solnodes1.Type, solnodes2.Type)) or self.is_top_level(s.value)

        type_calls = [is_type_call(symbol) for c in callees for symbol in c.symbols]
        # can't have ambiguity for casts, so if one of the matches is a cast then they must all be (and there must only
        # be one, which is checked later) and vice versa
        assert TypeHelper.any_or_all(type_calls)

        if any(type_calls):
            assert len(callees) == 1 and len(callees[0].symbols) == 1

            ttype = self.type_helper.symbol_to_ast2_type(callees[0].symbols[0])
            if ttype.is_user_type() and ttype.value.x.is_struct():
                # struct init
                new_args = create_new_args()
                assert len(option_args) == 0
                return solnodes2.CreateStruct(ttype, new_args)
            else:
                 # casts must look like T(x), also can't have a base as the base is the resolved callee
                assert len(expr.args) == 1
                assert len(option_args) == 0
                assert not callees[0].base
                assert not (isinstance(ttype, solnodes2.ResolvedUserType) and isinstance(ttype.value.x, solnodes2.StructDefinition))

                # special case where address(uint160) maps to address payable:
                # see https://docs.soliditylang.org/en/develop/050-breaking-changes.html
                arg_type = self.type_helper.get_expr_type(expr.args[0])

                if ttype.is_address() and arg_type.is_int() and not arg_type.is_signed and arg_type.size == 160:
                    ttype = solnodes2.AddressType(is_payable=True)

                return solnodes2.Cast(ttype, self.refine_expr(expr.args[0]))

        # match function call candidates via parameters
        # (matched symbol, symbol type, is_synthetic)
        candidates = []
        for c in callees:
            # Match the callees in the current bucket
            bucket_candidates = []

            for s in c.symbols:
                t = self.type_helper.symbol_to_ast2_type(s)
                is_synthetic = False

                if isinstance(t, solnodes2.FunctionType):
                    # None is a sentinel, do NOT do 'if ft.inputs:'
                    if t.inputs is None:
                        # input types == None => polymorphic builtin function. This isn't the same as a no arg function,
                        # where input types == []
                        bucket_candidates.append((s, t, is_synthetic))
                        continue
                    else:
                        # match input types
                        input_types = t.inputs
                elif isinstance(t, solnodes2.MappingType):
                    # MappingType, these can look like function calls but are mapping loads. A mapping type can be
                    # nested, like myMapping :: (x => (y => z))
                    flattened_types = t.flatten()
                    # the last element in the flattened list is the final return type and isn't an arg, so don't include
                    # that
                    assert len(flattened_types) == len(arg_types) + 1
                    input_types = flattened_types[:-1]
                else:
                    assert isinstance(s.value, solnodes1.StateVariableDeclaration)
                    assert solnodes1.VisibilityModifier.PUBLIC in s.value.modifiers
                    # synthetic getter method for a public field, e.g. a public field 'data', expr is data()
                    input_types = []
                    is_synthetic = True

                # check for each parameter of the target, check if the arg can be passed to it
                if len(input_types) == len(arg_types):
                    if all([targ.can_implicitly_cast_from(actual) for targ, actual in zip(input_types, arg_types)]):
                        bucket_candidates.append((s, t, is_synthetic))

            if len(bucket_candidates) > 1:
                raise ValueError('Resolved to too many different bases')
            elif len(bucket_candidates) == 1:
                candidates.append((c.base, *bucket_candidates[0]))

        if len(candidates) == 0:
            # no resolved callees
            raise ValueError('Can\'t resolve call')
        elif len(candidates) > 1:
            logging.getLogger('AST2').info(f'Matched multiple buckets for: {expr}, choosing first from {candidates}')

        # Choose the candidate from the first bucket
        # FunctionCallee, (input: types, output: types)
        # TODO: get named args for PartialFunctionCallee
        possible_base, sym, ftype, is_synthetic = candidates[0]

        if isinstance(ftype, solnodes2.MappingType):
            # for mapping types, the dst is the output type
            out_type = ftype.dst
        elif is_synthetic:
            # for synthetic candidate, the type itself is the output type
            out_type = ftype
        elif ftype.outputs is None:
            # for FunctionTypes where output IS None, return type is polymorphic. So far it's only abi.decode
            if sym.aliases[0] == 'decode' and sym.parent_scope.aliases[0] == 'abi':
                assert len(arg_types) == 2
                out_type = arg_types[1]
            else:
                self._todo(expr)
        elif len(ftype.outputs) > 1:
            # returns multiple things, set the return type as a TupleType
            out_type = solnodes2.TupleType(ftype.outputs)
        elif len(ftype.outputs) == 1:
            # one return type
            out_type = ftype.outputs[0]
        else:
            # void return
            out_type = None

        new_args = create_new_args()

        if isinstance(sym, symtab.BuiltinFunction):
            if isinstance(possible_base, solnodes2.BuiltinType) or not possible_base:
                # TODO: separate node for revert, require, etc
                if sym.aliases[0] == 'require':
                    assert allow_stmt
                    assert len(option_args) == 0

                    if len(new_args) == 1:
                        return solnodes2.Require(new_args[0], None)
                    elif len(new_args) == 2:
                        assert new_args[1].type_of().is_string()
                        return solnodes2.Require(new_args[0], new_args[1])
                    self._todo(expr)
                elif sym.aliases[0] == 'revert':
                    assert allow_stmt
                    if len(new_args) == 1:
                        assert new_args[0].type_of().is_string()
                        return solnodes2.RevertWithReason(new_args[0])
                    elif len(new_args) == 0:
                        return solnodes2.Revert()
                    self._todo(expr)
                name = f'{possible_base.name}.{sym.aliases[0]}' if possible_base else {sym.aliases[0]}
                return solnodes2.BuiltInCall(option_args, new_args, name, out_type)
            elif isinstance(possible_base, solnodes2.Expr):
                # e.g. myaddress.call(...)
                return solnodes2.DynamicBuiltInCall(option_args, new_args, out_type, possible_base, sym.aliases[0])
        elif isinstance(sym.value, solnodes1.FunctionDefinition):
            # TODO: check for None possible_base in refine_expr
            pb2 = possible_base

            current_contract = self.get_declaring_contract(expr)
            func_declaring_contract = self.get_declaring_contract(sym.value)

            # assert self.is_subcontract(ast1_current_contract, var_declaring_contract)
            # 
            # contract_type: solnodes2.ResolvedUserType = self.type_helper.get_contract_type(var_declaring_contract)

            is_local_call = self.is_subcontract(current_contract, func_declaring_contract)

            if possible_base and not isinstance(possible_base, solnodes2.Expr) and is_local_call:
                # if we have a base such as ResolvedUserType but its to a function in the same contract
                possible_base = self.get_self_object(expr)

            if not possible_base:
                assert is_local_call
                possible_base = self.get_self_object(expr)

            name = solnodes2.Ident(sym.value.name.text)
            if isinstance(possible_base, solnodes2.Expr):
                return solnodes2.FunctionCall(option_args, new_args, possible_base, name)
            else:
                return solnodes2.DirectCall(option_args, new_args, possible_base, name)
        elif isinstance(sym.value, solnodes1.StateVariableDeclaration):
            assert isinstance(possible_base, solnodes2.Expr)
            assert len(option_args) == 0

            if isinstance(ftype, solnodes2.MappingType):
                # create nested mapping loads multiple args were passed to this "call".
                # e.g. myMapping(x, y) => (myMapping[x])[y], i.e. have to create the inner one first

                expr_base = possible_base

                for expr_key in new_args:
                    new_expr = solnodes2.MappingLoad(expr_base, expr_key)
                    expr_base = new_expr

                return new_expr
            elif is_synthetic:
                # synthetic getter for a public field
                # TODO: array getter?
                assert out_type.is_string() or not out_type.is_array()
                return solnodes2.StateVarLoad(possible_base, sym.aliases[0])
        elif isinstance(sym.value, solnodes1.ErrorDefinition):
            assert allow_error
            assert len(option_args) == 0
            return sym.value.ast2_node, new_args
        self._todo(expr)


    ASSIGN_TO_OP = {
        solnodes1.BinaryOpCode.ASSIGN: solnodes1.BinaryOpCode.ASSIGN,
        solnodes1.BinaryOpCode.ASSIGN_OR: solnodes1.BinaryOpCode.BIT_OR,
        solnodes1.BinaryOpCode.ASSIGN_BIT_NEG: solnodes1.BinaryOpCode.BIT_XOR,
        solnodes1.BinaryOpCode.ASSIGN_BIT_AND: solnodes1.BinaryOpCode.BIT_AND,
        solnodes1.BinaryOpCode.ASSIGN_LSHIFT: solnodes1.BinaryOpCode.LSHIFT,
        solnodes1.BinaryOpCode.ASSIGN_RSHIFT: solnodes1.BinaryOpCode.RSHIFT,
        solnodes1.BinaryOpCode.ASSIGN_ADD: solnodes1.BinaryOpCode.ADD,
        solnodes1.BinaryOpCode.ASSIGN_SUB: solnodes1.BinaryOpCode.SUB,
        solnodes1.BinaryOpCode.ASSIGN_MUL: solnodes1.BinaryOpCode.MUL,
        solnodes1.BinaryOpCode.ASSIGN_DIV: solnodes1.BinaryOpCode.DIV,
        solnodes1.BinaryOpCode.ASSIGN_MOD: solnodes1.BinaryOpCode.MOD
    }

    def is_subcontract(self, a: symtab.ContractOrInterfaceScope, b: symtab.ContractOrInterfaceScope):
        # TODO: quicker algorithm

        # checks if A is a subcontract of B/ if B is a supercontract of A
        to_check = deque()
        to_check.append(a)

        while to_check:
            next = to_check.popleft()
            if next == b:
                return True
            to_check.extend(next.get_supers())

        return False

    def refine_expr(self, expr: solnodes1.Expr, is_function_callee=False, allow_type=False, allow_tuple_exprs=False,
                    allow_multiple_exprs=False, allow_none=True, allow_stmt=False, is_argument=False):
        if expr is None:
            assert allow_none
            return None

        if isinstance(expr, solnodes1.UnaryOp):
            return solnodes2.UnaryOp(self.refine_expr(expr.expr), expr.op, expr.is_pre)
        elif isinstance(expr, solnodes1.BinaryOp):
            left = self.refine_expr(expr.left, allow_tuple_exprs=True)
            right = self.refine_expr(expr.right)
            
            def make_assign(lhs, rhs):
                if isinstance(lhs, solnodes2.StateVarLoad):
                    return solnodes2.StateVarStore(lhs.base, lhs.name, rhs)
                elif isinstance(lhs, solnodes2.ArrayLoad):
                    return solnodes2.ArrayStore(lhs.base, lhs.index, rhs)
                else:
                    return solnodes2.LocalVarStore(lhs.var, rhs)
            
            if isinstance(left, list):
                assert expr.op == solnodes1.BinaryOpCode.ASSIGN
                assert allow_multiple_exprs
                # (x,y) = V; translates to
                # z = V; x = V[0]; y = V[1];
                # x and y can be state var setters, i.e. (a.x, b.y) = V is a valid assignment
                ttypes = [e.type_of() for e in left]

                def z():
                    return solnodes2.Var('z', solnodes2.TupleType(ttypes), None)

                stmts = [solnodes2.LocalVarStore(z(), right)]
                for idx, e in enumerate(left):
                    rhs = solnodes2.TupleLoad(solnodes2.LocalVarLoad(z()), idx)
                    stmts.append(make_assign(e, rhs))

                return stmts

            if expr.op in self.ASSIGN_TO_OP:
                # this is an assign, make sure the lhs is a valid assignment target.
                # if the OP does some other mathematical operation then split the rhs into a load lhs + rhs
                # e.g. x += y translates to x = (x + y)
                assert isinstance(left, (solnodes2.StateVarLoad, solnodes2.LocalVarLoad, solnodes2.ArrayLoad))

                if expr.op != solnodes1.BinaryOpCode.ASSIGN:
                    value = solnodes2.BinaryOp(left, right, self.ASSIGN_TO_OP[expr.op])
                else:
                    value = right
                
                return make_assign(left, value)
            else:
                return solnodes2.BinaryOp(left, right, expr.op)
        elif isinstance(expr, solnodes1.Type):
            if is_function_callee:
                # E.g. calls that look like T(x) (Casts)
                # Type as expr has no base (direct reference)
                # find_type returns a single symbol so wrap it in a list for conformity
                return [Builder.FunctionCallee(None, [expr.scope.find_type(expr)])]
            elif is_argument:
                # for arguments, types can sometimes be passed, e.g. abi.decode(x, bool)
                return solnodes2.TypeLiteral(self.type_helper.map_type(expr))
        elif isinstance(expr, solnodes1.Ident):
            # We should only reach this if this Ident is a reference to a variable load. This shouldn't be
            # hit when resolving other uses of Idents

            if expr.text == 'this':
                return self.get_self_object(expr)
            elif expr.text == 'super':
                return self.get_super_object(expr)
            elif expr.text == '_':
                # NOTE: we return a Stmt here instead of an Expr. In a later pass, ExprStmt(ExecModifiedCode)
                # gets reduced to just ExecModifiedCode in place of ExprStmt
                return solnodes2.ExecModifiedCode()

            if is_function_callee:
                def symbol_base(s):
                    if self.is_top_level(s.value):
                        # direct type reference, e.g. MyContract -> no base
                        return None
                    if isinstance(s, (symtab.BuiltinFunction, symtab.BuiltinObject, symtab.BuiltinValue)):
                        return None
                    s_contract = self.get_declaring_contract_in_scope(s)
                    return self.type_helper.get_contract_type(s_contract)
                def symbol_bases(bucket):
                    bases = [symbol_base(s) for s in bucket]
                    if len(bases) > 0:
                        # all the same
                        assert all([x == bases[0] for x in bases])
                        return bases[0]
                    else:
                        return None
                bucket = expr.scope.find(expr.text)
                return [Builder.FunctionCallee(symbol_bases(bucket), bucket)]

            ident_symbol = expr.scope.find_single(expr.text).resolve_base_symbol()
            assert ident_symbol  # must be resolved to something

            if isinstance(ident_symbol, symtab.BuiltinValue):
                base_scope = ident_symbol.parent_scope
                assert isinstance(base_scope, symtab.BuiltinObject)
                return solnodes2.GlobalValue(f'{base_scope.aliases[0]}.{ident_symbol.aliases[0]}', self.type_helper.map_type(ident_symbol.ttype))

            ident_target = ident_symbol.value  # the AST1 node that this Ident is referring to

            if isinstance(ident_target, solnodes1.StateVariableDeclaration):
                # i.e. Say we are in contract C and ident is 'x', check that 'x' is declared in C
                # this is so that we know the 'base' of this load will be 'self'
                ast1_current_contract = self.get_declaring_contract(expr)
                var_declaring_contract = self.get_declaring_contract(ident_target)

                assert self.is_subcontract(ast1_current_contract, var_declaring_contract)

                contract_type: solnodes2.ResolvedUserType = self.type_helper.get_contract_type(var_declaring_contract)

                return solnodes2.StateVarLoad(solnodes2.SelfObject(contract_type.value), solnodes2.Ident(expr.text))
            elif isinstance(ident_target, (solnodes1.Parameter, solnodes1.Var)):
                return solnodes2.LocalVarLoad(self.var(ident_target))
            elif self.is_top_level(ident_target):
                assert allow_type
                return self.type_helper.symbol_to_ast2_type(ident_symbol)
            else:
                self._todo(ident_target)
        elif isinstance(expr, solnodes1.CallFunction):
            return self.refine_call_function(expr, allow_stmt=allow_stmt)
        elif isinstance(expr, solnodes1.GetMember):
            base = expr.obj_base
            mname = expr.name.text

            base_type: solnodes2.Type = self.type_helper.get_expr_type(expr.obj_base)

            if not isinstance(base_type, solnodes2.FunctionType):
                base_scopes = self.type_helper.scope_for_type(base, base_type)

                member_symbols = [scope_symbols for s in base_scopes if (scope_symbols := s.find(mname))]

                assert len(member_symbols) > 0, f'No matches to call {str(base)}.{mname}'

                if is_function_callee:
                    if isinstance(base_type, solnodes2.BuiltinType):
                        bucket_base = base_type
                    else:
                        bucket_base = self.refine_expr(base, allow_type=True)
                    # assert len(member_symbols) == 1 # 1 bucket for now, need to investigate
                    callees = []
                    for bucket in member_symbols:
                        callees.append(Builder.FunctionCallee(bucket_base, bucket))
                    return callees

                # if sum(len(xs) for xs in member_symbols) > 1:
                #     logging.getLogger('AST2').info(
                #         f'Multiple resolves for {str(base)}.{mname}, choosing first: {sym} from {sym.parent_scope.aliases}')

                assert len(member_symbols) == 1 and len(member_symbols[0]) == 1
                sym = member_symbols[0][0]

                if isinstance(sym, symtab.BuiltinValue):
                    if isinstance(base_type, solnodes2.BuiltinType):
                        # e.g. msg.gas, where the base is a builtin object
                        return solnodes2.GlobalValue(f'{base_type.name}.{mname}', self.type_helper.map_type(sym.ttype))
                    else:
                        # e.g. myarray.length, 'length' is builtin to the array type(i.e. not a concrete field)
                        new_base = self.refine_expr(base)
                        return solnodes2.DynamicBuiltInValue(mname, self.type_helper.map_type(sym.ttype), new_base)
                else:
                    referenced_member = sym.value
                    new_base = self.refine_expr(base, allow_type=True)

                    if isinstance(referenced_member, solnodes1.StructMember):
                        assert isinstance(new_base, solnodes2.Expr)
                        return solnodes2.StateVarLoad(new_base, solnodes2.Ident(mname))
                    elif isinstance(referenced_member, solnodes1.StateVariableDeclaration):
                        # if the base is a type, it's a constant load, i.e. MyX.myConst (possibly also a qualified
                        # lookup like MyX.MyY.myConst?)
                        # else it's an instance member load which requires an expr base
                        if isinstance(new_base, solnodes2.Type):
                            assert isinstance(new_base, solnodes2.ResolvedUserType)
                            assert solnodes1.MutabilityModifier.CONSTANT in referenced_member.modifiers
                            return solnodes2.StaticVarLoad(new_base, solnodes2.Ident(referenced_member.name.text))
                    elif isinstance(referenced_member, solnodes1.Ident) and isinstance(referenced_member.parent,
                                                                                       solnodes1.EnumDefinition):
                        assert isinstance(new_base, solnodes2.ResolvedUserType) and new_base.value.x.is_enum()
                        member_matches = [member for member in new_base.value.x.values
                                          if member.name.text == referenced_member.text]
                        assert len(member_matches) == 1
                        return solnodes2.EnumLoad(member_matches[0])
            else:
                # need to resolve this as if it was a function call, e.g. we have x.myFunc.selector and we treat it as
                # if it's x.myFunc()
                callees: List[Builder.FunctionCallee] = self.refine_expr(base, is_function_callee=True)
                assert len(callees) == 1 and len(callees[0].symbols) == 1

                member_symbol = callees[0].symbols[0]
                possible_base = callees[0].base

                # TODO: make this work without explicit check
                if mname == 'selector':
                    candidates = []

                    if isinstance(possible_base, solnodes2.Expr):
                        contract = possible_base.type_of()
                    elif possible_base:
                        contract = possible_base
                    else:
                        contract = self.get_self_object(expr).type_of()
                    # shouldn't need to do arg checks for selector
                    for part in contract.value.x.parts:
                        if isinstance(part, (solnodes2.FunctionDefinition, solnodes2.ErrorDefinition)):
                            if part.name.text == member_symbol.value.name.text:
                                candidates.append(part)

                    assert len(candidates) == 1

                    return solnodes2.ABISelector(candidates[0])
                else:
                    # the named arg value comes as the argument of the parent call function expr
                    assert is_function_callee
                    return [Builder.PartialFunctionCallee(possible_base, [member_symbol], { mname: None })]
            self._todo(expr)
        elif isinstance(expr, solnodes1.Literal):
            if isinstance(expr.value, tuple):
                assert not expr.unit

                type_args = [self.type_helper.map_as_type_arg(arg) for arg in expr.value]
                are_type_args = [isinstance(arg, (solnodes1.Type, solnodes2.Type)) for arg in type_args]
                assert TypeHelper.any_or_all(are_type_args)

                if any(are_type_args):
                    # the grammar has 'TupleExpression' s, e.g. '(' exprList ')'. The exprs it allows can also be types.
                    # Either all or none of the exprs must be types
                    # but the parser is weird
                    return solnodes2.TypeLiteral(solnodes2.TupleType([self.type_helper.map_type(t) for t in type_args]))
                elif len(expr.value) == 1:
                    # Bracketed expressions, not tuples, e.g. (x).y() , (x) isn't a tuple so unpack here
                    assert isinstance(expr.value[0], solnodes1.Expr)
                    return self.refine_expr(expr.value[0])
                else:
                    # Actual tuple but tuples aren't part of solidity properly, they are just syntactic sugar
                    # e.g. for returning multiple values or unpacking calls that return multiple values. So check
                    # that the parent is a return and as a special case to function, we return a list of the values
                    # instead of an Expr type. The parent case for Return can handle returning a list as well.
                    # This is also true for the LHS of var stores
                    assert allow_tuple_exprs
                    return [self.refine_expr(e) for e in expr.value]
            elif isinstance(expr.value, solnodes1.Type):
                self._todo(expr)
            else:
                assert not isinstance(expr.value, solnodes1.Expr)
                return solnodes2.Literal(expr.value, self.type_helper.get_expr_type(expr), expr.unit)
        elif isinstance(expr, solnodes1.GetArrayValue):
            return solnodes2.ArrayLoad(self.refine_expr(expr.array_base), self.refine_expr(expr.index))
        elif isinstance(expr, solnodes1.PayableConversion):
            # address payable cast
            assert len(expr.args) == 1
            return solnodes2.Cast(solnodes2.AddressType(True), self.refine_expr(expr.args[0]))
        elif isinstance(expr, solnodes1.CreateMetaType):
            return solnodes2.GetType(self.type_helper.map_type(expr.base_type))
        elif isinstance(expr, solnodes1.TernaryOp):
            return solnodes2.TernaryOp(self.refine_expr(expr.condition), self.refine_expr(expr.left), self.refine_expr(expr.right))
        elif isinstance(expr, solnodes1.NamedArg):
            return solnodes2.NamedArgument(solnodes2.Ident(expr.name.text), self.refine_expr(expr.value))
        elif isinstance(expr, solnodes1.NewInlineArray):
            return solnodes2.CreateInlineArray([self.refine_expr(e) for e in expr.elements])
        self._todo(expr)

    def find_method(self, possible_matches: List[symtab.Symbol], arg_types: List[solnodes2.Type]):
        assert not any([x is None for x in arg_types])

        def get_arg_types(func_scope: symtab.ModFunErrEvtScope) -> List[solnodes2.Type]:
            assert isinstance(func_scope, symtab.ModFunErrEvtScope)
            return [self.type_helper.map_type(p.var_type) for p in func_scope.value.parameters]

        def check_arg_types(s: symtab.Symbol) -> bool:
            if isinstance(s, symtab.UsingFunctionSymbol):
                # Consider the expression x.sub(y) where x and y are vars of type 'int256' and there's a Using directive
                # that's added the 'sub' method to the int256 type. This UsingFunctionSymbol points to a function
                # 'sub (int256, int256)' but the actual function call in the expression takes 1 parameter. If we just
                # parse the expression for the argument types we would only have [unit256] for 'y' but the actual
                # method we want to find has [int256, int256].

                # resolved symbol is the function scope
                target_param_types = get_arg_types(s.resolve_base_symbol())
                actual_param_types = [self.type_helper.map_type(s.override_type)] + arg_types
            else:
                assert isinstance(s, symtab.ModFunErrEvtScope)
                # In Solidity x.sub(y) is only valid with a Using declaration, so we check the actual parameter type
                # lists supplied.
                target_param_types = get_arg_types(s)
                actual_param_types = arg_types

            return solnodes2.Type.are_matching_types(target_param_types, actual_param_types)

        actual_matches = [x for x in possible_matches if check_arg_types(x)]

        assert len(actual_matches) == 1, 'Invalid resolve'
        assert isinstance(actual_matches[0].value, solnodes1.FunctionDefinition)

        return actual_matches[0]

    def var(self, node: Union[solnodes1.Var, solnodes1.Parameter]):
        location = None
        if node.var_loc:
            location = solnodes2.Location(node.var_loc.name.lower())

        # Solidity allowed unnamed parameters apparently...
        # function sgReceive(uint16 /*_chainId*/, bytes memory /*_srcAddress*/, uint /*_nonce*/, address _token,
        # uint amountLD, bytes memory payload) override external {
        name = None
        if node.var_name:
            name = node.var_name.text

        return solnodes2.Var(
            solnodes2.Ident(name),
            self.type_helper.map_type(node.var_type),
            location
        )

    def parameter(self, node: solnodes1.Parameter):
        return solnodes2.Parameter(self.var(node))

    def error_parameter(self, node: solnodes1.ErrorParameter):
        return solnodes2.ErrorParameter(self.type_helper.map_type(node.var_type), solnodes2.Ident(node.name.text))

    def modifier(self, node: solnodes1.Modifier):
        pass

    def block(self, node: solnodes1.Block):
        if node:
            return solnodes2.Block(
                [self.refine_stmt(s) for s in node.stmts],
                node.is_unchecked
            )
        else:
            return solnodes2.Block([], False)

    def define_skeleton(self, ast1_node: solnodes1.SourceUnit, source_unit_name: str) -> solnodes2.TopLevelUnit:
        """
        Makes a skeleton of the given AST1 node without processing the details. This is required as user types are
        loaded on demand(when they're used in code/parameter lists/declarations, etc). This skeleton is used as a
        reference and then filled in later on. """

        assert not hasattr(ast1_node, 'ast2_node')

        # Source unit name is only used for source units/top level units
        assert bool(source_unit_name) == self.is_top_level(ast1_node)

        def _make_new_node(n):
            if isinstance(n, solnodes1.FunctionDefinition):
                return solnodes2.FunctionDefinition(solnodes2.Ident(str(n.name)), [], [], [], None)

            name = solnodes2.Ident(n.name.text)
            if isinstance(n, solnodes1.ContractDefinition):
                return solnodes2.ContractDefinition(source_unit_name, name, [], [], [], [])
            elif isinstance(n, solnodes1.InterfaceDefinition):
                return solnodes2.InterfaceDefinition(source_unit_name, name, [], [], [])
            elif isinstance(n, solnodes1.StructDefinition):
                return solnodes2.StructDefinition(source_unit_name, name, [])
            elif isinstance(n, solnodes1.LibraryDefinition):
                return solnodes2.LibraryDefinition(source_unit_name, name, [], [])
            elif isinstance(n, solnodes1.EnumDefinition):
                return solnodes2.EnumDefinition(source_unit_name, name, [])
            elif isinstance(n, solnodes1.ErrorDefinition):
                return solnodes2.ErrorDefinition(source_unit_name, name, [])
            elif isinstance(n, solnodes1.StateVariableDeclaration):
                return solnodes2.StateVariableDeclaration(name, None, [], None)
            elif isinstance(n, solnodes1.EventDefinition):
                return solnodes2.EventDefinition(name, [], None)
            elif isinstance(n, solnodes1.ModifierDefinition):
                return solnodes2.ModifierDefinition(name, [], [], None)
            else:
                self._todo(ast1_node)

        logging.getLogger('AST2').info(f' making skeleton for {ast1_node.name} :: {source_unit_name}')

        ast2_node = _make_new_node(ast1_node)
        ast1_node.ast2_node = ast2_node

        if hasattr(ast1_node, 'parts'):
            for p in ast1_node.parts:
                if self.is_top_level(p):
                    # these units don't get added as parts in AST2, e.g. an embedded contract B in parent contract A
                    # gets loaded as a separate ContractDefinition with the name as A$B
                    self.load_if_required(p.owning_scope)

            for p in ast1_node.parts:
                if not self.is_top_level(p) and not isinstance(p,
                                                               (solnodes1.UsingDirective, solnodes1.PragmaDirective)):
                    # don't need usings or pragmas for AST2
                    ast2_node.parts.append(self.define_skeleton(p, None))

        # need to define inputs (and maybe outputs) for functions so that function calls can be resolved during
        # DirectCall.type_of() calls
        if isinstance(ast1_node, solnodes1.FunctionDefinition):
            ast2_node.inputs = [self.parameter(x) for x in ast1_node.parameters]
            ast2_node.outputs = [self.parameter(x) for x in ast1_node.returns]

        if isinstance(ast1_node, solnodes1.ErrorDefinition):
            ast2_node.inputs = [self.error_parameter(x) for x in ast1_node.parameters]

        if isinstance(ast1_node, solnodes1.StateVariableDeclaration):
            ast2_node.ttype = self.type_helper.map_type(ast1_node.var_type)

        if isinstance(ast1_node, solnodes1.EventDefinition):
            ast2_node.inputs = [solnodes2.EventParameter(solnodes2.Ident(p.name.text if p.name else f'<unnamed:{i}'), self.type_helper.map_type(p.var_type), p.is_indexed)
                                for i,p in enumerate(ast1_node.parameters)]

        if isinstance(ast1_node, solnodes1.ModifierDefinition):
            ast2_node.inputs = [self.parameter(x) for x in ast1_node.parameters]

        if self.is_top_level(ast1_node):
            self.to_refine.append(ast1_node)

        return ast2_node

    def refine_unit_or_part(self, ast1_node: solnodes1.SourceUnit):
        if not isinstance(ast1_node, (solnodes1.ContractDefinition, solnodes1.InterfaceDefinition,
                                      solnodes1.StructDefinition, solnodes1.LibraryDefinition,
                                      solnodes1.EnumDefinition, solnodes1.ErrorDefinition,
                                      solnodes1.FunctionDefinition, solnodes1.EventDefinition,
                                      solnodes1.StateVariableDeclaration, solnodes1.ModifierDefinition)):
            raise ValueError('x')

        ast2_node = ast1_node.ast2_node

        if hasattr(ast2_node, 'refined') and ast2_node.refined:
            return

        if self.is_top_level(ast1_node):
            if isinstance(ast1_node, solnodes1.ContractDefinition):
                ast2_node.is_abstract = ast1_node.is_abstract

            # contracts, interfaces
            if hasattr(ast1_node, 'inherits'):
                ast2_node.inherits = [
                    solnodes2.InheritSpecifier(self.type_helper.get_user_type(x.name), [self.refine_expr(arg) for arg in x.args])
                    for x in ast1_node.inherits
                ]

            # contracts, interfaces, libraries
            if hasattr(ast1_node, 'parts'):
                for part in ast1_node.parts:
                    if isinstance(part, solnodes1.UsingDirective):
                        # Not sure if things other than contracts can have usings, if this should error, we can investigate
                        library_scope = part.scope.find_single(part.library_name.text)
                        assert isinstance(library_scope.value, solnodes1.LibraryDefinition)
                        library = self.type_helper.get_contract_type(part.scope.find_single(part.library_name.text))
                        ast2_node.type_overrides.append(solnodes2.LibraryOverride(self.type_helper.map_type(part.override_type), library))

                    if hasattr(part, 'ast2_node'):
                        self.refine_unit_or_part(part)

            # structs
            if hasattr(ast1_node, 'members'):
                ast2_node.members = [solnodes2.StructMember(self.type_helper.map_type(x.member_type), solnodes2.Ident(x.name.text)) for x in
                                     ast1_node.members]

            # enums
            if hasattr(ast1_node, 'values'):
                ast2_node.values = [solnodes2.EnumMember(solnodes2.Ident(n.text)) for n in ast1_node.values]

        if isinstance(ast1_node, solnodes1.FunctionDefinition):
            ast2_node.modifiers = [self.modifier(x) for x in ast1_node.modifiers]
            ast2_node.code = self.block(ast1_node.code) if ast1_node.code else None
            ast2_node.refined = True
            return ast2_node

        if isinstance(ast1_node, solnodes1.StateVariableDeclaration):
            ast2_node.modifiers = [self.modifier(x) for x in ast1_node.modifiers]
            ast2_node.value = self.refine_expr(ast1_node.initial_value) if ast1_node.initial_value else None
            ast2_node.refined = True
            return ast2_node

        if isinstance(ast1_node, solnodes1.EventDefinition):
            ast2_node.is_anonymous = ast1_node.is_anonymous
            ast2_node.refined = True
            return ast2_node

        if isinstance(ast1_node, solnodes1.ModifierDefinition):
            ast2_node.modifiers = [self.modifier(x) for x in ast1_node.modifiers]
            ast2_node.code = self.block(ast1_node.code) if ast1_node.code else None
            ast2_node.refined = True
            return ast2_node

        ast2_node.refined = True

        ast2_node._set_child_parents()

        return None

    def is_top_level(self, node: solnodes1.Node):
        # Error and FunctionDefinitions are set as SourceUnits in AST1 but not in AST2
        return isinstance(node, solnodes1.SourceUnit) and not isinstance(node, (solnodes1.FunctionDefinition, solnodes1.ErrorDefinition))
