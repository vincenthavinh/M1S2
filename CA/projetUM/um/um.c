#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <string.h>


/*typedef d'un tableau de plateaux*/
typedef struct tableau_struct{
    uint taille_plateaux;
    uint* plateau;
}tableau;


/*fichier lu.*/
FILE* f;
/*pointeur sur le tableau contenant le programme.*/
tableau* prog;
/*les 8 registres a capacite d'un plateau chacun, initialises a 0.*/
uint registre[8] = {0};
/*indice d'execution du programme*/
int i;


int main(int argc, char *argv[]){
	/*on verifie qu'un unsigned int soit bien code sur 4 octets.*/
	if(sizeof(uint)!=4){
		printf("Erreur: sizeof(uint) != 4 actuellement.\n");
		return 1;
	}

    /*on verifie qu'un pointeur sur le type tableau soit bien code sur 4 octets.*/
    if(sizeof(tableau*)!=4){
        printf("Erreur: sizeof(tableau*) != 4 actuellement.\n");
        return 1;
    }

	/*on ouvre le fichier en lecture binaire.*/
	f = fopen(argv[1],"rb");
	
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

	/*on alloue le tableau 'O' qui contiendra le programme.*/
    prog = (tableau*) malloc (sizeof(tableau));
    prog->taille_plateaux = taille_uints;
    prog->plateau = (uint*) calloc (prog->taille_plateaux, sizeof(uint));

    /*On dump le programme binaire dans le tableau 'O',
     *on recupere uint par uint ( <=> plateau par plateau ),
     *et on inverse l'ordre des octets pour chaque uint.
     * https://stackoverflow.com/a/13001446 */
    printf("Conversion\n");
    /*uint bytes[4];
    int j = 0;
    int k=0;
    while ( fread(bytes, 4, 1,f) != 0) {
        uint sum = bytes[0]<<24 | bytes[1]<<16 | bytes[2]<<8 | bytes[3];
        prog->plateau[j] = sum;
        if(k<=2){printf("%u\n", sum);k++;};
        j++;
    }*/
    int a;
    int n = 4;
    int j= 0;
    int k =0;
    while(EOF!= (a=fgetc(f))){
        if(!n--){
            j++;
            n = 3;
        }
        prog->plateau[j] <<=8;
        prog->plateau[j]  |=a;
        if(k<=2){printf("%u\n", prog->plateau[j]);k++;};
    }
    printf("t: %u\n", prog->taille_plateaux);
    printf("j: %d\n", j);

    /*FILE* t = fopen("test.umz","wb");
     *fwrite(prog, sizeof(uint), taille_uints, t);*/

    /*on place l'indice d'execution sur l'index du 1er plateau du programme.*/
    i = 0;
    int z = 0;
    while(z<50){
        k++;
    	uint plat_act = prog->plateau[i];

    	/*on recupere les 4 bits de poids forts du plateau actuel.
    	 *c'est le numero de l'operateur.*/
    	int num_op = plat_act >> 28;

        /*on recupere les identificateurs des registres a utiliser selon l'operateur*/
        uint id_A, id_B, id_C;
        if(num_op !=13){
            /*on recupere les identificateurs des registres A B et C du plateau actuel.
             *voir commentaires dans testBits.c pour explications.*/
            id_A = (plat_act >> 6) & 7;
            id_B = (plat_act >> 3) & 7;
            id_C = (plat_act) & 7;
            printf("i: %d, plat: %u, num_op: %d, A: %u, B: %u, C: %u\n", 
                i, plat_act, num_op, id_A, id_B, id_C);
        }else{
            /*on recupere l'identificateur de A : les 3 bits de poids
            *fort apres ceux du numero de l'operateur*/
            id_A = (plat_act >> 25) & 7;

            printf("i: %d, plat: %u, num_op: %d, A: %u", 
            i, plat_act, num_op, id_A);
        }
    	
    	/*on avance l'indice d'execution avant de traiter le plateau actuel,
    	 *comme precise dans l'enonce.*/
    	i++;

        /*declarations de quelques variables utilisees dans le switch*/
        tableau* tab;
        tableau* copie;
        uint offset;
        unsigned int console = NULL;
        uint value_A;

    	/*switch case sur les differents operateurs.*/
    	switch(num_op){
    		case 0: /*Mouvement conditionnel*/
                if(!(registre[id_C] == 0))
                    registre[id_A] = registre[id_B];
    			break;

    		case 1: /*Indice de tableau*/
                if(registre[id_B] != 0){
                    /*recupere la valeur a la case offset du tableau pointe par le registre B
                    * s'il ne pointe pas sur NULL*/
                    printf("[then] ");
                    tab = (tableau*) registre[id_B];
                }else{
                    /*sinon recupere la valeur a la case offset du tableau contenant le prog.*/
                    printf("[else] ");
                    tab = prog;
                }
                offset = registre[id_C];
                printf("t_plat: %u, offset: %u\n", tab, offset);
                registre[id_A] = tab->plateau[offset];
    			break;

    		case 2: /*Modification de tableau*/
                printf("a: %u\n", registre[id_A]);
                if(registre[id_A] != 0){
                     /*modifie le tableau que pointe le registre A s'il ne pointe pas sur NULL.*/
                    tab = (tableau*) registre[id_A];
                }else{
                    /*sinon modifie le tableau contenant le prog.*/
                    tab = prog;
                }
                offset = registre[id_B];
                tab->plateau[offset] = registre[id_C];
    			break;

    		case 3: /*Addition*/
                registre[id_A] = (registre[id_B] + registre[id_C]) % 4294967296;
    			break;

    		case 4: /*Multiplication*/
                registre[id_A] = (registre[id_B] * registre[id_C]) % 4294967296;
    			break;

    		case 5: /*Division*/
                registre[id_A] = registre[id_B] / registre[id_C];
    			break;

    		case 6: /*Not-And*/
                registre[id_A] = ~(registre[id_B] & registre[id_C]);
                /* http://computer-programming-forum.com/47-c-language/479a9ea9793f70d7.htm */
    			break;

    		case 7: /*Stop*/
                printf("\n[Fin du programme]\n");
                return 0;
    			break;

    		case 8: /*Allocation*/
                tab = (tableau*) malloc (sizeof(tableau));
                tab->taille_plateaux = registre[id_C];
                /*utilisation de calloc pour initialiser a 0.*/
                tab->plateau = (uint*) calloc (tab->taille_plateaux, sizeof(uint));
                registre[id_B] = (uint) tab;
    			break;

    		case 9: /*Abandon*/
                tab = (tableau*) registre[id_C];
                free(tab->plateau);
                free(tab);
    			break;

    		case 10: /*Sortie*/
                /* man : fputc() writes the character c, cast to an unsigned char, to stream.*/
                fputc(registre[id_C], stdout);
                fflush(stdout);
    			break;

    		case 11: /*Entree*/
                console = fgetc(stdin);
                if(console == EOF) registre[id_C] = 4294967295;
                else registre[id_C] = console;
    			break;

    		case 12: /*Chargement de programme*/
                /*Seulement quand le registre B ne pointe pas sur null*/
                printf("b: %u\n", registre[id_B]);
                if(registre[id_B] != 0){

                    tab = (tableau*) registre[id_B];

                    /*creation de la copie*/
                    copie = (tableau*) malloc (sizeof(tableau));
                    copie->taille_plateaux = tab->taille_plateaux;
                    copie->plateau = (uint*) malloc (copie->taille_plateaux * sizeof(uint));
                    memcpy(copie, tab, copie->taille_plateaux * 4); //3e arg en octets
                    printf("tab: %u\n",tab->plateau[3]);
                    printf("copie: %u\n",copie->plateau[3]);
                    /*remplacement*/
                    free(prog->plateau);
                    free(prog);
                    prog = copie;
                    printf("prog: %u\n",prog->plateau[3]);

                }
                printf("fin 12\n");
                /*positionnement de l'indice d'execution*/
                i = registre[id_C];
                break;

    		case 13: /*Orthographe*/
                /*on recupere la valeur a chargee : les 25 bits de poids faibles.
                 *on se sert pour cela du masque 0000000111..25 fois..11 <=> 33554431*/
                value_A = (plat_act) & 33554431;
                printf(", v: %u\n", value_A);
                registre[id_A] = value_A;
                //printf("plateau: %u, A: %u, value: %u\n", plat_act, id_A, value_A);
    			break;

            default:
                printf("PROBLEME OPERATEUR\n");
    	}

	    if(!(i<prog->taille_plateaux)){
	    	printf("Erreur: indice execution >= indice max des plateaux du programme\n");
	    	return 1;
	    }

    }

	return 0;
}

