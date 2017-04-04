import java.awt.event.ActionEvent;

import javax.swing.JList;

/**
 * Each object in this class represents a display window containing
 * GUI elements. These elements will relay information to the user 
 * and allow a clear visual representation of the data they request.
 * 
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 *
 */
public class SelectionViewWindow {
	
	/** Lists that display NewsMakers **/
	private JList<NewsMaker> displayNewsMakerInfo;
	
	/** Lists that display News stories **/
	private JList<NewsStory> displayNewsStoryInto;
	
	/** Model representation of the news stories **/
	private NewsStoryListModel storyModel;
	
	/** Model representation of the news makers **/
	private NewsMakerListModel newsMakerModel;
	
	/**
	 * Constructor to create the Selection View Window
	 */
	public SelectionViewWindow() {
	
	}
	
	/**
	 * The method to respond when an event happens. Other 
	 * similar methods will override this in order to accomplish
	 * their specific task request by the user.
	 * @param e
	 * 		The action event that the listener pick up.
	 */
	public void actionPerformed(ActionEvent e) {
	
	}
	
	/**
	 * A mutator method that sets the specific model for the
	 * view.
	 * Note: This parameter inside of set model is specifically for 
	 * a the NewsStoryList model.
	 * @param model
	 * 		The model that has the data to show to the user.
	 */
	public void setModel(NewsStoryListModel model) {
	
	}
	
	/**
	 * A mutator method that sets the specific model for the
	 * view.
	 * Note: This parameter inside of set model is specifically for 
	 * a the NewsMakerList model.
	 * @param model
	 * 		The model that has the data to show to the user.
	 */
	public void setModel(NewsMakerListModel model) {
	
	}
	

}
