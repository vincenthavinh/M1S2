{
  open Parser
}

let integer = '-'?['0'-'9']+
let spaces = [' ' '\t']

rule token = parse
    spaces        { token lexbuf }
  | '+'           { PLUS }
  | '*'           { MUL }
  | '('           { LPAREN }
  | ')'           { RPAREN }
  | integer as x  { INTEGER(int_of_string x) }
  | '\n'           { EOL }
  | "PRINT"         { PRINT }
  | ';'     { SEMICOLON }
