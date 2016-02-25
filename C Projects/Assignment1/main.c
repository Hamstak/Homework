#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "LinkedList.h"
#include "football.h"
#include "HashTable.h"

int stringcompare(void *, void *);

int main(int argc, const char *argv[]){
  int i;
  HashTable *table;
  char str[15];
  table = malloc(sizeof(HashTable));
  table->table = malloc(sizeof(list) * 100);
  for (i = 0; i < 100; i++) {
    sprintf(str, "%d", i);
    table_set(table, str, str);
    printf("%s\n", table_get(table, str, stringcompare)
  }
}

int stringcompare(void *one, void *two){
  char *str = (char*) one;
  char *str1 = (char*) two;
  return strcmp(str, str1);
}
