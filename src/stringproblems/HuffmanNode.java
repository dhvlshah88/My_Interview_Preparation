package stringproblems;

public class HuffmanNode implements Comparable<HuffmanNode>  {
	public final char character;
	public final int frequency;
	public final HuffmanNode left;
	public final HuffmanNode right;

	public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
		this.character = character;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}

	public boolean isLeaf(){
		/* Return true if the node has no left and right child */
		return (left == null  &&  right == null);
	}

	@Override
	public int compareTo(HuffmanNode o) {
		return this.frequency - o.frequency;
	}

}
