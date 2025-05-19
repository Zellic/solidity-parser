from abc import ABC, abstractmethod
from dataclasses import field
from solidity_parser.ast.nodebase import NodeDataclass, Node


@NodeDataclass
class Type(Node, ABC):
    scope: 'Scope' = field(default=None, init=False, repr=False, compare=False, hash=False)
    """
    Shim for symbol table scoping. The scope field is also defined in solnodes1 Node but since this base  class is 
    defined in this file, it must be defined here as well
    """

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
        """ Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc """
        return False

    def is_array(self) -> bool:
        return False

    def is_byte_array(self) -> bool:
        """ Check if the type is any type of byte array, e.g. bytes, bytes1, bytes32 """
        return (isinstance(self, ArrayType) and isinstance(self.base_type, ByteType)) or isinstance(self, BytesType)

    def is_byte_array_underlying(self) -> bool:
        """ Check if this type is logically an array of bytes, e.g. bytes, bytes1, bytes32 and string """
        return self.is_byte_array() or self.is_string()

    def is_string(self) -> bool:
        return False

    def is_function(self) -> bool:
        return False

    def is_int(self) -> bool:
        return False

    def is_bool(self) -> bool:
        return False

    def is_user_type(self) -> bool:
        """ Check if the type is a user defined type, e.g. struct, enum, contract, etc """
        return False

    def is_user_error(self) -> bool:
        """ Check if the type is defined by a user defined Error function """
        return False

    def is_address(self) -> bool:
        return False

    def is_mapping(self) -> bool:
        return False

    def is_byte(self) -> bool:
        """ Check if the type is a single "byte" """
        return False

    def is_tuple(self) -> bool:
        """ Check if the type is a tuple. These are synthetic types in Solidity but can be used in ASTs """
        return False

    def is_literal_type(self) -> bool:
        """ Check if the type is a literal type, i.e. an inferred type from a constant number or string expression.
            These are not real types in Solidity but are used in solc to aid type inference and optimization rules
        """
        return False

    def is_float(self) -> bool:
        """ Check whether this type is a compile time float"""
        return False

    def is_void(self) -> bool:
        """ Check if the type represents a void return type. This isn't part of Solidity directly but is represented
            when a function doesn't define any return types
        """
        return False

    def type_key(self, *args, **kwargs):
        """ Returns a unique key for the type that can be used to cache types in the symbol table """
        return self.code_str()

    @abstractmethod
    def __str__(self):
        pass

    def code_str(self):
        """ Returns the string representation of the type in Solidity syntax"""
        pass


@NodeDataclass
class FloatType(Type):
    """
    This is not a real type in valid Solidity code but the Solidity compiler allows compile time expression evaluation
    of floats
    """

    value: float
    """ Since the value is always known at compile time, we have it here """

    def is_float(self) -> bool:
        return True

    def __str__(self):
        return 'float'

    def code_str(self):
        return str(self)

    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        if super().can_implicitly_cast_from(actual_type):
            return True
        return actual_type.is_float()

    def type_key(self, *args, **kwargs):
        raise ValueError('Float types do not have a type key')


@NodeDataclass
class VoidType(Type):
    def is_void(self) -> bool:
        return True

    def is_builtin(self) -> bool:
        return True

    def code_str(self):
        return str(self)

    def __str__(self):
        return '<void>'

    def type_key(self, *args, **kwargs):
        raise ValueError('Void types do not have a type key')


