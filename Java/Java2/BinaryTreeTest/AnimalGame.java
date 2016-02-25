import java.util.*;
import java.io.*;

public class AnimalGame {
   public static void main(String[] args){
      new AnimalGame();
   }
   public AnimalGame(){
      Scanner kb = new Scanner(System.in);
      AnimalNode n = load();
      if (n == null){
         n = new AnimalNode("Is your animal a mammal?");
         n.y = new AnimalNode("Dog");
         n.n = new AnimalNode("Shark");
      }
      AnimalNode root = n;
      boolean playing = true;
      
      while(playing){
         System.out.println("Welcome to Animal Guess. Please think of an animal.");
         while (n.data.endsWith("?")){
            System.out.print(n.data + " ");
            n = kb.nextLine().equals("y") ? n.y : n.n;
         }
         System.out.print("I think your animal is a " + n.data + ". Am I correct? ");
         if (kb.nextLine().equals("y"))
            System.out.println("GG nerd, I win.");
         else {
            System.out.println("Oh well. Please help me learn.");
            System.out.print("What is the name of your animal? ");
            String animal = kb.nextLine();
            System.out.print("What is a unique question about your animal? ");
            String question = kb.nextLine();
            String temp;
            temp = n.data;
            n.data = question;
            n.y = new AnimalNode(animal);
            n.n = new AnimalNode(temp);
         }
         System.out.print("Play again? ");
         playing = kb.nextLine().equals("y");
         if (playing)
            n = root;
         else
            save(root);
      }
   }
   public void save(AnimalNode root){
      ObjectOutputStream oos = null;
      FileOutputStream fout = null;
      try {
         fout = new FileOutputStream("animal.ser");
         oos = new ObjectOutputStream(fout);
         oos.writeObject(root); 
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         if (oos != null){
            try {
               oos.close();
            }catch (Exception ex){
               ex.printStackTrace();
            }
         }
      }
   }
   
   public AnimalNode load(){
      FileInputStream streamIn = null;
      ObjectInputStream ois = null;
      AnimalNode n = null;
      try{
         streamIn = new FileInputStream("Animal.ser");
         ois = new ObjectInputStream(streamIn);
         n = (AnimalNode)ois.readObject();
      }catch (Exception e){
         e.printStackTrace();
      }finally{
         if (ois != null){
            try {
               ois.close();
            }catch(Exception ex){
               ex.printStackTrace();
            }
         }
      }
      return n;
   }
}