%{
open Ast
%}

%token PLUS, MUL, LPAREN, RPAREN, EOL, PRINT, SEMICOLON
%token<int> INTEGER


%start calc
%type <Ast.stmt> calc
%type <Ast.expr> expr
%type <Ast.expr> term
%type <Ast.expr> factor
%type <Ast.stmt> stmt

%%

calc : stmt EOL { $1 }
     
stmts : stmt { $1 }
      | stmt SEMICOLON stmts { $1; $3 };

stmt : PRINT expr { Print($2) };

expr : expr PLUS expr { Add($1, $3) }
     | term  { $1 };

term : term MUL term { Mul($1, $3) }
     | factor  { $1 } ;

factor : INTEGER { Integer($1) }
       | LPAREN expr RPAREN { $2 } ;

%%
