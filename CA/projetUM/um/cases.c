case 0: /*Mouvement conditionnel*/
                if(!(registre[id_C] == 0))
                    registre[id_A] = registre[id_B];
    			break;

    		case 1: /*Indice de tableau*/
                if(registre[id_B] != 0){
                    /*recupere la valeur a la case offset du tableau pointe par le registre B
                    * s'il ne pointe pas sur NULL*/
                    //printf("[then] ");
                    tab = (tableau*) registre[id_B];
                }else{
                    /*sinon recupere la valeur a la case offset du tableau contenant le prog.*/
                    //printf("[else] ");
                    tab = prog;
                }
                offset = registre[id_C];
                //printf("t_plat: %u, offset: %u\n", tab, offset);
                registre[id_A] = tab->plateau[offset];
    			break;

    		case 2: /*Modification de tableau*/
                //printf("a: %u\n", registre[id_A]);
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
                if(registre[id_C] < 256 ){
                    fputc(registre[id_C], stdout);
                    fflush(stdout);
                }else{
                    printf("\nErreur: affichage du registre C > 255\n");
                    return 1;
                }
    			break;

    		case 11: /*Entree*/
                console = fgetc(stdin);
                if(console == EOF) registre[id_C] = 4294967295;
                else registre[id_C] = console;
    			break;

    		case 12: /*Chargement de programme*/
                /*Seulement quand le registre B ne pointe pas sur null*/
                //rintf("b: %u\n", registre[id_B]);
                if(registre[id_B] != 0){

                    tab = (tableau*) registre[id_B];

                    /*creation de la copie*/
                    copie = (tableau*) malloc (sizeof(tableau));
                    copie->taille_plateaux = tab->taille_plateaux;
                    copie->plateau = (uint*) malloc (copie->taille_plateaux * sizeof(uint));
                    memcpy(copie->plateau, tab->plateau, copie->taille_plateaux * 4); //3e arg en octets
                    //printf("tab: %u\n",tab->plateau[3]);
                    //printf("copie: %u\n",copie->plateau[3]);

                    /*remplacement*/
                    free(prog->plateau);
                    free(prog);
                    prog = copie;
                    //printf("prog: %u\n",prog->plateau[3]);

                }
                //printf("fin 12\n");
                /*positionnement de l'indice d'execution*/
                i = registre[id_C];
                break;

    		case 13: /*Orthographe*/
                /*on recupere la valeur a chargee : les 25 bits de poids faibles.
                 *on se sert pour cela du masque 0000000111..25 fois..11 <=> 33554431*/
                value_A = (plat_act) & 33554431;
                //printf(", v: %u\n", value_A);
                registre[id_A] = value_A;
                //printf("plateau: %u, A: %u, value: %u\n", plat_act, id_A, value_A);
    			break;