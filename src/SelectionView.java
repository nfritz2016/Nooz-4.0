import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

public class SelectionView extends JFrame implements ActionListener {
	
	private NewsDataBaseModel newsDataBaseModel = new NewsDataBaseModel();
	
	private JMenuBar jmb = new JMenuBar();
	
	private JMenu jmFile = new JMenu("File");
	private JMenuItem jmiLoad = new JMenuItem("Load");
	private JMenuItem jmiSave = new JMenuItem("Save");
	private JMenuItem jmiImport = new JMenuItem("Import");
	private JMenuItem jmiExport = new JMenuItem("Export");
	
	private JMenu jmNewsMaker = new JMenu("NewsMaker");
	private JMenuItem jmiAddNewsMaker = new JMenuItem("Add NewsMaker");
	private JMenuItem jmiEditNewsMaker = new JMenuItem("Edit NewsMaker");
	private JMenuItem jmiDeleteNewsMaker = new JMenuItem("Delete NewsMaker");
	private JMenuItem jmiDeleteNewsMakerList = new JMenuItem("Delete NewsMaker List");
	
	private JMenu jmNewsStory = new JMenu("NewsStory");
	private JMenuItem jmiAddNewsStory = new JMenuItem("Add News Story");
	private JMenuItem jmiEditNewsStory = new JMenuItem("Edit News Story");
	private JMenuItem jmiSortNewsStories = new JMenuItem("Sort News Stories");
	private JMenuItem jmiDeleteNewsStory = new JMenuItem("Delete News Stories");
	private JMenuItem jmiDeleteAllNewsStories = new JMenuItem("Delete All News Stories");
	
	private JMenu jmDisplay = new JMenu("Display");
	private JMenuItem jmiPieChart = new JMenuItem("Pie Chart");
	private JMenuItem jmiText = new JMenuItem("Text");
	
	private JList<NewsMakerModel> jlNewsMakerList = new JList<NewsMakerModel>();
	private JScrollPane jspNewsMakerList = new JScrollPane(jlNewsMakerList);
	private JPanel jpNewsMakerList = new JPanel();
	
	private JList<NewsStory> jlNewsStoryList = new JList<NewsStory>();
	private JScrollPane jspNewsStoryList = new JScrollPane(jlNewsStoryList);
	private JPanel jpNewsStoryList = new JPanel();
	
	private JSplitPane splitPane;
	private JLabel newsmakers = new JLabel("NewsMakers");
	private JLabel newsstories = new JLabel("News Stories");
	
	public SelectionView() {
		//sets name of frame
		setTitle("Nooz");
		
		//makes the file tab
		jmFile.add(jmiLoad);
		jmFile.add(jmiSave);
		jmFile.add(jmiImport);
		jmFile.add(jmiExport);
		//Set appropriate buttons inactive initially
		jmiSave.setEnabled(false);
		jmiExport.setEnabled(false);
		
		//makes NewsMaker tab
		jmNewsMaker.add(jmiAddNewsMaker);
		jmNewsMaker.add(jmiEditNewsMaker);
		jmNewsMaker.add(jmiDeleteNewsMaker);
		jmNewsMaker.add(jmiDeleteNewsMakerList);
		//Set appropriate buttons inactive initially
		jmiEditNewsMaker.setEnabled(false);
		jmiDeleteNewsMaker.setEnabled(false);
		jmiDeleteNewsMakerList.setEnabled(false);
		
		//makes NewsStory Tab
		jmNewsStory.add(jmiAddNewsStory);
		jmNewsStory.add(jmiEditNewsStory);
		jmNewsStory.add(jmiSortNewsStories);
		jmNewsStory.add(jmiDeleteNewsStory);
		jmNewsStory.add(jmiDeleteAllNewsStories);
		//Set appropriate buttons inactive initially
		jmiEditNewsStory.setEnabled(false);
		jmiSortNewsStories.setEnabled(false);
		jmiDeleteNewsStory.setEnabled(false);
		jmiDeleteAllNewsStories.setEnabled(false);
		
		//makes display tab
		jmDisplay.add(jmiPieChart);
		jmDisplay.add(jmiText);
		//Set appropriate buttons inactive initially
		jmiPieChart.setEnabled(false);
		jmiText.setEnabled(false);
		
		//puts all menus into bar
		jmb.add(jmFile);
		jmb.add(jmNewsMaker);
		jmb.add(jmNewsStory);
		jmb.add(jmDisplay);
		
		//makes the frame and such
		jpNewsMakerList.setLayout(new BorderLayout());
		jpNewsStoryList.setLayout(new BorderLayout());
		jpNewsMakerList.add(jspNewsMakerList);
		jpNewsMakerList.add(newsmakers, BorderLayout.NORTH);
		jpNewsStoryList.add(jspNewsStoryList);
		jpNewsStoryList.add(newsstories, BorderLayout.NORTH);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jpNewsMakerList, jpNewsStoryList);
		jlNewsMakerList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jlNewsStoryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		setJMenuBar(jmb);
		add(splitPane);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void registerFileMenuListener(ActionListener fileMenuListener) {
		jmFile.addActionListener(fileMenuListener);
	}
	
	public void registerNewsMakerMenuListener(ActionListener newsMakerMenuListener) {
		jmNewsMaker.addActionListener(newsMakerMenuListener);
	}
	
	public void registerNewsStoryMenuListener(ActionListener newsStoryMenuListener) {
		jmNewsStory.addActionListener(newsStoryMenuListener);
	}
	
	public void registerDisplayMenuListener(ActionListener displayMenuListener) {
		jmDisplay.addActionListener(displayMenuListener);
	}
	
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel) {
		this.newsDataBaseModel = newsDataBaseModel;
		if(this.newsDataBaseModel != null) {
			newsDataBaseModel.addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getActionCommand().equals("Present NewsStories")) {
			if (getSelectedNewsMakers().length == 0) {
				//put all stories in story JList.
			}
			else {
				for (int i = 0; i < getSelectedNewsMakers().length; i++) {
					//for each newsmaker selected, add the stories to the other window.
				}
			}
		}
	}
	
	public int[] getSelectedNewsMakers() {
		return jlNewsMakerList.getSelectedIndices();
	}
	
	public int[] getSelectedNewsStories() {
		return jlNewsStoryList.getSelectedIndices();
	}
}
