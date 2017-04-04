import java.util.Comparator;

/**
 * DateComparator compares the date of two news stories.
 * If the date are the same, the time of day will be compared.
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 */
public class DateComparator implements Comparator<NewsStory> 
{
	/** The date comparator */
	public static final DateComparator DATE_COMPARATOR = null; //TODO revert null

	/**
	 * Overridden compare method that compares the date of two news stories.
	 * If the dates are the same, then the time of day of the stories will be compared.
	 * 
	 * @param newsStory1
	 *            The first news story.
	 * @param newsStory2
	 *            The second news story.
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return 0; //TODO revert return
	}
}
