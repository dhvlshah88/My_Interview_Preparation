package codingchallenges;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Dhaval on 12/22/13.
 *
 * Steps:
 * 1) Reading the file line by line and passing the line as string to two functions. 
 * 2) These two functions namely "sortQueriesUsingRank" and "sortQueriesUsingScore" will sort the queries and create a hashmap of values respectively.
 * 3) Then createStringFromMapSortedByRank & createStringFromMapSortedByRank methods extract the values from these hashmap and create a string. 
 * 4) This string is passed as parameter to buffered writer to write onto the file.
 *
 *
 * Explanation: I will try to explain the approach I have used while solving this problem. I have used buffered reader and writer
 * to read the file, since this a better approach for reading and writing the file with greater size than the current file. I have used 
 * linked hashmap to store query name i.e. "seinfield" as key and all the associated queries details like url, rank and score in a 
 * tree map as their value. The idea behind using linked hashmap is that it maintains insertion order of keys, so while printing the 
 * output I always get same order in which I inserted the keys. Now the treemap is used to sort and store remaining queries details. 
 * One of tree map has rank as their key, so while inserting it is sorting in natural order. And the other tree map has score as 
 * their key and it ordering is been reversed, so it sorts the score in reverse order. 
 * 
 * For last function that is to calculate average score of queries, I have calculated average score of queries associated with a query name.
 *
 */
public class SortQueries {

	private int lineNumber = 0;

	/**
	 * These variables are linked hash map with values as tree map. LinkedHashMap is used since it guarantees that the insertion 
	 * order of values is maintained. We will store the query name as a key (for example "seinfield") and tree map of all queries 
	 * tagged with that description as value.
	 */
	private static LinkedHashMap<String, TreeMap<Integer, ArrayList<String>>> queriesMapSortedByRank = new LinkedHashMap<String, TreeMap<Integer, ArrayList<String>>>();
	
	private static LinkedHashMap<String, TreeMap<Integer, ArrayList<String>>> queriesMapSortedByScore = new LinkedHashMap<String, TreeMap<Integer, ArrayList<String>>>();
	
	/**
	 * This variable is tree map with key as integer and values as array list of string objects. TreeMap is used to sort the 
	 * queries according to their rank. We will store the rank as key and remaining values like url and score in an array list.
	 */
	private static TreeMap<Integer, ArrayList<String>> mapSortedByRank = null;
	
	/**
	 * Below given variable is tree map with key as integer and values as array list of string objects. TreeMap is used to sort the 
	 * queries according to their rank. We will store the rank as key and remaining values like url and score in an array list.
	 */
	private static TreeMap<Integer, ArrayList<String>> mapSortedByScore = null;
	
	
	
	/**
	 * Reads the tsv file using {@link BufferedReader} and send that line as parameter to {@link SortQueries#sortQueriesUsingRank(String)} 
	 * and {@link SortQueries#sortQueriesUsingScore(String, HashMap)} methods of {@link SortQueries}.
	 * 
	 * @param inputFilePath A input file path object.
	 * @param charset A valid charset.
	 */
	private void readFileAndSortValues(Path inputFilePath, Charset charset, HashMap<String, Integer> scoreMap)
	{
		/** Substitute for logging*/
		System.out.println("Logging: QueryRanking.readFileAndSortValues()");
		
		/**This condition checks whether file path instance is null, if yes then prints error message and returns null.*/
		if(inputFilePath == null)
		{
			System.out.println("Error: Please specify input file's path!");
			return;
		}
		
		/** This condition checks if the charset is null or not registered. If its null or not registered, it prints an
		 * error message and returns 
		 */
		if(charset == null)
		{
			System.out.println("Please specify a valid charset!");
			return;
		}
		
		if(!charset.isRegistered())
		{
			System.out.println("Please specify a registered charset!");
			return;
		}
		
		/** This condition check if the scoreMap is null or zero sized. If it is either, it prints an error message and
		 * returns; 
		 */
		if(scoreMap == null || scoreMap.size() == 0)
		{
			System.out.println("Please specify a score map!");
			return;
		}

		/**
		 * Below code creates a buffered reader to read file line by line. Since we are using try with resource statement it closes the reader
		 * at the end of statement.
		 */
		try (BufferedReader reader = Files.newBufferedReader(inputFilePath, charset)){

			String line = null;
			while((line = reader.readLine()) != null) {
				++lineNumber;
				sortQueriesUsingRank(line);
				sortQueriesUsingScore(line, scoreMap);
			}
		}
		catch(IOException ex)
		{
			System.err.format("IOException: %s%n", ex);
			ex.printStackTrace();
		}
		catch (SecurityException ex) {
			System.err.format("SecurityException: %s%n", ex);
			ex.printStackTrace();
		}
		catch (Exception ex) 
		{
			System.err.format("Exception: %s%n", ex);
			ex.printStackTrace();
		}
	}

