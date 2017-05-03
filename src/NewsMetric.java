/**
 * Enumeration to distinguish what each metric of a given story is. Can 
 * be either length or count.
 * 
 * @author Cavan Gary
 *
 */
public enum NewsMetric {
	
	LENGTH, COUNT;
	
	/**
	 * This overridden code capitalizes the code correctly for output to
	 * the user.
	 */
	@Override
	public String toString(){
		switch(this) {
		case LENGTH:
			return "Length";
		case COUNT:
			return "Count";
		default:
			throw new IllegalArgumentException();
		}
	}

}
