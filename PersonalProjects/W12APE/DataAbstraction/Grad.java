public class Grad extends Student{
   private double perCredit;
   public Grad(int id, int credits, double fee){
      super(id,credits);
      perCredit = fee;
   }
   public double calcFees(){
      return credits * perCredit;
   }
   public String toString(){
      return super.toString() + "Fees: " + calcFees() + "\r\nGraduate\r\n";
   }
}