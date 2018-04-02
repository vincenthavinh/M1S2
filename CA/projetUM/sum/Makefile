MAKEFLAGS += --silent

sum: 
	ocamllex lexer.mll
	ocamlc -c ast.ml
	ocamlc -c eval.ml
	ocamlyacc parser.mly
	ocamlc -c parser.mli
	ocamlc -c lexer.ml
	ocamlc -c parser.ml
	ocamlc -c prog.ml
	ocamlc -o prog ast.cmo eval.cmo lexer.cmo parser.cmo prog.cmo
clean: 
	rm *.cmi; rm *.cmo; rm *.mli; rm prog; rm lexer.ml; rm parser.ml
	echo "Cleaned."

all: sum
