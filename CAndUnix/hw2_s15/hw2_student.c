//
//  main.c
//  Median
//
//

#include <stdio.h>
#include <stdlib.h>

int * readNumbers( int * total );
int computeMedian(int *p, int n);

// Please do not change main() function

int main(int argc, const char * argv[])
{

    int n ; // the number of positive integers you input,
            // it will be brought back by using call-by-reference next line.
    int * arr = readNumbers( & n );
    
    if( arr != NULL && n > 0 ) {
    
        int median = computeMedian(arr, n);
        printf("The median for the group of numbers you input is: %d \n", median );
    }
    else{
        
        printf("No positive number has been input! \n");
    }
    
    free(arr); //deallocate what arr points to.
    
    return 0;
}


/**
 * The function continuously reads in postive integer numbers ( or zero )
 * from the starndard input, until users input (-1).
 * The group of positive numbers(or zero) are saved into a dynamic array,
 * a piecie of memory that is dynamically allocated in this function.
 *
 * The function returns the pointer that points to the array of postive
 * numbers(or zero). The function returns NULL if no positive number(or zero) is inputted,
 * that is, you first input a -1 on stardout.
 *
 * You do not need to check whether an input is postive(or zero) or not, except for checking -1 used to
 * terminate the input. You can safely ASSUME all inputs are postive numbers ( or zero ) except for the
 * last -1 input.
 *
 *
 * Note: all memory (elements) in the returned dynamic array have to be used,
 * which means no memory in the returned dynamic array is wasted and vacant.
 * The returned array has the exact amount of spaces to hold all inputted positive numbers(or zero).
 * Note: in your program you can assume there is no more than 1000 numbers that
 * uers will input on starndard input.
 */
int * readNumbers( int * total )
{
}




/**
 * The function takes an array of postivie numbers, pointed by p,
 * the size of the array is specified by n.
 *
 * The function first sorts the array p, then computes and returns the median number in p.
 * The median number can be calculated using the following equations AFTER p is sorted.
 * Note: you can sort the array by using any sorting algorthims you know.
 *
 * Assuming the array p is sorted and is of length n,
 * If n is odd then the median is p[(n-1)/2].
 * If n is even than the median is ( p[n/2] + p[(n/2)-1] ) / 2.
 *
 */
int computeMedian(int *p, int n)
{
}




