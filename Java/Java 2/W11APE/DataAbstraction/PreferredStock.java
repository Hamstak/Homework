public class PreferredStock extends Stock{
   public PreferredStock(String symbol, int shares, double price){
      super(symbol, shares, price);
   }
   public double calcDividend(){
      return shares / 100.0;
   }
   public String toString(){
      return super.toString() + "Dividend: " + calcDividend();
   }
}