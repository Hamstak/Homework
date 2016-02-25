/*
*
*/

public class LineItem{
   private Item item;
   public Item item(){ return item; }
   
   private Integer amount;
   public Integer amount(){ return amount; }
   public void setAmount(int amount){ 
      this.amount = amount; 
   }
   
   public LineItem(Item item, int amount){
      this.item = item;
      this.amount = new Integer(amount);
   }
   
   public Double getExtensionPrice(){
      return new Double(amount.intValue() * item.price().doubleValue());
   }
   
   public Double getExtensionWeight(){
      return new Double(amount.intValue() * item.weight().doubleValue());
   }
   @Override
   public String toString(){
      int temp1 = item.stockUnit().intValue();
      String temp2 = item.description();
      int temp3 = amount.intValue();
      double temp4 = getExtensionPrice().doubleValue();
      double temp5 = getExtensionWeight().doubleValue();
      return String.format("%10d\t%-20s\t%4d\t%10.2f\t%10.2f",temp1,temp2,temp3,temp4,temp5);
   }
}