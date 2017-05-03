/**
 * Creates enumeration for the various News content options
 * available to display to the user.
 * Includes source, topic and subject.
 * 
 * @author Cavan Gary
 *
 */
public enum NewsContent {
	
	SOURCE, TOPIC, SUBJECT;
	
	//turns a newsContent enum into a string
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