@NodeDataclass
class ArrayType(Type):
    """ Single dimension array type with no size attributes"""
    base_type: Type

    def __str__(self): return f"{self.base_type}[]"

    def code_str(self): return f'{self.base_type.code_str()}[]'
    
    def type_key(self, name_resolver=None, *args, **kwargs):
        return f"{self.base_type.type_key(name_resolver, *args, **kwargs)}[]"

    def is_builtin(self) -> bool:
        # e.g. byte[] is builtin, string[] is builtin, MyContract[] is not
        return self.base_type.is_builtin()

    def can_implicitly_cast_from(self, actual_type: Type) -> bool:
        if super().can_implicitly_cast_from(actual_type):
            return True
        if not self.has_size() and actual_type.is_array() and actual_type.has_size():
            # i.e. FixedLengthArrayType/VariableLengthArrayType can cast to the base ArrayType (but not each other)
            # e.g. byte[4] casts to byte[] but not the other way around
            return self.base_type.can_implicitly_cast_from(actual_type.base_type)
        if self.base_type.is_byte() and not self.has_size() and actual_type.is_literal_type():
            if self.is_string() == actual_type.is_string():
                return True
            if self.is_int() == actual_type.is_int():
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

    def code_str(self):
        return f'{self.base_type.code_str()}[{str(self.size)}]'
    
    def type_key(self, name_resolver=None, *args, **kwargs):
        return f"{self.base_type.type_key(name_resolver, *args, **kwargs)}[{str(self.size)}]"
    
    def is_fixed_size(self) -> bool:
        return True

    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        if super().can_implicitly_cast_from(actual_type):
            return True
        if not self.is_string() and self.base_type.is_byte() and actual_type.is_int() and actual_type.is_literal_type():
            # Decimal number literals cannot be implicitly converted to fixed-size byte arrays. Hexadecimal number literals
            # can be, but only if the number of hex digits exactly fits the size of the bytes type. As an exception both
            # decimal and hexadecimal literals which have a value of zero can be converted to any fixed-size bytes type:
            return self.size >= (actual_type.size / 8)
        if self.base_type.is_byte() and actual_type.is_string() and actual_type.is_literal_type():
            # e.g. bytes32 samevar = "stringliteral"
            return self.size >= actual_type.real_size

        return False


@NodeDataclass
class VariableLengthArrayType(ArrayType):
    """ Array type with a length that is determined at runtime"""
    size: 'Expr'

    def __str__(self): return f"{self.base_type}[{self.size}]"

    def code_str(self):
        return f'{self.base_type.code_str()}[{self.size.code_str()}]'

    def type_key(self, name_resolver=None, *args, **kwargs):
        # the size bit is a bit tricky as it might not be a literal, just stringify it for now
        return f"{self.base_type.type_key(name_resolver, *args, **kwargs)}[{self.size.code_str()}]"


@NodeDataclass
class AddressType(Type):
    """ Solidity address/address payable type, functionally this is a uint160"""
    is_payable: bool

    def __str__(self): return f"address{' payable' if self.is_payable else ''}"

    def code_str(self):
        return 'address' + (' payable' if self.is_payable else '')

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

    def code_str(self):
        return 'byte'


def UIntType(size=256):
    return IntType(False, size)


def Bytes(size=None):
    if size is not None:
        if isinstance(size, int):
            return FixedLengthArrayType(ByteType(), size)
        else:
            return VariableLengthArrayType(ByteType(), size)
        # elif isinstance(size, Expr):
        #     return VariableLengthArrayType(ByteType(), size)
        # else:
        #     raise NotImplementedError(f'{type(size)}')
    else:
        return BytesType()


@NodeDataclass
class BytesType(ArrayType):
    """ bytes type only (similar but not equal to byte[]/bytes1[]) """
    base_type: Type = field(default_factory=lambda: Bytes(1), init=False)

    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        # don't have anything in AST1 to mark whether the literal is a hex or dec int so we do the
        # conversion regardless
        # e.g. bytes public c = hex"11"; is allowed but bytes public c = 0x11; is NOT
        if actual_type.is_literal_type() and actual_type.is_int():
            return True
        return super().can_implicitly_cast_from(actual_type)

    def __str__(self):
        return 'bytes'

    def code_str(self):
        return 'bytes'

    def type_key(self, *args, **kwargs):
        return 'bytes'


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

    def code_str(self):
        return ('u' if not self.is_signed else '') + 'int' + str(self.size)


@NodeDataclass
class PreciseIntType(IntType):
    real_bit_length: int

    def is_literal_type(self) -> bool:
        return True

    def __str__(self): return f"{'int' if self.is_signed else 'uint'}{self.size}({self.real_bit_length})"

    def code_str(self):
        return str(self)


