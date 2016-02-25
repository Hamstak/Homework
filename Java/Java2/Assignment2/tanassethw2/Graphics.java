public class Graphics{
   private static final String[] UPPER_H = {"###   ###", "###   ###", "###   ###", "#########", "#########", "###   ###", "###   ###","###   ###"};
   private static final String[] LOWER_E = {"         ", "         ", "         ", "  ####  ", " #   ## ", " ####   ", " #      ", "  #### "};
   private static final String[] LOWER_R = {"         ", "         ", "         ", "#  ####  ", "# #    ##", "##       ", "#        ", "##       "};
   
   public static void startScreen(){
      String temp = "";
      for(int i = 0; i < 8; i++){
         temp = temp + UPPER_H[i];
         temp = temp + " ";
         temp = temp + LOWER_E[i];
         temp = temp + " ";
         temp = temp + LOWER_R[i];
         temp = temp + "\n";
      }
      System.out.print(temp);
   }
   public static void repaint(){
      System.out.print("\n");
   }
}