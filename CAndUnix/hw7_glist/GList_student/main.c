//
//  main.c
//  GenericList
//
//  Created by Tony Tian on 11/19/14.
//  Copyright (c) 2014 Tony Tian. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "List.h"
#include "student.h"
#include "typeUtil.h"

#define Num 8
#define Size 100


int main(int argc, const char * argv[])
{
    
    //static array first
    student temp[Num] = {{7,"able"}, {1,"band"}, {4,"cat"}, {3,"dog"}, {2,"ele"}, {5, "find"}, {6, "good"}, {0, "hello"}};
    student *data[Num];
    
    int i = 0;
    student *cur;
    
    //copy data into dynamic array
    //set up for tests
    for(; i < Num; i ++)
    {
        cur = (student *) malloc(sizeof(student)); //each student object takes a piece of mem
        cur->id = temp[i].id;
        cur->name = (char *) malloc(Size * sizeof(char));
        strcpy(cur->name, temp[i].name);
        data[i] = cur;
    }
    
    List slist;
    init(&slist, compStudent, printStudent, freeStudent);
    
    for(i = 0; i < Num; i ++ )
    {
        slist = addFirst(slist, (void *) data[i]);
    }
    printf("------Original List:------\n");
    // print out the list
    printList(&slist);
    
    //sort
    slist = sort(slist);
    
    printf("------After sorted:------\n");
    //print again
    printList(&slist);
    
    removeNode(&slist, (void *)&temp[4]);
    printf("------After removed student with id = 2:------\n");
    printList(&slist);
    
    printf("------Now start to free all memory!\n");
    //free the whole list
    freeList(&slist);
    
    return 0;
}


/*

int main(int argc, const char * argv[])
{

    int data[Num] = {7, 1, 4, 3, 2, 5, 6, 0};
    int i = 0;
    
    List slist;
    init(&slist, cmpInt, printInt, freeInt);
    
    for(i = 0; i < Num; i ++ )
    {
        slist = addFirst(slist, (void *) &data[i]);
    }
    // print out the list
    printf("--------------------before int array sort------------\n");
    printList(&slist);
    
    slist = sort(slist);
    printf("--------------------after int array sorted-----------\n");
    printList(&slist);
    
    printf("--------------------now start to free memory!--------\n");
    freeList(&slist);

    return 0;
}
 */

/*
int main(int argc, const char * argv[])
{

    char * temp[Num] = {"able", "band", "cat", "dog", "ele","find", "good", "hello"};
    char *data[Num];
    
    int i = 0;
    for(; i < Num; i ++)
    {
        data[i] = (char *) malloc( Size * sizeof(char) );
        strcpy(data[i], temp[i]);
    }
    
    List slist;
    init(&slist, cmpStr, printStr, freeStr);
    
    for(i = 0; i < Num; i ++ )
    {
        slist = addFirst(slist, (void *) data[i]);
    }
    // print out the list
    printList(&slist);
    freeList(&slist);
    
    return 0;
}
*/





