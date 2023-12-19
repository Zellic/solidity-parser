from dataclasses import dataclass, field
from enum import Enum
from typing import List, Any, Union, Optional
from abc import ABC, abstractmethod


class Node:
    location: str
    "LineNumber:LinePosition, this is set dynamically in common.make"
    comments: List[str]

    def __post_init__(self):
        for child in self.get_children():
            child.parent = self

    def get_children(self):
        parent = self.parent if hasattr(self, 'parent') else None

        for val in vars(self).values():
            if parent and val is parent:
                continue

            if isinstance(val, Node):
                yield val
            elif isinstance(val, (list, tuple)):
                yield from [v for v in val if isinstance(v, Node)]

    def get_all_children(self):
        for direct_child in self.get_children():
            yield direct_child
            yield from direct_child.get_all_children()

    def linenumber(self) -> int:
        return int(self.location.split(":")[0])

    def source_location(self):
        if hasattr(self, 'scope') and self.scope:
            from solidity_parser.ast.symtab import FileScope
            file_scope = self.scope.find_first_ancestor_of(FileScope)
            file_name = file_scope.source_unit_name
        else:
            file_name = '<unknown>'
        return f'{file_name} @{self.location}'

    def offset(self) -> int:
        return int(self.location.split(":")[1])


class Stmt(Node):
    pass


class Expr(Node):
    pass


@dataclass
class Ident(Expr):
    """ String identifier node """
    text: str

    def __str__(self): return self.text


class Type(Node, ABC):
    """ Base class for all Solidity types """

    @abstractmethod
    def __str__(self):
        pass

    def is_array(self) -> bool:
        return False

    def is_string(self) -> bool:
        return False

    def is_function(self) -> bool:
        return False

    def is_int(self) -> bool:
        return False

    def is_mapping(self) -> bool:
        return False

    def is_address(self) -> bool:
        return False

    def type_key(self):
        return str(self)


@dataclass
class ArrayType(Type):
    """ Single dimension array type with no size attributes """
    base_type: Type

    def __str__(self): return f"{self.base_type}[]"

    def is_array(self) -> bool:
        return True


@dataclass
class FixedLengthArrayType(ArrayType):
    """ Array type with a known length that is determined at compile time """
    size: int

    def __str__(self): return f"{self.base_type}[{self.size}]"


@dataclass
class VariableLengthArrayType(ArrayType):
    """ Array type with a length that is determined at runtime"""
    size: Expr

    def __str__(self): return f"{self.base_type}[{self.size}]"


@dataclass
class AddressType(Type):
    """ Solidity address/address payable type """
    is_payable: bool

    def __str__(self): return f"address{' payable' if self.is_payable else ''}"

    def is_address(self) -> bool:
        return True


@dataclass
class ByteType(Type):
    """ Single 8bit byte type """

    def __str__(self): return "byte"


@dataclass
class BytesType(ArrayType):
    base_type: Type = field(default_factory=ByteType, init=False)

    def __str__(self): return 'bytes'


@dataclass
class IntType(Type):
    """ Solidity native integer type of various bit length and signedness"""

    is_signed: bool
    """ Whether the type is a signed int or unsigned int """
    size: int
    """ Size of the type in bits """

    def __str__(self): return f"{'int' if self.is_signed else 'uint'}{self.size}"

    def is_int(self) -> bool:
        return True


class BoolType(Type):
    """ Solidity native boolean type"""

    def __str__(self): return "bool"


class StringType(Type):
    """ Solidity native string type"""

    def __str__(self): return "string"

    def is_array(self) -> bool:
        return True

    def is_string(self) -> bool:
        return True


class VarType(Type):
    """ Type that wasn't explicitly identified in the code

    This type should not be used without running a subsequent type inference pass.

    An example variable declaration that would use this type symbol: 'var (, mantissa, exponent) = ... '
    """

    # I've only seen this once in ~10000 contracts where a contract used the 'var' keyword

    def __str__(self): return "var"


class AnyType(Type):
    """ Type that is used only in 'using' declarations to specify that the declaration is overriding all possible types

    For example in the declaration 'using SomeLibrary for *', the overriden type here is AnyType(every type
    that is imported from SomeLibrary)
    """

    def __str__(self): return "*"


