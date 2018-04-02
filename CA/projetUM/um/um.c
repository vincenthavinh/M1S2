#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]){
	/*on verifie qu'un unsigned int soit bien code sur 4 octets*/
	if(sizeof(uint)!=4){
		printf("Erreur: sizeof(uint) != 4 actuellement.\n");
		return 1;
	}
	/*on ouvre le fichier en lecture binaire*/
	FILE* f = fopen(argv[1],"rb");
	
	if(f==NULL){
		printf("Erreur: fopen() retourne NULL. verifier nom fichier.\n");
		return 1;
	}

	/*on recupere la taille du fichier*/
	fseek(f, 0, SEEK_END);
	long taille_octets = ftell(f);
	rewind(f);
	long taille_uints = taille_octets >> 2;
	//printf("taille [octets] : %ld, [uints] : %ld\n", taille_octets, taille_uints);

	/*on alloue le pointeur sur le tableau 'O' qui contiendra le programme.
	 *ce "tableau" stocke des "plateaux" de 32 bits chacun <-> 4 octets <-> 1 uint
	 *on cree donc un tableau de uints.
	 */
    uint* prog = (uint*) malloc (taille_uints*sizeof(uint)); 

    /*On dump le programme binaire dans le tableau 'O' uint par uint*/
    fread(prog, sizeof(uint), taille_uints, f);

    /*FILE* t = fopen("test.umz","wb");
    fwrite(prog, sizeof(uint), taille_uints, t);*/

    uint registre[8];
	return 0;
}

