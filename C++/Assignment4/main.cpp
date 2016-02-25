/*
 * main.cpp
 *
 *  Created on: Feb 17, 2016
 *      Author: Tim Tanasse
 */
#include "Graph.h"
#include <iostream>

int main (int argc, char** argv){
	Graph g;
	bool cityInformation = g.loadCityInformation("Terrain.obj");

	if(!cityInformation){
		std::cout<< "No information available!";
	}

	g.generate();

	g.printInformation();

	g.showConnectivity(0);

	return 0;
}
