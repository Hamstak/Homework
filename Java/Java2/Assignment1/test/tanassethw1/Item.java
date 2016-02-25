/*
 * 
 * 
 */


public class Item implements Comparable<Item>{
	
   private Integer stockUnit;
   public Integer stockUnit(){ return stockUnit;}
   
	private String description;
   public String description(){ return description; }
   
	private Double price;
   public Double price(){ return price; }
   
	private Integer quantity;
   
	private Double weight;
   public Double weight(){ return weight; }
	
	public Item(Integer stockUnit, String description, Double price, Integer quantity, Double weight){
		this.stockUnit = stockUnit;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
      this.weight = weight;
	}
   public Item(Integer stockUnit){
      this.stockUnit = stockUnit;
   }
   @Override
	public String toString(){
		return String.format("%d\n%s\n%f\n%d\n%f\n",stockUnit,description, price, quantity, weight);
	}
   public int compareTo(Item that){
      return this.stockUnit - that.stockUnit;
   }
}