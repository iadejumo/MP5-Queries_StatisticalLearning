grammar QueryGrammar;

@header {
package ca.ece.ubc.cpen221.mp5;
}

orExpr : andExpr (WS? OR andExpr)*;
andExpr  : WS? atom (WS? AND WS? atom)*;
atom  : in |category|rating|price|name|LPAREN orExpr RPAREN;
OR  : '||';
AND  : '&&';
INEQ : GT|GTE|LT|LTE|EQ; 
GT  : '>';
GTE  : '>=';
LT  : '<';
LTE  : '<=';
EQ  : '=';
NUM  : [1-5]+;
in  : 'in' LPAREN string RPAREN; 
category  : 'category' WS? LPAREN string RPAREN; 
name  : 'name' WS? LPAREN string RPAREN;
rating  : 'rating' WS? INEQ WS? NUM; 
price  : 'price' WS? INEQ WS? NUM; 
LPAREN  : '(';
RPAREN  : ')';
//WORD  :  [a-zA-Z]+[0-9]?.?;
//string  : (WORD+ WS?)+;
string  : .+;
WS  : ' ';