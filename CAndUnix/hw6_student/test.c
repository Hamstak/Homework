#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <string.h>
//#include </usr/include/crpyt.h>
 int main(void){
   int a = 'a';//97
   int z = 'z';//122
   char *str;
   str = "$1$6gMKIopE$I.zkP2EvrXHDmApzYoV.B.";
   int b = strlen(str) + 1;
   printf("%d, %d, %d\n", a, z, b);
   return 1;
 }