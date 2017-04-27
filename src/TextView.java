import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextView implements ActionListener {
	/**
	 * 
	 */
	private JFrame jfText;
	private NewsMakerModel newsMakerModel;
	private List<NEwsMedia> newsMedia;
	private List<SortCriterion> sortCriteria;
	private String listOfStories;
	private String summaryLine;
	private JTextArea jtaNewsStoryList;
	private JScrollPane jspNewsStoryList;
	private JTextArea jtaSummaryLine;
	
	public void TextView(NewsMakerModel newsMakerModel, 
						 List<NewsMedia> newsMedia,
						 List<SortCriterion> sortCriteria) {
		
	}
	
	private void constructNewsStoriesAndSummary() {
		
	}
	
	private void constructTitle() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}
