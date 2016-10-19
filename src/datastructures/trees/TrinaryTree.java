package datastructures.trees;

public class TrinaryTree {

	//Static class for node.
	public static class TrinaryNode {
		
		private TrinaryNode leftNode;
		private TrinaryNode middleNode;
		private TrinaryNode rightNode;
		private int value;
		
		public TrinaryNode(int value)
		{
			this.value = value;
			leftNode = middleNode = rightNode = null;
		}

		/*//Accessor methods. This might be need if the TrinaryNode class is in different file.
		public void setLeftNode(TrinaryNode node)
		{
			this.leftNode = node;
		}
		
		public TrinaryNode getLeftNode()
		{
			return leftNode;
		}
		
		public void setMiddleNode(TrinaryNode node)
		{
			this.middleNode = node;
		}
			
		public TrinaryNode getMiddleNode()
		{
			return middleNode;
		}

		public void setRightNode(TrinaryNode node)
		{
			this.rightNode = node;
		}
		
		public TrinaryNode getRightNode()
		{
			return rightNode;
		}
		
		public void setValue(int value)
		{
			this.value = value;
		}
		
		public int getValue()
		{
			return value;
		}*/
	}

	//Recursive method to insert a node either at left, middle or right position.
	public static void insertNode(TrinaryNode root, int nodeValue)
	{
		if (root == null)
			throw new RuntimeException("Root is null. Please specify root while inserting new value.");
		
		// If node value is less than root's value, add a node to left.
		if(nodeValue < root.value)
		{
			if(root.leftNode != null)
			{
				insertNode(root.leftNode, nodeValue);
				return;
			}
			root.leftNode = new TrinaryNode(nodeValue);
		}
		
		// If node value is greater than root's value, add a node to right.
		if(nodeValue > root.value)
		{
			if(root.rightNode != null)
			{
				insertNode(root.rightNode, nodeValue);
				return;
			}
			root.rightNode = new TrinaryNode(nodeValue);
		}

		// If node value is equal to root's value, add a node to middle
		if(nodeValue == root.value)
		{
			if(root.middleNode != null)
			{
				insertNode(root.middleNode, nodeValue);
				return;
			}
			root.middleNode = new TrinaryNode(nodeValue);
		}
	}
	
	// Helper function to find the minimum value node.
	public static TrinaryNode findMin(TrinaryNode node)
	{
		if (node != null)
			while (node.leftNode != null) {
				node = node.leftNode;
			}
		
		return node;
	}
	
	//Delete a node from tree.
	public static TrinaryNode deleteNode(TrinaryNode root, int nodeValue)
	{
		TrinaryNode node = root;
		
		if(node == null)
			return null;
		
		if(nodeValue < node.value)
		{
			node.leftNode = deleteNode(node.leftNode, nodeValue);
		}
		else if(nodeValue > node.value)
		{
			node.rightNode = deleteNode(node.rightNode, nodeValue);
		}
		else
		{
			if(node.middleNode != null)
			{
				node.middleNode = deleteNode(node.middleNode, nodeValue);
			}
			else if(node.rightNode != null)
			{
				int minValue = findMin(node.rightNode).value;
				node.value = minValue;
				node.rightNode = deleteNode(node.rightNode, minValue);
			}
			else
			{
				node = node.leftNode;
			}
		}
		
		return node;
	}

	
	 //Recursively print the whole tree
	  public static void printTree(TrinaryNode root)
	  {
	      if (root != null)
	      {
	          System.out.println("Node value : " + root.value);
	          printTree(root.leftNode);
	          printTree(root.middleNode);
	          printTree(root.rightNode);
	      }
	  }
	  
	  //Populate the tree with int values and returns root.
	  public static TrinaryNode populateTree(int A[])
	  {
	      TrinaryNode root = new TrinaryNode(A[0]);

	      //Insert values into the tree
	      for (int i = 1; i < A.length; i++)
	      {
	          insertNode(root, A[i]);
	      }

	      //Print tree
	      printTree(root);
		
	     return root;
	  }
	  
		public static void main(String[] args) 
		{
			
			int values[] = {5, 4, 9, 5, 9, 7, 2, 2};

		    TrinaryNode root = TrinaryTree.populateTree(values);
		    System.out.println();
		    TrinaryTree.deleteNode(root, 9);
		     
		    printTree(root);
		}
}
