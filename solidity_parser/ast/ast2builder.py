from dataclasses import replace as copy_dataclass
from typing import List, Union, Optional, Dict, Set, Deque
from collections import deque

from Tools.scripts.make_ctype import values

from solidity_parser.ast import solnodes as solnodes1
from solidity_parser.ast import solnodes2 as solnodes2
from solidity_parser.ast import symtab

import logging
import math

class TypeHelper:
    def __init__(self, builder):
        self.builder = builder

    def find_field(self, ttype: solnodes2.Type, name: str) -> solnodes2.FunctionDefinition:
        pass

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

    def find_declared_target_method(self, scope: symtab.Scope, name: str, arg_types: List[solnodes2.Type]):
        pass

    def get_expr_type(self, expr: solnodes1.Expr, allow_multiple=False) -> solnodes2.Type:
        if isinstance(expr, solnodes1.Ident):
            text = expr.text
            if text == 'this':
                symbol = expr.scope.find_first_ancestor_of((symtab.ContractOrInterfaceScope, symtab.LibraryScope,
                                                                 symtab.EnumScope, symtab.StructScope))
            else:
                if allow_multiple:
                    symbols = expr.scope.find(text, find_base_symbol=True)
                    return [self.symbol_to_ast2_type(s) for s in symbols]
                else:
                    symbol = expr.scope.find_single(text, find_base_symbol=True)

            return self.symbol_to_ast2_type(symbol)
        elif isinstance(expr, solnodes1.GetMember):
            base_type = self.get_expr_type(expr.obj_base)
            member = expr.name.text
            if member == 'length' and isinstance(base_type, solnodes2.ArrayType):
                return solnodes2.UIntType()

            # check the scope of the base type
            # then check the current contract/interface/library/scope to see if it's an overriden type with the using
            # directive
            scope = self.scope_for_type(expr, base_type)
            if allow_multiple:
                symbols = scope.find(member, find_base_symbol=True)
                return [self.symbol_to_ast2_type(s) for s in symbols]
            else:
                symbol = scope.find_single(member)
                return self.symbol_to_ast2_type(symbol)
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
                are_type_args = [isinstance(arg, solnodes1.Type) for arg in type_args]
                assert any(are_type_args) == all(are_type_args)

                if any(are_type_args):
                    # the grammar has 'TupleExpression' s, e.g. '(' exprList ')'. The exprs it allows can also be types.
                    # Either all or none of the exprs must be types
                    # but the parser is weird
                    return solnodes2.TupleType([self.builder.map_type(t) for t in type_args])
                elif len(value) == 1:
                    # Bracketed expressions, not tuples, e.g. (x).y() , (x) isn't a tuple so unpack here
                    assert isinstance(value[0], solnodes1.Expr)
                    return self.get_expr_type(value[0])
                else:
                    return self.builder._todo(value)
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
                t1 = self.get_expr_type(expr.left)
                t2 = self.get_expr_type(expr.right)
                if expr.op != solnodes1.BinaryOpCode.ASSIGN:
                    # can only compare ints, but we can't use t1 == t2 as we can compare different int types, e.g.
                    # this.x (uint256) == 0 (uint8)
                    assert isinstance(t1, solnodes2.IntType) and isinstance(t2, solnodes2.IntType)
                else:
                    # assignment, types must be the same (I think)
                    assert t1 == t2
                return t1
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
            callee = expr.callee
            if isinstance(callee, solnodes1.Type):
                # e.g. int(...), string(...), address(...) => cast expr
                return self.builder.map_type(callee)

            arg_types = [self.get_expr_type(arg) for arg in expr.args]

            func_types = self.get_expr_type(callee, allow_multiple=True)

            if isinstance(func_types, solnodes2.Type):
                # constructor call/new type
                if func_types.is_builtin():
                    # e.g. new string(xxx)
                    return func_types
                else:
                    # e.g. new MyX() ? TODO: check if we should return the constructor function type here instead
                    return func_types

            assert all([isinstance(ft, solnodes2.FunctionType) for ft in func_types])

            candidates = []
            for ft in func_types:
                if ft.inputs:
                    # match input types
                    if len(ft.inputs) == len(arg_types):
                        if all([targ.can_implicitly_cast_from(actual)] for targ, actual in zip(ft.inputs, arg_types)):
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
            if isinstance(expr, solnodes1.GetMember) and isinstance(expr.obj_base, solnodes1.Ident):
                if expr.obj_base.text == 'abi' and expr.name.text == 'decode':
                    assert output_types == None
                    # drop the first argument type so output types are t1, t2...
                    #  abi.decode(bytes memory encodedData, (t1, t2...)) returns (t1, t2...)
                    output_types = arg_types[1:]

            if allow_multiple:
                return output_types
            else:
                assert len(output_types) == 1
                return output_types[0]
        elif isinstance(expr, solnodes1.CreateMetaType):
            return solnodes2.MetaTypeType(self.builder.map_type(expr.base_type))
        elif isinstance(expr, solnodes1.New):
            return self.builder.map_type(expr.type_name)
        return self.builder._todo(expr)

    def map_as_type_arg(self, arg):
        # grammar shenanigans again...
        # sometimes stuff like uint[] gets parsed as GetArrayValue(array_base=IntType(...), index=None))
        if isinstance(arg, solnodes1.Type):
            return arg
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

    def symbol_to_ast2_type(self, symbol) -> solnodes2.Type:
        if isinstance(symbol, symtab.BuiltinObject):
            return solnodes2.BuiltinType(symbol.name)
        elif isinstance(symbol, symtab.BuiltinFunction):
            input_types = [self.builder.map_type(ttype) for ttype in symbol.input_types] if symbol.input_types else None
            output_types = [self.builder.map_type(ttype) for ttype in symbol.output_types] if symbol.output_types else None
            return solnodes2.FunctionType(input_types, output_types)
        elif isinstance(symbol, symtab.BuiltinValue):
            ttype = symbol.ttype

            if isinstance(ttype, solnodes2.Type):
                # For builtin values that we create in scope_for_type, we pass in an AST2 Type instead of AST1 Type
                return ttype
            else:
                return self.builder.map_type(ttype)

        value = symbol.value

        if self.builder.is_top_level(value):
            # Contract, interface, struct, library
            return self.builder.get_contract_type(symbol)
        elif isinstance(value, (solnodes1.Parameter, solnodes1.Var)):
            return self.builder.map_type(value.var_type)
        elif isinstance(value, solnodes1.FunctionDefinition):
            def param_types(ps):
                return [self.builder.map_type(p.var_type) for p in ps]
            return solnodes2.FunctionType(param_types(value.parameters), param_types(value.returns))
        elif isinstance(value, (solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration)):
            return self.builder.map_type(value.var_type)
        else:
            assert False, f'{type(value)}'

    def scope_for_type(self, node: solnodes1.Node, ttype: solnodes2.Type) -> symtab.Scope:
        if isinstance(ttype, solnodes2.ResolvedUserType):
            scope = node.scope.find_single(ttype.value.x.name.text)
        elif isinstance(ttype, solnodes2.BuiltinType):
            scope = node.scope.find_single(ttype.name)
        elif isinstance(ttype, solnodes2.MetaTypeType):
            type_key = symtab.meta_type_key(ttype)
            scope = node.scope.find_single(type_key)

            if scope is None:
                # Create a meta type entry in the symbol table
                # https://docs.soliditylang.org/en/latest/units-and-global-variables.html#type-information
                members = [
                    ('name', solnodes2.StringType()), ('creationCode', solnodes2.Bytes()),
                    ('runtimeCode', solnodes2.Bytes())
                ]

                base_ttype = ttype.ttype

                if isinstance(base_ttype, solnodes2.IntType):
                    members.extend([('min', base_ttype), ('max', base_ttype)])

                if isinstance(base_ttype, solnodes2.ResolvedUserType) and isinstance(base_ttype.value.x, solnodes2.InterfaceDefinition):
                    members.append(('interfaceId', solnodes2.Bytes(4)))

                scope = symtab.create_builtin_scope(type_key, values=members)
                node.scope.add_global_symbol(scope)
        else:
            # this is a primitive (probably). E.g. We look up the global <type: int256> or if the type is a metatype
            # <metatype: int256>
            type_key = symtab.type_key(ttype)
            scope = node.scope.find_single(type_key)

            if not scope:
                fields = []

                if isinstance(ttype, solnodes2.FunctionType):
                    # Function selector, specific to the function type itself
                    fields.append(('selector', solnodes2.Bytes(4)))

                scope = symtab.create_builtin_scope(type_key, values=fields)
                node.scope.add_global_symbol(scope)

        assert isinstance(scope, symtab.Scope)
        return scope

