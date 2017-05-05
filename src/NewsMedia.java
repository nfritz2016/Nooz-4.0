import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Cavan Gary - 113388151
 */
public enum NewsMedia {
	
	/**
	 * 
	 */
	NEWSPAPER, ONLINE, TV;
	
	/**
	 * 
	 */
	public static List<NewsMedia> VALUES_LIST;
	
	/**
	 * @author Cavan Gary
	 * @author Alex Kloppenburg
	 */
	public String toString() {
		
		switch(this) {
		case NEWSPAPER:
			return "Newspaper";
		case ONLINE:
			return "Online";
		case TV:
			return "TV";
		default:
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * @author Cavan Gary
	 * @author Alex Kloppenburg
	 * @return
	 */
	public List<NewsMedia> valuesAsList() {
		
		VALUES_LIST = new ArrayList<NewsMedia>();
		
		VALUES_LIST.add(NEWSPAPER);
		VALUES_LIST.add(ONLINE);
		VALUES_LIST.add(TV);
		
		return VALUES_LIST;
	
	}


}
