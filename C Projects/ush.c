#include <stdin.h>
#include <stdio.h>
#include <string.h>

void load_configs();

char* ush_read_line(){
  char *line = NULL;
  ssize_t buffer_size = 0;
  getline(&line, &buffer_size, stdin);
  return line;
}


void ush_loop(){
  char *line;
  char **args;
  int status;

  do{
    printf("> ");
    line = ush_read_line();
    args = ush_split_line(line);
    status = ush_execute(args);
  }while (status);
}

int main(int argc, char **argv){
  //gotta load configs up here
  load_configs();

  ush_loop();

  return EXIT_SUCESS;
}
