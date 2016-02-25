/*
 * Point3D.c
 *
 *  Created on: Feb 17, 2016
 *      Author: Tim Tanasse
 */
#include "Point3D.h"

Point3D::Point3D(double x1, double y1, double z1){
	x = x1;
	y = y1;
	z = z1;
}

double Point3D::distance(Point3D point){
	return sqrt((( x - point.x)*( x - point.x)) + (( y -point.y)*( y -point.y)) + (( z - point.z)*( z - point.z)));
}

