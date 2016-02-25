/*
 * GreatestCommonDivisor.java
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


public class GreatestCommonDivisor {
	
	public static void main (String args[]) {
		int num1=45;
		int num2=12;
		while (num2>0){
			int remainder = num1 % num2;
			num1 = num2;
			num2 = remainder;
		}
		System.out.println(num1);
	}
}

