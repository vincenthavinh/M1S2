{
	open Parser 		(* ’The type token is defined in parser.mli *)
	exception Eof
}

rule token = parse
	  [' ' '\t'] 					{ token lexbuf } (* skip blanks *)
	| ['\n' ] 						{ EOL }
	| ('-'?)['0'-'9']+ as lxm 		{ NUM(int_of_string lxm) }
	| "add" 						{ ADD }
	| "sub" 						{ SUB }
	| "mul" 						{ MUL }
	| "div" 						{ DIV }
	| '(' 							{ LPAR }
	| ')' 							{ RPAR }
	| eof 							{ raise Eof }

	| "true" 						{ TRUE }
	| "false" 						{ FALSE }
	| "ECHO" 						{ ECHO }
	| '[' 							{ LCROC }
	| ']' 							{ RCROC }
	| ';' 							{ SEMICOLON }
(*	| "CONST" 						{ CONST }
	| "int" 						{ INT }
	| "bool" 						{ BOOL }*)
