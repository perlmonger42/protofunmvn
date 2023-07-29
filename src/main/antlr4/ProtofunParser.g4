parser grammar ProtofunParser;

options {tokenVocab=ProtofunLexer;}

start: ALGORITHM IDENTIFIER block EOF;
block : OPEN_CURLY_BRACE statement* CLOSE_CURLY_BRACE ;
statement : assignment | variableDeclaration | print ;
variableDeclaration: VAR IDENTIFIER COLON TYPE ASSIGNMENT_OP expr;
assignment: IDENTIFIER ASSIGNMENT_OP expr;
print: PRINT L_PAREN expr R_PAREN ;
expr: expr MULOP expr
   | expr ACCUMULATION_OP expr
   | L_PAREN expr R_PAREN
   | REAL_LITERAL
   | INTEGER_LITERAL
   | IDENTIFIER
   ;
