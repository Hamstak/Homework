#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <string.h>
#include "pgmUtility.h"

int usage(const char* test);

int main(int argc, const char* argv[]){
     if (argc == 5){
      if (argv[1][1] == 'e'){
         int e = atoi(argv[2]);
         if (strcmp(argv[3],argv[4]) == 0)
            return usage("file");
         FILE* fin = fopen(argv[3],"r");
         if (fin == NULL){
            printf("Usage: oldImageFile must reference an existing file");
            return 0;
         }
         FILE* fout = fopen(argv[4],"w+");
         char** header = malloc(4 * sizeof(char*));
         int i;
         for (i = 0; i < 4; i++){
            header[i] = malloc(maxSizeHeadRow * sizeof(char));
         }
         int rows;
         int cols;
         int** pixels = pgmRead(header, &rows, &cols, fin);
         if(pgmDrawEdge(pixels, rows, cols, e, header)){
            printf("Edge was drawn!\n");
         }else{
            printf("Nothing was changed!\n");
         }
         pgmWrite((const char**)header, (const int**)pixels, rows, cols, fout);
         for (i = 0; i < 4; i++){
            free(header[i]);
         }
         free(header);
         for(i = 0; i < rows; i++){
            free(pixels[i]);
         }
         free(pixels);
         fclose(fin);
         fclose(fout);
         printf("Processing was successful!\n");
         return 0;
      }else{
         return usage("arg");
      }
   }else if (argc == 7){
      if (argv[1][1] == 'c'){
         int centerRow = atoi(argv[2]);
         int centerCol = atoi(argv[3]);
         int radius = atoi(argv[4]);
         if ((centerRow == 0 && argv[2][0] != '0') || (centerCol == 0 && argv[3][0] != '0') || radius == 0){
            return usage(argv[1]);
         }
         if (strcmp(argv[5],argv[6]) == 0)
            return usage("file");
         FILE* fin = fopen(argv[5],"r");
         if (fin == NULL){
            printf("Usage: oldImageFile must reference an existing file\n");
            return 0;
         }
         FILE* fout = fopen(argv[6],"w+");
         char** header = malloc(4 * sizeof(char*));
         int i;
         for (i = 0; i < 4; i++){
            header[i] = malloc(maxSizeHeadRow * sizeof(char));
         }
         int rows;
         int cols;
         int** pixels = pgmRead(header, &rows, &cols, fin);
         int pgmc = pgmDrawCircle(pixels, rows, cols, centerRow, centerCol, radius, header); 
         if (pgmc){
            printf("Circle was partially or compeletely drawn!\n");
         }else{
            printf("Nothing was changed!\n");
         }
         pgmWrite((const char**)header, (const int**)pixels, rows, cols, fout);
         for (i = 0; i < 4; i++){
            free(header[i]);
         }
         free(header);
         for(i = 0; i < rows; i++){
            free(pixels[i]);
         }
         free(pixels);
         fclose(fin);
         fclose(fout);
         printf("Processing was successful!\n");
         return 0;
      }else{
         return usage("arg");
      }
   }else if (argc == 8 || argc == 9){
      int adj;
      if (argc == 8)
         adj = 0;
      else
         adj = 1;
      if ((argv[1][1] == 'c' && argv[2][1] == 'e') || (strlen(argv[1]) == 3 && argv[1][1] == 'c' && argv[1][2] == 'e')){
         int centerRow = atoi(argv[2+adj]);
         int centerCol = atoi(argv[3+adj]);
         int radius = atoi(argv[4 + adj]);
         int edge = atoi(argv[5 + adj]);
         if (strcmp(argv[6 + adj],argv[7 + adj]) == 0)
            return usage("file");
         FILE* fin = fopen(argv[6 + adj],"r");
         if (fin == NULL){
            printf("Usage: oldImageFile must reference an existing file!\n");
            return 0;
         }
         FILE* fout = fopen(argv[7 + adj],"w+");
         char** header = malloc(4 * sizeof(char*));
         int i;
         for (i = 0; i < 4; i++){
            header[i] = malloc(maxSizeHeadRow * sizeof(char));
         }
         int rows;
         int cols;
         int** pixels = pgmRead(header, &rows, &cols, fin);
         if (pgmDrawCircle(pixels, rows, cols, centerRow, centerCol, radius, header)){
            printf("Circle was partially or compeletely drawn!\n");
         }else{
            printf("No circle was drawn!\n");
         }
         if (pgmDrawEdge(pixels, rows, cols, edge, header)){
            printf("Edge was drawn!\n");
         }else{
            printf("No edge was drawn!\n");
         }
         pgmWrite((const char**)header, (const int**)pixels, rows, cols, fout);
         for (i = 0; i < 4; i++){
            free(header[i]);
         }
         free(header);
         for(i = 0; i < rows; i++){
            free(pixels[i]);
         }
         free(pixels);
         fclose(fin);
         fclose(fout);
         printf("Processing was successful!\n");
         return 0;
      }else{
         return usage("arg");
      }
   }
   return usage("-a");
}

int usage(const char* test){
   if (strlen(test) == 3){
      printf("Usage: incorrect number of arguments.\nCorrect usage: ./hw34 -c circleCenterRow circleCenterColumn radius oldImageFile newImageFile\n./hw34 -e edgeWidth oldImageFile newImageFile\n./hw34 [-ce, -c -e] circleCenterRow circleCenterColumn radius edgeWidth oldImageFile newImageFile\n");
   }else if (strlen(test) == 2){
      printf("Usage: no argument detected.\nCorrect usage: ./hw34 -c circleCenterRow circleCenterColumn radius oldImageFile newImageFile\n./hw34 -e edgeWidth oldImageFile newImageFile\n./hw34 [-ce, -c -e] circleCenterRow circleCenterColumn radius edgeWidth oldImageFile newImageFile\n");
   }else if (strlen(test) == 4){
      printf("Usage: oldImageFile and newImageFile cannot be the same.\n");
   }
   return 0;
}