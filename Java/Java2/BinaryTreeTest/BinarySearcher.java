public class BinarySearcher{
   public static void main(String[] args){
      int[] arr = {1,2,3,4,5,6,7};
      System.out.print(binarySearch(arr,3,0,arr.length));
   }
   private static int binarySearch(int[] arr, int target, int low, int high){
      int mid = (low + high)/2;
      if (!(low <= high))
         return -1;
      if (arr[mid] - target < 0)
         return binarySearch(arr, target, mid + 1, high);
      else if (arr[mid] - target > 0)
         return binarySearch(arr, target, low, mid - 1);
      else
         return mid;   
   }  
}