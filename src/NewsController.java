import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class NewsController {

	private NewsDataBaseModel newsDataBaseModel;
	
	private SelectionView selectionView;
	
	private EditNewsMakerView editNewsMakerView;
	
	private JDialog viewDialog;
	
	private AddEditNewsStoryView addEditNewsStoryView;
	
	private NewsStory editedNewsStory;
	
	private MediaTypeSelectionView mediaTypeSelectionView;
	
	private List<NewsMedia> selectedMediaTypes = new ArrayList<NewsMedia>();
	
	//push test2
	public NewsController() {
		//empty constructor
	}
	
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel) {
		this.newsDataBaseModel = newsDataBaseModel;
	}
	
	public void setSelectionView(SelectionView selectionView) {
		this.selectionView = selectionView;
	}
	
	private void loadNewsData() throws IOException {
		JFileChooser fc = new JFileChooser(".");
		int returnValue = fc.showOpenDialog(selectionView);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String fileName = null;
			try {
				fileName = fc.getSelectedFile().getCanonicalPath();
				FileInputStream fileInputStream = new FileInputStream(fileName);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				newsDataBaseModel.none = (NewsMakerModel) objectInputStream.readObject();
				newsDataBaseModel.setNewsMakerListModel((NewsMakerListModel) objectInputStream.readObject());
				
				//NOT SURE AFTER THIS POINT
				newsDataBaseModel.setNewsStoryListModel((NewsStoryListModel) objectInputStream.readObject());
				newsDataBaseModel.setNewsSourceMap((Map<String, String>) objectInputStream.readObject());
				newsDataBaseModel.setNewsTopicMap((Map<String, String>) objectInputStream.readObject());
				newsDataBaseModel.setNewsSubjectMap((Map<String, String>) objectInputStream.readObject());
			} 
			//WHY DO WE NEED TRY/CATCH?
			// either class not found | invalid class exception | Stream corrupted exception
			catch (ClassNotFoundException cnf) {
				System.err.println("Class not found exception: " + cnf.getMessage());
			}
		}	
	}
	
	//TODO write
	private void saveNewsData() {
		
	}
	
	//TODO write
	private void importNoozStories() {
		
	}
	
	//TODO write
	private void exportNewsStories() {
		
	}
	
	//TODO write
	private void addNewsMaker() {
		
	}
	
	//TODO write
	private void editNewsMakers() {
		
	}
	
	//TODO write
	private void deleteNewsMakers() {
		newsDataBaseModel.removeAllNewsMakers();
	}
	
	//TODO write
	private void deleteNewsMakerList() {
		//calls on method in NewsMakerListModel
		//SHOULDN'T THIS BE removeListOfNewsMakers ?? but then what are the arguments
		//Get args from the view or model
		newsDataBaseModel.removeNewsMakers(newsDataBaseModel.getNewsMakers());
	}
	
	//TODO write
	private void addNewsStory() {
		//calls or uses JDialog
		NewsMakerModel.addNewsStory();
	}
	
	//TODO write
	private void editNewsStories() {
		
	}
	
	//TODO write
	private void sortNewsStories() {
		
	}
	
	//TODO write
	private void deleteNewsStories() {
		
	}
	
	//TODO write
	private void deleteAllNewsStories() {
		NewsStoryListModel.removeListOfNewsStories(NewsStoryListModel.getNewsStories());
	}
	
	/**
     * This method is called to display pie charts when requested by the user.
     * It gets the list of all selected news makers from the
     * <code>SectionView</code> and displays one pie chart per news maker. For
     * each pie chart it needs to determine the media type(s) to display, the
     * news content type to display, and the news metric to use for display.
     */
    private void displayPieCharts() {
        // Get the indices of the news makers selected in the selection view.
        int[] indices = selectionView.getSelectedNewsMakers();

        // If there are no selected news makers, alert the user and return.
        if (0 == indices.length) {
            JOptionPane.showMessageDialog(selectionView, "No newsmaker selected.", "Invalid Selection",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            // If there are selected news makers, go through the process for each.
            NewsMakerListModel newsMakerListModel = this.newsDataBaseModel.getNewsMakerListModel();
            for (int index : indices) {
                NewsMakerModel newsMakerModel = newsMakerListModel.get(index);
                String newsMakerName = newsMakerModel.getName();

                // Get media types using MediaTypeSelectionView.
                this.selectedMediaTypes = null;
                this.mediaTypeSelectionView = new MediaTypeSelectionView();
                MediaTypeSelectionListener mediaTypeSelectionListener = new MediaTypeSelectionListener();
                this.mediaTypeSelectionView.jbOkay.addActionListener(mediaTypeSelectionListener);
                this.mediaTypeSelectionView.jbCancel.addActionListener(mediaTypeSelectionListener);

                this.viewDialog = new JDialog(selectionView, newsMakerName, true);
                this.viewDialog.add(mediaTypeSelectionView);
                this.viewDialog.setResizable(false);
                this.viewDialog.pack();
                this.viewDialog.setVisible(true);

                // If no media types were selected, go on to next news maker.
                if (null == this.selectedMediaTypes) {
                    continue;
                }

                // Get content type using JOptionPane.
                NewsContent selectedNewsContent = null;
                selectedNewsContent = (NewsContent) JOptionPane.showInputDialog(selectionView,
                        "Graph news stories based on which content?", newsMakerName, JOptionPane.PLAIN_MESSAGE, null,
                        NewsContent.values(), NewsContent.TOPIC);
                if (null == selectedNewsContent) {
                    continue;
                }

                // Get metric type using JOPtionPane.
                NewsMetric selectedNewsMetric = null;
                selectedNewsMetric = (NewsMetric) JOptionPane.showInputDialog(selectionView,
                        "Graph news stories based on which metric?", newsMakerName, JOptionPane.PLAIN_MESSAGE, null,
                        NewsMetric.values(), NewsMetric.LENGTH);
                if (null == selectedNewsMetric) {
                    continue;
                }

                // Create the pie chart.
                PieChartView pieChartView = new PieChartView(newsMakerModel, selectedMediaTypes, selectedNewsContent,
                        selectedNewsMetric);

                //Make sure the pie chart listens for model changes so that it can update itself.
                newsMakerModel.addActionListener(pieChartView);
            }
        }
    }
	
	
	private void displayTextViews() {
		
		// Get the indices of the news makers selected in the selection view.
        int[] indices = selectionView.getSelectedNewsMakers();

        // If there are no selected news makers, alert the user and return.
        if (0 == indices.length) {
            JOptionPane.showMessageDialog(selectionView, "No newsmaker selected.", "Invalid Selection",
                    JOptionPane.WARNING_MESSAGE);
        } 
        else {
            // If there are selected news makers, go through the process for each.
            NewsMakerListModel newsMakerListModel = this.newsDataBaseModel.getNewsMakerListModel();
            for (int index : indices) {
                NewsMakerModel newsMakerModel = newsMakerListModel.get(index);
                String newsMakerName = newsMakerModel.getName();

                // Get media types using MediaTypeSelectionView.
                this.selectedMediaTypes = null;
                this.mediaTypeSelectionView = new MediaTypeSelectionView();
                MediaTypeSelectionListener mediaTypeSelectionListener = new MediaTypeSelectionListener();
                this.mediaTypeSelectionView.jbOkay.addActionListener(mediaTypeSelectionListener);
                this.mediaTypeSelectionView.jbCancel.addActionListener(mediaTypeSelectionListener);

                this.viewDialog = new JDialog(selectionView, newsMakerName, true);
                this.viewDialog.add(mediaTypeSelectionView);
                this.viewDialog.setResizable(false);
                this.viewDialog.pack();
                this.viewDialog.setVisible(true);

                // If no media types were selected, go on to next news maker.
                if (null == this.selectedMediaTypes) {
                    continue;
                }

                // Get sort criteria using JOptionPane.
                List<SortCriterion> selectedSortCriteria = null;
                selectedSortCriteria = (List<SortCriterion>) JOptionPane.showInputDialog(selectionView,
                        "Sort news stories based on which criteria?", newsMakerName, JOptionPane.PLAIN_MESSAGE, null,
                        SortCriterion.values(), NewsContent.TOPIC);
                if (null == selectedSortCriteria) {
                    continue;
                }

                // Create the text view.
                TextView textView = new TextView(newsMakerModel, selectedMediaTypes, selectedSortCriteria);

                //Make sure the pie chart listens for model changes so that it can update itself.
                newsMakerModel.addActionListener(textView);
            }
        }
		
	}
	
	
	//LISTENERS
	//TODO write listeners
	
	private class FileMenuListener implements ActionListener {
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if ("Load".equals(actionEvent.getActionCommand())) {
				loadNewsData();
			}
			if ("Save".equals(actionEvent.getActionCommand())) {
				saveNewsData();
			}
			if ("Import".equals(actionEvent.getActionCommand())) {
				importNoozStories();
			}
			if ("Export".equals(actionEvent.getActionCommand())) {
				exportNewsStories();
			}
		}

	}
	
	private class NewsMakerMenuListener implements ActionListener {
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			
		}
	}
	
	private class NewsStoryMenuListener implements ActionListener {
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if ("Add News Story".equals(actionEvent.getActionCommand())) {
				addNewsStory();
			}
			if ("Edit News Story".equals(actionEvent.getActionCommand())) {
				editNewsStories();
			}
			if ("Sort News Stories".equals(actionEvent.getActionCommand())) {
				sortNewsStories();
			}
			if ("Delete News Story".equals(actionEvent.getActionCommand())) {
				deleteNewsStories();
			}
			if ("Delete All News Stories".equals(actionEvent.getActionCommand())) {
				deleteAllNewsStories();
			}
		}
	}
	
	private class DisplayMenuListener implements ActionListener {
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if ("Pie Chart".equals(actionEvent.getActionCommand())) {
				displayPieCharts();
			}
			if ("Text".equals(actionEvent.getActionCommand())) {
				displayTextViews();
			}
		}
	}
	
	private class EditNewsMakerNameListener implements ActionListener {
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {	
			//before we do this we need to add an if statement for the listener
			if ("something".equals(actionEvent.getActionCommand())) {
				
				//if News maker name doesn't exist in list, set news maker's name and resort list of news makers in database
				if(!NewsMakerListModel.getNewsMakerNames().contains()) {
					 NewsMakerModel.setName(/*WHERE IN THE VIEW IS THE NEW NAME???*/);
				}
				/*
				 * if name exists, confirm replacing existing news maker with name whose name has just been change
				 * by using JOptionPane
				 * Replace or don't depending on confirmation
				 */
				
			}
		}
	}
	
	private class RemoveNewsMakerFromNewStoriesListener implements ActionListener {
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			
			if("Remove From Story".equals(actionEvent.getActionCommand())){
				//I think???
				//EditNewsMakerView.getSelectedNewsStoryIndices();
			}
			
		}
	}
	
	//written by alex 5/2
	private class AddEditNewsStoryListener implements ActionListener {
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			
			if ("Add News Story".equals(actionEvent.getActionCommand())) {
				addNewsStory();
			}
			if ("Edit News Story".equals(actionEvent.getActionCommand())) {
				editNewsStories();
			}
			
		}
	}
	
    /**
     * <code>MediaTypeSelectionListener</code> is an inner class (within
     * <code>NewsController</code>) to listen for actions from a
     * <code>MediaTypeSelectionView</code>. It has one method that does all the
     * work -- the overridden <code>actionPerformed</code> method -- which is
     * called when there is a relevant <code>actionEvent</code>.
     * 
     * @author Dean Hougen
     * @version 1.0
     *
     */
    public class MediaTypeSelectionListener implements ActionListener {

        /**
         * The overridden <code>actionPerformed</code> method that does all of
         * the work. If the user indicates their selections are "OK" (the
         * <code>actionCommand</code> is "OK"), it queries each
         * <code>JCheckBox</code> of the <code>MediaTypeSelectionView</code> to
         * see if it was selected. If so, it adds the corresponding
         * <code>NewsMedia</code> type to the <code>selectedMediaTypes</code>
         * list. If no check boxes were selected, it warns the user of this
         * fact. Once it has extracted the relevant information from the
         * <code>MediaTypeSelectionView</code>, it disposes of that view, which
         * closes the modal window and allows the user to interact with other
         * windows in <code>Nooz</code>.
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            selectedMediaTypes = new LinkedList<NewsMedia>();
            if ("OK".equals(actionEvent.getActionCommand())) {
                if (mediaTypeSelectionView.jcbNewspaper.isSelected()) {
                    selectedMediaTypes.add(NewsMedia.NEWSPAPER);
                }
                if (mediaTypeSelectionView.jcbTVNews.isSelected()) {
                    selectedMediaTypes.add(NewsMedia.TV);
                }
                if (mediaTypeSelectionView.jcbOnline.isSelected()) {
                    selectedMediaTypes.add(NewsMedia.ONLINE);
                }
                if (null == selectedMediaTypes) {
                    JOptionPane.showMessageDialog(selectionView, "No media type selected.", "Invalid Selection",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            viewDialog.dispose();
        }
    }
}