@dataclass
class MappingType(Type):
    """ Type that represents a function mapping definition

    For example in the mapping '(uint x => Campaign c)', src would be 'unit' and the dst would be 'Campaign',
    src_key would be 'x' and dst_key would be 'c'
    """
    src: Type
    dst: Type
    src_name: Ident = None
    dst_name: Ident = None

    def __str__(self):
        def _name(ident):
            return (' ' + str(ident)) if ident else ''
        return f"({self.src}{_name(self.src_name)} => {self.dst}{_name(self.dst_name)})"

    def is_mapping(self) -> bool:
        return True


class Location(Enum):
    """ Solidity reference type storage locations

    These are used to specify in what type of memory context/area a struct/array/mapping is stored
    """

    MEMORY = 'memory'
    """ An location that does not persist between function calls """

    STORAGE = 'storage'
    """ A location persists between function calls
    
    Contract state variables are stored here also
    """

    CALLDATA = 'calldata'
    """ A location that contains the function call arguments for external function call parameters """

    def __str__(self): return self.value


@dataclass
class UserType(Type):
    """ Type invoked using a valid Solidity reference, e.g. a class, contract, library, enum, etc name"""
    name: Ident

    def __str__(self): return str(self.name)


class NoType(Type):
    def __str__(self):
        return '<no_type>'


@dataclass
class NamedArg(Expr):
    """ A name-value pair used for calling functions with options """
    name: Ident
    value: Expr


class Unit(Enum):
    """ Solidity numerical unit types """
    WEI = ('wei', 1)
    GWEI = ('gwei', 1e9)
    SZABO = ('szabo', 1e12)
    FINNEY = ('finney', 1e15)
    ETHER = ('ether', 1e18)
    SECONDS = ('seconds', 1)
    MINUTES = ('minutes', 60)
    HOURS = ('hours', 60*60)
    DAYS = ('days', 24*60*60)
    WEEKS = ('weeks', 7*24*60*60)
    # Take care if you perform calendar calculations using these units, because not every year equals 365 days and not
    # even every day has 24 hours because of leap seconds. Due to the fact that leap seconds cannot be predicted,
    # an exact calendar library has to be updated by an external oracle.
    # The suffix years has been removed in version 0.5.0 due to the reasons above.
    YEARS = ('years', 7*24*60*60*365)

    def __new__(cls, *args, **kwargs):
        obj = object.__new__(cls)
        obj._value_ = args[0]
        return obj

    # ignore the first param since it's already set by __new__
    def __init__(self, _: str, multiplier: int):
        self._multiplier_ = multiplier

    def __str__(self):
        return self.value

    # this makes sure that the multiplier is read-only
    @property
    def multiplier(self) -> int:
        return self._multiplier_


@dataclass
class Literal(Expr):
    """ Constant value expression that can have an optional unit associated with it

    The value may be a python primitive, e.g. an integer, boolean, string, tuple, etc """
    value: Any
    unit: Unit = None


class UnaryOpCode(Enum):
    """ Single operand operation types"""
    INC = '++'
    DEC = '--'
    SIGN_POS = '+'
    SIGN_NEG = '-'
    BOOL_NEG = '!'
    BIT_NEG = '~'
    DELETE = 'delete'


@dataclass
class UnaryOp(Expr):
    """ Single operand expression """
    expr: Expr
    op: UnaryOpCode
    is_pre: bool
    """ Whether the operation is pre or post, e.g. ++x or x++ """


class BinaryOpCode(Enum):
    """ Binary/two operand operation types, including assignment types """
    EXPONENTIATE = '**'
    MUL = '*'
    DIV = '/'
    MOD = '%'
    ADD = '+'
    SUB = '-'

    LSHIFT = '<<'
    RSHIFT = '>>'
    BIT_AND = '&'
    BIT_XOR = '^'
    BIT_OR = '|'

    LT = '<'
    GT = '>'
    LTEQ = '<='
    GTEQ = '>='
    EQ = '=='
    NEQ = '!='

    BOOL_AND = '&&'
    BOOL_OR = '||'

    ASSIGN = '='
    ASSIGN_OR = '|='
    ASSIGN_BIT_NEG = '^='
    ASSIGN_BIT_AND = '&='
    ASSIGN_LSHIFT = '<<='
    ASSIGN_RSHIFT = '>>='
    ASSIGN_ADD = '+='
    ASSIGN_SUB = '-='
    ASSIGN_MUL = '*='
    ASSIGN_DIV = '/='
    ASSIGN_MOD = '%='


