public abstract class Employee {
   private String name;
   
   private double salary;
   private double salaryDifference;
   
   public double getSalary(){ return salary + salaryDifference; }
   
   public Employee(String name, double salaryDifference){
      this.name = name;
      this.salary = 40000;
      this.salaryDifference = salaryDifference;
   }
    public abstract void reportSalary();
}