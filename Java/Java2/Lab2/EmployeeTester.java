import java.util.*;
 
public class EmployeeTester {
   public static void main(String[] args){
      List<Employee> employees = new ArrayList<Employee>();
      employees.add(new Programmer("Tim Tanasse", false));
      employees.add(new Programmer("Will E. Makit", true));
      employees.add(new Lawyer("Ivana Killmen", 11));
      employees.add(new Lawyer("Luke N. Dimm", 0));
      employees.add(new Lawyer("Eileen Dover", 100));
      employees.add(new Accountant("Bill Cheatem", 17.00));
      employees.add(new Accountant("Joe Kisonyou", 45.50));
      employees.add(new Accountant("Seymour Butts", 2.50));
      
      for(Employee e: employees){
         e.reportSalary();
      }
   }
}