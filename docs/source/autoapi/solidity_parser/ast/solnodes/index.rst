:py:mod:`solidity_parser.ast.solnodes`
======================================

.. py:module:: solidity_parser.ast.solnodes


Module Contents
---------------

Classes
~~~~~~~

.. autoapisummary::

   solidity_parser.ast.solnodes.AST1Node
   solidity_parser.ast.solnodes.Stmt
   solidity_parser.ast.solnodes.Expr
   solidity_parser.ast.solnodes.Ident
   solidity_parser.ast.solnodes.Location
   solidity_parser.ast.solnodes.NamedArg
   solidity_parser.ast.solnodes.Unit
   solidity_parser.ast.solnodes.Literal
   solidity_parser.ast.solnodes.UnaryOpCode
   solidity_parser.ast.solnodes.UnaryOp
   solidity_parser.ast.solnodes.BinaryOpCode
   solidity_parser.ast.solnodes.BinaryOp
   solidity_parser.ast.solnodes.TernaryOp
   solidity_parser.ast.solnodes.New
   solidity_parser.ast.solnodes.NewInlineArray
   solidity_parser.ast.solnodes.PayableConversion
   solidity_parser.ast.solnodes.GetArrayValue
   solidity_parser.ast.solnodes.GetArraySlice
   solidity_parser.ast.solnodes.GetMember
   solidity_parser.ast.solnodes.CallFunction
   solidity_parser.ast.solnodes.Var
   solidity_parser.ast.solnodes.VarDecl
   solidity_parser.ast.solnodes.Parameter
   solidity_parser.ast.solnodes.ExprStmt
   solidity_parser.ast.solnodes.Block
   solidity_parser.ast.solnodes.If
   solidity_parser.ast.solnodes.Catch
   solidity_parser.ast.solnodes.Try
   solidity_parser.ast.solnodes.While
   solidity_parser.ast.solnodes.For
   solidity_parser.ast.solnodes.Emit
   solidity_parser.ast.solnodes.Revert
   solidity_parser.ast.solnodes.AssemblyStmt
   solidity_parser.ast.solnodes.DoWhile
   solidity_parser.ast.solnodes.Continue
   solidity_parser.ast.solnodes.Break
   solidity_parser.ast.solnodes.Return
   solidity_parser.ast.solnodes.Throw
   solidity_parser.ast.solnodes.Modifier
   solidity_parser.ast.solnodes.VisibilityModifierKind
   solidity_parser.ast.solnodes.MutabilityModifierKind
   solidity_parser.ast.solnodes.VisibilityModifier2
   solidity_parser.ast.solnodes.MutabilityModifier2
   solidity_parser.ast.solnodes.InvocationModifier
   solidity_parser.ast.solnodes.OverrideSpecifier
   solidity_parser.ast.solnodes.SourceUnit
   solidity_parser.ast.solnodes.PragmaDirective
   solidity_parser.ast.solnodes.ImportDirective
   solidity_parser.ast.solnodes.GlobalImportDirective
   solidity_parser.ast.solnodes.UnitImportDirective
   solidity_parser.ast.solnodes.SymbolAlias
   solidity_parser.ast.solnodes.SymbolImportDirective
   solidity_parser.ast.solnodes.ContractPart
   solidity_parser.ast.solnodes.SpecialFunctionKind
   solidity_parser.ast.solnodes.FunctionDefinition
   solidity_parser.ast.solnodes.ModifierDefinition
   solidity_parser.ast.solnodes.StructMember
   solidity_parser.ast.solnodes.StructDefinition
   solidity_parser.ast.solnodes.EnumDefinition
   solidity_parser.ast.solnodes.StateVariableDeclaration
   solidity_parser.ast.solnodes.ConstantVariableDeclaration
   solidity_parser.ast.solnodes.UserValueType
   solidity_parser.ast.solnodes.EventParameter
   solidity_parser.ast.solnodes.EventDefinition
   solidity_parser.ast.solnodes.ErrorParameter
   solidity_parser.ast.solnodes.ErrorDefinition
   solidity_parser.ast.solnodes.UsingAttachment
   solidity_parser.ast.solnodes.UsingOperatorBinding
   solidity_parser.ast.solnodes.UsingDirective
   solidity_parser.ast.solnodes.InheritSpecifier
   solidity_parser.ast.solnodes.ContractDefinition
   solidity_parser.ast.solnodes.InterfaceDefinition
   solidity_parser.ast.solnodes.LibraryDefinition
   solidity_parser.ast.solnodes.CreateMetaType



