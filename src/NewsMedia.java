import java.awt.List;

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
			return "tv";//TODO: Check to see if this is right output
		}
	}
	
	public List<NewsMedia> valuesAsList() {
		
	}

}
