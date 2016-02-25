/* Tim Tanasse
 * Date Class
 */


public class Date implements Comparable<Date>{
	
	private Day theDay;
	private Month theMonth;
	private Year theYear;
	
	public Date(){
		this.theYear = new Year(1970);
		this.theMonth = new Month(1, this.theYear.getLeapYear());
		this.theDay = new Day(1, this.calcDayofWeek(1));
	}
	public Date(int monthVal, int dayVal , int yearVal){
		theYear = new Year(yearVal);
		theMonth = new Month(monthVal, this.theYear.getLeapYear());
		theDay = new Day(dayVal, this.calcDayofWeek(dayVal));
	}
	public int getDay(){
		return this.theDay.getDay();
	}
	public int getYear(){
		return this.theYear.getYear();
	}
	public int getMonth(){
		return this.theMonth.getMonth();
	}
	public void setYear(int yearVal){
		this.theYear.setYear(yearVal);
	}
	public void setMonth(int monthVal){
		Month temp = new Month(monthVal, this.theYear.getLeapYear());
		this.theMonth = temp;
	}
	public void setDay(int dayVal){
		Day temp = new Day(dayVal, this.calcDayofWeek(dayVal));
		this.theDay = temp;
	}
	private int calcNumLeapDays(){
		int count = 0;
		for (int i = 1970; i < this.theYear.getYear(); i++){
			if (Year.calcLeapYear(i)){
				count++;
			}
		}
		return count;
	}
	private int calcNumMonthDays(){ //returns the day
		int count = 0;
		for (int i = 1; i < this.theMonth.getMonth(); i++){
			count += Month.DAY_LIMITS[Boolean.compare(this.theYear.getLeapYear(), false)][i - 1];
		}
		return count;
	}
	public int compareTo(Date that){
		Year temp = new Year(1970);
		int rawDaysThis = (this.theYear.compareTo(temp) * 365) * this.calcNumLeapDays() + this.calcNumMonthDays() + this.theDay.getDay();
		int rawDaysThat = (that.theYear.compareTo(temp) * 365) * that.calcNumLeapDays() + that.calcNumMonthDays() + that.theDay.getDay();
		return rawDaysThis - rawDaysThat;
	}
	@Override
	public boolean equals(Object obj){
		if (obj.getClass().getSimpleName().equals(this.getClass().getSimpleName())){
			Date temp = (Date)obj;
			if (this.theDay.equals(temp.theDay) && this.theMonth.equals(temp.theMonth) && this.theYear.equals(temp.theYear)){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString(){
		return "" + this.theMonth.getMonth() + "/" + this.theDay.getDay() +"/" + this.theYear.getYear();
	}
   public String toStringLongForm(){
      Date temp = new Date (1,1,this.theYear.getYear());
		return this.theDay.getDayOfWeek() + " " + this.theMonth.getMonthString() + " "+this.theDay.getDay()+" " + this.theYear.getYear() + ", day " + (this.compareTo(temp) + 1) + " of the year";
   }
	private int calcDayofWeek(int dayVal){ // formula source: http://mathforum.org/library/drmath/view/55837.html
		int monthTemp = this.theMonth.getMonth();
		int yearTemp = this.theYear.getYear();
		if (monthTemp < 3){
			if (monthTemp == 2){
				monthTemp = 14;
				yearTemp--;
			}else{
				monthTemp = 13;
				yearTemp--;
			}
		}
		int temp = dayVal + (2 * monthTemp) + ((3 * (monthTemp + 1) ) / 5) + yearTemp + (yearTemp/4) - (yearTemp/100) + (yearTemp/400) + 2;
		return temp % 7;
	}
	public static int valiDate(int monthVal, int dayVal, int yearVal){ //returns 0 if date is bad, 1 if good.
		int dayLimitTemp = 0;
		try{
			dayLimitTemp = Month.DAY_LIMITS[Boolean.compare(Year.calcLeapYear(yearVal),false)][monthVal - 1];
		}catch (Exception e){
			dayLimitTemp = 0;
		}
		if (dayLimitTemp == 0){
			return 0;
		}
		if ( (yearVal >= 1970) && (yearVal <= 2400) && (monthVal > 0) && (monthVal < 13) && (dayVal > 0) && (dayVal <= dayLimitTemp)){
			return 1;
		}
		else return 0;
	}
}

