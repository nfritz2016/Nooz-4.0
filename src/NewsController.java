import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 * @author Nathan Fritz
 * @author Alex Kloppenburg
 * @author Joe Pauly
 * @author Cavan Gary
 */
public class NewsController {
	
	/**
	 * 
	 */
	private NewsDataBaseModel newsDataBaseModel;
	
	/**
	 * 
	 */
	private SelectionView selectionView;
	
	/**
	 * 
	 */
	private EditNewsMakerView editNewsMakerView;
	
	/**
	 * 
	 */
	private JDialog viewDialog;
	
	/**
	 * 
	 */
	private AddEditNewsStoryView addEditNewsStoryView;
	
	/**
	 * 
	 */
	private NewsStory editedNewsStory;
	
	/**
	 * 
	 */
	private MediaTypeSelectionView mediaTypeSelectionView;
	
	/**
	 * 
	 */
	private List<NewsMedia> selectedMediaTypes = new ArrayList<NewsMedia>();
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	public NewsController() {
		//empty constructor
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel) {
		this.newsDataBaseModel = newsDataBaseModel;
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	public void setSelectionView(SelectionView selectionView) {
		this.selectionView = selectionView;
		this.selectionView.registerDisplayMenuListener(new DisplayMenuListener());
		this.selectionView.registerFileMenuListener(new FileMenuListener());
		this.selectionView.registerNewsMakerMenuListener(new NewsMakerMenuListener());
		this.selectionView.registerNewsStoryMenuListener(new NewsStoryMenuListener());
		newsDataBaseModel.none.addActionListener(selectionView);
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	private void loadNewsData() {
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
				newsDataBaseModel.setNewsStoryListModel((NewsStoryListModel) objectInputStream.readObject());
				newsDataBaseModel.setNewsSourceMap((Map<String, String>) objectInputStream.readObject());
				newsDataBaseModel.setNewsTopicMap((Map<String, String>) objectInputStream.readObject());
				newsDataBaseModel.setNewsSubjectMap((Map<String, String>) objectInputStream.readObject());
				objectInputStream.close();
			} 
			catch (ClassNotFoundException cnf) {
				System.err.println("Class not found exception: " + cnf.getMessage());
			}
			catch(IOException ioe) {
				System.err.println("I/O exception: " + ioe.getMessage());
			}
		}	
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	private void saveNewsData() {
		JFileChooser fc = new JFileChooser(".");
		int returnValue = fc.showSaveDialog(selectionView);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String fileName = null;
			try {
				fileName = fc.getSelectedFile().getCanonicalPath();
				String[] file = fileName.split("\\\\");
				String fileSelected = file[file.length - 1];
				FileOutputStream fileOutputStream = new FileOutputStream(fileSelected);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(newsDataBaseModel.none);
				objectOutputStream.writeObject(newsDataBaseModel.getNewsMakerListModel());
				objectOutputStream.writeObject(newsDataBaseModel.getNewsStoryListModel());
				objectOutputStream.writeObject(newsDataBaseModel.getNewsSourceMap());
				objectOutputStream.writeObject(newsDataBaseModel.getNewsTopicMap());
				objectOutputStream.writeObject(newsDataBaseModel.getNewsSubjectMap());
				objectOutputStream.close();
			} 
			catch(IOException ioe) {
				System.err.println("I/O exception: " + ioe.getMessage());
			}
		}	
	}
	

	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	private void importNoozStories() {
		
		//Initialized file chooser
		JFileChooser fc = new JFileChooser(".");
		String filename = "";
		String singleFileName = "";
		int returnValue = -1;
		String selectedItem = "";
		
		//creates the combo box and adds it to joption pane
		String[] boxElements = {"Source Codes", "Topic Codes", "Subject Codes", "News Stories"};
		JComboBox<String> combo = new JComboBox<String>(boxElements);
				
		Map<String, String> sourceMap = new TreeMap<String, String>();
		Map<String, String> topicMap = new TreeMap<String, String>();
		Map<String, String> subjectMap = new TreeMap<String, String>();
		String storyFile = "";

		//sentinel statement
		while(sourceMap.isEmpty() || topicMap.isEmpty() || subjectMap.isEmpty() || storyFile.length() < 1)
		{
			
			filename = "";
			 singleFileName = "";
			returnValue = fc.showOpenDialog(selectionView);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				try{
					filename = fc.getSelectedFile().getCanonicalPath();
					String[] files = filename.split("\\\\");
					singleFileName = files[files.length - 1];

				}
				catch(IOException ioe){
					System.err.println("I/O exception " + ioe.getMessage());
				}
			}
			else if(returnValue == JFileChooser.CANCEL_OPTION) {
				break;
			}
			
			JOptionPane.showMessageDialog( null, combo, "Enter the data represented in this file", JOptionPane.INFORMATION_MESSAGE);
			selectedItem = (String)combo.getSelectedItem();
			
			if(selectedItem.equals("Source Codes")) {
				sourceMap = new TreeMap<String, String> (CodeFileProcessor.readCodeFile(singleFileName));
				this.newsDataBaseModel.setNewsSourceMap(sourceMap);
			}
			else if(selectedItem.equals("Topic Codes")) {
				topicMap = new TreeMap<String, String> (CodeFileProcessor.readCodeFile(singleFileName));
				this.newsDataBaseModel.setNewsTopicMap(topicMap);
			}
			else if(selectedItem.equals("Subject Codes")) {
				subjectMap = new TreeMap<String, String> (CodeFileProcessor.readCodeFile(singleFileName));
				this.newsDataBaseModel.setNewsSubjectMap(subjectMap);
			}
			else if (selectedItem.equals("News Stories")) {
				storyFile = singleFileName;
			}
			
			
		}
	
	
		if(!(sourceMap.isEmpty()) && !(topicMap.isEmpty()) && !(subjectMap.isEmpty()) ) {
			NewsDataBaseModel dataBase = NoozFileProcessor.readNoozFile(storyFile, sourceMap, topicMap, subjectMap);
			newsDataBaseModel.setNewsMakerListModel(dataBase.getNewsMakerListModel());
			newsDataBaseModel.setNewsStoryListModel(dataBase.getNewsStoryListModel());
		}
		
