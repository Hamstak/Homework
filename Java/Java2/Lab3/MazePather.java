public class MazePather{
   public static int[][] grid = {{1,1,1,0,1,1,0,0,0,1,1,1,1},
                                 {1,0,1,1,1,0,1,1,1,1,0,0,1},
                                 {0,0,0,0,1,0,1,0,1,0,1,0,0},
                                 {1,1,1,0,1,1,1,0,1,0,1,1,1},
                                 {1,0,1,0,0,0,0,1,1,1,0,0,1},
                                 {1,0,1,1,1,1,1,1,0,1,1,1,1},
                                 {1,0,0,0,0,0,0,0,0,0,0,0,0},
                                 {1,1,1,1,1,1,1,1,1,1,1,1,1}};
   public static void main(String[] args){
      System.out.println(pathMaze(0, 0));
   }
   private static boolean pathMaze( int x, int y){
      if ( x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 3)
         return false;
      if (x == grid.length - 1 && y == grid[0].length - 1)
         return pathed(x,y);
      grid[x][y] = 3;
      if (pathMaze(x - 1, y) || pathMaze(x,y - 1) || pathMaze(x + 1,y) || pathMaze(x,y + 1))
         return pathed(x,y);
      return false;
   }
   private static boolean pathed(int x, int y){
      grid[x][y] = 7;
      return true;
   }
}