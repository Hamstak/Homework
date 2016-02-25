/*
*
*/

package rltut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Point{
   public int x;
   public int y;
   public int z;
   
   public Point(int x, int y, int z){
      this.x = x;
      this.y = y;
      this.z = z;
   }
   @Override
   public boolean equals(Object obj){
      if (this==obj)
         return true;
      if (obj == null)
         return false;
      if (obj.getClass() != this.getClass())
         return false;
      Point that = (Point)obj;
      if (x != that.x)
         return false;
      if (y != that.y)
         return false;
      if (z != that.z)
         return false;
      return true;
   }
   public List<Point> neighbors8(){
      List<Point> points = new ArrayList<Point>();
      for (int ox = -1; ox < 2; ox++){
         if (ox == 0 || ox + x < 0)
            continue;
         for (int oy = -1; oy < 2 ; oy++){
            if (oy == 0 || oy + y < 0)
               continue;
            points.add(new Point(x+ox, y+oy, z));
         }
      }
      Collections.shuffle(points);
      return points;
   }
}