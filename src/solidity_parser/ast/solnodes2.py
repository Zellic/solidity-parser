from abc import ABC
from dataclasses import dataclass, field
from enum import Enum
from typing import List, Any, Union, TypeVar, Generic, Optional
from copy import deepcopy
from collections import deque

from solidity_parser.ast import solnodes as solnodes1

from solidity_parser.ast.mro_helper import c3_linearise

T = TypeVar('T')


def NodeDataclass(cls, *args, **kwargs):
    # Add a hash based on the elements that make up this node. This is required because dataclass doesn't generate a
    # hash for us unless we pass in unsafe_hash=True on the decorator for every node subclass and even if we do that
    # it can't hash lists. Since get_all_children returns a generator of nodes (i.e. no lists), we can hash it as a
    # tuple, i.e. a "snapshot hash"
    def __node__hash(self):
        return hash(tuple(self.get_all_children()))
    cls.__hash__ = __node__hash
    return dataclass(*[cls, *args], **kwargs)


@dataclass
class Ref(Generic[T]):
    x: T


@NodeDataclass
class Node:
    parent: Optional['Node'] = field(init=False, repr=False, hash=False, compare=False)

    def get_children(self):
        for val in vars(self).values():
            # Don't include parent or Refs
            if val is self.parent:
                continue

            if isinstance(val, Node):
                yield val
            elif isinstance(val, (list, tuple)):
                yield from [v for v in val if isinstance(v, Node)]

    def get_all_children(self):
        for direct_child in self.get_children():
            yield direct_child
            yield from direct_child.get_all_children()

    def __post_init__(self):
        self.parent = None
        self._set_child_parents()

    def _set_child_parents(self):
        for child in self.get_children():
            child.parent = self

    def __deepcopy__(self, memodict):
        new_fields = {}
        for name, dfield in self.__dataclass_fields__.items():
            if name == 'parent':
                # don't climb up the tree/copy the parent
                continue
            # just confirm it needs to be passed to the constructor
            if not dfield.init:
                continue

            current_value = getattr(self, name)
            if isinstance(current_value, (Node, list, tuple)) and not isinstance(current_value, Ref):
                new_fields[name] = deepcopy(current_value, memodict)
            else:
                # copy stuff like str, int
                new_fields[name] = current_value
        klass = self.__class__
        # create the copy by instantiating it like a normal Node, i.e. the parent of the children are set here
        new_obj = klass(**new_fields)
        return new_obj

    def code_str(self):
        raise NotImplementedError()


@NodeDataclass
class Type(Node, ABC):
    @staticmethod
    def are_matching_types(target_param_types, actual_param_types):
        if not len(target_param_types) == len(actual_param_types):
            return False

        # check if the actual args types are passable to the target types
        return all([a.can_implicitly_cast_from(b) for a,b in zip(target_param_types, actual_param_types)])

    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        # Check whether actual_type can be converted to this type implicitly
        # Default case is if the types are equal
        return self == actual_type

    def is_builtin(self) -> bool:
        raise NotImplementedError()

    def is_array(self) -> bool:
        return False

    def is_string(self) -> bool:
        return False

    def is_function(self) -> bool:
        return False

    def is_int(self) -> bool:
        return False

    def is_user_type(self) -> bool:
        return False

    def is_address(self) -> bool:
        return False

    def is_mapping(self) -> bool:
        return False

    def is_byte(self) -> bool:
        return False

    def is_tuple(self) -> bool:
        return False

    def is_literal_type(self) -> bool:
        return False


@NodeDataclass
class Stmt(Node, ABC):
    pass


@NodeDataclass
class Expr(Node, ABC):
    def type_of(self) -> Type:
        raise NotImplementedError(f'{type(self)}')


@NodeDataclass
class Modifier(Node, ABC):
    pass


@NodeDataclass
class VisibilityModifier(Modifier):
    kind: solnodes1.VisibilityModifierKind

    def code_str(self):
        return str(self.kind.value)


