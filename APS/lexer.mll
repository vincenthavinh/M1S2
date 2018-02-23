{
	open Parser 		(* ’The type token is defined in parser.mli *)
	exception Eof

}
rule token = parse
		[' ' '\t'] 		{ token lexbuf } (* skip blanks *)
	| ['\n' ] 			{ EOL }
	| ['0'-'9']+('.'['0'-'9'])? as lxm 		{ NUM(int_of_string lxm) }
	| "add" 				{ PLUS }
	| "sub" 				{ MINUS }
	| "mul" 				{ TIMES }
	| "div" 				{ DIV }
	| '(' 					{ LPAR }
	| ')' 					{ RPAR }
	| eof 					{ raise Eof }