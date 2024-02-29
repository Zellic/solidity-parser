// Generated from java-escape by ANTLR 4.11.1
package solidity_parser.grammar.v088;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SolidityParser}.
 */
public interface SolidityParserListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 */
	void enterImportDirective(SolidityParser.ImportDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#importDirective}.
	 * @param ctx the parse tree
	 */
	void exitImportDirective(SolidityParser.ImportDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#importAliases}.
	 * @param ctx the parse tree
	 */
	void enterImportAliases(SolidityParser.ImportAliasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#importAliases}.
	 * @param ctx the parse tree
	 */
	void exitImportAliases(SolidityParser.ImportAliasesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(SolidityParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(SolidityParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#symbolAliases}.
	 * @param ctx the parse tree
	 */
	void enterSymbolAliases(SolidityParser.SymbolAliasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#symbolAliases}.
	 * @param ctx the parse tree
	 */
	void exitSymbolAliases(SolidityParser.SymbolAliasesContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#interfaceDefinition}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDefinition(SolidityParser.InterfaceDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#interfaceDefinition}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDefinition(SolidityParser.InterfaceDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#libraryDefinition}.
	 * @param ctx the parse tree
	 */
	void enterLibraryDefinition(SolidityParser.LibraryDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#libraryDefinition}.
	 * @param ctx the parse tree
	 */
	void exitLibraryDefinition(SolidityParser.LibraryDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#inheritanceSpecifierList}.
	 * @param ctx the parse tree
	 */
	void enterInheritanceSpecifierList(SolidityParser.InheritanceSpecifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#inheritanceSpecifierList}.
	 * @param ctx the parse tree
	 */
	void exitInheritanceSpecifierList(SolidityParser.InheritanceSpecifierListContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#contractBodyElement}.
	 * @param ctx the parse tree
	 */
	void enterContractBodyElement(SolidityParser.ContractBodyElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#contractBodyElement}.
	 * @param ctx the parse tree
	 */
	void exitContractBodyElement(SolidityParser.ContractBodyElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void enterNamedArgument(SolidityParser.NamedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void exitNamedArgument(SolidityParser.NamedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#callArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterCallArgumentList(SolidityParser.CallArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#callArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitCallArgumentList(SolidityParser.CallArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#identifierPath}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierPath(SolidityParser.IdentifierPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#identifierPath}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierPath(SolidityParser.IdentifierPathContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#visibility}.
	 * @param ctx the parse tree
	 */
	void enterVisibility(SolidityParser.VisibilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#visibility}.
	 * @param ctx the parse tree
	 */
	void exitVisibility(SolidityParser.VisibilityContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(SolidityParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(SolidityParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#constructorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#constructorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDefinition(SolidityParser.ConstructorDefinitionContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#fallbackFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFallbackFunctionDefinition(SolidityParser.FallbackFunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#fallbackFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFallbackFunctionDefinition(SolidityParser.FallbackFunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#receiveFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterReceiveFunctionDefinition(SolidityParser.ReceiveFunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#receiveFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitReceiveFunctionDefinition(SolidityParser.ReceiveFunctionDefinitionContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#structMember}.
	 * @param ctx the parse tree
	 */
	void enterStructMember(SolidityParser.StructMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#structMember}.
	 * @param ctx the parse tree
	 */
	void exitStructMember(SolidityParser.StructMemberContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#userDefinedValueTypeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterUserDefinedValueTypeDefinition(SolidityParser.UserDefinedValueTypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#userDefinedValueTypeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitUserDefinedValueTypeDefinition(SolidityParser.UserDefinedValueTypeDefinitionContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#constantVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantVariableDeclaration(SolidityParser.ConstantVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#constantVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantVariableDeclaration(SolidityParser.ConstantVariableDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#errorParameter}.
	 * @param ctx the parse tree
	 */
	void enterErrorParameter(SolidityParser.ErrorParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#errorParameter}.
	 * @param ctx the parse tree
	 */
	void exitErrorParameter(SolidityParser.ErrorParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#errorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterErrorDefinition(SolidityParser.ErrorDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#errorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitErrorDefinition(SolidityParser.ErrorDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#usingDirective}.
	 * @param ctx the parse tree
	 */
	void enterUsingDirective(SolidityParser.UsingDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#usingDirective}.
	 * @param ctx the parse tree
	 */
	void exitUsingDirective(SolidityParser.UsingDirectiveContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#dataLocation}.
	 * @param ctx the parse tree
	 */
	void enterDataLocation(SolidityParser.DataLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#dataLocation}.
	 * @param ctx the parse tree
	 */
	void exitDataLocation(SolidityParser.DataLocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryPrefixOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPrefixOperation(SolidityParser.UnaryPrefixOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryPrefixOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPrefixOperation(SolidityParser.UnaryPrefixOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryExpression}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(SolidityParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrderComparison}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrderComparison(SolidityParser.OrderComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrderComparison}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrderComparison(SolidityParser.OrderComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditional(SolidityParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditional(SolidityParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PayableConversion}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPayableConversion(SolidityParser.PayableConversionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PayableConversion}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPayableConversion(SolidityParser.PayableConversionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SolidityParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SolidityParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnarySuffixOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnarySuffixOperation(SolidityParser.UnarySuffixOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnarySuffixOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnarySuffixOperation(SolidityParser.UnarySuffixOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShiftOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftOperation(SolidityParser.ShiftOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShiftOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftOperation(SolidityParser.ShiftOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitAndOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitAndOperation(SolidityParser.BitAndOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitAndOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitAndOperation(SolidityParser.BitAndOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexRangeAccess}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexRangeAccess(SolidityParser.IndexRangeAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexRangeAccess}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexRangeAccess(SolidityParser.IndexRangeAccessContext ctx);
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
	 * Enter a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(SolidityParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(SolidityParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexAccess}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexAccess(SolidityParser.IndexAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexAccess}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexAccess(SolidityParser.IndexAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOperation(SolidityParser.AddSubOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOperation(SolidityParser.AddSubOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitOrOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitOrOperation(SolidityParser.BitOrOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitOrOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitOrOperation(SolidityParser.BitOrOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpOperation(SolidityParser.ExpOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpOperation(SolidityParser.ExpOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndOperation(SolidityParser.AndOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndOperation(SolidityParser.AndOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InlineArray}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInlineArray(SolidityParser.InlineArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InlineArray}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInlineArray(SolidityParser.InlineArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrOperation(SolidityParser.OrOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrOperation(SolidityParser.OrOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(SolidityParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAccess}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(SolidityParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivModOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModOperation(SolidityParser.MulDivModOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivModOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModOperation(SolidityParser.MulDivModOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitXorOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitXorOperation(SolidityParser.BitXorOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitXorOperation}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitXorOperation(SolidityParser.BitXorOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Tuple}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTuple(SolidityParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Tuple}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTuple(SolidityParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityComparison}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityComparison(SolidityParser.EqualityComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityComparison}
	 * labeled alternative in {@link SolidityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityComparison(SolidityParser.EqualityComparisonContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void enterAssignOp(SolidityParser.AssignOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void exitAssignOp(SolidityParser.AssignOpContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#inlineArrayExpression}.
	 * @param ctx the parse tree
	 */
	void enterInlineArrayExpression(SolidityParser.InlineArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#inlineArrayExpression}.
	 * @param ctx the parse tree
	 */
	void exitInlineArrayExpression(SolidityParser.InlineArrayExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SolidityParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SolidityParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(SolidityParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(SolidityParser.BooleanLiteralContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link SolidityParser#hexStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterHexStringLiteral(SolidityParser.HexStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#hexStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitHexStringLiteral(SolidityParser.HexStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#unicodeStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterUnicodeStringLiteral(SolidityParser.UnicodeStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#unicodeStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitUnicodeStringLiteral(SolidityParser.UnicodeStringLiteralContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#uncheckedBlock}.
	 * @param ctx the parse tree
	 */
	void enterUncheckedBlock(SolidityParser.UncheckedBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#uncheckedBlock}.
	 * @param ctx the parse tree
	 */
	void exitUncheckedBlock(SolidityParser.UncheckedBlockContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#revertStatement}.
	 * @param ctx the parse tree
	 */
	void enterRevertStatement(SolidityParser.RevertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#revertStatement}.
	 * @param ctx the parse tree
	 */
	void exitRevertStatement(SolidityParser.RevertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#assemblyStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssemblyStatement(SolidityParser.AssemblyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#assemblyStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssemblyStatement(SolidityParser.AssemblyStatementContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#variableDeclarationTuple}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationTuple(SolidityParser.VariableDeclarationTupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#variableDeclarationTuple}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationTuple(SolidityParser.VariableDeclarationTupleContext ctx);
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
	 * Enter a parse tree produced by {@link SolidityParser#mappingType}.
	 * @param ctx the parse tree
	 */
	void enterMappingType(SolidityParser.MappingTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#mappingType}.
	 * @param ctx the parse tree
	 */
	void exitMappingType(SolidityParser.MappingTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#mappingKeyType}.
	 * @param ctx the parse tree
	 */
	void enterMappingKeyType(SolidityParser.MappingKeyTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#mappingKeyType}.
	 * @param ctx the parse tree
	 */
	void exitMappingKeyType(SolidityParser.MappingKeyTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulStatement}.
	 * @param ctx the parse tree
	 */
	void enterYulStatement(SolidityParser.YulStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulStatement}.
	 * @param ctx the parse tree
	 */
	void exitYulStatement(SolidityParser.YulStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulBlock}.
	 * @param ctx the parse tree
	 */
	void enterYulBlock(SolidityParser.YulBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulBlock}.
	 * @param ctx the parse tree
	 */
	void exitYulBlock(SolidityParser.YulBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterYulVariableDeclaration(SolidityParser.YulVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitYulVariableDeclaration(SolidityParser.YulVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulAssignment}.
	 * @param ctx the parse tree
	 */
	void enterYulAssignment(SolidityParser.YulAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulAssignment}.
	 * @param ctx the parse tree
	 */
	void exitYulAssignment(SolidityParser.YulAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterYulIfStatement(SolidityParser.YulIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitYulIfStatement(SolidityParser.YulIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulForStatement}.
	 * @param ctx the parse tree
	 */
	void enterYulForStatement(SolidityParser.YulForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulForStatement}.
	 * @param ctx the parse tree
	 */
	void exitYulForStatement(SolidityParser.YulForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulSwitchCase}.
	 * @param ctx the parse tree
	 */
	void enterYulSwitchCase(SolidityParser.YulSwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulSwitchCase}.
	 * @param ctx the parse tree
	 */
	void exitYulSwitchCase(SolidityParser.YulSwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulSwitchStatement}.
	 * @param ctx the parse tree
	 */
	void enterYulSwitchStatement(SolidityParser.YulSwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulSwitchStatement}.
	 * @param ctx the parse tree
	 */
	void exitYulSwitchStatement(SolidityParser.YulSwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterYulFunctionDefinition(SolidityParser.YulFunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitYulFunctionDefinition(SolidityParser.YulFunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulPath}.
	 * @param ctx the parse tree
	 */
	void enterYulPath(SolidityParser.YulPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulPath}.
	 * @param ctx the parse tree
	 */
	void exitYulPath(SolidityParser.YulPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterYulFunctionCall(SolidityParser.YulFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitYulFunctionCall(SolidityParser.YulFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulBoolean}.
	 * @param ctx the parse tree
	 */
	void enterYulBoolean(SolidityParser.YulBooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulBoolean}.
	 * @param ctx the parse tree
	 */
	void exitYulBoolean(SolidityParser.YulBooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulLiteral}.
	 * @param ctx the parse tree
	 */
	void enterYulLiteral(SolidityParser.YulLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulLiteral}.
	 * @param ctx the parse tree
	 */
	void exitYulLiteral(SolidityParser.YulLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolidityParser#yulExpression}.
	 * @param ctx the parse tree
	 */
	void enterYulExpression(SolidityParser.YulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#yulExpression}.
	 * @param ctx the parse tree
	 */
	void exitYulExpression(SolidityParser.YulExpressionContext ctx);
}