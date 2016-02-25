/*
 * Color.cpp
 *
 *  Created on: Feb 2, 2016
 *      Author: moth
 */

#include "Color.h"

bool operator==(const Color& p1, const Color& p2){
	return p1.green == p2.green && p1.red == p2.red && p1.blue == p2.blue;
}

Color operator+(const Color& c1, const Color& c2){
	Color color;
	color.red = std::min(1.0, c1.red + c2.red);
	color.green = std::min(1.0, c2.green + c2.green);
	color.blue = std::min(1.0, c1.blue + c2.blue);
	return color;
}

Color operator-(const Color& c1, const Color& c2){
	Color color;
	color.red = std::max(0.0, c1.red - c2.red);
	color.green = std::max(0.0, c1.green - c2.green);
	color.blue = std::max(0.0, c1.blue - c2.blue);
	return color;
}

Color operator*(const Color& c1, const Color& c2){
	Color color;
	color.red = c1.red * c2.red;
	color.green = c1.green * c2.green;
	color.blue = c1.blue * c2.blue;
	return color;
}

bool operator!(const Color& c){
	return c.red == 0.0 && c.blue == 0.0 && c.green == 0.0;
}

std::ostream& operator<<(std::ostream& ostr, const Color& c){
	ostr << "{" << c.red << "," << c.green << "," << c.blue<<"}";
	return ostr;
}

std::istream& operator>>(std::istream& istr, Color& c){
	std::cout<<"input red: ";
	c.red = getDouble(istr);
	std::cout <<"input green: ";
	c.green = getDouble(istr);
	std::cout<<"input blue: ";
	c.blue = getDouble(istr);
	std::cout<<std::endl;
	return istr;
}

double getDouble(std::istream& istr){
	double       input;
		    std::string  line;
		    while(std::getline(istr, line))   // read a line at a time for parsing.
		    {
		        std::stringstream linestream(line);
		        if (!(linestream >> input))
		        {
		            std::cout<<"Invalid input detected!" <<std::endl;
		        	continue;
		        }
		        if ((input < 0.0) || (input > 1.0))
		        {
		            std::cout<<"Invalid input range detected!"<<std::endl;
		        	continue;
		        }
		        char errorTest;
		        if (linestream >> errorTest)
		        {
		            std::cout<<"Trailing characters detected!"<<std::endl;
		        	continue;
		        }
		        break;
		    }
	return input;
}

Color::Color(double r, double g, double b) {
	red = r;
	green = g;
	blue = b;
}

Color::Color(const Color& c) {
	red = c.red;
	green = c.green;
	blue = c.blue;
}

Color::Color(Color&& cp) {
	red= cp.red;
	green = cp.green;
	blue = cp.blue;

	cp.red = 0;
	cp.green = 0;
	cp.blue = 0;
}

Color::~Color() {
	red = 0;
	green = 0;
	blue = 0;
}

Color& Color::operator =(const Color& c) {
	red = c.red;
	green = c.green;
	blue = c.blue;

	return *this;
}

Color& Color::operator =(Color&& c) {
	red = c.red;
	green = c.green;
	blue = c.blue;

	c.red = 0;
	c.green = 0;
	c.blue = 0;

	return *this;

}
