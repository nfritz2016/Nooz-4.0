
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Serves as the model for data in a NewsMakerList.
 * 
 * @author Nathan Fritz, Joe Pauly, Cavan Gary
 *
 */
public class NewsMakerListModel extends NewsMakerList{
		
		/**
		 * List of all the Action Listeners.
		 */
		private ArrayList<ActionListener> ActionListenerList;
		
		/**
		 * Default constructor
		 */
		public NewsMakerListModel() {
			
		}
		
		/**
		 * Tells us if the NewsMaker was added to the list.
		 * @param newsMaker The NewsMaker we want to add to the list.
		 * @return Returns true if the newsmaker was added and false otherwise.
		 */
		@Override
		public boolean addNewsMaker(NewsMaker newsMaker) {
			
		}
		
		/**
		 * Tells us if a NewsMaker was edited.
		 * @param newsMaker The NewsMaker we want to edit.
		 * @return Returns true if the newsmaker was edited and false otherwise.
		 */
		@Override
		public boolean editNewsMaker(NewsMaker newsMaker) {
			
		}
		
		/**
		 * Tells us if the NewsMaker was deleted.
		 * @param newsMaker The NewsMaker we are trying to delete.
		 * @return Returns true if the newsmaker was deleted and false otherwise.
		 */
		@Override
		public boolean deleteNewsMaker(NewsMaker newsMaker) {
			
		}

		/**
		 * Tells us if the newsmaker lit was deleted.
		 * @param newsMaker The newsmakerlist we want to delete.
		 * @return Returns true if the list was deleted and false otherwise.
		 */
	        @Override
		public boolean deleteNewsMakerList(NewsMakerList newsMakerList) {
			
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
