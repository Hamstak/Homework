#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 1000

void clean(int argc, char **argv)
{
	int i;
	for ( i = 0; i < argc; i++) {
		free(argv[i]);
	}
	free(argv);
}

void printargs(int argc, char **argv)
{
	int x;
	for(x = 0; x < argc; x++)
		printf("%s\n", argv[x]);
}

char ** makeargs(char *s, int * argc)
{
	char tempstring[100][100];
	char **curriedstring;
	char delim[] = " \t";
	char *token;
	token = strtok(s, delim);
	while(token){
		strcpy( tempstring[*argc],token);
		(*argc)++;
		//printf("%d %s\n", *argc, token);
		token = strtok(NULL, delim);
	}
	curriedstring = malloc(*argc * sizeof(char*));
	int i;
	for ( i = 0; i < *argc ; i++) {
		curriedstring[i] = malloc((strlen(tempstring[i]) + 1) * sizeof(char));
		strncpy(curriedstring[i], tempstring[i], strlen(tempstring[i]) + 1);
	}
   return curriedstring;

}// end makeArgs


int main()
{
  char **argv = NULL, s[] = "ls -l file";
  int argc=0;

  argv = makeargs(s, &argc);
  if(argc != -1)
  {
    printf("There are %d tokens.\nThe tokens are:\n", argc);
    printargs(argc, argv);

  }// end if

  clean(argc, argv);
  argv = NULL;

}// end main
