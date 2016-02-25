#ifndef LINKED_LIST_H
#define LINKED_LIST_H

//common free function
typedef void (*freeFunction)(void *);

typedef enum {TRUE, FALSE} bool;

typedef bool (*listIterator)(void *);

typedef bool (*listFold)(void *, void *);

typedef int (*listSort)(void *, void *);

typedef bool (*listExpression)(void *);

typedef struct _listNode {
  void *data;
  struct _listNode *next;
}listNode;

typedef struct {
  int size;
  int nodeSize;
  listNode *head;
  listNode *tail;
  freeFunction freeFn;
}list;

void list_new(list *list, int nodeSize, freeFunction freeFn);
void list_destroy(list *list);

void list_prepend(list *list, void *element);
void list_append(list *list, void *element);
int list_size(list *list);

void list_fold(list *list, void *accumulator, listFold fold);
void list_take_while(list *list, list *taken, listExpression exp)

void list_map(list *list, listIterator iterator);
void list_head(list *list, void *element, bool removeFromList);
void list_tail(list *list, void *element);

void list_sort(list *list, listSort sort);
void split(list *list, list *firstHalf, list *secondHalf);
void merge(list *list, list*firstHalf, list*secondHalf, listSort sort);

void element_free(void *element);
#endif
