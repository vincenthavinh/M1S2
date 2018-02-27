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

(*type dec =
	  ASTconst of tyype*)

type cmds =
	  ASTcmd of stat
	| ASTcmds of stat * cmds
	(*| ASTcmds2 of dec * cmds*)
