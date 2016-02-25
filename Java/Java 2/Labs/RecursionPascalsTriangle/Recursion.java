public class Recursion
{
	public static long pascal(int n, int k){
      if (n == 0 || k == 0)
         return 1;
      if (n == k)
         return 1;
      return pascal(n - 1, k - 1) + pascal(n - 1, k);
   }
}// end class