import time
import numpy as np

def tic():
    global t0
    t0 = time.time()
    return 

def toc():
    global t0
    t = time.time() - t0
    print("Time elapsed :"+str(t)+" seconds")


class Spiral :
    def __init__(self,size):
        if size % 2 == 0:
            print("Grid size must be odd. Please provide an odd grid size.")
        else:
            self.size = int(size)
            self.middle = int((self.size + 1) / 2)
            self.CurrNumber = 1
            self.CurrPosition = 0
            self.Direction = 1 + 0j
            self.SegLength = 1
            self.SegPos = 0
            self.SegCount = 0
	
	def ring_id(self,Number):
		search_base = np.asarray([x**2 for x in range(self.size) if x % 2 != 0])
		target = bisect.bisect(search_base,Number)
		print(str(target))

    def NumberSearch(self,Number):
        self.CurrNumber = 1
        self.CurrPosition = 0
        self.SegLength = 1
        while self.CurrNumber != Number :
            self.Move()
            self.CurrNumber += 1

        return [int(self.CurrPosition.real + self.middle), int(self.CurrPosition.imag + self.middle)]


    def PositionSearch(self,X,Y):
        self.CurrNumber = 1
        self.CurrPosition = 0
        self.SegLength = 1
        while self.CurrPosition != X-self.middle + (Y-self.middle)*1j :
            self.Move()
            self.CurrNumber += 1

        return self.CurrNumber


    def Move(self):
        self.CurrPosition += self.Direction
        self.SegPos += 1
        if self.SegPos == self.SegLength:
            self.Direction = self.Direction*(-  1j)
            self.SegCount += 1
            self.SegPos = 0
            if self.SegCount == 2:
                self.SegLength += 1
                self.SegCount = 0





Spiral(3).ring_id(1200)
"""
tic()
print(Spiral(3).NumberSearch(8))
toc()
tic()
print(Spiral(7).PositionSearch(1,1))
toc()
tic()
print(Spiral(11).NumberSearch(50))
toc()
tic()
print(Spiral(9).PositionSearch(6,8))
toc()
tic()
print(Spiral(1024716039).NumberSearch(557614022))
toc()
tic()
print(Spiral(234653477).PositionSearch(11777272,289722))
toc()
print(time.clock())
"""
