/**
 * Creates enumeration for all of the various sort criterion that 
 * the user can choose from when looking through News Stories.
 * Includes source, topic, subject, length, and Date/Time.
 * 
 * @author Cavan Gary
 *
 */
public enum SortCriterion {
	
	SOURCE, TOPIC, SUBJECT, LENGTH, DATE_TIME;
	
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
