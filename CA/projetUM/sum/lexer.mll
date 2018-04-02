{
	open Parser
	exception Eof
}

let integer = ['0'-'9']+
let spaces = [' ' '\t']

rule token = parse
		spaces 						{ token lexbuf }
	| eof 							{ raise Eof }
	| '\n' 							{ EOL }

	| integer as x 					{ INTEGER(int_of_string x) }
	| '+' 							{ PLUS }
	| "print" 						{ PRINT }
	
	(*| ';' 						{ SEMICOLON }*)


