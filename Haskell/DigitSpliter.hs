
splitDigits' (0,y) = y
splitDigits' (x,y) = y : splitDigits' (quotRem x 10)
