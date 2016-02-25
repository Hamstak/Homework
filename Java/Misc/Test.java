/*
 * test.java
 * 
 * Copyright 2015 Tim Tanasse <tim@tim-Aspire-5560>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
import java.util.Scanner;

public class test {
	
	public static void main (String args[]) {
		int option = 0;
		boolean yn = (4 < 3 && 2 == 2 && 3 > 9 && 34532 / 324 > 29);
		System.out.print(22 / 44 + (3 % 31));
      int[] ara = {5,6,3,8,120,3,4,2};
      System.out.println(Boolean.compare(true, false) +""+ Boolean.compare(false, false) +""+ Boolean.compare(false, true) +""+ Boolean.compare(true, true));
      SortSearchUtil.selectionSort(ara);
		String myString = "Hello!";
		Scanner kb = new Scanner(System.in);
		option = kb.nextInt();
		switch(option){
			case 1: System.out.println(myString.charAt(1));
			break;
			case 2: System.out.println(myString.substring(1,3));
			break; 
			case 3: System.out.println(myString.substring(1));
			break;
			case 4: System.exit(0);
		}
		int i = 0;
		for (i = 0; i < 5; i++){
			System.out.println();
		}
		System.out.println(i);
		System.out.println(7/2);
		greatestCD(3,11);
		greatestCD(2,14);
		greatestCD(18,300);
	}
	public static int greatestCD(int num1, int num2){
		while (num2 != 0){
			int temp = num2;
			num2 = num1 % num2;
			num1 = temp;
		}
		return num1;
	}
}

