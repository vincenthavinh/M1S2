let rec fib = function x-> if x < 2 then 1 else (fib(x-1))+(fib(x-2));;
let rec map = function f -> function l ->
    if l = [] then [] else (f (hd l))::(map f (tl l))
;;

map fib;;