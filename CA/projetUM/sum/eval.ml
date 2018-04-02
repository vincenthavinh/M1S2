open Ast

let rec eval e =
	match e with
	| Add(left, right) -> (eval left) + (eval right)
	| Integer(x) -> x
	
let rec eval_stmt i =
	match i with
	| Print(x) -> print_int (eval x)
