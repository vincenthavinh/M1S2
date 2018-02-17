#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int i=0;
pthread_t th1;

void* fun_fils(void* rien){
	sleep(5);
	printf("je suis le fils de pid = %d\n", getpid());
	printf("i vaut %d\n", i);
	
}

int main(void){
	
	/*QUESTION1
	int i = 0;
	int pid = fork();
	if(pid !=0){
		printf("je suis le père (pid = %d).\n", getpid());
		printf("entre la valeur de i : ");
		scanf("%d", &i);
		printf("i vaut %d\n", i);
	}else{
		sleep(5);
		printf("\nje suis le fils (pid = %d), i vaut %d\n", getpid(), i);
	}*/


	/*QUESTION3/*/
	void* status;
	pthread_create(&th1, NULL, fun_fils, NULL);
	printf("je suis le père (pid = %d).", getpid());
	printf("entre la valeur de i : ");
	scanf("%d", &i);
	printf("i vaut %d\n", i);
	pthread_join(th1, &status);
}
