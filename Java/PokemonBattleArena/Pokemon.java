public class Pokemon implements Comparable<Pokemon>{
   public static final double[][] TYPE_CHART= 
   //n   f   fl  p   g   r   b   g   s   f   w   g   e   p   i   d   da
   {{1.0,1.0,1.0,1.0,1.0,0.5,1.0,0.0,0.5,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0},//normal
    {2.0,1.0,0.5,0.5,1.0,2.0,0.5,0.0,2.0,1.0,1.0,1.0,1.0,0.5,2.0,1.0,2.0},//fighting
    {1.0,2.0,1.0,1.0,1.0,0.5,2.0,1.0,0.5,1.0,1.0,2.0,0.5,1.0,1.0,1.0,1.0},//flying
    {1.0,1.0,1.0,0.5,0.5,0.5,1.0,0.5,0.0,1.0,1.0,2.0,1.0,1.0,1.0,1.0,1.0},//poison
    {1.0,1.0,0.0,2.0,1.0,2.0,0.5,1.0,2.0,2.0,1.0,0.5,2.0,1.0,1.0,1.0,1.0},//ground
    {1.0,0.5,2.0,1.0,0.5,1.0,2.0,1.0,0.5,2.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0},//rock
    {1.0,0.5,0.5,0.5,1.0,1.0,1.0,0.5,0.5,0.5,1.0,2.0,1.0,2.0,1.0,1.0,2.0},//bug
    {0.0,1.0,1.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,1.0,1.0,1.0,2.0,1.0,1.0,0.5},//ghost
    {1.0,1.0,1.0,1.0,1.0,2.0,1.0,1.0,0.5,0.5,0.5,1.0,0.5,1.0,2.0,1.0,1.0},//steel
    {1.0,1.0,1.0,1.0,1.0,0.5,2.0,1.0,2.0,0.5,0.5,2.0,1.0,1.0,2.0,1.0,1.0},//fire
    {1.0,1.0,1.0,1.0,2.0,2.0,1.0,1.0,1.0,2.0,0.5,0.5,1.0,1.0,1.0,0.5,1.0},//water
    {1.0,1.0,0.5,0.5,2.0,2.0,0.5,1.0,0.5,0.5,2.0,0.5,1.0,1.0,1.0,0.5,1.0},//grass
    {1.0,1.0,2.0,1.0,0.0,1.0,1.0,1.0,1.0,1.0,2.0,0.5,0.5,1.0,1.0,0.5,1.0},//electric
    {1.0,2.0,1.0,2.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0,1.0,1.0,0.5,1.0,1.0,0.0},//psychic
    {1.0,1.0,2.0,1.0,2.0,1.0,1.0,1.0,0.5,0.5,0.5,2.0,1.0,1.0,0.5,2.0,1.0},//ice
    {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.5,1.0,1.0,1.0,1.0,1.0,1.0,2.0,1.0},//dragon
    {1.0,0.5,1.0,1.0,1.0,1.0,1.0,2.0,0.5,1.0,1.0,1.0,1.0,2.0,1.0,1.0,0.5}};
    
    private Type[] type;
    
    private String name;
    
    public Pokemon(String name, String type1, String type2){
      this.name = name;
      this.type = new Type[2];
      this.type[0] = Type.type(type1);
      this.type[1] = Type.type(type2);
    }
    public Pokemon(String name, String type1){
      this.name = name;
      this.type = new Type[1];
      this.type[0] = Type.type(type1);
    }
    public int compareTo(Pokemon that){
      int temp = 1;
      for (int x = 0; x < this.type.length; x++){
         for (int y = 0; y < that.type.length; y++){
            temp *= TYPE_CHART[this.type[x].index()][that.type[y].index()];
         temp *= TYPE_CHART[that.type[y].index()][this.type[x].index()];
         }
      }
      return temp;
    }
    @Override
    public boolean equals(Object obj){
      if (obj.getClass().getSimpleName().equals(this.getClass().getSimpleName())){
         Pokemon that = (Pokemon)obj;
         if (that.name.equals(this.name))
            return true;
      }
      return false;
    }
}