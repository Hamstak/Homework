test: main.o LinkedList.o HashTable.o
	gcc -g -o test main.o LinkedList.o HashTable.o

LinkedList.o: LinkedList.c
	gcc -c LinkedList.c

HashTable.o : HashTable.c
	gcc -c HashTable.c

clean:
		rm *o test
