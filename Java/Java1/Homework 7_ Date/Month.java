/* Tim Tanasse
 * Month Class
 * A part of the Date class
 */


public class Month {
	
	public static final String[] MONTHS_OF_YEAR = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public static final int[][] DAY_LIMITS = {{31, 28, 31, 30, 31,30, 31, 31, 30, 31, 30, 31},{31, 29, 31, 30, 31,30, 31, 31, 30, 31, 30, 31}};
	private int monthVal;
	private String monthString;
	private int dayLimit;
	public Month(int month,boolean isLeapYear){
		this.monthVal = month;
		monthSwitch(isLeapYear);
	}
	public int getMonth(){
		return this.monthVal;
	}
	public String getMonthString(){
		return this.monthString;
	}
	public int getDayLimit(){
		return this.dayLimit;
	}
	public void setMonth(int month, boolean isLeapYear){
		this.monthVal = month;
		monthSwitch(isLeapYear);
	}
	@Override
	public boolean equals(Object obj){
		if (obj.getClass().getSimpleName().equals(this.getClass().getSimpleName())){
			Month temp = (Month)obj;
			if (this.monthVal == temp.monthVal){
				return true;
			}
		}
		return false;
	}
	private void monthSwitch(boolean isLeapYear){
		this.monthString = Month.MONTHS_OF_YEAR[monthVal - 1];
		this.dayLimit = this.DAY_LIMITS[Boolean.compare(isLeapYear, false)][monthVal - 1];
	}
	@Override
	public String toString(){
		return this.monthString;
	}
}

