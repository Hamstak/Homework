#include "hw5.h"

int main()
{
    FILE * fin = NULL;
    int total, choice;
    Address * array = NULL;

    fin = openFile();

    array = fillArray(&total, fin);

    fclose(fin);
    fin = NULL;

    do
    {
        switch(choice = menu())
        {
			case 1:	printStreetSortedArray(array, total); //sort and then print array according to street string
					break;

			case 2: printCitySortedArray(array, total);   //sort according to city string
					break;

			case 3: printStateCitySortedArray(total, array);  //sort according to State then city string
					break;

			case 4:	printZipSortedArray(total, array);  //sort according to zip value
	   }

	}while(choice != 5); //when menu() return 5, it means quit.

	cleanUp(array, total);  //deallocate all dynamically allocated memory
	array = NULL;

    return 0;

}// end main
