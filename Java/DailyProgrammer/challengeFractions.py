#!/usr/bin/env python
#  
#  
import string

class Fraction:
	def __init__(self, a, b = 0):
		self.num = 0
		self.dem = 0
		if (b != 0):
			self.num = int(a)
			self.dem = int(b)
		else:
			self.num = int(a[0])
			self.dem = int(a[1])

	def __str__(self):
		return str(self.num) + "/" + str(self.dem)
	
def mult_frac(a,b):
	a.num *= b.dem
	b.num *= a.dem
	temp = a.dem * b.dem
	a.dem = temp
	b.dem = temp
	
	
def reduc(a):
	temp = gcd(a.num, a.dem)
	a.num //= temp
	a.dem //= temp
	
def gcd(a, b):
	while a != 0:
		c = a
		a = b % a
		b = c
	return b
	
def add_frac(a, b):
	mult_frac(a,b)
	temp = Fraction(a.num + b.num, a.dem)
	reduc(temp)
	return temp


def main():
	#import pdb; pdb.set_trace()
	f = open("input.txt")
	fractions = f.read().splitlines()
	fractions.pop(0)
	print(fractions)
	fractions = [Fraction(frac) for frac in [frac.split('/') for frac in fractions]]
	while len(fractions) != 1:
		fractions[0] = add_frac(fractions[0], fractions[1])
		fractions.pop(1)
	print(str(fractions[0]))
	return 0

if __name__ == '__main__':
	main()

