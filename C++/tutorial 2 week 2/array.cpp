#define ARRAY_H

#include <iostream>

class Array{
public:
  Array(int = 1, double = 0.0);
  Array(const Array &);
  ~Array();
  const Array & operator=(const Array&);
private:
  int size;
  double * data;
}

Array::Array(int sz, double t) : size(sz){
  data = new double[size];
  for (int i  = 0; i < sz; i++) {
    data[i] = t;
  }
}

Array::Array(const Array & v) :size(v.size){
  data = new double[size];
  for (int i = 0; i < size; i++) {
    data[i] = v.data[i];
  }
}

Array::~Array(){
  delete[] data;
  data = nulptr;
  size = 0;
}

Array::const Array & operator=(const Array & v){
  if (this != &v) {
    delete[] v.data;
    v.data = new double[this.size];
    v.size = this.size;
    for (int i = 0; i < v.size; i++) {
      v.data[i] = this.data[i];
    }
  }
}
