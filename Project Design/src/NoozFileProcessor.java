import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;


/**
 * NoozFileProcessor object will process files used within the program.
 *
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 *
 */
public class NoozFileProcessor 
{
	/** The list of news makers.*/
	private static NewsMakerList newsMakers;

	/**
	 * Takes in a file of news stories and converts 
	 * it into a list of NewsMakers.
	 *  
	 * @param fileName
	 * 				The name of the file to be read.
	 * @param sourceMap
	 * 				The map of the story sources.
	 * @param topicMap
	 * 				The map of the story topics.
	 * @param subjectMap
	 * 				The map of the story subjects.
	 * @return The list of news makers.
	 * @throws IOException if the file does not exist.
	 */
	public static NewsMakerList readNoozFile(String fileName, 
											 Map<String, String> sourceMap,
											 Map<String, String> topicMap,
											 Map<String, String> subjectMap) 
											 throws IOException {
		return null;
	}

	/**
	 * A method to write a list of stories into a new file.
	 * 
	 * @param fileName
	 * 				The name of the new file.
	 * @param listOfStories
	 * 				The list of stories to write in the file.
	 * @throws IOException
	 */
	public static void writeNewsStoriesFile(String fileName, 
											String listOfStories) 
											throws IOException {
	}

	
	/**
	 * A method that turns each line from a nooz file into usable data.
	 * Each line will be broken into parts and decoded.
	 * 
	 * @param line
	 * 				The line to process.
	 * @param sourceMap
	 * 				The map of story sources.
	 * @param topicMap
	 * 				The map of story topics.
	 * @param subjectMap
	 * 				The map of story subjects.
	 */
	private static void processLine(String line,
			 						Map<String, String> sourceMap,
			 						Map<String, String> topicMap,
			 						Map<String, String> subjectMap) {
	}

	/**
	 * A method to decode the date of each story.
	 * 
	 * @param dateString
	 * 				The encoded date.
	 * @return The decoded date.
	 */
	private static LocalDate decodeDate(String dateString) {
		return null; //TODO return null
	}


	/**
	 * A method to decode the length of each story.
	 * @param lengthString
	 * 				The String version of the length.
	 * @return The int version of the length.
	 */
	private static int decodeLength(String lengthString) {
		return 0; //TODO revert return
	}


	/**
	 * A method to decode news maker names.
	 * @param parts
	 * 				The array of the line parts.
	 * @param startingIndex
	 * 				The index which starts the news maker's name.
	 * @return
	 */
	private static String decodeNewsmakerName(String[] parts, int startingIndex) {
		return null; //TODO revert return
	}

	/**
	 * A method to decode the part of day for each news story.
	 * Only TV and Online news stories will have a part of day code
	 * in the line.
	 * 
	 * @param partOfDayCode
	 * 				The String version of the part of day.
	 * @return The enum version of the part of day.
	 */
	private static PartOfDay decodePartOfDay(String partOfDayCode) {
		return null; //TODO revert return
	}
}
