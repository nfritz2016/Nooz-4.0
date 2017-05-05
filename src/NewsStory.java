import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Project 3, CS 2334, Section 010 March 8, 2017
 * <P>
 * A <code>NewsStory</code> is composed of the date the story was published, the
 * name of the source (such as newspaper or TV news program) where the story was
 * published, the length the story (in words for written stories; in seconds for
 * spoken news), the broad topic for the story, the specific subject matter of
 * the story, and two lead news makers in the story.
 * </P>
 * 
* @author Nathan Fritz - 113294199
 * @author Alex Kloppenburg - 113388722
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 * @author Dean Hougen
 * 
 */
abstract class NewsStory implements Comparable<NewsStory>, Serializable {
	/**
	 * This is the first serializable version of NewsStory, so we select a
	 * serialVersionUID of 1L.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The date the story was published/broadcast as a
	 * <code>java.time.LocalDate</code>.
	 */
	private LocalDate date;

	/** The name of the source in which the story was published. */
	private String source;

	/** The length of the story. */
	private int length;

	/** The broad topic of the story. */
	private String topic;

	/** The specific subject matter of the story. */
	private String subject;

	/** The first news maker featured in the story. */
	private NewsMakerModel newsMaker1;

	/** The second news maker featured in the story. */
	private NewsMakerModel newsMaker2;

	/**
	 * The constructor for the class which takes objects of appropriate types to
	 * initialize all of the fields.
	 * <P>
	 * Note that in the length a story cannot be negative, so our class should
	 * model that fact. However, to keep the project relatively simple, this
	 * requirement was not made in the project description and this check
	 * doesn't need to be made yet.
	 * </P>
	 * 
	 * @param date
	 *            The date the story was published as a java.time.LocalDate.
	 * @param source
	 *            The name of the source in which the story was published.
	 * @param length
	 *            The length of the story.
	 * @param topic
	 *            The broad topic of the story.
	 * @param subject
	 *            The specific subject matter of the story.
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 *            
	 * @author Dean Hougen
	 * @author Cavan Gary
	 * @author Alex Kloppenburg
	 */
	protected NewsStory(LocalDate date, String source, int length, String topic, String subject, NewsMakerModel newsMaker1,
			NewsMakerModel newsMaker2) {
		this.date = date; // Note that LocalDate is immutable
		this.source = source;
		if(length >= 0){
			this.length = length;
		}
		else{
			this.length = 0;
			System.err.println("News Story length value was negative, length has been set to default of 0.");
		}
		this.topic = topic;
		this.subject = subject;
		this.newsMaker1 = newsMaker1;
		this.newsMaker2 = newsMaker2;
	}

	/**
	 * The accessor for the date field.
	 * <P>
	 * Note that <code>LocalDate</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The date the story was published.
	 * @author Dean Hougen
	 */
	public LocalDate getDate() {
		return date; // Note that LocalDate is immutable
	}

	/**
	 * The accessor for the source name field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The name of the source in which the story was published.
	 * @author Dean Hougen
	 */
	public String getSource() {
		return source;
	}

	/**
	 * The accessor for the length field.
	 * <P>
	 * Note that <code>int</code>s are passed by value, so it is fine to return
	 * the field itself.
	 * </P>
	 * 
	 * @return The count of the words in the story.
	 * @author Dean Hougen
	 */
	public int getLength() {
		return length;
	}

	/**
	 * The accessor for length equivalent in words.
	 * <P>
	 * This accessor for length allows both newspaper stories and TV news
	 * stories to be compared on the same basis: words. Since newspaper stories
	 * already have their length measured in words, for newspaper stories, we
	 * can simply return their length. For TV news stories, though, the measured
	 * value is duration in minutes, so we need to convert this to an
	 * approximate number of words before returning it.
	 * </P>
	 * <P>
	 * Note that the description above assumes we only have two subclasses, one
	 * for newspaper stories and one for TV news stories. However, this class
	 * should be flexible enough to allow for other types of news stories to be
	 * created as subclasses.
	 * </P>
	 * 
	 * @return The equivalent of the length in words
	 * 
	 * @author Dean Hougen
	 */
	public abstract int getLengthInWords();

