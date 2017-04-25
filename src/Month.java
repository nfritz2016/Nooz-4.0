/**
 * 
 * @author Cavan Gary
 *
 */
public enum Month {
	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
	
	@Override
	public String toString() {
		switch(this){
		case JANUARY:
			return "January";
		case FEBRUARY:
			return "February";
		case MARCH:
			return "March";
		case APRIL:
			return "April";
		case MAY:
			return "May";
		case JUNE:
			return "June";
		case JULY:
			return "July";
		case AUGUST:
			return "August";
		case SEPTEMBER:
			return "September";
		case OCTOBER:
			return "October";
		case NOVEMBER:
			return "November";
		case DECEMBER:
			return "December";
		default:
			throw new IllegalArgumentException();
		}
		
		//TODO: Figure out what this method is in UML
		public int fromInt() {
			
		}
		
		
		
	}

}
