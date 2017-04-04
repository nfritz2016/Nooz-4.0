import java.io.Serializable;
import java.time.LocalDate;
/**
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
*/
abstract class NewsStory implements Comparable<NewsStory>, Serializable {
	/**The Serial UID*/
	private static final long serialVersionUID = 1L;

	/** The date the story was published. */
	private LocalDate date;

	/** The name of the source publishing the story. */
	private String source;

	/** The length of the story. */
	private int length;

	/** The topic of the story. */
	private String topic;

	/** The subject of the story. */
	private String subject;
	
	/** The first news maker featured in the story. */
	private NewsMaker newsMaker1;

	/** The second news maker featured in the story. */
	private NewsMaker newsMaker2;

	/**
	 * The constructor for the class which takes objects of appropriate types to
	 * initialize all of the fields.
	 * 
	 * @param date
	 *            The date the story was published.
	 * @param source
	 *            The name of the source publishing the story.
	 * @param length
	 *            The length of the story.
	 * @param topic
	 *            The topic of the story.
	 * @param suject
	 *            The subject of the story.
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 */
	protected NewsStory(LocalDate date, String source, int length, 
						String topic, String subject, NewsMaker newsMaker1,
						NewsMaker newsMaker2) {
	}

	/**
	 * The accessor for the date field.
	 * 
	 * @return The date the story was published.
	 */
	public LocalDate getDate() {
		return null; //TODO revert return
	}

	/**
	 * The accessor for the source name field.
	 * 
	 * @return The name of the source publishing the story.
	 */
	public String getSource() {
		return null; //TODO revert return
	}

	/**
	 * The accessor for the length field.
	 * 
	 * @return The count of the words in the story.
	 */
	public int getLength() {
		return 0; //TODO revert return
	}

	/**
	 * The accessor for length equivalent in words.
	 * <P>
	 * This accessor for length allows both newspaper, TV, and online news
	 * stories to be compared on the length in words.
	 * <P>
	 * Note that the description above assumes we only have two subclasses, one
	 * for newspaper stories and one for TV news stories. However, this class
	 * should be flexible enough to allow for other types of news stories to be
	 * created as subclasses.
	 * </P>
	 * 
	 * @return The equivalent of the length in words
	 */
	public abstract int getLengthInWords();

	/**
	 * The accessor for the topic field.
	 * 
	 * @return The topic of the story.
	 */
	public String getTopic() {
		return null; //TODO revert return
	}
	
	/**
	 * The accessor for the subject field.
	 *
	 * @return the subject of the story.
	 */
	public String getSubject() {
		return null; //TODO revert return
	}

	/**
	 * The accessor for the first news maker field.
	 * 
	 * @return The first news maker featured in the story.
	 */
	public NewsMaker getNewsMaker1() {
		return null; //TODO revert return
	}

	/**
	 * The accessor for the second news maker field.
	 * 
	 * @return The second news maker featured in the story.
	 */
	public NewsMaker getNewsMaker2() {
		return null; //TODO revert return
	}

	/**
	 * Overridden equals method considers equality of contents
	 * rather than memory locations.
	 *
	 * Compare all fields of news story.
	 */
	@Override
	public boolean equals(Object o) {
		return false; //TODO revert return
	}

	/**
	 * Overridden compareTo method to allow for sorting.
	 * 
	 * The natural ordering for news stories is topic.
	 *
	 */
	@Override
	public int compareTo(NewsStory newsStory) {
		return 0; //TODO revert return
	}
}
