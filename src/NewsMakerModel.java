import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Nathan Fritz - 113294199
 */
public class NewsMakerModel implements Serializable, Comparable<NewsMakerModel> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private ArrayList<ActionListener> actionListenerList;
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private NewsStoryListModel newsStoryListModel = new NewsStoryListModel();
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 */
	public NewsMakerModel() {
		this.name = "None";
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public NewsMakerModel(String name) {
		this.name = name;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Addition of News Story"));
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public String getName() {
		return this.name;
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
	public void addNewsStory(NewsStory newsStory) {
		if (!this.newsStoryListModel.contains(newsStory)) {
			this.newsStoryListModel.add(newsStory);
			}
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel) {
		this.newsStoryListModel = newsStoryListModel;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public void removeNewsStory(NewsStory newsStory) {
		if (this.newsStoryListModel.contains(newsStory)) {
			this.newsStoryListModel.remove(newsStory);
		}
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Remove News Story"));
	}
	
	/**
	 * @author Dean Hougen
	 */
	public boolean equals(Object o) {
		if (o instanceof NewsMakerModel) {
			NewsMakerModel newsMakerModel = (NewsMakerModel) o;
			if (newsMakerModel.getName().equals(this.name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @author Nathan Fritz
	 */
	@Override
	public int compareTo(NewsMakerModel newsMakerModel) {
		return this.getName().compareTo(newsMakerModel.getName());
		//TODO not entirely sure
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public String toString() {
		return name;
		//TODO not entirely sure b/c no javadoc
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public synchronized void addActionListener(ActionListener actionListener) {
		if (actionListenerList == null) {
			actionListenerList = new ArrayList<ActionListener>();
		}
		actionListenerList.add(actionListener);
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public synchronized void removeActionListener(ActionListener actionListener) {
		this.actionListenerList.remove(actionListener);
	}
	
	/**
	 * @author Nathan Fritz
	 */
	private void processEvent(ActionEvent e) {
		ArrayList<ActionListener> list;
		synchronized (this) {
			if (actionListenerList == null)
				return;
			// Do not worry about the cast warning here.
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}
		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}

}
