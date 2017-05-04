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
 *
 */
public class NewsDataBaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
	
	private Map<String, String> newsSourceMap = new HashMap<String, String>();
	private Map<String, String> newsTopicMap = new HashMap<String, String>();
	private Map<String, String> newsSubjectMap = new HashMap<String, String>();
	
	NewsMakerModel none = new NewsMakerModel();
	
	private NewsMakerListModel newsMakerListModel = new NewsMakerListModel();
	private NewsStoryListModel newsStoryListModel = new NewsStoryListModel();
	
	
	public NewsDataBaseModel() {
		this.addNewsMakerModel(this.none);
	}
	
	public NewsDataBaseModel(NewsMakerListModel newsMakerListModel, NewsStoryListModel newsStoryListModel) {
		this.newsMakerListModel = newsMakerListModel;
		this.newsStoryListModel = newsStoryListModel;
		
	}
	
	public Map<String, String> getNewsSourceMap() {
		return this.newsSourceMap;
	}
	
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
	
	public void setNewsSourceMap(Map<String, String> newsSourceMap) {
		this.newsSourceMap = newsSourceMap;
	}
	
	public Map<String, String> getNewsTopicMap() {
		return this.newsTopicMap;
	}
	
	public String[] getNewsTopics() {
		String[] topics = new String[this.newsTopicMap.size()];
		int i = 0;
		for (String topic : this.newsTopicMap.values()) {
			topics[i] = topic;
			i++;
		}
		return topics;
	}
	
	public void setNewsTopicMap(Map<String, String> newsTopicMap) {
		this.newsTopicMap = newsTopicMap;
	}
	
	public Map<String, String> getNewsSubjectMap() {
		return this.newsSubjectMap;
	}
	
	public String[] getNewsSubjects() {
		String[] subjects = new String[this.newsSubjectMap.size()];
		int i = 0;
		for (String subject : this.newsSubjectMap.values()) {
			subjects[i] = subject;
			i++;
		}
		return subjects;
	}
	
	public void setNewsSubjectMap(Map<String, String> newsSubjectMap) {
		this.newsSubjectMap = newsSubjectMap;
	}
	
	public boolean newsMakerListIsEmpty() {
		return this.newsMakerListModel.isEmpty();
	}
	
	public boolean containsNewsMakerModel(NewsMakerModel newsMakerModel) {
		return this.newsMakerListModel.contains(newsMakerModel);
	}
	
	public NewsMakerListModel getNewsMakerListModel() {
		return this.newsMakerListModel;
	}
	
	public String[] getNewsMakerNames() {
		return this.newsMakerListModel.getNewsMakerNames();
	}
	
	public DefaultListModel<NewsMakerModel> getNewsMakers() {
		return this.newsMakerListModel.getNewsMakers();
	}
	
	public void setNewsMakerListModel(NewsMakerListModel newsMakerListModel) {
		this.newsMakerListModel = newsMakerListModel;
	}
	
	public void addNewsMakerModel(NewsMakerModel newsMakerModel) {
		this.newsMakerListModel.add(newsMakerModel);
	}
	
	public void replaceNewsMakerModel(NewsMakerModel newsMakerModel) {
		this.newsMakerListModel.replace(newsMakerModel);
	}
	
	public void removeNewsMakers(DefaultListModel<NewsMakerModel> newsMakers) {
		this.newsMakerListModel.removeListOfNewsMakers(newsMakers);
	}
	
	public void removeAllNewsMakers() {
		for(int i = 0; i < this.newsStoryListModel.size(); ++i){
			for(int j = 0; j < this.newsMakerListModel.get(i).getNewsStoryListModel().size(); ++j){
				this.newsMakerListModel.get(i).getNewsStoryListModel().get(j).setNewsMaker1(none);
				this.newsMakerListModel.get(i).getNewsStoryListModel().get(j).setNewsMaker2(none);
			}
		}
		this.newsMakerListModel.removeAllNewsMakers();
		this.newsMakerListModel.add(none);
	}
	
	public void sortNewsMakerListModel() {
		this.newsMakerListModel.sort();
	}
	
	public boolean newsStoryListIsEmpty() {
		return this.newsStoryListModel.isEmpty();
	}
	
	public boolean containsNewsStory(NewsStory newsStory) {
		return this.newsStoryListModel.contains(newsStory);
	}
	
	public NewsStoryListModel getNewsStoryListModel() {
		return this.newsStoryListModel;
	}
	
	public DefaultListModel<NewsStory> getNewsStories() {
		return this.newsStoryListModel.getNewsStories();
	}
	
	public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel) {
		this.newsStoryListModel = newsStoryListModel;
	}
	
	public void setNewsStoryListModelFromArray(NewsStory[] newsStoryArray) {
		this.newsStoryListModel.setNewsStoriesFromArray(newsStoryArray);
	}
	
	public void addNewsStory(NewsStory newsStory) {
		this.newsStoryListModel.add(newsStory);
	}
	
	public void removeNewsStories(DefaultListModel<NewsStory> newsStories) {
		this.newsStoryListModel.removeListOfNewsStories(newsStories);
	}
	
	public void removeAllNewsStories() {
		//I think this should work, I might just be clearing a copy but I'm pretty sure I'm not
		this.newsStoryListModel.getNewsStories().clear();
	}
	
	public void addActionListener(ActionListener l) {
		if (actionListenerList == null) {
			actionListenerList = new ArrayList<ActionListener>();
		}
		actionListenerList.add(l);
	}
	
	public void removeActionListener(ActionListener l) {
		if (actionListenerList != null && actionListenerList.contains(l)) {
			actionListenerList.remove(l);
		}
	}
	
	private void processEvent(ActionEvent e) {
		ArrayList<ActionListener> list;
		synchronized (this) {
			if (actionListenerList == null)
				return;
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}
		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}
}
