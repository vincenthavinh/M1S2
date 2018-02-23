%{
open Ast
%}

%token <int> NUM
%token <string> IDENT
%token PLUS MINUS TIMES DIV
%token LPAR RPAR
%token EOL

%start line				/* the entry point */

%type <Ast.expr> line

%%

line:
		expr EOL { $1 }
	;

expr:
		NUM { ASTNum($1) }
	| IDENT { ASTId($1) }
	| LPAR PLUS expr expr RPAR { ASTPrim(Ast.Add, $3, $4) }
	| LPAR MINUS expr expr RPAR { ASTPrim(Ast.Sub, $3, $4) }
	| LPAR TIMES expr expr RPAR { ASTPrim(Ast.Mul, $3, $4) }
	| LPAR DIV expr expr RPAR { ASTPrim(Ast.Div, $3, $4) }
	;