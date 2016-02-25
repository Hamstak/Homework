
#include "ColorBlob.h"

bool operator==(const ColorBlob& c1, const ColorBlob& c2){
	if(c1.height == c2.height && c1.width == c2.height){
		for(int i = 0; i < c1.height; i++){
			for(int j = 0; j < c1.width; j++){
				if(!(c1.blob[i][j] == c1.blob[i][j])){
					return false;
				}
			}
		}
		return true;
	}
	return false;
}

ColorBlob operator+(const ColorBlob& cBlob1, const ColorBlob& cBlob2){
	ColorBlob temp;
	if(cBlob1.blob != NULL && cBlob2.blob != NULL){
		Color tempColor = Color();
		temp.height = std::min(cBlob1.height, cBlob2.height);
		temp.width = std::min(cBlob1.width, cBlob2.width);
		temp.blob = (Color**)malloc(temp.height * sizeof(Color*));
		for(int i = 0; i < temp.height; i++){
			temp.blob[i] = (Color*)malloc(temp.width * sizeof(Color));
			for(int j = 0; j < temp.width; j++){
				temp.blob[i][j] = cBlob1.blob[i][j] + cBlob2.blob[i][j];
			}
		}
	}
	return temp;

}
ColorBlob operator-(const ColorBlob& cBlob1, const ColorBlob& cBlob2){
	ColorBlob colorBlob;
	if(cBlob1.blob != NULL && cBlob2.blob != NULL){
		colorBlob.height = std::min(cBlob1.height, cBlob2.height);
		colorBlob.width = std::min(cBlob1.width, cBlob1.width);
		colorBlob.blob = (Color **)malloc(colorBlob.height * sizeof(Color*));
		for(int i = 0; i < colorBlob.height; i++){
			colorBlob.blob[i] = (Color*)malloc(colorBlob.width *sizeof(Color));
			for(int j = 0; j < colorBlob.width; j++){
				colorBlob.blob[i][j] = cBlob1.blob[i][j] - cBlob2.blob[i][j];
			}
		}
	}else{
		colorBlob = ColorBlob();
	}
	return colorBlob;
}
ColorBlob operator*(const ColorBlob& cBlob1, const Color& c){
	ColorBlob colorBlob;
	colorBlob.height = cBlob1.height;
	colorBlob.width = cBlob1.width;
	colorBlob.blob = (Color**)malloc(colorBlob.height * sizeof(Color*));
	for(int i = 0; i < colorBlob.height; i++){
		colorBlob.blob[i] = (Color *)malloc(colorBlob.width * sizeof(Color));
		for(int j = 0; j < colorBlob.width; j++){
			colorBlob.blob[i][j] = cBlob1.blob[i][j] * c;
		}
	}
	return colorBlob;
}
bool operator!(const ColorBlob& cBlob){
	for(int i = 0; i < cBlob.height; i++){
		for (int j = 0; j < cBlob.width; j++){
			if(!(cBlob.blob[i][j] == Color())){
				return false;
			}
		}
	}
	return true;
}

std::ostream& operator<<(std::ostream& ostr, const ColorBlob& cBlob){
	ostr<< "Height: " << cBlob.height <<std::endl<< "Width: "<< cBlob.width<<std::endl;
	if (cBlob.blob != NULL){
		for(int i = 0; i < cBlob.height; i++){
				for(int j = 0; j < cBlob.width; j++){
					ostr<<cBlob.blob[i][j]<<" ";
				}
				ostr<<std::endl;
			}
	}
	return ostr;
}
std::istream& operator>>(std::istream& istr, ColorBlob& cBlob){
	for(int i = 0; i < cBlob.height; i++){
		for(int j = 0; j < cBlob.width; j++){
			std::cout<<"Enter data for "<<i<<","<<j<<std::endl;
			istr >> cBlob.blob[i][j];
		}
	}
	return istr;
}

int getInt(std::istream& istr){
	int input;
		    //using string and stringstream to validate inputs.
			std::string  line;
		    while(std::getline(istr, line))   // read a line at a time for parsing.
		    {
		        std::stringstream linestream(line);
		        if (!(linestream >> input))
		        {
		            std::cout<<"Invalid input detected!" <<std::endl;
		        	continue;
		        }
		        if ((input < 1))
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
ColorBlob::ColorBlob(int h, int w, Color c) {
	height = h;
	width = w;
	blob = (Color**)malloc(h * sizeof(Color*));
	for(int i = 0; i < h; i++){
		blob[i] = (Color*)malloc(w * sizeof(Color));
		for(int j = 0; j < w; j++){
			blob[i][j] = c;
		}
	}
	//return *this;
}

ColorBlob::ColorBlob(const ColorBlob& c) {
	height = c.height;
	width = c.width;
	blob = (Color**)malloc(height * sizeof(Color*));
		for(int i = 0; i < height; i++){
			blob[i] = (Color*)malloc(width * sizeof(Color));
			for(int j = 0; j < width; j++){
				blob[i][j] = c.blob != NULL ? c.blob[0][0] : Color();
			}
		}
}

ColorBlob& ColorBlob::operator =(const ColorBlob& c) {
	height = c.height;
	width = c.width;
	blob = (Color**)malloc(height * sizeof(Color*));
		for(int i = 0; i < height; i++){
			blob[i] = (Color*)malloc(width * sizeof(Color));
			for(int j = 0; j < width; j++){
				blob[i][j] = c.blob != NULL ? c.blob[0][0] : Color();
			}
		}
	return *this;
}

ColorBlob& ColorBlob::operator =(ColorBlob&& c) {
	height = c.height;
	width = c.width;
	blob = (Color**)malloc(height * sizeof(Color*));
		for(int i = 0; i < height; i++){
			blob[i] = (Color*)malloc(width * sizeof(Color));
			for(int j = 0; j < width; j++){
				blob[i][j] = c.blob != NULL ? c.blob[0][0] : Color();
			}
		}

	for(int i = 0; i < c.height; i++)
		free(c.blob[i]);
	free(c.blob);
	c.blob = NULL;
	c.height = 0;
	c.width = 0;
	return *this;
}

ColorBlob::ColorBlob(ColorBlob&& c) {
	height = c.height;
	width = c.width;
	blob = (Color**)malloc(height * sizeof(Color*));
		for(int i = 0; i < height; i++){
			blob[i] = (Color*)malloc(width * sizeof(Color));
			for(int j = 0; j < width; j++){
				blob[i][j] = c.blob != NULL ? c.blob[0][0] : Color();
			}
		}

	for(int i = 0; i < c.height; i++)
		free(c.blob[i]);
	free(c.blob);
	c.blob = NULL;
	c.height = 0;
	c.width = 0;
}

ColorBlob::~ColorBlob() {
	for(int i = 0; i < height; i++)
			free(blob[i]);
		free(blob);
		blob = NULL;
		height = 0;
		width = 0;
}
