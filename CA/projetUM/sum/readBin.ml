let input_chan = open_in_bin "test.um" in
try
	while true; do
		let x = input_byte input_chan in
		print_endline (string_of_int x) ;
	done
with 
	End_of_file ->	
		flush stdout;
		close_in input_chan