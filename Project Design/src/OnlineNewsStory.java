import java.time.LocalDate;
/**
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 */
public class OnlineNewsStory extends NewsStory {
	/**The SerialUID*/
	private static final long serialVersionUID = 1L;
	
	/**The part of day of story screen shot*/
	private PartOfDay partOfDay;

	/**
	 * The constructor which takes parameters for all of the fields
	 * and calls the constructor for parent class NewsStory.
	 * 
	 * @param date
	 *            The date the story was published.
	 * @param sourceName
	 *            The name of the source publishing the story.
	 * @param length
	 *            The length of the story.
	 * @param topic
	 *            The topic of the story.
	 * @param subject
	 *            The subject of the story.          
	 	 * @param partOfDay
	 *            The part of day of story snapshot.  
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 */
	public OnlineNewsStory(LocalDate date, String sourceName, int length, 
						   String topic, String subject, PartOfDay partOfDay, NewsMaker newsMaker1,
						   NewsMaker newsMaker2) {
	}

	/**
	 * Overrides the getLengthInWords method from
	 * NewsStory. Online news stories are in words,
	 * so just return length.
	 *
	 */
	@Override
	public int getLengthInWords() {
		return 0; //TODO revert return
	}
	
	/**
	 * Accessor for part of day field.
	 * @return the part of day of story snapshot.
	 */
	public PartOfDay getPartOfDay() {
		return null; //TODO revert return
	}
	
	@Override
	public boolean equals(Object o) {
	}
}
