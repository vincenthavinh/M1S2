%{
open Ast
%}

%token <int> NUM
%token <string> IDENT
%token ADD SUB MUL DIV
%token LPAR RPAR
%token EOL

%token TRUE FALSE
%token ECHO
%token LCROC RCROC
%token SEMICOLON
%token CONST
%token INT BOOL

%start prog			/* the entry point */

%type <Ast.cmds> prog

%%

prog:
	  LCROC cmds RCROC { $2 }
	;

cmds:
	  stat { ASTcmd($1) }
	/*| dec SEMICOLON cmds { ASTcmds2($1, $3) }*/
	| stat SEMICOLON cmds { ASTcmds($1, $3) }
	;

/*dec:
	  CONST IDENT tyype expr { ASTconst($3) }
	;*/

stat:
	  ECHO expr { ASTecho($2) }
	;

expr:
	  TRUE { ASTbool(Ast.True) }
	| FALSE { ASTbool(Ast.False) }
	| NUM { ASTnum($1) }
	| IDENT { ASTid($1) }
	| LPAR ADD expr expr RPAR { ASToprim(Ast.Add, $3, $4) }
	| LPAR SUB expr expr RPAR { ASToprim(Ast.Sub, $3, $4) }
	| LPAR MUL expr expr RPAR { ASToprim(Ast.Mul, $3, $4) }
	| LPAR DIV expr expr RPAR { ASToprim(Ast.Div, $3, $4) }
	;

/*tyype:
	  INT { ASTtprim(Ast.Int) }
	| BOOL { ASTtprim(Ast.Bool) }
	;*/