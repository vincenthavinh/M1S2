type token =
  | PLUS
  | MUL
  | LPAREN
  | RPAREN
  | EOL
  | PRINT
  | SEMICOLON
  | INTEGER of (int)

val calc :
  (Lexing.lexbuf  -> token) -> Lexing.lexbuf -> Ast.stmt
