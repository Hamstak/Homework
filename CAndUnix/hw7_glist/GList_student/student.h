//
//  student.h
//  GenericList
//
//  Created by Tony Tian on 11/19/14.
//  Copyright (c) 2014 Tony Tian. All rights reserved.
//

#ifndef GenericList_student_h
#define GenericList_student_h


typedef struct
{
    int id;
    char *name;
} student;


int compStudent(void * a, void * z);

void printStudent(void * a);

void freeStudent(void * a);

#endif
