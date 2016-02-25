/*
 * 
 * 
 */


public class Rational implements Comparable <Rational> {
	private int[] rat = new int[2];
	
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
		while (den != 0){
			int temp = den;
			den = num % den;
			num = temp;
		}
		return num;
	}
	private int greatestCD (Rational input){
		while (input.rat[1] != 0){
			int temp = input.rat[1];
			input.rat[1] = input.rat[0] % input.rat[1];
			input.rat[0] = temp;
		}
		return input.rat[0];
	}
	public int compareTo (Rational input){
		if (this.rat[0] == input.rat[0] && this.rat[1] == input.rat[1]){
			return 0;
		}else if ( (this.rat[0]/this.rat[1]) < (input.rat[0]/input.rat[1]) ){
			return -1;
		}else {
			return 1;
		}
	}
	public boolean equals (Rational input){
		if (this.rat[0] == input.rat[0] && this.rat[1] == input.rat[1]){
			return true;
		}else{
			return false;
		}
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
		if (this.rat[1] == 1){
			return "" + this.rat[0];
		}
		return this.rat[0]+"/"+this.rat[1]+", " + (this.rat[0]/this.rat[1]);
		
	}
	public void add (Rational input){
		this.rat[0] = (this.rat[0] * input.rat[1]) + (input.rat[0] * this.rat[1]);
		this.rat[1] *= input.rat[1];
		reduce();
	}
	private void reduce(){
		int temp = greatestCD(this.rat[0], this.rat[1]);
			this.rat[0] /= temp;
			this.rat[1] /= temp;
	}
	public void subtract (Rational input){
		this.rat[0] = (this.rat[0] * input.rat[1]) - (input.rat[0] * this.rat[1]);
		this.rat[1] *= input.rat[1];
		reduce();
	}
}

