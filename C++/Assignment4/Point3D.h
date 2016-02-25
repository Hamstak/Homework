/*
 * Point3D.h
 *
 *  Created on: Feb 17, 2016
 *      Author: Tim Tanasse
 */

#ifndef POINT3D_H_
#define POINT3D_H_
#include <math.h>

class Point3D{
public:
	double distance(Point3D);
	Point3D(double, double, double);
	double x;
	double y;
	double z;
};


#endif /* POINT3D_H_ */
