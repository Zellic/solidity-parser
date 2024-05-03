:py:mod:`solidity_parser.ast.solnodes2`
=======================================

.. py:module:: solidity_parser.ast.solnodes2


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.solnodes2.AST2Node
   solidity_parser.ast.solnodes2.Stmt
   solidity_parser.ast.solnodes2.Expr
   solidity_parser.ast.solnodes2.Modifier
   solidity_parser.ast.solnodes2.ResolvedUserType
   solidity_parser.ast.solnodes2.SuperType
   solidity_parser.ast.solnodes2.VisibilityModifier
   solidity_parser.ast.solnodes2.MutabilityModifier
   solidity_parser.ast.solnodes2.OverrideSpecifier
   solidity_parser.ast.solnodes2.SuperConstructorInvocationModifier
   solidity_parser.ast.solnodes2.FunctionInvocationModifier
   solidity_parser.ast.solnodes2.Ident
   solidity_parser.ast.solnodes2.NamedArgument
   solidity_parser.ast.solnodes2.TopLevelUnit
   solidity_parser.ast.solnodes2.ContractPart
   solidity_parser.ast.solnodes2.InheritSpecifier
   solidity_parser.ast.solnodes2.LibraryOverride
   solidity_parser.ast.solnodes2.FileDefinition
   solidity_parser.ast.solnodes2.ContractDefinition
   solidity_parser.ast.solnodes2.InterfaceDefinition
   solidity_parser.ast.solnodes2.LibraryDefinition
   solidity_parser.ast.solnodes2.UserDefinedValueTypeDefinition
   solidity_parser.ast.solnodes2.EnumMember
   solidity_parser.ast.solnodes2.EnumDefinition
   solidity_parser.ast.solnodes2.StructMember
   solidity_parser.ast.solnodes2.StructDefinition
   solidity_parser.ast.solnodes2.ErrorParameter
   solidity_parser.ast.solnodes2.ErrorDefinition
   solidity_parser.ast.solnodes2.StateVariableDeclaration
   solidity_parser.ast.solnodes2.ConstantVariableDeclaration
   solidity_parser.ast.solnodes2.EventParameter
   solidity_parser.ast.solnodes2.EventDefinition
   solidity_parser.ast.solnodes2.Location
   solidity_parser.ast.solnodes2.Var
   solidity_parser.ast.solnodes2.Parameter
   solidity_parser.ast.solnodes2.Block
   solidity_parser.ast.solnodes2.If
   solidity_parser.ast.solnodes2.Catch
   solidity_parser.ast.solnodes2.Try
   solidity_parser.ast.solnodes2.While
   solidity_parser.ast.solnodes2.For
   solidity_parser.ast.solnodes2.FunctionMarker
   solidity_parser.ast.solnodes2.FunctionDefinition
   solidity_parser.ast.solnodes2.BuiltinFunction
   solidity_parser.ast.solnodes2.ModifierDefinition
   solidity_parser.ast.solnodes2.TupleVarDecl
   solidity_parser.ast.solnodes2.VarDecl
   solidity_parser.ast.solnodes2.ExprStmt
   solidity_parser.ast.solnodes2.Literal
   solidity_parser.ast.solnodes2.TypeLiteral
   solidity_parser.ast.solnodes2.UnaryOp
   solidity_parser.ast.solnodes2.BinaryOp
   solidity_parser.ast.solnodes2.TernaryOp
   solidity_parser.ast.solnodes2.SelfObject
   solidity_parser.ast.solnodes2.SuperObject
   solidity_parser.ast.solnodes2.StateVarLoad
   solidity_parser.ast.solnodes2.StaticVarLoad
   solidity_parser.ast.solnodes2.EnumLoad
   solidity_parser.ast.solnodes2.StateVarStore
   solidity_parser.ast.solnodes2.LocalVarLoad
   solidity_parser.ast.solnodes2.LocalVarStore
   solidity_parser.ast.solnodes2.ArrayLengthStore
   solidity_parser.ast.solnodes2.TupleLoad
   solidity_parser.ast.solnodes2.ArrayLoad
   solidity_parser.ast.solnodes2.ArrayStore
   solidity_parser.ast.solnodes2.ArraySliceLoad
   solidity_parser.ast.solnodes2.CreateInlineArray
   solidity_parser.ast.solnodes2.MappingLoad
   solidity_parser.ast.solnodes2.MappingStore
   solidity_parser.ast.solnodes2.GlobalValue
   solidity_parser.ast.solnodes2.ABISelector
   solidity_parser.ast.solnodes2.DynamicBuiltInValue
   solidity_parser.ast.solnodes2.CreateMemoryArray
   solidity_parser.ast.solnodes2.CreateStruct
   solidity_parser.ast.solnodes2.CreateAndDeployContract
   solidity_parser.ast.solnodes2.Call
   solidity_parser.ast.solnodes2.DirectCall
   solidity_parser.ast.solnodes2.FunctionCall
   solidity_parser.ast.solnodes2.FunctionPointerCall
   solidity_parser.ast.solnodes2.DynamicBuiltInCall
   solidity_parser.ast.solnodes2.BuiltInCall
   solidity_parser.ast.solnodes2.Cast
   solidity_parser.ast.solnodes2.GetType
   solidity_parser.ast.solnodes2.GetFunctionPointer
   solidity_parser.ast.solnodes2.EmitEvent
   solidity_parser.ast.solnodes2.Revert
   solidity_parser.ast.solnodes2.RevertWithError
   solidity_parser.ast.solnodes2.RevertWithReason
   solidity_parser.ast.solnodes2.Require
   solidity_parser.ast.solnodes2.Return
   solidity_parser.ast.solnodes2.Continue
   solidity_parser.ast.solnodes2.Break
   solidity_parser.ast.solnodes2.Assembly
   solidity_parser.ast.solnodes2.ExecModifiedCode
   solidity_parser.ast.solnodes2.UnprocessedCode



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.solnodes2.raiseNotPrintable
   solidity_parser.ast.solnodes2.param_def_str



