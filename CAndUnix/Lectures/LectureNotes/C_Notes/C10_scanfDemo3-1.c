#include <stdio.h>
int main( )
{
   char str[100];
   int i, j;
   char c;

   printf( "Enter a character :");
   scanf("%c", &c); //

   while( c != 'q' && c != 'Q' )
   { 
       printf( "You entered: \"%c\"\n",c);
       
       printf( "Enter a character :");
       scanf("%c", &c); //

   }       


   return 0;
}
