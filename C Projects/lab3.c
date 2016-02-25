#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

#define MAX 100

void clean(int argc, char **argv);
void printargs(int argc, char **argv);
char ** makeargs(char *s, int * argc);
void forkIt(char ** argv);


int main()
{
	char **argv = NULL, s[MAX];
	int argc;

	printf("Please enter a command (exit to exit) ");
	fgets(s, MAX, stdin);

 	while(strcmp(s, "exit\n") != 0)
  	{
		argv = makeargs(s, &argc);
  		if(argc != -1)
  		{
    			printf("There are %d tokens.\nThe tokens are:\n", argc);
    			printargs(argc, argv);
		}// end if

		forkIt(argv);

  		clean(argc, argv);
  		argv = NULL;

		printf("Please enter a command (exit to exit) ");
		fgets(s, MAX, stdin);

	}// end while

}// end main

void clean(int argc, char **argv)
{
	int i;
	for (i = 0; i < argc; i++) {
		free(argv[i]);
	}
	free(argv[i]);
	free(argv);
}// end clean

void printargs(int argc, char **argv)
{
	int x;
	for(x = 0; x < argc; x++)
		printf("%s\n", argv[x]);

}// end printargs

char ** makeargs(char *s, int * argc)
{
	*argc = 0;
	char tempstring[100][100];
	char **curriedstring;
	char delim[] = " ";
	char *token;
	s[strlen(s) - 1] = '\0';
	token = strtok(s, delim);
	while(token != NULL && token[0] != '\n'){
		strcpy( tempstring[*argc],token);
		(*argc)++;
		//printf("%d %s\n", *argc, token);
		token = strtok(NULL, delim);
	}
	int i;
	for ( i = 0; i < *argc; i++) {

		printf("%s\n", tempstring[i]);
	}
	curriedstring = malloc((*argc + 1) * sizeof(char*));
	for ( i = 0; i < *argc ; i++) {
		curriedstring[i] = malloc((strlen(tempstring[i]) + 1) * sizeof(char));
		strncpy(curriedstring[i], tempstring[i], strlen(tempstring[i]) + 1);
	}
	//curriedstring[i-1][strlen(curriedstring[i-1])] = '\0'
	curriedstring[i] = (char *)NULL;
  return curriedstring;

}// end makeArgs

void forkIt(char ** argv)
{
	int status;
	pid_t pid = fork();
	if (pid > 0) {
		 wait(&status);
	}else if (pid == 0){
		execvp(argv[0], argv);
		perror("execvp");
		exit(1);
	}else{
		printf("Fork failed! Feel bad!");
	}

}// end forkIt