@dataclass
class BinaryOp(Expr):
    """ Binary/two operand expression """
    left: Expr
    right: Expr
    op: BinaryOpCode


@dataclass
class TernaryOp(Expr):
    """ Choice expression that evaluates the given condition and returns one of the two given expressions

    If the condition evaluates to false then the left expression is returned, otherwise the right one is
    """
    condition: Expr
    left: Expr
    right: Expr


@dataclass
class New(Expr):
    """ New object allocation expression without constructor invocation

    Note that this expression only represents the 'new X' part of a new objects creation 'new X(a,b)'.
    This expression must then be used as the base object in a constructor call to instantiate it.

    """
    type_name: Type


@dataclass
class NewInlineArray(Expr):
    """ Solidity 8 inline array creation

    An inline array is one where the elements are explicitly stated in the definition, for example:
    'int[5]   foo2 = [1, 0, 0, 0, 0];'
    """
    elements: List[Expr]


@dataclass
class PayableConversion(Expr):
    """ Converts an address to a payable address

    For example: 'payable(address(myAddressHex))'
    """
    args: List[Expr]


@dataclass
class GetArrayValue(Expr):
    """ Gets the value at the given index from the given array """
    array_base: Expr
    index: Expr


@dataclass
class GetArraySlice(Expr):
    """ Gets a subarray at the given start and end indices from the given array """
    array_base: Expr
    start_index: Expr
    end_index: Expr


@dataclass
class GetMember(Expr):
    """ Gets a member field or method from a given object """
    obj_base: Expr
    name: Ident


@dataclass
class CallFunction(Expr):
    """ Invokes a function """
    callee: Expr
    """ This callee is most likely a GetMember expression but can be any callable """
    modifiers: List
    args: List[Expr]


@dataclass
class Var(Node):
    var_type: Type
    var_name: Ident
    var_loc: Optional[Location] = None


@dataclass
class VarDecl(Stmt):
    variables: List[Var]
    value: Expr
    is_lhs_tuple: bool = False


@dataclass
class Parameter(Node):
    var_type: Ident
    var_loc: Location
    var_name: Ident

    def __str__(self):
        return f"{self.var_type} { self.var_loc.value +  ' ' if self.var_loc else ''}{self.var_name if self.var_name else '<unnamed>'}"


@dataclass
class ExprStmt(Stmt):
    expr: Expr


@dataclass
class Block(Stmt):
    stmts: List[Stmt]
    is_unchecked: bool = False


@dataclass
class If(Stmt):
    condition: Expr
    true_branch: Stmt
    false_branch: Stmt


@dataclass
class Catch(Stmt):
    ident: Ident
    parameters: List[Parameter]
    body: Block


@dataclass
class Try(Stmt):
    expr: Expr
    return_parameters: List[Parameter]
    body: Block
    catch_clauses: List[Catch]


@dataclass
class While(Stmt):
    expr: Expr
    body: Stmt


@dataclass
class For(Stmt):
    initialiser: Stmt  # TODO might also be ExprStmt or VarDecl
    condition: Expr
    advancement: Expr
    body: Stmt


@dataclass
class Emit(Stmt):
    call: CallFunction


@dataclass
class Revert(Stmt):
    call: CallFunction


@dataclass
class AssemblyStmt(Stmt):
    # TODO: full assembly code representation
    code: str


@dataclass
class DoWhile(Stmt):
    body: Stmt
    condition: Expr


class Continue(Stmt):
    pass


class Break(Stmt):
    pass


@dataclass
class Return(Stmt):
    value: Expr


@dataclass
class Throw(Stmt):
    pass


@dataclass
class Modifier(Node):
    pass


class VisibilityModifierKind(Enum):
    EXTERNAL = 'external'
    PUBLIC = 'public'
    INTERNAL = 'internal'
    PRIVATE = 'private'
    VIRTUAL = 'virtual'


class MutabilityModifierKind(Enum):
    PURE = 'pure'
    CONSTANT = 'constant'
    VIEW = 'view'
    PAYABLE = 'payable'
    IMMUTABLE = 'immutable'


@dataclass
class VisibilityModifier2(Modifier):
    kind: VisibilityModifierKind


