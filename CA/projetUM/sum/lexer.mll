{
	open Parser 		(* ’The type token is defined in parser.mli *)
	exception Eof
}

rule token = parse
	 eof 							{ raise Eof }

(* mots clefs *)
	| "print" 						{ PRINT }

(* ensemble num *)
	| ('-'?)['0'-'9']+ as lxm 		{ NUM(int_of_string lxm) }

(* ensemble ident
	| (['a'-'z''A'-'Z'])(['a'-'z''A'-'Z''0'-'9'])* as lxm 		{ IDENT(lxm) }*)

(* ensemble chaine *)
	| '"'['a'-'z''A'-'Z'' ']*'"' as lxm 						{ CHAINE(lxm) }		

(* separateurs *)
	| [' ' '\t'] 					{ token lexbuf } (* skip blanks *)
	| ['\n' ] 						{ EOL }


