/* Tim Tanasse 
 * Day Class
 * A part of the Date class
 */


public class Day {
	private static final String[] DAYS_OF_WEEK = { "Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
	private int dayVal;
	private int dayOfWeekInt;
	private String dayOfWeek;
	public Day(int day, int dayOfWeek){
		this.dayVal = day;
		this.dayOfWeekInt = dayOfWeek;
		this.dayOfWeek = DAYS_OF_WEEK[dayOfWeek];
	}
	public int getDay(){
		return this.dayVal;
	}
	public int getDayOfWeekInt(){
		return this.dayOfWeekInt;
	}
	public String getDayOfWeek(){
		return this.dayOfWeek;
	}
	public void setDay(int day){
		dayOfWeekInt = (dayOfWeekInt + (this.dayVal - day) % 7) + 1;
		this.setDayOfWeek(this.dayOfWeekInt);
		this.dayVal = day;
	}
	
	public void setDayOfWeek(int dayOfWeekInt){
		this.dayOfWeek = DAYS_OF_WEEK[dayOfWeekInt - 1];
	}
	@Override
	public boolean equals(Object input){
		if (input.getClass().getSimpleName().equals(this.getClass().getSimpleName())){
			Day that = (Day)input;
			if (this.dayOfWeek.equals(that.getDayOfWeek()) && this.dayVal == that.getDay()){
				return true;
			}
		}
		return false;
	}
}