@dataclass
class MutabilityModifier2(Modifier):
    kind: MutabilityModifierKind


@dataclass
class InvocationModifier(Modifier):
    name: Ident
    arguments: List[Expr]


@dataclass
class OverrideSpecifier(Modifier):
    arguments: List[UserType]


class SourceUnit(Node):
    pass


@dataclass
class PragmaDirective(SourceUnit):
    name: Ident
    value: Union[str, Expr]


@dataclass
class ImportDirective(SourceUnit):
    path: str


@dataclass
class GlobalImportDirective(ImportDirective):
    pass


@dataclass
class UnitImportDirective(ImportDirective):
    alias: Ident


@dataclass
class SymbolAlias(Node):
    symbol: Ident
    alias: Ident


@dataclass
class SymbolImportDirective(ImportDirective):
    aliases: List[SymbolAlias]


@dataclass
class ContractPart(Node):
    pass


class SpecialFunctionKind(Enum):
    CONSTRUCTOR = '<<constructor>>'
    RECEIVE = '<<receive>>'
    FALLBACK = '<<fallback>>'

    def __str__(self):
        return self.value[2:-2]


@dataclass
class FunctionDefinition(SourceUnit, ContractPart):
    name: Union[Ident, SpecialFunctionKind]
    parameters: List[Parameter]
    modifiers: List[Modifier]
    returns: List[Parameter]
    code: Block


@dataclass
class ModifierDefinition(ContractPart):
    name: Ident
    parameters: List[Parameter]
    modifiers: List[Modifier]
    code: Block


@dataclass
class StructMember(Node):
    member_type: Type
    name: Ident


@dataclass
class StructDefinition(SourceUnit, ContractPart):
    name: Ident
    members: List[StructMember]


@dataclass
class EnumDefinition(SourceUnit, ContractPart):
    name: Ident
    values: List[Ident]


@dataclass
class StateVariableDeclaration(ContractPart):
    var_type: Type
    modifiers: List[Modifier]
    name: Ident
    initial_value: Expr


@dataclass
class ConstantVariableDeclaration(SourceUnit):
    var_type: Type
    name: Ident
    initial_value: Expr


@dataclass
class UserValueType(SourceUnit, ContractPart):
    name: Ident
    value: Type


@dataclass
class EventParameter(Node):
    var_type: Type
    name: Ident
    is_indexed: bool


@dataclass
class EventDefinition(ContractPart):
    name: Ident
    is_anonymous: bool
    parameters: List[EventParameter]


@dataclass
class ErrorParameter(Node):
    var_type: Type
    name: Ident


@dataclass
class ErrorDefinition(SourceUnit, ContractPart):
    name: Ident
    parameters: List[ErrorParameter]


@dataclass
class UsingAttachment(Node):
    member_name: Ident


@dataclass
class UsingOperatorBinding(Node):
    member_name: Ident
    operator: Union[UnaryOpCode, BinaryOpCode]


@dataclass
class UsingDirective(ContractPart):
    library_name: Ident
    # either override_type or bindings is allowed but not both at the same time
    override_type: Type
    attachments_or_bindings: List[Union[UsingAttachment, UsingOperatorBinding]] = field(default_factory=list)
    is_global: bool = field(default=False)


@dataclass
class InheritSpecifier(Node):
    name: UserType
    args: List[Expr]


@dataclass
class ContractDefinition(SourceUnit):
    name: Ident
    is_abstract: bool
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]


@dataclass
class InterfaceDefinition(SourceUnit):
    name: Ident
    inherits: List[InheritSpecifier]
    parts: List[ContractPart]


@dataclass
class LibraryDefinition(SourceUnit):
    name: Ident
    parts: List[ContractPart]


@dataclass
class CreateMetaType(Expr):
    base_type: Type


@dataclass
class FunctionType(Type):
    parameters: List[Parameter]
    modifiers: List[Modifier]
    return_parameters: List[Parameter]

    def __str__(self):
        # TODO
        return f'FT'

    def is_function(self) -> bool:
        return True


def has_modifier_kind(node, *kinds: Union[VisibilityModifierKind, MutabilityModifierKind]):
    if hasattr(node, 'modifiers'):
        own_kinds = [m.kind for m in node.modifiers if hasattr(m, 'kind')]
        for k in kinds:
            if k in own_kinds:
                return True
    return False
