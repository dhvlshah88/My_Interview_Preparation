package algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode {
    int frequency;
    char input;
    HuffmanNode left;
    HuffmanNode right;
    
    public HuffmanNode(char input, int frequency) {
	this.frequency = frequency;
	this.input = input;
    }

    public HuffmanNode() {
	// TODO Auto-generated constructor stub
    }
    
}

class HuffmanNodeComparator implements Comparator<HuffmanNode> {
    
    @Override 
    public int compare (HuffmanNode o1, HuffmanNode o2) {
	if (o1.frequency < o2.frequency) {
	    return -1;
	} else {
	    return 1;
	}
    }
}

public class HuffmanEncoding {
    
    Map <Character, String> map = null;
    
    public HuffmanEncoding() {
	map = new HashMap<>();
    }
    
    public Map<Character, String> encoding(char[] input, int[] frequency) {
	PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>(input.length, new HuffmanNodeComparator());
	
	// insertion complexity is O(log n)
	for (int i = 0; i < input.length; i++) {
	    HuffmanNode node = new HuffmanNode(input[i], frequency[i]);
	    minHeap.offer(node);
	}
	
	while (minHeap.size() > 1) {
	    HuffmanNode h1 = minHeap.poll();
	    HuffmanNode h2 = minHeap .poll();
	    HuffmanNode node = new HuffmanNode();
	    node.frequency = h1.frequency + h2.frequency;
	    node.left = h1;
	    node .right = h2;
	    minHeap.offer(node);
	}
	
	StringBuilder strBuilder = new StringBuilder();
	createCode(minHeap.poll(), strBuilder);
	return map;
    }
    
    public void createCode(HuffmanNode node, StringBuilder strBuilder) {
	if (node == null)
	    	return;
	
	if (node.left == null && node.right == null) {
	    map.put(node.input, strBuilder.toString());
	    return;
	}
	
	strBuilder.append("0");
	createCode(node.left, strBuilder);
	strBuilder.deleteCharAt(strBuilder.length() -1);
	strBuilder.append("1");
	createCode(node.right, strBuilder);
	strBuilder.deleteCharAt(strBuilder.length() -1);
    }
    

    public static void main(String[] args) {
        HuffmanEncoding he = new HuffmanEncoding();
        char input[] = {'a','b','c','d','e','f'};
        int frequency[] = {5,9,12,13,16,45};
        Map<Character,String> code = he.encoding(input, frequency);
        System.out.println(code);
    }

}
