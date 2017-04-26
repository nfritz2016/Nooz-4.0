import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class EditNewsMakerView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NewsMakerModel newsMakerModel;
	private NewsDataBaseModel newsDataBaseModel;
	private DefaultListModel<String> newsStoryStringList;
	private JList<String> jlNewsStoryList;
	private JScrollPane jspNewsStoryList;
	private JPanel jpNewsStoryList;
	private JTextField jftName;
	private JLabel jlbName;
	private JButton jbtRemoveFromStory;
	private JPanel jplName;
	
	//TODO write constructor
	public EditNewsMakerView(NewsMakerModel newsMakerModel, NewsDataBaseModel newsDataBaseModel) {
		
	}
	
	//TODO write method
	public int[] getSelectedNewsStoryIndices() {
		
	}
	
	//TODO write method
	private void populateNewsStroyIndices() {
		
	}
	
	//TODO write method
	public void actionPerformed(ActionEvent actionEvent) {
		
	}
	
}
