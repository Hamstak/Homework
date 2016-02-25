#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#include "pgmUtility.h"

int main(int argc, char* argv[]){
   FILE* fp;
   FILE* fop;
   //fp = fopen("smallFile.pgm","r");
   fp = fopen("baboon.ascii.pgm","r");
   fop = fopen("smallFile1.pgm","w+");
   char** header;
   header = malloc(4 * sizeof(char*));
   int i;
   for (i = 0; i < 4; i ++){
      header[i] = malloc(200 * sizeof(char));
   }
   int** pixels;
   int rows;
   int columns;
   pixels = pgmRead(header, &rows, &columns, fp);
   pgmDrawCircle(pixels,rows,columns,rows/2,columns/2,columns/3,header);
   pgmDrawEdge(pixels,rows,columns,100,header);
   pgmWrite((const char**)header, (const int**)pixels, rows, columns, fop);
   for(i = 0; i < 4; i++){
      free(header[i]);
   }
   free(header);
   for(i = 0; i < rows; i++){
      free(pixels[i]);
   }
   free(pixels);
   fclose(fp);
   fclose(fop);
   return 0;
}
