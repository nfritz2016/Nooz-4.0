import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewsMakerListModel extends NewsMakerList{
	
	private ArrayList<ActionListener> ActionListenerList;
	
	public newsMkaerListModel()
	{}
	
	public void addNewsMaker(NewsMaker newsMaker)
	{}
	
	public void editNewsMaker(NewsMaker newsMaker)
	{}
	
	public void deleteNewsMaker(NewsMaker newsMaker)
	{}

	public void deleteNewsMakerList(NewsMaker newsMaker)
	{}
	
	public synchronized void addActionListener(ActionListener l)
	{}
	
	public synchronized void removeActionListener(ActionListener l)
	{}
	
	private void processEvent(ActionEvent e)
	{}
}