@NodeDataclass
class MutabilityModifier(Modifier):
    kind: solnodes1.MutabilityModifierKind

    def code_str(self):
        return str(self.kind.value)


@NodeDataclass
class OverrideSpecifier(Modifier):
    bases: List['ResolvedUserType']


@NodeDataclass
class SuperConstructorInvocationModifier(Modifier):
    base_ttype: 'ResolvedUserType'
    inputs: List[Expr]


@NodeDataclass
class Ident(Node):
    text: str


@NodeDataclass
class NamedArgument(Node):
    name: Ident
    expr: Expr


@NodeDataclass
class TopLevelUnit(Node):
    source_unit_name: str
    name: Ident

    def is_subttype_of(self, other_contract: 'TopLevelUnit') -> bool:
        to_check = deque()
        to_check.append(self)

        while to_check:
            next = to_check.popleft()
            if next == other_contract:
                return True
            to_check.extend(next.get_supers())
        return False

    def as_type(self):
        return ResolvedUserType(Ref(self))

    def get_supers(self) -> List[Union['ContractDefinition', 'InterfaceDefinition']]:
        # c.inherits are the InheritSpecifics
        # s.name is the ResolvedUserType => .value.x is the Contract/InterfaceDefinition
        return [s.name.value.x for s in self.inherits] if hasattr(self, 'inherits') else []

    def get_subtypes(self) -> List[Union['ContractDefinition', 'InterfaceDefinition']]:
        return [s.x for s in self._subtypes] if hasattr(self, '_subtypes') else []

    def is_enum(self) -> bool:
        return isinstance(self, EnumDefinition)

    def is_struct(self) -> bool:
        return isinstance(self, StructDefinition)

    def is_contract(self) -> bool:
        return isinstance(self, ContractDefinition)

    def is_interface(self) -> bool:
        return isinstance(self, InterfaceDefinition)


@NodeDataclass
class ArrayType(Type):
    """ Single dimension array type with no size attributes
    This is most often used for 'bytes' which is a array of bytes of unknown/variable length
    """
    base_type: Type

    def __str__(self): return f"{self.base_type}[]"

    def is_builtin(self) -> bool:
        # e.g. byte[] is builtin, string[] is builtin, MyContract[] is not
        return self.base_type.is_builtin()

    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        if super().can_implicitly_cast_from(actual_type):
            return True
        if not self.has_size() and actual_type.is_array() and actual_type.has_size():
            # i.e. FixedLengthArrayType/VariableLengthArrayType can cast to the base ArrayType (but not each other)
            # e.g. byte[4] casts to byte[] but not the other way around
            return self.base_type.can_implicitly_cast_from(actual_type.base_type)
        if self.base_type.is_byte() and not self.has_size() and actual_type.is_literal_type():
            return True

        return False

    def has_size(self) -> bool:
        return hasattr(self, 'size')

    def is_fixed_size(self) -> bool:
        return False

    def is_array(self) -> bool:
        return True


@NodeDataclass
class FixedLengthArrayType(ArrayType):
    """ Array type with a known length that is determined at compile time """
    size: int

    def __str__(self): return f"{self.base_type}[{self.size}]"

    def is_fixed_size(self) -> bool:
        return True

    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        if super().can_implicitly_cast_from(actual_type):
            return True
        # Decimal number literals cannot be implicitly converted to fixed-size byte arrays. Hexadecimal number literals
        # can be, but only if the number of hex digits exactly fits the size of the bytes type. As an exception both
        # decimal and hexadecimal literals which have a value of zero can be converted to any fixed-size bytes type:
        if self.base_type.is_byte() and actual_type.is_int() and actual_type.is_literal_type():
            return self.size >= (actual_type.size / 8)
        if self.base_type.is_byte() and actual_type.is_string() and actual_type.is_literal_type():
            # e.g. bytes32 samevar = "stringliteral"
            return self.size >= actual_type.real_size

        return False


