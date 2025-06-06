import typing
from dataclasses import dataclass
from typing import List, Union, Dict, Deque, cast, Optional
from types import UnionType
from collections import deque, defaultdict
from copy import deepcopy

from solidity_parser.ast import nodebase, solnodes as solnodes1, types as soltypes
from solidity_parser.ast import solnodes2 as solnodes2, symtab

import logging
import functools

from solidity_parser.ast.mro_helper import c3_linearise
from solidity_parser import errors
from solidity_parser.ast.solnodes import ModifierDefinition, FunctionDefinition, ErrorDefinition, EventDefinition

T = typing.TypeVar('T')


class ErrorHandler:
    """
    Keeps track of what AST2Builder is doing and captures the line tracking information when errors happen. Also wraps
    Python errors in our own errors types if required and provides assertion failure checking.

    The general idea of this class is to make sure AST2Builder operations return consistent error types by wrapping
    them in CodeProcessingErrors so that the client can catch and decide what to do with them.
    """

    def __init__(self, create_state, quiet_errors=True):
        """
        :param create_state: A function used to compute the state of the builder for a node when an error context
                             wrapped function is called
        :param quiet_errors: Whether to throw an error immediately or store it in the caught_errors list
        """

        # whether to throw a caught error immediately or store it in the caught_errors list for a client to consume
        # later, this is used for testing where fast errors can be caught and fail the test quickly
        self.quiet_errors = quiet_errors
        self.caught_errors = []
        # current state of the builder
        self.state = None
        # state creator function, takes a node, returns a state
        self.create_state = create_state

    def handle_processing_error(self, error: errors.CodeProcessingError):
        """
        Error callback handler for AST2Builder functions to call when a CodeProcessingError (only) occurs.
        """
        # reraise if not quiet
        if self.quiet_errors:
            logging.getLogger('AST2').error(f'Processing error: {error.args[0]}')
            self.caught_errors.append(error)
        else:
            raise error

    @staticmethod
    def make_processing_error_args(message: str, node: solnodes1.AST1Node) -> errors.CPEArgs:
        """ Helper to make the input args tuple for a CodeProcessingError from a message and AST1 node """
        file_scope = node.scope.find_first_ancestor_of(symtab.FileScope)
        return message, file_scope.source_unit_name, node.linenumber(), node.offset()

    def with_error_context(self, func):
        """
        Decorator that takes a function, f, and wraps it in a function that captures the current state of the builder
        before executing f and restores the state afterwards. If any errors occur in the process, a CodeProcessingError
        (specifically an UnexpectedCodeProcessingError) is raised, which should be allowed to propagate to the client of
        the builder.
        """
        @functools.wraps(func)
        def wrapped_function(node, *args, **kwargs):
            # Store current state
            prev_state = self.state
            # Create a new state for the node
            state = self.create_state(node)
            self.state = state
            try:
                result = func(node, *args, **kwargs)
            except errors.CodeProcessingError:
                # CPE, reraise
                raise
            except Exception as e:
                # Non CPE, wrap in CPE
                error_args = self.make_processing_error_args(e.args[0] if e.args else f'{type(e)}', state.current_node)
                raise errors.UnexpectedCodeProcessingError(*error_args, e) from e
            finally:
                # Restore state after call
                self.state = prev_state
            return result
        return wrapped_function

    def todo(self, node) -> T:
        """
        Forces an error if the node is not supported by the builder. Since it always raises, the return type is fully
        polymorphic and can be used by the builder to do anything.
        E.g. a common pattern is to return the result of this function to mark the end of control flow in the builder
        code return self.error_handler.todo(node)
        """
        return self._todo(node)

    def error(self, msg, *predicates):
        """
        Raises an error with the given message if any of the predicates fail. This is used for user level errors, i.e.
        the input code is invalid
        """
        return self._error(msg, *predicates)

    def assert_error(self, msg, *predicates):
        """
        Raises an assertion error with the given message if any of the predicates fail, very similar to error but used
        for 'internal' errors, i.e. compiler assumptions that must pass
        """
        return self._assert_error(msg, *predicates)

    def _todo(self, node) -> T:
        # this always raises an error, so let the return type be suitable for any use case, e.g. return _todo
        self._error(f'{type(node)} not supported/implemented')
        return None

    def _error(self, msg, *predicates):
        # Used for user level errors, i.e. the input code has an issue
        failure = not predicates or any(not p for p in predicates)
        # i.e. one failed. If there were no predicates supplied, it's a guaranteed failure
        if failure:
            node = self.state.current_node
            raise errors.CodeProcessingError(*self.make_processing_error_args(msg, node))
        return True

    def _assert_error(self, msg, *predicates):
        # Used for 'internal' errors, i.e. compiler man assumptions that must pass
        return self._error(f'Internal assertion fault: {msg}', *predicates)


