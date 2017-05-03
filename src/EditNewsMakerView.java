import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author Nathan Fritz
 *
 */
public class EditNewsMakerView extends JPanel implements ActionListener, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private NewsDataBaseModel newsDataBaseModel = new NewsDataBaseModel();
	
	private DefaultListModel<String> newsStoryStringList = new DefaultListModel<String>();
	
	private JList<NewsStory> jlNewsStoryList = new JList<NewsStory>();
	private JScrollPane jspNewsStoryList = new JScrollPane(jlNewsStoryList);
	private JPanel jpNewsStoryList = new JPanel();
	
	//
	JTextField jtfName = new JTextField();
	private JLabel jlbName = new JLabel("Name: ");
	private JPanel jplName = new JPanel();
	
	//A button to remove them
	JButton jbtRemoveFromStory = new JButton("Remove From Story");
	
	
	
	public EditNewsMakerView(NewsMakerModel newsMakerModel, NewsDataBaseModel newsDataBaseModel) {
		this.newsDataBaseModel = newsDataBaseModel;
		jplName.add(jlbName);
		jplName.add(jtfName);
		jpNewsStoryList.add(jspNewsStoryList);
		setLayout(new BorderLayout(1, 2));
		add(jplName);
		add(jpNewsStoryList);
		jbtRemoveFromStory.setActionCommand("Remove From Story");
		enableRemovalButton();
	}
	
	public int[] getSelectedNewsStoryIndices() {
		return jlNewsStoryList.getSelectedIndices();
	}
	
	/*private void populateNewsStoryJList() {
		DefaultListModel<NewsStory> duplicate = newsDataBaseModel.getNewsStories();
		if (duplicate.isEmpty()) {
			newsStoryStringList.clear();
		}
		
		for (int i = 0; i < duplicate.getSize(); i++) {
			newsStoryStringList.addElement(duplicate.get(i).toString());
		}
	}*/
	
	private void enableRemovalButton(){
		if(getSelectedNewsStoryIndices() == null){
			jbtRemoveFromStory.setEnabled(false);
		}
		else{
			jbtRemoveFromStory.setEnabled(true);
		}
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getActionCommand().equals("Remove From Story")) {
			//If none are selected, add the whole list of news stories to the jlist
			if (getSelectedNewsStoryIndices().length > 0) {
				int[] selectedList = getSelectedNewsStoryIndices();
				for (int i = 0; i < getSelectedNewsStoryIndices().length; i++) {
					//something
				}
				
			}
		}
	}
}