class BoolType(Type):
    """ Solidity native boolean type"""

    def __str__(self): return "bool"

    def is_builtin(self) -> bool:
        return True

    def is_bool(self) -> bool:
        return True

    def code_str(self):
        return 'bool'


@NodeDataclass
class StringType(ArrayType):
    """ Solidity native string type"""

    # makes this an Array[Byte] (as Solidity uses UTF8 for strings?)
    base_type: Type = field(default_factory=lambda: Bytes(1), init=False)

    def __str__(self): return "string"

    def code_str(self):
        return 'string'

    def type_key(self, *args, **kwargs):
        return 'string'

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

    def has_size(self) -> bool:
        # ArrayType.has_size() checks if we have a 'size' attribute, but we don't: it's called
        # real_size(), so this shim fixes that.
        # This allows e.g. PreciseStringType of length 1 to be implicitly castable to the base StringType
        return True

    def __str__(self): return f"string({self.real_size})"

    def code_str(self):
        return str(self)


@NodeDataclass
class MappingType(Type):
    """ Type that represents a function mapping definition

    For example in the mapping '(uint x => Campaign c)', src would be 'unit' and the dst would be 'Campaign',
    src_key would be 'x' and dst_key would be 'c'
    """
    src: Type
    dst: Type
    src_name: 'Ident' = None
    dst_name: 'Ident' = None

    def __str__(self):
        def _name(ident):
            return (' ' + str(ident)) if ident else ''
        return f"({self.src}{_name(self.src_name)} => {self.dst}{_name(self.dst_name)})"

    def code_str(self):
        return str(self)

    def type_key(self, name_resolver=None, *args, **kwargs):
        return f"({self.src.type_key(name_resolver, *args, **kwargs)} => {self.dst.type_key(name_resolver, *args, **kwargs)})"

    def is_mapping(self) -> bool:
        return True

    def flatten(self) -> list[Type]:
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
class UserType(Type):
    """
    Type invoked using a valid Solidity reference, e.g. a class, contract, library, enum, etc name.
    This is an "unlinked" type, e.g. it has no underlying AST node backing it and has no corresponding context other
    than the scope it was declared in. For AST2 use solnodes2.ResolvedUserType instead.
    """
    name: 'Ident'

    def __str__(self): return str(self.name)

    def type_key(self, name_resolver=None, *args, **kwargs):
        if name_resolver is None:
            raise ValueError(f'Cannot resolve {self.name} without a name resolver')
        else:
            return name_resolver(self.scope, self.name.text)


@NodeDataclass
class BuiltinType(Type):
    """
    Type representing types of Solidity builtin objects, e.g. the type of the 'msg' or 'abi' objects in the expressions
    `msg.sender` or `abi.decode(...)`
    """
    name: str

    def __str__(self):
        return f'Builtin<{self.name}>'

    def is_builtin(self) -> bool:
        return True

    def code_str(self):
        return self.name


def ABIType() -> BuiltinType:
    return BuiltinType('abi')


@NodeDataclass
class FunctionParameter(Node):
    """
    Shim: see Type to understand why
    """
    name: 'Ident'
    ttype: Type
    scope: 'Scope' = field(default=None, init=False, repr=False, compare=False, hash=False)


