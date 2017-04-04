import java.util.Comparator;

/**
 * SourceComparator compares the source of two news stories.
 * 
 */
public class SourceComparator implements Comparator<NewsStory> 
{
	/** The source comparator */
	public static final SourceComparator SOURCE_COMPARATOR = null; //TODO revert null

	/**
	 * Overridden compare method that compares the sources of two news stories.
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
