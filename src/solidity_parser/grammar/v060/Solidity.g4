// Copyright 2020 Gonçalo Sá <goncalo.sa@consensys.net>
// Copyright 2016-2019 Federico Bond <federicobond@gmail.com>
// Licensed under the MIT license. See LICENSE file in the project root for details.

// This grammar is much less strict than what Solidity currently parses
// to allow this to pass with older versions of Solidity.

grammar Solidity;

sourceUnit
  : (pragmaDirective | importDirective | structDefinition | enumDefinition | contractDefinition)* EOF ;

pragmaDirective
  : 'pragma' pragmaName pragmaValue ';' ;

pragmaName
  : identifier ;

pragmaValue
  : version | expression ;

version
  : versionConstraint versionConstraint? ;

versionConstraint
  : versionOperator? VersionLiteral ;

versionOperator
  : '^' | '~' | '>=' | '>' | '<' | '<=' | '=' ;

importDirective
  : 'import' StringLiteralFragment ('as' identifier)? ';' # ModuleImport
  | 'import' ('*' | symbol=identifier) ('as' unitAlias=identifier)? 'from' StringLiteralFragment ';' # AliasImport
  | 'import' '{' importDeclaration ( ',' importDeclaration )* '}' 'from' StringLiteralFragment ';' # SymbolImport
  ;

importDeclaration
  : identifier ('as' identifier)? ;

ContractKeyword : 'contract' ;
InterfaceKeyword : 'interface' ;
LibraryKeyword : 'library' ;

Abstract : 'abstract' ;

contractDefinition
  : Abstract? ( ContractKeyword | InterfaceKeyword | LibraryKeyword ) identifier
    ( 'is' inheritanceSpecifier (',' inheritanceSpecifier )* )?
    '{' contractPart* '}' ;

inheritanceSpecifier
  : userDefinedTypeName ( '(' expressionList? ')' )? ;

contractPart
  : stateVariableDeclaration
  | usingForDeclaration
  | structDefinition
  | modifierDefinition
  | functionDefinition
  | eventDefinition
  | enumDefinition ;

stateVariableDeclaration
  : typeName
    ( PublicKeyword | InternalKeyword | PrivateKeyword | ConstantKeyword | ImmutableKeyword | overrideSpecifier )*
    identifier ('=' expression)? ';' ;

overrideSpecifier : 'override' ( '(' userDefinedTypeName (',' userDefinedTypeName)* ')' )? ;

usingForDeclaration
  : 'using' identifier 'for' ('*' | typeName) ';' ;

structDefinition
  : 'struct' identifier
    '{' ( variableDeclaration ';' (variableDeclaration ';')* )? '}' ;

modifierDefinition
  : 'modifier' identifier parameterList? ( VirtualKeyword | overrideSpecifier )* ( ';' | block ) ;

functionDefinition
  : functionDescriptor parameterList modifierList returnParameters? ( ';' | block ) ;

functionDescriptor
    // The original grammar didn't contain ConstructorKeyword after 'function' but contract2244(0.4.15)
    // had an example of 'function constructor' so I added it here to parse - Bibl
  : 'function' ( identifier | ReceiveKeyword | FallbackKeyword | ConstructorKeyword )?
  | ConstructorKeyword
  | FallbackKeyword
  | ReceiveKeyword ;

returnParameters
  : 'returns' parameterList ;

modifierList
  : ( modifierInvocation | stateMutability | visibilityModifier | overrideSpecifier )* ;

modifierInvocation
  : identifier ( '(' expressionList? ')' )? ;

eventDefinition
  : 'event' identifier eventParameterList AnonymousKeyword? ';' ;

enumDefinition
  : 'enum' identifier '{' enumValue? (',' enumValue)* '}' ;

enumValue
  : identifier ;

parameterList
  : '(' ( parameter (',' parameter)* )? ')' ;

parameter
  : typeName storageLocation? identifier? ;

eventParameterList
  : '(' ( eventParameter (',' eventParameter)* )? ')' ;

eventParameter
  : typeName IndexedKeyword? identifier? ;

variableDeclaration
  : typeName storageLocation? identifier ;

typeName
  : elementaryTypeName
  | userDefinedTypeName
  | mapping
  | typeName '[' expression? ']'
  | functionTypeName ;

userDefinedTypeName
  : identifier ( '.' identifier )* ;

