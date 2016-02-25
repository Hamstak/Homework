
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hw5.h"

FILE* openFile(){
   char fileName[100];
   while(1){
      printf("Enter the name of the input file -> ");
      scanf("%s",fileName);
      FILE * fin = fopen(fileName,"r");
      if (fin)
         return fin;
      printf("File not found. ");
   }
   return NULL;
}
int menu(){
   printf("1. Print the array sorted by street\n2. Print the array sorted by city\n3. Print the array sorted by state and then city\n4. Print the array sorted by zip\n5. Quit\n Enter your choice ->");
   int choice;
   if (scanf("%d",&choice) > 0 && (choice > 0 && choice < 6))
      return choice;
   printf("The choice was invalid, please enter an integer between 1 and 6\n");
   return menu();
}

Address * fillArray(int * total, FILE * fin){
   char temp[100];
   *total = 0;
   while(fgets(temp,99,fin)){
      (*total)++;
   }
   rewind(fin);
   char** array = malloc((*total) * sizeof(char*));
   int i;
   for(i = 0; i < (*total); i++){
      array[i] = malloc(100 * sizeof(char));
      fgets(array[i], 99, fin);
   }
   Address * addresses = (Address*)malloc(((*total)/4) * sizeof(Address));
   int j = 0;
   for (i = 0; i < (*total); i += 4){
      addresses[j].street = malloc((strlen(array[i]) + 1)*sizeof(char));
      strcpy(addresses[j].street, array[i]);
      addresses[j].city = malloc((strlen(array[i + 1]) + 1) * sizeof(char));
      strcpy(addresses[j].city, array[i + 1]);
      addresses[j].state = malloc((strlen(array[i + 2]) + 1) * sizeof(char));
      strcpy(addresses[j].state, array[i + 2]);
      addresses[j].zip = atoi(array[i + 3]);
      j++;
   }
   for (i = 0; i < (*total); i++){
      free(array[i]);
   }
   free(array);
   (*total) = (*total)/4;
   return addresses;
}
void printStreetSortedArray(Address * array, int total){
   int posFill;
   Address temp;
   int indexSmallest;
   for (posFill = 0; posFill < total; posFill++){
      indexSmallest = posFill;
      int curr;
      for(curr = posFill + 1; curr < total; curr++){
         if(strlen(array[indexSmallest].street) < strlen(array[curr].street)){
            int i;
            for (i = 0; i < strlen(array[curr].street); i++){
               char temp1, temp2;
               temp1 = array[indexSmallest].street[i];
               temp2 = array[curr].street[i];
               if (temp1 < temp2){
                  break;
               }else if (temp1 > temp2){
                  indexSmallest = curr;
                  break;
               }
            }
         }else{
            int i;
            for (i = 0; i < strlen(array[curr].street); i++){
               char temp1, temp2;
               temp1 = array[indexSmallest].street[i];
               temp2 = array[curr].street[i];
               if (temp1 < temp2){
                  break;
               }else if (temp1 > temp2){
                  indexSmallest = curr;
                  break;
               }
            }
         }   
      }
      temp = array[indexSmallest];
      array[indexSmallest] = array[posFill];
      array[posFill] = temp;
   }
   int i;
   for (i = 0; i < total; i++){
      printf("%s%s%s%d\n\n",array[i].street,array[i].city,array[i].state,array[i].zip);
   } 
}
void printCitySortedArray(Address * array, int total){
   int posFill;
   Address temp;
   int indexSmallest;
   for (posFill = 0; posFill < total; posFill++){
      indexSmallest = posFill;
      int curr;
      for(curr = posFill + 1; curr < total; curr++){
         if(strlen(array[indexSmallest].city) < strlen(array[curr].city)){
            int i;
            for (i = 0; i < strlen(array[curr].city); i++){
               char temp1, temp2;
               temp1 = array[indexSmallest].city[i];
               temp2 = array[curr].city[i];
               if (temp1 < temp2){
                  break;
               }else if (temp1 > temp2){
                  indexSmallest = curr;
                  break;
               }
            }
         }else{
            int i;
            for (i = 0; i < strlen(array[curr].city); i++){
               char temp1, temp2;
               temp1 = array[indexSmallest].city[i];
               temp2 = array[curr].city[i];
               if (temp1 < temp2){
                  break;
               }else if (temp1 > temp2){
                  indexSmallest = curr;
                  break;
               }
            }
         }   
      }
      temp = array[indexSmallest];
      array[indexSmallest] = array[posFill];
      array[posFill] = temp;
   }
   int i;
   for (i = 0; i < total; i++){
      printf("%s%s%s%d\n\n",array[i].street,array[i].city,array[i].state,array[i].zip);
   } 
}
void printStateCitySortedArray(int total, Address * array){
   int posFill;
   Address temp;
   int indexSmallest;
   int sorted;
   for (posFill = 0; posFill < total; posFill++){
      indexSmallest = posFill;
      int curr;
      for(curr = posFill + 1; curr < total; curr++){
         int x;
         sorted = 0;
         for (x = 0; x < 2; x++){
            if (array[indexSmallest].state[x] < array[curr].state[x]){
               sorted = 1;
               break;
            }else if (array[indexSmallest].state[x] > array[curr].state[x]){
               indexSmallest = curr;
               break;
            }
         }
         if (indexSmallest != curr && !sorted ){
            if(strlen(array[indexSmallest].city) < strlen(array[curr].city)){
               int i;
               for (i = 0; i < strlen(array[curr].city); i++){
                  char temp1, temp2;
                  temp1 = array[indexSmallest].city[i];
                  temp2 = array[curr].city[i];
                  if (temp1 < temp2){
                     break;
                  }else if (temp1 > temp2){
                     indexSmallest = curr;
                     break;
                  }
               }
            }else{
               int i;
               for (i = 0; i < strlen(array[curr].city); i++){
                  char temp1, temp2;
                  temp1 = array[indexSmallest].city[i];
                  temp2 = array[curr].city[i];
                  if (temp1 < temp2){
                     break;
                  }else if (temp1 > temp2){
                     indexSmallest = curr;
                     break;
                  }
               }
            }
         }   
      }
      temp = array[indexSmallest];
      array[indexSmallest] = array[posFill];
      array[posFill] = temp;
   }
   int i;
   for (i = 0; i < total; i++){
      printf("%s%s%s%d\n\n",array[i].street,array[i].city,array[i].state,array[i].zip);
   } 

}
void printZipSortedArray(int total, Address * array){
   int posFill;
   Address temp;
   int indexSmallest;
   for (posFill = 0; posFill < total; posFill++){
      indexSmallest = posFill;
      int curr;
      for(curr = posFill + 1; curr < total; curr++){
         if (array[indexSmallest].zip > array[curr].zip){
            indexSmallest = curr;
         }
      }
      temp = array[indexSmallest];
      array[indexSmallest] = array[posFill];
      array[posFill] = temp;
   }
   int i;
   for (i = 0; i < total; i++){
      printf("%s%s%s%d\n\n",array[i].street,array[i].city,array[i].state,array[i].zip);
   } 

}
void cleanUp(Address * array, int total){
   int i;
   for (i = 0; i < total; i++){
      free(array[i].street);
      free(array[i].city);
      free(array[i].state);
   }
   free(array);
}
