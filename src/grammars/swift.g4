grammar swift;

top_level : statements EOF
          ;

statements: (statement TK_SEMI_COLON?)*
          ;

statement :     expression                         #EXP_ST
               |declaration                        #DEC_ST
               |loop_statement                     #LOOP_ST
               |branch_statement                   #BRANCH_ST
               |control_transfer_statement         #CTRL_ST
               |print_call                         #PRINT_ST
               |function_call                      #FUNC_ST  //falta
               |code_block                         #CODE_BLK_ST
          ;

print_call: op=(TK_PRINT | TK_PRINTLN)  TK_PAR_LEFT expression TK_PAR_RIGHT;

function_call: TK_IDENT TK_PAR_LEFT expression_list?TK_PAR_RIGHT;

branch_statement :   if_statement
                   | switch_statement
 ;



control_transfer_statement :
     break_statement
  | continue_statement
  | return_statement
  ;

break_statement : TK_BREAK;

continue_statement: TK_CONTINUE ;

return_statement: TK_RETURN expression?;

declaration : variable_declaration
            | constant_declaration
            | function_declaration
            ;

code_block : '{' statements '}';

constant_declaration : TK_LET TK_IDENT (TK_COLON type)? ('=' expression)?
                     ;
variable_declaration : TK_VAR TK_IDENT (TK_COLON type)? ('=' expression)?
                     ;
function_declaration: TK_FUNCTION TK_IDENT TK_PAR_LEFT (func_parameter (TK_COMA func_parameter)*)? TK_PAR_RIGHT ARROW (type|TK_VOID) code_block ;

func_parameter : cons=(TK_LET | TK_VAR)?  TK_IDENT  TK_COLON  type;

type :   TK_INT                                   #Type_INT
        | TK_FLOAT                                #Type_FLOAT
        | TK_BOOL                                 #Type_BOOL
        | TK_STRING                               #Type_STRING
        | type'['']'                              #Type_ARRAY
        | dic_type                                #Type_DIC
     ;

dic_type: TK_DIC ftype TK_COMA ltype;

ftype: LT type;

ltype: type GT;

loop_statement :    for_statement
                    |while_statement
                    |do_statement
                    ;

do_statement :     TK_DO code_block TK_WHILE expression
;

end_for:  expression?
                    ;

for_statement:      TK_FOR (TK_PAR_LEFT for_init? TK_SEMI_COLON expression? TK_SEMI_COLON end_for TK_PAR_RIGHT| for_init? TK_SEMI_COLON expression? TK_SEMI_COLON end_for) code_block
                   ;

for_init : variable_declaration | expression_list
;

expression_list : expression (TK_COMA expression)* ;


while_statement : TK_WHILE expression code_block

;

where_clause : TK_WHERE expression ;

if_statement : TK_IF expression code_block else_clause? ;

else_clause : TK_ELSE code_block | TK_ELSE if_statement  ;

switch_statement : TK_SWITCH expression '{' (case_label code_block)* (default_label code_block)? '}'  ;

case_label : TK_CASE integer_literal  TK_COLON  ;

default_label : TK_DEFAULT  TK_COLON  ;

