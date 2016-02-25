data Wire = Blk | Blue | Red | Ylw | Wht

calcWires :: [Wire] -> string

calcWires wires
  | length wires == 3 = if Red `elem` wires == False
                        then "Cut the second wire"
                        else if last wires == Wht
                        then "Cut the last wire"
                        else if count Blue wires > 1
                        then "Cut the last blue wire"
                        else "Cut the last wire"
  | length wires == 4 = if count Red wires > 1
                        then "Consult manual"
                        else if last wires == Ylw && count Red wires == 0
                        then "Cut the first wire"
                        else if count Blue wires == 1
                        then "Cut the first wire"
                        else if count Ylw wires > 1
                        then "Cut the last wire"
                        else "Cut the second wire"

count :: a -> [a] -> int
count x xs = h x xs 0
  where h x [] i = i
        h x xs i = if x == head xs then h x (tail xs) (i+1) else h x (tail xs) i
