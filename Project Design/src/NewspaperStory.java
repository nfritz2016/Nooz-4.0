import java.time.LocalDate;

public class NewspaperStory extends NewsStory {
	
	/**The SerialUID*/
	private static final long serialVersionUID = 1L;

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
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 */
	public NewspaperStory(LocalDate date, String sourceName, int length, 
						  String topic, String subject, NewsMaker newsMaker1,
						  NewsMaker newsMaker2) {
	}


	/**
	 * Overrides the getLengthInWords method from
	 * NewsStory. Newspaper story length is already
	 * in word count, so just return length.
	 *
	 */
	@Override
	public int getLengthInWords() {
		return 0; //TODO revert return
	}
}
