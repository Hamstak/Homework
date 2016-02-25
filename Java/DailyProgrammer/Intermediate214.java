import java.io.File;
import java.util.Scanner;

public class Intermediate214{
   public static void main(String[] args) throws Exception{
      File fileHandle = new File(args[0]);
      Scanner fin = new Scanner(fileHandle);
      int x, y;
      String[] canvasSize = fin.nextLine().split(" ");
      x = Integer.parseInt(canvasSize[0]);
      y = Integer.parseInt(canvasSize[1]);
      int[][] canvas = new int[x][y];
      int[] counter = new int[100];
      while(fin.hasNextLine()){
         String[] paperInfo = fin.nextLine().split(" ");
         layPaper(counter,canvas, Integer.parseInt(paperInfo[0]), Integer.parseInt(paperInfo[1]), Integer.parseInt(paperInfo[2]),Integer.parseInt(paperInfo[3]),Integer.parseInt(paperInfo[4]));
      }
      for (int cx = 0; cx < counter.length; cx++){
         if(counter[x] == 0)
            continue;
         System.out.println(x + ": " + counter[x]);
      }
   }
   private static void layPaper(int[] counter, int[][] canvas, int color, int sizex, int sizey, int posx, int posy){
    for(int x = posx; x < posx + sizex; x++){
      for (int y = posy; y < posy + sizey; y++){
         canvas[x][y] = color;
         counter[color]++;
      }
    }
   }
   private static void overLap(Paper one, Paper two,){
      
      if (!(one.posx + one.sizex > two.posx && one.posy + one.sizey > two.posy) || !(two.posx + two.sizex > one.posx && two.posy + two.sizey > one.posy))
         return;
      long tempstartx = two.posx > one.posx ? two.posx : one.posx;
      long tempendx = two.posx + two.sizex > one.posx + one.sizex ? one.posx + one.sizex : two.posx + two.sizex;
      long tempstarty = two.posy > one.posx ? two.posy : one.posy;
      long tempendy = two.posy + two.sizey > one.posy + one.sizey ? one.posy + one.sizey : two.posy + two.sizey;
      one.area = one.area - ((tempendx - tempstartx) * (tempendy - tempstarty));
   }
}