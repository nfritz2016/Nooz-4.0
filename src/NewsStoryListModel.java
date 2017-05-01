import java.io.Serializable;

import javax.swing.DefaultListModel;

/**
 * @author Nathan Fritz
 *
 */
public class NewsStoryListModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private DefaultListModel<NewsStory> newsStories = new DefaultListModel<NewsStory>();
	
	public NewsStoryListModel() {
		
	}
	
	public NewsStoryListModel(NewsStoryListModel newsStoryListModel) {
		this.newsStories.clear();
		for (int i = 0; i < newsStoryListModel.size(); i++) {
			this.newsStories.addElement(newsStoryListModel.get(i));
		}
	}
	
	public boolean isEmpty() {
		return newsStories.isEmpty();
	}
	
	public int size() {
		return newsStories.getSize();
	}
	
	public boolean contains(NewsStory newsStory) {
		return this.newsStories.contains(newsStory);
	}
	
	public NewsStory get(int index) {
		return this.newsStories.getElementAt(index);
	}
	
	public DefaultListModel<NewsStory> getNewsStories() {
		return this.newsStories;
	}
	
	public void add(NewsStory newsStory) {
		this.newsStories.addElement(newsStory);
	}
	
	public void remove(NewsStory newsStory) {
		this.newsStories.remove(this.newsStories.indexOf(newsStory));
	}
	
	public void removeListOfNewsStories(DefaultListModel<NewsStory> newsStories) {
		for (int i = 0; i < newsStories.getSize(); i++) {
			this.newsStories.remove(this.newsStories.indexOf(newsStories.get(i)));
		}
	}
	
	public void setNewsStories(NewsStoryListModel newsStoryListModel) {
		this.newsStories.clear();
		for (int i = 0; i < newsStoryListModel.size(); i++) {
			this.newsStories.addElement(newsStoryListModel.get(i));
		}
	}
	
	public void setNewsStoriesFromArray(NewsStory[] newsStoryArray) {
		this.newsStories.clear();
		for (NewsStory story : newsStoryArray) {
			this.newsStories.addElement(story);
		}
	}
}
