// Generated from D:/Documentos/SwiftCompiler/src/grammars\swift.g4 by ANTLR 4.5.3
package parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class swiftParser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, TK_BREAK = 7, TK_CONTINUE = 8,
            TK_LET = 9, TK_VAR = 10, TK_COLON = 11, TK_SEMI_COLON = 12, TK_INT = 13, TK_FLOAT = 14,
            TK_DOUBLE = 15, TK_BOOL = 16, TK_STRING = 17, TK_DIC = 18, TK_ARRAY = 19, TK_VOID = 20,
            TK_TRUE = 21, TK_FALSE = 22, TK_WHERE = 23, TK_IF = 24, TK_ELSE = 25, TK_SWITCH = 26,
            TK_COUNT = 27, TK_CONCAT = 28, TK_DO = 29, TK_WHILE = 30, TK_FOR = 31, TK_IN = 32,
            TK_CASE = 33, TK_DEFAULT = 34, TK_AS = 35, TK_IS = 36, TK_FUNCTION = 37, INC = 38,
            DEC = 39, ARROW = 40, MUL = 41, DIV = 42, ADD = 43, SUB = 44, MOD = 45, RANGE = 46, UPRANGE = 47,
            AND = 48, OR = 49, NOT = 50, ANDB = 51, ORB = 52, XORB = 53, EQ = 54, DISTINCT = 55, GTE = 56,
            LTE = 57, GT = 58, LT = 59, ASSIG = 60, ANDEQ = 61, OREQ = 62, PLUSEQ = 63, TIMESEQ = 64,
            SUBEQ = 65, DIVEQ = 66, MODEQ = 67, LOCAL = 68, TK_PAR_RIGHT = 69, TK_PAR_LEFT = 70,
            TK_RETURN = 71, TK_PRINT = 72, TK_PRINTLN = 73, TK_COMA = 74, TK_IDENT = 75, Binary_literal = 76,
            Octal_literal = 77, Decimal_literal = 78, Pure_decimal_digits = 79, Hexadecimal_literal = 80,
            Floating_point_literal = 81, Static_string_literal = 82, WS = 83, Block_comment = 84,
            Line_comment = 85;
    public static final int
            RULE_top_level = 0, RULE_statements = 1, RULE_statement = 2, RULE_print_call = 3,
            RULE_function_call = 4, RULE_branch_statement = 5, RULE_control_transfer_statement = 6,
            RULE_break_statement = 7, RULE_continue_statement = 8, RULE_return_statement = 9,
            RULE_declaration = 10, RULE_code_block = 11, RULE_constant_declaration = 12,
            RULE_variable_declaration = 13, RULE_function_declaration = 14, RULE_func_parameter = 15,
            RULE_type = 16, RULE_dic_type = 17, RULE_ftype = 18, RULE_ltype = 19,
            RULE_loop_statement = 20, RULE_do_statement = 21, RULE_end_for = 22, RULE_for_statement = 23,
            RULE_for_init = 24, RULE_expression_list = 25, RULE_while_statement = 26,
            RULE_where_clause = 27, RULE_if_statement = 28, RULE_else_clause = 29,
            RULE_switch_statement = 30, RULE_case_label = 31, RULE_default_label = 32,
            RULE_expression = 33, RULE_range_ops = 34, RULE_literal = 35, RULE_array_literal = 36,
            RULE_dic_literal = 37, RULE_dic_item = 38, RULE_dic_item_list = 39, RULE_numeric_literal = 40,
            RULE_boolean_literal = 41, RULE_integer_literal = 42, RULE_string_literal = 43;
    public static final String[] ruleNames = {
            "top_level", "statements", "statement", "print_call", "function_call",
            "branch_statement", "control_transfer_statement", "break_statement", "continue_statement",
            "return_statement", "declaration", "code_block", "constant_declaration",
            "variable_declaration", "function_declaration", "func_parameter", "type",
            "dic_type", "ftype", "ltype", "loop_statement", "do_statement", "end_for",
            "for_statement", "for_init", "expression_list", "while_statement", "where_clause",
            "if_statement", "else_clause", "switch_statement", "case_label", "default_label",
            "expression", "range_ops", "literal", "array_literal", "dic_literal",
            "dic_item", "dic_item_list", "numeric_literal", "boolean_literal", "integer_literal",
            "string_literal"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3W\u0201\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4" +
                    ",\t,\4-\t-\3\2\3\2\3\2\3\3\3\3\5\3`\n\3\7\3b\n\3\f\3\16\3e\13\3\3\4\3" +
                    "\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4o\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5" +
                    "\6y\n\6\3\6\3\6\3\7\3\7\5\7\177\n\7\3\b\3\b\3\b\5\b\u0084\n\b\3\t\3\t" +
                    "\3\n\3\n\3\13\3\13\5\13\u008c\n\13\3\f\3\f\3\f\5\f\u0091\n\f\3\r\3\r\3" +
                    "\r\3\r\3\16\3\16\3\16\3\16\5\16\u009b\n\16\3\16\3\16\5\16\u009f\n\16\3" +
                    "\17\3\17\3\17\3\17\5\17\u00a5\n\17\3\17\3\17\5\17\u00a9\n\17\3\20\3\20" +
                    "\3\20\3\20\3\20\3\20\7\20\u00b1\n\20\f\20\16\20\u00b4\13\20\5\20\u00b6" +
                    "\n\20\3\20\3\20\3\20\3\20\5\20\u00bc\n\20\3\20\3\20\3\21\5\21\u00c1\n" +
                    "\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00cd\n\22" +
                    "\3\22\3\22\3\22\7\22\u00d2\n\22\f\22\16\22\u00d5\13\22\3\23\3\23\3\23" +
                    "\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\5\26\u00e5\n\26" +
                    "\3\27\3\27\3\27\3\27\3\27\3\30\5\30\u00ed\n\30\3\31\3\31\3\31\5\31\u00f2" +
                    "\n\31\3\31\3\31\5\31\u00f6\n\31\3\31\3\31\3\31\3\31\3\31\5\31\u00fd\n" +
                    "\31\3\31\3\31\5\31\u0101\n\31\3\31\3\31\5\31\u0105\n\31\3\31\3\31\3\32" +
                    "\3\32\5\32\u010b\n\32\3\33\3\33\3\33\7\33\u0110\n\33\f\33\16\33\u0113" +
                    "\13\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u0120" +
                    "\n\36\3\37\3\37\3\37\3\37\5\37\u0126\n\37\3 \3 \3 \3 \3 \3 \7 \u012e\n" +
                    " \f \16 \u0131\13 \3 \3 \3 \5 \u0136\n \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"" +
                    "\3#\3#\3#\3#\5#\u0145\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#" +
                    "\3#\3#\3#\3#\3#\5#\u015b\n#\3#\3#\3#\3#\3#\3#\3#\5#\u0164\n#\3#\3#\3#" +
                    "\3#\3#\3#\3#\5#\u016d\n#\3#\3#\3#\3#\3#\3#\3#\5#\u0176\n#\3#\3#\3#\3#" +
                    "\3#\3#\3#\5#\u017f\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u018b\n#\3#\3#" +
                    "\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u019d\n#\3#\3#\5#\u01a1" +
                    "\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#" +
                    "\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u01cd" +
                    "\n#\f#\16#\u01d0\13#\3$\5$\u01d3\n$\3$\3$\3%\3%\3%\3%\3%\5%\u01dc\n%\3" +
                    "&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\7)\u01ed\n)\f)\16)\u01f0" +
                    "\13)\3*\3*\5*\u01f4\n*\3+\3+\3,\3,\3,\3,\3,\5,\u01fd\n,\3-\3-\3-\2\4\"" +
                    "D.\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD" +
                    "FHJLNPRTVX\2\20\3\2JK\3\2\13\f\3\2\60\61\3\2-.\3\2()\4\2BBDE\3\2?@\4\2" +
                    "AACC\4\2+,//\3\2\65\67\3\289\3\2:=\3\2\62\63\3\2\27\30\u022d\2Z\3\2\2" +
                    "\2\4c\3\2\2\2\6n\3\2\2\2\bp\3\2\2\2\nu\3\2\2\2\f~\3\2\2\2\16\u0083\3\2" +
                    "\2\2\20\u0085\3\2\2\2\22\u0087\3\2\2\2\24\u0089\3\2\2\2\26\u0090\3\2\2" +
                    "\2\30\u0092\3\2\2\2\32\u0096\3\2\2\2\34\u00a0\3\2\2\2\36\u00aa\3\2\2\2" +
                    " \u00c0\3\2\2\2\"\u00cc\3\2\2\2$\u00d6\3\2\2\2&\u00db\3\2\2\2(\u00de\3" +
                    "\2\2\2*\u00e4\3\2\2\2,\u00e6\3\2\2\2.\u00ec\3\2\2\2\60\u00ee\3\2\2\2\62" +
                    "\u010a\3\2\2\2\64\u010c\3\2\2\2\66\u0114\3\2\2\28\u0118\3\2\2\2:\u011b" +
                    "\3\2\2\2<\u0125\3\2\2\2>\u0127\3\2\2\2@\u0139\3\2\2\2B\u013d\3\2\2\2D" +
                    "\u01a0\3\2\2\2F\u01d2\3\2\2\2H\u01db\3\2\2\2J\u01dd\3\2\2\2L\u01e1\3\2" +
                    "\2\2N\u01e5\3\2\2\2P\u01e9\3\2\2\2R\u01f3\3\2\2\2T\u01f5\3\2\2\2V\u01fc" +
                    "\3\2\2\2X\u01fe\3\2\2\2Z[\5\4\3\2[\\\7\2\2\3\\\3\3\2\2\2]_\5\6\4\2^`\7" +
                    "\16\2\2_^\3\2\2\2_`\3\2\2\2`b\3\2\2\2a]\3\2\2\2be\3\2\2\2ca\3\2\2\2cd" +
                    "\3\2\2\2d\5\3\2\2\2ec\3\2\2\2fo\5D#\2go\5\26\f\2ho\5*\26\2io\5\f\7\2j" +
                    "o\5\16\b\2ko\5\b\5\2lo\5\n\6\2mo\5\30\r\2nf\3\2\2\2ng\3\2\2\2nh\3\2\2" +
                    "\2ni\3\2\2\2nj\3\2\2\2nk\3\2\2\2nl\3\2\2\2nm\3\2\2\2o\7\3\2\2\2pq\t\2" +
                    "\2\2qr\7H\2\2rs\5D#\2st\7G\2\2t\t\3\2\2\2uv\7M\2\2vx\7H\2\2wy\5\64\33" +
                    "\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7G\2\2{\13\3\2\2\2|\177\5:\36\2}\177" +
                    "\5> \2~|\3\2\2\2~}\3\2\2\2\177\r\3\2\2\2\u0080\u0084\5\20\t\2\u0081\u0084" +
                    "\5\22\n\2\u0082\u0084\5\24\13\2\u0083\u0080\3\2\2\2\u0083\u0081\3\2\2" +
                    "\2\u0083\u0082\3\2\2\2\u0084\17\3\2\2\2\u0085\u0086\7\t\2\2\u0086\21\3" +
                    "\2\2\2\u0087\u0088\7\n\2\2\u0088\23\3\2\2\2\u0089\u008b\7I\2\2\u008a\u008c" +
                    "\5D#\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\25\3\2\2\2\u008d" +
                    "\u0091\5\34\17\2\u008e\u0091\5\32\16\2\u008f\u0091\5\36\20\2\u0090\u008d" +
                    "\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\27\3\2\2\2\u0092" +
                    "\u0093\7\3\2\2\u0093\u0094\5\4\3\2\u0094\u0095\7\4\2\2\u0095\31\3\2\2" +
                    "\2\u0096\u0097\7\13\2\2\u0097\u009a\7M\2\2\u0098\u0099\7\r\2\2\u0099\u009b" +
                    "\5\"\22\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2" +
                    "\u009c\u009d\7>\2\2\u009d\u009f\5D#\2\u009e\u009c\3\2\2\2\u009e\u009f" +
                    "\3\2\2\2\u009f\33\3\2\2\2\u00a0\u00a1\7\f\2\2\u00a1\u00a4\7M\2\2\u00a2" +
                    "\u00a3\7\r\2\2\u00a3\u00a5\5\"\22\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3" +
                    "\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a7\7>\2\2\u00a7\u00a9\5D#\2\u00a8" +
                    "\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\35\3\2\2\2\u00aa\u00ab\7\'\2" +
                    "\2\u00ab\u00ac\7M\2\2\u00ac\u00b5\7H\2\2\u00ad\u00b2\5 \21\2\u00ae\u00af" +
                    "\7L\2\2\u00af\u00b1\5 \21\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2" +
                    "\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2" +
                    "\2\2\u00b5\u00ad\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7" +
                    "\u00b8\7G\2\2\u00b8\u00bb\7*\2\2\u00b9\u00bc\5\"\22\2\u00ba\u00bc\7\26" +
                    "\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd" +
                    "\u00be\5\30\r\2\u00be\37\3\2\2\2\u00bf\u00c1\t\3\2\2\u00c0\u00bf\3\2\2" +
                    "\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\7M\2\2\u00c3\u00c4" +
                    "\7\r\2\2\u00c4\u00c5\5\"\22\2\u00c5!\3\2\2\2\u00c6\u00c7\b\22\1\2\u00c7" +
                    "\u00cd\7\17\2\2\u00c8\u00cd\7\20\2\2\u00c9\u00cd\7\22\2\2\u00ca\u00cd" +
                    "\7\23\2\2\u00cb\u00cd\5$\23\2\u00cc\u00c6\3\2\2\2\u00cc\u00c8\3\2\2\2" +
                    "\u00cc\u00c9\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d3" +
                    "\3\2\2\2\u00ce\u00cf\f\4\2\2\u00cf\u00d0\7\5\2\2\u00d0\u00d2\7\6\2\2\u00d1" +
                    "\u00ce\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2" +
                    "\2\2\u00d4#\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7\24\2\2\u00d7\u00d8" +
                    "\5&\24\2\u00d8\u00d9\7L\2\2\u00d9\u00da\5(\25\2\u00da%\3\2\2\2\u00db\u00dc" +
                    "\7=\2\2\u00dc\u00dd\5\"\22\2\u00dd\'\3\2\2\2\u00de\u00df\5\"\22\2\u00df" +
                    "\u00e0\7<\2\2\u00e0)\3\2\2\2\u00e1\u00e5\5\60\31\2\u00e2\u00e5\5\66\34" +
                    "\2\u00e3\u00e5\5,\27\2\u00e4\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3" +
                    "\3\2\2\2\u00e5+\3\2\2\2\u00e6\u00e7\7\37\2\2\u00e7\u00e8\5\30\r\2\u00e8" +
                    "\u00e9\7 \2\2\u00e9\u00ea\5D#\2\u00ea-\3\2\2\2\u00eb\u00ed\5D#\2\u00ec" +
                    "\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed/\3\2\2\2\u00ee\u0104\7!\2\2\u00ef" +
                    "\u00f1\7H\2\2\u00f0\u00f2\5\62\32\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3" +
                    "\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\7\16\2\2\u00f4\u00f6\5D#\2\u00f5" +
                    "\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\7\16" +
                    "\2\2\u00f8\u00f9\5.\30\2\u00f9\u00fa\7G\2\2\u00fa\u0105\3\2\2\2\u00fb" +
                    "\u00fd\5\62\32\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3" +
                    "\2\2\2\u00fe\u0100\7\16\2\2\u00ff\u0101\5D#\2\u0100\u00ff\3\2\2\2\u0100" +
                    "\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7\16\2\2\u0103\u0105\5" +
                    ".\30\2\u0104\u00ef\3\2\2\2\u0104\u00fc\3\2\2\2\u0105\u0106\3\2\2\2\u0106" +
                    "\u0107\5\30\r\2\u0107\61\3\2\2\2\u0108\u010b\5\34\17\2\u0109\u010b\5\64" +
                    "\33\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\63\3\2\2\2\u010c\u0111" +
                    "\5D#\2\u010d\u010e\7L\2\2\u010e\u0110\5D#\2\u010f\u010d\3\2\2\2\u0110" +
                    "\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\65\3\2\2" +
                    "\2\u0113\u0111\3\2\2\2\u0114\u0115\7 \2\2\u0115\u0116\5D#\2\u0116\u0117" +
                    "\5\30\r\2\u0117\67\3\2\2\2\u0118\u0119\7\31\2\2\u0119\u011a\5D#\2\u011a" +
                    "9\3\2\2\2\u011b\u011c\7\32\2\2\u011c\u011d\5D#\2\u011d\u011f\5\30\r\2" +
                    "\u011e\u0120\5<\37\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120;\3" +
                    "\2\2\2\u0121\u0122\7\33\2\2\u0122\u0126\5\30\r\2\u0123\u0124\7\33\2\2" +
                    "\u0124\u0126\5:\36\2\u0125\u0121\3\2\2\2\u0125\u0123\3\2\2\2\u0126=\3" +
                    "\2\2\2\u0127\u0128\7\34\2\2\u0128\u0129\5D#\2\u0129\u012f\7\3\2\2\u012a" +
                    "\u012b\5@!\2\u012b\u012c\5\30\r\2\u012c\u012e\3\2\2\2\u012d\u012a\3\2" +
                    "\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130" +
                    "\u0135\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\5B\"\2\u0133\u0134\5\30" +
                    "\r\2\u0134\u0136\3\2\2\2\u0135\u0132\3\2\2\2\u0135\u0136\3\2\2\2\u0136" +
                    "\u0137\3\2\2\2\u0137\u0138\7\4\2\2\u0138?\3\2\2\2\u0139\u013a\7#\2\2\u013a" +
                    "\u013b\5V,\2\u013b\u013c\7\r\2\2\u013cA\3\2\2\2\u013d\u013e\7$\2\2\u013e" +
                    "\u013f\7\r\2\2\u013fC\3\2\2\2\u0140\u0141\b#\1\2\u0141\u0142\7M\2\2\u0142" +
                    "\u0144\7H\2\2\u0143\u0145\5\64\33\2\u0144\u0143\3\2\2\2\u0144\u0145\3" +
                    "\2\2\2\u0145\u0146\3\2\2\2\u0146\u01a1\7G\2\2\u0147\u0148\7\35\2\2\u0148" +
                    "\u0149\7H\2\2\u0149\u014a\5D#\2\u014a\u014b\7G\2\2\u014b\u01a1\3\2\2\2" +
                    "\u014c\u014d\7F\2\2\u014d\u01a1\5V,\2\u014e\u01a1\7M\2\2\u014f\u0150\5" +
                    "F$\2\u0150\u0151\t\4\2\2\u0151\u0152\5F$\2\u0152\u01a1\3\2\2\2\u0153\u0154" +
                    "\t\5\2\2\u0154\u01a1\5D#\27\u0155\u015a\7M\2\2\u0156\u0157\7\5\2\2\u0157" +
                    "\u0158\5D#\2\u0158\u0159\7\6\2\2\u0159\u015b\3\2\2\2\u015a\u0156\3\2\2" +
                    "\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u01a1\t\6\2\2\u015d\u015e" +
                    "\t\6\2\2\u015e\u0163\7M\2\2\u015f\u0160\7\5\2\2\u0160\u0161\5D#\2\u0161" +
                    "\u0162\7\6\2\2\u0162\u0164\3\2\2\2\u0163\u015f\3\2\2\2\u0163\u0164\3\2" +
                    "\2\2\u0164\u01a1\3\2\2\2\u0165\u0166\7\64\2\2\u0166\u01a1\5D#\16\u0167" +
                    "\u016c\7M\2\2\u0168\u0169\7\5\2\2\u0169\u016a\5D#\2\u016a\u016b\7\6\2" +
                    "\2\u016b\u016d\3\2\2\2\u016c\u0168\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e" +
                    "\3\2\2\2\u016e\u016f\t\7\2\2\u016f\u01a1\5D#\r\u0170\u0175\7M\2\2\u0171" +
                    "\u0172\7\5\2\2\u0172\u0173\5D#\2\u0173\u0174\7\6\2\2\u0174\u0176\3\2\2" +
                    "\2\u0175\u0171\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178" +
                    "\t\b\2\2\u0178\u01a1\5D#\f\u0179\u017e\7M\2\2\u017a\u017b\7\5\2\2\u017b" +
                    "\u017c\5D#\2\u017c\u017d\7\6\2\2\u017d\u017f\3\2\2\2\u017e\u017a\3\2\2" +
                    "\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\t\t\2\2\u0181\u01a1" +
                    "\5D#\13\u0182\u0183\5\"\22\2\u0183\u0184\7\5\2\2\u0184\u0185\7\6\2\2\u0185" +
                    "\u018a\7H\2\2\u0186\u0187\5D#\2\u0187\u0188\7L\2\2\u0188\u0189\5D#\2\u0189" +
                    "\u018b\3\2\2\2\u018a\u0186\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2" +
                    "\2\2\u018c\u018d\7G\2\2\u018d\u01a1\3\2\2\2\u018e\u018f\5$\23\2\u018f" +
                    "\u0190\7H\2\2\u0190\u0191\7G\2\2\u0191\u01a1\3\2\2\2\u0192\u0193\7H\2" +
                    "\2\u0193\u0194\5D#\2\u0194\u0195\7G\2\2\u0195\u01a1\3\2\2\2\u0196\u01a1" +
                    "\5H%\2\u0197\u019c\7M\2\2\u0198\u0199\7\5\2\2\u0199\u019a\5D#\2\u019a" +
                    "\u019b\7\6\2\2\u019b\u019d\3\2\2\2\u019c\u0198\3\2\2\2\u019c\u019d\3\2" +
                    "\2\2\u019d\u019e\3\2\2\2\u019e\u019f\7>\2\2\u019f\u01a1\5D#\3\u01a0\u0140" +
                    "\3\2\2\2\u01a0\u0147\3\2\2\2\u01a0\u014c\3\2\2\2\u01a0\u014e\3\2\2\2\u01a0" +
                    "\u014f\3\2\2\2\u01a0\u0153\3\2\2\2\u01a0\u0155\3\2\2\2\u01a0\u015d\3\2" +
                    "\2\2\u01a0\u0165\3\2\2\2\u01a0\u0167\3\2\2\2\u01a0\u0170\3\2\2\2\u01a0" +
                    "\u0179\3\2\2\2\u01a0\u0182\3\2\2\2\u01a0\u018e\3\2\2\2\u01a0\u0192\3\2" +
                    "\2\2\u01a0\u0196\3\2\2\2\u01a0\u0197\3\2\2\2\u01a1\u01ce\3\2\2\2\u01a2" +
                    "\u01a3\f\24\2\2\u01a3\u01a4\t\n\2\2\u01a4\u01cd\5D#\25\u01a5\u01a6\f\23" +
                    "\2\2\u01a6\u01a7\t\5\2\2\u01a7\u01cd\5D#\24\u01a8\u01a9\f\22\2\2\u01a9" +
                    "\u01aa\t\13\2\2\u01aa\u01cd\5D#\23\u01ab\u01ac\f\21\2\2\u01ac\u01ad\t" +
                    "\f\2\2\u01ad\u01cd\5D#\22\u01ae\u01af\f\20\2\2\u01af\u01b0\t\r\2\2\u01b0" +
                    "\u01cd\5D#\21\u01b1\u01b2\f\17\2\2\u01b2\u01b3\t\16\2\2\u01b3\u01cd\5" +
                    "D#\20\u01b4\u01b5\f\n\2\2\u01b5\u01b6\7\b\2\2\u01b6\u01b7\5D#\2\u01b7" +
                    "\u01b8\7\r\2\2\u01b8\u01b9\5D#\13\u01b9\u01cd\3\2\2\2\u01ba\u01bb\f\34" +
                    "\2\2\u01bb\u01bc\7\7\2\2\u01bc\u01bd\7\36\2\2\u01bd\u01be\7H\2\2\u01be" +
                    "\u01bf\5D#\2\u01bf\u01c0\7G\2\2\u01c0\u01cd\3\2\2\2\u01c1\u01c2\f\32\2" +
                    "\2\u01c2\u01c3\7\5\2\2\u01c3\u01c4\5D#\2\u01c4\u01c5\7\6\2\2\u01c5\u01cd" +
                    "\3\2\2\2\u01c6\u01c7\f\7\2\2\u01c7\u01c8\7%\2\2\u01c8\u01cd\5\"\22\2\u01c9" +
                    "\u01ca\f\6\2\2\u01ca\u01cb\7&\2\2\u01cb\u01cd\5\"\22\2\u01cc\u01a2\3\2" +
                    "\2\2\u01cc\u01a5\3\2\2\2\u01cc\u01a8\3\2\2\2\u01cc\u01ab\3\2\2\2\u01cc" +
                    "\u01ae\3\2\2\2\u01cc\u01b1\3\2\2\2\u01cc\u01b4\3\2\2\2\u01cc\u01ba\3\2" +
                    "\2\2\u01cc\u01c1\3\2\2\2\u01cc\u01c6\3\2\2\2\u01cc\u01c9\3\2\2\2\u01cd" +
                    "\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cfE\3\2\2\2" +
                    "\u01d0\u01ce\3\2\2\2\u01d1\u01d3\7.\2\2\u01d2\u01d1\3\2\2\2\u01d2\u01d3" +
                    "\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\5V,\2\u01d5G\3\2\2\2\u01d6\u01dc" +
                    "\5R*\2\u01d7\u01dc\5X-\2\u01d8\u01dc\5T+\2\u01d9\u01dc\5J&\2\u01da\u01dc" +
                    "\5L\'\2\u01db\u01d6\3\2\2\2\u01db\u01d7\3\2\2\2\u01db\u01d8\3\2\2\2\u01db" +
                    "\u01d9\3\2\2\2\u01db\u01da\3\2\2\2\u01dcI\3\2\2\2\u01dd\u01de\7\5\2\2" +
                    "\u01de\u01df\5\64\33\2\u01df\u01e0\7\6\2\2\u01e0K\3\2\2\2\u01e1\u01e2" +
                    "\7\5\2\2\u01e2\u01e3\5P)\2\u01e3\u01e4\7\6\2\2\u01e4M\3\2\2\2\u01e5\u01e6" +
                    "\5D#\2\u01e6\u01e7\7\r\2\2\u01e7\u01e8\5D#\2\u01e8O\3\2\2\2\u01e9\u01ee" +
                    "\5N(\2\u01ea\u01eb\7L\2\2\u01eb\u01ed\5N(\2\u01ec\u01ea\3\2\2\2\u01ed" +
                    "\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01efQ\3\2\2\2" +
                    "\u01f0\u01ee\3\2\2\2\u01f1\u01f4\5V,\2\u01f2\u01f4\7S\2\2\u01f3\u01f1" +
                    "\3\2\2\2\u01f3\u01f2\3\2\2\2\u01f4S\3\2\2\2\u01f5\u01f6\t\17\2\2\u01f6" +
                    "U\3\2\2\2\u01f7\u01fd\7N\2\2\u01f8\u01fd\7O\2\2\u01f9\u01fd\7P\2\2\u01fa" +
                    "\u01fd\7Q\2\2\u01fb\u01fd\7R\2\2\u01fc\u01f7\3\2\2\2\u01fc\u01f8\3\2\2" +
                    "\2\u01fc\u01f9\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fb\3\2\2\2\u01fdW" +
                    "\3\2\2\2\u01fe\u01ff\7T\2\2\u01ffY\3\2\2\2\61_cnx~\u0083\u008b\u0090\u009a" +
                    "\u009e\u00a4\u00a8\u00b2\u00b5\u00bb\u00c0\u00cc\u00d3\u00e4\u00ec\u00f1" +
                    "\u00f5\u00fc\u0100\u0104\u010a\u0111\u011f\u0125\u012f\u0135\u0144\u015a" +
                    "\u0163\u016c\u0175\u017e\u018a\u019c\u01a0\u01cc\u01ce\u01d2\u01db\u01ee" +
                    "\u01f3\u01fc";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'{'", "'}'", "'['", "']'", "'.'", "'?'", "'break'", "'continue'",
            "'let'", "'var'", "':'", "';'", null, null, null, null, "'String'", "'Dictionary'",
            "'Array'", "'Void'", "'true'", "'false'", "'where'", "'if'", "'else'",
            "'switch'", "'count'", "'concat'", "'do'", "'while'", "'for'", "'in'",
            "'case'", "'default'", "'as'", "'is'", "'func'", "'++'", "'--'", "'->'",
            "'*'", "'/'", "'+'", "'-'", "'%'", "'..'", "'...'", "'&&'", "'||'", "'!'",
            "'&'", "'|'", "'^'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'='",
            "'&='", "'|='", "'+='", "'*='", "'-='", "'/='", "'%='", "'$'", "')'",
            "'('", "'return'", "'print'", "'println'", "','"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, "TK_BREAK", "TK_CONTINUE", "TK_LET",
            "TK_VAR", "TK_COLON", "TK_SEMI_COLON", "TK_INT", "TK_FLOAT", "TK_DOUBLE",
            "TK_BOOL", "TK_STRING", "TK_DIC", "TK_ARRAY", "TK_VOID", "TK_TRUE", "TK_FALSE",
            "TK_WHERE", "TK_IF", "TK_ELSE", "TK_SWITCH", "TK_COUNT", "TK_CONCAT",
            "TK_DO", "TK_WHILE", "TK_FOR", "TK_IN", "TK_CASE", "TK_DEFAULT", "TK_AS",
            "TK_IS", "TK_FUNCTION", "INC", "DEC", "ARROW", "MUL", "DIV", "ADD", "SUB",
            "MOD", "RANGE", "UPRANGE", "AND", "OR", "NOT", "ANDB", "ORB", "XORB",
            "EQ", "DISTINCT", "GTE", "LTE", "GT", "LT", "ASSIG", "ANDEQ", "OREQ",
            "PLUSEQ", "TIMESEQ", "SUBEQ", "DIVEQ", "MODEQ", "LOCAL", "TK_PAR_RIGHT",
            "TK_PAR_LEFT", "TK_RETURN", "TK_PRINT", "TK_PRINTLN", "TK_COMA", "TK_IDENT",
            "Binary_literal", "Octal_literal", "Decimal_literal", "Pure_decimal_digits",
            "Hexadecimal_literal", "Floating_point_literal", "Static_string_literal",
            "WS", "Block_comment", "Line_comment"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public swiftParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String getGrammarFileName() {
        return "swift.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final Top_levelContext top_level() throws RecognitionException {
        Top_levelContext _localctx = new Top_levelContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_top_level);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(88);
                statements();
                setState(89);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StatementsContext statements() throws RecognitionException {
        StatementsContext _localctx = new StatementsContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_statements);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(97);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << TK_BREAK) | (1L << TK_CONTINUE) | (1L << TK_LET) | (1L << TK_VAR) | (1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_BOOL) | (1L << TK_STRING) | (1L << TK_DIC) | (1L << TK_TRUE) | (1L << TK_FALSE) | (1L << TK_IF) | (1L << TK_SWITCH) | (1L << TK_COUNT) | (1L << TK_DO) | (1L << TK_WHILE) | (1L << TK_FOR) | (1L << TK_FUNCTION) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << NOT))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LOCAL - 68)) | (1L << (TK_PAR_LEFT - 68)) | (1L << (TK_RETURN - 68)) | (1L << (TK_PRINT - 68)) | (1L << (TK_PRINTLN - 68)) | (1L << (TK_IDENT - 68)) | (1L << (Binary_literal - 68)) | (1L << (Octal_literal - 68)) | (1L << (Decimal_literal - 68)) | (1L << (Pure_decimal_digits - 68)) | (1L << (Hexadecimal_literal - 68)) | (1L << (Floating_point_literal - 68)) | (1L << (Static_string_literal - 68)))) != 0)) {
                    {
                        {
                            setState(91);
                            statement();
                            setState(93);
                            _la = _input.LA(1);
                            if (_la == TK_SEMI_COLON) {
                                {
                                    setState(92);
                                    match(TK_SEMI_COLON);
                                }
                            }

                        }
                    }
                    setState(99);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_statement);
        try {
            setState(108);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    _localctx = new EXP_STContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(100);
                    expression(0);
                }
                break;
                case 2:
                    _localctx = new DEC_STContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(101);
                    declaration();
                }
                break;
                case 3:
                    _localctx = new LOOP_STContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(102);
                    loop_statement();
                }
                break;
                case 4:
                    _localctx = new BRANCH_STContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(103);
                    branch_statement();
                }
                break;
                case 5:
                    _localctx = new CTRL_STContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(104);
                    control_transfer_statement();
                }
                break;
                case 6:
                    _localctx = new PRINT_STContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(105);
                    print_call();
                }
                break;
                case 7:
                    _localctx = new FUNC_STContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(106);
                    function_call();
                }
                break;
                case 8:
                    _localctx = new CODE_BLK_STContext(_localctx);
                    enterOuterAlt(_localctx, 8);
                {
                    setState(107);
                    code_block();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Print_callContext print_call() throws RecognitionException {
        Print_callContext _localctx = new Print_callContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_print_call);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(110);
                ((Print_callContext) _localctx).op = _input.LT(1);
                _la = _input.LA(1);
                if (!(_la == TK_PRINT || _la == TK_PRINTLN)) {
                    ((Print_callContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                } else {
                    consume();
                }
                setState(111);
                match(TK_PAR_LEFT);
                setState(112);
                expression(0);
                setState(113);
                match(TK_PAR_RIGHT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Function_callContext function_call() throws RecognitionException {
        Function_callContext _localctx = new Function_callContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_function_call);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(115);
                match(TK_IDENT);
                setState(116);
                match(TK_PAR_LEFT);
                setState(118);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_BOOL) | (1L << TK_STRING) | (1L << TK_DIC) | (1L << TK_TRUE) | (1L << TK_FALSE) | (1L << TK_COUNT) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << NOT))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LOCAL - 68)) | (1L << (TK_PAR_LEFT - 68)) | (1L << (TK_IDENT - 68)) | (1L << (Binary_literal - 68)) | (1L << (Octal_literal - 68)) | (1L << (Decimal_literal - 68)) | (1L << (Pure_decimal_digits - 68)) | (1L << (Hexadecimal_literal - 68)) | (1L << (Floating_point_literal - 68)) | (1L << (Static_string_literal - 68)))) != 0)) {
                    {
                        setState(117);
                        expression_list();
                    }
                }

                setState(120);
                match(TK_PAR_RIGHT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Branch_statementContext branch_statement() throws RecognitionException {
        Branch_statementContext _localctx = new Branch_statementContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_branch_statement);
        try {
            setState(124);
            switch (_input.LA(1)) {
                case TK_IF:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(122);
                    if_statement();
                }
                break;
                case TK_SWITCH:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(123);
                    switch_statement();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Control_transfer_statementContext control_transfer_statement() throws RecognitionException {
        Control_transfer_statementContext _localctx = new Control_transfer_statementContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_control_transfer_statement);
        try {
            setState(129);
            switch (_input.LA(1)) {
                case TK_BREAK:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(126);
                    break_statement();
                }
                break;
                case TK_CONTINUE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(127);
                    continue_statement();
                }
                break;
                case TK_RETURN:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(128);
                    return_statement();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Break_statementContext break_statement() throws RecognitionException {
        Break_statementContext _localctx = new Break_statementContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_break_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(131);
                match(TK_BREAK);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Continue_statementContext continue_statement() throws RecognitionException {
        Continue_statementContext _localctx = new Continue_statementContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_continue_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(133);
                match(TK_CONTINUE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Return_statementContext return_statement() throws RecognitionException {
        Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_return_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(135);
                match(TK_RETURN);
                setState(137);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                    case 1: {
                        setState(136);
                        expression(0);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DeclarationContext declaration() throws RecognitionException {
        DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_declaration);
        try {
            setState(142);
            switch (_input.LA(1)) {
                case TK_VAR:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(139);
                    variable_declaration();
                }
                break;
                case TK_LET:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(140);
                    constant_declaration();
                }
                break;
                case TK_FUNCTION:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(141);
                    function_declaration();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Code_blockContext code_block() throws RecognitionException {
        Code_blockContext _localctx = new Code_blockContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_code_block);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(144);
                match(T__0);
                setState(145);
                statements();
                setState(146);
                match(T__1);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Constant_declarationContext constant_declaration() throws RecognitionException {
        Constant_declarationContext _localctx = new Constant_declarationContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_constant_declaration);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(148);
                match(TK_LET);
                setState(149);
                match(TK_IDENT);
                setState(152);
                _la = _input.LA(1);
                if (_la == TK_COLON) {
                    {
                        setState(150);
                        match(TK_COLON);
                        setState(151);
                        type(0);
                    }
                }

                setState(156);
                _la = _input.LA(1);
                if (_la == ASSIG) {
                    {
                        setState(154);
                        match(ASSIG);
                        setState(155);
                        expression(0);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Variable_declarationContext variable_declaration() throws RecognitionException {
        Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_variable_declaration);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(158);
                match(TK_VAR);
                setState(159);
                match(TK_IDENT);
                setState(162);
                _la = _input.LA(1);
                if (_la == TK_COLON) {
                    {
                        setState(160);
                        match(TK_COLON);
                        setState(161);
                        type(0);
                    }
                }

                setState(166);
                _la = _input.LA(1);
                if (_la == ASSIG) {
                    {
                        setState(164);
                        match(ASSIG);
                        setState(165);
                        expression(0);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Function_declarationContext function_declaration() throws RecognitionException {
        Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_function_declaration);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(168);
                match(TK_FUNCTION);
                setState(169);
                match(TK_IDENT);
                setState(170);
                match(TK_PAR_LEFT);
                setState(179);
                _la = _input.LA(1);
                if (_la == TK_LET || _la == TK_VAR || _la == TK_IDENT) {
                    {
                        setState(171);
                        func_parameter();
                        setState(176);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == TK_COMA) {
                            {
                                {
                                    setState(172);
                                    match(TK_COMA);
                                    setState(173);
                                    func_parameter();
                                }
                            }
                            setState(178);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(181);
                match(TK_PAR_RIGHT);
                setState(182);
                match(ARROW);
                setState(185);
                switch (_input.LA(1)) {
                    case TK_INT:
                    case TK_FLOAT:
                    case TK_BOOL:
                    case TK_STRING:
                    case TK_DIC: {
                        setState(183);
                        type(0);
                    }
                    break;
                    case TK_VOID: {
                        setState(184);
                        match(TK_VOID);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(187);
                code_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Func_parameterContext func_parameter() throws RecognitionException {
        Func_parameterContext _localctx = new Func_parameterContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_func_parameter);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(190);
                _la = _input.LA(1);
                if (_la == TK_LET || _la == TK_VAR) {
                    {
                        setState(189);
                        ((Func_parameterContext) _localctx).cons = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == TK_LET || _la == TK_VAR)) {
                            ((Func_parameterContext) _localctx).cons = (Token) _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                    }
                }

                setState(192);
                match(TK_IDENT);
                setState(193);
                match(TK_COLON);
                setState(194);
                type(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeContext type() throws RecognitionException {
        return type(0);
    }

    private TypeContext type(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        TypeContext _localctx = new TypeContext(_ctx, _parentState);
        TypeContext _prevctx = _localctx;
        int _startState = 32;
        enterRecursionRule(_localctx, 32, RULE_type, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(202);
                switch (_input.LA(1)) {
                    case TK_INT: {
                        _localctx = new Type_INTContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(197);
                        match(TK_INT);
                    }
                    break;
                    case TK_FLOAT: {
                        _localctx = new Type_FLOATContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(198);
                        match(TK_FLOAT);
                    }
                    break;
                    case TK_BOOL: {
                        _localctx = new Type_BOOLContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(199);
                        match(TK_BOOL);
                    }
                    break;
                    case TK_STRING: {
                        _localctx = new Type_STRINGContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(200);
                        match(TK_STRING);
                    }
                    break;
                    case TK_DIC: {
                        _localctx = new Type_DICContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(201);
                        dic_type();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(209);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 17, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new Type_ARRAYContext(new TypeContext(_parentctx, _parentState));
                                pushNewRecursionContext(_localctx, _startState, RULE_type);
                                setState(204);
                                if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                setState(205);
                                match(T__2);
                                setState(206);
                                match(T__3);
                            }
                        }
                    }
                    setState(211);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 17, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final Dic_typeContext dic_type() throws RecognitionException {
        Dic_typeContext _localctx = new Dic_typeContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_dic_type);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(212);
                match(TK_DIC);
                setState(213);
                ftype();
                setState(214);
                match(TK_COMA);
                setState(215);
                ltype();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FtypeContext ftype() throws RecognitionException {
        FtypeContext _localctx = new FtypeContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_ftype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(217);
                match(LT);
                setState(218);
                type(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LtypeContext ltype() throws RecognitionException {
        LtypeContext _localctx = new LtypeContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_ltype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(220);
                type(0);
                setState(221);
                match(GT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Loop_statementContext loop_statement() throws RecognitionException {
        Loop_statementContext _localctx = new Loop_statementContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_loop_statement);
        try {
            setState(226);
            switch (_input.LA(1)) {
                case TK_FOR:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(223);
                    for_statement();
                }
                break;
                case TK_WHILE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(224);
                    while_statement();
                }
                break;
                case TK_DO:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(225);
                    do_statement();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Do_statementContext do_statement() throws RecognitionException {
        Do_statementContext _localctx = new Do_statementContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_do_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(228);
                match(TK_DO);
                setState(229);
                code_block();
                setState(230);
                match(TK_WHILE);
                setState(231);
                expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final End_forContext end_for() throws RecognitionException {
        End_forContext _localctx = new End_forContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_end_for);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(234);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_BOOL) | (1L << TK_STRING) | (1L << TK_DIC) | (1L << TK_TRUE) | (1L << TK_FALSE) | (1L << TK_COUNT) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << NOT))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LOCAL - 68)) | (1L << (TK_PAR_LEFT - 68)) | (1L << (TK_IDENT - 68)) | (1L << (Binary_literal - 68)) | (1L << (Octal_literal - 68)) | (1L << (Decimal_literal - 68)) | (1L << (Pure_decimal_digits - 68)) | (1L << (Hexadecimal_literal - 68)) | (1L << (Floating_point_literal - 68)) | (1L << (Static_string_literal - 68)))) != 0)) {
                    {
                        setState(233);
                        expression(0);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final For_statementContext for_statement() throws RecognitionException {
        For_statementContext _localctx = new For_statementContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_for_statement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(236);
                match(TK_FOR);
                setState(258);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
                    case 1: {
                        setState(237);
                        match(TK_PAR_LEFT);
                        setState(239);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << TK_VAR) | (1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_BOOL) | (1L << TK_STRING) | (1L << TK_DIC) | (1L << TK_TRUE) | (1L << TK_FALSE) | (1L << TK_COUNT) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << NOT))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LOCAL - 68)) | (1L << (TK_PAR_LEFT - 68)) | (1L << (TK_IDENT - 68)) | (1L << (Binary_literal - 68)) | (1L << (Octal_literal - 68)) | (1L << (Decimal_literal - 68)) | (1L << (Pure_decimal_digits - 68)) | (1L << (Hexadecimal_literal - 68)) | (1L << (Floating_point_literal - 68)) | (1L << (Static_string_literal - 68)))) != 0)) {
                            {
                                setState(238);
                                for_init();
                            }
                        }

                        setState(241);
                        match(TK_SEMI_COLON);
                        setState(243);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_BOOL) | (1L << TK_STRING) | (1L << TK_DIC) | (1L << TK_TRUE) | (1L << TK_FALSE) | (1L << TK_COUNT) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << NOT))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LOCAL - 68)) | (1L << (TK_PAR_LEFT - 68)) | (1L << (TK_IDENT - 68)) | (1L << (Binary_literal - 68)) | (1L << (Octal_literal - 68)) | (1L << (Decimal_literal - 68)) | (1L << (Pure_decimal_digits - 68)) | (1L << (Hexadecimal_literal - 68)) | (1L << (Floating_point_literal - 68)) | (1L << (Static_string_literal - 68)))) != 0)) {
                            {
                                setState(242);
                                expression(0);
                            }
                        }

                        setState(245);
                        match(TK_SEMI_COLON);
                        setState(246);
                        end_for();
                        setState(247);
                        match(TK_PAR_RIGHT);
                    }
                    break;
                    case 2: {
                        setState(250);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << TK_VAR) | (1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_BOOL) | (1L << TK_STRING) | (1L << TK_DIC) | (1L << TK_TRUE) | (1L << TK_FALSE) | (1L << TK_COUNT) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << NOT))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LOCAL - 68)) | (1L << (TK_PAR_LEFT - 68)) | (1L << (TK_IDENT - 68)) | (1L << (Binary_literal - 68)) | (1L << (Octal_literal - 68)) | (1L << (Decimal_literal - 68)) | (1L << (Pure_decimal_digits - 68)) | (1L << (Hexadecimal_literal - 68)) | (1L << (Floating_point_literal - 68)) | (1L << (Static_string_literal - 68)))) != 0)) {
                            {
                                setState(249);
                                for_init();
                            }
                        }

                        setState(252);
                        match(TK_SEMI_COLON);
                        setState(254);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_BOOL) | (1L << TK_STRING) | (1L << TK_DIC) | (1L << TK_TRUE) | (1L << TK_FALSE) | (1L << TK_COUNT) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << NOT))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LOCAL - 68)) | (1L << (TK_PAR_LEFT - 68)) | (1L << (TK_IDENT - 68)) | (1L << (Binary_literal - 68)) | (1L << (Octal_literal - 68)) | (1L << (Decimal_literal - 68)) | (1L << (Pure_decimal_digits - 68)) | (1L << (Hexadecimal_literal - 68)) | (1L << (Floating_point_literal - 68)) | (1L << (Static_string_literal - 68)))) != 0)) {
                            {
                                setState(253);
                                expression(0);
                            }
                        }

                        setState(256);
                        match(TK_SEMI_COLON);
                        setState(257);
                        end_for();
                    }
                    break;
                }
                setState(260);
                code_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final For_initContext for_init() throws RecognitionException {
        For_initContext _localctx = new For_initContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_for_init);
        try {
            setState(264);
            switch (_input.LA(1)) {
                case TK_VAR:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(262);
                    variable_declaration();
                }
                break;
                case T__2:
                case TK_INT:
                case TK_FLOAT:
                case TK_BOOL:
                case TK_STRING:
                case TK_DIC:
                case TK_TRUE:
                case TK_FALSE:
                case TK_COUNT:
                case INC:
                case DEC:
                case ADD:
                case SUB:
                case NOT:
                case LOCAL:
                case TK_PAR_LEFT:
                case TK_IDENT:
                case Binary_literal:
                case Octal_literal:
                case Decimal_literal:
                case Pure_decimal_digits:
                case Hexadecimal_literal:
                case Floating_point_literal:
                case Static_string_literal:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(263);
                    expression_list();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Expression_listContext expression_list() throws RecognitionException {
        Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_expression_list);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(266);
                expression(0);
                setState(271);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == TK_COMA) {
                    {
                        {
                            setState(267);
                            match(TK_COMA);
                            setState(268);
                            expression(0);
                        }
                    }
                    setState(273);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final While_statementContext while_statement() throws RecognitionException {
        While_statementContext _localctx = new While_statementContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_while_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(274);
                match(TK_WHILE);
                setState(275);
                expression(0);
                setState(276);
                code_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Where_clauseContext where_clause() throws RecognitionException {
        Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_where_clause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(278);
                match(TK_WHERE);
                setState(279);
                expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final If_statementContext if_statement() throws RecognitionException {
        If_statementContext _localctx = new If_statementContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_if_statement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(281);
                match(TK_IF);
                setState(282);
                expression(0);
                setState(283);
                code_block();
                setState(285);
                _la = _input.LA(1);
                if (_la == TK_ELSE) {
                    {
                        setState(284);
                        else_clause();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Else_clauseContext else_clause() throws RecognitionException {
        Else_clauseContext _localctx = new Else_clauseContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_else_clause);
        try {
            setState(291);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(287);
                    match(TK_ELSE);
                    setState(288);
                    code_block();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(289);
                    match(TK_ELSE);
                    setState(290);
                    if_statement();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Switch_statementContext switch_statement() throws RecognitionException {
        Switch_statementContext _localctx = new Switch_statementContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_switch_statement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(293);
                match(TK_SWITCH);
                setState(294);
                expression(0);
                setState(295);
                match(T__0);
                setState(301);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == TK_CASE) {
                    {
                        {
                            setState(296);
                            case_label();
                            setState(297);
                            code_block();
                        }
                    }
                    setState(303);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(307);
                _la = _input.LA(1);
                if (_la == TK_DEFAULT) {
                    {
                        setState(304);
                        default_label();
                        setState(305);
                        code_block();
                    }
                }

                setState(309);
                match(T__1);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Case_labelContext case_label() throws RecognitionException {
        Case_labelContext _localctx = new Case_labelContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_case_label);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(311);
                match(TK_CASE);
                setState(312);
                integer_literal();
                setState(313);
                match(TK_COLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Default_labelContext default_label() throws RecognitionException {
        Default_labelContext _localctx = new Default_labelContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_default_label);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(315);
                match(TK_DEFAULT);
                setState(316);
                match(TK_COLON);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        return expression(0);
    }

    private ExpressionContext expression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
        ExpressionContext _prevctx = _localctx;
        int _startState = 66;
        enterRecursionRule(_localctx, 66, RULE_expression, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(414);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 39, _ctx)) {
                    case 1: {
                        _localctx = new FUNC_CALLContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(319);
                        match(TK_IDENT);
                        setState(320);
                        match(TK_PAR_LEFT);
                        setState(322);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_BOOL) | (1L << TK_STRING) | (1L << TK_DIC) | (1L << TK_TRUE) | (1L << TK_FALSE) | (1L << TK_COUNT) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << NOT))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LOCAL - 68)) | (1L << (TK_PAR_LEFT - 68)) | (1L << (TK_IDENT - 68)) | (1L << (Binary_literal - 68)) | (1L << (Octal_literal - 68)) | (1L << (Decimal_literal - 68)) | (1L << (Pure_decimal_digits - 68)) | (1L << (Hexadecimal_literal - 68)) | (1L << (Floating_point_literal - 68)) | (1L << (Static_string_literal - 68)))) != 0)) {
                            {
                                setState(321);
                                expression_list();
                            }
                        }

                        setState(324);
                        match(TK_PAR_RIGHT);
                    }
                    break;
                    case 2: {
                        _localctx = new COUNTContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(325);
                        match(TK_COUNT);
                        setState(326);
                        match(TK_PAR_LEFT);
                        setState(327);
                        expression(0);
                        setState(328);
                        match(TK_PAR_RIGHT);
                    }
                    break;
                    case 3: {
                        _localctx = new LOCAL_INFERContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(330);
                        match(LOCAL);
                        setState(331);
                        integer_literal();
                    }
                    break;
                    case 4: {
                        _localctx = new REFERENCEContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(332);
                        match(TK_IDENT);
                    }
                    break;
                    case 5: {
                        _localctx = new RANGE_OPContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(333);
                        range_ops();
                        setState(334);
                        _la = _input.LA(1);
                        if (!(_la == RANGE || _la == UPRANGE)) {
                            _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                        setState(335);
                        range_ops();
                    }
                    break;
                    case 6: {
                        _localctx = new UNARY_OPContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(337);
                        ((UNARY_OPContext) _localctx).op = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == ADD || _la == SUB)) {
                            ((UNARY_OPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                        setState(338);
                        expression(21);
                    }
                    break;
                    case 7: {
                        _localctx = new INC_DEC_RIGTHContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(339);
                        match(TK_IDENT);
                        setState(344);
                        _la = _input.LA(1);
                        if (_la == T__2) {
                            {
                                setState(340);
                                match(T__2);
                                setState(341);
                                expression(0);
                                setState(342);
                                match(T__3);
                            }
                        }

                        setState(346);
                        ((INC_DEC_RIGTHContext) _localctx).op = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == INC || _la == DEC)) {
                            ((INC_DEC_RIGTHContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                    }
                    break;
                    case 8: {
                        _localctx = new INC_DEC_LEFTContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(347);
                        ((INC_DEC_LEFTContext) _localctx).op = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == INC || _la == DEC)) {
                            ((INC_DEC_LEFTContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                        setState(348);
                        match(TK_IDENT);
                        setState(353);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 33, _ctx)) {
                            case 1: {
                                setState(349);
                                match(T__2);
                                setState(350);
                                expression(0);
                                setState(351);
                                match(T__3);
                            }
                            break;
                        }
                    }
                    break;
                    case 9: {
                        _localctx = new NOT_OPContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(355);
                        match(NOT);
                        setState(356);
                        expression(12);
                    }
                    break;
                    case 10: {
                        _localctx = new MUL_DIV_MOD_EQOPContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(357);
                        match(TK_IDENT);
                        setState(362);
                        _la = _input.LA(1);
                        if (_la == T__2) {
                            {
                                setState(358);
                                match(T__2);
                                setState(359);
                                expression(0);
                                setState(360);
                                match(T__3);
                            }
                        }

                        setState(364);
                        ((MUL_DIV_MOD_EQOPContext) _localctx).op = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (TIMESEQ - 64)) | (1L << (DIVEQ - 64)) | (1L << (MODEQ - 64)))) != 0))) {
                            ((MUL_DIV_MOD_EQOPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                        setState(365);
                        expression(11);
                    }
                    break;
                    case 11: {
                        _localctx = new AND_OR_EQOPContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(366);
                        match(TK_IDENT);
                        setState(371);
                        _la = _input.LA(1);
                        if (_la == T__2) {
                            {
                                setState(367);
                                match(T__2);
                                setState(368);
                                expression(0);
                                setState(369);
                                match(T__3);
                            }
                        }

                        setState(373);
                        ((AND_OR_EQOPContext) _localctx).op = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == ANDEQ || _la == OREQ)) {
                            ((AND_OR_EQOPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                        setState(374);
                        expression(10);
                    }
                    break;
                    case 12: {
                        _localctx = new PLUS_SUB_EQOPContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(375);
                        match(TK_IDENT);
                        setState(380);
                        _la = _input.LA(1);
                        if (_la == T__2) {
                            {
                                setState(376);
                                match(T__2);
                                setState(377);
                                expression(0);
                                setState(378);
                                match(T__3);
                            }
                        }

                        setState(382);
                        ((PLUS_SUB_EQOPContext) _localctx).op = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == PLUSEQ || _la == SUBEQ)) {
                            ((PLUS_SUB_EQOPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                        } else {
                            consume();
                        }
                        setState(383);
                        expression(9);
                    }
                    break;
                    case 13: {
                        _localctx = new NEW_ARRAYContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(384);
                        type(0);
                        setState(385);
                        match(T__2);
                        setState(386);
                        match(T__3);
                        setState(387);
                        match(TK_PAR_LEFT);
                        setState(392);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << TK_INT) | (1L << TK_FLOAT) | (1L << TK_BOOL) | (1L << TK_STRING) | (1L << TK_DIC) | (1L << TK_TRUE) | (1L << TK_FALSE) | (1L << TK_COUNT) | (1L << INC) | (1L << DEC) | (1L << ADD) | (1L << SUB) | (1L << NOT))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LOCAL - 68)) | (1L << (TK_PAR_LEFT - 68)) | (1L << (TK_IDENT - 68)) | (1L << (Binary_literal - 68)) | (1L << (Octal_literal - 68)) | (1L << (Decimal_literal - 68)) | (1L << (Pure_decimal_digits - 68)) | (1L << (Hexadecimal_literal - 68)) | (1L << (Floating_point_literal - 68)) | (1L << (Static_string_literal - 68)))) != 0)) {
                            {
                                setState(388);
                                expression(0);
                                setState(389);
                                match(TK_COMA);
                                setState(390);
                                expression(0);
                            }
                        }

                        setState(394);
                        match(TK_PAR_RIGHT);
                    }
                    break;
                    case 14: {
                        _localctx = new NEW_DICContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(396);
                        dic_type();
                        setState(397);
                        match(TK_PAR_LEFT);
                        setState(398);
                        match(TK_PAR_RIGHT);
                    }
                    break;
                    case 15: {
                        _localctx = new PARENTESISContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(400);
                        match(TK_PAR_LEFT);
                        setState(401);
                        expression(0);
                        setState(402);
                        match(TK_PAR_RIGHT);
                    }
                    break;
                    case 16: {
                        _localctx = new CTEContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(404);
                        literal();
                    }
                    break;
                    case 17: {
                        _localctx = new ASSIG_OPContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(405);
                        match(TK_IDENT);
                        setState(410);
                        _la = _input.LA(1);
                        if (_la == T__2) {
                            {
                                setState(406);
                                match(T__2);
                                setState(407);
                                expression(0);
                                setState(408);
                                match(T__3);
                            }
                        }

                        setState(412);
                        match(ASSIG);
                        setState(413);
                        expression(1);
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(460);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 41, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(458);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 40, _ctx)) {
                                case 1: {
                                    _localctx = new MUL_DIV_MOD_OPContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(416);
                                    if (!(precpred(_ctx, 18)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 18)");
                                    setState(417);
                                    ((MUL_DIV_MOD_OPContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0))) {
                                        ((MUL_DIV_MOD_OPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(418);
                                    expression(19);
                                }
                                break;
                                case 2: {
                                    _localctx = new ADD_SUB_OPContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(419);
                                    if (!(precpred(_ctx, 17)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 17)");
                                    setState(420);
                                    ((ADD_SUB_OPContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == ADD || _la == SUB)) {
                                        ((ADD_SUB_OPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(421);
                                    expression(18);
                                }
                                break;
                                case 3: {
                                    _localctx = new BINARY_OPContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(422);
                                    if (!(precpred(_ctx, 16)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 16)");
                                    setState(423);
                                    ((BINARY_OPContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANDB) | (1L << ORB) | (1L << XORB))) != 0))) {
                                        ((BINARY_OPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(424);
                                    expression(17);
                                }
                                break;
                                case 4: {
                                    _localctx = new EQ_DIST_OPContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(425);
                                    if (!(precpred(_ctx, 15)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 15)");
                                    setState(426);
                                    ((EQ_DIST_OPContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == EQ || _la == DISTINCT)) {
                                        ((EQ_DIST_OPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(427);
                                    expression(16);
                                }
                                break;
                                case 5: {
                                    _localctx = new COMP_OPContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(428);
                                    if (!(precpred(_ctx, 14)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 14)");
                                    setState(429);
                                    ((COMP_OPContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTE) | (1L << LTE) | (1L << GT) | (1L << LT))) != 0))) {
                                        ((COMP_OPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(430);
                                    expression(15);
                                }
                                break;
                                case 6: {
                                    _localctx = new AND_OR_OPContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(431);
                                    if (!(precpred(_ctx, 13)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 13)");
                                    setState(432);
                                    ((AND_OR_OPContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == AND || _la == OR)) {
                                        ((AND_OR_OPContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        consume();
                                    }
                                    setState(433);
                                    expression(14);
                                }
                                break;
                                case 7: {
                                    _localctx = new TERNARY_OPContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(434);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(435);
                                    match(T__5);
                                    setState(436);
                                    expression(0);
                                    setState(437);
                                    match(TK_COLON);
                                    setState(438);
                                    expression(9);
                                }
                                break;
                                case 8: {
                                    _localctx = new APPENDContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(440);
                                    if (!(precpred(_ctx, 26)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 26)");
                                    setState(441);
                                    match(T__4);
                                    setState(442);
                                    match(TK_CONCAT);
                                    setState(443);
                                    match(TK_PAR_LEFT);
                                    setState(444);
                                    expression(0);
                                    setState(445);
                                    match(TK_PAR_RIGHT);
                                }
                                break;
                                case 9: {
                                    _localctx = new INDX_REFERENCEContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(447);
                                    if (!(precpred(_ctx, 24)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 24)");
                                    {
                                        setState(448);
                                        match(T__2);
                                        setState(449);
                                        expression(0);
                                        setState(450);
                                        match(T__3);
                                    }
                                }
                                break;
                                case 10: {
                                    _localctx = new CAST_OPContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(452);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(453);
                                    match(TK_AS);
                                    setState(454);
                                    type(0);
                                }
                                break;
                                case 11: {
                                    _localctx = new CHECK_TYPE_OPContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(455);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(456);
                                    match(TK_IS);
                                    setState(457);
                                    type(0);
                                }
                                break;
                            }
                        }
                    }
                    setState(462);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 41, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final Range_opsContext range_ops() throws RecognitionException {
        Range_opsContext _localctx = new Range_opsContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_range_ops);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(464);
                _la = _input.LA(1);
                if (_la == SUB) {
                    {
                        setState(463);
                        match(SUB);
                    }
                }

                setState(466);
                integer_literal();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LiteralContext literal() throws RecognitionException {
        LiteralContext _localctx = new LiteralContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_literal);
        try {
            setState(473);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 43, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(468);
                    numeric_literal();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(469);
                    string_literal();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(470);
                    boolean_literal();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(471);
                    array_literal();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(472);
                    dic_literal();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Array_literalContext array_literal() throws RecognitionException {
        Array_literalContext _localctx = new Array_literalContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_array_literal);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(475);
                match(T__2);
                setState(476);
                expression_list();
                setState(477);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Dic_literalContext dic_literal() throws RecognitionException {
        Dic_literalContext _localctx = new Dic_literalContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_dic_literal);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(479);
                match(T__2);
                setState(480);
                dic_item_list();
                setState(481);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Dic_itemContext dic_item() throws RecognitionException {
        Dic_itemContext _localctx = new Dic_itemContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_dic_item);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(483);
                expression(0);
                setState(484);
                match(TK_COLON);
                setState(485);
                expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Dic_item_listContext dic_item_list() throws RecognitionException {
        Dic_item_listContext _localctx = new Dic_item_listContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_dic_item_list);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(487);
                dic_item();
                setState(492);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == TK_COMA) {
                    {
                        {
                            setState(488);
                            match(TK_COMA);
                            setState(489);
                            dic_item();
                        }
                    }
                    setState(494);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Numeric_literalContext numeric_literal() throws RecognitionException {
        Numeric_literalContext _localctx = new Numeric_literalContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_numeric_literal);
        try {
            setState(497);
            switch (_input.LA(1)) {
                case Binary_literal:
                case Octal_literal:
                case Decimal_literal:
                case Pure_decimal_digits:
                case Hexadecimal_literal:
                    _localctx = new CTE_INTContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(495);
                    integer_literal();
                }
                break;
                case Floating_point_literal:
                    _localctx = new CTE_FLOATContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(496);
                    match(Floating_point_literal);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Boolean_literalContext boolean_literal() throws RecognitionException {
        Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_boolean_literal);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(499);
                _la = _input.LA(1);
                if (!(_la == TK_TRUE || _la == TK_FALSE)) {
                    _errHandler.recoverInline(this);
                } else {
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Integer_literalContext integer_literal() throws RecognitionException {
        Integer_literalContext _localctx = new Integer_literalContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_integer_literal);
        try {
            setState(506);
            switch (_input.LA(1)) {
                case Binary_literal:
                    _localctx = new CTE_BINContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(501);
                    match(Binary_literal);
                }
                break;
                case Octal_literal:
                    _localctx = new CTE_OCTContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(502);
                    match(Octal_literal);
                }
                break;
                case Decimal_literal:
                    _localctx = new CTE_DECContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(503);
                    match(Decimal_literal);
                }
                break;
                case Pure_decimal_digits:
                    _localctx = new CTE_PURE_DECContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(504);
                    match(Pure_decimal_digits);
                }
                break;
                case Hexadecimal_literal:
                    _localctx = new CTE_HEXContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(505);
                    match(Hexadecimal_literal);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final String_literalContext string_literal() throws RecognitionException {
        String_literalContext _localctx = new String_literalContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_string_literal);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(508);
                match(Static_string_literal);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 16:
                return type_sempred((TypeContext) _localctx, predIndex);
            case 33:
                return expression_sempred((ExpressionContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean type_sempred(TypeContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 2);
        }
        return true;
    }

    private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 1:
                return precpred(_ctx, 18);
            case 2:
                return precpred(_ctx, 17);
            case 3:
                return precpred(_ctx, 16);
            case 4:
                return precpred(_ctx, 15);
            case 5:
                return precpred(_ctx, 14);
            case 6:
                return precpred(_ctx, 13);
            case 7:
                return precpred(_ctx, 8);
            case 8:
                return precpred(_ctx, 26);
            case 9:
                return precpred(_ctx, 24);
            case 10:
                return precpred(_ctx, 5);
            case 11:
                return precpred(_ctx, 4);
        }
        return true;
    }

    public static class Top_levelContext extends ParserRuleContext {
        public Top_levelContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StatementsContext statements() {
            return getRuleContext(StatementsContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(swiftParser.EOF, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_top_level;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitTop_level(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StatementsContext extends ParserRuleContext {
        public StatementsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public List<TerminalNode> TK_SEMI_COLON() {
            return getTokens(swiftParser.TK_SEMI_COLON);
        }

        public TerminalNode TK_SEMI_COLON(int i) {
            return getToken(swiftParser.TK_SEMI_COLON, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statements;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitStatements(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StatementContext extends ParserRuleContext {
        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StatementContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        public void copyFrom(StatementContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class PRINT_STContext extends StatementContext {
        public PRINT_STContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        public Print_callContext print_call() {
            return getRuleContext(Print_callContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitPRINT_ST(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CODE_BLK_STContext extends StatementContext {
        public CODE_BLK_STContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        public Code_blockContext code_block() {
            return getRuleContext(Code_blockContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCODE_BLK_ST(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CTRL_STContext extends StatementContext {
        public CTRL_STContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        public Control_transfer_statementContext control_transfer_statement() {
            return getRuleContext(Control_transfer_statementContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCTRL_ST(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FUNC_STContext extends StatementContext {
        public FUNC_STContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        public Function_callContext function_call() {
            return getRuleContext(Function_callContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitFUNC_ST(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BRANCH_STContext extends StatementContext {
        public BRANCH_STContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        public Branch_statementContext branch_statement() {
            return getRuleContext(Branch_statementContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitBRANCH_ST(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DEC_STContext extends StatementContext {
        public DEC_STContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        public DeclarationContext declaration() {
            return getRuleContext(DeclarationContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitDEC_ST(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LOOP_STContext extends StatementContext {
        public LOOP_STContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        public Loop_statementContext loop_statement() {
            return getRuleContext(Loop_statementContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitLOOP_ST(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EXP_STContext extends StatementContext {
        public EXP_STContext(StatementContext ctx) {
            copyFrom(ctx);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitEXP_ST(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Print_callContext extends ParserRuleContext {
        public Token op;

        public Print_callContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_PAR_LEFT() {
            return getToken(swiftParser.TK_PAR_LEFT, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode TK_PAR_RIGHT() {
            return getToken(swiftParser.TK_PAR_RIGHT, 0);
        }

        public TerminalNode TK_PRINT() {
            return getToken(swiftParser.TK_PRINT, 0);
        }

        public TerminalNode TK_PRINTLN() {
            return getToken(swiftParser.TK_PRINTLN, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_print_call;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitPrint_call(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Function_callContext extends ParserRuleContext {
        public Function_callContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public TerminalNode TK_PAR_LEFT() {
            return getToken(swiftParser.TK_PAR_LEFT, 0);
        }

        public TerminalNode TK_PAR_RIGHT() {
            return getToken(swiftParser.TK_PAR_RIGHT, 0);
        }

        public Expression_listContext expression_list() {
            return getRuleContext(Expression_listContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function_call;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitFunction_call(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Branch_statementContext extends ParserRuleContext {
        public Branch_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public If_statementContext if_statement() {
            return getRuleContext(If_statementContext.class, 0);
        }

        public Switch_statementContext switch_statement() {
            return getRuleContext(Switch_statementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_branch_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitBranch_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Control_transfer_statementContext extends ParserRuleContext {
        public Control_transfer_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Break_statementContext break_statement() {
            return getRuleContext(Break_statementContext.class, 0);
        }

        public Continue_statementContext continue_statement() {
            return getRuleContext(Continue_statementContext.class, 0);
        }

        public Return_statementContext return_statement() {
            return getRuleContext(Return_statementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_control_transfer_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitControl_transfer_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Break_statementContext extends ParserRuleContext {
        public Break_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_BREAK() {
            return getToken(swiftParser.TK_BREAK, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_break_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitBreak_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Continue_statementContext extends ParserRuleContext {
        public Continue_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_CONTINUE() {
            return getToken(swiftParser.TK_CONTINUE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_continue_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitContinue_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Return_statementContext extends ParserRuleContext {
        public Return_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_RETURN() {
            return getToken(swiftParser.TK_RETURN, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_return_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitReturn_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DeclarationContext extends ParserRuleContext {
        public DeclarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Variable_declarationContext variable_declaration() {
            return getRuleContext(Variable_declarationContext.class, 0);
        }

        public Constant_declarationContext constant_declaration() {
            return getRuleContext(Constant_declarationContext.class, 0);
        }

        public Function_declarationContext function_declaration() {
            return getRuleContext(Function_declarationContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_declaration;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitDeclaration(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Code_blockContext extends ParserRuleContext {
        public Code_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StatementsContext statements() {
            return getRuleContext(StatementsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_code_block;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCode_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Constant_declarationContext extends ParserRuleContext {
        public Constant_declarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_LET() {
            return getToken(swiftParser.TK_LET, 0);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public TerminalNode TK_COLON() {
            return getToken(swiftParser.TK_COLON, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constant_declaration;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitConstant_declaration(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Variable_declarationContext extends ParserRuleContext {
        public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_VAR() {
            return getToken(swiftParser.TK_VAR, 0);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public TerminalNode TK_COLON() {
            return getToken(swiftParser.TK_COLON, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variable_declaration;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitVariable_declaration(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Function_declarationContext extends ParserRuleContext {
        public Function_declarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_FUNCTION() {
            return getToken(swiftParser.TK_FUNCTION, 0);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public TerminalNode TK_PAR_LEFT() {
            return getToken(swiftParser.TK_PAR_LEFT, 0);
        }

        public TerminalNode TK_PAR_RIGHT() {
            return getToken(swiftParser.TK_PAR_RIGHT, 0);
        }

        public TerminalNode ARROW() {
            return getToken(swiftParser.ARROW, 0);
        }

        public Code_blockContext code_block() {
            return getRuleContext(Code_blockContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode TK_VOID() {
            return getToken(swiftParser.TK_VOID, 0);
        }

        public List<Func_parameterContext> func_parameter() {
            return getRuleContexts(Func_parameterContext.class);
        }

        public Func_parameterContext func_parameter(int i) {
            return getRuleContext(Func_parameterContext.class, i);
        }

        public List<TerminalNode> TK_COMA() {
            return getTokens(swiftParser.TK_COMA);
        }

        public TerminalNode TK_COMA(int i) {
            return getToken(swiftParser.TK_COMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function_declaration;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitFunction_declaration(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Func_parameterContext extends ParserRuleContext {
        public Token cons;

        public Func_parameterContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public TerminalNode TK_COLON() {
            return getToken(swiftParser.TK_COLON, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode TK_LET() {
            return getToken(swiftParser.TK_LET, 0);
        }

        public TerminalNode TK_VAR() {
            return getToken(swiftParser.TK_VAR, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_func_parameter;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitFunc_parameter(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TypeContext extends ParserRuleContext {
        public TypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_type;
        }

        public void copyFrom(TypeContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class Type_BOOLContext extends TypeContext {
        public Type_BOOLContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_BOOL() {
            return getToken(swiftParser.TK_BOOL, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitType_BOOL(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Type_FLOATContext extends TypeContext {
        public Type_FLOATContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_FLOAT() {
            return getToken(swiftParser.TK_FLOAT, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitType_FLOAT(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Type_INTContext extends TypeContext {
        public Type_INTContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_INT() {
            return getToken(swiftParser.TK_INT, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitType_INT(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Type_ARRAYContext extends TypeContext {
        public Type_ARRAYContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitType_ARRAY(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Type_STRINGContext extends TypeContext {
        public Type_STRINGContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_STRING() {
            return getToken(swiftParser.TK_STRING, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitType_STRING(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Type_DICContext extends TypeContext {
        public Type_DICContext(TypeContext ctx) {
            copyFrom(ctx);
        }

        public Dic_typeContext dic_type() {
            return getRuleContext(Dic_typeContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitType_DIC(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Dic_typeContext extends ParserRuleContext {
        public Dic_typeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_DIC() {
            return getToken(swiftParser.TK_DIC, 0);
        }

        public FtypeContext ftype() {
            return getRuleContext(FtypeContext.class, 0);
        }

        public TerminalNode TK_COMA() {
            return getToken(swiftParser.TK_COMA, 0);
        }

        public LtypeContext ltype() {
            return getRuleContext(LtypeContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dic_type;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitDic_type(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FtypeContext extends ParserRuleContext {
        public FtypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LT() {
            return getToken(swiftParser.LT, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ftype;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitFtype(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LtypeContext extends ParserRuleContext {
        public LtypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode GT() {
            return getToken(swiftParser.GT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ltype;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitLtype(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Loop_statementContext extends ParserRuleContext {
        public Loop_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public For_statementContext for_statement() {
            return getRuleContext(For_statementContext.class, 0);
        }

        public While_statementContext while_statement() {
            return getRuleContext(While_statementContext.class, 0);
        }

        public Do_statementContext do_statement() {
            return getRuleContext(Do_statementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_loop_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitLoop_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Do_statementContext extends ParserRuleContext {
        public Do_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_DO() {
            return getToken(swiftParser.TK_DO, 0);
        }

        public Code_blockContext code_block() {
            return getRuleContext(Code_blockContext.class, 0);
        }

        public TerminalNode TK_WHILE() {
            return getToken(swiftParser.TK_WHILE, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_do_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitDo_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class End_forContext extends ParserRuleContext {
        public End_forContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_end_for;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitEnd_for(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class For_statementContext extends ParserRuleContext {
        public For_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_FOR() {
            return getToken(swiftParser.TK_FOR, 0);
        }

        public Code_blockContext code_block() {
            return getRuleContext(Code_blockContext.class, 0);
        }

        public TerminalNode TK_PAR_LEFT() {
            return getToken(swiftParser.TK_PAR_LEFT, 0);
        }

        public List<TerminalNode> TK_SEMI_COLON() {
            return getTokens(swiftParser.TK_SEMI_COLON);
        }

        public TerminalNode TK_SEMI_COLON(int i) {
            return getToken(swiftParser.TK_SEMI_COLON, i);
        }

        public End_forContext end_for() {
            return getRuleContext(End_forContext.class, 0);
        }

        public TerminalNode TK_PAR_RIGHT() {
            return getToken(swiftParser.TK_PAR_RIGHT, 0);
        }

        public For_initContext for_init() {
            return getRuleContext(For_initContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_for_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitFor_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class For_initContext extends ParserRuleContext {
        public For_initContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Variable_declarationContext variable_declaration() {
            return getRuleContext(Variable_declarationContext.class, 0);
        }

        public Expression_listContext expression_list() {
            return getRuleContext(Expression_listContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_for_init;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitFor_init(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Expression_listContext extends ParserRuleContext {
        public Expression_listContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public List<TerminalNode> TK_COMA() {
            return getTokens(swiftParser.TK_COMA);
        }

        public TerminalNode TK_COMA(int i) {
            return getToken(swiftParser.TK_COMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression_list;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitExpression_list(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class While_statementContext extends ParserRuleContext {
        public While_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_WHILE() {
            return getToken(swiftParser.TK_WHILE, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Code_blockContext code_block() {
            return getRuleContext(Code_blockContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_while_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitWhile_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Where_clauseContext extends ParserRuleContext {
        public Where_clauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_WHERE() {
            return getToken(swiftParser.TK_WHERE, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_where_clause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitWhere_clause(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class If_statementContext extends ParserRuleContext {
        public If_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_IF() {
            return getToken(swiftParser.TK_IF, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Code_blockContext code_block() {
            return getRuleContext(Code_blockContext.class, 0);
        }

        public Else_clauseContext else_clause() {
            return getRuleContext(Else_clauseContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_if_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitIf_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Else_clauseContext extends ParserRuleContext {
        public Else_clauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_ELSE() {
            return getToken(swiftParser.TK_ELSE, 0);
        }

        public Code_blockContext code_block() {
            return getRuleContext(Code_blockContext.class, 0);
        }

        public If_statementContext if_statement() {
            return getRuleContext(If_statementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_else_clause;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitElse_clause(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Switch_statementContext extends ParserRuleContext {
        public Switch_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_SWITCH() {
            return getToken(swiftParser.TK_SWITCH, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public List<Case_labelContext> case_label() {
            return getRuleContexts(Case_labelContext.class);
        }

        public Case_labelContext case_label(int i) {
            return getRuleContext(Case_labelContext.class, i);
        }

        public List<Code_blockContext> code_block() {
            return getRuleContexts(Code_blockContext.class);
        }

        public Code_blockContext code_block(int i) {
            return getRuleContext(Code_blockContext.class, i);
        }

        public Default_labelContext default_label() {
            return getRuleContext(Default_labelContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_switch_statement;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitSwitch_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Case_labelContext extends ParserRuleContext {
        public Case_labelContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_CASE() {
            return getToken(swiftParser.TK_CASE, 0);
        }

        public Integer_literalContext integer_literal() {
            return getRuleContext(Integer_literalContext.class, 0);
        }

        public TerminalNode TK_COLON() {
            return getToken(swiftParser.TK_COLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_case_label;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCase_label(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Default_labelContext extends ParserRuleContext {
        public Default_labelContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_DEFAULT() {
            return getToken(swiftParser.TK_DEFAULT, 0);
        }

        public TerminalNode TK_COLON() {
            return getToken(swiftParser.TK_COLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_default_label;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitDefault_label(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        public void copyFrom(ExpressionContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class CHECK_TYPE_OPContext extends ExpressionContext {
        public CHECK_TYPE_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode TK_IS() {
            return getToken(swiftParser.TK_IS, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCHECK_TYPE_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CAST_OPContext extends ExpressionContext {
        public CAST_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode TK_AS() {
            return getToken(swiftParser.TK_AS, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCAST_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class NEW_DICContext extends ExpressionContext {
        public NEW_DICContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public Dic_typeContext dic_type() {
            return getRuleContext(Dic_typeContext.class, 0);
        }

        public TerminalNode TK_PAR_LEFT() {
            return getToken(swiftParser.TK_PAR_LEFT, 0);
        }

        public TerminalNode TK_PAR_RIGHT() {
            return getToken(swiftParser.TK_PAR_RIGHT, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitNEW_DIC(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MUL_DIV_MOD_EQOPContext extends ExpressionContext {
        public Token op;

        public MUL_DIV_MOD_EQOPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode TIMESEQ() {
            return getToken(swiftParser.TIMESEQ, 0);
        }

        public TerminalNode DIVEQ() {
            return getToken(swiftParser.DIVEQ, 0);
        }

        public TerminalNode MODEQ() {
            return getToken(swiftParser.MODEQ, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitMUL_DIV_MOD_EQOP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BINARY_OPContext extends ExpressionContext {
        public Token op;

        public BINARY_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode ANDB() {
            return getToken(swiftParser.ANDB, 0);
        }

        public TerminalNode XORB() {
            return getToken(swiftParser.XORB, 0);
        }

        public TerminalNode ORB() {
            return getToken(swiftParser.ORB, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitBINARY_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class INDX_REFERENCEContext extends ExpressionContext {
        public INDX_REFERENCEContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitINDX_REFERENCE(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AND_OR_OPContext extends ExpressionContext {
        public Token op;

        public AND_OR_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode AND() {
            return getToken(swiftParser.AND, 0);
        }

        public TerminalNode OR() {
            return getToken(swiftParser.OR, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitAND_OR_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TERNARY_OPContext extends ExpressionContext {
        public TERNARY_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode TK_COLON() {
            return getToken(swiftParser.TK_COLON, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitTERNARY_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PLUS_SUB_EQOPContext extends ExpressionContext {
        public Token op;

        public PLUS_SUB_EQOPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode PLUSEQ() {
            return getToken(swiftParser.PLUSEQ, 0);
        }

        public TerminalNode SUBEQ() {
            return getToken(swiftParser.SUBEQ, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitPLUS_SUB_EQOP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class UNARY_OPContext extends ExpressionContext {
        public Token op;

        public UNARY_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode SUB() {
            return getToken(swiftParser.SUB, 0);
        }

        public TerminalNode ADD() {
            return getToken(swiftParser.ADD, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitUNARY_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class REFERENCEContext extends ExpressionContext {
        public REFERENCEContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitREFERENCE(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ADD_SUB_OPContext extends ExpressionContext {
        public Token op;

        public ADD_SUB_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode ADD() {
            return getToken(swiftParser.ADD, 0);
        }

        public TerminalNode SUB() {
            return getToken(swiftParser.SUB, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitADD_SUB_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PARENTESISContext extends ExpressionContext {
        public PARENTESISContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_PAR_LEFT() {
            return getToken(swiftParser.TK_PAR_LEFT, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode TK_PAR_RIGHT() {
            return getToken(swiftParser.TK_PAR_RIGHT, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitPARENTESIS(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class INC_DEC_LEFTContext extends ExpressionContext {
        public Token op;

        public INC_DEC_LEFTContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public TerminalNode INC() {
            return getToken(swiftParser.INC, 0);
        }

        public TerminalNode DEC() {
            return getToken(swiftParser.DEC, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitINC_DEC_LEFT(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AND_OR_EQOPContext extends ExpressionContext {
        public Token op;

        public AND_OR_EQOPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode ANDEQ() {
            return getToken(swiftParser.ANDEQ, 0);
        }

        public TerminalNode OREQ() {
            return getToken(swiftParser.OREQ, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitAND_OR_EQOP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class COMP_OPContext extends ExpressionContext {
        public Token op;

        public COMP_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode GT() {
            return getToken(swiftParser.GT, 0);
        }

        public TerminalNode GTE() {
            return getToken(swiftParser.GTE, 0);
        }

        public TerminalNode LT() {
            return getToken(swiftParser.LT, 0);
        }

        public TerminalNode LTE() {
            return getToken(swiftParser.LTE, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCOMP_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class NEW_ARRAYContext extends ExpressionContext {
        public NEW_ARRAYContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode TK_PAR_LEFT() {
            return getToken(swiftParser.TK_PAR_LEFT, 0);
        }

        public TerminalNode TK_PAR_RIGHT() {
            return getToken(swiftParser.TK_PAR_RIGHT, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode TK_COMA() {
            return getToken(swiftParser.TK_COMA, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitNEW_ARRAY(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MUL_DIV_MOD_OPContext extends ExpressionContext {
        public Token op;

        public MUL_DIV_MOD_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode MUL() {
            return getToken(swiftParser.MUL, 0);
        }

        public TerminalNode DIV() {
            return getToken(swiftParser.DIV, 0);
        }

        public TerminalNode MOD() {
            return getToken(swiftParser.MOD, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitMUL_DIV_MOD_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class APPENDContext extends ExpressionContext {
        public APPENDContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode TK_CONCAT() {
            return getToken(swiftParser.TK_CONCAT, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitAPPEND(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EQ_DIST_OPContext extends ExpressionContext {
        public Token op;

        public EQ_DIST_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode EQ() {
            return getToken(swiftParser.EQ, 0);
        }

        public TerminalNode DISTINCT() {
            return getToken(swiftParser.DISTINCT, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitEQ_DIST_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CTEContext extends ExpressionContext {
        public CTEContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public LiteralContext literal() {
            return getRuleContext(LiteralContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCTE(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FUNC_CALLContext extends ExpressionContext {
        public FUNC_CALLContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public TerminalNode TK_PAR_LEFT() {
            return getToken(swiftParser.TK_PAR_LEFT, 0);
        }

        public TerminalNode TK_PAR_RIGHT() {
            return getToken(swiftParser.TK_PAR_RIGHT, 0);
        }

        public Expression_listContext expression_list() {
            return getRuleContext(Expression_listContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitFUNC_CALL(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class NOT_OPContext extends ExpressionContext {
        public NOT_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode NOT() {
            return getToken(swiftParser.NOT, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitNOT_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LOCAL_INFERContext extends ExpressionContext {
        public LOCAL_INFERContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LOCAL() {
            return getToken(swiftParser.LOCAL, 0);
        }

        public Integer_literalContext integer_literal() {
            return getRuleContext(Integer_literalContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitLOCAL_INFER(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class COUNTContext extends ExpressionContext {
        public COUNTContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_COUNT() {
            return getToken(swiftParser.TK_COUNT, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCOUNT(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class RANGE_OPContext extends ExpressionContext {
        public RANGE_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<Range_opsContext> range_ops() {
            return getRuleContexts(Range_opsContext.class);
        }

        public Range_opsContext range_ops(int i) {
            return getRuleContext(Range_opsContext.class, i);
        }

        public TerminalNode UPRANGE() {
            return getToken(swiftParser.UPRANGE, 0);
        }

        public TerminalNode RANGE() {
            return getToken(swiftParser.RANGE, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitRANGE_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ASSIG_OPContext extends ExpressionContext {
        public ASSIG_OPContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public TerminalNode ASSIG() {
            return getToken(swiftParser.ASSIG, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitASSIG_OP(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class INC_DEC_RIGTHContext extends ExpressionContext {
        public Token op;

        public INC_DEC_RIGTHContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TK_IDENT() {
            return getToken(swiftParser.TK_IDENT, 0);
        }

        public TerminalNode INC() {
            return getToken(swiftParser.INC, 0);
        }

        public TerminalNode DEC() {
            return getToken(swiftParser.DEC, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitINC_DEC_RIGTH(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Range_opsContext extends ParserRuleContext {
        public Range_opsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Integer_literalContext integer_literal() {
            return getRuleContext(Integer_literalContext.class, 0);
        }

        public TerminalNode SUB() {
            return getToken(swiftParser.SUB, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_range_ops;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitRange_ops(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LiteralContext extends ParserRuleContext {
        public LiteralContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Numeric_literalContext numeric_literal() {
            return getRuleContext(Numeric_literalContext.class, 0);
        }

        public String_literalContext string_literal() {
            return getRuleContext(String_literalContext.class, 0);
        }

        public Boolean_literalContext boolean_literal() {
            return getRuleContext(Boolean_literalContext.class, 0);
        }

        public Array_literalContext array_literal() {
            return getRuleContext(Array_literalContext.class, 0);
        }

        public Dic_literalContext dic_literal() {
            return getRuleContext(Dic_literalContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_literal;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitLiteral(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Array_literalContext extends ParserRuleContext {
        public Array_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Expression_listContext expression_list() {
            return getRuleContext(Expression_listContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_array_literal;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitArray_literal(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Dic_literalContext extends ParserRuleContext {
        public Dic_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Dic_item_listContext dic_item_list() {
            return getRuleContext(Dic_item_listContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dic_literal;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitDic_literal(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Dic_itemContext extends ParserRuleContext {
        public Dic_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode TK_COLON() {
            return getToken(swiftParser.TK_COLON, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dic_item;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitDic_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Dic_item_listContext extends ParserRuleContext {
        public Dic_item_listContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<Dic_itemContext> dic_item() {
            return getRuleContexts(Dic_itemContext.class);
        }

        public Dic_itemContext dic_item(int i) {
            return getRuleContext(Dic_itemContext.class, i);
        }

        public List<TerminalNode> TK_COMA() {
            return getTokens(swiftParser.TK_COMA);
        }

        public TerminalNode TK_COMA(int i) {
            return getToken(swiftParser.TK_COMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dic_item_list;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitDic_item_list(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Numeric_literalContext extends ParserRuleContext {
        public Numeric_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Numeric_literalContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_numeric_literal;
        }

        public void copyFrom(Numeric_literalContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class CTE_INTContext extends Numeric_literalContext {
        public CTE_INTContext(Numeric_literalContext ctx) {
            copyFrom(ctx);
        }

        public Integer_literalContext integer_literal() {
            return getRuleContext(Integer_literalContext.class, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCTE_INT(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CTE_FLOATContext extends Numeric_literalContext {
        public CTE_FLOATContext(Numeric_literalContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode Floating_point_literal() {
            return getToken(swiftParser.Floating_point_literal, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCTE_FLOAT(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Boolean_literalContext extends ParserRuleContext {
        public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TK_TRUE() {
            return getToken(swiftParser.TK_TRUE, 0);
        }

        public TerminalNode TK_FALSE() {
            return getToken(swiftParser.TK_FALSE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_boolean_literal;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor)
                return ((swiftVisitor<? extends T>) visitor).visitBoolean_literal(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class Integer_literalContext extends ParserRuleContext {
        public Integer_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public Integer_literalContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_integer_literal;
        }

        public void copyFrom(Integer_literalContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class CTE_HEXContext extends Integer_literalContext {
        public CTE_HEXContext(Integer_literalContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode Hexadecimal_literal() {
            return getToken(swiftParser.Hexadecimal_literal, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCTE_HEX(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CTE_OCTContext extends Integer_literalContext {
        public CTE_OCTContext(Integer_literalContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode Octal_literal() {
            return getToken(swiftParser.Octal_literal, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCTE_OCT(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CTE_DECContext extends Integer_literalContext {
        public CTE_DECContext(Integer_literalContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode Decimal_literal() {
            return getToken(swiftParser.Decimal_literal, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCTE_DEC(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CTE_PURE_DECContext extends Integer_literalContext {
        public CTE_PURE_DECContext(Integer_literalContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode Pure_decimal_digits() {
            return getToken(swiftParser.Pure_decimal_digits, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCTE_PURE_DEC(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CTE_BINContext extends Integer_literalContext {
        public CTE_BINContext(Integer_literalContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode Binary_literal() {
            return getToken(swiftParser.Binary_literal, 0);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitCTE_BIN(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class String_literalContext extends ParserRuleContext {
        public String_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Static_string_literal() {
            return getToken(swiftParser.Static_string_literal, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string_literal;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof swiftVisitor) return ((swiftVisitor<? extends T>) visitor).visitString_literal(this);
            else return visitor.visitChildren(this);
        }
    }
}