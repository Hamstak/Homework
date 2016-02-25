//
//  typeUtil.c
//  GenericList
//
//  Created by Tony Tian on 11/19/14.
//  Copyright (c) 2014 Tony Tian. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "typeUtil.h"


void printStr(void * str)
{
    char *temp = (char *)str;
    printf("%-5s", temp);
}


void printInt(void * i)
{
    int *temp = (int *) i;  //explicit type cast
    printf("%d", *temp);
}

int cmpStr(void *s1, void *s2)
{
    return strcmp((char *)s1, (char *)s2);
}

int cmpInt(void *s1, void *s2)
{
    return *((int *)s1) - *((int *)s2);
}

void freeStr(void * str)
{
    char *temp = str;     //implicit type cast
    free(temp);
}

void freeInt(void * i)
{
    return;
}