expression: TK_IDENT TK_PAR_LEFT expression_list?TK_PAR_RIGHT                                       #FUNC_CALL
            |TK_COUNT '(' expression')'                                                             #COUNT
            |expression '.' TK_CONCAT '('expression')'                                              #APPEND
            |LOCAL integer_literal                                                                  #LOCAL_INFER
            |expression ('[' expression ']')                                                        #INDX_REFERENCE
            |TK_IDENT                                                                               #REFERENCE
            |range_ops (UPRANGE | RANGE) range_ops                                                  #RANGE_OP
            |op=(SUB|ADD) expression                                                                #UNARY_OP
            |TK_IDENT('['expression']')? op=(INC | DEC)                                             #INC_DEC_RIGTH
            |op=(INC|DEC) TK_IDENT ('['expression']')?                                              #INC_DEC_LEFT
            |expression op=(MUL | DIV | MOD) expression                                             #MUL_DIV_MOD_OP
            |expression op=(ADD | SUB) expression                                                   #ADD_SUB_OP
            |expression op=(ANDB | XORB | ORB ) expression                                          #BINARY_OP
            |expression op=(EQ | DISTINCT) expression                                               #EQ_DIST_OP //TODO Por hacer
            |expression op=(GT | GTE | LT | LTE) expression                                         #COMP_OP
            |expression op=(AND | OR) expression                                                    #AND_OR_OP
            |NOT expression                                                                         #NOT_OP
            |TK_IDENT ('['expression']')? op=(TIMESEQ | DIVEQ |MODEQ) expression                    #MUL_DIV_MOD_EQOP
            |TK_IDENT ('['expression']')? op=(ANDEQ | OREQ) expression                              #AND_OR_EQOP
            |TK_IDENT ('['expression']')? op=(PLUSEQ | SUBEQ) expression                            #PLUS_SUB_EQOP
            |expression'?'expression TK_COLON expression                                            #TERNARY_OP
            |type'['']' TK_PAR_LEFT (expression TK_COMA expression)?TK_PAR_RIGHT                    #NEW_ARRAY
            |dic_type  TK_PAR_LEFT TK_PAR_RIGHT                                                     #NEW_DIC
            |expression TK_AS type                                                                  #CAST_OP
            |expression TK_IS type                                                                  #CHECK_TYPE_OP
            | TK_PAR_LEFT  expression TK_PAR_RIGHT                                                  #PARENTESIS
            |literal                                                                                #CTE
            |TK_IDENT ('['expression']')? ASSIG expression                                          #ASSIG_OP
            ;

range_ops: SUB? integer_literal;

literal :     numeric_literal
            | string_literal
            | boolean_literal
            | array_literal
            | dic_literal  ;

array_literal: '[' expression_list ']';

dic_literal:  '[' dic_item_list ']' ;

dic_item: expression TK_COLON expression;

dic_item_list: dic_item (TK_COMA dic_item)* ;

numeric_literal
 : integer_literal                                                      #CTE_INT
 | Floating_point_literal                                               #CTE_FLOAT
 ;

boolean_literal : TK_TRUE | TK_FALSE ;

// GRAMMAR OF AN INTEGER LITERAL
integer_literal
 : Binary_literal                                                        #CTE_BIN
 | Octal_literal                                                         #CTE_OCT
 | Decimal_literal                                                       #CTE_DEC
 | Pure_decimal_digits                                                   #CTE_PURE_DEC
 | Hexadecimal_literal                                                   #CTE_HEX
 ;
 string_literal: Static_string_literal;
 //char_literal: '\''.'\''                                         #CTE_CHAR            ;
 //TOKENS
TK_BREAK:'break';
TK_CONTINUE:'continue' ;
TK_LET :'let';
TK_VAR: 'var';
TK_COLON:':';
TK_SEMI_COLON:';';
TK_INT:'Int'|'int';
TK_FLOAT:'Float'|'float';
TK_DOUBLE:'Double'|'double';
//TK_CHAR: 'Char' | 'char';
TK_BOOL:'Bool'|'bool';
TK_STRING:'String';
TK_DIC: 'Dictionary';
TK_ARRAY: 'Array';
TK_VOID:'Void';
// TK_OPTIONAL:;
TK_TRUE:'true';
TK_FALSE:'false';
TK_WHERE:'where';
TK_IF:'if';
TK_ELSE:'else';
TK_SWITCH:'switch';
TK_COUNT: 'count';
TK_CONCAT: 'concat';
/*****************************************/
//Loops
TK_DO:'do';
TK_WHILE :'while';
TK_FOR:'for';
TK_IN:'in';
TK_CASE:'case';
TK_DEFAULT:'default';
TK_AS:'as';
TK_IS:'is';
/*******************************************/

