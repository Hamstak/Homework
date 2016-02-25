import java.util.*;


public class CastTest {
	
	public static void main (String args[]) {
		int first = 0;
		int second = 0;
		Scanner kb = new Scanner(System.in);
		System.out.print("Input a positive int: ");
		first = kb.nextInt();
		System.out.println();
		kb.nextLine();
		while (first!=0){
			second += first % 10;
			first /= 10;
		}
		System.out.print(second);
	}
}