class TypeHelper:
    """
    Helper class for computing AST2 types from AST1 nodes. This is required because AST1 nodes are not linked and do not
    have type information associated with some nodes, i.e. the node trees aren't able to compute types on their own.
    """
    def __init__(self, builder: 'Builder', error_handler: ErrorHandler):
        self.builder = builder
        self.error_handler = error_handler

    @staticmethod
    def any_or_all(args):
        """ Returns True if any or all args are True """
        return (len(args) == 0) or (any(args) == all(args))
    
    def create_filter_using_scope(self, base_type: soltypes.Type):
        # creates a filter for searching in the symtab. This is required because when a using statement is seen, all of
        # the functions from the library are imported into the current scope, even if they don't match the type
        # specified in the using statement. This filter checks if the type in the using statement matches the given
        # base_type
        def test_predicate(s: symtab.Symbol):
            if isinstance(s, symtab.UsingFunctionSymbol):
                # override type is the type specified in the using statement
                override_type = self.get_expr_type(s.override_type)
                return override_type.can_implicitly_cast_from(base_type)
            else:
                return True
        return test_predicate
            
    def get_current_contract_type(self, node) -> solnodes2.ResolvedUserType:
        """ Returns the ResolvedUserType the given node is declared in """
        return self.get_contract_type(self.builder.get_declaring_contract_scope(node))

    def deduplicate_func_types(self, ttypes: list[soltypes.Type]):
        # unfortunately not this simple because the functions can look different but be the "same" for our purposes here.
        # e.g. the weird edge case where we have B extends A, B.f(X) external and A.f(X) public. The function visibility
        # can be "widened"/made less restrictive by the overriding function. In this case the AST nodes will have different
        # hash/eq so list(set(...)) won't deduplicate them
        # n^2 check, shouldn't be too bad in practice
        ftype = [t.is_function() for t in ttypes]
        keep = [True] * len(ttypes)
        for i in range(len(ttypes)):
            if not ftype[i] or not keep[i]:
                continue
            for j in range(i + 1, len(ttypes)):
                if not ftype[j] or not keep[j]:
                    continue
                # f1 and f2 are guaranteed to be functions at this point
                f1, f2 = cast(soltypes.FunctionType, ttypes[i]), cast(soltypes.FunctionType, ttypes[j])
                if f1.can_implicitly_cast_from(f2):
                    keep[j] = False
        return [ttypes[i] for i in range(len(ttypes)) if keep[i]]

    def get_expr_type(self, expr: solnodes1.Expr | soltypes.Type, allow_multiple=False, force_tuple=False, function_callee=False) -> typing.Union[solnodes2.Types, list[solnodes2.Types]]:
        """
        Main helper function that computes the AST2 type of the given AST1 expression

        :param expr: The AST1 expression to type, may be a Type also as types are part of both the AST1 and AST2 nodeset
        :param allow_multiple: Changes the return of this function to a list of types instead of a single type. This is
                               required for expressions that may need extra contextual information to return a single
                               resolved Type, e.g. the callee of a function call without its arguments may resolve to
                               multiple callsites and if this is set to True, the return type will be a list of function
                               types
        :param force_tuple: Forces the return type to be a TupleType instead of a single type in cases where it's
                            ambiguous, e.g. the expression (x) can be either a bracket expression or a tuple expression
        :param function_callee: Whether the expression is the callee of a function call, required to compute the type of
                                state variable lookups as Solidity generates getter functions if the variable is used as
                                a function callee
        :return: The AST2 type of the expression or a list of types if allow_multiple is True
        """

        if isinstance(expr, soltypes.Type):
            # already have a type, either return it or resolve it to make sure it's AST2 and not AST1 only
            return self.map_type(expr)
        elif isinstance(expr, solnodes1.Ident):
            text = expr.text
            if text == 'this':
                return self.get_current_contract_type(expr)
            elif text == 'super':
                # contract_type.value is a Ref[Contract/InterfaceDef] which is what SuperType takes
                contract_type = self.get_current_contract_type(expr)
                return solnodes2.SuperType(contract_type.value)
            else:
                # lookup a single unqualified Ident in the current scope(expr.scope). Note this path ISN'T taken for
                # qualified lookups (e.g. x.y)
                if allow_multiple:
                    # return all matching symbol types
                    symbols = expr.scope.find(text)
                    self.error_handler.assert_error('Expected any or all function callees', self.any_or_all([isinstance(s.value, symtab.ModFunErrEvtScope) for s in symbols]))
                    any_funcs = any([isinstance(s, symtab.ModFunErrEvtScope) for s in symbols])

                    if function_callee and any_funcs:
                        function_chain = self.builder.is_declaration_chain(symbols)
                        if function_chain:
                            # less sophisticated way compared to refine_expr: we need to get the function at the top
                            # of the hierarchy (symtab returns them all), i.e. the one that overrides all the others
                            # ah crap, imagine f(X),f(Y) in contract A, contract A extends B, B has f(X),f(Y)
                            # i.e. two override chains with the same function name. function_chain would be False and the
                            return [self.symbol_to_ast2_type(symbols[0], function_callee=function_callee)]

                        # deduplicate
                        func_types = [self.symbol_to_ast2_type(s, function_callee=function_callee) for s in symbols]
                        return self.deduplicate_func_types(func_types)

                    # non function case
                    return [self.symbol_to_ast2_type(s, function_callee=function_callee) for s in symbols]
                else:
                    inheritable_predicate = symtab.ACCEPT_INHERITABLE(expr.scope)
                    symbols = expr.scope.find(expr.text, predicate=inheritable_predicate)

                    if not symbols:
                        self.error_handler.error(f'Unresolved reference to {expr.text}')
                        assert False  # unreachable as the above error is always raised

                    if len(symbols) == 1:
                        return self.symbol_to_ast2_type(symbols[0], function_callee=function_callee)

                    # we only care about the type here and not the symbols, so if all the types are the same, just
                    # return the type of the first: this might be wrong and we might have to find the highest type
                    # in the lattice
                    possible_types = [self.symbol_to_ast2_type(s, function_callee=function_callee) for s in symbols]
                    types_the_same = [possible_types[0] == t for t in possible_types[1:]]
                    self.error_handler.error(f'Need the same types: {possible_types}', types_the_same)
                    return possible_types[0]
        elif isinstance(expr, solnodes1.GetMember):
            # similar to the Ident case, but we have to resolve the base type first to get the scope in which we will
            # look up the member name
            base_type = self.get_expr_type(expr.obj_base)
            member = expr.name.text

            # Solidity has bytes.concat and string.concat, when this happens the obj_base is bytes or string (subclass
            # of Type, not Ident) and the member is concat. In that case the typekey used for the base type is different
            # so that the builtin object with the concat function can be found
            find_direct_scope = isinstance(expr.obj_base, (soltypes.BytesType, soltypes.StringType))
            scopes = self.scopes_for_type(expr, base_type, use_encoded_type_key=not find_direct_scope)

            if allow_multiple:
                for s in scopes:
                    # search with the using filter here as qualified lookups can resolve to functions introduced by the
                    # using statement
                    symbols = s.find(member, predicate=self.create_filter_using_scope(base_type))
                    if symbols:
                        return [self.symbol_to_ast2_type(s, function_callee=function_callee) for s in symbols]
                return []
            else:
                # TODO: do we need the using filter here as well?
                for s in scopes:
                    symbols = s.find(member)
                    if symbols:
                        # find returns supercontract functions too, the only way this is allowable is if the types all match
                        symbol_types = [self.symbol_to_ast2_type(symbol, function_callee=function_callee) for symbol in symbols]
                        all_same_types = [symbol_types[0] == s_t for s_t in symbol_types]
                        self.error_handler.error('Multiple symbols matched with different types', all_same_types)
                        return symbol_types[0]

            # TODO: change this to error_handler.todo call
            return []
        elif isinstance(expr, solnodes1.Literal):
            value = expr.value
            if isinstance(value, bool):
                # this needs to go before the int check as bool is a subclass of int in python
                return soltypes.BoolType()
            elif isinstance(value, (int, float)):
                if isinstance(value, float):
                    # Try and create an integer out of this float literal. If that's not possible, then the caller
                    # must be expecting FloatType as a possible return so need to assert allow_float
                    full_value = value * (expr.unit.multiplier if expr.unit else 1)
                    if not full_value.is_integer():
                        # This can happen because compiletime floats are allowed in solidity for expressions
                        # that are evaluated at compiletime. E.g. instead of 0.01 ether which would give full_value
                        # an integer value, we could have 0.01 * 1 ether as a binary expr
                        return soltypes.FloatType(full_value)
                    full_value = int(full_value)
                else:
                    full_value = value

                value = full_value

                if value == 0:
                    return soltypes.PreciseIntType(is_signed=False, size=8, real_bit_length=1)

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

                return soltypes.PreciseIntType(is_signed=signed, size=bits, real_bit_length=full_value.bit_length())
            elif isinstance(value, str):
                # TODO: maybe need to revise to a different len calculation based on the docs
                return soltypes.PreciseStringType(real_size=len(value))
            elif isinstance(value, tuple):
                # this is for bracketed expressions, may or may not be a tuple expression
                type_args = [self.map_as_type_arg(arg) for arg in value]
                are_type_args = [isinstance(arg, soltypes.Type) for arg in type_args]

                self.error_handler.assert_error('Tuple type args must be any or all', TypeHelper.any_or_all(are_type_args))

                if any(are_type_args):
                    # the grammar has 'TupleExpression' s, e.g. '(' exprList ')'. The exprs it allows can also be types.
                    # Either all or none of the exprs must be types
                    # but the parser is weird
                    if len(type_args) == 1 and not force_tuple:
                        return self.map_type(type_args[0])
                    else:
                        return soltypes.TupleType([self.map_type(t) for t in type_args])

                self.error_handler.assert_error('Expected all exprs in tuple',
                                           all([isinstance(e, solnodes1.Expr) for e in value]))

                if len(value) == 1:
                    if force_tuple:
                        return soltypes.TupleType([self.get_expr_type(value[0])])
                    else:
                        # Bracketed expressions, not tuples, e.g. (x).y() , (x) isn't a tuple so unpack here
                        return self.get_expr_type(value[0])
                else:
                    # multiple expressions, definitely a tuple
                    return soltypes.TupleType([self.get_expr_type(e) for e in value])
            else:
                return self.error_handler.todo(value)
        elif isinstance(expr, solnodes1.GetArrayValue):
            # array index lookups can be either a mapping or an array lookup
            base_type = self.get_expr_type(expr.array_base)
            if base_type.is_mapping():
                return cast(soltypes.MappingType, base_type).dst
            elif base_type.is_array():
                return cast(soltypes.ArrayType, base_type).base_type
            else:
                return self.error_handler.todo(base_type)
        elif isinstance(expr, solnodes1.GetArraySlice):
            base_type = self.get_expr_type(expr.array_base)
            return base_type
        elif isinstance(expr, solnodes1.BinaryOp):
            t1 = self.get_expr_type(expr.left, force_tuple=expr.op.name.startswith('ASSIGN'))
            t2 = self.get_expr_type(expr.right)

            if (t1.is_user_type() and cast(solnodes2.ResolvedUserType, t1).value.x.is_udvt() and t2.is_user_type()
                    and cast(solnodes2.ResolvedUserType, t2).value.x.is_udvt()):
                member_symbol = self.builder.find_bound_operator_symbol(expr, [t1, t2])
                output_params = member_symbol.value.returns
                self.error_handler.assert_error('Not handled', len(output_params) == 1)
                return self.map_type(output_params[0].var_type)

            if expr.op in [solnodes1.BinaryOpCode.BOOL_AND, solnodes1.BinaryOpCode.BOOL_OR, solnodes1.BinaryOpCode.EQ,
                           solnodes1.BinaryOpCode.NEQ]:
                return soltypes.BoolType()
            elif expr.op in [solnodes1.BinaryOpCode.LTEQ, solnodes1.BinaryOpCode.LT, solnodes1.BinaryOpCode.GT,
                             solnodes1.BinaryOpCode.GTEQ]:
                return soltypes.BoolType()
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
                if expr.op != solnodes1.BinaryOpCode.ASSIGN:
                    # can only compare ints, but we can't use t1 == t2 as we can compare different int types, e.g.
                    # this.x (uint256) == 0 (uint8)

                    self.error_handler.assert_error(f'Invalid assign types {t1}, vs {t2}',
                                               (t1.is_int() and t2.is_int())
                                               or (t1.is_byte_array() and t2.is_byte_array())
                                               or (t1.is_byte_array() and t2.is_int()))

                    if t1.is_int():  # t2 is also an int here
                        return t1 if cast(soltypes.IntType, t1).size > cast(soltypes.IntType, t2).size else t2
                else:
                    if not t2.is_tuple():
                        # tuple assign, note the lhs can have a subset of the RHS, e.g. (a, ) = f()
                        # FIXME: check this properly, myBytes[i] = "x";
                        self.error_handler.assert_error(f'Tuple assign type conformity {t1} vs {t2}',
                                                   (t1.can_implicitly_cast_from(t2))
                                                   or (t1.is_byte() and t2.is_string()))
                return t2
            else:
                return self.error_handler.todo(expr.op)
        elif isinstance(expr, solnodes1.TernaryOp):
            t1 = self.get_expr_type(expr.left)
            t2 = self.get_expr_type(expr.right)

            self.error_handler.error(f'Ternary int == int {t1} vs {t2}', t1.is_int() == t2.is_int())

            if t1.is_int():
                # if they're both ints, then take the bigger type
                return t1 if cast(soltypes.IntType, t1).size > cast(soltypes.IntType, t2).size else t2
            elif t1.is_literal_type() and t2.is_literal_type() and t1.is_string() and t2.is_string():
                # both precise string types but different sizes, take the biggest one
                return t1 if cast(soltypes.PreciseStringType, t1).real_size > cast(soltypes.PreciseStringType, t2).real_size else t2
            else:
                try:
                    assert t1 == t2
                    return t1
                except AssertionError:
                    # t1 = addr payable, t2 = addr
                    # TODO: actually we need to check if there is a base type here
                    if t2.can_implicitly_cast_from(t1):
                        return t1
                    elif t1.can_implicitly_cast_from(t2):
                        return t2
                    else:
                        self.error_handler.assert_error(f'Mismatching ternary cast bases {t1} vs {t2}',
                                                   t2.can_implicitly_cast_from(t1))
        elif isinstance(expr, solnodes1.UnaryOp):
            expr_type = self.get_expr_type(expr.expr)

            if expr_type.is_user_type() and cast(solnodes2.ResolvedUserType, expr_type).value.x.is_udvt():
                member_symbol = self.builder.find_bound_operator_symbol(expr, [expr_type])
                output_params = member_symbol.value.returns
                self.error_handler.assert_error('Not handled', len(output_params) == 1)
                return self.map_type(output_params[0].var_type)

            if expr.op in [solnodes1.UnaryOpCode.INC, solnodes1.UnaryOpCode.DEC, solnodes1.UnaryOpCode.SIGN_NEG,
                           solnodes1.UnaryOpCode.SIGN_POS, solnodes1.UnaryOpCode.BIT_NEG]:
                return expr_type
            elif expr.op == solnodes1.UnaryOpCode.BOOL_NEG:
                return soltypes.BoolType()
            else:
                return self.error_handler.todo(expr.op)
        elif isinstance(expr, solnodes1.CallFunction):
            return self.get_function_expr_type(expr, allow_multiple=allow_multiple)
        elif isinstance(expr, solnodes1.CreateMetaType):
            return soltypes.MetaTypeType(self.map_type(expr.base_type))
        elif isinstance(expr, solnodes1.New):
            return self.map_type(expr.type_name)
        elif isinstance(expr, solnodes1.PayableConversion):
            return soltypes.AddressType(is_payable=True)
        elif isinstance(expr, solnodes1.NamedArg):
            return self.get_expr_type(expr.value)
        elif isinstance(expr, solnodes1.NewInlineArray):
            arg_types: list[soltypes.Type] = [self.get_expr_type(arg) for arg in expr.elements]
            are_ints = any([t.is_int() for t in arg_types])

            if are_ints:
                # if any of the elements is signed, the resultant type can't bn unsigned
                # e.g. [-1, 0, 0] can't be uint8[]
                is_signed = any([cast(soltypes.IntType, t).is_signed for t in arg_types])

                max_real_bit_length = 0
                max_total_length = 0

                for t in arg_types:
                    max_total_length = max(max_total_length, cast(soltypes.IntType, t).size)
                    if t.is_literal_type():
                        max_real_bit_length = max(max_real_bit_length, cast(soltypes.PreciseIntType, t).real_bit_length)

                if any([not t.is_literal_type() for t in arg_types]):
                    # if there are any non precise ones, the whole thing can't be precise, e.g. [0, 1, this.myInt] can't
                    # have a base_type of uint8(1), instead it must be uint(T(this.myInt))
                    base_type = soltypes.IntType(is_signed, max_total_length)
                else:
                    base_type = soltypes.PreciseIntType(is_signed, max_total_length, max_real_bit_length)

                return soltypes.FixedLengthArrayType(base_type, len(expr.elements))
            else:
                self.error_handler.assert_error(f'Different element types: {arg_types}', all([arg_types[0] == t for t in arg_types]))
                return soltypes.FixedLengthArrayType(arg_types[0], len(expr.elements))
        return self.error_handler.todo(expr)

    def check_func_type_inputs(self, ttype: soltypes.FunctionType, expr: solnodes1.CallFunction):
        named_args = {a.name.text: self.get_expr_type(a.value) for a in expr.args if isinstance(a, solnodes1.NamedArg)}

        if len(named_args) > 0:
            func_params = {p.name.text: p.ttype for p in ttype.input_params}

            if set(func_params.keys()) != set(named_args.keys()):
                return False

            f_types, c_types = [], []

            for k, v in named_args.items():
                f_types.append(func_params[k])
                c_types.append(v)
        else:
            f_types = [self.map_type(x.ttype) for x in ttype.input_params]
            c_types = [self.get_expr_type(a) for a in expr.args]

        return soltypes.Type.are_matching_types(f_types, c_types)

    def get_function_expr_type(self, expr: solnodes1.CallFunction, allow_multiple=False, return_target_symbol=False):
        callee = expr.callee
        if isinstance(callee, soltypes.Type):
            if callee.is_address():
                # special case where address(uint160) maps to address payable:
                # see https://docs.soliditylang.org/en/develop/050-breaking-changes.html
                self.error_handler.error(f'Args={expr.args}', len(expr.args) == 1)
                arg_type = self.get_expr_type(expr.args[0])

                if arg_type.is_int() and not arg_type.is_signed and arg_type.size == 160:
                    return soltypes.AddressType(is_payable=True)

            # e.g. int(...), string(...), address(...) => cast expr
            return self.map_type(callee)
        elif isinstance(callee, solnodes1.Ident) and callee.text == 'address':
            return soltypes.AddressType(is_payable=False)

        callable_ttypes = self.get_expr_type(callee, allow_multiple=True, function_callee=True)

        if not isinstance(callable_ttypes, list):
            callable_ttypes = [callable_ttypes]

        def is_cast_call(t):
            return isinstance(t, soltypes.Type) and not t.is_function() and not t.is_mapping()

        # de-deplicate the callables. This is because we don't have 'base' information for these types like we do
        # when we refine function calls in the builder. The get_expr_type call can return functions that are overriden
        # giving us multiples of the same types, e.g. B extends A, B.f overrides A.f, get_expr_type returns 2x the
        # return type of f.
        # not order preserving though
        callable_ttypes = list(set(callable_ttypes))

        type_calls = [is_cast_call(ft) for ft in callable_ttypes]

        self.error_handler.error(f'Type calls must be any or all: {type_calls}', TypeHelper.any_or_all(type_calls))

        if any(type_calls):
            self.error_handler.error(f'Cast takes 1 argument: len={len(callable_ttypes)}', len(callable_ttypes) == 1)

            tc = callable_ttypes[0]
            # constructor call/new type
            if tc.is_builtin():
                # e.g. new string(xxx)
                return tc
            else:
                # e.g. new MyX(), or MyX(val)
                # TODO: check if we should return the constructor function type here instead
                return tc

        callable_calls = [ft.is_function() or ft.is_mapping() for ft in callable_ttypes]
        self.error_handler.assert_error(f'Non cast call must be callables: {callable_calls}', all(callable_calls))

        self.error_handler.assert_error('Not allowed to mix positional and named args', self.any_or_all([isinstance(a, solnodes1.NamedArg) for a in expr.args]))

        has_named_args = len(expr.args) > 0 and isinstance(expr.args[0], solnodes1.NamedArg)

        if not has_named_args:
            # FIXME: bit of a hack, when the deduplication happens it ignores parameter names and only considers types
            #  so if no named args are provided and we are doing positional type checks only, then we can potentially
            #  fix duplicate callees early here
            callable_ttypes = self.deduplicate_func_types(callable_ttypes)

        candidates = []
        for ttype in callable_ttypes:
            if ttype.is_function():
                ttype: soltypes.FunctionType
                # None is a sentinel, do NOT do 'if ft.input_params:'
                if ttype.input_params is not None:
                    # match input types
                    if has_named_args:
                        if self.check_func_type_inputs(ttype, expr):
                            candidates.append(ttype.outputs)
                    else:
                        arg_types = [self.get_expr_type(arg) for arg in expr.args]
                        if len(ttype.input_params) == len(arg_types):
                            if all([param.ttype.can_implicitly_cast_from(actual) for param, actual in zip(ttype.input_params, arg_types)]):
                                candidates.append(ttype.outputs)
                else:
                    # input types == None => polymorphic builtin function. This isn't the same as a no arg function,
                    # where input types == []
                    candidates.append(ttype.outputs)
                    continue
            elif ttype.is_mapping():
                arg_types = [self.get_expr_type(arg) for arg in expr.args]
                ttype: soltypes.MappingType
                flattened_types = ttype.flatten()

                self.error_handler.assert_error(f'{flattened_types} vs {arg_types}',
                                           len(flattened_types) == len(arg_types) + 1)

                input_types = flattened_types[:-1]
                # match input types
                if all([targ.can_implicitly_cast_from(actual) for targ, actual in zip(input_types, arg_types)]):
                    candidates.append([ttype.dst])
            else:
                self.error_handler.todo(ttype)

        if len(candidates) != 1:
            callable_ttypes = self.get_expr_type(callee, allow_multiple=True, function_callee=True)
            self.error_handler.error(f'Can\'t resolve call')

        output_types = candidates[0]

        # Special case: check if abi.decode is called as its output types depend on its input types
        #  i.e. output_types is set to None in the symbol table as it's inputs and outputs are completely
        #       generic
        if isinstance(callee, solnodes1.GetMember) and isinstance(callee.obj_base, solnodes1.Ident):
            if callee.obj_base.text == 'abi' and callee.name.text == 'decode':
                self.error_handler.assert_error(f'Polymorphic abi.decode => {output_types}', output_types is None)
                # drop the first argument type so output types are t1, t2...
                #  abi.decode(bytes memory encodedData, (t1, t2...)) returns (t1, t2...)
                output_types = [self.get_expr_type(arg) for arg in expr.args][1:]

        if allow_multiple:
            return output_types
        else:
            if len(output_types) == 1:
                return output_types[0]
            else:
                return soltypes.TupleType(output_types)

    def map_as_type_arg(self, arg):
        """
        This function tries to force the given expr argument into a type if it looks like a type

        The supplied grammar is ambiguous and sometimes parses types as expression e.g. byte[100] would end up as an
        array access instead of a fixed length byte array. I've only really seen this happen for arguments of function
        calls, i.e. in abi.decode hence the name of the function. Should probably see if this happens in other places in
        the grammar too...
        """

        # sometimes stuff like uint[] gets parsed as GetArrayValue(array_base=IntType(...), index=None))
        if isinstance(arg, soltypes.Type):
            # "base case", it's a Type already so it's definitely a type :)
            return self.map_type(arg)
        elif isinstance(arg, solnodes1.Ident):
            # TODO: this can be improved: better lookup functions now exist compared to find
            # lookup the ident in the current scope and if it's a top level type, it's a type
            symbols = arg.scope.find(arg.text)
            if len(symbols) == 1:
                sym = symbols[0]
                if hasattr(sym, 'base_scope'):
                    # this is hit when the found symbol is a proxy scope
                    sym = sym.base_scope
                resolved_sym = sym.res_syms_single()
                if self.builder.is_top_level(resolved_sym.value):
                    return self.symbol_to_ast2_type(resolved_sym)
        elif isinstance(arg, solnodes1.GetMember):
            # Happens with qualified types, e.g. MyC.MyB
            # FIXME: want to get rid of the refine_expr call here and use a pure AST1 solution as refine_expr has side
            # effects on the arg
            possible_type = self.builder.refine_expr(arg)
            if isinstance(possible_type, soltypes.Type):
                return possible_type
        elif isinstance(arg, solnodes1.GetArrayValue):
            # try and coerce the base node into a type, this handles cases where the array_base
            # is an Ident or a Type, etc
            base_ttype = None

            possible_base_ttype = self.builder.refine_expr(arg.array_base, allow_type=True)
            if possible_base_ttype and isinstance(possible_base_ttype, soltypes.Type):
                base_ttype = possible_base_ttype
            else:
                return arg

            if arg.index:
                # e.g. bytes32[100]
                if isinstance(arg.index, solnodes1.Literal):
                    return soltypes.FixedLengthArrayType(base_ttype, int(arg.index.value))
            else:
                # e.g. MyType[]
                return soltypes.ArrayType(base_ttype)
        # base case
        return arg

    def param_types(self, ps):
        """ Returns the types of the given parameters """
        if not ps:
            return []
        return [self.map_type(p.var_type) for p in ps]

    def map_input_params(self, func: ModifierDefinition | FunctionDefinition | ErrorDefinition | EventDefinition) -> list[soltypes.FunctionParameter]:
        # mapping fp to fp just ensures that any AST1 child nodes are translated into AST2 nodes
        ps = func.parameters
        return [soltypes.FunctionParameter(self.builder.ident(p.var_name), self.map_type(p.var_type)) for p in ps] if ps else []

    def symbol_to_ast2_type(self, symbol, function_callee=False) -> solnodes2.Types:
        """
        Computes the AST2 type of the given symtab Symbol
        """

        if isinstance(symbol, symtab.FileScope):
            # apparently you can prefix with a file name now? e.g. MyErrors.ErrorX() where MyErrors is the imported
            # 'MyErrors.sol' file and'ErrorX' is a free function/error in that file
            return self.get_contract_type(symbol)
        elif isinstance(symbol, symtab.UsingFunctionSymbol):
            # need to do this check against the unresolved symbol as calling res_syms_single below on a
            # UsingFunctionSymbol gives the base ModFunErrEvt symbol, but we need to differentiate whether this value
            # came from a using statement

            # cast for type checker, could be further refined as just FunctionDefinition
            value: ModifierDefinition | FunctionDefinition | ErrorDefinition | EventDefinition = cast(solnodes1.ModFunErrEvt, symbol.value)
            # X.abc(1) === abc(X,1), remove the type of X from the start of the input types
            return soltypes.FunctionType(self.map_input_params(symbol.value)[1:],
                                         self.param_types(value.returns),
                                         self.builder.modifiers(value))

        # can resolve now
        symbol = symbol.res_syms_single()

        if isinstance(symbol, symtab.BuiltinObject):
            if v := symbol.value:
                # if this builtin object was created to scope a type, e.g. a byte[] or int256, etc, just
                # resolve to the type directly instead of shadowing it as a builtin type
                self.error_handler.assert_error(f'Builtin symbol must be type: {type(v)}',
                                                isinstance(v, soltypes.Type))
                return self.map_type(v)
            else:
                return soltypes.BuiltinType(symbol.name)
        elif isinstance(symbol, symtab.BuiltinFunction):
            # These input type checks need to be 'is not None' instead of just if symbol.input_types as some of these
            # might be empty lists (meaning no inputs or outputs in the function) whereas 'None' indicates that the
            # function accepts any parameter types there (fully polymorphic).
            #  At the moment 'None' output_types is only used for abi.decode
            input_types = [soltypes.FunctionParameter(self.builder.no_ident(), self.map_type(t)) for t in symbol.input_types] if symbol.input_types is not None else None
            output_types = [self.map_type(ttype) for ttype in symbol.output_types] if symbol.output_types is not None else None
            return soltypes.FunctionType(input_types, output_types, [])
        elif isinstance(symbol, symtab.BuiltinValue):
            ttype = symbol.ttype
            return self.map_type(ttype)

        value = symbol.value

        if self.builder.is_top_level(value):
            # Contract, interface, struct, library
            return self.get_contract_type(symbol)
        elif isinstance(value, (solnodes1.Parameter, solnodes1.Var)):
            return self.map_type(value.var_type)
        elif isinstance(value, solnodes1.FunctionDefinition):
            return soltypes.FunctionType(self.map_input_params(value), self.param_types(value.returns), self.builder.modifiers(value))
        elif isinstance(value, solnodes1.ErrorDefinition):
            if function_callee:
                # error initialised like callable eg MyError(1,2), I believe this is only passed to require() in 0.8.26
                return solnodes2.UserDefinedErrorType(nodebase.Ref(value))
            else:
                # AFAIK this is only used for MyError.selector
                return soltypes.FunctionType(self.map_input_params(value), [], [])
        elif isinstance(value, solnodes1.EventDefinition):
            # This can happen with old solidity contracts before the 'emit' keyword was created. In this case, an
            # event is triggered by a function call e.g. MyEvent() instead of emit MyEvent()
            return soltypes.FunctionType(self.map_input_params(value), [], [])
        elif isinstance(value, (solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration)):
            # Mappings are stored as fields but have mapping types
            field_type = self.map_type(value.var_type)
            if function_callee:
                # This is the case where a public state var is loaded via its autogenerated getter
                modifiers = [solnodes2.VisibilityModifier(solnodes1.VisibilityModifierKind.EXTERNAL),
                             solnodes2.MutabilityModifier(solnodes1.MutabilityModifierKind.VIEW)]
                if field_type.is_mapping():
                    flattened_types = field_type.flatten()
                    return soltypes.FunctionType([soltypes.FunctionParameter(self.builder.no_ident(), t) for t in flattened_types[:-1]], flattened_types[-1:], modifiers)
                elif field_type.is_array() and not field_type.is_byte_array_underlying():
                    return soltypes.FunctionType([soltypes.FunctionParameter(self.builder.no_ident(), soltypes.UIntType())], [field_type.base_type], modifiers)
                else:
                    return soltypes.FunctionType([], [field_type], modifiers)
            return field_type
        elif isinstance(value, solnodes1.StructMember):
            return self.map_type(value.member_type)
        elif isinstance(value, solnodes1.Ident):
            if isinstance(value.parent, solnodes1.EnumDefinition):
                # this is an enum member, the type is the enum itself
                self.error_handler.assert_error(f'Enum parent scope invalid: {type(value.scope)}',
                                           isinstance(value.scope, symtab.EnumScope))
                return self.symbol_to_ast2_type(value.scope)
        elif isinstance(value, solnodes1.ModifierDefinition):
            return soltypes.FunctionType(self.map_input_params(value), [], self.builder.modifiers(value))
        assert False, f'{type(value)}'

    def scopes_for_type(self, node: solnodes1.AST1Node, ttype: solnodes2.Types, use_encoded_type_key=True) -> List[symtab.Scope]:
        if isinstance(ttype, solnodes2.SuperType):
            return c3_linearise(self.builder.get_declaring_contract_scope(node))
        elif isinstance(ttype, solnodes2.ResolvedUserType):
            if isinstance(ttype.value.x, solnodes2.FileDefinition):
                # don't find another scope other than the filescope for this filedefinition, it can't be put in a using directive like
                # normal user types
                scope = ttype.value.x.scope
                assert isinstance(scope, symtab.FileScope)
                return [scope]

            try:
                user_scopes = node.scope.find_user_type_scope(ttype.value.x.name.text)
            except symtab.TypeNotFound:
                # Weird situation where an object of type T is used in a contract during an intermediate computation but
                # T isn't imported. E.g. (x.y).z = f() where x.y is of type T and f returns an object of type S but
                # T isn't imported in the contract. This is the AddressSlot case in ERC1967Upgrade
                return [ttype.scope]

            filtered_scopes = []
            for s in user_scopes:
                if s is not None and s.value != ttype.scope.value:
                    if s.res_syms_single() != ttype.scope.res_syms_single():
                        logging.getLogger('AST2').warning(f'Type {ttype.value.x.descriptor()} is used at {node.source_location()} but looking up {ttype.value.x.name.text} in this scope results in a different type!')
                        filtered_scopes.append(ttype.scope)
                        continue
                filtered_scopes.append(s)

            # "Prior to version 0.5.0, Solidity allowed address members to be accessed by a contract instance, for
            # example this.balance. This is now forbidden and an explicit conversion to address must be done:
            # address(this).balance"
            # TODO: add versioncheck
            # if ttype.value.x.is_contract():
            #     scopes.append(scope.find_type(solnodes1.AddressType(False)))
            return filtered_scopes
        elif isinstance(ttype, soltypes.BuiltinType):
            scope = node.scope.find_single(ttype.name)
        elif isinstance(ttype, soltypes.MetaTypeType):
            base_type = ttype.ttype
            is_interface = base_type.is_user_type() and cast(solnodes2.ResolvedUserType, base_type).value.x.is_interface()
            is_enum = base_type.is_user_type() and cast(solnodes2.ResolvedUserType, base_type).value.x.is_enum()
            scope = node.scope.find_metatype(ttype.ttype, is_interface, is_enum)
        else:
            if use_encoded_type_key:
                # encoded as <type:X>
                scopes = []
                if ttype.is_address() and ttype.is_payable:
                    # address payable is essentially a sub type of address
                    scopes.extend(node.scope.find_type(soltypes.AddressType(False)))
                    scopes.extend(node.scope.find_type(soltypes.AddressType(True)))
                else:
                    scopes.extend(node.scope.find_type(ttype))
                return scopes
            else:
                # used for 'bytes' and 'string' .concat. They are builtin scopes with builtin calls
                scope = node.scope.find_single(str(ttype))

        assert isinstance(scope, symtab.Scope), f'{type(scope)}'
        return [scope]

    def map_function_param(self, param: soltypes.FunctionParameter) -> soltypes.FunctionParameter:
        return soltypes.FunctionParameter(
            self.builder.ident(param.name),
            self.map_type(param.ttype)
        )

    def map_type(self, ttype: soltypes.Type) -> solnodes2.Types:
        if isinstance(ttype, solnodes2.Types) and not isinstance(ttype, solnodes1.Types):
            # AST2 specific type, doesn't need checking below
            # TODO: does it need copying though?
            return cast(solnodes2.Types, ttype)

        if isinstance(ttype, soltypes.ErrorType):
            return soltypes.ErrorType()
        elif isinstance(ttype, soltypes.UserType):
            return self.get_user_type(ttype)
        # string and bytes have to go before the base Array cases below
        elif isinstance(ttype, soltypes.BytesType):
            return soltypes.BytesType()
        elif isinstance(ttype, soltypes.StringType):
            return soltypes.StringType()
        elif isinstance(ttype, soltypes.VariableLengthArrayType):
            base_type = self.map_type(ttype.base_type)
            size_type = self.get_expr_type(ttype.size)
            # Fix for some weird grammar parsing issues where a fixed length array type is parsed as a variable length
            # array type with a literal passed as the size expr, so here we change it to a fixed one
            # Check for isinstance(ttype.size, solnodes1.Literal) as a compile time constant expr, e.g. Record[2**253]
            # is a fixed sized but FixedLengthArrayType needs an int not an expr that computes an int.
            if size_type.is_int() and size_type.is_literal_type() and isinstance(ttype.size, solnodes1.Literal):
                size = ttype.size.value
                assert isinstance(size, int)
                return soltypes.FixedLengthArrayType(base_type, size)
            else:
                return soltypes.VariableLengthArrayType(base_type, self.builder.refine_expr(ttype.size))
        elif isinstance(ttype, soltypes.FixedLengthArrayType):
            return soltypes.FixedLengthArrayType(self.map_type(ttype.base_type), ttype.size)
        elif isinstance(ttype, soltypes.ArrayType):
            return soltypes.ArrayType(self.map_type(ttype.base_type))
        elif isinstance(ttype, soltypes.AddressType):
            return soltypes.AddressType(ttype.is_payable)
        elif isinstance(ttype, soltypes.ByteType):
            return soltypes.ByteType()
        elif isinstance(ttype, soltypes.IntType):
            return soltypes.IntType(ttype.is_signed, ttype.size)
        elif isinstance(ttype, soltypes.BoolType):
            return soltypes.BoolType()
        elif isinstance(ttype, soltypes.MappingType):
            return soltypes.MappingType(self.map_type(ttype.src), self.map_type(ttype.dst),
                                        self.builder.ident(ttype.src_name), self.builder.ident(ttype.dst_name))
        elif isinstance(ttype, soltypes.FunctionType):
            # TODO: fix the cases for polymorphic types where inputs or outputs is set to None
            return soltypes.FunctionType([self.map_function_param(p) for p in ttype.input_params] if ttype.input_params is not None else None,
                                         [self.map_type(t) for t in ttype.outputs] if ttype.outputs is not None else None,
                                         self.builder.modifiers(ttype))

        self.error_handler.todo(ttype)

    def get_contract_type(self, user_type_symbol: symtab.Symbol) -> solnodes2.ResolvedUserType:
        assert isinstance(user_type_symbol, symtab.Scope)
        if isinstance(user_type_symbol, symtab.FileScope):
            contract = self.builder.get_synthetic_owner(user_type_symbol.source_unit_name, user_type_symbol)
        else:
            contract = self.builder.load_if_required(user_type_symbol)
        ttype = solnodes2.ResolvedUserType(nodebase.Ref(contract))
        ttype.scope = user_type_symbol
        return ttype

    def _symtab_top_level_predicate(self, base_scope):
        # This is needed for old contracts before the 'constructor' keyword was used so that when we look up 'X'
        # we don't hit 'function X' i.e. the constructor in the current contract, instead we only look for a user type

        # filescope can happen e.g. import "..." as X, then for the type identifier path: X.Y, X is a FileScope
        def unit_scope_of(s):
            return s.find_first_ancestor_of((symtab.FileScope, symtab.ContractOrInterfaceScope, symtab.EnumScope, symtab.LibraryScope, symtab.UserDefinedValueTypeScope))

        base_unit_scope = unit_scope_of(base_scope)
        def accept(sym: symtab.Symbol):
            resolved_sym = sym.res_syms_single()
            if isinstance(resolved_sym, symtab.FileScope):
                return True
            if isinstance(sym, symtab.ProxyScope) and isinstance(sym.created_by.value, solnodes1.UsingDirective):
                return unit_scope_of(sym) == base_unit_scope # dont inherit scopes created by using directives
            return self.builder.is_top_level(resolved_sym.value)

        return accept

    def get_user_type(self, ttype: soltypes.UserType):
        """Maps an AST1 UserType to AST2 ResolvedUserType in the scope of the AST1 node that references the type"""
        s = ttype.scope.find_user_type_scope(ttype.name.text, find_base_symbol=True)
        if not s:
            raise ValueError(f"Can't resolve {ttype}")
        return self.get_contract_type(s)


