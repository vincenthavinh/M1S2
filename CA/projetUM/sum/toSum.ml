open Ast
open Print_sum

(* ---------------- Lecture stdin ---------------- *)

let _ =
	try
		let lexbuf = Lexing.from_channel stdin in
		let x = Parser.prog Lexer.token lexbuf in
		sum_prog x
	with Lexer.Eof -> exit 0
