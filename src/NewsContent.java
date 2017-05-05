/**
 * Creates enumeration for the various News content options
 * available to display to the user.
 * Includes source, topic and subject.
 * 
 * @author Nathan Fritz - 113294199
 * @author Alex Kloppenburg - 113388722
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 *
 */
public enum NewsContent {
	
	/**
	 * 
	 */
	SOURCE, TOPIC, SUBJECT;
	
	/**
	 * @author Cavan Gary
	 */
	@Override
	public String toString() {
		
		switch(this){
		case SOURCE:
			return "Source";
		case TOPIC:
			return "Topic";
		case SUBJECT:
			return "Subject";
		default:
			throw new IllegalArgumentException();
		}
	}

}