		newsDataBaseModel.sortNewsMakerListModel();
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//TODO write
	private void exportNewsStories() {
		//get list of stores from textview (or another function)
		//get output name froma jfilechooser
		//NoozFileProcessor.writeNewsTextFile(outputFileName, listOfStories);
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//TODO write
	private void addNewsMaker() {
		//If news maker is not in database, add it
		String name = JOptionPane.showInputDialog("Please enter the news maker's name");
		
		//If no name is added in, we make the name "none"
		if(name != null && name.equals("")){
			name = "None";
		}
		if(name != null){
			NewsMakerModel maker = new NewsMakerModel(name);
			if(!newsDataBaseModel.getNewsMakerListModel().contains(maker)) {
				newsDataBaseModel.addNewsMakerModel(maker);
				selectionView.setNewsDataBaseModel(newsDataBaseModel);
			}
			else {
				String[] options = {"No", "Yes"};
				int choice = JOptionPane.showOptionDialog(null, 
										     "This news maker already exists.\nDo you want to override the name?",
										     null, JOptionPane.CLOSED_OPTION,
										     JOptionPane.CLOSED_OPTION,
										     null,
										     options,
										     options[1]);
				if(choice == 1) {
					newsDataBaseModel.replaceNewsMakerModel(maker);
				}
			}
			/*System.out.println(this.newsDataBaseModel.getNewsMakerListModel().get(maker).getName());
			if(this.newsDataBaseModel.getNewsMakerListModel().get(maker).getName().equals("")){
				System.out.println("empty string");
			}*/
		}
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//TODO NOT SURE HOW TO USE THIS VIEW
	private void editNewsMakers() {
		int [] makers = selectionView.getSelectedNewsMakers();
		if(makers.length == 0) {
			JOptionPane.showMessageDialog(null, "No news makers have been selected.");
		}
		else {
			for(int index: makers) {
				String newsMakerName = this.newsDataBaseModel.getNewsMakerListModel().get(index).getName();
				this.editNewsMakerView = new EditNewsMakerView(this.newsDataBaseModel.getNewsMakerListModel().get(index), 
						this.newsDataBaseModel);
				this.editNewsMakerView.jbtRemoveFromStory.addActionListener(new RemoveNewsMakerFromNewStoriesListener());
				this.editNewsMakerView.jtfName.addActionListener(new EditNewsMakerNameListener());
				this.viewDialog = new JDialog(selectionView, "Editing News Makers", true);
				this.viewDialog.add(editNewsMakerView);
				this.viewDialog.setResizable(false);
				this.viewDialog.pack();
				//getClass();
				this.viewDialog.setVisible(true);
			}
			
			
		}
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//TODO write
	private void deleteNewsMakers() {
		int [] makers = selectionView.getSelectedNewsMakers();
		if(makers.length == 0) {
			JOptionPane.showMessageDialog(null, "No news makers have been selected.");
		}
		else {
			int[] indices = selectionView.getSelectedNewsMakers();
			for(int index = 0; index < indices.length; ++index){
				newsDataBaseModel.getNewsMakerListModel().remove(newsDataBaseModel.getNewsMakerListModel().get(index));
			}
		}
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//TODO write
	private void deleteNewsMakerList() {
		String[] options = {"No", "Yes"};
		int choice = JOptionPane.showOptionDialog(null, 
								     "Are you sure you want remove all news makers?",
								     null, JOptionPane.CLOSED_OPTION,
								     JOptionPane.CLOSED_OPTION,
								     null,
								     options,
								     options[1]);
		if(choice == 1) {
			newsDataBaseModel.getNewsMakerListModel().removeAllNewsMakers();
		}
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	private void addNewsStory() {
		this.addEditNewsStoryView = new AddEditNewsStoryView(this.newsDataBaseModel, null);
		AddEditNewsStoryListener listener = new AddEditNewsStoryListener();
		this.addEditNewsStoryView.jbtAddEditNewsStory.addActionListener(listener);
		this.viewDialog = new JDialog(selectionView, "Adding News Story", true);
		this.viewDialog.add(addEditNewsStoryView);
		this.viewDialog.setResizable(false);
		this.viewDialog.pack();
		this.viewDialog.setVisible(true);
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//TODO write
	private void editNewsStories() {
		int [] stories = selectionView.getSelectedNewsStories();
		NewsStoryListModel list = new NewsStoryListModel();
		for(int index = 0; index < newsDataBaseModel.getNewsMakerListModel().size(); ++index) {
			list.add(newsDataBaseModel.getNewsStoryListModel().get(index));
		}
		if(stories.length == 0) {
			JOptionPane.showMessageDialog(null, "No news stories have been selected.");
		}


		else {
			for(int index = 0; index < list.size(); ++index) {
			this.addEditNewsStoryView = new AddEditNewsStoryView(this.newsDataBaseModel, list.get(index));
			this.addEditNewsStoryView.jbtAddEditNewsStory.addActionListener(new AddEditNewsStoryListener());
			this.viewDialog = new JDialog(selectionView, "Editing News Story", true);
			this.viewDialog.add(addEditNewsStoryView);
			this.viewDialog.setResizable(false);
			this.viewDialog.pack();
			this.viewDialog.setVisible(true);
			
			NewsMedia type = (NewsMedia) addEditNewsStoryView.jcbNewsMediaType.getSelectedItem();
			String source = (String) addEditNewsStoryView.jcbNewsStorySource.getSelectedItem();
			String topic = (String) addEditNewsStoryView.jcbNewsStoryTopic.getSelectedItem();
			String subject = (String) addEditNewsStoryView.jcbNewsStorySubject.getSelectedItem();
			String newsMaker1Name = (String) addEditNewsStoryView.jcbNewsStoryNewsMaker1.getSelectedItem();
			String newsMaker2Name = (String) addEditNewsStoryView.jcbNewsStoryNewsMaker2.getSelectedItem();
			NewsMakerModel newsMaker1 = new NewsMakerModel(newsMaker1Name);
			NewsMakerModel newsMaker2 = new NewsMakerModel(newsMaker2Name);
			if (!newsDataBaseModel.getNewsMakerListModel().contains(newsMaker1)) {
				newsDataBaseModel.addNewsMakerModel(newsMaker1);
			}
			if (!newsDataBaseModel.getNewsMakerListModel().contains(newsMaker2)) {
				newsDataBaseModel.addNewsMakerModel(newsMaker2);
			}
			long lengthLong =  (long) addEditNewsStoryView.jftfNewsStoryLength.getValue();
			int length = (int) lengthLong;
			int year = (int) addEditNewsStoryView.jcbNewsStoryYear.getSelectedItem();
			Month monthAsEnum = (Month) addEditNewsStoryView.jcbNewsStoryMonth.getSelectedItem();
			int monthAsInt = monthAsEnum.toInt();
			int day = (int) addEditNewsStoryView.jcbNewsStoryDay.getSelectedItem();
			LocalDate date = LocalDate.of(year, monthAsInt, day);
			PartOfDay partOfDay = (PartOfDay) addEditNewsStoryView.jcbNewsStoryPartOfDay.getSelectedItem();
			NewsStory story = null;
			if (type.equals(NewsMedia.NEWSPAPER)) {
				story = new NewspaperStory(date, source, length, topic, subject, newsMaker1, newsMaker2);
				newsMaker1.addNewsStory(story);
				newsMaker2.addNewsStory(story);
			}
			else if (type.equals(NewsMedia.TV)) {
				story = new TVNewsStory(date, source, length, topic, subject, partOfDay, newsMaker1, newsMaker2);
				newsMaker1.addNewsStory(story);
				newsMaker2.addNewsStory(story);
				System.out.println(story);
			}
			else if (type.equals(NewsMedia.ONLINE)) {
				story = new OnlineNewsStory(date, source, length, topic, subject, partOfDay, newsMaker1, newsMaker2);
				newsMaker1.addNewsStory(story);
				newsMaker2.addNewsStory(story);
				//newsMaker1.addActionListener(selectionView);
				//newsMaker2.addActionListener(selectionView);
				System.out.println("finished online");
			}
			}

		}
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//TODO write
	private void sortNewsStories() {
		String[] criteria = {"source", "topic", "length", "date/time", "subject"};
		String input = (String) JOptionPane.showInputDialog(null, 
															"Select a sort criterion: ", 
															"Custom Sort",
															JOptionPane.NO_OPTION,
															null,
															criteria,
															criteria[0]);
		if(input != null) {
			List<NewsStory> listCopy = (List<NewsStory>) newsDataBaseModel.getNewsStories();
			
			if(input.equals("topic")) {
				Collections.sort(listCopy);
			}
			
			else if(input.equals("source")) {
				Collections.sort(listCopy, SourceComparator.SOURCE_COMPARATOR);
			}
			
			else if(input.equals("length")) {
				Collections.sort(listCopy, LengthComparator.LENGTH_COMPARATOR);
			}
			
			else if(input.equals("date/time")) {
				Collections.sort(listCopy, DateComparator.DATE_COMPARATOR);
			}
			
			//subject
			else {
				Collections.sort(listCopy, SubjectComparator.SUBJECT_COMPARATOR);
			}
			
			newsDataBaseModel.setNewsStoryListModel((NewsStoryListModel) listCopy);
		}

	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//TODO write
	private void deleteNewsStories() {
		
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//TODO write
	private void deleteAllNewsStories() {
		String[] options = {"No", "Yes"};
		int choice = JOptionPane.showOptionDialog(null, 
								     "Are you sure you want remove all news stories?",
								     null, JOptionPane.CLOSED_OPTION,
								     JOptionPane.CLOSED_OPTION,
								     null,
								     options,
								     options[1]);
		if(choice == 1) {
			newsDataBaseModel.removeAllNewsStories();
			System.out.println("Attempted to delete news stories");
		}
	}
	
	/**
     * This method is called to display pie charts when requested by the user.
     * It gets the list of all selected news makers from the
     * <code>SectionView</code> and displays one pie chart per news maker. For
     * each pie chart it needs to determine the media type(s) to display, the
     * news content type to display, and the news metric to use for display.
     * 
     *
     * @author Nathan Fritz
     * @author Alex Kloppenburg
     * @author Joe Pauly
     * @author Cavan Gary
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
	
    /**
     * @author Nathan Fritz
     * @author Alex Kloppenburg
     * @author Joe Pauly
     * @author Cavan Gary
     */
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
                List<SortCriterion> selectedSortCriteria = new ArrayList<SortCriterion>();
                for(int i = 0; i < 4; ++i){
                	SortCriterion selectedSortCriterion = (SortCriterion)JOptionPane.showInputDialog(selectionView,
                			"Sort news stories based on which criteria?", newsMakerName, JOptionPane.PLAIN_MESSAGE, null,
                			SortCriterion.values(), NewsContent.TOPIC);
                	selectedSortCriteria.add(selectedSortCriterion);
            	}
                
                
                // Create the text view.
                TextView textView = new TextView(newsMakerModel, selectedMediaTypes, selectedSortCriteria);

                //Make sure the text view listens for model changes so that it can update itself.
                newsMakerModel.addActionListener(textView);
            }
        }
		
	}
	
	
	//LISTENERS
	//TODO write listeners
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	private class FileMenuListener implements ActionListener {
		
		/**
		 * @author Nathan Fritz
		 * @author Alex Kloppenburg
		 * @author Joe Pauly
		 * @author Cavan Gary
		 */
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
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	private class NewsMakerMenuListener implements ActionListener {
		
		/**
		 * @author Nathan Fritz
		 * @author Alex Kloppenburg
		 * @author Joe Pauly
		 * @author Cavan Gary
		 */
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if("Add Newsmaker".equals(actionEvent.getActionCommand())) {
				addNewsMaker();
			}
			if("Edit Newsmaker".equals(actionEvent.getActionCommand())) {
				editNewsMakers();
			}
			if("Delete Newsmaker".equals(actionEvent.getActionCommand())) {
				deleteNewsMakers();
			}
			if("Delete Newsmaker List".equals(actionEvent.getActionCommand())) {
				deleteNewsMakerList();
			}
		}
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	private class NewsStoryMenuListener implements ActionListener {
		
		/**
		 * @author Nathan Fritz
		 * @author Alex Kloppenburg
		 * @author Joe Pauly
		 * @author Cavan Gary
		 */
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
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	private class DisplayMenuListener implements ActionListener {
		
		/**
		 * @author Nathan Fritz
		 * @author Alex Kloppenburg
		 * @author Joe Pauly
		 * @author Cavan Gary
		 */
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
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	public class EditNewsMakerNameListener implements ActionListener {
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {	
			//before we do this we need to add an if statement for the listener
			if ("Edit Newsmaker Name".equals(actionEvent.getActionCommand())) {
				NewsMakerModel maker = new NewsMakerModel(editNewsMakerView.jtfName.getText());
				if(newsDataBaseModel.getNewsMakerListModel().contains(maker)){
					String[] options = {"No", "Yes"};
					int choice = JOptionPane.showOptionDialog(null, 
											     "This news maker already exists.\nDo you want to override the name?",
											     null, JOptionPane.CLOSED_OPTION,
											     JOptionPane.CLOSED_OPTION,
											     null,
											     options,
											     options[1]);
					if(choice == 1) {
						newsDataBaseModel.replaceNewsMakerModel(maker);
						newsDataBaseModel.sortNewsMakerListModel();
					}
				}
				else {
					newsDataBaseModel.getNewsMakerListModel().get(editNewsMakerView.newsMakerModel).setName(editNewsMakerView.jtfName.getText());
				}
				/*
				 * if name exists, confirm replacing existing news maker with name whose name has just been change
				 * by using JOptionPane
				 * Replace or don't depending on confirmation
				 */
				
			}
		}
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	public class RemoveNewsMakerFromNewStoriesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if("Remove From Story".equals(actionEvent.getActionCommand())){
				int indices[] = editNewsMakerView.getSelectedNewsStoryIndices();
				
				for(int i = 0; i < indices.length; ++i){
					System.out.println(indices[i]);
				}
				
				for(int index = 0; index < indices.length; ++index) {
					if(newsDataBaseModel.getNewsMakerListModel().get(editNewsMakerView.newsMakerModel).getNewsStoryListModel().
							get(indices[index]).getNewsMaker1().equals(editNewsMakerView.newsMakerModel))
					{
						System.out.println("first newsmaker equal");
						newsDataBaseModel.getNewsMakerListModel().get(editNewsMakerView.newsMakerModel).getNewsStoryListModel().
							get(indices[index]).setNewsMaker1(new NewsMakerModel());
						System.out.println("first newsmaker set to none");
					}
					if(newsDataBaseModel.getNewsMakerListModel().get(editNewsMakerView.newsMakerModel).getNewsStoryListModel().
							get(indices[index]).getNewsMaker2().equals(editNewsMakerView.newsMakerModel))
					{
						System.out.println("second newsmaker equal");
						newsDataBaseModel.getNewsMakerListModel().get(editNewsMakerView.newsMakerModel).getNewsStoryListModel().
							get(indices[index]).setNewsMaker2(new NewsMakerModel());
						System.out.println("second newsmaker set to none");
					}
				}
			}	
		}
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	//written by alex 5/2
	public class AddEditNewsStoryListener implements ActionListener {
		
		/**
		 * @author Nathan Fritz
		 * @author Alex Kloppenburg
		 * @author Joe Pauly
		 * @author Cavan Gary
		 */
		//TODO write
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if ("Add Story Button Pressed".equals(actionEvent.getActionCommand())) {
				NewsMedia type = (NewsMedia) addEditNewsStoryView.jcbNewsMediaType.getSelectedItem();
				String source = (String) addEditNewsStoryView.jcbNewsStorySource.getSelectedItem();
				String topic = (String) addEditNewsStoryView.jcbNewsStoryTopic.getSelectedItem();
				String subject = (String) addEditNewsStoryView.jcbNewsStorySubject.getSelectedItem();
				String newsMaker1Name = (String) addEditNewsStoryView.jcbNewsStoryNewsMaker1.getSelectedItem();
				String newsMaker2Name = (String) addEditNewsStoryView.jcbNewsStoryNewsMaker2.getSelectedItem();
				NewsMakerModel newsMaker1 = new NewsMakerModel(newsMaker1Name);
				NewsMakerModel newsMaker2 = new NewsMakerModel(newsMaker2Name);
				if (!newsDataBaseModel.getNewsMakerListModel().contains(newsMaker1)) {
					newsDataBaseModel.addNewsMakerModel(newsMaker1);
				}
				if (!newsDataBaseModel.getNewsMakerListModel().contains(newsMaker2)) {
					newsDataBaseModel.addNewsMakerModel(newsMaker2);
				}
				long lengthLong =  (long) addEditNewsStoryView.jftfNewsStoryLength.getValue();
				int length = (int) lengthLong;
				int year = (int) addEditNewsStoryView.jcbNewsStoryYear.getSelectedItem();
				Month monthAsEnum = (Month) addEditNewsStoryView.jcbNewsStoryMonth.getSelectedItem();
				int monthAsInt = monthAsEnum.toInt();
				int day = (int) addEditNewsStoryView.jcbNewsStoryDay.getSelectedItem();
				LocalDate date = LocalDate.of(year, monthAsInt, day);
				PartOfDay partOfDay = (PartOfDay) addEditNewsStoryView.jcbNewsStoryPartOfDay.getSelectedItem();
				if (type.equals(NewsMedia.NEWSPAPER)) {
					NewsStory story = new NewspaperStory(date, source, length, topic, subject, newsMaker1, newsMaker2);
					newsMaker1.addNewsStory(story);
					newsMaker2.addNewsStory(story);
					newsMaker1.addActionListener(selectionView);
					newsMaker2.addActionListener(selectionView);
					newsDataBaseModel.addNewsStory(story);
				}
				else if (type.equals(NewsMedia.TV)) {
					NewsStory story = new TVNewsStory(date, source, length, topic, subject, partOfDay, newsMaker1, newsMaker2);
					newsMaker1.addNewsStory(story);
					newsMaker2.addNewsStory(story);
					newsMaker1.addActionListener(selectionView);
					newsMaker2.addActionListener(selectionView);
					newsDataBaseModel.addNewsStory(story);
				}
				else if (type.equals(NewsMedia.ONLINE)) {
					NewsStory story = new OnlineNewsStory(date, source, length, topic, subject, partOfDay, newsMaker1, newsMaker2);
					newsMaker1.addNewsStory(story);
					newsMaker2.addNewsStory(story);

					newsMaker1.addActionListener(selectionView);
					newsMaker2.addActionListener(selectionView);
					//newsDataBaseModel.addActionListener(selectionView);
					newsDataBaseModel.addNewsStory(story);					
					System.out.println("finished online");
				}
				viewDialog.dispose();
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
     *
     * @author Nathan Fritz
     * @author Alex Kloppenburg
     * @author Joe Pauly
     * @author Cavan Gary
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
