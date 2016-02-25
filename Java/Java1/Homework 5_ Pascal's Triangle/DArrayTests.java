/* Tim Tanasse
 * Assignment 5: Pascal's Triangle
 * Attempted EC: Formatting
 * Feb 12, 2015
 */


public class DArrayTests{
	public static final int[] BASE_CASE = { 0 , 1 , 0 };
	
	public static void main (String args[]) {
		int[][] ara = generatePascal(16);
		//rowRev(ara);
		printPyramid(ara);
	}
	public static int[][] generatePascal(int input){
		int[][] temp = new int[input][];
		temp[0] = BASE_CASE;
		for (int i = 1; i < temp.length; i++){
			temp[i] = new int[i+3];
			for (int j = 0; j < temp[i].length; j++){
				if ( (j == 0) || (j == temp[i].length - 1) ){
					temp[i][j] = 0;
				}else{
					temp[i][j] = temp[i-1][j] + temp[i-1][j-1];
				}
			} 
		}
		return temp;
	}
	public static void printPyramid (int[][] input){
		int multiplier = 0;
		multiplier = sizeInt(largestInt(input[input.length - 1])) + 2;
		for (int i = 0; i < input.length;i++){
			printSpace(input.length, i, multiplier);
			for (int j = 0; j < input[i].length; j++){
				if (input[i][j] != 0){
					System.out.printf("%"+(multiplier)+"d",input[i][j]);
				}
			}
			System.out.println();
		}
	}
	public static void printSpace(int num,int row, int multiplier){
		int temp =num - row - 1;
      for (int i = 0; i < temp; i++){
			for (int j = 0; j < multiplier/2; j++){
				System.out.print(" ");
			}
		}
	}
	public static int sizeInt(int input){
		int size = 0;
		int temp = input;
		if (temp == 0){
			size++;
		}else{ 
			while (temp >= 10){
				temp /= 10;
				size++;
			}
			size++;
		}
		return size;
	}
	public static int largestInt(int[] input){
		int temp = 0;
		for (int i = 0; i < input.length; i++){
			if (temp < input[i]){
				temp = input[i];
			}
		}
		return temp;
	}
	public static void rowRev (int[][] input){
		int[] temp;
		for (int i = 0; i < input.length/2; i++){
			temp = input[i];
			input[i] = input[input.length - i - 1];
			input[input.length - i - 1] = temp; 
		}
	}
	public static int[] cFoot (int[][] input){
		int[] temp = new int[input[0].length];
		for (int i = 0; i < input[i].length; i++){
			for (int j = 0; j < input.length; j++){
				temp[i] += input[j][i];
			}
		}
		return temp;
	}
	public static int[] rFoot (int[][] input){
		int[] temp = new int[input.length];
		for (int i = 0; i < input.length; i++){
			for (int j = 0; j < input[i].length;j++){
				temp[i] += input[i][j];
			}
		}
		return temp;
	} 
	public static boolean isEven(int num){ // simple check for even integers
		if (num % 2 == 0){
			 return true;
		}else{
			 return false;
		}
	}
}

