// Generated from java-escape by ANTLR 4.11.1
package solidity_parser.grammar.v070;
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
		DecimalNumber=99, HexNumber=100, NumberUnit=101, Gwei=102, Szabo=103, 
		Finney=104, HexLiteralFragment=105, ReservedKeyword=106, AnonymousKeyword=107, 
		BreakKeyword=108, ConstantKeyword=109, ImmutableKeyword=110, ContinueKeyword=111, 
		LeaveKeyword=112, ExternalKeyword=113, IndexedKeyword=114, InternalKeyword=115, 
		PayableKeyword=116, PrivateKeyword=117, PublicKeyword=118, VirtualKeyword=119, 
		PureKeyword=120, TypeKeyword=121, ViewKeyword=122, ConstructorKeyword=123, 
		FallbackKeyword=124, ReceiveKeyword=125, Identifier=126, StringLiteralFragment=127, 
		UnicodeStringLiteralFragment=128, WS=129, COMMENT=130, LINE_COMMENT=131;
	public static final int
		RULE_sourceUnit = 0, RULE_pragmaDirective = 1, RULE_pragmaName = 2, RULE_pragmaValue = 3, 
		RULE_importDirective = 4, RULE_importDeclaration = 5, RULE_contractDefinition = 6, 
		RULE_inheritanceSpecifier = 7, RULE_contractPart = 8, RULE_stateVariableDeclaration = 9, 
		RULE_overrideSpecifier = 10, RULE_usingForDeclaration = 11, RULE_structDefinition = 12, 
		RULE_modifierDefinition = 13, RULE_functionDefinition = 14, RULE_functionDescriptor = 15, 
		RULE_returnParameters = 16, RULE_modifierList = 17, RULE_modifierInvocation = 18, 
		RULE_eventDefinition = 19, RULE_enumDefinition = 20, RULE_enumValue = 21, 
		RULE_parameterList = 22, RULE_parameter = 23, RULE_eventParameterList = 24, 
		RULE_eventParameter = 25, RULE_variableDeclaration = 26, RULE_typeName = 27, 
		RULE_userDefinedTypeName = 28, RULE_mapping = 29, RULE_mappingKey = 30, 
		RULE_functionTypeName = 31, RULE_storageLocation = 32, RULE_stateMutability = 33, 
		RULE_visibilityModifier = 34, RULE_block = 35, RULE_statement = 36, RULE_expressionStatement = 37, 
		RULE_ifStatement = 38, RULE_tryStatement = 39, RULE_catchClause = 40, 
		RULE_whileStatement = 41, RULE_forStatement = 42, RULE_simpleStatement = 43, 
		RULE_inlineAssemblyStatement = 44, RULE_doWhileStatement = 45, RULE_continueStatement = 46, 
		RULE_breakStatement = 47, RULE_returnStatement = 48, RULE_throwStatement = 49, 
		RULE_emitStatement = 50, RULE_variableDeclarationStatement = 51, RULE_variableDeclarationList = 52, 
		RULE_identifierList = 53, RULE_elementaryTypeName = 54, RULE_addressType = 55, 
		RULE_expression = 56, RULE_primaryExpression = 57, RULE_arrayBrackets = 58, 
		RULE_expressionList = 59, RULE_nameValueList = 60, RULE_nameValue = 61, 
		RULE_functionCallArguments = 62, RULE_functionCall = 63, RULE_tupleExpression = 64, 
		RULE_typeNameExpression = 65, RULE_assemblyItem = 66, RULE_assemblyBlock = 67, 
		RULE_assemblyExpression = 68, RULE_assemblyCall = 69, RULE_assemblyLocalDefinition = 70, 
		RULE_assemblyAssignment = 71, RULE_assemblyIdentifierList = 72, RULE_assemblyIdentifier = 73, 
		RULE_assemblyStackAssignment = 74, RULE_labelDefinition = 75, RULE_assemblySwitch = 76, 
		RULE_assemblyCase = 77, RULE_assemblyFunctionDefinition = 78, RULE_assemblyFunctionReturns = 79, 
		RULE_assemblyFor = 80, RULE_assemblyIf = 81, RULE_assemblyLiteral = 82, 
		RULE_assemblyTypedVariableList = 83, RULE_assemblyType = 84, RULE_subAssembly = 85, 
		RULE_numberLiteral = 86, RULE_identifier = 87, RULE_hexLiteral = 88, RULE_stringLiteral = 89, 
		RULE_unicodeStringLiteral = 90;
	private static String[] makeRuleNames() {
		return new String[] {
			"sourceUnit", "pragmaDirective", "pragmaName", "pragmaValue", "importDirective", 
			"importDeclaration", "contractDefinition", "inheritanceSpecifier", "contractPart", 
			"stateVariableDeclaration", "overrideSpecifier", "usingForDeclaration", 
			"structDefinition", "modifierDefinition", "functionDefinition", "functionDescriptor", 
			"returnParameters", "modifierList", "modifierInvocation", "eventDefinition", 
			"enumDefinition", "enumValue", "parameterList", "parameter", "eventParameterList", 
			"eventParameter", "variableDeclaration", "typeName", "userDefinedTypeName", 
			"mapping", "mappingKey", "functionTypeName", "storageLocation", "stateMutability", 
			"visibilityModifier", "block", "statement", "expressionStatement", "ifStatement", 
			"tryStatement", "catchClause", "whileStatement", "forStatement", "simpleStatement", 
			"inlineAssemblyStatement", "doWhileStatement", "continueStatement", "breakStatement", 
			"returnStatement", "throwStatement", "emitStatement", "variableDeclarationStatement", 
			"variableDeclarationList", "identifierList", "elementaryTypeName", "addressType", 
			"expression", "primaryExpression", "arrayBrackets", "expressionList", 
			"nameValueList", "nameValue", "functionCallArguments", "functionCall", 
			"tupleExpression", "typeNameExpression", "assemblyItem", "assemblyBlock", 
			"assemblyExpression", "assemblyCall", "assemblyLocalDefinition", "assemblyAssignment", 
			"assemblyIdentifierList", "assemblyIdentifier", "assemblyStackAssignment", 
			"labelDefinition", "assemblySwitch", "assemblyCase", "assemblyFunctionDefinition", 
			"assemblyFunctionReturns", "assemblyFor", "assemblyIf", "assemblyLiteral", 
			"assemblyTypedVariableList", "assemblyType", "subAssembly", "numberLiteral", 
			"identifier", "hexLiteral", "stringLiteral", "unicodeStringLiteral"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'pragma'", "';'", "'import'", "'as'", "'*'", "'from'", "'{'", 
			"','", "'}'", "'is'", "'('", "')'", "'='", "'override'", "'using'", "'for'", 
			"'struct'", "'modifier'", "'function'", "'returns'", "'event'", "'enum'", 
			"'['", "']'", "'.'", "'mapping'", "'=>'", "'memory'", "'storage'", "'calldata'", 
			"'if'", "'else'", "'try'", "'catch'", "'while'", "'assembly'", "'do'", 
			"'return'", "'throw'", "'emit'", "'address'", "'++'", "'--'", "'new'", 
			"':'", "'+'", "'-'", "'delete'", "'after'", "'!'", "'~'", "'**'", "'/'", 
			"'%'", "'<<'", "'>>'", "'&'", "'^'", "'|'", "'<'", "'>'", "'<='", "'>='", 
			"'=='", "'!='", "'&&'", "'||'", "'?'", "'|='", "'^='", "'&='", "'<<='", 
			"'>>='", "'+='", "'-='", "'*='", "'/='", "'%='", "'let'", "':='", "'=:'", 
			"'switch'", "'case'", "'default'", "'contract'", "'interface'", "'library'", 
			"'abstract'", "'bool'", "'string'", "'var'", null, null, "'byte'", null, 
			null, null, null, null, null, null, "'gwei'", "'szabo'", "'finney'", 
			null, null, "'anonymous'", "'break'", "'constant'", "'immutable'", "'continue'", 
			"'leave'", "'external'", "'indexed'", "'internal'", "'payable'", "'private'", 
			"'public'", "'virtual'", "'pure'", "'type'", "'view'", "'constructor'", 
			"'fallback'", "'receive'"
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
			"Gwei", "Szabo", "Finney", "HexLiteralFragment", "ReservedKeyword", "AnonymousKeyword", 
			"BreakKeyword", "ConstantKeyword", "ImmutableKeyword", "ContinueKeyword", 
			"LeaveKeyword", "ExternalKeyword", "IndexedKeyword", "InternalKeyword", 
			"PayableKeyword", "PrivateKeyword", "PublicKeyword", "VirtualKeyword", 
			"PureKeyword", "TypeKeyword", "ViewKeyword", "ConstructorKeyword", "FallbackKeyword", 
			"ReceiveKeyword", "Identifier", "StringLiteralFragment", "UnicodeStringLiteralFragment", 
			"WS", "COMMENT", "LINE_COMMENT"
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
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4325386L) != 0 || (((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & 15L) != 0) {
				{
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(182);
					pragmaDirective();
					}
					break;
				case T__2:
					{
					setState(183);
					importDirective();
					}
					break;
				case T__16:
					{
					setState(184);
					structDefinition();
					}
					break;
				case T__21:
					{
					setState(185);
					enumDefinition();
					}
					break;
				case ContractKeyword:
				case InterfaceKeyword:
				case LibraryKeyword:
				case Abstract:
					{
					setState(186);
					contractDefinition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
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
			setState(194);
			match(T__0);
			setState(195);
			pragmaName();
			setState(196);
			pragmaValue();
			setState(197);
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
			setState(199);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & -6L) != 0 || (((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1L) != 0 || (((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 15L) != 0) {
				{
				{
				setState(201);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(206);
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
		enterRule(_localctx, 8, RULE_importDirective);
		int _la;
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new ModuleImportContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(T__2);
				setState(208);
				match(StringLiteralFragment);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(209);
					match(T__3);
					setState(210);
					identifier();
					}
				}

				setState(213);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new AliasImportContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(T__2);
				setState(217);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(215);
					match(T__4);
					}
					break;
				case T__5:
				case T__29:
				case T__40:
				case Gwei:
				case Szabo:
				case Finney:
				case Identifier:
					{
					setState(216);
					((AliasImportContext)_localctx).symbol = identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(219);
					match(T__3);
					setState(220);
					((AliasImportContext)_localctx).unitAlias = identifier();
					}
				}

				setState(223);
				match(T__5);
				setState(224);
				match(StringLiteralFragment);
				setState(225);
				match(T__1);
				}
				break;
			case 3:
				_localctx = new SymbolImportContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				match(T__2);
				setState(227);
				match(T__6);
				setState(228);
				importDeclaration();
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(229);
					match(T__7);
					setState(230);
					importDeclaration();
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(236);
				match(T__8);
				setState(237);
				match(T__5);
				setState(238);
				match(StringLiteralFragment);
				setState(239);
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
		enterRule(_localctx, 10, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			identifier();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(244);
				match(T__3);
				setState(245);
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
		enterRule(_localctx, 12, RULE_contractDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract) {
				{
				setState(248);
				match(Abstract);
				}
			}

			setState(251);
			_la = _input.LA(1);
			if ( !((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & 7L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(252);
			identifier();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(253);
				match(T__9);
				setState(254);
				inheritanceSpecifier();
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(255);
					match(T__7);
					setState(256);
					inheritanceSpecifier();
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(264);
			match(T__6);
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200171348032L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 257698095615L) != 0) {
				{
				{
				setState(265);
				contractPart();
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(271);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 14, RULE_inheritanceSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			userDefinedTypeName();
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(274);
				match(T__10);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
					{
					setState(275);
					expressionList();
					}
				}

				setState(278);
				match(T__11);
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
		enterRule(_localctx, 16, RULE_contractPart);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				stateVariableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				usingForDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				structDefinition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(284);
				modifierDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(285);
				functionDefinition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(286);
				eventDefinition();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(287);
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
		enterRule(_localctx, 18, RULE_stateVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			typeName(0);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13 || (((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & 835L) != 0) {
				{
				setState(297);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PublicKeyword:
					{
					setState(291);
					match(PublicKeyword);
					}
					break;
				case InternalKeyword:
					{
					setState(292);
					match(InternalKeyword);
					}
					break;
				case PrivateKeyword:
					{
					setState(293);
					match(PrivateKeyword);
					}
					break;
				case ConstantKeyword:
					{
					setState(294);
					match(ConstantKeyword);
					}
					break;
				case ImmutableKeyword:
					{
					setState(295);
					match(ImmutableKeyword);
					}
					break;
				case T__13:
					{
					setState(296);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
			identifier();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(303);
				match(T__12);
				setState(304);
				expression(0);
				}
			}

			setState(307);
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
		enterRule(_localctx, 20, RULE_overrideSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(T__13);
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(310);
				match(T__10);
				setState(311);
				userDefinedTypeName();
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(312);
					match(T__7);
					setState(313);
					userDefinedTypeName();
					}
					}
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(319);
				match(T__11);
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
		enterRule(_localctx, 22, RULE_usingForDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(T__14);
			setState(324);
			identifier();
			setState(325);
			match(T__15);
			setState(328);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(326);
				match(T__4);
				}
				break;
			case T__5:
			case T__18:
			case T__25:
			case T__29:
			case T__40:
			case BoolType:
			case StringType:
			case VarType:
			case Int:
			case Uint:
			case AByte:
			case Byte:
			case Fixed:
			case Ufixed:
			case Gwei:
			case Szabo:
			case Finney:
			case Identifier:
				{
				setState(327);
				typeName(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(330);
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
		enterRule(_localctx, 24, RULE_structDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(T__16);
			setState(333);
			identifier();
			setState(334);
			match(T__6);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200164630592L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 137439011327L) != 0) {
				{
				setState(335);
				variableDeclaration();
				setState(336);
				match(T__1);
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200164630592L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 137439011327L) != 0) {
					{
					{
					setState(337);
					variableDeclaration();
					setState(338);
					match(T__1);
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(347);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 26, RULE_modifierDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(T__17);
			setState(350);
			identifier();
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(351);
				parameterList();
				}
			}

			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13 || _la==VirtualKeyword) {
				{
				setState(356);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VirtualKeyword:
					{
					setState(354);
					match(VirtualKeyword);
					}
					break;
				case T__13:
					{
					setState(355);
					overrideSpecifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(361);
				match(T__1);
				}
				break;
			case T__6:
				{
				setState(362);
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
		enterRule(_localctx, 28, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			functionDescriptor();
			setState(366);
			parameterList();
			setState(367);
			modifierList();
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(368);
				returnParameters();
				}
			}

			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(371);
				match(T__1);
				}
				break;
			case T__6:
				{
				setState(372);
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
		enterRule(_localctx, 30, RULE_functionDescriptor);
		try {
			setState(385);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				match(T__18);
				setState(380);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
				case T__29:
				case T__40:
				case Gwei:
				case Szabo:
				case Finney:
				case Identifier:
					{
					setState(376);
					identifier();
					}
					break;
				case ReceiveKeyword:
					{
					setState(377);
					match(ReceiveKeyword);
					}
					break;
				case FallbackKeyword:
					{
					setState(378);
					match(FallbackKeyword);
					}
					break;
				case ConstructorKeyword:
					{
					setState(379);
					match(ConstructorKeyword);
					}
					break;
				case T__10:
					break;
				default:
					break;
				}
				}
				break;
			case ConstructorKeyword:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				match(ConstructorKeyword);
				}
				break;
			case FallbackKeyword:
				enterOuterAlt(_localctx, 3);
				{
				setState(383);
				match(FallbackKeyword);
				}
				break;
			case ReceiveKeyword:
				enterOuterAlt(_localctx, 4);
				{
				setState(384);
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
		enterRule(_localctx, 32, RULE_returnParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(T__19);
			setState(388);
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
		enterRule(_localctx, 34, RULE_modifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(394);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__5:
					case T__29:
					case T__40:
					case Gwei:
					case Szabo:
					case Finney:
					case Identifier:
						{
						setState(390);
						modifierInvocation();
						}
						break;
					case ConstantKeyword:
					case PayableKeyword:
					case PureKeyword:
					case ViewKeyword:
						{
						setState(391);
						stateMutability();
						}
						break;
					case ExternalKeyword:
					case InternalKeyword:
					case PrivateKeyword:
					case PublicKeyword:
					case VirtualKeyword:
						{
						setState(392);
						visibilityModifier();
						}
						break;
					case T__13:
						{
						setState(393);
						overrideSpecifier();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(398);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		enterRule(_localctx, 36, RULE_modifierInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			identifier();
			setState(405);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(400);
				match(T__10);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
					{
					setState(401);
					expressionList();
					}
				}

				setState(404);
				match(T__11);
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
		enterRule(_localctx, 38, RULE_eventDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(T__20);
			setState(408);
			identifier();
			setState(409);
			eventParameterList();
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AnonymousKeyword) {
				{
				setState(410);
				match(AnonymousKeyword);
				}
			}

			setState(413);
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
		enterRule(_localctx, 40, RULE_enumDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(T__21);
			setState(416);
			identifier();
			setState(417);
			match(T__6);
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
				{
				setState(418);
				enumValue();
				}
			}

			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(421);
				match(T__7);
				setState(422);
				enumValue();
				}
				}
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(428);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 42, RULE_enumValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
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
		enterRule(_localctx, 44, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(T__10);
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200164630592L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 137439011327L) != 0) {
				{
				setState(433);
				parameter();
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(434);
					match(T__7);
					setState(435);
					parameter();
					}
					}
					setState(440);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(443);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 46, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			typeName(0);
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(446);
				storageLocation();
				}
				break;
			}
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
				{
				setState(449);
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
		enterRule(_localctx, 48, RULE_eventParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(T__10);
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200164630592L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 137439011327L) != 0) {
				{
				setState(453);
				eventParameter();
				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(454);
					match(T__7);
					setState(455);
					eventParameter();
					}
					}
					setState(460);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(463);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 50, RULE_eventParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			typeName(0);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IndexedKeyword) {
				{
				setState(466);
				match(IndexedKeyword);
				}
			}

			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
				{
				setState(469);
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
		enterRule(_localctx, 52, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			typeName(0);
			setState(474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(473);
				storageLocation();
				}
				break;
			}
			setState(476);
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_typeName, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(479);
				elementaryTypeName();
				}
				break;
			case 2:
				{
				setState(480);
				userDefinedTypeName();
				}
				break;
			case 3:
				{
				setState(481);
				mapping();
				}
				break;
			case 4:
				{
				setState(482);
				functionTypeName();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(493);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeName);
					setState(485);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(486);
					match(T__22);
					setState(488);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
						{
						setState(487);
						expression(0);
						}
					}

					setState(490);
					match(T__23);
					}
					} 
				}
				setState(495);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
		enterRule(_localctx, 56, RULE_userDefinedTypeName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			identifier();
			setState(501);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(497);
					match(T__24);
					setState(498);
					identifier();
					}
					} 
				}
				setState(503);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
		enterRule(_localctx, 58, RULE_mapping);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(T__25);
			setState(505);
			match(T__10);
			setState(506);
			mappingKey();
			setState(507);
			match(T__26);
			setState(508);
			typeName(0);
			setState(509);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 60, RULE_mappingKey);
		try {
			setState(513);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(511);
				elementaryTypeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(512);
				userDefinedTypeName();
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
		enterRule(_localctx, 62, RULE_functionTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(T__18);
			setState(516);
			parameterList();
			setState(517);
			modifierList();
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(518);
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
		enterRule(_localctx, 64, RULE_storageLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0) ) {
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
		enterRule(_localctx, 66, RULE_stateMutability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			_la = _input.LA(1);
			if ( !((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & 10369L) != 0) ) {
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
		enterRule(_localctx, 68, RULE_visibilityModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			_la = _input.LA(1);
			if ( !((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & 117L) != 0) ) {
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
		enterRule(_localctx, 70, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(T__6);
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4468392782792896L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966506704895L) != 0) {
				{
				{
				setState(528);
				statement();
				}
				}
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(534);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 72, RULE_statement);
		try {
			setState(549);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				ifStatement();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
				tryStatement();
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 3);
				{
				setState(538);
				whileStatement();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(539);
				forStatement();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(540);
				block();
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 6);
				{
				setState(541);
				inlineAssemblyStatement();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 7);
				{
				setState(542);
				doWhileStatement();
				}
				break;
			case ContinueKeyword:
				enterOuterAlt(_localctx, 8);
				{
				setState(543);
				continueStatement();
				}
				break;
			case BreakKeyword:
				enterOuterAlt(_localctx, 9);
				{
				setState(544);
				breakStatement();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 10);
				{
				setState(545);
				returnStatement();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 11);
				{
				setState(546);
				throwStatement();
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 12);
				{
				setState(547);
				emitStatement();
				}
				break;
			case T__5:
			case T__10:
			case T__18:
			case T__22:
			case T__25:
			case T__29:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
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
			case Gwei:
			case Szabo:
			case Finney:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
			case UnicodeStringLiteralFragment:
				enterOuterAlt(_localctx, 13);
				{
				setState(548);
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
		enterRule(_localctx, 74, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			expression(0);
			setState(552);
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
		enterRule(_localctx, 76, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(T__30);
			setState(555);
			match(T__10);
			setState(556);
			expression(0);
			setState(557);
			match(T__11);
			setState(558);
			statement();
			setState(561);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(559);
				match(T__31);
				setState(560);
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
		enterRule(_localctx, 78, RULE_tryStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(T__32);
			setState(564);
			expression(0);
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(565);
				returnParameters();
				}
			}

			setState(568);
			block();
			setState(570); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(569);
				catchClause();
				}
				}
				setState(572); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__33 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 80, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			match(T__33);
			setState(579);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096999488L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
				{
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
					{
					setState(575);
					identifier();
					}
				}

				setState(578);
				parameterList();
				}
			}

			setState(581);
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
		enterRule(_localctx, 82, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			match(T__34);
			setState(584);
			match(T__10);
			setState(585);
			expression(0);
			setState(586);
			match(T__11);
			setState(587);
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
		enterRule(_localctx, 84, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(T__15);
			setState(590);
			match(T__10);
			setState(593);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__10:
			case T__18:
			case T__22:
			case T__25:
			case T__29:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
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
			case Gwei:
			case Szabo:
			case Finney:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
			case UnicodeStringLiteralFragment:
				{
				setState(591);
				simpleStatement();
				}
				break;
			case T__1:
				{
				setState(592);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(597);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__10:
			case T__22:
			case T__29:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
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
			case Gwei:
			case Szabo:
			case Finney:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
			case UnicodeStringLiteralFragment:
				{
				setState(595);
				expressionStatement();
				}
				break;
			case T__1:
				{
				setState(596);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
				{
				setState(599);
				expression(0);
				}
			}

			setState(602);
			match(T__11);
			setState(603);
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
		enterRule(_localctx, 86, RULE_simpleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(605);
				variableDeclarationStatement();
				}
				break;
			case 2:
				{
				setState(606);
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
		enterRule(_localctx, 88, RULE_inlineAssemblyStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			match(T__35);
			setState(611);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==StringLiteralFragment) {
				{
				setState(610);
				match(StringLiteralFragment);
				}
			}

			setState(613);
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
		enterRule(_localctx, 90, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(615);
			match(T__36);
			setState(616);
			statement();
			setState(617);
			match(T__34);
			setState(618);
			match(T__10);
			setState(619);
			expression(0);
			setState(620);
			match(T__11);
			setState(621);
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
		enterRule(_localctx, 92, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			match(ContinueKeyword);
			setState(624);
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
		enterRule(_localctx, 94, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			match(BreakKeyword);
			setState(627);
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
		enterRule(_localctx, 96, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(T__37);
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
				{
				setState(630);
				expression(0);
				}
			}

			setState(633);
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
		enterRule(_localctx, 98, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			match(T__38);
			setState(636);
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
		enterRule(_localctx, 100, RULE_emitStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			match(T__39);
			setState(639);
			functionCall();
			setState(640);
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
		enterRule(_localctx, 102, RULE_variableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(642);
				match(VarType);
				setState(643);
				identifierList();
				}
				break;
			case 2:
				{
				setState(644);
				variableDeclaration();
				}
				break;
			case 3:
				{
				setState(645);
				match(T__10);
				setState(646);
				variableDeclarationList();
				setState(647);
				match(T__11);
				}
				break;
			}
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(651);
				match(T__12);
				setState(652);
				expression(0);
				}
			}

			setState(655);
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
		enterRule(_localctx, 104, RULE_variableDeclarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200164630592L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 137439011327L) != 0) {
				{
				setState(657);
				variableDeclaration();
				}
			}

			setState(666);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(660);
				match(T__7);
				setState(662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200164630592L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 137439011327L) != 0) {
					{
					setState(661);
					variableDeclaration();
					}
				}

				}
				}
				setState(668);
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
		enterRule(_localctx, 106, RULE_identifierList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			match(T__10);
			setState(676);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(671);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
						{
						setState(670);
						identifier();
						}
					}

					setState(673);
					match(T__7);
					}
					} 
				}
				setState(678);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			}
			setState(680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
				{
				setState(679);
				identifier();
				}
			}

			setState(682);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 108, RULE_elementaryTypeName);
		try {
			setState(694);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__40:
				enterOuterAlt(_localctx, 1);
				{
				setState(684);
				addressType();
				}
				break;
			case BoolType:
				enterOuterAlt(_localctx, 2);
				{
				setState(685);
				match(BoolType);
				}
				break;
			case StringType:
				enterOuterAlt(_localctx, 3);
				{
				setState(686);
				match(StringType);
				}
				break;
			case VarType:
				enterOuterAlt(_localctx, 4);
				{
				setState(687);
				match(VarType);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 5);
				{
				setState(688);
				match(Int);
				}
				break;
			case Uint:
				enterOuterAlt(_localctx, 6);
				{
				setState(689);
				match(Uint);
				}
				break;
			case AByte:
				enterOuterAlt(_localctx, 7);
				{
				setState(690);
				match(AByte);
				}
				break;
			case Byte:
				enterOuterAlt(_localctx, 8);
				{
				setState(691);
				match(Byte);
				}
				break;
			case Fixed:
				enterOuterAlt(_localctx, 9);
				{
				setState(692);
				match(Fixed);
				}
				break;
			case Ufixed:
				enterOuterAlt(_localctx, 10);
				{
				setState(693);
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
		enterRule(_localctx, 110, RULE_addressType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			match(T__40);
			setState(698);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(697);
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
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				_localctx = new NewTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(701);
				match(T__43);
				setState(702);
				typeName(0);
				}
				break;
			case 2:
				{
				_localctx = new MetaTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(703);
				match(TypeKeyword);
				setState(704);
				match(T__10);
				setState(705);
				typeName(0);
				setState(706);
				match(T__11);
				}
				break;
			case 3:
				{
				_localctx = new PayableExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(708);
				match(PayableKeyword);
				setState(709);
				match(T__10);
				setState(710);
				expression(0);
				setState(711);
				match(T__11);
				}
				break;
			case 4:
				{
				_localctx = new BracketExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(713);
				match(T__10);
				setState(714);
				expression(0);
				setState(715);
				match(T__11);
				}
				break;
			case 5:
				{
				_localctx = new UnaryPreOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(717);
				_la = _input.LA(1);
				if ( !(_la==T__41 || _la==T__42) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(718);
				expression(20);
				}
				break;
			case 6:
				{
				_localctx = new UnaryPreOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(719);
				_la = _input.LA(1);
				if ( !(_la==T__45 || _la==T__46) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(720);
				expression(19);
				}
				break;
			case 7:
				{
				_localctx = new DeleteExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(721);
				match(T__47);
				setState(722);
				expression(18);
				}
				break;
			case 8:
				{
				_localctx = new ReservedKeyExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(723);
				match(T__48);
				setState(724);
				expression(17);
				}
				break;
			case 9:
				{
				_localctx = new LogicOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(725);
				match(T__49);
				setState(726);
				expression(16);
				}
				break;
			case 10:
				{
				_localctx = new LogicOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(727);
				match(T__50);
				setState(728);
				expression(15);
				}
				break;
			case 11:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(729);
				primaryExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(809);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(807);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(732);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(733);
						match(T__51);
						setState(734);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(735);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(736);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 27021597764223008L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(737);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(738);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(739);
						_la = _input.LA(1);
						if ( !(_la==T__45 || _la==T__46) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(740);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(741);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(742);
						_la = _input.LA(1);
						if ( !(_la==T__54 || _la==T__55) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(743);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(744);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(745);
						match(T__56);
						setState(746);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(747);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(748);
						match(T__57);
						setState(749);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(750);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(751);
						match(T__58);
						setState(752);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(753);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(754);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & -1152921504606846976L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(755);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(756);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(757);
						_la = _input.LA(1);
						if ( !(_la==T__63 || _la==T__64) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(758);
						expression(7);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(759);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(760);
						match(T__65);
						setState(761);
						expression(6);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(762);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(763);
						match(T__66);
						setState(764);
						expression(5);
						}
						break;
					case 12:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(765);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(766);
						_la = _input.LA(1);
						if ( !(_la==T__12 || (((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 1023L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(767);
						expression(3);
						}
						break;
					case 13:
						{
						_localctx = new UnaryPostOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(768);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(769);
						_la = _input.LA(1);
						if ( !(_la==T__41 || _la==T__42) ) {
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
						setState(770);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(771);
						match(T__22);
						setState(773);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
							{
							setState(772);
							expression(0);
							}
						}

						setState(775);
						match(T__23);
						}
						break;
					case 15:
						{
						_localctx = new ArraySliceContext(new ExpressionContext(_parentctx, _parentState));
						((ArraySliceContext)_localctx).base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(776);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(777);
						match(T__22);
						setState(779);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
							{
							setState(778);
							((ArraySliceContext)_localctx).start = expression(0);
							}
						}

						setState(781);
						match(T__44);
						setState(783);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
							{
							setState(782);
							((ArraySliceContext)_localctx).end = expression(0);
							}
						}

						setState(785);
						match(T__23);
						}
						break;
					case 16:
						{
						_localctx = new MemberLoadContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(786);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(787);
						match(T__24);
						setState(788);
						identifier();
						}
						break;
					case 17:
						{
						_localctx = new FuncCallExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(789);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(795);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__6) {
							{
							setState(790);
							match(T__6);
							setState(792);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
								{
								setState(791);
								nameValueList();
								}
							}

							setState(794);
							match(T__8);
							}
						}

						setState(797);
						match(T__10);
						setState(798);
						functionCallArguments();
						setState(799);
						match(T__11);
						}
						break;
					case 18:
						{
						_localctx = new TernaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(801);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(802);
						match(T__67);
						{
						setState(803);
						expression(0);
						setState(804);
						match(T__44);
						setState(805);
						expression(0);
						}
						}
						break;
					}
					} 
				}
				setState(811);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
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
		public UnicodeStringLiteralContext unicodeStringLiteral() {
			return getRuleContext(UnicodeStringLiteralContext.class,0);
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
		enterRule(_localctx, 114, RULE_primaryExpression);
		try {
			setState(826);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(812);
				match(BooleanLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(813);
				numberLiteral();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(814);
				hexLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(815);
				stringLiteral();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(816);
				unicodeStringLiteral();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(817);
				identifier();
				setState(819);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(818);
					arrayBrackets();
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(821);
				tupleExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(822);
				typeNameExpression();
				setState(824);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(823);
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
		enterRule(_localctx, 116, RULE_arrayBrackets);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(828);
			match(T__22);
			setState(829);
			match(T__23);
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
		enterRule(_localctx, 118, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			expression(0);
			setState(836);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(832);
				match(T__7);
				setState(833);
				expression(0);
				}
				}
				setState(838);
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
		enterRule(_localctx, 120, RULE_nameValueList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(839);
			nameValue();
			setState(844);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(840);
					match(T__7);
					setState(841);
					nameValue();
					}
					} 
				}
				setState(846);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			}
			setState(848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(847);
				match(T__7);
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
		enterRule(_localctx, 122, RULE_nameValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(850);
			identifier();
			setState(851);
			match(T__44);
			setState(852);
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
		enterRule(_localctx, 124, RULE_functionCallArguments);
		int _la;
		try {
			setState(862);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(854);
				match(T__6);
				setState(856);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
					{
					setState(855);
					nameValueList();
					}
				}

				setState(858);
				match(T__8);
				}
				break;
			case T__5:
			case T__10:
			case T__11:
			case T__22:
			case T__29:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
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
			case Gwei:
			case Szabo:
			case Finney:
			case HexLiteralFragment:
			case PayableKeyword:
			case TypeKeyword:
			case Identifier:
			case StringLiteralFragment:
			case UnicodeStringLiteralFragment:
				enterOuterAlt(_localctx, 2);
				{
				setState(860);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
					{
					setState(859);
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
		enterRule(_localctx, 126, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864);
			expression(0);
			setState(865);
			match(T__10);
			setState(866);
			functionCallArguments();
			setState(867);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 128, RULE_tupleExpression);
		int _la;
		try {
			setState(895);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(869);
				match(T__10);
				{
				setState(871);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
					{
					setState(870);
					expression(0);
					}
				}

				setState(879);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(873);
					match(T__7);
					setState(875);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
						{
						setState(874);
						expression(0);
						}
					}

					}
					}
					setState(881);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(882);
				match(T__11);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(883);
				match(T__22);
				setState(892);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4466217314158656L) != 0 || (((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 966501986303L) != 0) {
					{
					setState(884);
					expression(0);
					setState(889);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(885);
						match(T__7);
						setState(886);
						expression(0);
						}
						}
						setState(891);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(894);
				match(T__23);
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
		enterRule(_localctx, 130, RULE_typeNameExpression);
		try {
			setState(899);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(897);
				elementaryTypeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(898);
				userDefinedTypeName();
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
		enterRule(_localctx, 132, RULE_assemblyItem);
		try {
			setState(919);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(901);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(902);
				assemblyBlock();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(903);
				assemblyExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(904);
				assemblyLocalDefinition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(905);
				assemblyAssignment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(906);
				assemblyStackAssignment();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(907);
				labelDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(908);
				assemblySwitch();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(909);
				assemblyFunctionDefinition();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(910);
				assemblyFor();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(911);
				assemblyIf();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(912);
				match(BreakKeyword);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(913);
				match(ContinueKeyword);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(914);
				match(LeaveKeyword);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(915);
				subAssembly();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(916);
				numberLiteral();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(917);
				stringLiteral();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(918);
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
		enterRule(_localctx, 134, RULE_assemblyBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(921);
			match(T__6);
			setState(925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2545842454720L) != 0 || (((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 422226016370701L) != 0) {
				{
				{
				setState(922);
				assemblyItem();
				}
				}
				setState(927);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(928);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		public AssemblyIdentifierContext assemblyIdentifier() {
			return getRuleContext(AssemblyIdentifierContext.class,0);
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
		enterRule(_localctx, 136, RULE_assemblyExpression);
		try {
			setState(933);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(930);
				assemblyCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(931);
				assemblyLiteral();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(932);
				assemblyIdentifier();
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
		enterRule(_localctx, 138, RULE_assemblyCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(935);
				match(T__37);
				}
				break;
			case 2:
				{
				setState(936);
				match(T__40);
				}
				break;
			case 3:
				{
				setState(937);
				match(AByte);
				}
				break;
			case 4:
				{
				setState(938);
				identifier();
				}
				break;
			}
			setState(953);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(941);
				match(T__10);
				setState(943);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2474974904384L) != 0 || (((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 12884905841L) != 0) {
					{
					setState(942);
					assemblyExpression();
					}
				}

				setState(949);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(945);
					match(T__7);
					setState(946);
					assemblyExpression();
					}
					}
					setState(951);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(952);
				match(T__11);
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
		enterRule(_localctx, 140, RULE_assemblyLocalDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(955);
			match(T__78);
			setState(956);
			assemblyIdentifierList();
			setState(959);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__79) {
				{
				setState(957);
				match(T__79);
				setState(958);
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
		enterRule(_localctx, 142, RULE_assemblyAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(961);
			assemblyIdentifierList();
			setState(962);
			match(T__79);
			setState(963);
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
		public List<AssemblyIdentifierContext> assemblyIdentifier() {
			return getRuleContexts(AssemblyIdentifierContext.class);
		}
		public AssemblyIdentifierContext assemblyIdentifier(int i) {
			return getRuleContext(AssemblyIdentifierContext.class,i);
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
		enterRule(_localctx, 144, RULE_assemblyIdentifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(965);
			assemblyIdentifier();
			setState(970);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(966);
				match(T__7);
				setState(967);
				assemblyIdentifier();
				}
				}
				setState(972);
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
	public static class AssemblyIdentifierContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public AssemblyIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblyIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterAssemblyIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitAssemblyIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitAssemblyIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyIdentifierContext assemblyIdentifier() throws RecognitionException {
		AssemblyIdentifierContext _localctx = new AssemblyIdentifierContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_assemblyIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(973);
			identifier();
			setState(978);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(974);
				match(T__24);
				setState(975);
				identifier();
				}
				}
				setState(980);
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
		enterRule(_localctx, 148, RULE_assemblyStackAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(981);
			match(T__80);
			setState(982);
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
		enterRule(_localctx, 150, RULE_labelDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(984);
			identifier();
			setState(985);
			match(T__44);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 152, RULE_assemblySwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(987);
			match(T__81);
			setState(988);
			assemblyExpression();
			setState(992);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__82 || _la==T__83) {
				{
				{
				setState(989);
				assemblyCase();
				}
				}
				setState(994);
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
		enterRule(_localctx, 154, RULE_assemblyCase);
		int _la;
		try {
			setState(1004);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__82:
				enterOuterAlt(_localctx, 1);
				{
				setState(995);
				match(T__82);
				setState(996);
				assemblyLiteral();
				setState(998);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(997);
					assemblyType();
					}
				}

				setState(1000);
				assemblyBlock();
				}
				break;
			case T__83:
				enterOuterAlt(_localctx, 2);
				{
				setState(1002);
				match(T__83);
				setState(1003);
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
		enterRule(_localctx, 156, RULE_assemblyFunctionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			match(T__18);
			setState(1007);
			identifier();
			setState(1008);
			match(T__10);
			setState(1010);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) {
				{
				setState(1009);
				assemblyTypedVariableList();
				}
			}

			setState(1012);
			match(T__11);
			setState(1014);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46) {
				{
				setState(1013);
				assemblyFunctionReturns();
				}
			}

			setState(1016);
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
		enterRule(_localctx, 158, RULE_assemblyFunctionReturns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1018);
			match(T__46);
			setState(1019);
			match(T__60);
			setState(1020);
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
		enterRule(_localctx, 160, RULE_assemblyFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1022);
			match(T__15);
			setState(1023);
			assemblyBlock();
			setState(1024);
			assemblyExpression();
			setState(1025);
			assemblyBlock();
			setState(1026);
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
		enterRule(_localctx, 162, RULE_assemblyIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1028);
			match(T__30);
			setState(1029);
			assemblyExpression();
			setState(1030);
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
		enterRule(_localctx, 164, RULE_assemblyLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1037);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteralFragment:
				{
				setState(1032);
				stringLiteral();
				}
				break;
			case DecimalNumber:
				{
				setState(1033);
				match(DecimalNumber);
				}
				break;
			case HexNumber:
				{
				setState(1034);
				match(HexNumber);
				}
				break;
			case HexLiteralFragment:
				{
				setState(1035);
				hexLiteral();
				}
				break;
			case BooleanLiteral:
				{
				setState(1036);
				match(BooleanLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1040);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				{
				setState(1039);
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
		enterRule(_localctx, 166, RULE_assemblyTypedVariableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042);
			identifier();
			setState(1044);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__44) {
				{
				setState(1043);
				assemblyType();
				}
			}

			setState(1048);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(1046);
				match(T__7);
				setState(1047);
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
		enterRule(_localctx, 168, RULE_assemblyType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1050);
			match(T__44);
			setState(1051);
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
		enterRule(_localctx, 170, RULE_subAssembly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1053);
			match(T__35);
			setState(1054);
			identifier();
			setState(1055);
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
		public TerminalNode Gwei() { return getToken(SolidityParser.Gwei, 0); }
		public TerminalNode Finney() { return getToken(SolidityParser.Finney, 0); }
		public TerminalNode Szabo() { return getToken(SolidityParser.Szabo, 0); }
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
		enterRule(_localctx, 172, RULE_numberLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1057);
			_la = _input.LA(1);
			if ( !(_la==DecimalNumber || _la==HexNumber) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1059);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				{
				setState(1058);
				_la = _input.LA(1);
				if ( !((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & 15L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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
		public TerminalNode Gwei() { return getToken(SolidityParser.Gwei, 0); }
		public TerminalNode Finney() { return getToken(SolidityParser.Finney, 0); }
		public TerminalNode Szabo() { return getToken(SolidityParser.Szabo, 0); }
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
		enterRule(_localctx, 174, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1061);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 2200096997440L) != 0 || (((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 16777223L) != 0) ) {
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
		enterRule(_localctx, 176, RULE_hexLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1064); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1063);
					match(HexLiteralFragment);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1066); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
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
		enterRule(_localctx, 178, RULE_stringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1069); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1068);
					match(StringLiteralFragment);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1071); 
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
	public static class UnicodeStringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> UnicodeStringLiteralFragment() { return getTokens(SolidityParser.UnicodeStringLiteralFragment); }
		public TerminalNode UnicodeStringLiteralFragment(int i) {
			return getToken(SolidityParser.UnicodeStringLiteralFragment, i);
		}
		public UnicodeStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unicodeStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).enterUnicodeStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SolidityListener ) ((SolidityListener)listener).exitUnicodeStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SolidityVisitor ) return ((SolidityVisitor<? extends T>)visitor).visitUnicodeStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnicodeStringLiteralContext unicodeStringLiteral() throws RecognitionException {
		UnicodeStringLiteralContext _localctx = new UnicodeStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_unicodeStringLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1074); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1073);
					match(UnicodeStringLiteralFragment);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1076); 
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
		case 27:
			return typeName_sempred((TypeNameContext)_localctx, predIndex);
		case 56:
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
		"\u0004\u0001\u0083\u0437\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"Y\u0002Z\u0007Z\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u00bc\b\u0000\n\u0000\f\u0000\u00bf\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0005\u0003\u00cb\b\u0003\n\u0003"+
		"\f\u0003\u00ce\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00d4\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00da\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00de\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00e8\b\u0004\n\u0004\f\u0004"+
		"\u00eb\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00f2\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00f7\b\u0005\u0001\u0006\u0003\u0006\u00fa\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0102"+
		"\b\u0006\n\u0006\f\u0006\u0105\t\u0006\u0003\u0006\u0107\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u010b\b\u0006\n\u0006\f\u0006\u010e\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u0115\b\u0007\u0001\u0007\u0003\u0007\u0118\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0121\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u012a\b\t\n\t\f\t\u012d\t\t"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u0132\b\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u013b\b\n\n\n\f\n\u013e\t\n\u0001\n"+
		"\u0001\n\u0003\n\u0142\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0149\b\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0155"+
		"\b\f\n\f\f\f\u0158\t\f\u0003\f\u015a\b\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u0161\b\r\u0001\r\u0001\r\u0005\r\u0165\b\r\n\r\f\r"+
		"\u0168\t\r\u0001\r\u0001\r\u0003\r\u016c\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0172\b\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0176\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u017d\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u0182\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u018b\b\u0011\n\u0011\f\u0011"+
		"\u018e\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0193\b"+
		"\u0012\u0001\u0012\u0003\u0012\u0196\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u019c\b\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u01a4\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u01a8\b\u0014\n\u0014\f\u0014\u01ab\t\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u01b5\b\u0016\n\u0016\f\u0016\u01b8"+
		"\t\u0016\u0003\u0016\u01ba\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u01c0\b\u0017\u0001\u0017\u0003\u0017\u01c3\b"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01c9"+
		"\b\u0018\n\u0018\f\u0018\u01cc\t\u0018\u0003\u0018\u01ce\b\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u01d4\b\u0019\u0001"+
		"\u0019\u0003\u0019\u01d7\b\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u01db"+
		"\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0003\u001b\u01e4\b\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0003\u001b\u01e9\b\u001b\u0001\u001b\u0005\u001b\u01ec\b\u001b"+
		"\n\u001b\f\u001b\u01ef\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005"+
		"\u001c\u01f4\b\u001c\n\u001c\f\u001c\u01f7\t\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0003\u001e\u0202\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0003\u001f\u0208\b\u001f\u0001 \u0001 \u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0005#\u0212\b#\n#\f#\u0215\t#\u0001#\u0001#"+
		"\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0003$\u0226\b$\u0001%\u0001%\u0001%\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u0232\b&\u0001\'\u0001\'\u0001"+
		"\'\u0003\'\u0237\b\'\u0001\'\u0001\'\u0004\'\u023b\b\'\u000b\'\f\'\u023c"+
		"\u0001(\u0001(\u0003(\u0241\b(\u0001(\u0003(\u0244\b(\u0001(\u0001(\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u0252\b*\u0001*\u0001*\u0003*\u0256\b*\u0001*\u0003*\u0259\b*\u0001"+
		"*\u0001*\u0001*\u0001+\u0001+\u0003+\u0260\b+\u0001,\u0001,\u0003,\u0264"+
		"\b,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u00010\u00010\u00030\u0278"+
		"\b0\u00010\u00010\u00011\u00011\u00011\u00012\u00012\u00012\u00012\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00013\u00033\u028a\b3\u00013\u0001"+
		"3\u00033\u028e\b3\u00013\u00013\u00014\u00034\u0293\b4\u00014\u00014\u0003"+
		"4\u0297\b4\u00054\u0299\b4\n4\f4\u029c\t4\u00015\u00015\u00035\u02a0\b"+
		"5\u00015\u00055\u02a3\b5\n5\f5\u02a6\t5\u00015\u00035\u02a9\b5\u00015"+
		"\u00015\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00036\u02b7\b6\u00017\u00017\u00037\u02bb\b7\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00038\u02db\b8\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00038\u0306\b8\u00018\u00018\u00018\u00018\u00038\u030c\b8\u00018\u0001"+
		"8\u00038\u0310\b8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0003"+
		"8\u0319\b8\u00018\u00038\u031c\b8\u00018\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00058\u0328\b8\n8\f8\u032b\t8\u00019\u0001"+
		"9\u00019\u00019\u00019\u00019\u00019\u00039\u0334\b9\u00019\u00019\u0001"+
		"9\u00039\u0339\b9\u00039\u033b\b9\u0001:\u0001:\u0001:\u0001;\u0001;\u0001"+
		";\u0005;\u0343\b;\n;\f;\u0346\t;\u0001<\u0001<\u0001<\u0005<\u034b\b<"+
		"\n<\f<\u034e\t<\u0001<\u0003<\u0351\b<\u0001=\u0001=\u0001=\u0001=\u0001"+
		">\u0001>\u0003>\u0359\b>\u0001>\u0001>\u0003>\u035d\b>\u0003>\u035f\b"+
		">\u0001?\u0001?\u0001?\u0001?\u0001?\u0001@\u0001@\u0003@\u0368\b@\u0001"+
		"@\u0001@\u0003@\u036c\b@\u0005@\u036e\b@\n@\f@\u0371\t@\u0001@\u0001@"+
		"\u0001@\u0001@\u0001@\u0005@\u0378\b@\n@\f@\u037b\t@\u0003@\u037d\b@\u0001"+
		"@\u0003@\u0380\b@\u0001A\u0001A\u0003A\u0384\bA\u0001B\u0001B\u0001B\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0001B\u0001B\u0001B\u0001B\u0003B\u0398\bB\u0001C\u0001C\u0005C\u039c"+
		"\bC\nC\fC\u039f\tC\u0001C\u0001C\u0001D\u0001D\u0001D\u0003D\u03a6\bD"+
		"\u0001E\u0001E\u0001E\u0001E\u0003E\u03ac\bE\u0001E\u0001E\u0003E\u03b0"+
		"\bE\u0001E\u0001E\u0005E\u03b4\bE\nE\fE\u03b7\tE\u0001E\u0003E\u03ba\b"+
		"E\u0001F\u0001F\u0001F\u0001F\u0003F\u03c0\bF\u0001G\u0001G\u0001G\u0001"+
		"G\u0001H\u0001H\u0001H\u0005H\u03c9\bH\nH\fH\u03cc\tH\u0001I\u0001I\u0001"+
		"I\u0005I\u03d1\bI\nI\fI\u03d4\tI\u0001J\u0001J\u0001J\u0001K\u0001K\u0001"+
		"K\u0001L\u0001L\u0001L\u0005L\u03df\bL\nL\fL\u03e2\tL\u0001M\u0001M\u0001"+
		"M\u0003M\u03e7\bM\u0001M\u0001M\u0001M\u0001M\u0003M\u03ed\bM\u0001N\u0001"+
		"N\u0001N\u0001N\u0003N\u03f3\bN\u0001N\u0001N\u0003N\u03f7\bN\u0001N\u0001"+
		"N\u0001O\u0001O\u0001O\u0001O\u0001P\u0001P\u0001P\u0001P\u0001P\u0001"+
		"P\u0001Q\u0001Q\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001R\u0001R\u0003"+
		"R\u040e\bR\u0001R\u0003R\u0411\bR\u0001S\u0001S\u0003S\u0415\bS\u0001"+
		"S\u0001S\u0003S\u0419\bS\u0001T\u0001T\u0001T\u0001U\u0001U\u0001U\u0001"+
		"U\u0001V\u0001V\u0003V\u0424\bV\u0001W\u0001W\u0001X\u0004X\u0429\bX\u000b"+
		"X\fX\u042a\u0001Y\u0004Y\u042e\bY\u000bY\fY\u042f\u0001Z\u0004Z\u0433"+
		"\bZ\u000bZ\fZ\u0434\u0001Z\u0000\u00026p[\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2"+
		"\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u0000\u000f\u0001"+
		"\u0000\u0002\u0002\u0001\u0000UW\u0001\u0000\u001c\u001e\u0004\u0000m"+
		"mttxxzz\u0003\u0000qqssuw\u0001\u0000*+\u0001\u0000./\u0002\u0000\u0005"+
		"\u000556\u0001\u000078\u0001\u0000<?\u0001\u0000@A\u0002\u0000\r\rEN\u0001"+
		"\u0000cd\u0001\u0000eh\u0005\u0000\u0006\u0006\u001e\u001e))fh~~\u04b6"+
		"\u0000\u00bd\u0001\u0000\u0000\u0000\u0002\u00c2\u0001\u0000\u0000\u0000"+
		"\u0004\u00c7\u0001\u0000\u0000\u0000\u0006\u00cc\u0001\u0000\u0000\u0000"+
		"\b\u00f1\u0001\u0000\u0000\u0000\n\u00f3\u0001\u0000\u0000\u0000\f\u00f9"+
		"\u0001\u0000\u0000\u0000\u000e\u0111\u0001\u0000\u0000\u0000\u0010\u0120"+
		"\u0001\u0000\u0000\u0000\u0012\u0122\u0001\u0000\u0000\u0000\u0014\u0135"+
		"\u0001\u0000\u0000\u0000\u0016\u0143\u0001\u0000\u0000\u0000\u0018\u014c"+
		"\u0001\u0000\u0000\u0000\u001a\u015d\u0001\u0000\u0000\u0000\u001c\u016d"+
		"\u0001\u0000\u0000\u0000\u001e\u0181\u0001\u0000\u0000\u0000 \u0183\u0001"+
		"\u0000\u0000\u0000\"\u018c\u0001\u0000\u0000\u0000$\u018f\u0001\u0000"+
		"\u0000\u0000&\u0197\u0001\u0000\u0000\u0000(\u019f\u0001\u0000\u0000\u0000"+
		"*\u01ae\u0001\u0000\u0000\u0000,\u01b0\u0001\u0000\u0000\u0000.\u01bd"+
		"\u0001\u0000\u0000\u00000\u01c4\u0001\u0000\u0000\u00002\u01d1\u0001\u0000"+
		"\u0000\u00004\u01d8\u0001\u0000\u0000\u00006\u01e3\u0001\u0000\u0000\u0000"+
		"8\u01f0\u0001\u0000\u0000\u0000:\u01f8\u0001\u0000\u0000\u0000<\u0201"+
		"\u0001\u0000\u0000\u0000>\u0203\u0001\u0000\u0000\u0000@\u0209\u0001\u0000"+
		"\u0000\u0000B\u020b\u0001\u0000\u0000\u0000D\u020d\u0001\u0000\u0000\u0000"+
		"F\u020f\u0001\u0000\u0000\u0000H\u0225\u0001\u0000\u0000\u0000J\u0227"+
		"\u0001\u0000\u0000\u0000L\u022a\u0001\u0000\u0000\u0000N\u0233\u0001\u0000"+
		"\u0000\u0000P\u023e\u0001\u0000\u0000\u0000R\u0247\u0001\u0000\u0000\u0000"+
		"T\u024d\u0001\u0000\u0000\u0000V\u025f\u0001\u0000\u0000\u0000X\u0261"+
		"\u0001\u0000\u0000\u0000Z\u0267\u0001\u0000\u0000\u0000\\\u026f\u0001"+
		"\u0000\u0000\u0000^\u0272\u0001\u0000\u0000\u0000`\u0275\u0001\u0000\u0000"+
		"\u0000b\u027b\u0001\u0000\u0000\u0000d\u027e\u0001\u0000\u0000\u0000f"+
		"\u0289\u0001\u0000\u0000\u0000h\u0292\u0001\u0000\u0000\u0000j\u029d\u0001"+
		"\u0000\u0000\u0000l\u02b6\u0001\u0000\u0000\u0000n\u02b8\u0001\u0000\u0000"+
		"\u0000p\u02da\u0001\u0000\u0000\u0000r\u033a\u0001\u0000\u0000\u0000t"+
		"\u033c\u0001\u0000\u0000\u0000v\u033f\u0001\u0000\u0000\u0000x\u0347\u0001"+
		"\u0000\u0000\u0000z\u0352\u0001\u0000\u0000\u0000|\u035e\u0001\u0000\u0000"+
		"\u0000~\u0360\u0001\u0000\u0000\u0000\u0080\u037f\u0001\u0000\u0000\u0000"+
		"\u0082\u0383\u0001\u0000\u0000\u0000\u0084\u0397\u0001\u0000\u0000\u0000"+
		"\u0086\u0399\u0001\u0000\u0000\u0000\u0088\u03a5\u0001\u0000\u0000\u0000"+
		"\u008a\u03ab\u0001\u0000\u0000\u0000\u008c\u03bb\u0001\u0000\u0000\u0000"+
		"\u008e\u03c1\u0001\u0000\u0000\u0000\u0090\u03c5\u0001\u0000\u0000\u0000"+
		"\u0092\u03cd\u0001\u0000\u0000\u0000\u0094\u03d5\u0001\u0000\u0000\u0000"+
		"\u0096\u03d8\u0001\u0000\u0000\u0000\u0098\u03db\u0001\u0000\u0000\u0000"+
		"\u009a\u03ec\u0001\u0000\u0000\u0000\u009c\u03ee\u0001\u0000\u0000\u0000"+
		"\u009e\u03fa\u0001\u0000\u0000\u0000\u00a0\u03fe\u0001\u0000\u0000\u0000"+
		"\u00a2\u0404\u0001\u0000\u0000\u0000\u00a4\u040d\u0001\u0000\u0000\u0000"+
		"\u00a6\u0412\u0001\u0000\u0000\u0000\u00a8\u041a\u0001\u0000\u0000\u0000"+
		"\u00aa\u041d\u0001\u0000\u0000\u0000\u00ac\u0421\u0001\u0000\u0000\u0000"+
		"\u00ae\u0425\u0001\u0000\u0000\u0000\u00b0\u0428\u0001\u0000\u0000\u0000"+
		"\u00b2\u042d\u0001\u0000\u0000\u0000\u00b4\u0432\u0001\u0000\u0000\u0000"+
		"\u00b6\u00bc\u0003\u0002\u0001\u0000\u00b7\u00bc\u0003\b\u0004\u0000\u00b8"+
		"\u00bc\u0003\u0018\f\u0000\u00b9\u00bc\u0003(\u0014\u0000\u00ba\u00bc"+
		"\u0003\f\u0006\u0000\u00bb\u00b6\u0001\u0000\u0000\u0000\u00bb\u00b7\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b8\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001"+
		"\u0000\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001"+
		"\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001"+
		"\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0005\u0000\u0000\u0001\u00c1\u0001\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0005\u0001\u0000\u0000\u00c3\u00c4\u0003"+
		"\u0004\u0002\u0000\u00c4\u00c5\u0003\u0006\u0003\u0000\u00c5\u00c6\u0005"+
		"\u0002\u0000\u0000\u00c6\u0003\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003"+
		"\u00aeW\u0000\u00c8\u0005\u0001\u0000\u0000\u0000\u00c9\u00cb\b\u0000"+
		"\u0000\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000"+
		"\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cd\u0007\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u0005\u0003\u0000\u0000\u00d0\u00d3\u0005\u007f"+
		"\u0000\u0000\u00d1\u00d2\u0005\u0004\u0000\u0000\u00d2\u00d4\u0003\u00ae"+
		"W\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00f2\u0005\u0002\u0000"+
		"\u0000\u00d6\u00d9\u0005\u0003\u0000\u0000\u00d7\u00da\u0005\u0005\u0000"+
		"\u0000\u00d8\u00da\u0003\u00aeW\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0005\u0004\u0000\u0000\u00dc\u00de\u0003\u00aeW\u0000\u00dd"+
		"\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0006\u0000\u0000\u00e0"+
		"\u00e1\u0005\u007f\u0000\u0000\u00e1\u00f2\u0005\u0002\u0000\u0000\u00e2"+
		"\u00e3\u0005\u0003\u0000\u0000\u00e3\u00e4\u0005\u0007\u0000\u0000\u00e4"+
		"\u00e9\u0003\n\u0005\u0000\u00e5\u00e6\u0005\b\u0000\u0000\u00e6\u00e8"+
		"\u0003\n\u0005\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001"+
		"\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001"+
		"\u0000\u0000\u0000\u00ea\u00ec\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ed\u0005\t\u0000\u0000\u00ed\u00ee\u0005\u0006"+
		"\u0000\u0000\u00ee\u00ef\u0005\u007f\u0000\u0000\u00ef\u00f0\u0005\u0002"+
		"\u0000\u0000\u00f0\u00f2\u0001\u0000\u0000\u0000\u00f1\u00cf\u0001\u0000"+
		"\u0000\u0000\u00f1\u00d6\u0001\u0000\u0000\u0000\u00f1\u00e2\u0001\u0000"+
		"\u0000\u0000\u00f2\t\u0001\u0000\u0000\u0000\u00f3\u00f6\u0003\u00aeW"+
		"\u0000\u00f4\u00f5\u0005\u0004\u0000\u0000\u00f5\u00f7\u0003\u00aeW\u0000"+
		"\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000"+
		"\u00f7\u000b\u0001\u0000\u0000\u0000\u00f8\u00fa\u0005X\u0000\u0000\u00f9"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0007\u0001\u0000\u0000\u00fc"+
		"\u0106\u0003\u00aeW\u0000\u00fd\u00fe\u0005\n\u0000\u0000\u00fe\u0103"+
		"\u0003\u000e\u0007\u0000\u00ff\u0100\u0005\b\u0000\u0000\u0100\u0102\u0003"+
		"\u000e\u0007\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0105\u0001"+
		"\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001"+
		"\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001"+
		"\u0000\u0000\u0000\u0106\u00fd\u0001\u0000\u0000\u0000\u0106\u0107\u0001"+
		"\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u010c\u0005"+
		"\u0007\u0000\u0000\u0109\u010b\u0003\u0010\b\u0000\u010a\u0109\u0001\u0000"+
		"\u0000\u0000\u010b\u010e\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010f\u0001\u0000"+
		"\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010f\u0110\u0005\t\u0000"+
		"\u0000\u0110\r\u0001\u0000\u0000\u0000\u0111\u0117\u00038\u001c\u0000"+
		"\u0112\u0114\u0005\u000b\u0000\u0000\u0113\u0115\u0003v;\u0000\u0114\u0113"+
		"\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0116"+
		"\u0001\u0000\u0000\u0000\u0116\u0118\u0005\f\u0000\u0000\u0117\u0112\u0001"+
		"\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u000f\u0001"+
		"\u0000\u0000\u0000\u0119\u0121\u0003\u0012\t\u0000\u011a\u0121\u0003\u0016"+
		"\u000b\u0000\u011b\u0121\u0003\u0018\f\u0000\u011c\u0121\u0003\u001a\r"+
		"\u0000\u011d\u0121\u0003\u001c\u000e\u0000\u011e\u0121\u0003&\u0013\u0000"+
		"\u011f\u0121\u0003(\u0014\u0000\u0120\u0119\u0001\u0000\u0000\u0000\u0120"+
		"\u011a\u0001\u0000\u0000\u0000\u0120\u011b\u0001\u0000\u0000\u0000\u0120"+
		"\u011c\u0001\u0000\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0120"+
		"\u011e\u0001\u0000\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0121"+
		"\u0011\u0001\u0000\u0000\u0000\u0122\u012b\u00036\u001b\u0000\u0123\u012a"+
		"\u0005v\u0000\u0000\u0124\u012a\u0005s\u0000\u0000\u0125\u012a\u0005u"+
		"\u0000\u0000\u0126\u012a\u0005m\u0000\u0000\u0127\u012a\u0005n\u0000\u0000"+
		"\u0128\u012a\u0003\u0014\n\u0000\u0129\u0123\u0001\u0000\u0000\u0000\u0129"+
		"\u0124\u0001\u0000\u0000\u0000\u0129\u0125\u0001\u0000\u0000\u0000\u0129"+
		"\u0126\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129"+
		"\u0128\u0001\u0000\u0000\u0000\u012a\u012d\u0001\u0000\u0000\u0000\u012b"+
		"\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c"+
		"\u012e\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012e"+
		"\u0131\u0003\u00aeW\u0000\u012f\u0130\u0005\r\u0000\u0000\u0130\u0132"+
		"\u0003p8\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000"+
		"\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u0134\u0005\u0002"+
		"\u0000\u0000\u0134\u0013\u0001\u0000\u0000\u0000\u0135\u0141\u0005\u000e"+
		"\u0000\u0000\u0136\u0137\u0005\u000b\u0000\u0000\u0137\u013c\u00038\u001c"+
		"\u0000\u0138\u0139\u0005\b\u0000\u0000\u0139\u013b\u00038\u001c\u0000"+
		"\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u013e\u0001\u0000\u0000\u0000"+
		"\u013c\u013a\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000"+
		"\u013d\u013f\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000"+
		"\u013f\u0140\u0005\f\u0000\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141"+
		"\u0136\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142"+
		"\u0015\u0001\u0000\u0000\u0000\u0143\u0144\u0005\u000f\u0000\u0000\u0144"+
		"\u0145\u0003\u00aeW\u0000\u0145\u0148\u0005\u0010\u0000\u0000\u0146\u0149"+
		"\u0005\u0005\u0000\u0000\u0147\u0149\u00036\u001b\u0000\u0148\u0146\u0001"+
		"\u0000\u0000\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001"+
		"\u0000\u0000\u0000\u014a\u014b\u0005\u0002\u0000\u0000\u014b\u0017\u0001"+
		"\u0000\u0000\u0000\u014c\u014d\u0005\u0011\u0000\u0000\u014d\u014e\u0003"+
		"\u00aeW\u0000\u014e\u0159\u0005\u0007\u0000\u0000\u014f\u0150\u00034\u001a"+
		"\u0000\u0150\u0156\u0005\u0002\u0000\u0000\u0151\u0152\u00034\u001a\u0000"+
		"\u0152\u0153\u0005\u0002\u0000\u0000\u0153\u0155\u0001\u0000\u0000\u0000"+
		"\u0154\u0151\u0001\u0000\u0000\u0000\u0155\u0158\u0001\u0000\u0000\u0000"+
		"\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000"+
		"\u0157\u015a\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000"+
		"\u0159\u014f\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000"+
		"\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015c\u0005\t\u0000\u0000\u015c"+
		"\u0019\u0001\u0000\u0000\u0000\u015d\u015e\u0005\u0012\u0000\u0000\u015e"+
		"\u0160\u0003\u00aeW\u0000\u015f\u0161\u0003,\u0016\u0000\u0160\u015f\u0001"+
		"\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u0166\u0001"+
		"\u0000\u0000\u0000\u0162\u0165\u0005w\u0000\u0000\u0163\u0165\u0003\u0014"+
		"\n\u0000\u0164\u0162\u0001\u0000\u0000\u0000\u0164\u0163\u0001\u0000\u0000"+
		"\u0000\u0165\u0168\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000"+
		"\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u016b\u0001\u0000\u0000"+
		"\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0169\u016c\u0005\u0002\u0000"+
		"\u0000\u016a\u016c\u0003F#\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016b"+
		"\u016a\u0001\u0000\u0000\u0000\u016c\u001b\u0001\u0000\u0000\u0000\u016d"+
		"\u016e\u0003\u001e\u000f\u0000\u016e\u016f\u0003,\u0016\u0000\u016f\u0171"+
		"\u0003\"\u0011\u0000\u0170\u0172\u0003 \u0010\u0000\u0171\u0170\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0175\u0001"+
		"\u0000\u0000\u0000\u0173\u0176\u0005\u0002\u0000\u0000\u0174\u0176\u0003"+
		"F#\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0174\u0001\u0000\u0000"+
		"\u0000\u0176\u001d\u0001\u0000\u0000\u0000\u0177\u017c\u0005\u0013\u0000"+
		"\u0000\u0178\u017d\u0003\u00aeW\u0000\u0179\u017d\u0005}\u0000\u0000\u017a"+
		"\u017d\u0005|\u0000\u0000\u017b\u017d\u0005{\u0000\u0000\u017c\u0178\u0001"+
		"\u0000\u0000\u0000\u017c\u0179\u0001\u0000\u0000\u0000\u017c\u017a\u0001"+
		"\u0000\u0000\u0000\u017c\u017b\u0001\u0000\u0000\u0000\u017c\u017d\u0001"+
		"\u0000\u0000\u0000\u017d\u0182\u0001\u0000\u0000\u0000\u017e\u0182\u0005"+
		"{\u0000\u0000\u017f\u0182\u0005|\u0000\u0000\u0180\u0182\u0005}\u0000"+
		"\u0000\u0181\u0177\u0001\u0000\u0000\u0000\u0181\u017e\u0001\u0000\u0000"+
		"\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0180\u0001\u0000\u0000"+
		"\u0000\u0182\u001f\u0001\u0000\u0000\u0000\u0183\u0184\u0005\u0014\u0000"+
		"\u0000\u0184\u0185\u0003,\u0016\u0000\u0185!\u0001\u0000\u0000\u0000\u0186"+
		"\u018b\u0003$\u0012\u0000\u0187\u018b\u0003B!\u0000\u0188\u018b\u0003"+
		"D\"\u0000\u0189\u018b\u0003\u0014\n\u0000\u018a\u0186\u0001\u0000\u0000"+
		"\u0000\u018a\u0187\u0001\u0000\u0000\u0000\u018a\u0188\u0001\u0000\u0000"+
		"\u0000\u018a\u0189\u0001\u0000\u0000\u0000\u018b\u018e\u0001\u0000\u0000"+
		"\u0000\u018c\u018a\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000"+
		"\u0000\u018d#\u0001\u0000\u0000\u0000\u018e\u018c\u0001\u0000\u0000\u0000"+
		"\u018f\u0195\u0003\u00aeW\u0000\u0190\u0192\u0005\u000b\u0000\u0000\u0191"+
		"\u0193\u0003v;\u0000\u0192\u0191\u0001\u0000\u0000\u0000\u0192\u0193\u0001"+
		"\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194\u0196\u0005"+
		"\f\u0000\u0000\u0195\u0190\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000"+
		"\u0000\u0000\u0196%\u0001\u0000\u0000\u0000\u0197\u0198\u0005\u0015\u0000"+
		"\u0000\u0198\u0199\u0003\u00aeW\u0000\u0199\u019b\u00030\u0018\u0000\u019a"+
		"\u019c\u0005k\u0000\u0000\u019b\u019a\u0001\u0000\u0000\u0000\u019b\u019c"+
		"\u0001\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d\u019e"+
		"\u0005\u0002\u0000\u0000\u019e\'\u0001\u0000\u0000\u0000\u019f\u01a0\u0005"+
		"\u0016\u0000\u0000\u01a0\u01a1\u0003\u00aeW\u0000\u01a1\u01a3\u0005\u0007"+
		"\u0000\u0000\u01a2\u01a4\u0003*\u0015\u0000\u01a3\u01a2\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01a9\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a6\u0005\b\u0000\u0000\u01a6\u01a8\u0003*\u0015\u0000"+
		"\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a8\u01ab\u0001\u0000\u0000\u0000"+
		"\u01a9\u01a7\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ac\u0001\u0000\u0000\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ad\u0005\t\u0000\u0000\u01ad)\u0001\u0000\u0000\u0000\u01ae"+
		"\u01af\u0003\u00aeW\u0000\u01af+\u0001\u0000\u0000\u0000\u01b0\u01b9\u0005"+
		"\u000b\u0000\u0000\u01b1\u01b6\u0003.\u0017\u0000\u01b2\u01b3\u0005\b"+
		"\u0000\u0000\u01b3\u01b5\u0003.\u0017\u0000\u01b4\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b8\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7\u01ba\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b9\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000"+
		"\u0000\u01bb\u01bc\u0005\f\u0000\u0000\u01bc-\u0001\u0000\u0000\u0000"+
		"\u01bd\u01bf\u00036\u001b\u0000\u01be\u01c0\u0003@ \u0000\u01bf\u01be"+
		"\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0\u01c2"+
		"\u0001\u0000\u0000\u0000\u01c1\u01c3\u0003\u00aeW\u0000\u01c2\u01c1\u0001"+
		"\u0000\u0000\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3/\u0001\u0000"+
		"\u0000\u0000\u01c4\u01cd\u0005\u000b\u0000\u0000\u01c5\u01ca\u00032\u0019"+
		"\u0000\u01c6\u01c7\u0005\b\u0000\u0000\u01c7\u01c9\u00032\u0019\u0000"+
		"\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c9\u01cc\u0001\u0000\u0000\u0000"+
		"\u01ca\u01c8\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000"+
		"\u01cb\u01ce\u0001\u0000\u0000\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000"+
		"\u01cd\u01c5\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000"+
		"\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf\u01d0\u0005\f\u0000\u0000\u01d0"+
		"1\u0001\u0000\u0000\u0000\u01d1\u01d3\u00036\u001b\u0000\u01d2\u01d4\u0005"+
		"r\u0000\u0000\u01d3\u01d2\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000"+
		"\u0000\u0000\u01d4\u01d6\u0001\u0000\u0000\u0000\u01d5\u01d7\u0003\u00ae"+
		"W\u0000\u01d6\u01d5\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000"+
		"\u0000\u01d73\u0001\u0000\u0000\u0000\u01d8\u01da\u00036\u001b\u0000\u01d9"+
		"\u01db\u0003@ \u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da\u01db\u0001"+
		"\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc\u01dd\u0003"+
		"\u00aeW\u0000\u01dd5\u0001\u0000\u0000\u0000\u01de\u01df\u0006\u001b\uffff"+
		"\uffff\u0000\u01df\u01e4\u0003l6\u0000\u01e0\u01e4\u00038\u001c\u0000"+
		"\u01e1\u01e4\u0003:\u001d\u0000\u01e2\u01e4\u0003>\u001f\u0000\u01e3\u01de"+
		"\u0001\u0000\u0000\u0000\u01e3\u01e0\u0001\u0000\u0000\u0000\u01e3\u01e1"+
		"\u0001\u0000\u0000\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e4\u01ed"+
		"\u0001\u0000\u0000\u0000\u01e5\u01e6\n\u0002\u0000\u0000\u01e6\u01e8\u0005"+
		"\u0017\u0000\u0000\u01e7\u01e9\u0003p8\u0000\u01e8\u01e7\u0001\u0000\u0000"+
		"\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000"+
		"\u0000\u01ea\u01ec\u0005\u0018\u0000\u0000\u01eb\u01e5\u0001\u0000\u0000"+
		"\u0000\u01ec\u01ef\u0001\u0000\u0000\u0000\u01ed\u01eb\u0001\u0000\u0000"+
		"\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee7\u0001\u0000\u0000\u0000"+
		"\u01ef\u01ed\u0001\u0000\u0000\u0000\u01f0\u01f5\u0003\u00aeW\u0000\u01f1"+
		"\u01f2\u0005\u0019\u0000\u0000\u01f2\u01f4\u0003\u00aeW\u0000\u01f3\u01f1"+
		"\u0001\u0000\u0000\u0000\u01f4\u01f7\u0001\u0000\u0000\u0000\u01f5\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000\u01f69\u0001"+
		"\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000\u0000\u01f8\u01f9\u0005"+
		"\u001a\u0000\u0000\u01f9\u01fa\u0005\u000b\u0000\u0000\u01fa\u01fb\u0003"+
		"<\u001e\u0000\u01fb\u01fc\u0005\u001b\u0000\u0000\u01fc\u01fd\u00036\u001b"+
		"\u0000\u01fd\u01fe\u0005\f\u0000\u0000\u01fe;\u0001\u0000\u0000\u0000"+
		"\u01ff\u0202\u0003l6\u0000\u0200\u0202\u00038\u001c\u0000\u0201\u01ff"+
		"\u0001\u0000\u0000\u0000\u0201\u0200\u0001\u0000\u0000\u0000\u0202=\u0001"+
		"\u0000\u0000\u0000\u0203\u0204\u0005\u0013\u0000\u0000\u0204\u0205\u0003"+
		",\u0016\u0000\u0205\u0207\u0003\"\u0011\u0000\u0206\u0208\u0003 \u0010"+
		"\u0000\u0207\u0206\u0001\u0000\u0000\u0000\u0207\u0208\u0001\u0000\u0000"+
		"\u0000\u0208?\u0001\u0000\u0000\u0000\u0209\u020a\u0007\u0002\u0000\u0000"+
		"\u020aA\u0001\u0000\u0000\u0000\u020b\u020c\u0007\u0003\u0000\u0000\u020c"+
		"C\u0001\u0000\u0000\u0000\u020d\u020e\u0007\u0004\u0000\u0000\u020eE\u0001"+
		"\u0000\u0000\u0000\u020f\u0213\u0005\u0007\u0000\u0000\u0210\u0212\u0003"+
		"H$\u0000\u0211\u0210\u0001\u0000\u0000\u0000\u0212\u0215\u0001\u0000\u0000"+
		"\u0000\u0213\u0211\u0001\u0000\u0000\u0000\u0213\u0214\u0001\u0000\u0000"+
		"\u0000\u0214\u0216\u0001\u0000\u0000\u0000\u0215\u0213\u0001\u0000\u0000"+
		"\u0000\u0216\u0217\u0005\t\u0000\u0000\u0217G\u0001\u0000\u0000\u0000"+
		"\u0218\u0226\u0003L&\u0000\u0219\u0226\u0003N\'\u0000\u021a\u0226\u0003"+
		"R)\u0000\u021b\u0226\u0003T*\u0000\u021c\u0226\u0003F#\u0000\u021d\u0226"+
		"\u0003X,\u0000\u021e\u0226\u0003Z-\u0000\u021f\u0226\u0003\\.\u0000\u0220"+
		"\u0226\u0003^/\u0000\u0221\u0226\u0003`0\u0000\u0222\u0226\u0003b1\u0000"+
		"\u0223\u0226\u0003d2\u0000\u0224\u0226\u0003V+\u0000\u0225\u0218\u0001"+
		"\u0000\u0000\u0000\u0225\u0219\u0001\u0000\u0000\u0000\u0225\u021a\u0001"+
		"\u0000\u0000\u0000\u0225\u021b\u0001\u0000\u0000\u0000\u0225\u021c\u0001"+
		"\u0000\u0000\u0000\u0225\u021d\u0001\u0000\u0000\u0000\u0225\u021e\u0001"+
		"\u0000\u0000\u0000\u0225\u021f\u0001\u0000\u0000\u0000\u0225\u0220\u0001"+
		"\u0000\u0000\u0000\u0225\u0221\u0001\u0000\u0000\u0000\u0225\u0222\u0001"+
		"\u0000\u0000\u0000\u0225\u0223\u0001\u0000\u0000\u0000\u0225\u0224\u0001"+
		"\u0000\u0000\u0000\u0226I\u0001\u0000\u0000\u0000\u0227\u0228\u0003p8"+
		"\u0000\u0228\u0229\u0005\u0002\u0000\u0000\u0229K\u0001\u0000\u0000\u0000"+
		"\u022a\u022b\u0005\u001f\u0000\u0000\u022b\u022c\u0005\u000b\u0000\u0000"+
		"\u022c\u022d\u0003p8\u0000\u022d\u022e\u0005\f\u0000\u0000\u022e\u0231"+
		"\u0003H$\u0000\u022f\u0230\u0005 \u0000\u0000\u0230\u0232\u0003H$\u0000"+
		"\u0231\u022f\u0001\u0000\u0000\u0000\u0231\u0232\u0001\u0000\u0000\u0000"+
		"\u0232M\u0001\u0000\u0000\u0000\u0233\u0234\u0005!\u0000\u0000\u0234\u0236"+
		"\u0003p8\u0000\u0235\u0237\u0003 \u0010\u0000\u0236\u0235\u0001\u0000"+
		"\u0000\u0000\u0236\u0237\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000"+
		"\u0000\u0000\u0238\u023a\u0003F#\u0000\u0239\u023b\u0003P(\u0000\u023a"+
		"\u0239\u0001\u0000\u0000\u0000\u023b\u023c\u0001\u0000\u0000\u0000\u023c"+
		"\u023a\u0001\u0000\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000\u023d"+
		"O\u0001\u0000\u0000\u0000\u023e\u0243\u0005\"\u0000\u0000\u023f\u0241"+
		"\u0003\u00aeW\u0000\u0240\u023f\u0001\u0000\u0000\u0000\u0240\u0241\u0001"+
		"\u0000\u0000\u0000\u0241\u0242\u0001\u0000\u0000\u0000\u0242\u0244\u0003"+
		",\u0016\u0000\u0243\u0240\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000"+
		"\u0000\u0000\u0244\u0245\u0001\u0000\u0000\u0000\u0245\u0246\u0003F#\u0000"+
		"\u0246Q\u0001\u0000\u0000\u0000\u0247\u0248\u0005#\u0000\u0000\u0248\u0249"+
		"\u0005\u000b\u0000\u0000\u0249\u024a\u0003p8\u0000\u024a\u024b\u0005\f"+
		"\u0000\u0000\u024b\u024c\u0003H$\u0000\u024cS\u0001\u0000\u0000\u0000"+
		"\u024d\u024e\u0005\u0010\u0000\u0000\u024e\u0251\u0005\u000b\u0000\u0000"+
		"\u024f\u0252\u0003V+\u0000\u0250\u0252\u0005\u0002\u0000\u0000\u0251\u024f"+
		"\u0001\u0000\u0000\u0000\u0251\u0250\u0001\u0000\u0000\u0000\u0252\u0255"+
		"\u0001\u0000\u0000\u0000\u0253\u0256\u0003J%\u0000\u0254\u0256\u0005\u0002"+
		"\u0000\u0000\u0255\u0253\u0001\u0000\u0000\u0000\u0255\u0254\u0001\u0000"+
		"\u0000\u0000\u0256\u0258\u0001\u0000\u0000\u0000\u0257\u0259\u0003p8\u0000"+
		"\u0258\u0257\u0001\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000"+
		"\u0259\u025a\u0001\u0000\u0000\u0000\u025a\u025b\u0005\f\u0000\u0000\u025b"+
		"\u025c\u0003H$\u0000\u025cU\u0001\u0000\u0000\u0000\u025d\u0260\u0003"+
		"f3\u0000\u025e\u0260\u0003J%\u0000\u025f\u025d\u0001\u0000\u0000\u0000"+
		"\u025f\u025e\u0001\u0000\u0000\u0000\u0260W\u0001\u0000\u0000\u0000\u0261"+
		"\u0263\u0005$\u0000\u0000\u0262\u0264\u0005\u007f\u0000\u0000\u0263\u0262"+
		"\u0001\u0000\u0000\u0000\u0263\u0264\u0001\u0000\u0000\u0000\u0264\u0265"+
		"\u0001\u0000\u0000\u0000\u0265\u0266\u0003\u0086C\u0000\u0266Y\u0001\u0000"+
		"\u0000\u0000\u0267\u0268\u0005%\u0000\u0000\u0268\u0269\u0003H$\u0000"+
		"\u0269\u026a\u0005#\u0000\u0000\u026a\u026b\u0005\u000b\u0000\u0000\u026b"+
		"\u026c\u0003p8\u0000\u026c\u026d\u0005\f\u0000\u0000\u026d\u026e\u0005"+
		"\u0002\u0000\u0000\u026e[\u0001\u0000\u0000\u0000\u026f\u0270\u0005o\u0000"+
		"\u0000\u0270\u0271\u0005\u0002\u0000\u0000\u0271]\u0001\u0000\u0000\u0000"+
		"\u0272\u0273\u0005l\u0000\u0000\u0273\u0274\u0005\u0002\u0000\u0000\u0274"+
		"_\u0001\u0000\u0000\u0000\u0275\u0277\u0005&\u0000\u0000\u0276\u0278\u0003"+
		"p8\u0000\u0277\u0276\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000"+
		"\u0000\u0278\u0279\u0001\u0000\u0000\u0000\u0279\u027a\u0005\u0002\u0000"+
		"\u0000\u027aa\u0001\u0000\u0000\u0000\u027b\u027c\u0005\'\u0000\u0000"+
		"\u027c\u027d\u0005\u0002\u0000\u0000\u027dc\u0001\u0000\u0000\u0000\u027e"+
		"\u027f\u0005(\u0000\u0000\u027f\u0280\u0003~?\u0000\u0280\u0281\u0005"+
		"\u0002\u0000\u0000\u0281e\u0001\u0000\u0000\u0000\u0282\u0283\u0005[\u0000"+
		"\u0000\u0283\u028a\u0003j5\u0000\u0284\u028a\u00034\u001a\u0000\u0285"+
		"\u0286\u0005\u000b\u0000\u0000\u0286\u0287\u0003h4\u0000\u0287\u0288\u0005"+
		"\f\u0000\u0000\u0288\u028a\u0001\u0000\u0000\u0000\u0289\u0282\u0001\u0000"+
		"\u0000\u0000\u0289\u0284\u0001\u0000\u0000\u0000\u0289\u0285\u0001\u0000"+
		"\u0000\u0000\u028a\u028d\u0001\u0000\u0000\u0000\u028b\u028c\u0005\r\u0000"+
		"\u0000\u028c\u028e\u0003p8\u0000\u028d\u028b\u0001\u0000\u0000\u0000\u028d"+
		"\u028e\u0001\u0000\u0000\u0000\u028e\u028f\u0001\u0000\u0000\u0000\u028f"+
		"\u0290\u0005\u0002\u0000\u0000\u0290g\u0001\u0000\u0000\u0000\u0291\u0293"+
		"\u00034\u001a\u0000\u0292\u0291\u0001\u0000\u0000\u0000\u0292\u0293\u0001"+
		"\u0000\u0000\u0000\u0293\u029a\u0001\u0000\u0000\u0000\u0294\u0296\u0005"+
		"\b\u0000\u0000\u0295\u0297\u00034\u001a\u0000\u0296\u0295\u0001\u0000"+
		"\u0000\u0000\u0296\u0297\u0001\u0000\u0000\u0000\u0297\u0299\u0001\u0000"+
		"\u0000\u0000\u0298\u0294\u0001\u0000\u0000\u0000\u0299\u029c\u0001\u0000"+
		"\u0000\u0000\u029a\u0298\u0001\u0000\u0000\u0000\u029a\u029b\u0001\u0000"+
		"\u0000\u0000\u029bi\u0001\u0000\u0000\u0000\u029c\u029a\u0001\u0000\u0000"+
		"\u0000\u029d\u02a4\u0005\u000b\u0000\u0000\u029e\u02a0\u0003\u00aeW\u0000"+
		"\u029f\u029e\u0001\u0000\u0000\u0000\u029f\u02a0\u0001\u0000\u0000\u0000"+
		"\u02a0\u02a1\u0001\u0000\u0000\u0000\u02a1\u02a3\u0005\b\u0000\u0000\u02a2"+
		"\u029f\u0001\u0000\u0000\u0000\u02a3\u02a6\u0001\u0000\u0000\u0000\u02a4"+
		"\u02a2\u0001\u0000\u0000\u0000\u02a4\u02a5\u0001\u0000\u0000\u0000\u02a5"+
		"\u02a8\u0001\u0000\u0000\u0000\u02a6\u02a4\u0001\u0000\u0000\u0000\u02a7"+
		"\u02a9\u0003\u00aeW\u0000\u02a8\u02a7\u0001\u0000\u0000\u0000\u02a8\u02a9"+
		"\u0001\u0000\u0000\u0000\u02a9\u02aa\u0001\u0000\u0000\u0000\u02aa\u02ab"+
		"\u0005\f\u0000\u0000\u02abk\u0001\u0000\u0000\u0000\u02ac\u02b7\u0003"+
		"n7\u0000\u02ad\u02b7\u0005Y\u0000\u0000\u02ae\u02b7\u0005Z\u0000\u0000"+
		"\u02af\u02b7\u0005[\u0000\u0000\u02b0\u02b7\u0005\\\u0000\u0000\u02b1"+
		"\u02b7\u0005]\u0000\u0000\u02b2\u02b7\u0005^\u0000\u0000\u02b3\u02b7\u0005"+
		"_\u0000\u0000\u02b4\u02b7\u0005`\u0000\u0000\u02b5\u02b7\u0005a\u0000"+
		"\u0000\u02b6\u02ac\u0001\u0000\u0000\u0000\u02b6\u02ad\u0001\u0000\u0000"+
		"\u0000\u02b6\u02ae\u0001\u0000\u0000\u0000\u02b6\u02af\u0001\u0000\u0000"+
		"\u0000\u02b6\u02b0\u0001\u0000\u0000\u0000\u02b6\u02b1\u0001\u0000\u0000"+
		"\u0000\u02b6\u02b2\u0001\u0000\u0000\u0000\u02b6\u02b3\u0001\u0000\u0000"+
		"\u0000\u02b6\u02b4\u0001\u0000\u0000\u0000\u02b6\u02b5\u0001\u0000\u0000"+
		"\u0000\u02b7m\u0001\u0000\u0000\u0000\u02b8\u02ba\u0005)\u0000\u0000\u02b9"+
		"\u02bb\u0005t\u0000\u0000\u02ba\u02b9\u0001\u0000\u0000\u0000\u02ba\u02bb"+
		"\u0001\u0000\u0000\u0000\u02bbo\u0001\u0000\u0000\u0000\u02bc\u02bd\u0006"+
		"8\uffff\uffff\u0000\u02bd\u02be\u0005,\u0000\u0000\u02be\u02db\u00036"+
		"\u001b\u0000\u02bf\u02c0\u0005y\u0000\u0000\u02c0\u02c1\u0005\u000b\u0000"+
		"\u0000\u02c1\u02c2\u00036\u001b\u0000\u02c2\u02c3\u0005\f\u0000\u0000"+
		"\u02c3\u02db\u0001\u0000\u0000\u0000\u02c4\u02c5\u0005t\u0000\u0000\u02c5"+
		"\u02c6\u0005\u000b\u0000\u0000\u02c6\u02c7\u0003p8\u0000\u02c7\u02c8\u0005"+
		"\f\u0000\u0000\u02c8\u02db\u0001\u0000\u0000\u0000\u02c9\u02ca\u0005\u000b"+
		"\u0000\u0000\u02ca\u02cb\u0003p8\u0000\u02cb\u02cc\u0005\f\u0000\u0000"+
		"\u02cc\u02db\u0001\u0000\u0000\u0000\u02cd\u02ce\u0007\u0005\u0000\u0000"+
		"\u02ce\u02db\u0003p8\u0014\u02cf\u02d0\u0007\u0006\u0000\u0000\u02d0\u02db"+
		"\u0003p8\u0013\u02d1\u02d2\u00050\u0000\u0000\u02d2\u02db\u0003p8\u0012"+
		"\u02d3\u02d4\u00051\u0000\u0000\u02d4\u02db\u0003p8\u0011\u02d5\u02d6"+
		"\u00052\u0000\u0000\u02d6\u02db\u0003p8\u0010\u02d7\u02d8\u00053\u0000"+
		"\u0000\u02d8\u02db\u0003p8\u000f\u02d9\u02db\u0003r9\u0000\u02da\u02bc"+
		"\u0001\u0000\u0000\u0000\u02da\u02bf\u0001\u0000\u0000\u0000\u02da\u02c4"+
		"\u0001\u0000\u0000\u0000\u02da\u02c9\u0001\u0000\u0000\u0000\u02da\u02cd"+
		"\u0001\u0000\u0000\u0000\u02da\u02cf\u0001\u0000\u0000\u0000\u02da\u02d1"+
		"\u0001\u0000\u0000\u0000\u02da\u02d3\u0001\u0000\u0000\u0000\u02da\u02d5"+
		"\u0001\u0000\u0000\u0000\u02da\u02d7\u0001\u0000\u0000\u0000\u02da\u02d9"+
		"\u0001\u0000\u0000\u0000\u02db\u0329\u0001\u0000\u0000\u0000\u02dc\u02dd"+
		"\n\u000e\u0000\u0000\u02dd\u02de\u00054\u0000\u0000\u02de\u0328\u0003"+
		"p8\u000f\u02df\u02e0\n\r\u0000\u0000\u02e0\u02e1\u0007\u0007\u0000\u0000"+
		"\u02e1\u0328\u0003p8\u000e\u02e2\u02e3\n\f\u0000\u0000\u02e3\u02e4\u0007"+
		"\u0006\u0000\u0000\u02e4\u0328\u0003p8\r\u02e5\u02e6\n\u000b\u0000\u0000"+
		"\u02e6\u02e7\u0007\b\u0000\u0000\u02e7\u0328\u0003p8\f\u02e8\u02e9\n\n"+
		"\u0000\u0000\u02e9\u02ea\u00059\u0000\u0000\u02ea\u0328\u0003p8\u000b"+
		"\u02eb\u02ec\n\t\u0000\u0000\u02ec\u02ed\u0005:\u0000\u0000\u02ed\u0328"+
		"\u0003p8\n\u02ee\u02ef\n\b\u0000\u0000\u02ef\u02f0\u0005;\u0000\u0000"+
		"\u02f0\u0328\u0003p8\t\u02f1\u02f2\n\u0007\u0000\u0000\u02f2\u02f3\u0007"+
		"\t\u0000\u0000\u02f3\u0328\u0003p8\b\u02f4\u02f5\n\u0006\u0000\u0000\u02f5"+
		"\u02f6\u0007\n\u0000\u0000\u02f6\u0328\u0003p8\u0007\u02f7\u02f8\n\u0005"+
		"\u0000\u0000\u02f8\u02f9\u0005B\u0000\u0000\u02f9\u0328\u0003p8\u0006"+
		"\u02fa\u02fb\n\u0004\u0000\u0000\u02fb\u02fc\u0005C\u0000\u0000\u02fc"+
		"\u0328\u0003p8\u0005\u02fd\u02fe\n\u0002\u0000\u0000\u02fe\u02ff\u0007"+
		"\u000b\u0000\u0000\u02ff\u0328\u0003p8\u0003\u0300\u0301\n\u001d\u0000"+
		"\u0000\u0301\u0328\u0007\u0005\u0000\u0000\u0302\u0303\n\u001b\u0000\u0000"+
		"\u0303\u0305\u0005\u0017\u0000\u0000\u0304\u0306\u0003p8\u0000\u0305\u0304"+
		"\u0001\u0000\u0000\u0000\u0305\u0306\u0001\u0000\u0000\u0000\u0306\u0307"+
		"\u0001\u0000\u0000\u0000\u0307\u0328\u0005\u0018\u0000\u0000\u0308\u0309"+
		"\n\u001a\u0000\u0000\u0309\u030b\u0005\u0017\u0000\u0000\u030a\u030c\u0003"+
		"p8\u0000\u030b\u030a\u0001\u0000\u0000\u0000\u030b\u030c\u0001\u0000\u0000"+
		"\u0000\u030c\u030d\u0001\u0000\u0000\u0000\u030d\u030f\u0005-\u0000\u0000"+
		"\u030e\u0310\u0003p8\u0000\u030f\u030e\u0001\u0000\u0000\u0000\u030f\u0310"+
		"\u0001\u0000\u0000\u0000\u0310\u0311\u0001\u0000\u0000\u0000\u0311\u0328"+
		"\u0005\u0018\u0000\u0000\u0312\u0313\n\u0019\u0000\u0000\u0313\u0314\u0005"+
		"\u0019\u0000\u0000\u0314\u0328\u0003\u00aeW\u0000\u0315\u031b\n\u0018"+
		"\u0000\u0000\u0316\u0318\u0005\u0007\u0000\u0000\u0317\u0319\u0003x<\u0000"+
		"\u0318\u0317\u0001\u0000\u0000\u0000\u0318\u0319\u0001\u0000\u0000\u0000"+
		"\u0319\u031a\u0001\u0000\u0000\u0000\u031a\u031c\u0005\t\u0000\u0000\u031b"+
		"\u0316\u0001\u0000\u0000\u0000\u031b\u031c\u0001\u0000\u0000\u0000\u031c"+
		"\u031d\u0001\u0000\u0000\u0000\u031d\u031e\u0005\u000b\u0000\u0000\u031e"+
		"\u031f\u0003|>\u0000\u031f\u0320\u0005\f\u0000\u0000\u0320\u0328\u0001"+
		"\u0000\u0000\u0000\u0321\u0322\n\u0003\u0000\u0000\u0322\u0323\u0005D"+
		"\u0000\u0000\u0323\u0324\u0003p8\u0000\u0324\u0325\u0005-\u0000\u0000"+
		"\u0325\u0326\u0003p8\u0000\u0326\u0328\u0001\u0000\u0000\u0000\u0327\u02dc"+
		"\u0001\u0000\u0000\u0000\u0327\u02df\u0001\u0000\u0000\u0000\u0327\u02e2"+
		"\u0001\u0000\u0000\u0000\u0327\u02e5\u0001\u0000\u0000\u0000\u0327\u02e8"+
		"\u0001\u0000\u0000\u0000\u0327\u02eb\u0001\u0000\u0000\u0000\u0327\u02ee"+
		"\u0001\u0000\u0000\u0000\u0327\u02f1\u0001\u0000\u0000\u0000\u0327\u02f4"+
		"\u0001\u0000\u0000\u0000\u0327\u02f7\u0001\u0000\u0000\u0000\u0327\u02fa"+
		"\u0001\u0000\u0000\u0000\u0327\u02fd\u0001\u0000\u0000\u0000\u0327\u0300"+
		"\u0001\u0000\u0000\u0000\u0327\u0302\u0001\u0000\u0000\u0000\u0327\u0308"+
		"\u0001\u0000\u0000\u0000\u0327\u0312\u0001\u0000\u0000\u0000\u0327\u0315"+
		"\u0001\u0000\u0000\u0000\u0327\u0321\u0001\u0000\u0000\u0000\u0328\u032b"+
		"\u0001\u0000\u0000\u0000\u0329\u0327\u0001\u0000\u0000\u0000\u0329\u032a"+
		"\u0001\u0000\u0000\u0000\u032aq\u0001\u0000\u0000\u0000\u032b\u0329\u0001"+
		"\u0000\u0000\u0000\u032c\u033b\u0005b\u0000\u0000\u032d\u033b\u0003\u00ac"+
		"V\u0000\u032e\u033b\u0003\u00b0X\u0000\u032f\u033b\u0003\u00b2Y\u0000"+
		"\u0330\u033b\u0003\u00b4Z\u0000\u0331\u0333\u0003\u00aeW\u0000\u0332\u0334"+
		"\u0003t:\u0000\u0333\u0332\u0001\u0000\u0000\u0000\u0333\u0334\u0001\u0000"+
		"\u0000\u0000\u0334\u033b\u0001\u0000\u0000\u0000\u0335\u033b\u0003\u0080"+
		"@\u0000\u0336\u0338\u0003\u0082A\u0000\u0337\u0339\u0003t:\u0000\u0338"+
		"\u0337\u0001\u0000\u0000\u0000\u0338\u0339\u0001\u0000\u0000\u0000\u0339"+
		"\u033b\u0001\u0000\u0000\u0000\u033a\u032c\u0001\u0000\u0000\u0000\u033a"+
		"\u032d\u0001\u0000\u0000\u0000\u033a\u032e\u0001\u0000\u0000\u0000\u033a"+
		"\u032f\u0001\u0000\u0000\u0000\u033a\u0330\u0001\u0000\u0000\u0000\u033a"+
		"\u0331\u0001\u0000\u0000\u0000\u033a\u0335\u0001\u0000\u0000\u0000\u033a"+
		"\u0336\u0001\u0000\u0000\u0000\u033bs\u0001\u0000\u0000\u0000\u033c\u033d"+
		"\u0005\u0017\u0000\u0000\u033d\u033e\u0005\u0018\u0000\u0000\u033eu\u0001"+
		"\u0000\u0000\u0000\u033f\u0344\u0003p8\u0000\u0340\u0341\u0005\b\u0000"+
		"\u0000\u0341\u0343\u0003p8\u0000\u0342\u0340\u0001\u0000\u0000\u0000\u0343"+
		"\u0346\u0001\u0000\u0000\u0000\u0344\u0342\u0001\u0000\u0000\u0000\u0344"+
		"\u0345\u0001\u0000\u0000\u0000\u0345w\u0001\u0000\u0000\u0000\u0346\u0344"+
		"\u0001\u0000\u0000\u0000\u0347\u034c\u0003z=\u0000\u0348\u0349\u0005\b"+
		"\u0000\u0000\u0349\u034b\u0003z=\u0000\u034a\u0348\u0001\u0000\u0000\u0000"+
		"\u034b\u034e\u0001\u0000\u0000\u0000\u034c\u034a\u0001\u0000\u0000\u0000"+
		"\u034c\u034d\u0001\u0000\u0000\u0000\u034d\u0350\u0001\u0000\u0000\u0000"+
		"\u034e\u034c\u0001\u0000\u0000\u0000\u034f\u0351\u0005\b\u0000\u0000\u0350"+
		"\u034f\u0001\u0000\u0000\u0000\u0350\u0351\u0001\u0000\u0000\u0000\u0351"+
		"y\u0001\u0000\u0000\u0000\u0352\u0353\u0003\u00aeW\u0000\u0353\u0354\u0005"+
		"-\u0000\u0000\u0354\u0355\u0003p8\u0000\u0355{\u0001\u0000\u0000\u0000"+
		"\u0356\u0358\u0005\u0007\u0000\u0000\u0357\u0359\u0003x<\u0000\u0358\u0357"+
		"\u0001\u0000\u0000\u0000\u0358\u0359\u0001\u0000\u0000\u0000\u0359\u035a"+
		"\u0001\u0000\u0000\u0000\u035a\u035f\u0005\t\u0000\u0000\u035b\u035d\u0003"+
		"v;\u0000\u035c\u035b\u0001\u0000\u0000\u0000\u035c\u035d\u0001\u0000\u0000"+
		"\u0000\u035d\u035f\u0001\u0000\u0000\u0000\u035e\u0356\u0001\u0000\u0000"+
		"\u0000\u035e\u035c\u0001\u0000\u0000\u0000\u035f}\u0001\u0000\u0000\u0000"+
		"\u0360\u0361\u0003p8\u0000\u0361\u0362\u0005\u000b\u0000\u0000\u0362\u0363"+
		"\u0003|>\u0000\u0363\u0364\u0005\f\u0000\u0000\u0364\u007f\u0001\u0000"+
		"\u0000\u0000\u0365\u0367\u0005\u000b\u0000\u0000\u0366\u0368\u0003p8\u0000"+
		"\u0367\u0366\u0001\u0000\u0000\u0000\u0367\u0368\u0001\u0000\u0000\u0000"+
		"\u0368\u036f\u0001\u0000\u0000\u0000\u0369\u036b\u0005\b\u0000\u0000\u036a"+
		"\u036c\u0003p8\u0000\u036b\u036a\u0001\u0000\u0000\u0000\u036b\u036c\u0001"+
		"\u0000\u0000\u0000\u036c\u036e\u0001\u0000\u0000\u0000\u036d\u0369\u0001"+
		"\u0000\u0000\u0000\u036e\u0371\u0001\u0000\u0000\u0000\u036f\u036d\u0001"+
		"\u0000\u0000\u0000\u036f\u0370\u0001\u0000\u0000\u0000\u0370\u0372\u0001"+
		"\u0000\u0000\u0000\u0371\u036f\u0001\u0000\u0000\u0000\u0372\u0380\u0005"+
		"\f\u0000\u0000\u0373\u037c\u0005\u0017\u0000\u0000\u0374\u0379\u0003p"+
		"8\u0000\u0375\u0376\u0005\b\u0000\u0000\u0376\u0378\u0003p8\u0000\u0377"+
		"\u0375\u0001\u0000\u0000\u0000\u0378\u037b\u0001\u0000\u0000\u0000\u0379"+
		"\u0377\u0001\u0000\u0000\u0000\u0379\u037a\u0001\u0000\u0000\u0000\u037a"+
		"\u037d\u0001\u0000\u0000\u0000\u037b\u0379\u0001\u0000\u0000\u0000\u037c"+
		"\u0374\u0001\u0000\u0000\u0000\u037c\u037d\u0001\u0000\u0000\u0000\u037d"+
		"\u037e\u0001\u0000\u0000\u0000\u037e\u0380\u0005\u0018\u0000\u0000\u037f"+
		"\u0365\u0001\u0000\u0000\u0000\u037f\u0373\u0001\u0000\u0000\u0000\u0380"+
		"\u0081\u0001\u0000\u0000\u0000\u0381\u0384\u0003l6\u0000\u0382\u0384\u0003"+
		"8\u001c\u0000\u0383\u0381\u0001\u0000\u0000\u0000\u0383\u0382\u0001\u0000"+
		"\u0000\u0000\u0384\u0083\u0001\u0000\u0000\u0000\u0385\u0398\u0003\u00ae"+
		"W\u0000\u0386\u0398\u0003\u0086C\u0000\u0387\u0398\u0003\u0088D\u0000"+
		"\u0388\u0398\u0003\u008cF\u0000\u0389\u0398\u0003\u008eG\u0000\u038a\u0398"+
		"\u0003\u0094J\u0000\u038b\u0398\u0003\u0096K\u0000\u038c\u0398\u0003\u0098"+
		"L\u0000\u038d\u0398\u0003\u009cN\u0000\u038e\u0398\u0003\u00a0P\u0000"+
		"\u038f\u0398\u0003\u00a2Q\u0000\u0390\u0398\u0005l\u0000\u0000\u0391\u0398"+
		"\u0005o\u0000\u0000\u0392\u0398\u0005p\u0000\u0000\u0393\u0398\u0003\u00aa"+
		"U\u0000\u0394\u0398\u0003\u00acV\u0000\u0395\u0398\u0003\u00b2Y\u0000"+
		"\u0396\u0398\u0003\u00b0X\u0000\u0397\u0385\u0001\u0000\u0000\u0000\u0397"+
		"\u0386\u0001\u0000\u0000\u0000\u0397\u0387\u0001\u0000\u0000\u0000\u0397"+
		"\u0388\u0001\u0000\u0000\u0000\u0397\u0389\u0001\u0000\u0000\u0000\u0397"+
		"\u038a\u0001\u0000\u0000\u0000\u0397\u038b\u0001\u0000\u0000\u0000\u0397"+
		"\u038c\u0001\u0000\u0000\u0000\u0397\u038d\u0001\u0000\u0000\u0000\u0397"+
		"\u038e\u0001\u0000\u0000\u0000\u0397\u038f\u0001\u0000\u0000\u0000\u0397"+
		"\u0390\u0001\u0000\u0000\u0000\u0397\u0391\u0001\u0000\u0000\u0000\u0397"+
		"\u0392\u0001\u0000\u0000\u0000\u0397\u0393\u0001\u0000\u0000\u0000\u0397"+
		"\u0394\u0001\u0000\u0000\u0000\u0397\u0395\u0001\u0000\u0000\u0000\u0397"+
		"\u0396\u0001\u0000\u0000\u0000\u0398\u0085\u0001\u0000\u0000\u0000\u0399"+
		"\u039d\u0005\u0007\u0000\u0000\u039a\u039c\u0003\u0084B\u0000\u039b\u039a"+
		"\u0001\u0000\u0000\u0000\u039c\u039f\u0001\u0000\u0000\u0000\u039d\u039b"+
		"\u0001\u0000\u0000\u0000\u039d\u039e\u0001\u0000\u0000\u0000\u039e\u03a0"+
		"\u0001\u0000\u0000\u0000\u039f\u039d\u0001\u0000\u0000\u0000\u03a0\u03a1"+
		"\u0005\t\u0000\u0000\u03a1\u0087\u0001\u0000\u0000\u0000\u03a2\u03a6\u0003"+
		"\u008aE\u0000\u03a3\u03a6\u0003\u00a4R\u0000\u03a4\u03a6\u0003\u0092I"+
		"\u0000\u03a5\u03a2\u0001\u0000\u0000\u0000\u03a5\u03a3\u0001\u0000\u0000"+
		"\u0000\u03a5\u03a4\u0001\u0000\u0000\u0000\u03a6\u0089\u0001\u0000\u0000"+
		"\u0000\u03a7\u03ac\u0005&\u0000\u0000\u03a8\u03ac\u0005)\u0000\u0000\u03a9"+
		"\u03ac\u0005^\u0000\u0000\u03aa\u03ac\u0003\u00aeW\u0000\u03ab\u03a7\u0001"+
		"\u0000\u0000\u0000\u03ab\u03a8\u0001\u0000\u0000\u0000\u03ab\u03a9\u0001"+
		"\u0000\u0000\u0000\u03ab\u03aa\u0001\u0000\u0000\u0000\u03ac\u03b9\u0001"+
		"\u0000\u0000\u0000\u03ad\u03af\u0005\u000b\u0000\u0000\u03ae\u03b0\u0003"+
		"\u0088D\u0000\u03af\u03ae\u0001\u0000\u0000\u0000\u03af\u03b0\u0001\u0000"+
		"\u0000\u0000\u03b0\u03b5\u0001\u0000\u0000\u0000\u03b1\u03b2\u0005\b\u0000"+
		"\u0000\u03b2\u03b4\u0003\u0088D\u0000\u03b3\u03b1\u0001\u0000\u0000\u0000"+
		"\u03b4\u03b7\u0001\u0000\u0000\u0000\u03b5\u03b3\u0001\u0000\u0000\u0000"+
		"\u03b5\u03b6\u0001\u0000\u0000\u0000\u03b6\u03b8\u0001\u0000\u0000\u0000"+
		"\u03b7\u03b5\u0001\u0000\u0000\u0000\u03b8\u03ba\u0005\f\u0000\u0000\u03b9"+
		"\u03ad\u0001\u0000\u0000\u0000\u03b9\u03ba\u0001\u0000\u0000\u0000\u03ba"+
		"\u008b\u0001\u0000\u0000\u0000\u03bb\u03bc\u0005O\u0000\u0000\u03bc\u03bf"+
		"\u0003\u0090H\u0000\u03bd\u03be\u0005P\u0000\u0000\u03be\u03c0\u0003\u0088"+
		"D\u0000\u03bf\u03bd\u0001\u0000\u0000\u0000\u03bf\u03c0\u0001\u0000\u0000"+
		"\u0000\u03c0\u008d\u0001\u0000\u0000\u0000\u03c1\u03c2\u0003\u0090H\u0000"+
		"\u03c2\u03c3\u0005P\u0000\u0000\u03c3\u03c4\u0003\u0088D\u0000\u03c4\u008f"+
		"\u0001\u0000\u0000\u0000\u03c5\u03ca\u0003\u0092I\u0000\u03c6\u03c7\u0005"+
		"\b\u0000\u0000\u03c7\u03c9\u0003\u0092I\u0000\u03c8\u03c6\u0001\u0000"+
		"\u0000\u0000\u03c9\u03cc\u0001\u0000\u0000\u0000\u03ca\u03c8\u0001\u0000"+
		"\u0000\u0000\u03ca\u03cb\u0001\u0000\u0000\u0000\u03cb\u0091\u0001\u0000"+
		"\u0000\u0000\u03cc\u03ca\u0001\u0000\u0000\u0000\u03cd\u03d2\u0003\u00ae"+
		"W\u0000\u03ce\u03cf\u0005\u0019\u0000\u0000\u03cf\u03d1\u0003\u00aeW\u0000"+
		"\u03d0\u03ce\u0001\u0000\u0000\u0000\u03d1\u03d4\u0001\u0000\u0000\u0000"+
		"\u03d2\u03d0\u0001\u0000\u0000\u0000\u03d2\u03d3\u0001\u0000\u0000\u0000"+
		"\u03d3\u0093\u0001\u0000\u0000\u0000\u03d4\u03d2\u0001\u0000\u0000\u0000"+
		"\u03d5\u03d6\u0005Q\u0000\u0000\u03d6\u03d7\u0003\u00aeW\u0000\u03d7\u0095"+
		"\u0001\u0000\u0000\u0000\u03d8\u03d9\u0003\u00aeW\u0000\u03d9\u03da\u0005"+
		"-\u0000\u0000\u03da\u0097\u0001\u0000\u0000\u0000\u03db\u03dc\u0005R\u0000"+
		"\u0000\u03dc\u03e0\u0003\u0088D\u0000\u03dd\u03df\u0003\u009aM\u0000\u03de"+
		"\u03dd\u0001\u0000\u0000\u0000\u03df\u03e2\u0001\u0000\u0000\u0000\u03e0"+
		"\u03de\u0001\u0000\u0000\u0000\u03e0\u03e1\u0001\u0000\u0000\u0000\u03e1"+
		"\u0099\u0001\u0000\u0000\u0000\u03e2\u03e0\u0001\u0000\u0000\u0000\u03e3"+
		"\u03e4\u0005S\u0000\u0000\u03e4\u03e6\u0003\u00a4R\u0000\u03e5\u03e7\u0003"+
		"\u00a8T\u0000\u03e6\u03e5\u0001\u0000\u0000\u0000\u03e6\u03e7\u0001\u0000"+
		"\u0000\u0000\u03e7\u03e8\u0001\u0000\u0000\u0000\u03e8\u03e9\u0003\u0086"+
		"C\u0000\u03e9\u03ed\u0001\u0000\u0000\u0000\u03ea\u03eb\u0005T\u0000\u0000"+
		"\u03eb\u03ed\u0003\u0086C\u0000\u03ec\u03e3\u0001\u0000\u0000\u0000\u03ec"+
		"\u03ea\u0001\u0000\u0000\u0000\u03ed\u009b\u0001\u0000\u0000\u0000\u03ee"+
		"\u03ef\u0005\u0013\u0000\u0000\u03ef\u03f0\u0003\u00aeW\u0000\u03f0\u03f2"+
		"\u0005\u000b\u0000\u0000\u03f1\u03f3\u0003\u00a6S\u0000\u03f2\u03f1\u0001"+
		"\u0000\u0000\u0000\u03f2\u03f3\u0001\u0000\u0000\u0000\u03f3\u03f4\u0001"+
		"\u0000\u0000\u0000\u03f4\u03f6\u0005\f\u0000\u0000\u03f5\u03f7\u0003\u009e"+
		"O\u0000\u03f6\u03f5\u0001\u0000\u0000\u0000\u03f6\u03f7\u0001\u0000\u0000"+
		"\u0000\u03f7\u03f8\u0001\u0000\u0000\u0000\u03f8\u03f9\u0003\u0086C\u0000"+
		"\u03f9\u009d\u0001\u0000\u0000\u0000\u03fa\u03fb\u0005/\u0000\u0000\u03fb"+
		"\u03fc\u0005=\u0000\u0000\u03fc\u03fd\u0003\u00a6S\u0000\u03fd\u009f\u0001"+
		"\u0000\u0000\u0000\u03fe\u03ff\u0005\u0010\u0000\u0000\u03ff\u0400\u0003"+
		"\u0086C\u0000\u0400\u0401\u0003\u0088D\u0000\u0401\u0402\u0003\u0086C"+
		"\u0000\u0402\u0403\u0003\u0086C\u0000\u0403\u00a1\u0001\u0000\u0000\u0000"+
		"\u0404\u0405\u0005\u001f\u0000\u0000\u0405\u0406\u0003\u0088D\u0000\u0406"+
		"\u0407\u0003\u0086C\u0000\u0407\u00a3\u0001\u0000\u0000\u0000\u0408\u040e"+
		"\u0003\u00b2Y\u0000\u0409\u040e\u0005c\u0000\u0000\u040a\u040e\u0005d"+
		"\u0000\u0000\u040b\u040e\u0003\u00b0X\u0000\u040c\u040e\u0005b\u0000\u0000"+
		"\u040d\u0408\u0001\u0000\u0000\u0000\u040d\u0409\u0001\u0000\u0000\u0000"+
		"\u040d\u040a\u0001\u0000\u0000\u0000\u040d\u040b\u0001\u0000\u0000\u0000"+
		"\u040d\u040c\u0001\u0000\u0000\u0000\u040e\u0410\u0001\u0000\u0000\u0000"+
		"\u040f\u0411\u0003\u00a8T\u0000\u0410\u040f\u0001\u0000\u0000\u0000\u0410"+
		"\u0411\u0001\u0000\u0000\u0000\u0411\u00a5\u0001\u0000\u0000\u0000\u0412"+
		"\u0414\u0003\u00aeW\u0000\u0413\u0415\u0003\u00a8T\u0000\u0414\u0413\u0001"+
		"\u0000\u0000\u0000\u0414\u0415\u0001\u0000\u0000\u0000\u0415\u0418\u0001"+
		"\u0000\u0000\u0000\u0416\u0417\u0005\b\u0000\u0000\u0417\u0419\u0003\u00a6"+
		"S\u0000\u0418\u0416\u0001\u0000\u0000\u0000\u0418\u0419\u0001\u0000\u0000"+
		"\u0000\u0419\u00a7\u0001\u0000\u0000\u0000\u041a\u041b\u0005-\u0000\u0000"+
		"\u041b\u041c\u0003\u00aeW\u0000\u041c\u00a9\u0001\u0000\u0000\u0000\u041d"+
		"\u041e\u0005$\u0000\u0000\u041e\u041f\u0003\u00aeW\u0000\u041f\u0420\u0003"+
		"\u0086C\u0000\u0420\u00ab\u0001\u0000\u0000\u0000\u0421\u0423\u0007\f"+
		"\u0000\u0000\u0422\u0424\u0007\r\u0000\u0000\u0423\u0422\u0001\u0000\u0000"+
		"\u0000\u0423\u0424\u0001\u0000\u0000\u0000\u0424\u00ad\u0001\u0000\u0000"+
		"\u0000\u0425\u0426\u0007\u000e\u0000\u0000\u0426\u00af\u0001\u0000\u0000"+
		"\u0000\u0427\u0429\u0005i\u0000\u0000\u0428\u0427\u0001\u0000\u0000\u0000"+
		"\u0429\u042a\u0001\u0000\u0000\u0000\u042a\u0428\u0001\u0000\u0000\u0000"+
		"\u042a\u042b\u0001\u0000\u0000\u0000\u042b\u00b1\u0001\u0000\u0000\u0000"+
		"\u042c\u042e\u0005\u007f\u0000\u0000\u042d\u042c\u0001\u0000\u0000\u0000"+
		"\u042e\u042f\u0001\u0000\u0000\u0000\u042f\u042d\u0001\u0000\u0000\u0000"+
		"\u042f\u0430\u0001\u0000\u0000\u0000\u0430\u00b3\u0001\u0000\u0000\u0000"+
		"\u0431\u0433\u0005\u0080\u0000\u0000\u0432\u0431\u0001\u0000\u0000\u0000"+
		"\u0433\u0434\u0001\u0000\u0000\u0000\u0434\u0432\u0001\u0000\u0000\u0000"+
		"\u0434\u0435\u0001\u0000\u0000\u0000\u0435\u00b5\u0001\u0000\u0000\u0000"+
		"|\u00bb\u00bd\u00cc\u00d3\u00d9\u00dd\u00e9\u00f1\u00f6\u00f9\u0103\u0106"+
		"\u010c\u0114\u0117\u0120\u0129\u012b\u0131\u013c\u0141\u0148\u0156\u0159"+
		"\u0160\u0164\u0166\u016b\u0171\u0175\u017c\u0181\u018a\u018c\u0192\u0195"+
		"\u019b\u01a3\u01a9\u01b6\u01b9\u01bf\u01c2\u01ca\u01cd\u01d3\u01d6\u01da"+
		"\u01e3\u01e8\u01ed\u01f5\u0201\u0207\u0213\u0225\u0231\u0236\u023c\u0240"+
		"\u0243\u0251\u0255\u0258\u025f\u0263\u0277\u0289\u028d\u0292\u0296\u029a"+
		"\u029f\u02a4\u02a8\u02b6\u02ba\u02da\u0305\u030b\u030f\u0318\u031b\u0327"+
		"\u0329\u0333\u0338\u033a\u0344\u034c\u0350\u0358\u035c\u035e\u0367\u036b"+
		"\u036f\u0379\u037c\u037f\u0383\u0397\u039d\u03a5\u03ab\u03af\u03b5\u03b9"+
		"\u03bf\u03ca\u03d2\u03e0\u03e6\u03ec\u03f2\u03f6\u040d\u0410\u0414\u0418"+
		"\u0423\u042a\u042f\u0434";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}