class Builder:

    def __init__(self):
        self.user_types: Dict[str, solnodes2.ContractDefinition] = {}
        self.type_helper = TypeHelper(self)
        self.processed: Set[solnodes1.SourceUnit] = set()
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

    def get_contract_type(self, user_type_symbol: symtab.Symbol) -> solnodes2.ResolvedUserType:
        return solnodes2.ResolvedUserType(solnodes2.Ref(self.load_if_required(user_type_symbol)))

    def get_user_type(self, ttype: solnodes1.UserType):
        """Maps an AST1 UserType to AST2 ResolvedUserType"""
        name = ttype.name.text

        if '.' in name:
            # this is a qualified identifier, i.e. X.Y or X.Y.Z, etc
            parts = name.split('.')
            scope = ttype.scope

            for p in parts:
                scope = scope.find_single(p)
            s = scope
        else:
            s = ttype.scope.find_single(name)

        if not s:
            raise ValueError(f"Can't resolve {ttype}")

        return self.get_contract_type(s)

    def _todo(self, node):
        raise ValueError(f'TODO: {type(node)}')

    def map_type(self, ttype: solnodes1.Type) -> solnodes2.Type:
        if isinstance(ttype, solnodes1.UserType):
            return self.get_user_type(ttype)
        elif isinstance(ttype, solnodes1.VariableLengthArrayType):
            return solnodes2.VariableLengthArrayType(self.map_type(ttype.base_type), self.refine_expr(ttype.size))
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

        self._todo(ttype)

    def symbol_to_ref(self, symbol: symtab.Symbol):
        ast1_node = symbol.value


    def refine_stmt(self, node: solnodes1.Stmt):
        if isinstance(node, solnodes1.VarDecl):
            if len(node.variables) == 1:
                return solnodes2.VarDecl(self.var(node.variables[0]), self.refine_expr(node.value) if node.value else None)
            else:
                return solnodes2.TupleVarDecl([self.var(x) for x in node.variables], self.refine_expr(node.value))
        elif isinstance(node, solnodes1.ExprStmt):
            return solnodes2.ExprStmt(self.refine_expr(node.expr))
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
            parent_type = self.get_contract_type(callee_symbol.parent_scope)

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
                val_or_vals = self.refine_expr(rval)

            assert isinstance(val_or_vals, (solnodes2.Expr, list))

            if not isinstance(val_or_vals, list):
                val_or_vals = [val_or_vals]
            return solnodes2.Return(val_or_vals)
        elif isinstance(node, solnodes1.AssemblyStmt):
            return solnodes2.Assembly(node.code)
        elif isinstance(node, solnodes1.While):
            return solnodes2.While(self.refine_expr(node.expr), self.refine_stmt(node.body))
        elif isinstance(node, solnodes1.For):
            return solnodes2.For(self.refine_stmt(node.initialiser), self.refine_expr(node.condition),
                       self.refine_expr(node.advancement), self.refine_stmt(node.body))
        elif isinstance(node, solnodes1.Break):
            return solnodes2.Break()
        elif isinstance(node, solnodes1.Continue):
            return solnodes2.Continue()
        elif isinstance(node, solnodes1.Revert):
            # Special case of refine_function_call, should return CreateError
            error = self.refine_call_function(node.call)
            assert isinstance(error, solnodes2.CreateError)
            return solnodes2.Revert(error=error, reason=None)
        self._todo(node)

    def get_declaring_contract(self, node: solnodes1.Node) -> Union[symtab.ContractOrInterfaceScope, symtab.LibraryScope]:
        return node.scope.find_first_ancestor_of((symtab.ContractOrInterfaceScope, symtab.LibraryScope))

    def get_self_object(self, node: Union[solnodes1.Stmt, solnodes1.Expr]):
        ast1_current_contract = self.get_declaring_contract(node)
        contract_type: solnodes2.ResolvedUserType = self.get_contract_type(ast1_current_contract)
        return solnodes2.SelfObject(contract_type.value)

    def get_super_object(self, node: Union[solnodes1.Stmt, solnodes1.Expr]):
        ast1_current_contract = self.get_declaring_contract(node)
        contract_type: solnodes2.ResolvedUserType = self.get_contract_type(ast1_current_contract)
        return solnodes2.SuperObject(solnodes2.SuperType(contract_type.value))

    def check_builtin_function(self, name: str, new_args: List[solnodes2.Expr], new_mods: List[solnodes2.Modifier]) -> Optional[solnodes2.BuiltInCall]:
        def assert_simple_call(arg_len=1, mod_len=0):
            assert len(new_args) == arg_len and len(new_mods) == mod_len

        if name == 'keccak256':
            assert_simple_call()
            return solnodes2.BuiltInCall([], new_args, name, solnodes2.FixedLengthArrayType(solnodes2.ByteType(), 32))
        elif name == 'addmod' or name == 'mulmod':
            # (uint x, uint y, uint k) returns (uint)
            assert_simple_call(arg_len=3)
            return solnodes2.BuiltInCall([], new_args, name, solnodes2.UIntType())
        elif name == 'sub' or name == 'div' or name == 'mod' or name == 'min' or name == 'max':
            # mod(uint x, uint y) returns (uint)
            assert_simple_call(arg_len=2)
            return solnodes2.BuiltInCall([], new_args, name, solnodes2.UIntType())
        elif name == 'exp' or name == 'log2' or name == 'sqrt':
            # (uint x) returns (uint)
            assert_simple_call()
            return solnodes2.BuiltInCall([], new_args, name, solnodes2.UIntType())

    def refine_named_arg(self, arg):
        return solnodes2.NamedArgument(solnodes2.Ident(arg.name.text), self.refine_expr(arg.value))

    def refine_call_function(self, expr):
        # solnodes1.CallFunction is very confusing because the grammar allows basically any expression into it and
        # doesn't parse the name of the function call as a separate entity. So we have to do our own analysis
        # of expr.callee to figure out wtf was accepted by the parser
        callee = expr.callee

        new_args = []
        new_named_args = []

        for x in expr.args:
            if isinstance(x, solnodes1.NamedArg):
                new_named_args.append(self.refine_named_arg(x))
            else:
                new_args.append(self.refine_expr(x))

        new_modifiers = [self.modifier(x) for x in expr.modifiers]

        # helper for a few cases
        def assert_simple_call(arg_len=1, mod_len=0, named_len=0):
            if arg_len is not None:
                assert len(new_args) == arg_len
            if mod_len is not None:
                len(new_modifiers) == mod_len
            if named_len is not None:
                len(new_named_args) == named_len

        if isinstance(callee, solnodes1.Ident):
            if callee.text == 'require':
                return solnodes2.RequireExpr(new_modifiers, new_args)
            elif callee.text == 'revert':
                assert_simple_call()
                assert isinstance(new_args[0].type_of(), solnodes2.StringType)
                # Some solidity grammars give this as its node AST1 node, others don't
                return solnodes2.Revert(error=None, reason=new_args[0])
            elif callee.text == 'gasleft':
                assert_simple_call(arg_len=0)
                # this is the same as msg.gas
                return solnodes2.GlobalValue('msg.gas', solnodes2.UIntType(256))
            elif callee.text == 'address':
                # i.e. address(xyz)
                # Sometimes the callee gets parsed as an AddressType and sometimes as an Ident(text='address'), why?
                # I have no idea...
                # address(my_obj) but we treat it as a Cast expr type instead of its own separate node
                assert_simple_call()
                return solnodes2.Cast(solnodes2.AddressType(is_payable=False), new_args[0])
            else:
                builtin_call = self.check_builtin_function(callee.text, new_args, new_modifiers)
                if builtin_call:
                    return builtin_call

                ident_target_symbols = expr.scope.find(callee.text)

                if len(ident_target_symbols) == 0:
                    raise ValueError('No resolve')

                if len(ident_target_symbols) == 1:
                    ident_target_symbol = ident_target_symbols[0]
                else:
                    # We have multiple things this call could resolve to, this should be a polymorphic call so
                    # check that all the symbols are functions
                    type_a = type(ident_target_symbols[0])
                    all([type(x) == type_a for x in ident_target_symbols])

                    assert isinstance(ident_target_symbols[0], symtab.ModFunErrEvtScope)

                    ident_target_symbol = self.find_method(ident_target_symbols, [arg.type_of() for arg in new_args])

                if isinstance(ident_target_symbol, symtab.ContractOrInterfaceScope):
                    assert_simple_call()
                    return solnodes2.Cast(self.get_contract_type(ident_target_symbol), new_args[0])
                elif isinstance(ident_target_symbol, symtab.ModFunErrEvtScope):
                    target = ident_target_symbol.value

                    if isinstance(target, solnodes1.FunctionDefinition):
                        # This is an unqualified function call, i.e. the statement 'my_func(x,y)'. The base
                        # is set as self
                        return solnodes2.FunctionCall(new_modifiers, new_args, self.get_self_object(expr), solnodes2.Ident(target.name.text))
                    elif isinstance(target, solnodes1.ErrorDefinition):
                        # Special case of refine_function_call for Revert Stmts => check parent is a revert
                        assert_simple_call(arg_len=None)
                        return solnodes2.CreateError(target, new_args)
                elif isinstance(ident_target_symbol, symtab.StructScope):
                    assert_simple_call(arg_len=None)  # any number of args, 0 modifiers
                    return solnodes2.CreateStruct(self.get_contract_type(ident_target_symbol), new_args)
        elif isinstance(callee, solnodes1.AddressType):
            # address(my_obj) but we treat it as a Cast expr type instead of its own separate node
            assert_simple_call()
            return solnodes2.Cast(self.map_type(callee), new_args[0])
        elif isinstance(callee, solnodes1.GetMember):
            base = callee.obj_base
            if isinstance(base, solnodes1.GetMember):
                new_base = self.refine_expr(base)
            elif isinstance(base, solnodes1.CallFunction):
                new_base = self.refine_expr(base)
            elif isinstance(base, solnodes1.Ident):
                if base.text == 'abi':
                    if callee.name.text == 'encode' or callee.name.text == 'encodePacked' or callee.name.text == 'encodeWithSelector' or callee.name.text == 'encodeWithSignature':
                        return solnodes2.BuiltInCall(
                            new_modifiers,
                            new_args,
                            f'abi.{callee.name.text}',
                            solnodes2.ArrayType(solnodes2.ByteType())
                        )
                    elif callee.name.text == 'decode':
                        assert_simple_call(arg_len=2)
                        assert isinstance(new_args[1], solnodes2.TypeLiteral)

                        return solnodes2.BuiltInCall(
                            new_modifiers,
                            [new_args[1]],
                            'abi.decode',
                            solnodes2.TupleType(new_args[1].type_of())
                        )
                elif base.text == 'super':
                    new_base = self.get_super_object(expr)
                elif base.text == 'this':
                    new_base = self.get_self_object(expr)
                else:
                    ident_symbol = expr.scope.find_single(base.text)
                    ident_node = ident_symbol.value
                    if isinstance(ident_node, solnodes1.StateVariableDeclaration):
                        # state_var.xyz() => self.state_var.xyz()
                        new_base = solnodes2.StateVarLoad(self.get_self_object(expr), solnodes2.Ident(ident_node.name.text))
                    elif isinstance(ident_node, (solnodes1.Parameter, solnodes1.Var)):
                        new_base = solnodes2.LocalVarLoad(self.var(ident_node))
                    else:
                        assert isinstance(ident_symbol, symtab.Scope)
                        target_symbols = ident_symbol.find(callee.name.text)

                        if len(target_symbols) == 0:
                            raise ValueError('No resolve')

                        if len(target_symbols) == 1:
                            target_symbol = target_symbols[0]
                        else:
                            # check homogenous
                            type_a = type(target_symbols[0])
                            all([type(x) == type_a for x in target_symbols])

                            assert isinstance(target_symbols[0], symtab.ModFunErrEvtScope)

                            target_symbol = self.find_method(target_symbols, [arg.type_of() for arg in new_args])

                        if isinstance(target_symbol, symtab.ModFunErrEvtScope):
                            assert isinstance(ident_node, (solnodes1.LibraryDefinition, solnodes1.ContractDefinition))
                            # static library call, e.g. MyLib.xyz()
                            return solnodes2.DirectCall(new_modifiers, new_args, self.get_contract_type(ident_symbol), solnodes2.Ident(target_symbol.value.name.text))
                        else:
                            assert isinstance(target_symbol, symtab.StructScope)
                            return solnodes2.CreateStruct(self.get_contract_type(target_symbol), new_args)
            else:
                # This is here so that I can stop on each pattern, the above creation of new_base are approved patterns
                self._todo(expr)

            # Check to see if the call resolves to something and if so create a FunctionCall

            # target: solnodes1.FunctionDefinition = self.find_method(expr.scope, new_base,
            #                                                         [x.type_of() for x in new_args],
            #                                                         callee.name.text)
            # assert target

            return solnodes2.FunctionCall(
                new_modifiers,
                new_args,
                new_base,
                solnodes2.Ident(callee.name.text)
            )
        elif isinstance(callee, solnodes1.New):
            if isinstance(callee.type_name, (solnodes1.ArrayType, solnodes1.StringType)):
                # 'new bytes(0)' -> CreateMemoryArray(ttype = FixedLengthArrayType(ttype=ByteType, size=32), size=Literal(0))
                # Note, I've also seen 'new string(len)' , this seems to be valid as strings are arrays of bytes. This is
                # made valid by StringType being a subtype of ArrayType
                assert_simple_call()
                size_expr = self.refine_expr(expr.args[0])
                return solnodes2.CreateMemoryArray(self.map_type(callee.type_name), size_expr)
            # SELF NOTE: don't pass the type_name to refine expr on a whim, it can resolve to too many things
        elif isinstance(callee, (solnodes1.ArrayType, solnodes1.StringType, solnodes1.IntType)):
            assert_simple_call()
            # E.g. 'bytes32(0)' -> Cast(ttype = FixedLengthArrayType(ttype=ByteType, size=32), size=Literal(0))
            # E.g. 'bytes(baseURI)'
            return solnodes2.Cast(self.map_type(callee), new_args[0])

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

    def any_or_all(self, args):
        return all(args) == any(args)

    def follow_get_member(self, get_member: solnodes1.GetMember) -> solnodes2.Type:
        base = get_member.obj_base

        def scope_for_type(ttype: solnodes2.Type) -> symtab.Scope:
            if isinstance(ttype, solnodes2.ResolvedUserType):
                type_key = ttype.value.x.name.text
            else:
                type_key = symtab.type_key(ttype)
            scope = base.scope.find_single(type_key)
            assert isinstance(scope, symtab.Scope)
            return scope

        symbol = None
        scope = None

        if isinstance(base, solnodes1.GetMember):
            # Find the symbol, get its type, get the scope of the type
            symbol = self.follow_get_member(base)
        elif isinstance(base, solnodes1.Ident):
            if base.text == 'this':
                scope = get_member.scope.find_first_ancestor_of((symtab.ContractOrInterfaceScope, symtab.LibraryScope,
                                                                 symtab.EnumScope, symtab.StructScope))
            else:
                symbol = get_member.scope.find_single(base.text)
        else:
            new_expr = self.refine_expr(base)
            scope = scope_for_type(new_expr.type_of())

        if symbol:
            ttype = self.type_helper.symbol_to_ast2_type(symbol)
            scope = scope_for_type(ttype)

        if get_member.name.text == 'selector':
            raise ValueError('selector is not a concrete ref')

        result = scope.find_single(get_member.name.text)

        return result

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

    def refine_expr(self, expr: solnodes1.Expr):

        def ff():
            # check if its really a Stmt call, e.g. require(), assert(), revert etc
            if isinstance(expr, solnodes1.CallFunction) and isinstance(expr.callee, solnodes1.Ident):
                if expr.callee.text == 'require' or expr.callee.text == 'revert':
                    return
            print(f'{expr} => {self.type_helper.get_expr_type(expr, allow_multiple=True)}')

        ff()

        if isinstance(expr, solnodes1.UnaryOp):
            return solnodes2.UnaryOp(self.refine_expr(expr.expr), expr.op, expr.is_pre)
        elif isinstance(expr, solnodes1.BinaryOp):
            left = self.refine_expr(expr.left)
            right = self.refine_expr(expr.right)

            if expr.op in self.ASSIGN_TO_OP:
                # this is an assign, make sure the lhs is a valid assignment target.
                # if the OP does some other mathematical operation then split the rhs into a load lhs + rhs
                assert isinstance(left, (solnodes2.StateVarLoad, solnodes2.LocalVarLoad, solnodes2.ArrayLoad))

                if expr.op != solnodes1.BinaryOpCode.ASSIGN:
                    value = solnodes2.BinaryOp(left, right, self.ASSIGN_TO_OP[expr.op])
                else:
                    value = right

                if isinstance(left, solnodes2.StateVarLoad):
                    return solnodes2.StateVarStore(left.base, left.name, value)
                elif isinstance(left, solnodes2.ArrayLoad):
                    return solnodes2.ArrayStore(left.base, left.index, value)
                else:
                    return solnodes2.LocalVarStore(left.var, value)
            else:
                return solnodes2.BinaryOp(left, right, expr.op)
        elif isinstance(expr, solnodes1.Ident):
            # We should only reach this if this Ident is a reference to a variable load. This shouldn't be
            # hit when resolving other uses of Idents

            if expr.text == 'this':
                return self.get_self_object(expr)
            elif expr.text == '_':
                # NOTE: we return a Stmt here instead of an Expr. In a later pass, ExprStmt(ExecModifiedCode)
                # gets reduced to just ExecModifiedCode in place of ExprStmt
                return solnodes2.ExecModifiedCode()

            ident_symbol = expr.scope.find_single(expr.text)
            assert ident_symbol  # must be resolved to something

            ident_target = ident_symbol.value  # the AST1 node that this Ident is referring to

            if isinstance(ident_target, solnodes1.StateVariableDeclaration):
                # i.e. Say we are in contract C and ident is 'x', check that 'x' is declared in C
                # this is so that we know the 'base' of this load will be 'self'
                ast1_current_contract = self.get_declaring_contract(expr)
                var_declaring_contract = self.get_declaring_contract(ident_target)

                assert self.is_subcontract(ast1_current_contract, var_declaring_contract)

                contract_type: solnodes2.ResolvedUserType = self.get_contract_type(var_declaring_contract)

                return solnodes2.StateVarLoad(solnodes2.SelfObject(contract_type.value), solnodes2.Ident(expr.text))
            elif isinstance(ident_target, (solnodes1.Parameter, solnodes1.Var)):
                return solnodes2.LocalVarLoad(self.var(ident_target))
            else:
                self._todo(ident_target)
        elif isinstance(expr, solnodes1.CallFunction):
            return self.refine_call_function(expr)
        elif isinstance(expr, solnodes1.GetMember):
            base = expr.obj_base

            mname = expr.name.text

            if mname == 'selector':
                # the selector is a bytes4 ABI function selector
                assert isinstance(base, solnodes1.GetMember)
                base_scope = self.follow_get_member(base)
                assert isinstance(base_scope.value, solnodes1.FunctionDefinition)
                return solnodes2.ABISelector(solnodes2.Ref(base_scope.value.ast2_node))

            if mname == 'length':
                return solnodes2.DynamicBuiltInValue('length', solnodes2.UIntType(), self.refine_expr(base))

            if mname == 'min' or mname == 'max' or mname == 'creationCode' or mname == 'interfaceId'\
                    or mname == 'runtimeCode' or mname == 'name':
                new_base = self.refine_expr(base)
                assert isinstance(new_base.type_of(), solnodes2.MetaTypeType)
                return solnodes2.DynamicBuiltInValue(mname, new_base.type_of(), new_base)

            if mname == 'code':
                new_base = self.refine_expr(base)
                assert isinstance(new_base.type_of(), solnodes2.AddressType)
                return solnodes2.DynamicBuiltInValue(mname, solnodes2.Bytes(), new_base)

            if mname == 'balance':
                return solnodes2.DynamicBuiltInValue('length', solnodes2.UIntType(), self.refine_expr(base))

            if isinstance(base, solnodes1.Ident):
                if base.text == 'msg':
                    if expr.name.text == 'value':
                        return solnodes2.GlobalValue('msg.value', solnodes2.UIntType())
                    elif expr.name.text == 'gas':
                        return solnodes2.GlobalValue('msg.gas', solnodes2.UIntType())
                    elif expr.name.text == 'sender':
                        return solnodes2.GlobalValue('msg.sender', solnodes2.AddressType(False))
                    elif expr.name.text == 'data':
                        return solnodes2.GlobalValue('msg.data', solnodes2.ArrayType(solnodes2.ByteType()))
                    elif expr.name.text == 'sig':
                        # FIXME: size
                        return solnodes2.GlobalValue('msg.sig', solnodes2.FixedLengthArrayType(solnodes2.UIntType()))

                # MyEnum.MYVALUE, don't want to pass Ident(text='MyEnum') to refine_expr as it's not an Expr that can
                # be loaded as a base itself
                target_symbols = base.scope.find(base.text)
                if len(target_symbols) == 1 and isinstance(target_symbols[0], symtab.EnumScope):
                    return solnodes2.EnumMemberLoad(self.get_contract_type(target_symbols[0]), solnodes2.Ident(mname))

            ident_target = self.follow_get_member(expr)
            # this is assumed to be a field load only, i.e. x.y (in AST1 x.y would be a child of a FunctionCall
            # so x.y() should be a FunctionCall instead of the child of a FC)
            new_base = self.refine_expr(base)
            return solnodes2.StateVarLoad(new_base, mname)
        elif isinstance(expr, solnodes1.Literal):
            if isinstance(expr.value, tuple):
                assert not expr.unit

                type_args = [self.type_helper.map_as_type_arg(arg) for arg in expr.value]
                are_type_args = [isinstance(arg, solnodes1.Type) for arg in type_args]
                assert self.any_or_all(are_type_args)

                if any(are_type_args):
                    # the grammar has 'TupleExpression' s, e.g. '(' exprList ')'. The exprs it allows can also be types.
                    # Either all or none of the exprs must be types
                    # but the parser is weird
                    return solnodes2.TypeLiteral(solnodes2.TupleType([self.map_type(t) for t in type_args]))
                elif len(expr.value) == 1:
                    # Bracketed expressions, not tuples, e.g. (x).y() , (x) isn't a tuple so unpack here
                    assert isinstance(expr.value[0], solnodes1.Expr)
                    return self.refine_expr(expr.value[0])
                else:
                    # Actual tuple but tuples aren't part of solidity properly, they are just syntactic sugar
                    # e.g. for returning multiple values or unpacking calls that return multiple values. So check
                    # that the parent is a return and as a special case to function, we return a list of the values
                    # instead of an Expr type. The parent case for Return can handle returning a list as well
                    assert isinstance(expr.parent, solnodes1.Return)
                    return [self.refine_expr(e) for e in expr.value]
            elif isinstance(expr.value, solnodes1.Type):
                self._todo(expr)
            else:
                assert not isinstance(expr.value, solnodes1.Expr)
                return solnodes2.Literal(expr.value, self.literal_type(expr.value), expr.unit)
        elif isinstance(expr, solnodes1.GetArrayValue):
            return solnodes2.ArrayLoad(self.refine_expr(expr.array_base), self.refine_expr(expr.index))
        elif isinstance(expr, solnodes1.PayableConversion):
            # address payable cast
            assert len(expr.args) == 1
            return solnodes2.Cast(solnodes2.AddressType(True), self.refine_expr(expr.args[0]))
        elif isinstance(expr, solnodes1.CreateMetaType):
            return solnodes2.GetType(self.map_type(expr.base_type))
        elif isinstance(expr, solnodes1.TernaryOp):
            return solnodes2.TernaryOp(self.refine_expr(expr.condition), self.refine_expr(expr.left), self.refine_expr(expr.right))
        self._todo(expr)

    def literal_type(self, value):
        if isinstance(value, int):
            return solnodes2.UIntType()
        elif isinstance(value, str):
            return solnodes2.StringType()
        return self._todo(value)


    def find_method(self, possible_matches: List[symtab.Symbol], arg_types: List[solnodes2.Type]):
        assert not any([x is None for x in arg_types])

        def get_arg_types(func_scope: symtab.ModFunErrEvtScope) -> List[solnodes2.Type]:
            assert isinstance(func_scope, symtab.ModFunErrEvtScope)
            return [self.map_type(p.var_type) for p in func_scope.value.parameters]

        def check_arg_types(s: symtab.Symbol) -> bool:
            if isinstance(s, symtab.UsingFunctionSymbol):
                # Consider the expression x.sub(y) where x and y are vars of type 'int256' and there's a Using directive
                # that's added the 'sub' method to the int256 type. This UsingFunctionSymbol points to a function
                # 'sub (int256, int256)' but the actual function call in the expression takes 1 parameter. If we just
                # parse the expression for the argument types we would only have [unit256] for 'y' but the actual
                # method we want to find has [int256, int256].

                # resolved symbol is the function scope
                target_param_types = get_arg_types(s.resolve_base_symbol())
                actual_param_types = [self.map_type(s.override_type)] + arg_types
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
            self.map_type(node.var_type),
            location
        )

    def parameter(self, node: solnodes1.Parameter):
        return solnodes2.Parameter(self.var(node))

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
            elif isinstance(n, solnodes1.StateVariableDeclaration):
                return solnodes2.StateVariableDeclaration(name, None, [], None)
            elif isinstance(n, solnodes1.EventDefinition):
                return solnodes2.EventDefinition(name, [], None)
            elif isinstance(n, solnodes1.ModifierDefinition):
                return solnodes2.ModifierDefinition(name, [], [], None)
            else:
                self._todo(ast1_node)

        logging.getLogger('AST2').info(f' making skeleton for {ast1_node.name}')

        ast2_node = _make_new_node(ast1_node)
        ast1_node.ast2_node = ast2_node

        if hasattr(ast1_node, 'parts'):
            for p in ast1_node.parts:
                if self.is_top_level(p):
                    # these units don't get added as parts in AST2, e.g. an embedded contract B in parent contract A
                    # gets loaded as a separate ContractDefinition with the name as A$B
                    self.load_if_required(p.scope)

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

        if isinstance(ast1_node, solnodes1.StateVariableDeclaration):
            ast2_node.ttype = self.map_type(ast1_node.var_type)

        if isinstance(ast1_node, solnodes1.EventDefinition):
            ast2_node.inputs = [solnodes2.EventParameter(solnodes2.Ident(p.name.text if p.name else f'<unnamed:{i}'), self.map_type(p.var_type), p.is_indexed)
                                for i,p in enumerate(ast1_node.parameters)]

        if isinstance(ast1_node, solnodes1.ModifierDefinition):
            ast2_node.inputs = [self.parameter(x) for x in ast1_node.parameters]

        if self.is_top_level(ast1_node):
            self.to_refine.append(ast1_node)

        return ast2_node

    def refine_unit_or_part(self, ast1_node: solnodes1.SourceUnit):
        if not isinstance(ast1_node, (solnodes1.ContractDefinition, solnodes1.InterfaceDefinition,
                                      solnodes1.StructDefinition, solnodes1.LibraryDefinition,
                                      solnodes1.EnumDefinition,
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
                    solnodes2.InheritSpecifier(self.get_user_type(x.name), [self.refine_expr(arg) for arg in x.args])
                    for x in ast1_node.inherits
                ]

            # contracts, interfaces, libraries
            if hasattr(ast1_node, 'parts'):
                for part in ast1_node.parts:
                    if isinstance(part, solnodes1.UsingDirective):
                        # Not sure if things other than contracts can have usings, if this should errors, we can investigate
                        library_scope = part.scope.find_single(part.library_name.text)
                        assert isinstance(library_scope.value, solnodes1.LibraryDefinition)
                        library = self.get_contract_type(part.scope.find_single(part.library_name.text))
                        ast2_node.type_overrides.append(solnodes2.LibraryOverride(self.map_type(part.override_type), library))

                    if hasattr(part, 'ast2_node'):
                        self.refine_unit_or_part(part)

            # structs
            if hasattr(ast1_node, 'members'):
                ast2_node.members = [solnodes2.StructMember(self.map_type(x.member_type), solnodes2.Ident(x.name.text)) for x in
                                     ast1_node.members]

            # enums
            if hasattr(ast1_node, 'values'):
                ast2_node.values = [solnodes2.Ident(n.text) for n in ast1_node.values]

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
        return None

    def is_top_level(self, node: solnodes1.Node):
        # FunctionDefinitions are set as SourceUnits in AST1 but not in AST2
        return isinstance(node, solnodes1.SourceUnit) and not isinstance(node, solnodes1.FunctionDefinition)