@NodeDataclass
class VariableLengthArrayType(ArrayType):
    """ Array type with a length that is determined at runtime"""
    size: Expr

    def __str__(self): return f"{self.base_type}[{self.size}]"


@NodeDataclass
class AddressType(Type):
    """ Solidity address/address payable type, functionally this is a uint160"""
    is_payable: bool

    def __str__(self): return f"address{' payable' if self.is_payable else ''}"

    def can_implicitly_cast_from(self, actual_type: Type) -> bool:
        # address_payable(actual_type) can be cast to address implicitly
        if actual_type.is_address():
            # Matrix:
            #  self <= actual_type = can_implicitly_cast_from
            #  AP <= AP = true
            #  AP <= A = false
            #  A <= A = true
            #  A <= AP = true
            return not(self.is_payable and not actual_type.is_payable)
        # contracts can get cast to address (at least in solidity 0.4.23)
        if actual_type.is_user_type():
            definition = actual_type.value.x
            if definition.is_contract() or definition.is_interface():
                return True
        # uint160 can cast to address, I've seen this in a contract but AfterObol.sol:
        # _mint(0x0CA5cD5790695055F0a01F73A47160C35f9d3A46, 100000000 * 10 ** decimals());
        # but not sure how this is allowed exactly
        # UPDATE:
        # "Hexadecimal literals that pass the address checksum test, for example
        # 0xdCad3a6d3569DF655070DEd06cb7A1b2Ccd1D3AF are of address type. Hexadecimal literals that are between 39 and
        # 41 digits long and do not pass the checksum test produce an error. You can prepend (for integer types) or
        # append (for bytesNN types) zeros to remove the error."
        # We can't do a check for hex literals (without changing some parsing code) just do it for any int
        if not self.is_payable and actual_type.is_int() and not actual_type.is_signed and actual_type.size == 160:
            return True

        return False

    def is_builtin(self) -> bool:
        return True

    def is_address(self) -> bool:
        return True


@NodeDataclass
class ByteType(Type):
    """ Single 8bit byte type """

    def __str__(self): return "byte"

    def is_builtin(self) -> bool:
        return True

    def is_byte(self) -> bool:
        return True


@NodeDataclass
class IntType(Type):
    """ Solidity native integer type of various bit length and signedness"""

    is_signed: bool
    """ Whether the type is a signed int or unsigned int """
    size: int
    """ Size of the type in bits """

    def __str__(self): return f"{'int' if self.is_signed else 'uint'}{self.size}"

    def can_implicitly_cast_from(self, actual_type: Type) -> bool:
        if actual_type.is_int():
            # inty(actual_type) to intx(self) if y <= x, same for uint, but not both at the same time
            if actual_type.is_signed == self.is_signed and actual_type.size <= self.size:
                return True

            if actual_type.is_int() and actual_type.is_literal_type() and not actual_type.is_signed:
                # e.g. calling f(1 :: uint8) where f(x: int256)
                return actual_type.real_bit_length < self.size
        return False

    def is_builtin(self) -> bool:
        return True

    def is_int(self) -> bool:
        return True


@NodeDataclass
class PreciseIntType(IntType):
    real_bit_length: int
    value: int

    def is_literal_type(self) -> bool:
        return True

    def __str__(self): return f"{'int' if self.is_signed else 'uint'}{self.size}({self.real_bit_length})"


def UIntType(size=256):
    return IntType(False, size)


def Bytes(size=None):
    if size is not None:
        if isinstance(size, int):
            return FixedLengthArrayType(ByteType(), size)
        elif isinstance(size, Expr):
            return VariableLengthArrayType(ByteType(), size)
        else:
            raise NotImplementedError(f'{type(size)}')
    else:
        return ArrayType(ByteType())


def is_byte_array(ttype: Type) -> bool:
    return isinstance(ttype, ArrayType) and isinstance(ttype.base_type, ByteType)


