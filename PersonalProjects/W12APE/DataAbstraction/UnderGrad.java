public class UnderGrad extends Student{
   public UnderGrad(int id, int credits){
      super(id, credits);
   }
   public double calcFees(){
      return credits * StudentInterface.PER_CREDIT;
   }
   public String toString(){
      return super.toString() + "Fees: " + calcFees() + "\r\nUndergraduate \r\n";
   }
}