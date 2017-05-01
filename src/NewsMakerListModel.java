import java.io.Serializable;

import javax.swing.DefaultListModel;

/**
 * @author Nathan Fritz
 *
 */
public class NewsMakerListModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private DefaultListModel<NewsMakerModel> newsMakerDefaultListModel = new DefaultListModel<NewsMakerModel>();
	
	public NewsMakerListModel() {
		
	}
	
	public NewsMakerListModel(NewsMakerListModel newsMakerListModel) {
		//TODO
	}
	
	public boolean isEmpty() {
		return this.newsMakerDefaultListModel.isEmpty();
	}
	
	public int size() {
		return this.newsMakerDefaultListModel.getSize();
	}
	
	public boolean contains(NewsMakerModel newsMakerModel) {
		return this.newsMakerDefaultListModel.contains(newsMakerModel);
	}
	
	public NewsMakerModel getExactMatch(String newsMakerName) {
		return null;
		//TODO
	}
	
	public NewsMakerModel getPartialMatch(String newsMakerName) {
		return null;
		//TODO
	}
	
	public DefaultListModel<NewsMakerModel> getNewsMakers() {
		return this.newsMakerDefaultListModel;
	}
	
	public NewsMakerModel get(int index) {
		return this.newsMakerDefaultListModel.getElementAt(index);
	}
	
	public String[] getNewsMakerNames() {
		return null;
	}
	
	public void add(NewsMakerModel newsMakerModel) {
		this.newsMakerDefaultListModel.addElement(newsMakerModel);
	}
	
	public void replace(NewsMakerModel newsMakerModel) {
		if (this.newsMakerDefaultListModel.contains(newsMakerModel)) {
			
		}
	}
	
	public void remove(NewsMakerModel newsMakerModel) {
		this.newsMakerDefaultListModel.remove(this.newsMakerDefaultListModel.indexOf(newsMakerModel));
	}
	
	public void removeListOfNewsMakers(DefaultListModel<NewsMakerModel> newsMakers) {
		for (int i = 0; i < newsMakers.getSize(); i++) {
			this.newsMakerDefaultListModel.remove(this.newsMakerDefaultListModel.indexOf(newsMakers.get(i)));
		}
	}
	
	public void removeAllNewsMakers() {
		this.newsMakerDefaultListModel.clear();
	}
	
	public void setNewsMakersFromNewsMakerList(NewsMakerListModel newsMakerListModel) {
		//TODO
	}
	
	public void sort() {
		//TODO
	}
}
