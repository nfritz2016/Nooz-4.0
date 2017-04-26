import java.awt.GridLayout;
import java.io.Serializable;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddEditNewsStoryView extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	private NewsDataBaseModel newsDataBaseModel = new NewsDataBaseModel();
	private NewsStory newsStory = new NewsStory();
	//contents for type
	private JLabel jlbNewsMediaType = new JLabel("Type: ");
	JComboBox<NewsMedia> jcbNewsMediaType = new JComboBox<NewsMedia>();
	private JPanel jpNewsMediaType = new JPanel();
	//contents for source
	private JLabel jlbNewsStorySource = new JLabel("Source: ");
	JComboBox<String> jcbNewsStorySource = new JComboBox<String>();
	private JPanel jpNewsStorySource = new JPanel();
	//contents for topic
	private JLabel jlbNewsStoryTopic = new JLabel("Topic: ");
	JComboBox<String> jcbNewsStoryTopic = new JComboBox<String>();
	private JPanel jpNewsStoryTopic = new JPanel();
	//contents of subject
	private JLabel jlbNewsStorySubject = new JLabel("Subject: ");
	JComboBox<String> jcbNewsStorySubject = new JComboBox<String>();
	private JPanel jpNewsStorySubject = new JPanel();
	//contents of NewsMaker1
	private JLabel jlbNewsStoryNewsMaker1 = new JLabel("News Maker 1: ");
	JComboBox<String> jcbNewsStoryNewsMaker1 = new JComboBox<String>();
	private JPanel jpNewsStoryNewsMaker1 = new JPanel();
	//contents of NewsMaker2
	private JLabel jlbNewsStoryNewsMaker2 = new JLabel("News Maker 2: ");
	JComboBox<String> jcbNewsStoryNewsMaker2 = new JComboBox<String>();
	private JPanel jpNewsStoryNewsMaker2 = new JPanel();
	//contents of length field
	private JLabel jlbNewsStoryLength = new JLabel("Length: ");
	private NumberFormat integerFieldFormatter = NumberFormat.getNumberInstance();
	JFormattedTextField jftfNewsStoryLength = new JFormattedTextField(integerFieldFormatter);
	private JPanel jplNewsStoryLength = new JPanel();
	//contents of year field
	private JLabel jlbNewsStoryYear = new JLabel("Year: ");
	private Integer[] years;
	JComboBox<Integer> jcbNewsStoryYear = new JComboBox<Integer>();
	private JPanel jplNewsStoryYear = new JPanel();
	//contents of month field
	private JLabel jlbNewsStoryMonth = new JLabel("Month: ");
	JComboBox<Month> jcbNewsStoryMonth = new JComboBox<Month>();
	private JPanel jplNewsStoryMonth = new JPanel();
	//contents of day
	private JLabel jlbNewsStoryDay = new JLabel("Day: ");
	private Integer[] days;
	JComboBox<Integer> jcbNewsStoryDay = new JComboBox<Integer>();
	private JPanel jplNewsStoryDay = new JPanel();
	//contents of PartOfDay field
	private JLabel jlbNewsStoryPartOfDay = new JLabel("Part of Day: ");
	JComboBox<PartOfDay> jcbNewsStoryPartOfDay = new JComboBox<PartOfDay>();
	private JPanel jplNewsStoryPartOfDay = new JPanel();
	//panel for when details
	private JPanel jplNewsStoryWhen = new JPanel(new GridLayout(1, 4));
	//button to do everything
	JButton jbtAddEditNewsStory = new JButton("Test");
	//panel to contain EVERYTHING
	private JPanel jplAddEditNewsStory = new JPanel(new GridLayout(9, 1, 12, 12));
	
	public AddEditNewsStoryView(/*NewsDataBaseModel newsDataBaseModel, NewsStory newsStory*/) {
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
	}
}
