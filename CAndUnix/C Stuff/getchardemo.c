#include <stdio.h>
int main(){
	int c = 0;
	printf("Enter a value: ");
	c = getchar();

	clearbuffer();

	while (c != 'q' && c != 'Q'){
		printf("You entered: ");
		putchar(c);
		printf("\n");

		printf("Enter a value: ");
		c = getchar();

		clearbuff();
	}
}

void clearbuffer(){
	while(getchar() != '\n'){
	}
}
