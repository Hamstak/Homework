#  
#  
import re

def ruth_aaron(input_pair):
	#import pdb; pdb.set_trace()
	int_pair = map(int,input_pair)
	if not int_pair[0] + 1 == int_pair[1] or not factor_sum(int_pair):
		return "NOT VALID"
	else:
		return "VALID"
		
		
def factor_sum(input_pair):
	def sum_primes():
		sum_pairs = []
		for num in input_pair:
			temp = 0
			for i in range(num // 2):
				if num % i == 0:
					temp += i
				while num % i == 0:
					num /= i
			sum_pairs += temp
		return sum_pairs[0] == sum_pairs[1]		
	return sum_primes
			
def main():
	print("");
	count = raw_input('Enter in the number of Ruth-Aaron pairs you will test -> ')
	pairs = []
	for i in range(int(count)):
		print(ruth_aaron(raw_input('>')[1:-1].split(',')))
		
	return 0

if __name__ == '__main__':
	main()

