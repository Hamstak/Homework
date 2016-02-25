#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX_GUESSES 15
int main(){
	char playAgain;
	char name[25];	
	int theNum, guess, count;
	
	printf("Please enter your name: ");
	scanf("%s",name);
	while(getchar() != '\n'){}	
	do{
		srand(time(NULL));
		theNum = (rand() % 100) + 1;
		//printf("%d\n", theNum);
		count = 0;
		do{
			printf("%s, please enter a guess between 1 and 100: ",name);	
			scanf("%d",&guess);
			count ++;
			while(getchar() != '\n'){}
			if (guess > theNum)
				printf("Too high!\n");
			else if(guess < theNum)
				printf("Too low!\n");
			else
				printf("%s, you guessed the number %d in %d guesses.\n",name,theNum,count);
		}while (guess != theNum && count < MAX_GUESSES);
		if (count == MAX_GUESSES)
			printf("%s, you failed to guess the correct number in %d guesses.\n",name,MAX_GUESSES);
		printf("Would you like to play again? ");
		playAgain = getchar();
		while(getchar() != '\n'){}
	}while(playAgain == 'y');
	return 0;
}