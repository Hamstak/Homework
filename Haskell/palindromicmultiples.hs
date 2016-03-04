import Data.List

reverseInt:: Integer -> Integer
reverseInt x = read . reverse . show $ abs x

palindrome:: Integer -> Bool
palindrome x = x == (reverseInt x)

myZipWith x xs = [(x,y) | y <- xs]

productOver xs = [x*y | (x,y) <- xs]

massiveZipWith [] ys = []
massiveZipWith (x:xs) ys = myZipWith x ys ++ massiveZipWith xs ys

removeDups xs =reverse $ map head $ group $ sort xs

massiveProductOver x y= productOver $ massiveZipWith x y

--theBigLebowski ::
theBigLebowski x y = removeDups $ massiveProductOver x y

--euler4 :: (Num a) => a -> a -> [a] -> a
euler4 x y = head [n | n <- (theBigLebowski x y), palindrome n]
