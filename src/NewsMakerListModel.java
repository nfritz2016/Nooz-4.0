import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;

/**
 * @author Nathan Fritz
 *
 */
public class NewsMakerListModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private DefaultListModel<NewsMakerModel> newsMakerDefaultListModel = new DefaultListModel<NewsMakerModel>();
	
	public NewsMakerListModel() {
		//empty constructor
	}
	
	public NewsMakerListModel(NewsMakerListModel newsMakerListModel) {
		this.newsMakerDefaultListModel.clear();
		for (int i = 0; i < newsMakerListModel.size(); i++) {
			newsMakerDefaultListModel.addElement(newsMakerListModel.get(i));
		}
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
		
		//linear searches through the list and returns the first newsMaker that has a name that exactly matches the given string
		for (int i = 0; i < newsMakerDefaultListModel.size(); ++i) {
			if (newsMakerDefaultListModel.get(i).getName().equals(newsMakerName)) {
				return new NewsMakerModel(newsMakerName);
			}
		}
		
		/*
		 * If the exact match is not found the linear search won't do anything, so we do what we did in the last project and return 
		 * null once the search is done 
		 */
		return null;
	}
	
	public NewsMakerModel getPartialMatch(String newsMakerName){
		
		//linear searches through the list and returns the first newsMaker that has a name that contains the given string
		for (int i = 0; i < newsMakerDefaultListModel.size(); ++i) {
			if (newsMakerDefaultListModel.get(i).getName().contains(newsMakerName)) {
				return new NewsMakerModel(newsMakerName);
			}
		}
		
		/*
		 * If the partial match is not found the linear search won't do anything, so we do what we did in the last project and return 
		 * null once the search is done 
		 */
		return null;
	}
	
	public DefaultListModel<NewsMakerModel> getNewsMakers() {
		return this.newsMakerDefaultListModel;
	}
	
	public NewsMakerModel get(int index) {
		return this.newsMakerDefaultListModel.getElementAt(index);
	}
	
	public NewsMakerModel get(NewsMakerModel newsMakerModel){
		return this.newsMakerDefaultListModel.getElementAt(this.newsMakerDefaultListModel.indexOf(newsMakerModel));
	}
	
	public String[] getNewsMakerNames() {
		String[] names = new String[this.newsMakerDefaultListModel.size()];
		for (int i = 0; i < this.newsMakerDefaultListModel.size(); i++) {
			names[i] = this.newsMakerDefaultListModel.getElementAt(i).getName();
		}
		return names;
	}
	
	public void add(NewsMakerModel newsMakerModel) {
		this.newsMakerDefaultListModel.addElement(newsMakerModel);
	}
	
	public void replace(NewsMakerModel newsMakerModel) {
		if (this.newsMakerDefaultListModel.contains(newsMakerModel)) {
			this.newsMakerDefaultListModel.set(this.newsMakerDefaultListModel.indexOf(newsMakerModel), newsMakerModel);
		}
	}
	
	public void remove(NewsMakerModel newsMakerModel) {
		this.newsMakerDefaultListModel.remove(this.newsMakerDefaultListModel.indexOf(newsMakerModel));
	}
	
	public void removeListOfNewsMakers(DefaultListModel<NewsMakerModel> newsMakers) {
		for (int i = 0; i < newsMakers.getSize(); i++) {
			for(int j = 0; j < newsMakers.get(i).getNewsStoryListModel().size(); ++j){
				this.newsMakerDefaultListModel.get(this.newsMakerDefaultListModel.indexOf(newsMakers.get(i))).
					getNewsStoryListModel().get(j).setNewsMaker1(new NewsMakerModel());
				this.newsMakerDefaultListModel.get(this.newsMakerDefaultListModel.indexOf(newsMakers.get(i))).
				getNewsStoryListModel().get(j).setNewsMaker2(new NewsMakerModel());
			}
			this.newsMakerDefaultListModel.remove(this.newsMakerDefaultListModel.indexOf(newsMakers.get(i)));
		}
		
	}
	
	public void removeAllNewsMakers() {
		for(int i = 0; i < this.size(); ++i){
			for(int j = 0; j < this.get(i).getNewsStoryListModel().size(); ++j){
				this.get(i).getNewsStoryListModel().get(j).setNewsMaker1(new NewsMakerModel());
				this.get(i).getNewsStoryListModel().get(j).setNewsMaker2(new NewsMakerModel());
			}
		}
		this.newsMakerDefaultListModel.clear();
	}
	
	public void setNewsMakersFromNewsMakerList(NewsMakerListModel newsMakerListModel) {
		this.newsMakerDefaultListModel.clear();
		for (int i = 0; i < newsMakerListModel.size(); i++) {
			this.newsMakerDefaultListModel.addElement(newsMakerListModel.get(i));
		}
	}
	
	public void sort() {
		//TODO unsure on how correct this is
		NewsMakerModel[] sortingArray = new NewsMakerModel[this.newsMakerDefaultListModel.size()];
		
		for(int i = 0; i < this.newsMakerDefaultListModel.size(); ++i){
			sortingArray[i] = (NewsMakerModel)this.newsMakerDefaultListModel.get(i);
		}
		
		Arrays.sort(sortingArray);
		this.newsMakerDefaultListModel.clear();
		
		for(int i = 0; i < sortingArray.length; ++i){
			this.newsMakerDefaultListModel.addElement(sortingArray[i]);
		}
		
	}
}
