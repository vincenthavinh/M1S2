// Fichier prodcons1.c 
// Producteurs/Consommateurs
// Premiere version : sans synchronisation 
// compilation 
// gcc -Wall --std=c99 prodcons1.c -o prodcons1 -lpthread

#include <stdlib.h> 
#include <stdio.h> 
#include <sched.h>
#include <pthread.h> 
// Constantes 
#define BUF_SIZE 10 
#define NB_TURN 55
#define TRUE 1 
#define FALSE 0

// Structure de donnee BUFFER 
typedef struct _Buffer {   int nb_elem;   int elem[BUF_SIZE]; } Buffer;

Buffer * CreerBuffer() 
{   
  Buffer* buf = (Buffer *) malloc(sizeof(Buffer));   
  if(buf==NULL) 
    {     
      fprintf(stderr,"Impossible d'allouer le buffer\n");     
      exit(EXIT_FAILURE);   
    }   buf->nb_elem=0;   
  return buf; 
}

void EcrireBuffer(Buffer *buf, int val) 
{   
    /********** ?????????? **********/
    
}

int LireBuffer(Buffer *buf) 
{   
    /********** ?????????? **********/
}    

// Routine du producteur

void * THREAD_Producteur(void * arg) 
{   
    /********** ?????????? **********/
}

// Routine du consommateur 
void * THREAD_Consommateur(void * arg) 
{   
    /********** ?????????? **********/
}

// Programme principal  
int main(void) 
{   
  pthread_t thread_prod;
  pthread_t thread_cons;
  long stat_prod;
  long stat_cons;

  Buffer * buf = CreerBuffer();   
  pthread_create(&thread_prod,NULL,THREAD_Producteur,(void *) buf);


  pthread_create(&thread_cons,NULL,THREAD_Consommateur,(void *) buf);
  pthread_join(thread_prod, (void**) &stat_prod);
  pthread_join(thread_cons, (void**) &stat_cons);

}
