let _ =
	try
		let lexbuf = Lexing.from_channel stdin in
		let ast = Parser.prog Lexer.token lexbuf in
		Eval.eval_stmt ast;
		print_newline(); 
		flush stdout
	with
	| Lexer.Eof -> exit 0