/*
 * colorblob_tester.cpp
 *
 *  Created on: Feb 2, 2016
 *      Author: Timothy Tanasse
 *
 *  compiler: g++
 *
 */
#include <iostream>
#include "ColorBlob.h"
#include <utility>

int main(){
	ColorBlob cBlob(2, 2, Color());       				// created with some default color, width 2, height 2
	std::cout << "cBlob = " << cBlob << std::endl;
	ColorBlob cBlobOne(cBlob);
	ColorBlob cBlobTwo(2,2, Color());
	std::cin >> cBlobTwo;                               // can modify color entry now!
	ColorBlob cBlobThree = cBlobOne + cBlobTwo;
	ColorBlob cBlobFour = cBlobOne - cBlobTwo;
	Color cColor(0.5, 0.4, 0.45);
	ColorBlob cBlobFive = cBlobOne*cColor;
	std::cout << !cBlobFive << std::endl;    // compares whether the color entries are black or not
	ColorBlob cBlobSix;
	cBlobSix = std::move(cBlobFive);
	std::cout << "cBlobSix after move: " << cBlobSix;
	std::cout << "cBlobFive after move: " << cBlobFive;
	ColorBlob cBlobSeven= std::move(cBlobOne);
	std::cout << "cBlobSeven after move:" << cBlobSeven;
	std::cout << "cBlobOne after move: " << cBlobOne;
	return 0;
}
