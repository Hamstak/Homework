public class Programmer extends Employee {
   private boolean busPass;
   public boolean busPass() { return busPass; }
   
   public Programmer(String name, boolean busPass){
      super(name, 20000);
      this.busPass = busPass;
   }
   public void reportSalary(){
    System.out.println("I am a programmer. I make $" + getSalary() + ", and I " + ((busPass()) ? "have a bus pass." : "have no bus pass."));
   }
}