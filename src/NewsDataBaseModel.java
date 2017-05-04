import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;

/**
 * @author Nathan Fritz
 * @author Alex Kloppenburg
 */
public class NewsDataBaseModel implements ActionListener, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
	
	/**
	 * 
	 */
	private Map<String, String> newsSourceMap = new HashMap<String, String>();
	
	/**
	 * 
	 */
	private Map<String, String> newsTopicMap = new HashMap<String, String>();
	
	/**
	 * 
	 */
	private Map<String, String> newsSubjectMap = new HashMap<String, String>();
	
	/**
	 * 
	 */
	NewsMakerModel none = new NewsMakerModel("None");
	
	/**
	 * 
	 */
	private NewsMakerListModel newsMakerListModel = new NewsMakerListModel();
	
	/**
	 * 
	 */
	private NewsStoryListModel newsStoryListModel = new NewsStoryListModel();
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 */
	public NewsDataBaseModel() {

		this.addNewsMakerModel(this.none);

	}
	
	/**
	 * @author Nathan Fritz
	 */
	public NewsDataBaseModel(NewsMakerListModel newsMakerListModel, NewsStoryListModel newsStoryListModel) {
		this.newsMakerListModel = newsMakerListModel;
		this.newsStoryListModel = newsStoryListModel;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public Map<String, String> getNewsSourceMap() {
		return this.newsSourceMap;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public String[] getNewsSources() {
		
		String[] sources = new String[this.newsSourceMap.size()];
		int i = 0;
		for (String source : this.newsSourceMap.values()) {
			sources[i] = source;
			i++;
		}
		return sources;
		
		//return (String[]) this.newsSourceMap.values().toArray();
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setNewsSourceMap(Map<String, String> newsSourceMap) {
		this.newsSourceMap = newsSourceMap;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public Map<String, String> getNewsTopicMap() {
		return this.newsTopicMap;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public String[] getNewsTopics() {
		String[] topics = new String[this.newsTopicMap.size()];
		int i = 0;
		for (String topic : this.newsTopicMap.values()) {
			topics[i] = topic;
			i++;
		}
		return topics;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setNewsTopicMap(Map<String, String> newsTopicMap) {
		this.newsTopicMap = newsTopicMap;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public Map<String, String> getNewsSubjectMap() {
		return this.newsSubjectMap;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public String[] getNewsSubjects() {
		String[] subjects = new String[this.newsSubjectMap.size()];
		int i = 0;
		for (String subject : this.newsSubjectMap.values()) {
			subjects[i] = subject;
			i++;
		}
		return subjects;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setNewsSubjectMap(Map<String, String> newsSubjectMap) {
		this.newsSubjectMap = newsSubjectMap;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public boolean newsMakerListIsEmpty() {
		return this.newsMakerListModel.isEmpty();
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public boolean containsNewsMakerModel(NewsMakerModel newsMakerModel) {
		return this.newsMakerListModel.contains(newsMakerModel);
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public NewsMakerListModel getNewsMakerListModel() {
		return this.newsMakerListModel;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public String[] getNewsMakerNames() {
		return this.newsMakerListModel.getNewsMakerNames();
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public DefaultListModel<NewsMakerModel> getNewsMakers() {
		return this.newsMakerListModel.getNewsMakers();
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setNewsMakerListModel(NewsMakerListModel newsMakerListModel) {
		this.newsMakerListModel.setNewsMakersFromNewsMakerList(newsMakerListModel);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void addNewsMakerModel(NewsMakerModel newsMakerModel) {
		this.newsMakerListModel.add(newsMakerModel);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void replaceNewsMakerModel(NewsMakerModel newsMakerModel) {
		this.newsMakerListModel.replace(newsMakerModel);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void removeNewsMakers(DefaultListModel<NewsMakerModel> newsMakers) {
		this.newsMakerListModel.removeListOfNewsMakers(newsMakers);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 */
	public void removeAllNewsMakers() {
		this.newsMakerListModel.removeAllNewsMakers();
		this.newsMakerListModel.add(none);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void sortNewsMakerListModel() {
		this.newsMakerListModel.sort();
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public boolean newsStoryListIsEmpty() {
		return this.newsStoryListModel.isEmpty();
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public boolean containsNewsStory(NewsStory newsStory) {
		return this.newsStoryListModel.contains(newsStory);
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public NewsStoryListModel getNewsStoryListModel() {
		return this.newsStoryListModel;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public DefaultListModel<NewsStory> getNewsStories() {
		return this.newsStoryListModel.getNewsStories();
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel) {
		this.newsStoryListModel.setNewsStories(newsStoryListModel);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setNewsStoryListModelFromArray(NewsStory[] newsStoryArray) {
		this.newsStoryListModel.setNewsStoriesFromArray(newsStoryArray);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void addNewsStory(NewsStory newsStory) {
		this.newsStoryListModel.add(newsStory);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void removeNewsStories(DefaultListModel<NewsStory> newsStories) {
		this.newsStoryListModel.removeListOfNewsStories(newsStories);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Alex Kloppenburg
	 */
	public void removeAllNewsStories() {
		//I think this should work, I might just be clearing a copy but I'm pretty sure I'm not
		this.newsStoryListModel.getNewsStories().clear();
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Menu Items"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void addActionListener(ActionListener l) {
		if (actionListenerList == null) {
			actionListenerList = new ArrayList<ActionListener>();
		}
		actionListenerList.add(l);
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void removeActionListener(ActionListener l) {
		if (actionListenerList != null && actionListenerList.contains(l)) {
			actionListenerList.remove(l);
		}
	}
	
	/**
	 * @author Nathan Fritz
	 */
	private void processEvent(ActionEvent e) {
		ArrayList<ActionListener> list;
		System.out.println("icybucuytuinibtuuifyignyut");
		synchronized (this) {
			if (actionListenerList == null)
				return;
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}
		
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i);
			ActionListener listener = list.get(i);
			System.out.println(listener.getClass());
			listener.actionPerformed(e);
		}
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("SHold not be reached");
	}
}