Attributes
~~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.solnodes2.T
   solidity_parser.ast.solnodes2.Types


.. py:data:: T

   

.. py:function:: raiseNotPrintable()


.. py:function:: param_def_str(ps)


.. py:class:: AST2Node


   Bases: :py:obj:`solidity_parser.ast.nodebase.Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:method:: get_top_level_unit() -> TopLevelUnit



.. py:class:: Stmt


   Bases: :py:obj:`AST2Node`, :py:obj:`abc.ABC`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: Expr


   Bases: :py:obj:`AST2Node`, :py:obj:`abc.ABC`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:method:: type_of() -> solidity_parser.ast.types.Type
      :abstractmethod:



.. py:class:: Modifier


   Bases: :py:obj:`AST2Node`, :py:obj:`abc.ABC`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: ResolvedUserType


   Bases: :py:obj:`solidity_parser.ast.types.Type`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: scope
      :type: Scope

      

   .. py:attribute:: value
      :type: solidity_parser.ast.nodebase.Ref[TopLevelUnit]

      

   .. py:method:: __str__()

      Return str(self).


   .. py:method:: __repr__()

      Return repr(self).


   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: is_user_type() -> bool

      Check if the type is a user defined type, e.g. struct, enum, contract, etc 


   .. py:method:: can_implicitly_cast_from(actual_type: solidity_parser.ast.types.Type) -> bool


   .. py:method:: get_types_for_declared_type() -> list[TopLevelUnit]


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax



.. py:class:: SuperType


   Bases: :py:obj:`solidity_parser.ast.types.Type`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: declarer
      :type: solidity_parser.ast.nodebase.Ref[Union[ContractDefinition, InterfaceDefinition]]

      

   .. py:method:: is_builtin() -> bool

      Check if the type is a Solidity builtin type, e.g. primitives, message object, abi object, etc 


   .. py:method:: get_types_for_declared_type() -> list[TopLevelUnit]


   .. py:method:: code_str()

      Returns the string representation of the type in Solidity syntax


   .. py:method:: __str__()

      Return str(self).



.. py:class:: VisibilityModifier


   Bases: :py:obj:`Modifier`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: kind
      :type: solidity_parser.ast.solnodes.VisibilityModifierKind

      

   .. py:method:: code_str()



.. py:class:: MutabilityModifier


   Bases: :py:obj:`Modifier`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: kind
      :type: solidity_parser.ast.solnodes.MutabilityModifierKind

      

   .. py:method:: code_str()



.. py:class:: OverrideSpecifier


   Bases: :py:obj:`Modifier`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: bases
      :type: list[ResolvedUserType]

      

   .. py:method:: code_str()



.. py:class:: SuperConstructorInvocationModifier


   Bases: :py:obj:`Modifier`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base_ttype
      :type: ResolvedUserType

      

   .. py:attribute:: inputs
      :type: list[Expr]

      

   .. py:method:: code_str()



.. py:class:: FunctionInvocationModifier


   Bases: :py:obj:`Modifier`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: modifier
      :type: solidity_parser.ast.nodebase.Ref[ModifierDefinition]

      

   .. py:attribute:: inputs
      :type: list[Expr]

      

   .. py:method:: code_str()



.. py:class:: Ident


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: text
      :type: str

      

   .. py:method:: code_str()


   .. py:method:: __str__()

      Return str(self).



.. py:class:: NamedArgument


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: expr
      :type: Expr

      

   .. py:method:: code_str()



.. py:class:: TopLevelUnit


   Bases: :py:obj:`AST2Node`, :py:obj:`abc.ABC`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: source_unit_name
      :type: str

      

   .. py:attribute:: name
      :type: Ident

      

   .. py:method:: descriptor() -> str


   .. py:method:: is_subttype_of(other_contract: TopLevelUnit) -> bool


   .. py:method:: as_type()


   .. py:method:: get_supers() -> list[Union[ContractDefinition, InterfaceDefinition]]


   .. py:method:: get_subtypes() -> list[Union[ContractDefinition, InterfaceDefinition]]


   .. py:method:: is_enum() -> bool


   .. py:method:: is_struct() -> bool


   .. py:method:: is_contract() -> bool


   .. py:method:: is_interface() -> bool


   .. py:method:: is_udvt() -> bool


   .. py:method:: find_named_parts(name: str, explore_mro: bool, matching_types)



.. py:class:: ContractPart


   Bases: :py:obj:`AST2Node`, :py:obj:`abc.ABC`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:method:: has_modifier_kind(*kinds: solidity_parser.ast.solnodes.VisibilityModifierKind | solidity_parser.ast.solnodes.MutabilityModifierKind)



.. py:class:: InheritSpecifier


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: ResolvedUserType

      

   .. py:attribute:: args
      :type: list[Expr]

      

   .. py:method:: code_str()



.. py:class:: LibraryOverride


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: overriden_type
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: library
      :type: ResolvedUserType

      


.. py:class:: FileDefinition


   Bases: :py:obj:`TopLevelUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: scope
      :type: Scope

      

   .. py:attribute:: parts
      :type: list[ContractPart]

      

   .. py:method:: descriptor() -> str



