//
//  List.h
//  GenericList
//
//  Created by Tony Tian on 11/19/14.
//  Copyright (c) 2014 Tony Tian. All rights reserved.
//

#ifndef GenericList_List_h
#define GenericList_List_h

typedef struct node
{
    void *data;   //generic pointer data
    struct node *next;
}Node;

typedef struct
{
    Node *head;
    Node *tail;
    
    int (*cmpData)(void *, void *);
    void (*printData)(void *);
    void (*freeData)(void *);
    
    int size;
}List;


void init(List *alist, int (*fComp)(void *, void *), void (*fPrint)(void *), void (*fFree)(void *));

Node * newNode(void * elem);
void printList(const List *alist);
void freeList(List *alist);
List addFirst(List alist, void *toAdd);
List sort(List alist);
int removeNode(List *alist, void *obj);


#endif
