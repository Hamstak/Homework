#include <stdio.h>
#include <limits.h>

void myMax1( int *arr, int *max, int n );
int myMax2( int *arr, int n );

int main()
{
    int a[] = {5, 3, 12, 6, 0, 24, 17, 8, 2, 6};
    int len = sizeof(a) / sizeof(int);  //NOTE: this usage does NOT work with dynamic arrays,
					//Here a is an static array initialized with curly braces.
   
    int m; //used to hold the maximum number in the array
    myMax1(a,&m,len);
    
    
    printf("The max number returned by myMax1 in array a is %d\n", m);
    
    m = 0; // reset m to zero for next function call
    m = myMax2(a,len);
    
    
    printf("The max number returned by myMax2 in array a is %d\n", m);
}

// Using call by reference, we bring the maximal number in the input array arr
// outside of the function myMax1.
// Your program has to search the array to find the maximum number in array.
// arr is the input array,
// max is the a pointer pointing to variable that holds the maximum number in array
// n is the length of the input array arr 
void myMax1( int *arr, int *max, int n )
{
   *max = arr[0];
   int i;
   for (i = 0; i < n; i++){
      if (arr[i] > *max)
         *max = arr[i];
   }
}


// myMax2 take the input array arr of size n,
// and search the array to find the maximum number in array,
// then return the maximum number using return statement.
int myMax2( int *arr, int n )
{
   int temp = 0;
   int i = 0;
   for(i = 0; i < n; i++){
      if(arr[i] > temp)
         temp = arr[i];
   }
   return temp;
}
