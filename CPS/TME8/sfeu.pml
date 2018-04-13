mtype {RED, ORANGE, GREEN, INDETERMINEE };


chan observe = [0] of {mtype, bool} ;

active proctype feu(){
	bool clignotant = false;
	mtype couleur = INDETERMINEE;

	initial:
		atomic { couleur = ORANGE;
			     clignotant = true;
				 observe!couleur, clignotant;
	

	if 
	::true-> clignotant = false;goto gored;
	::true-> goto initial;
	fi

	gored:
		couleur=RED;
		if
			::true->goto gogreen;
			::true->goto fault;
		fi

	gorange:
		couleur=ORANGE;
		if
			::true->goto gored;
			::true->goto fault;
		fi

	gogreen:
		couleur=GREEN;
		if
			::true->goto gorange;
			::true->goto fault;
		fi

	fault:
		couleur=ORANGE;
		clignotant=true;
		if 
			::true->goto fault;
		fi
			
		
	}
}

active proctype observeur(){
	mtype precedent = INDETERMINEE;
	mtype currColor = INDETERMINEE;
	bool clignote = false;

	do
		::observe?currColor, clignote ->
		if
			::atomic { currColor == ORANGE ->
				assert(clignote == true || precedent != RED);precedent=ORANGE ;printf("\norange"); } 
			::atomic { currColor == GREEN ->
				assert(precedent != ORANGE);precedent = GREEN ;printf("\nGREEN");}
			::atomic { currColor == RED -> 
				assert(precedent != GREEN);precedent = RED ;printf("\nRED");}
			::atomic { clignote == true -> 
				assert(currColor == ORANGE)  ; printf(" clignotant")}
		fi
	od


}