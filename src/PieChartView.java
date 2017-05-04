import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Alex Kloppenburg
 *
 */
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
	 * @author Alex Kloppenburg
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
	 * @author Alex Kloppenburg
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
	 * @author Alex Kloppenburg
	 * @return
	 */
	
	private List<Wedge> constructWedges(){
		
		//Gets number of total stories
		int numStoriesTotal = newsMakerModel.getNewsStoryListModel().size();
		
		//Creates a list to hold only the types selected
		NewsStoryListModel selectedList = new NewsStoryListModel();
		
		/*
		 * Iterates through the list of NewsMedia enums and adds all the stories of that type to the list of desired
		 * stories, similar to what was done in TextView
		 */
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
		
		if("something".equals(actionEvent.getActionCommand())){
			//make it update itself (not sure how)????
		}
		
	}
	
	//TODO test main, delete leter
	public static void main(String[] args){
		List<NewsMedia> testList = new ArrayList<NewsMedia>();
		testList.add(NewsMedia.TV);
		
		PieChartView test = new PieChartView(null, testList, NewsContent.SOURCE, NewsMetric.LENGTH);
		
		System.out.print(test.constructTitle());
	}
	
}
