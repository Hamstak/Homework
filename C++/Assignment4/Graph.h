/*
 * Graph.h
 *
 *  Created on: Feb 17, 2016
 *      Author: Tim Tanasse
 */

#ifndef GRAPH_H_
#define GRAPH_H_
#include "Point3D.h"
#include <vector>
#include <map>
#include <set>
#include <string>
#include <fstream>
#include <iostream>
#include <sstream>

class Graph{
public:
	Graph();

	bool loadCityInformation(std::string);
	void generate();
	void printInformation();
	void showConnectivity(int);

	std::vector<Point3D> cityCoords;
	std::vector<int> cityIndicies;
	std::map<int, std::set<int>> cityConnectivity;
	std::string fileName;

};

#endif /* GRAPH_H_ */