class BoolType(Type):
    """ Solidity native boolean type"""

    def __str__(self): return "bool"

    def is_builtin(self) -> bool:
        return True


@NodeDataclass
class StringType(ArrayType):
    """ Solidity native string type"""

    # makes this an Array[Byte] (as Solidity uses UTF8 for strings?)
    base_type: Type = field(default=ByteType(), init=False)

    def __str__(self): return "string"

    def is_builtin(self) -> bool:
        return True

    def is_string(self) -> bool:
        return True


@NodeDataclass
class PreciseStringType(StringType):
    """String literal type that has a known length at compile time"""

    real_size: int

    def is_literal_type(self) -> bool:
        return True

    def __str__(self): return f"string({self.real_size})"


@NodeDataclass
class MappingType(Type):
    """ Type that represents a function mapping definition

    For example in the mapping '(uint => Campaign)', src would be 'unit' and the dst would be 'Campaign'
    """
    src: Type
    dst: Type

    def __str__(self): return f"({self.src} => {self.dst})"

    def is_builtin(self) -> bool:
        return False

    def is_mapping(self) -> bool:
        return True

    def flatten(self) -> List[Type]:
        # get a nested mapping types elements in a list
        # e.g. (x => (y => z)) would return [x,y,z]
        result = [self.src]
        next_link = self.dst
        while next_link:
            if next_link.is_mapping():
                result.append(next_link.src)
                next_link = next_link.dst
            else:
                # base case, we hit the end of the chain
                result.append(next_link)
                next_link = None
        return result


@NodeDataclass
class ResolvedUserType(Type):
    # Ref so that we don't set the parent of the TopLevelUnit to this type instance
    value: Ref[TopLevelUnit] = field(repr=False)

    # FIXME: The name of the unit isn't showing in pretty prints for some reason, just outputs ResolvedUserType()

    def __str__(self):
        return f'ResolvedUserType({self.value.x.name.text})'

    def __repr__(self):
        return self.__str__()

    def is_builtin(self) -> bool:
        return False

    def is_user_type(self) -> bool:
        return True

    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        if super().can_implicitly_cast_from(actual_type):
            return True

        if actual_type.is_user_type():
            return actual_type.value.x.is_subttype_of(self.value.x)

        return False

    def get_types_for_declared_type(self) -> List[TopLevelUnit]:
        return [self.value.x] + self.value.x.get_subtypes()


@NodeDataclass
class BuiltinType(Type):
    name: str

    def __str__(self):
        return f'Builtin<{self.name}>'

    def is_builtin(self) -> bool:
        return True


def ABIType() -> BuiltinType:
    return BuiltinType('abi')


@NodeDataclass
class FunctionType(Type):
    inputs: List[Type]
    outputs: List[Type]

    def is_builtin(self) -> bool:
        return False

    def is_function(self) -> bool:
        return True


@NodeDataclass
class TupleType(Type):
    ttypes: List[Type]

    def is_builtin(self) -> bool:
        return False

    def is_tuple(self) -> bool:
        return True


@NodeDataclass
class Error(Type):
    def __str__(self):
        return '<Error>()'


@NodeDataclass
class ContractPart(Node):
    def has_modifier_kind(self, *kinds: Union[solnodes1.VisibilityModifierKind, solnodes1.MutabilityModifierKind]):
        if hasattr(self, 'modifiers'):
            own_kinds = [m.kind for m in self.modifiers if hasattr(m, 'kind')]
            for k in kinds:
                if k in own_kinds:
                    return True
        return False


@NodeDataclass
class InheritSpecifier(Node):
    name: ResolvedUserType
    args: List[Expr]


@NodeDataclass
class LibraryOverride(Node):
    overriden_type: Type
    library: ResolvedUserType


@NodeDataclass
class FileDefinition(TopLevelUnit):
    # This is currently only used for ownerless definitions, i.e. contracts/interfaces/etc don't have this as a parent
    # and this isn't created for most processed source files
    parts: List[ContractPart]


