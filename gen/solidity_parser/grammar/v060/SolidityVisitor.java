// Generated from java-escape by ANTLR 4.11.1
package solidity_parser.grammar.v060;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SolidityParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SolidityVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SolidityParser#sourceUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceUnit(SolidityParser.SourceUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#pragmaDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPragmaDirective(SolidityParser.PragmaDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#pragmaName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPragmaName(SolidityParser.PragmaNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#pragmaValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPragmaValue(SolidityParser.PragmaValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#version}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersion(SolidityParser.VersionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#versionConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionConstraint(SolidityParser.VersionConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#versionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionOperator(SolidityParser.VersionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModuleImport}
	 * labeled alternative in {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleImport(SolidityParser.ModuleImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AliasImport}
	 * labeled alternative in {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliasImport(SolidityParser.AliasImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymbolImport}
	 * labeled alternative in {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolImport(SolidityParser.SymbolImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(SolidityParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#contractDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContractDefinition(SolidityParser.ContractDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#inheritanceSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#contractPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContractPart(SolidityParser.ContractPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#stateVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#overrideSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#usingForDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingForDeclaration(SolidityParser.UsingForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#structDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDefinition(SolidityParser.StructDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#modifierDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifierDefinition(SolidityParser.ModifierDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#functionDescriptor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDescriptor(SolidityParser.FunctionDescriptorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#returnParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnParameters(SolidityParser.ReturnParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#modifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifierList(SolidityParser.ModifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#modifierInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifierInvocation(SolidityParser.ModifierInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#eventDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventDefinition(SolidityParser.EventDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#enumDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDefinition(SolidityParser.EnumDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#enumValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumValue(SolidityParser.EnumValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(SolidityParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(SolidityParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#eventParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventParameterList(SolidityParser.EventParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#eventParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventParameter(SolidityParser.EventParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(SolidityParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(SolidityParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#userDefinedTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedTypeName(SolidityParser.UserDefinedTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapping(SolidityParser.MappingContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#mappingKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingKey(SolidityParser.MappingKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#functionTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#storageLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageLocation(SolidityParser.StorageLocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#stateMutability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateMutability(SolidityParser.StateMutabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#visibilityModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibilityModifier(SolidityParser.VisibilityModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SolidityParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SolidityParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(SolidityParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SolidityParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(SolidityParser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(SolidityParser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(SolidityParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(SolidityParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(SolidityParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#inlineAssemblyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineAssemblyStatement(SolidityParser.InlineAssemblyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#doWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(SolidityParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(SolidityParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(SolidityParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SolidityParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(SolidityParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#emitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmitStatement(SolidityParser.EmitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#variableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(SolidityParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#elementaryTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#addressType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddressType(SolidityParser.AddressTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLoad}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLoad(SolidityParser.ArrayLoadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PayableExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPayableExpr(SolidityParser.PayableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(SolidityParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryPostOp}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPostOp(SolidityParser.UnaryPostOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryPreOp}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPreOp(SolidityParser.UnaryPreOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewType}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewType(SolidityParser.NewTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReservedKeyExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReservedKeyExpr(SolidityParser.ReservedKeyExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Primary}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(SolidityParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeleteExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteExpr(SolidityParser.DeleteExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketExpr(SolidityParser.BracketExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArraySlice}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySlice(SolidityParser.ArraySliceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberLoad}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberLoad(SolidityParser.MemberLoadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TernaryExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpr(SolidityParser.TernaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MetaType}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaType(SolidityParser.MetaTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicOp}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOp(SolidityParser.LogicOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(SolidityParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#arrayBrackets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayBrackets(SolidityParser.ArrayBracketsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(SolidityParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#nameValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameValueList(SolidityParser.NameValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#nameValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameValue(SolidityParser.NameValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#functionCallArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallArguments(SolidityParser.FunctionCallArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SolidityParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#tupleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleExpression(SolidityParser.TupleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#typeNameExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNameExpression(SolidityParser.TypeNameExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyItem(SolidityParser.AssemblyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyBlock(SolidityParser.AssemblyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyExpression(SolidityParser.AssemblyExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyCall(SolidityParser.AssemblyCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyLocalDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyLocalDefinition(SolidityParser.AssemblyLocalDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyAssignment(SolidityParser.AssemblyAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyIdentifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyIdentifierList(SolidityParser.AssemblyIdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyStackAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyStackAssignment(SolidityParser.AssemblyStackAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#labelDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDefinition(SolidityParser.LabelDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblySwitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblySwitch(SolidityParser.AssemblySwitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyCase(SolidityParser.AssemblyCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyFunctionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyFunctionDefinition(SolidityParser.AssemblyFunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyFunctionReturns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyFunctionReturns(SolidityParser.AssemblyFunctionReturnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyFor(SolidityParser.AssemblyForContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyIf(SolidityParser.AssemblyIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyLiteral(SolidityParser.AssemblyLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyTypedVariableList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyTypedVariableList(SolidityParser.AssemblyTypedVariableListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyType(SolidityParser.AssemblyTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#subAssembly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAssembly(SolidityParser.SubAssemblyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(SolidityParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(SolidityParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#hexLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexLiteral(SolidityParser.HexLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(SolidityParser.StringLiteralContext ctx);
}