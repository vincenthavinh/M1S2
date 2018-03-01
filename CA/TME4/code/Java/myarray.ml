let rec sum_array = function tab -> function n -> function acc -> if n = 0 then (acc + tab.(n)) else sum_array tab (n - 1) (acc + tab.(n));;

let t = Array.make 5 1 in
  sum_array t ((Array.length t) - 1) 0
;;
