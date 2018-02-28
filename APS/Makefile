LEX_ML = /usr/bin/ocamllex
YACC_ML = /usr/bin/ocamlyacc
OCAMLC = ocamlc

toProlog: parser toProlog.ml print_prolog.ml
	$(OCAMLC) -o toProlog ast.cmo lexer.cmo parser.cmo print_prolog.ml toProlog.ml

parser: ast.ml lexer.mll parser.mly
	$(OCAMLC) -c ast.ml
	$(LEX_ML) -o lexer.ml lexer.mll
	$(YACC_ML) -b parser parser.mly
	$(OCAMLC) -c parser.mli
	$(OCAMLC) -c lexer.ml
	$(OCAMLC) -c parser.ml

clean:
	rm -f *.cmo
	rm -f *.cmi
	rm -f toProlog
	rm -f lexer.ml
	rm -f parser.mli
	rm -f parser.ml
