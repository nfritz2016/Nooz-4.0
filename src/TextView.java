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
 * 
 * @author Alex
 *
 */
//class created by alex 4/25
//all fields created by alex 4/25
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
	private String listOfStories = "test string story list \n\n\n\n\n";
	
	/**
	 * 
	 */
	private String summaryLine = "test string summary line";
	
	/**
	 * 
	 */
	private JTextArea jtaNewsStoryList = new JTextArea(listOfStories);
	
	/**
	 * 
	 */
	private JScrollPane jspNewsStoryList = new JScrollPane(jtaNewsStoryList);
	
	/**
	 * 
	 */
	private JTextArea jtaSummaryLine = new JTextArea(summaryLine);
	
	/**
	 * 
	 * @param newsMakerModel
	 * @param newsMedia
	 * @param sortCriteria
	 */
	//created by alex 4/25
	//graphical part of method body written by alex 4/26
	public TextView(NewsMakerModel newsMakerModel, List<NewsMedia> newsMedia, List<SortCriterion> sortCriteria){
		
		/*fill strings with info, will populate into text fields bc of initializations above.  When initialized,
		 * the Strings are added into their respective JTextAreas an simply need to be added to the JFrame.
		 */
		this.newsMakerModel = newsMakerModel;
		this.newsMedia = newsMedia;
		this.sortCriteria = sortCriteria;
		
		//GUI stuff
		//TODO find right layout to make this look good
		//Set layout
		this.jfText.setLayout(new GridLayout(2, 1, 0, 0));
		//Add scroll pane to frame
		this.jfText.add(jspNewsStoryList);
		//add summary line JTextArea to frame
		this.jfText.add(jtaSummaryLine);
		//Set title
		this.jfText.setTitle(constructTitle());
		//Add news stories to the scroll pane
		this.jtaNewsStoryList.append(this.listOfStories);
		//Add summary line to the JTextArea
		this.jtaSummaryLine.append(this.summaryLine);
		
		//pack the frame and set visible
		this.jfText.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jfText.pack();
		this.jfText.setVisible(true);
		
	}
	
	/**
	 * This method adapts several methods from the UserInterface class from project 3, adapting them for use with the 
	 * new MVC classes.  It creates a single string containing both the list of NewsStories 
	 */
	//created by alex 4/25
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
			this.listOfStories += "Number of Stories: " + selectedList.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Words: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		}
		// If the type is TV news, use seconds (from length)
		else if (this.newsMedia.contains(NewsMedia.TV)) {
			this.listOfStories += "Number of Stories: " + selectedList.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Seconds: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		}
		// If the type is mixed, use words as common unit
		else {
			this.listOfStories += "Number of Stories: " + selectedList.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Word Equivalents: " + totalLength
					+ "; Number of Topics: " + distinctTopics.size() + "; Number of Subjects: "
					+ distinctSubjects.size();
		}
		
		
		//convertToOutputFormat adds the summary line by default so we have to do two substrings to separate them
		if(this.listOfStories.lastIndexOf("\n") > 0) {
			//Summary line is last line, or everything after the last newline character
			this.summaryLine =  this.listOfStories.substring(this.listOfStories.lastIndexOf("\n"), 
					this.listOfStories.length() - 1);
			//Cuts off the summary line and leaves us with just the list of stories
			this.listOfStories =  this.listOfStories.substring(0, this.listOfStories.lastIndexOf("\n"));
		} 
		
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
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
	 * 
	 * @param e
	 */
	//created by alex 4/25
	@Override
	public void actionPerformed(ActionEvent actionEvent){
		
		
		
	}
	
	//TODO main method just for testing, delete later
	public static void main(String[] args){
		NewsMakerModel test1 = null;
		List<NewsMedia> test2 = null;
		List<SortCriterion> test3 = new ArrayList<SortCriterion>();
		test3.add(SortCriterion.DATE_TIME);
		new TextView(test1, test2, test3);
	}

}
