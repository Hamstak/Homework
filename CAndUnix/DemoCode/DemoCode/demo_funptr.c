//
//  main.c
//  FunctionPtr
//
//  Created by Tony Tian on 11/23/13.
//  Copyright (c) 2013 Tony Tian. All rights reserved.
//

#include <math.h>
#include <stdio.h>
#include <stdlib.h>

//===================================================================================
//example 1
/*
int max(int x, int y)
{
    return x > y ? x : y;
}

int main(void)
{
    // p is funciton pointer
    int (* p)(int, int) = & max;
    int a, b, c, d;
    
    printf("please input 3 numbers:");
    scanf("%d %d %d", & a, & b, & c);
    
    // equivalent to call，d = max(max(a, b), c)
    d = (* p)(( *p)(a, b), c);
    
    printf("the maxumum number is: %d\n", d);
    
    return 0;
}
*/


//======================================================================================
//example 2

/*
// Function taking a function pointer as an argument
double compute_sum(double (*funcp)(double), double lo, double hi)
{
    double  sum = 0.0;
    
    // Add values returned by the pointed-to function '*funcp'
    for (int i = 0;  i <= 100;  i++)
    {
        double  x, y;
        
        // Use the function pointer 'funcp' to invoke the function
        x = i/100.0 * (hi - lo) + lo;
        y = (*funcp)(x);
        sum += y;
    }
    return (sum/100.0);
}

int main(void)
{
    double  (*fp)(double);      // Function pointer
    double  sum;
    
    // Use 'sin()' as the pointed-to function
    fp = sin;    //functions name like array name acts like the start address of function.
    sum = compute_sum(fp, 0.0, 1.0);
    printf("sum(sin): %f\n", sum);
    
    // Use 'cos()' as the pointed-to function
    fp = cos;
    sum = compute_sum(fp, 0.0, 1.0);
    printf("sum(cos): %f\n", sum);
    return 0;
}

*/

// The benefit of function pointer is that in this example,
// we just implemented a single compute_sum function, which takes into account sin and cos two operations.
// If we do not use function pointer, we have to write two separate function, one is like
// compute_sum_sin and the other is like compute_sum_cos, actually these two function has a lot of code
// in common.

//======================================================================
//Example 3
/*

typedef struct
{
    int data;
    char name[10];
} object;

int object_compare(object * a, object * z)
{
    return a->data < z->data ? 1 : 0;
}

object *maximum(object * begin,object * end,int (* compare)(object *, object *))
{
    object * result = begin;
    while(begin != end)
    {
        if(compare(result, begin))
        {
            result = begin;
        }
        ++ begin;
    }
    return result;
}

int main(void)
{
    object data[8] = {{0,"a"}, {1,"b"}, {2,"c"}, {3,"d"}, {4,"e"}, {5, "f"}, {6, "g"}, {7, "h"}};
    object * max;
    max = maximum(data + 0, data + 8, & object_compare);
    printf("max->data = %d, max->name=%s\n", max->data, max->name);
    return 0;
}
 
 //if you use object_compare() function, and the function
 // sort( object * array, int (* compare )(object *, object *) )
 // can flexibly sort the array in both ascending and descending order in the single function sort().


*/
//==============================================================
//======================================================================
//Example 4


typedef struct
{
    int data;
    char name[10];
} object;

int object_compare(const void * a, const void * z)
{
    const object *b1 = a;
    const object *b2 = z;
    return b1->data - b2->data;  // return 0, positive and negative numbers
                                 // its return is similar to strcmp().
}


int main(void)
{
    object data[8] = {{7,"a"}, {1,"b"}, {4,"c"}, {3,"d"}, {2,"e"}, {5, "f"}, {6, "g"}, {0, "h"}};
    int i = 0;
    object *p = data;
    printf("The Objects in data array before sorting:\n");
    for( i = 0; i < 8; i++, p ++ )
    {
        printf("p->data = %d, p->name=%s\n", p->data, p->name);
    }
    
    p = data;
    qsort( p, 8, sizeof( object), object_compare );
    
    printf("\n\nThe Objects in data array After sorted:\n");
    for( i = 0; i < 8; i++, p ++ )
    {
        printf("p->data = %d, p->name=%s\n", p->data, p->name);
    }

    return 0;
}

// Following is the declaration for qsort() function.
// void qsort(void *base, size_t nitems, size_t size, int (*compar)(const void *, const void*))
//Parameters
//base -- This is the pointer to the first element of the array to be sorted.
//nitems -- This is the number of elements in the array pointed by base.
//size -- This is the size in bytes of each element in the array.
//compar -- This is the function that compares two elements. That requires a function that returns 0 if equal, positive number if first arg is greater than the second arg.









