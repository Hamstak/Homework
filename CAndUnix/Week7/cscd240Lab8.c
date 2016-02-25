#include <stdio.h>
#include <stdlib.h>
#define R 5
#define C 4

int main(int argc, const char * argv[])
{
    
    int i, j, walk = 0;
    int **grades = (int **)malloc(R * sizeof(int *));  //Assume that value of this entire expression is 0x7fb322403930
 
    // allocate memory for each row for test purpose, otherwise we should do the following in a loop
    grades[0] = (int *) malloc( C * sizeof(int) );        //Assume that value of this entire expression is 0x7fb3224000e0
    grades[1] = (int *) malloc( C * sizeof(int) );        //Assume that value of this entire expression is 0x7fb322401f50
    grades[2] = (int *) malloc( C * sizeof(int) );
    grades[3] = (int *) malloc( C * sizeof(int) );
    grades[4] = (int *) malloc( C * sizeof(int) );

    for( i = 0; i < R; i ++)
    {
        for(j = 0; j < C; j ++)
        {
            grades[i][j] = walk ++;
        }
    }

    int **pptr = grades;
    printf("-1: pptr= %p\n", pptr);
    printf("-1: &pptr[0] = %p\n", &pptr[0] );
    printf("-1: pptr+1= %p\n", pptr + 1);
    printf("-1: pptr+2= %p\n", pptr + 2);
    
    printf("\n\n");
    
    printf("0: pptr[0]= %p\n", pptr[0]);
    printf("0: *pptr= %p\n", *pptr);
    printf("0: &pptr[0][0]= %p\n", &pptr[0][0]);

    printf("\n\n");
    
    printf("1: pptr[1]= %p\n", pptr[1]);
    printf("1: *(pptr + 1)= %p\n", *(pptr + 1));
    printf("1: &pptr[1][0] = %p\n", &pptr[1][0] );
    
    printf("\n\n");
    
    printf("2: *pptr + 1 = %p\n", *pptr + 1);
    printf("2: *(pptr+0) + 1 = %p\n", *(pptr + 0) + 1);
    printf("2: &pptr[0][1] = %p\n", &pptr[0][1] );
    
    printf("\n\n");
    printf("3: *(pptr[1] + 1) = %d\n", *(pptr[1] + 1) );
    printf("3: *( *(pptr + 1) + 1) = %d\n", *( * (pptr + 1) + 1) );
    printf("3: pptr[1][1] = %d\n", pptr[1][1] );
    
    return 0;
} //end of main
