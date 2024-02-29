// Generated from java-escape by ANTLR 4.11.1
package solidity_parser.grammar.v088;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SolidityParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ReservedKeywords=1, Pragma=2, Abstract=3, Anonymous=4, Address=5, As=6, 
		Assembly=7, Bool=8, Break=9, Bytes=10, Calldata=11, Catch=12, Constant=13, 
		Constructor=14, Continue=15, Contract=16, Delete=17, Do=18, Else=19, Emit=20, 
		Enum=21, Error=22, Revert=23, Event=24, External=25, Fallback=26, False_=27, 
		Fixed=28, From=29, FixedBytes=30, For=31, Function=32, Hex=33, If=34, 
		Immutable=35, Import=36, Indexed=37, Interface=38, Internal=39, Is=40, 
		Library=41, Mapping=42, Memory=43, Modifier=44, New=45, NumberUnit=46, 
		Override=47, Payable=48, Private=49, Public=50, Pure=51, Receive=52, Return=53, 
		Returns=54, SignedIntegerType=55, Storage=56, String=57, Struct=58, True_=59, 
		Try=60, Type=61, Ufixed=62, Unchecked=63, UnsignedIntegerType=64, Using=65, 
		View=66, Virtual=67, While=68, LParen=69, RParen=70, LBrack=71, RBrack=72, 
		LBrace=73, RBrace=74, Colon=75, Semicolon=76, Period=77, Conditional=78, 
		DoubleArrow=79, RightArrow=80, Assign=81, AssignBitOr=82, AssignBitXor=83, 
		AssignBitAnd=84, AssignShl=85, AssignSar=86, AssignShr=87, AssignAdd=88, 
		AssignSub=89, AssignMul=90, AssignDiv=91, AssignMod=92, Comma=93, Or=94, 
		And=95, BitOr=96, BitXor=97, BitAnd=98, Shl=99, Sar=100, Shr=101, Add=102, 
		Sub=103, Mul=104, Div=105, Mod=106, Exp=107, Equal=108, NotEqual=109, 
		LessThan=110, GreaterThan=111, LessThanOrEqual=112, GreaterThanOrEqual=113, 
		Not=114, BitNot=115, Inc=116, Dec=117, DoubleQuote=118, SingleQuote=119, 
		NonEmptyStringLiteral=120, EmptyStringLiteral=121, UnicodeStringLiteral=122, 
		HexString=123, HexNumber=124, DecimalNumber=125, Identifier=126, WS=127, 
		COMMENT=128, LINE_COMMENT=129, AssemblyDialect=130, AssemblyLBrace=131, 
		AssemblyBlockWS=132, AssemblyBlockCOMMENT=133, AssemblyBlockLINE_COMMENT=134, 
		YulBreak=135, YulCase=136, YulContinue=137, YulDefault=138, YulFalse=139, 
		YulFor=140, YulFunction=141, YulIf=142, YulLeave=143, YulLet=144, YulSwitch=145, 
		YulTrue=146, YulHex=147, YulEVMBuiltin=148, YulLBrace=149, YulRBrace=150, 
		YulLParen=151, YulRParen=152, YulAssign=153, YulPeriod=154, YulComma=155, 
		YulArrow=156, YulIdentifier=157, YulHexNumber=158, YulDecimalNumber=159, 
		YulStringLiteral=160, YulHexStringLiteral=161, YulWS=162, YulCOMMENT=163, 
		YulLINE_COMMENT=164, PragmaToken=165, PragmaSemicolon=166, PragmaWS=167, 
		PragmaCOMMENT=168, PragmaLINE_COMMENT=169;
	public static final int
		RULE_sourceUnit = 0, RULE_pragmaDirective = 1, RULE_importDirective = 2, 
		RULE_importAliases = 3, RULE_path = 4, RULE_symbolAliases = 5, RULE_contractDefinition = 6, 
		RULE_interfaceDefinition = 7, RULE_libraryDefinition = 8, RULE_inheritanceSpecifierList = 9, 
		RULE_inheritanceSpecifier = 10, RULE_contractBodyElement = 11, RULE_namedArgument = 12, 
		RULE_callArgumentList = 13, RULE_identifierPath = 14, RULE_modifierInvocation = 15, 
		RULE_visibility = 16, RULE_parameterList = 17, RULE_parameterDeclaration = 18, 
		RULE_constructorDefinition = 19, RULE_stateMutability = 20, RULE_overrideSpecifier = 21, 
		RULE_functionDefinition = 22, RULE_modifierDefinition = 23, RULE_fallbackFunctionDefinition = 24, 
		RULE_receiveFunctionDefinition = 25, RULE_structDefinition = 26, RULE_structMember = 27, 
		RULE_enumDefinition = 28, RULE_userDefinedValueTypeDefinition = 29, RULE_stateVariableDeclaration = 30, 
		RULE_constantVariableDeclaration = 31, RULE_eventParameter = 32, RULE_eventDefinition = 33, 
		RULE_errorParameter = 34, RULE_errorDefinition = 35, RULE_usingDirective = 36, 
		RULE_typeName = 37, RULE_elementaryTypeName = 38, RULE_functionTypeName = 39, 
		RULE_variableDeclaration = 40, RULE_dataLocation = 41, RULE_expression = 42, 
		RULE_assignOp = 43, RULE_tupleExpression = 44, RULE_inlineArrayExpression = 45, 
		RULE_identifier = 46, RULE_literal = 47, RULE_booleanLiteral = 48, RULE_stringLiteral = 49, 
		RULE_hexStringLiteral = 50, RULE_unicodeStringLiteral = 51, RULE_numberLiteral = 52, 
		RULE_block = 53, RULE_uncheckedBlock = 54, RULE_statement = 55, RULE_simpleStatement = 56, 
		RULE_ifStatement = 57, RULE_forStatement = 58, RULE_whileStatement = 59, 
		RULE_doWhileStatement = 60, RULE_continueStatement = 61, RULE_breakStatement = 62, 
		RULE_tryStatement = 63, RULE_catchClause = 64, RULE_returnStatement = 65, 
		RULE_emitStatement = 66, RULE_revertStatement = 67, RULE_assemblyStatement = 68, 
		RULE_variableDeclarationList = 69, RULE_variableDeclarationTuple = 70, 
		RULE_variableDeclarationStatement = 71, RULE_expressionStatement = 72, 
		RULE_mappingType = 73, RULE_mappingKeyType = 74, RULE_yulStatement = 75, 
		RULE_yulBlock = 76, RULE_yulVariableDeclaration = 77, RULE_yulAssignment = 78, 
		RULE_yulIfStatement = 79, RULE_yulForStatement = 80, RULE_yulSwitchCase = 81, 
		RULE_yulSwitchStatement = 82, RULE_yulFunctionDefinition = 83, RULE_yulPath = 84, 
		RULE_yulFunctionCall = 85, RULE_yulBoolean = 86, RULE_yulLiteral = 87, 
		RULE_yulExpression = 88;
	private static String[] makeRuleNames() {
		return new String[] {
			"sourceUnit", "pragmaDirective", "importDirective", "importAliases", 
			"path", "symbolAliases", "contractDefinition", "interfaceDefinition", 
			"libraryDefinition", "inheritanceSpecifierList", "inheritanceSpecifier", 
			"contractBodyElement", "namedArgument", "callArgumentList", "identifierPath", 
			"modifierInvocation", "visibility", "parameterList", "parameterDeclaration", 
			"constructorDefinition", "stateMutability", "overrideSpecifier", "functionDefinition", 
			"modifierDefinition", "fallbackFunctionDefinition", "receiveFunctionDefinition", 
			"structDefinition", "structMember", "enumDefinition", "userDefinedValueTypeDefinition", 
			"stateVariableDeclaration", "constantVariableDeclaration", "eventParameter", 
			"eventDefinition", "errorParameter", "errorDefinition", "usingDirective", 
			"typeName", "elementaryTypeName", "functionTypeName", "variableDeclaration", 
			"dataLocation", "expression", "assignOp", "tupleExpression", "inlineArrayExpression", 
			"identifier", "literal", "booleanLiteral", "stringLiteral", "hexStringLiteral", 
			"unicodeStringLiteral", "numberLiteral", "block", "uncheckedBlock", "statement", 
			"simpleStatement", "ifStatement", "forStatement", "whileStatement", "doWhileStatement", 
			"continueStatement", "breakStatement", "tryStatement", "catchClause", 
			"returnStatement", "emitStatement", "revertStatement", "assemblyStatement", 
			"variableDeclarationList", "variableDeclarationTuple", "variableDeclarationStatement", 
			"expressionStatement", "mappingType", "mappingKeyType", "yulStatement", 
			"yulBlock", "yulVariableDeclaration", "yulAssignment", "yulIfStatement", 
			"yulForStatement", "yulSwitchCase", "yulSwitchStatement", "yulFunctionDefinition", 
			"yulPath", "yulFunctionCall", "yulBoolean", "yulLiteral", "yulExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'pragma'", "'abstract'", "'anonymous'", "'address'", "'as'", 
			"'assembly'", "'bool'", null, "'bytes'", "'calldata'", "'catch'", "'constant'", 
			"'constructor'", null, "'contract'", "'delete'", "'do'", "'else'", "'emit'", 
			"'enum'", "'error'", "'revert'", "'event'", "'external'", "'fallback'", 
			null, null, "'from'", null, null, null, null, null, "'immutable'", "'import'", 
			"'indexed'", "'interface'", "'internal'", "'is'", "'library'", "'mapping'", 
			"'memory'", "'modifier'", "'new'", null, "'override'", "'payable'", "'private'", 
			"'public'", "'pure'", "'receive'", "'return'", "'returns'", null, "'storage'", 
			"'string'", "'struct'", null, "'try'", "'type'", null, "'unchecked'", 
			null, "'using'", "'view'", "'virtual'", "'while'", null, null, "'['", 
			"']'", null, null, "':'", null, null, "'?'", "'=>'", null, "'='", "'|='", 
			"'^='", "'&='", "'<<='", "'>>='", "'>>>='", "'+='", "'-='", "'*='", "'/='", 
			"'%='", null, "'||'", "'&&'", "'|'", "'^'", "'&'", "'<<'", "'>>'", "'>>>'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'=='", "'!='", "'<'", "'>'", 
			"'<='", "'>='", "'!'", "'~'", "'++'", "'--'", "'\"'", "'''", null, null, 
			null, null, null, null, null, null, null, null, "'\"evmasm\"'", null, 
			null, null, null, null, "'case'", null, "'default'", null, null, null, 
			null, "'leave'", "'let'", "'switch'", null, null, null, null, null, null, 
			null, "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ReservedKeywords", "Pragma", "Abstract", "Anonymous", "Address", 
			"As", "Assembly", "Bool", "Break", "Bytes", "Calldata", "Catch", "Constant", 
			"Constructor", "Continue", "Contract", "Delete", "Do", "Else", "Emit", 
			"Enum", "Error", "Revert", "Event", "External", "Fallback", "False_", 
			"Fixed", "From", "FixedBytes", "For", "Function", "Hex", "If", "Immutable", 
			"Import", "Indexed", "Interface", "Internal", "Is", "Library", "Mapping", 
			"Memory", "Modifier", "New", "NumberUnit", "Override", "Payable", "Private", 
			"Public", "Pure", "Receive", "Return", "Returns", "SignedIntegerType", 
			"Storage", "String", "Struct", "True_", "Try", "Type", "Ufixed", "Unchecked", 
			"UnsignedIntegerType", "Using", "View", "Virtual", "While", "LParen", 
			"RParen", "LBrack", "RBrack", "LBrace", "RBrace", "Colon", "Semicolon", 
			"Period", "Conditional", "DoubleArrow", "RightArrow", "Assign", "AssignBitOr", 
			"AssignBitXor", "AssignBitAnd", "AssignShl", "AssignSar", "AssignShr", 
			"AssignAdd", "AssignSub", "AssignMul", "AssignDiv", "AssignMod", "Comma", 
			"Or", "And", "BitOr", "BitXor", "BitAnd", "Shl", "Sar", "Shr", "Add", 
			"Sub", "Mul", "Div", "Mod", "Exp", "Equal", "NotEqual", "LessThan", "GreaterThan", 
			"LessThanOrEqual", "GreaterThanOrEqual", "Not", "BitNot", "Inc", "Dec", 
			"DoubleQuote", "SingleQuote", "NonEmptyStringLiteral", "EmptyStringLiteral", 
			"UnicodeStringLiteral", "HexString", "HexNumber", "DecimalNumber", "Identifier", 
			"WS", "COMMENT", "LINE_COMMENT", "AssemblyDialect", "AssemblyLBrace", 
			"AssemblyBlockWS", "AssemblyBlockCOMMENT", "AssemblyBlockLINE_COMMENT", 
			"YulBreak", "YulCase", "YulContinue", "YulDefault", "YulFalse", "YulFor", 
			"YulFunction", "YulIf", "YulLeave", "YulLet", "YulSwitch", "YulTrue", 
			"YulHex", "YulEVMBuiltin", "YulLBrace", "YulRBrace", "YulLParen", "YulRParen", 
			"YulAssign", "YulPeriod", "YulComma", "YulArrow", "YulIdentifier", "YulHexNumber", 
			"YulDecimalNumber", "YulStringLiteral", "YulHexStringLiteral", "YulWS", 
			"YulCOMMENT", "YulLINE_COMMENT", "PragmaToken", "PragmaSemicolon", "PragmaWS", 
			"PragmaCOMMENT", "PragmaLINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SolidityParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SourceUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SolidityParser.EOF, 0); }
		public List<PragmaDirectiveContext> pragmaDirective() {
			return getRuleContexts(PragmaDirectiveContext.class);
		}
		public PragmaDirectiveContext pragmaDirective(int i) {
			return getRuleContext(PragmaDirectiveContext.class,i);
		}
		public List<ImportDirectiveContext> importDirective() {
			return getRuleContexts(ImportDirectiveContext.class);
		}
		public ImportDirectiveContext importDirective(int i) {
			return getRuleContext(ImportDirectiveContext.class,i);
		}
		public List<ContractDefinitionContext> contractDefinition() {
			return getRuleContexts(ContractDefinitionContext.class);
		}
		public ContractDefinitionContext contractDefinition(int i) {
			return getRuleContext(ContractDefinitionContext.class,i);
		}
		public List<InterfaceDefinitionContext> interfaceDefinition() {
			return getRuleContexts(InterfaceDefinitionContext.class);
		}
		public InterfaceDefinitionContext interfaceDefinition(int i) {
			return getRuleContext(InterfaceDefinitionContext.class,i);
		}
		public List<LibraryDefinitionContext> libraryDefinition() {
			return getRuleContexts(LibraryDefinitionContext.class);
		}
		public LibraryDefinitionContext libraryDefinition(int i) {
			return getRuleContext(LibraryDefinitionContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<ConstantVariableDeclarationContext> constantVariableDeclaration() {
			return getRuleContexts(ConstantVariableDeclarationContext.class);
		}
		public ConstantVariableDeclarationContext constantVariableDeclaration(int i) {
			return getRuleContext(ConstantVariableDeclarationContext.class,i);
		}
		public List<StructDefinitionContext> structDefinition() {
			return getRuleContexts(StructDefinitionContext.class);
		}
		public StructDefinitionContext structDefinition(int i) {
			return getRuleContext(StructDefinitionContext.class,i);
		}
		public List<EnumDefinitionContext> enumDefinition() {
			return getRuleContexts(EnumDefinitionContext.class);
		}
		public EnumDefinitionContext enumDefinition(int i) {
			return getRuleContext(EnumDefinitionContext.class,i);
		}
		public List<UserDefinedValueTypeDefinitionContext> userDefinedValueTypeDefinition() {
			return getRuleContexts(UserDefinedValueTypeDefinitionContext.class);
		}
		public UserDefinedValueTypeDefinitionContext userDefinedValueTypeDefinition(int i) {
			return getRuleContext(UserDefinedValueTypeDefinitionContext.class,i);
		}
		public List<ErrorDefinitionContext> errorDefinition() {
			return getRuleContexts(ErrorDefinitionContext.class);
		}
		public ErrorDefinitionContext errorDefinition(int i) {
			return getRuleContext(ErrorDefinitionContext.class,i);
		}
		public SourceUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterSourceUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitSourceUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitSourceUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceUnitContext sourceUnit() throws RecognitionException {
		SourceUnitContext _localctx = new SourceUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sourceUnit);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(189);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(178);
						pragmaDirective();
						}
						break;
					case 2:
						{
						setState(179);
						importDirective();
						}
						break;
					case 3:
						{
						setState(180);
						contractDefinition();
						}
						break;
					case 4:
						{
						setState(181);
						interfaceDefinition();
						}
						break;
					case 5:
						{
						setState(182);
						libraryDefinition();
						}
						break;
					case 6:
						{
						setState(183);
						functionDefinition();
						}
						break;
					case 7:
						{
						setState(184);
						constantVariableDeclaration();
						}
						break;
					case 8:
						{
						setState(185);
						structDefinition();
						}
						break;
					case 9:
						{
						setState(186);
						enumDefinition();
						}
						break;
					case 10:
						{
						setState(187);
						userDefinedValueTypeDefinition();
						}
						break;
					case 11:
						{
						setState(188);
						errorDefinition();
						}
						break;
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(194);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PragmaDirectiveContext extends ParserRuleContext {
		public TerminalNode Pragma() { return getToken(SolidityParser.Pragma, 0); }
		public TerminalNode PragmaSemicolon() { return getToken(SolidityParser.PragmaSemicolon, 0); }
		public List<TerminalNode> PragmaToken() { return getTokens(SolidityParser.PragmaToken); }
		public TerminalNode PragmaToken(int i) {
			return getToken(SolidityParser.PragmaToken, i);
		}
		public PragmaDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterPragmaDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitPragmaDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitPragmaDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PragmaDirectiveContext pragmaDirective() throws RecognitionException {
		PragmaDirectiveContext _localctx = new PragmaDirectiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pragmaDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(Pragma);
			setState(198); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(197);
				match(PragmaToken);
				}
				}
				setState(200); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PragmaToken );
			setState(202);
			match(PragmaSemicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDirectiveContext extends ParserRuleContext {
		public IdentifierContext unitAlias;
		public TerminalNode Import() { return getToken(SolidityParser.Import, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public SymbolAliasesContext symbolAliases() {
			return getRuleContext(SymbolAliasesContext.class,0);
		}
		public TerminalNode From() { return getToken(SolidityParser.From, 0); }
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TerminalNode As() { return getToken(SolidityParser.As, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ImportDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterImportDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitImportDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitImportDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDirectiveContext importDirective() throws RecognitionException {
		ImportDirectiveContext _localctx = new ImportDirectiveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(Import);
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NonEmptyStringLiteral:
				{
				{
				setState(205);
				path();
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==As) {
					{
					setState(206);
					match(As);
					setState(207);
					((ImportDirectiveContext)_localctx).unitAlias = identifier();
					}
				}

				}
				}
				break;
			case LBrace:
				{
				{
				setState(210);
				symbolAliases();
				setState(211);
				match(From);
				setState(212);
				path();
				}
				}
				break;
			case Mul:
				{
				{
				setState(214);
				match(Mul);
				setState(215);
				match(As);
				setState(216);
				((ImportDirectiveContext)_localctx).unitAlias = identifier();
				setState(217);
				match(From);
				setState(218);
				path();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(222);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportAliasesContext extends ParserRuleContext {
		public IdentifierContext symbol;
		public IdentifierContext alias;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode As() { return getToken(SolidityParser.As, 0); }
		public ImportAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importAliases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterImportAliases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitImportAliases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitImportAliases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportAliasesContext importAliases() throws RecognitionException {
		ImportAliasesContext _localctx = new ImportAliasesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			((ImportAliasesContext)_localctx).symbol = identifier();
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(225);
				match(As);
				setState(226);
				((ImportAliasesContext)_localctx).alias = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathContext extends ParserRuleContext {
		public TerminalNode NonEmptyStringLiteral() { return getToken(SolidityParser.NonEmptyStringLiteral, 0); }
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(NonEmptyStringLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SymbolAliasesContext extends ParserRuleContext {
		public ImportAliasesContext importAliases;
		public List<ImportAliasesContext> aliases = new ArrayList<ImportAliasesContext>();
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<ImportAliasesContext> importAliases() {
			return getRuleContexts(ImportAliasesContext.class);
		}
		public ImportAliasesContext importAliases(int i) {
			return getRuleContext(ImportAliasesContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public SymbolAliasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolAliases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterSymbolAliases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitSymbolAliases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitSymbolAliases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolAliasesContext symbolAliases() throws RecognitionException {
		SymbolAliasesContext _localctx = new SymbolAliasesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_symbolAliases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(LBrace);
			setState(232);
			((SymbolAliasesContext)_localctx).importAliases = importAliases();
			((SymbolAliasesContext)_localctx).aliases.add(((SymbolAliasesContext)_localctx).importAliases);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(233);
				match(Comma);
				setState(234);
				((SymbolAliasesContext)_localctx).importAliases = importAliases();
				((SymbolAliasesContext)_localctx).aliases.add(((SymbolAliasesContext)_localctx).importAliases);
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(240);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContractDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Contract() { return getToken(SolidityParser.Contract, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Abstract() { return getToken(SolidityParser.Abstract, 0); }
		public InheritanceSpecifierListContext inheritanceSpecifierList() {
			return getRuleContext(InheritanceSpecifierListContext.class,0);
		}
		public List<ContractBodyElementContext> contractBodyElement() {
			return getRuleContexts(ContractBodyElementContext.class);
		}
		public ContractBodyElementContext contractBodyElement(int i) {
			return getRuleContext(ContractBodyElementContext.class,i);
		}
		public ContractDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterContractDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitContractDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitContractDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContractDefinitionContext contractDefinition() throws RecognitionException {
		ContractDefinitionContext _localctx = new ContractDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_contractDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract) {
				{
				setState(242);
				match(Abstract);
				}
			}

			setState(245);
			match(Contract);
			setState(246);
			((ContractDefinitionContext)_localctx).name = identifier();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Is) {
				{
				setState(247);
				inheritanceSpecifierList();
				}
			}

			setState(250);
			match(LBrace);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(251);
					contractBodyElement();
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(257);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Interface() { return getToken(SolidityParser.Interface, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InheritanceSpecifierListContext inheritanceSpecifierList() {
			return getRuleContext(InheritanceSpecifierListContext.class,0);
		}
		public List<ContractBodyElementContext> contractBodyElement() {
			return getRuleContexts(ContractBodyElementContext.class);
		}
		public ContractBodyElementContext contractBodyElement(int i) {
			return getRuleContext(ContractBodyElementContext.class,i);
		}
		public InterfaceDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInterfaceDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInterfaceDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInterfaceDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceDefinitionContext interfaceDefinition() throws RecognitionException {
		InterfaceDefinitionContext _localctx = new InterfaceDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_interfaceDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(Interface);
			setState(260);
			((InterfaceDefinitionContext)_localctx).name = identifier();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Is) {
				{
				setState(261);
				inheritanceSpecifierList();
				}
			}

			setState(264);
			match(LBrace);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(265);
					contractBodyElement();
					}
					} 
				}
				setState(270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(271);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LibraryDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Library() { return getToken(SolidityParser.Library, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ContractBodyElementContext> contractBodyElement() {
			return getRuleContexts(ContractBodyElementContext.class);
		}
		public ContractBodyElementContext contractBodyElement(int i) {
			return getRuleContext(ContractBodyElementContext.class,i);
		}
		public LibraryDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_libraryDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterLibraryDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitLibraryDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitLibraryDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LibraryDefinitionContext libraryDefinition() throws RecognitionException {
		LibraryDefinitionContext _localctx = new LibraryDefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_libraryDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(Library);
			setState(274);
			((LibraryDefinitionContext)_localctx).name = identifier();
			setState(275);
			match(LBrace);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(276);
					contractBodyElement();
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(282);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InheritanceSpecifierListContext extends ParserRuleContext {
		public InheritanceSpecifierContext inheritanceSpecifier;
		public List<InheritanceSpecifierContext> inheritanceSpecifiers = new ArrayList<InheritanceSpecifierContext>();
		public TerminalNode Is() { return getToken(SolidityParser.Is, 0); }
		public List<InheritanceSpecifierContext> inheritanceSpecifier() {
			return getRuleContexts(InheritanceSpecifierContext.class);
		}
		public InheritanceSpecifierContext inheritanceSpecifier(int i) {
			return getRuleContext(InheritanceSpecifierContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public InheritanceSpecifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritanceSpecifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInheritanceSpecifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInheritanceSpecifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInheritanceSpecifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritanceSpecifierListContext inheritanceSpecifierList() throws RecognitionException {
		InheritanceSpecifierListContext _localctx = new InheritanceSpecifierListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inheritanceSpecifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(Is);
			setState(285);
			((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier = inheritanceSpecifier();
			((InheritanceSpecifierListContext)_localctx).inheritanceSpecifiers.add(((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier);
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(286);
					match(Comma);
					setState(287);
					((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier = inheritanceSpecifier();
					((InheritanceSpecifierListContext)_localctx).inheritanceSpecifiers.add(((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier);
					}
					} 
				}
				setState(292);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InheritanceSpecifierContext extends ParserRuleContext {
		public IdentifierPathContext name;
		public CallArgumentListContext arguments;
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public InheritanceSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritanceSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInheritanceSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInheritanceSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInheritanceSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritanceSpecifierContext inheritanceSpecifier() throws RecognitionException {
		InheritanceSpecifierContext _localctx = new InheritanceSpecifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inheritanceSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			((InheritanceSpecifierContext)_localctx).name = identifierPath();
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(294);
				((InheritanceSpecifierContext)_localctx).arguments = callArgumentList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContractBodyElementContext extends ParserRuleContext {
		public ConstructorDefinitionContext constructorDefinition() {
			return getRuleContext(ConstructorDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public ModifierDefinitionContext modifierDefinition() {
			return getRuleContext(ModifierDefinitionContext.class,0);
		}
		public FallbackFunctionDefinitionContext fallbackFunctionDefinition() {
			return getRuleContext(FallbackFunctionDefinitionContext.class,0);
		}
		public ReceiveFunctionDefinitionContext receiveFunctionDefinition() {
			return getRuleContext(ReceiveFunctionDefinitionContext.class,0);
		}
		public StructDefinitionContext structDefinition() {
			return getRuleContext(StructDefinitionContext.class,0);
		}
		public EnumDefinitionContext enumDefinition() {
			return getRuleContext(EnumDefinitionContext.class,0);
		}
		public UserDefinedValueTypeDefinitionContext userDefinedValueTypeDefinition() {
			return getRuleContext(UserDefinedValueTypeDefinitionContext.class,0);
		}
		public StateVariableDeclarationContext stateVariableDeclaration() {
			return getRuleContext(StateVariableDeclarationContext.class,0);
		}
		public EventDefinitionContext eventDefinition() {
			return getRuleContext(EventDefinitionContext.class,0);
		}
		public ErrorDefinitionContext errorDefinition() {
			return getRuleContext(ErrorDefinitionContext.class,0);
		}
		public UsingDirectiveContext usingDirective() {
			return getRuleContext(UsingDirectiveContext.class,0);
		}
		public ContractBodyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractBodyElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterContractBodyElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitContractBodyElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitContractBodyElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContractBodyElementContext contractBodyElement() throws RecognitionException {
		ContractBodyElementContext _localctx = new ContractBodyElementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_contractBodyElement);
		try {
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				constructorDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				modifierDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				fallbackFunctionDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				receiveFunctionDefinition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(302);
				structDefinition();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(303);
				enumDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(304);
				userDefinedValueTypeDefinition();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(305);
				stateVariableDeclaration();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(306);
				eventDefinition();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(307);
				errorDefinition();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(308);
				usingDirective();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamedArgumentContext extends ParserRuleContext {
		public IdentifierContext name;
		public ExpressionContext value;
		public TerminalNode Colon() { return getToken(SolidityParser.Colon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NamedArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterNamedArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitNamedArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitNamedArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedArgumentContext namedArgument() throws RecognitionException {
		NamedArgumentContext _localctx = new NamedArgumentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_namedArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			((NamedArgumentContext)_localctx).name = identifier();
			setState(312);
			match(Colon);
			setState(313);
			((NamedArgumentContext)_localctx).value = expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallArgumentListContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<NamedArgumentContext> namedArgument() {
			return getRuleContexts(NamedArgumentContext.class);
		}
		public NamedArgumentContext namedArgument(int i) {
			return getRuleContext(NamedArgumentContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public CallArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterCallArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitCallArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitCallArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallArgumentListContext callArgumentList() throws RecognitionException {
		CallArgumentListContext _localctx = new CallArgumentListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(LParen);
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(324);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(316);
					expression(0);
					setState(321);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(317);
						match(Comma);
						setState(318);
						expression(0);
						}
						}
						setState(323);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(326);
				match(LBrace);
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
					{
					setState(327);
					namedArgument();
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(328);
						match(Comma);
						setState(329);
						namedArgument();
						}
						}
						setState(334);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(337);
				match(RBrace);
				}
				break;
			}
			setState(340);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierPathContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Period() { return getTokens(SolidityParser.Period); }
		public TerminalNode Period(int i) {
			return getToken(SolidityParser.Period, i);
		}
		public IdentifierPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIdentifierPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIdentifierPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIdentifierPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierPathContext identifierPath() throws RecognitionException {
		IdentifierPathContext _localctx = new IdentifierPathContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_identifierPath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			identifier();
			setState(347);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(343);
					match(Period);
					setState(344);
					identifier();
					}
					} 
				}
				setState(349);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierInvocationContext extends ParserRuleContext {
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public ModifierInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterModifierInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitModifierInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitModifierInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierInvocationContext modifierInvocation() throws RecognitionException {
		ModifierInvocationContext _localctx = new ModifierInvocationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_modifierInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			identifierPath();
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(351);
				callArgumentList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VisibilityContext extends ParserRuleContext {
		public TerminalNode Internal() { return getToken(SolidityParser.Internal, 0); }
		public TerminalNode External() { return getToken(SolidityParser.External, 0); }
		public TerminalNode Private() { return getToken(SolidityParser.Private, 0); }
		public TerminalNode Public() { return getToken(SolidityParser.Public, 0); }
		public VisibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibility; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVisibility(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVisibility(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVisibility(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisibilityContext visibility() throws RecognitionException {
		VisibilityContext _localctx = new VisibilityContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_visibility);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1689399649632256L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public ParameterDeclarationContext parameterDeclaration;
		public List<ParameterDeclarationContext> parameters = new ArrayList<ParameterDeclarationContext>();
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			((ParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
			((ParameterListContext)_localctx).parameters.add(((ParameterListContext)_localctx).parameterDeclaration);
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(357);
				match(Comma);
				setState(358);
				((ParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
				((ParameterListContext)_localctx).parameters.add(((ParameterListContext)_localctx).parameterDeclaration);
				}
				}
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public DataLocationContext location;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public DataLocationContext dataLocation() {
			return getRuleContext(DataLocationContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			((ParameterDeclarationContext)_localctx).type = typeName(0);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 72066390130952192L) != 0) {
				{
				setState(365);
				((ParameterDeclarationContext)_localctx).location = dataLocation();
				}
			}

			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
				{
				setState(368);
				((ParameterDeclarationContext)_localctx).name = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDefinitionContext extends ParserRuleContext {
		public  payableSet = False;
		public  visibilitySet = False;
		public ParameterListContext arguments;
		public BlockContext body;
		public TerminalNode Constructor() { return getToken(SolidityParser.Constructor, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Payable() { return getTokens(SolidityParser.Payable); }
		public TerminalNode Payable(int i) {
			return getToken(SolidityParser.Payable, i);
		}
		public List<TerminalNode> Internal() { return getTokens(SolidityParser.Internal); }
		public TerminalNode Internal(int i) {
			return getToken(SolidityParser.Internal, i);
		}
		public List<TerminalNode> Public() { return getTokens(SolidityParser.Public); }
		public TerminalNode Public(int i) {
			return getToken(SolidityParser.Public, i);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ConstructorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterConstructorDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitConstructorDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitConstructorDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDefinitionContext constructorDefinition() throws RecognitionException {
		ConstructorDefinitionContext _localctx = new ConstructorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constructorDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(Constructor);
			setState(372);
			match(LParen);
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(373);
				((ConstructorDefinitionContext)_localctx).arguments = parameterList();
				}
				break;
			}
			setState(376);
			match(RParen);
			setState(389);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(387);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						setState(377);
						modifierInvocation();
						}
						break;
					case 2:
						{
						setState(378);
						if (!(not _localctx.payableSet)) throw new FailedPredicateException(this, "not $payableSet");
						setState(379);
						match(Payable);
						((ConstructorDefinitionContext)_localctx).payableSet =  True;
						}
						break;
					case 3:
						{
						setState(381);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(382);
						match(Internal);
						((ConstructorDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					case 4:
						{
						setState(384);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(385);
						match(Public);
						((ConstructorDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					}
					} 
				}
				setState(391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(392);
			((ConstructorDefinitionContext)_localctx).body = block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateMutabilityContext extends ParserRuleContext {
		public TerminalNode Pure() { return getToken(SolidityParser.Pure, 0); }
		public TerminalNode View() { return getToken(SolidityParser.View, 0); }
		public TerminalNode Payable() { return getToken(SolidityParser.Payable, 0); }
		public StateMutabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateMutability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStateMutability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStateMutability(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStateMutability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateMutabilityContext stateMutability() throws RecognitionException {
		StateMutabilityContext _localctx = new StateMutabilityContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stateMutability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_la = _input.LA(1);
			if ( !((((_la - 48)) & ~0x3f) == 0 && ((1L << (_la - 48)) & 262153L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OverrideSpecifierContext extends ParserRuleContext {
		public IdentifierPathContext identifierPath;
		public List<IdentifierPathContext> overrides = new ArrayList<IdentifierPathContext>();
		public TerminalNode Override() { return getToken(SolidityParser.Override, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<IdentifierPathContext> identifierPath() {
			return getRuleContexts(IdentifierPathContext.class);
		}
		public IdentifierPathContext identifierPath(int i) {
			return getRuleContext(IdentifierPathContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public OverrideSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overrideSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterOverrideSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitOverrideSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitOverrideSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverrideSpecifierContext overrideSpecifier() throws RecognitionException {
		OverrideSpecifierContext _localctx = new OverrideSpecifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_overrideSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(Override);
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(397);
				match(LParen);
				setState(398);
				((OverrideSpecifierContext)_localctx).identifierPath = identifierPath();
				((OverrideSpecifierContext)_localctx).overrides.add(((OverrideSpecifierContext)_localctx).identifierPath);
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(399);
					match(Comma);
					setState(400);
					((OverrideSpecifierContext)_localctx).identifierPath = identifierPath();
					((OverrideSpecifierContext)_localctx).overrides.add(((OverrideSpecifierContext)_localctx).identifierPath);
					}
					}
					setState(405);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(406);
				match(RParen);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public  visibilitySet = False;
		public  mutabilitySet = False;
		public  virtualSet = False;
		public  overrideSpecifierSet = False;
		public ParameterListContext arguments;
		public ParameterListContext returnParameters;
		public BlockContext body;
		public TerminalNode Function() { return getToken(SolidityParser.Function, 0); }
		public List<TerminalNode> LParen() { return getTokens(SolidityParser.LParen); }
		public TerminalNode LParen(int i) {
			return getToken(SolidityParser.LParen, i);
		}
		public List<TerminalNode> RParen() { return getTokens(SolidityParser.RParen); }
		public TerminalNode RParen(int i) {
			return getToken(SolidityParser.RParen, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Fallback() { return getToken(SolidityParser.Fallback, 0); }
		public TerminalNode Receive() { return getToken(SolidityParser.Receive, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public List<VisibilityContext> visibility() {
			return getRuleContexts(VisibilityContext.class);
		}
		public VisibilityContext visibility(int i) {
			return getRuleContext(VisibilityContext.class,i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ParameterListContext> parameterList() {
			return getRuleContexts(ParameterListContext.class);
		}
		public ParameterListContext parameterList(int i) {
			return getRuleContext(ParameterListContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(Function);
			setState(414);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Error:
			case Revert:
			case From:
			case Identifier:
				{
				setState(411);
				identifier();
				}
				break;
			case Fallback:
				{
				setState(412);
				match(Fallback);
				}
				break;
			case Receive:
				{
				setState(413);
				match(Receive);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(416);
			match(LParen);
			setState(418);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(417);
				((FunctionDefinitionContext)_localctx).arguments = parameterList();
				}
				break;
			}
			setState(420);
			match(RParen);
			setState(439);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(437);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(421);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(422);
						visibility();
						((FunctionDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(425);
						if (!(not _localctx.mutabilitySet)) throw new FailedPredicateException(this, "not $mutabilitySet");
						setState(426);
						stateMutability();
						((FunctionDefinitionContext)_localctx).mutabilitySet =  True;
						}
						break;
					case 3:
						{
						setState(429);
						modifierInvocation();
						}
						break;
					case 4:
						{
						setState(430);
						if (!(not _localctx.virtualSet)) throw new FailedPredicateException(this, "not $virtualSet");
						setState(431);
						match(Virtual);
						((FunctionDefinitionContext)_localctx).virtualSet =  True;
						}
						break;
					case 5:
						{
						setState(433);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(434);
						overrideSpecifier();
						((FunctionDefinitionContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					}
					} 
				}
				setState(441);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(442);
				match(Returns);
				setState(443);
				match(LParen);
				setState(444);
				((FunctionDefinitionContext)_localctx).returnParameters = parameterList();
				setState(445);
				match(RParen);
				}
			}

			setState(451);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(449);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(450);
				((FunctionDefinitionContext)_localctx).body = block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierDefinitionContext extends ParserRuleContext {
		public  virtualSet = False;
		public  overrideSpecifierSet = False;
		public IdentifierContext name;
		public ParameterListContext arguments;
		public BlockContext body;
		public TerminalNode Modifier() { return getToken(SolidityParser.Modifier, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ModifierDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterModifierDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitModifierDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitModifierDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierDefinitionContext modifierDefinition() throws RecognitionException {
		ModifierDefinitionContext _localctx = new ModifierDefinitionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_modifierDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(Modifier);
			setState(454);
			((ModifierDefinitionContext)_localctx).name = identifier();
			setState(460);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(455);
				match(LParen);
				setState(457);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(456);
					((ModifierDefinitionContext)_localctx).arguments = parameterList();
					}
					break;
				}
				setState(459);
				match(RParen);
				}
				break;
			}
			setState(471);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(469);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						setState(462);
						if (!(not _localctx.virtualSet)) throw new FailedPredicateException(this, "not $virtualSet");
						setState(463);
						match(Virtual);
						((ModifierDefinitionContext)_localctx).virtualSet =  True;
						}
						break;
					case 2:
						{
						setState(465);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(466);
						overrideSpecifier();
						((ModifierDefinitionContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					}
					} 
				}
				setState(473);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(476);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(474);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(475);
				((ModifierDefinitionContext)_localctx).body = block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FallbackFunctionDefinitionContext extends ParserRuleContext {
		public  visibilitySet = False;
		public  mutabilitySet = False;
		public  virtualSet = False;
		public  overrideSpecifierSet = False;
		public  hasParameters = False;
		public Token kind;
		public ParameterListContext returnParameters;
		public BlockContext body;
		public List<TerminalNode> LParen() { return getTokens(SolidityParser.LParen); }
		public TerminalNode LParen(int i) {
			return getToken(SolidityParser.LParen, i);
		}
		public List<TerminalNode> RParen() { return getTokens(SolidityParser.RParen); }
		public TerminalNode RParen(int i) {
			return getToken(SolidityParser.RParen, i);
		}
		public TerminalNode Fallback() { return getToken(SolidityParser.Fallback, 0); }
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public List<ParameterListContext> parameterList() {
			return getRuleContexts(ParameterListContext.class);
		}
		public ParameterListContext parameterList(int i) {
			return getRuleContext(ParameterListContext.class,i);
		}
		public List<TerminalNode> External() { return getTokens(SolidityParser.External); }
		public TerminalNode External(int i) {
			return getToken(SolidityParser.External, i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FallbackFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fallbackFunctionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterFallbackFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitFallbackFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitFallbackFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FallbackFunctionDefinitionContext fallbackFunctionDefinition() throws RecognitionException {
		FallbackFunctionDefinitionContext _localctx = new FallbackFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_fallbackFunctionDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			((FallbackFunctionDefinitionContext)_localctx).kind = match(Fallback);
			setState(479);
			match(LParen);
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(480);
				parameterList();
				((FallbackFunctionDefinitionContext)_localctx).hasParameters =  True;
				}
				break;
			}
			setState(485);
			match(RParen);
			setState(503);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(501);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						setState(486);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(487);
						match(External);
						((FallbackFunctionDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(489);
						if (!(not _localctx.mutabilitySet)) throw new FailedPredicateException(this, "not $mutabilitySet");
						setState(490);
						stateMutability();
						((FallbackFunctionDefinitionContext)_localctx).mutabilitySet =  True;
						}
						break;
					case 3:
						{
						setState(493);
						modifierInvocation();
						}
						break;
					case 4:
						{
						setState(494);
						if (!(not _localctx.virtualSet)) throw new FailedPredicateException(this, "not $virtualSet");
						setState(495);
						match(Virtual);
						((FallbackFunctionDefinitionContext)_localctx).virtualSet =  True;
						}
						break;
					case 5:
						{
						setState(497);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(498);
						overrideSpecifier();
						((FallbackFunctionDefinitionContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					}
					} 
				}
				setState(505);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(513);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(506);
				if (!(_localctx.hasParameters)) throw new FailedPredicateException(this, "$hasParameters");
				setState(507);
				match(Returns);
				setState(508);
				match(LParen);
				setState(509);
				((FallbackFunctionDefinitionContext)_localctx).returnParameters = parameterList();
				setState(510);
				match(RParen);
				}
				break;
			case 2:
				{
				setState(512);
				if (!(not _localctx.hasParameters)) throw new FailedPredicateException(this, "not $hasParameters");
				}
				break;
			}
			setState(517);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(515);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(516);
				((FallbackFunctionDefinitionContext)_localctx).body = block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiveFunctionDefinitionContext extends ParserRuleContext {
		public  visibilitySet = False;
		public  mutabilitySet = False;
		public  virtualSet = False;
		public  overrideSpecifierSet = False;
		public Token kind;
		public BlockContext body;
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Receive() { return getToken(SolidityParser.Receive, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public List<TerminalNode> External() { return getTokens(SolidityParser.External); }
		public TerminalNode External(int i) {
			return getToken(SolidityParser.External, i);
		}
		public List<TerminalNode> Payable() { return getTokens(SolidityParser.Payable); }
		public TerminalNode Payable(int i) {
			return getToken(SolidityParser.Payable, i);
		}
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<TerminalNode> Virtual() { return getTokens(SolidityParser.Virtual); }
		public TerminalNode Virtual(int i) {
			return getToken(SolidityParser.Virtual, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReceiveFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiveFunctionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterReceiveFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitReceiveFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitReceiveFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiveFunctionDefinitionContext receiveFunctionDefinition() throws RecognitionException {
		ReceiveFunctionDefinitionContext _localctx = new ReceiveFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_receiveFunctionDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			((ReceiveFunctionDefinitionContext)_localctx).kind = match(Receive);
			setState(520);
			match(LParen);
			setState(521);
			match(RParen);
			setState(538);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(536);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						setState(522);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(523);
						match(External);
						((ReceiveFunctionDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(525);
						if (!(not _localctx.mutabilitySet)) throw new FailedPredicateException(this, "not $mutabilitySet");
						setState(526);
						match(Payable);
						((ReceiveFunctionDefinitionContext)_localctx).mutabilitySet =  True;
						}
						break;
					case 3:
						{
						setState(528);
						modifierInvocation();
						}
						break;
					case 4:
						{
						setState(529);
						if (!(not _localctx.virtualSet)) throw new FailedPredicateException(this, "not $virtualSet");
						setState(530);
						match(Virtual);
						((ReceiveFunctionDefinitionContext)_localctx).virtualSet =  True;
						}
						break;
					case 5:
						{
						setState(532);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(533);
						overrideSpecifier();
						((ReceiveFunctionDefinitionContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					}
					} 
				}
				setState(540);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			setState(543);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(541);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(542);
				((ReceiveFunctionDefinitionContext)_localctx).body = block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public StructMemberContext members;
		public TerminalNode Struct() { return getToken(SolidityParser.Struct, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public StructDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStructDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStructDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStructDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDefinitionContext structDefinition() throws RecognitionException {
		StructDefinitionContext _localctx = new StructDefinitionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_structDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			match(Struct);
			setState(546);
			((StructDefinitionContext)_localctx).name = identifier();
			setState(547);
			match(LBrace);
			setState(549); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(548);
					((StructDefinitionContext)_localctx).members = structMember();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(551); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(553);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructMemberContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStructMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStructMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStructMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_structMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			((StructMemberContext)_localctx).type = typeName(0);
			setState(556);
			((StructMemberContext)_localctx).name = identifier();
			setState(557);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier;
		public List<IdentifierContext> enumValues = new ArrayList<IdentifierContext>();
		public TerminalNode Enum() { return getToken(SolidityParser.Enum, 0); }
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public EnumDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEnumDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEnumDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEnumDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDefinitionContext enumDefinition() throws RecognitionException {
		EnumDefinitionContext _localctx = new EnumDefinitionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(Enum);
			setState(560);
			((EnumDefinitionContext)_localctx).name = identifier();
			setState(561);
			match(LBrace);
			setState(562);
			((EnumDefinitionContext)_localctx).identifier = identifier();
			((EnumDefinitionContext)_localctx).enumValues.add(((EnumDefinitionContext)_localctx).identifier);
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(563);
				match(Comma);
				setState(564);
				((EnumDefinitionContext)_localctx).identifier = identifier();
				((EnumDefinitionContext)_localctx).enumValues.add(((EnumDefinitionContext)_localctx).identifier);
				}
				}
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(570);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UserDefinedValueTypeDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode Type() { return getToken(SolidityParser.Type, 0); }
		public TerminalNode Is() { return getToken(SolidityParser.Is, 0); }
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UserDefinedValueTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedValueTypeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUserDefinedValueTypeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUserDefinedValueTypeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUserDefinedValueTypeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedValueTypeDefinitionContext userDefinedValueTypeDefinition() throws RecognitionException {
		UserDefinedValueTypeDefinitionContext _localctx = new UserDefinedValueTypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_userDefinedValueTypeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			match(Type);
			setState(573);
			((UserDefinedValueTypeDefinitionContext)_localctx).name = identifier();
			setState(574);
			match(Is);
			setState(575);
			elementaryTypeName(True);
			setState(576);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StateVariableDeclarationContext extends ParserRuleContext {
		public  constantnessSet = False;
		public  visibilitySet = False;
		public  overrideSpecifierSet = False;
		public TypeNameContext type;
		public IdentifierContext name;
		public ExpressionContext initialValue;
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> Public() { return getTokens(SolidityParser.Public); }
		public TerminalNode Public(int i) {
			return getToken(SolidityParser.Public, i);
		}
		public List<TerminalNode> Private() { return getTokens(SolidityParser.Private); }
		public TerminalNode Private(int i) {
			return getToken(SolidityParser.Private, i);
		}
		public List<TerminalNode> Internal() { return getTokens(SolidityParser.Internal); }
		public TerminalNode Internal(int i) {
			return getToken(SolidityParser.Internal, i);
		}
		public List<TerminalNode> Constant() { return getTokens(SolidityParser.Constant); }
		public TerminalNode Constant(int i) {
			return getToken(SolidityParser.Constant, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public List<TerminalNode> Immutable() { return getTokens(SolidityParser.Immutable); }
		public TerminalNode Immutable(int i) {
			return getToken(SolidityParser.Immutable, i);
		}
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StateVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStateVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStateVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStateVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateVariableDeclarationContext stateVariableDeclaration() throws RecognitionException {
		StateVariableDeclarationContext _localctx = new StateVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_stateVariableDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			((StateVariableDeclarationContext)_localctx).type = typeName(0);
			setState(600);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(598);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
					case 1:
						{
						setState(579);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(580);
						match(Public);
						((StateVariableDeclarationContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(582);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(583);
						match(Private);
						((StateVariableDeclarationContext)_localctx).visibilitySet =  True;
						}
						break;
					case 3:
						{
						setState(585);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(586);
						match(Internal);
						((StateVariableDeclarationContext)_localctx).visibilitySet =  True;
						}
						break;
					case 4:
						{
						setState(588);
						if (!(not _localctx.constantnessSet)) throw new FailedPredicateException(this, "not $constantnessSet");
						setState(589);
						match(Constant);
						((StateVariableDeclarationContext)_localctx).constantnessSet =  True;
						}
						break;
					case 5:
						{
						setState(591);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(592);
						overrideSpecifier();
						((StateVariableDeclarationContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					case 6:
						{
						setState(595);
						if (!(not _localctx.constantnessSet)) throw new FailedPredicateException(this, "not $constantnessSet");
						setState(596);
						match(Immutable);
						((StateVariableDeclarationContext)_localctx).constantnessSet =  True;
						}
						break;
					}
					} 
				}
				setState(602);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			setState(603);
			((StateVariableDeclarationContext)_localctx).name = identifier();
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(604);
				match(Assign);
				setState(605);
				((StateVariableDeclarationContext)_localctx).initialValue = expression(0);
				}
			}

			setState(608);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantVariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public ExpressionContext initialValue;
		public TerminalNode Constant() { return getToken(SolidityParser.Constant, 0); }
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterConstantVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitConstantVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitConstantVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantVariableDeclarationContext constantVariableDeclaration() throws RecognitionException {
		ConstantVariableDeclarationContext _localctx = new ConstantVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_constantVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			((ConstantVariableDeclarationContext)_localctx).type = typeName(0);
			setState(611);
			match(Constant);
			setState(612);
			((ConstantVariableDeclarationContext)_localctx).name = identifier();
			setState(613);
			match(Assign);
			setState(614);
			((ConstantVariableDeclarationContext)_localctx).initialValue = expression(0);
			setState(615);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventParameterContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Indexed() { return getToken(SolidityParser.Indexed, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EventParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEventParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEventParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEventParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventParameterContext eventParameter() throws RecognitionException {
		EventParameterContext _localctx = new EventParameterContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_eventParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			((EventParameterContext)_localctx).type = typeName(0);
			setState(619);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Indexed) {
				{
				setState(618);
				match(Indexed);
				}
			}

			setState(622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
				{
				setState(621);
				((EventParameterContext)_localctx).name = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public EventParameterContext eventParameter;
		public List<EventParameterContext> parameters = new ArrayList<EventParameterContext>();
		public TerminalNode Event() { return getToken(SolidityParser.Event, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Anonymous() { return getToken(SolidityParser.Anonymous, 0); }
		public List<EventParameterContext> eventParameter() {
			return getRuleContexts(EventParameterContext.class);
		}
		public EventParameterContext eventParameter(int i) {
			return getRuleContext(EventParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public EventDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEventDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEventDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEventDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventDefinitionContext eventDefinition() throws RecognitionException {
		EventDefinitionContext _localctx = new EventDefinitionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_eventDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(Event);
			setState(625);
			((EventDefinitionContext)_localctx).name = identifier();
			setState(626);
			match(LParen);
			setState(635);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(627);
				((EventDefinitionContext)_localctx).eventParameter = eventParameter();
				((EventDefinitionContext)_localctx).parameters.add(((EventDefinitionContext)_localctx).eventParameter);
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(628);
					match(Comma);
					setState(629);
					((EventDefinitionContext)_localctx).eventParameter = eventParameter();
					((EventDefinitionContext)_localctx).parameters.add(((EventDefinitionContext)_localctx).eventParameter);
					}
					}
					setState(634);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(637);
			match(RParen);
			setState(639);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Anonymous) {
				{
				setState(638);
				match(Anonymous);
				}
			}

			setState(641);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ErrorParameterContext extends ParserRuleContext {
		public TypeNameContext type;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ErrorParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterErrorParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitErrorParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitErrorParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorParameterContext errorParameter() throws RecognitionException {
		ErrorParameterContext _localctx = new ErrorParameterContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_errorParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
			((ErrorParameterContext)_localctx).type = typeName(0);
			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
				{
				setState(644);
				((ErrorParameterContext)_localctx).name = identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ErrorDefinitionContext extends ParserRuleContext {
		public IdentifierContext name;
		public ErrorParameterContext errorParameter;
		public List<ErrorParameterContext> parameters = new ArrayList<ErrorParameterContext>();
		public TerminalNode Error() { return getToken(SolidityParser.Error, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ErrorParameterContext> errorParameter() {
			return getRuleContexts(ErrorParameterContext.class);
		}
		public ErrorParameterContext errorParameter(int i) {
			return getRuleContext(ErrorParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public ErrorDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterErrorDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitErrorDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitErrorDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorDefinitionContext errorDefinition() throws RecognitionException {
		ErrorDefinitionContext _localctx = new ErrorDefinitionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_errorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			match(Error);
			setState(648);
			((ErrorDefinitionContext)_localctx).name = identifier();
			setState(649);
			match(LParen);
			setState(658);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(650);
				((ErrorDefinitionContext)_localctx).errorParameter = errorParameter();
				((ErrorDefinitionContext)_localctx).parameters.add(((ErrorDefinitionContext)_localctx).errorParameter);
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(651);
					match(Comma);
					setState(652);
					((ErrorDefinitionContext)_localctx).errorParameter = errorParameter();
					((ErrorDefinitionContext)_localctx).parameters.add(((ErrorDefinitionContext)_localctx).errorParameter);
					}
					}
					setState(657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(660);
			match(RParen);
			setState(661);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UsingDirectiveContext extends ParserRuleContext {
		public TerminalNode Using() { return getToken(SolidityParser.Using, 0); }
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public TerminalNode For() { return getToken(SolidityParser.For, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public UsingDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUsingDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUsingDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUsingDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingDirectiveContext usingDirective() throws RecognitionException {
		UsingDirectiveContext _localctx = new UsingDirectiveContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_usingDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			match(Using);
			setState(664);
			identifierPath();
			setState(665);
			match(For);
			setState(668);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(666);
				match(Mul);
				}
				break;
			case 2:
				{
				setState(667);
				typeName(0);
				}
				break;
			}
			setState(670);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public FunctionTypeNameContext functionTypeName() {
			return getRuleContext(FunctionTypeNameContext.class,0);
		}
		public MappingTypeContext mappingType() {
			return getRuleContext(MappingTypeContext.class,0);
		}
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		return typeName(0);
	}

	private TypeNameContext typeName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeNameContext _localctx = new TypeNameContext(_ctx, _parentState);
		TypeNameContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_typeName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(673);
				elementaryTypeName(True);
				}
				break;
			case 2:
				{
				setState(674);
				functionTypeName();
				}
				break;
			case 3:
				{
				setState(675);
				mappingType();
				}
				break;
			case 4:
				{
				setState(676);
				identifierPath();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(687);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeName);
					setState(679);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(680);
					match(LBrack);
					setState(682);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
					case 1:
						{
						setState(681);
						expression(0);
						}
						break;
					}
					setState(684);
					match(RBrack);
					}
					} 
				}
				setState(689);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementaryTypeNameContext extends ParserRuleContext {
		public  allowAddressPayable;
		public TerminalNode Address() { return getToken(SolidityParser.Address, 0); }
		public TerminalNode Payable() { return getToken(SolidityParser.Payable, 0); }
		public TerminalNode Bool() { return getToken(SolidityParser.Bool, 0); }
		public TerminalNode String() { return getToken(SolidityParser.String, 0); }
		public TerminalNode Bytes() { return getToken(SolidityParser.Bytes, 0); }
		public TerminalNode SignedIntegerType() { return getToken(SolidityParser.SignedIntegerType, 0); }
		public TerminalNode UnsignedIntegerType() { return getToken(SolidityParser.UnsignedIntegerType, 0); }
		public TerminalNode FixedBytes() { return getToken(SolidityParser.FixedBytes, 0); }
		public TerminalNode Fixed() { return getToken(SolidityParser.Fixed, 0); }
		public TerminalNode Ufixed() { return getToken(SolidityParser.Ufixed, 0); }
		public ElementaryTypeNameContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ElementaryTypeNameContext(ParserRuleContext parent, int invokingState,  allowAddressPayable) {
			super(parent, invokingState);
			this.allowAddressPayable = allowAddressPayable;
		}
		@Override public int getRuleIndex() { return RULE_elementaryTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterElementaryTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitElementaryTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitElementaryTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementaryTypeNameContext elementaryTypeName( allowAddressPayable) throws RecognitionException {
		ElementaryTypeNameContext _localctx = new ElementaryTypeNameContext(_ctx, getState(), allowAddressPayable);
		enterRule(_localctx, 76, RULE_elementaryTypeName);
		try {
			setState(702);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(690);
				match(Address);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(691);
				if (!(_localctx.allowAddressPayable)) throw new FailedPredicateException(this, "$allowAddressPayable");
				setState(692);
				match(Address);
				setState(693);
				match(Payable);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(694);
				match(Bool);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(695);
				match(String);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(696);
				match(Bytes);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(697);
				match(SignedIntegerType);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(698);
				match(UnsignedIntegerType);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(699);
				match(FixedBytes);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(700);
				match(Fixed);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(701);
				match(Ufixed);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionTypeNameContext extends ParserRuleContext {
		public  visibilitySet = False;
		public  mutabilitySet = False;
		public ParameterListContext arguments;
		public ParameterListContext returnParameters;
		public TerminalNode Function() { return getToken(SolidityParser.Function, 0); }
		public List<TerminalNode> LParen() { return getTokens(SolidityParser.LParen); }
		public TerminalNode LParen(int i) {
			return getToken(SolidityParser.LParen, i);
		}
		public List<TerminalNode> RParen() { return getTokens(SolidityParser.RParen); }
		public TerminalNode RParen(int i) {
			return getToken(SolidityParser.RParen, i);
		}
		public List<VisibilityContext> visibility() {
			return getRuleContexts(VisibilityContext.class);
		}
		public VisibilityContext visibility(int i) {
			return getRuleContext(VisibilityContext.class,i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public List<ParameterListContext> parameterList() {
			return getRuleContexts(ParameterListContext.class);
		}
		public ParameterListContext parameterList(int i) {
			return getRuleContext(ParameterListContext.class,i);
		}
		public FunctionTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterFunctionTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitFunctionTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitFunctionTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeNameContext functionTypeName() throws RecognitionException {
		FunctionTypeNameContext _localctx = new FunctionTypeNameContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_functionTypeName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			match(Function);
			setState(705);
			match(LParen);
			setState(707);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(706);
				((FunctionTypeNameContext)_localctx).arguments = parameterList();
				}
				break;
			}
			setState(709);
			match(RParen);
			setState(720);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(718);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
					case 1:
						{
						setState(710);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(711);
						visibility();
						((FunctionTypeNameContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(714);
						if (!(not _localctx.mutabilitySet)) throw new FailedPredicateException(this, "not $mutabilitySet");
						setState(715);
						stateMutability();
						((FunctionTypeNameContext)_localctx).mutabilitySet =  True;
						}
						break;
					}
					} 
				}
				setState(722);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			}
			setState(728);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(723);
				match(Returns);
				setState(724);
				match(LParen);
				setState(725);
				((FunctionTypeNameContext)_localctx).returnParameters = parameterList();
				setState(726);
				match(RParen);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext type;
		public DataLocationContext location;
		public IdentifierContext name;
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataLocationContext dataLocation() {
			return getRuleContext(DataLocationContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			((VariableDeclarationContext)_localctx).type = typeName(0);
			setState(732);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 72066390130952192L) != 0) {
				{
				setState(731);
				((VariableDeclarationContext)_localctx).location = dataLocation();
				}
			}

			setState(734);
			((VariableDeclarationContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataLocationContext extends ParserRuleContext {
		public TerminalNode Memory() { return getToken(SolidityParser.Memory, 0); }
		public TerminalNode Storage() { return getToken(SolidityParser.Storage, 0); }
		public TerminalNode Calldata() { return getToken(SolidityParser.Calldata, 0); }
		public DataLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterDataLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitDataLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitDataLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataLocationContext dataLocation() throws RecognitionException {
		DataLocationContext _localctx = new DataLocationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_dataLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 72066390130952192L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryPrefixOperationContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Inc() { return getToken(SolidityParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(SolidityParser.Dec, 0); }
		public TerminalNode Not() { return getToken(SolidityParser.Not, 0); }
		public TerminalNode BitNot() { return getToken(SolidityParser.BitNot, 0); }
		public TerminalNode Delete() { return getToken(SolidityParser.Delete, 0); }
		public TerminalNode Sub() { return getToken(SolidityParser.Sub, 0); }
		public UnaryPrefixOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUnaryPrefixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUnaryPrefixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUnaryPrefixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public PrimaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrderComparisonContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LessThan() { return getToken(SolidityParser.LessThan, 0); }
		public TerminalNode GreaterThan() { return getToken(SolidityParser.GreaterThan, 0); }
		public TerminalNode LessThanOrEqual() { return getToken(SolidityParser.LessThanOrEqual, 0); }
		public TerminalNode GreaterThanOrEqual() { return getToken(SolidityParser.GreaterThanOrEqual, 0); }
		public OrderComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterOrderComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitOrderComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitOrderComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Conditional() { return getToken(SolidityParser.Conditional, 0); }
		public TerminalNode Colon() { return getToken(SolidityParser.Colon, 0); }
		public ConditionalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PayableConversionContext extends ExpressionContext {
		public TerminalNode Payable() { return getToken(SolidityParser.Payable, 0); }
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public PayableConversionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterPayableConversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitPayableConversion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitPayableConversion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public AssignmentContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnarySuffixOperationContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Inc() { return getToken(SolidityParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(SolidityParser.Dec, 0); }
		public UnarySuffixOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUnarySuffixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUnarySuffixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUnarySuffixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ShiftOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Shl() { return getToken(SolidityParser.Shl, 0); }
		public TerminalNode Sar() { return getToken(SolidityParser.Sar, 0); }
		public TerminalNode Shr() { return getToken(SolidityParser.Shr, 0); }
		public ShiftOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterShiftOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitShiftOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitShiftOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitAndOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitAnd() { return getToken(SolidityParser.BitAnd, 0); }
		public BitAndOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBitAndOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBitAndOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBitAndOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexRangeAccessContext extends ExpressionContext {
		public ExpressionContext start;
		public ExpressionContext end;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode Colon() { return getToken(SolidityParser.Colon, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public IndexRangeAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIndexRangeAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIndexRangeAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIndexRangeAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<NamedArgumentContext> namedArgument() {
			return getRuleContexts(NamedArgumentContext.class);
		}
		public NamedArgumentContext namedArgument(int i) {
			return getRuleContext(NamedArgumentContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public FuncCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitFuncCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitFuncCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewExpressionContext extends ExpressionContext {
		public TerminalNode New() { return getToken(SolidityParser.New, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public NewExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexAccessContext extends ExpressionContext {
		public ExpressionContext index;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public IndexAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIndexAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIndexAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIndexAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Add() { return getToken(SolidityParser.Add, 0); }
		public TerminalNode Sub() { return getToken(SolidityParser.Sub, 0); }
		public AddSubOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAddSubOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAddSubOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAddSubOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitOrOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitOr() { return getToken(SolidityParser.BitOr, 0); }
		public BitOrOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBitOrOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBitOrOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBitOrOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Exp() { return getToken(SolidityParser.Exp, 0); }
		public ExpOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterExpOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitExpOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitExpOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode And() { return getToken(SolidityParser.And, 0); }
		public AndOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAndOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAndOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAndOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlineArrayContext extends ExpressionContext {
		public InlineArrayExpressionContext inlineArrayExpression() {
			return getRuleContext(InlineArrayExpressionContext.class,0);
		}
		public InlineArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInlineArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInlineArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInlineArray(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Or() { return getToken(SolidityParser.Or, 0); }
		public OrOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterOrOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitOrOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitOrOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Period() { return getToken(SolidityParser.Period, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Address() { return getToken(SolidityParser.Address, 0); }
		public MemberAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMemberAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Mul() { return getToken(SolidityParser.Mul, 0); }
		public TerminalNode Div() { return getToken(SolidityParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SolidityParser.Mod, 0); }
		public MulDivModOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMulDivModOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMulDivModOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMulDivModOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitXorOperationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitXor() { return getToken(SolidityParser.BitXor, 0); }
		public BitXorOperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBitXorOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBitXorOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBitXorOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ExpressionContext {
		public TupleExpressionContext tupleExpression() {
			return getRuleContext(TupleExpressionContext.class,0);
		}
		public TupleContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityComparisonContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Equal() { return getToken(SolidityParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(SolidityParser.NotEqual, 0); }
		public EqualityComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEqualityComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEqualityComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEqualityComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MetaTypeContext extends ExpressionContext {
		public TerminalNode Type() { return getToken(SolidityParser.Type, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public MetaTypeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMetaType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMetaType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMetaType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(757);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				_localctx = new PayableConversionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(739);
				match(Payable);
				setState(740);
				callArgumentList();
				}
				break;
			case 2:
				{
				_localctx = new MetaTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(741);
				match(Type);
				setState(742);
				match(LParen);
				setState(743);
				typeName(0);
				setState(744);
				match(RParen);
				}
				break;
			case 3:
				{
				_localctx = new UnaryPrefixOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(746);
				((UnaryPrefixOperationContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Delete || (((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & 30721L) != 0) ) {
					((UnaryPrefixOperationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(747);
				expression(19);
				}
				break;
			case 4:
				{
				_localctx = new NewExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(748);
				match(New);
				setState(749);
				typeName(0);
				}
				break;
			case 5:
				{
				_localctx = new TupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(750);
				tupleExpression();
				}
				break;
			case 6:
				{
				_localctx = new InlineArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(751);
				inlineArrayExpression();
				}
				break;
			case 7:
				{
				_localctx = new PrimaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(755);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(752);
					identifier();
					}
					break;
				case 2:
					{
					setState(753);
					literal();
					}
					break;
				case 3:
					{
					setState(754);
					elementaryTypeName(False);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(844);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(842);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
					case 1:
						{
						_localctx = new ExpOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(759);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(760);
						match(Exp);
						setState(761);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(762);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(763);
						_la = _input.LA(1);
						if ( !((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 7L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(764);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new AddSubOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(765);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(766);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(767);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ShiftOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(768);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(769);
						_la = _input.LA(1);
						if ( !((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & 7L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(770);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new BitAndOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(771);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(772);
						match(BitAnd);
						setState(773);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new BitXorOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(774);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(775);
						match(BitXor);
						setState(776);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new BitOrOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(777);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(778);
						match(BitOr);
						setState(779);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new OrderComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(780);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(781);
						_la = _input.LA(1);
						if ( !((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 15L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(782);
						expression(11);
						}
						break;
					case 9:
						{
						_localctx = new EqualityComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(783);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(784);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(785);
						expression(10);
						}
						break;
					case 10:
						{
						_localctx = new AndOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(786);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(787);
						match(And);
						setState(788);
						expression(9);
						}
						break;
					case 11:
						{
						_localctx = new OrOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(789);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(790);
						match(Or);
						setState(791);
						expression(8);
						}
						break;
					case 12:
						{
						_localctx = new AssignmentContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(792);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(793);
						assignOp();
						setState(794);
						expression(5);
						}
						break;
					case 13:
						{
						_localctx = new IndexAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(796);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(797);
						match(LBrack);
						setState(799);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
						case 1:
							{
							setState(798);
							((IndexAccessContext)_localctx).index = expression(0);
							}
							break;
						}
						setState(801);
						match(RBrack);
						}
						break;
					case 14:
						{
						_localctx = new IndexRangeAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(802);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(803);
						match(LBrack);
						setState(805);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
						case 1:
							{
							setState(804);
							((IndexRangeAccessContext)_localctx).start = expression(0);
							}
							break;
						}
						setState(807);
						match(Colon);
						setState(809);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
						case 1:
							{
							setState(808);
							((IndexRangeAccessContext)_localctx).end = expression(0);
							}
							break;
						}
						setState(811);
						match(RBrack);
						}
						break;
					case 15:
						{
						_localctx = new MemberAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(812);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(813);
						match(Period);
						setState(816);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Error:
						case Revert:
						case From:
						case Identifier:
							{
							setState(814);
							identifier();
							}
							break;
						case Address:
							{
							setState(815);
							match(Address);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 16:
						{
						_localctx = new FuncCallExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(818);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(831);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LBrace) {
							{
							setState(819);
							match(LBrace);
							setState(828);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
								{
								setState(820);
								namedArgument();
								setState(825);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==Comma) {
									{
									{
									setState(821);
									match(Comma);
									setState(822);
									namedArgument();
									}
									}
									setState(827);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
							}

							setState(830);
							match(RBrace);
							}
						}

						setState(833);
						callArgumentList();
						}
						break;
					case 17:
						{
						_localctx = new UnarySuffixOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(834);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(835);
						((UnarySuffixOperationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Inc || _la==Dec) ) {
							((UnarySuffixOperationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 18:
						{
						_localctx = new ConditionalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(836);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(837);
						match(Conditional);
						{
						setState(838);
						expression(0);
						setState(839);
						match(Colon);
						setState(840);
						expression(0);
						}
						}
						break;
					}
					} 
				}
				setState(846);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignOpContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public TerminalNode AssignBitOr() { return getToken(SolidityParser.AssignBitOr, 0); }
		public TerminalNode AssignBitXor() { return getToken(SolidityParser.AssignBitXor, 0); }
		public TerminalNode AssignBitAnd() { return getToken(SolidityParser.AssignBitAnd, 0); }
		public TerminalNode AssignShl() { return getToken(SolidityParser.AssignShl, 0); }
		public TerminalNode AssignSar() { return getToken(SolidityParser.AssignSar, 0); }
		public TerminalNode AssignShr() { return getToken(SolidityParser.AssignShr, 0); }
		public TerminalNode AssignAdd() { return getToken(SolidityParser.AssignAdd, 0); }
		public TerminalNode AssignSub() { return getToken(SolidityParser.AssignSub, 0); }
		public TerminalNode AssignMul() { return getToken(SolidityParser.AssignMul, 0); }
		public TerminalNode AssignDiv() { return getToken(SolidityParser.AssignDiv, 0); }
		public TerminalNode AssignMod() { return getToken(SolidityParser.AssignMod, 0); }
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAssignOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAssignOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAssignOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(847);
			_la = _input.LA(1);
			if ( !((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 4095L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleExpressionContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public TupleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterTupleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitTupleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitTupleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleExpressionContext tupleExpression() throws RecognitionException {
		TupleExpressionContext _localctx = new TupleExpressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_tupleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			match(LParen);
			{
			setState(851);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(850);
				expression(0);
				}
				break;
			}
			setState(859);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(853);
				match(Comma);
				setState(855);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(854);
					expression(0);
					}
					break;
				}
				}
				}
				setState(861);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(862);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InlineArrayExpressionContext extends ParserRuleContext {
		public TerminalNode LBrack() { return getToken(SolidityParser.LBrack, 0); }
		public TerminalNode RBrack() { return getToken(SolidityParser.RBrack, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public InlineArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineArrayExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterInlineArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitInlineArrayExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitInlineArrayExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineArrayExpressionContext inlineArrayExpression() throws RecognitionException {
		InlineArrayExpressionContext _localctx = new InlineArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_inlineArrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864);
			match(LBrack);
			{
			setState(865);
			expression(0);
			setState(870);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(866);
				match(Comma);
				setState(867);
				expression(0);
				}
				}
				setState(872);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(873);
			match(RBrack);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SolidityParser.Identifier, 0); }
		public TerminalNode From() { return getToken(SolidityParser.From, 0); }
		public TerminalNode Error() { return getToken(SolidityParser.Error, 0); }
		public TerminalNode Revert() { return getToken(SolidityParser.Revert, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(875);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public HexStringLiteralContext hexStringLiteral() {
			return getRuleContext(HexStringLiteralContext.class,0);
		}
		public UnicodeStringLiteralContext unicodeStringLiteral() {
			return getRuleContext(UnicodeStringLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_literal);
		try {
			setState(882);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(877);
				stringLiteral();
				}
				break;
			case HexNumber:
			case DecimalNumber:
				enterOuterAlt(_localctx, 2);
				{
				setState(878);
				numberLiteral();
				}
				break;
			case False_:
			case True_:
				enterOuterAlt(_localctx, 3);
				{
				setState(879);
				booleanLiteral();
				}
				break;
			case HexString:
				enterOuterAlt(_localctx, 4);
				{
				setState(880);
				hexStringLiteral();
				}
				break;
			case UnicodeStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(881);
				unicodeStringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode True_() { return getToken(SolidityParser.True_, 0); }
		public TerminalNode False_() { return getToken(SolidityParser.False_, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			_la = _input.LA(1);
			if ( !(_la==False_ || _la==True_) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> NonEmptyStringLiteral() { return getTokens(SolidityParser.NonEmptyStringLiteral); }
		public TerminalNode NonEmptyStringLiteral(int i) {
			return getToken(SolidityParser.NonEmptyStringLiteral, i);
		}
		public List<TerminalNode> EmptyStringLiteral() { return getTokens(SolidityParser.EmptyStringLiteral); }
		public TerminalNode EmptyStringLiteral(int i) {
			return getToken(SolidityParser.EmptyStringLiteral, i);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_stringLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(887); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(886);
					_la = _input.LA(1);
					if ( !(_la==NonEmptyStringLiteral || _la==EmptyStringLiteral) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(889); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HexStringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> HexString() { return getTokens(SolidityParser.HexString); }
		public TerminalNode HexString(int i) {
			return getToken(SolidityParser.HexString, i);
		}
		public HexStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterHexStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitHexStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitHexStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HexStringLiteralContext hexStringLiteral() throws RecognitionException {
		HexStringLiteralContext _localctx = new HexStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_hexStringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(892); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(891);
					match(HexString);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(894); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnicodeStringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> UnicodeStringLiteral() { return getTokens(SolidityParser.UnicodeStringLiteral); }
		public TerminalNode UnicodeStringLiteral(int i) {
			return getToken(SolidityParser.UnicodeStringLiteral, i);
		}
		public UnicodeStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unicodeStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUnicodeStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUnicodeStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUnicodeStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnicodeStringLiteralContext unicodeStringLiteral() throws RecognitionException {
		UnicodeStringLiteralContext _localctx = new UnicodeStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_unicodeStringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(897); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(896);
					match(UnicodeStringLiteral);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(899); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberLiteralContext extends ParserRuleContext {
		public TerminalNode DecimalNumber() { return getToken(SolidityParser.DecimalNumber, 0); }
		public TerminalNode HexNumber() { return getToken(SolidityParser.HexNumber, 0); }
		public TerminalNode NumberUnit() { return getToken(SolidityParser.NumberUnit, 0); }
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_numberLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			_la = _input.LA(1);
			if ( !(_la==HexNumber || _la==DecimalNumber) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(903);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(902);
				match(NumberUnit);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(SolidityParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SolidityParser.RBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<UncheckedBlockContext> uncheckedBlock() {
			return getRuleContexts(UncheckedBlockContext.class);
		}
		public UncheckedBlockContext uncheckedBlock(int i) {
			return getRuleContext(UncheckedBlockContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			match(LBrace);
			setState(910);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(908);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
					case 1:
						{
						setState(906);
						statement();
						}
						break;
					case 2:
						{
						setState(907);
						uncheckedBlock();
						}
						break;
					}
					} 
				}
				setState(912);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			}
			setState(913);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UncheckedBlockContext extends ParserRuleContext {
		public TerminalNode Unchecked() { return getToken(SolidityParser.Unchecked, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public UncheckedBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uncheckedBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterUncheckedBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitUncheckedBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitUncheckedBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UncheckedBlockContext uncheckedBlock() throws RecognitionException {
		UncheckedBlockContext _localctx = new UncheckedBlockContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_uncheckedBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915);
			match(Unchecked);
			setState(916);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public EmitStatementContext emitStatement() {
			return getRuleContext(EmitStatementContext.class,0);
		}
		public RevertStatementContext revertStatement() {
			return getRuleContext(RevertStatementContext.class,0);
		}
		public AssemblyStatementContext assemblyStatement() {
			return getRuleContext(AssemblyStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_statement);
		try {
			setState(931);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(918);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(919);
				simpleStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(920);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(921);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(922);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(923);
				doWhileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(924);
				continueStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(925);
				breakStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(926);
				tryStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(927);
				returnStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(928);
				emitStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(929);
				revertStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(930);
				assemblyStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStatementContext extends ParserRuleContext {
		public VariableDeclarationStatementContext variableDeclarationStatement() {
			return getRuleContext(VariableDeclarationStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterSimpleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitSimpleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitSimpleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_simpleStatement);
		try {
			setState(935);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(933);
				variableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(934);
				expressionStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(SolidityParser.If, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(SolidityParser.Else, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(937);
			match(If);
			setState(938);
			match(LParen);
			setState(939);
			expression(0);
			setState(940);
			match(RParen);
			setState(941);
			statement();
			setState(944);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				{
				setState(942);
				match(Else);
				setState(943);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(SolidityParser.For, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public List<TerminalNode> Semicolon() { return getTokens(SolidityParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(SolidityParser.Semicolon, i);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(946);
			match(For);
			setState(947);
			match(LParen);
			setState(950);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				{
				setState(948);
				simpleStatement();
				}
				break;
			case 2:
				{
				setState(949);
				match(Semicolon);
				}
				break;
			}
			setState(954);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(952);
				expressionStatement();
				}
				break;
			case 2:
				{
				setState(953);
				match(Semicolon);
				}
				break;
			}
			setState(957);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(956);
				expression(0);
				}
				break;
			}
			setState(959);
			match(RParen);
			setState(960);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(SolidityParser.While, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(962);
			match(While);
			setState(963);
			match(LParen);
			setState(964);
			expression(0);
			setState(965);
			match(RParen);
			setState(966);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStatementContext extends ParserRuleContext {
		public TerminalNode Do() { return getToken(SolidityParser.Do, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(SolidityParser.While, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(968);
			match(Do);
			setState(969);
			statement();
			setState(970);
			match(While);
			setState(971);
			match(LParen);
			setState(972);
			expression(0);
			setState(973);
			match(RParen);
			setState(974);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(SolidityParser.Continue, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(976);
			match(Continue);
			setState(977);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(SolidityParser.Break, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(979);
			match(Break);
			setState(980);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TryStatementContext extends ParserRuleContext {
		public ParameterListContext returnParameters;
		public TerminalNode Try() { return getToken(SolidityParser.Try, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Returns() { return getToken(SolidityParser.Returns, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitTryStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitTryStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_tryStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(982);
			match(Try);
			setState(983);
			expression(0);
			setState(989);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(984);
				match(Returns);
				setState(985);
				match(LParen);
				setState(986);
				((TryStatementContext)_localctx).returnParameters = parameterList();
				setState(987);
				match(RParen);
				}
			}

			setState(991);
			block();
			setState(993); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(992);
					catchClause();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(995); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchClauseContext extends ParserRuleContext {
		public ParameterListContext arguments;
		public TerminalNode Catch() { return getToken(SolidityParser.Catch, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitCatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(997);
			match(Catch);
			setState(1005);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==LParen || _la==Identifier) {
				{
				setState(999);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
					{
					setState(998);
					identifier();
					}
				}

				setState(1001);
				match(LParen);
				{
				setState(1002);
				((CatchClauseContext)_localctx).arguments = parameterList();
				}
				setState(1003);
				match(RParen);
				}
			}

			setState(1007);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(SolidityParser.Return, 0); }
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1009);
			match(Return);
			setState(1011);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				setState(1010);
				expression(0);
				}
				break;
			}
			setState(1013);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmitStatementContext extends ParserRuleContext {
		public TerminalNode Emit() { return getToken(SolidityParser.Emit, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public EmitStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emitStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterEmitStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitEmitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitEmitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmitStatementContext emitStatement() throws RecognitionException {
		EmitStatementContext _localctx = new EmitStatementContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_emitStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1015);
			match(Emit);
			setState(1016);
			expression(0);
			setState(1017);
			callArgumentList();
			setState(1018);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RevertStatementContext extends ParserRuleContext {
		public TerminalNode Revert() { return getToken(SolidityParser.Revert, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CallArgumentListContext callArgumentList() {
			return getRuleContext(CallArgumentListContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public RevertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_revertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterRevertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitRevertStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitRevertStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RevertStatementContext revertStatement() throws RecognitionException {
		RevertStatementContext _localctx = new RevertStatementContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_revertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1020);
			match(Revert);
			setState(1021);
			expression(0);
			setState(1022);
			callArgumentList();
			setState(1023);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssemblyStatementContext extends ParserRuleContext {
		public TerminalNode Assembly() { return getToken(SolidityParser.Assembly, 0); }
		public TerminalNode AssemblyLBrace() { return getToken(SolidityParser.AssemblyLBrace, 0); }
		public TerminalNode YulRBrace() { return getToken(SolidityParser.YulRBrace, 0); }
		public TerminalNode AssemblyDialect() { return getToken(SolidityParser.AssemblyDialect, 0); }
		public List<YulStatementContext> yulStatement() {
			return getRuleContexts(YulStatementContext.class);
		}
		public YulStatementContext yulStatement(int i) {
			return getRuleContext(YulStatementContext.class,i);
		}
		public AssemblyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterAssemblyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitAssemblyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitAssemblyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyStatementContext assemblyStatement() throws RecognitionException {
		AssemblyStatementContext _localctx = new AssemblyStatementContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_assemblyStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1025);
			match(Assembly);
			setState(1027);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssemblyDialect) {
				{
				setState(1026);
				match(AssemblyDialect);
				}
			}

			setState(1029);
			match(AssemblyLBrace);
			setState(1033);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & 4220901L) != 0) {
				{
				{
				setState(1030);
				yulStatement();
				}
				}
				setState(1035);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1036);
			match(YulRBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationListContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> variableDeclarations = new ArrayList<VariableDeclarationContext>();
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVariableDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVariableDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVariableDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationListContext variableDeclarationList() throws RecognitionException {
		VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_variableDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1038);
			((VariableDeclarationListContext)_localctx).variableDeclaration = variableDeclaration();
			((VariableDeclarationListContext)_localctx).variableDeclarations.add(((VariableDeclarationListContext)_localctx).variableDeclaration);
			setState(1043);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1039);
				match(Comma);
				setState(1040);
				((VariableDeclarationListContext)_localctx).variableDeclaration = variableDeclaration();
				((VariableDeclarationListContext)_localctx).variableDeclarations.add(((VariableDeclarationListContext)_localctx).variableDeclaration);
				}
				}
				setState(1045);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationTupleContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration;
		public List<VariableDeclarationContext> variableDeclarations = new ArrayList<VariableDeclarationContext>();
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SolidityParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SolidityParser.Comma, i);
		}
		public VariableDeclarationTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationTuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVariableDeclarationTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVariableDeclarationTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVariableDeclarationTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationTupleContext variableDeclarationTuple() throws RecognitionException {
		VariableDeclarationTupleContext _localctx = new VariableDeclarationTupleContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_variableDeclarationTuple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1046);
			match(LParen);
			{
			setState(1050);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1047);
					match(Comma);
					}
					} 
				}
				setState(1052);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			}
			setState(1053);
			((VariableDeclarationTupleContext)_localctx).variableDeclaration = variableDeclaration();
			((VariableDeclarationTupleContext)_localctx).variableDeclarations.add(((VariableDeclarationTupleContext)_localctx).variableDeclaration);
			}
			setState(1061);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1055);
				match(Comma);
				setState(1057);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(1056);
					((VariableDeclarationTupleContext)_localctx).variableDeclaration = variableDeclaration();
					((VariableDeclarationTupleContext)_localctx).variableDeclarations.add(((VariableDeclarationTupleContext)_localctx).variableDeclaration);
					}
					break;
				}
				}
				}
				setState(1063);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1064);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationStatementContext extends ParserRuleContext {
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclarationTupleContext variableDeclarationTuple() {
			return getRuleContext(VariableDeclarationTupleContext.class,0);
		}
		public TerminalNode Assign() { return getToken(SolidityParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationStatementContext variableDeclarationStatement() throws RecognitionException {
		VariableDeclarationStatementContext _localctx = new VariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_variableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1075);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				{
				setState(1066);
				variableDeclaration();
				setState(1069);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(1067);
					match(Assign);
					setState(1068);
					expression(0);
					}
				}

				}
				}
				break;
			case 2:
				{
				{
				setState(1071);
				variableDeclarationTuple();
				setState(1072);
				match(Assign);
				setState(1073);
				expression(0);
				}
				}
				break;
			}
			setState(1077);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(SolidityParser.Semicolon, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1079);
			expression(0);
			setState(1080);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MappingTypeContext extends ParserRuleContext {
		public MappingKeyTypeContext key;
		public TypeNameContext value;
		public TerminalNode Mapping() { return getToken(SolidityParser.Mapping, 0); }
		public TerminalNode LParen() { return getToken(SolidityParser.LParen, 0); }
		public TerminalNode DoubleArrow() { return getToken(SolidityParser.DoubleArrow, 0); }
		public TerminalNode RParen() { return getToken(SolidityParser.RParen, 0); }
		public MappingKeyTypeContext mappingKeyType() {
			return getRuleContext(MappingKeyTypeContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public MappingTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMappingType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMappingType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMappingType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MappingTypeContext mappingType() throws RecognitionException {
		MappingTypeContext _localctx = new MappingTypeContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_mappingType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1082);
			match(Mapping);
			setState(1083);
			match(LParen);
			setState(1084);
			((MappingTypeContext)_localctx).key = mappingKeyType();
			setState(1085);
			match(DoubleArrow);
			setState(1086);
			((MappingTypeContext)_localctx).value = typeName(0);
			setState(1087);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MappingKeyTypeContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public IdentifierPathContext identifierPath() {
			return getRuleContext(IdentifierPathContext.class,0);
		}
		public MappingKeyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingKeyType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterMappingKeyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitMappingKeyType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitMappingKeyType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MappingKeyTypeContext mappingKeyType() throws RecognitionException {
		MappingKeyTypeContext _localctx = new MappingKeyTypeContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_mappingKeyType);
		try {
			setState(1091);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1089);
				elementaryTypeName(False);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1090);
				identifierPath();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulStatementContext extends ParserRuleContext {
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public YulVariableDeclarationContext yulVariableDeclaration() {
			return getRuleContext(YulVariableDeclarationContext.class,0);
		}
		public YulAssignmentContext yulAssignment() {
			return getRuleContext(YulAssignmentContext.class,0);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public YulIfStatementContext yulIfStatement() {
			return getRuleContext(YulIfStatementContext.class,0);
		}
		public YulForStatementContext yulForStatement() {
			return getRuleContext(YulForStatementContext.class,0);
		}
		public YulSwitchStatementContext yulSwitchStatement() {
			return getRuleContext(YulSwitchStatementContext.class,0);
		}
		public TerminalNode YulLeave() { return getToken(SolidityParser.YulLeave, 0); }
		public TerminalNode YulBreak() { return getToken(SolidityParser.YulBreak, 0); }
		public TerminalNode YulContinue() { return getToken(SolidityParser.YulContinue, 0); }
		public YulFunctionDefinitionContext yulFunctionDefinition() {
			return getRuleContext(YulFunctionDefinitionContext.class,0);
		}
		public YulStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulStatementContext yulStatement() throws RecognitionException {
		YulStatementContext _localctx = new YulStatementContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_yulStatement);
		try {
			setState(1104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1093);
				yulBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1094);
				yulVariableDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1095);
				yulAssignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1096);
				yulFunctionCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1097);
				yulIfStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1098);
				yulForStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1099);
				yulSwitchStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1100);
				match(YulLeave);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1101);
				match(YulBreak);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1102);
				match(YulContinue);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1103);
				yulFunctionDefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulBlockContext extends ParserRuleContext {
		public TerminalNode YulLBrace() { return getToken(SolidityParser.YulLBrace, 0); }
		public TerminalNode YulRBrace() { return getToken(SolidityParser.YulRBrace, 0); }
		public List<YulStatementContext> yulStatement() {
			return getRuleContexts(YulStatementContext.class);
		}
		public YulStatementContext yulStatement(int i) {
			return getRuleContext(YulStatementContext.class,i);
		}
		public YulBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulBlockContext yulBlock() throws RecognitionException {
		YulBlockContext _localctx = new YulBlockContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_yulBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1106);
			match(YulLBrace);
			setState(1110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & 4220901L) != 0) {
				{
				{
				setState(1107);
				yulStatement();
				}
				}
				setState(1112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1113);
			match(YulRBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulVariableDeclarationContext extends ParserRuleContext {
		public Token YulIdentifier;
		public List<Token> variables = new ArrayList<Token>();
		public TerminalNode YulLet() { return getToken(SolidityParser.YulLet, 0); }
		public List<TerminalNode> YulIdentifier() { return getTokens(SolidityParser.YulIdentifier); }
		public TerminalNode YulIdentifier(int i) {
			return getToken(SolidityParser.YulIdentifier, i);
		}
		public TerminalNode YulAssign() { return getToken(SolidityParser.YulAssign, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public YulVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulVariableDeclarationContext yulVariableDeclaration() throws RecognitionException {
		YulVariableDeclarationContext _localctx = new YulVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_yulVariableDeclaration);
		int _la;
		try {
			setState(1134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1115);
				match(YulLet);
				setState(1116);
				((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
				setState(1119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulAssign) {
					{
					setState(1117);
					match(YulAssign);
					setState(1118);
					yulExpression();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1121);
				match(YulLet);
				setState(1122);
				((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
				setState(1127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1123);
					match(YulComma);
					setState(1124);
					((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
					}
					}
					setState(1129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulAssign) {
					{
					setState(1130);
					match(YulAssign);
					setState(1131);
					yulFunctionCall();
					}
				}

				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulAssignmentContext extends ParserRuleContext {
		public List<YulPathContext> yulPath() {
			return getRuleContexts(YulPathContext.class);
		}
		public YulPathContext yulPath(int i) {
			return getRuleContext(YulPathContext.class,i);
		}
		public TerminalNode YulAssign() { return getToken(SolidityParser.YulAssign, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulAssignmentContext yulAssignment() throws RecognitionException {
		YulAssignmentContext _localctx = new YulAssignmentContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_yulAssignment);
		int _la;
		try {
			setState(1150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1136);
				yulPath();
				setState(1137);
				match(YulAssign);
				setState(1138);
				yulExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1140);
				yulPath();
				setState(1143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1141);
					match(YulComma);
					setState(1142);
					yulPath();
					}
					}
					setState(1145); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==YulComma );
				}
				setState(1147);
				match(YulAssign);
				setState(1148);
				yulFunctionCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulIfStatementContext extends ParserRuleContext {
		public YulExpressionContext cond;
		public YulBlockContext body;
		public TerminalNode YulIf() { return getToken(SolidityParser.YulIf, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public YulIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulIfStatementContext yulIfStatement() throws RecognitionException {
		YulIfStatementContext _localctx = new YulIfStatementContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_yulIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1152);
			match(YulIf);
			setState(1153);
			((YulIfStatementContext)_localctx).cond = yulExpression();
			setState(1154);
			((YulIfStatementContext)_localctx).body = yulBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulForStatementContext extends ParserRuleContext {
		public YulBlockContext init;
		public YulExpressionContext cond;
		public YulBlockContext post;
		public YulBlockContext body;
		public TerminalNode YulFor() { return getToken(SolidityParser.YulFor, 0); }
		public List<YulBlockContext> yulBlock() {
			return getRuleContexts(YulBlockContext.class);
		}
		public YulBlockContext yulBlock(int i) {
			return getRuleContext(YulBlockContext.class,i);
		}
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public YulForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulForStatementContext yulForStatement() throws RecognitionException {
		YulForStatementContext _localctx = new YulForStatementContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_yulForStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1156);
			match(YulFor);
			setState(1157);
			((YulForStatementContext)_localctx).init = yulBlock();
			setState(1158);
			((YulForStatementContext)_localctx).cond = yulExpression();
			setState(1159);
			((YulForStatementContext)_localctx).post = yulBlock();
			setState(1160);
			((YulForStatementContext)_localctx).body = yulBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulSwitchCaseContext extends ParserRuleContext {
		public TerminalNode YulCase() { return getToken(SolidityParser.YulCase, 0); }
		public YulLiteralContext yulLiteral() {
			return getRuleContext(YulLiteralContext.class,0);
		}
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public YulSwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulSwitchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulSwitchCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulSwitchCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulSwitchCaseContext yulSwitchCase() throws RecognitionException {
		YulSwitchCaseContext _localctx = new YulSwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_yulSwitchCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1162);
			match(YulCase);
			setState(1163);
			yulLiteral();
			setState(1164);
			yulBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulSwitchStatementContext extends ParserRuleContext {
		public TerminalNode YulSwitch() { return getToken(SolidityParser.YulSwitch, 0); }
		public YulExpressionContext yulExpression() {
			return getRuleContext(YulExpressionContext.class,0);
		}
		public TerminalNode YulDefault() { return getToken(SolidityParser.YulDefault, 0); }
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public List<YulSwitchCaseContext> yulSwitchCase() {
			return getRuleContexts(YulSwitchCaseContext.class);
		}
		public YulSwitchCaseContext yulSwitchCase(int i) {
			return getRuleContext(YulSwitchCaseContext.class,i);
		}
		public YulSwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulSwitchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulSwitchStatementContext yulSwitchStatement() throws RecognitionException {
		YulSwitchStatementContext _localctx = new YulSwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_yulSwitchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1166);
			match(YulSwitch);
			setState(1167);
			yulExpression();
			setState(1179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YulCase:
				{
				{
				setState(1169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1168);
					yulSwitchCase();
					}
					}
					setState(1171); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==YulCase );
				setState(1175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulDefault) {
					{
					setState(1173);
					match(YulDefault);
					setState(1174);
					yulBlock();
					}
				}

				}
				}
				break;
			case YulDefault:
				{
				{
				setState(1177);
				match(YulDefault);
				setState(1178);
				yulBlock();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulFunctionDefinitionContext extends ParserRuleContext {
		public Token YulIdentifier;
		public List<Token> arguments = new ArrayList<Token>();
		public List<Token> returnParameters = new ArrayList<Token>();
		public YulBlockContext body;
		public TerminalNode YulFunction() { return getToken(SolidityParser.YulFunction, 0); }
		public List<TerminalNode> YulIdentifier() { return getTokens(SolidityParser.YulIdentifier); }
		public TerminalNode YulIdentifier(int i) {
			return getToken(SolidityParser.YulIdentifier, i);
		}
		public TerminalNode YulLParen() { return getToken(SolidityParser.YulLParen, 0); }
		public TerminalNode YulRParen() { return getToken(SolidityParser.YulRParen, 0); }
		public YulBlockContext yulBlock() {
			return getRuleContext(YulBlockContext.class,0);
		}
		public TerminalNode YulArrow() { return getToken(SolidityParser.YulArrow, 0); }
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulFunctionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulFunctionDefinitionContext yulFunctionDefinition() throws RecognitionException {
		YulFunctionDefinitionContext _localctx = new YulFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_yulFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1181);
			match(YulFunction);
			setState(1182);
			match(YulIdentifier);
			setState(1183);
			match(YulLParen);
			setState(1192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==YulIdentifier) {
				{
				setState(1184);
				((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulFunctionDefinitionContext)_localctx).arguments.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
				setState(1189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1185);
					match(YulComma);
					setState(1186);
					((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulFunctionDefinitionContext)_localctx).arguments.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
					}
					}
					setState(1191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1194);
			match(YulRParen);
			setState(1204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==YulArrow) {
				{
				setState(1195);
				match(YulArrow);
				setState(1196);
				((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulFunctionDefinitionContext)_localctx).returnParameters.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
				setState(1201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1197);
					match(YulComma);
					setState(1198);
					((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulFunctionDefinitionContext)_localctx).returnParameters.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
					}
					}
					setState(1203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1206);
			((YulFunctionDefinitionContext)_localctx).body = yulBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulPathContext extends ParserRuleContext {
		public List<TerminalNode> YulIdentifier() { return getTokens(SolidityParser.YulIdentifier); }
		public TerminalNode YulIdentifier(int i) {
			return getToken(SolidityParser.YulIdentifier, i);
		}
		public List<TerminalNode> YulPeriod() { return getTokens(SolidityParser.YulPeriod); }
		public TerminalNode YulPeriod(int i) {
			return getToken(SolidityParser.YulPeriod, i);
		}
		public YulPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulPathContext yulPath() throws RecognitionException {
		YulPathContext _localctx = new YulPathContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_yulPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1208);
			match(YulIdentifier);
			setState(1213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==YulPeriod) {
				{
				{
				setState(1209);
				match(YulPeriod);
				setState(1210);
				match(YulIdentifier);
				}
				}
				setState(1215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulFunctionCallContext extends ParserRuleContext {
		public TerminalNode YulLParen() { return getToken(SolidityParser.YulLParen, 0); }
		public TerminalNode YulRParen() { return getToken(SolidityParser.YulRParen, 0); }
		public TerminalNode YulIdentifier() { return getToken(SolidityParser.YulIdentifier, 0); }
		public TerminalNode YulEVMBuiltin() { return getToken(SolidityParser.YulEVMBuiltin, 0); }
		public List<YulExpressionContext> yulExpression() {
			return getRuleContexts(YulExpressionContext.class);
		}
		public YulExpressionContext yulExpression(int i) {
			return getRuleContext(YulExpressionContext.class,i);
		}
		public List<TerminalNode> YulComma() { return getTokens(SolidityParser.YulComma); }
		public TerminalNode YulComma(int i) {
			return getToken(SolidityParser.YulComma, i);
		}
		public YulFunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulFunctionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulFunctionCallContext yulFunctionCall() throws RecognitionException {
		YulFunctionCallContext _localctx = new YulFunctionCallContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_yulFunctionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1216);
			_la = _input.LA(1);
			if ( !(_la==YulEVMBuiltin || _la==YulIdentifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1217);
			match(YulLParen);
			setState(1226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & 8127105L) != 0) {
				{
				setState(1218);
				yulExpression();
				setState(1223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1219);
					match(YulComma);
					setState(1220);
					yulExpression();
					}
					}
					setState(1225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1228);
			match(YulRParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulBooleanContext extends ParserRuleContext {
		public TerminalNode YulTrue() { return getToken(SolidityParser.YulTrue, 0); }
		public TerminalNode YulFalse() { return getToken(SolidityParser.YulFalse, 0); }
		public YulBooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulBoolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulBooleanContext yulBoolean() throws RecognitionException {
		YulBooleanContext _localctx = new YulBooleanContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_yulBoolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1230);
			_la = _input.LA(1);
			if ( !(_la==YulFalse || _la==YulTrue) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulLiteralContext extends ParserRuleContext {
		public TerminalNode YulDecimalNumber() { return getToken(SolidityParser.YulDecimalNumber, 0); }
		public TerminalNode YulStringLiteral() { return getToken(SolidityParser.YulStringLiteral, 0); }
		public TerminalNode YulHexNumber() { return getToken(SolidityParser.YulHexNumber, 0); }
		public YulBooleanContext yulBoolean() {
			return getRuleContext(YulBooleanContext.class,0);
		}
		public TerminalNode YulHexStringLiteral() { return getToken(SolidityParser.YulHexStringLiteral, 0); }
		public YulLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulLiteralContext yulLiteral() throws RecognitionException {
		YulLiteralContext _localctx = new YulLiteralContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_yulLiteral);
		try {
			setState(1237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YulDecimalNumber:
				enterOuterAlt(_localctx, 1);
				{
				setState(1232);
				match(YulDecimalNumber);
				}
				break;
			case YulStringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(1233);
				match(YulStringLiteral);
				}
				break;
			case YulHexNumber:
				enterOuterAlt(_localctx, 3);
				{
				setState(1234);
				match(YulHexNumber);
				}
				break;
			case YulFalse:
			case YulTrue:
				enterOuterAlt(_localctx, 4);
				{
				setState(1235);
				yulBoolean();
				}
				break;
			case YulHexStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(1236);
				match(YulHexStringLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YulExpressionContext extends ParserRuleContext {
		public YulPathContext yulPath() {
			return getRuleContext(YulPathContext.class,0);
		}
		public YulFunctionCallContext yulFunctionCall() {
			return getRuleContext(YulFunctionCallContext.class,0);
		}
		public YulLiteralContext yulLiteral() {
			return getRuleContext(YulLiteralContext.class,0);
		}
		public YulExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yulExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).enterYulExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityParserListener ) ((SolidityParserListener)listener).exitYulExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityParserVisitor ) return ((SolidityParserVisitor<? extends T>)visitor).visitYulExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YulExpressionContext yulExpression() throws RecognitionException {
		YulExpressionContext _localctx = new YulExpressionContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_yulExpression);
		try {
			setState(1242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1239);
				yulPath();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1240);
				yulFunctionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1241);
				yulLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return constructorDefinition_sempred((ConstructorDefinitionContext)_localctx, predIndex);
		case 22:
			return functionDefinition_sempred((FunctionDefinitionContext)_localctx, predIndex);
		case 23:
			return modifierDefinition_sempred((ModifierDefinitionContext)_localctx, predIndex);
		case 24:
			return fallbackFunctionDefinition_sempred((FallbackFunctionDefinitionContext)_localctx, predIndex);
		case 25:
			return receiveFunctionDefinition_sempred((ReceiveFunctionDefinitionContext)_localctx, predIndex);
		case 30:
			return stateVariableDeclaration_sempred((StateVariableDeclarationContext)_localctx, predIndex);
		case 37:
			return typeName_sempred((TypeNameContext)_localctx, predIndex);
		case 38:
			return elementaryTypeName_sempred((ElementaryTypeNameContext)_localctx, predIndex);
		case 39:
			return functionTypeName_sempred((FunctionTypeNameContext)_localctx, predIndex);
		case 42:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean constructorDefinition_sempred(ConstructorDefinitionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return not _localctx.payableSet;
		case 1:
			return not _localctx.visibilitySet;
		case 2:
			return not _localctx.visibilitySet;
		}
		return true;
	}
	private boolean functionDefinition_sempred(FunctionDefinitionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return not _localctx.visibilitySet;
		case 4:
			return not _localctx.mutabilitySet;
		case 5:
			return not _localctx.virtualSet;
		case 6:
			return not _localctx.overrideSpecifierSet;
		}
		return true;
	}
	private boolean modifierDefinition_sempred(ModifierDefinitionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return not _localctx.virtualSet;
		case 8:
			return not _localctx.overrideSpecifierSet;
		}
		return true;
	}
	private boolean fallbackFunctionDefinition_sempred(FallbackFunctionDefinitionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return not _localctx.visibilitySet;
		case 10:
			return not _localctx.mutabilitySet;
		case 11:
			return not _localctx.virtualSet;
		case 12:
			return not _localctx.overrideSpecifierSet;
		case 13:
			return _localctx.hasParameters;
		case 14:
			return not _localctx.hasParameters;
		}
		return true;
	}
	private boolean receiveFunctionDefinition_sempred(ReceiveFunctionDefinitionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return not _localctx.visibilitySet;
		case 16:
			return not _localctx.mutabilitySet;
		case 17:
			return not _localctx.virtualSet;
		case 18:
			return not _localctx.overrideSpecifierSet;
		}
		return true;
	}
	private boolean stateVariableDeclaration_sempred(StateVariableDeclarationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return not _localctx.visibilitySet;
		case 20:
			return not _localctx.visibilitySet;
		case 21:
			return not _localctx.visibilitySet;
		case 22:
			return not _localctx.constantnessSet;
		case 23:
			return not _localctx.overrideSpecifierSet;
		case 24:
			return not _localctx.constantnessSet;
		}
		return true;
	}
	private boolean typeName_sempred(TypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 25:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean elementaryTypeName_sempred(ElementaryTypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 26:
			return _localctx.allowAddressPayable;
		}
		return true;
	}
	private boolean functionTypeName_sempred(FunctionTypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 27:
			return not _localctx.visibilitySet;
		case 28:
			return not _localctx.mutabilitySet;
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 29:
			return precpred(_ctx, 17);
		case 30:
			return precpred(_ctx, 16);
		case 31:
			return precpred(_ctx, 15);
		case 32:
			return precpred(_ctx, 14);
		case 33:
			return precpred(_ctx, 13);
		case 34:
			return precpred(_ctx, 12);
		case 35:
			return precpred(_ctx, 11);
		case 36:
			return precpred(_ctx, 10);
		case 37:
			return precpred(_ctx, 9);
		case 38:
			return precpred(_ctx, 8);
		case 39:
			return precpred(_ctx, 7);
		case 40:
			return precpred(_ctx, 5);
		case 41:
			return precpred(_ctx, 25);
		case 42:
			return precpred(_ctx, 24);
		case 43:
			return precpred(_ctx, 23);
		case 44:
			return precpred(_ctx, 22);
		case 45:
			return precpred(_ctx, 18);
		case 46:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00a9\u04dd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u00be\b\u0000"+
		"\n\u0000\f\u0000\u00c1\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0004\u0001\u00c7\b\u0001\u000b\u0001\f\u0001\u00c8\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"\u00d1\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"\u00dd\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u00e4\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u00ec\b\u0005\n\u0005\f\u0005\u00ef"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0003\u0006\u00f4\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00f9\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u00fd\b\u0006\n\u0006\f\u0006\u0100\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0107"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u010b\b\u0007\n\u0007\f\u0007"+
		"\u010e\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0005\b\u0116\b\b\n\b\f\b\u0119\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u0121\b\t\n\t\f\t\u0124\t\t\u0001\n\u0001\n\u0003\n"+
		"\u0128\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0136\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0140\b\r\n\r\f\r\u0143\t\r\u0003"+
		"\r\u0145\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u014b\b\r\n\r\f\r"+
		"\u014e\t\r\u0003\r\u0150\b\r\u0001\r\u0003\r\u0153\b\r\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u015a\b\u000e\n\u000e"+
		"\f\u000e\u015d\t\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u0161\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u0168\b\u0011\n\u0011\f\u0011\u016b\t\u0011\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u016f\b\u0012\u0001\u0012\u0003\u0012\u0172\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u0177\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0184\b\u0013\n\u0013"+
		"\f\u0013\u0187\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u0192\b\u0015\n\u0015\f\u0015\u0195\t\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u0199\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u019f\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01a3\b\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u01b6\b\u0016\n\u0016\f\u0016\u01b9\t\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01c0\b\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u01c4\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u01ca\b\u0017\u0001\u0017\u0003\u0017\u01cd\b\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u01d6\b\u0017\n\u0017\f\u0017\u01d9\t\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u01dd\b\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01e4\b\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01f6\b\u0018\n\u0018\f\u0018"+
		"\u01f9\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0202\b\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0206\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u0219\b\u0019\n\u0019\f\u0019\u021c\t\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u0220\b\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0004\u001a\u0226\b\u001a\u000b\u001a\f\u001a\u0227"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0005\u001c\u0236\b\u001c\n\u001c\f\u001c\u0239\t\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0257\b\u001e\n\u001e\f\u001e"+
		"\u025a\t\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u025f\b"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0003 \u026c"+
		"\b \u0001 \u0003 \u026f\b \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0005"+
		"!\u0277\b!\n!\f!\u027a\t!\u0003!\u027c\b!\u0001!\u0001!\u0003!\u0280\b"+
		"!\u0001!\u0001!\u0001\"\u0001\"\u0003\"\u0286\b\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0005#\u028e\b#\n#\f#\u0291\t#\u0003#\u0293\b#"+
		"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u029d"+
		"\b$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u02a6\b%\u0001"+
		"%\u0001%\u0001%\u0003%\u02ab\b%\u0001%\u0005%\u02ae\b%\n%\f%\u02b1\t%"+
		"\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0003&\u02bf\b&\u0001\'\u0001\'\u0001\'\u0003\'\u02c4"+
		"\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0005\'\u02cf\b\'\n\'\f\'\u02d2\t\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0003\'\u02d9\b\'\u0001(\u0001(\u0003(\u02dd\b(\u0001(\u0001"+
		"(\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u02f4\b*\u0003*\u02f6\b*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0003*\u0320\b*\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u0326\b*\u0001*\u0001*\u0003*\u032a\b*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0003*\u0331\b*\u0001*\u0001*\u0001*\u0001*\u0001*\u0005*\u0338\b*\n"+
		"*\f*\u033b\t*\u0003*\u033d\b*\u0001*\u0003*\u0340\b*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0005*\u034b\b*\n*\f*\u034e"+
		"\t*\u0001+\u0001+\u0001,\u0001,\u0003,\u0354\b,\u0001,\u0001,\u0003,\u0358"+
		"\b,\u0005,\u035a\b,\n,\f,\u035d\t,\u0001,\u0001,\u0001-\u0001-\u0001-"+
		"\u0001-\u0005-\u0365\b-\n-\f-\u0368\t-\u0001-\u0001-\u0001.\u0001.\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0003/\u0373\b/\u00010\u00010\u00011\u0004"+
		"1\u0378\b1\u000b1\f1\u0379\u00012\u00042\u037d\b2\u000b2\f2\u037e\u0001"+
		"3\u00043\u0382\b3\u000b3\f3\u0383\u00014\u00014\u00034\u0388\b4\u0001"+
		"5\u00015\u00015\u00055\u038d\b5\n5\f5\u0390\t5\u00015\u00015\u00016\u0001"+
		"6\u00016\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00017\u00037\u03a4\b7\u00018\u00018\u00038\u03a8"+
		"\b8\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00039\u03b1\b9\u0001"+
		":\u0001:\u0001:\u0001:\u0003:\u03b7\b:\u0001:\u0001:\u0003:\u03bb\b:\u0001"+
		":\u0003:\u03be\b:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0001?\u0001?\u0003?\u03de\b?\u0001?\u0001?\u0004?\u03e2\b?\u000b?\f"+
		"?\u03e3\u0001@\u0001@\u0003@\u03e8\b@\u0001@\u0001@\u0001@\u0001@\u0003"+
		"@\u03ee\b@\u0001@\u0001@\u0001A\u0001A\u0003A\u03f4\bA\u0001A\u0001A\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0001C\u0001C\u0001C\u0001C\u0001C\u0001"+
		"D\u0001D\u0003D\u0404\bD\u0001D\u0001D\u0005D\u0408\bD\nD\fD\u040b\tD"+
		"\u0001D\u0001D\u0001E\u0001E\u0001E\u0005E\u0412\bE\nE\fE\u0415\tE\u0001"+
		"F\u0001F\u0005F\u0419\bF\nF\fF\u041c\tF\u0001F\u0001F\u0001F\u0001F\u0003"+
		"F\u0422\bF\u0005F\u0424\bF\nF\fF\u0427\tF\u0001F\u0001F\u0001G\u0001G"+
		"\u0001G\u0003G\u042e\bG\u0001G\u0001G\u0001G\u0001G\u0003G\u0434\bG\u0001"+
		"G\u0001G\u0001H\u0001H\u0001H\u0001I\u0001I\u0001I\u0001I\u0001I\u0001"+
		"I\u0001I\u0001J\u0001J\u0003J\u0444\bJ\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0003K\u0451\bK\u0001L\u0001"+
		"L\u0005L\u0455\bL\nL\fL\u0458\tL\u0001L\u0001L\u0001M\u0001M\u0001M\u0001"+
		"M\u0003M\u0460\bM\u0001M\u0001M\u0001M\u0001M\u0005M\u0466\bM\nM\fM\u0469"+
		"\tM\u0001M\u0001M\u0003M\u046d\bM\u0003M\u046f\bM\u0001N\u0001N\u0001"+
		"N\u0001N\u0001N\u0001N\u0001N\u0004N\u0478\bN\u000bN\fN\u0479\u0001N\u0001"+
		"N\u0001N\u0003N\u047f\bN\u0001O\u0001O\u0001O\u0001O\u0001P\u0001P\u0001"+
		"P\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0001Q\u0001R\u0001R\u0001"+
		"R\u0004R\u0492\bR\u000bR\fR\u0493\u0001R\u0001R\u0003R\u0498\bR\u0001"+
		"R\u0001R\u0003R\u049c\bR\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0005"+
		"S\u04a4\bS\nS\fS\u04a7\tS\u0003S\u04a9\bS\u0001S\u0001S\u0001S\u0001S"+
		"\u0001S\u0005S\u04b0\bS\nS\fS\u04b3\tS\u0003S\u04b5\bS\u0001S\u0001S\u0001"+
		"T\u0001T\u0001T\u0005T\u04bc\bT\nT\fT\u04bf\tT\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0005U\u04c6\bU\nU\fU\u04c9\tU\u0003U\u04cb\bU\u0001U\u0001U"+
		"\u0001V\u0001V\u0001W\u0001W\u0001W\u0001W\u0001W\u0003W\u04d6\bW\u0001"+
		"X\u0001X\u0001X\u0003X\u04db\bX\u0001X\u0001\u0122\u0002JTY\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u0000\u0011\u0003"+
		"\u0000\u0019\u0019\'\'12\u0003\u00000033BB\u0003\u0000\u000b\u000b++8"+
		"8\u0003\u0000\u0011\u0011ggru\u0001\u0000hj\u0001\u0000fg\u0001\u0000"+
		"ce\u0001\u0000nq\u0001\u0000lm\u0001\u0000tu\u0001\u0000Q\\\u0003\u0000"+
		"\u0016\u0017\u001d\u001d~~\u0002\u0000\u001b\u001b;;\u0001\u0000xy\u0001"+
		"\u0000|}\u0002\u0000\u0094\u0094\u009d\u009d\u0002\u0000\u008b\u008b\u0092"+
		"\u0092\u0569\u0000\u00bf\u0001\u0000\u0000\u0000\u0002\u00c4\u0001\u0000"+
		"\u0000\u0000\u0004\u00cc\u0001\u0000\u0000\u0000\u0006\u00e0\u0001\u0000"+
		"\u0000\u0000\b\u00e5\u0001\u0000\u0000\u0000\n\u00e7\u0001\u0000\u0000"+
		"\u0000\f\u00f3\u0001\u0000\u0000\u0000\u000e\u0103\u0001\u0000\u0000\u0000"+
		"\u0010\u0111\u0001\u0000\u0000\u0000\u0012\u011c\u0001\u0000\u0000\u0000"+
		"\u0014\u0125\u0001\u0000\u0000\u0000\u0016\u0135\u0001\u0000\u0000\u0000"+
		"\u0018\u0137\u0001\u0000\u0000\u0000\u001a\u013b\u0001\u0000\u0000\u0000"+
		"\u001c\u0156\u0001\u0000\u0000\u0000\u001e\u015e\u0001\u0000\u0000\u0000"+
		" \u0162\u0001\u0000\u0000\u0000\"\u0164\u0001\u0000\u0000\u0000$\u016c"+
		"\u0001\u0000\u0000\u0000&\u0173\u0001\u0000\u0000\u0000(\u018a\u0001\u0000"+
		"\u0000\u0000*\u018c\u0001\u0000\u0000\u0000,\u019a\u0001\u0000\u0000\u0000"+
		".\u01c5\u0001\u0000\u0000\u00000\u01de\u0001\u0000\u0000\u00002\u0207"+
		"\u0001\u0000\u0000\u00004\u0221\u0001\u0000\u0000\u00006\u022b\u0001\u0000"+
		"\u0000\u00008\u022f\u0001\u0000\u0000\u0000:\u023c\u0001\u0000\u0000\u0000"+
		"<\u0242\u0001\u0000\u0000\u0000>\u0262\u0001\u0000\u0000\u0000@\u0269"+
		"\u0001\u0000\u0000\u0000B\u0270\u0001\u0000\u0000\u0000D\u0283\u0001\u0000"+
		"\u0000\u0000F\u0287\u0001\u0000\u0000\u0000H\u0297\u0001\u0000\u0000\u0000"+
		"J\u02a5\u0001\u0000\u0000\u0000L\u02be\u0001\u0000\u0000\u0000N\u02c0"+
		"\u0001\u0000\u0000\u0000P\u02da\u0001\u0000\u0000\u0000R\u02e0\u0001\u0000"+
		"\u0000\u0000T\u02f5\u0001\u0000\u0000\u0000V\u034f\u0001\u0000\u0000\u0000"+
		"X\u0351\u0001\u0000\u0000\u0000Z\u0360\u0001\u0000\u0000\u0000\\\u036b"+
		"\u0001\u0000\u0000\u0000^\u0372\u0001\u0000\u0000\u0000`\u0374\u0001\u0000"+
		"\u0000\u0000b\u0377\u0001\u0000\u0000\u0000d\u037c\u0001\u0000\u0000\u0000"+
		"f\u0381\u0001\u0000\u0000\u0000h\u0385\u0001\u0000\u0000\u0000j\u0389"+
		"\u0001\u0000\u0000\u0000l\u0393\u0001\u0000\u0000\u0000n\u03a3\u0001\u0000"+
		"\u0000\u0000p\u03a7\u0001\u0000\u0000\u0000r\u03a9\u0001\u0000\u0000\u0000"+
		"t\u03b2\u0001\u0000\u0000\u0000v\u03c2\u0001\u0000\u0000\u0000x\u03c8"+
		"\u0001\u0000\u0000\u0000z\u03d0\u0001\u0000\u0000\u0000|\u03d3\u0001\u0000"+
		"\u0000\u0000~\u03d6\u0001\u0000\u0000\u0000\u0080\u03e5\u0001\u0000\u0000"+
		"\u0000\u0082\u03f1\u0001\u0000\u0000\u0000\u0084\u03f7\u0001\u0000\u0000"+
		"\u0000\u0086\u03fc\u0001\u0000\u0000\u0000\u0088\u0401\u0001\u0000\u0000"+
		"\u0000\u008a\u040e\u0001\u0000\u0000\u0000\u008c\u0416\u0001\u0000\u0000"+
		"\u0000\u008e\u0433\u0001\u0000\u0000\u0000\u0090\u0437\u0001\u0000\u0000"+
		"\u0000\u0092\u043a\u0001\u0000\u0000\u0000\u0094\u0443\u0001\u0000\u0000"+
		"\u0000\u0096\u0450\u0001\u0000\u0000\u0000\u0098\u0452\u0001\u0000\u0000"+
		"\u0000\u009a\u046e\u0001\u0000\u0000\u0000\u009c\u047e\u0001\u0000\u0000"+
		"\u0000\u009e\u0480\u0001\u0000\u0000\u0000\u00a0\u0484\u0001\u0000\u0000"+
		"\u0000\u00a2\u048a\u0001\u0000\u0000\u0000\u00a4\u048e\u0001\u0000\u0000"+
		"\u0000\u00a6\u049d\u0001\u0000\u0000\u0000\u00a8\u04b8\u0001\u0000\u0000"+
		"\u0000\u00aa\u04c0\u0001\u0000\u0000\u0000\u00ac\u04ce\u0001\u0000\u0000"+
		"\u0000\u00ae\u04d5\u0001\u0000\u0000\u0000\u00b0\u04da\u0001\u0000\u0000"+
		"\u0000\u00b2\u00be\u0003\u0002\u0001\u0000\u00b3\u00be\u0003\u0004\u0002"+
		"\u0000\u00b4\u00be\u0003\f\u0006\u0000\u00b5\u00be\u0003\u000e\u0007\u0000"+
		"\u00b6\u00be\u0003\u0010\b\u0000\u00b7\u00be\u0003,\u0016\u0000\u00b8"+
		"\u00be\u0003>\u001f\u0000\u00b9\u00be\u00034\u001a\u0000\u00ba\u00be\u0003"+
		"8\u001c\u0000\u00bb\u00be\u0003:\u001d\u0000\u00bc\u00be\u0003F#\u0000"+
		"\u00bd\u00b2\u0001\u0000\u0000\u0000\u00bd\u00b3\u0001\u0000\u0000\u0000"+
		"\u00bd\u00b4\u0001\u0000\u0000\u0000\u00bd\u00b5\u0001\u0000\u0000\u0000"+
		"\u00bd\u00b6\u0001\u0000\u0000\u0000\u00bd\u00b7\u0001\u0000\u0000\u0000"+
		"\u00bd\u00b8\u0001\u0000\u0000\u0000\u00bd\u00b9\u0001\u0000\u0000\u0000"+
		"\u00bd\u00ba\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000"+
		"\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0005\u0000\u0000\u0001\u00c3\u0001\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c6\u0005\u0002\u0000\u0000\u00c5\u00c7\u0005\u00a5\u0000\u0000"+
		"\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005\u00a6\u0000\u0000"+
		"\u00cb\u0003\u0001\u0000\u0000\u0000\u00cc\u00dc\u0005$\u0000\u0000\u00cd"+
		"\u00d0\u0003\b\u0004\u0000\u00ce\u00cf\u0005\u0006\u0000\u0000\u00cf\u00d1"+
		"\u0003\\.\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d1\u00dd\u0001\u0000\u0000\u0000\u00d2\u00d3\u0003"+
		"\n\u0005\u0000\u00d3\u00d4\u0005\u001d\u0000\u0000\u00d4\u00d5\u0003\b"+
		"\u0004\u0000\u00d5\u00dd\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005h\u0000"+
		"\u0000\u00d7\u00d8\u0005\u0006\u0000\u0000\u00d8\u00d9\u0003\\.\u0000"+
		"\u00d9\u00da\u0005\u001d\u0000\u0000\u00da\u00db\u0003\b\u0004\u0000\u00db"+
		"\u00dd\u0001\u0000\u0000\u0000\u00dc\u00cd\u0001\u0000\u0000\u0000\u00dc"+
		"\u00d2\u0001\u0000\u0000\u0000\u00dc\u00d6\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0001\u0000\u0000\u0000\u00de\u00df\u0005L\u0000\u0000\u00df\u0005"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e3\u0003\\.\u0000\u00e1\u00e2\u0005"+
		"\u0006\u0000\u0000\u00e2\u00e4\u0003\\.\u0000\u00e3\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u0007\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e6\u0005x\u0000\u0000\u00e6\t\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0005I\u0000\u0000\u00e8\u00ed\u0003\u0006\u0003\u0000"+
		"\u00e9\u00ea\u0005]\u0000\u0000\u00ea\u00ec\u0003\u0006\u0003\u0000\u00eb"+
		"\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee"+
		"\u00f0\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\u0005J\u0000\u0000\u00f1\u000b\u0001\u0000\u0000\u0000\u00f2\u00f4"+
		"\u0005\u0003\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\u0005\u0010\u0000\u0000\u00f6\u00f8\u0003\\.\u0000\u00f7\u00f9\u0003"+
		"\u0012\t\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fe\u0005I\u0000"+
		"\u0000\u00fb\u00fd\u0003\u0016\u000b\u0000\u00fc\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fd\u0100\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0101\u0001\u0000\u0000"+
		"\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0102\u0005J\u0000\u0000"+
		"\u0102\r\u0001\u0000\u0000\u0000\u0103\u0104\u0005&\u0000\u0000\u0104"+
		"\u0106\u0003\\.\u0000\u0105\u0107\u0003\u0012\t\u0000\u0106\u0105\u0001"+
		"\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0108\u0001"+
		"\u0000\u0000\u0000\u0108\u010c\u0005I\u0000\u0000\u0109\u010b\u0003\u0016"+
		"\u000b\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010b\u010e\u0001\u0000"+
		"\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d\u010f\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0005J\u0000\u0000\u0110\u000f\u0001\u0000\u0000"+
		"\u0000\u0111\u0112\u0005)\u0000\u0000\u0112\u0113\u0003\\.\u0000\u0113"+
		"\u0117\u0005I\u0000\u0000\u0114\u0116\u0003\u0016\u000b\u0000\u0115\u0114"+
		"\u0001\u0000\u0000\u0000\u0116\u0119\u0001\u0000\u0000\u0000\u0117\u0115"+
		"\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u011a"+
		"\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u011a\u011b"+
		"\u0005J\u0000\u0000\u011b\u0011\u0001\u0000\u0000\u0000\u011c\u011d\u0005"+
		"(\u0000\u0000\u011d\u0122\u0003\u0014\n\u0000\u011e\u011f\u0005]\u0000"+
		"\u0000\u011f\u0121\u0003\u0014\n\u0000\u0120\u011e\u0001\u0000\u0000\u0000"+
		"\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000"+
		"\u0122\u0120\u0001\u0000\u0000\u0000\u0123\u0013\u0001\u0000\u0000\u0000"+
		"\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u0127\u0003\u001c\u000e\u0000"+
		"\u0126\u0128\u0003\u001a\r\u0000\u0127\u0126\u0001\u0000\u0000\u0000\u0127"+
		"\u0128\u0001\u0000\u0000\u0000\u0128\u0015\u0001\u0000\u0000\u0000\u0129"+
		"\u0136\u0003&\u0013\u0000\u012a\u0136\u0003,\u0016\u0000\u012b\u0136\u0003"+
		".\u0017\u0000\u012c\u0136\u00030\u0018\u0000\u012d\u0136\u00032\u0019"+
		"\u0000\u012e\u0136\u00034\u001a\u0000\u012f\u0136\u00038\u001c\u0000\u0130"+
		"\u0136\u0003:\u001d\u0000\u0131\u0136\u0003<\u001e\u0000\u0132\u0136\u0003"+
		"B!\u0000\u0133\u0136\u0003F#\u0000\u0134\u0136\u0003H$\u0000\u0135\u0129"+
		"\u0001\u0000\u0000\u0000\u0135\u012a\u0001\u0000\u0000\u0000\u0135\u012b"+
		"\u0001\u0000\u0000\u0000\u0135\u012c\u0001\u0000\u0000\u0000\u0135\u012d"+
		"\u0001\u0000\u0000\u0000\u0135\u012e\u0001\u0000\u0000\u0000\u0135\u012f"+
		"\u0001\u0000\u0000\u0000\u0135\u0130\u0001\u0000\u0000\u0000\u0135\u0131"+
		"\u0001\u0000\u0000\u0000\u0135\u0132\u0001\u0000\u0000\u0000\u0135\u0133"+
		"\u0001\u0000\u0000\u0000\u0135\u0134\u0001\u0000\u0000\u0000\u0136\u0017"+
		"\u0001\u0000\u0000\u0000\u0137\u0138\u0003\\.\u0000\u0138\u0139\u0005"+
		"K\u0000\u0000\u0139\u013a\u0003T*\u0000\u013a\u0019\u0001\u0000\u0000"+
		"\u0000\u013b\u0152\u0005E\u0000\u0000\u013c\u0141\u0003T*\u0000\u013d"+
		"\u013e\u0005]\u0000\u0000\u013e\u0140\u0003T*\u0000\u013f\u013d\u0001"+
		"\u0000\u0000\u0000\u0140\u0143\u0001\u0000\u0000\u0000\u0141\u013f\u0001"+
		"\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0145\u0001"+
		"\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0144\u013c\u0001"+
		"\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0153\u0001"+
		"\u0000\u0000\u0000\u0146\u014f\u0005I\u0000\u0000\u0147\u014c\u0003\u0018"+
		"\f\u0000\u0148\u0149\u0005]\u0000\u0000\u0149\u014b\u0003\u0018\f\u0000"+
		"\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000\u0000"+
		"\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000"+
		"\u014d\u0150\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000"+
		"\u014f\u0147\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000"+
		"\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0153\u0005J\u0000\u0000\u0152"+
		"\u0144\u0001\u0000\u0000\u0000\u0152\u0146\u0001\u0000\u0000\u0000\u0153"+
		"\u0154\u0001\u0000\u0000\u0000\u0154\u0155\u0005F\u0000\u0000\u0155\u001b"+
		"\u0001\u0000\u0000\u0000\u0156\u015b\u0003\\.\u0000\u0157\u0158\u0005"+
		"M\u0000\u0000\u0158\u015a\u0003\\.\u0000\u0159\u0157\u0001\u0000\u0000"+
		"\u0000\u015a\u015d\u0001\u0000\u0000\u0000\u015b\u0159\u0001\u0000\u0000"+
		"\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u001d\u0001\u0000\u0000"+
		"\u0000\u015d\u015b\u0001\u0000\u0000\u0000\u015e\u0160\u0003\u001c\u000e"+
		"\u0000\u015f\u0161\u0003\u001a\r\u0000\u0160\u015f\u0001\u0000\u0000\u0000"+
		"\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u001f\u0001\u0000\u0000\u0000"+
		"\u0162\u0163\u0007\u0000\u0000\u0000\u0163!\u0001\u0000\u0000\u0000\u0164"+
		"\u0169\u0003$\u0012\u0000\u0165\u0166\u0005]\u0000\u0000\u0166\u0168\u0003"+
		"$\u0012\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0168\u016b\u0001\u0000"+
		"\u0000\u0000\u0169\u0167\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000"+
		"\u0000\u0000\u016a#\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000"+
		"\u0000\u016c\u016e\u0003J%\u0000\u016d\u016f\u0003R)\u0000\u016e\u016d"+
		"\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0171"+
		"\u0001\u0000\u0000\u0000\u0170\u0172\u0003\\.\u0000\u0171\u0170\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172%\u0001\u0000"+
		"\u0000\u0000\u0173\u0174\u0005\u000e\u0000\u0000\u0174\u0176\u0005E\u0000"+
		"\u0000\u0175\u0177\u0003\"\u0011\u0000\u0176\u0175\u0001\u0000\u0000\u0000"+
		"\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000"+
		"\u0178\u0185\u0005F\u0000\u0000\u0179\u0184\u0003\u001e\u000f\u0000\u017a"+
		"\u017b\u0004\u0013\u0000\u0001\u017b\u017c\u00050\u0000\u0000\u017c\u0184"+
		"\u0006\u0013\uffff\uffff\u0000\u017d\u017e\u0004\u0013\u0001\u0001\u017e"+
		"\u017f\u0005\'\u0000\u0000\u017f\u0184\u0006\u0013\uffff\uffff\u0000\u0180"+
		"\u0181\u0004\u0013\u0002\u0001\u0181\u0182\u00052\u0000\u0000\u0182\u0184"+
		"\u0006\u0013\uffff\uffff\u0000\u0183\u0179\u0001\u0000\u0000\u0000\u0183"+
		"\u017a\u0001\u0000\u0000\u0000\u0183\u017d\u0001\u0000\u0000\u0000\u0183"+
		"\u0180\u0001\u0000\u0000\u0000\u0184\u0187\u0001\u0000\u0000\u0000\u0185"+
		"\u0183\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186"+
		"\u0188\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188"+
		"\u0189\u0003j5\u0000\u0189\'\u0001\u0000\u0000\u0000\u018a\u018b\u0007"+
		"\u0001\u0000\u0000\u018b)\u0001\u0000\u0000\u0000\u018c\u0198\u0005/\u0000"+
		"\u0000\u018d\u018e\u0005E\u0000\u0000\u018e\u0193\u0003\u001c\u000e\u0000"+
		"\u018f\u0190\u0005]\u0000\u0000\u0190\u0192\u0003\u001c\u000e\u0000\u0191"+
		"\u018f\u0001\u0000\u0000\u0000\u0192\u0195\u0001\u0000\u0000\u0000\u0193"+
		"\u0191\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194"+
		"\u0196\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000\u0000\u0000\u0196"+
		"\u0197\u0005F\u0000\u0000\u0197\u0199\u0001\u0000\u0000\u0000\u0198\u018d"+
		"\u0001\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199+\u0001"+
		"\u0000\u0000\u0000\u019a\u019e\u0005 \u0000\u0000\u019b\u019f\u0003\\"+
		".\u0000\u019c\u019f\u0005\u001a\u0000\u0000\u019d\u019f\u00054\u0000\u0000"+
		"\u019e\u019b\u0001\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000"+
		"\u019e\u019d\u0001\u0000\u0000\u0000\u019f\u01a0\u0001\u0000\u0000\u0000"+
		"\u01a0\u01a2\u0005E\u0000\u0000\u01a1\u01a3\u0003\"\u0011\u0000\u01a2"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3"+
		"\u01a4\u0001\u0000\u0000\u0000\u01a4\u01b7\u0005F\u0000\u0000\u01a5\u01a6"+
		"\u0004\u0016\u0003\u0001\u01a6\u01a7\u0003 \u0010\u0000\u01a7\u01a8\u0006"+
		"\u0016\uffff\uffff\u0000\u01a8\u01b6\u0001\u0000\u0000\u0000\u01a9\u01aa"+
		"\u0004\u0016\u0004\u0001\u01aa\u01ab\u0003(\u0014\u0000\u01ab\u01ac\u0006"+
		"\u0016\uffff\uffff\u0000\u01ac\u01b6\u0001\u0000\u0000\u0000\u01ad\u01b6"+
		"\u0003\u001e\u000f\u0000\u01ae\u01af\u0004\u0016\u0005\u0001\u01af\u01b0"+
		"\u0005C\u0000\u0000\u01b0\u01b6\u0006\u0016\uffff\uffff\u0000\u01b1\u01b2"+
		"\u0004\u0016\u0006\u0001\u01b2\u01b3\u0003*\u0015\u0000\u01b3\u01b4\u0006"+
		"\u0016\uffff\uffff\u0000\u01b4\u01b6\u0001\u0000\u0000\u0000\u01b5\u01a5"+
		"\u0001\u0000\u0000\u0000\u01b5\u01a9\u0001\u0000\u0000\u0000\u01b5\u01ad"+
		"\u0001\u0000\u0000\u0000\u01b5\u01ae\u0001\u0000\u0000\u0000\u01b5\u01b1"+
		"\u0001\u0000\u0000\u0000\u01b6\u01b9\u0001\u0000\u0000\u0000\u01b7\u01b5"+
		"\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000\u01b8\u01bf"+
		"\u0001\u0000\u0000\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000\u01ba\u01bb"+
		"\u00056\u0000\u0000\u01bb\u01bc\u0005E\u0000\u0000\u01bc\u01bd\u0003\""+
		"\u0011\u0000\u01bd\u01be\u0005F\u0000\u0000\u01be\u01c0\u0001\u0000\u0000"+
		"\u0000\u01bf\u01ba\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000"+
		"\u0000\u01c0\u01c3\u0001\u0000\u0000\u0000\u01c1\u01c4\u0005L\u0000\u0000"+
		"\u01c2\u01c4\u0003j5\u0000\u01c3\u01c1\u0001\u0000\u0000\u0000\u01c3\u01c2"+
		"\u0001\u0000\u0000\u0000\u01c4-\u0001\u0000\u0000\u0000\u01c5\u01c6\u0005"+
		",\u0000\u0000\u01c6\u01cc\u0003\\.\u0000\u01c7\u01c9\u0005E\u0000\u0000"+
		"\u01c8\u01ca\u0003\"\u0011\u0000\u01c9\u01c8\u0001\u0000\u0000\u0000\u01c9"+
		"\u01ca\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb"+
		"\u01cd\u0005F\u0000\u0000\u01cc\u01c7\u0001\u0000\u0000\u0000\u01cc\u01cd"+
		"\u0001\u0000\u0000\u0000\u01cd\u01d7\u0001\u0000\u0000\u0000\u01ce\u01cf"+
		"\u0004\u0017\u0007\u0001\u01cf\u01d0\u0005C\u0000\u0000\u01d0\u01d6\u0006"+
		"\u0017\uffff\uffff\u0000\u01d1\u01d2\u0004\u0017\b\u0001\u01d2\u01d3\u0003"+
		"*\u0015\u0000\u01d3\u01d4\u0006\u0017\uffff\uffff\u0000\u01d4\u01d6\u0001"+
		"\u0000\u0000\u0000\u01d5\u01ce\u0001\u0000\u0000\u0000\u01d5\u01d1\u0001"+
		"\u0000\u0000\u0000\u01d6\u01d9\u0001\u0000\u0000\u0000\u01d7\u01d5\u0001"+
		"\u0000\u0000\u0000\u01d7\u01d8\u0001\u0000\u0000\u0000\u01d8\u01dc\u0001"+
		"\u0000\u0000\u0000\u01d9\u01d7\u0001\u0000\u0000\u0000\u01da\u01dd\u0005"+
		"L\u0000\u0000\u01db\u01dd\u0003j5\u0000\u01dc\u01da\u0001\u0000\u0000"+
		"\u0000\u01dc\u01db\u0001\u0000\u0000\u0000\u01dd/\u0001\u0000\u0000\u0000"+
		"\u01de\u01df\u0005\u001a\u0000\u0000\u01df\u01e3\u0005E\u0000\u0000\u01e0"+
		"\u01e1\u0003\"\u0011\u0000\u01e1\u01e2\u0006\u0018\uffff\uffff\u0000\u01e2"+
		"\u01e4\u0001\u0000\u0000\u0000\u01e3\u01e0\u0001\u0000\u0000\u0000\u01e3"+
		"\u01e4\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5"+
		"\u01f7\u0005F\u0000\u0000\u01e6\u01e7\u0004\u0018\t\u0001\u01e7\u01e8"+
		"\u0005\u0019\u0000\u0000\u01e8\u01f6\u0006\u0018\uffff\uffff\u0000\u01e9"+
		"\u01ea\u0004\u0018\n\u0001\u01ea\u01eb\u0003(\u0014\u0000\u01eb\u01ec"+
		"\u0006\u0018\uffff\uffff\u0000\u01ec\u01f6\u0001\u0000\u0000\u0000\u01ed"+
		"\u01f6\u0003\u001e\u000f\u0000\u01ee\u01ef\u0004\u0018\u000b\u0001\u01ef"+
		"\u01f0\u0005C\u0000\u0000\u01f0\u01f6\u0006\u0018\uffff\uffff\u0000\u01f1"+
		"\u01f2\u0004\u0018\f\u0001\u01f2\u01f3\u0003*\u0015\u0000\u01f3\u01f4"+
		"\u0006\u0018\uffff\uffff\u0000\u01f4\u01f6\u0001\u0000\u0000\u0000\u01f5"+
		"\u01e6\u0001\u0000\u0000\u0000\u01f5\u01e9\u0001\u0000\u0000\u0000\u01f5"+
		"\u01ed\u0001\u0000\u0000\u0000\u01f5\u01ee\u0001\u0000\u0000\u0000\u01f5"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f6\u01f9\u0001\u0000\u0000\u0000\u01f7"+
		"\u01f5\u0001\u0000\u0000\u0000\u01f7\u01f8\u0001\u0000\u0000\u0000\u01f8"+
		"\u0201\u0001\u0000\u0000\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01fa"+
		"\u01fb\u0004\u0018\r\u0001\u01fb\u01fc\u00056\u0000\u0000\u01fc\u01fd"+
		"\u0005E\u0000\u0000\u01fd\u01fe\u0003\"\u0011\u0000\u01fe\u01ff\u0005"+
		"F\u0000\u0000\u01ff\u0202\u0001\u0000\u0000\u0000\u0200\u0202\u0004\u0018"+
		"\u000e\u0001\u0201\u01fa\u0001\u0000\u0000\u0000\u0201\u0200\u0001\u0000"+
		"\u0000\u0000\u0202\u0205\u0001\u0000\u0000\u0000\u0203\u0206\u0005L\u0000"+
		"\u0000\u0204\u0206\u0003j5\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0205"+
		"\u0204\u0001\u0000\u0000\u0000\u02061\u0001\u0000\u0000\u0000\u0207\u0208"+
		"\u00054\u0000\u0000\u0208\u0209\u0005E\u0000\u0000\u0209\u021a\u0005F"+
		"\u0000\u0000\u020a\u020b\u0004\u0019\u000f\u0001\u020b\u020c\u0005\u0019"+
		"\u0000\u0000\u020c\u0219\u0006\u0019\uffff\uffff\u0000\u020d\u020e\u0004"+
		"\u0019\u0010\u0001\u020e\u020f\u00050\u0000\u0000\u020f\u0219\u0006\u0019"+
		"\uffff\uffff\u0000\u0210\u0219\u0003\u001e\u000f\u0000\u0211\u0212\u0004"+
		"\u0019\u0011\u0001\u0212\u0213\u0005C\u0000\u0000\u0213\u0219\u0006\u0019"+
		"\uffff\uffff\u0000\u0214\u0215\u0004\u0019\u0012\u0001\u0215\u0216\u0003"+
		"*\u0015\u0000\u0216\u0217\u0006\u0019\uffff\uffff\u0000\u0217\u0219\u0001"+
		"\u0000\u0000\u0000\u0218\u020a\u0001\u0000\u0000\u0000\u0218\u020d\u0001"+
		"\u0000\u0000\u0000\u0218\u0210\u0001\u0000\u0000\u0000\u0218\u0211\u0001"+
		"\u0000\u0000\u0000\u0218\u0214\u0001\u0000\u0000\u0000\u0219\u021c\u0001"+
		"\u0000\u0000\u0000\u021a\u0218\u0001\u0000\u0000\u0000\u021a\u021b\u0001"+
		"\u0000\u0000\u0000\u021b\u021f\u0001\u0000\u0000\u0000\u021c\u021a\u0001"+
		"\u0000\u0000\u0000\u021d\u0220\u0005L\u0000\u0000\u021e\u0220\u0003j5"+
		"\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u021f\u021e\u0001\u0000\u0000"+
		"\u0000\u02203\u0001\u0000\u0000\u0000\u0221\u0222\u0005:\u0000\u0000\u0222"+
		"\u0223\u0003\\.\u0000\u0223\u0225\u0005I\u0000\u0000\u0224\u0226\u0003"+
		"6\u001b\u0000\u0225\u0224\u0001\u0000\u0000\u0000\u0226\u0227\u0001\u0000"+
		"\u0000\u0000\u0227\u0225\u0001\u0000\u0000\u0000\u0227\u0228\u0001\u0000"+
		"\u0000\u0000\u0228\u0229\u0001\u0000\u0000\u0000\u0229\u022a\u0005J\u0000"+
		"\u0000\u022a5\u0001\u0000\u0000\u0000\u022b\u022c\u0003J%\u0000\u022c"+
		"\u022d\u0003\\.\u0000\u022d\u022e\u0005L\u0000\u0000\u022e7\u0001\u0000"+
		"\u0000\u0000\u022f\u0230\u0005\u0015\u0000\u0000\u0230\u0231\u0003\\."+
		"\u0000\u0231\u0232\u0005I\u0000\u0000\u0232\u0237\u0003\\.\u0000\u0233"+
		"\u0234\u0005]\u0000\u0000\u0234\u0236\u0003\\.\u0000\u0235\u0233\u0001"+
		"\u0000\u0000\u0000\u0236\u0239\u0001\u0000\u0000\u0000\u0237\u0235\u0001"+
		"\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238\u023a\u0001"+
		"\u0000\u0000\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u023a\u023b\u0005"+
		"J\u0000\u0000\u023b9\u0001\u0000\u0000\u0000\u023c\u023d\u0005=\u0000"+
		"\u0000\u023d\u023e\u0003\\.\u0000\u023e\u023f\u0005(\u0000\u0000\u023f"+
		"\u0240\u0003L&\u0000\u0240\u0241\u0005L\u0000\u0000\u0241;\u0001\u0000"+
		"\u0000\u0000\u0242\u0258\u0003J%\u0000\u0243\u0244\u0004\u001e\u0013\u0001"+
		"\u0244\u0245\u00052\u0000\u0000\u0245\u0257\u0006\u001e\uffff\uffff\u0000"+
		"\u0246\u0247\u0004\u001e\u0014\u0001\u0247\u0248\u00051\u0000\u0000\u0248"+
		"\u0257\u0006\u001e\uffff\uffff\u0000\u0249\u024a\u0004\u001e\u0015\u0001"+
		"\u024a\u024b\u0005\'\u0000\u0000\u024b\u0257\u0006\u001e\uffff\uffff\u0000"+
		"\u024c\u024d\u0004\u001e\u0016\u0001\u024d\u024e\u0005\r\u0000\u0000\u024e"+
		"\u0257\u0006\u001e\uffff\uffff\u0000\u024f\u0250\u0004\u001e\u0017\u0001"+
		"\u0250\u0251\u0003*\u0015\u0000\u0251\u0252\u0006\u001e\uffff\uffff\u0000"+
		"\u0252\u0257\u0001\u0000\u0000\u0000\u0253\u0254\u0004\u001e\u0018\u0001"+
		"\u0254\u0255\u0005#\u0000\u0000\u0255\u0257\u0006\u001e\uffff\uffff\u0000"+
		"\u0256\u0243\u0001\u0000\u0000\u0000\u0256\u0246\u0001\u0000\u0000\u0000"+
		"\u0256\u0249\u0001\u0000\u0000\u0000\u0256\u024c\u0001\u0000\u0000\u0000"+
		"\u0256\u024f\u0001\u0000\u0000\u0000\u0256\u0253\u0001\u0000\u0000\u0000"+
		"\u0257\u025a\u0001\u0000\u0000\u0000\u0258\u0256\u0001\u0000\u0000\u0000"+
		"\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u025b\u0001\u0000\u0000\u0000"+
		"\u025a\u0258\u0001\u0000\u0000\u0000\u025b\u025e\u0003\\.\u0000\u025c"+
		"\u025d\u0005Q\u0000\u0000\u025d\u025f\u0003T*\u0000\u025e\u025c\u0001"+
		"\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000\u0000\u025f\u0260\u0001"+
		"\u0000\u0000\u0000\u0260\u0261\u0005L\u0000\u0000\u0261=\u0001\u0000\u0000"+
		"\u0000\u0262\u0263\u0003J%\u0000\u0263\u0264\u0005\r\u0000\u0000\u0264"+
		"\u0265\u0003\\.\u0000\u0265\u0266\u0005Q\u0000\u0000\u0266\u0267\u0003"+
		"T*\u0000\u0267\u0268\u0005L\u0000\u0000\u0268?\u0001\u0000\u0000\u0000"+
		"\u0269\u026b\u0003J%\u0000\u026a\u026c\u0005%\u0000\u0000\u026b\u026a"+
		"\u0001\u0000\u0000\u0000\u026b\u026c\u0001\u0000\u0000\u0000\u026c\u026e"+
		"\u0001\u0000\u0000\u0000\u026d\u026f\u0003\\.\u0000\u026e\u026d\u0001"+
		"\u0000\u0000\u0000\u026e\u026f\u0001\u0000\u0000\u0000\u026fA\u0001\u0000"+
		"\u0000\u0000\u0270\u0271\u0005\u0018\u0000\u0000\u0271\u0272\u0003\\."+
		"\u0000\u0272\u027b\u0005E\u0000\u0000\u0273\u0278\u0003@ \u0000\u0274"+
		"\u0275\u0005]\u0000\u0000\u0275\u0277\u0003@ \u0000\u0276\u0274\u0001"+
		"\u0000\u0000\u0000\u0277\u027a\u0001\u0000\u0000\u0000\u0278\u0276\u0001"+
		"\u0000\u0000\u0000\u0278\u0279\u0001\u0000\u0000\u0000\u0279\u027c\u0001"+
		"\u0000\u0000\u0000\u027a\u0278\u0001\u0000\u0000\u0000\u027b\u0273\u0001"+
		"\u0000\u0000\u0000\u027b\u027c\u0001\u0000\u0000\u0000\u027c\u027d\u0001"+
		"\u0000\u0000\u0000\u027d\u027f\u0005F\u0000\u0000\u027e\u0280\u0005\u0004"+
		"\u0000\u0000\u027f\u027e\u0001\u0000\u0000\u0000\u027f\u0280\u0001\u0000"+
		"\u0000\u0000\u0280\u0281\u0001\u0000\u0000\u0000\u0281\u0282\u0005L\u0000"+
		"\u0000\u0282C\u0001\u0000\u0000\u0000\u0283\u0285\u0003J%\u0000\u0284"+
		"\u0286\u0003\\.\u0000\u0285\u0284\u0001\u0000\u0000\u0000\u0285\u0286"+
		"\u0001\u0000\u0000\u0000\u0286E\u0001\u0000\u0000\u0000\u0287\u0288\u0005"+
		"\u0016\u0000\u0000\u0288\u0289\u0003\\.\u0000\u0289\u0292\u0005E\u0000"+
		"\u0000\u028a\u028f\u0003D\"\u0000\u028b\u028c\u0005]\u0000\u0000\u028c"+
		"\u028e\u0003D\"\u0000\u028d\u028b\u0001\u0000\u0000\u0000\u028e\u0291"+
		"\u0001\u0000\u0000\u0000\u028f\u028d\u0001\u0000\u0000\u0000\u028f\u0290"+
		"\u0001\u0000\u0000\u0000\u0290\u0293\u0001\u0000\u0000\u0000\u0291\u028f"+
		"\u0001\u0000\u0000\u0000\u0292\u028a\u0001\u0000\u0000\u0000\u0292\u0293"+
		"\u0001\u0000\u0000\u0000\u0293\u0294\u0001\u0000\u0000\u0000\u0294\u0295"+
		"\u0005F\u0000\u0000\u0295\u0296\u0005L\u0000\u0000\u0296G\u0001\u0000"+
		"\u0000\u0000\u0297\u0298\u0005A\u0000\u0000\u0298\u0299\u0003\u001c\u000e"+
		"\u0000\u0299\u029c\u0005\u001f\u0000\u0000\u029a\u029d\u0005h\u0000\u0000"+
		"\u029b\u029d\u0003J%\u0000\u029c\u029a\u0001\u0000\u0000\u0000\u029c\u029b"+
		"\u0001\u0000\u0000\u0000\u029d\u029e\u0001\u0000\u0000\u0000\u029e\u029f"+
		"\u0005L\u0000\u0000\u029fI\u0001\u0000\u0000\u0000\u02a0\u02a1\u0006%"+
		"\uffff\uffff\u0000\u02a1\u02a6\u0003L&\u0000\u02a2\u02a6\u0003N\'\u0000"+
		"\u02a3\u02a6\u0003\u0092I\u0000\u02a4\u02a6\u0003\u001c\u000e\u0000\u02a5"+
		"\u02a0\u0001\u0000\u0000\u0000\u02a5\u02a2\u0001\u0000\u0000\u0000\u02a5"+
		"\u02a3\u0001\u0000\u0000\u0000\u02a5\u02a4\u0001\u0000\u0000\u0000\u02a6"+
		"\u02af\u0001\u0000\u0000\u0000\u02a7\u02a8\n\u0001\u0000\u0000\u02a8\u02aa"+
		"\u0005G\u0000\u0000\u02a9\u02ab\u0003T*\u0000\u02aa\u02a9\u0001\u0000"+
		"\u0000\u0000\u02aa\u02ab\u0001\u0000\u0000\u0000\u02ab\u02ac\u0001\u0000"+
		"\u0000\u0000\u02ac\u02ae\u0005H\u0000\u0000\u02ad\u02a7\u0001\u0000\u0000"+
		"\u0000\u02ae\u02b1\u0001\u0000\u0000\u0000\u02af\u02ad\u0001\u0000\u0000"+
		"\u0000\u02af\u02b0\u0001\u0000\u0000\u0000\u02b0K\u0001\u0000\u0000\u0000"+
		"\u02b1\u02af\u0001\u0000\u0000\u0000\u02b2\u02bf\u0005\u0005\u0000\u0000"+
		"\u02b3\u02b4\u0004&\u001a\u0001\u02b4\u02b5\u0005\u0005\u0000\u0000\u02b5"+
		"\u02bf\u00050\u0000\u0000\u02b6\u02bf\u0005\b\u0000\u0000\u02b7\u02bf"+
		"\u00059\u0000\u0000\u02b8\u02bf\u0005\n\u0000\u0000\u02b9\u02bf\u0005"+
		"7\u0000\u0000\u02ba\u02bf\u0005@\u0000\u0000\u02bb\u02bf\u0005\u001e\u0000"+
		"\u0000\u02bc\u02bf\u0005\u001c\u0000\u0000\u02bd\u02bf\u0005>\u0000\u0000"+
		"\u02be\u02b2\u0001\u0000\u0000\u0000\u02be\u02b3\u0001\u0000\u0000\u0000"+
		"\u02be\u02b6\u0001\u0000\u0000\u0000\u02be\u02b7\u0001\u0000\u0000\u0000"+
		"\u02be\u02b8\u0001\u0000\u0000\u0000\u02be\u02b9\u0001\u0000\u0000\u0000"+
		"\u02be\u02ba\u0001\u0000\u0000\u0000\u02be\u02bb\u0001\u0000\u0000\u0000"+
		"\u02be\u02bc\u0001\u0000\u0000\u0000\u02be\u02bd\u0001\u0000\u0000\u0000"+
		"\u02bfM\u0001\u0000\u0000\u0000\u02c0\u02c1\u0005 \u0000\u0000\u02c1\u02c3"+
		"\u0005E\u0000\u0000\u02c2\u02c4\u0003\"\u0011\u0000\u02c3\u02c2\u0001"+
		"\u0000\u0000\u0000\u02c3\u02c4\u0001\u0000\u0000\u0000\u02c4\u02c5\u0001"+
		"\u0000\u0000\u0000\u02c5\u02d0\u0005F\u0000\u0000\u02c6\u02c7\u0004\'"+
		"\u001b\u0001\u02c7\u02c8\u0003 \u0010\u0000\u02c8\u02c9\u0006\'\uffff"+
		"\uffff\u0000\u02c9\u02cf\u0001\u0000\u0000\u0000\u02ca\u02cb\u0004\'\u001c"+
		"\u0001\u02cb\u02cc\u0003(\u0014\u0000\u02cc\u02cd\u0006\'\uffff\uffff"+
		"\u0000\u02cd\u02cf\u0001\u0000\u0000\u0000\u02ce\u02c6\u0001\u0000\u0000"+
		"\u0000\u02ce\u02ca\u0001\u0000\u0000\u0000\u02cf\u02d2\u0001\u0000\u0000"+
		"\u0000\u02d0\u02ce\u0001\u0000\u0000\u0000\u02d0\u02d1\u0001\u0000\u0000"+
		"\u0000\u02d1\u02d8\u0001\u0000\u0000\u0000\u02d2\u02d0\u0001\u0000\u0000"+
		"\u0000\u02d3\u02d4\u00056\u0000\u0000\u02d4\u02d5\u0005E\u0000\u0000\u02d5"+
		"\u02d6\u0003\"\u0011\u0000\u02d6\u02d7\u0005F\u0000\u0000\u02d7\u02d9"+
		"\u0001\u0000\u0000\u0000\u02d8\u02d3\u0001\u0000\u0000\u0000\u02d8\u02d9"+
		"\u0001\u0000\u0000\u0000\u02d9O\u0001\u0000\u0000\u0000\u02da\u02dc\u0003"+
		"J%\u0000\u02db\u02dd\u0003R)\u0000\u02dc\u02db\u0001\u0000\u0000\u0000"+
		"\u02dc\u02dd\u0001\u0000\u0000\u0000\u02dd\u02de\u0001\u0000\u0000\u0000"+
		"\u02de\u02df\u0003\\.\u0000\u02dfQ\u0001\u0000\u0000\u0000\u02e0\u02e1"+
		"\u0007\u0002\u0000\u0000\u02e1S\u0001\u0000\u0000\u0000\u02e2\u02e3\u0006"+
		"*\uffff\uffff\u0000\u02e3\u02e4\u00050\u0000\u0000\u02e4\u02f6\u0003\u001a"+
		"\r\u0000\u02e5\u02e6\u0005=\u0000\u0000\u02e6\u02e7\u0005E\u0000\u0000"+
		"\u02e7\u02e8\u0003J%\u0000\u02e8\u02e9\u0005F\u0000\u0000\u02e9\u02f6"+
		"\u0001\u0000\u0000\u0000\u02ea\u02eb\u0007\u0003\u0000\u0000\u02eb\u02f6"+
		"\u0003T*\u0013\u02ec\u02ed\u0005-\u0000\u0000\u02ed\u02f6\u0003J%\u0000"+
		"\u02ee\u02f6\u0003X,\u0000\u02ef\u02f6\u0003Z-\u0000\u02f0\u02f4\u0003"+
		"\\.\u0000\u02f1\u02f4\u0003^/\u0000\u02f2\u02f4\u0003L&\u0000\u02f3\u02f0"+
		"\u0001\u0000\u0000\u0000\u02f3\u02f1\u0001\u0000\u0000\u0000\u02f3\u02f2"+
		"\u0001\u0000\u0000\u0000\u02f4\u02f6\u0001\u0000\u0000\u0000\u02f5\u02e2"+
		"\u0001\u0000\u0000\u0000\u02f5\u02e5\u0001\u0000\u0000\u0000\u02f5\u02ea"+
		"\u0001\u0000\u0000\u0000\u02f5\u02ec\u0001\u0000\u0000\u0000\u02f5\u02ee"+
		"\u0001\u0000\u0000\u0000\u02f5\u02ef\u0001\u0000\u0000\u0000\u02f5\u02f3"+
		"\u0001\u0000\u0000\u0000\u02f6\u034c\u0001\u0000\u0000\u0000\u02f7\u02f8"+
		"\n\u0011\u0000\u0000\u02f8\u02f9\u0005k\u0000\u0000\u02f9\u034b\u0003"+
		"T*\u0011\u02fa\u02fb\n\u0010\u0000\u0000\u02fb\u02fc\u0007\u0004\u0000"+
		"\u0000\u02fc\u034b\u0003T*\u0011\u02fd\u02fe\n\u000f\u0000\u0000\u02fe"+
		"\u02ff\u0007\u0005\u0000\u0000\u02ff\u034b\u0003T*\u0010\u0300\u0301\n"+
		"\u000e\u0000\u0000\u0301\u0302\u0007\u0006\u0000\u0000\u0302\u034b\u0003"+
		"T*\u000f\u0303\u0304\n\r\u0000\u0000\u0304\u0305\u0005b\u0000\u0000\u0305"+
		"\u034b\u0003T*\u000e\u0306\u0307\n\f\u0000\u0000\u0307\u0308\u0005a\u0000"+
		"\u0000\u0308\u034b\u0003T*\r\u0309\u030a\n\u000b\u0000\u0000\u030a\u030b"+
		"\u0005`\u0000\u0000\u030b\u034b\u0003T*\f\u030c\u030d\n\n\u0000\u0000"+
		"\u030d\u030e\u0007\u0007\u0000\u0000\u030e\u034b\u0003T*\u000b\u030f\u0310"+
		"\n\t\u0000\u0000\u0310\u0311\u0007\b\u0000\u0000\u0311\u034b\u0003T*\n"+
		"\u0312\u0313\n\b\u0000\u0000\u0313\u0314\u0005_\u0000\u0000\u0314\u034b"+
		"\u0003T*\t\u0315\u0316\n\u0007\u0000\u0000\u0316\u0317\u0005^\u0000\u0000"+
		"\u0317\u034b\u0003T*\b\u0318\u0319\n\u0005\u0000\u0000\u0319\u031a\u0003"+
		"V+\u0000\u031a\u031b\u0003T*\u0005\u031b\u034b\u0001\u0000\u0000\u0000"+
		"\u031c\u031d\n\u0019\u0000\u0000\u031d\u031f\u0005G\u0000\u0000\u031e"+
		"\u0320\u0003T*\u0000\u031f\u031e\u0001\u0000\u0000\u0000\u031f\u0320\u0001"+
		"\u0000\u0000\u0000\u0320\u0321\u0001\u0000\u0000\u0000\u0321\u034b\u0005"+
		"H\u0000\u0000\u0322\u0323\n\u0018\u0000\u0000\u0323\u0325\u0005G\u0000"+
		"\u0000\u0324\u0326\u0003T*\u0000\u0325\u0324\u0001\u0000\u0000\u0000\u0325"+
		"\u0326\u0001\u0000\u0000\u0000\u0326\u0327\u0001\u0000\u0000\u0000\u0327"+
		"\u0329\u0005K\u0000\u0000\u0328\u032a\u0003T*\u0000\u0329\u0328\u0001"+
		"\u0000\u0000\u0000\u0329\u032a\u0001\u0000\u0000\u0000\u032a\u032b\u0001"+
		"\u0000\u0000\u0000\u032b\u034b\u0005H\u0000\u0000\u032c\u032d\n\u0017"+
		"\u0000\u0000\u032d\u0330\u0005M\u0000\u0000\u032e\u0331\u0003\\.\u0000"+
		"\u032f\u0331\u0005\u0005\u0000\u0000\u0330\u032e\u0001\u0000\u0000\u0000"+
		"\u0330\u032f\u0001\u0000\u0000\u0000\u0331\u034b\u0001\u0000\u0000\u0000"+
		"\u0332\u033f\n\u0016\u0000\u0000\u0333\u033c\u0005I\u0000\u0000\u0334"+
		"\u0339\u0003\u0018\f\u0000\u0335\u0336\u0005]\u0000\u0000\u0336\u0338"+
		"\u0003\u0018\f\u0000\u0337\u0335\u0001\u0000\u0000\u0000\u0338\u033b\u0001"+
		"\u0000\u0000\u0000\u0339\u0337\u0001\u0000\u0000\u0000\u0339\u033a\u0001"+
		"\u0000\u0000\u0000\u033a\u033d\u0001\u0000\u0000\u0000\u033b\u0339\u0001"+
		"\u0000\u0000\u0000\u033c\u0334\u0001\u0000\u0000\u0000\u033c\u033d\u0001"+
		"\u0000\u0000\u0000\u033d\u033e\u0001\u0000\u0000\u0000\u033e\u0340\u0005"+
		"J\u0000\u0000\u033f\u0333\u0001\u0000\u0000\u0000\u033f\u0340\u0001\u0000"+
		"\u0000\u0000\u0340\u0341\u0001\u0000\u0000\u0000\u0341\u034b\u0003\u001a"+
		"\r\u0000\u0342\u0343\n\u0012\u0000\u0000\u0343\u034b\u0007\t\u0000\u0000"+
		"\u0344\u0345\n\u0006\u0000\u0000\u0345\u0346\u0005N\u0000\u0000\u0346"+
		"\u0347\u0003T*\u0000\u0347\u0348\u0005K\u0000\u0000\u0348\u0349\u0003"+
		"T*\u0000\u0349\u034b\u0001\u0000\u0000\u0000\u034a\u02f7\u0001\u0000\u0000"+
		"\u0000\u034a\u02fa\u0001\u0000\u0000\u0000\u034a\u02fd\u0001\u0000\u0000"+
		"\u0000\u034a\u0300\u0001\u0000\u0000\u0000\u034a\u0303\u0001\u0000\u0000"+
		"\u0000\u034a\u0306\u0001\u0000\u0000\u0000\u034a\u0309\u0001\u0000\u0000"+
		"\u0000\u034a\u030c\u0001\u0000\u0000\u0000\u034a\u030f\u0001\u0000\u0000"+
		"\u0000\u034a\u0312\u0001\u0000\u0000\u0000\u034a\u0315\u0001\u0000\u0000"+
		"\u0000\u034a\u0318\u0001\u0000\u0000\u0000\u034a\u031c\u0001\u0000\u0000"+
		"\u0000\u034a\u0322\u0001\u0000\u0000\u0000\u034a\u032c\u0001\u0000\u0000"+
		"\u0000\u034a\u0332\u0001\u0000\u0000\u0000\u034a\u0342\u0001\u0000\u0000"+
		"\u0000\u034a\u0344\u0001\u0000\u0000\u0000\u034b\u034e\u0001\u0000\u0000"+
		"\u0000\u034c\u034a\u0001\u0000\u0000\u0000\u034c\u034d\u0001\u0000\u0000"+
		"\u0000\u034dU\u0001\u0000\u0000\u0000\u034e\u034c\u0001\u0000\u0000\u0000"+
		"\u034f\u0350\u0007\n\u0000\u0000\u0350W\u0001\u0000\u0000\u0000\u0351"+
		"\u0353\u0005E\u0000\u0000\u0352\u0354\u0003T*\u0000\u0353\u0352\u0001"+
		"\u0000\u0000\u0000\u0353\u0354\u0001\u0000\u0000\u0000\u0354\u035b\u0001"+
		"\u0000\u0000\u0000\u0355\u0357\u0005]\u0000\u0000\u0356\u0358\u0003T*"+
		"\u0000\u0357\u0356\u0001\u0000\u0000\u0000\u0357\u0358\u0001\u0000\u0000"+
		"\u0000\u0358\u035a\u0001\u0000\u0000\u0000\u0359\u0355\u0001\u0000\u0000"+
		"\u0000\u035a\u035d\u0001\u0000\u0000\u0000\u035b\u0359\u0001\u0000\u0000"+
		"\u0000\u035b\u035c\u0001\u0000\u0000\u0000\u035c\u035e\u0001\u0000\u0000"+
		"\u0000\u035d\u035b\u0001\u0000\u0000\u0000\u035e\u035f\u0005F\u0000\u0000"+
		"\u035fY\u0001\u0000\u0000\u0000\u0360\u0361\u0005G\u0000\u0000\u0361\u0366"+
		"\u0003T*\u0000\u0362\u0363\u0005]\u0000\u0000\u0363\u0365\u0003T*\u0000"+
		"\u0364\u0362\u0001\u0000\u0000\u0000\u0365\u0368\u0001\u0000\u0000\u0000"+
		"\u0366\u0364\u0001\u0000\u0000\u0000\u0366\u0367\u0001\u0000\u0000\u0000"+
		"\u0367\u0369\u0001\u0000\u0000\u0000\u0368\u0366\u0001\u0000\u0000\u0000"+
		"\u0369\u036a\u0005H\u0000\u0000\u036a[\u0001\u0000\u0000\u0000\u036b\u036c"+
		"\u0007\u000b\u0000\u0000\u036c]\u0001\u0000\u0000\u0000\u036d\u0373\u0003"+
		"b1\u0000\u036e\u0373\u0003h4\u0000\u036f\u0373\u0003`0\u0000\u0370\u0373"+
		"\u0003d2\u0000\u0371\u0373\u0003f3\u0000\u0372\u036d\u0001\u0000\u0000"+
		"\u0000\u0372\u036e\u0001\u0000\u0000\u0000\u0372\u036f\u0001\u0000\u0000"+
		"\u0000\u0372\u0370\u0001\u0000\u0000\u0000\u0372\u0371\u0001\u0000\u0000"+
		"\u0000\u0373_\u0001\u0000\u0000\u0000\u0374\u0375\u0007\f\u0000\u0000"+
		"\u0375a\u0001\u0000\u0000\u0000\u0376\u0378\u0007\r\u0000\u0000\u0377"+
		"\u0376\u0001\u0000\u0000\u0000\u0378\u0379\u0001\u0000\u0000\u0000\u0379"+
		"\u0377\u0001\u0000\u0000\u0000\u0379\u037a\u0001\u0000\u0000\u0000\u037a"+
		"c\u0001\u0000\u0000\u0000\u037b\u037d\u0005{\u0000\u0000\u037c\u037b\u0001"+
		"\u0000\u0000\u0000\u037d\u037e\u0001\u0000\u0000\u0000\u037e\u037c\u0001"+
		"\u0000\u0000\u0000\u037e\u037f\u0001\u0000\u0000\u0000\u037fe\u0001\u0000"+
		"\u0000\u0000\u0380\u0382\u0005z\u0000\u0000\u0381\u0380\u0001\u0000\u0000"+
		"\u0000\u0382\u0383\u0001\u0000\u0000\u0000\u0383\u0381\u0001\u0000\u0000"+
		"\u0000\u0383\u0384\u0001\u0000\u0000\u0000\u0384g\u0001\u0000\u0000\u0000"+
		"\u0385\u0387\u0007\u000e\u0000\u0000\u0386\u0388\u0005.\u0000\u0000\u0387"+
		"\u0386\u0001\u0000\u0000\u0000\u0387\u0388\u0001\u0000\u0000\u0000\u0388"+
		"i\u0001\u0000\u0000\u0000\u0389\u038e\u0005I\u0000\u0000\u038a\u038d\u0003"+
		"n7\u0000\u038b\u038d\u0003l6\u0000\u038c\u038a\u0001\u0000\u0000\u0000"+
		"\u038c\u038b\u0001\u0000\u0000\u0000\u038d\u0390\u0001\u0000\u0000\u0000"+
		"\u038e\u038c\u0001\u0000\u0000\u0000\u038e\u038f\u0001\u0000\u0000\u0000"+
		"\u038f\u0391\u0001\u0000\u0000\u0000\u0390\u038e\u0001\u0000\u0000\u0000"+
		"\u0391\u0392\u0005J\u0000\u0000\u0392k\u0001\u0000\u0000\u0000\u0393\u0394"+
		"\u0005?\u0000\u0000\u0394\u0395\u0003j5\u0000\u0395m\u0001\u0000\u0000"+
		"\u0000\u0396\u03a4\u0003j5\u0000\u0397\u03a4\u0003p8\u0000\u0398\u03a4"+
		"\u0003r9\u0000\u0399\u03a4\u0003t:\u0000\u039a\u03a4\u0003v;\u0000\u039b"+
		"\u03a4\u0003x<\u0000\u039c\u03a4\u0003z=\u0000\u039d\u03a4\u0003|>\u0000"+
		"\u039e\u03a4\u0003~?\u0000\u039f\u03a4\u0003\u0082A\u0000\u03a0\u03a4"+
		"\u0003\u0084B\u0000\u03a1\u03a4\u0003\u0086C\u0000\u03a2\u03a4\u0003\u0088"+
		"D\u0000\u03a3\u0396\u0001\u0000\u0000\u0000\u03a3\u0397\u0001\u0000\u0000"+
		"\u0000\u03a3\u0398\u0001\u0000\u0000\u0000\u03a3\u0399\u0001\u0000\u0000"+
		"\u0000\u03a3\u039a\u0001\u0000\u0000\u0000\u03a3\u039b\u0001\u0000\u0000"+
		"\u0000\u03a3\u039c\u0001\u0000\u0000\u0000\u03a3\u039d\u0001\u0000\u0000"+
		"\u0000\u03a3\u039e\u0001\u0000\u0000\u0000\u03a3\u039f\u0001\u0000\u0000"+
		"\u0000\u03a3\u03a0\u0001\u0000\u0000\u0000\u03a3\u03a1\u0001\u0000\u0000"+
		"\u0000\u03a3\u03a2\u0001\u0000\u0000\u0000\u03a4o\u0001\u0000\u0000\u0000"+
		"\u03a5\u03a8\u0003\u008eG\u0000\u03a6\u03a8\u0003\u0090H\u0000\u03a7\u03a5"+
		"\u0001\u0000\u0000\u0000\u03a7\u03a6\u0001\u0000\u0000\u0000\u03a8q\u0001"+
		"\u0000\u0000\u0000\u03a9\u03aa\u0005\"\u0000\u0000\u03aa\u03ab\u0005E"+
		"\u0000\u0000\u03ab\u03ac\u0003T*\u0000\u03ac\u03ad\u0005F\u0000\u0000"+
		"\u03ad\u03b0\u0003n7\u0000\u03ae\u03af\u0005\u0013\u0000\u0000\u03af\u03b1"+
		"\u0003n7\u0000\u03b0\u03ae\u0001\u0000\u0000\u0000\u03b0\u03b1\u0001\u0000"+
		"\u0000\u0000\u03b1s\u0001\u0000\u0000\u0000\u03b2\u03b3\u0005\u001f\u0000"+
		"\u0000\u03b3\u03b6\u0005E\u0000\u0000\u03b4\u03b7\u0003p8\u0000\u03b5"+
		"\u03b7\u0005L\u0000\u0000\u03b6\u03b4\u0001\u0000\u0000\u0000\u03b6\u03b5"+
		"\u0001\u0000\u0000\u0000\u03b7\u03ba\u0001\u0000\u0000\u0000\u03b8\u03bb"+
		"\u0003\u0090H\u0000\u03b9\u03bb\u0005L\u0000\u0000\u03ba\u03b8\u0001\u0000"+
		"\u0000\u0000\u03ba\u03b9\u0001\u0000\u0000\u0000\u03bb\u03bd\u0001\u0000"+
		"\u0000\u0000\u03bc\u03be\u0003T*\u0000\u03bd\u03bc\u0001\u0000\u0000\u0000"+
		"\u03bd\u03be\u0001\u0000\u0000\u0000\u03be\u03bf\u0001\u0000\u0000\u0000"+
		"\u03bf\u03c0\u0005F\u0000\u0000\u03c0\u03c1\u0003n7\u0000\u03c1u\u0001"+
		"\u0000\u0000\u0000\u03c2\u03c3\u0005D\u0000\u0000\u03c3\u03c4\u0005E\u0000"+
		"\u0000\u03c4\u03c5\u0003T*\u0000\u03c5\u03c6\u0005F\u0000\u0000\u03c6"+
		"\u03c7\u0003n7\u0000\u03c7w\u0001\u0000\u0000\u0000\u03c8\u03c9\u0005"+
		"\u0012\u0000\u0000\u03c9\u03ca\u0003n7\u0000\u03ca\u03cb\u0005D\u0000"+
		"\u0000\u03cb\u03cc\u0005E\u0000\u0000\u03cc\u03cd\u0003T*\u0000\u03cd"+
		"\u03ce\u0005F\u0000\u0000\u03ce\u03cf\u0005L\u0000\u0000\u03cfy\u0001"+
		"\u0000\u0000\u0000\u03d0\u03d1\u0005\u000f\u0000\u0000\u03d1\u03d2\u0005"+
		"L\u0000\u0000\u03d2{\u0001\u0000\u0000\u0000\u03d3\u03d4\u0005\t\u0000"+
		"\u0000\u03d4\u03d5\u0005L\u0000\u0000\u03d5}\u0001\u0000\u0000\u0000\u03d6"+
		"\u03d7\u0005<\u0000\u0000\u03d7\u03dd\u0003T*\u0000\u03d8\u03d9\u0005"+
		"6\u0000\u0000\u03d9\u03da\u0005E\u0000\u0000\u03da\u03db\u0003\"\u0011"+
		"\u0000\u03db\u03dc\u0005F\u0000\u0000\u03dc\u03de\u0001\u0000\u0000\u0000"+
		"\u03dd\u03d8\u0001\u0000\u0000\u0000\u03dd\u03de\u0001\u0000\u0000\u0000"+
		"\u03de\u03df\u0001\u0000\u0000\u0000\u03df\u03e1\u0003j5\u0000\u03e0\u03e2"+
		"\u0003\u0080@\u0000\u03e1\u03e0\u0001\u0000\u0000\u0000\u03e2\u03e3\u0001"+
		"\u0000\u0000\u0000\u03e3\u03e1\u0001\u0000\u0000\u0000\u03e3\u03e4\u0001"+
		"\u0000\u0000\u0000\u03e4\u007f\u0001\u0000\u0000\u0000\u03e5\u03ed\u0005"+
		"\f\u0000\u0000\u03e6\u03e8\u0003\\.\u0000\u03e7\u03e6\u0001\u0000\u0000"+
		"\u0000\u03e7\u03e8\u0001\u0000\u0000\u0000\u03e8\u03e9\u0001\u0000\u0000"+
		"\u0000\u03e9\u03ea\u0005E\u0000\u0000\u03ea\u03eb\u0003\"\u0011\u0000"+
		"\u03eb\u03ec\u0005F\u0000\u0000\u03ec\u03ee\u0001\u0000\u0000\u0000\u03ed"+
		"\u03e7\u0001\u0000\u0000\u0000\u03ed\u03ee\u0001\u0000\u0000\u0000\u03ee"+
		"\u03ef\u0001\u0000\u0000\u0000\u03ef\u03f0\u0003j5\u0000\u03f0\u0081\u0001"+
		"\u0000\u0000\u0000\u03f1\u03f3\u00055\u0000\u0000\u03f2\u03f4\u0003T*"+
		"\u0000\u03f3\u03f2\u0001\u0000\u0000\u0000\u03f3\u03f4\u0001\u0000\u0000"+
		"\u0000\u03f4\u03f5\u0001\u0000\u0000\u0000\u03f5\u03f6\u0005L\u0000\u0000"+
		"\u03f6\u0083\u0001\u0000\u0000\u0000\u03f7\u03f8\u0005\u0014\u0000\u0000"+
		"\u03f8\u03f9\u0003T*\u0000\u03f9\u03fa\u0003\u001a\r\u0000\u03fa\u03fb"+
		"\u0005L\u0000\u0000\u03fb\u0085\u0001\u0000\u0000\u0000\u03fc\u03fd\u0005"+
		"\u0017\u0000\u0000\u03fd\u03fe\u0003T*\u0000\u03fe\u03ff\u0003\u001a\r"+
		"\u0000\u03ff\u0400\u0005L\u0000\u0000\u0400\u0087\u0001\u0000\u0000\u0000"+
		"\u0401\u0403\u0005\u0007\u0000\u0000\u0402\u0404\u0005\u0082\u0000\u0000"+
		"\u0403\u0402\u0001\u0000\u0000\u0000\u0403\u0404\u0001\u0000\u0000\u0000"+
		"\u0404\u0405\u0001\u0000\u0000\u0000\u0405\u0409\u0005\u0083\u0000\u0000"+
		"\u0406\u0408\u0003\u0096K\u0000\u0407\u0406\u0001\u0000\u0000\u0000\u0408"+
		"\u040b\u0001\u0000\u0000\u0000\u0409\u0407\u0001\u0000\u0000\u0000\u0409"+
		"\u040a\u0001\u0000\u0000\u0000\u040a\u040c\u0001\u0000\u0000\u0000\u040b"+
		"\u0409\u0001\u0000\u0000\u0000\u040c\u040d\u0005\u0096\u0000\u0000\u040d"+
		"\u0089\u0001\u0000\u0000\u0000\u040e\u0413\u0003P(\u0000\u040f\u0410\u0005"+
		"]\u0000\u0000\u0410\u0412\u0003P(\u0000\u0411\u040f\u0001\u0000\u0000"+
		"\u0000\u0412\u0415\u0001\u0000\u0000\u0000\u0413\u0411\u0001\u0000\u0000"+
		"\u0000\u0413\u0414\u0001\u0000\u0000\u0000\u0414\u008b\u0001\u0000\u0000"+
		"\u0000\u0415\u0413\u0001\u0000\u0000\u0000\u0416\u041a\u0005E\u0000\u0000"+
		"\u0417\u0419\u0005]\u0000\u0000\u0418\u0417\u0001\u0000\u0000\u0000\u0419"+
		"\u041c\u0001\u0000\u0000\u0000\u041a\u0418\u0001\u0000\u0000\u0000\u041a"+
		"\u041b\u0001\u0000\u0000\u0000\u041b\u041d\u0001\u0000\u0000\u0000\u041c"+
		"\u041a\u0001\u0000\u0000\u0000\u041d\u041e\u0003P(\u0000\u041e\u0425\u0001"+
		"\u0000\u0000\u0000\u041f\u0421\u0005]\u0000\u0000\u0420\u0422\u0003P("+
		"\u0000\u0421\u0420\u0001\u0000\u0000\u0000\u0421\u0422\u0001\u0000\u0000"+
		"\u0000\u0422\u0424\u0001\u0000\u0000\u0000\u0423\u041f\u0001\u0000\u0000"+
		"\u0000\u0424\u0427\u0001\u0000\u0000\u0000\u0425\u0423\u0001\u0000\u0000"+
		"\u0000\u0425\u0426\u0001\u0000\u0000\u0000\u0426\u0428\u0001\u0000\u0000"+
		"\u0000\u0427\u0425\u0001\u0000\u0000\u0000\u0428\u0429\u0005F\u0000\u0000"+
		"\u0429\u008d\u0001\u0000\u0000\u0000\u042a\u042d\u0003P(\u0000\u042b\u042c"+
		"\u0005Q\u0000\u0000\u042c\u042e\u0003T*\u0000\u042d\u042b\u0001\u0000"+
		"\u0000\u0000\u042d\u042e\u0001\u0000\u0000\u0000\u042e\u0434\u0001\u0000"+
		"\u0000\u0000\u042f\u0430\u0003\u008cF\u0000\u0430\u0431\u0005Q\u0000\u0000"+
		"\u0431\u0432\u0003T*\u0000\u0432\u0434\u0001\u0000\u0000\u0000\u0433\u042a"+
		"\u0001\u0000\u0000\u0000\u0433\u042f\u0001\u0000\u0000\u0000\u0434\u0435"+
		"\u0001\u0000\u0000\u0000\u0435\u0436\u0005L\u0000\u0000\u0436\u008f\u0001"+
		"\u0000\u0000\u0000\u0437\u0438\u0003T*\u0000\u0438\u0439\u0005L\u0000"+
		"\u0000\u0439\u0091\u0001\u0000\u0000\u0000\u043a\u043b\u0005*\u0000\u0000"+
		"\u043b\u043c\u0005E\u0000\u0000\u043c\u043d\u0003\u0094J\u0000\u043d\u043e"+
		"\u0005O\u0000\u0000\u043e\u043f\u0003J%\u0000\u043f\u0440\u0005F\u0000"+
		"\u0000\u0440\u0093\u0001\u0000\u0000\u0000\u0441\u0444\u0003L&\u0000\u0442"+
		"\u0444\u0003\u001c\u000e\u0000\u0443\u0441\u0001\u0000\u0000\u0000\u0443"+
		"\u0442\u0001\u0000\u0000\u0000\u0444\u0095\u0001\u0000\u0000\u0000\u0445"+
		"\u0451\u0003\u0098L\u0000\u0446\u0451\u0003\u009aM\u0000\u0447\u0451\u0003"+
		"\u009cN\u0000\u0448\u0451\u0003\u00aaU\u0000\u0449\u0451\u0003\u009eO"+
		"\u0000\u044a\u0451\u0003\u00a0P\u0000\u044b\u0451\u0003\u00a4R\u0000\u044c"+
		"\u0451\u0005\u008f\u0000\u0000\u044d\u0451\u0005\u0087\u0000\u0000\u044e"+
		"\u0451\u0005\u0089\u0000\u0000\u044f\u0451\u0003\u00a6S\u0000\u0450\u0445"+
		"\u0001\u0000\u0000\u0000\u0450\u0446\u0001\u0000\u0000\u0000\u0450\u0447"+
		"\u0001\u0000\u0000\u0000\u0450\u0448\u0001\u0000\u0000\u0000\u0450\u0449"+
		"\u0001\u0000\u0000\u0000\u0450\u044a\u0001\u0000\u0000\u0000\u0450\u044b"+
		"\u0001\u0000\u0000\u0000\u0450\u044c\u0001\u0000\u0000\u0000\u0450\u044d"+
		"\u0001\u0000\u0000\u0000\u0450\u044e\u0001\u0000\u0000\u0000\u0450\u044f"+
		"\u0001\u0000\u0000\u0000\u0451\u0097\u0001\u0000\u0000\u0000\u0452\u0456"+
		"\u0005\u0095\u0000\u0000\u0453\u0455\u0003\u0096K\u0000\u0454\u0453\u0001"+
		"\u0000\u0000\u0000\u0455\u0458\u0001\u0000\u0000\u0000\u0456\u0454\u0001"+
		"\u0000\u0000\u0000\u0456\u0457\u0001\u0000\u0000\u0000\u0457\u0459\u0001"+
		"\u0000\u0000\u0000\u0458\u0456\u0001\u0000\u0000\u0000\u0459\u045a\u0005"+
		"\u0096\u0000\u0000\u045a\u0099\u0001\u0000\u0000\u0000\u045b\u045c\u0005"+
		"\u0090\u0000\u0000\u045c\u045f\u0005\u009d\u0000\u0000\u045d\u045e\u0005"+
		"\u0099\u0000\u0000\u045e\u0460\u0003\u00b0X\u0000\u045f\u045d\u0001\u0000"+
		"\u0000\u0000\u045f\u0460\u0001\u0000\u0000\u0000\u0460\u046f\u0001\u0000"+
		"\u0000\u0000\u0461\u0462\u0005\u0090\u0000\u0000\u0462\u0467\u0005\u009d"+
		"\u0000\u0000\u0463\u0464\u0005\u009b\u0000\u0000\u0464\u0466\u0005\u009d"+
		"\u0000\u0000\u0465\u0463\u0001\u0000\u0000\u0000\u0466\u0469\u0001\u0000"+
		"\u0000\u0000\u0467\u0465\u0001\u0000\u0000\u0000\u0467\u0468\u0001\u0000"+
		"\u0000\u0000\u0468\u046c\u0001\u0000\u0000\u0000\u0469\u0467\u0001\u0000"+
		"\u0000\u0000\u046a\u046b\u0005\u0099\u0000\u0000\u046b\u046d\u0003\u00aa"+
		"U\u0000\u046c\u046a\u0001\u0000\u0000\u0000\u046c\u046d\u0001\u0000\u0000"+
		"\u0000\u046d\u046f\u0001\u0000\u0000\u0000\u046e\u045b\u0001\u0000\u0000"+
		"\u0000\u046e\u0461\u0001\u0000\u0000\u0000\u046f\u009b\u0001\u0000\u0000"+
		"\u0000\u0470\u0471\u0003\u00a8T\u0000\u0471\u0472\u0005\u0099\u0000\u0000"+
		"\u0472\u0473\u0003\u00b0X\u0000\u0473\u047f\u0001\u0000\u0000\u0000\u0474"+
		"\u0477\u0003\u00a8T\u0000\u0475\u0476\u0005\u009b\u0000\u0000\u0476\u0478"+
		"\u0003\u00a8T\u0000\u0477\u0475\u0001\u0000\u0000\u0000\u0478\u0479\u0001"+
		"\u0000\u0000\u0000\u0479\u0477\u0001\u0000\u0000\u0000\u0479\u047a\u0001"+
		"\u0000\u0000\u0000\u047a\u047b\u0001\u0000\u0000\u0000\u047b\u047c\u0005"+
		"\u0099\u0000\u0000\u047c\u047d\u0003\u00aaU\u0000\u047d\u047f\u0001\u0000"+
		"\u0000\u0000\u047e\u0470\u0001\u0000\u0000\u0000\u047e\u0474\u0001\u0000"+
		"\u0000\u0000\u047f\u009d\u0001\u0000\u0000\u0000\u0480\u0481\u0005\u008e"+
		"\u0000\u0000\u0481\u0482\u0003\u00b0X\u0000\u0482\u0483\u0003\u0098L\u0000"+
		"\u0483\u009f\u0001\u0000\u0000\u0000\u0484\u0485\u0005\u008c\u0000\u0000"+
		"\u0485\u0486\u0003\u0098L\u0000\u0486\u0487\u0003\u00b0X\u0000\u0487\u0488"+
		"\u0003\u0098L\u0000\u0488\u0489\u0003\u0098L\u0000\u0489\u00a1\u0001\u0000"+
		"\u0000\u0000\u048a\u048b\u0005\u0088\u0000\u0000\u048b\u048c\u0003\u00ae"+
		"W\u0000\u048c\u048d\u0003\u0098L\u0000\u048d\u00a3\u0001\u0000\u0000\u0000"+
		"\u048e\u048f\u0005\u0091\u0000\u0000\u048f\u049b\u0003\u00b0X\u0000\u0490"+
		"\u0492\u0003\u00a2Q\u0000\u0491\u0490\u0001\u0000\u0000\u0000\u0492\u0493"+
		"\u0001\u0000\u0000\u0000\u0493\u0491\u0001\u0000\u0000\u0000\u0493\u0494"+
		"\u0001\u0000\u0000\u0000\u0494\u0497\u0001\u0000\u0000\u0000\u0495\u0496"+
		"\u0005\u008a\u0000\u0000\u0496\u0498\u0003\u0098L\u0000\u0497\u0495\u0001"+
		"\u0000\u0000\u0000\u0497\u0498\u0001\u0000\u0000\u0000\u0498\u049c\u0001"+
		"\u0000\u0000\u0000\u0499\u049a\u0005\u008a\u0000\u0000\u049a\u049c\u0003"+
		"\u0098L\u0000\u049b\u0491\u0001\u0000\u0000\u0000\u049b\u0499\u0001\u0000"+
		"\u0000\u0000\u049c\u00a5\u0001\u0000\u0000\u0000\u049d\u049e\u0005\u008d"+
		"\u0000\u0000\u049e\u049f\u0005\u009d\u0000\u0000\u049f\u04a8\u0005\u0097"+
		"\u0000\u0000\u04a0\u04a5\u0005\u009d\u0000\u0000\u04a1\u04a2\u0005\u009b"+
		"\u0000\u0000\u04a2\u04a4\u0005\u009d\u0000\u0000\u04a3\u04a1\u0001\u0000"+
		"\u0000\u0000\u04a4\u04a7\u0001\u0000\u0000\u0000\u04a5\u04a3\u0001\u0000"+
		"\u0000\u0000\u04a5\u04a6\u0001\u0000\u0000\u0000\u04a6\u04a9\u0001\u0000"+
		"\u0000\u0000\u04a7\u04a5\u0001\u0000\u0000\u0000\u04a8\u04a0\u0001\u0000"+
		"\u0000\u0000\u04a8\u04a9\u0001\u0000\u0000\u0000\u04a9\u04aa\u0001\u0000"+
		"\u0000\u0000\u04aa\u04b4\u0005\u0098\u0000\u0000\u04ab\u04ac\u0005\u009c"+
		"\u0000\u0000\u04ac\u04b1\u0005\u009d\u0000\u0000\u04ad\u04ae\u0005\u009b"+
		"\u0000\u0000\u04ae\u04b0\u0005\u009d\u0000\u0000\u04af\u04ad\u0001\u0000"+
		"\u0000\u0000\u04b0\u04b3\u0001\u0000\u0000\u0000\u04b1\u04af\u0001\u0000"+
		"\u0000\u0000\u04b1\u04b2\u0001\u0000\u0000\u0000\u04b2\u04b5\u0001\u0000"+
		"\u0000\u0000\u04b3\u04b1\u0001\u0000\u0000\u0000\u04b4\u04ab\u0001\u0000"+
		"\u0000\u0000\u04b4\u04b5\u0001\u0000\u0000\u0000\u04b5\u04b6\u0001\u0000"+
		"\u0000\u0000\u04b6\u04b7\u0003\u0098L\u0000\u04b7\u00a7\u0001\u0000\u0000"+
		"\u0000\u04b8\u04bd\u0005\u009d\u0000\u0000\u04b9\u04ba\u0005\u009a\u0000"+
		"\u0000\u04ba\u04bc\u0005\u009d\u0000\u0000\u04bb\u04b9\u0001\u0000\u0000"+
		"\u0000\u04bc\u04bf\u0001\u0000\u0000\u0000\u04bd\u04bb\u0001\u0000\u0000"+
		"\u0000\u04bd\u04be\u0001\u0000\u0000\u0000\u04be\u00a9\u0001\u0000\u0000"+
		"\u0000\u04bf\u04bd\u0001\u0000\u0000\u0000\u04c0\u04c1\u0007\u000f\u0000"+
		"\u0000\u04c1\u04ca\u0005\u0097\u0000\u0000\u04c2\u04c7\u0003\u00b0X\u0000"+
		"\u04c3\u04c4\u0005\u009b\u0000\u0000\u04c4\u04c6\u0003\u00b0X\u0000\u04c5"+
		"\u04c3\u0001\u0000\u0000\u0000\u04c6\u04c9\u0001\u0000\u0000\u0000\u04c7"+
		"\u04c5\u0001\u0000\u0000\u0000\u04c7\u04c8\u0001\u0000\u0000\u0000\u04c8"+
		"\u04cb\u0001\u0000\u0000\u0000\u04c9\u04c7\u0001\u0000\u0000\u0000\u04ca"+
		"\u04c2\u0001\u0000\u0000\u0000\u04ca\u04cb\u0001\u0000\u0000\u0000\u04cb"+
		"\u04cc\u0001\u0000\u0000\u0000\u04cc\u04cd\u0005\u0098\u0000\u0000\u04cd"+
		"\u00ab\u0001\u0000\u0000\u0000\u04ce\u04cf\u0007\u0010\u0000\u0000\u04cf"+
		"\u00ad\u0001\u0000\u0000\u0000\u04d0\u04d6\u0005\u009f\u0000\u0000\u04d1"+
		"\u04d6\u0005\u00a0\u0000\u0000\u04d2\u04d6\u0005\u009e\u0000\u0000\u04d3"+
		"\u04d6\u0003\u00acV\u0000\u04d4\u04d6\u0005\u00a1\u0000\u0000\u04d5\u04d0"+
		"\u0001\u0000\u0000\u0000\u04d5\u04d1\u0001\u0000\u0000\u0000\u04d5\u04d2"+
		"\u0001\u0000\u0000\u0000\u04d5\u04d3\u0001\u0000\u0000\u0000\u04d5\u04d4"+
		"\u0001\u0000\u0000\u0000\u04d6\u00af\u0001\u0000\u0000\u0000\u04d7\u04db"+
		"\u0003\u00a8T\u0000\u04d8\u04db\u0003\u00aaU\u0000\u04d9\u04db\u0003\u00ae"+
		"W\u0000\u04da\u04d7\u0001\u0000\u0000\u0000\u04da\u04d8\u0001\u0000\u0000"+
		"\u0000\u04da\u04d9\u0001\u0000\u0000\u0000\u04db\u00b1\u0001\u0000\u0000"+
		"\u0000\u0087\u00bd\u00bf\u00c8\u00d0\u00dc\u00e3\u00ed\u00f3\u00f8\u00fe"+
		"\u0106\u010c\u0117\u0122\u0127\u0135\u0141\u0144\u014c\u014f\u0152\u015b"+
		"\u0160\u0169\u016e\u0171\u0176\u0183\u0185\u0193\u0198\u019e\u01a2\u01b5"+
		"\u01b7\u01bf\u01c3\u01c9\u01cc\u01d5\u01d7\u01dc\u01e3\u01f5\u01f7\u0201"+
		"\u0205\u0218\u021a\u021f\u0227\u0237\u0256\u0258\u025e\u026b\u026e\u0278"+
		"\u027b\u027f\u0285\u028f\u0292\u029c\u02a5\u02aa\u02af\u02be\u02c3\u02ce"+
		"\u02d0\u02d8\u02dc\u02f3\u02f5\u031f\u0325\u0329\u0330\u0339\u033c\u033f"+
		"\u034a\u034c\u0353\u0357\u035b\u0366\u0372\u0379\u037e\u0383\u0387\u038c"+
		"\u038e\u03a3\u03a7\u03b0\u03b6\u03ba\u03bd\u03dd\u03e3\u03e7\u03ed\u03f3"+
		"\u0403\u0409\u0413\u041a\u0421\u0425\u042d\u0433\u0443\u0450\u0456\u045f"+
		"\u0467\u046c\u046e\u0479\u047e\u0493\u0497\u049b\u04a5\u04a8\u04b1\u04b4"+
		"\u04bd\u04c7\u04ca\u04d5\u04da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}