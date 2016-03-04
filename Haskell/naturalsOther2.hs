import Data.List

fermas = scanl1 (+) [1..]

minDivisor x = head [y | y <- [2..], x `mod` y == 0]

nextFactor 1 = Nothing
nextFactor n = let m = minDivisor n in Just (m, n `div` m)
factorize = unfoldr nextFactor


divnum n = product $ map ((+1) . length) (group $ factorize n)

result n = head $ filter (\x -> divnum x > n) fermas
main = print $ result 500