	/**
	 * Receives query string from {@link SortQueries#readFileAndSortValues(Path, Charset)}, fill's {@link LinkedHashMap} and sort 
	 * queries according their rank.
	 * 
	 * @param filePath A file's path object.
	 * 
	 * @return linked hash map with sorted queries.
	 */
	private void sortQueriesUsingRank(String line)
	{
		/** Substitute for logging*/
		System.out.println("Logging: QueryRanking.sortQueriesUsingRank()");

		/** This condition check whether line is null or empty. If its then, print an error message and returns. */
		if(line == null || line.isEmpty())
		{
			System.out.println("String parameter is either null or empty!");
			return;	
		}

		/**Split the line on regex for tab.*/
		String[] listOfWords = line.split("\t");

		/**
		 * This condition checks whether line the contains four words per line as well as file contains tab separated values, if no 
		 * then prints error message and returns null.
		 */
		if(listOfWords.length < 4)
		{
			System.out.println("Number of words is less than 4 at line number " + lineNumber);
			System.out.println("Or file doesn't contains tab separated values!!");
			return;
		}

		/** This condition check whether the rank value is integer. If not print error message and returns null.*/
		if(!listOfWords[2].matches(".*\\d.*"))
		{
			System.out.println("Rank value is not an integer value.");
			return;
		}

		/*Query queryObj = new Query();
				queryObj.setName(listOfWords[0]);
				queryObj.setUrl(listOfWords[1]);
				queryObj.setRank(Integer.parseInt(listOfWords[2]));
				queryObj.setScore(listOfWords[3]);*/

		/**
		 * This condition checks whether the query name in current line is already present in the hash map. If not, insert the 
		 * new query name and create an instance of tree map to hold query values associated to that query name. 
		 */
		if(!queriesMapSortedByRank.containsKey(listOfWords[0]))
		{
			mapSortedByRank = new TreeMap<Integer, ArrayList<String>>();
			queriesMapSortedByRank.put(listOfWords[0], mapSortedByRank);
		}

		/** Add remaining words in an array list*/
		ArrayList<String> remainingWords = new ArrayList<String>();
		remainingWords.add(listOfWords[1]);
		remainingWords.add(listOfWords[3]);

		/** Add the query rank as key and array list of remaining values as value*/
		mapSortedByRank.put(Integer.parseInt(listOfWords[2]), remainingWords);

	}

	/**
	 * Receives query string from {@link SortQueries#readFileAndSortValues(Path, Charset)}, fill's {@link LinkedHashMap} and sort 
	 * queries according their score.
	 * 
	 * @param filePath A file's path object.
	 * @param scoreMap A hash map containing scores. Score type as key and its associate score as value.
	 * 
	 * @return linked hash map with sorted queries.
	 */
	private void sortQueriesUsingScore(String line, HashMap<String, Integer> scoreMap)
	{
		/** Substitute for logging*/
		System.out.println("Logging: QueryRanking.sortQueriesUsingScore()");
		
		/** This condition check whether line is null or empty. If its then, print an error message and returns. */
		if(line == null || line.isEmpty())
		{
			System.out.println("String parameter is either null or empty!");
			return;	
		}

		/**Split the line on regex for tab.*/
		String[] listOfWords = line.split("\t");

		/**
		 * This condition checks whether line the contains four words per line as well as file contains tab separated values or not. If not, 
		 * prints an error message and returns null.
		 */
		if(listOfWords.length < 4)
		{
			System.out.println("Number of words is less than 4 at line number " + lineNumber);
			System.out.println("Or file doesn't contains tab separated values!!");
			return;
		}

		/**
		 * This condition checks whether the query name in current line is already present in the hash map or not. If not, insert the 
		 * new query name and create an instance of tree map to hold query values associated to that query name. And order 
		 * of values in tree map is reversed to sort according to their score.
		 */
		if(!queriesMapSortedByScore.containsKey(listOfWords[0]))
		{
			mapSortedByScore = new TreeMap<Integer, ArrayList<String>>(Collections.reverseOrder());
			queriesMapSortedByScore.put(listOfWords[0], mapSortedByScore);
		}

		/** Add remaining words in an array list */
		ArrayList<String> remainingWords = new ArrayList<String>();
		remainingWords.add(listOfWords[1]);
		remainingWords.add(listOfWords[2]);
		remainingWords.add(listOfWords[3]);

		/** Add the query score from scoreMap as key and array list of remaining values as value. Also I am adding query's score type 
		 * in the above array list, so I don't need to fetch it from scoreMap. */
		mapSortedByScore.put(scoreMap.get(listOfWords[3]), remainingWords);
	}

