public class Paper{
   public long posx;
   public long posy;
   public long sizex;
   public long sizey;
   public int color;
   public long area;
   
   public Paper(int color, long sizex, long sizey, long posx, long posy){
      this.posx = posx;
      this.posy = posy;
      this.sizex = sizex;
      this.sizey = sizey;
      this.color = color;
      area = sizex * sizey;
   }
}