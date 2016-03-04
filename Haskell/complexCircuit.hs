module Main where

import AI.HNN.FF.Network
import Numeric.LinearAlgebra

-- This is a sample set of vectors, which are being pushed up from a List type to a more generic type which can be treated as vectors.
-- Each sample is in a 2-tuple with a target vector.
samples :: Samples Double
samples = [ (fromList [0, 0], fromList [0])
          , (fromList [0, 1], fromList [1])
          , (fromList [1, 0], fromList [1])
          , (fromList [1, 1], fromList [0])
          ]

main :: IO ()
main = do
  
  --"createNetwork 2 [2] 1" produces a network with 2 input nodes, a single layer of 2 hidden nodes, and a single output node.
  --The second parameter of createNetwork is a list, because you can have any number of input layers.
  network <- createNetwork 2 [2] 1
  
  --This next statement prints out the weights of the network as is, which is pretty terrible since they are generated randomly.
  mapM_ (print . output network tanh . fst) samples
  putStrLn "------------------"

  --Since Hasekell doesn't utilize mutable memory, we need to assign our trained network to a new constant.
  --The network is trained with a tanh function, and is trained with our samples as defined previously.
  let network' = trainNTimes 1000 0.8 tanh tanh' network samples
  
  --Look at our nice little network now!
  mapM_ (print . output network' tanh . fst) samples
  putStrLn "------------------"
