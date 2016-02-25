/* Tim Tanasse
 * Rational number class.
 * 
 */


public class Rational implements Comparable<Rational>{
	private int[] rat = new int[2];
	// rat[0] is a the numerator and rat[1] is the denominator
	public Rational(){
		this.rat[0] = 1;
		this.rat[1] = 1;
	}
	public Rational(int num, int den){
		this.rat[0] = num;
		this.rat[1] = den;
		reduce();
	}
	private int greatestCD (int num, int den){
		num = Math.abs(num);
		den = Math.abs(den);
		while (den != 0){
			int temp = num % den;
			num = den;
			den = temp;
		}
		return num;
	}
	private int greatestCD (Rational input){
		input.rat[0] = Math.abs(input.rat[0]);
		input.rat[1] = Math.abs(input.rat[1]);
		while (input.rat[1] != 0){
			int temp =  input.rat[0] % input.rat[1];
			input.rat[0] =input.rat[1];
			input.rat[1] = temp;
		}
		return input.rat[0];
	}
	@Override
	public int compareTo (Rational input){
		int temp1 = this.rat[0] * input.rat[1];
		int temp2 = this.rat[1] * input.rat[0];
		return temp1 - temp2;
	}
	@Override
	public boolean equals (Object input){
		if (input.getClass().getSimpleName().equals(this.getClass().getSimpleName())){
			Rational that = (Rational)input;
			if (this.rat[0] == that.getNumerator() && this.rat[1] == that.getDenominator()){
				return true;
			}
		}
		return false;
	}
	public void setNumerator (int num){
		this.rat[0] = num / greatestCD(num,this.rat[1]);
	}
	public void setDenominator (int num){
		this.rat[1] = num /greatestCD(this.rat[0], num);
	}
	public int getNumerator(){
		return this.rat[0];
	}
	public int getDenominator(){
		return this.rat[1];
	}
	@Override
	public String toString(){
		return String.format("%d"+"/"+"%d"+", "+"%.2f",this.rat[0],this.rat[1],((double)this.rat[0]/(double)this.rat[1]));
	}
	public void add (Rational input){
		this.rat[0] = (this.rat[0] * input.rat[1]) + (input.rat[0] * this.rat[1]);
		this.rat[1] *= input.rat[1];
		reduce();
	}
	public static Rational add (Rational r1,Rational r2){
		Rational temp = new Rational((r1.rat[0] * r2.rat[1]) + (r2.rat[0] * r1.rat[1]),(r1.rat[1]*r2.rat[1]));
		return temp;
	}
	private void reduce(){
		int temp = greatestCD(this.rat[0], this.rat[1]);
			this.rat[0] /= temp;
			this.rat[1] /= temp;
	}
	public void sub (Rational input){
		this.rat[0] = (this.rat[0] * input.rat[1]) - (input.rat[0] * this.rat[1]);
		this.rat[1] *= input.rat[1];
		reduce();
	}
	public static Rational sub (Rational r1, Rational r2){
		Rational temp = new Rational((r1.rat[0] * r2.rat[1]) - (r2.rat[0] * r1.rat[1]),(r1.rat[1]*r2.rat[1]));
		return temp;
	}
	public static Rational[] initializeRationalArray(int[][] input){
		  Rational[] temp = new Rational[input.length];
		  for (int i = 0; i < input.length; i++){
			  temp[i] = new Rational(input[i][0], input[i][1]);
		  }
		  return temp;
	  }
}