@NodeDataclass
class ContractDefinition(TopLevelUnit):
    is_abstract: bool
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]
    type_overrides: List[LibraryOverride]
    _subtypes: List[Ref[Union['ContractDefinition', 'InterfaceDefinition']]] = field(default_factory=list, init=False, hash=False, compare=False, repr=False)


@NodeDataclass
class InterfaceDefinition(TopLevelUnit):
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]
    type_overrides: List[LibraryOverride]
    _subtypes: List[Ref[Union['ContractDefinition', 'InterfaceDefinition']]] = field(default_factory=list, init=False, hash=False, compare=False, repr=False)


@NodeDataclass
class LibraryDefinition(TopLevelUnit):
    parts: List[ContractPart]
    type_overrides: List[LibraryOverride]


@NodeDataclass
class EnumMember(Node):
    name: Ident


@NodeDataclass
class EnumDefinition(TopLevelUnit):
    values: List[EnumMember]


@NodeDataclass
class StructMember(Node):
    ttype: Type
    name: Ident


@NodeDataclass
class StructDefinition(TopLevelUnit):
    members: List[StructMember]


@NodeDataclass
class ErrorParameter(Node):
    ttype: Type
    name: Ident


@NodeDataclass
class ErrorDefinition(TopLevelUnit, ContractPart):
    inputs: List[ErrorParameter]


@NodeDataclass
class StateVariableDeclaration(ContractPart):
    name: Ident
    ttype: Type
    modifiers: List[Modifier]
    value: Expr


@NodeDataclass
class ConstantVariableDeclaration(ContractPart):
    name: Ident
    ttype: Type
    value: Expr


@NodeDataclass
class EventParameter(Node):
    name: Ident
    ttype: Type
    is_indexed: bool


@NodeDataclass
class EventDefinition(ContractPart):
    name: Ident
    inputs: List[EventParameter]
    is_anonymous: bool


class Location(Enum):
    MEMORY = 'memory'
    STORAGE = 'storage'
    CALLDATA = 'calldata'

    def __str__(self): return self.value


@NodeDataclass
class Var(Node):
    name: Ident
    ttype: Type
    location: Location


@NodeDataclass
class Parameter(Node):
    var: Var


@NodeDataclass
class Block(Stmt):
    stmts: List[Stmt]
    is_unchecked: bool


@NodeDataclass
class If(Stmt):
    condition: Expr
    true_branch: Stmt
    false_branch: Stmt


@NodeDataclass
class Catch(Stmt):
    ident: Ident
    parameters: List[Parameter]
    body: Block


@NodeDataclass
class Try(Stmt):
    expr: Expr
    return_parameters: List[Parameter]
    body: Block
    catch_clauses: List[Catch]


@NodeDataclass
class While(Stmt):
    condition: Expr
    body: Stmt
    is_do_while: bool


@NodeDataclass
class For(Stmt):
    initialiser: Stmt
    condition: Expr
    advancement: Expr
    body: Stmt


@NodeDataclass
class FunctionDefinition(ContractPart):
    name: Ident
    inputs: List[Parameter]
    outputs: List[Parameter]
    modifiers: List[Modifier]
    code: Block


@NodeDataclass
class ModifierDefinition(ContractPart):
    name: Ident
    inputs: List[Parameter]
    modifiers: List[Modifier]
    code: Block


@NodeDataclass
class TupleVarDecl(Stmt):
    vars: List[Var]
    value: Expr


@NodeDataclass
class VarDecl(Stmt):
    var: Var
    value: Expr


@NodeDataclass
class ExprStmt(Stmt):
    expr: Expr


@NodeDataclass
class Literal(Expr):
    value: Any
    ttype: Type
    unit: solnodes1.Unit = None
    
    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class TypeLiteral(Expr):
    ttype: Type

    def type_of(self):
        return self.ttype