.. py:class:: ContractDefinition


   Bases: :py:obj:`TopLevelUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: is_abstract
      :type: bool

      

   .. py:attribute:: inherits
      :type: list[InheritSpecifier]

      

   .. py:attribute:: parts
      :type: list[ContractPart]

      

   .. py:attribute:: type_overrides
      :type: list[LibraryOverride]

      

   .. py:attribute:: _subtypes
      :type: list[solidity_parser.ast.nodebase.Ref[Union[ContractDefinition, InterfaceDefinition]]]

      


.. py:class:: InterfaceDefinition


   Bases: :py:obj:`TopLevelUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: inherits
      :type: list[InheritSpecifier]

      

   .. py:attribute:: parts
      :type: list[ContractPart]

      

   .. py:attribute:: type_overrides
      :type: list[LibraryOverride]

      

   .. py:attribute:: _subtypes
      :type: list[solidity_parser.ast.nodebase.Ref[Union[ContractDefinition, InterfaceDefinition]]]

      


.. py:class:: LibraryDefinition


   Bases: :py:obj:`TopLevelUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: parts
      :type: list[ContractPart]

      

   .. py:attribute:: type_overrides
      :type: list[LibraryOverride]

      


.. py:class:: UserDefinedValueTypeDefinition


   Bases: :py:obj:`TopLevelUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      


