import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsStoryList implements Serializable {
	/**The Serial UID*/
	private static final long serialVersionUID = 1L;
	
	/** The list of news stories.*/
	private List<NewsStory> newsStories; //TODO initialize

	/**
	 * The mutator for adding a newspaper story to the list.
	 * 
	 * @param newsStory
	 *            The newspaper story to add.
	 */
	public void add(NewsStory newsStory) {
	}

	/**
	 * The accessor for determining the number of stories in the list.
	 * 
	 * @return The number of stories in the list.
	 */
	public int size() {
		return 0; //TODO revert return
	}

	/**
	 * An accessor for getting a story from the list based on its position
	 * (index) in the list.
	 * 
	 * @param index
	 *            The location from which to get the story.
	 * @return The newspaper story at the index, if the index is valid.
	 * @throws IllegalArgumentException
	 *            if the index is not valid.
	 */
	public NewsStory get(int index) {
		return null; //TODO revert return
	}
}