@NodeDataclass
class UnaryOp(Expr):
    """ Single operand expression """
    expr: Expr
    op: solnodes1.UnaryOpCode
    is_pre: bool

    def type_of(self) -> Type:
        expr_ttype = self.expr.type_of()
        # FIXME: could be 'delete', never seen it though
        assert expr_ttype.is_int()
        return expr_ttype


@NodeDataclass
class BinaryOp(Expr):
    left: Expr
    right: Expr
    op: solnodes1.BinaryOpCode

    def type_of(self) -> Type:
        if self.op in [solnodes1.BinaryOpCode.BOOL_AND, solnodes1.BinaryOpCode.BOOL_OR, solnodes1.BinaryOpCode.EQ,
                       solnodes1.BinaryOpCode.NEQ]:
            return BoolType()
        elif self.op in [solnodes1.BinaryOpCode.LTEQ, solnodes1.BinaryOpCode.LT, solnodes1.BinaryOpCode.GT,
                         solnodes1.BinaryOpCode.GTEQ]:
            return BoolType()
        elif self.op in [solnodes1.BinaryOpCode.LSHIFT, solnodes1.BinaryOpCode.RSHIFT]:
            # result of a shift has the type of the left operand (from docs)
            return self.left.type_of()
        elif self.op == solnodes1.BinaryOpCode.EXPONENTIATE:
            # result is type of the base
            return self.left.type_of()
        elif self.op in [solnodes1.BinaryOpCode.MUL, solnodes1.BinaryOpCode.DIV, solnodes1.BinaryOpCode.MOD,
                         solnodes1.BinaryOpCode.ADD, solnodes1.BinaryOpCode.SUB,
                         solnodes1.BinaryOpCode.BIT_AND, solnodes1.BinaryOpCode.BIT_OR,
                         solnodes1.BinaryOpCode.BIT_XOR
                         ]:
            t1 = self.left.type_of()
            t2 = self.right.type_of()
            assert t1.can_implicitly_cast_from(t2)
            return t1
        else:
            raise ValueError(f'{self.op}')


@NodeDataclass
class TernaryOp(Expr):
    condition: Expr
    left: Expr
    right: Expr


@NodeDataclass
class SelfObject(Expr):
    declarer: Ref[Union[ContractDefinition, InterfaceDefinition]] = field(repr=False)

    def type_of(self) -> Type:
        return ResolvedUserType(self.declarer)


@NodeDataclass
class SuperType(Type):
    declarer: Ref[Union[ContractDefinition, InterfaceDefinition]] = field(repr=False)

    def is_builtin(self) -> bool:
        return False
    
    def get_types_for_declared_type(self) -> List[TopLevelUnit]:
        # FIXME: return bases
        return self.declarer.x.get_supers()


@NodeDataclass
class SuperObject(Expr):
    ttype: SuperType

    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class StateVarLoad(Expr):
    base: Expr
    name: Ident

    def type_of(self) -> Type:
        base_type = self.base.type_of()
        assert isinstance(base_type, ResolvedUserType)

        unit = base_type.value.x

        if isinstance(unit, StructDefinition):
            matches = [m for m in unit.members if
                       m.name.text == self.name.text and isinstance(m, StructMember)]
        else:
            matches = [p for p in unit.parts if
                       p.name.text == self.name.text and isinstance(p, StateVariableDeclaration)]

        assert len(matches) == 1
        return matches[0].ttype


@NodeDataclass
class ConstVarLoad(Expr):
    var: Ref[ConstantVariableDeclaration]

    def type_of(self) -> Type:
        return self.var.x.ttype


@NodeDataclass
class StaticVarLoad(Expr):
    ttype: ResolvedUserType
    name: Ident


@NodeDataclass
class EnumLoad(Expr):
    member: Ref[EnumMember]

    def type_of(self) -> Type:
        # enum members type is its parent type
        return self.member.x.parent.as_type()


