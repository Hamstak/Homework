#include <stdio.h>
#include <stdlib.h>

int * foo1(int n)
{
    int *p =(int *) malloc( n * sizeof(int) );
    int i;
   
    for( i = 0; i < n; i ++ )
        *(p + i) = i;

    return p;
}

int * foo2(int n)
{
    int a[100], i; 
    int *p = a;

    for( i = 0; i < 100; i ++)
        *(p + i) = i;

    return p;
}

int * foo3(int n)
{
    int a[100], i;

    for( i = 0; i < 100; i ++)
        *( a + i) = i;

    return a;
}

void foo4(int *n)
{
    int b = 10;
    n = &b;
}


void foo5(int *n)
{
    int b = 10;
    *n = b;
}

int * foo6( int *n )
{
    int b = 10;
    b = *n;

    return &b;
}


int main()
{

   return 0; 
}