	/**
	 * Generates a average score for each query.
	 * 
	 * @param queriesMap A sorted hashmap from {@link SortQueries#averageScorePerQuery(HashMap)} method.
	 * 
	 * @return linked hash map with average score per query.
	 */
	private LinkedHashMap<String, Integer> averageScorePerQuery(HashMap<String, TreeMap<Integer, ArrayList<String>>> queriesMap)
	{
		/** Substitute for logging*/
		System.out.println("Logging: QueryRanking.averageScorePerQuery()");
		
		/** This condition checks whether the queriesMap is null or not. If its then, prints an error message and returns null */
		if(queriesMap == null || queriesMap.size() == 0)
		{
			System.out.println("Hash is either null or empty!");
			return null;
		}
				
		LinkedHashMap<String, Integer> scoreMap = new LinkedHashMap<String, Integer>();

		/** Below code loops through queriesMap and calculates the average score per query */
		for(Map.Entry<String, TreeMap<Integer, ArrayList<String>>> entry : queriesMap.entrySet())
		{
			int averageScore = 0;
			for(Integer score : entry.getValue().keySet())
			{
				averageScore += score.intValue();
			}
			averageScore /= entry.getValue().size();
			
			//Insert a query name as key and associated score as value.
			scoreMap.put(entry.getKey(), averageScore);
		}

		return scoreMap;
	}

	
	
	/**
	 * Writes a tsv file from hashmap returned from {@link SortQueries#sortQueriesUsingRank(String)} method of 
	 * {@link SortQueries} class. 
	 * 
	 * @param sortedMap A sorted hashmap from {@link SortQueries#sortQueriesUsingRank(String)} method.
	 * @param outputFilePath Output file's path instance.
	 */
	private void createStringFromMapSortedByRank(HashMap<String, TreeMap<Integer, ArrayList<String>>> sortedMap, Path outputFilePath,  Charset charset)
	{
		/** Substitute for logging*/
		System.out.println("Logging: QueryRanking.createStringFromMapSortedByRank()");
		
		/** This condition checks if the hash map is null or not. If its null, then print an error message and returns */
		if(sortedMap == null || sortedMap.size() == 0)
		{
			System.out.println("Sorted hash map is either null or empty!");
			return;
		}
		
		/** This condition checks if the output file path instance is null or not. If it is then print a error 
		 * message and returns.
		 */
		if(outputFilePath == null)
		{
			System.out.println("Please specify an output file's path!");
			return;
		}
		
		/** This condition checks if the charset is null or not registered. If its null or not registered, it prints an
		 * error message and returns 
		 */
		if(charset == null)
		{
			System.out.println("Please specify a valid charset!");
			return;
		}

		if(!charset.isRegistered())
		{
			System.out.println("Please specify a registered charset!");
			return;
		}
		
		/** Instantiate a StringBuilder instance to append values from hash map and tabs to create a string */
		StringBuilder outputString = new StringBuilder();
		for(Map.Entry<String, TreeMap<Integer, ArrayList<String>>> entry : sortedMap.entrySet())
		{
			for (Map.Entry<Integer, ArrayList<String>> rankedEntry : entry.getValue().entrySet())
			{
				outputString.append(entry.getKey());
				outputString.append("\t");
				outputString.append(rankedEntry.getValue().get(0));
				outputString.append("\t");
				outputString.append(rankedEntry.getKey());
				outputString.append("\t");
				outputString.append(rankedEntry.getValue().get(1));
				outputString.append(System.lineSeparator());
			}
		}

		writeOutputToFile(outputString.toString(), outputFilePath, charset);
	}

	
	
	
	/**
	 * Writes a tsv file from hashmap returned from {@link SortQueries#sortQueriesUsingScore(String, HashMap)} method of 
	 * {@link SortQueries} class. 
	 * 
	 * @param sortedMap A sorted hashmap from {@link SortQueries#sortQueriesUsingScore(String, HashMap)} method.
	 * @param outputFilePath Output file's path instance.
	 */
	private void createStringFromMapSortedByScore(HashMap<String, TreeMap<Integer, ArrayList<String>>> sortedMap, Path outputFilePath, Charset charset)
	{
		/** Substitute for logging*/
		System.out.println("Logging: QueryRanking.createStringFromMapSortedByScore()");
		
		/** This condition checks if the hash map is null or not. If its null, then print an error message and return */
		if(sortedMap == null || sortedMap.size() == 0)
		{
			System.out.println("Sorted hashmap is either null or empty!");
			return;
		}

		/** This condition checks if the output file path instance is null or not. If its null, then print an error 
		 * message and return.
		 */
		if(outputFilePath == null)
		{
			System.out.println("Please specify an output file's path!");
			return;
		}
		
		/** This condition checks if the charset is null or not registered. If its null or not registered, it prints an
		 * error message and returns 
		 */
		if(charset == null || !charset.isRegistered())
		{
			System.out.println("Please specify a valid charset!");
			return;
		}
		
		/** Instantiate a StringBuilder instance to append values from hashmap and tabs to create a string */
		StringBuilder outputString = new StringBuilder();
		for(Map.Entry<String, TreeMap<Integer, ArrayList<String>>> entry : sortedMap.entrySet())
		{
			for (Map.Entry<Integer, ArrayList<String>> rankedEntry : entry.getValue().entrySet())
			{
				outputString.append(entry.getKey());
				outputString.append("\t");
				outputString.append(rankedEntry.getValue().get(0));
				outputString.append("\t");
				outputString.append(rankedEntry.getValue().get(1));
				outputString.append("\t");
				outputString.append(rankedEntry.getValue().get(2));
				outputString.append(System.lineSeparator());
			}
		}

		writeOutputToFile(outputString.toString(), outputFilePath, charset);
	}

	
	
