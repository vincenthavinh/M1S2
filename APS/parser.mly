%{
open Ast
%}

%token LCROC RCROC LPAR RPAR SEMICOLON COMMA COLONS ASTERISK VECTOR
%token NOT AND OR EQ LT ADD SUB MUL DIV
%token INT BOOL
%token IF CONST FUN REC ECHO
%token TRUE FALSE
%token <int> NUM
%token <string> IDENT
%token EOL

%start prog			/* the entry point */

%type <Ast.cmds> prog

%%

prog:
	  LCROC cmds RCROC { $2 }
	;

cmds:
	  stat { ASTstat($1) }
	| dec SEMICOLON cmds { ASTcmds(ASTdec($1), $3) }
	| stat SEMICOLON cmds { ASTcmds(ASTstat($1), $3) }
	;

dec:
	  CONST IDENT tyype expr { ASTconst($2, $3, $4) }
	;

stat:
	  ECHO expr { ASTecho($2) }
	;

expr:
	  TRUE { ASTbool(Ast.True) }
	| FALSE { ASTbool(Ast.False) }
	| NUM { ASTnum($1) }
	| IDENT { ASTid($1) }
	| LPAR IF expr expr expr RPAR { ASTif($3, $4, $5) }
	| LPAR ADD expr expr RPAR { ASToprim(Ast.Add, $3, $4) }
	| LPAR SUB expr expr RPAR { ASToprim(Ast.Sub, $3, $4) }
	| LPAR MUL expr expr RPAR { ASToprim(Ast.Mul, $3, $4) }
	| LPAR DIV expr expr RPAR { ASToprim(Ast.Div, $3, $4) }
	;

tyype:
	  INT { ASTtprim(Ast.Int) }
	| BOOL { ASTtprim(Ast.Bool) }
	;