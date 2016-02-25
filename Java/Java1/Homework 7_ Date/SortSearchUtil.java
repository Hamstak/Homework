/* Tim Tanasse
 * Search/Sort Utility Class
 */
public class SortSearchUtil {
	
	public static void selectionSort(int[] ara){
		int temp = 0;
		int indexSmallest = 0;
		for (int posFill = 0; posFill < (ara.length - 1); posFill++){
			indexSmallest = posFill;
			for (int current = posFill + 1; current < ara.length; current++){
				if (ara[current] < ara[indexSmallest]){
					indexSmallest = current;
				}
			}
			temp = ara[posFill];
			ara[posFill] = ara[indexSmallest];
			ara[indexSmallest] = temp;
		}
	}
	public static void selectionSort(Comparable[] ara){
		Comparable temp = null;
		int indexSmallest = 0;
		for (int posFill = 0; posFill < (ara.length - 1); posFill++){
			indexSmallest = posFill;
			for (int current = posFill + 1; current < ara.length; current++){
				if (ara[current].compareTo(ara[indexSmallest]) < 0){
					indexSmallest = current;
				}
			}
			temp = ara[posFill];
			ara[posFill] = ara[indexSmallest];
			ara[indexSmallest] = temp;
		}
	}
	public static void selectionSort(double[] ara){
		double temp = 0;
		int indexSmallest = 0;
		for (int posFill = 0; posFill < (ara.length - 1); posFill++){
			indexSmallest = posFill;
			for (int current = posFill + 1; current < ara.length; current++){
				if (ara[current] < ara[indexSmallest]){
					indexSmallest = current;
				}
			}
			temp = ara[posFill];
			ara[posFill] = ara[indexSmallest];
			ara[indexSmallest] = temp;
		}
	}
		public static void selectionSort(String[] ara){
		String temp = "";
		int indexSmallest = 0;
		for (int posFill = 0; posFill < (ara.length - 1); posFill++){
			indexSmallest = posFill;
			for (int current = posFill + 1; current < ara.length; current++){
				if (ara[current].compareTo(ara[indexSmallest]) < 0){
					indexSmallest = current;
				}
			}
			temp = ara[posFill];
			ara[posFill] = ara[indexSmallest];
			ara[indexSmallest] = temp;
		}
	}
	public static int linearSearch( int[] ara, int target){	//searches through a 1d int array and reports the index
		for (int i = 0; i < ara.length; i++){						//if a given value is there, otherwise reports -1
			if (ara[i] == target){
				return i;
			}
		}
		return -1;
	}
	public static void revArray(int[] input){	//Reverses the order of an array
		int temp;
		for(int i = 0; i <= input.length/2; i++){
			temp = input[i];
			input[i] = input[input.length - i - 1];
			input[input.length - i - 1] = temp;
		}
	}
	public static void quickSort(int[] input, int start, int end){
		int index = partition(input, start, end);
		if (start < index - 1){
			quickSort(input, start, index - 1);
		}
		if (index < end){
			quickSort(input, index, end);
		}
	}
	private static int partition(int[] input, int start, int end){
		int leftIndex = start, rightIndex = end;
		int temp = 0;
		int pivot = input[(leftIndex+rightIndex) / 2];
		while (leftIndex <= rightIndex){
			while (input[leftIndex] < pivot){
				leftIndex++;
			}while (input[rightIndex] > pivot){
				rightIndex--;
			}
			if (leftIndex <= rightIndex){
				temp = input[leftIndex];
				input[leftIndex] = input[rightIndex];
				input[rightIndex] = temp;
				leftIndex++;
				rightIndex--;
			}
		}
		return leftIndex;
	}
	public static void quickSort(Comparable[] input, int start, int end){
		int index = partition(input, start, end);
		if (start < index - 1){
			quickSort(input, start, index - 1);
		}
		if (index < end){
			quickSort(input, index, end);
		}
	}
	private static int partition(Comparable[] input, int start, int end){
		int leftIndex = start, rightIndex = end;
		Comparable temp = null;
		Comparable pivot = input[(leftIndex+rightIndex) / 2];
		while (leftIndex <= rightIndex){
			while (input[leftIndex].compareTo(pivot) < 0){
				leftIndex++;
			}while (input[rightIndex].compareTo(pivot) > 0){
				rightIndex--;
			}
			if (leftIndex <= rightIndex){
				temp = input[leftIndex];
				input[leftIndex] = input[rightIndex];
				input[rightIndex] = temp;
				leftIndex++;
				rightIndex--;
			}
		}
		return leftIndex;
	}
	public static void insertionSort (int[] input){
		for (int i = 1; i < input.length; i++){
			int temp = input[i];
			int posTemp = i;
			while (posTemp > 0 && temp < input[posTemp - 1]){
				input[posTemp] = input[posTemp - 1];
				posTemp--;
			}
			input[posTemp] = temp;
		}
	}
	public static void insertionSort (String[] input){
		for (int i = 1; i < input.length; i++){
			String temp = input[i];
			int posTemp = i;
			while ( (posTemp > 0) && (temp.compareTo(input[posTemp - 1]) < 0) ){
				input[posTemp] = input[posTemp - 1];
				posTemp--;
			}
			input[posTemp] = temp;
		}
	}
	public static int binarySearch (int[] inputAra, int inputTarget, int start, int end){
		int mid = 0;
		while (start <= end){
			mid = (start + ((end-start)/2));
			if (inputTarget < inputAra[mid]){
				end = mid - 1;
			}else if (inputTarget > inputAra[mid]){
				start = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	public static int binarySearch (Comparable[] inputAra, Comparable inputTarget, int start, int end){
		int mid = 0;
		while (start <= end){
			mid = (start + ((end-start)/2));
			if (inputTarget.compareTo(inputAra[mid]) < 0){
				end = mid - 1;
			}else if (inputTarget.compareTo(inputAra[mid]) > 0){
				start = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}