Functions
~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.solnodes.has_modifier_kind



Attributes
~~~~~~~~~~

.. autoapisummary::

   solidity_parser.ast.solnodes.ModFunErrEvt
   solidity_parser.ast.solnodes.Types


.. py:class:: AST1Node


   Bases: :py:obj:`solidity_parser.ast.nodebase.Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: scope
      :type: Scope

      

   .. py:attribute:: ast2_node
      :type: AST2Node

      


.. py:class:: Stmt


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: Expr


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: Ident


   Bases: :py:obj:`Expr`

   String identifier node 

   .. py:attribute:: text
      :type: str

      

   .. py:method:: __str__()

      Return str(self).



.. py:class:: Location(*args, **kwds)


   Bases: :py:obj:`enum.Enum`

   Solidity reference type storage locations

   These are used to specify in what type of memory context/area a struct/array/mapping is stored

   .. py:attribute:: MEMORY
      :value: 'memory'

      An location that does not persist between function calls 


   .. py:attribute:: STORAGE
      :value: 'storage'

      A location persists between function calls

      Contract state variables are stored here also


   .. py:attribute:: CALLDATA
      :value: 'calldata'

      A location that contains the function call arguments for external function call parameters 


   .. py:method:: __str__()

      Return str(self).



.. py:class:: NamedArg


   Bases: :py:obj:`Expr`

   A name-value pair used for calling functions with options 

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: value
      :type: Expr

      


.. py:class:: Unit(_: str, multiplier: int)


   Bases: :py:obj:`enum.Enum`

   Solidity numerical unit types 

   .. py:property:: multiplier
      :type: int


   .. py:attribute:: WEI
      :value: ('wei', 1)

      

   .. py:attribute:: GWEI
      :value: ('gwei', 1000000000.0)

      

   .. py:attribute:: SZABO
      :value: ('szabo', 1000000000000.0)

      

   .. py:attribute:: FINNEY
      :value: ('finney', 1000000000000000.0)

      

   .. py:attribute:: ETHER
      :value: ('ether', 1e+18)

      

   .. py:attribute:: SECONDS
      :value: ('seconds', 1)

      

   .. py:attribute:: MINUTES
      :value: ('minutes', 60)

      

   .. py:attribute:: HOURS
      :value: ('hours',)

      

   .. py:attribute:: DAYS
      :value: ('days',)

      

   .. py:attribute:: WEEKS
      :value: ('weeks',)

      

   .. py:attribute:: YEARS
      :value: ('years',)

      

   .. py:method:: __str__()

      Return str(self).



.. py:class:: Literal


   Bases: :py:obj:`Expr`

   Constant value expression that can have an optional unit associated with it

   The value may be a python primitive, e.g. an integer, boolean, string, tuple, etc 

   .. py:attribute:: value
      :type: Any

      

   .. py:attribute:: unit
      :type: Unit

      

   .. py:method:: code_str()



.. py:class:: UnaryOpCode(*args, **kwds)


   Bases: :py:obj:`enum.Enum`

   Single operand operation types

   .. py:attribute:: INC
      :value: '++'

      

   .. py:attribute:: DEC
      :value: '--'

      

   .. py:attribute:: SIGN_POS
      :value: '+'

      

   .. py:attribute:: SIGN_NEG
      :value: '-'

      

   .. py:attribute:: BOOL_NEG
      :value: '!'

      

   .. py:attribute:: BIT_NEG
      :value: '~'

      

   .. py:attribute:: DELETE
      :value: 'delete'

      


.. py:class:: UnaryOp


   Bases: :py:obj:`Expr`

   Single operand expression 

   .. py:attribute:: expr
      :type: Expr

      

   .. py:attribute:: op
      :type: UnaryOpCode

      

   .. py:attribute:: is_pre
      :type: bool

      Whether the operation is pre or post, e.g. ++x or x++ 



.. py:class:: BinaryOpCode(*args, **kwds)


   Bases: :py:obj:`enum.Enum`

   Binary/two operand operation types, including assignment types 

   .. py:attribute:: EXPONENTIATE
      :value: '**'

      

   .. py:attribute:: MUL
      :value: '*'

      

   .. py:attribute:: DIV
      :value: '/'

      

   .. py:attribute:: MOD
      :value: '%'

      

   .. py:attribute:: ADD
      :value: '+'

      

   .. py:attribute:: SUB
      :value: '-'

      

   .. py:attribute:: LSHIFT
      :value: '<<'

      

   .. py:attribute:: RSHIFT
      :value: '>>'

      

   .. py:attribute:: BIT_AND
      :value: '&'

      

   .. py:attribute:: BIT_XOR
      :value: '^'

      

   .. py:attribute:: BIT_OR
      :value: '|'

      

   .. py:attribute:: LT
      :value: '<'

      

   .. py:attribute:: GT
      :value: '>'

      

   .. py:attribute:: LTEQ
      :value: '<='

      

   .. py:attribute:: GTEQ
      :value: '>='

      

   .. py:attribute:: EQ
      :value: '=='

      

   .. py:attribute:: NEQ
      :value: '!='

      

   .. py:attribute:: BOOL_AND
      :value: '&&'

      

   .. py:attribute:: BOOL_OR
      :value: '||'

      

   .. py:attribute:: ASSIGN
      :value: '='

      

   .. py:attribute:: ASSIGN_OR
      :value: '|='

      

   .. py:attribute:: ASSIGN_BIT_NEG
      :value: '^='

      

   .. py:attribute:: ASSIGN_BIT_AND
      :value: '&='

      

   .. py:attribute:: ASSIGN_LSHIFT
      :value: '<<='

      

   .. py:attribute:: ASSIGN_RSHIFT
      :value: '>>='

      

   .. py:attribute:: ASSIGN_ADD
      :value: '+='

      

   .. py:attribute:: ASSIGN_SUB
      :value: '-='

      

   .. py:attribute:: ASSIGN_MUL
      :value: '*='

      

   .. py:attribute:: ASSIGN_DIV
      :value: '/='

      

   .. py:attribute:: ASSIGN_MOD
      :value: '%='

      


.. py:class:: BinaryOp


   Bases: :py:obj:`Expr`

   Binary/two operand expression 

   .. py:attribute:: left
      :type: Expr

      

   .. py:attribute:: right
      :type: Expr

      

   .. py:attribute:: op
      :type: BinaryOpCode

      


.. py:class:: TernaryOp


   Bases: :py:obj:`Expr`

   Choice expression that evaluates the given condition and returns one of the two given expressions

   If the condition evaluates to false then the left expression is returned, otherwise the right one is

   .. py:attribute:: condition
      :type: Expr

      

   .. py:attribute:: left
      :type: Expr

      

   .. py:attribute:: right
      :type: Expr

      


.. py:class:: New


   Bases: :py:obj:`Expr`

   New object allocation expression without constructor invocation

   Note that this expression only represents the 'new X' part of a new objects creation 'new X(a,b)'.
   This expression must then be used as the base object in a constructor call to instantiate it.


   .. py:attribute:: type_name
      :type: solidity_parser.ast.types.Type

      


.. py:class:: NewInlineArray


   Bases: :py:obj:`Expr`

   Solidity 8 inline array creation

   An inline array is one where the elements are explicitly stated in the definition, for example:
   'int[5]   foo2 = [1, 0, 0, 0, 0];'

   .. py:attribute:: elements
      :type: list[Expr]

      


.. py:class:: PayableConversion


   Bases: :py:obj:`Expr`

   Converts an address to a payable address

   For example: 'payable(address(myAddressHex))'

   .. py:attribute:: args
      :type: list[Expr]

      


.. py:class:: GetArrayValue


   Bases: :py:obj:`Expr`

   Gets the value at the given index from the given array 

   .. py:attribute:: array_base
      :type: Expr

      

   .. py:attribute:: index
      :type: Expr

      


.. py:class:: GetArraySlice


   Bases: :py:obj:`Expr`

   Gets a subarray at the given start and end indices from the given array 

   .. py:attribute:: array_base
      :type: Expr

      

   .. py:attribute:: start_index
      :type: Expr

      

   .. py:attribute:: end_index
      :type: Expr

      


.. py:class:: GetMember


   Bases: :py:obj:`Expr`

   Gets a member field or method from a given object 

   .. py:attribute:: obj_base
      :type: Expr

      

   .. py:attribute:: name
      :type: Ident

      


.. py:class:: CallFunction


   Bases: :py:obj:`Expr`

   Invokes a function 

   .. py:attribute:: callee
      :type: Expr

      This callee is most likely a GetMember expression but can be any callable 


   .. py:attribute:: modifiers
      :type: list

      

   .. py:attribute:: args
      :type: list[Expr]

      


.. py:class:: Var


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var_type
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: var_name
      :type: Ident

      

   .. py:attribute:: var_loc
      :type: Optional[Location]

      


.. py:class:: VarDecl


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: variables
      :type: list[Var]

      

   .. py:attribute:: value
      :type: Expr

      

   .. py:attribute:: is_lhs_tuple
      :type: bool
      :value: False

      


.. py:class:: Parameter


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var_type
      :type: Ident

      

   .. py:attribute:: var_loc
      :type: Location

      

   .. py:attribute:: var_name
      :type: Ident

      

   .. py:method:: __str__()

      Return str(self).



.. py:class:: ExprStmt


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: expr
      :type: Expr

      


.. py:class:: Block


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: stmts
      :type: list[Stmt]

      

   .. py:attribute:: is_unchecked
      :type: bool
      :value: False

      


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

      


.. py:class:: While


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: expr
      :type: Expr

      

   .. py:attribute:: body
      :type: Stmt

      


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

      


.. py:class:: Emit


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: call
      :type: CallFunction

      


.. py:class:: Revert


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: call
      :type: CallFunction

      


.. py:class:: AssemblyStmt


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: code
      :type: str

      


.. py:class:: DoWhile


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: body
      :type: Stmt

      

   .. py:attribute:: condition
      :type: Expr

      


.. py:class:: Continue


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: Break


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: Return


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: value
      :type: Expr

      


.. py:class:: Throw


   Bases: :py:obj:`Stmt`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: Modifier


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: VisibilityModifierKind(*args, **kwds)


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

   .. py:attribute:: EXTERNAL
      :value: 'external'

      

   .. py:attribute:: PUBLIC
      :value: 'public'

      

   .. py:attribute:: INTERNAL
      :value: 'internal'

      

   .. py:attribute:: PRIVATE
      :value: 'private'

      

   .. py:attribute:: VIRTUAL
      :value: 'virtual'

      


.. py:class:: MutabilityModifierKind(*args, **kwds)


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

   .. py:attribute:: PURE
      :value: 'pure'

      

   .. py:attribute:: CONSTANT
      :value: 'constant'

      

   .. py:attribute:: VIEW
      :value: 'view'

      

   .. py:attribute:: PAYABLE
      :value: 'payable'

      

   .. py:attribute:: IMMUTABLE
      :value: 'immutable'

      


.. py:class:: VisibilityModifier2


   Bases: :py:obj:`Modifier`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: kind
      :type: VisibilityModifierKind

      


.. py:class:: MutabilityModifier2


   Bases: :py:obj:`Modifier`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: kind
      :type: MutabilityModifierKind

      


.. py:class:: InvocationModifier


   Bases: :py:obj:`Modifier`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: arguments
      :type: list[Expr]

      


.. py:class:: OverrideSpecifier


   Bases: :py:obj:`Modifier`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: arguments
      :type: list[solidity_parser.ast.types.UserType]

      


.. py:class:: SourceUnit


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: PragmaDirective


   Bases: :py:obj:`SourceUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: value
      :type: str | Expr

      


