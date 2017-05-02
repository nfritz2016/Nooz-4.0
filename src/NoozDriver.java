/**
 * 
 * @author Alex
 * @author Nathan Fritz
 *
 */
//class created by alex 4/25
//all fields created by alex 4/25
public class NoozDriver {
	
	/**
	 * 
	 */
	private static NewsDataBaseModel newsDataBaseModel;
	
	/**
	 * 
	 */
	private static SelectionView selectionView;
	
	/**
	 * 
	 */
	private static NewsController newsController;
	
	/**
	 * 
	 * @param args
	 */
	//created by alex 4/25
	public static void main(String[] args){
		
		newsDataBaseModel = new NewsDataBaseModel();
		selectionView.setNewsDataBaseModel(newsDataBaseModel);
		newsController.setNewsDataBaseModel(newsDataBaseModel);
		newsController.setSelectionView(selectionView);
	}

}