TK_FUNCTION: 'func';
// Operadores
INC : '++';
DEC : '--';
ARROW:'->';
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
MOD : '%' ;
RANGE : '..';
UPRANGE: '...';
//Logical
AND:'&&';
OR:'||';
NOT:'!';
//BitwiseOperators
ANDB:'&';
ORB:'|';
XORB:'^';
//Comparations
EQ  : '==';
DISTINCT:'!=';
GTE:'>=';
LTE:'<=';
GT:'>';
LT:'<';
//Assignemet Operators
ASSIG:'=';
ANDEQ:'&=';
OREQ : '|=';
PLUSEQ:'+=';
TIMESEQ:'*=';
SUBEQ:'-=';
DIVEQ:'/=';
MODEQ:'%=';
LOCAL:'$';

TK_PAR_RIGHT: ')';
TK_PAR_LEFT: '(';
TK_RETURN: 'return';
TK_PRINT: 'print';
TK_PRINTLN: 'println';
TK_COMA:',';
TK_IDENT :  TK_LETRA (TK_LETRA|Decimal_digit)* ;
fragment TK_LETRA : [a-zA-Z]|'_';


// Fragment
Binary_literal : '0b' Binary_digit Binary_literal_characters? ;
fragment Binary_digit : [01] ;
fragment Binary_literal_character : Binary_digit | '_'  ;
fragment Binary_literal_characters : Binary_literal_character+ ;

Octal_literal : '0o' Octal_digit Octal_literal_characters? ;
fragment Octal_digit : [0-7] ;
fragment Octal_literal_character : Octal_digit | '_'  ;
fragment Octal_literal_characters : Octal_literal_character+ ;

Decimal_literal		: [0-9] [0-9_]* ;
Pure_decimal_digits : [0-9]+ ;
fragment Decimal_digit : [0-9] ;
fragment Decimal_literal_character : Decimal_digit | '_'  ;
fragment Decimal_literal_characters : Decimal_literal_character+ ;

Hexadecimal_literal : '0x' Hexadecimal_digit Hexadecimal_literal_characters? ;
fragment Hexadecimal_digit : [0-9a-fA-F] ;
fragment Hexadecimal_literal_character : Hexadecimal_digit | '_'  ;
fragment Hexadecimal_literal_characters : Hexadecimal_literal_character+ ;

// GRAMMAR OF A FLOATING_POINT LITERAL

Floating_point_literal: Decimal_literal Decimal_fraction? Decimal_exponent?;

fragment Decimal_fraction : '.' Decimal_literal ;
fragment Decimal_exponent : Floating_point_e Sign? Decimal_literal ;
fragment Hexadecimal_fraction : '.' Hexadecimal_digit Hexadecimal_literal_characters? ;
fragment Hexadecimal_exponent : Floating_point_p Sign? Decimal_literal ;
fragment Floating_point_e : [eE] ;
fragment Floating_point_p : [pP] ;
fragment Sign : [+\-] ;

// GRAMMAR OF A STRING LITERAL

Static_string_literal : '"' Quoted_text? '"' ;
fragment Quoted_text : Quoted_text_item+ ;
fragment Quoted_text_item
  : Escaped_character
  | ~["\n\r\\]
  ;
fragment
Escaped_character
  : '\\' [0\\tnr"']
  | '\\x' Hexadecimal_digit Hexadecimal_digit
  | '\\u' '{' Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit '}'
  | '\\u' '{'
 Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit
 Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit Hexadecimal_digit
 '}'
  ;

WS : [ \n\r\t\u000B\u000C\u0000]+				-> channel(HIDDEN) ;
Block_comment : '/*' (Block_comment|.)*? '*/'	-> channel(HIDDEN) ; // nesting comments allowed
Line_comment : '//' .*? ('\n'|EOF)				-> channel(HIDDEN) ;