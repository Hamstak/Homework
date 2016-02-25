#
import itertools
  
fiblist = {}

def fibonacci(x):
	#import pdb; pdb.set_trace()
	temp_fib_list = list(itertools.takewhile(lambda y: y <= x, fibgen))
	if x != temp_fib_list[-1]:
		for i in fibgen:
			if x % i == 0:
				global fiblist
				temp_fib_list = [j * (x/i) for j in fiblist]
				break
	print(temp_fib_list)

def fib(x):
	global fiblist
	if x < 2:
		fiblist[x] = x
		return fiblist[x]
	if x not in fiblist:
		fiblist[x] = fib(x-1) + fib(x - 2)
		return fiblist[x]
	return fiblist[x]
	
fibgen = (fib(i) for i in itertools.count(3))


def main():
	fibonacci(21)
	fibonacci(528)
	fibonacci(123456789)
	return 0

if __name__ == '__main__':
	main()