.. py:class:: ImportDirective


   Bases: :py:obj:`SourceUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: path
      :type: str

      


.. py:class:: GlobalImportDirective


   Bases: :py:obj:`ImportDirective`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: UnitImportDirective


   Bases: :py:obj:`ImportDirective`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: alias
      :type: Ident

      


.. py:class:: SymbolAlias


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: symbol
      :type: Ident

      

   .. py:attribute:: alias
      :type: Ident

      


.. py:class:: SymbolImportDirective


   Bases: :py:obj:`ImportDirective`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: aliases
      :type: list[SymbolAlias]

      


.. py:class:: ContractPart


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.


.. py:class:: SpecialFunctionKind(*args, **kwds)


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

   .. py:attribute:: CONSTRUCTOR
      :value: '<<constructor>>'

      

   .. py:attribute:: RECEIVE
      :value: '<<receive>>'

      

   .. py:attribute:: FALLBACK
      :value: '<<fallback>>'

      

   .. py:method:: __str__()

      Return str(self).



.. py:class:: FunctionDefinition


   Bases: :py:obj:`SourceUnit`, :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident | SpecialFunctionKind

      

   .. py:attribute:: parameters
      :type: list[Parameter]

      

   .. py:attribute:: modifiers
      :type: list[Modifier]

      

   .. py:attribute:: returns
      :type: list[Parameter]

      

   .. py:attribute:: code
      :type: Block

      


.. py:class:: ModifierDefinition


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: parameters
      :type: list[Parameter]

      

   .. py:attribute:: modifiers
      :type: list[Modifier]

      

   .. py:attribute:: code
      :type: Block

      


.. py:class:: StructMember


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: member_type
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: name
      :type: Ident

      


.. py:class:: StructDefinition


   Bases: :py:obj:`SourceUnit`, :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: members
      :type: list[StructMember]

      


.. py:class:: EnumDefinition


   Bases: :py:obj:`SourceUnit`, :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: values
      :type: list[Ident]

      


.. py:class:: StateVariableDeclaration


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var_type
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: modifiers
      :type: list[Modifier]

      

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: initial_value
      :type: Expr

      


.. py:class:: ConstantVariableDeclaration


   Bases: :py:obj:`SourceUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var_type
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: initial_value
      :type: Expr

      


