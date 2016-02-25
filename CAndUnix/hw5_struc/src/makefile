#makefile for hw5
CC = gcc
CCFLAGS = -g -Wall
hw5 : hw5.o
	$(CC) $(CCFLAGS) -o hw5 cscd240hw5.c hw5.o
hw5.o : hw5.c hw5.h
	$(CC) $(CCFLAGS) -c hw5.c
