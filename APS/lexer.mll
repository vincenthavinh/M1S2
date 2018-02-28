{
	open Parser 		(* ’The type token is defined in parser.mli *)
	exception Eof
}

rule token = parse
	 eof 							{ raise Eof }

(* symboles reserves *)
	| '[' 							{ LCROC }
	| ']' 							{ RCROC }
	| '(' 							{ LPAR }
	| ')' 							{ RPAR }
	| ';' 							{ SEMICOLON }
	| ',' 							{ COMMA }
	| ':' 							{ COLONS }
	| '*' 							{ ASTERISK }
	| "->" 							{ VECTOR }

(* ensemble oprim *)
	| "add" 						{ ADD }
	| "sub" 						{ SUB }
	| "mul" 						{ MUL }
	| "div" 						{ DIV }


(* ensemble tprim *)
	| "int" 						{ INT }
	| "bool" 						{ BOOL }

(* mots clef *)
	| "if" 							{ IF }
	| "CONST" 						{ CONST }
	| "ECHO" 						{ ECHO }

(* ensemble bool *)
	| "true" 						{ TRUE }
	| "false" 						{ FALSE }

(* ensemble num *)
	| ('-'?)['0'-'9']+ as lxm 		{ NUM(int_of_string lxm) }

(* ensemble ident *)
	| (['a'-'z''A'-'Z'])(['a'-'z''A'-'Z''0'-'9'])* as lxm { IDENT(lxm)}

(* separateurs *)
	| [' ' '\t'] 					{ token lexbuf } (* skip blanks *)
	| ['\n' ] 						{ EOL }


