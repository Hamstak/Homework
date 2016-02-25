//
//  List.c
//  GenericList
//
//  Created by Tony Tian on 11/19/14.
//  Copyright (c) 2014 Tony Tian. All rights reserved.
//
#include <stdio.h>
#include <stdlib.h>

#include "List.h"

// Call by reference
// This is a linked list without dummy head node!
void init(List *alist, int (*fComp)(void *, void *), void (*fPrint)(void *), void (*fFree)(void *))
{
    if(alist != NULL)
    {
        alist->head = NULL;
        alist->tail = NULL;
        alist->size = 0;
        alist->cmpData = fComp;
        alist->printData = fPrint;
        alist->freeData = fFree;
    }
    else
    {
        printf("Invalid NULL list pointer passed in!\n");
    }
}

Node * newNode(void * elem)
{
    Node *temp = (Node *)malloc(sizeof(Node));
    temp->data = elem;
    temp->next = NULL;
    return temp;
}

void printList(const List *alist)
{
    Node *cur = alist->head;
    while (cur)
    {
        (alist->printData)(cur->data);
        if(cur->next != NULL)
            printf("-->\n");
        cur=cur->next;
    }
    printf("\n");
    
}

void freeList(List *alist)
{
    Node *cur = alist->head;
    Node *temp;
    
    while (cur != NULL)
    {
        temp = cur;
        cur = cur->next;
        (alist->freeData)(temp->data);
        free(temp);
    }
}

List addFirst(List alist, void *toAdd)
{
    Node *nn = newNode(toAdd);
    
    if(alist.head == NULL) // or use if( ! alist.head )
    {
        alist.head = nn;
        alist.tail = nn;
    }
    else
    {
        nn->next = alist.head;
        alist.head = nn;
    }
    alist.size ++;
    
    return alist;
}

//
List sort(List alist)
{
    Node *min, *start = alist.head, *cur;
    void *temp;
    if (alist.size == 0)   return alist;
    
    for(; start->next != NULL; start = start->next)
    {
        min = start;
        for( cur = start->next; cur != NULL; cur = cur->next) {
            if ( alist.cmpData( cur->data, min->data ) < 0 )
                min = cur;
        }
        //swap
        temp = start->data;
        start->data = min->data;
        min->data = temp;
    }
    return alist;
}

// This function uses call by reference.
// It removes the first occurence of the node that contains an object obj in the List.
// obj points to the object that will be removed from the list pointed to by alist.
// if obj exists in alist, you remove the list node and return 1, otherwise return 0;
// Hint: you have to use the function pointer cmpData to compare whether obj equals to the data
// in the current list node when you go through each node in the list.
// Requirement: no memory leak please. After you remove the node, if any, please free all related
// memory. Check memory leak by using valgrind on the cslinux machine!
// Hint: please first understand the entire program, including the main() function!
// Please do not change the signature of this function
int removeNode(List *alist, void *obj)
{
   if (!(alist->size))
      return 0;
   if(alist->cmpData(alist->head->data, obj) == 0){
      Node* toRmv = alist->head;
      alist->head = alist->head->next;
      alist->freeData(toRmv->data);
      free(toRmv);
      alist->size--;
      return 1;
   }
   Node* prev = alist->head;
   Node* curr = alist->head->next;
   while(curr){
      if (alist->cmpData(curr->data,obj) == 0){
         Node* toRmv = curr;
         prev->next = curr->next;
         alist->freeData(toRmv->data);
         free(toRmv);
         alist->size--;
         return 1;
      }else{
         curr = curr->next;
         prev = prev->next;
      }
   }
   return 0;
}






