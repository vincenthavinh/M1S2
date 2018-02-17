let _ =
  let lexbuf = Lexing.from_channel stdin in
  let ast = Parser.calc Lexer.token lexbuf in
  Eval.eval_stmt ast;
  print_newline(); flush stdout
