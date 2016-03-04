import Data.List.Ordered
import Data.Numbers.

sumWhile f (x:xs)
	| f x = x + sumWhile f xs
	| otherwise = 0

primes = 2 : euler [3,5..]

euler (p:xs) = p : euler (xs `minus` map (p*) (p:xs))

--primes f n = f 2 euler [3,5..n]
--	where euler (p:xs) = f p euler (xs `minus` map (p*) (p:xs))

--primesLT x= takeWhile (< x) primes

euler3 n (x:ps) 
	| x == n = n
	| x <  n = if n `mod` x == 0 then euler3 (quot n x) (x:ps) else euler3 n ps
