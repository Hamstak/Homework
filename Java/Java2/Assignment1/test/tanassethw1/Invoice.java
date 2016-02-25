/*
*
*
*/
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Invoice{
   
   private Integer orderNumber;
   public Integer orderNumber(){ return orderNumber; }
   
   private Integer customerNumber;
   public Integer customerNumber(){ return customerNumber; }
   
   private Date orderDate;
   public Date orderDate(){ return orderDate; }
   
   private ArrayList<LineItem> lineItems;
   public ArrayList<LineItem> lineItems(){ return lineItems; }
   
   public Invoice( int orderNumber, int customerNumber){
      this.orderNumber = new Integer(orderNumber);
      this.customerNumber = new Integer(customerNumber);
      Calendar temp = Calendar.getInstance();
      this.orderDate = temp.getTime();
      lineItems = new ArrayList<LineItem>();
      
   }
   public void addItem(Item newItem, int quantity){
      LineItem temp = new LineItem(newItem, quantity);
      for (int i = 0; i < lineItems.size();i++){
         if(lineItems.get(i).item().description().equals(temp.item().description())){
            lineItems.get(i).setAmount(lineItems.get(i).amount()+quantity);
            return;  
         }
      }
      lineItems.add(temp);
   }
   @Override
   public String toString(){
      String temp = String.format("ORDER: %d\nCUSTOMER: %d\nDATE: %s\n",orderNumber.intValue(),customerNumber.intValue(),orderDate.toString());
      temp = temp + "\n\t SKU    Description\t    Quantity\t    Price\t   Weight";
      temp = temp + "\n       -------------------------------------------------------------------";
      for(int i = 0; i < lineItems.size();i++){
         temp = temp + "\n  " + lineItems.get(i).toString();
      }
      return temp;
   }
   
}