	/**
	 * Writes a tsv file from string received from {@link SortQueries#createStringFromMapSortedByRank(HashMap, Path, Charset)} 
	 * or {@link SortQueries#createStringFromMapSortedByScore(HashMap, Path, Charset)} method of {@link SortQueries} class. 
	 * 
	 * @param output A output string
	 * @param outputFilePath A output file's path object
	 * @param charset A valid charset
	 */
	public void writeOutputToFile(String output, Path outputFilePath, Charset charset)
	{
		/** Substitute for logging*/
		System.out.println("Logging: QueryRanking.writeOutputToFile()");
		
		/** Instantiate a BufferedWriter object to write the string from StringBuilder object */
		try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset))
		{
			writer.write(output, 0, output.length());
		} 
		catch(IOException ex)
		{
			System.err.format("IOException: %s%n", ex);
			ex.printStackTrace();
		}
		catch (Exception ex) 
		{
			System.err.format("Exception: %s%n", ex);
			ex.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		SortQueries qr = new SortQueries();

		Path filePath = FileSystems.getDefault().getPath("resources", "Inputfile.tsv");
		Charset charset = Charset.forName("US-ASCII");
		
		HashMap<String, Integer> scoreMap = new HashMap<>();
		scoreMap.put("Perfect", new Integer(10));
		scoreMap.put("Excellent", new Integer(7));
		scoreMap.put("Good", new Integer(5));
		scoreMap.put("Fair", new Integer(3));
		scoreMap.put("Bad", new Integer(1));

		System.out.println("Test Case 1: File path not specified");
		qr.readFileAndSortValues(null, charset, scoreMap);
		System.out.println();
		
		System.out.println("Test Case 2: Charset not specified.");
		qr.readFileAndSortValues(filePath, null, scoreMap);
		System.out.println();
		
		System.out.println("Test Case 3: Unregistered charset specified.");
		qr.readFileAndSortValues(filePath, Charset.forName("x-IBM1006"), scoreMap);
		System.out.println();
						
		System.out.println("Test Case 4: scoreMap is null.");
		qr.readFileAndSortValues(filePath, charset, null);
		System.out.println();
		
		System.out.println("Test Case 5: scoreMap's size is zero.");
		qr.readFileAndSortValues(filePath, charset, new HashMap<String, Integer>());
		System.out.println();
		
		System.out.println("Test Case 6: Null value provided to createStringFromMapSortedByRank in place of sorted hash map.");
		qr.createStringFromMapSortedByRank(null, filePath, charset);
		System.out.println();
		
		System.out.println("Test Case 7: Null value provided to averageScorePerQuery");
		qr.averageScorePerQuery(null);
		System.out.println();
		
		System.out.println("Test Case 8: Zero sized hashmap provided to averageScorePerQuery");
		qr.averageScorePerQuery(new HashMap<String, TreeMap<Integer, ArrayList<String>>>());
		System.out.println();
		
		System.out.println("Test Case 9: Everything is provided.");
		qr.readFileAndSortValues(filePath, charset, scoreMap);
		filePath =  FileSystems.getDefault().getPath("resources", "Outputfile.tsv");
		qr.createStringFromMapSortedByRank(queriesMapSortedByRank, filePath, charset);

		filePath =  FileSystems.getDefault().getPath("resources", "Outputfile1.tsv");
		qr.createStringFromMapSortedByScore(queriesMapSortedByScore, filePath, charset);
		
		LinkedHashMap<String, Integer> avgScoreMap = qr.averageScorePerQuery(queriesMapSortedByScore);
		for(Map.Entry<String, Integer> avgEntry : avgScoreMap.entrySet())
		{
			System.out.println("Avg score for " + avgEntry.getKey() + " : " + avgEntry.getValue());
		}
		System.out.println();
		
	}	
}

