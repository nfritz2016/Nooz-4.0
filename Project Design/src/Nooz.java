import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Nooz class is the driver class for the program.
 * 
 * @author Nathan Fritz - 113294199
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 *
 */
public class Nooz {
	/** List of news makers */
	private static NewsMakerList newsMakers;
	
	/** Map of story sources */
	private static Map<String, String> sourceMap;
	
	/** Map of story topics */
	private static Map<String, String> topicMap;
	
	/** Map of story subjects */
	private static Map<String, String> subjectMap;
	
	/**
	 * Controls the operations of the program.
	 * 
	 * @param args
	 * 			 The program arguments are not used in this program.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	}
	
	/**
	 * A method to enable data loading outside of the main method.
	 * 
	 */
	private static void loadData() {	
	}
	
	/**
	 * A method to enable looping through the user interface queries.
	 * 
	 */
	private static void loopForUserQueries() {
	}

}
