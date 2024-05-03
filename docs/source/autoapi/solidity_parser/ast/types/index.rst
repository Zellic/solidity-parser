:py:mod:`solidity_parser.ast.types`
===================================

.. py:module:: solidity_parser.ast.types


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.types.Type
   solidity_parser.ast.types.FloatType
   solidity_parser.ast.types.VoidType
   solidity_parser.ast.types.ArrayType
   solidity_parser.ast.types.FixedLengthArrayType
   solidity_parser.ast.types.VariableLengthArrayType
   solidity_parser.ast.types.AddressType
   solidity_parser.ast.types.ByteType
   solidity_parser.ast.types.BytesType
   solidity_parser.ast.types.IntType
   solidity_parser.ast.types.PreciseIntType
   solidity_parser.ast.types.BoolType
   solidity_parser.ast.types.StringType
   solidity_parser.ast.types.PreciseStringType
   solidity_parser.ast.types.MappingType
   solidity_parser.ast.types.UserType
   solidity_parser.ast.types.BuiltinType
   solidity_parser.ast.types.FunctionType
   solidity_parser.ast.types.TupleType
   solidity_parser.ast.types.MetaTypeType
   solidity_parser.ast.types.VarType
   solidity_parser.ast.types.AnyType



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.types.UIntType
   solidity_parser.ast.types.Bytes
   solidity_parser.ast.types.ABIType



.. py:class:: Type


   Bases: :py:obj:`solidity_parser.ast.nodebase.Node`, :py:obj:`abc.ABC`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: scope
      :type: Scope

      Shim for symbol table scoping. The scope field is also defined in solnodes1 Node but since this base  class is 
      defined in this file, it must be defined here as well


   .. py:method:: are_matching_types(target_param_types, actual_param_types)
      :staticmethod:


   .. py:method:: can_implicitly_cast_from(actual_type: Type) -> bool


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: is_array() -> bool


   .. py:method:: is_byte_array() -> bool

      Check if the type is any type of byte array, e.g. bytes, bytes1, bytes32 


   .. py:method:: is_byte_array_underlying() -> bool

      Check if this type is logically an array of bytes, e.g. bytes, bytes1, bytes32 and string 


   .. py:method:: is_string() -> bool


   .. py:method:: is_function() -> bool


   .. py:method:: is_int() -> bool


   .. py:method:: is_bool() -> bool


   .. py:method:: is_user_type() -> bool

      Check if the type is a user defined type, e.g. struct, enum, contract, etc 


   .. py:method:: is_address() -> bool


   .. py:method:: is_mapping() -> bool


   .. py:method:: is_byte() -> bool

      Check if the type is a single "byte" 


   .. py:method:: is_tuple() -> bool

      Check if the type is a tuple. These are synthetic types in Solidity but can be used in ASTs 


   .. py:method:: is_literal_type() -> bool

      Check if the type is a literal type, i.e. an inferred type from a constant number or string expression.
      These are not real types in Solidity but are used in solc to aid type inference and optimization rules


   .. py:method:: is_float() -> bool

      Check whether this type is a compile time float


   .. py:method:: is_void() -> bool

      Check if the type represents a void return type. This isn't part of Solidity directly but is represented
      when a function doesn't define any return types


   .. py:method:: type_key()

      Returns a unique key for the type that can be used to cache types in the symbol table 


   .. py:method:: __str__()
      :abstractmethod:

      Return str(self).


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: FloatType


   Bases: :py:obj:`Type`

   This is not a real type in valid Solidity code but the Solidity compiler allows compile time expression evaluation
   of floats

   .. py:attribute:: value
      :type: float

      Since the value is always known at compile time, we have it here 


   .. py:method:: is_float() -> bool

      Check whether this type is a compile time float


   .. py:method:: __str__()

      Return str(self).


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax


   .. py:method:: can_implicitly_cast_from(actual_type: Type) -> bool



.. py:class:: VoidType


   Bases: :py:obj:`Type`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:method:: is_void() -> bool

      Check if the type represents a void return type. This isn't part of Solidity directly but is represented
      when a function doesn't define any return types


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax


   .. py:method:: __str__()

      Return str(self).



.. py:class:: ArrayType


   Bases: :py:obj:`Type`

   Single dimension array type with no size attributes

   .. py:attribute:: base_type
      :type: Type

      

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: can_implicitly_cast_from(actual_type: Type) -> bool


   .. py:method:: has_size() -> bool


   .. py:method:: is_fixed_size() -> bool


   .. py:method:: is_array() -> bool



.. py:class:: FixedLengthArrayType


   Bases: :py:obj:`ArrayType`

   Array type with a known length that is determined at compile time 

   .. py:attribute:: size
      :type: int

      

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: is_fixed_size() -> bool


   .. py:method:: can_implicitly_cast_from(actual_type: Type) -> bool


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: VariableLengthArrayType


   Bases: :py:obj:`ArrayType`

   Array type with a length that is determined at runtime

   .. py:attribute:: size
      :type: Expr

      

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: AddressType


   Bases: :py:obj:`Type`

   Solidity address/address payable type, functionally this is a uint160

   .. py:attribute:: is_payable
      :type: bool

      

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: can_implicitly_cast_from(actual_type: Type) -> bool


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: is_address() -> bool


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: ByteType


   Bases: :py:obj:`Type`

   Single 8bit byte type 

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: is_byte() -> bool

      Check if the type is a single "byte" 


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:function:: UIntType(size=256)


