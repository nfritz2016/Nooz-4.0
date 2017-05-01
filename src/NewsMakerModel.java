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
		//TODO
	}
	
	public void removeNewsStory(NewsStory newsStory) {
		this.newsStoryListModel.remove(newsStory);
	}
	
	public boolean equals(Object o) {
		return true;
		//TODO
	}
	
	public int compareTo(NewsMakerModel newsMakerModel) {
		return 0;
		//TODO
	}
	
	public String toString() {
		return name;
		//not sure
	}
	
	public void addActionListener(ActionListener actionListener) {
		this.actionListenerList.add(actionListener);
	}
	
	public void removeActionListener(ActionListener actionListener) {
		this.actionListenerList.remove(actionListener);
	}
	
	private void processEvent(ActionEvent e) {
		//TODO
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO
	}
}