mapping
  : 'mapping' '(' mappingKey '=>' typeName ')' ;

mappingKey
  : elementaryTypeName
  | userDefinedTypeName ;

functionTypeName
  : 'function' parameterList modifierList returnParameters? ;

storageLocation
  : 'memory' | 'storage' | 'calldata';

stateMutability
  : PureKeyword | ConstantKeyword | ViewKeyword | PayableKeyword ;

visibilityModifier
  : ExternalKeyword | PublicKeyword | InternalKeyword | PrivateKeyword | VirtualKeyword ;

block
  : '{' statement* '}' ;

statement
  : ifStatement
  | tryStatement
  | whileStatement
  | forStatement
  | block
  | inlineAssemblyStatement
  | doWhileStatement
  | continueStatement
  | breakStatement
  | returnStatement
  | throwStatement
  | emitStatement
  | simpleStatement ;

expressionStatement
  : expression ';' ;

ifStatement
  : 'if' '(' expression ')' statement ( 'else' statement )? ;

tryStatement : 'try' expression returnParameters? block catchClause+ ;

// In reality catch clauses still are not processed as below
// the identifier can only be a set string: "Error". But plans
// of the Solidity team include possible expansion so we'll
// leave this as is, befitting with the Solidity docs.
catchClause : 'catch' ( identifier? parameterList )? block ;

whileStatement
  : 'while' '(' expression ')' statement ;

forStatement
  : 'for' '(' ( simpleStatement | ';' ) ( expressionStatement | ';' ) expression? ')' statement ;

simpleStatement
  : ( variableDeclarationStatement | expressionStatement ) ;

inlineAssemblyStatement
  : 'assembly' StringLiteralFragment? assemblyBlock ;

doWhileStatement
  : 'do' statement 'while' '(' expression ')' ';' ;

continueStatement
  : 'continue' ';' ;

breakStatement
  : 'break' ';' ;

returnStatement
  : 'return' expression? ';' ;

// throw is no longer supported by latest Solidity.
throwStatement
  : 'throw' ';' ;

emitStatement
  : 'emit' functionCall ';' ;

// 'var' is no longer supported by latest Solidity.
variableDeclarationStatement
  : ( 'var' identifierList | variableDeclaration | '(' variableDeclarationList ')' ) ( '=' expression )? ';';

variableDeclarationList
  : variableDeclaration? (',' variableDeclaration? )* ;

identifierList
  : '(' ( identifier? ',' )* identifier? ')' ;

elementaryTypeName
  : addressType
  | BoolType
  | StringType
  | VarType
  | Int
  | Uint
  | AByte
  | Byte
  | Fixed
  | Ufixed ;

addressType: 'address' PayableKeyword? ;

BoolType: 'bool' ;

StringType: 'string' ;

VarType: 'var' ;

Int
  : 'int' | 'int8' | 'int16' | 'int24' | 'int32' | 'int40' | 'int48' | 'int56' | 'int64' | 'int72' | 'int80' | 'int88' | 'int96' | 'int104' | 'int112' | 'int120' | 'int128' | 'int136' | 'int144' | 'int152' | 'int160' | 'int168' | 'int176' | 'int184' | 'int192' | 'int200' | 'int208' | 'int216' | 'int224' | 'int232' | 'int240' | 'int248' | 'int256' ;

Uint
  : 'uint' | 'uint8' | 'uint16' | 'uint24' | 'uint32' | 'uint40' | 'uint48' | 'uint56' | 'uint64' | 'uint72' | 'uint80' | 'uint88' | 'uint96' | 'uint104' | 'uint112' | 'uint120' | 'uint128' | 'uint136' | 'uint144' | 'uint152' | 'uint160' | 'uint168' | 'uint176' | 'uint184' | 'uint192' | 'uint200' | 'uint208' | 'uint216' | 'uint224' | 'uint232' | 'uint240' | 'uint248' | 'uint256' ;

AByte : 'byte' ;

Byte
  : 'bytes' | 'bytes1' | 'bytes2' | 'bytes3' | 'bytes4' | 'bytes5' | 'bytes6' | 'bytes7' | 'bytes8' | 'bytes9' | 'bytes10' | 'bytes11' | 'bytes12' | 'bytes13' | 'bytes14' | 'bytes15' | 'bytes16' | 'bytes17' | 'bytes18' | 'bytes19' | 'bytes20' | 'bytes21' | 'bytes22' | 'bytes23' | 'bytes24' | 'bytes25' | 'bytes26' | 'bytes27' | 'bytes28' | 'bytes29' | 'bytes30' | 'bytes31' | 'bytes32' ;

