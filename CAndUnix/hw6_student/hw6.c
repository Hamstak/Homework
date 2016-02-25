#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <crypt.h>

#define BUFFER_SIZE 34
#define ALPHA_START 97
#define ALPHA_END 122

void pdie(const char* mesg);
char** strRead(int fin);
int strWrite(int fout, char** passwords);
char** findPasswords(char** passwords);

int main( int argc, char* argv){
   int total;
   int rfd;
   int wfd;
   int bufferChars;
   int writtenChars;
   char buffer[BUFFER_SIZE];
   char* bp;
   if ((rfd = open("pass.txt", O_RDONLY, 0)) < 0)
      pdie("Open failed: File not found");
   char** passwords = strRead(rfd);
   if ((wfd = open("plainpass.txt", O_WRONLY | O_CREAT | O_TRUNC | S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH)) < 0)
      if ((wfd = open("plainpass.txt", O_WRONLY | O_TRUNC | S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH)) < 0)
         pdie("Open Failed");
   char** returned = findPasswords(passwords);
   strWrite(wfd, returned);
   int i;
   for(i = 0; i < 3; i++){
      free(passwords[i]);
   }
   free(passwords);
   free(returned);
}
 
void pdie(const char* mesg){
   perror(mesg);
   exit(1);
}

char** strRead(int fin){
 char *buffer = malloc(36 * sizeof(char));
 char* bp;
 char** passwords = malloc(3 * sizeof(char*));
 int bufferChars;
 int i = 0;
 while(1){
   if ((bufferChars = read(fin, buffer, BUFFER_SIZE)) > 0 && buffer[0] != '\n'){
      passwords[i] = malloc (strlen(buffer) * sizeof(char));
      strcpy(passwords[i],buffer);
      read(fin,buffer,1);
      i++;
   }else
      break;
 }
 free(buffer);
 return passwords;
}
int strWrite(int fout, char** passwords){
   char buffer[1] = {'\n'};
   int bufferChars, writtenChars = 0;
   int i;
   for (i = 0; i < 3; i++){
      if ((writtenChars = write(fout, passwords[i], strlen(passwords[i]))) < 0)
         pdie("Write failed");
      free(passwords[i]);
      write(fout, buffer, 1);
   }
   return 1;
}
char** findPasswords(char** passwords){
   char password[4];
   char** returned = malloc(3 * sizeof(char*));
   int a, b, c, d, i;
   int count = 0;
   for (i = 0; i < 3; i ++){
      returned[i] = malloc(4 * sizeof(char));
   }
   for ( a = 97; a <= 122; a++){
      password[0] = (char)a;
      for( b = 97; b <= 122; b++){
         password[1] = (char)b;
         for(c = 97; c<= 122; c++){
            password[2] = (char)c;
            for( d = 97; d <= 122; d++){
               password[3] = (char)d;
               for (i = 0; i < 3; i++){
                  if (passwords[i] == NULL)
                     if (compare(crypt(password, passwords[i]),passwords[i], 0)){
                        printf("Password %d has been found\n",i + 1);
                        strcpy(returned[i],password);
                        count++;
                        free(passwords[i]);
                        passwords[i] = NULL;
                        if (count == 3){
                           return returned;
                        }
                     }
                  }
               }
            }
         }
      }
   }
   return NULL;
}

int compare(char* one, char* two, int n){
   if (n == strlen(one) || n == strlen(two))
      return 1;
   if (one[n] != two[n])
      return 0;
   return compare(one, two, n + 1);
}