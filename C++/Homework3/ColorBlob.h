/*
 * ColorBlob.h
 *
 *  Created on: Feb 2, 2016
 *      Author: moth
 */

#ifndef COLORBLOB_H_
#define COLORBLOB_H_
#include <iostream>
#include <stdlib.h>
#include <utility>
#include "Color.h"

int getInt(std::istream&);

class ColorBlob{
	friend bool operator==(const ColorBlob&, const ColorBlob&);
	friend ColorBlob operator+(const ColorBlob& cBlob1, const ColorBlob& cBlob2);
	friend ColorBlob operator-(const ColorBlob& cBlob1, const ColorBlob& cBlob2);
	friend ColorBlob operator*(const ColorBlob& cBlob1, const Color& c);
	friend bool operator!(const ColorBlob& cBlob);
	friend std::ostream& operator<<(std::ostream&, const ColorBlob&);
	friend std::istream& operator>>(std::istream&, ColorBlob&);
public:
	ColorBlob(int h = 0, int w = 0, Color c = Color());
	ColorBlob(const ColorBlob&);
	ColorBlob(ColorBlob&&);
	ColorBlob& operator=(const ColorBlob&);
	ColorBlob& operator=(ColorBlob&&);
	~ColorBlob();
private:
	int height, width;
	Color **blob;
};

#endif /* COLORBLOB_H_ */
