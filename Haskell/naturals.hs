import Data.Numbers.Primes
import Data.List

triangleNum 1 = 1
triangleNum n = n + triangleNum (n-1)

triangleList = 1 : zipWith (+) [2..] triangleList

factor xss = map primeFactors xss

compare' x = (< 500) $ fst x

groupFactors xss = [ (product [length y + 1 | y <- group x] ,product x) | x <- xss]

finalList = groupFactors $ factor triangleList

main = print $ head $ dropWhile compare' finalList
