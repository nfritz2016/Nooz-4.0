import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

/**
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 */
public class NoozFileProcessor 
{
	/** The list of news makers.*/
	private static NewsMakerList newsMakers;

	public static NewsMakerList readNoozFile(String fileName, 
											 Map<String, String> sourceMap,
											 Map<String, String> topicMap,
											 Map<String, String> subjectMap) 
											 throws IOException {
		return null;
	}

	public static void writeNewsStoriesFile(String fileName, 
											String listOfStories) 
											throws IOException {
	}


	private static void processLine(String line,
			 						Map<String, String> sourceMap,
			 						Map<String, String> topicMap,
			 						Map<String, String> subjectMap) {
	}

	private static LocalDate decodeDate(String dateString) {
		return null; //TODO return null
	}


	private static int decodeLength(String lengthString) {
		return 0; //TODO revert return
	}


	private static String decodeNewsmakerName(String[] parts, int startingIndex) {
		return null; //TODO revert return
	}

	private static PartOfDay decodePartOfDay(String partOfDayCode) {
		return null; //TODO revert return
	}
}
