%{
open Ast
%}

%token EOL PRINT, PLUS
%token<int> INTEGER


%start prog
%type <Ast.stmt> prog
%type <Ast.expr> expr
%type <Ast.stmt> stmt

%%

prog : 
	  stmt EOL { $1 }

stmt : 
	  PRINT expr { Print($2) }
	;

expr : 
	  expr PLUS expr { Add($1, $3) }
	| INTEGER { Integer($1) }
	;


%%
