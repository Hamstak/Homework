
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#include "pgmUtility.h"

// Implement or deine each function prototypes listed in pgmUtility.h file.
// NOTE: You can NOT change the input, output, and argument type of the functions in pgmUtility.h
// NOTE: You can NOT change the prototype (signature) of any functions listed in pgmUtility.h

/* Should input a string array of size 2, and be sure to ind and use the highest intensity value in the output.
 * returns a integer 'pixel map' of the intensity values from the given pgm file. 
 * numRows and numCols become their respective values, and the string array will contain the filetype 'P2' and the name comment line '# <stuff>'
 */
int pgmDrawEdge(int** pixels, int numRows, int numCols, int edgeWidth, char** header){
   if (edgeWidth <= 0)
      return 0;
   int i;
   int j;
   int intense = 0;
   for (i = 0; i < numRows; i++){
      if (i < edgeWidth || i >= numRows - edgeWidth){
         for (j = 0; j < numCols; j++){
            pixels[i][j] = 0;
         }  
      }else{
         for (j = 0; j < edgeWidth; j++){
            pixels[i][j] = 0;
         }
         for(j = numCols - 1; j >= numCols - edgeWidth; j--){
            pixels[i][j] = 0;
         }  
      }
      if (i >= edgeWidth || i < numRows - edgeWidth){
         for (j = edgeWidth; j < numCols - edgeWidth; j++){
            if (pixels[i][j] > intense)
               intense = pixels[i][j];
         }
      }
   }
   if (intense != atoi(header[3])){
      sprintf(header[3],"%d\n",intense);
   }
   return 1;
}
double distance (int p1[], int p2[]){
   double x = pow((p1[0] - p2[0]),2);
   double y = pow((p1[1] - p2[1]),2);
   double z = sqrt((x + y));
   return z;
}
int pgmDrawCircle(int** pixels, int numRows, int numCols, int centerRow, int centerCol, int radius, char** header){
   if (centerRow + numRows < 0 || centerRow - numRows > numRows || centerCol + numCols < 0 || centerCol - numCols > numCols)
      return 0;
   int changed = 1;
   int i;
   int j;
   int intense = 0;
   int center[2] = {centerRow, centerCol};
   for ( i = 0; i < numRows; i++){
      for (j = 0; j < numCols; j++){
         int point[2] = {i,j};
         double d = distance(point,center);
         if (d < (double)radius){
            pixels[i][j] = 0;
            changed++;
         }else if (intense < pixels[i][j]){
            intense = pixels[i][j];
         }
      }
   }
   if ( changed != 0 && intense != atoi(header[3])){
      sprintf(header[3],"%d\n",intense);
      changed = 1;
   }else if (changed > 1){
      return 1;
   }else{
      changed = 0;
   }
   return changed;
}

int** pgmRead(char** header, int* numRows, int* numCols, FILE* in){
   if( !fgets(header[0],maxSizeHeadRow,in) ||
       !fgets(header[1],maxSizeHeadRow,in) ||
       !fscanf(in,"%d",numCols) ||
       !fscanf(in,"%d",numRows)||
       !fgets(header[2],maxSizeHeadRow,in) ||
       !fgets(header[3],maxSizeHeadRow,in))
       return NULL;
   sprintf(header[2],"%d %d\n",*numCols, *numRows);
   int** pixels = malloc(*numRows * sizeof(int*));
   int i;
   for(i = 0; i < *numRows; i++){
      pixels[i] = malloc(*numCols * sizeof(int*));
   }
   int j;
   int intense = 0;
   for (i = 0; i < *numRows; i++){
      for (j = 0; j < *numCols; j++){
         if (fscanf(in, "%d", &pixels[i][j]) == 0)
            return NULL;
         if (intense < pixels[i][j]){
            intense = pixels[i][j];
         }
      }
   }
   if (intense != atoi(header[3])){
      sprintf(header[3],"%d\n",intense);
   }
   return pixels;
}

int pgmWrite(const char** header, const int** pixels, int numRows, int numCols, FILE* out){
   int i;
   for (i = 0; i < 4; i++){
      if (!fputs(header[i],out))
         return -1;
   }
   int j;
   char* str = malloc(10 * sizeof(char));
   int count = 0;
   int intense = atoi(header[3]);
   while(intense !=0){
      count++;
      intense /= 10;
   }
   for (i = 0; i < numRows; i++){
      for (j = 0; j < numCols - 1; j++){
         sprintf(str,"%d",pixels[i][j]);
         fputs(str,out);
         int count2 = 0;
         int temp = pixels[i][j + 1];
         if (temp == 0)
            count2++;
         else
            while (temp != 0){
               count2++;
               temp /= 10;
            }
         int x;
         for (x = count2; x < count + 1; x++){
            fputs(" ",out);
         }
      }
      sprintf(str,"%d",pixels[i][j]);
      fputs(str,out);
      fputs("\n",out);
   }
   free(str);
   return 0;
}