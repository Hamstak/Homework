/*
*
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class InvoiceTester{
   
   public static void main(String[] args)throws IOException{
      ArrayList<Item> items = readItems();
      Invoice invoice = createInvoice(items);
      System.out.print(invoice.toString());
   }
   public static Scanner checkIntegrity(String fileName, int modValue)throws IOException{
	  Scanner fin = FileUtil.openInputFile(fileName);
	  int count = FileUtil.countFile(fin);
      fin.close();
      if(count % modValue != 0){
         return null;
      }
      return FileUtil.openInputFile(fileName);
   }
   public static ArrayList<Item> readItems() throws IOException{
      Scanner fin = checkIntegrity("Items.txt",5);
      if (fin == null){
		  return null;
	  }
      return buildItems(fin);
   }
   public static ArrayList<Item> buildItems(Scanner fin){
	   String[] stringTemp = new String[5];
      ArrayList<Item> items = new ArrayList<Item>();
      while(fin.hasNextLine()){
         for(int j = 0; j < 5; j++){
            stringTemp[j] = fin.nextLine();
         }
         Integer stockTemp = Integer.parseInt(stringTemp[0]);
         String descriptionTemp = stringTemp[1];
         Double priceTemp = Double.parseDouble(stringTemp[2]);
         Integer quantityTemp = Integer.parseInt(stringTemp[3]);
         Double weightTemp = Double.parseDouble(stringTemp[4]);
         Item itemTemp = new Item(stockTemp, descriptionTemp, priceTemp, quantityTemp, weightTemp);
         items.add(itemTemp);
         Collections.sort(items);
      }
      return items;
   }
   public static Invoice createInvoice(ArrayList<Item> items)throws IOException{
      Scanner fin = checkIntegrity("Order.txt",2);
      Invoice invoice = initializeInvoice(fin);
      fillInvoice(items,invoice,fin);
      return invoice;
   }
   public static Invoice initializeInvoice(Scanner fin){
    Integer customerNumber;
      if(fin.hasNextLine())
         customerNumber = new Integer(Integer.parseInt(fin.nextLine()));
      else
         return null;
      Integer orderNumber;
      if(fin.hasNextLine())
         orderNumber = new Integer(Integer.parseInt(fin.nextLine()));
      else
         return null;
      return new Invoice(orderNumber, customerNumber);  
   }
   public static void fillInvoice(ArrayList<Item> items, Invoice invoice, Scanner fin){
      Integer[] lineItemTemp = new Integer[2];
      while(fin.hasNextLine()){
         for(int i = 0; i < lineItemTemp.length; i++){
            if (fin.hasNextLine()){
               lineItemTemp[i] = Integer.parseInt(fin.nextLine());
            }else{
               break;
            }
         }
         Item dummyItem = new Item(lineItemTemp[0]);
         int searchIndex = Collections.binarySearch(items, dummyItem);
         if (searchIndex >= 0)
            invoice.addItem(items.get(searchIndex), lineItemTemp[1].intValue());
      }
   }
}
