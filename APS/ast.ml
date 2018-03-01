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

(*type arg =
	  ASTarg of string * tyype

type args =
	  ASTarg of arg
	| ASTargs of arg * args*)

type stat = 
	  ASTecho of expr

type dec =
	  ASTconst of string * tyype * expr
	| Todo

type cmd =
	  ASTstat of stat	
	| ASTdec of dec

type cmds =
	  ASTstat of stat
	| ASTcmds of cmd * cmds
