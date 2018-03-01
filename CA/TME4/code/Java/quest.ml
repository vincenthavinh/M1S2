let rec map f l = if l =[] then [] else (f (car l))::(map f (cdr l));;
