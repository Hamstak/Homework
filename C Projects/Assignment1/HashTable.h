#ifndef HASH_TABLE
#define HASH_TABLE
#include "LinkedList.h"

typedef bool (*comparator)(void *, void *);

typedef struct _HashTable{
  int size;
  list **table;
}HashTable;

typedef struct _tableNode{
  void* key;
  void* value;
}

HashTable table_create(int size);
void table_destroy(HashTable *hashTable);

void table_set(HashTable *hashTable, void *key, void *value);
void table_get(hashTable *hashTable, void *key, void *value, comparator keyCompare);
void table_destroy_node(HashTable *hashTable, void *key);

#endif
