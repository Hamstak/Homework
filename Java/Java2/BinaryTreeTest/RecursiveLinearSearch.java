public class RecursiveLinearSearch{
      public static void main(String[] args){
         int[] arr = {1,2,3,4,5};
         System.out.print(linearSearch(arr,4));
      }
      private static int linearSearch(int[] arr, int target){
         return linearSearch(arr,target,0);
      }
      private static int linearSearch(int[] arr, int target, int index){
         if (arr.length == index)
            return -1;
         if (arr[index] == target)
            return index;
         return linearSearch(arr,target,index + 1);
      }
   }