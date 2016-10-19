package datastructures.trees;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 * Created by Dhaval on 1/18/14.
 */
public class TrieTree
{

	private TrieNode root;
	private LinkedHashSet<String> listOfWords;
	private HashMap<String, LinkedHashSet<String>> longestWordsMap;
	private LinkedHashMap<String, LinkedHashSet<String>> longestWordMapSorted; 

	private static class TrieNode
	{
		@SuppressWarnings("unused")
		char character;
		HashMap<Character, TrieNode> children;
		boolean isEnd;

		public TrieNode(char character)
		{
			this.character = character;
			children = new HashMap<>();
			this.isEnd = false;
		}
	}

	public TrieTree()
	{
		root = new TrieNode((char)0);
	}

	//Method to insert a word in Trie tree data structure.
	public void insertWord(String word)
	{
		TrieNode currentNode = root;

		for(char letter : word.toCharArray())
		{
			//Retrieves current node's children (next characters hash-map to current letter).
			HashMap<Character, TrieNode> nextLetterMap = currentNode.children;

			//If nextLetterMap already contains this letter, then return its corresponding node.
			if(nextLetterMap.containsKey(letter))
			{
				currentNode = nextLetterMap.get(letter);
			}
			else
			{
				TrieNode nextNode = new TrieNode(letter);
				nextLetterMap.put(letter, nextNode);
				currentNode = nextNode;
			}
		}

		//Set isEnd variable to true if the currentNode represents last letter of a word.
		currentNode.isEnd = true;
	}

	public void buildTrieTreeUsingListOfWords()
	{
		if(listOfWords == null)
			throw new IllegalArgumentException("Argument is null");

		for(String word : listOfWords)
		{
			insertWord(word);
		}
	}


	public  String getMatchingPrefix(String inputString)
	{
		//Create a new StringBuilder instance to hold the resulting prefix.
		StringBuilder resultString = new StringBuilder();
		
		//Initialize this variable with reference of the root in order to traverse the trie tree.
		TrieNode currentNode = root;
		int lastPrefixLength = 0;

		//Iterate through the char array of the input string and traverse down the trie tree.
		for(char letter : inputString.toCharArray())
		{
			//If nextLetterMap already contains this letter, then return its corresponding node.
			HashMap<Character, TrieNode> nextLetterMap = currentNode.children;	

			//Check if the map contains the character. If so append that to output string and move down the trie tree.
			if(nextLetterMap.containsKey(letter))
			{
				currentNode = nextLetterMap.get(letter);
				resultString.append(letter);

				// If this is end of a word, then update lastPrefixLength with length of valid prefix.
				if(currentNode.isEnd)
					lastPrefixLength = inputString.indexOf(letter) + 1;
			}
			else
				break;
		}

		
		// If the last processed character did not match end of a word, return the previously matching prefix using lastPrefixLength
		if(!currentNode.isEnd)
			return resultString.substring(0, lastPrefixLength);

		return resultString.toString();
	}


	public LinkedHashMap<String, LinkedHashSet<String>> getLongestWordMadeOfOtherWords()
	{
		StringBuilder subWord = new StringBuilder();
		longestWordsMap = new HashMap<>();

		for(String word : listOfWords)
		{
			TrieNode currentNode = root;
			int concatenatedWordCounter = 0;
			LinkedHashSet<String> subStringList = new LinkedHashSet<>();

			for(char letter : word.toCharArray())
			{
				HashMap<Character, TrieNode> nextLettersMap = currentNode.children;
				if(nextLettersMap.containsKey(letter))
				{
					currentNode = nextLettersMap.get(letter);
					subWord.append(letter);

					if(currentNode.isEnd)
					{
						concatenatedWordCounter++;

						subStringList.add(subWord.toString());
						subWord.setLength(0);
						subWord.trimToSize();
					}
				}
				else
					break;
			}

			System.out.println("Word: " + word + " is composed of " + concatenatedWordCounter + " words.");
			longestWordsMap.put(word, subStringList);
		}

		sortMapByValue();
		
		return longestWordMapSorted;
	}

	public HashSet<String> readLineFromTextFile(String filePath) throws IOException
	{
		String currentLine = "";
		this.listOfWords = new LinkedHashSet<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){

			while((currentLine = reader.readLine())!= null){
				
				if(currentLine.isEmpty())
					continue;
				
				listOfWords.add(currentLine);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Size: " + listOfWords.size());
		return listOfWords;
	}

	private void sortMapByValue()
	{
		List<Entry<String, LinkedHashSet<String>>> unsortedList = new LinkedList<>(longestWordsMap.entrySet()); 
		Collections.sort(unsortedList, new Comparator<Entry<String, LinkedHashSet<String>>>() {

			public int compare(Entry<String, LinkedHashSet<String>> entry1, Entry<String, LinkedHashSet<String>> entry2)
			{
				int size1 = ((HashSet<?>) entry1.getValue()).size();
				int size2 = ((HashSet<?>) entry2.getValue()).size();

				return Integer.valueOf(size1).compareTo(size2);
			}
		});

		longestWordMapSorted = new LinkedHashMap<>();
		for(Iterator<Entry<String, LinkedHashSet<String>>> it = unsortedList.iterator(); it.hasNext();)
		{
			Entry<String, LinkedHashSet<String>> entry = it.next();
			longestWordMapSorted.put(entry.getKey(), entry.getValue());
		}
	}

}
