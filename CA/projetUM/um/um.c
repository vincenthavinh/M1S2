#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[]){
	

	FILE* f = fopen(argv[1],"rb");
	
	if(f==NULL){
		printf("fopen retourne NULL. fin prog\n");
		return 1;
	}

	
	
	return 0;
}

