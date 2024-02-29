// Generated from java-escape by ANTLR 4.11.1
package solidity_parser.grammar.v088;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SolidityParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SolidityParserVisitor<T> extends ParseTreeVisitor<T> {
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
	 * Visit a parse tree produced by {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDirective(SolidityParser.ImportDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#importAliases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportAliases(SolidityParser.ImportAliasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(SolidityParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#symbolAliases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolAliases(SolidityParser.SymbolAliasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#contractDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContractDefinition(SolidityParser.ContractDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#interfaceDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDefinition(SolidityParser.InterfaceDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#libraryDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibraryDefinition(SolidityParser.LibraryDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#inheritanceSpecifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritanceSpecifierList(SolidityParser.InheritanceSpecifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#inheritanceSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritanceSpecifier(SolidityParser.InheritanceSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#contractBodyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContractBodyElement(SolidityParser.ContractBodyElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#namedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedArgument(SolidityParser.NamedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#callArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallArgumentList(SolidityParser.CallArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#identifierPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierPath(SolidityParser.IdentifierPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#modifierInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifierInvocation(SolidityParser.ModifierInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#visibility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibility(SolidityParser.VisibilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(SolidityParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(SolidityParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#constructorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#stateMutability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateMutability(SolidityParser.StateMutabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#overrideSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverrideSpecifier(SolidityParser.OverrideSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(SolidityParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#modifierDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifierDefinition(SolidityParser.ModifierDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#fallbackFunctionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallbackFunctionDefinition(SolidityParser.FallbackFunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#receiveFunctionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiveFunctionDefinition(SolidityParser.ReceiveFunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#structDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDefinition(SolidityParser.StructDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#structMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructMember(SolidityParser.StructMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#enumDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDefinition(SolidityParser.EnumDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#userDefinedValueTypeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedValueTypeDefinition(SolidityParser.UserDefinedValueTypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#stateVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateVariableDeclaration(SolidityParser.StateVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#constantVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantVariableDeclaration(SolidityParser.ConstantVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#eventParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventParameter(SolidityParser.EventParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#eventDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventDefinition(SolidityParser.EventDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#errorParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorParameter(SolidityParser.ErrorParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#errorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorDefinition(SolidityParser.ErrorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#usingDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingDirective(SolidityParser.UsingDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(SolidityParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#elementaryTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementaryTypeName(SolidityParser.ElementaryTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#functionTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTypeName(SolidityParser.FunctionTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(SolidityParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#dataLocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataLocation(SolidityParser.DataLocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryPrefixOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPrefixOperation(SolidityParser.UnaryPrefixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrderComparison}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderComparison(SolidityParser.OrderComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(SolidityParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PayableConversion}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPayableConversion(SolidityParser.PayableConversionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SolidityParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnarySuffixOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnarySuffixOperation(SolidityParser.UnarySuffixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShiftOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftOperation(SolidityParser.ShiftOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitAndOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitAndOperation(SolidityParser.BitAndOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexRangeAccess}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexRangeAccess(SolidityParser.IndexRangeAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncCallExpr}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(SolidityParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(SolidityParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexAccess}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAccess(SolidityParser.IndexAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubOperation(SolidityParser.AddSubOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitOrOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOrOperation(SolidityParser.BitOrOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpOperation(SolidityParser.ExpOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOperation(SolidityParser.AndOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InlineArray}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineArray(SolidityParser.InlineArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOperation(SolidityParser.OrOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccess(SolidityParser.MemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivModOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModOperation(SolidityParser.MulDivModOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitXorOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitXorOperation(SolidityParser.BitXorOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Tuple}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(SolidityParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityComparison}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityComparison(SolidityParser.EqualityComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MetaType}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaType(SolidityParser.MetaTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assignOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignOp(SolidityParser.AssignOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#tupleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleExpression(SolidityParser.TupleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#inlineArrayExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineArrayExpression(SolidityParser.InlineArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(SolidityParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SolidityParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(SolidityParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(SolidityParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#hexStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexStringLiteral(SolidityParser.HexStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#unicodeStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnicodeStringLiteral(SolidityParser.UnicodeStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(SolidityParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SolidityParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#uncheckedBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUncheckedBlock(SolidityParser.UncheckedBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SolidityParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(SolidityParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SolidityParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(SolidityParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(SolidityParser.WhileStatementContext ctx);
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
	 * Visit a parse tree produced by {@link SolidityParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SolidityParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#emitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmitStatement(SolidityParser.EmitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#revertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRevertStatement(SolidityParser.RevertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#assemblyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssemblyStatement(SolidityParser.AssemblyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationList(SolidityParser.VariableDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#variableDeclarationTuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationTuple(SolidityParser.VariableDeclarationTupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#variableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationStatement(SolidityParser.VariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(SolidityParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#mappingType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingType(SolidityParser.MappingTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#mappingKeyType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingKeyType(SolidityParser.MappingKeyTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulStatement(SolidityParser.YulStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulBlock(SolidityParser.YulBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulVariableDeclaration(SolidityParser.YulVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulAssignment(SolidityParser.YulAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulIfStatement(SolidityParser.YulIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulForStatement(SolidityParser.YulForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulSwitchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulSwitchCase(SolidityParser.YulSwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulSwitchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulSwitchStatement(SolidityParser.YulSwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulFunctionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulFunctionDefinition(SolidityParser.YulFunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulPath(SolidityParser.YulPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulFunctionCall(SolidityParser.YulFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulBoolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulBoolean(SolidityParser.YulBooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulLiteral(SolidityParser.YulLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolidityParser#yulExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYulExpression(SolidityParser.YulExpressionContext ctx);
}