Fixed
  : 'fixed' | ( 'fixed'  [0-9]+ 'x' [0-9]+ ) ;

Ufixed
  : 'ufixed' | ( 'ufixed' [0-9]+ 'x' [0-9]+ ) ;

expression
  : expression ('++' | '--') # UnaryPostOp
  | 'new' typeName # NewType
  | expression '[' expression? ']' # ArrayLoad
  | base=expression '[' start_expr=expression? ':' end_expr=expression? ']' # ArraySlice
  | expression '.' identifier # MemberLoad
//  | expression '{' nameValueList '}' # FCNamedExpr
//  | expression '(' functionCallArguments ')' # FCArgExpr
  | expression ( '{' nameValueList? '}' )? '(' functionCallArguments ')' # FuncCallExpr
  | TypeKeyword '(' typeName ')' # MetaType
  | PayableKeyword '(' expression ')' # PayableExpr
  | '(' expression ')' # BracketExpr
  | ('++' | '--') expression # UnaryPreOp
  | ('+' | '-') expression # UnaryPreOp
  | 'delete' expression # DeleteExpr
  | 'after' expression # ReservedKeyExpr
  | '!' expression # LogicOp
  | '~' expression # LogicOp
  | expression '**' expression # BinaryExpr
  | expression ('*' | '/' | '%') expression # BinaryExpr
  | expression ('+' | '-') expression # BinaryExpr
  | expression ('<<' | '>>') expression # BinaryExpr
  | expression '&' expression # BinaryExpr
  | expression '^' expression # BinaryExpr
  | expression '|' expression # BinaryExpr
  | expression ('<' | '>' | '<=' | '>=') expression # BinaryExpr
  | expression ('==' | '!=') expression # BinaryExpr
  | expression '&&' expression # BinaryExpr
  | expression '||' expression # BinaryExpr
  | expression '?' (expression ':' expression) # TernaryExpr
  | expression ('=' | '|=' | '^=' | '&=' | '<<=' | '>>=' | '+=' | '-=' | '*=' | '/=' | '%=') expression # BinaryExpr
  | primaryExpression  # Primary;

primaryExpression
  : BooleanLiteral
  | numberLiteral
  | hexLiteral
  | stringLiteral
  | identifier arrayBrackets?
  | tupleExpression
  | typeNameExpression arrayBrackets? ;

arrayBrackets : ('[' ']') ;

expressionList
  : expression (',' expression)* ;

nameValueList
  : nameValue (',' nameValue)* ','? ;

nameValue
  : identifier ':' expression ;

functionCallArguments
  : '{' nameValueList? '}'
  | expressionList? ;

functionCall
  : expression '(' functionCallArguments ')' ;

tupleExpression
  : '(' ( expression? ( ',' expression? )* ) ')'
  | '[' ( expression ( ',' expression )* )? ']' ;

typeNameExpression
  : elementaryTypeName
  | userDefinedTypeName ;

assemblyItem
  : identifier
  | assemblyBlock
  | assemblyExpression
  | assemblyLocalDefinition
  | assemblyAssignment
  | assemblyStackAssignment
  | labelDefinition
  | assemblySwitch
  | assemblyFunctionDefinition
  | assemblyFor
  | assemblyIf
  | BreakKeyword
  | ContinueKeyword
  | LeaveKeyword
  | subAssembly
  | numberLiteral
  | stringLiteral
  | hexLiteral ;

assemblyBlock
  : '{' assemblyItem* '}' ;

assemblyExpression
  : assemblyCall | assemblyLiteral ;

assemblyCall
  : ( 'return' | 'address' | AByte | identifier ) ( '(' assemblyExpression? ( ',' assemblyExpression )* ')' )? ;

assemblyLocalDefinition
  : 'let' assemblyIdentifierList ( ':=' assemblyExpression )? ;

assemblyAssignment
  : assemblyIdentifierList ':=' assemblyExpression ;

assemblyIdentifierList
  : identifier ( ',' identifier )* ;

assemblyStackAssignment
  : '=:' identifier ;

