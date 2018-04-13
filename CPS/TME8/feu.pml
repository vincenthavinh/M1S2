mtype = {red, orange, green};
mtype = {blink, static};
mtype color;
mtype state;
mtype last
mtype panne=false;

proctype P(){
do
	:: atomic {color==orange->color=red}
	::color==red->color=green;
	::color==green->color=orange;
od
} 

proctype obs(){
do
	::panne==false->
	if	
		::color==orange->printf("je suis de couleur orange\n");
		::color==red->printf("je suis de couleur rouge\n");
		::color==green->printf("je suis de couleur verte\n");
	fi
od
}

proctype panneInject(){
	if
		::true->
		::true->panne=true;
	fi
}

proctype panneObs(){
	do
		::panne==true->printf("Je suis en panne.\n");
	od
}

init {
	color = orange;
	state = blink;
	atomic {
	run obs();
	run panneInject();
	run panneObs();
	run P();
	}
}