/**
 * @author Alex Kloppenburg
 * @author Nathan Fritz
 * @author Cavan Gary
 * @author Joe Pauly
 */
//class created by alex 4/25
//all fields created by alex 4/25
//initialized by Cavan 5/2
public class NoozDriver {
	
	/**
	 * 
	 */
	private static NewsDataBaseModel newsDataBaseModel;
	
	/**
	 * 
	 */
	private static SelectionView selectionView = new SelectionView();
	
	/**
	 * 
	 */
	private static NewsController newsController = new NewsController();
	
	/**
	 * @author Alex Kloppenburg
	 * @author Nathan Fritz
	 * @author Cavan Gary
	 * @author Joe Pauly
	 */
	public static void main(String[] args){
		
		newsDataBaseModel = new NewsDataBaseModel();
		selectionView.setNewsDataBaseModel(newsDataBaseModel);
		newsController.setNewsDataBaseModel(newsDataBaseModel);
		newsController.setSelectionView(selectionView);
	}

}
