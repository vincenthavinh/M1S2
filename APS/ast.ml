type op = Add | Mul | Sub | Div

let string_of_op op =
	match op with
			Add -> "add"
		| Mul -> "mul"
		| Sub -> "sub"
		| Div -> "div"

let op_of_string op =
	match op with
			"add" -> Add
		| "mul" -> Mul
		| "sub" -> Sub
		| "div" -> Div

type expr =
		ASTNum of int
	| ASTId of string
	| ASTPrim of op * expr * expr