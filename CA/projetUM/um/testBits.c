#include <stdlib.h>
#include <stdio.h>

/*https://stackoverflow.com/questions/111928/is-there-a-printf-converter-to-print-in-binary-format*/

//assumes little endian
void printBits(size_t const size, void const * const ptr)
{
    unsigned char *b = (unsigned char*) ptr;
    unsigned char byte;
    int i, j;

    for (i=size-1;i>=0;i--)
    {
        for (j=7;j>=0;j--)
        {
            byte = (b[i] >> j) & 1;
            printf("%u", byte);
        }
    }
    //puts("");
}

int main(int argv, char* argc[])
{

        uint ui = 3221225520;
        printBits(sizeof(ui), &ui);
        printf(" : %u\n", ui);

        /*uint ui1 = ui >>2;
        printBits(sizeof(ui1), &ui1);
        printf(" : %u\n", ui1);*/

        /* https://stackoverflow.com/questions/10493411/what-is-bit-masking */

        /* on veut recuperer le registre C:
         * on enleve les 6 premiers bits de poids faible avec >>6.
         * => les 3 bits voulus sont tout à droite.
         * puis on passe les 32-3 = 29 bits de poids fort à 0 en 
         * appliquant le bon masque de bits. ici : 
         * 000...29 fois...0111. <=> 7 en décimal.
         * il ne reste plus que les 3 bits voulus. */
        uint c = ui>>6; 

        printBits(sizeof(c), &c);
        printf(" : %u\n", c);

        c = c & 7; 

        printBits(sizeof(c), &c);
        printf(" : %u\n", c);

        /*Tests pour operateur 13*/
        uint value_A = (ui) & 33554431;
        printBits(sizeof(value_A), &value_A);
        printf(" : %u\n", value_A);

        return 0;
}