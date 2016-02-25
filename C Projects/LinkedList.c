#include <stdlib.h>
#include <string.h>
#include <assert.h>

#include "LinkedList.h"

void list_new(list *list, int nodeSize, freeFunction freeFn){
  assert(nodeSize > 0);
  list->size = 0;
  list->nodeSize;
  list->head = list->tail = NULL;
  list->freeFn = freeFn;
}

void list_destroy(list *list){
  listNode *curr;
  while (list->head != NULL) {
    curr = list->head;
    list->head = curr->next;
    if (list->freeFn) {
      list->freeFn(curr->data);
    }else{
      free(curr->data);
    }
    free(curr);
  }
}

void list_prepend(list *list, void *element){
  listNode *node = malloc(sizeof(listNode));
  node->data = malloc(list->nodeSize);
  memcpy(node->data, element, list->nodeSize);

  node->next = list->head;
  list->head = node;

  if (!list->tail) {
    list->tail = list->head;
  }
  list->size++;
}

void list_append(list * list, void *element){
  listNode *node = malloc(sizeof(listNode));
  node->data = malloc(list->nodeSize);
  node->next = NULL;

  memcpy(node->data, element, list->nodeSize);
  if(!list->size){
    list->head = list->tail = node;
  }else{
    list->tail->next = node;
    list->tail = node;
  }

  list->size++;
}

void list_map(list *list, listIterator iterator){
  assert(iterator != NULL);

  listNode *node = list->head;
  bool result = TRUE;
  while(node != NULL && result){
    result = iterator(node->data);
    node = node->next;
  }
}

void list_fold(list *list, void *accumulator, listFold fold){
  assert(fold != NULL);

  listNode *node = list->head;
  bool result = TRUE;
  while (node != NULL && result) {
    result = fold(accumulator, node->data);
    node = node->next;
  }
}

void list_head(list *list, void *element, bool removeFromList){
  assert(list->head != NULL);

  listNode *node = list->head;
  memcpy(element, node->data, list->nodeSize);

  if (removeFromList ) {
    list->head = node->next;
    list->size--;

    free(node->data);
    free(node);
  }
}

void list_tail(list *list, void *element){
  assert(list->tail != NULL);

  listNode *node = list->tail;
  memcpy(element, node->data, list->nodeSize);
}

void list_sort(list *list, listSort sort){
  assert(sort != NULL);

  if (list->size <= 1) {
    return;
  }
  list* a, b;
  list_new(a, list->nodeSize, list->freeFn);
  list_new(b, list->nodeSize, list->freeFn);
  split(list, a, b)
  list_sort(a, sort);
  list_sort(b, sort);
  merge(list,a,b,sort);
}

static void split(list *list, list *a, list *b){
  int i = 0;
  listNode *curr = list->head;
  while (i < list->size/2) {
    list->head = list->head->next;
    curr->next = a->head;
    a->head = curr;
    curr = list->head;
    i++;
  }
  while (curr != NULL) {
    list->head = list->head->next;
    curr->next = b->head;
    b->head = curr;
    curr = list->head;
  }
}

void list_take_while(list *list, list *taken, listExpression exp){
  assert(list->head != NULL);

}

static void merge(list *list, list *a, list *b, listSort sort){
  listNode* curra, currb, cyclea, cycleb;
  curra, cyclea = a->head;
  currb, cycleb = b->head;
  do{
    if ( curra != NULL && (currb == NULL || (sort(curra->data, currb->data) < 0))) {
      cyclea = cyclea->next;
      curra->next = list->head;
      list->head = curra;
      curra = cyclea;
    }
    if (currb != NULL) {
      cycleb = cycleb->next;
      currb->next = list->head;
      list->head = currb;
      currb = cycleb;
    }
  }while(curra != NULL && currb != NULL)

}

void element_free(list *list, void *element){
  if (list->freeFn != NULL) {
    list->freeFn(element);
  }else{
    free(element);
  }
}
