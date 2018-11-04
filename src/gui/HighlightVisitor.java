package gui;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.swiftBaseVisitor;
import parser.swiftParser;
import traductor.BCELNode;

import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 * Created by Razor on 11/06/2017.
 * SwiftCompiler
 */
public class HighlightVisitor extends swiftBaseVisitor<BCELNode> {

    private StyledDocument styledDocument;
    private Style keyWordStyle;
    private Style typeStyle;
    private Style funcIdentStyle;
    private Style normalStyle;
    private Style stringStyle;
    private Style numericStyle;
    private String text;

    public HighlightVisitor(String txt, StyledDocument styledDocument, Style keyWordStyle
            , Style stringStyle, Style typeStyle, Style funcIdentStyle, Style normalStyle, Style numericStyle) {
        this.text = txt;
        this.styledDocument = styledDocument;
        this.keyWordStyle = keyWordStyle;
        this.typeStyle = typeStyle;
        this.funcIdentStyle = funcIdentStyle;
        this.stringStyle = stringStyle;
        this.normalStyle = normalStyle;
        this.numericStyle = numericStyle;
    }

    @Override
    public BCELNode visitTop_level(swiftParser.Top_levelContext ctx) {
        styledDocument.setCharacterAttributes(0, text.length(), normalStyle, true);
        visit(ctx.statements());
        return null;
    }

