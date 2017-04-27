import java.util.Comparator;

/**
 * Project 4, CS 2334, May 5, 2017
 * <P>
 * SubjectComparator compares the subject of two news stories.
 * 
 * @author Joe Pauly (112909034)
 *
 */
public class SubjectComparator implements Comparator<NewsStory> {
	
	public static final SubjectComparator SOURCE_COMPARATOR = new SubjectComparator();
	
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return newsStory1.getSubject().compareTo(newsStory2.getSubject());
	}
}