.. py:class:: UserValueType


   Bases: :py:obj:`SourceUnit`, :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: value
      :type: solidity_parser.ast.types.Type

      


.. py:class:: EventParameter


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var_type
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: is_indexed
      :type: bool

      


.. py:class:: EventDefinition


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: is_anonymous
      :type: bool

      

   .. py:attribute:: parameters
      :type: list[EventParameter]

      


.. py:class:: ErrorParameter


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: var_type
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: name
      :type: Ident

      


.. py:class:: ErrorDefinition


   Bases: :py:obj:`SourceUnit`, :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: parameters
      :type: list[ErrorParameter]

      


.. py:class:: UsingAttachment


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: member_name
      :type: Ident

      


.. py:class:: UsingOperatorBinding


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: member_name
      :type: Ident

      

   .. py:attribute:: operator
      :type: UnaryOpCode | BinaryOpCode

      


.. py:class:: UsingDirective


   Bases: :py:obj:`ContractPart`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: library_name
      :type: Ident

      

   .. py:attribute:: override_type
      :type: solidity_parser.ast.types.Type

      

   .. py:attribute:: attachments_or_bindings
      :type: list[UsingAttachment | UsingOperatorBinding]

      

   .. py:attribute:: is_global
      :type: bool

      


.. py:class:: InheritSpecifier


   Bases: :py:obj:`AST1Node`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: solidity_parser.ast.types.UserType

      

   .. py:attribute:: args
      :type: list[Expr]

      


.. py:class:: ContractDefinition


   Bases: :py:obj:`SourceUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: is_abstract
      :type: bool

      

   .. py:attribute:: inherits
      :type: list[InheritSpecifier]

      

   .. py:attribute:: parts
      :type: list[ContractPart]

      


.. py:class:: InterfaceDefinition


   Bases: :py:obj:`SourceUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: inherits
      :type: list[InheritSpecifier]

      

   .. py:attribute:: parts
      :type: list[ContractPart]

      


.. py:class:: LibraryDefinition


   Bases: :py:obj:`SourceUnit`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: name
      :type: Ident

      

   .. py:attribute:: parts
      :type: list[ContractPart]

      


.. py:class:: CreateMetaType


   Bases: :py:obj:`Expr`

   Base class for all AST nodes. Includes source location information, code comments and a parenting mechanism so that
   clients can traverse all child and parent nodes.

   .. py:attribute:: base_type
      :type: solidity_parser.ast.types.Type

      


.. py:function:: has_modifier_kind(node, *kinds: VisibilityModifierKind | MutabilityModifierKind)


.. py:data:: ModFunErrEvt
   :type: TypeAlias

   

.. py:data:: Types
   :type: TypeAlias

   