@NodeDataclass
class FunctionType(Type):
    input_params: list[FunctionParameter]
    # TODO: maybe outputs need to use NamedType as well, unsure
    outputs: list[Type]
    # "By default, function types are internal, so the internal keyword can be omitted. Note that this only applies to
    # function types. Visibility has to be specified explicitly for functions defined in contracts, they do not have a
    # default."
    modifiers: list['Modifier']

    def is_builtin(self) -> bool:
        return False

    def is_function(self) -> bool:
        return True

    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        if super().can_implicitly_cast_from(actual_type):
            return True

        # Conversions:
        # A function type A is implicitly convertible to a function type B if and only if their parameter types are
        # identical, their return types are identical, their internal/external property is identical and the state
        # mutability of A is more restrictive than the state mutability of B. In particular:
        #     pure functions can be converted to view and non-payable functions
        #     view functions can be converted to non-payable functions
        #     payable functions can be converted to non-payable functions
        # No other conversions between function types are possible

        if actual_type.is_function():
            if len(actual_type.input_params) != len(self.input_params):
                return False
            return all([t1.ttype == t2.ttype for t1, t2 in zip(self.input_params, actual_type.input_params)])

        return False

    def code_str(self):
        # function (<parameter types>) {internal|external} [pure|view|payable] [returns (<return types>)]
        if self.input_params is None:
            input_params = '<polymorphic>'
        else:
            input_params = ", ".join(t.code_str() for t in self.input_params)

        if self.outputs is None:
            output_params = '<polymorphic>'
        else:
            output_params = ", ".join(t.code_str() for t in self.outputs)

        return f'function ({input_params}) returns ({output_params})'

    def __str__(self):
        return self.code_str()

    def type_key(self, name_resolver=None, *args, **kwargs):
        # doesn't include modifiers for now
        if self.input_params is None:
            input_params = '<polymorphic>'
        else:
            input_params = ', '.join([p.ttype.type_key(name_resolver, *args, **kwargs) for p in self.input_params])

        if self.outputs is None:
            output_params = '<polymorphic>'
        else:
            output_params = ', '.join([p.type_key(name_resolver, *args, **kwargs) for p in self.outputs])
        return f'function ({input_params}) returns ({output_params})'


@NodeDataclass
class ErrorType(Type):
    # for now this type only occurs as a type filter for the 0.8.26 require() builtin that takes an error "object" as an arg
    def __str__(self):
        return '<err>'
    def is_builtin(self) -> bool:
        return False
    def code_str(self):
        raise ValueError('ErrorType is not a printable')
    def type_key(self, *args, **kwargs):
        raise ValueError('ErrorType does not have a type key')
    def can_implicitly_cast_from(self, actual_type: 'Type') -> bool:
        if super().can_implicitly_cast_from(actual_type):
            return True
        return actual_type.is_user_error()

@NodeDataclass
class TupleType(Type):
    """
    Type of a tuple of elements. This is not a real Solidity type but is used to represent the type of tuple expressions
     (e.g. desugaring) in the AST
    """
    ttypes: list[Type]

    def is_builtin(self) -> bool:
        return False

    def is_tuple(self) -> bool:
        return True

    def code_str(self):
        return f'({", ".join(t.code_str() for t in self.ttypes)})'

    def __str__(self):
        return f'({", ".join(str(t) for t in self.ttypes)})'

    def type_key(self, name_resolver=None, *args, **kwargs):
        return f'({", ".join(t.type_key(name_resolver, *args, **kwargs) for t in self.ttypes)})'


@NodeDataclass
class MetaTypeType(Type):
    """
    Metatype Solidity type, i.e. type(X). This type has a few builtin fields such as min, max, name, creationCode,
    runtimeCode and interfaceId
    """
    ttype: Type

    def is_builtin(self) -> bool:
        # TODO: are these all builtin types irregardless?
        return self.ttype.is_builtin()

    def code_str(self):
        return f'type({self.ttype.code_str()})'

    def __str__(self):
        return f'type({self.ttype})'

    # TODO: metatype typekey


@NodeDataclass
class VarType(Type):
    """ Type that wasn't explicitly identified in the code

    This type should not be used without running a subsequent type inference pass.

    An example variable declaration that would use this type symbol: 'var (, mantissa, exponent) = ... '
    """

    # I've only seen this once in ~10000 contracts where a contract used the 'var' keyword

    def __str__(self): return "var"

    def type_key(self, name_resolver=None, *args, **kwargs):
        raise ValueError('Var types do not have a type key')


@NodeDataclass
class AnyType(Type):
    """ Type that is used only in 'using' declarations to specify that the declaration is overriding all possible types

    For example in the declaration 'using SomeLibrary for *', the overriden type here is AnyType(every type
    that is imported from SomeLibrary)
    """

    def __str__(self): return "*"

    def type_key(self, name_resolver=None, *args, **kwargs):
        raise ValueError('Any types do not have a type key')
