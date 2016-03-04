import Data.List
import Data.Numbers.Primes

lengthPlus x = length x + 1

totalDivisors xs = map product [map lengthPlus x | x <- (map group xs)]

naturalList = [ take x [1..] | x<-[1..]]

triangleFactors = drop 1 $ map primeFactors $ map sum naturalList

euler12 = [(product x, totalDivisors x)| x <- triangleFactors]
