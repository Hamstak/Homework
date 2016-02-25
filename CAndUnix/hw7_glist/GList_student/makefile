#makefile for hw7
glist : List.o typeUtil.o student.o main.o
	gcc -g -o glist main.o List.o typeUtil.o student.o
List.o : List.c
	gcc -c List.c
typeUtil.o : typeUtil.c
	gcc -c typeUtil.c
student.o : student.c
	gcc -c student.c
main.o : main.c
	gcc -c main.c
clean:
	rm *o glist
