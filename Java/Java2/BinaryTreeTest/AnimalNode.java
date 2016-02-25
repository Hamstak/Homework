import java.io.*;
public class AnimalNode implements Serializable{
   public String data;
   public AnimalNode y;
   public AnimalNode n;
   
   public AnimalNode(String data){
      this.data = data;
   }
} 