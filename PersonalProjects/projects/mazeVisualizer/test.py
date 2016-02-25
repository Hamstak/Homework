import time

def tic():
	global t0
	t0 = time.time()
	return
	
def toc():
	global t0
	t = time.time() - t0
	print(str(t) + "\n")

tic()	
for i in range(10000000):
	x = 100 * 100
toc()
tic()
for i in range(10000000):
	x = (100 + 0j) * (100 + 1j)	
toc()
