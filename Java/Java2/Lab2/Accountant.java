public class Accountant extends Employee{
   private double allowance;
   
   public Accountant(String name, double allowance){
      super(name, 0);
      this.allowance = allowance;
   }
   public void reportSalary(){
      System.out.println("I am an accountant. I make $" + getSalary() + ", and I have a parking allowance of $" + allowance + ".");
   }
}