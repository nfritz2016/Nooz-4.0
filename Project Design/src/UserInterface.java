import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;


/**
 * The UserInterface object will allow for interaction
 * between the user and the program.
 * 
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 *
 */
public class UserInterface
{
	/**
	 * Method enables asking a question that allows
	 * for a single response. The method should check
	 * that the response is valid.
	 * 
	 * @param message
	 * 				The question to ask.
	 * @param options
	 * 				The valid response options.
	 * @return The String format of the response.
	 * @throws IOException if the response is not valid.
	 */
	public static String querySingleChoice(String message, String[] options) throws IOException {
		return null; //TODO revert null
	}
	
	/**
	 * Method enables asking a question that allows
	 * for a multiple responses. The method should check
	 * that the responses are valid.
	 * 
	 * @param message
	 * 				The question to ask.
	 * @param options
	 * 				The valid response options.
	 * @return The String format of the response.
	 * @throws IOException if the response is not valid.
	 */
	public static String queryMultipleChoices(String message, String[] options) throws IOException {
		return null; //TODO revert null
	}
	
	/**
	 * Method enables asking for the news maker name to be searched.
	 * 
	 * @param matchType
	 * 				The user can search by exact or partial match.
	 * @return the name, exact or partial, or the news maker.
	 * @throws IOException if there is no name matched.
	 */
	public static String queryNewsMakerName(String matchType) throws IOException {
		return null; //TODO revert null
	}
	
	/**
	 * Method enables asking for the order of parameters to sort the news story list.
	 *
	 * @param sortCriteria
	 * 				The hierarchy of sorting criteria.
	 * @return the criterion to add to the hierarchy.
	 * @throws IOException if the criterion does not match options.
	 */
	public static String querySortCriterion(String[] sortCriteria) throws IOException {
		return null; //TODO revert null
	}
	
	/**
	 * Method enables asking for a file name to either read or write.
	 * 
	 * @param message
	 * 				Question to ask the user.
	 * @param mustExist
	 * 				Tells method if the file must be found.
	 * @return the name of the file.
	 * @throws IOException if the file does not exist.
	 */
	public static String queryFileName(String message, boolean mustExist) throws IOException {
		return null; //TODO revert null
	}
	
	/**
	 * Creates a String of news stories with a particular output
	 * depending on the media type and sorting criteria. The method
	 * will call on an additional method to convert each individual story
	 * to a String.
	 * 
	 * @param newsMaker
	 * 				The news maker to create the list of news story.
	 * @param mediaType
	 * 				The media type of stories searched for by user.
	 * @param sortCriteria
	 * 				The criteria requested for sorting the stories.
	 * @return the sorted list in a usable String.
	 */
	public static String createListOfNewsStoriesForNewsmaker(NewsMaker newsMaker, 
														     String mediaType, 
														     String[] sortCriteria) {
		return null; //TODO revert null
	}
	
	/**
	 * Converts a single news story to a usable String.
	 * 
	 * @param newsStory
	 * 				The story to be converted.
	 * @param mediaType
	 * 				The media type requested by the user.
	 * @return the String of the news story.
	 */
	private static String convertToOutputFormat(NewsStory newsStory, String mediaType) {
		return null; //TODO revert null
	}
	
	public static void presentNewspaperStories(String listOfStories, String newsMakerName) {
	}
	
	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker) { 	
	}
	
	public static void displayPieChartForNewsMaker(NewsMaker newsMaker, 
												   String mediaType, 
												   String content, 
												   String measure) {	
	}
}