.. py:class:: EnumMember


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      


.. py:class:: EnumDefinition


   Bases: :py:obj:`TopLevelUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: values
      :type: list[EnumMember]

      


.. py:class:: StructMember


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: name
      :type: Ident

      


.. py:class:: StructDefinition


   Bases: :py:obj:`TopLevelUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: members
      :type: list[StructMember]

      


.. py:class:: ErrorParameter


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: name
      :type: Ident

      


.. py:class:: ErrorDefinition


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: inputs
      :type: list[ErrorParameter]

      


.. py:class:: StateVariableDeclaration


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: modifiers
      :type: list[Modifier]

      

   .. py:attribute:: value
      :type: Expr

      


.. py:class:: ConstantVariableDeclaration


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: value
      :type: Expr

      


.. py:class:: EventParameter


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: is_indexed
      :type: bool

      


.. py:class:: EventDefinition


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: inputs
      :type: list[EventParameter]

      

   .. py:attribute:: is_anonymous
      :type: bool

      


.. py:class:: Location(*args, **kwds)


   Bases: :py:obj:`enum.Enum`

   Create a collection of name/value pairs.

   Example enumeration:

   >>> class Color(Enum):
   ...     RED = 1
   ...     BLUE = 2
   ...     GREEN = 3

   Access them by:

   - attribute access::

   >>> Color.RED
   <Color.RED: 1>

   - value lookup:

   >>> Color(1)
   <Color.RED: 1>

   - name lookup:

   >>> Color['RED']
   <Color.RED: 1>

   Enumerations can be iterated over, and know how many members they have:

   >>> len(Color)
   3

   >>> list(Color)
   [<Color.RED: 1>, <Color.BLUE: 2>, <Color.GREEN: 3>]

   Methods can be added to enumerations, and members can have their own
   attributes -- see the documentation for details.

   .. py:attribute:: MEMORY
      :value: 'memory'

      

   .. py:attribute:: STORAGE
      :value: 'storage'

      

   .. py:attribute:: CALLDATA
      :value: 'calldata'

      

   .. py:method:: __str__()

      Return str(self).



.. py:class:: Var


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: location
      :type: Location

      

   .. py:method:: code_str()



.. py:class:: Parameter


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var
      :type: Var

      


.. py:class:: Block


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: stmts
      :type: list[Stmt]

      

   .. py:attribute:: is_unchecked
      :type: bool

      

   .. py:method:: code_str(brackets=True)



.. py:class:: If


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: condition
      :type: Expr

      

   .. py:attribute:: true_branch
      :type: Stmt

      

   .. py:attribute:: false_branch
      :type: Stmt

      

   .. py:method:: code_str()



.. py:class:: Catch


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ident
      :type: Ident

      

   .. py:attribute:: parameters
      :type: list[Parameter]

      

   .. py:attribute:: body
      :type: Block

      

   .. py:method:: code_str()



.. py:class:: Try


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: expr
      :type: Expr

      

   .. py:attribute:: return_parameters
      :type: list[Parameter]

      

   .. py:attribute:: body
      :type: Block

      

   .. py:attribute:: catch_clauses
      :type: list[Catch]

      

   .. py:method:: code_str()



.. py:class:: While


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: condition
      :type: Expr

      

   .. py:attribute:: body
      :type: Stmt

      

   .. py:attribute:: is_do_while
      :type: bool

      

   .. py:method:: code_str()



.. py:class:: For


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: initialiser
      :type: Stmt

      

   .. py:attribute:: condition
      :type: Expr

      

   .. py:attribute:: advancement
      :type: Expr

      

   .. py:attribute:: body
      :type: Stmt

      

   .. py:method:: code_str()



