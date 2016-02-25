#  
#  

def primef(number):
	return [ x for x in range(2,number//2) if x not in 
		[ i for j in range(2,8) for i in range(j*2,number//2,j)] and number % x == 0]

def main():
	print(primef(100))
	return 0

if __name__ == '__main__':
	main()

