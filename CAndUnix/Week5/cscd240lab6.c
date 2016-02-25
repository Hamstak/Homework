#include <stdio.h>
int main()
{
int arr[] = { 200, 400, 600, 800, 1000, 1200, 1400, 1600, 1800, 2000};
	int *ptr = arr;

	/* This gives us an idea of the memory map */
	printf("sizeof(ptr) %ld\n", sizeof(ptr) ); // number of bytes used for a pointer variable
	printf("sizeof(arr[0]) %ld\n", sizeof(arr[0]) ); //number of bytes used for an array element

	printf("value of arr is %p\n", arr);
	printf("value of ptr is %p\n", ptr);

	printf("address of arr[1] is %p\n", &arr[1]);
	printf("addres of arr[9] is %p\n", &arr[9]);
	printf("&ptr is %p\n", &ptr);
	/* end memory map */
	ptr++;
	printf("*ptr %d\n", *ptr);
	printf("ptr %p\n", ptr);

	*++ptr;
	printf("*++ptr %d\n", *ptr);
	printf("ptr %p\n", ptr);

	*ptr++;
	printf("*ptr++ %d\n", *ptr);
	printf("ptr %p\n", ptr);

	ptr = arr; // reset ptr, no need to explain this statement

	// fun with printf repeat last couple of commands
	printf("*++ptr %d\n", *++ptr);
	printf("ptr %p\n", ptr);

	printf("*ptr++ %d\n", *ptr++);
	printf("ptr %p\n", ptr);

	ptr = arr; // reset ptr, no need to explain this statement

	*ptr += 1;
	printf("*ptr %d\n", *ptr);
	printf("ptr %p\n", ptr);

	printf("*(ptr+1) = %d\n", *(ptr+1));

	ptr = arr; // reset ptr, no need to explain this statement


	*(arr+2) = *ptr+100;
	printf("*(arr+2) = %d\n", *(arr+2));

	ptr = arr + 5;
	printf("*ptr %d\n", *ptr);
	printf("ptr %p\n", ptr);

	ptr = arr; // reset ptr, no need to explain this statement

	arr[2] = *(ptr + 5);
	printf("arr[2] = %d\n", arr[2]);

	ptr = (arr + 10);
	printf("ptr %p\n", ptr);
	printf("*ptr %d\n", *ptr);
	return 0;

}// end main
