import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
		this.jfText.setLayout(new GridLayout(2, 1, 0, 0));
		this.jfText.add(jspNewsStoryList);
		this.jfText.add(jtaSummaryLine);
		this.jfText.setTitle(constructTitle());
		this.jfText.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jfText.pack();
		this.jfText.setVisible(true);
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void constructNewsStoriesAndSummary(){
		//Constructs list of news Stories as a single string
		this.listOfStories = "";
		for(int i = 0; i < this.newsMakerModel.getNewsStoryListModel().size(); ++i){
			this.listOfStories += UserInterface.convertToOutputFormat(this.newsMakerModel.getNewsStoryListModel().get(i), 
					this.newsMedia);
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