	/**
	 * The accessor for the topic field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The broad topic of the story.
	 * @author Dean Hougen
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * The accessor for the subject field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The specific subject matter of the story.
	 * @author Dean Hougen
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * The accessor for the first news maker field.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @return The first news maker featured in the story.
	 * @author Dean Hougen
	 * @author Alex Kloppenburg
	 */
	public NewsMakerModel getNewsMaker1() {
		NewsMakerModel newsmaker1 = this.newsMaker1;
		return newsmaker1;
	}

	/**
	 * The accessor for the second news maker field.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @return The second news maker featured in the story.
	 * @author Dean Hougen
	 * @author Alex Kloppenburg
	 */
	public NewsMakerModel getNewsMaker2() {
		NewsMakerModel newsmaker2 = this.newsMaker2;
		return newsmaker2;
	}
	
	//Begins setters probably for the edit newsStory window
	
	/**
	 * 
	 * @param date
	 * @author Dean Hougen
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * 
	 * @param source
	 */
	public void setSource(String source){
		this.source = source;
	}
	
	/**
	 * 
	 * @param length
	 * @author Dean Hougen
	 */
	public void setLength(int length){
		this.length = length;
	}
	
	/**
	 * 
	 * @param topic
	 * @author Dean Hougen
	 */
	public void setTopic(String topic){
		this.topic = topic;
	}
	
	/**
	 * 
	 * @param subject
	 * @author Dean Hougen
	 */
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	/**
	 * 
	 * @param newsMaker1
	 * @author Dean Hougen
	 * @author Alex Kloppenburg
	 */
	public void setNewsMaker1(NewsMakerModel newsMaker1){
		this.newsMaker1 = newsMaker1;
	}
	
	/**
	 * 
	 * @param newsMaker2
	 * @author Dean Hougen
	 * @author Alex Kloppenburg
	 */
	public void setNewsMaker2(NewsMakerModel newsMaker2){
		this.newsMaker2 = newsMaker2;
	}

	/**
	 * Overridden <code>equals</code> method considers equality of contents
	 * rather than memory locations.
	 * <P>
	 * Note that we compare all fields of news story but that
	 * <code>equals</code> for the news makers themselves does not compare their
	 * news story lists.
	 * </P>
	 * 
	 * @param o
	 *            The object to which to compare this.
	 * @author Dean Hougen
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof NewsStory) {
			NewsStory newsStory = (NewsStory) o;
			boolean equivalent = this.date.equals(newsStory.date);
			if (equivalent) {
				equivalent = this.source.equals(newsStory.source);
			}
			if (equivalent) {
				equivalent = this.length == newsStory.length;
			}
			if (equivalent) {
				equivalent = this.topic.equals(newsStory.topic);
			}
			if (equivalent) {
				equivalent = this.subject.equals(newsStory.subject);
			}
			if (equivalent) {
				equivalent = this.newsMaker1.equals(newsStory.newsMaker1);
			}
			if (equivalent) {
				equivalent = this.newsMaker2.equals(newsStory.newsMaker2);
			}
			return equivalent;
		}
		// If it isn't a NewsStory, it's not equivalent.
		else {
			return false;
		}
	}

	/**
	 * Overridden <code>compareTo</code> method to allow for sorting.
	 * <P>
	 * The natural ordering for news stories is topic.
	 * </P>
	 * 
	 * @author Dean Hougen
	 */
	@Override
	public int compareTo(NewsStory newsStory) {
		return this.topic.compareTo(newsStory.topic);
	}
	
	/**
	 * @author Alex Kloppenburg
	 * @author Nathan Fritz
	 */
	public String toString(){
		ArrayList<NewsMedia> newsMedia = new ArrayList<NewsMedia>();
		newsMedia.add(NewsMedia.NEWSPAPER);
		newsMedia.add(NewsMedia.TV);
		newsMedia.add(NewsMedia.ONLINE);
		if (this instanceof NewspaperStory) {
			return "Newspaper Story: " + UserInterface.convertToOutputFormat(this, newsMedia) + "; " + this.getNewsMaker1() + "; " + this.getNewsMaker2();
		}
		
		else if (this instanceof TVNewsStory) {
			return "TV News Story: " + UserInterface.convertToOutputFormat(this, newsMedia) + "; " + this.getNewsMaker1() + "; " + this.getNewsMaker2();
		}
		
		else if (this instanceof OnlineNewsStory) {
			return "Online News Story: " + UserInterface.convertToOutputFormat(this, newsMedia) + "; " + this.getNewsMaker1() + "; " + this.getNewsMaker2();
		}
		
		else {
			return "Error in toString() of NewsStory";
		}
	}
}