labelDefinition
  : identifier ':' ;

assemblySwitch
  : 'switch' assemblyExpression assemblyCase* ;

assemblyCase
  : 'case' assemblyLiteral assemblyType? assemblyBlock
  | 'default' assemblyBlock ;

assemblyFunctionDefinition
  : 'function' identifier '(' assemblyTypedVariableList? ')'
    assemblyFunctionReturns? assemblyBlock ;

assemblyFunctionReturns
  : ( '-' '>' assemblyTypedVariableList ) ;

assemblyFor
  : 'for' assemblyBlock assemblyExpression assemblyBlock assemblyBlock ;

assemblyIf
  : 'if' assemblyExpression assemblyBlock ;

assemblyLiteral
  : ( stringLiteral | DecimalNumber | HexNumber | hexLiteral | BooleanLiteral ) assemblyType? ;

assemblyTypedVariableList
  : identifier assemblyType? ( ',' assemblyTypedVariableList )? ;

assemblyType
  : ':' identifier ;

subAssembly
  : 'assembly' identifier assemblyBlock ;

numberLiteral
  : (DecimalNumber | HexNumber) NumberUnit? ;

identifier
// commented out 'address' as an ident, it's a type...
  : ('from' | 'calldata' | /*'address' |*/ Identifier) ;

BooleanLiteral
  : 'true' | 'false' ;

DecimalNumber
  : ( DecimalDigits | (DecimalDigits? '.' DecimalDigits) ) ( [eE] '-'? DecimalDigits )? ;

fragment
DecimalDigits
  : [0-9] ( '_'? [0-9] )* ;

HexNumber
  : '0' [xX] HexDigits ;

fragment
HexDigits
  : HexCharacter ( '_'? HexCharacter )* ;

NumberUnit
  : 'wei' | 'szabo' | 'finney' | 'ether'
  | 'seconds' | 'minutes' | 'hours' | 'days' | 'weeks' | 'years' ;

HexLiteralFragment
  : 'hex' (('"' HexDigits? '"') | ('\'' HexDigits? '\'')) ;

hexLiteral : HexLiteralFragment+ ;

fragment
HexPair
  : HexCharacter HexCharacter ;

fragment
HexCharacter
  : [0-9A-Fa-f] ;

ReservedKeyword
  : 'after'
  | 'case'
  | 'default'
  | 'final'
  | 'in'
  | 'inline'
  | 'let'
  | 'match'
  | 'null'
  | 'of'
  | 'relocatable'
  | 'static'
  | 'switch'
  | 'typeof' ;

AnonymousKeyword : 'anonymous' ;
BreakKeyword : 'break' ;
ConstantKeyword : 'constant' ;
ImmutableKeyword : 'immutable' ;
ContinueKeyword : 'continue' ;
LeaveKeyword : 'leave' ;
ExternalKeyword : 'external' ;
IndexedKeyword : 'indexed' ;
InternalKeyword : 'internal' ;
PayableKeyword : 'payable' ;
PrivateKeyword : 'private' ;
PublicKeyword : 'public' ;
VirtualKeyword : 'virtual' ;
PureKeyword : 'pure' ;
TypeKeyword : 'type' ;
ViewKeyword : 'view' ;

ConstructorKeyword : 'constructor' ;
FallbackKeyword : 'fallback' ;
ReceiveKeyword : 'receive' ;

Identifier
  : IdentifierStart IdentifierPart* ;

fragment
IdentifierStart
  : [a-zA-Z$_] ;

fragment
IdentifierPart
  : [a-zA-Z0-9$_] ;

stringLiteral
  : StringLiteralFragment+ ;

StringLiteralFragment
  : '"' DoubleQuotedStringCharacter* '"'
  | '\'' SingleQuotedStringCharacter* '\'' ;

fragment
DoubleQuotedStringCharacter
  : ~["\r\n\\] | ('\\' .) ;

fragment
SingleQuotedStringCharacter
  : ~['\r\n\\] | ('\\' .) ;

VersionLiteral
  : [0-9]+ ( '.' [0-9]+ ('.' [0-9]+)? )? ;

WS
  : [ \t\r\n\u000C]+ -> skip ;

COMMENT
  : '/*' .*? '*/' -> channel(HIDDEN) ;

LINE_COMMENT
  : '//' ~[\r\n]* -> channel(HIDDEN) ;

