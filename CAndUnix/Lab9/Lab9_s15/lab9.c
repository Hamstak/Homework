//
//  main.c
//  FileIOlab
//
//

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// You are FREE to add more function declarations and FREE to
// add more functions in this soruce file.

int processTextFile(char * inputFileName, char * outputFileName);
int sortLines(char * inputFileName, char * outputFileName);

int main(int argc, const char * argv[])
{

    // insert code here...
    char *input = "input.txt";
    char *out1 = "outFile1";
    char *out2 = "outFile2";
    
    processTextFile(input, out1); //It takes input.txt as input, and output a file named outFile1.
    
    // The output file of processTextFile() becomes the input of the following function,
    // sortLines() which takes outFile1 as input and outputs outFile2.
    sortLines(out1, out2);
    
    //printf("Done processing!\n");
    return 0;
}


/**
 * TODO:
 * The method reads in each line in a provided text file with its name pointed to by inputFileName,
 * The method processes each line of the input file, and output the results
 * into another file with its name pointed to by outputFileName.
 * One input file has been provided in the source file folder.
 * Note: you can safely assume that each line in the input file contains less than 1024 characters.
 * Note: NO strtok() method call please, which we have not learned yet.
 *
 * Each line of the input file has a format like the following.
 * At the beginning of each line, we may (or MAY NOT) have some leading English words (alphabetical letters);
 * And you are guaranteed to surely have two integer numbers at the end of each line.
 * Items or words in each line are separated by a single white space character.
 * For examples, "a good man 20 30" is a formatted line of text in the file.
 * "12 50" may be another line in the input file, in which we do NOT have leading alphabetical words.
 * Note: you can safely assume that each line in the input file contains less than 1024 characters.
 *
 * The method reads one line at a time from input file and constructs a new line for output.
 * The new line for the output file consists of the leading English words at the beginning of the line
 * that is read in from the input file, plus a numerical SUM of the two integer numbers at the end of the line of
 * the input.
 * For example, if the input line is "a good man 20 30",
 * the corresponding output line for the output file is "a good man 50".
 * For another example, if the input line is "12 50",
 * the corresponding output line for the output file is "62".
 *
 *
 * @param inputFileName string of the file name for the input file.
 * @param outputFileName string of the file name for the output file.
 *
 * @return 0 if the input file can be opened and read successfully,
 * and each new line can be successfully written back to the output file.
 * The method returns -1 if any error occurs, such as
 * FileNotFound error.
 */
int processTextFile(char * inputFileName, char * outputFileName)
{
    return 0;
}


/**
 * TODO:
 * The method reads in all lines in a provided text file with its name pointed to by inputFileName,
 * The method sorts all lines of the input file according to the numerical value at the 
 * end of each line in ascending order, then outputs the results
 * into another file with its name pointed to by outputFileName.
 * The input file is intended to be the output file of the function above, processTextFile().
 * Note: you can safely assume that each line in the input file contains less than 1024 characters.
 * Note: NO strtok() method call please, which we have not learned yet.
 * Note: you probably need the function rewind(filePointer) to start reading again 
 * from the beginning in a file, without the need of closing it.
 *
 * Each line of the input file has a format like the following.
 * At the beginning of each line, we may (or MAY NOT) have some leading English words (alphabetical letters);
 * And you are guaranteed to surely have ONE integer numbers at the end of each line.
 * Items or words in each line are separated by a single white space character.
 * For examples, "a good man 50" is a formatted line of text in the file.
 * "12" may be another line in the input file, in which we do NOT have leading alphabetical words.
 * Note: you can safely assume that each line in the input file contains less than 1024 characters.
 *
 * The method reads in all lines from input file and sorts the lines according to the numerical value
 * at the end of each line, the method then writes the sorted lines back to the text file, with name
 * pointe by outputFileName.
 *
 * For example, if the input file contains three lines below:
 * "a good man 50"
 * "65"
 * "better are 7"
 *
 * The corresponding sorted output file would be three lines but sorted:
 * "better are 7"
 * "a good man 50"
 * "65"
 *
 *
 * @param inputFileName string of the file name for the input file.
 * @param outputFileName string of the file name for the output file.
 *
 * @return 0 if the input file can be opened and read successfully,
 * and each new line can be successfully written back to the output file.
 * The method returns -1 if any error occurs, such as
 * FileNotFound error.
 */
int sortLines(char * inputFileName, char * outputFileName)
{
    return 0;
}

