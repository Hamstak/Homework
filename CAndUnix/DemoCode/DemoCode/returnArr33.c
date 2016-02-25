#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* function to generate and return random numbers */
int * getRandom(int *size )
{
  printf("Input how many random number you like to generate:");
  scanf("%d", size);

  int  *r = (int*) malloc( * size * sizeof(int));
  int i;

  /* set the seed */
  srand( (unsigned)time( NULL ) );
  for ( i = 0; i < * size ; ++i)
  {
      *(r + i) = rand() % 101; //generate random number between 0 to 100
     // using *(r + i) in place of r[i] is also work in the previous statement

     printf( "r[%d] = %d\n", i, r[i]);

  }

  return r;
}

/* main function to call above defined function */
int main ()
{
   int *p;
   int i;

   //note here: we did not initialize arrSize
   int arrSize;

   p = getRandom( &arrSize );// IS This CORRECT?
   for ( i = 0; i < arrSize; i++ )
   {
       printf( "*(p + %d) : %d\n", i, *(p + i));
       //printf( "*(p + %d) : %d\n", i, p[i] );
   }

   return 0;
}
