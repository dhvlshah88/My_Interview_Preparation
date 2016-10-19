package stringproblems;

import java.util.PriorityQueue;

public class ShuffleCharacters {
	
	public static void main(String[] args) {
		
		String word = "aa";
		System.out.println(isValidShuffle(word));
		
		word = "aaabbbbbbdddggef";
		System.out.println(isValidShuffle(word));
		
		word = "apple";
		System.out.println(isValidShuffle(word));
		
		word = "aaaaabbbbb";
		System.out.println(isValidShuffle(word));
		
//		word = "aaabbbbbbdddggef";
//		HuffmanCode(word);
	}
		
	public static boolean isValidShuffle(String input) {
		if (input.isEmpty())
			 throw new IllegalArgumentException("Input string cannot be null");
		
		if (input.length() == 1)
			return true;
		
		int [] characterOccurence = new int[26];
		int maxOccuredCharacter = Integer.MIN_VALUE;
		
		for (char c : input.toLowerCase().toCharArray()) {
			int index = c - 'a';
			characterOccurence[index]++;
			maxOccuredCharacter = Math.max(maxOccuredCharacter, characterOccurence[index]);
		}

		return maxOccuredCharacter <= ((input.length() + 1) / 2);
	}
	
	public static void HuffmanCode(String input) {
		 int[] frequency = new int[26];
		 
		for (char c : input.toCharArray()) {
			frequency[c-'a']++;
		}
		
		HuffmanNode huffmanNode = buildTree(frequency);
		
		 /* Print the Huffman code */
	     System.out.println("Character\t Frequency\t Huffman Code");
	     printCode(huffmanNode, new StringBuffer());
	}

	public static HuffmanNode buildTree(int[] frequency) {
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
		
		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] > 0) 
				pq.offer(new HuffmanNode((char)('a' + i), frequency[i], null, null));
		}
		
		while (pq.size() > 1) {
			/* Extract two minimum frequency char */
			HuffmanNode leftNode = pq.poll();
//			System.out.println("left node: " + leftNode.character);
			HuffmanNode rightNode = pq.poll();
//			System.out.println("right node: " + rightNode.character);
			
			/* Create a new internal node as the parent of left and right */
	        pq.offer(new HuffmanNode('\0', leftNode.frequency+rightNode.frequency, leftNode, rightNode));
		}
		
		/* Return the only node which is the root */
		return pq.poll();
	}
	
	/* This function prints the Huffman code from the Huffman tree (starting from root to leaf) */
	 public static void printCode(HuffmanNode root, StringBuffer s){
	     /* If it is a leaf node */
	     if(root.isLeaf()){
	        /* Print the character, its frequency and the code */
	        System.out.println(root.character +"\t"+ root.frequency +"\t"+ s);
	     }
	     
	     /* If it is not a leaf node */
	     if(!root.isLeaf()){
	         /* Traversing left branch */
	         s.append('0');
	         printCode(root.left, s);
	         s.deleteCharAt(s.length()-1);
	         /* Traversing right branch */
	         s.append('1');
	         printCode(root.right, s);
	         s.deleteCharAt(s.length()-1);
	     }
	 }
	 
	
}
