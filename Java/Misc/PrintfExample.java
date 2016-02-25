
//  Print formatting examples...

    public class PrintfExample
   {
       public static void main(String[]args)
      {
		
			double x;
			x = 3 / 2;
			
			System.out.print(x + "\n");
         System.out.println(x);
			
			int myInt = 12;
			double myDouble = 12.6789;
				
         String s = String.format("My string with %d code and a %4.2f double", myInt, myDouble);   
         System.out.println(s);   		
         System.out.printf("                       regular: %d \n", myInt);
         System.out.printf("                  left justify: %-20d \n", myInt);
         System.out.printf("                 right justify: %20d \n", myInt);
         System.out.printf("right justify - pad with zeros: %020d \n", myInt);
         System.out.printf("            two decimal places: %20.2f \n", myDouble);
         System.out.printf("                   dollar sign: $%20.3f \n", myDouble);
         System.out.printf("              the percent sign: %%%20.3f\n", myDouble);
      
         System.out.println("----------------");
         System.out.printf("                       regular: %d \n",-12);
         System.out.printf("                  left justify: %-20d \n", -12);
         System.out.printf("                 right justify: %20d \n", -12);
         System.out.printf("right justify - pad with zeros: %020d \n", -12);
         System.out.printf("          three decimal places: %20.3f \n", -12.6789);
         System.out.printf("                   dollar sign: $%20.3f \n", -12.6789);
         System.out.printf("              the percent sign: %%%20.3f\n", -12.6789);
      
         System.out.println("----------------");
         System.out.printf("                      the plus: %+020.2f\n", 12.9876);
         System.out.printf("                     the space: % 020.2f\n", 12.0);
         System.out.printf("negative-      the parenthesis: %(21.2f\n", -12.0);
         System.out.printf("positive-      the parenthesis: %(20.2f\n", 12.0);
         System.out.printf("                   hexadecimal: %20x\n", 12);
      
         System.out.println("----------------");
         System.out.println("Alignment");
         System.out.printf("num: $%10.2f\n", 2.0);
         System.out.printf("num: $%10.2f\n", 24.0);
         System.out.printf("num: $%10.2f\n", 246.0);
         System.out.printf("num: $%10d\n", 2);
         System.out.printf("num: $%10d\n", 24);
         System.out.printf("num: $%10d\n", 246);
      
         System.out.println("----------------");
         System.out.printf("multiple arguments: %1$5.2f %2$3.4f %1$020f\n", 12.01, 25.78);
         System.out.printf("multiple arguments only diff: %1$5.2f %2$3.4f  " +
            					"   %1$020f\n", 12.01, 25.78);
         System.out.printf("multiple arguments: %5.2f %3.4f %20.2f\n", 12.01, 25.78, 15.03);      
      
      }//end main method
   
   
   }//end class