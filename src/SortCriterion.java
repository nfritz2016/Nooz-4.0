/**
 * Creates enumeration for all of the various sort criterion that 
 * the user can choose from when looking through News Stories.
 * Includes source, topic, subject, length, and Date/Time.
 * 
 * @author Nathan Fritz - 113294199
 * @author Alex Kloppenburg - 113388722
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 */
public enum SortCriterion {
	
	/**
	 * 
	 */
	SOURCE, TOPIC, SUBJECT, LENGTH, DATE_TIME;
	
	/**
	 * @author Cavan Gary
	 */
	@Override
	public String toString() {
		switch(this) {
		case SOURCE:
			return "Source";
		case TOPIC:
			return "Topic";
		case SUBJECT:
			return "Subject";
		case LENGTH:
			return "Length";
		case DATE_TIME:
			return "Date or Time";//TODO: see what string should be used
		default: 
			throw new IllegalArgumentException();
		}
	}

}
