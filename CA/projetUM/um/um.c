#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]){
	/*on verifie qu'un unsigned int soit bien code sur 4 octets.*/
	if(sizeof(uint)!=4){
		printf("Erreur: sizeof(uint) != 4 actuellement.\n");
		return 1;
	}
	/*on ouvre le fichier en lecture binaire.*/
	FILE* f = fopen(argv[1],"rb");
	
	if(f==NULL){
		printf("Erreur: fopen() retourne NULL. verifier nom fichier.\n");
		return 1;
	}

	/*on recupere la taille en uints du fichier.
	 *cela correspond au nombre de plateaux dans le programme*/
	fseek(f, 0, SEEK_END);
	long taille_octets = ftell(f);
	rewind(f);
	long taille_uints = taille_octets >> 2;
	printf("%ld\n", taille_uints);

	/*on alloue le pointeur sur le tableau 'O' qui contiendra le programme.
	 *ce "tableau" stocke des "plateaux" de 32 bits chacun <-> 4 octets <-> 1 uint.
	 *on cree donc un tableau de uints.*/
    uint* prog = (uint*) malloc (taille_uints*sizeof(uint)); 

    /*On dump le programme binaire dans le tableau 'O' uint par uint*/
    fread(prog, sizeof(uint), taille_uints, f);

    /*FILE* t = fopen("test.umz","wb");
    fwrite(prog, sizeof(uint), taille_uints, t);*/

    /*on declare et initialise les 8 registres a 0.*/
    uint registre[8] = {0};

    /*on place l'indice d'execution sur le premier plateau.*/
    int i = 0;

    while(1){
    	uint plat_act = prog[i];

    	/*on recupere les 4 bits de poids forts du plateau actuel.
    	 *c'est le numero de l'operateur*/
    	int num_op = plat_act >> 28;
		
		printf("i: %d, plat: %u, num_op: %d\n", i, plat_act, num_op);
    	
    	/*on avance l'indice d'execution avant de traiter le plateau actuel,
    	 *comme precise dans l'enonce.*/
    	i++;

    	/*switch case sur les differents operateurs*/
    	switch(num_op){
    		case 0:
    			break;
    		case 1:
    			break;
    		case 2:
    			break;
    		case 3:
    			break;
    		case 4:
    			break;
    		case 5:
    			break;
    		case 6:
    			break;
    		case 7:
    			break;
    		case 8:
    			break;
    		case 9:
    			break;
    		case 10:
    			break;
    		case 11:
    			break;
    		case 12:
    			break;
    		case 13:
    			break;
    	}

	    if(!(i<taille_uints)){
	    	printf("Erreur: indice execution >= indice max des plateaux du programme\n");
	    	return 1;
	    }

    }

	return 0;
}

