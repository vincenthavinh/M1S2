type token =
  | PLUS
  | MUL
  | LPAREN
  | RPAREN
  | EOL
  | PRINT
  | SEMICOLON
  | INTEGER of (int)

open Parsing;;
let _ = parse_error;;
# 2 "parser.mly"
open Ast
# 16 "parser.ml"
let yytransl_const = [|
  257 (* PLUS *);
  258 (* MUL *);
  259 (* LPAREN *);
  260 (* RPAREN *);
  261 (* EOL *);
  262 (* PRINT *);
  263 (* SEMICOLON *);
    0|]

let yytransl_block = [|
  264 (* INTEGER *);
    0|]

let yylhs = "\255\255\
\001\000\006\000\006\000\005\000\002\000\002\000\003\000\003\000\
\004\000\004\000\000\000"

let yylen = "\002\000\
\002\000\001\000\003\000\002\000\003\000\001\000\003\000\001\000\
\001\000\003\000\002\000"

let yydefred = "\000\000\
\000\000\000\000\000\000\011\000\000\000\000\000\000\000\009\000\
\000\000\000\000\008\000\000\000\001\000\000\000\000\000\000\000\
\003\000\010\000\000\000\000\000"

let yydgoto = "\002\000\
\004\000\009\000\010\000\011\000\005\000\006\000"

let yysindex = "\001\000\
\253\254\000\000\008\255\000\000\006\255\014\255\008\255\000\000\
\022\255\023\255\000\000\253\254\000\000\017\255\008\255\008\255\
\000\000\000\000\022\255\023\255"

let yyrindex = "\000\000\
\000\000\000\000\000\000\000\000\019\255\000\000\000\000\000\000\
\015\255\000\255\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\010\255\005\255"

let yygindex = "\000\000\
\000\000\249\255\010\000\000\000\000\000\015\000"

let yytablesize = 27
let yytable = "\014\000\
\006\000\001\000\003\000\006\000\006\000\007\000\006\000\019\000\
\007\000\007\000\007\000\007\000\012\000\005\000\005\000\008\000\
\005\000\015\000\013\000\004\000\018\000\004\000\015\000\002\000\
\016\000\020\000\017\000"

let yycheck = "\007\000\
\001\001\001\000\006\001\004\001\005\001\001\001\007\001\015\000\
\004\001\005\001\003\001\007\001\007\001\004\001\005\001\008\001\
\007\001\001\001\005\001\005\001\004\001\007\001\001\001\005\001\
\002\001\016\000\012\000"

let yynames_const = "\
  PLUS\000\
  MUL\000\
  LPAREN\000\
  RPAREN\000\
  EOL\000\
  PRINT\000\
  SEMICOLON\000\
  "

let yynames_block = "\
  INTEGER\000\
  "

let yyact = [|
  (fun _ -> failwith "parser")
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 1 : 'stmts) in
    Obj.repr(
# 18 "parser.mly"
                 ( _1 )
# 94 "parser.ml"
               : Ast.stmt))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : Ast.stmt) in
    Obj.repr(
# 20 "parser.mly"
             ( _1 )
# 101 "parser.ml"
               : 'stmts))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : Ast.stmt) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'stmts) in
    Obj.repr(
# 21 "parser.mly"
                             ( _1; _3 )
# 109 "parser.ml"
               : 'stmts))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 0 : Ast.expr) in
    Obj.repr(
# 23 "parser.mly"
                  ( Print(_2) )
# 116 "parser.ml"
               : Ast.stmt))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : Ast.expr) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : Ast.expr) in
    Obj.repr(
# 25 "parser.mly"
                      ( Add(_1, _3) )
# 124 "parser.ml"
               : Ast.expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : Ast.expr) in
    Obj.repr(
# 26 "parser.mly"
             ( _1 )
# 131 "parser.ml"
               : Ast.expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : Ast.expr) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : Ast.expr) in
    Obj.repr(
# 28 "parser.mly"
                     ( Mul(_1, _3) )
# 139 "parser.ml"
               : Ast.expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : Ast.expr) in
    Obj.repr(
# 29 "parser.mly"
               ( _1 )
# 146 "parser.ml"
               : Ast.expr))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : int) in
    Obj.repr(
# 31 "parser.mly"
                 ( Integer(_1) )
# 153 "parser.ml"
               : Ast.expr))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 1 : Ast.expr) in
    Obj.repr(
# 32 "parser.mly"
                            ( _2 )
# 160 "parser.ml"
               : Ast.expr))
(* Entry calc *)
; (fun __caml_parser_env -> raise (Parsing.YYexit (Parsing.peek_val __caml_parser_env 0)))
|]
let yytables =
  { Parsing.actions=yyact;
    Parsing.transl_const=yytransl_const;
    Parsing.transl_block=yytransl_block;
    Parsing.lhs=yylhs;
    Parsing.len=yylen;
    Parsing.defred=yydefred;
    Parsing.dgoto=yydgoto;
    Parsing.sindex=yysindex;
    Parsing.rindex=yyrindex;
    Parsing.gindex=yygindex;
    Parsing.tablesize=yytablesize;
    Parsing.table=yytable;
    Parsing.check=yycheck;
    Parsing.error_function=parse_error;
    Parsing.names_const=yynames_const;
    Parsing.names_block=yynames_block }
let calc (lexfun : Lexing.lexbuf -> token) (lexbuf : Lexing.lexbuf) =
   (Parsing.yyparse yytables 1 lexfun lexbuf : Ast.stmt)
;;
