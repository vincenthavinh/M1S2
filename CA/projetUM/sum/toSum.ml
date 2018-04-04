open Ast
open Print_sum

(* ---------------- Lecture stdin ---------------- *)

let _ =
	try
		let lexbuf = Lexing.from_channel stdin in
		let x = Parser.prog Lexer.token lexbuf in
		print_sum_prog x;
		print_char '\n'
	with Lexer.Eof -> exit 0
