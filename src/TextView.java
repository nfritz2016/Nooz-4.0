import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Alex Kloppenburg
 */
public class TextView implements ActionListener{
	
	/**
	 * 
	 */
	private JFrame jfText = new JFrame();
	
	/**
	 * 
	 */
	private NewsMakerModel newsMakerModel;
	
	/**
	 * 
	 */
	private List<NewsMedia> newsMedia;
	
	/**
	 * 
	 */
	private List<SortCriterion> sortCriteria;
	
	/**
	 * 
	 */
	private String listOfStories = "";
	
	/**
	 * 
	 */
	private String summaryLine = "";
	
	/**
	 * 
	 */
	private JTextArea jtaNewsStoryList;
	
	/**
	 * 
	 */
	private JScrollPane jspNewsStoryList;
	
	/**
	 * 
	 */
	private JTextArea jtaSummaryLine;
	
	/**
	 * @author Alex Kloppenburg
	 */
	public TextView(NewsMakerModel newsMakerModel, List<NewsMedia> newsMedia, List<SortCriterion> sortCriteria){
		
		/*fill strings with info, will populate into text fields bc of initializations above.  When initialized,
		 * the Strings are added into their respective JTextAreas an simply need to be added to the JFrame.
		 */
		this.newsMakerModel = newsMakerModel;
		this.newsMedia = newsMedia;
		this.sortCriteria = sortCriteria;
		constructNewsStoriesAndSummary();
		
		//GUI stuff
		//TODO find right layout to make this look good
		//Set layout
		this.jfText.setLayout(new GridLayout(2, 1, 0, 0));
		jtaNewsStoryList = new JTextArea(listOfStories);
		jspNewsStoryList = new JScrollPane(jtaNewsStoryList);
		jtaSummaryLine = new JTextArea(summaryLine);
		//Add scroll pane to frame
		this.jfText.add(jspNewsStoryList);
		//add summary line JTextArea to frame
		this.jfText.add(jtaSummaryLine);
		//Set title
		this.jfText.setTitle(constructTitle());
		//Fill textareas
		//Set uneditable
		jtaNewsStoryList.setEditable(false);
		jtaSummaryLine.setEditable(false);
		
		//pack the frame and set visible
		this.jfText.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jfText.setLocationRelativeTo(null);
		this.jfText.pack();
		this.jfText.setVisible(true);
		
	}
	
	/**
	 * This method adapts several methods from the UserInterface class from project 3, adapting them for use with the 
	 * new MVC classes.  It creates a single string containing both the list of NewsStories 
	 * 
	 * @author Dean Hougen
	 * @author Alex Kloppenburg
	 */
	private void constructNewsStoriesAndSummary(){
		
		/* The list of stories as a String */
		this.listOfStories = "";

		/*
		 * Sets to keep track of the distinct news source names and topics found
		 * (for the summary line).
		 */
		Set<String> distinctNewsSourceNames = new TreeSet<String>();
		Set<String> distinctTopics = new TreeSet<String>();
		Set<String> distinctSubjects = new TreeSet<String>();

		/* The running total of the length of the stories. */
		int totalLength = 0;

		/*
		 * A local reference to the story list so that we don't have use the
		 * accessor method repeatedly (wasting time).
		 */
		NewsStoryListModel newsStoryList = this.newsMakerModel.getNewsStoryListModel();
		
		//Gets number of total stories
		int numStoriesTotal = newsMakerModel.getNewsStoryListModel().size();
		
		//Creates a list to hold only the types selected
		NewsStoryListModel selectedList = new NewsStoryListModel();
		
		/*
		 * Iterates through the list of NewsMedia enums and adds all the stories of that type to the list of desired
		 * stories, similar to what was done in PieChartView
		 */
		for(int index = 0; index < this.newsMedia.size(); ++index){
			if(this.newsMedia.get(index) == NewsMedia.NEWSPAPER){
				for(int i = 0; i < numStoriesTotal; ++i){
					if(newsMakerModel.getNewsStoryListModel().get(i) instanceof NewspaperStory){
						selectedList.add(newsMakerModel.getNewsStoryListModel().get(i));
					}
				}
			}
			if(this.newsMedia.get(index) == NewsMedia.ONLINE){
				for(int i = 0; i < numStoriesTotal; ++i){
					if(newsMakerModel.getNewsStoryListModel().get(i) instanceof OnlineNewsStory){
						selectedList.add(newsMakerModel.getNewsStoryListModel().get(i));
					}
				}
			}
			if(this.newsMedia.get(index) == NewsMedia.TV){
				for(int i = 0; i < numStoriesTotal; ++i){
					if(newsMakerModel.getNewsStoryListModel().get(i) instanceof TVNewsStory){
						selectedList.add(newsMakerModel.getNewsStoryListModel().get(i));
					}
				}
			}
		}


		// Cycle through the stories one at a time
		for (int index = 0; index < selectedList.size(); ++index) {

			// Add any new source name encountered to the set of names
			// Since sets exclude duplicates, we don't need to check
			distinctNewsSourceNames.add(selectedList.get(index).getSource());

			// Add any new topic encountered to the set of topics
			// Since sets exclude duplicates, we don't need to check
			distinctTopics.add(selectedList.get(index).getTopic());

			// Add any new topic encountered to the set of topics
			// Since sets exclude duplicates, we don't need to check
			distinctSubjects.add(selectedList.get(index).getSubject());

			// Add to the running total for length
			// If the type is TV news, use seconds (from length)
			if (this.newsMedia.contains(NewsMedia.TV)) {
				totalLength += selectedList.get(index).getLength();
			}
			// If the type is newspaper, use words
			// If the type is online, use words
			// If the type is mixed, use words as common unit
			else {
				totalLength += selectedList.get(index).getLengthInWords();
			}

			// Convert the story to the display format and add it to the end of
			// the list
			this.listOfStories += UserInterface.convertToOutputFormat(selectedList.get(index), this.newsMedia) + "\n";
		}

		// Construct the summary line
		// If the type doesn't include TV, use words
		if (!(this.newsMedia.contains(NewsMedia.TV))) {
			this.summaryLine += "Number of Stories: " + selectedList.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Words: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		}
		// If the type is TV news, use seconds (from length)
		else if (this.newsMedia.contains(NewsMedia.TV)) {
			this.summaryLine += "Number of Stories: " + selectedList.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Seconds: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		}
		// If the type is mixed, use words as common unit
		else {
			this.summaryLine += "Number of Stories: " + selectedList.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Word Equivalents: " + totalLength
					+ "; Number of Topics: " + distinctTopics.size() + "; Number of Subjects: "
					+ distinctSubjects.size();
		}
		
	}
	
	/**
	 * @author Alex Kloppenburg
	 */
	private String constructTitle(){
		
		String title = "Text View of " ;
		
		for(int i = 0; i < this.newsMedia.size(); ++i){
			title += this.newsMedia.get(i).toString() + " News Stories " + " and ";
		}
		
		title = title.substring(0, title.length() - 5);
		
		title += "Sorted by ";
		
		for(int i = 0; i < this.sortCriteria.size(); ++i){
			title += this.sortCriteria.get(i).toString() + " and ";
		}
		
		title = title.substring(0, title.length() - 5);
		
		return title;
		
	}
	
	/**
	 * @author Alex Kloppenburg
	 * @param e
	 */
	//created by alex 4/25
	@Override
	public void actionPerformed(ActionEvent actionEvent){
		
		if("Text".equals(actionEvent.getActionCommand())){
			constructTitle();
			constructNewsStoriesAndSummary();
		}
		
	}
}