@NodeDataclass
class StateVarStore(Expr):
    base: Expr
    name: Ident
    value: Expr


@NodeDataclass
class LocalVarLoad(Expr):
    var: Var

    def type_of(self) -> Type:
        return self.var.ttype


@NodeDataclass
class LocalVarStore(Expr):
    var: Var
    value: Expr

    def type_of(self) -> Type:
        return self.var.ttype


@NodeDataclass
class ArrayLengthStore(Expr):
    # resizing array length is deprecated since solidity 0.6
    # The expr that loads the array e.g. this.myArray
    base: Expr
    value: Expr

    def type_of(self) -> Type:
        return UIntType(256)


@NodeDataclass
class TupleLoad(Expr):
    base: Expr
    index: int

    def type_of(self) -> Type:
        tuple_type = self.base.type_of()
        assert isinstance(tuple_type, TupleType)

        assert 0 <= self.index < len(tuple_type.ttypes)

        return tuple_type.ttypes[self.index]


@NodeDataclass
class ArrayLoad(Expr):
    base: Expr
    index: Expr

    def type_of(self) -> Type:
        base_type = self.base.type_of()

        if isinstance(base_type, MappingType):
            assert base_type.src == self.index.type_of()
            return base_type.dst
        elif isinstance(base_type, ArrayType):
            assert isinstance(self.index.type_of(), IntType)
            return base_type.base_type
        else:
            raise ValueError(f'unknown base type: f{base_type}')


@NodeDataclass
class ArrayStore(Expr):
    base: Expr
    index: Expr
    value: Expr


@NodeDataclass
class CreateInlineArray(Expr):
    """ Solidity 8 inline array creation

    An inline array is one where the elements are explicitly stated in the definition, for example:
    'int[5]   foo2 = [1, 0, 0, 0, 0];'
    """
    elements: List[Expr]

    def type_of(self) -> Type:
        element_types = [e.type_of() for e in self.elements]
        # need at least 1 element for this call to work, TODO: maybe store the type and decide whether to use it if
        # there are elements
        assert len(element_types) > 0
        assert all([t == element_types[0] for t in element_types])
        return FixedLengthArrayType(element_types[0], len(element_types))


@NodeDataclass
class MappingLoad(Expr):
    base: Expr
    key: Expr


@NodeDataclass
class MappingStore(Expr):
    base: Expr
    key: Expr
    value: Expr


@NodeDataclass
class GlobalValue(Expr):
    name: str
    ttype: Type

    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class ABISelector(Expr):
    function: Ref[FunctionDefinition]

    def type_of(self) -> Type:
        return Bytes(4)

    def __str__(self):
        f = self.function.x
        owner_name = f.parent.source_unit_name
        return f'{owner_name}.{f.name.text}.selector'


@NodeDataclass
class DynamicBuiltInValue(Expr):
    # <base>.name
    name: str
    ttype: Type
    base: Expr

    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class CreateMemoryArray(Expr):
    ttype: ArrayType
    size: Expr

    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class CreateStruct(Expr):
    ttype: ResolvedUserType
    args: List[Expr]

    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class CreateAndDeployContract(Expr):
    ttype: ResolvedUserType
    named_args: List[NamedArgument]
    args: List[Expr]

    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class Call(Expr):
    named_args: List[NamedArgument]
    args: List[Expr]

    def check_arg_types(self, f: FunctionDefinition) -> bool:
        f_types = [x.var.ttype for x in f.inputs]
        c_types = [a.type_of() for a in self.args]
        return Type.are_matching_types(f_types, c_types)


