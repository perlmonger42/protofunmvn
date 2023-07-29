lexer grammar ProtofunLexer;
WS : [ \r\n\t]+ -> skip ;
PRINT: 'print' ;
L_PAREN: '(' ;
REAL_LITERAL : '-'? [0-9]+ '.' [0-9]+ ;
INTEGER_LITERAL : '-'? [0-9]+ ;
R_PAREN: ')' ;
ACCUMULATION_OP : '+' | '-' ;
MULOP : '*' | '/' | '%' ;

ASSIGNMENT_OP: ':=' ;
VAR: 'var ' ;
ALGORITHM: 'algorithm' ;
TYPE: 'Int' | 'Float';
IDENTIFIER: [a-zA-Z][a-zA-Z0-9_-]* ;
CLOSE_CURLY_BRACE: '}';
OPEN_CURLY_BRACE: '{';
BLOCK_COMMENT: '/*' .*? '*/' -> skip ;
COMMENT: '//' .*? [\n] -> skip ; // TODO: Handle EOF
COLON: ':';