.. py:function:: Bytes(size=None)


.. py:class:: BytesType


   Bases: :py:obj:`ArrayType`

   bytes type only (similar but not equal to byte[]/bytes1[]) 

   .. py:attribute:: base_type
      :type: Type

      

   .. py:method:: can_implicitly_cast_from(actual_type: Type) -> bool


   .. py:method:: __str__()

      Return str(self).


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: IntType


   Bases: :py:obj:`Type`

   Solidity native integer type of various bit length and signedness

   .. py:attribute:: is_signed
      :type: bool

      Whether the type is a signed int or unsigned int 


   .. py:attribute:: size
      :type: int

      Size of the type in bits 


   .. py:method:: __str__()

      Return str(self).


   .. py:method:: can_implicitly_cast_from(actual_type: Type) -> bool


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: is_int() -> bool


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: PreciseIntType


   Bases: :py:obj:`IntType`

   Solidity native integer type of various bit length and signedness

   .. py:attribute:: real_bit_length
      :type: int

      

   .. py:method:: is_literal_type() -> bool

      Check if the type is a literal type, i.e. an inferred type from a constant number or string expression.
      These are not real types in Solidity but are used in solc to aid type inference and optimization rules


   .. py:method:: __str__()

      Return str(self).


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: BoolType


   Bases: :py:obj:`Type`

   Solidity native boolean type

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: is_bool() -> bool


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: StringType


   Bases: :py:obj:`ArrayType`

   Solidity native string type

   .. py:attribute:: base_type
      :type: Type

      

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: is_string() -> bool


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: PreciseStringType


   Bases: :py:obj:`StringType`

   String literal type that has a known length at compile time

   .. py:attribute:: real_size
      :type: int

      

   .. py:method:: is_literal_type() -> bool

      Check if the type is a literal type, i.e. an inferred type from a constant number or string expression.
      These are not real types in Solidity but are used in solc to aid type inference and optimization rules


   .. py:method:: has_size() -> bool


   .. py:method:: __str__()

      Return str(self).


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: MappingType


   Bases: :py:obj:`Type`

   Type that represents a function mapping definition

   For example in the mapping '(uint x => Campaign c)', src would be 'unit' and the dst would be 'Campaign',
   src_key would be 'x' and dst_key would be 'c'

   .. py:attribute:: src
      :type: Type

      

   .. py:attribute:: dst
      :type: Type

      

   .. py:attribute:: src_name
      :type: Ident

      

   .. py:attribute:: dst_name
      :type: Ident

      

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: is_mapping() -> bool


   .. py:method:: flatten() -> list[Type]


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: UserType


   Bases: :py:obj:`Type`

   Type invoked using a valid Solidity reference, e.g. a class, contract, library, enum, etc name.
   This is an "unlinked" type, e.g. it has no underlying AST node backing it and has no corresponding context other
   than the scope it was declared in. For AST2 use solnodes2.ResolvedUserType instead.

   .. py:attribute:: name
      :type: Ident

      

   .. py:method:: __str__()

      Return str(self).



.. py:class:: BuiltinType


   Bases: :py:obj:`Type`

   Type representing types of Solidity builtin objects, e.g. the type of the 'msg' or 'abi' objects in the expressions
   `msg.sender` or `abi.decode(...)`

   .. py:attribute:: name
      :type: str

      

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:function:: ABIType() -> BuiltinType


.. py:class:: FunctionType


   Bases: :py:obj:`Type`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: inputs
      :type: list[Type]

      

   .. py:attribute:: outputs
      :type: list[Type]

      

   .. py:attribute:: modifiers
      :type: list[Modifier]

      

   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: is_function() -> bool


   .. py:method:: can_implicitly_cast_from(actual_type: Type) -> bool


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax


   .. py:method:: __str__()

      Return str(self).


   .. py:method:: type_key()

      Returns a unique key for the type that can be used to cache types in the symbol table 



.. py:class:: TupleType


   Bases: :py:obj:`Type`

   Type of a tuple of elements. This is not a real Solidity type but is used to represent the type of tuple expressions
    (e.g. desugaring) in the AST

   .. py:attribute:: ttypes
      :type: list[Type]

      

   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: is_tuple() -> bool

      Check if the type is a tuple. These are synthetic types in Solidity but can be used in ASTs 


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax


   .. py:method:: __str__()

      Return str(self).



.. py:class:: MetaTypeType


   Bases: :py:obj:`Type`

   Metatype Solidity type, i.e. type(X). This type has a few builtin fields such as min, max, name, creationCode,
   runtimeCode and interfaceId

   .. py:attribute:: ttype
      :type: Type

      

   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax


   .. py:method:: __str__()

      Return str(self).



.. py:class:: VarType


   Bases: :py:obj:`Type`

   Type that wasn't explicitly identified in the code

   This type should not be used without running a subsequent type inference pass.

   An example variable declaration that would use this type symbol: 'var (, mantissa, exponent) = ... '

   .. py:method:: __str__()

      Return str(self).



.. py:class:: AnyType


   Bases: :py:obj:`Type`

   Type that is used only in 'using' declarations to specify that the declaration is overriding all possible types

   For example in the declaration 'using SomeLibrary for *', the overriden type here is AnyType(every type
   that is imported from SomeLibrary)

   .. py:method:: __str__()

      Return str(self).



