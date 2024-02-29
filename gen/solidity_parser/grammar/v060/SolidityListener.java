// Generated from java-escape by ANTLR 4.11.1
package solidity_parser.grammar.v060;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SolidityParser}.
 */
public interface SolidityListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SolidityParser#sourceUnit}.
	 * @param ctx the parse tree
	 */
	void enterSourceUnit(SolidityParser.SourceUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#sourceUnit}.
	 * @param ctx the parse tree
	 */
	void exitSourceUnit(SolidityParser.SourceUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#pragmaDirective}.
	 * @param ctx the parse tree
	 */
	void enterPragmaDirective(SolidityParser.PragmaDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#pragmaDirective}.
	 * @param ctx the parse tree
	 */
	void exitPragmaDirective(SolidityParser.PragmaDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#pragmaName}.
	 * @param ctx the parse tree
	 */
	void enterPragmaName(SolidityParser.PragmaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#pragmaName}.
	 * @param ctx the parse tree
	 */
	void exitPragmaName(SolidityParser.PragmaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#pragmaValue}.
	 * @param ctx the parse tree
	 */
	void enterPragmaValue(SolidityParser.PragmaValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#pragmaValue}.
	 * @param ctx the parse tree
	 */
	void exitPragmaValue(SolidityParser.PragmaValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#version}.
	 * @param ctx the parse tree
	 */
	void enterVersion(SolidityParser.VersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#version}.
	 * @param ctx the parse tree
	 */
	void exitVersion(SolidityParser.VersionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#versionConstraint}.
	 * @param ctx the parse tree
	 */
	void enterVersionConstraint(SolidityParser.VersionConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#versionConstraint}.
	 * @param ctx the parse tree
	 */
	void exitVersionConstraint(SolidityParser.VersionConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#versionOperator}.
	 * @param ctx the parse tree
	 */
	void enterVersionOperator(SolidityParser.VersionOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#versionOperator}.
	 * @param ctx the parse tree
	 */
	void exitVersionOperator(SolidityParser.VersionOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ModuleImport}
	 * labeled alternative in {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 */
	void enterModuleImport(SolidityParser.ModuleImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ModuleImport}
	 * labeled alternative in {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 */
	void exitModuleImport(SolidityParser.ModuleImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AliasImport}
	 * labeled alternative in {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 */
	void enterAliasImport(SolidityParser.AliasImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AliasImport}
	 * labeled alternative in {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 */
	void exitAliasImport(SolidityParser.AliasImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymbolImport}
	 * labeled alternative in {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 */
	void enterSymbolImport(SolidityParser.SymbolImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymbolImport}
	 * labeled alternative in {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 */
	void exitSymbolImport(SolidityParser.SymbolImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(SolidityParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(SolidityParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#contractDefinition}.
	 * @param ctx the parse tree
	 */
	void enterContractDefinition(SolidityParser.ContractDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#contractDefinition}.
	 * @param ctx the parse tree
	 */
	void exitContractDefinition(SolidityParser.ContractDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#inheritanceSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#inheritanceSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#contractPart}.
	 * @param ctx the parse tree
	 */
	void enterContractPart(SolidityParser.ContractPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#contractPart}.
	 * @param ctx the parse tree
	 */
	void exitContractPart(SolidityParser.ContractPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#stateVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#stateVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#overrideSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#overrideSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#usingForDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterUsingForDeclaration(SolidityParser.UsingForDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#usingForDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitUsingForDeclaration(SolidityParser.UsingForDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#structDefinition}.
	 * @param ctx the parse tree
	 */
	void enterStructDefinition(SolidityParser.StructDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#structDefinition}.
	 * @param ctx the parse tree
	 */
	void exitStructDefinition(SolidityParser.StructDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#modifierDefinition}.
	 * @param ctx the parse tree
	 */
	void enterModifierDefinition(SolidityParser.ModifierDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#modifierDefinition}.
	 * @param ctx the parse tree
	 */
	void exitModifierDefinition(SolidityParser.ModifierDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#functionDescriptor}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDescriptor(SolidityParser.FunctionDescriptorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#functionDescriptor}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDescriptor(SolidityParser.FunctionDescriptorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#returnParameters}.
	 * @param ctx the parse tree
	 */
	void enterReturnParameters(SolidityParser.ReturnParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#returnParameters}.
	 * @param ctx the parse tree
	 */
	void exitReturnParameters(SolidityParser.ReturnParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#modifierList}.
	 * @param ctx the parse tree
	 */
	void enterModifierList(SolidityParser.ModifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#modifierList}.
	 * @param ctx the parse tree
	 */
	void exitModifierList(SolidityParser.ModifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#modifierInvocation}.
	 * @param ctx the parse tree
	 */
	void enterModifierInvocation(SolidityParser.ModifierInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#modifierInvocation}.
	 * @param ctx the parse tree
	 */
	void exitModifierInvocation(SolidityParser.ModifierInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#eventDefinition}.
	 * @param ctx the parse tree
	 */
	void enterEventDefinition(SolidityParser.EventDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#eventDefinition}.
	 * @param ctx the parse tree
	 */
	void exitEventDefinition(SolidityParser.EventDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#enumDefinition}.
	 * @param ctx the parse tree
	 */
	void enterEnumDefinition(SolidityParser.EnumDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#enumDefinition}.
	 * @param ctx the parse tree
	 */
	void exitEnumDefinition(SolidityParser.EnumDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#enumValue}.
	 * @param ctx the parse tree
	 */
	void enterEnumValue(SolidityParser.EnumValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#enumValue}.
	 * @param ctx the parse tree
	 */
	void exitEnumValue(SolidityParser.EnumValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(SolidityParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(SolidityParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(SolidityParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(SolidityParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#eventParameterList}.
	 * @param ctx the parse tree
	 */
	void enterEventParameterList(SolidityParser.EventParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#eventParameterList}.
	 * @param ctx the parse tree
	 */
	void exitEventParameterList(SolidityParser.EventParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#eventParameter}.
	 * @param ctx the parse tree
	 */
	void enterEventParameter(SolidityParser.EventParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#eventParameter}.
	 * @param ctx the parse tree
	 */
	void exitEventParameter(SolidityParser.EventParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(SolidityParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(SolidityParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(SolidityParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(SolidityParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#userDefinedTypeName}.
	 * @param ctx the parse tree
	 */
	void enterUserDefinedTypeName(SolidityParser.UserDefinedTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#userDefinedTypeName}.
	 * @param ctx the parse tree
	 */
	void exitUserDefinedTypeName(SolidityParser.UserDefinedTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMapping(SolidityParser.MappingContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMapping(SolidityParser.MappingContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#mappingKey}.
	 * @param ctx the parse tree
	 */
	void enterMappingKey(SolidityParser.MappingKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#mappingKey}.
	 * @param ctx the parse tree
	 */
	void exitMappingKey(SolidityParser.MappingKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#functionTypeName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#functionTypeName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#storageLocation}.
	 * @param ctx the parse tree
	 */
	void enterStorageLocation(SolidityParser.StorageLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#storageLocation}.
	 * @param ctx the parse tree
	 */
	void exitStorageLocation(SolidityParser.StorageLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#stateMutability}.
	 * @param ctx the parse tree
	 */
	void enterStateMutability(SolidityParser.StateMutabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#stateMutability}.
	 * @param ctx the parse tree
	 */
	void exitStateMutability(SolidityParser.StateMutabilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#visibilityModifier}.
	 * @param ctx the parse tree
	 */
	void enterVisibilityModifier(SolidityParser.VisibilityModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#visibilityModifier}.
	 * @param ctx the parse tree
	 */
	void exitVisibilityModifier(SolidityParser.VisibilityModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SolidityParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SolidityParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SolidityParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SolidityParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(SolidityParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(SolidityParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SolidityParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SolidityParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(SolidityParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(SolidityParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(SolidityParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(SolidityParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(SolidityParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(SolidityParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(SolidityParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(SolidityParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(SolidityParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(SolidityParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#inlineAssemblyStatement}.
	 * @param ctx the parse tree
	 */
	void enterInlineAssemblyStatement(SolidityParser.InlineAssemblyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#inlineAssemblyStatement}.
	 * @param ctx the parse tree
	 */
	void exitInlineAssemblyStatement(SolidityParser.InlineAssemblyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(SolidityParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(SolidityParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(SolidityParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(SolidityParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(SolidityParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(SolidityParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SolidityParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SolidityParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(SolidityParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(SolidityParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#emitStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmitStatement(SolidityParser.EmitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#emitStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmitStatement(SolidityParser.EmitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#variableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#variableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(SolidityParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(SolidityParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#elementaryTypeName}.
	 * @param ctx the parse tree
	 */
	void enterElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#elementaryTypeName}.
	 * @param ctx the parse tree
	 */
	void exitElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#addressType}.
	 * @param ctx the parse tree
	 */
	void enterAddressType(SolidityParser.AddressTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#addressType}.
	 * @param ctx the parse tree
	 */
	void exitAddressType(SolidityParser.AddressTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayLoad}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLoad(SolidityParser.ArrayLoadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayLoad}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLoad(SolidityParser.ArrayLoadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PayableExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPayableExpr(SolidityParser.PayableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PayableExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPayableExpr(SolidityParser.PayableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(SolidityParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(SolidityParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryPostOp}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPostOp(SolidityParser.UnaryPostOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryPostOp}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPostOp(SolidityParser.UnaryPostOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryPreOp}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPreOp(SolidityParser.UnaryPreOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryPreOp}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPreOp(SolidityParser.UnaryPreOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewType}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewType(SolidityParser.NewTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewType}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewType(SolidityParser.NewTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReservedKeyExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReservedKeyExpr(SolidityParser.ReservedKeyExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReservedKeyExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReservedKeyExpr(SolidityParser.ReservedKeyExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Primary}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SolidityParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Primary}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SolidityParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeleteExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDeleteExpr(SolidityParser.DeleteExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeleteExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDeleteExpr(SolidityParser.DeleteExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBracketExpr(SolidityParser.BracketExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBracketExpr(SolidityParser.BracketExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArraySlice}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArraySlice(SolidityParser.ArraySliceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArraySlice}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArraySlice(SolidityParser.ArraySliceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberLoad}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberLoad(SolidityParser.MemberLoadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberLoad}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberLoad(SolidityParser.MemberLoadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TernaryExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(SolidityParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TernaryExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(SolidityParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MetaType}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMetaType(SolidityParser.MetaTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MetaType}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMetaType(SolidityParser.MetaTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicOp}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicOp(SolidityParser.LogicOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicOp}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicOp(SolidityParser.LogicOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(SolidityParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(SolidityParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#arrayBrackets}.
	 * @param ctx the parse tree
	 */
	void enterArrayBrackets(SolidityParser.ArrayBracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#arrayBrackets}.
	 * @param ctx the parse tree
	 */
	void exitArrayBrackets(SolidityParser.ArrayBracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(SolidityParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(SolidityParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#nameValueList}.
	 * @param ctx the parse tree
	 */
	void enterNameValueList(SolidityParser.NameValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#nameValueList}.
	 * @param ctx the parse tree
	 */
	void exitNameValueList(SolidityParser.NameValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#nameValue}.
	 * @param ctx the parse tree
	 */
	void enterNameValue(SolidityParser.NameValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#nameValue}.
	 * @param ctx the parse tree
	 */
	void exitNameValue(SolidityParser.NameValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#functionCallArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallArguments(SolidityParser.FunctionCallArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#functionCallArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallArguments(SolidityParser.FunctionCallArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SolidityParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SolidityParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#tupleExpression}.
	 * @param ctx the parse tree
	 */
	void enterTupleExpression(SolidityParser.TupleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#tupleExpression}.
	 * @param ctx the parse tree
	 */
	void exitTupleExpression(SolidityParser.TupleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#typeNameExpression}.
	 * @param ctx the parse tree
	 */
	void enterTypeNameExpression(SolidityParser.TypeNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#typeNameExpression}.
	 * @param ctx the parse tree
	 */
	void exitTypeNameExpression(SolidityParser.TypeNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyItem}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyItem(SolidityParser.AssemblyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyItem}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyItem(SolidityParser.AssemblyItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyBlock}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyBlock(SolidityParser.AssemblyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyBlock}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyBlock(SolidityParser.AssemblyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyExpression(SolidityParser.AssemblyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyExpression(SolidityParser.AssemblyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyCall}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyCall(SolidityParser.AssemblyCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyCall}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyCall(SolidityParser.AssemblyCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyLocalDefinition}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyLocalDefinition(SolidityParser.AssemblyLocalDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyLocalDefinition}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyLocalDefinition(SolidityParser.AssemblyLocalDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyAssignment(SolidityParser.AssemblyAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyAssignment(SolidityParser.AssemblyAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyIdentifierList}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyIdentifierList(SolidityParser.AssemblyIdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyIdentifierList}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyIdentifierList(SolidityParser.AssemblyIdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyStackAssignment}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyStackAssignment(SolidityParser.AssemblyStackAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyStackAssignment}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyStackAssignment(SolidityParser.AssemblyStackAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#labelDefinition}.
	 * @param ctx the parse tree
	 */
	void enterLabelDefinition(SolidityParser.LabelDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#labelDefinition}.
	 * @param ctx the parse tree
	 */
	void exitLabelDefinition(SolidityParser.LabelDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblySwitch}.
	 * @param ctx the parse tree
	 */
	void enterAssemblySwitch(SolidityParser.AssemblySwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblySwitch}.
	 * @param ctx the parse tree
	 */
	void exitAssemblySwitch(SolidityParser.AssemblySwitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyCase}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyCase(SolidityParser.AssemblyCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyCase}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyCase(SolidityParser.AssemblyCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyFunctionDefinition(SolidityParser.AssemblyFunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyFunctionDefinition(SolidityParser.AssemblyFunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyFunctionReturns}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyFunctionReturns(SolidityParser.AssemblyFunctionReturnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyFunctionReturns}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyFunctionReturns(SolidityParser.AssemblyFunctionReturnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyFor}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyFor(SolidityParser.AssemblyForContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyFor}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyFor(SolidityParser.AssemblyForContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyIf}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyIf(SolidityParser.AssemblyIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyIf}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyIf(SolidityParser.AssemblyIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyLiteral}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyLiteral(SolidityParser.AssemblyLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyLiteral}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyLiteral(SolidityParser.AssemblyLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyTypedVariableList}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyTypedVariableList(SolidityParser.AssemblyTypedVariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyTypedVariableList}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyTypedVariableList(SolidityParser.AssemblyTypedVariableListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyType}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyType(SolidityParser.AssemblyTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyType}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyType(SolidityParser.AssemblyTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#subAssembly}.
	 * @param ctx the parse tree
	 */
	void enterSubAssembly(SolidityParser.SubAssemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#subAssembly}.
	 * @param ctx the parse tree
	 */
	void exitSubAssembly(SolidityParser.SubAssemblyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(SolidityParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(SolidityParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SolidityParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SolidityParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#hexLiteral}.
	 * @param ctx the parse tree
	 */
	void enterHexLiteral(SolidityParser.HexLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#hexLiteral}.
	 * @param ctx the parse tree
	 */
	void exitHexLiteral(SolidityParser.HexLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(SolidityParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(SolidityParser.StringLiteralContext ctx);
}