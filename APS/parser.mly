%{
open Ast
%}

%token LCROC RCROC LPAR RPAR SEMICOLON COMMA COLONS ASTERISK ARROW
%token NOT AND OR EQ LT ADD SUB MUL DIV
%token INT BOOL
%token IF CONST FUN REC ECHO
%token TRUE FALSE
%token <int> NUM
%token <string> IDENT
%token EOL

%start prog			/* the entry point */

%type <Ast.prog> prog

%%

prog:
	  LCROC cmds RCROC 		{ $2 }
	;

cmds:
	  stat 						{ [ASTstat($1)] }
	| dec SEMICOLON cmds 		{ ASTdec($1)::$3 }
	| stat SEMICOLON cmds 		{ ASTstat($1)::$3 }
	;

dec:
	  CONST IDENT tyype expr 						{ ASTconst($2, $3, $4) }
	| FUN IDENT tyype LCROC args RCROC expr 		{ ASTfun($2, $3, $5, $7) }
	| FUN REC IDENT tyype LCROC args RCROC expr 	{ ASTfunrec($3, $4, $6, $8) }

stat:
	  ECHO expr 		{ ASTecho($2) }
	;

expr:
	  TRUE 								{ ASTbool(Ast.True) }
	| FALSE 							{ ASTbool(Ast.False) }
	| NUM 								{ ASTnum($1) }
	| IDENT 							{ ASTid($1) }
	| LPAR IF expr expr expr RPAR 		{ ASTif($3, $4, $5) }
	| LPAR NOT expr RPAR 				{ Todo }
	| LPAR AND expr expr RPAR 			{ Todo }
	| LPAR OR expr expr RPAR 			{ Todo }
	| LPAR EQ expr expr RPAR 			{ Todo }
	| LPAR LT expr expr RPAR 			{ Todo }
	| LPAR ADD expr expr RPAR 			{ ASToprim(Ast.Add, $3, $4) }
	| LPAR SUB expr expr RPAR 			{ ASToprim(Ast.Sub, $3, $4) }
	| LPAR MUL expr expr RPAR 			{ ASToprim(Ast.Mul, $3, $4) }
	| LPAR DIV expr expr RPAR 			{ ASToprim(Ast.Div, $3, $4) }
	| LCROC args RCROC expr 			{ Todo }
	| LPAR expr exprs RPAR 				{ Todo }
	;

exprs:
	  expr 				{ Todo }
	| expr exprs 		{ Todo }

arg:
	  IDENT COLONS tyype 	{ ASTarg($1, $3) }
	;

args:
	  arg 					{ [$1] }
	| arg COMMA args 		{ $1::$3 }
	;

tyype:
	  INT 									{ ASTtprim(Ast.Int) }
	| BOOL 									{ ASTtprim(Ast.Bool) }
	| LPAR tyypes ARROW tyype RPAR 			{ Todo }
	;

tyypes:
	  tyype 						{ }
	| tyype ASTERISK tyypes 		{ }
	;
