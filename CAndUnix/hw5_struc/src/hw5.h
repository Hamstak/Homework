
#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    char *street;
    char *city;
    char *state;
    int zip;
}Address;

FILE * openFile();
int menu();
Address * fillArray(int * total, FILE * fin);
void printStreetSortedArray(Address * array, int total);
void printCitySortedArray(Address * array, int total);
void printStateCitySortedArray(int total, Address * array);
void printZipSortedArray(int total, Address * array);
void cleanUp(Address * array, int total);
