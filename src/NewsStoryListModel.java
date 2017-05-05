import java.io.Serializable;

import javax.swing.DefaultListModel;

/**
 * @author Nathan Fritz - 113294199
 */
public class NewsStoryListModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private DefaultListModel<NewsStory> newsStories = new DefaultListModel<NewsStory>();
	
	/**
	 * 
	 */
	public NewsStoryListModel() {
		
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public NewsStoryListModel(NewsStoryListModel newsStoryListModel) {
		this.newsStories.clear();
		for (int i = 0; i < newsStoryListModel.size(); i++) {
			this.newsStories.addElement(newsStoryListModel.get(i));
		}
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public boolean isEmpty() {
		return newsStories.isEmpty();
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public int size() {
		return newsStories.getSize();
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public boolean contains(NewsStory newsStory) {
		return this.newsStories.contains(newsStory);
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public NewsStory get(int index) {
		return this.newsStories.getElementAt(index);
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public DefaultListModel<NewsStory> getNewsStories() {
		return this.newsStories;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void add(NewsStory newsStory) {
		this.newsStories.addElement(newsStory);
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void remove(NewsStory newsStory) {
		this.newsStories.remove(this.newsStories.indexOf(newsStory));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void removeListOfNewsStories(DefaultListModel<NewsStory> newsStories) {
		for (int i = 0; i < newsStories.getSize(); i++) {
			this.newsStories.remove(this.newsStories.indexOf(newsStories.get(i)));
		}
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setNewsStories(NewsStoryListModel newsStoryListModel) {
		this.newsStories.clear();
		for (int i = 0; i < newsStoryListModel.size(); i++) {
			this.newsStories.addElement(newsStoryListModel.get(i));
		}
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setNewsStoriesFromArray(NewsStory[] newsStoryArray) {
		this.newsStories.clear();
		for (NewsStory story : newsStoryArray) {
			this.newsStories.addElement(story);
		}
	}
}
