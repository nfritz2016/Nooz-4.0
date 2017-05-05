/**
 * @author Nathan Fritz - 113294199
 * @author Alex Kloppenburg - 113388722
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 */
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