class Builder:

    @dataclass
    class State:
        current_node: solnodes1.AST1Node

    def __init__(self):
        error_handler = ErrorHandler(create_state=Builder.State)

        self.refine_stmt = error_handler.with_error_context(self.refine_stmt)
        self.refine_expr = error_handler.with_error_context(self.refine_expr)
        
        self.type_helper = TypeHelper(self, error_handler)

        self.error_handler = error_handler

        self.synthetic_toplevels: Dict[str, solnodes2.FileDefinition] = {}
        self.normal_toplevels = []
        self.to_refine: Deque[solnodes1.SourceUnit | solnodes2.FileDefinition] = deque()

        self.temp_var_counter = 0

    def link_with_ast1(func):
        @functools.wraps(func)
        def _wrapped(self: 'Builder', ast1_node, *args, **kwargs):
            result = func(self, ast1_node, *args, **kwargs)

            if not result:
                return result

            if isinstance(result, list):
                code_nodes = result
            elif result:
                code_nodes = [result]

            for n in code_nodes:
                n.id_location = ast1_node.id_location
                n.start_location = ast1_node.start_location
                n.end_location = ast1_node.end_location

            return result
        return _wrapped

    def get_top_level_units(self) -> List[solnodes2.TopLevelUnit]:
        return list(self.synthetic_toplevels.values()) + self.normal_toplevels

    def enqueue_files(self, files: List[symtab.FileScope]):
        for file_scope in files:
            for ss in file_scope.symbols.values():
                for s in ss:
                    if s.parent_scope != file_scope:
                        # don't process imported symbols under this file scope
                        continue
                    n = s.value
                    if self.should_create_skeleton(n) and not n.ast2_node:
                        self.define_skeleton(n, file_scope.source_unit_name)

    def process_all(self):
        while self.to_refine:
            n = self.to_refine.popleft()

            sun = n.scope.find_first_ancestor_of(symtab.FileScope).source_unit_name
            logging.getLogger('AST2').debug(f'Processing {type(n).__name__}({n.name}) in {sun}')

            self.refine_unit_or_part(n)

    def load_non_top_level_if_required(self, ast1_node: solnodes1.SourceUnit | solnodes1.ContractPart) -> solnodes2.ContractPart:
        """
        Ensures the given AST1 non top level node has been skeletoned as an AST2 node. This will
        in turn skeleton any parent nodes that need to be made.

        For top level nodes use the load_if_required function instead
        """

        if ast1_node.ast2_node:
            return ast1_node.ast2_node

        if isinstance(ast1_node, (solnodes1.FunctionDefinition, solnodes1.ModifierDefinition, solnodes1.EventDefinition,
                                  solnodes1.ErrorDefinition, solnodes1.StateVariableDeclaration,
                                  solnodes1.ConstantVariableDeclaration)):
            ast1_scope = ast1_node.scope
            parent_scope = ast1_scope.find_first_ancestor(self.type_helper._symtab_top_level_predicate(ast1_scope))

            if isinstance(parent_scope, symtab.FileScope):
                sun = parent_scope.source_unit_name
            else:
                sun = None

            # need to pass in the SUN for FileScopes here so this ast1_node gets added to the FileDefinition
            return self.define_skeleton(ast1_node, sun)
        else:
            self.error_handler.error(f'Cannot load {type(ast1_node)}')

    def load_if_required(self, user_type_symbol: symtab.Symbol) -> solnodes2.TopLevelUnit:
        user_type_symbol = user_type_symbol.res_syms_single()

        ast1_node: solnodes1.SourceUnit = user_type_symbol.value

        if isinstance(ast1_node, (solnodes1.ContractDefinition, solnodes1.InterfaceDefinition,
                                  solnodes1.StructDefinition, solnodes1.LibraryDefinition, solnodes1.EnumDefinition,
                                  solnodes1.UserValueType)):

            if ast1_node.ast2_node:
                ast2_node = ast1_node.ast2_node
            else:
                # this starts at the parent_scope and tries to match then recurses up
                parent_scope = user_type_symbol.parent_scope.find_first_ancestor(predicate=symtab.ACCEPT_TOP_LEVEL_SCOPE)

                if isinstance(parent_scope, symtab.FileScope):
                    source_unit_name = parent_scope.source_unit_name
                    logging.getLogger('AST2').debug(f'Defining top level unit {source_unit_name}::{ast1_node.name.text}')
                    # force skeleton of the whole file, filescope.value is the ast1 parts
                    for part in parent_scope.value:
                        # None = EOF
                        if part is not None and self.should_create_skeleton(part) and not part.ast2_node:
                            # pass the source unit name here, this lets define_skeleton trigger the 'free floating'
                            # check if the part is not a top level node and adds the part to the FileDefinition.
                            # if it is a top level node, then it will define it as a top level node in AST2 and wont
                            # add it to the FileDefinition
                            self.define_skeleton(part, source_unit_name)
                    ast2_node = ast1_node.ast2_node
                else:
                    # load the parent which will in turn define skeletons for its children, including the current
                    # ast1_node
                    parent_was_loaded = parent_scope.value.ast2_node is not None
                    logging.getLogger('AST2').debug(f'Loading parent of {ast1_node.name.text} ({parent_scope.aliases[0]})')
                    parent_type = self.load_if_required(parent_scope)
                    source_unit_name = f'{parent_type.source_unit_name}${parent_type.name.text}'

                    if parent_was_loaded:
                        # if the parent was previously loaded but the current ast node wasn't, then load_if_required
                        # won't attempt to define skeletons for its children(including ast1_node) so we have to manually
                        # do it here.
                        # This case is a bit weird and happens with circular references, i.e. MyLib defines MyEnum and
                        # MyLib defines a function f that takes MyEnum as a parameter. Loading MyEnum requires MyLib to
                        # be loaded but loading MyLib requires MyEnum to be loaded for the parameter type in f.
                        logging.getLogger('AST2').debug(
                            f'Defining circular ref type: {ast1_node.name.text} from {source_unit_name}')
                        ast2_node = self.define_skeleton(ast1_node, source_unit_name)
                    else:
                        # Parent wasn't previously defined and so it was loaded, in turn creating skeletons for its
                        # children and therefore ast2_node is set
                        ast2_node = ast1_node.ast2_node
            return ast2_node
        else:
            raise ValueError(f"Invalid type resolve: {type(ast1_node)}")

    @link_with_ast1
    def refine_stmt(self, node: solnodes1.Stmt, allow_none=False):
        if node is None:
            assert allow_none
            return None

        if isinstance(node, solnodes1.VarDecl):
            if len(node.variables) > 1 or node.is_lhs_tuple:
                return solnodes2.TupleVarDecl([self.var(x) for x in node.variables],
                                              self.refine_expr(node.value, is_assign_rhs=True, allow_tuple_exprs=True))
            else:
                return solnodes2.VarDecl(self.var(node.variables[0]),
                                         self.refine_expr(node.value, is_assign_rhs=True) if node.value else None)
        elif isinstance(node, solnodes1.ExprStmt):
            def map_node(x):
                if isinstance(x, solnodes2.Expr):
                    return solnodes2.ExprStmt(x)
                else:
                    assert isinstance(x, solnodes2.Stmt)
                    return x
            nodes = self.refine_expr(node.expr, allow_multiple_exprs=True, allow_stmt=True, allow_tuple_exprs=True,
                                     allow_event=True)
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
            event_call = self.refine_call_function(node.call, allow_event=True)
            assert isinstance(event_call, solnodes2.EmitEvent)
            return event_call
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
            err_create = self.refine_call_function(node.call, allow_error=True)
            assert isinstance(err_create, solnodes2.CreateError)
            return solnodes2.RevertWithError(err_create)
        self.error_handler.todo(node)

    def get_declaring_contract_scope(self, node: solnodes1.AST1Node) -> Union[
        symtab.ContractOrInterfaceScope, symtab.LibraryScope, symtab.EnumScope, symtab.StructScope, symtab.EnumScope, symtab.FileScope]:
        return self.get_declaring_contract_scope_in_scope(node.scope)

    def get_declaring_contract_scope_in_scope(self, scope: symtab.Symbol) -> Union[
        symtab.ContractOrInterfaceScope, symtab.LibraryScope, symtab.EnumScope, symtab.StructScope, symtab.EnumScope, symtab.FileScope]:
        return scope.find_first_ancestor_of((symtab.ContractOrInterfaceScope, symtab.LibraryScope,
                                             symtab.EnumScope, symtab.StructScope, symtab.EnumScope,
                                             # required for ownerless definitions
                                             symtab.FileScope))

    def get_self_object(self, node: Union[solnodes1.Stmt, solnodes1.Expr]):
        ast1_current_contract = self.get_declaring_contract_scope(node)
        contract_type: solnodes2.ResolvedUserType = self.type_helper.get_contract_type(ast1_current_contract)
        return solnodes2.SelfObject(contract_type.value)

    def get_super_object(self, node: Union[solnodes1.Stmt, solnodes1.Expr]):
        ast1_current_contract = self.get_declaring_contract_scope(node)
        contract_type: solnodes2.ResolvedUserType = self.type_helper.get_contract_type(ast1_current_contract)
        return solnodes2.SuperObject(solnodes2.SuperType(contract_type.value))  # assign the Ref[TLU] as the Ref in the SuperType

    @dataclass
    class FunctionCallee:
        base: Optional[solnodes2.Expr | symtab.Symbol]
        symbols: List[symtab.Symbol]

    @dataclass
    class PartialFunctionCallee(FunctionCallee):
        call_options: Dict[str, solnodes2.Expr]

    def refine_call_function(self, expr, allow_error=False, allow_stmt=False, allow_event=False):
        def create_new_args():
            results = []
            for ast1_arg in expr.args:
                # technically we should check hasattr(expr.callee, 'name') and str(expr.callee.name) == 'require'
                # but don't want to hardcode it
                ast2_arg = self.refine_expr(ast1_arg, is_argument=True, allow_error=True)
                if isinstance(ast2_arg, list):
                    # this currently only happens for tuples of exprs (not tuples of types) in the 2nd arg of
                    # abi.encodeCall calls
                    results.extend(ast2_arg)
                else:
                    results.append(ast2_arg)
            return results

        def create_special_call_options():
            return [solnodes2.NamedArgument(self.ident(arg.name), self.refine_expr(arg.value)) for arg in expr.special_call_options]

        callee = expr.callee

        if isinstance(callee, solnodes1.New):
            # special case since new can only be in the form of new X()
            base_type = self.type_helper.map_type(callee.type_name)
            if base_type.is_array():
                # e.g. new X[5]
                self.error_handler.assert_error('New array creation must take a single integer length as parameter',
                                   len(expr.args) == 1 and self.type_helper.get_expr_type(expr.args[0]).is_int())
                return solnodes2.CreateMemoryArray(base_type, self.refine_expr(expr.args[0]))
            elif base_type.is_user_type():
                # e.g. new X(...)
                # TODO: check if option args are allowed here
                return solnodes2.CreateAndDeployContract(base_type, create_special_call_options(), create_new_args())

        # possible_base could be a Type or an expr:
        #  expr case is straight forward, i.e. myVar.xyz(), 'myVar' is the base
        #  or myVar.myField.xyz(), 'myVar.myField' is the base
        # type case is for expressions like MyLib.xyz() or MyX.MyY.xyz() where MyX.MyY is just a qualified name
        # we can't/don't handle myVar.MyX.xyz() where myVar is an expr and MyX is a type
        #
        # Symbols are matches by name only
        callees: Union[List[Builder.FunctionCallee], solnodes2.Expr] = self.refine_expr(callee, is_function_callee=True)
        special_call_options = create_special_call_options()

        # Function pointer call, e.g. <myExpr>(...);
        if isinstance(callees, solnodes2.Expr):
            new_args = create_new_args()
            return solnodes2.FunctionPointerCall(special_call_options, new_args, callees)

        if any([isinstance(c, Builder.PartialFunctionCallee) for c in callees]):
            # Partially built callee, i.e. the full expr may be x(y=5, z=6), a partial callee might only be x(y=5, z=?)
            # This is because some exprs are built top down(partial) instead of bottom up. The top down ones are
            # difficult as we have to backtrack and fill in details afterwards

            def split_keys(c: Builder.PartialFunctionCallee):
                missing, filled = set(), set()
                for key in c.call_options.keys():
                    if c.call_options[key] is None:
                        missing.add(key)
                    else:
                        filled.add(key)
                return missing, filled

            possible_unmatched_keys, fully_matched_keys = split_keys(callees[0])

            if possible_unmatched_keys:
                # Atm only allow f.gas(x) and f.value(x) i.e. 1 arg, this can be improved by checking against the symtab
                # entries for gas and value
                self.error_handler.assert_error(f'Expected one arg, got {expr.args}', len(expr.args) == 1)

            for c in callees:
                c_missing, c_matched = split_keys(c)
                if len(c_missing) > 0:
                    self.error_handler.assert_error(f'Too many options: {c_missing} vs {possible_unmatched_keys}', c_missing == possible_unmatched_keys)
                    # parse x in f.gas(x) and add it as a call option
                    c.call_options[list(c_missing)[0]] = self.refine_expr(expr.args[0])
                if len(c_matched) > 0:
                    self.error_handler.assert_error(f'Too many options: {c_matched} vs {fully_matched_keys}', c_matched == fully_matched_keys)

            if len(possible_unmatched_keys) > 0:
                return callees
            else:
                # if there are no unmatched keys, i.e. this partial function application has been fully filled out,
                # continue with function call node determination as normal as PartialFunctionCallee is a FunctionCallee
                # arbitrarily pick the first one
                special_call_options.extend([solnodes2.NamedArgument(solnodes2.Ident(name), value) for name, value in callees[0].call_options.items()])

        arg_types = [self.type_helper.get_expr_type(arg) for arg in expr.args]

        def is_type_call(s):
            value = s.res_syms_single().value
            # type calls when X in X(a) is a type, e.g. MyContract(_addr), bytes(xx), etc, which are casts
            return isinstance(value, soltypes.Type) or self.is_top_level(value)

        type_calls = [is_type_call(symbol) for c in callees for symbol in c.symbols]
        # can't have ambiguity for casts, so if one of the matches is a cast then they must all be (and there must only
        # be one, which is checked later) and vice versa
        assert TypeHelper.any_or_all(type_calls)

        if any(type_calls):
            # all have to be the same type

            self.error_handler.assert_error(f'Only 1 type bucket match allowed, got: {callees}',
                               len(callees) == 1)

            res_syms = set([rs for s in callees[0].symbols for rs in s.res_syms()])

            self.error_handler.assert_error(f'Bucket matches to multiple types: {res_syms}', len(res_syms) == 1)

            ttype = self.type_helper.symbol_to_ast2_type(callees[0].symbols[0])
            if ttype.is_user_type() and cast(solnodes2.ResolvedUserType, ttype).value.x.is_struct():
                # struct init
                new_args = create_new_args()
                self.error_handler.error(f'Call options not allowed during struct initialiser: {special_call_options}',
                                   len(special_call_options) == 0)
                return solnodes2.CreateStruct(ttype, new_args)
            else:
                # casts must look like T(x), also can't have a base as the base is the resolved callee
                self.error_handler.error(f'Can only cast single arg: {expr.args}',
                                   len(expr.args) == 1)
                self.error_handler.error(f'Call options not allowed during cast: {special_call_options}',
                                   len(special_call_options) == 0)
                self.error_handler.assert_error('Cast must not have base', not callees[0].base)

                # TODO: put version check on this
                # special case where address(uint160) maps to address payable:
                # see https://docs.soliditylang.org/en/develop/050-breaking-changes.html
                arg_type = self.type_helper.get_expr_type(expr.args[0])

                if ttype.is_address() and arg_type.is_int() and not arg_type.is_signed and arg_type.size == 160:
                    ttype = soltypes.AddressType(is_payable=True)
                return solnodes2.Cast(ttype, self.refine_expr(expr.args[0]))

        # match function call candidates via parameters
        # (matched symbol, symbol type, is_synthetic)
        candidates: list[tuple[symtab.Symbol | solnodes2.Expr, symtab.Symbol, soltypes.Type, bool]] = []
        for c in callees:
            # Match the callees in the current bucket
            bucket_candidates: list[tuple[symtab.Symbol, solnodes2.Types, bool]] = []

            for s in c.symbols:
                # DONT pass function_callee=True here, this will give us the real type of the symbol for statevars
                # i.e. we'll get uint instead of () -> uint which we need to set is_synthetic
                t: soltypes.Type = self.type_helper.symbol_to_ast2_type(s)
                is_synthetic = False

                if t.is_function():
                    t: soltypes.FunctionType
                    # None is a sentinel, do NOT do 'if ft.input_params:'
                    if t.input_params is None:
                        # input types == None => polymorphic builtin function. This isn't the same as a no arg function,
                        # where input types == []
                        bucket_candidates.append((s, t, is_synthetic))
                        continue
                    else:
                        # match input types
                        if self.type_helper.check_func_type_inputs(t, expr):
                            bucket_candidates.append((s, t, is_synthetic))
                        continue
                elif t.is_mapping():
                    t: soltypes.MappingType
                    # MappingType, these can look like function calls but are mapping loads. A mapping type can be
                    # nested, like myMapping :: (x => (y => z))
                    flattened_types = t.flatten()
                    # the last element in the flattened list is the final return type and isn't an arg, so don't include
                    # that
                    self.error_handler.error(f'Mapping load must provide all inputs {len(flattened_types)}/{len(arg_types) + 1}',
                                len(flattened_types) == len(arg_types) + 1)
                    input_types = flattened_types[:-1]
                elif t.is_array() and not t.is_byte_array_underlying():
                    input_types = [soltypes.UIntType()]
                else:
                    self.error_handler.assert_error(f'Unhandled call to {type(s.value)}', isinstance(s.value, (
                        solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration)))
                    # self.error_handler.error(f'Getter call to {s} must public',
                    #             solnodes1.VisibilityModifierKind.PUBLIC in [m.kind for m in s.value.modifiers])
                    # synthetic getter method for a public field, e.g. a public field 'data', expr is data()
                    input_types = []
                    is_synthetic = True

                # check for each parameter of the target, check if the arg can be passed to it
                if len(input_types) == len(arg_types):
                    if all([
                        targ.can_implicitly_cast_from(actual)
                        for targ, actual in zip(input_types, arg_types)]):
                        bucket_candidates.append((s, t, is_synthetic))

            if len(bucket_candidates) > 1:
                # If we have multiple matches, check that they are part of an override chain and pick the first one
                # i.e. we might have
                # B is A { f() } A { f() }
                # So we resolve to B.f
                are_sub_contracts = self.is_declaration_chain([candidate[0] for candidate in bucket_candidates])
                if are_sub_contracts:
                    aliases = ', '.join([self.get_declaring_contract_scope_in_scope(c[0]).aliases[0] for c in bucket_candidates])
                    logging.getLogger('AST2').debug(f'Base chain: {aliases} @ {expr.id_location}')
                    candidates.append((c.base, *bucket_candidates[0]))  # type: ignore
                else:
                    return self.error_handler.assert_error(f'Resolved to too many different bases: {bucket_candidates}, args={arg_types}')
            elif len(bucket_candidates) == 1:
                candidates.append((c.base, *bucket_candidates[0]))  # type: ignore

        if len(candidates) == 0:
            # no resolved callees
            return self.error_handler.error(f"Can't resolve call: {expr}, candidates={candidates}, args={arg_types}")
        elif len(candidates) > 1:
            logging.getLogger('AST2').debug(f'Matched multiple buckets for: {expr}, choosing first from {candidates}')

        # Choose the candidate from the first bucket
        # FunctionCallee, (input: types, output: types)
        # TODO: get named args for PartialFunctionCallee
        possible_base, unresolved_sym, ftype, is_synthetic = candidates[0]

        sym = unresolved_sym.res_syms_single()

        if ftype.is_mapping():
            # for mapping types, the dst is the output type
            out_type = cast(soltypes.MappingType, ftype).dst
        elif ftype.is_array() and not ftype.is_byte_array_underlying():
            out_type = cast(soltypes.ArrayType, ftype).base_type
        elif is_synthetic:
            # for synthetic candidate, the type itself is the output type
            out_type = ftype
        else:
            ftype: soltypes.FunctionType

            if ftype.outputs is None:
                # for FunctionTypes where output IS None, return type is polymorphic. So far it's only abi.decode
                if sym.aliases[0] == 'decode' and sym.parent_scope.aliases[0] == 'abi':
                    self.error_handler.error(f'Invalid args: abi.decode({arg_types})', len(arg_types) == 2)
                    out_type = arg_types[1]
                else:
                    return self.error_handler.todo(expr)
            elif len(ftype.outputs) > 1:
                # returns multiple things, set the return type as a TupleType
                out_type = soltypes.TupleType(ftype.outputs)
            elif len(ftype.outputs) == 1:
                # one return type
                out_type = ftype.outputs[0]
            else:
                # void return
                out_type = soltypes.VoidType()

        new_args = create_new_args()

        if isinstance(sym, symtab.BuiltinFunction):
            if isinstance(possible_base, soltypes.BuiltinType) or not possible_base:
                # TODO: separate node for revert, require, etc
                if sym.aliases[0] == 'require':
                    assert allow_stmt
                    assert len(special_call_options) == 0

                    if len(new_args) == 1:
                        return solnodes2.Require(new_args[0], None)
                    elif len(new_args) == 2:
                        reason_ttype = new_args[1].type_of()
                        assert reason_ttype.is_string() or reason_ttype.is_user_error()
                        return solnodes2.Require(new_args[0], new_args[1])
                    self.error_handler.todo(expr)
                elif sym.aliases[0] == 'revert':
                    assert allow_stmt
                    if len(new_args) == 1:
                        assert new_args[0].type_of().is_string()
                        return solnodes2.RevertWithReason(new_args[0])
                    elif len(new_args) == 0:
                        return solnodes2.Revert()
                    self.error_handler.todo(expr)
                name = f'{possible_base.name}.{sym.aliases[0]}' if possible_base else sym.aliases[0]
                return solnodes2.BuiltInCall(special_call_options, new_args, name, out_type)
            elif isinstance(possible_base, solnodes2.Expr):
                # e.g. myaddress.call(...)
                return solnodes2.DynamicBuiltInCall(special_call_options, new_args, out_type, possible_base, sym.aliases[0])
            elif isinstance(possible_base, solnodes2.Types):
                possible_base: solnodes2.Types
                if possible_base.is_user_type() and cast(solnodes2.ResolvedUserType, possible_base).value.x.is_udvt():
                    self.error_handler.assert_error(f'Builtin call with {possible_base} base must be a UDVT call', possible_base.value.x.is_udvt())
                    return solnodes2.DynamicBuiltInCall(special_call_options, new_args, out_type, possible_base, sym.aliases[0])
                else:
                    # bytes.concat, string.concat
                    name = f'{str(possible_base)}.{sym.aliases[0]}'
                    return solnodes2.BuiltInCall(special_call_options, new_args, name, out_type)
        elif isinstance(sym.value, solnodes1.FunctionDefinition):
            # TODO: check for None possible_base in refine_expr

            current_contract = self.get_declaring_contract_scope(expr)
            func_declaring_contract = self.get_declaring_contract_scope(sym.value)

            is_local_call = self.is_subcontract(current_contract, func_declaring_contract)

            if possible_base and not isinstance(possible_base, solnodes2.Expr) and is_local_call:
                # if we have a base such as ResolvedUserType but its to a function in the same contract
                possible_base = self.get_self_object(expr)

            if not possible_base:
                assert is_local_call
                possible_base = self.get_self_object(expr)

            # e.g. myInt.xyz(abc) where xyz is in a library, IntLibrary and xyz(int, int) is a function in IntLibrary
            # therefore the inputs are [myInt, abc], target funtion is IntLibrary.xyz
            # Using directives are only used for libraries atm so this would end up as a DirectCall
            if isinstance(unresolved_sym, symtab.UsingFunctionSymbol):
                # prepend myInt to the arg list
                new_args = [possible_base] + new_args
                # set the base to the library that declares the func so that below we emit a DirectCall
                possible_base = self.type_helper.get_contract_type(func_declaring_contract)

            self.load_non_top_level_if_required(sym.value)
            name = solnodes2.Ident(sym.value.name.text)
            if isinstance(possible_base, solnodes2.Expr):
                return solnodes2.FunctionCall(special_call_options, new_args, possible_base, name)
            else:
                return solnodes2.DirectCall(special_call_options, new_args, possible_base, name)
        elif isinstance(sym.value, solnodes1.StateVariableDeclaration):
            assert isinstance(possible_base, solnodes2.Expr)
            assert len(special_call_options) == 0

            if ftype.is_mapping():
                # create nested mapping loads multiple args were passed to this "call".
                # e.g. myMapping(x, y) => (myMapping[x])[y], i.e. have to create the inner one first

                # possible_base here is actually the base of the load, i.e. we have b.x(a)
                # possible_base == b
                # we need to set the base to a state var load or we lose information about x
                expr_base = solnodes2.StateVarLoad(possible_base, solnodes2.Ident(sym.value.name.text))

                self.error_handler.assert_error(f'No args', len(new_args) > 0)
                new_expr = None

                for expr_key in new_args:
                    new_expr = solnodes2.MappingLoad(expr_base, expr_key)
                    expr_base = new_expr

                return new_expr
            elif ftype.is_array() and not ftype.is_byte_array_underlying():
                load_base = solnodes2.StateVarLoad(possible_base, solnodes2.Ident(sym.aliases[0]))
                return solnodes2.ArrayLoad(load_base, new_args[0])
            else:
                assert is_synthetic
                return solnodes2.StateVarLoad(possible_base, solnodes2.Ident(sym.aliases[0]))
        elif isinstance(sym.value, solnodes1.ErrorDefinition):
            assert allow_error
            assert len(special_call_options) == 0
            self.load_non_top_level_if_required(sym.value)
            assert isinstance(sym.value.ast2_node, solnodes2.ErrorDefinition)
            return solnodes2.CreateError(
                solnodes2.UserDefinedErrorType(nodebase.Ref(sym.value.ast2_node)),
                new_args
            )
        elif isinstance(sym.value, solnodes1.EventDefinition):
            # old style event Emit that looks like a function call: we convert this to an Emit Stmt in AST2
            assert allow_event
            assert out_type.is_void()

            current_contract = self.get_declaring_contract_scope(expr)
            func_declaring_contract = self.get_declaring_contract_scope(sym.value)

            is_local_call = self.is_subcontract(current_contract, func_declaring_contract)

            self.error_handler.assert_error(f'Event reference must be have no base, type base or be local: {is_local_call}/{possible_base}', (not possible_base or isinstance(possible_base, solnodes2.ResolvedUserType)) or is_local_call)

            return solnodes2.EmitEvent(nodebase.Ref(sym.value.ast2_node), new_args)
        elif isinstance(sym.value, (solnodes1.Var, solnodes1.Parameter)):
            # refine_expr again but this time not as a function callee to get the callee as an expr
            return solnodes2.FunctionPointerCall(special_call_options, new_args, self.refine_expr(callee))
        self.error_handler.todo(sym.value)


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

    def is_subcontract(self, a: symtab.Scope, b: symtab.Scope):
        if not isinstance(a, symtab.ContractOrInterfaceScope) or not isinstance(b, symtab.ContractOrInterfaceScope):
            return a == b

        # TODO: quicker algorithm

        # checks if A is a subcontract of B/ if B is a supercontract of A (B extends A)
        to_check = deque()
        to_check.append(a)

        while to_check:
            next = to_check.popleft()
            if next == b:
                return True
            to_check.extend(next.get_supers())

        return False

    def find_bound_operator_symbol(self, expr: solnodes1.UnaryOp | solnodes1.BinaryOp,
                                   input_types: list[solnodes2.Types]):
        # atm these operators are left associative for binary operators and both input types must match, just use the
        # first type arbitrarily
        udvt_scopes = self.type_helper.scopes_for_type(expr, input_types[0])
        # lookup the symbol via the operator symbol itself, e.g. '-', '+' , etc . This is so 2ary sub and 1arg neg can
        # be found with both UnaryOpCode.NEG and BinaryOpCode.SUB as they are both represented with '-'.
        sym_name = str(expr.op.value)

        def matches_params(symbol):
            # FIXME: dirty way to find the matching one, use actual type matching like normal arg matching done in ast2
            func = symbol.value
            return hasattr(func, 'parameters') and len(func.parameters) == len(input_types)

        member_symbols = [scope_symbols for s in udvt_scopes if (scope_symbols := s.find_single(sym_name, predicate=matches_params))]

        self.error_handler.assert_error(f'Too many bound functions for {sym_name} operator: {member_symbols}',
                           len(member_symbols) <= 1)
        self.error_handler.error(f'No bound functions for {sym_name} operator', len(member_symbols) == 1)

        return member_symbols[0]

    def refine_bound_operator(self, expr: Union[solnodes1.UnaryOp, solnodes1.BinaryOp],
                              inputs: List[solnodes2.Expr]):
        input_types = [a.type_of() for a in inputs]
        function_symbol = self.find_bound_operator_symbol(expr, input_types)
        ast1_function = function_symbol.value
        # ast1 function will always map to an ast2 function
        binding_f = cast(solnodes2.FunctionDefinition, self.load_non_top_level_if_required(ast1_function))
        arg_types = [p.var.ttype for p in binding_f.inputs]
        # currently only matching types are allowed (no implicit casts)
        self.error_handler.assert_error(f'Mismatched arg types: {arg_types} vs {input_types}', arg_types == input_types)
        return solnodes2.DirectCall([], inputs, cast(solnodes2.TopLevelUnit, binding_f.parent).as_type(),
                                    solnodes2.Ident(binding_f.name.text))

    def get_function_call_symbol_base(self, s: symtab.Symbol):
        # the symbol base is any context that is required to differentiate this symbol from others
        s = s.res_syms_single()
        if self.is_top_level(s.value):
            # direct type reference, e.g. MyContract -> no base
            return None
        if isinstance(s, (symtab.BuiltinFunction, symtab.BuiltinObject, symtab.BuiltinValue)):
            # These aren't based on a concrete base
            return None
        if isinstance(s.value, solnodes1.Var):
            # local var has no base
            return None
        # otherwise we choose the base as the type of the declarer, e.g. if the symbol is x in C
        # then C is the base of x
        s_contract = self.get_declaring_contract_scope_in_scope(s)
        return self.type_helper.get_contract_type(s_contract)

    def get_function_callee_buckets(self, symbols: List[symtab.Symbol]):
        # split the bucket by shared bases
        new_buckets = {}
        for symbol in symbols:
            base = self.get_function_call_symbol_base(symbol)
            if base not in new_buckets:
                new_buckets[base] = []
            new_buckets[base].append(symbol)

        return [Builder.FunctionCallee(base, symbols) for base, symbols in new_buckets.items()]

    def is_declaration_chain(self, function_symbols):
        symbol_sources = [self.get_declaring_contract_scope_in_scope(s) for s in function_symbols]
        are_sub_contracts = all([self.is_subcontract(symbol_sources[0], source) and symbol_sources[0] != source for source in symbol_sources[1:]])
        return are_sub_contracts

    @link_with_ast1
    def refine_expr(self, expr: solnodes1.Expr, is_function_callee=False, allow_type=False, allow_tuple_exprs=False,
                    allow_multiple_exprs=False, allow_none=True, allow_stmt=False, is_argument=False,
                    is_assign_rhs=False, allow_event=False, allow_error=False):
        if expr is None:
            assert allow_none
            return None

        if isinstance(expr, solnodes1.UnaryOp):
            refined_expr = self.refine_expr(expr.expr)
            expr_type = refined_expr.type_of()

            if expr_type.is_user_type() and expr_type.value.x.is_udvt():
                return self.refine_bound_operator(expr, [refined_expr])
            return solnodes2.UnaryOp(refined_expr, expr.op, expr.is_pre)
        elif isinstance(expr, solnodes1.BinaryOp):
            left = self.refine_expr(expr.left, allow_tuple_exprs=True)
            # (_lhRound, _lhTime) = (guessRound, guessTime); is allowed so RHS can also have a tuple expr
            right = self.refine_expr(expr.right, is_assign_rhs=True, allow_tuple_exprs=True)

            if 'ASSIGN' not in str(expr.op):
                left_type, right_type = left.type_of(), right.type_of()
                if left_type.is_user_type() and left_type.value.x.is_udvt() and right_type.is_user_type() and right_type.value.x.is_udvt():
                    return self.refine_bound_operator(expr, [left, right])

            def make_assign(lhs, rhs, is_array_length_minus=False):
                if isinstance(lhs, solnodes2.StateVarLoad):
                    return solnodes2.StateVarStore(deepcopy(lhs.base), deepcopy(lhs.name), rhs)
                elif isinstance(lhs, solnodes2.ArrayLoad):
                    return solnodes2.ArrayStore(deepcopy(lhs.base), deepcopy(lhs.index), rhs)
                elif isinstance(lhs, solnodes2.LocalVarLoad):
                    return solnodes2.LocalVarStore(deepcopy(lhs.var), rhs)
                elif isinstance(lhs, solnodes2.DynamicBuiltInValue):
                    assert is_array_length_minus
                    return solnodes2.ArrayLengthStore(deepcopy(lhs.base), rhs)
                else:
                    self.error_handler.todo(lhs)

            if isinstance(left, list):
                assert expr.op == solnodes1.BinaryOpCode.ASSIGN
                assert allow_multiple_exprs
                # (x,y) = V; translates to
                # z = V; x = V[0]; y = V[1];
                # x and y can be state var setters, i.e. (a.x, b.y) = V is a valid assignment
                ttypes = [e.type_of() for e in left]

                # create fresh temp var name
                var_name = f'__ttemp{self.temp_var_counter}__'
                self.temp_var_counter += 1

                def z():
                    return solnodes2.Var(solnodes2.Ident(var_name), soltypes.TupleType(ttypes), None)

                # Note this does break up the scoping as defined in the symtab but it's very difficult to correct it
                # and not worth it imo as after this AST2 pass the symtab is embedded naturally in the AST so doesn't
                # have to be used again
                stmts = [solnodes2.LocalVarStore(z(), right)]

                for idx, e in enumerate(left):
                    rhs = solnodes2.TupleLoad(solnodes2.LocalVarLoad(z()), idx)
                    stmts.append(make_assign(e, rhs))

                return stmts

            if expr.op in self.ASSIGN_TO_OP:
                # this is an assign, make sure the lhs is a valid assignment target.
                # if the OP does some other mathematical operation then split the rhs into a load lhs + rhs
                # e.g. x += y translates to x = (x + y)

                # for some reason solidity allows myArray.length -= 1
                is_array_length_minus = isinstance(left, solnodes2.DynamicBuiltInValue) and left.name == 'length' and left.base.type_of().is_array()

                assert is_array_length_minus or isinstance(left, (
                solnodes2.StateVarLoad, solnodes2.LocalVarLoad, solnodes2.ArrayLoad))

                if expr.op != solnodes1.BinaryOpCode.ASSIGN:
                    value = solnodes2.BinaryOp(left, right, self.ASSIGN_TO_OP[expr.op])
                else:
                    value = right

                return make_assign(left, value, is_array_length_minus)
            else:
                return solnodes2.BinaryOp(left, right, expr.op)
        elif isinstance(expr, solnodes1.Types):
            expr: solnodes1.Types
            if is_function_callee:
                # E.g. calls that look like T(x) (Casts)
                # Type as expr has no base (direct reference)
                zs = expr.scope.find_type(expr, as_single=False)
                return [Builder.FunctionCallee(None, zs)]
            elif is_argument:
                # for arguments, types can sometimes be passed, e.g. abi.decode(x, bool)
                return solnodes2.TypeLiteral(self.type_helper.map_type(expr))
            elif allow_type:
                # base of bytes/string.concat
                return self.type_helper.map_type(expr)
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

            # when this Ident is refined as part of a function call, we return a list of possible
            # function callees. we don't know the actual callee that is required here because that depends on
            # context (arguments, types, etc) that is part of the function call and not encoded in this identifier.
            if is_function_callee:
                if expr.text == 'address':
                    # weird grammar edge case where it's parsed as an ident instead of a type
                    ttype = soltypes.AddressType(is_payable=False)

                    # FIXME: surely this is always true?
                    if is_function_callee:
                        # types have no 'base' as function callees
                        return [Builder.FunctionCallee(None, expr.scope.find_type(ttype))]
                    elif is_argument:
                        return solnodes2.TypeLiteral(self.type_helper.map_type(ttype))
                else:
                    # normal case, find the symbol in the scope of this ident
                    bucket = expr.scope.find(expr.text)
                    return self.get_function_callee_buckets(bucket)

            inheritable_predicate = symtab.ACCEPT_INHERITABLE(expr.scope)
            symbols = expr.scope.find(expr.text, predicate=inheritable_predicate)

            if not symbols:
                self.error_handler.error(f'Unresolved reference to {expr.text}')
                assert False  # unreachable

            # symtab can return multiple symbols for types, e.g. Ident('MyC') can return a ContractOrInterfaceScope and
            # a ProxyScope created from a Using directive. Both of these are searchable scopes for 'MyC' but here we
            # don't need them for searching, we just want to figure out why it's loaded by Identifier (direct type load)
            # Solution is to just choose 1 but do a sanity check to make sure all the symbols represent the same base
            # type
            top_levels = [self.is_top_level(s.value) for s in symbols]
            self.error_handler.error('Expected all or none to be top levels',
                                     TypeHelper.any_or_all(top_levels))

            if top_levels[0]:
                all_the_same = [symbols[0].value == s.value for s in symbols]
                self.error_handler.error(f'Type lookup: {expr.text} returned too many types: {symbols}',
                                         all_the_same)
                ident_symbol = symbols[0].res_syms_single()
            else:
                if len(symbols) > 1:
                    # this happens in the public_state_overridding.sol case, symbols = X.test and A.test
                    sources = [self.get_declaring_contract_scope_in_scope(s) for s in symbols]
                    contract_chain = all([self.is_subcontract(sources[0], source) for source in sources[1:]])
                    self.error_handler.error(f'{expr.text} matches too many symbols: {symbols}', contract_chain)

                ident_symbol = symbols[0].res_syms_single()

            if isinstance(ident_symbol, symtab.BuiltinValue):
                base_scope = ident_symbol.parent_scope
                assert isinstance(base_scope, symtab.BuiltinObject)
                return solnodes2.GlobalValue(f'{base_scope.aliases[0]}.{ident_symbol.aliases[0]}', self.type_helper.map_type(ident_symbol.ttype))

            ident_target = ident_symbol.value  # the AST1 node that this Ident is referring to

            if isinstance(ident_target, (solnodes1.FunctionDefinition, solnodes1.EventDefinition, solnodes1.ErrorDefinition)):
                # TODO: can this be ambiguous or does the reference always select a single function
                return solnodes2.GetFunctionPointer(nodebase.Ref(ident_target.ast2_node))
            elif isinstance(ident_target, solnodes1.ConstantVariableDeclaration):
                base_scope = self.get_declaring_contract_scope(ident_target)
                base_type = self.type_helper.get_contract_type(base_scope)
                self.load_non_top_level_if_required(ident_target)
                return solnodes2.StaticVarLoad(base_type, solnodes2.Ident(ident_target.name.text))
            elif isinstance(ident_target, solnodes1.StateVariableDeclaration):
                self.load_non_top_level_if_required(ident_target)
                
                var_declaring_contract = self.get_declaring_contract_scope(ident_target)

                # even though it's parsed as a statevardecl, it can still be a const with the const modifier
                if solnodes1.has_modifier_kind(ident_target, solnodes1.MutabilityModifierKind.CONSTANT):
                    return solnodes2.StaticVarLoad(self.type_helper.get_contract_type(var_declaring_contract),
                                                   solnodes2.Ident(ident_target.name.text))

                # i.e. Say we are in contract C and ident is 'x', check that 'x' is declared in C
                # this is so that we know the 'base' of this load will be 'self'
                ast1_current_contract = self.get_declaring_contract_scope(expr)
                var_declaring_contract = self.get_declaring_contract_scope(ident_target)

                assert self.is_subcontract(ast1_current_contract, var_declaring_contract)

                contract_type: solnodes2.ResolvedUserType = self.type_helper.get_contract_type(var_declaring_contract)

                return solnodes2.StateVarLoad(solnodes2.SelfObject(contract_type.value), solnodes2.Ident(expr.text))
            elif isinstance(ident_target, (solnodes1.Parameter, solnodes1.Var)):
                return solnodes2.LocalVarLoad(self.var(ident_target))
            elif self.is_top_level(ident_target) or isinstance(ident_symbol, symtab.FileScope):
                ttype = self.type_helper.symbol_to_ast2_type(ident_symbol)
                if is_argument:
                    return solnodes2.TypeLiteral(ttype)
                else:
                    assert allow_type
                    return ttype
            else:
                self.error_handler.todo(ident_target)
        elif isinstance(expr, solnodes1.CallFunction):
            return self.refine_call_function(expr, allow_stmt=allow_stmt, allow_event=allow_event, allow_error=allow_error)
        elif isinstance(expr, solnodes1.GetMember):
            base = expr.obj_base
            mname = expr.name.text

            base_type: solnodes2.Types = self.type_helper.get_expr_type(expr.obj_base)

            find_direct_scope = isinstance(base, (soltypes.BytesType, soltypes.StringType))
            base_scopes = self.type_helper.scopes_for_type(base, base_type, use_encoded_type_key=not find_direct_scope)

            using_predicate = self.type_helper.create_filter_using_scope(base_type)
            member_symbols = [scope_symbols for s in base_scopes if (scope_symbols := s.find(mname, predicate=using_predicate))]

            self.error_handler.assert_error(f'No matches to call {str(base)}.{mname}', len(member_symbols) > 0)

            if is_function_callee:
                # special case for old gas and value special call options when doing external calls. This syntax looks
                # exactly like the certain syntax with using directives, but the behaviour is different. in this case
                # we want to recognise the syntax as a partial function application, whereas for using directives, we
                # want to continue with symbol resolution for function calls as normal
                if isinstance(base_type, soltypes.FunctionType):
                    if len(base_scopes) == 1 and len(member_symbols[0]) == 1:
                        if isinstance(member_symbols[0][0], symtab.BuiltinFunction):
                            self.error_handler.assert_error(f'Invalid special call operator: f{mname}',
                                                            mname in ['gas', 'value'])
                            callees: List[Builder.FunctionCallee] = self.refine_expr(base, is_function_callee=True)
                            return [Builder.PartialFunctionCallee(c.base, c.symbols, {mname: None}) for c in callees]

                if isinstance(base_type, soltypes.BuiltinType):
                    bucket_base = base_type
                else:
                    bucket_base = self.refine_expr(base, allow_type=True)

                callees = []
                for bucket in member_symbols:
                    split_buckets = defaultdict(list)
                    for real_sym in bucket:
                        resolved_sym = real_sym.res_syms_single()
                        # direct type reference, e.g. MyContract -> no base
                        sym_base = None if self.is_top_level(resolved_sym.value) else bucket_base
                        split_buckets[sym_base].append(real_sym)
                    for split_bucket_base, split_bucket in split_buckets.items():
                        callees.append(Builder.FunctionCallee(split_bucket_base, split_bucket))

                return callees

            if len(member_symbols) == 1:
                are_sub_contracts = self.is_declaration_chain(member_symbols[0])
                self.error_handler.assert_error(f'{expr} has too many target definitions ({len(member_symbols[0])})',are_sub_contracts)
                func_sym = member_symbols[0][0]

                if isinstance(func_sym, symtab.BuiltinValue) and func_sym.aliases[0] == 'selector':
                    callees: List[Builder.FunctionCallee] = self.refine_expr(base, is_function_callee=True)

                    self.error_handler.assert_error('Invalid number of bases', len(callees) == 1)

                    callee = callees[0]

                    directly_referenced_callables = []
                    for callee_symbol in callee.symbols:
                        callee_value = callee_symbol.res_syms_single().value
                        is_valid_type = isinstance(callee_value, (
                        solnodes1.FunctionDefinition, solnodes1.EventDefinition, solnodes1.ErrorDefinition))
                        directly_referenced_callables.append(is_valid_type)
                    self.error_handler.error(f'Incongruent callables: {callee.symbols}',
                                             self.type_helper.any_or_all(directly_referenced_callables))

                    if directly_referenced_callables[0]:
                        # check that functions are part of a chain
                        are_sub_contracts = self.is_declaration_chain(callee.symbols)
                        self.error_handler.assert_error(f'Too many target definitions ({len(callee.symbols)})',
                                                        are_sub_contracts)

                        member_symbol = callee.symbols[0]
                        possible_base = callee.base

                        self.error_handler.assert_error(f'Expected selector: got {mname}', mname == 'selector')
                        return solnodes2.ABISelector(nodebase.Ref(member_symbol.value.ast2_node))
                    else:
                        self.error_handler.assert_error(f'Too many callees: {callees}', len(callees) == 1)
                        self.error_handler.assert_error(f'Expected selector: got {expr}.{mname}',
                                                        mname == 'selector')
                        refined_base = self.refine_expr(base)
                        return solnodes2.ABISelector(refined_base)

                if isinstance(func_sym.value, (solnodes1.FunctionDefinition, solnodes1.EventDefinition, solnodes1.ErrorDefinition)):
                    # Func pointer load e.g. this is the first param in abi.encodeCall(A.f, ...)
                    # TODO: can this be ambiguous or does the reference always select a single function
                    return solnodes2.GetFunctionPointer(nodebase.Ref(func_sym.value.ast2_node))

            all_member_symbols = [ms for mss in member_symbols for ms in mss]
            unique_member_symbols = []
            symtab._add_to_results(all_member_symbols, unique_member_symbols, set())

            self.error_handler.assert_error(f'Expected single symbol, got: {member_symbols}', len(unique_member_symbols) == 1)
            sym = unique_member_symbols[0]

            if isinstance(sym, symtab.BuiltinValue):
                if isinstance(base_type, soltypes.BuiltinType):
                    # e.g. msg.gas, where the base is a builtin object
                    return solnodes2.GlobalValue(f'{base_type.name}.{mname}', self.type_helper.map_type(sym.ttype))
                else:
                    # e.g. myarray.length, 'length' is builtin to the array type(i.e. not a concrete field)
                    new_base = self.refine_expr(base)
                    return solnodes2.DynamicBuiltInValue(mname, self.type_helper.map_type(sym.ttype), new_base)
            elif isinstance(sym, symtab.BuiltinFunction):
                input_params = [solnodes2.Parameter(solnodes2.Var(None, self.type_helper.map_type(t), None)) for t in (sym.input_types or [])]
                output_params = [solnodes2.Parameter(solnodes2.Var(None, self.type_helper.map_type(t), None)) for t in (sym.output_types or [])]
                builtin_f = solnodes2.BuiltinFunction(sym.aliases[0], input_params, output_params)
                return solnodes2.GetFunctionPointer(nodebase.Ref(builtin_f))
            else:
                referenced_member = sym.value
                new_base = self.refine_expr(base, allow_type=True)

                if isinstance(referenced_member, solnodes1.StructMember):
                    assert isinstance(new_base, solnodes2.Expr)
                    return solnodes2.StateVarLoad(new_base, solnodes2.Ident(mname))
                elif isinstance(referenced_member, (solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration)):
                    # if the base is a type, it's a constant load, i.e. MyX.myConst (possibly also a qualified
                    # lookup like MyX.MyY.myConst?)
                    # else it's an instance member load which requires an expr base
                    if isinstance(new_base, solnodes2.Types):
                        assert isinstance(new_base, solnodes2.ResolvedUserType)
                        assert solnodes1.MutabilityModifierKind.CONSTANT in [m.kind for m in referenced_member.modifiers if hasattr(m, 'kind')]
                        return solnodes2.StaticVarLoad(new_base, solnodes2.Ident(referenced_member.name.text))
                elif isinstance(referenced_member, solnodes1.Ident) and isinstance(referenced_member.parent,
                                                                                   solnodes1.EnumDefinition):
                    assert isinstance(new_base, solnodes2.ResolvedUserType) and new_base.value.x.is_enum()
                    member_matches = [member for member in new_base.value.x.values
                                      if member.name.text == referenced_member.text]
                    assert len(member_matches) == 1
                    return solnodes2.EnumLoad(nodebase.Ref(member_matches[0]))
                elif self.is_top_level(referenced_member) or isinstance(referenced_member, solnodes1.ErrorDefinition):
                    assert isinstance(new_base, solnodes2.ResolvedUserType)
                    # Qualified top level reference, e.g. MyLib.MyEnum...
                    return self.type_helper.get_contract_type(sym)
            self.error_handler.todo(expr)
        elif isinstance(expr, solnodes1.Literal):
            if isinstance(expr.value, tuple):
                assert not expr.unit

                type_args = [self.type_helper.map_as_type_arg(arg) for arg in expr.value]
                are_type_args = [isinstance(arg, soltypes.Type) for arg in type_args]
                assert TypeHelper.any_or_all(are_type_args)

                if any(are_type_args):
                    # the grammar has 'TupleExpression' s, e.g. '(' exprList ')'. The exprs it allows can also be types.
                    # Either all or none of the exprs must be types
                    # but the parser is weird
                    return solnodes2.TypeLiteral(soltypes.TupleType([self.type_helper.map_type(t) for t in type_args]))
                elif len(expr.value) == 1:
                    # Bracketed expressions, not tuples, e.g. (x).y() , (x) isn't a tuple so unpack here
                    assert isinstance(expr.value[0], solnodes1.Expr)
                    return self.refine_expr(expr.value[0], is_assign_rhs=is_assign_rhs)
                else:
                    # Actual tuple but tuples aren't part of solidity properly, they are just syntactic sugar
                    # e.g. for returning multiple values or unpacking calls that return multiple values. So check
                    # that the parent is a return and as a special case to function, we return a list of the values
                    # instead of an Expr type. The parent case for Return can handle returning a list as well.
                    # This is also true for the LHS of var stores and in ExprStmts

                    # update: this is now allowed (at some point in 0.8, but used in 0.8.11 for abi.encodeCall)
                    # e.g. abi.encodeCall(A.f, (myVar1, myExpr2)) we return a list of exprs that the parent must
                    # inline/handle
                    if is_argument or allow_tuple_exprs:
                        return [self.refine_expr(e, is_assign_rhs=is_assign_rhs) for e in expr.value]
                    self.error_handler.todo(expr)
            # elif isinstance(expr.value, solnodes1.Type):
            #     self.error_handler.todo(expr)
            else:
                assert not isinstance(expr.value, solnodes1.Expr)
                # if this value determines the RHS of something with an expected type, e.g. bytes myb = 1234567...;
                # then the declared LHS type can be different from the implied type of the RHS
                # https://docs.soliditylang.org/en/v0.8.17/types.html#conversions-between-elementary-types
                explicit_ttype = self.type_helper.get_expr_type(expr)
                return solnodes2.Literal(expr.value, explicit_ttype, expr.unit)
        elif isinstance(expr, solnodes1.GetArrayValue):
            if allow_type:
                possible_type = self.type_helper.map_as_type_arg(expr)
                if possible_type and isinstance(possible_type, solnodes2.Types):
                    return possible_type
            return solnodes2.ArrayLoad(self.refine_expr(expr.array_base), self.refine_expr(expr.index))
        elif isinstance(expr, solnodes1.GetArraySlice):
            return solnodes2.ArraySliceLoad(self.refine_expr(expr.array_base), self.refine_expr(expr.start_index),
                                            self.refine_expr(expr.end_index))
        elif isinstance(expr, solnodes1.PayableConversion):
            # address payable cast
            assert len(expr.args) == 1
            return solnodes2.Cast(soltypes.AddressType(True), self.refine_expr(expr.args[0]))
        elif isinstance(expr, solnodes1.CreateMetaType):
            return solnodes2.GetType(self.type_helper.map_type(expr.base_type))
        elif isinstance(expr, solnodes1.TernaryOp):
            return solnodes2.TernaryOp(self.refine_expr(expr.condition), self.refine_expr(expr.left, allow_tuple_exprs=allow_tuple_exprs), self.refine_expr(expr.right, allow_tuple_exprs=allow_tuple_exprs))
        elif isinstance(expr, solnodes1.NamedArg):
            return solnodes2.NamedArgument(self.ident(expr.name), self.refine_expr(expr.value))
        elif isinstance(expr, solnodes1.NewInlineArray):
            return solnodes2.CreateInlineArray([self.refine_expr(e) for e in expr.elements])
        self.error_handler.todo(expr)

    def find_method(self, possible_matches: list[symtab.Symbol], arg_types: list[solnodes2.Types]):
        assert not any([x is None for x in arg_types])

        def get_arg_types(func_scope: symtab.ModFunErrEvtScope) -> list[solnodes2.Types]:
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
                target_param_types = get_arg_types(s.res_syms_single())
                actual_param_types = [self.type_helper.map_type(s.override_type)] + arg_types
            else:
                assert isinstance(s, symtab.ModFunErrEvtScope)
                # In Solidity x.sub(y) is only valid with a Using declaration, so we check the actual parameter type
                # lists supplied.
                target_param_types = get_arg_types(s)
                actual_param_types = arg_types

            return soltypes.Type.are_matching_types(target_param_types, actual_param_types)

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
        name = solnodes2.Ident(node.var_name.text if node.var_name else None)
        return solnodes2.ErrorParameter(self.type_helper.map_type(node.var_type), name)

    def ident(self, node: solnodes1.Ident, name: str = None):
        return solnodes2.Ident(node.text) if node else None

    def no_ident(self):
        return solnodes2.Ident('')

    def modifiers(self, node_with_modifiers):
        if not hasattr(node_with_modifiers, 'modifiers'):
            return []
        return [self.modifier(m) for m in node_with_modifiers.modifiers]

    def modifier(self, node: solnodes1.Modifier | solnodes2.Modifier):
        if isinstance(node, solnodes2.VisibilityModifier):
            return solnodes2.VisibilityModifier(node.kind)
        if isinstance(node, solnodes2.MutabilityModifier):
            return solnodes2.MutabilityModifier(node.kind)

        if isinstance(node, solnodes1.VisibilityModifier2):
            return solnodes2.VisibilityModifier(node.kind)
        if isinstance(node, solnodes1.MutabilityModifier2):
            return solnodes2.MutabilityModifier(node.kind)
        if isinstance(node, solnodes1.OverrideSpecifier):
            return solnodes2.OverrideSpecifier([self.type_helper.get_user_type(t) for t in node.arguments])

        if isinstance(node, solnodes1.InvocationModifier):
            target = self.type_helper.get_expr_type(node.name, allow_multiple=True)

            if isinstance(target, list):
                # deduplicate
                deduplicated_targets = list(set(target))
                self.error_handler.assert_error(f'InvocationModifier resolved to too many targets: {deduplicated_targets}', len(deduplicated_targets) == 1)
                target = deduplicated_targets[0]

            if isinstance(target, solnodes2.ResolvedUserType):
                node_klass = solnodes2.SuperConstructorInvocationModifier
            elif target.is_function():
                # actually it's a modifier definition that this resolves to
                mod_defs = node.scope.find(node.name.text)
                if len(mod_defs) > 1:
                    # If we have multiple matches, check that they are part of an override chain and pick the first one
                    are_sub_contracts = self.is_declaration_chain(mod_defs)
                    self.error_handler.assert_error(f'{node.name.text} has too many target definitions ({len(mod_defs)})', are_sub_contracts)

                target = self.load_non_top_level_if_required(mod_defs[0].value)
                node_klass = solnodes2.FunctionInvocationModifier
            else:
                return self.error_handler.todo(node)
            return node_klass(target, [self.refine_expr(e) for e in node.arguments] if node.arguments else [])  # type: ignore

        self.error_handler.todo(node)

    def process_code_block(self, node: solnodes1.Block):
        try:
            result_code = self.block(node)
            return result_code
        except errors.CodeProcessingError as e:
            self.error_handler.handle_processing_error(e)
            return solnodes2.UnprocessedCode(e)

    def block(self, node: solnodes1.Block):
        if node:
            return solnodes2.Block(
                [self.refine_stmt(s) for s in node.stmts],
                node.is_unchecked
            )
        else:
            return solnodes2.Block([], False)

    def get_synthetic_owner(self, source_unit_name, file_scope: symtab.FileScope) -> solnodes2.FileDefinition:
        if source_unit_name in self.synthetic_toplevels:
            return self.synthetic_toplevels[source_unit_name]
        toplevel = solnodes2.FileDefinition(source_unit_name, solnodes2.Ident(source_unit_name), [])
        # Set the 'scope' of this ast2 node. This is only done for this node type as it acts as an ast1 node during
        # refinement
        toplevel.scope = file_scope
        toplevel.ast2_node = toplevel
        # Pass this FileDefinition to the to_refine queue, note it's parsed specially because this queue usually
        # contains AST1 nodes but there is no AST1 node equivalent for FileDefinition
        self.to_refine.append(toplevel)
        self.synthetic_toplevels[source_unit_name] = toplevel
        return toplevel

    def define_skeleton(self, ast1_node: solnodes1.SourceUnit, source_unit_name: Optional[str]) -> solnodes2.TopLevelUnit | solnodes2.ContractPart:
        assert self.should_create_skeleton(ast1_node), f'{type(ast1_node)}'
        """
        Makes a skeleton of the given AST1 node without processing the details. This is required as user types are
        loaded on demand(when they're used in code/parameter lists/declarations, etc). This skeleton is used as a
        reference and then filled in later on. 
        
        The given source unit name is the computed source unit name(essentially the qualified file name) that will 
        directly contain this node in AST2.
        
        In the case where SUN is set and the node is considered a top level node in AST2 (see is_top_level), the node
        is skeletoned and the SUN becomes part of the descriptor for the node i.e. roughly: {SUN}{NODE_NAME}. e.g.
        a contract defined at the top level in a file.
        
        If the SUN is set but the node is not a top level node in AST2, the node is a free floating definition in AST1.
        A synthetic top level unit is made based on symtab.FileScope(becomes an AST2 FileDefinition) and the skeleton
        for the current node is added to the FileDefinition, e.g. a free floating constant or function definition in
        a file.
        
        If the SUN is not set, the node is a child of another top level unit(not directly the child of a FileScope),
        e.g. a function defined in a contract. 
        """
        assert not ast1_node.ast2_node

        logging_f = logging.getLogger('AST2').debug
        logging_f(f' making skeleton for {type(ast1_node).__name__}({ast1_node.name}) :: {source_unit_name}')  # type: ignore

        # Source unit name is only used for source units/top level units
        # This is the case where we have functions, errors, event, constants that are defined outside of a top level
        # node like a contract or interface, i.e. parentless definitions
        if source_unit_name and not self.is_top_level(ast1_node):
            # For these nodes we create a synthetic top level unit
            file_scope = ast1_node.scope.find_first_ancestor_of(symtab.FileScope)
            self.error_handler.assert_error(f'{source_unit_name} != {file_scope.source_unit_name}', source_unit_name == file_scope.source_unit_name)
            synthetic_toplevel = self.get_synthetic_owner(source_unit_name, file_scope)
            # For normal definitions that have an owner, source_unit_name passed in is None. The current call of
            # define_skeleton has the SUN set which triggered in this block to be executed. Re-call define_skeleton
            # but with no SUN. This skips this block and creates the ast2 skeleton and returns it us here
            ast2_node = self.define_skeleton(ast1_node, None)
            # this is needed as a shim as solnodes2.FileDefinition gets refined as there is no AST1 for it
            ast2_node.ast1_node = ast1_node
            ast2_node.is_free = True
            synthetic_toplevel.parts.append(ast2_node)
            synthetic_toplevel._set_child_parents()
            # MUST return here, we have already processed this ast1_node above
            return ast2_node

        def _make_new_node(n):
            if isinstance(n, solnodes1.FunctionDefinition):
                # name here is flattened because it can be a string or a specialfunctionkind
                # TODO: constructor marker
                name = str(n.name)

                markers = []

                if name == 'constructor':
                    markers.append(solnodes2.FunctionMarker.CONSTRUCTOR)
                # FIXME: in pre 0.5 solidity, the constructor keyword didn't exist so constructors were named the same
                #        as the contract, need to do a version check and add this case
                return solnodes2.FunctionDefinition(solnodes2.Ident(str(n.name)), [], [], [], None, markers)

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
            elif isinstance(n, solnodes1.UserValueType):
                return solnodes2.UserDefinedValueTypeDefinition(source_unit_name, name, None)
            elif isinstance(n, solnodes1.ErrorDefinition):
                return solnodes2.ErrorDefinition(name, [])
            elif isinstance(n, solnodes1.StateVariableDeclaration):
                if solnodes1.has_modifier_kind(n, solnodes1.MutabilityModifierKind.CONSTANT):
                    return solnodes2.ConstantVariableDeclaration(name, None, None)
                else:
                    return solnodes2.StateVariableDeclaration(name, None, [], None)
            elif isinstance(n, solnodes1.ConstantVariableDeclaration):
                return solnodes2.ConstantVariableDeclaration(name, None, None)
            elif isinstance(n, solnodes1.EventDefinition):
                return solnodes2.EventDefinition(name, [], None)
            elif isinstance(n, solnodes1.ModifierDefinition):
                return solnodes2.ModifierDefinition(name, [], [], None)
            else:
                self.error_handler.todo(n)

        ast2_node = _make_new_node(ast1_node)
        ast1_node.ast2_node = ast2_node
        # transfer the comments over
        ast2_node.comments = ast1_node.comments

        # contracts, interfaces
        if hasattr(ast1_node, 'inherits'):
            ast2_node.inherits = [
                solnodes2.InheritSpecifier(self.type_helper.get_user_type(x.name), [])
                for x in ast1_node.inherits
            ]

        if hasattr(ast1_node, 'parts'):
            for p in ast1_node.parts:
                if self.is_top_level(p):
                    # these units don't get added as parts in AST2, e.g. an embedded contract B in parent contract A
                    # gets loaded as a separate ContractDefinition with the name as A$B
                    self.load_if_required(p.owning_scope)

            for p in ast1_node.parts:
                # don't need usings or pragmas for AST2
                if not self.is_top_level(p) and self.should_create_skeleton(p) and not p.ast2_node:
                    ast2_node.parts.append(self.define_skeleton(p, None))

                if isinstance(p, (solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration)):
                    # generate synthetic, codeless, getter functions for each field. This is to fix virtual function
                    # call lookups that resolve to a synthetic getter
                    if solnodes1.has_modifier_kind(p, solnodes1.VisibilityModifierKind.PUBLIC):
                        # TODO: check override is valid
                        getter_func = solnodes2.FunctionDefinition(solnodes2.Ident(p.name.text), [], [solnodes2.Parameter(solnodes2.Var(solnodes2.Ident(p.name.text), self.type_helper.map_type(p.var_type), None))], [], None, [solnodes2.FunctionMarker.SYNTHETIC_FIELD_GETTER])
                        getter_func.refined = True
                        getter_func._set_child_parents()
                        ast2_node.parts.append(getter_func)
                        logging.getLogger('AST2').debug(f"generating getter: {getter_func.name.code_str()} :: {getter_func.outputs[0].var.ttype.code_str()}")

                        # generate mapping access getter
                        var_type = getter_func.outputs[0].var.ttype
                        if var_type.is_mapping():
                            # copy these as they are already linked to parent nodes
                            mapping_types = [deepcopy(t) for t in var_type.flatten()]
                            inputs = [solnodes2.Parameter(solnodes2.Var(None, t, None)) for t in mapping_types[:-1]]
                            outputs = [solnodes2.Parameter(solnodes2.Var(None, mapping_types[-1], None))]
                            mapping_getter_func = solnodes2.FunctionDefinition(solnodes2.Ident(p.name.text), inputs, outputs, [], None, [solnodes2.FunctionMarker.SYNTHETIC_FIELD_GETTER])
                            mapping_getter_func.refined = True
                            mapping_getter_func._set_child_parents()
                            ast2_node.parts.append(mapping_getter_func)
                            logging.getLogger('AST2').debug(f"generating mapping getter: {mapping_getter_func.name.code_str()} :: {mapping_getter_func.outputs[0].var.ttype.code_str()}")

        # structs
        if hasattr(ast1_node, 'members'):
            ast2_node.members = [
                solnodes2.StructMember(self.type_helper.map_type(x.member_type), solnodes2.Ident(x.name.text)) for x in
                ast1_node.members]

        # need to define inputs (and maybe outputs) for functions so that function calls can be resolved during
        # DirectCall.type_of() calls
        if isinstance(ast1_node, solnodes1.FunctionDefinition):
            ast2_node.inputs = [self.parameter(x) for x in ast1_node.parameters]
            ast2_node.outputs = [self.parameter(x) for x in ast1_node.returns]

        if isinstance(ast1_node, solnodes1.ErrorDefinition):
            ast2_node.inputs = [self.error_parameter(x) for x in ast1_node.parameters]

        if isinstance(ast1_node, solnodes1.EnumDefinition):
            ast2_node.values = [solnodes2.EnumMember(solnodes2.Ident(n.text)) for n in ast1_node.values]

        if isinstance(ast1_node, (solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration)):
            ast2_node.ttype = self.type_helper.map_type(ast1_node.var_type)

        if isinstance(ast1_node, solnodes1.EventDefinition):
            ast2_node.inputs = [solnodes2.EventParameter(solnodes2.Ident(p.var_name.text if p.var_name else f'<unnamed:{i}'), self.type_helper.map_type(p.var_type), p.is_indexed)
                                for i,p in enumerate(ast1_node.parameters)]

        if isinstance(ast1_node, solnodes1.ModifierDefinition):
            ast2_node.inputs = [self.parameter(x) for x in ast1_node.parameters]

        if isinstance(ast1_node, solnodes1.UserValueType):
            ast2_node.ttype = self.type_helper.map_type(ast1_node.value)

        if self.is_top_level(ast1_node):
            self.normal_toplevels.append(ast2_node)
            self.to_refine.append(ast1_node)

        ast2_node._set_child_parents()

        return ast2_node

    def refine_unit_or_part(self, ast1_node: Union[solnodes1.SourceUnit, solnodes2.FileDefinition]):
        is_file_def = isinstance(ast1_node, solnodes2.FileDefinition)
        if not isinstance(ast1_node, (solnodes1.ContractDefinition, solnodes1.InterfaceDefinition,
                                      solnodes1.StructDefinition, solnodes1.LibraryDefinition,
                                      solnodes1.EnumDefinition, solnodes1.ErrorDefinition,
                                      solnodes1.FunctionDefinition, solnodes1.EventDefinition,
                                      solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration,
                                      solnodes1.ModifierDefinition, solnodes1.UserValueType,
                                      # Special case
                                      solnodes2.FileDefinition)) and not is_file_def:
            raise ValueError('x')

        ast2_node = ast1_node.ast2_node

        if hasattr(ast2_node, 'refined') and ast2_node.refined:
            return

        if self.is_top_level(ast1_node) or is_file_def:
            if isinstance(ast1_node, solnodes1.ContractDefinition):
                ast2_node.is_abstract = ast1_node.is_abstract

            # contracts, interfaces
            if hasattr(ast1_node, 'inherits'):
                for ast1_inherit, ast2_inherit in zip(ast1_node.inherits, ast2_node.inherits):
                    ast2_inherit.args = [self.refine_expr(arg) for arg in ast1_inherit.args]

            # contracts, interfaces, libraries, filedef
            if hasattr(ast1_node, 'parts'):
                for part in ast1_node.parts:
                    if isinstance(part, solnodes1.UsingDirective):
                        if part.library_name:
                            # get the parent scope of the usingdirective, usually a FileScope as the proxy scope gets
                            # in the using directive scope
                            library_scope = part.scope.parent_scope.find_user_type_scope(part.library_name.text, find_base_symbol=True)
                            assert isinstance(library_scope.value, solnodes1.LibraryDefinition)
                            library = self.type_helper.get_contract_type(library_scope)
                            if isinstance(part.override_type, soltypes.AnyType):
                                for sym in library_scope.get_all_functions():
                                    input_params = sym.value.parameters
                                    if input_params:
                                        override_type = input_params[0].var_type
                                        ast2_node.type_overrides.append(solnodes2.LibraryOverride(
                                            self.type_helper.map_type(override_type), library))

                            else:
                                ast2_node.type_overrides.append(
                                solnodes2.LibraryOverride(self.type_helper.map_type(part.override_type), library))
                        else:
                            # TODO: free function version of this
                            pass

                    part_ast1node = None
                    if hasattr(part, 'ast2_node') and part.ast2_node:
                        part_ast1node = part
                    elif hasattr(part, 'is_free') and part.is_free:
                        part_ast1node = part.ast1_node

                    if part_ast1node:
                        self.refine_unit_or_part(part_ast1node)

        def refine_node(n):
            n.refined = True
            n._set_child_parents()
            return n

        if isinstance(ast1_node, solnodes1.FunctionDefinition):
            ast2_node.modifiers = [self.modifier(x) for x in ast1_node.modifiers]
            ast2_node.code = self.process_code_block(ast1_node.code) if ast1_node.code else None
            return refine_node(ast2_node)

        if isinstance(ast1_node, (solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration)):
            if hasattr(ast1_node, 'modifiers'):
                ast2_node.modifiers = [self.modifier(x) for x in ast1_node.modifiers]
            if ast1_node.initial_value:
                ast2_node.initial_value = self.refine_expr(ast1_node.initial_value, is_assign_rhs=True)
            return refine_node(ast2_node)

        if isinstance(ast1_node, solnodes1.EventDefinition):
            ast2_node.is_anonymous = ast1_node.is_anonymous
            return refine_node(ast2_node)

        if isinstance(ast1_node, solnodes1.ModifierDefinition):
            ast2_node.modifiers = [self.modifier(x) for x in ast1_node.modifiers]
            ast2_node.code = self.process_code_block(ast1_node.code) if ast1_node.code else None
            return refine_node(ast2_node)

        # don't return anything here
        refine_node(ast2_node)
        return None

    def is_top_level(self, node: solnodes1.AST1Node):
        # Error and FunctionDefinitions are set as SourceUnits in AST1 but not in AST2
        return isinstance(node, solnodes1.SourceUnit) and not isinstance(node, (solnodes1.ImportDirective, solnodes1.FunctionDefinition, solnodes1.ErrorDefinition, solnodes1.StateVariableDeclaration, solnodes1.ConstantVariableDeclaration))

    def should_create_skeleton(self, node: solnodes1.AST1Node) -> bool:
        return isinstance(node, (solnodes1.SourceUnit, solnodes1.ContractPart)) and not isinstance(node, (solnodes1.ImportDirective, solnodes1.PragmaDirective, solnodes1.UsingDirective))
