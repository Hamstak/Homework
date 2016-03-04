triangle a b c
	| a >= b = triangle 1 (b + 1) c
	| b >= c = triangle 1 2 (c + 1)
	| (a^2 + b^2 == c^2) && (a + b + c == 1000) = a * b * c
	| a == 1000 = 1
	| otherwise = triangle (a + 1) b c
