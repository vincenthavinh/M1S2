type tprim =
	  Int
	| Bool

type oprim = 
	  Add 
	| Mul 
	| Sub 
	| Div

type bool = 
	  True 
	| False

type expr =
	  ASTbool of bool
	| ASTnum of int
	| ASTid of string
	| ASTif of expr * expr * expr
	| ASToprim of oprim * expr * expr
	| Todo

type tyype =
	  ASTtprim of tprim
	| Todo

type arg =
	  ASTarg of string * tyype

type stat = 
	  ASTecho of expr

type dec =
	  ASTconst of string * tyype * expr
	| ASTfun of string * tyype * arg list * expr
	| ASTfunrec of string * tyype * arg list * expr

type cmd =
	  ASTstat of stat	
	| ASTdec of dec

type prog = 
	  cmd list

