package datastructures.trees;

import java.util.*;

public class BinaryTreeNode {

	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode parent;
	int value;
	
	public BinaryTreeNode(int value){
		this.value = value;
	}
    
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BinaryTreeNode [value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hashCode(left);
		result = prime * result + Objects.hashCode(parent);
		result = prime * result + Objects.hashCode(right);
		result = prime * result + value;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BinaryTreeNode))
			return false;
		BinaryTreeNode other = (BinaryTreeNode) obj;
		
		if(!Objects.equals(left, other.left))
			return false;
		if(!Objects.equals(parent, other.parent))
			return false;
		if(!Objects.equals(right, other.right))
			return false;
		
		if (value != other.value)
			return false;
		return true;
	}
}



