
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Serves as the model for data in a NewsStoryList.
 * 
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 *
 */
public class NewsStoryListModel extends NewsStoryList{
		
		/**
		 * List of all the Action Listeners.
		 */
		private ArrayList<ActionListener> ActionListenerList;
		
		/**
		 * Default constructor
		 */
		public NewsStoryListModel() {
			
		}
		
		/**
		 * Tells us if the NewsStory was added to the list.
		 * @param newsStory The NewsStory we want to add to the list.
		 * @return Returns true if the newsstory was added and false otherwise.
		 */
		@Override
		public boolean addNewsStory(NewsStory newsStory) {
			
		}
		
		/**
		 * Tells us if a NewsStory was edited.
		 * @param newsStory The newsstory we want to edit.
		 * @return Returns true if the newsstory was edited and false otherwise.
		 */
		@Override
		public boolean editNewsStory(NewsStory newsStory) {
			
		}
		
		/**
		 * Tells us if the NewsStory was deleted.
		 * @param newsStory The NewsStory we are trying to delete.
		 * @return Returns true if the newsstory was deleted and false otherwise.
		 */
		@Override
		public boolean deleteNewsStory(NewsStory newsStory) {
			
		}

		/**
		 * Tells us if the newsstory lit was deleted.
		 * @param newsMaker The newsStorylist we want to delete.
		 * @return Returns true if the list was deleted and false otherwise.
		 */
	        @Override
		public boolean deleteNewsStoryList(NewsStoryList newsStoryList) {
			
		}
		
		/**
		 * Adds an Actionlistener to the list.
		 * @param l the actionlistener to add to the list.
		 */
		public synchronized void addActionListener(ActionListener l) {
			
		}
		
		/**
		 * Removes an actionlistener form the list.
		 * @param l The actionlistener we want to remove.
		 */
		public synchronized void removeActionListener(ActionListener l) {
			
		}
		
		/**
		 * Processes an event that has occured.
		 * @param e Name of the actionevent.
		 */
		private void processEvent(ActionEvent e) {
			
		}
	}
