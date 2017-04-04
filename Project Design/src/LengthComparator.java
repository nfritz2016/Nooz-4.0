import java.util.Comparator;

/**
 * LengthComparator compares the lengths of two news stories.
 * Comparison will be on the length in words of the news story.
 * 
 */
public class LengthComparator implements Comparator<NewsStory> 
{
	/** The length comparator */
	public static final LengthComparator LENGTH_COMPARATOR = new LengthComparator();

		/**
		 * Overridden compare method that compares the length of two news stories.
		 * The lengths should be in words equivalent.
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
