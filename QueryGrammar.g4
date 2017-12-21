grammar QueryGrammar;

@header {
package ca.ece.ubc.cpen221.mp5;
}	

//Terminals: Lexer
OR  : '||';
AND  : '&&';
INEQ : GT|GTE|LT|LTE|EQ; 
GT  : '>';
GTE  : '>=';
LT  : '<';
LTE  : '<=';
EQ  : '=';
NUM  : [1-5]+;

LPAREN  : '(';
RPAREN  : ')';
WORD  :  [a-zA-Z0-9]+;
SYMBOLS  :  '\''|'/'|'('|')'|'-'|'&'|'.';
WS  : (' '|'\t'|'\r'|'\n')+;

//Non-terminals: Parser
root  :  orExpr EOF;

orExpr : andExpr WS? (WS? OR andExpr)*;
andExpr  : WS? atom WS? (WS? AND WS? atom)*;
atom  : in|category|rating|price|name|(LPAREN orExpr RPAREN);

in  : 'in' WS? LPAREN string RPAREN; 
category  : 'category' WS? LPAREN string RPAREN;
name  : 'name' WS? LPAREN string RPAREN;
rating  : 'rating' WS? INEQ WS? NUM; 
price  : 'price' WS? INEQ WS? NUM; 

string  : ((WS? WORD WS?)+ (WS? SYMBOLS|LPAREN|RPAREN WS? WORD* WS? (SYMBOLS|LPAREN|RPAREN)* WS?)*)+;