.. py:class:: FunctionMarker(*args, **kwds)


   Bases: :py:obj:`enum.Enum`

   Special function type markers 

   .. py:attribute:: CONSTRUCTOR
      :value: 1

      

   .. py:attribute:: SYNTHETIC_FIELD_GETTER
      :value: 2

      


.. py:class:: FunctionDefinition


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: inputs
      :type: list[Parameter]

      

   .. py:attribute:: outputs
      :type: list[Parameter]

      

   .. py:attribute:: modifiers
      :type: list[Modifier]

      

   .. py:attribute:: code
      :type: Block

      

   .. py:attribute:: markers
      :type: list[FunctionMarker]

      

   .. py:method:: param_str(ps) -> str
      :staticmethod:


   .. py:method:: descriptor() -> str


   .. py:method:: __str__()

      Return str(self).



.. py:class:: BuiltinFunction


   Bases: :py:obj:`AST2Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: inputs
      :type: list[Parameter]

      

   .. py:attribute:: outputs
      :type: list[Parameter]

      


.. py:class:: ModifierDefinition


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: inputs
      :type: list[Parameter]

      

   .. py:attribute:: modifiers
      :type: list[Modifier]

      

   .. py:attribute:: code
      :type: Block

      


.. py:class:: TupleVarDecl


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: vars
      :type: list[Var]

      

   .. py:attribute:: value
      :type: Expr

      

   .. py:method:: code_str()



.. py:class:: VarDecl


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var
      :type: Var

      

   .. py:attribute:: value
      :type: Expr

      

   .. py:method:: code_str()



.. py:class:: ExprStmt


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: expr
      :type: Expr

      

   .. py:method:: code_str()



.. py:class:: Literal


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: value
      :type: Any

      

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: unit
      :type: solidity_parser.ast.solnodes.Unit

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: TypeLiteral


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:method:: type_of()


   .. py:method:: code_str()



.. py:class:: UnaryOp


   Bases: :py:obj:`Expr`

   Single operand expression 

   .. py:attribute:: expr
      :type: Expr

      

   .. py:attribute:: op
      :type: solidity_parser.ast.solnodes.UnaryOpCode

      

   .. py:attribute:: is_pre
      :type: bool

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: BinaryOp


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: left
      :type: Expr

      

   .. py:attribute:: right
      :type: Expr

      

   .. py:attribute:: op
      :type: solidity_parser.ast.solnodes.BinaryOpCode

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: TernaryOp


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: condition
      :type: Expr

      

   .. py:attribute:: left
      :type: Expr

      

   .. py:attribute:: right
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: SelfObject


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: declarer
      :type: solidity_parser.ast.nodebase.Ref[ContractDefinition | InterfaceDefinition]

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: SuperObject


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: SuperType

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: StateVarLoad


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: name
      :type: Ident

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: StaticVarLoad


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: ResolvedUserType

      

   .. py:attribute:: name
      :type: Ident

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: EnumLoad


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: member
      :type: solidity_parser.ast.nodebase.Ref[EnumMember]

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: StateVarStore


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: value
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: state_var()


   .. py:method:: code_str()



.. py:class:: LocalVarLoad


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var
      :type: Var

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: LocalVarStore


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var
      :type: Var

      

   .. py:attribute:: value
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: ArrayLengthStore


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: value
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()
      :abstractmethod:



.. py:class:: TupleLoad


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: index
      :type: int

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: ArrayLoad


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: index
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: ArrayStore


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: index
      :type: Expr

      

   .. py:attribute:: value
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: ArraySliceLoad


   Bases: :py:obj:`Expr`

   Gets a subarray at the given start and end indices from the given array 

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: start_index
      :type: Expr

      

   .. py:attribute:: end_index
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: CreateInlineArray


   Bases: :py:obj:`Expr`

   Solidity 8 inline array creation

   An inline array is one where the elements are explicitly stated in the definition, for example:
   'int[5]   foo2 = [1, 0, 0, 0, 0];'

   .. py:attribute:: elements
      :type: list[Expr]

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: MappingLoad


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: key
      :type: Expr

      

   .. py:method:: code_str()


   .. py:method:: type_of() -> solidity_parser.ast.types.Type



.. py:class:: MappingStore


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: key
      :type: Expr

      

   .. py:attribute:: value
      :type: Expr

      

   .. py:method:: code_str()



.. py:class:: GlobalValue


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: str

      

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: ABISelector


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: function
      :type: solidity_parser.ast.nodebase.Ref[FunctionDefinition | ErrorDefinition] | Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: __str__()

      Return str(self).


   .. py:method:: code_str()



.. py:class:: DynamicBuiltInValue


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: str

      

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: base
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: CreateMemoryArray


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.ArrayType

      

   .. py:attribute:: size
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: CreateStruct


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: ResolvedUserType

      

   .. py:attribute:: args
      :type: list[Expr]

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: CreateAndDeployContract


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: ResolvedUserType

      

   .. py:attribute:: named_args
      :type: list[NamedArgument]

      

   .. py:attribute:: args
      :type: list[Expr]

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: Call


   Bases: :py:obj:`Expr`, :py:obj:`abc.ABC`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: named_args
      :type: list[NamedArgument]

      

   .. py:attribute:: args
      :type: list[Expr]

      

   .. py:method:: check_arg_types(f: FunctionDefinition) -> bool


   .. py:method:: param_str()



.. py:class:: DirectCall


   Bases: :py:obj:`Call`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: ResolvedUserType

      

   .. py:attribute:: name
      :type: Ident

      

   .. py:method:: base_type()


   .. py:method:: resolve_call() -> FunctionDefinition


   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()


   .. py:method:: __str__()

      Return str(self).



.. py:class:: FunctionCall


   Bases: :py:obj:`Call`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base
      :type: Expr

      

   .. py:attribute:: name
      :type: Ident

      

   .. py:method:: base_type()


   .. py:method:: resolve_call() -> FunctionDefinition


   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()


   .. py:method:: __str__()

      Return str(self).



.. py:class:: FunctionPointerCall


   Bases: :py:obj:`Call`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: callee
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: DynamicBuiltInCall


   Bases: :py:obj:`Call`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: base
      :type: Expr | ResolvedUserType

      

   .. py:attribute:: name
      :type: str

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: BuiltInCall


   Bases: :py:obj:`Call`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: str

      

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: Cast


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: value
      :type: Expr

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: GetType


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: ttype
      :type: solidity_parser.ast.types.Type

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: GetFunctionPointer


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: func
      :type: solidity_parser.ast.nodebase.Ref[Union[FunctionDefinition, BuiltinFunction]]

      

   .. py:method:: type_of() -> solidity_parser.ast.types.Type


   .. py:method:: code_str()



.. py:class:: EmitEvent


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: event
      :type: solidity_parser.ast.nodebase.Ref[EventDefinition]

      

   .. py:attribute:: args
      :type: list[Expr]

      

   .. py:method:: code_str()



.. py:class:: Revert


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: RevertWithError


   Bases: :py:obj:`Revert`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: error
      :type: solidity_parser.ast.nodebase.Ref[ErrorDefinition]

      

   .. py:attribute:: args
      :type: list[Expr]

      

   .. py:method:: code_str()



.. py:class:: RevertWithReason


   Bases: :py:obj:`Revert`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: reason
      :type: Expr

      

   .. py:method:: code_str()



.. py:class:: Require


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: condition
      :type: Expr

      

   .. py:attribute:: reason
      :type: Expr

      

   .. py:method:: code_str()



.. py:class:: Return


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: values
      :type: list[Expr]

      

   .. py:method:: code_str()



.. py:class:: Continue


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:method:: code_str()



.. py:class:: Break


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:method:: code_str()



.. py:class:: Assembly


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: code
      :type: str

      

   .. py:method:: code_str()



.. py:class:: ExecModifiedCode


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: UnprocessedCode


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: error
      :type: Exception

      


.. py:data:: Types
   :type: TypeAlias

   

