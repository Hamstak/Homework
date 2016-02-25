#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <assert.h>

#include "HashTable.h"

HashTable create_table(int size){
  HashTable *newTable;
  int i;
  assert(size > 0);

  if (table = malloc(sizeof(HashTable) == NULL){
    return NULL;
  }

  if (newTable->table = malloc(sizeof(list) * size) == NULL) {
    return NULL;
  }

  for (i = 0; i < size; i++) {
    newTable->table[i] = NULL;
  }

  newTable->size = size;

  return newTable;
}

void table_destroy(HashTable *hashTable){
  int i;
  for (i = 0; i < hashTable->size; i++) {
    if (hashTable->table[i] != NULL) {
      list_destroy(hashTable->table[i])
    }
  }
}

int table_hash(HashTable *hashTable, void *key){
  return (int)key % hashTable->size;
}
