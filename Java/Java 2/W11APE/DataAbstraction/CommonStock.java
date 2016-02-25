public class CommonStock extends Stock{
   public CommonStock(String symbol, int shares, double price){
      super(symbol, shares, price);
   }
   public double calcDividend(){
      return 0.0;
   }
   public String toString(){
      return super.toString() + "Dividend: " + calcDividend();
   }
}