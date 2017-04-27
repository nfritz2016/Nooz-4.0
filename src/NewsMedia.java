import java.util.List;

/**
 * 
 * @author Cavan Gary
 *
 */
public enum NewsMedia {
	NEWSPAPER, ONLINE, TV;
	
	//TODO: See what kind of list to make it into
	public static List<NewsMedia> VALUES_LIST;
	
	public String toString() {
		
		switch(this) {
		case NEWSPAPER:
			return "Newspaper";
		case ONLINE:
			return "Online";
		case TV:
			return "TV";//TODO: Check to see if this is right output
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public List<NewsMedia> valuesAsList() {
		
		VALUES_LIST.add(NEWSPAPER);
		VALUES_LIST.add(ONLINE);
		VALUES_LIST.add(TV);
		
		return VALUES_LIST;
	
	}


}
