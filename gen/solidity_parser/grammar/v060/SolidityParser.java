// Generated from java-escape by ANTLR 4.11.1
package solidity_parser.grammar.v060;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, ContractKeyword=85, InterfaceKeyword=86, 
		LibraryKeyword=87, Abstract=88, BoolType=89, StringType=90, VarType=91, 
		Int=92, Uint=93, AByte=94, Byte=95, Fixed=96, Ufixed=97, BooleanLiteral=98, 
		DecimalNumber=99, HexNumber=100, NumberUnit=101, HexLiteralFragment=102, 
		ReservedKeyword=103, AnonymousKeyword=104, BreakKeyword=105, ConstantKeyword=106, 
		ImmutableKeyword=107, ContinueKeyword=108, LeaveKeyword=109, ExternalKeyword=110, 
		IndexedKeyword=111, InternalKeyword=112, PayableKeyword=113, PrivateKeyword=114, 
		PublicKeyword=115, VirtualKeyword=116, PureKeyword=117, TypeKeyword=118, 
		ViewKeyword=119, ConstructorKeyword=120, FallbackKeyword=121, ReceiveKeyword=122, 
		Identifier=123, StringLiteralFragment=124, VersionLiteral=125, WS=126, 
		COMMENT=127, LINE_COMMENT=128;
	public static final int
		RULE_sourceUnit = 0, RULE_pragmaDirective = 1, RULE_pragmaName = 2, RULE_pragmaValue = 3, 
		RULE_version = 4, RULE_versionConstraint = 5, RULE_versionOperator = 6, 
		RULE_importDirective = 7, RULE_importDeclaration = 8, RULE_contractDefinition = 9, 
		RULE_inheritanceSpecifier = 10, RULE_contractPart = 11, RULE_stateVariableDeclaration = 12, 
		RULE_overrideSpecifier = 13, RULE_usingForDeclaration = 14, RULE_structDefinition = 15, 
		RULE_modifierDefinition = 16, RULE_functionDefinition = 17, RULE_functionDescriptor = 18, 
		RULE_returnParameters = 19, RULE_modifierList = 20, RULE_modifierInvocation = 21, 
		RULE_eventDefinition = 22, RULE_enumDefinition = 23, RULE_enumValue = 24, 
		RULE_parameterList = 25, RULE_parameter = 26, RULE_eventParameterList = 27, 
		RULE_eventParameter = 28, RULE_variableDeclaration = 29, RULE_typeName = 30, 
		RULE_userDefinedTypeName = 31, RULE_mapping = 32, RULE_mappingKey = 33, 
		RULE_functionTypeName = 34, RULE_storageLocation = 35, RULE_stateMutability = 36, 
		RULE_visibilityModifier = 37, RULE_block = 38, RULE_statement = 39, RULE_expressionStatement = 40, 
		RULE_ifStatement = 41, RULE_tryStatement = 42, RULE_catchClause = 43, 
		RULE_whileStatement = 44, RULE_forStatement = 45, RULE_simpleStatement = 46, 
		RULE_inlineAssemblyStatement = 47, RULE_doWhileStatement = 48, RULE_continueStatement = 49, 
		RULE_breakStatement = 50, RULE_returnStatement = 51, RULE_throwStatement = 52, 
		RULE_emitStatement = 53, RULE_variableDeclarationStatement = 54, RULE_variableDeclarationList = 55, 
		RULE_identifierList = 56, RULE_elementaryTypeName = 57, RULE_addressType = 58, 
		RULE_expression = 59, RULE_primaryExpression = 60, RULE_arrayBrackets = 61, 
		RULE_expressionList = 62, RULE_nameValueList = 63, RULE_nameValue = 64, 
		RULE_functionCallArguments = 65, RULE_functionCall = 66, RULE_tupleExpression = 67, 
		RULE_typeNameExpression = 68, RULE_assemblyItem = 69, RULE_assemblyBlock = 70, 
		RULE_assemblyExpression = 71, RULE_assemblyCall = 72, RULE_assemblyLocalDefinition = 73, 
		RULE_assemblyAssignment = 74, RULE_assemblyIdentifierList = 75, RULE_assemblyStackAssignment = 76, 
		RULE_labelDefinition = 77, RULE_assemblySwitch = 78, RULE_assemblyCase = 79, 
		RULE_assemblyFunctionDefinition = 80, RULE_assemblyFunctionReturns = 81, 
		RULE_assemblyFor = 82, RULE_assemblyIf = 83, RULE_assemblyLiteral = 84, 
		RULE_assemblyTypedVariableList = 85, RULE_assemblyType = 86, RULE_subAssembly = 87, 
		RULE_numberLiteral = 88, RULE_identifier = 89, RULE_hexLiteral = 90, RULE_stringLiteral = 91;
	private static String[] makeRuleNames() {
		return new String[] {
			"sourceUnit", "pragmaDirective", "pragmaName", "pragmaValue", "version", 
			"versionConstraint", "versionOperator", "importDirective", "importDeclaration", 
			"contractDefinition", "inheritanceSpecifier", "contractPart", "stateVariableDeclaration", 
			"overrideSpecifier", "usingForDeclaration", "structDefinition", "modifierDefinition", 
			"functionDefinition", "functionDescriptor", "returnParameters", "modifierList", 
			"modifierInvocation", "eventDefinition", "enumDefinition", "enumValue", 
			"parameterList", "parameter", "eventParameterList", "eventParameter", 
			"variableDeclaration", "typeName", "userDefinedTypeName", "mapping", 
			"mappingKey", "functionTypeName", "storageLocation", "stateMutability", 
			"visibilityModifier", "block", "statement", "expressionStatement", "ifStatement", 
			"tryStatement", "catchClause", "whileStatement", "forStatement", "simpleStatement", 
			"inlineAssemblyStatement", "doWhileStatement", "continueStatement", "breakStatement", 
			"returnStatement", "throwStatement", "emitStatement", "variableDeclarationStatement", 
			"variableDeclarationList", "identifierList", "elementaryTypeName", "addressType", 
			"expression", "primaryExpression", "arrayBrackets", "expressionList", 
			"nameValueList", "nameValue", "functionCallArguments", "functionCall", 
			"tupleExpression", "typeNameExpression", "assemblyItem", "assemblyBlock", 
			"assemblyExpression", "assemblyCall", "assemblyLocalDefinition", "assemblyAssignment", 
			"assemblyIdentifierList", "assemblyStackAssignment", "labelDefinition", 
			"assemblySwitch", "assemblyCase", "assemblyFunctionDefinition", "assemblyFunctionReturns", 
			"assemblyFor", "assemblyIf", "assemblyLiteral", "assemblyTypedVariableList", 
			"assemblyType", "subAssembly", "numberLiteral", "identifier", "hexLiteral", 
			"stringLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pragma'", "';'", "'^'", "'~'", "'>='", "'>'", "'<'", "'<='", 
			"'='", "'import'", "'as'", "'*'", "'from'", "'{'", "','", "'}'", "'is'", 
			"'('", "')'", "'override'", "'using'", "'for'", "'struct'", "'modifier'", 
			"'function'", "'returns'", "'event'", "'enum'", "'['", "']'", "'.'", 
			"'mapping'", "'=>'", "'memory'", "'storage'", "'calldata'", "'if'", "'else'", 
			"'try'", "'catch'", "'while'", "'assembly'", "'do'", "'return'", "'throw'", 
			"'emit'", "'address'", "'++'", "'--'", "'new'", "':'", "'+'", "'-'", 
			"'delete'", "'after'", "'!'", "'**'", "'/'", "'%'", "'<<'", "'>>'", "'&'", 
			"'|'", "'=='", "'!='", "'&&'", "'||'", "'?'", "'|='", "'^='", "'&='", 
			"'<<='", "'>>='", "'+='", "'-='", "'*='", "'/='", "'%='", "'let'", "':='", 
			"'=:'", "'switch'", "'case'", "'default'", "'contract'", "'interface'", 
			"'library'", "'abstract'", "'bool'", "'string'", "'var'", null, null, 
			"'byte'", null, null, null, null, null, null, null, null, null, "'anonymous'", 
			"'break'", "'constant'", "'immutable'", "'continue'", "'leave'", "'external'", 
			"'indexed'", "'internal'", "'payable'", "'private'", "'public'", "'virtual'", 
			"'pure'", "'type'", "'view'", "'constructor'", "'fallback'", "'receive'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ContractKeyword", "InterfaceKeyword", "LibraryKeyword", "Abstract", 
			"BoolType", "StringType", "VarType", "Int", "Uint", "AByte", "Byte", 
			"Fixed", "Ufixed", "BooleanLiteral", "DecimalNumber", "HexNumber", "NumberUnit", 
			"HexLiteralFragment", "ReservedKeyword", "AnonymousKeyword", "BreakKeyword", 
			"ConstantKeyword", "ImmutableKeyword", "ContinueKeyword", "LeaveKeyword", 
			"ExternalKeyword", "IndexedKeyword", "InternalKeyword", "PayableKeyword", 
			"PrivateKeyword", "PublicKeyword", "VirtualKeyword", "PureKeyword", "TypeKeyword", 
			"ViewKeyword", "ConstructorKeyword", "FallbackKeyword", "ReceiveKeyword", 
			"Identifier", "StringLiteralFragment", "VersionLiteral", "WS", "COMMENT", 
			"LINE_COMMENT"
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
		public List<ContractDefinitionContext> contractDefinition() {
			return getRuleContexts(ContractDefinitionContext.class);
		}
		public ContractDefinitionContext contractDefinition(int i) {
			return getRuleContext(ContractDefinitionContext.class,i);
		}
		public SourceUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterSourceUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitSourceUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitSourceUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceUnitContext sourceUnit() throws RecognitionException {
		SourceUnitContext _localctx = new SourceUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sourceUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 276825090L) != 0 || (((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & 15L) != 0) {
				{
				setState(189);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(184);
					pragmaDirective();
					}
					break;
				case T__9:
					{
					setState(185);
					importDirective();
					}
					break;
				case T__22:
					{
					setState(186);
					structDefinition();
					}
					break;
				case T__27:
					{
					setState(187);
					enumDefinition();
					}
					break;
				case ContractKeyword:
				case InterfaceKeyword:
				case LibraryKeyword:
				case Abstract:
					{
					setState(188);
					contractDefinition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public PragmaNameContext pragmaName() {
			return getRuleContext(PragmaNameContext.class,0);
		}
		public PragmaValueContext pragmaValue() {
			return getRuleContext(PragmaValueContext.class,0);
		}
		public PragmaDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterPragmaDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitPragmaDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitPragmaDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PragmaDirectiveContext pragmaDirective() throws RecognitionException {
		PragmaDirectiveContext _localctx = new PragmaDirectiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pragmaDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__0);
			setState(197);
			pragmaName();
			setState(198);
			pragmaValue();
			setState(199);
			match(T__1);
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
	public static class PragmaNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PragmaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterPragmaName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitPragmaName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitPragmaName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PragmaNameContext pragmaName() throws RecognitionException {
		PragmaNameContext _localctx = new PragmaNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pragmaName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			identifier();
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
	public static class PragmaValueContext extends ParserRuleContext {
		public VersionContext version() {
			return getRuleContext(VersionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PragmaValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterPragmaValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitPragmaValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitPragmaValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PragmaValueContext pragmaValue() throws RecognitionException {
		PragmaValueContext _localctx = new PragmaValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pragmaValue);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				version();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				expression(0);
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
	public static class VersionContext extends ParserRuleContext {
		public List<VersionConstraintContext> versionConstraint() {
			return getRuleContexts(VersionConstraintContext.class);
		}
		public VersionConstraintContext versionConstraint(int i) {
			return getRuleContext(VersionConstraintContext.class,i);
		}
		public VersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_version; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitVersion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitVersion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VersionContext version() throws RecognitionException {
		VersionContext _localctx = new VersionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_version);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			versionConstraint();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1016L) != 0 || _la==VersionLiteral) {
				{
				setState(208);
				versionConstraint();
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
	public static class VersionConstraintContext extends ParserRuleContext {
		public TerminalNode VersionLiteral() { return getToken(SolidityParser.VersionLiteral, 0); }
		public VersionOperatorContext versionOperator() {
			return getRuleContext(VersionOperatorContext.class,0);
		}
		public VersionConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_versionConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterVersionConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitVersionConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitVersionConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VersionConstraintContext versionConstraint() throws RecognitionException {
		VersionConstraintContext _localctx = new VersionConstraintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_versionConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1016L) != 0) {
				{
				setState(211);
				versionOperator();
				}
			}

			setState(214);
			match(VersionLiteral);
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
	public static class VersionOperatorContext extends ParserRuleContext {
		public VersionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_versionOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterVersionOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitVersionOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitVersionOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VersionOperatorContext versionOperator() throws RecognitionException {
		VersionOperatorContext _localctx = new VersionOperatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_versionOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1016L) != 0) ) {
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
	public static class ImportDirectiveContext extends ParserRuleContext {
		public ImportDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDirective; }
	 
		public ImportDirectiveContext() { }
		public void copyFrom(ImportDirectiveContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AliasImportContext extends ImportDirectiveContext {
		public IdentifierContext symbol;
		public IdentifierContext unitAlias;
		public TerminalNode StringLiteralFragment() { return getToken(SolidityParser.StringLiteralFragment, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public AliasImportContext(ImportDirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAliasImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAliasImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAliasImport(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModuleImportContext extends ImportDirectiveContext {
		public TerminalNode StringLiteralFragment() { return getToken(SolidityParser.StringLiteralFragment, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ModuleImportContext(ImportDirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterModuleImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitModuleImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitModuleImport(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SymbolImportContext extends ImportDirectiveContext {
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public TerminalNode StringLiteralFragment() { return getToken(SolidityParser.StringLiteralFragment, 0); }
		public SymbolImportContext(ImportDirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterSymbolImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitSymbolImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitSymbolImport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDirectiveContext importDirective() throws RecognitionException {
		ImportDirectiveContext _localctx = new ImportDirectiveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_importDirective);
		int _la;
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new ModuleImportContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				match(T__9);
				setState(219);
				match(StringLiteralFragment);
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(220);
					match(T__10);
					setState(221);
					identifier();
					}
				}

				setState(224);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new AliasImportContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(T__9);
				setState(228);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__11:
					{
					setState(226);
					match(T__11);
					}
					break;
				case T__12:
				case T__35:
				case Identifier:
					{
					setState(227);
					((AliasImportContext)_localctx).symbol = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(230);
					match(T__10);
					setState(231);
					((AliasImportContext)_localctx).unitAlias = identifier();
					}
				}

				setState(234);
				match(T__12);
				setState(235);
				match(StringLiteralFragment);
				setState(236);
				match(T__1);
				}
				break;
			case 3:
				_localctx = new SymbolImportContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				match(T__9);
				setState(238);
				match(T__13);
				setState(239);
				importDeclaration();
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(240);
					match(T__14);
					setState(241);
					importDeclaration();
					}
					}
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(247);
				match(T__15);
				setState(248);
				match(T__12);
				setState(249);
				match(StringLiteralFragment);
				setState(250);
				match(T__1);
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
	public static class ImportDeclarationContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			identifier();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(255);
				match(T__10);
				setState(256);
				identifier();
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
	public static class ContractDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ContractKeyword() { return getToken(SolidityParser.ContractKeyword, 0); }
		public TerminalNode InterfaceKeyword() { return getToken(SolidityParser.InterfaceKeyword, 0); }
		public TerminalNode LibraryKeyword() { return getToken(SolidityParser.LibraryKeyword, 0); }
		public TerminalNode Abstract() { return getToken(SolidityParser.Abstract, 0); }
		public List<InheritanceSpecifierContext> inheritanceSpecifier() {
			return getRuleContexts(InheritanceSpecifierContext.class);
		}
		public InheritanceSpecifierContext inheritanceSpecifier(int i) {
			return getRuleContext(InheritanceSpecifierContext.class,i);
		}
		public List<ContractPartContext> contractPart() {
			return getRuleContexts(ContractPartContext.class);
		}
		public ContractPartContext contractPart(int i) {
			return getRuleContext(ContractPartContext.class,i);
		}
		public ContractDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterContractDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitContractDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitContractDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContractDefinitionContext contractDefinition() throws RecognitionException {
		ContractDefinitionContext _localctx = new ContractDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_contractDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract) {
				{
				setState(259);
				match(Abstract);
				}
			}

			setState(262);
			_la = _input.LA(1);
			if ( !((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & 7L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(263);
			identifier();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(264);
				match(T__16);
				setState(265);
				inheritanceSpecifier();
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(266);
					match(T__14);
					setState(267);
					inheritanceSpecifier();
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(275);
			match(T__13);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 140810966278144L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 32212255231L) != 0) {
				{
				{
				setState(276);
				contractPart();
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			match(T__15);
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
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public InheritanceSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritanceSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterInheritanceSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitInheritanceSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitInheritanceSpecifier(this);
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
			setState(284);
			userDefinedTypeName();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(285);
				match(T__17);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
					{
					setState(286);
					expressionList();
					}
				}

				setState(289);
				match(T__18);
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
	public static class ContractPartContext extends ParserRuleContext {
		public StateVariableDeclarationContext stateVariableDeclaration() {
			return getRuleContext(StateVariableDeclarationContext.class,0);
		}
		public UsingForDeclarationContext usingForDeclaration() {
			return getRuleContext(UsingForDeclarationContext.class,0);
		}
		public StructDefinitionContext structDefinition() {
			return getRuleContext(StructDefinitionContext.class,0);
		}
		public ModifierDefinitionContext modifierDefinition() {
			return getRuleContext(ModifierDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public EventDefinitionContext eventDefinition() {
			return getRuleContext(EventDefinitionContext.class,0);
		}
		public EnumDefinitionContext enumDefinition() {
			return getRuleContext(EnumDefinitionContext.class,0);
		}
		public ContractPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contractPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterContractPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitContractPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitContractPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContractPartContext contractPart() throws RecognitionException {
		ContractPartContext _localctx = new ContractPartContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_contractPart);
		try {
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				stateVariableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				usingForDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(294);
				structDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(295);
				modifierDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(296);
				functionDefinition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(297);
				eventDefinition();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(298);
				enumDefinition();
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
	public static class StateVariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> PublicKeyword() { return getTokens(SolidityParser.PublicKeyword); }
		public TerminalNode PublicKeyword(int i) {
			return getToken(SolidityParser.PublicKeyword, i);
		}
		public List<TerminalNode> InternalKeyword() { return getTokens(SolidityParser.InternalKeyword); }
		public TerminalNode InternalKeyword(int i) {
			return getToken(SolidityParser.InternalKeyword, i);
		}
		public List<TerminalNode> PrivateKeyword() { return getTokens(SolidityParser.PrivateKeyword); }
		public TerminalNode PrivateKeyword(int i) {
			return getToken(SolidityParser.PrivateKeyword, i);
		}
		public List<TerminalNode> ConstantKeyword() { return getTokens(SolidityParser.ConstantKeyword); }
		public TerminalNode ConstantKeyword(int i) {
			return getToken(SolidityParser.ConstantKeyword, i);
		}
		public List<TerminalNode> ImmutableKeyword() { return getTokens(SolidityParser.ImmutableKeyword); }
		public TerminalNode ImmutableKeyword(int i) {
			return getToken(SolidityParser.ImmutableKeyword, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StateVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterStateVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitStateVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitStateVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateVariableDeclarationContext stateVariableDeclaration() throws RecognitionException {
		StateVariableDeclarationContext _localctx = new StateVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stateVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			typeName(0);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19 || (((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 835L) != 0) {
				{
				setState(308);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PublicKeyword:
					{
					setState(302);
					match(PublicKeyword);
					}
					break;
				case InternalKeyword:
					{
					setState(303);
					match(InternalKeyword);
					}
					break;
				case PrivateKeyword:
					{
					setState(304);
					match(PrivateKeyword);
					}
					break;
				case ConstantKeyword:
					{
					setState(305);
					match(ConstantKeyword);
					}
					break;
				case ImmutableKeyword:
					{
					setState(306);
					match(ImmutableKeyword);
					}
					break;
				case T__19:
					{
					setState(307);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
			identifier();
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(314);
				match(T__8);
				setState(315);
				expression(0);
				}
			}

			setState(318);
			match(T__1);
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
		public List<UserDefinedTypeNameContext> userDefinedTypeName() {
			return getRuleContexts(UserDefinedTypeNameContext.class);
		}
		public UserDefinedTypeNameContext userDefinedTypeName(int i) {
			return getRuleContext(UserDefinedTypeNameContext.class,i);
		}
		public OverrideSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overrideSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterOverrideSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitOverrideSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitOverrideSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverrideSpecifierContext overrideSpecifier() throws RecognitionException {
		OverrideSpecifierContext _localctx = new OverrideSpecifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_overrideSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(T__19);
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(321);
				match(T__17);
				setState(322);
				userDefinedTypeName();
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(323);
					match(T__14);
					setState(324);
					userDefinedTypeName();
					}
					}
					setState(329);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(330);
				match(T__18);
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
	public static class UsingForDeclarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public UsingForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usingForDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterUsingForDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitUsingForDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitUsingForDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingForDeclarationContext usingForDeclaration() throws RecognitionException {
		UsingForDeclarationContext _localctx = new UsingForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_usingForDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(T__20);
			setState(335);
			identifier();
			setState(336);
			match(T__21);
			setState(339);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(337);
				match(T__11);
				}
				break;
			case T__12:
			case T__24:
			case T__31:
			case T__35:
			case T__46:
			case BoolType:
			case StringType:
			case VarType:
			case Int:
			case Uint:
			case AByte:
			case Byte:
			case Fixed:
			case Ufixed:
			case Identifier:
				{
				setState(338);
				typeName(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(341);
			match(T__1);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public StructDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterStructDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitStructDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitStructDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDefinitionContext structDefinition() throws RecognitionException {
		StructDefinitionContext _localctx = new StructDefinitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_structDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(T__22);
			setState(344);
			identifier();
			setState(345);
			match(T__13);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 140810536361984L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 17179869695L) != 0) {
				{
				setState(346);
				variableDeclaration();
				setState(347);
				match(T__1);
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 140810536361984L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 17179869695L) != 0) {
					{
					{
					setState(348);
					variableDeclaration();
					setState(349);
					match(T__1);
					}
					}
					setState(355);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(358);
			match(T__15);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public List<TerminalNode> VirtualKeyword() { return getTokens(SolidityParser.VirtualKeyword); }
		public TerminalNode VirtualKeyword(int i) {
			return getToken(SolidityParser.VirtualKeyword, i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public ModifierDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterModifierDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitModifierDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitModifierDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierDefinitionContext modifierDefinition() throws RecognitionException {
		ModifierDefinitionContext _localctx = new ModifierDefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_modifierDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(T__23);
			setState(361);
			identifier();
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(362);
				parameterList();
				}
			}

			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19 || _la==VirtualKeyword) {
				{
				setState(367);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VirtualKeyword:
					{
					setState(365);
					match(VirtualKeyword);
					}
					break;
				case T__19:
					{
					setState(366);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(374);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(372);
				match(T__1);
				}
				break;
			case T__13:
				{
				setState(373);
				block();
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
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDescriptorContext functionDescriptor() {
			return getRuleContext(FunctionDescriptorContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReturnParametersContext returnParameters() {
			return getRuleContext(ReturnParametersContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			functionDescriptor();
			setState(377);
			parameterList();
			setState(378);
			modifierList();
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(379);
				returnParameters();
				}
			}

			setState(384);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(382);
				match(T__1);
				}
				break;
			case T__13:
				{
				setState(383);
				block();
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
	public static class FunctionDescriptorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ReceiveKeyword() { return getToken(SolidityParser.ReceiveKeyword, 0); }
		public TerminalNode FallbackKeyword() { return getToken(SolidityParser.FallbackKeyword, 0); }
		public TerminalNode ConstructorKeyword() { return getToken(SolidityParser.ConstructorKeyword, 0); }
		public FunctionDescriptorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDescriptor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterFunctionDescriptor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitFunctionDescriptor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitFunctionDescriptor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDescriptorContext functionDescriptor() throws RecognitionException {
		FunctionDescriptorContext _localctx = new FunctionDescriptorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionDescriptor);
		try {
			setState(396);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				match(T__24);
				setState(391);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__12:
				case T__35:
				case Identifier:
					{
					setState(387);
					identifier();
					}
					break;
				case ReceiveKeyword:
					{
					setState(388);
					match(ReceiveKeyword);
					}
					break;
				case FallbackKeyword:
					{
					setState(389);
					match(FallbackKeyword);
					}
					break;
				case ConstructorKeyword:
					{
					setState(390);
					match(ConstructorKeyword);
					}
					break;
				case T__17:
					break;
				default:
					break;
				}
				}
				break;
			case ConstructorKeyword:
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				match(ConstructorKeyword);
				}
				break;
			case FallbackKeyword:
				enterOuterAlt(_localctx, 3);
				{
				setState(394);
				match(FallbackKeyword);
				}
				break;
			case ReceiveKeyword:
				enterOuterAlt(_localctx, 4);
				{
				setState(395);
				match(ReceiveKeyword);
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
	public static class ReturnParametersContext extends ParserRuleContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ReturnParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterReturnParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitReturnParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitReturnParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnParametersContext returnParameters() throws RecognitionException {
		ReturnParametersContext _localctx = new ReturnParametersContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(T__25);
			setState(399);
			parameterList();
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
	public static class ModifierListContext extends ParserRuleContext {
		public List<ModifierInvocationContext> modifierInvocation() {
			return getRuleContexts(ModifierInvocationContext.class);
		}
		public ModifierInvocationContext modifierInvocation(int i) {
			return getRuleContext(ModifierInvocationContext.class,i);
		}
		public List<StateMutabilityContext> stateMutability() {
			return getRuleContexts(StateMutabilityContext.class);
		}
		public StateMutabilityContext stateMutability(int i) {
			return getRuleContext(StateMutabilityContext.class,i);
		}
		public List<VisibilityModifierContext> visibilityModifier() {
			return getRuleContexts(VisibilityModifierContext.class);
		}
		public VisibilityModifierContext visibilityModifier(int i) {
			return getRuleContext(VisibilityModifierContext.class,i);
		}
		public List<OverrideSpecifierContext> overrideSpecifier() {
			return getRuleContexts(OverrideSpecifierContext.class);
		}
		public OverrideSpecifierContext overrideSpecifier(int i) {
			return getRuleContext(OverrideSpecifierContext.class,i);
		}
		public ModifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterModifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitModifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitModifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierListContext modifierList() throws RecognitionException {
		ModifierListContext _localctx = new ModifierListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_modifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(405);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__12:
					case T__35:
					case Identifier:
						{
						setState(401);
						modifierInvocation();
						}
						break;
					case ConstantKeyword:
					case PayableKeyword:
					case PureKeyword:
					case ViewKeyword:
						{
						setState(402);
						stateMutability();
						}
						break;
					case ExternalKeyword:
					case InternalKeyword:
					case PrivateKeyword:
					case PublicKeyword:
					case VirtualKeyword:
						{
						setState(403);
						visibilityModifier();
						}
						break;
					case T__19:
						{
						setState(404);
						overrideSpecifier();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ModifierInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterModifierInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitModifierInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitModifierInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierInvocationContext modifierInvocation() throws RecognitionException {
		ModifierInvocationContext _localctx = new ModifierInvocationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_modifierInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			identifier();
			setState(416);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(411);
				match(T__17);
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
					{
					setState(412);
					expressionList();
					}
				}

				setState(415);
				match(T__18);
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
	public static class EventDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EventParameterListContext eventParameterList() {
			return getRuleContext(EventParameterListContext.class,0);
		}
		public TerminalNode AnonymousKeyword() { return getToken(SolidityParser.AnonymousKeyword, 0); }
		public EventDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterEventDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitEventDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitEventDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventDefinitionContext eventDefinition() throws RecognitionException {
		EventDefinitionContext _localctx = new EventDefinitionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_eventDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(T__26);
			setState(419);
			identifier();
			setState(420);
			eventParameterList();
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AnonymousKeyword) {
				{
				setState(421);
				match(AnonymousKeyword);
				}
			}

			setState(424);
			match(T__1);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<EnumValueContext> enumValue() {
			return getRuleContexts(EnumValueContext.class);
		}
		public EnumValueContext enumValue(int i) {
			return getRuleContext(EnumValueContext.class,i);
		}
		public EnumDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterEnumDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitEnumDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitEnumDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDefinitionContext enumDefinition() throws RecognitionException {
		EnumDefinitionContext _localctx = new EnumDefinitionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(T__27);
			setState(427);
			identifier();
			setState(428);
			match(T__13);
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__35 || _la==Identifier) {
				{
				setState(429);
				enumValue();
				}
			}

			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(432);
				match(T__14);
				setState(433);
				enumValue();
				}
				}
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(439);
			match(T__15);
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
	public static class EnumValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterEnumValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitEnumValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitEnumValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumValueContext enumValue() throws RecognitionException {
		EnumValueContext _localctx = new EnumValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_enumValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			identifier();
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
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(T__17);
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 140810536361984L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 17179869695L) != 0) {
				{
				setState(444);
				parameter();
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(445);
					match(T__14);
					setState(446);
					parameter();
					}
					}
					setState(451);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(454);
			match(T__18);
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
	public static class ParameterContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public StorageLocationContext storageLocation() {
			return getRuleContext(StorageLocationContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			typeName(0);
			setState(458);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(457);
				storageLocation();
				}
				break;
			}
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__35 || _la==Identifier) {
				{
				setState(460);
				identifier();
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
	public static class EventParameterListContext extends ParserRuleContext {
		public List<EventParameterContext> eventParameter() {
			return getRuleContexts(EventParameterContext.class);
		}
		public EventParameterContext eventParameter(int i) {
			return getRuleContext(EventParameterContext.class,i);
		}
		public EventParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterEventParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitEventParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitEventParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventParameterListContext eventParameterList() throws RecognitionException {
		EventParameterListContext _localctx = new EventParameterListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_eventParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(T__17);
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 140810536361984L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 17179869695L) != 0) {
				{
				setState(464);
				eventParameter();
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(465);
					match(T__14);
					setState(466);
					eventParameter();
					}
					}
					setState(471);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(474);
			match(T__18);
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
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode IndexedKeyword() { return getToken(SolidityParser.IndexedKeyword, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EventParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterEventParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitEventParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitEventParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventParameterContext eventParameter() throws RecognitionException {
		EventParameterContext _localctx = new EventParameterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_eventParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			typeName(0);
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IndexedKeyword) {
				{
				setState(477);
				match(IndexedKeyword);
				}
			}

			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__35 || _la==Identifier) {
				{
				setState(480);
				identifier();
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
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StorageLocationContext storageLocation() {
			return getRuleContext(StorageLocationContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			typeName(0);
			setState(485);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(484);
				storageLocation();
				}
				break;
			}
			setState(487);
			identifier();
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
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public MappingContext mapping() {
			return getRuleContext(MappingContext.class,0);
		}
		public FunctionTypeNameContext functionTypeName() {
			return getRuleContext(FunctionTypeNameContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitTypeName(this);
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
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_typeName, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
			case BoolType:
			case StringType:
			case VarType:
			case Int:
			case Uint:
			case AByte:
			case Byte:
			case Fixed:
			case Ufixed:
				{
				setState(490);
				elementaryTypeName();
				}
				break;
			case T__12:
			case T__35:
			case Identifier:
				{
				setState(491);
				userDefinedTypeName();
				}
				break;
			case T__31:
				{
				setState(492);
				mapping();
				}
				break;
			case T__24:
				{
				setState(493);
				functionTypeName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(504);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeName);
					setState(496);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(497);
					match(T__28);
					setState(499);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
						{
						setState(498);
						expression(0);
						}
					}

					setState(501);
					match(T__29);
					}
					} 
				}
				setState(506);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
	public static class UserDefinedTypeNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public UserDefinedTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterUserDefinedTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitUserDefinedTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitUserDefinedTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedTypeNameContext userDefinedTypeName() throws RecognitionException {
		UserDefinedTypeNameContext _localctx = new UserDefinedTypeNameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_userDefinedTypeName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			identifier();
			setState(512);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(508);
					match(T__30);
					setState(509);
					identifier();
					}
					} 
				}
				setState(514);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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
	public static class MappingContext extends ParserRuleContext {
		public MappingKeyContext mappingKey() {
			return getRuleContext(MappingKeyContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public MappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterMapping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitMapping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitMapping(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MappingContext mapping() throws RecognitionException {
		MappingContext _localctx = new MappingContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_mapping);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(T__31);
			setState(516);
			match(T__17);
			setState(517);
			mappingKey();
			setState(518);
			match(T__32);
			setState(519);
			typeName(0);
			setState(520);
			match(T__18);
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
	public static class MappingKeyContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public MappingKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterMappingKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitMappingKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitMappingKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MappingKeyContext mappingKey() throws RecognitionException {
		MappingKeyContext _localctx = new MappingKeyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_mappingKey);
		try {
			setState(524);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
			case BoolType:
			case StringType:
			case VarType:
			case Int:
			case Uint:
			case AByte:
			case Byte:
			case Fixed:
			case Ufixed:
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				elementaryTypeName();
				}
				break;
			case T__12:
			case T__35:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				userDefinedTypeName();
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
	public static class FunctionTypeNameContext extends ParserRuleContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ModifierListContext modifierList() {
			return getRuleContext(ModifierListContext.class,0);
		}
		public ReturnParametersContext returnParameters() {
			return getRuleContext(ReturnParametersContext.class,0);
		}
		public FunctionTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterFunctionTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitFunctionTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitFunctionTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeNameContext functionTypeName() throws RecognitionException {
		FunctionTypeNameContext _localctx = new FunctionTypeNameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_functionTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(T__24);
			setState(527);
			parameterList();
			setState(528);
			modifierList();
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(529);
				returnParameters();
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
	public static class StorageLocationContext extends ParserRuleContext {
		public StorageLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterStorageLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitStorageLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitStorageLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StorageLocationContext storageLocation() throws RecognitionException {
		StorageLocationContext _localctx = new StorageLocationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_storageLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 120259084288L) != 0) ) {
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
	public static class StateMutabilityContext extends ParserRuleContext {
		public TerminalNode PureKeyword() { return getToken(SolidityParser.PureKeyword, 0); }
		public TerminalNode ConstantKeyword() { return getToken(SolidityParser.ConstantKeyword, 0); }
		public TerminalNode ViewKeyword() { return getToken(SolidityParser.ViewKeyword, 0); }
		public TerminalNode PayableKeyword() { return getToken(SolidityParser.PayableKeyword, 0); }
		public StateMutabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateMutability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterStateMutability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitStateMutability(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitStateMutability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateMutabilityContext stateMutability() throws RecognitionException {
		StateMutabilityContext _localctx = new StateMutabilityContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_stateMutability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			_la = _input.LA(1);
			if ( !((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 10369L) != 0) ) {
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
	public static class VisibilityModifierContext extends ParserRuleContext {
		public TerminalNode ExternalKeyword() { return getToken(SolidityParser.ExternalKeyword, 0); }
		public TerminalNode PublicKeyword() { return getToken(SolidityParser.PublicKeyword, 0); }
		public TerminalNode InternalKeyword() { return getToken(SolidityParser.InternalKeyword, 0); }
		public TerminalNode PrivateKeyword() { return getToken(SolidityParser.PrivateKeyword, 0); }
		public TerminalNode VirtualKeyword() { return getToken(SolidityParser.VirtualKeyword, 0); }
		public VisibilityModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibilityModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterVisibilityModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitVisibilityModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitVisibilityModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisibilityModifierContext visibilityModifier() throws RecognitionException {
		VisibilityModifierContext _localctx = new VisibilityModifierContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_visibilityModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			_la = _input.LA(1);
			if ( !((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 117L) != 0) ) {
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
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			match(T__13);
			setState(542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 141861950023032848L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093857791L) != 0) {
				{
				{
				setState(539);
				statement();
				}
				}
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(545);
			match(T__15);
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
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InlineAssemblyStatementContext inlineAssemblyStatement() {
			return getRuleContext(InlineAssemblyStatementContext.class,0);
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
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public EmitStatementContext emitStatement() {
			return getRuleContext(EmitStatementContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_statement);
		try {
			setState(560);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
				enterOuterAlt(_localctx, 1);
				{
				setState(547);
				ifStatement();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(548);
				tryStatement();
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 3);
				{
				setState(549);
				whileStatement();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 4);
				{
				setState(550);
				forStatement();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(551);
				block();
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 6);
				{
				setState(552);
				inlineAssemblyStatement();
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 7);
				{
				setState(553);
				doWhileStatement();
				}
				break;
			case ContinueKeyword:
				enterOuterAlt(_localctx, 8);
				{
				setState(554);
				continueStatement();
				}
				break;
			case BreakKeyword:
				enterOuterAlt(_localctx, 9);
				{
				setState(555);
				breakStatement();
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 10);
				{
				setState(556);
				returnStatement();
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 11);
				{
				setState(557);
				throwStatement();
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 12);
				{
				setState(558);
				emitStatement();
				}
				break;
			case T__3:
			case T__12:
			case T__17:
			case T__24:
			case T__28:
			case T__31:
			case T__35:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case BoolType:
			case StringType:
			case VarType:
			case Int:
			case Uint:
			case AByte:
			case Byte:
			case Fixed:
			case Ufixed:
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
				enterOuterAlt(_localctx, 13);
				{
				setState(559);
				simpleStatement();
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
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			expression(0);
			setState(563);
			match(T__1);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			match(T__36);
			setState(566);
			match(T__17);
			setState(567);
			expression(0);
			setState(568);
			match(T__18);
			setState(569);
			statement();
			setState(572);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(570);
				match(T__37);
				setState(571);
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
	public static class TryStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ReturnParametersContext returnParameters() {
			return getRuleContext(ReturnParametersContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitTryStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitTryStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_tryStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			match(T__38);
			setState(575);
			expression(0);
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(576);
				returnParameters();
				}
			}

			setState(579);
			block();
			setState(581); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(580);
				catchClause();
				}
				}
				setState(583); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__39 );
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitCatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			match(T__39);
			setState(590);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 68719747072L) != 0 || _la==Identifier) {
				{
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12 || _la==T__35 || _la==Identifier) {
					{
					setState(586);
					identifier();
					}
				}

				setState(589);
				parameterList();
				}
			}

			setState(592);
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
	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			match(T__40);
			setState(595);
			match(T__17);
			setState(596);
			expression(0);
			setState(597);
			match(T__18);
			setState(598);
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
	public static class ForStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
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
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			match(T__21);
			setState(601);
			match(T__17);
			setState(604);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__12:
			case T__17:
			case T__24:
			case T__28:
			case T__31:
			case T__35:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case BoolType:
			case StringType:
			case VarType:
			case Int:
			case Uint:
			case AByte:
			case Byte:
			case Fixed:
			case Ufixed:
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
				{
				setState(602);
				simpleStatement();
				}
				break;
			case T__1:
				{
				setState(603);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(608);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__12:
			case T__17:
			case T__28:
			case T__35:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case BoolType:
			case StringType:
			case VarType:
			case Int:
			case Uint:
			case AByte:
			case Byte:
			case Fixed:
			case Ufixed:
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
				{
				setState(606);
				expressionStatement();
				}
				break;
			case T__1:
				{
				setState(607);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(611);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
				{
				setState(610);
				expression(0);
				}
			}

			setState(613);
			match(T__18);
			setState(614);
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
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterSimpleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitSimpleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitSimpleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_simpleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(616);
				variableDeclarationStatement();
				}
				break;
			case 2:
				{
				setState(617);
				expressionStatement();
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
	public static class InlineAssemblyStatementContext extends ParserRuleContext {
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public TerminalNode StringLiteralFragment() { return getToken(SolidityParser.StringLiteralFragment, 0); }
		public InlineAssemblyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineAssemblyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterInlineAssemblyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitInlineAssemblyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitInlineAssemblyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineAssemblyStatementContext inlineAssemblyStatement() throws RecognitionException {
		InlineAssemblyStatementContext _localctx = new InlineAssemblyStatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_inlineAssemblyStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			match(T__41);
			setState(622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==StringLiteralFragment) {
				{
				setState(621);
				match(StringLiteralFragment);
				}
			}

			setState(624);
			assemblyBlock();
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			match(T__42);
			setState(627);
			statement();
			setState(628);
			match(T__40);
			setState(629);
			match(T__17);
			setState(630);
			expression(0);
			setState(631);
			match(T__18);
			setState(632);
			match(T__1);
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
		public TerminalNode ContinueKeyword() { return getToken(SolidityParser.ContinueKeyword, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			match(ContinueKeyword);
			setState(635);
			match(T__1);
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
		public TerminalNode BreakKeyword() { return getToken(SolidityParser.BreakKeyword, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			match(BreakKeyword);
			setState(638);
			match(T__1);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(T__43);
			setState(642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
				{
				setState(641);
				expression(0);
				}
			}

			setState(644);
			match(T__1);
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
	public static class ThrowStatementContext extends ParserRuleContext {
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitThrowStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitThrowStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			match(T__44);
			setState(647);
			match(T__1);
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
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public EmitStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emitStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterEmitStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitEmitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitEmitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmitStatementContext emitStatement() throws RecognitionException {
		EmitStatementContext _localctx = new EmitStatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_emitStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(T__45);
			setState(650);
			functionCall();
			setState(651);
			match(T__1);
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
		public TerminalNode VarType() { return getToken(SolidityParser.VarType, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VariableDeclarationListContext variableDeclarationList() {
			return getRuleContext(VariableDeclarationListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationStatementContext variableDeclarationStatement() throws RecognitionException {
		VariableDeclarationStatementContext _localctx = new VariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_variableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(653);
				match(VarType);
				setState(654);
				identifierList();
				}
				break;
			case 2:
				{
				setState(655);
				variableDeclaration();
				}
				break;
			case 3:
				{
				setState(656);
				match(T__17);
				setState(657);
				variableDeclarationList();
				setState(658);
				match(T__18);
				}
				break;
			}
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(662);
				match(T__8);
				setState(663);
				expression(0);
				}
			}

			setState(666);
			match(T__1);
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
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public VariableDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterVariableDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitVariableDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitVariableDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationListContext variableDeclarationList() throws RecognitionException {
		VariableDeclarationListContext _localctx = new VariableDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_variableDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 140810536361984L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 17179869695L) != 0) {
				{
				setState(668);
				variableDeclaration();
				}
			}

			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(671);
				match(T__14);
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 140810536361984L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 17179869695L) != 0) {
					{
					setState(672);
					variableDeclaration();
					}
				}

				}
				}
				setState(679);
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
	public static class IdentifierListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_identifierList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			match(T__17);
			setState(687);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(682);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__12 || _la==T__35 || _la==Identifier) {
						{
						setState(681);
						identifier();
						}
					}

					setState(684);
					match(T__14);
					}
					} 
				}
				setState(689);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			}
			setState(691);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__35 || _la==Identifier) {
				{
				setState(690);
				identifier();
				}
			}

			setState(693);
			match(T__18);
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
	public static class ElementaryTypeNameContext extends ParserRuleContext {
		public AddressTypeContext addressType() {
			return getRuleContext(AddressTypeContext.class,0);
		}
		public TerminalNode BoolType() { return getToken(SolidityParser.BoolType, 0); }
		public TerminalNode StringType() { return getToken(SolidityParser.StringType, 0); }
		public TerminalNode VarType() { return getToken(SolidityParser.VarType, 0); }
		public TerminalNode Int() { return getToken(SolidityParser.Int, 0); }
		public TerminalNode Uint() { return getToken(SolidityParser.Uint, 0); }
		public TerminalNode AByte() { return getToken(SolidityParser.AByte, 0); }
		public TerminalNode Byte() { return getToken(SolidityParser.Byte, 0); }
		public TerminalNode Fixed() { return getToken(SolidityParser.Fixed, 0); }
		public TerminalNode Ufixed() { return getToken(SolidityParser.Ufixed, 0); }
		public ElementaryTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementaryTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterElementaryTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitElementaryTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitElementaryTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementaryTypeNameContext elementaryTypeName() throws RecognitionException {
		ElementaryTypeNameContext _localctx = new ElementaryTypeNameContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_elementaryTypeName);
		try {
			setState(705);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
				enterOuterAlt(_localctx, 1);
				{
				setState(695);
				addressType();
				}
				break;
			case BoolType:
				enterOuterAlt(_localctx, 2);
				{
				setState(696);
				match(BoolType);
				}
				break;
			case StringType:
				enterOuterAlt(_localctx, 3);
				{
				setState(697);
				match(StringType);
				}
				break;
			case VarType:
				enterOuterAlt(_localctx, 4);
				{
				setState(698);
				match(VarType);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 5);
				{
				setState(699);
				match(Int);
				}
				break;
			case Uint:
				enterOuterAlt(_localctx, 6);
				{
				setState(700);
				match(Uint);
				}
				break;
			case AByte:
				enterOuterAlt(_localctx, 7);
				{
				setState(701);
				match(AByte);
				}
				break;
			case Byte:
				enterOuterAlt(_localctx, 8);
				{
				setState(702);
				match(Byte);
				}
				break;
			case Fixed:
				enterOuterAlt(_localctx, 9);
				{
				setState(703);
				match(Fixed);
				}
				break;
			case Ufixed:
				enterOuterAlt(_localctx, 10);
				{
				setState(704);
				match(Ufixed);
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
	public static class AddressTypeContext extends ParserRuleContext {
		public TerminalNode PayableKeyword() { return getToken(SolidityParser.PayableKeyword, 0); }
		public AddressTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addressType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAddressType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAddressType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAddressType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddressTypeContext addressType() throws RecognitionException {
		AddressTypeContext _localctx = new AddressTypeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_addressType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			match(T__46);
			setState(709);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(708);
				match(PayableKeyword);
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
	public static class ArrayLoadContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayLoadContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterArrayLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitArrayLoad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitArrayLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PayableExprContext extends ExpressionContext {
		public TerminalNode PayableKeyword() { return getToken(SolidityParser.PayableKeyword, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PayableExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterPayableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitPayableExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitPayableExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryPostOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryPostOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterUnaryPostOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitUnaryPostOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitUnaryPostOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryPreOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryPreOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterUnaryPreOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitUnaryPreOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitUnaryPreOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewTypeContext extends ExpressionContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public NewTypeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterNewType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitNewType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitNewType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReservedKeyExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReservedKeyExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterReservedKeyExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitReservedKeyExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitReservedKeyExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PrimaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeleteExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeleteExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterDeleteExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitDeleteExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitDeleteExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracketExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterBracketExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitBracketExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitBracketExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArraySliceContext extends ExpressionContext {
		public ExpressionContext base;
		public ExpressionContext start;
		public ExpressionContext end;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArraySliceContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterArraySlice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitArraySlice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitArraySlice(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberLoadContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MemberLoadContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterMemberLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitMemberLoad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitMemberLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterTernaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitTernaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitTernaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MetaTypeContext extends ExpressionContext {
		public TerminalNode TypeKeyword() { return getToken(SolidityParser.TypeKeyword, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public MetaTypeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterMetaType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitMetaType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitMetaType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LogicOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterLogicOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitLogicOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitLogicOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionCallArgumentsContext functionCallArguments() {
			return getRuleContext(FunctionCallArgumentsContext.class,0);
		}
		public NameValueListContext nameValueList() {
			return getRuleContext(NameValueListContext.class,0);
		}
		public FuncCallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitFuncCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitFuncCallExpr(this);
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
		int _startState = 118;
		enterRecursionRule(_localctx, 118, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(741);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				{
				_localctx = new NewTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(712);
				match(T__49);
				setState(713);
				typeName(0);
				}
				break;
			case 2:
				{
				_localctx = new MetaTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(714);
				match(TypeKeyword);
				setState(715);
				match(T__17);
				setState(716);
				typeName(0);
				setState(717);
				match(T__18);
				}
				break;
			case 3:
				{
				_localctx = new PayableExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(719);
				match(PayableKeyword);
				setState(720);
				match(T__17);
				setState(721);
				expression(0);
				setState(722);
				match(T__18);
				}
				break;
			case 4:
				{
				_localctx = new BracketExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(724);
				match(T__17);
				setState(725);
				expression(0);
				setState(726);
				match(T__18);
				}
				break;
			case 5:
				{
				_localctx = new UnaryPreOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(728);
				_la = _input.LA(1);
				if ( !(_la==T__47 || _la==T__48) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(729);
				expression(20);
				}
				break;
			case 6:
				{
				_localctx = new UnaryPreOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(730);
				_la = _input.LA(1);
				if ( !(_la==T__51 || _la==T__52) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(731);
				expression(19);
				}
				break;
			case 7:
				{
				_localctx = new DeleteExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(732);
				match(T__53);
				setState(733);
				expression(18);
				}
				break;
			case 8:
				{
				_localctx = new ReservedKeyExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(734);
				match(T__54);
				setState(735);
				expression(17);
				}
				break;
			case 9:
				{
				_localctx = new LogicOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(736);
				match(T__55);
				setState(737);
				expression(16);
				}
				break;
			case 10:
				{
				_localctx = new LogicOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(738);
				match(T__3);
				setState(739);
				expression(15);
				}
				break;
			case 11:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(740);
				primaryExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(820);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(818);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(743);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(744);
						match(T__56);
						setState(745);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(746);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(747);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 864691128455139328L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(748);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(749);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(750);
						_la = _input.LA(1);
						if ( !(_la==T__51 || _la==T__52) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(751);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(752);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(753);
						_la = _input.LA(1);
						if ( !(_la==T__59 || _la==T__60) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(754);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(755);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(756);
						match(T__61);
						setState(757);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(758);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(759);
						match(T__2);
						setState(760);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(761);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(762);
						match(T__62);
						setState(763);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(764);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(765);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(766);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(767);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(768);
						_la = _input.LA(1);
						if ( !(_la==T__63 || _la==T__64) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(769);
						expression(7);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(770);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(771);
						match(T__65);
						setState(772);
						expression(6);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(773);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(774);
						match(T__66);
						setState(775);
						expression(5);
						}
						break;
					case 12:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(776);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(777);
						_la = _input.LA(1);
						if ( !(_la==T__8 || (((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 1023L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(778);
						expression(3);
						}
						break;
					case 13:
						{
						_localctx = new UnaryPostOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(779);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(780);
						_la = _input.LA(1);
						if ( !(_la==T__47 || _la==T__48) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 14:
						{
						_localctx = new ArrayLoadContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(781);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(782);
						match(T__28);
						setState(784);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
							{
							setState(783);
							expression(0);
							}
						}

						setState(786);
						match(T__29);
						}
						break;
					case 15:
						{
						_localctx = new ArraySliceContext(new ExpressionContext(_parentctx, _parentState));
						((ArraySliceContext)_localctx).base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(787);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(788);
						match(T__28);
						setState(790);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
							{
							setState(789);
							((ArraySliceContext)_localctx).start = expression(0);
							}
						}

						setState(792);
						match(T__50);
						setState(794);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
							{
							setState(793);
							((ArraySliceContext)_localctx).end = expression(0);
							}
						}

						setState(796);
						match(T__29);
						}
						break;
					case 16:
						{
						_localctx = new MemberLoadContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(797);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(798);
						match(T__30);
						setState(799);
						identifier();
						}
						break;
					case 17:
						{
						_localctx = new FuncCallExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(800);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(806);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__13) {
							{
							setState(801);
							match(T__13);
							setState(803);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==T__12 || _la==T__35 || _la==Identifier) {
								{
								setState(802);
								nameValueList();
								}
							}

							setState(805);
							match(T__15);
							}
						}

						setState(808);
						match(T__17);
						setState(809);
						functionCallArguments();
						setState(810);
						match(T__18);
						}
						break;
					case 18:
						{
						_localctx = new TernaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(812);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(813);
						match(T__67);
						{
						setState(814);
						expression(0);
						setState(815);
						match(T__50);
						setState(816);
						expression(0);
						}
						}
						break;
					}
					} 
				}
				setState(822);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
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
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode BooleanLiteral() { return getToken(SolidityParser.BooleanLiteral, 0); }
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public HexLiteralContext hexLiteral() {
			return getRuleContext(HexLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArrayBracketsContext arrayBrackets() {
			return getRuleContext(ArrayBracketsContext.class,0);
		}
		public TupleExpressionContext tupleExpression() {
			return getRuleContext(TupleExpressionContext.class,0);
		}
		public TypeNameExpressionContext typeNameExpression() {
			return getRuleContext(TypeNameExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_primaryExpression);
		try {
			setState(836);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(823);
				match(BooleanLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(824);
				numberLiteral();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(825);
				hexLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(826);
				stringLiteral();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(827);
				identifier();
				setState(829);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
				case 1:
					{
					setState(828);
					arrayBrackets();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(831);
				tupleExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(832);
				typeNameExpression();
				setState(834);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(833);
					arrayBrackets();
					}
					break;
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
	public static class ArrayBracketsContext extends ParserRuleContext {
		public ArrayBracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayBrackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterArrayBrackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitArrayBrackets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitArrayBrackets(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayBracketsContext arrayBrackets() throws RecognitionException {
		ArrayBracketsContext _localctx = new ArrayBracketsContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_arrayBrackets);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(838);
			match(T__28);
			setState(839);
			match(T__29);
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
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			expression(0);
			setState(846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(842);
				match(T__14);
				setState(843);
				expression(0);
				}
				}
				setState(848);
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
	public static class NameValueListContext extends ParserRuleContext {
		public List<NameValueContext> nameValue() {
			return getRuleContexts(NameValueContext.class);
		}
		public NameValueContext nameValue(int i) {
			return getRuleContext(NameValueContext.class,i);
		}
		public NameValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterNameValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitNameValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitNameValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameValueListContext nameValueList() throws RecognitionException {
		NameValueListContext _localctx = new NameValueListContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_nameValueList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			nameValue();
			setState(854);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(850);
					match(T__14);
					setState(851);
					nameValue();
					}
					} 
				}
				setState(856);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			}
			setState(858);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(857);
				match(T__14);
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
	public static class NameValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NameValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterNameValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitNameValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitNameValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameValueContext nameValue() throws RecognitionException {
		NameValueContext _localctx = new NameValueContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_nameValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			identifier();
			setState(861);
			match(T__50);
			setState(862);
			expression(0);
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
	public static class FunctionCallArgumentsContext extends ParserRuleContext {
		public NameValueListContext nameValueList() {
			return getRuleContext(NameValueListContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionCallArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterFunctionCallArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitFunctionCallArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitFunctionCallArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallArgumentsContext functionCallArguments() throws RecognitionException {
		FunctionCallArgumentsContext _localctx = new FunctionCallArgumentsContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_functionCallArguments);
		int _la;
		try {
			setState(872);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(864);
				match(T__13);
				setState(866);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12 || _la==T__35 || _la==Identifier) {
					{
					setState(865);
					nameValueList();
					}
				}

				setState(868);
				match(T__15);
				}
				break;
			case T__3:
			case T__12:
			case T__17:
			case T__18:
			case T__28:
			case T__35:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__51:
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case BoolType:
			case StringType:
			case VarType:
			case Int:
			case Uint:
			case AByte:
			case Byte:
			case Fixed:
			case Ufixed:
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
				enterOuterAlt(_localctx, 2);
				{
				setState(870);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
					{
					setState(869);
					expressionList();
					}
				}

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
	public static class FunctionCallContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionCallArgumentsContext functionCallArguments() {
			return getRuleContext(FunctionCallArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
			expression(0);
			setState(875);
			match(T__17);
			setState(876);
			functionCallArguments();
			setState(877);
			match(T__18);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TupleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterTupleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitTupleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitTupleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleExpressionContext tupleExpression() throws RecognitionException {
		TupleExpressionContext _localctx = new TupleExpressionContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_tupleExpression);
		int _la;
		try {
			setState(905);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(879);
				match(T__17);
				{
				setState(881);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
					{
					setState(880);
					expression(0);
					}
				}

				setState(889);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(883);
					match(T__14);
					setState(885);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
						{
						setState(884);
						expression(0);
						}
					}

					}
					}
					setState(891);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(892);
				match(T__18);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(893);
				match(T__28);
				setState(902);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 141722720030433296L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 52093267967L) != 0) {
					{
					setState(894);
					expression(0);
					setState(899);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
						{
						setState(895);
						match(T__14);
						setState(896);
						expression(0);
						}
						}
						setState(901);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(904);
				match(T__29);
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
	public static class TypeNameExpressionContext extends ParserRuleContext {
		public ElementaryTypeNameContext elementaryTypeName() {
			return getRuleContext(ElementaryTypeNameContext.class,0);
		}
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public TypeNameExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeNameExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterTypeNameExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitTypeNameExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitTypeNameExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameExpressionContext typeNameExpression() throws RecognitionException {
		TypeNameExpressionContext _localctx = new TypeNameExpressionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_typeNameExpression);
		try {
			setState(909);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
			case BoolType:
			case StringType:
			case VarType:
			case Int:
			case Uint:
			case AByte:
			case Byte:
			case Fixed:
			case Ufixed:
				enterOuterAlt(_localctx, 1);
				{
				setState(907);
				elementaryTypeName();
				}
				break;
			case T__12:
			case T__35:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(908);
				userDefinedTypeName();
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
	public static class AssemblyItemContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyLocalDefinitionContext assemblyLocalDefinition() {
			return getRuleContext(AssemblyLocalDefinitionContext.class,0);
		}
		public AssemblyAssignmentContext assemblyAssignment() {
			return getRuleContext(AssemblyAssignmentContext.class,0);
		}
		public AssemblyStackAssignmentContext assemblyStackAssignment() {
			return getRuleContext(AssemblyStackAssignmentContext.class,0);
		}
		public LabelDefinitionContext labelDefinition() {
			return getRuleContext(LabelDefinitionContext.class,0);
		}
		public AssemblySwitchContext assemblySwitch() {
			return getRuleContext(AssemblySwitchContext.class,0);
		}
		public AssemblyFunctionDefinitionContext assemblyFunctionDefinition() {
			return getRuleContext(AssemblyFunctionDefinitionContext.class,0);
		}
		public AssemblyForContext assemblyFor() {
			return getRuleContext(AssemblyForContext.class,0);
		}
		public AssemblyIfContext assemblyIf() {
			return getRuleContext(AssemblyIfContext.class,0);
		}
		public TerminalNode BreakKeyword() { return getToken(SolidityParser.BreakKeyword, 0); }
		public TerminalNode ContinueKeyword() { return getToken(SolidityParser.ContinueKeyword, 0); }
		public TerminalNode LeaveKeyword() { return getToken(SolidityParser.LeaveKeyword, 0); }
		public SubAssemblyContext subAssembly() {
			return getRuleContext(SubAssemblyContext.class,0);
		}
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public HexLiteralContext hexLiteral() {
			return getRuleContext(HexLiteralContext.class,0);
		}
		public AssemblyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyItemContext assemblyItem() throws RecognitionException {
		AssemblyItemContext _localctx = new AssemblyItemContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_assemblyItem);
		try {
			setState(929);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(911);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(912);
				assemblyBlock();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(913);
				assemblyExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(914);
				assemblyLocalDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(915);
				assemblyAssignment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(916);
				assemblyStackAssignment();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(917);
				labelDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(918);
				assemblySwitch();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(919);
				assemblyFunctionDefinition();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(920);
				assemblyFor();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(921);
				assemblyIf();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(922);
				match(BreakKeyword);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(923);
				match(ContinueKeyword);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(924);
				match(LeaveKeyword);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(925);
				subAssembly();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(926);
				numberLiteral();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(927);
				stringLiteral();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(928);
				hexLiteral();
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
	public static class AssemblyBlockContext extends ParserRuleContext {
		public List<AssemblyItemContext> assemblyItem() {
			return getRuleContexts(AssemblyItemContext.class);
		}
		public AssemblyItemContext assemblyItem(int i) {
			return getRuleContext(AssemblyItemContext.class,i);
		}
		public AssemblyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyBlockContext assemblyBlock() throws RecognitionException {
		AssemblyBlockContext _localctx = new AssemblyBlockContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_assemblyBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(931);
			match(T__13);
			setState(935);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 162933917114368L) != 0 || (((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 52778247946253L) != 0) {
				{
				{
				setState(932);
				assemblyItem();
				}
				}
				setState(937);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(938);
			match(T__15);
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
	public static class AssemblyExpressionContext extends ParserRuleContext {
		public AssemblyCallContext assemblyCall() {
			return getRuleContext(AssemblyCallContext.class,0);
		}
		public AssemblyLiteralContext assemblyLiteral() {
			return getRuleContext(AssemblyLiteralContext.class,0);
		}
		public AssemblyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyExpressionContext assemblyExpression() throws RecognitionException {
		AssemblyExpressionContext _localctx = new AssemblyExpressionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_assemblyExpression);
		try {
			setState(942);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__35:
			case T__43:
			case T__46:
			case AByte:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(940);
				assemblyCall();
				}
				break;
			case BooleanLiteral:
			case DecimalNumber:
			case HexNumber:
			case HexLiteralFragment:
			case StringLiteralFragment:
				enterOuterAlt(_localctx, 2);
				{
				setState(941);
				assemblyLiteral();
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
	public static class AssemblyCallContext extends ParserRuleContext {
		public TerminalNode AByte() { return getToken(SolidityParser.AByte, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AssemblyExpressionContext> assemblyExpression() {
			return getRuleContexts(AssemblyExpressionContext.class);
		}
		public AssemblyExpressionContext assemblyExpression(int i) {
			return getRuleContext(AssemblyExpressionContext.class,i);
		}
		public AssemblyCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyCallContext assemblyCall() throws RecognitionException {
		AssemblyCallContext _localctx = new AssemblyCallContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_assemblyCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(948);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__43:
				{
				setState(944);
				match(T__43);
				}
				break;
			case T__46:
				{
				setState(945);
				match(T__46);
				}
				break;
			case AByte:
				{
				setState(946);
				match(AByte);
				}
				break;
			case T__12:
			case T__35:
			case Identifier:
				{
				setState(947);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(962);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(950);
				match(T__17);
				setState(952);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 158398393884672L) != 0 || (((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 1610613105L) != 0) {
					{
					setState(951);
					assemblyExpression();
					}
				}

				setState(958);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(954);
					match(T__14);
					setState(955);
					assemblyExpression();
					}
					}
					setState(960);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(961);
				match(T__18);
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
	public static class AssemblyLocalDefinitionContext extends ParserRuleContext {
		public AssemblyIdentifierListContext assemblyIdentifierList() {
			return getRuleContext(AssemblyIdentifierListContext.class,0);
		}
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyLocalDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyLocalDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyLocalDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyLocalDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyLocalDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyLocalDefinitionContext assemblyLocalDefinition() throws RecognitionException {
		AssemblyLocalDefinitionContext _localctx = new AssemblyLocalDefinitionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_assemblyLocalDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(964);
			match(T__78);
			setState(965);
			assemblyIdentifierList();
			setState(968);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__79) {
				{
				setState(966);
				match(T__79);
				setState(967);
				assemblyExpression();
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
	public static class AssemblyAssignmentContext extends ParserRuleContext {
		public AssemblyIdentifierListContext assemblyIdentifierList() {
			return getRuleContext(AssemblyIdentifierListContext.class,0);
		}
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyAssignmentContext assemblyAssignment() throws RecognitionException {
		AssemblyAssignmentContext _localctx = new AssemblyAssignmentContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_assemblyAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(970);
			assemblyIdentifierList();
			setState(971);
			match(T__79);
			setState(972);
			assemblyExpression();
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
	public static class AssemblyIdentifierListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public AssemblyIdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyIdentifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyIdentifierListContext assemblyIdentifierList() throws RecognitionException {
		AssemblyIdentifierListContext _localctx = new AssemblyIdentifierListContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_assemblyIdentifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(974);
			identifier();
			setState(979);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(975);
				match(T__14);
				setState(976);
				identifier();
				}
				}
				setState(981);
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
	public static class AssemblyStackAssignmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyStackAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyStackAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyStackAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyStackAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyStackAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyStackAssignmentContext assemblyStackAssignment() throws RecognitionException {
		AssemblyStackAssignmentContext _localctx = new AssemblyStackAssignmentContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_assemblyStackAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(982);
			match(T__80);
			setState(983);
			identifier();
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
	public static class LabelDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LabelDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterLabelDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitLabelDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitLabelDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelDefinitionContext labelDefinition() throws RecognitionException {
		LabelDefinitionContext _localctx = new LabelDefinitionContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_labelDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(985);
			identifier();
			setState(986);
			match(T__50);
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
	public static class AssemblySwitchContext extends ParserRuleContext {
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public List<AssemblyCaseContext> assemblyCase() {
			return getRuleContexts(AssemblyCaseContext.class);
		}
		public AssemblyCaseContext assemblyCase(int i) {
			return getRuleContext(AssemblyCaseContext.class,i);
		}
		public AssemblySwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblySwitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblySwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblySwitch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblySwitch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblySwitchContext assemblySwitch() throws RecognitionException {
		AssemblySwitchContext _localctx = new AssemblySwitchContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_assemblySwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(988);
			match(T__81);
			setState(989);
			assemblyExpression();
			setState(993);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__82 || _la==T__83) {
				{
				{
				setState(990);
				assemblyCase();
				}
				}
				setState(995);
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
	public static class AssemblyCaseContext extends ParserRuleContext {
		public AssemblyLiteralContext assemblyLiteral() {
			return getRuleContext(AssemblyLiteralContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public AssemblyTypeContext assemblyType() {
			return getRuleContext(AssemblyTypeContext.class,0);
		}
		public AssemblyCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyCaseContext assemblyCase() throws RecognitionException {
		AssemblyCaseContext _localctx = new AssemblyCaseContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_assemblyCase);
		int _la;
		try {
			setState(1005);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__82:
				enterOuterAlt(_localctx, 1);
				{
				setState(996);
				match(T__82);
				setState(997);
				assemblyLiteral();
				setState(999);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__50) {
					{
					setState(998);
					assemblyType();
					}
				}

				setState(1001);
				assemblyBlock();
				}
				break;
			case T__83:
				enterOuterAlt(_localctx, 2);
				{
				setState(1003);
				match(T__83);
				setState(1004);
				assemblyBlock();
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
	public static class AssemblyFunctionDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public AssemblyTypedVariableListContext assemblyTypedVariableList() {
			return getRuleContext(AssemblyTypedVariableListContext.class,0);
		}
		public AssemblyFunctionReturnsContext assemblyFunctionReturns() {
			return getRuleContext(AssemblyFunctionReturnsContext.class,0);
		}
		public AssemblyFunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyFunctionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyFunctionDefinitionContext assemblyFunctionDefinition() throws RecognitionException {
		AssemblyFunctionDefinitionContext _localctx = new AssemblyFunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_assemblyFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1007);
			match(T__24);
			setState(1008);
			identifier();
			setState(1009);
			match(T__17);
			setState(1011);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__35 || _la==Identifier) {
				{
				setState(1010);
				assemblyTypedVariableList();
				}
			}

			setState(1013);
			match(T__18);
			setState(1015);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__52) {
				{
				setState(1014);
				assemblyFunctionReturns();
				}
			}

			setState(1017);
			assemblyBlock();
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
	public static class AssemblyFunctionReturnsContext extends ParserRuleContext {
		public AssemblyTypedVariableListContext assemblyTypedVariableList() {
			return getRuleContext(AssemblyTypedVariableListContext.class,0);
		}
		public AssemblyFunctionReturnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyFunctionReturns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyFunctionReturns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyFunctionReturns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyFunctionReturns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyFunctionReturnsContext assemblyFunctionReturns() throws RecognitionException {
		AssemblyFunctionReturnsContext _localctx = new AssemblyFunctionReturnsContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_assemblyFunctionReturns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1019);
			match(T__52);
			setState(1020);
			match(T__5);
			setState(1021);
			assemblyTypedVariableList();
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
	public static class AssemblyForContext extends ParserRuleContext {
		public List<AssemblyBlockContext> assemblyBlock() {
			return getRuleContexts(AssemblyBlockContext.class);
		}
		public AssemblyBlockContext assemblyBlock(int i) {
			return getRuleContext(AssemblyBlockContext.class,i);
		}
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyForContext assemblyFor() throws RecognitionException {
		AssemblyForContext _localctx = new AssemblyForContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_assemblyFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1023);
			match(T__21);
			setState(1024);
			assemblyBlock();
			setState(1025);
			assemblyExpression();
			setState(1026);
			assemblyBlock();
			setState(1027);
			assemblyBlock();
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
	public static class AssemblyIfContext extends ParserRuleContext {
		public AssemblyExpressionContext assemblyExpression() {
			return getRuleContext(AssemblyExpressionContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public AssemblyIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyIfContext assemblyIf() throws RecognitionException {
		AssemblyIfContext _localctx = new AssemblyIfContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_assemblyIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			match(T__36);
			setState(1030);
			assemblyExpression();
			setState(1031);
			assemblyBlock();
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
	public static class AssemblyLiteralContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public TerminalNode DecimalNumber() { return getToken(SolidityParser.DecimalNumber, 0); }
		public TerminalNode HexNumber() { return getToken(SolidityParser.HexNumber, 0); }
		public HexLiteralContext hexLiteral() {
			return getRuleContext(HexLiteralContext.class,0);
		}
		public TerminalNode BooleanLiteral() { return getToken(SolidityParser.BooleanLiteral, 0); }
		public AssemblyTypeContext assemblyType() {
			return getRuleContext(AssemblyTypeContext.class,0);
		}
		public AssemblyLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyLiteralContext assemblyLiteral() throws RecognitionException {
		AssemblyLiteralContext _localctx = new AssemblyLiteralContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_assemblyLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1038);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteralFragment:
				{
				setState(1033);
				stringLiteral();
				}
				break;
			case DecimalNumber:
				{
				setState(1034);
				match(DecimalNumber);
				}
				break;
			case HexNumber:
				{
				setState(1035);
				match(HexNumber);
				}
				break;
			case HexLiteralFragment:
				{
				setState(1036);
				hexLiteral();
				}
				break;
			case BooleanLiteral:
				{
				setState(1037);
				match(BooleanLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1041);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				{
				setState(1040);
				assemblyType();
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
	public static class AssemblyTypedVariableListContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyTypeContext assemblyType() {
			return getRuleContext(AssemblyTypeContext.class,0);
		}
		public AssemblyTypedVariableListContext assemblyTypedVariableList() {
			return getRuleContext(AssemblyTypedVariableListContext.class,0);
		}
		public AssemblyTypedVariableListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyTypedVariableList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyTypedVariableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyTypedVariableList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyTypedVariableList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyTypedVariableListContext assemblyTypedVariableList() throws RecognitionException {
		AssemblyTypedVariableListContext _localctx = new AssemblyTypedVariableListContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_assemblyTypedVariableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1043);
			identifier();
			setState(1045);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__50) {
				{
				setState(1044);
				assemblyType();
				}
			}

			setState(1049);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(1047);
				match(T__14);
				setState(1048);
				assemblyTypedVariableList();
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
	public static class AssemblyTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyTypeContext assemblyType() throws RecognitionException {
		AssemblyTypeContext _localctx = new AssemblyTypeContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_assemblyType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1051);
			match(T__50);
			setState(1052);
			identifier();
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
	public static class SubAssemblyContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssemblyBlockContext assemblyBlock() {
			return getRuleContext(AssemblyBlockContext.class,0);
		}
		public SubAssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subAssembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterSubAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitSubAssembly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitSubAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubAssemblyContext subAssembly() throws RecognitionException {
		SubAssemblyContext _localctx = new SubAssemblyContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_subAssembly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1054);
			match(T__41);
			setState(1055);
			identifier();
			setState(1056);
			assemblyBlock();
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
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_numberLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1058);
			_la = _input.LA(1);
			if ( !(_la==DecimalNumber || _la==HexNumber) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1060);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				{
				setState(1059);
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(SolidityParser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__35 || _la==Identifier) ) {
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
	public static class HexLiteralContext extends ParserRuleContext {
		public List<TerminalNode> HexLiteralFragment() { return getTokens(SolidityParser.HexLiteralFragment); }
		public TerminalNode HexLiteralFragment(int i) {
			return getToken(SolidityParser.HexLiteralFragment, i);
		}
		public HexLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterHexLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitHexLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitHexLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HexLiteralContext hexLiteral() throws RecognitionException {
		HexLiteralContext _localctx = new HexLiteralContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_hexLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1065); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1064);
					match(HexLiteralFragment);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1067); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
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
	public static class StringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> StringLiteralFragment() { return getTokens(SolidityParser.StringLiteralFragment); }
		public TerminalNode StringLiteralFragment(int i) {
			return getToken(SolidityParser.StringLiteralFragment, i);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_stringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1070); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1069);
					match(StringLiteralFragment);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1072); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 30:
			return typeName_sempred((TypeNameContext)_localctx, predIndex);
		case 59:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeName_sempred(TypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 29);
		case 14:
			return precpred(_ctx, 27);
		case 15:
			return precpred(_ctx, 26);
		case 16:
			return precpred(_ctx, 25);
		case 17:
			return precpred(_ctx, 24);
		case 18:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0080\u0433\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\u00be\b\u0000\n\u0000\f\u0000\u00c1\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\u00ce\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004\u00d2\b\u0004\u0001"+
		"\u0005\u0003\u0005\u00d5\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00df"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00e5"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00e9\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u00f3\b\u0007\n\u0007\f\u0007\u00f6\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00fd"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u0102\b\b\u0001\t\u0003\t\u0105"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u010d\b\t"+
		"\n\t\f\t\u0110\t\t\u0003\t\u0112\b\t\u0001\t\u0001\t\u0005\t\u0116\b\t"+
		"\n\t\f\t\u0119\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n\u0120"+
		"\b\n\u0001\n\u0003\n\u0123\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u012c\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0135\b\f\n"+
		"\f\f\f\u0138\t\f\u0001\f\u0001\f\u0001\f\u0003\f\u013d\b\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0146\b\r\n\r\f\r\u0149"+
		"\t\r\u0001\r\u0001\r\u0003\r\u014d\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0154\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u0160\b\u000f\n\u000f\f\u000f\u0163"+
		"\t\u000f\u0003\u000f\u0165\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u016c\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u0170\b\u0010\n\u0010\f\u0010\u0173\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u0177\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u017d\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0181"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u0188\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u018d"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u0196\b\u0014\n\u0014\f\u0014\u0199\t\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u019e\b\u0015\u0001\u0015"+
		"\u0003\u0015\u01a1\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u01a7\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u01af\b\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u01b3\b\u0017\n\u0017\f\u0017\u01b6\t\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u01c0\b\u0019\n\u0019\f\u0019\u01c3\t\u0019\u0003\u0019"+
		"\u01c5\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u01cb\b\u001a\u0001\u001a\u0003\u001a\u01ce\b\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u01d4\b\u001b\n\u001b\f\u001b"+
		"\u01d7\t\u001b\u0003\u001b\u01d9\b\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u01df\b\u001c\u0001\u001c\u0003\u001c\u01e2"+
		"\b\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u01e6\b\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u01ef\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e"+
		"\u01f4\b\u001e\u0001\u001e\u0005\u001e\u01f7\b\u001e\n\u001e\f\u001e\u01fa"+
		"\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u01ff\b\u001f"+
		"\n\u001f\f\u001f\u0202\t\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001!\u0001!\u0003!\u020d\b!\u0001\"\u0001\"\u0001\"\u0001\""+
		"\u0003\"\u0213\b\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001"+
		"&\u0005&\u021d\b&\n&\f&\u0220\t&\u0001&\u0001&\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0003\'\u0231\b\'\u0001(\u0001(\u0001(\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0003)\u023d\b)\u0001*\u0001*\u0001*\u0003"+
		"*\u0242\b*\u0001*\u0001*\u0004*\u0246\b*\u000b*\f*\u0247\u0001+\u0001"+
		"+\u0003+\u024c\b+\u0001+\u0003+\u024f\b+\u0001+\u0001+\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0003-\u025d\b-\u0001"+
		"-\u0001-\u0003-\u0261\b-\u0001-\u0003-\u0264\b-\u0001-\u0001-\u0001-\u0001"+
		".\u0001.\u0003.\u026b\b.\u0001/\u0001/\u0003/\u026f\b/\u0001/\u0001/\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u0001"+
		"1\u00012\u00012\u00012\u00013\u00013\u00033\u0283\b3\u00013\u00013\u0001"+
		"4\u00014\u00014\u00015\u00015\u00015\u00015\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00036\u0295\b6\u00016\u00016\u00036\u0299\b6\u0001"+
		"6\u00016\u00017\u00037\u029e\b7\u00017\u00017\u00037\u02a2\b7\u00057\u02a4"+
		"\b7\n7\f7\u02a7\t7\u00018\u00018\u00038\u02ab\b8\u00018\u00058\u02ae\b"+
		"8\n8\f8\u02b1\t8\u00018\u00038\u02b4\b8\u00018\u00018\u00019\u00019\u0001"+
		"9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00039\u02c2\b9\u0001"+
		":\u0001:\u0003:\u02c6\b:\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0003;\u02e6\b;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0003;\u0311\b;\u0001;\u0001"+
		";\u0001;\u0001;\u0003;\u0317\b;\u0001;\u0001;\u0003;\u031b\b;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0003;\u0324\b;\u0001;\u0003;\u0327"+
		"\b;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0005;\u0333\b;\n;\f;\u0336\t;\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0003<\u033e\b<\u0001<\u0001<\u0001<\u0003<\u0343\b<\u0003<\u0345\b"+
		"<\u0001=\u0001=\u0001=\u0001>\u0001>\u0001>\u0005>\u034d\b>\n>\f>\u0350"+
		"\t>\u0001?\u0001?\u0001?\u0005?\u0355\b?\n?\f?\u0358\t?\u0001?\u0003?"+
		"\u035b\b?\u0001@\u0001@\u0001@\u0001@\u0001A\u0001A\u0003A\u0363\bA\u0001"+
		"A\u0001A\u0003A\u0367\bA\u0003A\u0369\bA\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0001C\u0001C\u0003C\u0372\bC\u0001C\u0001C\u0003C\u0376\bC\u0005C\u0378"+
		"\bC\nC\fC\u037b\tC\u0001C\u0001C\u0001C\u0001C\u0001C\u0005C\u0382\bC"+
		"\nC\fC\u0385\tC\u0003C\u0387\bC\u0001C\u0003C\u038a\bC\u0001D\u0001D\u0003"+
		"D\u038e\bD\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001"+
		"E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0003"+
		"E\u03a2\bE\u0001F\u0001F\u0005F\u03a6\bF\nF\fF\u03a9\tF\u0001F\u0001F"+
		"\u0001G\u0001G\u0003G\u03af\bG\u0001H\u0001H\u0001H\u0001H\u0003H\u03b5"+
		"\bH\u0001H\u0001H\u0003H\u03b9\bH\u0001H\u0001H\u0005H\u03bd\bH\nH\fH"+
		"\u03c0\tH\u0001H\u0003H\u03c3\bH\u0001I\u0001I\u0001I\u0001I\u0003I\u03c9"+
		"\bI\u0001J\u0001J\u0001J\u0001J\u0001K\u0001K\u0001K\u0005K\u03d2\bK\n"+
		"K\fK\u03d5\tK\u0001L\u0001L\u0001L\u0001M\u0001M\u0001M\u0001N\u0001N"+
		"\u0001N\u0005N\u03e0\bN\nN\fN\u03e3\tN\u0001O\u0001O\u0001O\u0003O\u03e8"+
		"\bO\u0001O\u0001O\u0001O\u0001O\u0003O\u03ee\bO\u0001P\u0001P\u0001P\u0001"+
		"P\u0003P\u03f4\bP\u0001P\u0001P\u0003P\u03f8\bP\u0001P\u0001P\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001S\u0001"+
		"S\u0001S\u0001S\u0001T\u0001T\u0001T\u0001T\u0001T\u0003T\u040f\bT\u0001"+
		"T\u0003T\u0412\bT\u0001U\u0001U\u0003U\u0416\bU\u0001U\u0001U\u0003U\u041a"+
		"\bU\u0001V\u0001V\u0001V\u0001W\u0001W\u0001W\u0001W\u0001X\u0001X\u0003"+
		"X\u0425\bX\u0001Y\u0001Y\u0001Z\u0004Z\u042a\bZ\u000bZ\fZ\u042b\u0001"+
		"[\u0004[\u042f\b[\u000b[\f[\u0430\u0001[\u0000\u0002<v\\\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u0000\u000e\u0001\u0000\u0003\t\u0001\u0000UW\u0001\u0000\"$\u0004\u0000"+
		"jjqquuww\u0003\u0000nnpprt\u0001\u000001\u0001\u000045\u0002\u0000\f\f"+
		":;\u0001\u0000<=\u0001\u0000\u0005\b\u0001\u0000@A\u0002\u0000\t\tEN\u0001"+
		"\u0000cd\u0003\u0000\r\r$${{\u04af\u0000\u00bf\u0001\u0000\u0000\u0000"+
		"\u0002\u00c4\u0001\u0000\u0000\u0000\u0004\u00c9\u0001\u0000\u0000\u0000"+
		"\u0006\u00cd\u0001\u0000\u0000\u0000\b\u00cf\u0001\u0000\u0000\u0000\n"+
		"\u00d4\u0001\u0000\u0000\u0000\f\u00d8\u0001\u0000\u0000\u0000\u000e\u00fc"+
		"\u0001\u0000\u0000\u0000\u0010\u00fe\u0001\u0000\u0000\u0000\u0012\u0104"+
		"\u0001\u0000\u0000\u0000\u0014\u011c\u0001\u0000\u0000\u0000\u0016\u012b"+
		"\u0001\u0000\u0000\u0000\u0018\u012d\u0001\u0000\u0000\u0000\u001a\u0140"+
		"\u0001\u0000\u0000\u0000\u001c\u014e\u0001\u0000\u0000\u0000\u001e\u0157"+
		"\u0001\u0000\u0000\u0000 \u0168\u0001\u0000\u0000\u0000\"\u0178\u0001"+
		"\u0000\u0000\u0000$\u018c\u0001\u0000\u0000\u0000&\u018e\u0001\u0000\u0000"+
		"\u0000(\u0197\u0001\u0000\u0000\u0000*\u019a\u0001\u0000\u0000\u0000,"+
		"\u01a2\u0001\u0000\u0000\u0000.\u01aa\u0001\u0000\u0000\u00000\u01b9\u0001"+
		"\u0000\u0000\u00002\u01bb\u0001\u0000\u0000\u00004\u01c8\u0001\u0000\u0000"+
		"\u00006\u01cf\u0001\u0000\u0000\u00008\u01dc\u0001\u0000\u0000\u0000:"+
		"\u01e3\u0001\u0000\u0000\u0000<\u01ee\u0001\u0000\u0000\u0000>\u01fb\u0001"+
		"\u0000\u0000\u0000@\u0203\u0001\u0000\u0000\u0000B\u020c\u0001\u0000\u0000"+
		"\u0000D\u020e\u0001\u0000\u0000\u0000F\u0214\u0001\u0000\u0000\u0000H"+
		"\u0216\u0001\u0000\u0000\u0000J\u0218\u0001\u0000\u0000\u0000L\u021a\u0001"+
		"\u0000\u0000\u0000N\u0230\u0001\u0000\u0000\u0000P\u0232\u0001\u0000\u0000"+
		"\u0000R\u0235\u0001\u0000\u0000\u0000T\u023e\u0001\u0000\u0000\u0000V"+
		"\u0249\u0001\u0000\u0000\u0000X\u0252\u0001\u0000\u0000\u0000Z\u0258\u0001"+
		"\u0000\u0000\u0000\\\u026a\u0001\u0000\u0000\u0000^\u026c\u0001\u0000"+
		"\u0000\u0000`\u0272\u0001\u0000\u0000\u0000b\u027a\u0001\u0000\u0000\u0000"+
		"d\u027d\u0001\u0000\u0000\u0000f\u0280\u0001\u0000\u0000\u0000h\u0286"+
		"\u0001\u0000\u0000\u0000j\u0289\u0001\u0000\u0000\u0000l\u0294\u0001\u0000"+
		"\u0000\u0000n\u029d\u0001\u0000\u0000\u0000p\u02a8\u0001\u0000\u0000\u0000"+
		"r\u02c1\u0001\u0000\u0000\u0000t\u02c3\u0001\u0000\u0000\u0000v\u02e5"+
		"\u0001\u0000\u0000\u0000x\u0344\u0001\u0000\u0000\u0000z\u0346\u0001\u0000"+
		"\u0000\u0000|\u0349\u0001\u0000\u0000\u0000~\u0351\u0001\u0000\u0000\u0000"+
		"\u0080\u035c\u0001\u0000\u0000\u0000\u0082\u0368\u0001\u0000\u0000\u0000"+
		"\u0084\u036a\u0001\u0000\u0000\u0000\u0086\u0389\u0001\u0000\u0000\u0000"+
		"\u0088\u038d\u0001\u0000\u0000\u0000\u008a\u03a1\u0001\u0000\u0000\u0000"+
		"\u008c\u03a3\u0001\u0000\u0000\u0000\u008e\u03ae\u0001\u0000\u0000\u0000"+
		"\u0090\u03b4\u0001\u0000\u0000\u0000\u0092\u03c4\u0001\u0000\u0000\u0000"+
		"\u0094\u03ca\u0001\u0000\u0000\u0000\u0096\u03ce\u0001\u0000\u0000\u0000"+
		"\u0098\u03d6\u0001\u0000\u0000\u0000\u009a\u03d9\u0001\u0000\u0000\u0000"+
		"\u009c\u03dc\u0001\u0000\u0000\u0000\u009e\u03ed\u0001\u0000\u0000\u0000"+
		"\u00a0\u03ef\u0001\u0000\u0000\u0000\u00a2\u03fb\u0001\u0000\u0000\u0000"+
		"\u00a4\u03ff\u0001\u0000\u0000\u0000\u00a6\u0405\u0001\u0000\u0000\u0000"+
		"\u00a8\u040e\u0001\u0000\u0000\u0000\u00aa\u0413\u0001\u0000\u0000\u0000"+
		"\u00ac\u041b\u0001\u0000\u0000\u0000\u00ae\u041e\u0001\u0000\u0000\u0000"+
		"\u00b0\u0422\u0001\u0000\u0000\u0000\u00b2\u0426\u0001\u0000\u0000\u0000"+
		"\u00b4\u0429\u0001\u0000\u0000\u0000\u00b6\u042e\u0001\u0000\u0000\u0000"+
		"\u00b8\u00be\u0003\u0002\u0001\u0000\u00b9\u00be\u0003\u000e\u0007\u0000"+
		"\u00ba\u00be\u0003\u001e\u000f\u0000\u00bb\u00be\u0003.\u0017\u0000\u00bc"+
		"\u00be\u0003\u0012\t\u0000\u00bd\u00b8\u0001\u0000\u0000\u0000\u00bd\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bd\u00ba\u0001\u0000\u0000\u0000\u00bd\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00c1"+
		"\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0000\u0000\u0001\u00c3\u0001"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0001\u0000\u0000\u00c5\u00c6"+
		"\u0003\u0004\u0002\u0000\u00c6\u00c7\u0003\u0006\u0003\u0000\u00c7\u00c8"+
		"\u0005\u0002\u0000\u0000\u00c8\u0003\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0003\u00b2Y\u0000\u00ca\u0005\u0001\u0000\u0000\u0000\u00cb\u00ce\u0003"+
		"\b\u0004\u0000\u00cc\u00ce\u0003v;\u0000\u00cd\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u0007\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d1\u0003\n\u0005\u0000\u00d0\u00d2\u0003\n\u0005\u0000"+
		"\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d2\t\u0001\u0000\u0000\u0000\u00d3\u00d5\u0003\f\u0006\u0000\u00d4"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005}\u0000\u0000\u00d7\u000b"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0007\u0000\u0000\u0000\u00d9\r\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u0005\n\u0000\u0000\u00db\u00de\u0005|"+
		"\u0000\u0000\u00dc\u00dd\u0005\u000b\u0000\u0000\u00dd\u00df\u0003\u00b2"+
		"Y\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00fd\u0005\u0002\u0000"+
		"\u0000\u00e1\u00e4\u0005\n\u0000\u0000\u00e2\u00e5\u0005\f\u0000\u0000"+
		"\u00e3\u00e5\u0003\u00b2Y\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u0005\u000b\u0000\u0000\u00e7\u00e9\u0003\u00b2Y\u0000\u00e8\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\r\u0000\u0000\u00eb\u00ec\u0005"+
		"|\u0000\u0000\u00ec\u00fd\u0005\u0002\u0000\u0000\u00ed\u00ee\u0005\n"+
		"\u0000\u0000\u00ee\u00ef\u0005\u000e\u0000\u0000\u00ef\u00f4\u0003\u0010"+
		"\b\u0000\u00f0\u00f1\u0005\u000f\u0000\u0000\u00f1\u00f3\u0003\u0010\b"+
		"\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u0005\u0010\u0000\u0000\u00f8\u00f9\u0005\r\u0000\u0000"+
		"\u00f9\u00fa\u0005|\u0000\u0000\u00fa\u00fb\u0005\u0002\u0000\u0000\u00fb"+
		"\u00fd\u0001\u0000\u0000\u0000\u00fc\u00da\u0001\u0000\u0000\u0000\u00fc"+
		"\u00e1\u0001\u0000\u0000\u0000\u00fc\u00ed\u0001\u0000\u0000\u0000\u00fd"+
		"\u000f\u0001\u0000\u0000\u0000\u00fe\u0101\u0003\u00b2Y\u0000\u00ff\u0100"+
		"\u0005\u000b\u0000\u0000\u0100\u0102\u0003\u00b2Y\u0000\u0101\u00ff\u0001"+
		"\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0011\u0001"+
		"\u0000\u0000\u0000\u0103\u0105\u0005X\u0000\u0000\u0104\u0103\u0001\u0000"+
		"\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\u0007\u0001\u0000\u0000\u0107\u0111\u0003\u00b2"+
		"Y\u0000\u0108\u0109\u0005\u0011\u0000\u0000\u0109\u010e\u0003\u0014\n"+
		"\u0000\u010a\u010b\u0005\u000f\u0000\u0000\u010b\u010d\u0003\u0014\n\u0000"+
		"\u010c\u010a\u0001\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000\u0000"+
		"\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000"+
		"\u010f\u0112\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000"+
		"\u0111\u0108\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0117\u0005\u000e\u0000\u0000"+
		"\u0114\u0116\u0003\u0016\u000b\u0000\u0115\u0114\u0001\u0000\u0000\u0000"+
		"\u0116\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u011a\u0001\u0000\u0000\u0000"+
		"\u0119\u0117\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u0010\u0000\u0000"+
		"\u011b\u0013\u0001\u0000\u0000\u0000\u011c\u0122\u0003>\u001f\u0000\u011d"+
		"\u011f\u0005\u0012\u0000\u0000\u011e\u0120\u0003|>\u0000\u011f\u011e\u0001"+
		"\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0121\u0001"+
		"\u0000\u0000\u0000\u0121\u0123\u0005\u0013\u0000\u0000\u0122\u011d\u0001"+
		"\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0015\u0001"+
		"\u0000\u0000\u0000\u0124\u012c\u0003\u0018\f\u0000\u0125\u012c\u0003\u001c"+
		"\u000e\u0000\u0126\u012c\u0003\u001e\u000f\u0000\u0127\u012c\u0003 \u0010"+
		"\u0000\u0128\u012c\u0003\"\u0011\u0000\u0129\u012c\u0003,\u0016\u0000"+
		"\u012a\u012c\u0003.\u0017\u0000\u012b\u0124\u0001\u0000\u0000\u0000\u012b"+
		"\u0125\u0001\u0000\u0000\u0000\u012b\u0126\u0001\u0000\u0000\u0000\u012b"+
		"\u0127\u0001\u0000\u0000\u0000\u012b\u0128\u0001\u0000\u0000\u0000\u012b"+
		"\u0129\u0001\u0000\u0000\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c"+
		"\u0017\u0001\u0000\u0000\u0000\u012d\u0136\u0003<\u001e\u0000\u012e\u0135"+
		"\u0005s\u0000\u0000\u012f\u0135\u0005p\u0000\u0000\u0130\u0135\u0005r"+
		"\u0000\u0000\u0131\u0135\u0005j\u0000\u0000\u0132\u0135\u0005k\u0000\u0000"+
		"\u0133\u0135\u0003\u001a\r\u0000\u0134\u012e\u0001\u0000\u0000\u0000\u0134"+
		"\u012f\u0001\u0000\u0000\u0000\u0134\u0130\u0001\u0000\u0000\u0000\u0134"+
		"\u0131\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134"+
		"\u0133\u0001\u0000\u0000\u0000\u0135\u0138\u0001\u0000\u0000\u0000\u0136"+
		"\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137"+
		"\u0139\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0139"+
		"\u013c\u0003\u00b2Y\u0000\u013a\u013b\u0005\t\u0000\u0000\u013b\u013d"+
		"\u0003v;\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000"+
		"\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u013f\u0005\u0002"+
		"\u0000\u0000\u013f\u0019\u0001\u0000\u0000\u0000\u0140\u014c\u0005\u0014"+
		"\u0000\u0000\u0141\u0142\u0005\u0012\u0000\u0000\u0142\u0147\u0003>\u001f"+
		"\u0000\u0143\u0144\u0005\u000f\u0000\u0000\u0144\u0146\u0003>\u001f\u0000"+
		"\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u0149\u0001\u0000\u0000\u0000"+
		"\u0147\u0145\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000"+
		"\u0148\u014a\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000"+
		"\u014a\u014b\u0005\u0013\u0000\u0000\u014b\u014d\u0001\u0000\u0000\u0000"+
		"\u014c\u0141\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000"+
		"\u014d\u001b\u0001\u0000\u0000\u0000\u014e\u014f\u0005\u0015\u0000\u0000"+
		"\u014f\u0150\u0003\u00b2Y\u0000\u0150\u0153\u0005\u0016\u0000\u0000\u0151"+
		"\u0154\u0005\f\u0000\u0000\u0152\u0154\u0003<\u001e\u0000\u0153\u0151"+
		"\u0001\u0000\u0000\u0000\u0153\u0152\u0001\u0000\u0000\u0000\u0154\u0155"+
		"\u0001\u0000\u0000\u0000\u0155\u0156\u0005\u0002\u0000\u0000\u0156\u001d"+
		"\u0001\u0000\u0000\u0000\u0157\u0158\u0005\u0017\u0000\u0000\u0158\u0159"+
		"\u0003\u00b2Y\u0000\u0159\u0164\u0005\u000e\u0000\u0000\u015a\u015b\u0003"+
		":\u001d\u0000\u015b\u0161\u0005\u0002\u0000\u0000\u015c\u015d\u0003:\u001d"+
		"\u0000\u015d\u015e\u0005\u0002\u0000\u0000\u015e\u0160\u0001\u0000\u0000"+
		"\u0000\u015f\u015c\u0001\u0000\u0000\u0000\u0160\u0163\u0001\u0000\u0000"+
		"\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000"+
		"\u0000\u0162\u0165\u0001\u0000\u0000\u0000\u0163\u0161\u0001\u0000\u0000"+
		"\u0000\u0164\u015a\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000"+
		"\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166\u0167\u0005\u0010\u0000"+
		"\u0000\u0167\u001f\u0001\u0000\u0000\u0000\u0168\u0169\u0005\u0018\u0000"+
		"\u0000\u0169\u016b\u0003\u00b2Y\u0000\u016a\u016c\u00032\u0019\u0000\u016b"+
		"\u016a\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c"+
		"\u0171\u0001\u0000\u0000\u0000\u016d\u0170\u0005t\u0000\u0000\u016e\u0170"+
		"\u0003\u001a\r\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u016e\u0001"+
		"\u0000\u0000\u0000\u0170\u0173\u0001\u0000\u0000\u0000\u0171\u016f\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0176\u0001"+
		"\u0000\u0000\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0174\u0177\u0005"+
		"\u0002\u0000\u0000\u0175\u0177\u0003L&\u0000\u0176\u0174\u0001\u0000\u0000"+
		"\u0000\u0176\u0175\u0001\u0000\u0000\u0000\u0177!\u0001\u0000\u0000\u0000"+
		"\u0178\u0179\u0003$\u0012\u0000\u0179\u017a\u00032\u0019\u0000\u017a\u017c"+
		"\u0003(\u0014\u0000\u017b\u017d\u0003&\u0013\u0000\u017c\u017b\u0001\u0000"+
		"\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000\u017d\u0180\u0001\u0000"+
		"\u0000\u0000\u017e\u0181\u0005\u0002\u0000\u0000\u017f\u0181\u0003L&\u0000"+
		"\u0180\u017e\u0001\u0000\u0000\u0000\u0180\u017f\u0001\u0000\u0000\u0000"+
		"\u0181#\u0001\u0000\u0000\u0000\u0182\u0187\u0005\u0019\u0000\u0000\u0183"+
		"\u0188\u0003\u00b2Y\u0000\u0184\u0188\u0005z\u0000\u0000\u0185\u0188\u0005"+
		"y\u0000\u0000\u0186\u0188\u0005x\u0000\u0000\u0187\u0183\u0001\u0000\u0000"+
		"\u0000\u0187\u0184\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000"+
		"\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000"+
		"\u0000\u0188\u018d\u0001\u0000\u0000\u0000\u0189\u018d\u0005x\u0000\u0000"+
		"\u018a\u018d\u0005y\u0000\u0000\u018b\u018d\u0005z\u0000\u0000\u018c\u0182"+
		"\u0001\u0000\u0000\u0000\u018c\u0189\u0001\u0000\u0000\u0000\u018c\u018a"+
		"\u0001\u0000\u0000\u0000\u018c\u018b\u0001\u0000\u0000\u0000\u018d%\u0001"+
		"\u0000\u0000\u0000\u018e\u018f\u0005\u001a\u0000\u0000\u018f\u0190\u0003"+
		"2\u0019\u0000\u0190\'\u0001\u0000\u0000\u0000\u0191\u0196\u0003*\u0015"+
		"\u0000\u0192\u0196\u0003H$\u0000\u0193\u0196\u0003J%\u0000\u0194\u0196"+
		"\u0003\u001a\r\u0000\u0195\u0191\u0001\u0000\u0000\u0000\u0195\u0192\u0001"+
		"\u0000\u0000\u0000\u0195\u0193\u0001\u0000\u0000\u0000\u0195\u0194\u0001"+
		"\u0000\u0000\u0000\u0196\u0199\u0001\u0000\u0000\u0000\u0197\u0195\u0001"+
		"\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u0198)\u0001\u0000"+
		"\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u019a\u01a0\u0003\u00b2"+
		"Y\u0000\u019b\u019d\u0005\u0012\u0000\u0000\u019c\u019e\u0003|>\u0000"+
		"\u019d\u019c\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000"+
		"\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u01a1\u0005\u0013\u0000\u0000"+
		"\u01a0\u019b\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000"+
		"\u01a1+\u0001\u0000\u0000\u0000\u01a2\u01a3\u0005\u001b\u0000\u0000\u01a3"+
		"\u01a4\u0003\u00b2Y\u0000\u01a4\u01a6\u00036\u001b\u0000\u01a5\u01a7\u0005"+
		"h\u0000\u0000\u01a6\u01a5\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000"+
		"\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8\u01a9\u0005\u0002"+
		"\u0000\u0000\u01a9-\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005\u001c\u0000"+
		"\u0000\u01ab\u01ac\u0003\u00b2Y\u0000\u01ac\u01ae\u0005\u000e\u0000\u0000"+
		"\u01ad\u01af\u00030\u0018\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01ae"+
		"\u01af\u0001\u0000\u0000\u0000\u01af\u01b4\u0001\u0000\u0000\u0000\u01b0"+
		"\u01b1\u0005\u000f\u0000\u0000\u01b1\u01b3\u00030\u0018\u0000\u01b2\u01b0"+
		"\u0001\u0000\u0000\u0000\u01b3\u01b6\u0001\u0000\u0000\u0000\u01b4\u01b2"+
		"\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5\u01b7"+
		"\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b7\u01b8"+
		"\u0005\u0010\u0000\u0000\u01b8/\u0001\u0000\u0000\u0000\u01b9\u01ba\u0003"+
		"\u00b2Y\u0000\u01ba1\u0001\u0000\u0000\u0000\u01bb\u01c4\u0005\u0012\u0000"+
		"\u0000\u01bc\u01c1\u00034\u001a\u0000\u01bd\u01be\u0005\u000f\u0000\u0000"+
		"\u01be\u01c0\u00034\u001a\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01c0"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c1"+
		"\u01c2\u0001\u0000\u0000\u0000\u01c2\u01c5\u0001\u0000\u0000\u0000\u01c3"+
		"\u01c1\u0001\u0000\u0000\u0000\u01c4\u01bc\u0001\u0000\u0000\u0000\u01c4"+
		"\u01c5\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6"+
		"\u01c7\u0005\u0013\u0000\u0000\u01c73\u0001\u0000\u0000\u0000\u01c8\u01ca"+
		"\u0003<\u001e\u0000\u01c9\u01cb\u0003F#\u0000\u01ca\u01c9\u0001\u0000"+
		"\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb\u01cd\u0001\u0000"+
		"\u0000\u0000\u01cc\u01ce\u0003\u00b2Y\u0000\u01cd\u01cc\u0001\u0000\u0000"+
		"\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce5\u0001\u0000\u0000\u0000"+
		"\u01cf\u01d8\u0005\u0012\u0000\u0000\u01d0\u01d5\u00038\u001c\u0000\u01d1"+
		"\u01d2\u0005\u000f\u0000\u0000\u01d2\u01d4\u00038\u001c\u0000\u01d3\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d4\u01d7\u0001\u0000\u0000\u0000\u01d5\u01d3"+
		"\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d9"+
		"\u0001\u0000\u0000\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d8\u01d0"+
		"\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9\u01da"+
		"\u0001\u0000\u0000\u0000\u01da\u01db\u0005\u0013\u0000\u0000\u01db7\u0001"+
		"\u0000\u0000\u0000\u01dc\u01de\u0003<\u001e\u0000\u01dd\u01df\u0005o\u0000"+
		"\u0000\u01de\u01dd\u0001\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000"+
		"\u0000\u01df\u01e1\u0001\u0000\u0000\u0000\u01e0\u01e2\u0003\u00b2Y\u0000"+
		"\u01e1\u01e0\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000"+
		"\u01e29\u0001\u0000\u0000\u0000\u01e3\u01e5\u0003<\u001e\u0000\u01e4\u01e6"+
		"\u0003F#\u0000\u01e5\u01e4\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000"+
		"\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e8\u0003\u00b2"+
		"Y\u0000\u01e8;\u0001\u0000\u0000\u0000\u01e9\u01ea\u0006\u001e\uffff\uffff"+
		"\u0000\u01ea\u01ef\u0003r9\u0000\u01eb\u01ef\u0003>\u001f\u0000\u01ec"+
		"\u01ef\u0003@ \u0000\u01ed\u01ef\u0003D\"\u0000\u01ee\u01e9\u0001\u0000"+
		"\u0000\u0000\u01ee\u01eb\u0001\u0000\u0000\u0000\u01ee\u01ec\u0001\u0000"+
		"\u0000\u0000\u01ee\u01ed\u0001\u0000\u0000\u0000\u01ef\u01f8\u0001\u0000"+
		"\u0000\u0000\u01f0\u01f1\n\u0002\u0000\u0000\u01f1\u01f3\u0005\u001d\u0000"+
		"\u0000\u01f2\u01f4\u0003v;\u0000\u01f3\u01f2\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f4\u0001\u0000\u0000\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000\u01f5"+
		"\u01f7\u0005\u001e\u0000\u0000\u01f6\u01f0\u0001\u0000\u0000\u0000\u01f7"+
		"\u01fa\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f8"+
		"\u01f9\u0001\u0000\u0000\u0000\u01f9=\u0001\u0000\u0000\u0000\u01fa\u01f8"+
		"\u0001\u0000\u0000\u0000\u01fb\u0200\u0003\u00b2Y\u0000\u01fc\u01fd\u0005"+
		"\u001f\u0000\u0000\u01fd\u01ff\u0003\u00b2Y\u0000\u01fe\u01fc\u0001\u0000"+
		"\u0000\u0000\u01ff\u0202\u0001\u0000\u0000\u0000\u0200\u01fe\u0001\u0000"+
		"\u0000\u0000\u0200\u0201\u0001\u0000\u0000\u0000\u0201?\u0001\u0000\u0000"+
		"\u0000\u0202\u0200\u0001\u0000\u0000\u0000\u0203\u0204\u0005 \u0000\u0000"+
		"\u0204\u0205\u0005\u0012\u0000\u0000\u0205\u0206\u0003B!\u0000\u0206\u0207"+
		"\u0005!\u0000\u0000\u0207\u0208\u0003<\u001e\u0000\u0208\u0209\u0005\u0013"+
		"\u0000\u0000\u0209A\u0001\u0000\u0000\u0000\u020a\u020d\u0003r9\u0000"+
		"\u020b\u020d\u0003>\u001f\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020c"+
		"\u020b\u0001\u0000\u0000\u0000\u020dC\u0001\u0000\u0000\u0000\u020e\u020f"+
		"\u0005\u0019\u0000\u0000\u020f\u0210\u00032\u0019\u0000\u0210\u0212\u0003"+
		"(\u0014\u0000\u0211\u0213\u0003&\u0013\u0000\u0212\u0211\u0001\u0000\u0000"+
		"\u0000\u0212\u0213\u0001\u0000\u0000\u0000\u0213E\u0001\u0000\u0000\u0000"+
		"\u0214\u0215\u0007\u0002\u0000\u0000\u0215G\u0001\u0000\u0000\u0000\u0216"+
		"\u0217\u0007\u0003\u0000\u0000\u0217I\u0001\u0000\u0000\u0000\u0218\u0219"+
		"\u0007\u0004\u0000\u0000\u0219K\u0001\u0000\u0000\u0000\u021a\u021e\u0005"+
		"\u000e\u0000\u0000\u021b\u021d\u0003N\'\u0000\u021c\u021b\u0001\u0000"+
		"\u0000\u0000\u021d\u0220\u0001\u0000\u0000\u0000\u021e\u021c\u0001\u0000"+
		"\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f\u0221\u0001\u0000"+
		"\u0000\u0000\u0220\u021e\u0001\u0000\u0000\u0000\u0221\u0222\u0005\u0010"+
		"\u0000\u0000\u0222M\u0001\u0000\u0000\u0000\u0223\u0231\u0003R)\u0000"+
		"\u0224\u0231\u0003T*\u0000\u0225\u0231\u0003X,\u0000\u0226\u0231\u0003"+
		"Z-\u0000\u0227\u0231\u0003L&\u0000\u0228\u0231\u0003^/\u0000\u0229\u0231"+
		"\u0003`0\u0000\u022a\u0231\u0003b1\u0000\u022b\u0231\u0003d2\u0000\u022c"+
		"\u0231\u0003f3\u0000\u022d\u0231\u0003h4\u0000\u022e\u0231\u0003j5\u0000"+
		"\u022f\u0231\u0003\\.\u0000\u0230\u0223\u0001\u0000\u0000\u0000\u0230"+
		"\u0224\u0001\u0000\u0000\u0000\u0230\u0225\u0001\u0000\u0000\u0000\u0230"+
		"\u0226\u0001\u0000\u0000\u0000\u0230\u0227\u0001\u0000\u0000\u0000\u0230"+
		"\u0228\u0001\u0000\u0000\u0000\u0230\u0229\u0001\u0000\u0000\u0000\u0230"+
		"\u022a\u0001\u0000\u0000\u0000\u0230\u022b\u0001\u0000\u0000\u0000\u0230"+
		"\u022c\u0001\u0000\u0000\u0000\u0230\u022d\u0001\u0000\u0000\u0000\u0230"+
		"\u022e\u0001\u0000\u0000\u0000\u0230\u022f\u0001\u0000\u0000\u0000\u0231"+
		"O\u0001\u0000\u0000\u0000\u0232\u0233\u0003v;\u0000\u0233\u0234\u0005"+
		"\u0002\u0000\u0000\u0234Q\u0001\u0000\u0000\u0000\u0235\u0236\u0005%\u0000"+
		"\u0000\u0236\u0237\u0005\u0012\u0000\u0000\u0237\u0238\u0003v;\u0000\u0238"+
		"\u0239\u0005\u0013\u0000\u0000\u0239\u023c\u0003N\'\u0000\u023a\u023b"+
		"\u0005&\u0000\u0000\u023b\u023d\u0003N\'\u0000\u023c\u023a\u0001\u0000"+
		"\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000\u023dS\u0001\u0000\u0000"+
		"\u0000\u023e\u023f\u0005\'\u0000\u0000\u023f\u0241\u0003v;\u0000\u0240"+
		"\u0242\u0003&\u0013\u0000\u0241\u0240\u0001\u0000\u0000\u0000\u0241\u0242"+
		"\u0001\u0000\u0000\u0000\u0242\u0243\u0001\u0000\u0000\u0000\u0243\u0245"+
		"\u0003L&\u0000\u0244\u0246\u0003V+\u0000\u0245\u0244\u0001\u0000\u0000"+
		"\u0000\u0246\u0247\u0001\u0000\u0000\u0000\u0247\u0245\u0001\u0000\u0000"+
		"\u0000\u0247\u0248\u0001\u0000\u0000\u0000\u0248U\u0001\u0000\u0000\u0000"+
		"\u0249\u024e\u0005(\u0000\u0000\u024a\u024c\u0003\u00b2Y\u0000\u024b\u024a"+
		"\u0001\u0000\u0000\u0000\u024b\u024c\u0001\u0000\u0000\u0000\u024c\u024d"+
		"\u0001\u0000\u0000\u0000\u024d\u024f\u00032\u0019\u0000\u024e\u024b\u0001"+
		"\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000\u0000\u024f\u0250\u0001"+
		"\u0000\u0000\u0000\u0250\u0251\u0003L&\u0000\u0251W\u0001\u0000\u0000"+
		"\u0000\u0252\u0253\u0005)\u0000\u0000\u0253\u0254\u0005\u0012\u0000\u0000"+
		"\u0254\u0255\u0003v;\u0000\u0255\u0256\u0005\u0013\u0000\u0000\u0256\u0257"+
		"\u0003N\'\u0000\u0257Y\u0001\u0000\u0000\u0000\u0258\u0259\u0005\u0016"+
		"\u0000\u0000\u0259\u025c\u0005\u0012\u0000\u0000\u025a\u025d\u0003\\."+
		"\u0000\u025b\u025d\u0005\u0002\u0000\u0000\u025c\u025a\u0001\u0000\u0000"+
		"\u0000\u025c\u025b\u0001\u0000\u0000\u0000\u025d\u0260\u0001\u0000\u0000"+
		"\u0000\u025e\u0261\u0003P(\u0000\u025f\u0261\u0005\u0002\u0000\u0000\u0260"+
		"\u025e\u0001\u0000\u0000\u0000\u0260\u025f\u0001\u0000\u0000\u0000\u0261"+
		"\u0263\u0001\u0000\u0000\u0000\u0262\u0264\u0003v;\u0000\u0263\u0262\u0001"+
		"\u0000\u0000\u0000\u0263\u0264\u0001\u0000\u0000\u0000\u0264\u0265\u0001"+
		"\u0000\u0000\u0000\u0265\u0266\u0005\u0013\u0000\u0000\u0266\u0267\u0003"+
		"N\'\u0000\u0267[\u0001\u0000\u0000\u0000\u0268\u026b\u0003l6\u0000\u0269"+
		"\u026b\u0003P(\u0000\u026a\u0268\u0001\u0000\u0000\u0000\u026a\u0269\u0001"+
		"\u0000\u0000\u0000\u026b]\u0001\u0000\u0000\u0000\u026c\u026e\u0005*\u0000"+
		"\u0000\u026d\u026f\u0005|\u0000\u0000\u026e\u026d\u0001\u0000\u0000\u0000"+
		"\u026e\u026f\u0001\u0000\u0000\u0000\u026f\u0270\u0001\u0000\u0000\u0000"+
		"\u0270\u0271\u0003\u008cF\u0000\u0271_\u0001\u0000\u0000\u0000\u0272\u0273"+
		"\u0005+\u0000\u0000\u0273\u0274\u0003N\'\u0000\u0274\u0275\u0005)\u0000"+
		"\u0000\u0275\u0276\u0005\u0012\u0000\u0000\u0276\u0277\u0003v;\u0000\u0277"+
		"\u0278\u0005\u0013\u0000\u0000\u0278\u0279\u0005\u0002\u0000\u0000\u0279"+
		"a\u0001\u0000\u0000\u0000\u027a\u027b\u0005l\u0000\u0000\u027b\u027c\u0005"+
		"\u0002\u0000\u0000\u027cc\u0001\u0000\u0000\u0000\u027d\u027e\u0005i\u0000"+
		"\u0000\u027e\u027f\u0005\u0002\u0000\u0000\u027fe\u0001\u0000\u0000\u0000"+
		"\u0280\u0282\u0005,\u0000\u0000\u0281\u0283\u0003v;\u0000\u0282\u0281"+
		"\u0001\u0000\u0000\u0000\u0282\u0283\u0001\u0000\u0000\u0000\u0283\u0284"+
		"\u0001\u0000\u0000\u0000\u0284\u0285\u0005\u0002\u0000\u0000\u0285g\u0001"+
		"\u0000\u0000\u0000\u0286\u0287\u0005-\u0000\u0000\u0287\u0288\u0005\u0002"+
		"\u0000\u0000\u0288i\u0001\u0000\u0000\u0000\u0289\u028a\u0005.\u0000\u0000"+
		"\u028a\u028b\u0003\u0084B\u0000\u028b\u028c\u0005\u0002\u0000\u0000\u028c"+
		"k\u0001\u0000\u0000\u0000\u028d\u028e\u0005[\u0000\u0000\u028e\u0295\u0003"+
		"p8\u0000\u028f\u0295\u0003:\u001d\u0000\u0290\u0291\u0005\u0012\u0000"+
		"\u0000\u0291\u0292\u0003n7\u0000\u0292\u0293\u0005\u0013\u0000\u0000\u0293"+
		"\u0295\u0001\u0000\u0000\u0000\u0294\u028d\u0001\u0000\u0000\u0000\u0294"+
		"\u028f\u0001\u0000\u0000\u0000\u0294\u0290\u0001\u0000\u0000\u0000\u0295"+
		"\u0298\u0001\u0000\u0000\u0000\u0296\u0297\u0005\t\u0000\u0000\u0297\u0299"+
		"\u0003v;\u0000\u0298\u0296\u0001\u0000\u0000\u0000\u0298\u0299\u0001\u0000"+
		"\u0000\u0000\u0299\u029a\u0001\u0000\u0000\u0000\u029a\u029b\u0005\u0002"+
		"\u0000\u0000\u029bm\u0001\u0000\u0000\u0000\u029c\u029e\u0003:\u001d\u0000"+
		"\u029d\u029c\u0001\u0000\u0000\u0000\u029d\u029e\u0001\u0000\u0000\u0000"+
		"\u029e\u02a5\u0001\u0000\u0000\u0000\u029f\u02a1\u0005\u000f\u0000\u0000"+
		"\u02a0\u02a2\u0003:\u001d\u0000\u02a1\u02a0\u0001\u0000\u0000\u0000\u02a1"+
		"\u02a2\u0001\u0000\u0000\u0000\u02a2\u02a4\u0001\u0000\u0000\u0000\u02a3"+
		"\u029f\u0001\u0000\u0000\u0000\u02a4\u02a7\u0001\u0000\u0000\u0000\u02a5"+
		"\u02a3\u0001\u0000\u0000\u0000\u02a5\u02a6\u0001\u0000\u0000\u0000\u02a6"+
		"o\u0001\u0000\u0000\u0000\u02a7\u02a5\u0001\u0000\u0000\u0000\u02a8\u02af"+
		"\u0005\u0012\u0000\u0000\u02a9\u02ab\u0003\u00b2Y\u0000\u02aa\u02a9\u0001"+
		"\u0000\u0000\u0000\u02aa\u02ab\u0001\u0000\u0000\u0000\u02ab\u02ac\u0001"+
		"\u0000\u0000\u0000\u02ac\u02ae\u0005\u000f\u0000\u0000\u02ad\u02aa\u0001"+
		"\u0000\u0000\u0000\u02ae\u02b1\u0001\u0000\u0000\u0000\u02af\u02ad\u0001"+
		"\u0000\u0000\u0000\u02af\u02b0\u0001\u0000\u0000\u0000\u02b0\u02b3\u0001"+
		"\u0000\u0000\u0000\u02b1\u02af\u0001\u0000\u0000\u0000\u02b2\u02b4\u0003"+
		"\u00b2Y\u0000\u02b3\u02b2\u0001\u0000\u0000\u0000\u02b3\u02b4\u0001\u0000"+
		"\u0000\u0000\u02b4\u02b5\u0001\u0000\u0000\u0000\u02b5\u02b6\u0005\u0013"+
		"\u0000\u0000\u02b6q\u0001\u0000\u0000\u0000\u02b7\u02c2\u0003t:\u0000"+
		"\u02b8\u02c2\u0005Y\u0000\u0000\u02b9\u02c2\u0005Z\u0000\u0000\u02ba\u02c2"+
		"\u0005[\u0000\u0000\u02bb\u02c2\u0005\\\u0000\u0000\u02bc\u02c2\u0005"+
		"]\u0000\u0000\u02bd\u02c2\u0005^\u0000\u0000\u02be\u02c2\u0005_\u0000"+
		"\u0000\u02bf\u02c2\u0005`\u0000\u0000\u02c0\u02c2\u0005a\u0000\u0000\u02c1"+
		"\u02b7\u0001\u0000\u0000\u0000\u02c1\u02b8\u0001\u0000\u0000\u0000\u02c1"+
		"\u02b9\u0001\u0000\u0000\u0000\u02c1\u02ba\u0001\u0000\u0000\u0000\u02c1"+
		"\u02bb\u0001\u0000\u0000\u0000\u02c1\u02bc\u0001\u0000\u0000\u0000\u02c1"+
		"\u02bd\u0001\u0000\u0000\u0000\u02c1\u02be\u0001\u0000\u0000\u0000\u02c1"+
		"\u02bf\u0001\u0000\u0000\u0000\u02c1\u02c0\u0001\u0000\u0000\u0000\u02c2"+
		"s\u0001\u0000\u0000\u0000\u02c3\u02c5\u0005/\u0000\u0000\u02c4\u02c6\u0005"+
		"q\u0000\u0000\u02c5\u02c4\u0001\u0000\u0000\u0000\u02c5\u02c6\u0001\u0000"+
		"\u0000\u0000\u02c6u\u0001\u0000\u0000\u0000\u02c7\u02c8\u0006;\uffff\uffff"+
		"\u0000\u02c8\u02c9\u00052\u0000\u0000\u02c9\u02e6\u0003<\u001e\u0000\u02ca"+
		"\u02cb\u0005v\u0000\u0000\u02cb\u02cc\u0005\u0012\u0000\u0000\u02cc\u02cd"+
		"\u0003<\u001e\u0000\u02cd\u02ce\u0005\u0013\u0000\u0000\u02ce\u02e6\u0001"+
		"\u0000\u0000\u0000\u02cf\u02d0\u0005q\u0000\u0000\u02d0\u02d1\u0005\u0012"+
		"\u0000\u0000\u02d1\u02d2\u0003v;\u0000\u02d2\u02d3\u0005\u0013\u0000\u0000"+
		"\u02d3\u02e6\u0001\u0000\u0000\u0000\u02d4\u02d5\u0005\u0012\u0000\u0000"+
		"\u02d5\u02d6\u0003v;\u0000\u02d6\u02d7\u0005\u0013\u0000\u0000\u02d7\u02e6"+
		"\u0001\u0000\u0000\u0000\u02d8\u02d9\u0007\u0005\u0000\u0000\u02d9\u02e6"+
		"\u0003v;\u0014\u02da\u02db\u0007\u0006\u0000\u0000\u02db\u02e6\u0003v"+
		";\u0013\u02dc\u02dd\u00056\u0000\u0000\u02dd\u02e6\u0003v;\u0012\u02de"+
		"\u02df\u00057\u0000\u0000\u02df\u02e6\u0003v;\u0011\u02e0\u02e1\u0005"+
		"8\u0000\u0000\u02e1\u02e6\u0003v;\u0010\u02e2\u02e3\u0005\u0004\u0000"+
		"\u0000\u02e3\u02e6\u0003v;\u000f\u02e4\u02e6\u0003x<\u0000\u02e5\u02c7"+
		"\u0001\u0000\u0000\u0000\u02e5\u02ca\u0001\u0000\u0000\u0000\u02e5\u02cf"+
		"\u0001\u0000\u0000\u0000\u02e5\u02d4\u0001\u0000\u0000\u0000\u02e5\u02d8"+
		"\u0001\u0000\u0000\u0000\u02e5\u02da\u0001\u0000\u0000\u0000\u02e5\u02dc"+
		"\u0001\u0000\u0000\u0000\u02e5\u02de\u0001\u0000\u0000\u0000\u02e5\u02e0"+
		"\u0001\u0000\u0000\u0000\u02e5\u02e2\u0001\u0000\u0000\u0000\u02e5\u02e4"+
		"\u0001\u0000\u0000\u0000\u02e6\u0334\u0001\u0000\u0000\u0000\u02e7\u02e8"+
		"\n\u000e\u0000\u0000\u02e8\u02e9\u00059\u0000\u0000\u02e9\u0333\u0003"+
		"v;\u000f\u02ea\u02eb\n\r\u0000\u0000\u02eb\u02ec\u0007\u0007\u0000\u0000"+
		"\u02ec\u0333\u0003v;\u000e\u02ed\u02ee\n\f\u0000\u0000\u02ee\u02ef\u0007"+
		"\u0006\u0000\u0000\u02ef\u0333\u0003v;\r\u02f0\u02f1\n\u000b\u0000\u0000"+
		"\u02f1\u02f2\u0007\b\u0000\u0000\u02f2\u0333\u0003v;\f\u02f3\u02f4\n\n"+
		"\u0000\u0000\u02f4\u02f5\u0005>\u0000\u0000\u02f5\u0333\u0003v;\u000b"+
		"\u02f6\u02f7\n\t\u0000\u0000\u02f7\u02f8\u0005\u0003\u0000\u0000\u02f8"+
		"\u0333\u0003v;\n\u02f9\u02fa\n\b\u0000\u0000\u02fa\u02fb\u0005?\u0000"+
		"\u0000\u02fb\u0333\u0003v;\t\u02fc\u02fd\n\u0007\u0000\u0000\u02fd\u02fe"+
		"\u0007\t\u0000\u0000\u02fe\u0333\u0003v;\b\u02ff\u0300\n\u0006\u0000\u0000"+
		"\u0300\u0301\u0007\n\u0000\u0000\u0301\u0333\u0003v;\u0007\u0302\u0303"+
		"\n\u0005\u0000\u0000\u0303\u0304\u0005B\u0000\u0000\u0304\u0333\u0003"+
		"v;\u0006\u0305\u0306\n\u0004\u0000\u0000\u0306\u0307\u0005C\u0000\u0000"+
		"\u0307\u0333\u0003v;\u0005\u0308\u0309\n\u0002\u0000\u0000\u0309\u030a"+
		"\u0007\u000b\u0000\u0000\u030a\u0333\u0003v;\u0003\u030b\u030c\n\u001d"+
		"\u0000\u0000\u030c\u0333\u0007\u0005\u0000\u0000\u030d\u030e\n\u001b\u0000"+
		"\u0000\u030e\u0310\u0005\u001d\u0000\u0000\u030f\u0311\u0003v;\u0000\u0310"+
		"\u030f\u0001\u0000\u0000\u0000\u0310\u0311\u0001\u0000\u0000\u0000\u0311"+
		"\u0312\u0001\u0000\u0000\u0000\u0312\u0333\u0005\u001e\u0000\u0000\u0313"+
		"\u0314\n\u001a\u0000\u0000\u0314\u0316\u0005\u001d\u0000\u0000\u0315\u0317"+
		"\u0003v;\u0000\u0316\u0315\u0001\u0000\u0000\u0000\u0316\u0317\u0001\u0000"+
		"\u0000\u0000\u0317\u0318\u0001\u0000\u0000\u0000\u0318\u031a\u00053\u0000"+
		"\u0000\u0319\u031b\u0003v;\u0000\u031a\u0319\u0001\u0000\u0000\u0000\u031a"+
		"\u031b\u0001\u0000\u0000\u0000\u031b\u031c\u0001\u0000\u0000\u0000\u031c"+
		"\u0333\u0005\u001e\u0000\u0000\u031d\u031e\n\u0019\u0000\u0000\u031e\u031f"+
		"\u0005\u001f\u0000\u0000\u031f\u0333\u0003\u00b2Y\u0000\u0320\u0326\n"+
		"\u0018\u0000\u0000\u0321\u0323\u0005\u000e\u0000\u0000\u0322\u0324\u0003"+
		"~?\u0000\u0323\u0322\u0001\u0000\u0000\u0000\u0323\u0324\u0001\u0000\u0000"+
		"\u0000\u0324\u0325\u0001\u0000\u0000\u0000\u0325\u0327\u0005\u0010\u0000"+
		"\u0000\u0326\u0321\u0001\u0000\u0000\u0000\u0326\u0327\u0001\u0000\u0000"+
		"\u0000\u0327\u0328\u0001\u0000\u0000\u0000\u0328\u0329\u0005\u0012\u0000"+
		"\u0000\u0329\u032a\u0003\u0082A\u0000\u032a\u032b\u0005\u0013\u0000\u0000"+
		"\u032b\u0333\u0001\u0000\u0000\u0000\u032c\u032d\n\u0003\u0000\u0000\u032d"+
		"\u032e\u0005D\u0000\u0000\u032e\u032f\u0003v;\u0000\u032f\u0330\u0005"+
		"3\u0000\u0000\u0330\u0331\u0003v;\u0000\u0331\u0333\u0001\u0000\u0000"+
		"\u0000\u0332\u02e7\u0001\u0000\u0000\u0000\u0332\u02ea\u0001\u0000\u0000"+
		"\u0000\u0332\u02ed\u0001\u0000\u0000\u0000\u0332\u02f0\u0001\u0000\u0000"+
		"\u0000\u0332\u02f3\u0001\u0000\u0000\u0000\u0332\u02f6\u0001\u0000\u0000"+
		"\u0000\u0332\u02f9\u0001\u0000\u0000\u0000\u0332\u02fc\u0001\u0000\u0000"+
		"\u0000\u0332\u02ff\u0001\u0000\u0000\u0000\u0332\u0302\u0001\u0000\u0000"+
		"\u0000\u0332\u0305\u0001\u0000\u0000\u0000\u0332\u0308\u0001\u0000\u0000"+
		"\u0000\u0332\u030b\u0001\u0000\u0000\u0000\u0332\u030d\u0001\u0000\u0000"+
		"\u0000\u0332\u0313\u0001\u0000\u0000\u0000\u0332\u031d\u0001\u0000\u0000"+
		"\u0000\u0332\u0320\u0001\u0000\u0000\u0000\u0332\u032c\u0001\u0000\u0000"+
		"\u0000\u0333\u0336\u0001\u0000\u0000\u0000\u0334\u0332\u0001\u0000\u0000"+
		"\u0000\u0334\u0335\u0001\u0000\u0000\u0000\u0335w\u0001\u0000\u0000\u0000"+
		"\u0336\u0334\u0001\u0000\u0000\u0000\u0337\u0345\u0005b\u0000\u0000\u0338"+
		"\u0345\u0003\u00b0X\u0000\u0339\u0345\u0003\u00b4Z\u0000\u033a\u0345\u0003"+
		"\u00b6[\u0000\u033b\u033d\u0003\u00b2Y\u0000\u033c\u033e\u0003z=\u0000"+
		"\u033d\u033c\u0001\u0000\u0000\u0000\u033d\u033e\u0001\u0000\u0000\u0000"+
		"\u033e\u0345\u0001\u0000\u0000\u0000\u033f\u0345\u0003\u0086C\u0000\u0340"+
		"\u0342\u0003\u0088D\u0000\u0341\u0343\u0003z=\u0000\u0342\u0341\u0001"+
		"\u0000\u0000\u0000\u0342\u0343\u0001\u0000\u0000\u0000\u0343\u0345\u0001"+
		"\u0000\u0000\u0000\u0344\u0337\u0001\u0000\u0000\u0000\u0344\u0338\u0001"+
		"\u0000\u0000\u0000\u0344\u0339\u0001\u0000\u0000\u0000\u0344\u033a\u0001"+
		"\u0000\u0000\u0000\u0344\u033b\u0001\u0000\u0000\u0000\u0344\u033f\u0001"+
		"\u0000\u0000\u0000\u0344\u0340\u0001\u0000\u0000\u0000\u0345y\u0001\u0000"+
		"\u0000\u0000\u0346\u0347\u0005\u001d\u0000\u0000\u0347\u0348\u0005\u001e"+
		"\u0000\u0000\u0348{\u0001\u0000\u0000\u0000\u0349\u034e\u0003v;\u0000"+
		"\u034a\u034b\u0005\u000f\u0000\u0000\u034b\u034d\u0003v;\u0000\u034c\u034a"+
		"\u0001\u0000\u0000\u0000\u034d\u0350\u0001\u0000\u0000\u0000\u034e\u034c"+
		"\u0001\u0000\u0000\u0000\u034e\u034f\u0001\u0000\u0000\u0000\u034f}\u0001"+
		"\u0000\u0000\u0000\u0350\u034e\u0001\u0000\u0000\u0000\u0351\u0356\u0003"+
		"\u0080@\u0000\u0352\u0353\u0005\u000f\u0000\u0000\u0353\u0355\u0003\u0080"+
		"@\u0000\u0354\u0352\u0001\u0000\u0000\u0000\u0355\u0358\u0001\u0000\u0000"+
		"\u0000\u0356\u0354\u0001\u0000\u0000\u0000\u0356\u0357\u0001\u0000\u0000"+
		"\u0000\u0357\u035a\u0001\u0000\u0000\u0000\u0358\u0356\u0001\u0000\u0000"+
		"\u0000\u0359\u035b\u0005\u000f\u0000\u0000\u035a\u0359\u0001\u0000\u0000"+
		"\u0000\u035a\u035b\u0001\u0000\u0000\u0000\u035b\u007f\u0001\u0000\u0000"+
		"\u0000\u035c\u035d\u0003\u00b2Y\u0000\u035d\u035e\u00053\u0000\u0000\u035e"+
		"\u035f\u0003v;\u0000\u035f\u0081\u0001\u0000\u0000\u0000\u0360\u0362\u0005"+
		"\u000e\u0000\u0000\u0361\u0363\u0003~?\u0000\u0362\u0361\u0001\u0000\u0000"+
		"\u0000\u0362\u0363\u0001\u0000\u0000\u0000\u0363\u0364\u0001\u0000\u0000"+
		"\u0000\u0364\u0369\u0005\u0010\u0000\u0000\u0365\u0367\u0003|>\u0000\u0366"+
		"\u0365\u0001\u0000\u0000\u0000\u0366\u0367\u0001\u0000\u0000\u0000\u0367"+
		"\u0369\u0001\u0000\u0000\u0000\u0368\u0360\u0001\u0000\u0000\u0000\u0368"+
		"\u0366\u0001\u0000\u0000\u0000\u0369\u0083\u0001\u0000\u0000\u0000\u036a"+
		"\u036b\u0003v;\u0000\u036b\u036c\u0005\u0012\u0000\u0000\u036c\u036d\u0003"+
		"\u0082A\u0000\u036d\u036e\u0005\u0013\u0000\u0000\u036e\u0085\u0001\u0000"+
		"\u0000\u0000\u036f\u0371\u0005\u0012\u0000\u0000\u0370\u0372\u0003v;\u0000"+
		"\u0371\u0370\u0001\u0000\u0000\u0000\u0371\u0372\u0001\u0000\u0000\u0000"+
		"\u0372\u0379\u0001\u0000\u0000\u0000\u0373\u0375\u0005\u000f\u0000\u0000"+
		"\u0374\u0376\u0003v;\u0000\u0375\u0374\u0001\u0000\u0000\u0000\u0375\u0376"+
		"\u0001\u0000\u0000\u0000\u0376\u0378\u0001\u0000\u0000\u0000\u0377\u0373"+
		"\u0001\u0000\u0000\u0000\u0378\u037b\u0001\u0000\u0000\u0000\u0379\u0377"+
		"\u0001\u0000\u0000\u0000\u0379\u037a\u0001\u0000\u0000\u0000\u037a\u037c"+
		"\u0001\u0000\u0000\u0000\u037b\u0379\u0001\u0000\u0000\u0000\u037c\u038a"+
		"\u0005\u0013\u0000\u0000\u037d\u0386\u0005\u001d\u0000\u0000\u037e\u0383"+
		"\u0003v;\u0000\u037f\u0380\u0005\u000f\u0000\u0000\u0380\u0382\u0003v"+
		";\u0000\u0381\u037f\u0001\u0000\u0000\u0000\u0382\u0385\u0001\u0000\u0000"+
		"\u0000\u0383\u0381\u0001\u0000\u0000\u0000\u0383\u0384\u0001\u0000\u0000"+
		"\u0000\u0384\u0387\u0001\u0000\u0000\u0000\u0385\u0383\u0001\u0000\u0000"+
		"\u0000\u0386\u037e\u0001\u0000\u0000\u0000\u0386\u0387\u0001\u0000\u0000"+
		"\u0000\u0387\u0388\u0001\u0000\u0000\u0000\u0388\u038a\u0005\u001e\u0000"+
		"\u0000\u0389\u036f\u0001\u0000\u0000\u0000\u0389\u037d\u0001\u0000\u0000"+
		"\u0000\u038a\u0087\u0001\u0000\u0000\u0000\u038b\u038e\u0003r9\u0000\u038c"+
		"\u038e\u0003>\u001f\u0000\u038d\u038b\u0001\u0000\u0000\u0000\u038d\u038c"+
		"\u0001\u0000\u0000\u0000\u038e\u0089\u0001\u0000\u0000\u0000\u038f\u03a2"+
		"\u0003\u00b2Y\u0000\u0390\u03a2\u0003\u008cF\u0000\u0391\u03a2\u0003\u008e"+
		"G\u0000\u0392\u03a2\u0003\u0092I\u0000\u0393\u03a2\u0003\u0094J\u0000"+
		"\u0394\u03a2\u0003\u0098L\u0000\u0395\u03a2\u0003\u009aM\u0000\u0396\u03a2"+
		"\u0003\u009cN\u0000\u0397\u03a2\u0003\u00a0P\u0000\u0398\u03a2\u0003\u00a4"+
		"R\u0000\u0399\u03a2\u0003\u00a6S\u0000\u039a\u03a2\u0005i\u0000\u0000"+
		"\u039b\u03a2\u0005l\u0000\u0000\u039c\u03a2\u0005m\u0000\u0000\u039d\u03a2"+
		"\u0003\u00aeW\u0000\u039e\u03a2\u0003\u00b0X\u0000\u039f\u03a2\u0003\u00b6"+
		"[\u0000\u03a0\u03a2\u0003\u00b4Z\u0000\u03a1\u038f\u0001\u0000\u0000\u0000"+
		"\u03a1\u0390\u0001\u0000\u0000\u0000\u03a1\u0391\u0001\u0000\u0000\u0000"+
		"\u03a1\u0392\u0001\u0000\u0000\u0000\u03a1\u0393\u0001\u0000\u0000\u0000"+
		"\u03a1\u0394\u0001\u0000\u0000\u0000\u03a1\u0395\u0001\u0000\u0000\u0000"+
		"\u03a1\u0396\u0001\u0000\u0000\u0000\u03a1\u0397\u0001\u0000\u0000\u0000"+
		"\u03a1\u0398\u0001\u0000\u0000\u0000\u03a1\u0399\u0001\u0000\u0000\u0000"+
		"\u03a1\u039a\u0001\u0000\u0000\u0000\u03a1\u039b\u0001\u0000\u0000\u0000"+
		"\u03a1\u039c\u0001\u0000\u0000\u0000\u03a1\u039d\u0001\u0000\u0000\u0000"+
		"\u03a1\u039e\u0001\u0000\u0000\u0000\u03a1\u039f\u0001\u0000\u0000\u0000"+
		"\u03a1\u03a0\u0001\u0000\u0000\u0000\u03a2\u008b\u0001\u0000\u0000\u0000"+
		"\u03a3\u03a7\u0005\u000e\u0000\u0000\u03a4\u03a6\u0003\u008aE\u0000\u03a5"+
		"\u03a4\u0001\u0000\u0000\u0000\u03a6\u03a9\u0001\u0000\u0000\u0000\u03a7"+
		"\u03a5\u0001\u0000\u0000\u0000\u03a7\u03a8\u0001\u0000\u0000\u0000\u03a8"+
		"\u03aa\u0001\u0000\u0000\u0000\u03a9\u03a7\u0001\u0000\u0000\u0000\u03aa"+
		"\u03ab\u0005\u0010\u0000\u0000\u03ab\u008d\u0001\u0000\u0000\u0000\u03ac"+
		"\u03af\u0003\u0090H\u0000\u03ad\u03af\u0003\u00a8T\u0000\u03ae\u03ac\u0001"+
		"\u0000\u0000\u0000\u03ae\u03ad\u0001\u0000\u0000\u0000\u03af\u008f\u0001"+
		"\u0000\u0000\u0000\u03b0\u03b5\u0005,\u0000\u0000\u03b1\u03b5\u0005/\u0000"+
		"\u0000\u03b2\u03b5\u0005^\u0000\u0000\u03b3\u03b5\u0003\u00b2Y\u0000\u03b4"+
		"\u03b0\u0001\u0000\u0000\u0000\u03b4\u03b1\u0001\u0000\u0000\u0000\u03b4"+
		"\u03b2\u0001\u0000\u0000\u0000\u03b4\u03b3\u0001\u0000\u0000\u0000\u03b5"+
		"\u03c2\u0001\u0000\u0000\u0000\u03b6\u03b8\u0005\u0012\u0000\u0000\u03b7"+
		"\u03b9\u0003\u008eG\u0000\u03b8\u03b7\u0001\u0000\u0000\u0000\u03b8\u03b9"+
		"\u0001\u0000\u0000\u0000\u03b9\u03be\u0001\u0000\u0000\u0000\u03ba\u03bb"+
		"\u0005\u000f\u0000\u0000\u03bb\u03bd\u0003\u008eG\u0000\u03bc\u03ba\u0001"+
		"\u0000\u0000\u0000\u03bd\u03c0\u0001\u0000\u0000\u0000\u03be\u03bc\u0001"+
		"\u0000\u0000\u0000\u03be\u03bf\u0001\u0000\u0000\u0000\u03bf\u03c1\u0001"+
		"\u0000\u0000\u0000\u03c0\u03be\u0001\u0000\u0000\u0000\u03c1\u03c3\u0005"+
		"\u0013\u0000\u0000\u03c2\u03b6\u0001\u0000\u0000\u0000\u03c2\u03c3\u0001"+
		"\u0000\u0000\u0000\u03c3\u0091\u0001\u0000\u0000\u0000\u03c4\u03c5\u0005"+
		"O\u0000\u0000\u03c5\u03c8\u0003\u0096K\u0000\u03c6\u03c7\u0005P\u0000"+
		"\u0000\u03c7\u03c9\u0003\u008eG\u0000\u03c8\u03c6\u0001\u0000\u0000\u0000"+
		"\u03c8\u03c9\u0001\u0000\u0000\u0000\u03c9\u0093\u0001\u0000\u0000\u0000"+
		"\u03ca\u03cb\u0003\u0096K\u0000\u03cb\u03cc\u0005P\u0000\u0000\u03cc\u03cd"+
		"\u0003\u008eG\u0000\u03cd\u0095\u0001\u0000\u0000\u0000\u03ce\u03d3\u0003"+
		"\u00b2Y\u0000\u03cf\u03d0\u0005\u000f\u0000\u0000\u03d0\u03d2\u0003\u00b2"+
		"Y\u0000\u03d1\u03cf\u0001\u0000\u0000\u0000\u03d2\u03d5\u0001\u0000\u0000"+
		"\u0000\u03d3\u03d1\u0001\u0000\u0000\u0000\u03d3\u03d4\u0001\u0000\u0000"+
		"\u0000\u03d4\u0097\u0001\u0000\u0000\u0000\u03d5\u03d3\u0001\u0000\u0000"+
		"\u0000\u03d6\u03d7\u0005Q\u0000\u0000\u03d7\u03d8\u0003\u00b2Y\u0000\u03d8"+
		"\u0099\u0001\u0000\u0000\u0000\u03d9\u03da\u0003\u00b2Y\u0000\u03da\u03db"+
		"\u00053\u0000\u0000\u03db\u009b\u0001\u0000\u0000\u0000\u03dc\u03dd\u0005"+
		"R\u0000\u0000\u03dd\u03e1\u0003\u008eG\u0000\u03de\u03e0\u0003\u009eO"+
		"\u0000\u03df\u03de\u0001\u0000\u0000\u0000\u03e0\u03e3\u0001\u0000\u0000"+
		"\u0000\u03e1\u03df\u0001\u0000\u0000\u0000\u03e1\u03e2\u0001\u0000\u0000"+
		"\u0000\u03e2\u009d\u0001\u0000\u0000\u0000\u03e3\u03e1\u0001\u0000\u0000"+
		"\u0000\u03e4\u03e5\u0005S\u0000\u0000\u03e5\u03e7\u0003\u00a8T\u0000\u03e6"+
		"\u03e8\u0003\u00acV\u0000\u03e7\u03e6\u0001\u0000\u0000\u0000\u03e7\u03e8"+
		"\u0001\u0000\u0000\u0000\u03e8\u03e9\u0001\u0000\u0000\u0000\u03e9\u03ea"+
		"\u0003\u008cF\u0000\u03ea\u03ee\u0001\u0000\u0000\u0000\u03eb\u03ec\u0005"+
		"T\u0000\u0000\u03ec\u03ee\u0003\u008cF\u0000\u03ed\u03e4\u0001\u0000\u0000"+
		"\u0000\u03ed\u03eb\u0001\u0000\u0000\u0000\u03ee\u009f\u0001\u0000\u0000"+
		"\u0000\u03ef\u03f0\u0005\u0019\u0000\u0000\u03f0\u03f1\u0003\u00b2Y\u0000"+
		"\u03f1\u03f3\u0005\u0012\u0000\u0000\u03f2\u03f4\u0003\u00aaU\u0000\u03f3"+
		"\u03f2\u0001\u0000\u0000\u0000\u03f3\u03f4\u0001\u0000\u0000\u0000\u03f4"+
		"\u03f5\u0001\u0000\u0000\u0000\u03f5\u03f7\u0005\u0013\u0000\u0000\u03f6"+
		"\u03f8\u0003\u00a2Q\u0000\u03f7\u03f6\u0001\u0000\u0000\u0000\u03f7\u03f8"+
		"\u0001\u0000\u0000\u0000\u03f8\u03f9\u0001\u0000\u0000\u0000\u03f9\u03fa"+
		"\u0003\u008cF\u0000\u03fa\u00a1\u0001\u0000\u0000\u0000\u03fb\u03fc\u0005"+
		"5\u0000\u0000\u03fc\u03fd\u0005\u0006\u0000\u0000\u03fd\u03fe\u0003\u00aa"+
		"U\u0000\u03fe\u00a3\u0001\u0000\u0000\u0000\u03ff\u0400\u0005\u0016\u0000"+
		"\u0000\u0400\u0401\u0003\u008cF\u0000\u0401\u0402\u0003\u008eG\u0000\u0402"+
		"\u0403\u0003\u008cF\u0000\u0403\u0404\u0003\u008cF\u0000\u0404\u00a5\u0001"+
		"\u0000\u0000\u0000\u0405\u0406\u0005%\u0000\u0000\u0406\u0407\u0003\u008e"+
		"G\u0000\u0407\u0408\u0003\u008cF\u0000\u0408\u00a7\u0001\u0000\u0000\u0000"+
		"\u0409\u040f\u0003\u00b6[\u0000\u040a\u040f\u0005c\u0000\u0000\u040b\u040f"+
		"\u0005d\u0000\u0000\u040c\u040f\u0003\u00b4Z\u0000\u040d\u040f\u0005b"+
		"\u0000\u0000\u040e\u0409\u0001\u0000\u0000\u0000\u040e\u040a\u0001\u0000"+
		"\u0000\u0000\u040e\u040b\u0001\u0000\u0000\u0000\u040e\u040c\u0001\u0000"+
		"\u0000\u0000\u040e\u040d\u0001\u0000\u0000\u0000\u040f\u0411\u0001\u0000"+
		"\u0000\u0000\u0410\u0412\u0003\u00acV\u0000\u0411\u0410\u0001\u0000\u0000"+
		"\u0000\u0411\u0412\u0001\u0000\u0000\u0000\u0412\u00a9\u0001\u0000\u0000"+
		"\u0000\u0413\u0415\u0003\u00b2Y\u0000\u0414\u0416\u0003\u00acV\u0000\u0415"+
		"\u0414\u0001\u0000\u0000\u0000\u0415\u0416\u0001\u0000\u0000\u0000\u0416"+
		"\u0419\u0001\u0000\u0000\u0000\u0417\u0418\u0005\u000f\u0000\u0000\u0418"+
		"\u041a\u0003\u00aaU\u0000\u0419\u0417\u0001\u0000\u0000\u0000\u0419\u041a"+
		"\u0001\u0000\u0000\u0000\u041a\u00ab\u0001\u0000\u0000\u0000\u041b\u041c"+
		"\u00053\u0000\u0000\u041c\u041d\u0003\u00b2Y\u0000\u041d\u00ad\u0001\u0000"+
		"\u0000\u0000\u041e\u041f\u0005*\u0000\u0000\u041f\u0420\u0003\u00b2Y\u0000"+
		"\u0420\u0421\u0003\u008cF\u0000\u0421\u00af\u0001\u0000\u0000\u0000\u0422"+
		"\u0424\u0007\f\u0000\u0000\u0423\u0425\u0005e\u0000\u0000\u0424\u0423"+
		"\u0001\u0000\u0000\u0000\u0424\u0425\u0001\u0000\u0000\u0000\u0425\u00b1"+
		"\u0001\u0000\u0000\u0000\u0426\u0427\u0007\r\u0000\u0000\u0427\u00b3\u0001"+
		"\u0000\u0000\u0000\u0428\u042a\u0005f\u0000\u0000\u0429\u0428\u0001\u0000"+
		"\u0000\u0000\u042a\u042b\u0001\u0000\u0000\u0000\u042b\u0429\u0001\u0000"+
		"\u0000\u0000\u042b\u042c\u0001\u0000\u0000\u0000\u042c\u00b5\u0001\u0000"+
		"\u0000\u0000\u042d\u042f\u0005|\u0000\u0000\u042e\u042d\u0001\u0000\u0000"+
		"\u0000\u042f\u0430\u0001\u0000\u0000\u0000\u0430\u042e\u0001\u0000\u0000"+
		"\u0000\u0430\u0431\u0001\u0000\u0000\u0000\u0431\u00b7\u0001\u0000\u0000"+
		"\u0000|\u00bd\u00bf\u00cd\u00d1\u00d4\u00de\u00e4\u00e8\u00f4\u00fc\u0101"+
		"\u0104\u010e\u0111\u0117\u011f\u0122\u012b\u0134\u0136\u013c\u0147\u014c"+
		"\u0153\u0161\u0164\u016b\u016f\u0171\u0176\u017c\u0180\u0187\u018c\u0195"+
		"\u0197\u019d\u01a0\u01a6\u01ae\u01b4\u01c1\u01c4\u01ca\u01cd\u01d5\u01d8"+
		"\u01de\u01e1\u01e5\u01ee\u01f3\u01f8\u0200\u020c\u0212\u021e\u0230\u023c"+
		"\u0241\u0247\u024b\u024e\u025c\u0260\u0263\u026a\u026e\u0282\u0294\u0298"+
		"\u029d\u02a1\u02a5\u02aa\u02af\u02b3\u02c1\u02c5\u02e5\u0310\u0316\u031a"+
		"\u0323\u0326\u0332\u0334\u033d\u0342\u0344\u034e\u0356\u035a\u0362\u0366"+
		"\u0368\u0371\u0375\u0379\u0383\u0386\u0389\u038d\u03a1\u03a7\u03ae\u03b4"+
		"\u03b8\u03be\u03c2\u03c8\u03d3\u03e1\u03e7\u03ed\u03f3\u03f7\u040e\u0411"+
		"\u0415\u0419\u0424\u042b\u0430";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}