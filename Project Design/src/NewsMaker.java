import java.io.Serializable;

public class NewsMaker implements Comparable<NewsMaker>, Serializable {
	/**The Serial UID*/
	private static final long serialVersionUID = 1L;

	/** The name of the news maker.*/
	private String name;

	/** The list of news stories in which the news maker is featured.*/
	private NewsStoryList newsStories;

	/**
	 * The no-argument constructor for the class. This gives the news maker
	 * the special name of "None".
	 */
	public NewsMaker() {
	}

	/**
	 * The general constructor for the class which takes the name of the news
	 * maker.
	 * 
	 * @param name
	 *            The name of the news maker.
	 */
	public NewsMaker(String name) {
	}

	/**
	 * The accessor for the name field.
	 * 
	 * @return The name of the news maker.
	 */
	public String getName() {
		return null; //TODO revert return
	}

	/**
	 * The accessor for the list of news stories.
	 * 
	 * @return The list of stories featuring the news maker.
	 */
	public NewsStoryList getNewsStories() {
		return null; //TODO revert return
	}

	/**
	 * The mutator that adds a news story to a news maker's list of stories.
	 * 
	 * @param newsStory
	 *            The news story to add.
	 */
	public void addNewsStory(NewsStory newsStory) {
	}

	/**
	 * An overridden equals method. A NewsMaker is equal to another NewsMaker
	 * object is the names are equal.
	 * 
	 * @param o
	 *            The Object to which to compare this.
	 */
	@Override
	public boolean equals(Object o) {
		return false; //TODO revert return
	}

	/**
	 * The overridden compareTo method for news makers.
	 * The method compares news maker names.
	 * 
	 * @param newsMaker
	 *            The other news maker to which to this should be compared.
	 */
	@Override
	public int compareTo(NewsMaker newsMaker) {
		return 0; //TODO revert return
	}

}
