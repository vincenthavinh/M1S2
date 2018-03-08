open Ast
open Print_prolog

(* ---------------- Lecture stdin ---------------- *)

let _ =
	try
		let lexbuf = Lexing.from_channel stdin in
		let x = Parser.prog Lexer.token lexbuf in
		print_prolog_prog x;
		print_char '\n'
	with Lexer.Eof -> exit 0
