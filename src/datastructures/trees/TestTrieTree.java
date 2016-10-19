package datastructures.trees;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

public class TestTrieTree {

	  public static void main(String[] args) {
		  
		  testCase1();
		  //testCase2();
		  
         }
	  
	  private static void testCase1()
	  {
		   TrieTree dict = new TrieTree();        
	        dict.insertWord("are");
	        dict.insertWord("area");
	        dict.insertWord("base");
	        dict.insertWord("cat");
	        dict.insertWord("cater");        
	        dict.insertWord("basement");
	         
	        String input = "caterer";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              
	 
	        input = "basement";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));                      
	         
	        input = "are";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              
	 
	        input = "arex";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));              
	 
	        input = "basemexz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));                      
	         
	        input = "xyz";
	        System.out.print(input + ":   ");
	        System.out.println(dict.getMatchingPrefix(input));                      
 
	  }
	  
	 @SuppressWarnings("unused")
	private static void testCase2() {
		String filePath = "D:\\wordsforproblem.txt";
		
		TrieTree tree = new TrieTree();
		
		try {
			tree.readLineFromTextFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tree.buildTrieTreeUsingListOfWords();
		
		LinkedHashMap<String, LinkedHashSet<String>> map = tree.getLongestWordMadeOfOtherWords();
		
		int loopBreaker = 0;
		for(Entry<String, LinkedHashSet<String>> entry : map.entrySet())
		{
			System.out.println(entry.getKey() + " - " +  ((HashSet<String>)entry.getValue()).size());
			
			for(String words : entry.getValue())
			{
				System.out.print(words + ",");
			}
			
			loopBreaker++;
			
			if(loopBreaker > 3)
				break;
		}
		
	}

}
