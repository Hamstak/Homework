/*
 * Color.h
 *
 *  Created on: Feb 2, 2016
 *      Author: moth
 */

#ifndef COLOR_H_
#define COLOR_H_

#include <iostream>
#include <utility>
#include <sstream>

double getDouble(std::istream&);

class Color{

	friend bool operator==(const Color&, const Color&);
	friend Color operator+(const Color&, const Color&);
	friend Color operator-(const Color&, const Color&);
	friend Color operator*(const Color&, const Color&);
	friend bool operator!(const Color&);
	friend std::ostream& operator<<(std::ostream&, const Color&);
	friend std::istream& operator>>(std::istream&, Color&);

public:

	Color(double r = 0, double g = 0, double b = 0);
	Color(const Color&);
	Color(Color&&);
	~Color();
	Color& operator=(const Color&);
	Color& operator=(Color&&);
private:
	double red, green, blue;
};


#endif /* COLOR_H_ */
