// Generated from D:/Documentos/SwiftCompiler/src/grammars\swift.g4 by ANTLR 4.5.3
package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link swiftParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface swiftVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link swiftParser#top_level}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTop_level(swiftParser.Top_levelContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#statements}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatements(swiftParser.StatementsContext ctx);

    /**
     * Visit a parse tree produced by the {@code EXP_ST}
     * labeled alternative in {@link swiftParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEXP_ST(swiftParser.EXP_STContext ctx);

    /**
     * Visit a parse tree produced by the {@code DEC_ST}
     * labeled alternative in {@link swiftParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDEC_ST(swiftParser.DEC_STContext ctx);

    /**
     * Visit a parse tree produced by the {@code LOOP_ST}
     * labeled alternative in {@link swiftParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLOOP_ST(swiftParser.LOOP_STContext ctx);

    /**
     * Visit a parse tree produced by the {@code BRANCH_ST}
     * labeled alternative in {@link swiftParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBRANCH_ST(swiftParser.BRANCH_STContext ctx);

    /**
     * Visit a parse tree produced by the {@code CTRL_ST}
     * labeled alternative in {@link swiftParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCTRL_ST(swiftParser.CTRL_STContext ctx);

    /**
     * Visit a parse tree produced by the {@code PRINT_ST}
     * labeled alternative in {@link swiftParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPRINT_ST(swiftParser.PRINT_STContext ctx);

    /**
     * Visit a parse tree produced by the {@code FUNC_ST}
     * labeled alternative in {@link swiftParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFUNC_ST(swiftParser.FUNC_STContext ctx);

    /**
     * Visit a parse tree produced by the {@code CODE_BLK_ST}
     * labeled alternative in {@link swiftParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCODE_BLK_ST(swiftParser.CODE_BLK_STContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#print_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPrint_call(swiftParser.Print_callContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#function_call}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunction_call(swiftParser.Function_callContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#branch_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBranch_statement(swiftParser.Branch_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#control_transfer_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitControl_transfer_statement(swiftParser.Control_transfer_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#break_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBreak_statement(swiftParser.Break_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#continue_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitContinue_statement(swiftParser.Continue_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#return_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReturn_statement(swiftParser.Return_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#declaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDeclaration(swiftParser.DeclarationContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#code_block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCode_block(swiftParser.Code_blockContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#constant_declaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstant_declaration(swiftParser.Constant_declarationContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#variable_declaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVariable_declaration(swiftParser.Variable_declarationContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#function_declaration}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunction_declaration(swiftParser.Function_declarationContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#func_parameter}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunc_parameter(swiftParser.Func_parameterContext ctx);

    /**
     * Visit a parse tree produced by the {@code Type_BOOL}
     * labeled alternative in {@link swiftParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType_BOOL(swiftParser.Type_BOOLContext ctx);

    /**
     * Visit a parse tree produced by the {@code Type_FLOAT}
     * labeled alternative in {@link swiftParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType_FLOAT(swiftParser.Type_FLOATContext ctx);

    /**
     * Visit a parse tree produced by the {@code Type_INT}
     * labeled alternative in {@link swiftParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType_INT(swiftParser.Type_INTContext ctx);

    /**
     * Visit a parse tree produced by the {@code Type_ARRAY}
     * labeled alternative in {@link swiftParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType_ARRAY(swiftParser.Type_ARRAYContext ctx);

    /**
     * Visit a parse tree produced by the {@code Type_STRING}
     * labeled alternative in {@link swiftParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType_STRING(swiftParser.Type_STRINGContext ctx);

    /**
     * Visit a parse tree produced by the {@code Type_DIC}
     * labeled alternative in {@link swiftParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType_DIC(swiftParser.Type_DICContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#dic_type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDic_type(swiftParser.Dic_typeContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#ftype}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFtype(swiftParser.FtypeContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#ltype}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLtype(swiftParser.LtypeContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#loop_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLoop_statement(swiftParser.Loop_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#do_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDo_statement(swiftParser.Do_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#end_for}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEnd_for(swiftParser.End_forContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#for_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFor_statement(swiftParser.For_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#for_init}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFor_init(swiftParser.For_initContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#expression_list}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression_list(swiftParser.Expression_listContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#while_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhile_statement(swiftParser.While_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#where_clause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhere_clause(swiftParser.Where_clauseContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#if_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIf_statement(swiftParser.If_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#else_clause}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitElse_clause(swiftParser.Else_clauseContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#switch_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSwitch_statement(swiftParser.Switch_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#case_label}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCase_label(swiftParser.Case_labelContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#default_label}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefault_label(swiftParser.Default_labelContext ctx);

    /**
     * Visit a parse tree produced by the {@code CHECK_TYPE_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCHECK_TYPE_OP(swiftParser.CHECK_TYPE_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code CAST_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCAST_OP(swiftParser.CAST_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code NEW_DIC}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNEW_DIC(swiftParser.NEW_DICContext ctx);

    /**
     * Visit a parse tree produced by the {@code MUL_DIV_MOD_EQOP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMUL_DIV_MOD_EQOP(swiftParser.MUL_DIV_MOD_EQOPContext ctx);

    /**
     * Visit a parse tree produced by the {@code BINARY_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBINARY_OP(swiftParser.BINARY_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code INDX_REFERENCE}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitINDX_REFERENCE(swiftParser.INDX_REFERENCEContext ctx);

    /**
     * Visit a parse tree produced by the {@code AND_OR_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAND_OR_OP(swiftParser.AND_OR_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code TERNARY_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTERNARY_OP(swiftParser.TERNARY_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code PLUS_SUB_EQOP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPLUS_SUB_EQOP(swiftParser.PLUS_SUB_EQOPContext ctx);

    /**
     * Visit a parse tree produced by the {@code UNARY_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUNARY_OP(swiftParser.UNARY_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code REFERENCE}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitREFERENCE(swiftParser.REFERENCEContext ctx);

    /**
     * Visit a parse tree produced by the {@code ADD_SUB_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitADD_SUB_OP(swiftParser.ADD_SUB_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code PARENTESIS}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPARENTESIS(swiftParser.PARENTESISContext ctx);

    /**
     * Visit a parse tree produced by the {@code INC_DEC_LEFT}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitINC_DEC_LEFT(swiftParser.INC_DEC_LEFTContext ctx);

    /**
     * Visit a parse tree produced by the {@code AND_OR_EQOP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAND_OR_EQOP(swiftParser.AND_OR_EQOPContext ctx);

    /**
     * Visit a parse tree produced by the {@code COMP_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCOMP_OP(swiftParser.COMP_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code NEW_ARRAY}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNEW_ARRAY(swiftParser.NEW_ARRAYContext ctx);

    /**
     * Visit a parse tree produced by the {@code MUL_DIV_MOD_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMUL_DIV_MOD_OP(swiftParser.MUL_DIV_MOD_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code APPEND}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAPPEND(swiftParser.APPENDContext ctx);

    /**
     * Visit a parse tree produced by the {@code EQ_DIST_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEQ_DIST_OP(swiftParser.EQ_DIST_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code CTE}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCTE(swiftParser.CTEContext ctx);

    /**
     * Visit a parse tree produced by the {@code FUNC_CALL}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFUNC_CALL(swiftParser.FUNC_CALLContext ctx);

    /**
     * Visit a parse tree produced by the {@code NOT_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNOT_OP(swiftParser.NOT_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code LOCAL_INFER}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLOCAL_INFER(swiftParser.LOCAL_INFERContext ctx);

    /**
     * Visit a parse tree produced by the {@code COUNT}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCOUNT(swiftParser.COUNTContext ctx);

    /**
     * Visit a parse tree produced by the {@code RANGE_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRANGE_OP(swiftParser.RANGE_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code ASSIG_OP}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitASSIG_OP(swiftParser.ASSIG_OPContext ctx);

    /**
     * Visit a parse tree produced by the {@code INC_DEC_RIGTH}
     * labeled alternative in {@link swiftParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitINC_DEC_RIGTH(swiftParser.INC_DEC_RIGTHContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#range_ops}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRange_ops(swiftParser.Range_opsContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLiteral(swiftParser.LiteralContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#array_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArray_literal(swiftParser.Array_literalContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#dic_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDic_literal(swiftParser.Dic_literalContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#dic_item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDic_item(swiftParser.Dic_itemContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#dic_item_list}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDic_item_list(swiftParser.Dic_item_listContext ctx);

    /**
     * Visit a parse tree produced by the {@code CTE_INT}
     * labeled alternative in {@link swiftParser#numeric_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCTE_INT(swiftParser.CTE_INTContext ctx);

    /**
     * Visit a parse tree produced by the {@code CTE_FLOAT}
     * labeled alternative in {@link swiftParser#numeric_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCTE_FLOAT(swiftParser.CTE_FLOATContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#boolean_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBoolean_literal(swiftParser.Boolean_literalContext ctx);

    /**
     * Visit a parse tree produced by the {@code CTE_BIN}
     * labeled alternative in {@link swiftParser#integer_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCTE_BIN(swiftParser.CTE_BINContext ctx);

    /**
     * Visit a parse tree produced by the {@code CTE_OCT}
     * labeled alternative in {@link swiftParser#integer_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCTE_OCT(swiftParser.CTE_OCTContext ctx);

    /**
     * Visit a parse tree produced by the {@code CTE_DEC}
     * labeled alternative in {@link swiftParser#integer_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCTE_DEC(swiftParser.CTE_DECContext ctx);

    /**
     * Visit a parse tree produced by the {@code CTE_PURE_DEC}
     * labeled alternative in {@link swiftParser#integer_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCTE_PURE_DEC(swiftParser.CTE_PURE_DECContext ctx);

    /**
     * Visit a parse tree produced by the {@code CTE_HEX}
     * labeled alternative in {@link swiftParser#integer_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCTE_HEX(swiftParser.CTE_HEXContext ctx);

    /**
     * Visit a parse tree produced by {@link swiftParser#string_literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitString_literal(swiftParser.String_literalContext ctx);
}