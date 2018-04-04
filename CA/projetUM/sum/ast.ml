type expr =
	ASTnum of int

type stmt =
	  ASTprintExpr of expr
	| ASTprintChaine of string

type prog = 
	ASTprog of stmt

