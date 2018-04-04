open Ast

(* ------- conversion noeuds AST -> Print in sum ------- *)

let string_of_tprim x =
	match x with
		  Int -> "int"
		| Bool -> "bool"

let string_of_oprim x =
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

let rec print_sum_expr x =
	match x with
		  ASTbool a -> Printf.printf"%s" (string_of_bool a)
		| ASTnum a -> Printf.printf"%d" a
		| ASTid a -> Printf.printf"\"%s\"" a
		| ASTif (a, b, c) ->
			(
				Printf.printf"if ";
				print_sum_expr a;
				Printf.printf"\nthen ";
				print_sum_expr b;
				Printf.printf"\nelse ";
				print_sum_expr c; 
			)
		| ASToprim(a, b, c) -> 
			(
				Printf.printf"%s" (string_of_oprim a);
				Printf.printf"(";
				print_sum_expr b;
				Printf.printf",";
				print_sum_expr c;
				Printf.printf")"
			)

let rec print_sum_tyype x =
	match x with
		  ASTtprim a -> Printf.printf"%s" (string_of_tprim a)

let print_sum_arg x =
	match x with
		  ASTarg (a, b) ->
			(
				print_sum_tyype b;
		  		Printf.printf" %s" a;
		  	)

let rec print_sum_args x =
	match x with
		  [] -> ()
		| e::l -> 
			(
				print_sum_arg e;
				if l!=[] then print_string ", ";
				print_sum_args l
			)

let print_sum_stat x =
	match x with
		  ASTecho a -> print_sum_expr a

let print_sum_dec x =
	match x with
		  ASTconst (a, b ,c) -> 
		  	(
		  		print_sum_tyype b;
		  		Printf.printf" %s = " a;
		  		print_sum_expr c
		  	)
		| ASTfun(a, b ,c ,d) ->
			(
				print_sum_tyype b;
				Printf.printf" %s(" a;
				print_sum_args c;
				Printf.printf") {return ";
				print_sum_expr d;
				Printf.printf" ;}";
			)
		| ASTfunrec(a, b ,c ,d) ->
			(
				print_sum_tyype b;
				Printf.printf" %s(" a;
				print_sum_args c;
				Printf.printf") RECURSIF {return ";
				print_sum_expr d;
				Printf.printf" ;}";
			)
				

let print_sum_cmd x =
	match x with
		  ASTdec a -> print_string "ASTdec " ; print_sum_dec a
		| ASTstat a -> print_string "ASTstat " ; print_sum_stat a


let rec print_sum_prog x =
	match x with
		  [] -> ()
		| e::l -> 
			(
				print_sum_cmd e; 
				print_newline ();
				print_sum_prog l
			)

