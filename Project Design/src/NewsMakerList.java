import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 */
public class NewsMakerList implements Serializable {
	/**The Serial UID.*/
	private static final long serialVersionUID = 1L;
	
	/** The list of news makers.*/
	private List<NewsMaker> newsMakers;
	
	/** Keeps track if the news maker list is sorted */
	private boolean sorted;

	/**
	 * The no-argument constructor initializes the list to be an empty
	 * ArrayList.
	 */
	public NewsMakerList() {
	}

	/**
	 * The mutator for adding news makers to the list.
	 * 
	 * @param newsMaker
	 *            The news maker to add to the list.
	 * @throws IllegalArgumentException
	 *             If the news maker to add is already in the list.
	 */
	void add(NewsMaker newsMaker) {
	}

	/**
	 * An accessor method to test whether the list already contains a certain news maker.
	 * 
	 * @param newsMaker
	 *            The news maker searched.
	 * @return The boolean value true if the news maker is in the list, false otherwise.
	 */
	public boolean contains(NewsMaker newsMaker) {
		return false; //TODO revert return
	}

	/**
	 * An accessor method to get a news maker from the list.
	 * 
	 * @param newsMaker
	 *            The news maker to get from the list.
	 * @return The news maker found or null.
	 */
	public NewsMaker get(NewsMaker newsMaker) {
		return null; //TODO revert return
	}

	/**
	 * An accessor method to get a news maker from the list based on the exact
	 * name provided. If the list is sorted use binary search. If the list is not
	 * sorted, use a linear search and warn user that the list was unsorted.
	 * @param newsMakerName
	 *            The exact name for which to search.
	 * @return The news maker found or null.
	 */
	public NewsMaker getExactMatch(String newsMakerName) {
		return null; //TODO revert return
	}

	/**
	 * An accessor method to get a news maker from the list. A full match of the name
	 * does not have to be made.
	 * 
	 * @param newsMakerName
	 *            The exact name for which to search.
	 * @return The news maker found or null.
	 */
	public NewsMaker getPartialMatch(String newsMakerName) {
		return null; //TODO revert return
	}

	/**
	 * The sort method for the class. After sorting, the sorted field for the arrayList will
	 * be true.
	 */
	public void sort() {
	}
}
