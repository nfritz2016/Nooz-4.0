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
	
	NewsMakerModel newsMakerModel = new NewsMakerModel();
	
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
		this.newsMakerModel = newsMakerModel;
		this.newsDataBaseModel.addNewsMakerModel(this.newsMakerModel);
		
		//needs code to fill the JList based on the model
		this.jlNewsStoryList = new JList<NewsStory>(this.newsDataBaseModel.getNewsStories());

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
		if(this.newsMakerModel.getNewsStoryListModel() == null){
			jbtRemoveFromStory.setEnabled(false);
		}
		else if(this.newsMakerModel.getNewsStoryListModel().getNewsStories().isEmpty()){
			jbtRemoveFromStory.setEnabled(false);
		}
		else{
			jbtRemoveFromStory.setEnabled(true);
		}
	}
	
	@Override
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
		if(actionEvent.getActionCommand().equals("Modified News Story List")){
			enableRemovalButton();
		}
	}
}
