open Ast

(* ------- conversion noeuds AST -> Print in Prolog ------- *)

let string_of_op x =
	match x with
		  Add -> "add"
		| Mul -> "mul"
		| Sub -> "sub"
		| Div -> "div"

(*let op_of_string x =
	match x with
		  "add" -> Add
		| "mul" -> Mul
		| "sub" -> Sub
		| "div" -> Div*)

let string_of_bool x =
	match x with
		  True -> "true"
		| False -> "false"

let rec print_prolog_expr x =
	match x with
		  ASTnum a -> Printf.printf"%d" a
		| ASTid a -> Printf.printf"\"%s\"" a
		| ASToprim(a, b, c) -> 
			(
				Printf.printf"%s" (string_of_op a);
				Printf.printf"(";
				print_prolog_expr b;
				Printf.printf",";
				print_prolog_expr c;
				Printf.printf")"
			)
		| ASTbool a -> Printf.printf"%s" (string_of_bool a)

let print_prolog_stat x =
	match x with
		  ASTecho a -> print_prolog_expr a

let print_prolog_dec x =
	match x with
		  ASTconst a -> print_string "ASTconst"

let print_prolog_cmd x =
	match x with
		  ASTdec a -> print_prolog_dec a
		| ASTstat a -> print_prolog_stat a


let rec print_prolog_cmds x =
	match x with
		  ASTstat a -> print_prolog_stat a
		| ASTcmds(a, b) ->
			(
				print_prolog_cmd a;
				print_char '\n';
				print_prolog_cmds b
			)



