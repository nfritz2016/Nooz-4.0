import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/21
//all fields created by alex 4/21
public class PieChartView implements ActionListener{
	
	/**
	 * 
	 */
	private PieChart pieChart;
	
	/**
	 * 
	 */
	private NewsMakerModel newsMakerModel;
	
	/**
	 * 
	 */
	private List<NewsMedia> media;
	
	/**
	 * 
	 */
	private NewsContent content;
	
	/**
	 * 
	 */
	private NewsMetric measure;
	
	/**
	 * 
	 * @param newsMakerModel
	 * @param media
	 * @param content
	 * @param measure
	 */
	//created by alex 4/21
	//method body written by alex 4/22
	public PieChartView(NewsMakerModel newsMakerModel, List<NewsMedia> media, NewsContent content, NewsMetric measure){
		//TODO look at the UML and such and figure out what else needs to be done here/if this is correct
		this.newsMakerModel = newsMakerModel;
		this.media = media;
		this.content = content;
		this.measure = measure;
		
		String title = constructTitle();
		List<Wedge> wedges = constructWedges();
		
		this.pieChart = new PieChart(title, wedges);
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/21
	//written by alex 4/30
	public String constructTitle(){
		String title = "Pie Chart of " ;
		
		for(int i = 0; i < media.size(); ++i){
			title += media.get(i).toString() + " News Stories " + " and ";
		}
		
		title = title.substring(0, title.length() - 5);
		
		title += "Sorted by " + content.toString() + " (words or word equivalents)";
		
		return title;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/21
	private List<Wedge> constructWedges(){
		int numStoriesTotal = newsMakerModel.getNewsStoryListModel().size();
		NewsStoryListModel selectedList = new NewsStoryListModel();
		
		for(int index = 0; index < media.size(); ++index){
			if(media.get(index) == NewsMedia.NEWSPAPER){
				for(int i = 0; i < numStoriesTotal; ++i){
					if(newsMakerModel.getNewsStoryListModel().get(i) instanceof NewspaperStory){
						selectedList.add(newsMakerModel.getNewsStoryListModel().get(i));
					}
				}
			}
			if(media.get(index) == NewsMedia.ONLINE){
				for(int i = 0; i < numStoriesTotal; ++i){
					if(newsMakerModel.getNewsStoryListModel().get(i) instanceof OnlineNewsStory){
						selectedList.add(newsMakerModel.getNewsStoryListModel().get(i));
					}
				}
			}
			if(media.get(index) == NewsMedia.TV){
				for(int i = 0; i < numStoriesTotal; ++i){
					if(newsMakerModel.getNewsStoryListModel().get(i) instanceof TVNewsStory){
						selectedList.add(newsMakerModel.getNewsStoryListModel().get(i));
					}
				}
			}
		}
		
		List<Wedge> wedgeList = new ArrayList<Wedge>();
		double parts = selectedList.size();
		for (int i = 0; i < (int) parts; i++) {
			wedgeList.add(new Wedge(100.0 / parts, "Label"));
		}
		return wedgeList;
	}
	
	/**
	 * 
	 * @param actionEvent
	 */
	//created by alex 4/21
	public void actionPerformed(ActionEvent actionEvent){
		
		
		
	}
	
	//TODO test main, delete leter
	public static void main(String[] args){
		List<NewsMedia> testList = new ArrayList<NewsMedia>();
		testList.add(NewsMedia.TV);
		
		PieChartView test = new PieChartView(null, testList, NewsContent.SOURCE, NewsMetric.LENGTH);
		
		System.out.print(test.constructTitle());
	}
	
}
