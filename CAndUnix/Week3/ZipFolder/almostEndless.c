#include <stdio.h>
int main(){
	int x=0;
	while(x<2000000){
		printf("...");
		fflush(stdout);
		sleep(3);
		x ++;
	}
	return 0;
}