@NodeDataclass
class DirectCall(Call):
    ttype: ResolvedUserType
    name: Ident

    def resolve_call(self) -> FunctionDefinition:
        unit = self.ttype.value.x
        matching_name_funcs = [p for p in unit.parts if isinstance(p, FunctionDefinition) and p.name.text == self.name.text]
        matching_param_types = [f for f in matching_name_funcs if self.check_arg_types(f)]
        assert len(matching_param_types) == 1
        return matching_param_types[0]

    def type_of(self) -> Type:
        target_callee = self.resolve_call()
        if len(target_callee.outputs) > 1:
            # For functions that return multiple values return (t(r1), ... t(rk))
            ttype = TupleType([out_param.var.ttype for out_param in target_callee.outputs])
        else:
            ttype = target_callee.outputs[0].var.ttype
        return ttype


# x.y
@NodeDataclass
class FunctionCall(Call):
    base: Expr
    name: Ident

    def resolve_call(self) -> FunctionDefinition:
        if isinstance(self.base, SuperObject):
            # E.g. super.xyz()
            # First element will be the base type which we don't want to include in the MRO as its super call lookup
            ref_lookup_order = c3_linearise(self.base.declarer.x)[1:]
        else:
            # e.g. this.xyz() or abc.xyz()
            ref_lookup_order = c3_linearise(self.base.type_of().value.x)

        for unit in ref_lookup_order:
            matching_name_funcs = [p for p in unit.parts if isinstance(p, FunctionDefinition) and p.name.text == self.name.text]
            matching_param_types = [f for f in matching_name_funcs if self.check_arg_types(f)]
            if len(matching_param_types) == 1:
                return matching_param_types[0]
            elif len(matching_param_types) > 1:
                assert False, 'Too many matches'

        raise ValueError('No match')

    def type_of(self) -> Type:
        target_callee = self.resolve_call()
        if len(target_callee.outputs) > 1:
            # For functions that return multiple values return (t(r1), ... t(rk))
            ttype = TupleType([out_param.var.ttype for out_param in target_callee.outputs])
        else:
            ttype = target_callee.outputs[0].var.ttype
        return ttype


@NodeDataclass
class FunctionPointerCall(Call):
    callee: Expr

    def type_of(self) -> Type:
        callee_ttype: FunctionType = self.callee.type_of()
        output_ttypes = callee_ttype.outputs
        assert len(output_ttypes) > 0

        if len(output_ttypes) == 1:
            return output_ttypes[0]
        else:
            return TupleType(output_ttypes)


@NodeDataclass
class DynamicBuiltInCall(Call):
    ttype: Type
    base: Expr
    name: str

    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class BuiltInCall(Call):
    name: str
    ttype: Type

    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class Cast(Expr):
    ttype: Type
    value: Expr

    def type_of(self) -> Type:
        return self.ttype


@NodeDataclass
class MetaTypeType(Type):
    # type of a Solidity type, i.e. the type of type(X). This type has a few builtin fields such as min, max, name,
    # creationCode, runtimeCode and interfaceId
    ttype: Type

    def is_builtin(self) -> bool:
        return self.ttype.is_builtin()


@NodeDataclass
class GetType(Expr):
    # type(MyContract)
    ttype: Type

    def type_of(self) -> Type:
        return MetaTypeType(self.ttype)


@NodeDataclass
class GetFunctionPointer(Expr):
    func: Ref[FunctionDefinition]


@NodeDataclass
class EmitEvent(Stmt):
    event: Ref[EventDefinition]
    args: List[Expr]


@NodeDataclass
class Revert(Stmt):
    pass


@NodeDataclass
class RevertWithError(Revert):
    error: Ref[ErrorDefinition]
    args: List[Expr]


@NodeDataclass
class RevertWithReason(Revert):
    reason: Expr


@NodeDataclass
class Require(Stmt):
    condition: Expr
    reason: Expr


@NodeDataclass
class Return(Stmt):
    values: List[Expr]


class Continue(Stmt):
    pass


class Break(Stmt):
    pass


@NodeDataclass
class Assembly(Stmt):
    # TODO: full assembly code representation
    code: str


@NodeDataclass
class ExecModifiedCode(Stmt):
    # _; statement in modifier code bodies that show where modified function code gets executed
    pass
