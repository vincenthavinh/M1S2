%{
open Ast
%}

%token PRINT
%token <int> NUM
%token <string> IDENT
%token <string> CHAINE
%token EOL

%start prog			/* the entry point */

%type <Ast.prog> prog

%%

prog:
	stmt 			{ ASTprog($1) }
	;

stmt:
	  PRINT expr 			{ ASTprintExpr($2) }
	| PRINT CHAINE		{ ASTprintChaine($2) }
	;

expr:
	NUM 				{ ASTnum($1)}
	;