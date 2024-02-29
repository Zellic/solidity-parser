// Generated from java-escape by ANTLR 4.11.1
package solidity_parser.grammar.v080;
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
		RULE_enumDefinition = 28, RULE_stateVariableDeclaration = 29, RULE_constantVariableDeclaration = 30, 
		RULE_eventParameter = 31, RULE_eventDefinition = 32, RULE_errorParameter = 33, 
		RULE_errorDefinition = 34, RULE_usingDirective = 35, RULE_typeName = 36, 
		RULE_elementaryTypeName = 37, RULE_functionTypeName = 38, RULE_variableDeclaration = 39, 
		RULE_dataLocation = 40, RULE_expression = 41, RULE_assignOp = 42, RULE_tupleExpression = 43, 
		RULE_inlineArrayExpression = 44, RULE_identifier = 45, RULE_literal = 46, 
		RULE_booleanLiteral = 47, RULE_stringLiteral = 48, RULE_hexStringLiteral = 49, 
		RULE_unicodeStringLiteral = 50, RULE_numberLiteral = 51, RULE_block = 52, 
		RULE_uncheckedBlock = 53, RULE_statement = 54, RULE_simpleStatement = 55, 
		RULE_ifStatement = 56, RULE_forStatement = 57, RULE_whileStatement = 58, 
		RULE_doWhileStatement = 59, RULE_continueStatement = 60, RULE_breakStatement = 61, 
		RULE_tryStatement = 62, RULE_catchClause = 63, RULE_returnStatement = 64, 
		RULE_emitStatement = 65, RULE_revertStatement = 66, RULE_assemblyStatement = 67, 
		RULE_variableDeclarationList = 68, RULE_variableDeclarationTuple = 69, 
		RULE_variableDeclarationStatement = 70, RULE_expressionStatement = 71, 
		RULE_mappingType = 72, RULE_mappingKeyType = 73, RULE_yulStatement = 74, 
		RULE_yulBlock = 75, RULE_yulVariableDeclaration = 76, RULE_yulAssignment = 77, 
		RULE_yulIfStatement = 78, RULE_yulForStatement = 79, RULE_yulSwitchCase = 80, 
		RULE_yulSwitchStatement = 81, RULE_yulFunctionDefinition = 82, RULE_yulPath = 83, 
		RULE_yulFunctionCall = 84, RULE_yulBoolean = 85, RULE_yulLiteral = 86, 
		RULE_yulExpression = 87;
	private static String[] makeRuleNames() {
		return new String[] {
			"sourceUnit", "pragmaDirective", "importDirective", "importAliases", 
			"path", "symbolAliases", "contractDefinition", "interfaceDefinition", 
			"libraryDefinition", "inheritanceSpecifierList", "inheritanceSpecifier", 
			"contractBodyElement", "namedArgument", "callArgumentList", "identifierPath", 
			"modifierInvocation", "visibility", "parameterList", "parameterDeclaration", 
			"constructorDefinition", "stateMutability", "overrideSpecifier", "functionDefinition", 
			"modifierDefinition", "fallbackFunctionDefinition", "receiveFunctionDefinition", 
			"structDefinition", "structMember", "enumDefinition", "stateVariableDeclaration", 
			"constantVariableDeclaration", "eventParameter", "eventDefinition", "errorParameter", 
			"errorDefinition", "usingDirective", "typeName", "elementaryTypeName", 
			"functionTypeName", "variableDeclaration", "dataLocation", "expression", 
			"assignOp", "tupleExpression", "inlineArrayExpression", "identifier", 
			"literal", "booleanLiteral", "stringLiteral", "hexStringLiteral", "unicodeStringLiteral", 
			"numberLiteral", "block", "uncheckedBlock", "statement", "simpleStatement", 
			"ifStatement", "forStatement", "whileStatement", "doWhileStatement", 
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
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(186);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(176);
						pragmaDirective();
						}
						break;
					case 2:
						{
						setState(177);
						importDirective();
						}
						break;
					case 3:
						{
						setState(178);
						contractDefinition();
						}
						break;
					case 4:
						{
						setState(179);
						interfaceDefinition();
						}
						break;
					case 5:
						{
						setState(180);
						libraryDefinition();
						}
						break;
					case 6:
						{
						setState(181);
						functionDefinition();
						}
						break;
					case 7:
						{
						setState(182);
						constantVariableDeclaration();
						}
						break;
					case 8:
						{
						setState(183);
						structDefinition();
						}
						break;
					case 9:
						{
						setState(184);
						enumDefinition();
						}
						break;
					case 10:
						{
						setState(185);
						errorDefinition();
						}
						break;
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(191);
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
			setState(193);
			match(Pragma);
			setState(195); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				match(PragmaToken);
				}
				}
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PragmaToken );
			setState(199);
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
			setState(201);
			match(Import);
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NonEmptyStringLiteral:
				{
				{
				setState(202);
				path();
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==As) {
					{
					setState(203);
					match(As);
					setState(204);
					((ImportDirectiveContext)_localctx).unitAlias = identifier();
					}
				}

				}
				}
				break;
			case LBrace:
				{
				{
				setState(207);
				symbolAliases();
				setState(208);
				match(From);
				setState(209);
				path();
				}
				}
				break;
			case Mul:
				{
				{
				setState(211);
				match(Mul);
				setState(212);
				match(As);
				setState(213);
				((ImportDirectiveContext)_localctx).unitAlias = identifier();
				setState(214);
				match(From);
				setState(215);
				path();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(219);
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
			setState(221);
			((ImportAliasesContext)_localctx).symbol = identifier();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(222);
				match(As);
				setState(223);
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
			setState(226);
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
			setState(228);
			match(LBrace);
			setState(229);
			((SymbolAliasesContext)_localctx).importAliases = importAliases();
			((SymbolAliasesContext)_localctx).aliases.add(((SymbolAliasesContext)_localctx).importAliases);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(230);
				match(Comma);
				setState(231);
				((SymbolAliasesContext)_localctx).importAliases = importAliases();
				((SymbolAliasesContext)_localctx).aliases.add(((SymbolAliasesContext)_localctx).importAliases);
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(237);
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
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract) {
				{
				setState(239);
				match(Abstract);
				}
			}

			setState(242);
			match(Contract);
			setState(243);
			((ContractDefinitionContext)_localctx).name = identifier();
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Is) {
				{
				setState(244);
				inheritanceSpecifierList();
				}
			}

			setState(247);
			match(LBrace);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(248);
					contractBodyElement();
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(254);
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
			setState(256);
			match(Interface);
			setState(257);
			((InterfaceDefinitionContext)_localctx).name = identifier();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Is) {
				{
				setState(258);
				inheritanceSpecifierList();
				}
			}

			setState(261);
			match(LBrace);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(262);
					contractBodyElement();
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(268);
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
			setState(270);
			match(Library);
			setState(271);
			((LibraryDefinitionContext)_localctx).name = identifier();
			setState(272);
			match(LBrace);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(273);
					contractBodyElement();
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(279);
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
			setState(281);
			match(Is);
			setState(282);
			((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier = inheritanceSpecifier();
			((InheritanceSpecifierListContext)_localctx).inheritanceSpecifiers.add(((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier);
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(283);
					match(Comma);
					setState(284);
					((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier = inheritanceSpecifier();
					((InheritanceSpecifierListContext)_localctx).inheritanceSpecifiers.add(((InheritanceSpecifierListContext)_localctx).inheritanceSpecifier);
					}
					} 
				}
				setState(289);
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
			setState(290);
			((InheritanceSpecifierContext)_localctx).name = identifierPath();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(291);
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
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				constructorDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				modifierDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(297);
				fallbackFunctionDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(298);
				receiveFunctionDefinition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(299);
				structDefinition();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(300);
				enumDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(301);
				stateVariableDeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(302);
				eventDefinition();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(303);
				errorDefinition();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(304);
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
			setState(307);
			((NamedArgumentContext)_localctx).name = identifier();
			setState(308);
			match(Colon);
			setState(309);
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
			setState(311);
			match(LParen);
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(320);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(312);
					expression(0);
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(313);
						match(Comma);
						setState(314);
						expression(0);
						}
						}
						setState(319);
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
				setState(322);
				match(LBrace);
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
					{
					setState(323);
					namedArgument();
					setState(328);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(324);
						match(Comma);
						setState(325);
						namedArgument();
						}
						}
						setState(330);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(333);
				match(RBrace);
				}
				break;
			}
			setState(336);
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
			setState(338);
			identifier();
			setState(343);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(339);
					match(Period);
					setState(340);
					identifier();
					}
					} 
				}
				setState(345);
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
			setState(346);
			identifierPath();
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(347);
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
			setState(350);
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
			setState(352);
			((ParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
			((ParameterListContext)_localctx).parameters.add(((ParameterListContext)_localctx).parameterDeclaration);
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(353);
				match(Comma);
				setState(354);
				((ParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
				((ParameterListContext)_localctx).parameters.add(((ParameterListContext)_localctx).parameterDeclaration);
				}
				}
				setState(359);
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
			setState(360);
			((ParameterDeclarationContext)_localctx).type = typeName(0);
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 72066390130952192L) != 0) {
				{
				setState(361);
				((ParameterDeclarationContext)_localctx).location = dataLocation();
				}
			}

			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
				{
				setState(364);
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
			setState(367);
			match(Constructor);
			setState(368);
			match(LParen);
			setState(370);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(369);
				((ConstructorDefinitionContext)_localctx).arguments = parameterList();
				}
				break;
			}
			setState(372);
			match(RParen);
			setState(385);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(383);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						setState(373);
						modifierInvocation();
						}
						break;
					case 2:
						{
						setState(374);
						if (!(not _localctx.payableSet)) throw new FailedPredicateException(this, "not $payableSet");
						setState(375);
						match(Payable);
						((ConstructorDefinitionContext)_localctx).payableSet =  True;
						}
						break;
					case 3:
						{
						setState(377);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(378);
						match(Internal);
						((ConstructorDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					case 4:
						{
						setState(380);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(381);
						match(Public);
						((ConstructorDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					}
					} 
				}
				setState(387);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(388);
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
			setState(390);
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
			setState(392);
			match(Override);
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(393);
				match(LParen);
				setState(394);
				((OverrideSpecifierContext)_localctx).identifierPath = identifierPath();
				((OverrideSpecifierContext)_localctx).overrides.add(((OverrideSpecifierContext)_localctx).identifierPath);
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(395);
					match(Comma);
					setState(396);
					((OverrideSpecifierContext)_localctx).identifierPath = identifierPath();
					((OverrideSpecifierContext)_localctx).overrides.add(((OverrideSpecifierContext)_localctx).identifierPath);
					}
					}
					setState(401);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(402);
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
			setState(406);
			match(Function);
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Error:
			case Revert:
			case From:
			case Identifier:
				{
				setState(407);
				identifier();
				}
				break;
			case Fallback:
				{
				setState(408);
				match(Fallback);
				}
				break;
			case Receive:
				{
				setState(409);
				match(Receive);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(412);
			match(LParen);
			setState(414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(413);
				((FunctionDefinitionContext)_localctx).arguments = parameterList();
				}
				break;
			}
			setState(416);
			match(RParen);
			setState(435);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(433);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(417);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(418);
						visibility();
						((FunctionDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(421);
						if (!(not _localctx.mutabilitySet)) throw new FailedPredicateException(this, "not $mutabilitySet");
						setState(422);
						stateMutability();
						((FunctionDefinitionContext)_localctx).mutabilitySet =  True;
						}
						break;
					case 3:
						{
						setState(425);
						modifierInvocation();
						}
						break;
					case 4:
						{
						setState(426);
						if (!(not _localctx.virtualSet)) throw new FailedPredicateException(this, "not $virtualSet");
						setState(427);
						match(Virtual);
						((FunctionDefinitionContext)_localctx).virtualSet =  True;
						}
						break;
					case 5:
						{
						setState(429);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(430);
						overrideSpecifier();
						((FunctionDefinitionContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					}
					} 
				}
				setState(437);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(438);
				match(Returns);
				setState(439);
				match(LParen);
				setState(440);
				((FunctionDefinitionContext)_localctx).returnParameters = parameterList();
				setState(441);
				match(RParen);
				}
			}

			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(445);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(446);
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
			setState(449);
			match(Modifier);
			setState(450);
			((ModifierDefinitionContext)_localctx).name = identifier();
			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(451);
				match(LParen);
				setState(453);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(452);
					((ModifierDefinitionContext)_localctx).arguments = parameterList();
					}
					break;
				}
				setState(455);
				match(RParen);
				}
				break;
			}
			setState(467);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(465);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						setState(458);
						if (!(not _localctx.virtualSet)) throw new FailedPredicateException(this, "not $virtualSet");
						setState(459);
						match(Virtual);
						((ModifierDefinitionContext)_localctx).virtualSet =  True;
						}
						break;
					case 2:
						{
						setState(461);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(462);
						overrideSpecifier();
						((ModifierDefinitionContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					}
					} 
				}
				setState(469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(472);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(470);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(471);
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
			setState(474);
			((FallbackFunctionDefinitionContext)_localctx).kind = match(Fallback);
			setState(475);
			match(LParen);
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(476);
				parameterList();
				((FallbackFunctionDefinitionContext)_localctx).hasParameters =  True;
				}
				break;
			}
			setState(481);
			match(RParen);
			setState(499);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(497);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						setState(482);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(483);
						match(External);
						((FallbackFunctionDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(485);
						if (!(not _localctx.mutabilitySet)) throw new FailedPredicateException(this, "not $mutabilitySet");
						setState(486);
						stateMutability();
						((FallbackFunctionDefinitionContext)_localctx).mutabilitySet =  True;
						}
						break;
					case 3:
						{
						setState(489);
						modifierInvocation();
						}
						break;
					case 4:
						{
						setState(490);
						if (!(not _localctx.virtualSet)) throw new FailedPredicateException(this, "not $virtualSet");
						setState(491);
						match(Virtual);
						((FallbackFunctionDefinitionContext)_localctx).virtualSet =  True;
						}
						break;
					case 5:
						{
						setState(493);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(494);
						overrideSpecifier();
						((FallbackFunctionDefinitionContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					}
					} 
				}
				setState(501);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(509);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(502);
				if (!(_localctx.hasParameters)) throw new FailedPredicateException(this, "$hasParameters");
				setState(503);
				match(Returns);
				setState(504);
				match(LParen);
				setState(505);
				((FallbackFunctionDefinitionContext)_localctx).returnParameters = parameterList();
				setState(506);
				match(RParen);
				}
				break;
			case 2:
				{
				setState(508);
				if (!(not _localctx.hasParameters)) throw new FailedPredicateException(this, "not $hasParameters");
				}
				break;
			}
			setState(513);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(511);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(512);
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
			setState(515);
			((ReceiveFunctionDefinitionContext)_localctx).kind = match(Receive);
			setState(516);
			match(LParen);
			setState(517);
			match(RParen);
			setState(534);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(532);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						setState(518);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(519);
						match(External);
						((ReceiveFunctionDefinitionContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(521);
						if (!(not _localctx.mutabilitySet)) throw new FailedPredicateException(this, "not $mutabilitySet");
						setState(522);
						match(Payable);
						((ReceiveFunctionDefinitionContext)_localctx).mutabilitySet =  True;
						}
						break;
					case 3:
						{
						setState(524);
						modifierInvocation();
						}
						break;
					case 4:
						{
						setState(525);
						if (!(not _localctx.virtualSet)) throw new FailedPredicateException(this, "not $virtualSet");
						setState(526);
						match(Virtual);
						((ReceiveFunctionDefinitionContext)_localctx).virtualSet =  True;
						}
						break;
					case 5:
						{
						setState(528);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(529);
						overrideSpecifier();
						((ReceiveFunctionDefinitionContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					}
					} 
				}
				setState(536);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			setState(539);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Semicolon:
				{
				setState(537);
				match(Semicolon);
				}
				break;
			case LBrace:
				{
				setState(538);
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
			setState(541);
			match(Struct);
			setState(542);
			((StructDefinitionContext)_localctx).name = identifier();
			setState(543);
			match(LBrace);
			setState(545); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(544);
					((StructDefinitionContext)_localctx).members = structMember();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(547); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(549);
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
			setState(551);
			((StructMemberContext)_localctx).type = typeName(0);
			setState(552);
			((StructMemberContext)_localctx).name = identifier();
			setState(553);
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
			setState(555);
			match(Enum);
			setState(556);
			((EnumDefinitionContext)_localctx).name = identifier();
			setState(557);
			match(LBrace);
			setState(558);
			((EnumDefinitionContext)_localctx).identifier = identifier();
			((EnumDefinitionContext)_localctx).enumValues.add(((EnumDefinitionContext)_localctx).identifier);
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(559);
				match(Comma);
				setState(560);
				((EnumDefinitionContext)_localctx).identifier = identifier();
				((EnumDefinitionContext)_localctx).enumValues.add(((EnumDefinitionContext)_localctx).identifier);
				}
				}
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(566);
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
		enterRule(_localctx, 58, RULE_stateVariableDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			((StateVariableDeclarationContext)_localctx).type = typeName(0);
			setState(590);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(588);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
					case 1:
						{
						setState(569);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(570);
						match(Public);
						((StateVariableDeclarationContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(572);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(573);
						match(Private);
						((StateVariableDeclarationContext)_localctx).visibilitySet =  True;
						}
						break;
					case 3:
						{
						setState(575);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(576);
						match(Internal);
						((StateVariableDeclarationContext)_localctx).visibilitySet =  True;
						}
						break;
					case 4:
						{
						setState(578);
						if (!(not _localctx.constantnessSet)) throw new FailedPredicateException(this, "not $constantnessSet");
						setState(579);
						match(Constant);
						((StateVariableDeclarationContext)_localctx).constantnessSet =  True;
						}
						break;
					case 5:
						{
						setState(581);
						if (!(not _localctx.overrideSpecifierSet)) throw new FailedPredicateException(this, "not $overrideSpecifierSet");
						setState(582);
						overrideSpecifier();
						((StateVariableDeclarationContext)_localctx).overrideSpecifierSet =  True;
						}
						break;
					case 6:
						{
						setState(585);
						if (!(not _localctx.constantnessSet)) throw new FailedPredicateException(this, "not $constantnessSet");
						setState(586);
						match(Immutable);
						((StateVariableDeclarationContext)_localctx).constantnessSet =  True;
						}
						break;
					}
					} 
				}
				setState(592);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			setState(593);
			((StateVariableDeclarationContext)_localctx).name = identifier();
			setState(596);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(594);
				match(Assign);
				setState(595);
				((StateVariableDeclarationContext)_localctx).initialValue = expression(0);
				}
			}

			setState(598);
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
		enterRule(_localctx, 60, RULE_constantVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			((ConstantVariableDeclarationContext)_localctx).type = typeName(0);
			setState(601);
			match(Constant);
			setState(602);
			((ConstantVariableDeclarationContext)_localctx).name = identifier();
			setState(603);
			match(Assign);
			setState(604);
			((ConstantVariableDeclarationContext)_localctx).initialValue = expression(0);
			setState(605);
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
		enterRule(_localctx, 62, RULE_eventParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			((EventParameterContext)_localctx).type = typeName(0);
			setState(609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Indexed) {
				{
				setState(608);
				match(Indexed);
				}
			}

			setState(612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
				{
				setState(611);
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
		enterRule(_localctx, 64, RULE_eventDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			match(Event);
			setState(615);
			((EventDefinitionContext)_localctx).name = identifier();
			setState(616);
			match(LParen);
			setState(625);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(617);
				((EventDefinitionContext)_localctx).eventParameter = eventParameter();
				((EventDefinitionContext)_localctx).parameters.add(((EventDefinitionContext)_localctx).eventParameter);
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(618);
					match(Comma);
					setState(619);
					((EventDefinitionContext)_localctx).eventParameter = eventParameter();
					((EventDefinitionContext)_localctx).parameters.add(((EventDefinitionContext)_localctx).eventParameter);
					}
					}
					setState(624);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(627);
			match(RParen);
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Anonymous) {
				{
				setState(628);
				match(Anonymous);
				}
			}

			setState(631);
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
		enterRule(_localctx, 66, RULE_errorParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			((ErrorParameterContext)_localctx).type = typeName(0);
			setState(635);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
				{
				setState(634);
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
		enterRule(_localctx, 68, RULE_errorDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			match(Error);
			setState(638);
			((ErrorDefinitionContext)_localctx).name = identifier();
			setState(639);
			match(LParen);
			setState(648);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(640);
				((ErrorDefinitionContext)_localctx).errorParameter = errorParameter();
				((ErrorDefinitionContext)_localctx).parameters.add(((ErrorDefinitionContext)_localctx).errorParameter);
				setState(645);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(641);
					match(Comma);
					setState(642);
					((ErrorDefinitionContext)_localctx).errorParameter = errorParameter();
					((ErrorDefinitionContext)_localctx).parameters.add(((ErrorDefinitionContext)_localctx).errorParameter);
					}
					}
					setState(647);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(650);
			match(RParen);
			setState(651);
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
		enterRule(_localctx, 70, RULE_usingDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			match(Using);
			setState(654);
			identifierPath();
			setState(655);
			match(For);
			setState(658);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(656);
				match(Mul);
				}
				break;
			case 2:
				{
				setState(657);
				typeName(0);
				}
				break;
			}
			setState(660);
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
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_typeName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(667);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(663);
				elementaryTypeName(True);
				}
				break;
			case 2:
				{
				setState(664);
				functionTypeName();
				}
				break;
			case 3:
				{
				setState(665);
				mappingType();
				}
				break;
			case 4:
				{
				setState(666);
				identifierPath();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(677);
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
					setState(669);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(670);
					match(LBrack);
					setState(672);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
					case 1:
						{
						setState(671);
						expression(0);
						}
						break;
					}
					setState(674);
					match(RBrack);
					}
					} 
				}
				setState(679);
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
		enterRule(_localctx, 74, RULE_elementaryTypeName);
		try {
			setState(692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(680);
				match(Address);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(681);
				if (!(_localctx.allowAddressPayable)) throw new FailedPredicateException(this, "$allowAddressPayable");
				setState(682);
				match(Address);
				setState(683);
				match(Payable);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(684);
				match(Bool);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(685);
				match(String);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(686);
				match(Bytes);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(687);
				match(SignedIntegerType);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(688);
				match(UnsignedIntegerType);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(689);
				match(FixedBytes);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(690);
				match(Fixed);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(691);
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
		enterRule(_localctx, 76, RULE_functionTypeName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			match(Function);
			setState(695);
			match(LParen);
			setState(697);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(696);
				((FunctionTypeNameContext)_localctx).arguments = parameterList();
				}
				break;
			}
			setState(699);
			match(RParen);
			setState(710);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(708);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
					case 1:
						{
						setState(700);
						if (!(not _localctx.visibilitySet)) throw new FailedPredicateException(this, "not $visibilitySet");
						setState(701);
						visibility();
						((FunctionTypeNameContext)_localctx).visibilitySet =  True;
						}
						break;
					case 2:
						{
						setState(704);
						if (!(not _localctx.mutabilitySet)) throw new FailedPredicateException(this, "not $mutabilitySet");
						setState(705);
						stateMutability();
						((FunctionTypeNameContext)_localctx).mutabilitySet =  True;
						}
						break;
					}
					} 
				}
				setState(712);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			}
			setState(718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(713);
				match(Returns);
				setState(714);
				match(LParen);
				setState(715);
				((FunctionTypeNameContext)_localctx).returnParameters = parameterList();
				setState(716);
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
		enterRule(_localctx, 78, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			((VariableDeclarationContext)_localctx).type = typeName(0);
			setState(722);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 72066390130952192L) != 0) {
				{
				setState(721);
				((VariableDeclarationContext)_localctx).location = dataLocation();
				}
			}

			setState(724);
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
		enterRule(_localctx, 80, RULE_dataLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(726);
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
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				_localctx = new PayableConversionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(729);
				match(Payable);
				setState(730);
				callArgumentList();
				}
				break;
			case 2:
				{
				_localctx = new MetaTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(731);
				match(Type);
				setState(732);
				match(LParen);
				setState(733);
				typeName(0);
				setState(734);
				match(RParen);
				}
				break;
			case 3:
				{
				_localctx = new UnaryPrefixOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(736);
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
				setState(737);
				expression(19);
				}
				break;
			case 4:
				{
				_localctx = new NewExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(738);
				match(New);
				setState(739);
				typeName(0);
				}
				break;
			case 5:
				{
				_localctx = new TupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(740);
				tupleExpression();
				}
				break;
			case 6:
				{
				_localctx = new InlineArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(741);
				inlineArrayExpression();
				}
				break;
			case 7:
				{
				_localctx = new PrimaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(745);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(742);
					identifier();
					}
					break;
				case 2:
					{
					setState(743);
					literal();
					}
					break;
				case 3:
					{
					setState(744);
					elementaryTypeName(False);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(834);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(832);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
					case 1:
						{
						_localctx = new ExpOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(749);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(750);
						match(Exp);
						setState(751);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(752);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(753);
						_la = _input.LA(1);
						if ( !((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 7L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(754);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new AddSubOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(755);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(756);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(757);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ShiftOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(758);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(759);
						_la = _input.LA(1);
						if ( !((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & 7L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(760);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new BitAndOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(761);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(762);
						match(BitAnd);
						setState(763);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new BitXorOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(764);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(765);
						match(BitXor);
						setState(766);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new BitOrOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(767);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(768);
						match(BitOr);
						setState(769);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new OrderComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(770);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(771);
						_la = _input.LA(1);
						if ( !((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 15L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(772);
						expression(11);
						}
						break;
					case 9:
						{
						_localctx = new EqualityComparisonContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(773);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(774);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(775);
						expression(10);
						}
						break;
					case 10:
						{
						_localctx = new AndOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(776);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(777);
						match(And);
						setState(778);
						expression(9);
						}
						break;
					case 11:
						{
						_localctx = new OrOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(779);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(780);
						match(Or);
						setState(781);
						expression(8);
						}
						break;
					case 12:
						{
						_localctx = new AssignmentContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(782);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(783);
						assignOp();
						setState(784);
						expression(5);
						}
						break;
					case 13:
						{
						_localctx = new IndexAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(786);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(787);
						match(LBrack);
						setState(789);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
						case 1:
							{
							setState(788);
							((IndexAccessContext)_localctx).index = expression(0);
							}
							break;
						}
						setState(791);
						match(RBrack);
						}
						break;
					case 14:
						{
						_localctx = new IndexRangeAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(792);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(793);
						match(LBrack);
						setState(795);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
						case 1:
							{
							setState(794);
							((IndexRangeAccessContext)_localctx).start = expression(0);
							}
							break;
						}
						setState(797);
						match(Colon);
						setState(799);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
						case 1:
							{
							setState(798);
							((IndexRangeAccessContext)_localctx).end = expression(0);
							}
							break;
						}
						setState(801);
						match(RBrack);
						}
						break;
					case 15:
						{
						_localctx = new MemberAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(802);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(803);
						match(Period);
						setState(806);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Error:
						case Revert:
						case From:
						case Identifier:
							{
							setState(804);
							identifier();
							}
							break;
						case Address:
							{
							setState(805);
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
						setState(808);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(821);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LBrace) {
							{
							setState(809);
							match(LBrace);
							setState(818);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
								{
								setState(810);
								namedArgument();
								setState(815);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==Comma) {
									{
									{
									setState(811);
									match(Comma);
									setState(812);
									namedArgument();
									}
									}
									setState(817);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
							}

							setState(820);
							match(RBrace);
							}
						}

						setState(823);
						callArgumentList();
						}
						break;
					case 17:
						{
						_localctx = new UnarySuffixOperationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(824);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(825);
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
						setState(826);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(827);
						match(Conditional);
						{
						setState(828);
						expression(0);
						setState(829);
						match(Colon);
						setState(830);
						expression(0);
						}
						}
						break;
					}
					} 
				}
				setState(836);
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
		enterRule(_localctx, 84, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(837);
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
		enterRule(_localctx, 86, RULE_tupleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(839);
			match(LParen);
			{
			setState(841);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(840);
				expression(0);
				}
				break;
			}
			setState(849);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(843);
				match(Comma);
				setState(845);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(844);
					expression(0);
					}
					break;
				}
				}
				}
				setState(851);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(852);
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
		enterRule(_localctx, 88, RULE_inlineArrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			match(LBrack);
			{
			setState(855);
			expression(0);
			setState(860);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(856);
				match(Comma);
				setState(857);
				expression(0);
				}
				}
				setState(862);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(863);
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
		enterRule(_localctx, 90, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(865);
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
		enterRule(_localctx, 92, RULE_literal);
		try {
			setState(872);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NonEmptyStringLiteral:
			case EmptyStringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(867);
				stringLiteral();
				}
				break;
			case HexNumber:
			case DecimalNumber:
				enterOuterAlt(_localctx, 2);
				{
				setState(868);
				numberLiteral();
				}
				break;
			case False_:
			case True_:
				enterOuterAlt(_localctx, 3);
				{
				setState(869);
				booleanLiteral();
				}
				break;
			case HexString:
				enterOuterAlt(_localctx, 4);
				{
				setState(870);
				hexStringLiteral();
				}
				break;
			case UnicodeStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(871);
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
		enterRule(_localctx, 94, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
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
		enterRule(_localctx, 96, RULE_stringLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(877); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(876);
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
				setState(879); 
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
		enterRule(_localctx, 98, RULE_hexStringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(882); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(881);
					match(HexString);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(884); 
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
		enterRule(_localctx, 100, RULE_unicodeStringLiteral);
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
					match(UnicodeStringLiteral);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(889); 
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
		enterRule(_localctx, 102, RULE_numberLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(891);
			_la = _input.LA(1);
			if ( !(_la==HexNumber || _la==DecimalNumber) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(893);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(892);
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
		enterRule(_localctx, 104, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(895);
			match(LBrace);
			setState(900);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(898);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
					case 1:
						{
						setState(896);
						statement();
						}
						break;
					case 2:
						{
						setState(897);
						uncheckedBlock();
						}
						break;
					}
					} 
				}
				setState(902);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			}
			setState(903);
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
		enterRule(_localctx, 106, RULE_uncheckedBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			match(Unchecked);
			setState(906);
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
		enterRule(_localctx, 108, RULE_statement);
		try {
			setState(921);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(908);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(909);
				simpleStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(910);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(911);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(912);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(913);
				doWhileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(914);
				continueStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(915);
				breakStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(916);
				tryStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(917);
				returnStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(918);
				emitStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(919);
				revertStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(920);
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
		enterRule(_localctx, 110, RULE_simpleStatement);
		try {
			setState(925);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(923);
				variableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(924);
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
		enterRule(_localctx, 112, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(927);
			match(If);
			setState(928);
			match(LParen);
			setState(929);
			expression(0);
			setState(930);
			match(RParen);
			setState(931);
			statement();
			setState(934);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				{
				setState(932);
				match(Else);
				setState(933);
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
		enterRule(_localctx, 114, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			match(For);
			setState(937);
			match(LParen);
			setState(940);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				{
				setState(938);
				simpleStatement();
				}
				break;
			case 2:
				{
				setState(939);
				match(Semicolon);
				}
				break;
			}
			setState(944);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(942);
				expressionStatement();
				}
				break;
			case 2:
				{
				setState(943);
				match(Semicolon);
				}
				break;
			}
			setState(947);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(946);
				expression(0);
				}
				break;
			}
			setState(949);
			match(RParen);
			setState(950);
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
		enterRule(_localctx, 116, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(952);
			match(While);
			setState(953);
			match(LParen);
			setState(954);
			expression(0);
			setState(955);
			match(RParen);
			setState(956);
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
		enterRule(_localctx, 118, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(958);
			match(Do);
			setState(959);
			statement();
			setState(960);
			match(While);
			setState(961);
			match(LParen);
			setState(962);
			expression(0);
			setState(963);
			match(RParen);
			setState(964);
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
		enterRule(_localctx, 120, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(966);
			match(Continue);
			setState(967);
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
		enterRule(_localctx, 122, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
			match(Break);
			setState(970);
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
		enterRule(_localctx, 124, RULE_tryStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(972);
			match(Try);
			setState(973);
			expression(0);
			setState(979);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Returns) {
				{
				setState(974);
				match(Returns);
				setState(975);
				match(LParen);
				setState(976);
				((TryStatementContext)_localctx).returnParameters = parameterList();
				setState(977);
				match(RParen);
				}
			}

			setState(981);
			block();
			setState(983); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(982);
					catchClause();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(985); 
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
		enterRule(_localctx, 126, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(987);
			match(Catch);
			setState(995);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==LParen || _la==Identifier) {
				{
				setState(989);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 549453824L) != 0 || _la==Identifier) {
					{
					setState(988);
					identifier();
					}
				}

				setState(991);
				match(LParen);
				{
				setState(992);
				((CatchClauseContext)_localctx).arguments = parameterList();
				}
				setState(993);
				match(RParen);
				}
			}

			setState(997);
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
		enterRule(_localctx, 128, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(999);
			match(Return);
			setState(1001);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				setState(1000);
				expression(0);
				}
				break;
			}
			setState(1003);
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
		enterRule(_localctx, 130, RULE_emitStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1005);
			match(Emit);
			setState(1006);
			expression(0);
			setState(1007);
			callArgumentList();
			setState(1008);
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
		enterRule(_localctx, 132, RULE_revertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1010);
			match(Revert);
			setState(1011);
			expression(0);
			setState(1012);
			callArgumentList();
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
		enterRule(_localctx, 134, RULE_assemblyStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1015);
			match(Assembly);
			setState(1017);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssemblyDialect) {
				{
				setState(1016);
				match(AssemblyDialect);
				}
			}

			setState(1019);
			match(AssemblyLBrace);
			setState(1023);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & 4220901L) != 0) {
				{
				{
				setState(1020);
				yulStatement();
				}
				}
				setState(1025);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1026);
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
		enterRule(_localctx, 136, RULE_variableDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1028);
			((VariableDeclarationListContext)_localctx).variableDeclaration = variableDeclaration();
			((VariableDeclarationListContext)_localctx).variableDeclarations.add(((VariableDeclarationListContext)_localctx).variableDeclaration);
			setState(1033);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1029);
				match(Comma);
				setState(1030);
				((VariableDeclarationListContext)_localctx).variableDeclaration = variableDeclaration();
				((VariableDeclarationListContext)_localctx).variableDeclarations.add(((VariableDeclarationListContext)_localctx).variableDeclaration);
				}
				}
				setState(1035);
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
		enterRule(_localctx, 138, RULE_variableDeclarationTuple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1036);
			match(LParen);
			{
			setState(1040);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1037);
					match(Comma);
					}
					} 
				}
				setState(1042);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			}
			setState(1043);
			((VariableDeclarationTupleContext)_localctx).variableDeclaration = variableDeclaration();
			((VariableDeclarationTupleContext)_localctx).variableDeclarations.add(((VariableDeclarationTupleContext)_localctx).variableDeclaration);
			}
			setState(1051);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1045);
				match(Comma);
				setState(1047);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(1046);
					((VariableDeclarationTupleContext)_localctx).variableDeclaration = variableDeclaration();
					((VariableDeclarationTupleContext)_localctx).variableDeclarations.add(((VariableDeclarationTupleContext)_localctx).variableDeclaration);
					}
					break;
				}
				}
				}
				setState(1053);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1054);
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
		enterRule(_localctx, 140, RULE_variableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1065);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				{
				setState(1056);
				variableDeclaration();
				setState(1059);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Assign) {
					{
					setState(1057);
					match(Assign);
					setState(1058);
					expression(0);
					}
				}

				}
				}
				break;
			case 2:
				{
				{
				setState(1061);
				variableDeclarationTuple();
				setState(1062);
				match(Assign);
				setState(1063);
				expression(0);
				}
				}
				break;
			}
			setState(1067);
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
		enterRule(_localctx, 142, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1069);
			expression(0);
			setState(1070);
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
		enterRule(_localctx, 144, RULE_mappingType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1072);
			match(Mapping);
			setState(1073);
			match(LParen);
			setState(1074);
			((MappingTypeContext)_localctx).key = mappingKeyType();
			setState(1075);
			match(DoubleArrow);
			setState(1076);
			((MappingTypeContext)_localctx).value = typeName(0);
			setState(1077);
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
		enterRule(_localctx, 146, RULE_mappingKeyType);
		try {
			setState(1081);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1079);
				elementaryTypeName(False);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1080);
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
		enterRule(_localctx, 148, RULE_yulStatement);
		try {
			setState(1094);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1083);
				yulBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1084);
				yulVariableDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1085);
				yulAssignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1086);
				yulFunctionCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1087);
				yulIfStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1088);
				yulForStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1089);
				yulSwitchStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1090);
				match(YulLeave);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1091);
				match(YulBreak);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1092);
				match(YulContinue);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1093);
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
		enterRule(_localctx, 150, RULE_yulBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1096);
			match(YulLBrace);
			setState(1100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & 4220901L) != 0) {
				{
				{
				setState(1097);
				yulStatement();
				}
				}
				setState(1102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1103);
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
		enterRule(_localctx, 152, RULE_yulVariableDeclaration);
		int _la;
		try {
			setState(1124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1105);
				match(YulLet);
				setState(1106);
				((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
				setState(1109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulAssign) {
					{
					setState(1107);
					match(YulAssign);
					setState(1108);
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
				setState(1111);
				match(YulLet);
				setState(1112);
				((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
				setState(1117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1113);
					match(YulComma);
					setState(1114);
					((YulVariableDeclarationContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulVariableDeclarationContext)_localctx).variables.add(((YulVariableDeclarationContext)_localctx).YulIdentifier);
					}
					}
					setState(1119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulAssign) {
					{
					setState(1120);
					match(YulAssign);
					setState(1121);
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
		enterRule(_localctx, 154, RULE_yulAssignment);
		int _la;
		try {
			setState(1140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1126);
				yulPath();
				setState(1127);
				match(YulAssign);
				setState(1128);
				yulExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1130);
				yulPath();
				setState(1133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1131);
					match(YulComma);
					setState(1132);
					yulPath();
					}
					}
					setState(1135); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==YulComma );
				}
				setState(1137);
				match(YulAssign);
				setState(1138);
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
		enterRule(_localctx, 156, RULE_yulIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1142);
			match(YulIf);
			setState(1143);
			((YulIfStatementContext)_localctx).cond = yulExpression();
			setState(1144);
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
		enterRule(_localctx, 158, RULE_yulForStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1146);
			match(YulFor);
			setState(1147);
			((YulForStatementContext)_localctx).init = yulBlock();
			setState(1148);
			((YulForStatementContext)_localctx).cond = yulExpression();
			setState(1149);
			((YulForStatementContext)_localctx).post = yulBlock();
			setState(1150);
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
		enterRule(_localctx, 160, RULE_yulSwitchCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1152);
			match(YulCase);
			setState(1153);
			yulLiteral();
			setState(1154);
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
		enterRule(_localctx, 162, RULE_yulSwitchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1156);
			match(YulSwitch);
			setState(1157);
			yulExpression();
			setState(1169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YulCase:
				{
				{
				setState(1159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1158);
					yulSwitchCase();
					}
					}
					setState(1161); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==YulCase );
				setState(1165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==YulDefault) {
					{
					setState(1163);
					match(YulDefault);
					setState(1164);
					yulBlock();
					}
				}

				}
				}
				break;
			case YulDefault:
				{
				{
				setState(1167);
				match(YulDefault);
				setState(1168);
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
		enterRule(_localctx, 164, RULE_yulFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1171);
			match(YulFunction);
			setState(1172);
			match(YulIdentifier);
			setState(1173);
			match(YulLParen);
			setState(1182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==YulIdentifier) {
				{
				setState(1174);
				((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulFunctionDefinitionContext)_localctx).arguments.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
				setState(1179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1175);
					match(YulComma);
					setState(1176);
					((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulFunctionDefinitionContext)_localctx).arguments.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
					}
					}
					setState(1181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1184);
			match(YulRParen);
			setState(1194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==YulArrow) {
				{
				setState(1185);
				match(YulArrow);
				setState(1186);
				((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
				((YulFunctionDefinitionContext)_localctx).returnParameters.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
				setState(1191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1187);
					match(YulComma);
					setState(1188);
					((YulFunctionDefinitionContext)_localctx).YulIdentifier = match(YulIdentifier);
					((YulFunctionDefinitionContext)_localctx).returnParameters.add(((YulFunctionDefinitionContext)_localctx).YulIdentifier);
					}
					}
					setState(1193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1196);
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
		enterRule(_localctx, 166, RULE_yulPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1198);
			match(YulIdentifier);
			setState(1203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==YulPeriod) {
				{
				{
				setState(1199);
				match(YulPeriod);
				setState(1200);
				match(YulIdentifier);
				}
				}
				setState(1205);
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
		enterRule(_localctx, 168, RULE_yulFunctionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1206);
			_la = _input.LA(1);
			if ( !(_la==YulEVMBuiltin || _la==YulIdentifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1207);
			match(YulLParen);
			setState(1216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & 8127105L) != 0) {
				{
				setState(1208);
				yulExpression();
				setState(1213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==YulComma) {
					{
					{
					setState(1209);
					match(YulComma);
					setState(1210);
					yulExpression();
					}
					}
					setState(1215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1218);
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
		enterRule(_localctx, 170, RULE_yulBoolean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1220);
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
		enterRule(_localctx, 172, RULE_yulLiteral);
		try {
			setState(1227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YulDecimalNumber:
				enterOuterAlt(_localctx, 1);
				{
				setState(1222);
				match(YulDecimalNumber);
				}
				break;
			case YulStringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(1223);
				match(YulStringLiteral);
				}
				break;
			case YulHexNumber:
				enterOuterAlt(_localctx, 3);
				{
				setState(1224);
				match(YulHexNumber);
				}
				break;
			case YulFalse:
			case YulTrue:
				enterOuterAlt(_localctx, 4);
				{
				setState(1225);
				yulBoolean();
				}
				break;
			case YulHexStringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(1226);
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
		enterRule(_localctx, 174, RULE_yulExpression);
		try {
			setState(1232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1229);
				yulPath();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1230);
				yulFunctionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1231);
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
		case 29:
			return stateVariableDeclaration_sempred((StateVariableDeclarationContext)_localctx, predIndex);
		case 36:
			return typeName_sempred((TypeNameContext)_localctx, predIndex);
		case 37:
			return elementaryTypeName_sempred((ElementaryTypeNameContext)_localctx, predIndex);
		case 38:
			return functionTypeName_sempred((FunctionTypeNameContext)_localctx, predIndex);
		case 41:
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
		"\u0004\u0001\u00a9\u04d3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\u00bb\b\u0000\n\u0000\f\u0000\u00be\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001\u00c4\b\u0001"+
		"\u000b\u0001\f\u0001\u00c5\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002\u00ce\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002\u00da\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00e1\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u00e9\b\u0005\n\u0005\f\u0005\u00ec\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0003\u0006\u00f1\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00f6\b\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00fa\b\u0006"+
		"\n\u0006\f\u0006\u00fd\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0104\b\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u0108\b\u0007\n\u0007\f\u0007\u010b\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0113\b\b\n\b\f\b\u0116\t\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u011e\b\t\n\t\f\t\u0121"+
		"\t\t\u0001\n\u0001\n\u0003\n\u0125\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u0132\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u013c\b\r\n\r\f\r\u013f"+
		"\t\r\u0003\r\u0141\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0147\b"+
		"\r\n\r\f\r\u014a\t\r\u0003\r\u014c\b\r\u0001\r\u0003\r\u014f\b\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0156\b\u000e"+
		"\n\u000e\f\u000e\u0159\t\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u015d"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005"+
		"\u0011\u0164\b\u0011\n\u0011\f\u0011\u0167\t\u0011\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u016b\b\u0012\u0001\u0012\u0003\u0012\u016e\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0173\b\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0180\b\u0013\n"+
		"\u0013\f\u0013\u0183\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005"+
		"\u0015\u018e\b\u0015\n\u0015\f\u0015\u0191\t\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u0195\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u019b\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u019f\b"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u01b2\b\u0016\n\u0016\f\u0016\u01b5\t\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01bc\b\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u01c0\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u01c6\b\u0017\u0001\u0017\u0003\u0017\u01c9\b"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u01d2\b\u0017\n\u0017\f\u0017\u01d5\t\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u01d9\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01e0\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01f2\b\u0018\n\u0018"+
		"\f\u0018\u01f5\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u01fe\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u0202\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u0215\b\u0019\n\u0019\f\u0019\u0218"+
		"\t\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u021c\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0004\u001a\u0222\b\u001a\u000b\u001a"+
		"\f\u001a\u0223\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0005\u001c\u0232\b\u001c\n\u001c\f\u001c\u0235\t\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u024d\b\u001d\n"+
		"\u001d\f\u001d\u0250\t\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u0255\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0003\u001f\u0262\b\u001f\u0001\u001f\u0003\u001f\u0265\b\u001f"+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0005 \u026d\b \n \f \u0270"+
		"\t \u0003 \u0272\b \u0001 \u0001 \u0003 \u0276\b \u0001 \u0001 \u0001"+
		"!\u0001!\u0003!\u027c\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0005\"\u0284\b\"\n\"\f\"\u0287\t\"\u0003\"\u0289\b\"\u0001\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u0293\b#\u0001#\u0001"+
		"#\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u029c\b$\u0001$\u0001$\u0001"+
		"$\u0003$\u02a1\b$\u0001$\u0005$\u02a4\b$\n$\f$\u02a7\t$\u0001%\u0001%"+
		"\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0003%\u02b5\b%\u0001&\u0001&\u0001&\u0003&\u02ba\b&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005&\u02c5\b&\n&\f&\u02c8"+
		"\t&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u02cf\b&\u0001\'\u0001\'"+
		"\u0003\'\u02d3\b\'\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001)"+
		"\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0003)\u02ea\b)\u0003)\u02ec\b)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u0316"+
		"\b)\u0001)\u0001)\u0001)\u0001)\u0003)\u031c\b)\u0001)\u0001)\u0003)\u0320"+
		"\b)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u0327\b)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0005)\u032e\b)\n)\f)\u0331\t)\u0003)\u0333\b)\u0001)"+
		"\u0003)\u0336\b)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0005)\u0341\b)\n)\f)\u0344\t)\u0001*\u0001*\u0001+\u0001+\u0003"+
		"+\u034a\b+\u0001+\u0001+\u0003+\u034e\b+\u0005+\u0350\b+\n+\f+\u0353\t"+
		"+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0005,\u035b\b,\n,\f,\u035e"+
		"\t,\u0001,\u0001,\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0003"+
		".\u0369\b.\u0001/\u0001/\u00010\u00040\u036e\b0\u000b0\f0\u036f\u0001"+
		"1\u00041\u0373\b1\u000b1\f1\u0374\u00012\u00042\u0378\b2\u000b2\f2\u0379"+
		"\u00013\u00013\u00033\u037e\b3\u00014\u00014\u00014\u00054\u0383\b4\n"+
		"4\f4\u0386\t4\u00014\u00014\u00015\u00015\u00015\u00016\u00016\u00016"+
		"\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00036\u039a\b6\u00017\u00017\u00037\u039e\b7\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00038\u03a7\b8\u00019\u00019\u00019\u00019\u0003"+
		"9\u03ad\b9\u00019\u00019\u00039\u03b1\b9\u00019\u00039\u03b4\b9\u0001"+
		"9\u00019\u00019\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001"+
		"=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0003"+
		">\u03d4\b>\u0001>\u0001>\u0004>\u03d8\b>\u000b>\f>\u03d9\u0001?\u0001"+
		"?\u0003?\u03de\b?\u0001?\u0001?\u0001?\u0001?\u0003?\u03e4\b?\u0001?\u0001"+
		"?\u0001@\u0001@\u0003@\u03ea\b@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001B\u0001B\u0001B\u0001B\u0001B\u0001C\u0001C\u0003C\u03fa"+
		"\bC\u0001C\u0001C\u0005C\u03fe\bC\nC\fC\u0401\tC\u0001C\u0001C\u0001D"+
		"\u0001D\u0001D\u0005D\u0408\bD\nD\fD\u040b\tD\u0001E\u0001E\u0005E\u040f"+
		"\bE\nE\fE\u0412\tE\u0001E\u0001E\u0001E\u0001E\u0003E\u0418\bE\u0005E"+
		"\u041a\bE\nE\fE\u041d\tE\u0001E\u0001E\u0001F\u0001F\u0001F\u0003F\u0424"+
		"\bF\u0001F\u0001F\u0001F\u0001F\u0003F\u042a\bF\u0001F\u0001F\u0001G\u0001"+
		"G\u0001G\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001I\u0001"+
		"I\u0003I\u043a\bI\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0001"+
		"J\u0001J\u0001J\u0001J\u0003J\u0447\bJ\u0001K\u0001K\u0005K\u044b\bK\n"+
		"K\fK\u044e\tK\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0003L\u0456\b"+
		"L\u0001L\u0001L\u0001L\u0001L\u0005L\u045c\bL\nL\fL\u045f\tL\u0001L\u0001"+
		"L\u0003L\u0463\bL\u0003L\u0465\bL\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0004M\u046e\bM\u000bM\fM\u046f\u0001M\u0001M\u0001M\u0003M\u0475"+
		"\bM\u0001N\u0001N\u0001N\u0001N\u0001O\u0001O\u0001O\u0001O\u0001O\u0001"+
		"O\u0001P\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0004Q\u0488\bQ\u000b"+
		"Q\fQ\u0489\u0001Q\u0001Q\u0003Q\u048e\bQ\u0001Q\u0001Q\u0003Q\u0492\b"+
		"Q\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0005R\u049a\bR\nR\fR\u049d"+
		"\tR\u0003R\u049f\bR\u0001R\u0001R\u0001R\u0001R\u0001R\u0005R\u04a6\b"+
		"R\nR\fR\u04a9\tR\u0003R\u04ab\bR\u0001R\u0001R\u0001S\u0001S\u0001S\u0005"+
		"S\u04b2\bS\nS\fS\u04b5\tS\u0001T\u0001T\u0001T\u0001T\u0001T\u0005T\u04bc"+
		"\bT\nT\fT\u04bf\tT\u0003T\u04c1\bT\u0001T\u0001T\u0001U\u0001U\u0001V"+
		"\u0001V\u0001V\u0001V\u0001V\u0003V\u04cc\bV\u0001W\u0001W\u0001W\u0003"+
		"W\u04d1\bW\u0001W\u0001\u011f\u0002HRX\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4"+
		"\u00a6\u00a8\u00aa\u00ac\u00ae\u0000\u0011\u0003\u0000\u0019\u0019\'\'"+
		"12\u0003\u00000033BB\u0003\u0000\u000b\u000b++88\u0003\u0000\u0011\u0011"+
		"ggru\u0001\u0000hj\u0001\u0000fg\u0001\u0000ce\u0001\u0000nq\u0001\u0000"+
		"lm\u0001\u0000tu\u0001\u0000Q\\\u0003\u0000\u0016\u0017\u001d\u001d~~"+
		"\u0002\u0000\u001b\u001b;;\u0001\u0000xy\u0001\u0000|}\u0002\u0000\u0094"+
		"\u0094\u009d\u009d\u0002\u0000\u008b\u008b\u0092\u0092\u055e\u0000\u00bc"+
		"\u0001\u0000\u0000\u0000\u0002\u00c1\u0001\u0000\u0000\u0000\u0004\u00c9"+
		"\u0001\u0000\u0000\u0000\u0006\u00dd\u0001\u0000\u0000\u0000\b\u00e2\u0001"+
		"\u0000\u0000\u0000\n\u00e4\u0001\u0000\u0000\u0000\f\u00f0\u0001\u0000"+
		"\u0000\u0000\u000e\u0100\u0001\u0000\u0000\u0000\u0010\u010e\u0001\u0000"+
		"\u0000\u0000\u0012\u0119\u0001\u0000\u0000\u0000\u0014\u0122\u0001\u0000"+
		"\u0000\u0000\u0016\u0131\u0001\u0000\u0000\u0000\u0018\u0133\u0001\u0000"+
		"\u0000\u0000\u001a\u0137\u0001\u0000\u0000\u0000\u001c\u0152\u0001\u0000"+
		"\u0000\u0000\u001e\u015a\u0001\u0000\u0000\u0000 \u015e\u0001\u0000\u0000"+
		"\u0000\"\u0160\u0001\u0000\u0000\u0000$\u0168\u0001\u0000\u0000\u0000"+
		"&\u016f\u0001\u0000\u0000\u0000(\u0186\u0001\u0000\u0000\u0000*\u0188"+
		"\u0001\u0000\u0000\u0000,\u0196\u0001\u0000\u0000\u0000.\u01c1\u0001\u0000"+
		"\u0000\u00000\u01da\u0001\u0000\u0000\u00002\u0203\u0001\u0000\u0000\u0000"+
		"4\u021d\u0001\u0000\u0000\u00006\u0227\u0001\u0000\u0000\u00008\u022b"+
		"\u0001\u0000\u0000\u0000:\u0238\u0001\u0000\u0000\u0000<\u0258\u0001\u0000"+
		"\u0000\u0000>\u025f\u0001\u0000\u0000\u0000@\u0266\u0001\u0000\u0000\u0000"+
		"B\u0279\u0001\u0000\u0000\u0000D\u027d\u0001\u0000\u0000\u0000F\u028d"+
		"\u0001\u0000\u0000\u0000H\u029b\u0001\u0000\u0000\u0000J\u02b4\u0001\u0000"+
		"\u0000\u0000L\u02b6\u0001\u0000\u0000\u0000N\u02d0\u0001\u0000\u0000\u0000"+
		"P\u02d6\u0001\u0000\u0000\u0000R\u02eb\u0001\u0000\u0000\u0000T\u0345"+
		"\u0001\u0000\u0000\u0000V\u0347\u0001\u0000\u0000\u0000X\u0356\u0001\u0000"+
		"\u0000\u0000Z\u0361\u0001\u0000\u0000\u0000\\\u0368\u0001\u0000\u0000"+
		"\u0000^\u036a\u0001\u0000\u0000\u0000`\u036d\u0001\u0000\u0000\u0000b"+
		"\u0372\u0001\u0000\u0000\u0000d\u0377\u0001\u0000\u0000\u0000f\u037b\u0001"+
		"\u0000\u0000\u0000h\u037f\u0001\u0000\u0000\u0000j\u0389\u0001\u0000\u0000"+
		"\u0000l\u0399\u0001\u0000\u0000\u0000n\u039d\u0001\u0000\u0000\u0000p"+
		"\u039f\u0001\u0000\u0000\u0000r\u03a8\u0001\u0000\u0000\u0000t\u03b8\u0001"+
		"\u0000\u0000\u0000v\u03be\u0001\u0000\u0000\u0000x\u03c6\u0001\u0000\u0000"+
		"\u0000z\u03c9\u0001\u0000\u0000\u0000|\u03cc\u0001\u0000\u0000\u0000~"+
		"\u03db\u0001\u0000\u0000\u0000\u0080\u03e7\u0001\u0000\u0000\u0000\u0082"+
		"\u03ed\u0001\u0000\u0000\u0000\u0084\u03f2\u0001\u0000\u0000\u0000\u0086"+
		"\u03f7\u0001\u0000\u0000\u0000\u0088\u0404\u0001\u0000\u0000\u0000\u008a"+
		"\u040c\u0001\u0000\u0000\u0000\u008c\u0429\u0001\u0000\u0000\u0000\u008e"+
		"\u042d\u0001\u0000\u0000\u0000\u0090\u0430\u0001\u0000\u0000\u0000\u0092"+
		"\u0439\u0001\u0000\u0000\u0000\u0094\u0446\u0001\u0000\u0000\u0000\u0096"+
		"\u0448\u0001\u0000\u0000\u0000\u0098\u0464\u0001\u0000\u0000\u0000\u009a"+
		"\u0474\u0001\u0000\u0000\u0000\u009c\u0476\u0001\u0000\u0000\u0000\u009e"+
		"\u047a\u0001\u0000\u0000\u0000\u00a0\u0480\u0001\u0000\u0000\u0000\u00a2"+
		"\u0484\u0001\u0000\u0000\u0000\u00a4\u0493\u0001\u0000\u0000\u0000\u00a6"+
		"\u04ae\u0001\u0000\u0000\u0000\u00a8\u04b6\u0001\u0000\u0000\u0000\u00aa"+
		"\u04c4\u0001\u0000\u0000\u0000\u00ac\u04cb\u0001\u0000\u0000\u0000\u00ae"+
		"\u04d0\u0001\u0000\u0000\u0000\u00b0\u00bb\u0003\u0002\u0001\u0000\u00b1"+
		"\u00bb\u0003\u0004\u0002\u0000\u00b2\u00bb\u0003\f\u0006\u0000\u00b3\u00bb"+
		"\u0003\u000e\u0007\u0000\u00b4\u00bb\u0003\u0010\b\u0000\u00b5\u00bb\u0003"+
		",\u0016\u0000\u00b6\u00bb\u0003<\u001e\u0000\u00b7\u00bb\u00034\u001a"+
		"\u0000\u00b8\u00bb\u00038\u001c\u0000\u00b9\u00bb\u0003D\"\u0000\u00ba"+
		"\u00b0\u0001\u0000\u0000\u0000\u00ba\u00b1\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b2\u0001\u0000\u0000\u0000\u00ba\u00b3\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b4\u0001\u0000\u0000\u0000\u00ba\u00b5\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b6\u0001\u0000\u0000\u0000\u00ba\u00b7\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b8\u0001\u0000\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb"+
		"\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u0000\u0000\u0001\u00c0"+
		"\u0001\u0001\u0000\u0000\u0000\u00c1\u00c3\u0005\u0002\u0000\u0000\u00c2"+
		"\u00c4\u0005\u00a5\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0005\u00a6\u0000\u0000\u00c8\u0003\u0001\u0000\u0000\u0000\u00c9"+
		"\u00d9\u0005$\u0000\u0000\u00ca\u00cd\u0003\b\u0004\u0000\u00cb\u00cc"+
		"\u0005\u0006\u0000\u0000\u00cc\u00ce\u0003Z-\u0000\u00cd\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00da\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u0003\n\u0005\u0000\u00d0\u00d1\u0005\u001d\u0000"+
		"\u0000\u00d1\u00d2\u0003\b\u0004\u0000\u00d2\u00da\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d4\u0005h\u0000\u0000\u00d4\u00d5\u0005\u0006\u0000\u0000\u00d5"+
		"\u00d6\u0003Z-\u0000\u00d6\u00d7\u0005\u001d\u0000\u0000\u00d7\u00d8\u0003"+
		"\b\u0004\u0000\u00d8\u00da\u0001\u0000\u0000\u0000\u00d9\u00ca\u0001\u0000"+
		"\u0000\u0000\u00d9\u00cf\u0001\u0000\u0000\u0000\u00d9\u00d3\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dc\u0005L\u0000"+
		"\u0000\u00dc\u0005\u0001\u0000\u0000\u0000\u00dd\u00e0\u0003Z-\u0000\u00de"+
		"\u00df\u0005\u0006\u0000\u0000\u00df\u00e1\u0003Z-\u0000\u00e0\u00de\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u0007\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0005x\u0000\u0000\u00e3\t\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0005I\u0000\u0000\u00e5\u00ea\u0003\u0006\u0003"+
		"\u0000\u00e6\u00e7\u0005]\u0000\u0000\u00e7\u00e9\u0003\u0006\u0003\u0000"+
		"\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ed\u00ee\u0005J\u0000\u0000\u00ee\u000b\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f1\u0005\u0003\u0000\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f3\u0005\u0010\u0000\u0000\u00f3\u00f5\u0003Z-\u0000\u00f4\u00f6\u0003"+
		"\u0012\t\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00fb\u0005I\u0000"+
		"\u0000\u00f8\u00fa\u0003\u0016\u000b\u0000\u00f9\u00f8\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005J\u0000\u0000"+
		"\u00ff\r\u0001\u0000\u0000\u0000\u0100\u0101\u0005&\u0000\u0000\u0101"+
		"\u0103\u0003Z-\u0000\u0102\u0104\u0003\u0012\t\u0000\u0103\u0102\u0001"+
		"\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105\u0001"+
		"\u0000\u0000\u0000\u0105\u0109\u0005I\u0000\u0000\u0106\u0108\u0003\u0016"+
		"\u000b\u0000\u0107\u0106\u0001\u0000\u0000\u0000\u0108\u010b\u0001\u0000"+
		"\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000"+
		"\u0000\u0000\u010a\u010c\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0005J\u0000\u0000\u010d\u000f\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0005)\u0000\u0000\u010f\u0110\u0003Z-\u0000\u0110"+
		"\u0114\u0005I\u0000\u0000\u0111\u0113\u0003\u0016\u000b\u0000\u0112\u0111"+
		"\u0001\u0000\u0000\u0000\u0113\u0116\u0001\u0000\u0000\u0000\u0114\u0112"+
		"\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0117"+
		"\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\u0005J\u0000\u0000\u0118\u0011\u0001\u0000\u0000\u0000\u0119\u011a\u0005"+
		"(\u0000\u0000\u011a\u011f\u0003\u0014\n\u0000\u011b\u011c\u0005]\u0000"+
		"\u0000\u011c\u011e\u0003\u0014\n\u0000\u011d\u011b\u0001\u0000\u0000\u0000"+
		"\u011e\u0121\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000"+
		"\u011f\u011d\u0001\u0000\u0000\u0000\u0120\u0013\u0001\u0000\u0000\u0000"+
		"\u0121\u011f\u0001\u0000\u0000\u0000\u0122\u0124\u0003\u001c\u000e\u0000"+
		"\u0123\u0125\u0003\u001a\r\u0000\u0124\u0123\u0001\u0000\u0000\u0000\u0124"+
		"\u0125\u0001\u0000\u0000\u0000\u0125\u0015\u0001\u0000\u0000\u0000\u0126"+
		"\u0132\u0003&\u0013\u0000\u0127\u0132\u0003,\u0016\u0000\u0128\u0132\u0003"+
		".\u0017\u0000\u0129\u0132\u00030\u0018\u0000\u012a\u0132\u00032\u0019"+
		"\u0000\u012b\u0132\u00034\u001a\u0000\u012c\u0132\u00038\u001c\u0000\u012d"+
		"\u0132\u0003:\u001d\u0000\u012e\u0132\u0003@ \u0000\u012f\u0132\u0003"+
		"D\"\u0000\u0130\u0132\u0003F#\u0000\u0131\u0126\u0001\u0000\u0000\u0000"+
		"\u0131\u0127\u0001\u0000\u0000\u0000\u0131\u0128\u0001\u0000\u0000\u0000"+
		"\u0131\u0129\u0001\u0000\u0000\u0000\u0131\u012a\u0001\u0000\u0000\u0000"+
		"\u0131\u012b\u0001\u0000\u0000\u0000\u0131\u012c\u0001\u0000\u0000\u0000"+
		"\u0131\u012d\u0001\u0000\u0000\u0000\u0131\u012e\u0001\u0000\u0000\u0000"+
		"\u0131\u012f\u0001\u0000\u0000\u0000\u0131\u0130\u0001\u0000\u0000\u0000"+
		"\u0132\u0017\u0001\u0000\u0000\u0000\u0133\u0134\u0003Z-\u0000\u0134\u0135"+
		"\u0005K\u0000\u0000\u0135\u0136\u0003R)\u0000\u0136\u0019\u0001\u0000"+
		"\u0000\u0000\u0137\u014e\u0005E\u0000\u0000\u0138\u013d\u0003R)\u0000"+
		"\u0139\u013a\u0005]\u0000\u0000\u013a\u013c\u0003R)\u0000\u013b\u0139"+
		"\u0001\u0000\u0000\u0000\u013c\u013f\u0001\u0000\u0000\u0000\u013d\u013b"+
		"\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u0141"+
		"\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u0140\u0138"+
		"\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u014f"+
		"\u0001\u0000\u0000\u0000\u0142\u014b\u0005I\u0000\u0000\u0143\u0148\u0003"+
		"\u0018\f\u0000\u0144\u0145\u0005]\u0000\u0000\u0145\u0147\u0003\u0018"+
		"\f\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0147\u014a\u0001\u0000\u0000"+
		"\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000"+
		"\u0000\u0149\u014c\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000"+
		"\u0000\u014b\u0143\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000"+
		"\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u014f\u0005J\u0000\u0000"+
		"\u014e\u0140\u0001\u0000\u0000\u0000\u014e\u0142\u0001\u0000\u0000\u0000"+
		"\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0151\u0005F\u0000\u0000\u0151"+
		"\u001b\u0001\u0000\u0000\u0000\u0152\u0157\u0003Z-\u0000\u0153\u0154\u0005"+
		"M\u0000\u0000\u0154\u0156\u0003Z-\u0000\u0155\u0153\u0001\u0000\u0000"+
		"\u0000\u0156\u0159\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000"+
		"\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u001d\u0001\u0000\u0000"+
		"\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u015a\u015c\u0003\u001c\u000e"+
		"\u0000\u015b\u015d\u0003\u001a\r\u0000\u015c\u015b\u0001\u0000\u0000\u0000"+
		"\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u001f\u0001\u0000\u0000\u0000"+
		"\u015e\u015f\u0007\u0000\u0000\u0000\u015f!\u0001\u0000\u0000\u0000\u0160"+
		"\u0165\u0003$\u0012\u0000\u0161\u0162\u0005]\u0000\u0000\u0162\u0164\u0003"+
		"$\u0012\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0164\u0167\u0001\u0000"+
		"\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000"+
		"\u0000\u0000\u0166#\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000"+
		"\u0000\u0168\u016a\u0003H$\u0000\u0169\u016b\u0003P(\u0000\u016a\u0169"+
		"\u0001\u0000\u0000\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u016d"+
		"\u0001\u0000\u0000\u0000\u016c\u016e\u0003Z-\u0000\u016d\u016c\u0001\u0000"+
		"\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e%\u0001\u0000\u0000"+
		"\u0000\u016f\u0170\u0005\u000e\u0000\u0000\u0170\u0172\u0005E\u0000\u0000"+
		"\u0171\u0173\u0003\"\u0011\u0000\u0172\u0171\u0001\u0000\u0000\u0000\u0172"+
		"\u0173\u0001\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174"+
		"\u0181\u0005F\u0000\u0000\u0175\u0180\u0003\u001e\u000f\u0000\u0176\u0177"+
		"\u0004\u0013\u0000\u0001\u0177\u0178\u00050\u0000\u0000\u0178\u0180\u0006"+
		"\u0013\uffff\uffff\u0000\u0179\u017a\u0004\u0013\u0001\u0001\u017a\u017b"+
		"\u0005\'\u0000\u0000\u017b\u0180\u0006\u0013\uffff\uffff\u0000\u017c\u017d"+
		"\u0004\u0013\u0002\u0001\u017d\u017e\u00052\u0000\u0000\u017e\u0180\u0006"+
		"\u0013\uffff\uffff\u0000\u017f\u0175\u0001\u0000\u0000\u0000\u017f\u0176"+
		"\u0001\u0000\u0000\u0000\u017f\u0179\u0001\u0000\u0000\u0000\u017f\u017c"+
		"\u0001\u0000\u0000\u0000\u0180\u0183\u0001\u0000\u0000\u0000\u0181\u017f"+
		"\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182\u0184"+
		"\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0184\u0185"+
		"\u0003h4\u0000\u0185\'\u0001\u0000\u0000\u0000\u0186\u0187\u0007\u0001"+
		"\u0000\u0000\u0187)\u0001\u0000\u0000\u0000\u0188\u0194\u0005/\u0000\u0000"+
		"\u0189\u018a\u0005E\u0000\u0000\u018a\u018f\u0003\u001c\u000e\u0000\u018b"+
		"\u018c\u0005]\u0000\u0000\u018c\u018e\u0003\u001c\u000e\u0000\u018d\u018b"+
		"\u0001\u0000\u0000\u0000\u018e\u0191\u0001\u0000\u0000\u0000\u018f\u018d"+
		"\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0192"+
		"\u0001\u0000\u0000\u0000\u0191\u018f\u0001\u0000\u0000\u0000\u0192\u0193"+
		"\u0005F\u0000\u0000\u0193\u0195\u0001\u0000\u0000\u0000\u0194\u0189\u0001"+
		"\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195+\u0001\u0000"+
		"\u0000\u0000\u0196\u019a\u0005 \u0000\u0000\u0197\u019b\u0003Z-\u0000"+
		"\u0198\u019b\u0005\u001a\u0000\u0000\u0199\u019b\u00054\u0000\u0000\u019a"+
		"\u0197\u0001\u0000\u0000\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019a"+
		"\u0199\u0001\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c"+
		"\u019e\u0005E\u0000\u0000\u019d\u019f\u0003\"\u0011\u0000\u019e\u019d"+
		"\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u01a0"+
		"\u0001\u0000\u0000\u0000\u01a0\u01b3\u0005F\u0000\u0000\u01a1\u01a2\u0004"+
		"\u0016\u0003\u0001\u01a2\u01a3\u0003 \u0010\u0000\u01a3\u01a4\u0006\u0016"+
		"\uffff\uffff\u0000\u01a4\u01b2\u0001\u0000\u0000\u0000\u01a5\u01a6\u0004"+
		"\u0016\u0004\u0001\u01a6\u01a7\u0003(\u0014\u0000\u01a7\u01a8\u0006\u0016"+
		"\uffff\uffff\u0000\u01a8\u01b2\u0001\u0000\u0000\u0000\u01a9\u01b2\u0003"+
		"\u001e\u000f\u0000\u01aa\u01ab\u0004\u0016\u0005\u0001\u01ab\u01ac\u0005"+
		"C\u0000\u0000\u01ac\u01b2\u0006\u0016\uffff\uffff\u0000\u01ad\u01ae\u0004"+
		"\u0016\u0006\u0001\u01ae\u01af\u0003*\u0015\u0000\u01af\u01b0\u0006\u0016"+
		"\uffff\uffff\u0000\u01b0\u01b2\u0001\u0000\u0000\u0000\u01b1\u01a1\u0001"+
		"\u0000\u0000\u0000\u01b1\u01a5\u0001\u0000\u0000\u0000\u01b1\u01a9\u0001"+
		"\u0000\u0000\u0000\u01b1\u01aa\u0001\u0000\u0000\u0000\u01b1\u01ad\u0001"+
		"\u0000\u0000\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000\u01b3\u01b1\u0001"+
		"\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01bb\u0001"+
		"\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b6\u01b7\u0005"+
		"6\u0000\u0000\u01b7\u01b8\u0005E\u0000\u0000\u01b8\u01b9\u0003\"\u0011"+
		"\u0000\u01b9\u01ba\u0005F\u0000\u0000\u01ba\u01bc\u0001\u0000\u0000\u0000"+
		"\u01bb\u01b6\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000"+
		"\u01bc\u01bf\u0001\u0000\u0000\u0000\u01bd\u01c0\u0005L\u0000\u0000\u01be"+
		"\u01c0\u0003h4\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01bf\u01be\u0001"+
		"\u0000\u0000\u0000\u01c0-\u0001\u0000\u0000\u0000\u01c1\u01c2\u0005,\u0000"+
		"\u0000\u01c2\u01c8\u0003Z-\u0000\u01c3\u01c5\u0005E\u0000\u0000\u01c4"+
		"\u01c6\u0003\"\u0011\u0000\u01c5\u01c4\u0001\u0000\u0000\u0000\u01c5\u01c6"+
		"\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01c9"+
		"\u0005F\u0000\u0000\u01c8\u01c3\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001"+
		"\u0000\u0000\u0000\u01c9\u01d3\u0001\u0000\u0000\u0000\u01ca\u01cb\u0004"+
		"\u0017\u0007\u0001\u01cb\u01cc\u0005C\u0000\u0000\u01cc\u01d2\u0006\u0017"+
		"\uffff\uffff\u0000\u01cd\u01ce\u0004\u0017\b\u0001\u01ce\u01cf\u0003*"+
		"\u0015\u0000\u01cf\u01d0\u0006\u0017\uffff\uffff\u0000\u01d0\u01d2\u0001"+
		"\u0000\u0000\u0000\u01d1\u01ca\u0001\u0000\u0000\u0000\u01d1\u01cd\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d5\u0001\u0000\u0000\u0000\u01d3\u01d1\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d8\u0001"+
		"\u0000\u0000\u0000\u01d5\u01d3\u0001\u0000\u0000\u0000\u01d6\u01d9\u0005"+
		"L\u0000\u0000\u01d7\u01d9\u0003h4\u0000\u01d8\u01d6\u0001\u0000\u0000"+
		"\u0000\u01d8\u01d7\u0001\u0000\u0000\u0000\u01d9/\u0001\u0000\u0000\u0000"+
		"\u01da\u01db\u0005\u001a\u0000\u0000\u01db\u01df\u0005E\u0000\u0000\u01dc"+
		"\u01dd\u0003\"\u0011\u0000\u01dd\u01de\u0006\u0018\uffff\uffff\u0000\u01de"+
		"\u01e0\u0001\u0000\u0000\u0000\u01df\u01dc\u0001\u0000\u0000\u0000\u01df"+
		"\u01e0\u0001\u0000\u0000\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1"+
		"\u01f3\u0005F\u0000\u0000\u01e2\u01e3\u0004\u0018\t\u0001\u01e3\u01e4"+
		"\u0005\u0019\u0000\u0000\u01e4\u01f2\u0006\u0018\uffff\uffff\u0000\u01e5"+
		"\u01e6\u0004\u0018\n\u0001\u01e6\u01e7\u0003(\u0014\u0000\u01e7\u01e8"+
		"\u0006\u0018\uffff\uffff\u0000\u01e8\u01f2\u0001\u0000\u0000\u0000\u01e9"+
		"\u01f2\u0003\u001e\u000f\u0000\u01ea\u01eb\u0004\u0018\u000b\u0001\u01eb"+
		"\u01ec\u0005C\u0000\u0000\u01ec\u01f2\u0006\u0018\uffff\uffff\u0000\u01ed"+
		"\u01ee\u0004\u0018\f\u0001\u01ee\u01ef\u0003*\u0015\u0000\u01ef\u01f0"+
		"\u0006\u0018\uffff\uffff\u0000\u01f0\u01f2\u0001\u0000\u0000\u0000\u01f1"+
		"\u01e2\u0001\u0000\u0000\u0000\u01f1\u01e5\u0001\u0000\u0000\u0000\u01f1"+
		"\u01e9\u0001\u0000\u0000\u0000\u01f1\u01ea\u0001\u0000\u0000\u0000\u01f1"+
		"\u01ed\u0001\u0000\u0000\u0000\u01f2\u01f5\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001\u0000\u0000\u0000\u01f4"+
		"\u01fd\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f6"+
		"\u01f7\u0004\u0018\r\u0001\u01f7\u01f8\u00056\u0000\u0000\u01f8\u01f9"+
		"\u0005E\u0000\u0000\u01f9\u01fa\u0003\"\u0011\u0000\u01fa\u01fb\u0005"+
		"F\u0000\u0000\u01fb\u01fe\u0001\u0000\u0000\u0000\u01fc\u01fe\u0004\u0018"+
		"\u000e\u0001\u01fd\u01f6\u0001\u0000\u0000\u0000\u01fd\u01fc\u0001\u0000"+
		"\u0000\u0000\u01fe\u0201\u0001\u0000\u0000\u0000\u01ff\u0202\u0005L\u0000"+
		"\u0000\u0200\u0202\u0003h4\u0000\u0201\u01ff\u0001\u0000\u0000\u0000\u0201"+
		"\u0200\u0001\u0000\u0000\u0000\u02021\u0001\u0000\u0000\u0000\u0203\u0204"+
		"\u00054\u0000\u0000\u0204\u0205\u0005E\u0000\u0000\u0205\u0216\u0005F"+
		"\u0000\u0000\u0206\u0207\u0004\u0019\u000f\u0001\u0207\u0208\u0005\u0019"+
		"\u0000\u0000\u0208\u0215\u0006\u0019\uffff\uffff\u0000\u0209\u020a\u0004"+
		"\u0019\u0010\u0001\u020a\u020b\u00050\u0000\u0000\u020b\u0215\u0006\u0019"+
		"\uffff\uffff\u0000\u020c\u0215\u0003\u001e\u000f\u0000\u020d\u020e\u0004"+
		"\u0019\u0011\u0001\u020e\u020f\u0005C\u0000\u0000\u020f\u0215\u0006\u0019"+
		"\uffff\uffff\u0000\u0210\u0211\u0004\u0019\u0012\u0001\u0211\u0212\u0003"+
		"*\u0015\u0000\u0212\u0213\u0006\u0019\uffff\uffff\u0000\u0213\u0215\u0001"+
		"\u0000\u0000\u0000\u0214\u0206\u0001\u0000\u0000\u0000\u0214\u0209\u0001"+
		"\u0000\u0000\u0000\u0214\u020c\u0001\u0000\u0000\u0000\u0214\u020d\u0001"+
		"\u0000\u0000\u0000\u0214\u0210\u0001\u0000\u0000\u0000\u0215\u0218\u0001"+
		"\u0000\u0000\u0000\u0216\u0214\u0001\u0000\u0000\u0000\u0216\u0217\u0001"+
		"\u0000\u0000\u0000\u0217\u021b\u0001\u0000\u0000\u0000\u0218\u0216\u0001"+
		"\u0000\u0000\u0000\u0219\u021c\u0005L\u0000\u0000\u021a\u021c\u0003h4"+
		"\u0000\u021b\u0219\u0001\u0000\u0000\u0000\u021b\u021a\u0001\u0000\u0000"+
		"\u0000\u021c3\u0001\u0000\u0000\u0000\u021d\u021e\u0005:\u0000\u0000\u021e"+
		"\u021f\u0003Z-\u0000\u021f\u0221\u0005I\u0000\u0000\u0220\u0222\u0003"+
		"6\u001b\u0000\u0221\u0220\u0001\u0000\u0000\u0000\u0222\u0223\u0001\u0000"+
		"\u0000\u0000\u0223\u0221\u0001\u0000\u0000\u0000\u0223\u0224\u0001\u0000"+
		"\u0000\u0000\u0224\u0225\u0001\u0000\u0000\u0000\u0225\u0226\u0005J\u0000"+
		"\u0000\u02265\u0001\u0000\u0000\u0000\u0227\u0228\u0003H$\u0000\u0228"+
		"\u0229\u0003Z-\u0000\u0229\u022a\u0005L\u0000\u0000\u022a7\u0001\u0000"+
		"\u0000\u0000\u022b\u022c\u0005\u0015\u0000\u0000\u022c\u022d\u0003Z-\u0000"+
		"\u022d\u022e\u0005I\u0000\u0000\u022e\u0233\u0003Z-\u0000\u022f\u0230"+
		"\u0005]\u0000\u0000\u0230\u0232\u0003Z-\u0000\u0231\u022f\u0001\u0000"+
		"\u0000\u0000\u0232\u0235\u0001\u0000\u0000\u0000\u0233\u0231\u0001\u0000"+
		"\u0000\u0000\u0233\u0234\u0001\u0000\u0000\u0000\u0234\u0236\u0001\u0000"+
		"\u0000\u0000\u0235\u0233\u0001\u0000\u0000\u0000\u0236\u0237\u0005J\u0000"+
		"\u0000\u02379\u0001\u0000\u0000\u0000\u0238\u024e\u0003H$\u0000\u0239"+
		"\u023a\u0004\u001d\u0013\u0001\u023a\u023b\u00052\u0000\u0000\u023b\u024d"+
		"\u0006\u001d\uffff\uffff\u0000\u023c\u023d\u0004\u001d\u0014\u0001\u023d"+
		"\u023e\u00051\u0000\u0000\u023e\u024d\u0006\u001d\uffff\uffff\u0000\u023f"+
		"\u0240\u0004\u001d\u0015\u0001\u0240\u0241\u0005\'\u0000\u0000\u0241\u024d"+
		"\u0006\u001d\uffff\uffff\u0000\u0242\u0243\u0004\u001d\u0016\u0001\u0243"+
		"\u0244\u0005\r\u0000\u0000\u0244\u024d\u0006\u001d\uffff\uffff\u0000\u0245"+
		"\u0246\u0004\u001d\u0017\u0001\u0246\u0247\u0003*\u0015\u0000\u0247\u0248"+
		"\u0006\u001d\uffff\uffff\u0000\u0248\u024d\u0001\u0000\u0000\u0000\u0249"+
		"\u024a\u0004\u001d\u0018\u0001\u024a\u024b\u0005#\u0000\u0000\u024b\u024d"+
		"\u0006\u001d\uffff\uffff\u0000\u024c\u0239\u0001\u0000\u0000\u0000\u024c"+
		"\u023c\u0001\u0000\u0000\u0000\u024c\u023f\u0001\u0000\u0000\u0000\u024c"+
		"\u0242\u0001\u0000\u0000\u0000\u024c\u0245\u0001\u0000\u0000\u0000\u024c"+
		"\u0249\u0001\u0000\u0000\u0000\u024d\u0250\u0001\u0000\u0000\u0000\u024e"+
		"\u024c\u0001\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000\u0000\u024f"+
		"\u0251\u0001\u0000\u0000\u0000\u0250\u024e\u0001\u0000\u0000\u0000\u0251"+
		"\u0254\u0003Z-\u0000\u0252\u0253\u0005Q\u0000\u0000\u0253\u0255\u0003"+
		"R)\u0000\u0254\u0252\u0001\u0000\u0000\u0000\u0254\u0255\u0001\u0000\u0000"+
		"\u0000\u0255\u0256\u0001\u0000\u0000\u0000\u0256\u0257\u0005L\u0000\u0000"+
		"\u0257;\u0001\u0000\u0000\u0000\u0258\u0259\u0003H$\u0000\u0259\u025a"+
		"\u0005\r\u0000\u0000\u025a\u025b\u0003Z-\u0000\u025b\u025c\u0005Q\u0000"+
		"\u0000\u025c\u025d\u0003R)\u0000\u025d\u025e\u0005L\u0000\u0000\u025e"+
		"=\u0001\u0000\u0000\u0000\u025f\u0261\u0003H$\u0000\u0260\u0262\u0005"+
		"%\u0000\u0000\u0261\u0260\u0001\u0000\u0000\u0000\u0261\u0262\u0001\u0000"+
		"\u0000\u0000\u0262\u0264\u0001\u0000\u0000\u0000\u0263\u0265\u0003Z-\u0000"+
		"\u0264\u0263\u0001\u0000\u0000\u0000\u0264\u0265\u0001\u0000\u0000\u0000"+
		"\u0265?\u0001\u0000\u0000\u0000\u0266\u0267\u0005\u0018\u0000\u0000\u0267"+
		"\u0268\u0003Z-\u0000\u0268\u0271\u0005E\u0000\u0000\u0269\u026e\u0003"+
		">\u001f\u0000\u026a\u026b\u0005]\u0000\u0000\u026b\u026d\u0003>\u001f"+
		"\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026d\u0270\u0001\u0000\u0000"+
		"\u0000\u026e\u026c\u0001\u0000\u0000\u0000\u026e\u026f\u0001\u0000\u0000"+
		"\u0000\u026f\u0272\u0001\u0000\u0000\u0000\u0270\u026e\u0001\u0000\u0000"+
		"\u0000\u0271\u0269\u0001\u0000\u0000\u0000\u0271\u0272\u0001\u0000\u0000"+
		"\u0000\u0272\u0273\u0001\u0000\u0000\u0000\u0273\u0275\u0005F\u0000\u0000"+
		"\u0274\u0276\u0005\u0004\u0000\u0000\u0275\u0274\u0001\u0000\u0000\u0000"+
		"\u0275\u0276\u0001\u0000\u0000\u0000\u0276\u0277\u0001\u0000\u0000\u0000"+
		"\u0277\u0278\u0005L\u0000\u0000\u0278A\u0001\u0000\u0000\u0000\u0279\u027b"+
		"\u0003H$\u0000\u027a\u027c\u0003Z-\u0000\u027b\u027a\u0001\u0000\u0000"+
		"\u0000\u027b\u027c\u0001\u0000\u0000\u0000\u027cC\u0001\u0000\u0000\u0000"+
		"\u027d\u027e\u0005\u0016\u0000\u0000\u027e\u027f\u0003Z-\u0000\u027f\u0288"+
		"\u0005E\u0000\u0000\u0280\u0285\u0003B!\u0000\u0281\u0282\u0005]\u0000"+
		"\u0000\u0282\u0284\u0003B!\u0000\u0283\u0281\u0001\u0000\u0000\u0000\u0284"+
		"\u0287\u0001\u0000\u0000\u0000\u0285\u0283\u0001\u0000\u0000\u0000\u0285"+
		"\u0286\u0001\u0000\u0000\u0000\u0286\u0289\u0001\u0000\u0000\u0000\u0287"+
		"\u0285\u0001\u0000\u0000\u0000\u0288\u0280\u0001\u0000\u0000\u0000\u0288"+
		"\u0289\u0001\u0000\u0000\u0000\u0289\u028a\u0001\u0000\u0000\u0000\u028a"+
		"\u028b\u0005F\u0000\u0000\u028b\u028c\u0005L\u0000\u0000\u028cE\u0001"+
		"\u0000\u0000\u0000\u028d\u028e\u0005A\u0000\u0000\u028e\u028f\u0003\u001c"+
		"\u000e\u0000\u028f\u0292\u0005\u001f\u0000\u0000\u0290\u0293\u0005h\u0000"+
		"\u0000\u0291\u0293\u0003H$\u0000\u0292\u0290\u0001\u0000\u0000\u0000\u0292"+
		"\u0291\u0001\u0000\u0000\u0000\u0293\u0294\u0001\u0000\u0000\u0000\u0294"+
		"\u0295\u0005L\u0000\u0000\u0295G\u0001\u0000\u0000\u0000\u0296\u0297\u0006"+
		"$\uffff\uffff\u0000\u0297\u029c\u0003J%\u0000\u0298\u029c\u0003L&\u0000"+
		"\u0299\u029c\u0003\u0090H\u0000\u029a\u029c\u0003\u001c\u000e\u0000\u029b"+
		"\u0296\u0001\u0000\u0000\u0000\u029b\u0298\u0001\u0000\u0000\u0000\u029b"+
		"\u0299\u0001\u0000\u0000\u0000\u029b\u029a\u0001\u0000\u0000\u0000\u029c"+
		"\u02a5\u0001\u0000\u0000\u0000\u029d\u029e\n\u0001\u0000\u0000\u029e\u02a0"+
		"\u0005G\u0000\u0000\u029f\u02a1\u0003R)\u0000\u02a0\u029f\u0001\u0000"+
		"\u0000\u0000\u02a0\u02a1\u0001\u0000\u0000\u0000\u02a1\u02a2\u0001\u0000"+
		"\u0000\u0000\u02a2\u02a4\u0005H\u0000\u0000\u02a3\u029d\u0001\u0000\u0000"+
		"\u0000\u02a4\u02a7\u0001\u0000\u0000\u0000\u02a5\u02a3\u0001\u0000\u0000"+
		"\u0000\u02a5\u02a6\u0001\u0000\u0000\u0000\u02a6I\u0001\u0000\u0000\u0000"+
		"\u02a7\u02a5\u0001\u0000\u0000\u0000\u02a8\u02b5\u0005\u0005\u0000\u0000"+
		"\u02a9\u02aa\u0004%\u001a\u0001\u02aa\u02ab\u0005\u0005\u0000\u0000\u02ab"+
		"\u02b5\u00050\u0000\u0000\u02ac\u02b5\u0005\b\u0000\u0000\u02ad\u02b5"+
		"\u00059\u0000\u0000\u02ae\u02b5\u0005\n\u0000\u0000\u02af\u02b5\u0005"+
		"7\u0000\u0000\u02b0\u02b5\u0005@\u0000\u0000\u02b1\u02b5\u0005\u001e\u0000"+
		"\u0000\u02b2\u02b5\u0005\u001c\u0000\u0000\u02b3\u02b5\u0005>\u0000\u0000"+
		"\u02b4\u02a8\u0001\u0000\u0000\u0000\u02b4\u02a9\u0001\u0000\u0000\u0000"+
		"\u02b4\u02ac\u0001\u0000\u0000\u0000\u02b4\u02ad\u0001\u0000\u0000\u0000"+
		"\u02b4\u02ae\u0001\u0000\u0000\u0000\u02b4\u02af\u0001\u0000\u0000\u0000"+
		"\u02b4\u02b0\u0001\u0000\u0000\u0000\u02b4\u02b1\u0001\u0000\u0000\u0000"+
		"\u02b4\u02b2\u0001\u0000\u0000\u0000\u02b4\u02b3\u0001\u0000\u0000\u0000"+
		"\u02b5K\u0001\u0000\u0000\u0000\u02b6\u02b7\u0005 \u0000\u0000\u02b7\u02b9"+
		"\u0005E\u0000\u0000\u02b8\u02ba\u0003\"\u0011\u0000\u02b9\u02b8\u0001"+
		"\u0000\u0000\u0000\u02b9\u02ba\u0001\u0000\u0000\u0000\u02ba\u02bb\u0001"+
		"\u0000\u0000\u0000\u02bb\u02c6\u0005F\u0000\u0000\u02bc\u02bd\u0004&\u001b"+
		"\u0001\u02bd\u02be\u0003 \u0010\u0000\u02be\u02bf\u0006&\uffff\uffff\u0000"+
		"\u02bf\u02c5\u0001\u0000\u0000\u0000\u02c0\u02c1\u0004&\u001c\u0001\u02c1"+
		"\u02c2\u0003(\u0014\u0000\u02c2\u02c3\u0006&\uffff\uffff\u0000\u02c3\u02c5"+
		"\u0001\u0000\u0000\u0000\u02c4\u02bc\u0001\u0000\u0000\u0000\u02c4\u02c0"+
		"\u0001\u0000\u0000\u0000\u02c5\u02c8\u0001\u0000\u0000\u0000\u02c6\u02c4"+
		"\u0001\u0000\u0000\u0000\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7\u02ce"+
		"\u0001\u0000\u0000\u0000\u02c8\u02c6\u0001\u0000\u0000\u0000\u02c9\u02ca"+
		"\u00056\u0000\u0000\u02ca\u02cb\u0005E\u0000\u0000\u02cb\u02cc\u0003\""+
		"\u0011\u0000\u02cc\u02cd\u0005F\u0000\u0000\u02cd\u02cf\u0001\u0000\u0000"+
		"\u0000\u02ce\u02c9\u0001\u0000\u0000\u0000\u02ce\u02cf\u0001\u0000\u0000"+
		"\u0000\u02cfM\u0001\u0000\u0000\u0000\u02d0\u02d2\u0003H$\u0000\u02d1"+
		"\u02d3\u0003P(\u0000\u02d2\u02d1\u0001\u0000\u0000\u0000\u02d2\u02d3\u0001"+
		"\u0000\u0000\u0000\u02d3\u02d4\u0001\u0000\u0000\u0000\u02d4\u02d5\u0003"+
		"Z-\u0000\u02d5O\u0001\u0000\u0000\u0000\u02d6\u02d7\u0007\u0002\u0000"+
		"\u0000\u02d7Q\u0001\u0000\u0000\u0000\u02d8\u02d9\u0006)\uffff\uffff\u0000"+
		"\u02d9\u02da\u00050\u0000\u0000\u02da\u02ec\u0003\u001a\r\u0000\u02db"+
		"\u02dc\u0005=\u0000\u0000\u02dc\u02dd\u0005E\u0000\u0000\u02dd\u02de\u0003"+
		"H$\u0000\u02de\u02df\u0005F\u0000\u0000\u02df\u02ec\u0001\u0000\u0000"+
		"\u0000\u02e0\u02e1\u0007\u0003\u0000\u0000\u02e1\u02ec\u0003R)\u0013\u02e2"+
		"\u02e3\u0005-\u0000\u0000\u02e3\u02ec\u0003H$\u0000\u02e4\u02ec\u0003"+
		"V+\u0000\u02e5\u02ec\u0003X,\u0000\u02e6\u02ea\u0003Z-\u0000\u02e7\u02ea"+
		"\u0003\\.\u0000\u02e8\u02ea\u0003J%\u0000\u02e9\u02e6\u0001\u0000\u0000"+
		"\u0000\u02e9\u02e7\u0001\u0000\u0000\u0000\u02e9\u02e8\u0001\u0000\u0000"+
		"\u0000\u02ea\u02ec\u0001\u0000\u0000\u0000\u02eb\u02d8\u0001\u0000\u0000"+
		"\u0000\u02eb\u02db\u0001\u0000\u0000\u0000\u02eb\u02e0\u0001\u0000\u0000"+
		"\u0000\u02eb\u02e2\u0001\u0000\u0000\u0000\u02eb\u02e4\u0001\u0000\u0000"+
		"\u0000\u02eb\u02e5\u0001\u0000\u0000\u0000\u02eb\u02e9\u0001\u0000\u0000"+
		"\u0000\u02ec\u0342\u0001\u0000\u0000\u0000\u02ed\u02ee\n\u0011\u0000\u0000"+
		"\u02ee\u02ef\u0005k\u0000\u0000\u02ef\u0341\u0003R)\u0011\u02f0\u02f1"+
		"\n\u0010\u0000\u0000\u02f1\u02f2\u0007\u0004\u0000\u0000\u02f2\u0341\u0003"+
		"R)\u0011\u02f3\u02f4\n\u000f\u0000\u0000\u02f4\u02f5\u0007\u0005\u0000"+
		"\u0000\u02f5\u0341\u0003R)\u0010\u02f6\u02f7\n\u000e\u0000\u0000\u02f7"+
		"\u02f8\u0007\u0006\u0000\u0000\u02f8\u0341\u0003R)\u000f\u02f9\u02fa\n"+
		"\r\u0000\u0000\u02fa\u02fb\u0005b\u0000\u0000\u02fb\u0341\u0003R)\u000e"+
		"\u02fc\u02fd\n\f\u0000\u0000\u02fd\u02fe\u0005a\u0000\u0000\u02fe\u0341"+
		"\u0003R)\r\u02ff\u0300\n\u000b\u0000\u0000\u0300\u0301\u0005`\u0000\u0000"+
		"\u0301\u0341\u0003R)\f\u0302\u0303\n\n\u0000\u0000\u0303\u0304\u0007\u0007"+
		"\u0000\u0000\u0304\u0341\u0003R)\u000b\u0305\u0306\n\t\u0000\u0000\u0306"+
		"\u0307\u0007\b\u0000\u0000\u0307\u0341\u0003R)\n\u0308\u0309\n\b\u0000"+
		"\u0000\u0309\u030a\u0005_\u0000\u0000\u030a\u0341\u0003R)\t\u030b\u030c"+
		"\n\u0007\u0000\u0000\u030c\u030d\u0005^\u0000\u0000\u030d\u0341\u0003"+
		"R)\b\u030e\u030f\n\u0005\u0000\u0000\u030f\u0310\u0003T*\u0000\u0310\u0311"+
		"\u0003R)\u0005\u0311\u0341\u0001\u0000\u0000\u0000\u0312\u0313\n\u0019"+
		"\u0000\u0000\u0313\u0315\u0005G\u0000\u0000\u0314\u0316\u0003R)\u0000"+
		"\u0315\u0314\u0001\u0000\u0000\u0000\u0315\u0316\u0001\u0000\u0000\u0000"+
		"\u0316\u0317\u0001\u0000\u0000\u0000\u0317\u0341\u0005H\u0000\u0000\u0318"+
		"\u0319\n\u0018\u0000\u0000\u0319\u031b\u0005G\u0000\u0000\u031a\u031c"+
		"\u0003R)\u0000\u031b\u031a\u0001\u0000\u0000\u0000\u031b\u031c\u0001\u0000"+
		"\u0000\u0000\u031c\u031d\u0001\u0000\u0000\u0000\u031d\u031f\u0005K\u0000"+
		"\u0000\u031e\u0320\u0003R)\u0000\u031f\u031e\u0001\u0000\u0000\u0000\u031f"+
		"\u0320\u0001\u0000\u0000\u0000\u0320\u0321\u0001\u0000\u0000\u0000\u0321"+
		"\u0341\u0005H\u0000\u0000\u0322\u0323\n\u0017\u0000\u0000\u0323\u0326"+
		"\u0005M\u0000\u0000\u0324\u0327\u0003Z-\u0000\u0325\u0327\u0005\u0005"+
		"\u0000\u0000\u0326\u0324\u0001\u0000\u0000\u0000\u0326\u0325\u0001\u0000"+
		"\u0000\u0000\u0327\u0341\u0001\u0000\u0000\u0000\u0328\u0335\n\u0016\u0000"+
		"\u0000\u0329\u0332\u0005I\u0000\u0000\u032a\u032f\u0003\u0018\f\u0000"+
		"\u032b\u032c\u0005]\u0000\u0000\u032c\u032e\u0003\u0018\f\u0000\u032d"+
		"\u032b\u0001\u0000\u0000\u0000\u032e\u0331\u0001\u0000\u0000\u0000\u032f"+
		"\u032d\u0001\u0000\u0000\u0000\u032f\u0330\u0001\u0000\u0000\u0000\u0330"+
		"\u0333\u0001\u0000\u0000\u0000\u0331\u032f\u0001\u0000\u0000\u0000\u0332"+
		"\u032a\u0001\u0000\u0000\u0000\u0332\u0333\u0001\u0000\u0000\u0000\u0333"+
		"\u0334\u0001\u0000\u0000\u0000\u0334\u0336\u0005J\u0000\u0000\u0335\u0329"+
		"\u0001\u0000\u0000\u0000\u0335\u0336\u0001\u0000\u0000\u0000\u0336\u0337"+
		"\u0001\u0000\u0000\u0000\u0337\u0341\u0003\u001a\r\u0000\u0338\u0339\n"+
		"\u0012\u0000\u0000\u0339\u0341\u0007\t\u0000\u0000\u033a\u033b\n\u0006"+
		"\u0000\u0000\u033b\u033c\u0005N\u0000\u0000\u033c\u033d\u0003R)\u0000"+
		"\u033d\u033e\u0005K\u0000\u0000\u033e\u033f\u0003R)\u0000\u033f\u0341"+
		"\u0001\u0000\u0000\u0000\u0340\u02ed\u0001\u0000\u0000\u0000\u0340\u02f0"+
		"\u0001\u0000\u0000\u0000\u0340\u02f3\u0001\u0000\u0000\u0000\u0340\u02f6"+
		"\u0001\u0000\u0000\u0000\u0340\u02f9\u0001\u0000\u0000\u0000\u0340\u02fc"+
		"\u0001\u0000\u0000\u0000\u0340\u02ff\u0001\u0000\u0000\u0000\u0340\u0302"+
		"\u0001\u0000\u0000\u0000\u0340\u0305\u0001\u0000\u0000\u0000\u0340\u0308"+
		"\u0001\u0000\u0000\u0000\u0340\u030b\u0001\u0000\u0000\u0000\u0340\u030e"+
		"\u0001\u0000\u0000\u0000\u0340\u0312\u0001\u0000\u0000\u0000\u0340\u0318"+
		"\u0001\u0000\u0000\u0000\u0340\u0322\u0001\u0000\u0000\u0000\u0340\u0328"+
		"\u0001\u0000\u0000\u0000\u0340\u0338\u0001\u0000\u0000\u0000\u0340\u033a"+
		"\u0001\u0000\u0000\u0000\u0341\u0344\u0001\u0000\u0000\u0000\u0342\u0340"+
		"\u0001\u0000\u0000\u0000\u0342\u0343\u0001\u0000\u0000\u0000\u0343S\u0001"+
		"\u0000\u0000\u0000\u0344\u0342\u0001\u0000\u0000\u0000\u0345\u0346\u0007"+
		"\n\u0000\u0000\u0346U\u0001\u0000\u0000\u0000\u0347\u0349\u0005E\u0000"+
		"\u0000\u0348\u034a\u0003R)\u0000\u0349\u0348\u0001\u0000\u0000\u0000\u0349"+
		"\u034a\u0001\u0000\u0000\u0000\u034a\u0351\u0001\u0000\u0000\u0000\u034b"+
		"\u034d\u0005]\u0000\u0000\u034c\u034e\u0003R)\u0000\u034d\u034c\u0001"+
		"\u0000\u0000\u0000\u034d\u034e\u0001\u0000\u0000\u0000\u034e\u0350\u0001"+
		"\u0000\u0000\u0000\u034f\u034b\u0001\u0000\u0000\u0000\u0350\u0353\u0001"+
		"\u0000\u0000\u0000\u0351\u034f\u0001\u0000\u0000\u0000\u0351\u0352\u0001"+
		"\u0000\u0000\u0000\u0352\u0354\u0001\u0000\u0000\u0000\u0353\u0351\u0001"+
		"\u0000\u0000\u0000\u0354\u0355\u0005F\u0000\u0000\u0355W\u0001\u0000\u0000"+
		"\u0000\u0356\u0357\u0005G\u0000\u0000\u0357\u035c\u0003R)\u0000\u0358"+
		"\u0359\u0005]\u0000\u0000\u0359\u035b\u0003R)\u0000\u035a\u0358\u0001"+
		"\u0000\u0000\u0000\u035b\u035e\u0001\u0000\u0000\u0000\u035c\u035a\u0001"+
		"\u0000\u0000\u0000\u035c\u035d\u0001\u0000\u0000\u0000\u035d\u035f\u0001"+
		"\u0000\u0000\u0000\u035e\u035c\u0001\u0000\u0000\u0000\u035f\u0360\u0005"+
		"H\u0000\u0000\u0360Y\u0001\u0000\u0000\u0000\u0361\u0362\u0007\u000b\u0000"+
		"\u0000\u0362[\u0001\u0000\u0000\u0000\u0363\u0369\u0003`0\u0000\u0364"+
		"\u0369\u0003f3\u0000\u0365\u0369\u0003^/\u0000\u0366\u0369\u0003b1\u0000"+
		"\u0367\u0369\u0003d2\u0000\u0368\u0363\u0001\u0000\u0000\u0000\u0368\u0364"+
		"\u0001\u0000\u0000\u0000\u0368\u0365\u0001\u0000\u0000\u0000\u0368\u0366"+
		"\u0001\u0000\u0000\u0000\u0368\u0367\u0001\u0000\u0000\u0000\u0369]\u0001"+
		"\u0000\u0000\u0000\u036a\u036b\u0007\f\u0000\u0000\u036b_\u0001\u0000"+
		"\u0000\u0000\u036c\u036e\u0007\r\u0000\u0000\u036d\u036c\u0001\u0000\u0000"+
		"\u0000\u036e\u036f\u0001\u0000\u0000\u0000\u036f\u036d\u0001\u0000\u0000"+
		"\u0000\u036f\u0370\u0001\u0000\u0000\u0000\u0370a\u0001\u0000\u0000\u0000"+
		"\u0371\u0373\u0005{\u0000\u0000\u0372\u0371\u0001\u0000\u0000\u0000\u0373"+
		"\u0374\u0001\u0000\u0000\u0000\u0374\u0372\u0001\u0000\u0000\u0000\u0374"+
		"\u0375\u0001\u0000\u0000\u0000\u0375c\u0001\u0000\u0000\u0000\u0376\u0378"+
		"\u0005z\u0000\u0000\u0377\u0376\u0001\u0000\u0000\u0000\u0378\u0379\u0001"+
		"\u0000\u0000\u0000\u0379\u0377\u0001\u0000\u0000\u0000\u0379\u037a\u0001"+
		"\u0000\u0000\u0000\u037ae\u0001\u0000\u0000\u0000\u037b\u037d\u0007\u000e"+
		"\u0000\u0000\u037c\u037e\u0005.\u0000\u0000\u037d\u037c\u0001\u0000\u0000"+
		"\u0000\u037d\u037e\u0001\u0000\u0000\u0000\u037eg\u0001\u0000\u0000\u0000"+
		"\u037f\u0384\u0005I\u0000\u0000\u0380\u0383\u0003l6\u0000\u0381\u0383"+
		"\u0003j5\u0000\u0382\u0380\u0001\u0000\u0000\u0000\u0382\u0381\u0001\u0000"+
		"\u0000\u0000\u0383\u0386\u0001\u0000\u0000\u0000\u0384\u0382\u0001\u0000"+
		"\u0000\u0000\u0384\u0385\u0001\u0000\u0000\u0000\u0385\u0387\u0001\u0000"+
		"\u0000\u0000\u0386\u0384\u0001\u0000\u0000\u0000\u0387\u0388\u0005J\u0000"+
		"\u0000\u0388i\u0001\u0000\u0000\u0000\u0389\u038a\u0005?\u0000\u0000\u038a"+
		"\u038b\u0003h4\u0000\u038bk\u0001\u0000\u0000\u0000\u038c\u039a\u0003"+
		"h4\u0000\u038d\u039a\u0003n7\u0000\u038e\u039a\u0003p8\u0000\u038f\u039a"+
		"\u0003r9\u0000\u0390\u039a\u0003t:\u0000\u0391\u039a\u0003v;\u0000\u0392"+
		"\u039a\u0003x<\u0000\u0393\u039a\u0003z=\u0000\u0394\u039a\u0003|>\u0000"+
		"\u0395\u039a\u0003\u0080@\u0000\u0396\u039a\u0003\u0082A\u0000\u0397\u039a"+
		"\u0003\u0084B\u0000\u0398\u039a\u0003\u0086C\u0000\u0399\u038c\u0001\u0000"+
		"\u0000\u0000\u0399\u038d\u0001\u0000\u0000\u0000\u0399\u038e\u0001\u0000"+
		"\u0000\u0000\u0399\u038f\u0001\u0000\u0000\u0000\u0399\u0390\u0001\u0000"+
		"\u0000\u0000\u0399\u0391\u0001\u0000\u0000\u0000\u0399\u0392\u0001\u0000"+
		"\u0000\u0000\u0399\u0393\u0001\u0000\u0000\u0000\u0399\u0394\u0001\u0000"+
		"\u0000\u0000\u0399\u0395\u0001\u0000\u0000\u0000\u0399\u0396\u0001\u0000"+
		"\u0000\u0000\u0399\u0397\u0001\u0000\u0000\u0000\u0399\u0398\u0001\u0000"+
		"\u0000\u0000\u039am\u0001\u0000\u0000\u0000\u039b\u039e\u0003\u008cF\u0000"+
		"\u039c\u039e\u0003\u008eG\u0000\u039d\u039b\u0001\u0000\u0000\u0000\u039d"+
		"\u039c\u0001\u0000\u0000\u0000\u039eo\u0001\u0000\u0000\u0000\u039f\u03a0"+
		"\u0005\"\u0000\u0000\u03a0\u03a1\u0005E\u0000\u0000\u03a1\u03a2\u0003"+
		"R)\u0000\u03a2\u03a3\u0005F\u0000\u0000\u03a3\u03a6\u0003l6\u0000\u03a4"+
		"\u03a5\u0005\u0013\u0000\u0000\u03a5\u03a7\u0003l6\u0000\u03a6\u03a4\u0001"+
		"\u0000\u0000\u0000\u03a6\u03a7\u0001\u0000\u0000\u0000\u03a7q\u0001\u0000"+
		"\u0000\u0000\u03a8\u03a9\u0005\u001f\u0000\u0000\u03a9\u03ac\u0005E\u0000"+
		"\u0000\u03aa\u03ad\u0003n7\u0000\u03ab\u03ad\u0005L\u0000\u0000\u03ac"+
		"\u03aa\u0001\u0000\u0000\u0000\u03ac\u03ab\u0001\u0000\u0000\u0000\u03ad"+
		"\u03b0\u0001\u0000\u0000\u0000\u03ae\u03b1\u0003\u008eG\u0000\u03af\u03b1"+
		"\u0005L\u0000\u0000\u03b0\u03ae\u0001\u0000\u0000\u0000\u03b0\u03af\u0001"+
		"\u0000\u0000\u0000\u03b1\u03b3\u0001\u0000\u0000\u0000\u03b2\u03b4\u0003"+
		"R)\u0000\u03b3\u03b2\u0001\u0000\u0000\u0000\u03b3\u03b4\u0001\u0000\u0000"+
		"\u0000\u03b4\u03b5\u0001\u0000\u0000\u0000\u03b5\u03b6\u0005F\u0000\u0000"+
		"\u03b6\u03b7\u0003l6\u0000\u03b7s\u0001\u0000\u0000\u0000\u03b8\u03b9"+
		"\u0005D\u0000\u0000\u03b9\u03ba\u0005E\u0000\u0000\u03ba\u03bb\u0003R"+
		")\u0000\u03bb\u03bc\u0005F\u0000\u0000\u03bc\u03bd\u0003l6\u0000\u03bd"+
		"u\u0001\u0000\u0000\u0000\u03be\u03bf\u0005\u0012\u0000\u0000\u03bf\u03c0"+
		"\u0003l6\u0000\u03c0\u03c1\u0005D\u0000\u0000\u03c1\u03c2\u0005E\u0000"+
		"\u0000\u03c2\u03c3\u0003R)\u0000\u03c3\u03c4\u0005F\u0000\u0000\u03c4"+
		"\u03c5\u0005L\u0000\u0000\u03c5w\u0001\u0000\u0000\u0000\u03c6\u03c7\u0005"+
		"\u000f\u0000\u0000\u03c7\u03c8\u0005L\u0000\u0000\u03c8y\u0001\u0000\u0000"+
		"\u0000\u03c9\u03ca\u0005\t\u0000\u0000\u03ca\u03cb\u0005L\u0000\u0000"+
		"\u03cb{\u0001\u0000\u0000\u0000\u03cc\u03cd\u0005<\u0000\u0000\u03cd\u03d3"+
		"\u0003R)\u0000\u03ce\u03cf\u00056\u0000\u0000\u03cf\u03d0\u0005E\u0000"+
		"\u0000\u03d0\u03d1\u0003\"\u0011\u0000\u03d1\u03d2\u0005F\u0000\u0000"+
		"\u03d2\u03d4\u0001\u0000\u0000\u0000\u03d3\u03ce\u0001\u0000\u0000\u0000"+
		"\u03d3\u03d4\u0001\u0000\u0000\u0000\u03d4\u03d5\u0001\u0000\u0000\u0000"+
		"\u03d5\u03d7\u0003h4\u0000\u03d6\u03d8\u0003~?\u0000\u03d7\u03d6\u0001"+
		"\u0000\u0000\u0000\u03d8\u03d9\u0001\u0000\u0000\u0000\u03d9\u03d7\u0001"+
		"\u0000\u0000\u0000\u03d9\u03da\u0001\u0000\u0000\u0000\u03da}\u0001\u0000"+
		"\u0000\u0000\u03db\u03e3\u0005\f\u0000\u0000\u03dc\u03de\u0003Z-\u0000"+
		"\u03dd\u03dc\u0001\u0000\u0000\u0000\u03dd\u03de\u0001\u0000\u0000\u0000"+
		"\u03de\u03df\u0001\u0000\u0000\u0000\u03df\u03e0\u0005E\u0000\u0000\u03e0"+
		"\u03e1\u0003\"\u0011\u0000\u03e1\u03e2\u0005F\u0000\u0000\u03e2\u03e4"+
		"\u0001\u0000\u0000\u0000\u03e3\u03dd\u0001\u0000\u0000\u0000\u03e3\u03e4"+
		"\u0001\u0000\u0000\u0000\u03e4\u03e5\u0001\u0000\u0000\u0000\u03e5\u03e6"+
		"\u0003h4\u0000\u03e6\u007f\u0001\u0000\u0000\u0000\u03e7\u03e9\u00055"+
		"\u0000\u0000\u03e8\u03ea\u0003R)\u0000\u03e9\u03e8\u0001\u0000\u0000\u0000"+
		"\u03e9\u03ea\u0001\u0000\u0000\u0000\u03ea\u03eb\u0001\u0000\u0000\u0000"+
		"\u03eb\u03ec\u0005L\u0000\u0000\u03ec\u0081\u0001\u0000\u0000\u0000\u03ed"+
		"\u03ee\u0005\u0014\u0000\u0000\u03ee\u03ef\u0003R)\u0000\u03ef\u03f0\u0003"+
		"\u001a\r\u0000\u03f0\u03f1\u0005L\u0000\u0000\u03f1\u0083\u0001\u0000"+
		"\u0000\u0000\u03f2\u03f3\u0005\u0017\u0000\u0000\u03f3\u03f4\u0003R)\u0000"+
		"\u03f4\u03f5\u0003\u001a\r\u0000\u03f5\u03f6\u0005L\u0000\u0000\u03f6"+
		"\u0085\u0001\u0000\u0000\u0000\u03f7\u03f9\u0005\u0007\u0000\u0000\u03f8"+
		"\u03fa\u0005\u0082\u0000\u0000\u03f9\u03f8\u0001\u0000\u0000\u0000\u03f9"+
		"\u03fa\u0001\u0000\u0000\u0000\u03fa\u03fb\u0001\u0000\u0000\u0000\u03fb"+
		"\u03ff\u0005\u0083\u0000\u0000\u03fc\u03fe\u0003\u0094J\u0000\u03fd\u03fc"+
		"\u0001\u0000\u0000\u0000\u03fe\u0401\u0001\u0000\u0000\u0000\u03ff\u03fd"+
		"\u0001\u0000\u0000\u0000\u03ff\u0400\u0001\u0000\u0000\u0000\u0400\u0402"+
		"\u0001\u0000\u0000\u0000\u0401\u03ff\u0001\u0000\u0000\u0000\u0402\u0403"+
		"\u0005\u0096\u0000\u0000\u0403\u0087\u0001\u0000\u0000\u0000\u0404\u0409"+
		"\u0003N\'\u0000\u0405\u0406\u0005]\u0000\u0000\u0406\u0408\u0003N\'\u0000"+
		"\u0407\u0405\u0001\u0000\u0000\u0000\u0408\u040b\u0001\u0000\u0000\u0000"+
		"\u0409\u0407\u0001\u0000\u0000\u0000\u0409\u040a\u0001\u0000\u0000\u0000"+
		"\u040a\u0089\u0001\u0000\u0000\u0000\u040b\u0409\u0001\u0000\u0000\u0000"+
		"\u040c\u0410\u0005E\u0000\u0000\u040d\u040f\u0005]\u0000\u0000\u040e\u040d"+
		"\u0001\u0000\u0000\u0000\u040f\u0412\u0001\u0000\u0000\u0000\u0410\u040e"+
		"\u0001\u0000\u0000\u0000\u0410\u0411\u0001\u0000\u0000\u0000\u0411\u0413"+
		"\u0001\u0000\u0000\u0000\u0412\u0410\u0001\u0000\u0000\u0000\u0413\u0414"+
		"\u0003N\'\u0000\u0414\u041b\u0001\u0000\u0000\u0000\u0415\u0417\u0005"+
		"]\u0000\u0000\u0416\u0418\u0003N\'\u0000\u0417\u0416\u0001\u0000\u0000"+
		"\u0000\u0417\u0418\u0001\u0000\u0000\u0000\u0418\u041a\u0001\u0000\u0000"+
		"\u0000\u0419\u0415\u0001\u0000\u0000\u0000\u041a\u041d\u0001\u0000\u0000"+
		"\u0000\u041b\u0419\u0001\u0000\u0000\u0000\u041b\u041c\u0001\u0000\u0000"+
		"\u0000\u041c\u041e\u0001\u0000\u0000\u0000\u041d\u041b\u0001\u0000\u0000"+
		"\u0000\u041e\u041f\u0005F\u0000\u0000\u041f\u008b\u0001\u0000\u0000\u0000"+
		"\u0420\u0423\u0003N\'\u0000\u0421\u0422\u0005Q\u0000\u0000\u0422\u0424"+
		"\u0003R)\u0000\u0423\u0421\u0001\u0000\u0000\u0000\u0423\u0424\u0001\u0000"+
		"\u0000\u0000\u0424\u042a\u0001\u0000\u0000\u0000\u0425\u0426\u0003\u008a"+
		"E\u0000\u0426\u0427\u0005Q\u0000\u0000\u0427\u0428\u0003R)\u0000\u0428"+
		"\u042a\u0001\u0000\u0000\u0000\u0429\u0420\u0001\u0000\u0000\u0000\u0429"+
		"\u0425\u0001\u0000\u0000\u0000\u042a\u042b\u0001\u0000\u0000\u0000\u042b"+
		"\u042c\u0005L\u0000\u0000\u042c\u008d\u0001\u0000\u0000\u0000\u042d\u042e"+
		"\u0003R)\u0000\u042e\u042f\u0005L\u0000\u0000\u042f\u008f\u0001\u0000"+
		"\u0000\u0000\u0430\u0431\u0005*\u0000\u0000\u0431\u0432\u0005E\u0000\u0000"+
		"\u0432\u0433\u0003\u0092I\u0000\u0433\u0434\u0005O\u0000\u0000\u0434\u0435"+
		"\u0003H$\u0000\u0435\u0436\u0005F\u0000\u0000\u0436\u0091\u0001\u0000"+
		"\u0000\u0000\u0437\u043a\u0003J%\u0000\u0438\u043a\u0003\u001c\u000e\u0000"+
		"\u0439\u0437\u0001\u0000\u0000\u0000\u0439\u0438\u0001\u0000\u0000\u0000"+
		"\u043a\u0093\u0001\u0000\u0000\u0000\u043b\u0447\u0003\u0096K\u0000\u043c"+
		"\u0447\u0003\u0098L\u0000\u043d\u0447\u0003\u009aM\u0000\u043e\u0447\u0003"+
		"\u00a8T\u0000\u043f\u0447\u0003\u009cN\u0000\u0440\u0447\u0003\u009eO"+
		"\u0000\u0441\u0447\u0003\u00a2Q\u0000\u0442\u0447\u0005\u008f\u0000\u0000"+
		"\u0443\u0447\u0005\u0087\u0000\u0000\u0444\u0447\u0005\u0089\u0000\u0000"+
		"\u0445\u0447\u0003\u00a4R\u0000\u0446\u043b\u0001\u0000\u0000\u0000\u0446"+
		"\u043c\u0001\u0000\u0000\u0000\u0446\u043d\u0001\u0000\u0000\u0000\u0446"+
		"\u043e\u0001\u0000\u0000\u0000\u0446\u043f\u0001\u0000\u0000\u0000\u0446"+
		"\u0440\u0001\u0000\u0000\u0000\u0446\u0441\u0001\u0000\u0000\u0000\u0446"+
		"\u0442\u0001\u0000\u0000\u0000\u0446\u0443\u0001\u0000\u0000\u0000\u0446"+
		"\u0444\u0001\u0000\u0000\u0000\u0446\u0445\u0001\u0000\u0000\u0000\u0447"+
		"\u0095\u0001\u0000\u0000\u0000\u0448\u044c\u0005\u0095\u0000\u0000\u0449"+
		"\u044b\u0003\u0094J\u0000\u044a\u0449\u0001\u0000\u0000\u0000\u044b\u044e"+
		"\u0001\u0000\u0000\u0000\u044c\u044a\u0001\u0000\u0000\u0000\u044c\u044d"+
		"\u0001\u0000\u0000\u0000\u044d\u044f\u0001\u0000\u0000\u0000\u044e\u044c"+
		"\u0001\u0000\u0000\u0000\u044f\u0450\u0005\u0096\u0000\u0000\u0450\u0097"+
		"\u0001\u0000\u0000\u0000\u0451\u0452\u0005\u0090\u0000\u0000\u0452\u0455"+
		"\u0005\u009d\u0000\u0000\u0453\u0454\u0005\u0099\u0000\u0000\u0454\u0456"+
		"\u0003\u00aeW\u0000\u0455\u0453\u0001\u0000\u0000\u0000\u0455\u0456\u0001"+
		"\u0000\u0000\u0000\u0456\u0465\u0001\u0000\u0000\u0000\u0457\u0458\u0005"+
		"\u0090\u0000\u0000\u0458\u045d\u0005\u009d\u0000\u0000\u0459\u045a\u0005"+
		"\u009b\u0000\u0000\u045a\u045c\u0005\u009d\u0000\u0000\u045b\u0459\u0001"+
		"\u0000\u0000\u0000\u045c\u045f\u0001\u0000\u0000\u0000\u045d\u045b\u0001"+
		"\u0000\u0000\u0000\u045d\u045e\u0001\u0000\u0000\u0000\u045e\u0462\u0001"+
		"\u0000\u0000\u0000\u045f\u045d\u0001\u0000\u0000\u0000\u0460\u0461\u0005"+
		"\u0099\u0000\u0000\u0461\u0463\u0003\u00a8T\u0000\u0462\u0460\u0001\u0000"+
		"\u0000\u0000\u0462\u0463\u0001\u0000\u0000\u0000\u0463\u0465\u0001\u0000"+
		"\u0000\u0000\u0464\u0451\u0001\u0000\u0000\u0000\u0464\u0457\u0001\u0000"+
		"\u0000\u0000\u0465\u0099\u0001\u0000\u0000\u0000\u0466\u0467\u0003\u00a6"+
		"S\u0000\u0467\u0468\u0005\u0099\u0000\u0000\u0468\u0469\u0003\u00aeW\u0000"+
		"\u0469\u0475\u0001\u0000\u0000\u0000\u046a\u046d\u0003\u00a6S\u0000\u046b"+
		"\u046c\u0005\u009b\u0000\u0000\u046c\u046e\u0003\u00a6S\u0000\u046d\u046b"+
		"\u0001\u0000\u0000\u0000\u046e\u046f\u0001\u0000\u0000\u0000\u046f\u046d"+
		"\u0001\u0000\u0000\u0000\u046f\u0470\u0001\u0000\u0000\u0000\u0470\u0471"+
		"\u0001\u0000\u0000\u0000\u0471\u0472\u0005\u0099\u0000\u0000\u0472\u0473"+
		"\u0003\u00a8T\u0000\u0473\u0475\u0001\u0000\u0000\u0000\u0474\u0466\u0001"+
		"\u0000\u0000\u0000\u0474\u046a\u0001\u0000\u0000\u0000\u0475\u009b\u0001"+
		"\u0000\u0000\u0000\u0476\u0477\u0005\u008e\u0000\u0000\u0477\u0478\u0003"+
		"\u00aeW\u0000\u0478\u0479\u0003\u0096K\u0000\u0479\u009d\u0001\u0000\u0000"+
		"\u0000\u047a\u047b\u0005\u008c\u0000\u0000\u047b\u047c\u0003\u0096K\u0000"+
		"\u047c\u047d\u0003\u00aeW\u0000\u047d\u047e\u0003\u0096K\u0000\u047e\u047f"+
		"\u0003\u0096K\u0000\u047f\u009f\u0001\u0000\u0000\u0000\u0480\u0481\u0005"+
		"\u0088\u0000\u0000\u0481\u0482\u0003\u00acV\u0000\u0482\u0483\u0003\u0096"+
		"K\u0000\u0483\u00a1\u0001\u0000\u0000\u0000\u0484\u0485\u0005\u0091\u0000"+
		"\u0000\u0485\u0491\u0003\u00aeW\u0000\u0486\u0488\u0003\u00a0P\u0000\u0487"+
		"\u0486\u0001\u0000\u0000\u0000\u0488\u0489\u0001\u0000\u0000\u0000\u0489"+
		"\u0487\u0001\u0000\u0000\u0000\u0489\u048a\u0001\u0000\u0000\u0000\u048a"+
		"\u048d\u0001\u0000\u0000\u0000\u048b\u048c\u0005\u008a\u0000\u0000\u048c"+
		"\u048e\u0003\u0096K\u0000\u048d\u048b\u0001\u0000\u0000\u0000\u048d\u048e"+
		"\u0001\u0000\u0000\u0000\u048e\u0492\u0001\u0000\u0000\u0000\u048f\u0490"+
		"\u0005\u008a\u0000\u0000\u0490\u0492\u0003\u0096K\u0000\u0491\u0487\u0001"+
		"\u0000\u0000\u0000\u0491\u048f\u0001\u0000\u0000\u0000\u0492\u00a3\u0001"+
		"\u0000\u0000\u0000\u0493\u0494\u0005\u008d\u0000\u0000\u0494\u0495\u0005"+
		"\u009d\u0000\u0000\u0495\u049e\u0005\u0097\u0000\u0000\u0496\u049b\u0005"+
		"\u009d\u0000\u0000\u0497\u0498\u0005\u009b\u0000\u0000\u0498\u049a\u0005"+
		"\u009d\u0000\u0000\u0499\u0497\u0001\u0000\u0000\u0000\u049a\u049d\u0001"+
		"\u0000\u0000\u0000\u049b\u0499\u0001\u0000\u0000\u0000\u049b\u049c\u0001"+
		"\u0000\u0000\u0000\u049c\u049f\u0001\u0000\u0000\u0000\u049d\u049b\u0001"+
		"\u0000\u0000\u0000\u049e\u0496\u0001\u0000\u0000\u0000\u049e\u049f\u0001"+
		"\u0000\u0000\u0000\u049f\u04a0\u0001\u0000\u0000\u0000\u04a0\u04aa\u0005"+
		"\u0098\u0000\u0000\u04a1\u04a2\u0005\u009c\u0000\u0000\u04a2\u04a7\u0005"+
		"\u009d\u0000\u0000\u04a3\u04a4\u0005\u009b\u0000\u0000\u04a4\u04a6\u0005"+
		"\u009d\u0000\u0000\u04a5\u04a3\u0001\u0000\u0000\u0000\u04a6\u04a9\u0001"+
		"\u0000\u0000\u0000\u04a7\u04a5\u0001\u0000\u0000\u0000\u04a7\u04a8\u0001"+
		"\u0000\u0000\u0000\u04a8\u04ab\u0001\u0000\u0000\u0000\u04a9\u04a7\u0001"+
		"\u0000\u0000\u0000\u04aa\u04a1\u0001\u0000\u0000\u0000\u04aa\u04ab\u0001"+
		"\u0000\u0000\u0000\u04ab\u04ac\u0001\u0000\u0000\u0000\u04ac\u04ad\u0003"+
		"\u0096K\u0000\u04ad\u00a5\u0001\u0000\u0000\u0000\u04ae\u04b3\u0005\u009d"+
		"\u0000\u0000\u04af\u04b0\u0005\u009a\u0000\u0000\u04b0\u04b2\u0005\u009d"+
		"\u0000\u0000\u04b1\u04af\u0001\u0000\u0000\u0000\u04b2\u04b5\u0001\u0000"+
		"\u0000\u0000\u04b3\u04b1\u0001\u0000\u0000\u0000\u04b3\u04b4\u0001\u0000"+
		"\u0000\u0000\u04b4\u00a7\u0001\u0000\u0000\u0000\u04b5\u04b3\u0001\u0000"+
		"\u0000\u0000\u04b6\u04b7\u0007\u000f\u0000\u0000\u04b7\u04c0\u0005\u0097"+
		"\u0000\u0000\u04b8\u04bd\u0003\u00aeW\u0000\u04b9\u04ba\u0005\u009b\u0000"+
		"\u0000\u04ba\u04bc\u0003\u00aeW\u0000\u04bb\u04b9\u0001\u0000\u0000\u0000"+
		"\u04bc\u04bf\u0001\u0000\u0000\u0000\u04bd\u04bb\u0001\u0000\u0000\u0000"+
		"\u04bd\u04be\u0001\u0000\u0000\u0000\u04be\u04c1\u0001\u0000\u0000\u0000"+
		"\u04bf\u04bd\u0001\u0000\u0000\u0000\u04c0\u04b8\u0001\u0000\u0000\u0000"+
		"\u04c0\u04c1\u0001\u0000\u0000\u0000\u04c1\u04c2\u0001\u0000\u0000\u0000"+
		"\u04c2\u04c3\u0005\u0098\u0000\u0000\u04c3\u00a9\u0001\u0000\u0000\u0000"+
		"\u04c4\u04c5\u0007\u0010\u0000\u0000\u04c5\u00ab\u0001\u0000\u0000\u0000"+
		"\u04c6\u04cc\u0005\u009f\u0000\u0000\u04c7\u04cc\u0005\u00a0\u0000\u0000"+
		"\u04c8\u04cc\u0005\u009e\u0000\u0000\u04c9\u04cc\u0003\u00aaU\u0000\u04ca"+
		"\u04cc\u0005\u00a1\u0000\u0000\u04cb\u04c6\u0001\u0000\u0000\u0000\u04cb"+
		"\u04c7\u0001\u0000\u0000\u0000\u04cb\u04c8\u0001\u0000\u0000\u0000\u04cb"+
		"\u04c9\u0001\u0000\u0000\u0000\u04cb\u04ca\u0001\u0000\u0000\u0000\u04cc"+
		"\u00ad\u0001\u0000\u0000\u0000\u04cd\u04d1\u0003\u00a6S\u0000\u04ce\u04d1"+
		"\u0003\u00a8T\u0000\u04cf\u04d1\u0003\u00acV\u0000\u04d0\u04cd\u0001\u0000"+
		"\u0000\u0000\u04d0\u04ce\u0001\u0000\u0000\u0000\u04d0\u04cf\u0001\u0000"+
		"\u0000\u0000\u04d1\u00af\u0001\u0000\u0000\u0000\u0087\u00ba\u00bc\u00c5"+
		"\u00cd\u00d9\u00e0\u00ea\u00f0\u00f5\u00fb\u0103\u0109\u0114\u011f\u0124"+
		"\u0131\u013d\u0140\u0148\u014b\u014e\u0157\u015c\u0165\u016a\u016d\u0172"+
		"\u017f\u0181\u018f\u0194\u019a\u019e\u01b1\u01b3\u01bb\u01bf\u01c5\u01c8"+
		"\u01d1\u01d3\u01d8\u01df\u01f1\u01f3\u01fd\u0201\u0214\u0216\u021b\u0223"+
		"\u0233\u024c\u024e\u0254\u0261\u0264\u026e\u0271\u0275\u027b\u0285\u0288"+
		"\u0292\u029b\u02a0\u02a5\u02b4\u02b9\u02c4\u02c6\u02ce\u02d2\u02e9\u02eb"+
		"\u0315\u031b\u031f\u0326\u032f\u0332\u0335\u0340\u0342\u0349\u034d\u0351"+
		"\u035c\u0368\u036f\u0374\u0379\u037d\u0382\u0384\u0399\u039d\u03a6\u03ac"+
		"\u03b0\u03b3\u03d3\u03d9\u03dd\u03e3\u03e9\u03f9\u03ff\u0409\u0410\u0417"+
		"\u041b\u0423\u0429\u0439\u0446\u044c\u0455\u045d\u0462\u0464\u046f\u0474"+
		"\u0489\u048d\u0491\u049b\u049e\u04a7\u04aa\u04b3\u04bd\u04c0\u04cb\u04d0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}