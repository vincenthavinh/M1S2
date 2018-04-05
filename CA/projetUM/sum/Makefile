LEX_ML = /usr/bin/ocamllex
YACC_ML = /usr/bin/ocamlyacc
OCAMLC = ocamlc

all: toSum cleanTemp

toSum: parser toSum.ml
	$(OCAMLC) -o toSum ast.cmo lexer.cmo parser.cmo toSum.ml

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
	rm -f toSum
	rm -f lexer.ml
	rm -f parser.mli
	rm -f parser.ml

cleanTemp:
	rm -f *.cmo
	rm -f *.cmi
	rm -f lexer.ml
	rm -f parser.mli
	rm -f parser.ml
