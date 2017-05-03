import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Nathan Fritz
 *
 */
public class NewsMakerModel implements ActionListener, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
	
	private String name;
	
	private NewsStoryListModel newsStoryListModel = new NewsStoryListModel();
	
	public NewsMakerModel() {
		//empty constructor
	}
	
	public NewsMakerModel(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public NewsStoryListModel getNewsStoryListModel() {
		return this.newsStoryListModel;
	}
	
	public void addNewsStory(NewsStory newsStory) {
		this.newsStoryListModel.add(newsStory);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel) {
		this.newsStoryListModel = newsStoryListModel;
	}
	
	public void removeNewsStory(NewsStory newsStory) {
		this.newsStoryListModel.remove(newsStory);
	}
	
	public boolean equals(Object o) {
		if (o instanceof NewsMakerModel) {
			NewsMakerModel newsMakerModel = (NewsMakerModel) o;
			if (newsMakerModel.getName().equals(this.name)) {
				return true;
			}
		}
		return false;
	}
	
	public int compareTo(NewsMakerModel newsMakerModel) {
		return this.compareTo(newsMakerModel);
		//TODO not entirely sure
	}
	
	public String toString() {
		return name;
		//TODO not entirely sure b/c no javadoc
	}
	
	public void addActionListener(ActionListener actionListener) {
		this.actionListenerList.add(actionListener);
	}
	
	public void removeActionListener(ActionListener actionListener) {
		this.actionListenerList.remove(actionListener);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO idk what to do here
	}
}
