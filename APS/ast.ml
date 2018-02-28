(*type tprim =
	  Int
	| Bool*)

type oprim = 
	  Add 
	| Mul 
	| Sub 
	| Div

type bool = 
	  True 
	| False


(*type tyype =
	  ASTtprim of tprim*)

type expr =
	  ASTnum of int
	| ASTid of string
	| ASToprim of oprim * expr * expr
	| ASTbool of bool

type stat = 
	  ASTecho of expr

type dec =
	  ASTconst of expr

type cmd =
	  ASTstat of stat	
	| ASTdec of dec

type cmds =
	  ASTstat of stat
	| ASTcmds of cmd * cmds
