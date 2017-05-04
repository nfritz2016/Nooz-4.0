import java.io.Serializable;

import javax.swing.DefaultListModel;

/**
 * @author Nathan Fritz
 *
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
	 * 
	 * @param newsStoryListModel
	 */
	public NewsStoryListModel(NewsStoryListModel newsStoryListModel) {
		this.newsStories.clear();
		for (int i = 0; i < newsStoryListModel.size(); i++) {
			this.newsStories.addElement(newsStoryListModel.get(i));
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return newsStories.isEmpty();
	}
	
	/**
	 * 
	 * @return
	 */
	public int size() {
		return newsStories.getSize();
	}
	
	/**
	 * 
	 * @param newsStory
	 * @return
	 */
	public boolean contains(NewsStory newsStory) {
		return this.newsStories.contains(newsStory);
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public NewsStory get(int index) {
		return this.newsStories.getElementAt(index);
	}
	
	/**
	 * 
	 * @return
	 */
	public DefaultListModel<NewsStory> getNewsStories() {
		return this.newsStories;
	}
	
	/**
	 * 
	 * @param newsStory
	 */
	public void add(NewsStory newsStory) {
		this.newsStories.addElement(newsStory);
	}
	
	/**
	 * 
	 * @param newsStory
	 */
	public void remove(NewsStory newsStory) {
		this.newsStories.remove(this.newsStories.indexOf(newsStory));
	}
	
	/**
	 * 
	 * @param newsStories
	 */
	public void removeListOfNewsStories(DefaultListModel<NewsStory> newsStories) {
		for (int i = 0; i < newsStories.getSize(); i++) {
			this.newsStories.remove(this.newsStories.indexOf(newsStories.get(i)));
		}
	}
	
	/**
	 * 
	 * @param newsStoryListModel
	 */
	public void setNewsStories(NewsStoryListModel newsStoryListModel) {
		this.newsStories.clear();
		for (int i = 0; i < newsStoryListModel.size(); i++) {
			this.newsStories.addElement(newsStoryListModel.get(i));
		}
	}
	
	/**
	 * 
	 * @param newsStoryArray
	 */
	public void setNewsStoriesFromArray(NewsStory[] newsStoryArray) {
		this.newsStories.clear();
		for (NewsStory story : newsStoryArray) {
			this.newsStories.addElement(story);
		}
	}
}
