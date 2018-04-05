open Ast


(* ------- input channel pour la lecture SUM -------------- *)

let in_chan = 
	if(Array.length Sys.argv > 1)
	then open_in (Array.get Sys.argv 1)
	else stdin 


(* ------- output channel pour l'ecriture UM -------------- *)

let out_chan = 
	if(Array.length Sys.argv > 1)
	then 
		let arg = Array.get Sys.argv 1 in
		let name = (String.sub arg 0 (String.rindex arg '.')) in
		let name_extension = String.concat (".") [name ; "um"] in
		(*Printf.printf"%s, %s, %s\n" arg name name_extension;*)
		open_out_bin name_extension
	else open_out_bin "test-stdin.um"



(* ------- fonctions produtrices de plateaux UM ---------- *)

let op13 id_A valeur =
	let plateau = ref 0 in 
	plateau := !plateau lor (13 lsl 28);
	plateau := !plateau lor (id_A lsl 25);
	plateau := !plateau lor (valeur land 33554431);
	(*Printf.printf "plateau: %d, op: 13, A: %d, val: %d\n" !plateau id_A valeur;*)
	output_binary_int out_chan !plateau

let opABC op id_A id_B id_C =
	let plateau = ref 0 in 
	plateau := !plateau lor (op lsl 28);
	plateau := !plateau lor (id_A lsl 6);
	plateau := !plateau lor (id_B lsl 3);
	plateau := !plateau lor (id_C);
	(*Printf.printf "plateau: %d, op: %d, A: %d, B: %d, C:%d\n" !plateau op id_A id_B id_C;*)
	output_binary_int out_chan !plateau



(* ------- conversion instructions SUM -> plateaux UM ------- *)

let sum_expr x =
	match x with
		  ASTnum a -> 
		  	(
	  			let b = string_of_int a in
	  			for  i = 0 to (String.length b)-1 do
					op13 7 (Char.code (String.get b i));
					opABC 10 0 0 7;
					(*print_newline ()*)
				done
		  	)

let sum_stmt x =
	match x with
		  ASTprintExpr a -> 
		  	(	
		  		sum_expr a
		  	)
		| ASTprintChaine a ->
			(
				for  i = 1 to (String.length a)-2 do
					op13 7 (Char.code (String.get a i));
					opABC 10 0 0 7;
				done
			)

let rec sum_prog x =
	match x with
		  ASTprog a -> 
		  	(
		  		sum_stmt a;
		  		opABC 7 0 0 0
		  	)

(* ---------------- Lecture stdin/fichier ---------------- *)

let _ =
	try
		let lexbuf = Lexing.from_channel in_chan in
		let x = Parser.prog Lexer.token lexbuf in
		sum_prog x
	with Lexer.Eof -> exit 0