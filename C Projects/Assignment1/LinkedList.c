#include <stdlib.h>
#include <string.h>
#include <assert.h>

#include "list.h"

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
      list->freeFn(current->data);
    }

    free(curr->data);
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