    @Override
    public BCELNode visitFunction_declaration(swiftParser.Function_declarationContext ctx) {
        Token s;
        if (ctx.TK_FUNCTION() != null) {
            s = ctx.TK_FUNCTION().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(),
                    keyWordStyle, true);
        }
        if (ctx.TK_IDENT() != null) {
            s = ctx.TK_IDENT().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(),
                    funcIdentStyle, true);
        }
        if (ctx.func_parameter() != null) {
            for (swiftParser.Func_parameterContext func_parameterContext : ctx.func_parameter()) {
                visit(func_parameterContext);
            }
        }
        if (ctx.type() != null) {
            s = ctx.type().getStart();
            styledDocument.setCharacterAttributes(s.getStartIndex(), ctx.type().getText().length(),
                    typeStyle, true);
        } else if (ctx.TK_VOID() != null) {
            s = ctx.TK_VOID().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(),
                    typeStyle, true);
        }
        if (ctx.code_block() != null) {
            visit(ctx.code_block());
        }
        return null;
    }

    @Override
    public BCELNode visitFunc_parameter(swiftParser.Func_parameterContext ctx) {
        Token s;
        if (ctx.TK_LET() != null) {
            s = ctx.TK_LET().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(),
                    keyWordStyle, true);
        } else if (ctx.TK_VAR() != null) {
            s = ctx.TK_VAR().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(),
                    keyWordStyle, true);
        }
        if (ctx.type() != null) {
            s = ctx.type().getStart();
            styledDocument.setCharacterAttributes(s.getStartIndex(), ctx.type().getText().length(),
                    typeStyle, true);
        }
        return null;
    }

    @Override
    public BCELNode visitReturn_statement(swiftParser.Return_statementContext ctx) {
        if (ctx.TK_RETURN() != null) {
            Token s = ctx.TK_RETURN().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        return super.visitReturn_statement(ctx);
    }

    @Override
    public BCELNode visitPrint_call(swiftParser.Print_callContext ctx) {
        Token s;
        if (ctx.TK_PRINT() != null) {
            s = ctx.TK_PRINT().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        } else if (ctx.TK_PRINTLN() != null) {
            s = ctx.TK_PRINTLN().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        if (ctx.expression() != null) {
            visit(ctx.expression());
        }
        return null;
    }

    @Override
    public BCELNode visitString_literal(swiftParser.String_literalContext ctx) {
        if (ctx.Static_string_literal() != null) {
            Token s = ctx.Static_string_literal().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), stringStyle, true);
        }
        return null;
    }

    @Override
    public BCELNode visitCTE_INT(swiftParser.CTE_INTContext ctx) {
        if (ctx.integer_literal() != null) {
            Token s = ctx.integer_literal().getStart();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), numericStyle, true);
        }
        return super.visitCTE_INT(ctx);
    }

    @Override
    public BCELNode visitCTE_FLOAT(swiftParser.CTE_FLOATContext ctx) {
        if (ctx.Floating_point_literal() != null) {
            Token s = ctx.Floating_point_literal().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), numericStyle, true);
        }
        return super.visitCTE_FLOAT(ctx);
    }

    @Override
    public BCELNode visitBoolean_literal(swiftParser.Boolean_literalContext ctx) {
        Token s;
        if (ctx.TK_TRUE() != null) {
            s = ctx.TK_TRUE().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        } else {
            s = ctx.TK_FALSE().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        return super.visitBoolean_literal(ctx);
    }

    @Override
    public BCELNode visitStatements(swiftParser.StatementsContext ctx) {
        if (ctx.TK_SEMI_COLON() != null) {
            Token s;
            for (TerminalNode terminalNode : ctx.TK_SEMI_COLON()) {
                s = terminalNode.getSymbol();
                styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
            }
        }
        return super.visitStatements(ctx);
    }

    @Override
    public BCELNode visitVariable_declaration(swiftParser.Variable_declarationContext ctx) {
        super.visitVariable_declaration(ctx);
        Token s;
        if (ctx.TK_VAR() != null) {
            s = ctx.TK_VAR().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        if (ctx.type() != null) {
            s = ctx.type().getStart();
            styledDocument.setCharacterAttributes(s.getStartIndex(), ctx.type().getText().length(), typeStyle, true);
        }
        return null;
    }

    @Override
    public BCELNode visitConstant_declaration(swiftParser.Constant_declarationContext ctx) {
        super.visitConstant_declaration(ctx);
        Token s;
        if (ctx.TK_LET() != null) {
            s = ctx.TK_LET().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        if (ctx.type() != null) {
            s = ctx.type().getStart();
            styledDocument.setCharacterAttributes(s.getStartIndex(), ctx.type().getText().length(), typeStyle, true);
        }
        return null;
    }

    @Override
    public BCELNode visitFor_statement(swiftParser.For_statementContext ctx) {
        super.visitFor_statement(ctx);
        Token s;
        if (ctx.TK_FOR() != null) {
            s = ctx.TK_FOR().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        if (ctx.TK_SEMI_COLON(0) != null) {
            s = ctx.TK_SEMI_COLON(0).getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        if (ctx.TK_SEMI_COLON(1) != null) {
            s = ctx.TK_SEMI_COLON(1).getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        return null;
    }

    @Override
    public BCELNode visitWhile_statement(swiftParser.While_statementContext ctx) {
        super.visitWhile_statement(ctx);
        Token s;
        if (ctx.TK_WHILE() != null) {
            s = ctx.TK_WHILE().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        return null;
    }

    @Override
    public BCELNode visitDo_statement(swiftParser.Do_statementContext ctx) {
        super.visitDo_statement(ctx);
        Token s;
        if (ctx.TK_DO() != null) {
            s = ctx.TK_DO().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        if (ctx.TK_WHILE() != null) {
            s = ctx.TK_WHILE().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        return null;
    }

    @Override
    public BCELNode visitBreak_statement(swiftParser.Break_statementContext ctx) {
        super.visitBreak_statement(ctx);
        Token s;
        if (ctx.TK_BREAK() != null) {
            s = ctx.TK_BREAK().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        return null;
    }

    @Override
    public BCELNode visitContinue_statement(swiftParser.Continue_statementContext ctx) {
        super.visitContinue_statement(ctx);
        Token s;
        if (ctx.TK_CONTINUE() != null) {
            s = ctx.TK_CONTINUE().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        return null;

    }

    @Override
    public BCELNode visitCHECK_TYPE_OP(swiftParser.CHECK_TYPE_OPContext ctx) {
        Token s = ctx.TK_IS().getSymbol();
        styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        if (ctx.type() != null) {
            s = ctx.type().getStart();
            styledDocument.setCharacterAttributes(s.getStartIndex(), ctx.type().getText().length(), typeStyle, true);
        }
        return super.visitCHECK_TYPE_OP(ctx);
    }

    @Override
    public BCELNode visitElse_clause(swiftParser.Else_clauseContext ctx) {
        super.visitElse_clause(ctx);
        Token s = ctx.TK_ELSE().getSymbol();
        styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        return null;
    }

    @Override
    public BCELNode visitIf_statement(swiftParser.If_statementContext ctx) {
        super.visitIf_statement(ctx);
        Token s = ctx.TK_IF().getSymbol();
        styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        return null;
    }

    @Override
    public BCELNode visitSwitch_statement(swiftParser.Switch_statementContext ctx) {
        super.visitSwitch_statement(ctx);
        Token s = ctx.TK_SWITCH().getSymbol();
        styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        return null;
    }

    @Override
    public BCELNode visitRANGE_OP(swiftParser.RANGE_OPContext ctx) {
        Token s = ctx.range_ops(0).integer_literal().getStart();
        styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), numericStyle, true);
        s = ctx.range_ops(1).integer_literal().getStart();
        styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), numericStyle, true);
        if (ctx.RANGE() != null) {
            s = ctx.RANGE().getSymbol();
        } else {
            s = ctx.UPRANGE().getSymbol();
        }
        styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        return null;
    }

    @Override
    public BCELNode visitCAST_OP(swiftParser.CAST_OPContext ctx) {
        Token s = ctx.TK_AS().getSymbol();
        styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        if (ctx.type() != null) {
            s = ctx.type().getStart();
            styledDocument.setCharacterAttributes(s.getStartIndex(), ctx.type().getText().length(), typeStyle, true);
        }
        return super.visitCAST_OP(ctx);
    }

    @Override
    public BCELNode visitCase_label(swiftParser.Case_labelContext ctx) {
        super.visitCase_label(ctx);
        Token s;
        if (ctx.TK_CASE() != null) {
            s = ctx.TK_CASE().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        if (ctx.TK_COLON() != null) {
            s = ctx.TK_COLON().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        if (ctx.integer_literal() != null) {
            s = ctx.integer_literal().getStart();
            styledDocument.setCharacterAttributes(s.getStartIndex(), ctx.integer_literal().getText().length(), numericStyle, true);
        }
        return null;
    }

    @Override
    public BCELNode visitDefault_label(swiftParser.Default_labelContext ctx) {
        super.visitDefault_label(ctx);
        Token s;
        if (ctx.TK_DEFAULT() != null) {
            s = ctx.TK_DEFAULT().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        if (ctx.TK_COLON() != null) {
            s = ctx.TK_COLON().getSymbol();
            styledDocument.setCharacterAttributes(s.getStartIndex(), s.getText().length(), keyWordStyle, true);
        }
        return null;
    }
}
