import java.awt.GridLayout;
import java.io.Serializable;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Nathan Fritz
 *
 */
public class AddEditNewsStoryView extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	private NewsDataBaseModel newsDataBaseModel = new NewsDataBaseModel();
	private NewsStory newsStory;
	//contents for type
	private JLabel jlbNewsMediaType = new JLabel("Type: ");
	JComboBox<NewsMedia> jcbNewsMediaType = new JComboBox<NewsMedia>(NewsMedia.values());
	private JPanel jpNewsMediaType = new JPanel();
	//contents for source
	private JLabel jlbNewsStorySource = new JLabel("Source: ");
	JComboBox<String> jcbNewsStorySource = new JComboBox<String>(newsDataBaseModel.getNewsSources());
	private JPanel jpNewsStorySource = new JPanel();
	//contents for topic
	private JLabel jlbNewsStoryTopic = new JLabel("Topic: ");
	JComboBox<String> jcbNewsStoryTopic = new JComboBox<String>(newsDataBaseModel.getNewsTopics());
	private JPanel jpNewsStoryTopic = new JPanel();
	//contents of subject
	private JLabel jlbNewsStorySubject = new JLabel("Subject: ");
	JComboBox<String> jcbNewsStorySubject = new JComboBox<String>(newsDataBaseModel.getNewsSubjects());
	private JPanel jpNewsStorySubject = new JPanel();
	//contents of NewsMaker1
	private JLabel jlbNewsStoryNewsMaker1 = new JLabel("News Maker 1: ");
	JComboBox<String> jcbNewsStoryNewsMaker1 = new JComboBox<String>(newsDataBaseModel.getNewsMakerNames());
	private JPanel jpNewsStoryNewsMaker1 = new JPanel();
	//contents of NewsMaker2
	private JLabel jlbNewsStoryNewsMaker2 = new JLabel("News Maker 2: ");
	JComboBox<String> jcbNewsStoryNewsMaker2 = new JComboBox<String>(newsDataBaseModel.getNewsMakerNames());
	private JPanel jpNewsStoryNewsMaker2 = new JPanel();
	//contents of length field
	private JLabel jlbNewsStoryLength = new JLabel("Length: ");
	private NumberFormat integerFieldFormatter = NumberFormat.getNumberInstance();
	JFormattedTextField jftfNewsStoryLength = new JFormattedTextField(integerFieldFormatter);
	private JPanel jplNewsStoryLength = new JPanel();
	//contents of year field
	private JLabel jlbNewsStoryYear = new JLabel("Year: ");
	private Integer[] years = {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
	JComboBox<Integer> jcbNewsStoryYear = new JComboBox<Integer>(years);
	private JPanel jplNewsStoryYear = new JPanel();
	//contents of month field
	private JLabel jlbNewsStoryMonth = new JLabel("Month: ");
	JComboBox<Month> jcbNewsStoryMonth = new JComboBox<Month>(Month.values());
	private JPanel jplNewsStoryMonth = new JPanel();
	//contents of day
	private JLabel jlbNewsStoryDay = new JLabel("Day: ");
	private Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
	JComboBox<Integer> jcbNewsStoryDay = new JComboBox<Integer>(days);
	private JPanel jplNewsStoryDay = new JPanel();
	//contents of PartOfDay field
	private JLabel jlbNewsStoryPartOfDay = new JLabel("Part of Day: ");
	JComboBox<PartOfDay> jcbNewsStoryPartOfDay = new JComboBox<PartOfDay>(PartOfDay.values());
	private JPanel jplNewsStoryPartOfDay = new JPanel();
	//panel for when details
	private JPanel jplNewsStoryWhen = new JPanel(new GridLayout(1, 4));
	//button to do everything
	JButton jbtAddEditNewsStory;
	//panel to contain button
	private JPanel jplAddEditNewsStory = new JPanel(new GridLayout(9, 1, 12, 12));
	
	public AddEditNewsStoryView(NewsDataBaseModel newsDataBaseModel, NewsStory newsStory) {
		this.newsDataBaseModel = newsDataBaseModel;
		this.newsStory = newsStory;
		
		jpNewsMediaType.add(jlbNewsMediaType);
		jpNewsMediaType.add(jcbNewsMediaType);
		
		jpNewsStorySource.add(jlbNewsStorySource);
		jpNewsStorySource.add(jcbNewsStorySource);
		
		jpNewsStoryTopic.add(jlbNewsStoryTopic);
		jpNewsStoryTopic.add(jcbNewsStoryTopic);
		
		jpNewsStorySubject.add(jlbNewsStorySubject);
		jpNewsStorySubject.add(jcbNewsStorySubject);
		
		jpNewsStoryNewsMaker1.add(jlbNewsStoryNewsMaker1);
		jpNewsStoryNewsMaker1.add(jcbNewsStoryNewsMaker1);
		
		jpNewsStoryNewsMaker2.add(jlbNewsStoryNewsMaker2);
		jpNewsStoryNewsMaker2.add(jcbNewsStoryNewsMaker2);
		
		jplNewsStoryLength.add(jlbNewsStoryLength);
		jplNewsStoryLength.add(jftfNewsStoryLength);
		
		jplNewsStoryYear.add(jlbNewsStoryYear);
		jplNewsStoryYear.add(jcbNewsStoryYear);
		
		jplNewsStoryMonth.add(jlbNewsStoryMonth);
		jplNewsStoryMonth.add(jcbNewsStoryMonth);
		
		jplNewsStoryDay.add(jlbNewsStoryDay);
		jplNewsStoryDay.add(jcbNewsStoryDay);
		
		jplNewsStoryPartOfDay.add(jlbNewsStoryPartOfDay);
		jplNewsStoryPartOfDay.add(jcbNewsStoryPartOfDay);
		
		jplNewsStoryWhen.add(jplNewsStoryYear);
		jplNewsStoryWhen.add(jplNewsStoryMonth);
		jplNewsStoryWhen.add(jplNewsStoryDay);
		jplNewsStoryWhen.add(jplNewsStoryPartOfDay);
		
		jplAddEditNewsStory.add(jbtAddEditNewsStory);
		
		add(jpNewsMediaType);
		add(jpNewsStorySource);
		add(jpNewsStoryTopic);
		add(jpNewsStorySubject);
		add(jpNewsStoryNewsMaker1);
		add(jpNewsStoryNewsMaker2);
		add(jplNewsStoryLength);
		add(jplNewsStoryWhen);
		add(jplAddEditNewsStory);
		
		if (newsStory == null) {
			jbtAddEditNewsStory.setText("Add News Story");
		}
		else {
			jbtAddEditNewsStory.setText("Edit News Story");
			
			if (newsStory instanceof NewspaperStory) {
				jcbNewsMediaType.setSelectedItem(NewsMedia.NEWSPAPER);
			}
			else if (newsStory instanceof TVNewsStory) {
				jcbNewsMediaType.setSelectedItem(NewsMedia.TV);
			}
			else if (newsStory instanceof OnlineNewsStory) {
				jcbNewsMediaType.setSelectedItem(NewsMedia.ONLINE);
			}
			
			jcbNewsStorySource.setSelectedItem(newsStory.getSource());
			jcbNewsStoryTopic.setSelectedItem(newsStory.getTopic());
			jcbNewsStorySubject.setSelectedItem(newsStory.getSubject());
			jcbNewsStoryNewsMaker1.setSelectedItem(newsStory.getNewsMaker1());
			jcbNewsStoryNewsMaker2.setSelectedItem(newsStory.getNewsMaker2());
			jcbNewsStoryYear.setSelectedItem(newsStory.getDate().getYear());
			jcbNewsStoryMonth.setSelectedItem(newsStory.getDate().getMonth());
			jcbNewsStoryDay.setSelectedItem(newsStory.getDate().getDayOfMonth());
			jcbNewsStoryPartOfDay.setSelectedItem(newsStory.getDate());
		}
	}
}
