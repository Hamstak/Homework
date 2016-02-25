import java.util.Scanner;

public class DeckStackerRecursive {
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      run(kb.nextInt());
   }
   private static void run(int n){
      Scanner kb = new Scanner(System.in);
      if (n == 0)
         return;
      stackDeck(kb.nextInt());
      run(n-1);
   }
   private static void stackDeck(int size){
      int[] deck = new int[size];
      createDeck(1,0,deck);
      printDeck(0,deck);
      System.out.println();
   }
   private static void createDeck(int card, int pos, int[] deck){
      if (card == deck.length){
         deck[pos] = card;
         return;
      }
      deck[pos] = card;
      createDeck(card + 1,burnTwo(2,pos,deck),deck);
   }
   private static int burnTwo(int times,int pos, int[] deck){
      if (deck[pos] > 0)
         if (pos == deck.length - 1)
            return burnTwo(times,0,deck);
         else
            return burnTwo(times,pos + 1,deck);
      if (times == 0)
         return pos;
      if(pos == deck.length - 1)
         return burnTwo(times - 1, 0, deck);
      return burnTwo(times - 1, pos + 1, deck);
   }
   private static void printDeck(int index, int[] deck){
      if(index == deck.length)
         return;
      System.out.print(deck[index]);
      printDeck(index + 1, deck);
   }
}