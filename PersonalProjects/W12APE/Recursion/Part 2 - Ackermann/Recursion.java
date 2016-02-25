/*
	  Ackerman's function, A(m, n) is defined:
     A(0 , n) = n + 1 for n  >= 0 
     A(m , 0) = A(m Ğ 1 , 1) for m > 0
     A(m , n) = A(m Ğ 1 , A(m , n - 1)) for n >= 0
*/

public class Recursion
{
	public static long ackermann(long m, long n)
	{
      if (m == 0 && n >= 0)
         return n + 1;
      if (n == 0 && m > 0)
         return ackermann(m - 1, 1);
      if(n >= 0)
         return ackermann(m - 1, ackermann(m , n - 1));
      return 0;
	}// end ackermann
	
}// end class