/* Tim Tanasse
 * Year Class
 * A part of the Date Class
 */


public class Year {
	

		private int yearVal;
		private boolean isLeapYear;
		public Year(int yearVal){
			this.yearVal = yearVal;
			this.isLeapYear = calcLeapYear();
		}
	private boolean calcLeapYear(){
		if (this.yearVal % 4 != 0){
			return false;
		}else if (this.yearVal % 100 != 0){
			return true;
		}else if (this.yearVal % 400 != 0){
			return false;
		}else{
			return true;
		}
	}
	public static boolean calcLeapYear(int yearTemp){
		if (yearTemp % 4 != 0){
			return false;
		}else if (yearTemp % 100 != 0){
			return true;
		}else if (yearTemp % 400 != 0){
			return false;
		}else{
			return true;
		}
	}
	public int getYear(){
		return this.yearVal;
	}
	public boolean getLeapYear(){
		return this.isLeapYear;
	}
	public void setYear(int yearVal){
		this.yearVal = yearVal;
		this.isLeapYear = calcLeapYear(yearVal);
	}
	public int compareTo(Year that){
		return this.yearVal - that.yearVal;
	}
	@Override
	public boolean equals(Object obj){
		if (obj.getClass().getSimpleName().equals(this.getClass().getSimpleName())){
			Year temp = (Year)obj;
			if (this.yearVal == temp.yearVal){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString(){
		return "" + yearVal;
	}
}
