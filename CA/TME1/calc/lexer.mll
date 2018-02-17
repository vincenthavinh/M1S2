{
  open Parser
}

let integer = '-'?['0'-'9']+
let spaces = [' ' '\t']
let eol = '\n'
let print = "PRINT"
let semicolon = ';'

rule token = parse
    spaces        { token lexbuf }
  | "+"           { PLUS }
  | "*"           { MUL }
  | "("           { LPAREN }
  | ")"           { RPAREN }
  | integer as x  { INTEGER(int_of_string x) }
  | eol           { EOL }
  | print         { PRINT }
  | semicolon      { SEMICOLON }
