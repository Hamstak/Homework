import java.util.Scanner;

public class DeckStacker {
   public static void main(String[] args){
      int times;
      int[] deckSizes;
      int[] deck;
      Scanner kb = new Scanner(System.in);
      
      System.out.print("Enter a number of times you want to run -> ");
      times = kb.nextInt();
      kb.nextLine();
      System.out.println();
      deckSizes = new int[times];
      for (int i = 0; i < deckSizes.length; i++){
         System.out.print("Enter the size of deck " + (i + 1) + " -> ");
         deckSizes[i] = kb.nextInt();
         kb.nextLine();
         System.out.println();
      }
      for (int i = 0; i < times; i++){
         deck = new int[deckSizes[i]];
         int pos = 0;
         for (int j = 1; j < deck.length; j++){
            deck[pos] = j;
            for (int y = 0; y <= 1; y++){
               while (deck[pos] > 0){
                  if (pos == deck.length - 1)
                     pos = 0;       
                  else
                     pos++;
               }
               if (pos == deck.length - 1)
                  pos = 0;
               else
                  pos++;
               while (deck[pos] > 0){
                  if (pos == deck.length - 1)
                     pos = 0;       
                  else
                     pos++;
               }
            }
         }
         deck[pos] = deck.length;
         for(int z = 0; z < deck.length;z++)
            System.out.print(deck[z]);
         System.out.println();
      }
   }
}