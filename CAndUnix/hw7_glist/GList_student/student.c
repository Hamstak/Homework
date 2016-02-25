//
//  student.c
//  GenericList
//
//  Created by Tony Tian on 11/19/14.
//  Copyright (c) 2014 Tony Tian. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

#include "student.h"

int compStudent(void * a, void * z)
{
    student *b1 = (student *)a;
    student *b2 = (student *)z;
    return b1->id - b2->id;     // return 0, positive and negative numbers
                                // its return is similar to strcmp().
}


void printStudent(void * a)
{
    student *temp = a;
    if (temp)
    {
        printf("ID: %d, Name: %s", temp->id, temp->name);
    }
}


void freeStudent(void *a)
{
    student *temp = a;
    if(temp)
    {
        free(temp->name);
        temp->name = NULL;
    }
    free(temp);
}


