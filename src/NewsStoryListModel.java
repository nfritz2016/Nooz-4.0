import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

/**
 * Project 3, CS 2334, Section 010, March 8, 2017
 * <P>
 * A <code>NewsStoryList</code> is a list of <code>NewsStory</code> objects.
 * </P>
 * 
 * @author Dean Hougen and Cavan Gary
 * @version 2.0
 *
 */
class NewsStoryListModel implements Serializable {
	/**
	 * This is the first serializable version of NewsStoryList, so we select a
	 * serialVersionUID of 1L.
	 */
	private static final long serialVersionUID = 1L;

	/** The list of newspaper stories. */
	private DefaultListModel<NewsStory> newsStories;;

	NewsStoryListModel(){
		this.newsStories = new DefaultListModel<NewsStory>();
	}
	
	NewsStoryListModel(NewsStoryListModel model){
		this.newsStories = model.getNewsStories();
	}
	
	public boolean isEmpty(){
		
		return newsStories.isEmpty();
	}
	
	/**
	 * The accessor for determining the number of stories in the list.
	 * <P>
	 * Note that this accessor name violates the convention that accessor names
	 * should start with "get" (or "is" for booleans). However, "size" is an
	 * accepted convention for names serving this particular purpose, so we are
	 * following the second convention rather than the first.
	 * </P>
	 * 
	 * @return The number of stories in the list.
	 */
	public int size() {
		return this.newsStories.size();
	}
	
	public boolean contains (NewsStory newsStory){
		return this.newsStories.contains(newsStory);
	}
	
	/**
	 * An accessor for getting a story from the list based on its position
	 * (index) in the list.
	 * 
	 * @param index
	 *            The location from which to get the story.
	 * @return The newspaper story at the index, if the index is valid.
	 * @throws IllegalArgumentException
	 *             if the index is not valid.
	 */
	public NewsStory get(int index) {
		if (index >= 0 && index < this.newsStories.size()) {
			return this.newsStories.get(index);
		} else {
			throw new IllegalArgumentException("Index out of bounds: " + index);
		}
	}
	
	//TODO: check to see if returning correct object
	public DefaultListModel<NewsStory> getNewsStories(){
			return this.newsStories;
	}
	
	/**
	 * The mutator for adding a newspaper story to the list.
	 * <P>
	 * By using our own class with its own <code>add</code> method, rather than
	 * directly using the <code>add</code> method of <code>ArrayList</code>, we
	 * could ensure that we don't add duplicate <code>NewsStory</code> objects
	 * to our list. However, to keep the project relatively simple, this
	 * requirement was not made in the project description and this check
	 * doesn't need to be made yet.
	 * </P>
	 * 
	 * @param newsStory
	 *            The newspaper story to add.
	 */
	public void add(NewsStory newsStory) {
		// TODO Refine this to prevent duplicates (Eventually)
		this.newsStories.addElement(newsStory);
	}
	
	public void remove(NewsStory newsStory){
		
		boolean isRemoved = this.newsStories.removeElement(newsStory);
		
		if(!isRemoved)//tells user it was not removed
		{
			System.err.println("The news story was not removed");
		}
	}
	
	public void removeListOfNewsStories(DefaultListModel<NewsStory> newsStories){
		newsStories.removeAllElements();
		
	}
	
	public void setNewsStories(NewsStoryListModel newsStoryListModel){
		this.newsStories = newsStoryListModel.getNewsStories();
	}
	
	public void setNewsStoriesFromArray(NewsStory[] newsStoryArray){
		
		for(int index = 0; index < newsStoryArray.length; ++index)
		{
			this.newsStories.addElement(newsStoryArray[index]);
		}
	}


	
}