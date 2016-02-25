#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100

int parsePipe(char * s, char ***leftSide, char *** rightSide);
void cleanUp(char ** theString);
int count(char ** theString);




int main()
{
	int res, total, x;
	char s[MAX];
	char ** prePipe = NULL, ** postPipe = NULL;

	printf("Please enter a string (exit to exit) ");
	fgets(s, MAX, stdin);

	while(strcmp(s, "exit\n") != 0)
	{
		res = parsePipe(s, &prePipe, &postPipe);

		if(res == -1)
			printf("No PIPE found\n");

		else
		{
			total = count(prePipe);
			printf("prePipe: %s ", prePipe[0]);
			for(x = 1; x < total; x++)
				printf("%s ", prePipe[x]);

			printf("\n\n");

			cleanUp(prePipe);
			prePipe = NULL;


			total = count(postPipe);
			printf("postPipe: %s ", postPipe[0]);
			for(x = 1; x < total; x++)
				printf("%s ", postPipe[x]);

			printf("\n\n");

			cleanUp(postPipe);
			postPipe = NULL;

		}// end else

		printf("Please enter a string (exit to exit) ");
		fgets(s, MAX, stdin);

	}// end while

}// end main

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
	curriedstring[i] = NULL;
  return curriedstring;

}// end makeargs

int parsePipe(char * s, char ***leftSide, char *** rightSide)
{
	int i, b, argcl, argcr;
	argcr, argcl, b = 0;
	for (i = 0; i < strlen(s); i++) {
		if (s[i] == '|' && !((s[0] != '|') || (s[strlen(s)] != '|'))) {
			b = 1;
			break;
		}
	}
	if (b == 0) {
		return -1;
	}else{
		char *token1, *token2;
		char delim[] = "|";
		token1 = strtok(s,delim);
		token2 = strtok(NULL,delim);
		*leftSide = makeargs(token1, &argcl);
		*rightSide = makeargs(token2, &argcr);
	}
	return 1;


}// end parsePipe


void cleanUp(char ** theString)
{
	int i = 0;
	while(*(theString + i) != NULL){
			free(*(theString + i));
			i++;
	}
	free(theString);
}// end cleanUp


int count(char ** theString)
{
	int count = 0;
	while(*(theString + count) != NULL){
		count++;
	}
	return count;

}// end count
