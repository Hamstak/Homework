/*
 * Graph.c
 *
 *  Created on: Feb 17, 2016
 *      Author: Tim Tanasse
 */
#include "Graph.h"
Graph::Graph(){
}

bool Graph::loadCityInformation(std::string filename) {
	fileName = filename;
	std::ifstream ifs(filename);
	if(!ifs.is_open()){
		return false;
	}
	while(ifs.good()){
		std::string temp;
		std::getline(ifs, temp);
		std::istringstream sst(temp);
		std::getline(sst, temp, ' ');
		if(temp[0] == 'p'){
			double x, y, z;
			std::string::size_type sz;

			std::getline(sst, temp, ' ');
			x = std::stod(temp, &sz);
			std::getline(sst, temp, ' ');
			y = std::stod(temp, &sz);
			std::getline(sst, temp, ' ');
			z = std::stod(temp, &sz);

			Point3D tempPoint(x,y,z);
			cityCoords.push_back(tempPoint);
		}else{
			break;
		}
	}
	ifs.close();
	return true;
}

void Graph::generate() {
	std::ifstream ifs(fileName);
	if(!ifs.is_open()){
		std::cout<< "Open Failed in generate"<<std::endl;
		return;
	}
	while(ifs.good()){
		std::string temp;
		std::getline(ifs, temp);
		std::istringstream sst(temp);
		std::getline(sst, temp, ' ');
		if(temp[0] == 'c'){
			int array[3];

			std::string::size_type sz;

			std::getline(sst, temp, ' ');
			array[0] = std::stoi(temp, &sz);
			std::getline(sst, temp, ' ');
			array[1] = std::stoi(temp, &sz);
			std::getline(sst, temp, ' ');
			array[2] = std::stoi(temp, &sz);
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if (i != j){
						cityConnectivity[array[i]].insert(array[j]);
					}
				}
			}

		}
	}
	ifs.close();
}

void Graph::printInformation() {
	for(unsigned int i = 0; i < cityConnectivity.size(); i++){
		std::cout<< "["<< i <<"]: ";
		for(std::set<int>::iterator it = cityConnectivity[i].begin(); it != cityConnectivity[i].end(); it++){
			std::cout << *it<< " ";
		}
		std::cout <<std::endl;
	}
	std::cout<<std::endl;

}

void Graph::showConnectivity(int int1) {
	for(std::set<int>::iterator it = cityConnectivity[int1].begin(); it != cityConnectivity[int1].end(); it++){
		std::cout << "["<< int1 << "-"<< *it <<"]: " << cityCoords[int1].distance(cityCoords[*it])<<std::endl;
	}
}



