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


public class UserInterface
{
	public static String querySingleChoice(String message, String[] options) throws IOException {
		return null; //TODO revert null
	}
	
	public static String queryMultipleChoices(String message, String[] options) throws IOException {
		return null; //TODO revert null
	}
	
	public static String queryNewsMakerName(String matchType) throws IOException {
		return null; //TODO revert null
	}
	
	public static String querySortCriterion(String[] sortCriteria) throws IOException {
		return null; //TODO revert null
	}
	
	public static String queryFileName(String message, boolean mustExist) throws IOException {
		return null; //TODO revert null
	}
	
	public static String createListOfNewsStoriesForNewsmaker(NewsMaker newsMaker, 
														     String mediaType, 
														     String[] sortCriteria) {
		return null; //TODO revert null
	}
	
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
