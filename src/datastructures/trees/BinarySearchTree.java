package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import datastructures.linkedlist.LinkedListNode;

public class BinarySearchTree {
    BinaryTreeNode root;

    public BinarySearchTree(BinaryTreeNode root) {
	this.root = root;
    }

    public BinaryTreeNode findMinimumNode(BinaryTreeNode node)
    {
	return findMin(node);
    }

    private BinaryTreeNode findMin(BinaryTreeNode node)
    {
	if(node == null)
	    throw new IllegalArgumentException("Node is null");

	while(node.left != null)
	{
	    node = node.left;
	}

	return node;
    }

    public BinaryTreeNode findNode(BinaryTreeNode root, int searchValue){

	while(root != null){
	    int currValue = root.value;

	    if(currValue == searchValue) 
		break;

	    if(currValue < searchValue){
		return findNode(root.right, searchValue);
	    }
	    else{
		return findNode(root.left, searchValue);
	    }
	}

	return root;
    }

    public void insertNode(BinaryTreeNode node, int nodeValue){
	if(nodeValue < node.value){
	    if(node.left != null){
		insertNode(node.left, nodeValue);
		return;
	    }

	    BinaryTreeNode newLeftNode = new BinaryTreeNode(nodeValue); 
	    node.left = newLeftNode;
	    newLeftNode.parent = node;
	}
	else{
	    if(node.right != null){
		insertNode(node.right, nodeValue);
		return;
	    }

	    BinaryTreeNode newRightNode = new BinaryTreeNode(nodeValue);
	    node.right = newRightNode;
	    newRightNode.parent = node;
	}
    }

    public int maxHeight(BinaryTreeNode root){
	if(root == null) 
	    return 0;

	return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    public void preorderTraversal(BinaryTreeNode root){
	if(root == null) 
	    return; 

	root.toString();
	preorderTraversal(root.left);
	preorderTraversal(root.right);
    }

    public void inorderTraversal(BinaryTreeNode root){
	if(root == null) 
	    return;

	inorderTraversal(root.left);
	root.toString();
	inorderTraversal(root.right);
    }

    public void inorderTraversalIterative(BinaryTreeNode root){
	if (root == null)
	    return;

	//keep the nodes in the path that are waiting to be visited
	Stack<BinaryTreeNode> stack = new Stack<>();
	BinaryTreeNode node = root;

	while (node != null) {
	    stack.push(node);
	    node = node.left;
	}

	// traverse the tree
	while (!stack.empty()) {
	    // visit the top node
	    node = stack.pop();
	    System.out.println(node.value);

	    if (node.right != null) {
		node = node.right;

		// the next node to be visited is the leftmost
		while (node != null) {
		    stack.push(node);
		    node = node.left;
		}

	    }

	}
    }

    public void postorderTraversal(BinaryTreeNode root){
	if(root == null)
	    return;

	postorderTraversal(root.left);
	postorderTraversal(root.right);
	root.toString();
    }

    public BinaryTreeNode getLeftNode(BinaryTreeNode currNode){
	if(currNode == null) 
	    return null;
	while(currNode.left != null) 
	{
	    currNode = currNode.left;
	}

	return currNode;
    }

    public BinaryTreeNode getRightNode(BinaryTreeNode currNode){
	if(currNode == null) return null;
	while(currNode.right != null) 
	{
	    currNode = currNode.right;
	}

	return currNode;
    }

    public void mirror(){
	mirror(this.root);
    }

    public void mirror(BinaryTreeNode root){
	if(root != null) {

	    mirror(root.left);
	    mirror(root.right);

	    BinaryTreeNode temp = root.left;
	    root.left = root.right;
	    root.right = temp;
	}	
    }

    // This method is to find lowest common ancestor in binary search tree (not binary tree).
    public BinaryTreeNode lcaForBST(BinaryTreeNode root, BinaryTreeNode one, BinaryTreeNode two) {		
	// Check if one and two are in the root tree.
	while (root != null) {
	    if (root.value < one.value && root.value < two.value) {
		root = root.right;
	    }
	    else if (root.value > one.value && root.value > two.value) {
		root = root.left;
	    }
	    else 
		break;
	}

	return root;
    }

    public boolean isBST() { 
	return( isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE) ); 
    }

    /** 
	  Efficient BST helper -- Given a node, and min and max values, 
	  recurs down the tree to verify that it is a BST, and that all 
	  its nodes are within the min..max range. Works in O(n) time -- 
	  visits each node only once. 
     */ 
    private boolean isBST(BinaryTreeNode node, int min, int max) { 

	if (node==null) 
	    return true; 

	if (node.value < min || node.value > max)
	    return false;

	// left should be in range  min...node.data 
	boolean leftOk = isBST(node.left, min, node.value-1);

	// if the left is not ok, bail out 
	if (!leftOk) return false;

	// right should be in range node.data+1..max 
	boolean rightOk = isBST(node.right, node.value + 1, max);

	return rightOk; 

    } 

    @SuppressWarnings("unused")
    private boolean isBST2(BinaryTreeNode node, int min, int max){

	if(node == null) return true;

	if(node.value > min && node.value < max && isBST2(node.left, min, node.value) && isBST2(node.right, node.value, max))
	    return true;	

	return false;
    }

    // With pointer to parent 
    public BinaryTreeNode inOrderSuccessor(BinaryTreeNode node)
    {
	if(node == null)
	    throw new IllegalArgumentException("Node is null");

	if(node.right != null)
	    return findMin(node.right);

	BinaryTreeNode parentNode = node.parent;

	while(parentNode != null && node == parentNode.right) {
	    node = parentNode;
	    parentNode = parentNode.parent;
	}
	return parentNode;
    }

    //Without pointer to parent
    public BinaryTreeNode inOrderSuccessor(BinaryTreeNode root, BinaryTreeNode node)
    {

	if(root == null || node == null)
	    throw new IllegalArgumentException("Root or Node is null");

	if(node.right != null)
	    return findMin(node.right);

	BinaryTreeNode successor = null;

	while(root != null)
	{
	    if(node.value < root.value)
	    {
		successor = root;
		root = root.left;
	    }
	    else if(node.value > root.value)
		root = root.right;
	    else
		break;
	}

	return successor;
    }

    public static BinaryTreeNode sortedArrayToBST(int[] num)
    {
	int len = num.length;
	if (len == 0)
	    return null;

	return sortedArrayToBST(num, 0, len - 1);
    }

    private static BinaryTreeNode sortedArrayToBST(int[] num, int start, int end)
    {
	if(start > end)
	    return null;

	int mid = (start + end)/2;
	BinaryTreeNode root = new BinaryTreeNode(num[mid]);
	root.left = sortedArrayToBST(num, start, mid - 1);
	root.right = sortedArrayToBST(num, mid+1, end);

	return root;
    }

    public static BinaryTreeNode sortedListToBST(LinkedListNode list, int start, int end)
    {
	if(start > end)
	    return null;

	int mid = (start + end)/2;

	BinaryTreeNode leftNode = sortedListToBST(list, start, mid -1);
	BinaryTreeNode rootNode = new BinaryTreeNode(list.getData());
	list = list.getNext();
	BinaryTreeNode rightNode = sortedListToBST(list, mid + 1, end);

	rootNode.left = leftNode;
	rootNode.right = rightNode;

	return rootNode;
    }

    public static BinaryTreeNode flattenTree(BinaryTreeNode rootNode)
    {
	BinaryTreeNode currNode = rootNode;
	Stack<BinaryTreeNode> stack = new Stack<>();

	while(currNode != null || !stack.empty())
	{
	    if(currNode.left != null) {

		if(currNode.right != null)
		    stack.push(currNode.right);

		currNode.right = currNode.left;
		currNode.left = null;
	    }

	    if(currNode.right == null && !stack.empty()) {
		currNode.right = stack.pop();
	    }

	    currNode = currNode.right;
	}

	return rootNode;
    }

    public static BinaryTreeNode flattenTreeRecursive(BinaryTreeNode rootNode) {
	if (rootNode == null)
	    throw new IllegalArgumentException("Root node is null!!");

	BinaryTreeNode rightChild = rootNode.right;

	if (rootNode.left != null) {
	    rootNode.right = rootNode.left;
	    rootNode.left = null;
	    rootNode = flattenTreeRecursive(rootNode.right);
	}

	if (rightChild != null) {	
	    rootNode.right = rightChild;
	    rootNode = flattenTreeRecursive(rootNode.right);
	}

	return rootNode;
    }

    public static void printNodeLevelWise(BinaryTreeNode root) {
	if (root == null)
	    throw new IllegalArgumentException();

	int nodeAtCurrentLevel = 1;
	int nodeAtNextLevel = 0;
	int level = 0;

	Queue<BinaryTreeNode> queue = new LinkedList<>();
	queue.add(root);
	System.out.println("Level 0:");

	while (!queue.isEmpty()) {
	    BinaryTreeNode tempNode = queue.poll();
	    System.out.println(tempNode.toString());
	    --nodeAtCurrentLevel;

	    if (tempNode.left != null)
		queue.add(tempNode.left);

	    if (tempNode.right != null)
		queue.add(tempNode.right);

	    nodeAtNextLevel += 2;

	    if (nodeAtCurrentLevel == 0) {
		System.out.println("Level " + (++level) + ":");
		nodeAtCurrentLevel = nodeAtNextLevel;
	    }
	}
    }

    public String serialize(BinaryTreeNode root){
	StringBuilder sb = new StringBuilder();
	serialize(root, sb);
	return sb.toString();
    }

    private void serialize(BinaryTreeNode x, StringBuilder sb){
	if (x == null) {
	    sb.append("# ");
	} else {
	    //do a pre-order transversal
	    sb.append(x.value + " ");
	    serialize(x.left, sb);
	    serialize(x.right, sb);
	}
    }

    public BinaryTreeNode deserialize(String s){
	if (s == null || s.length() == 0) return null;
	StringTokenizer st = new StringTokenizer(s, " ");
	return deserialize(st);
    }

    private BinaryTreeNode deserialize(StringTokenizer st){
	if (!st.hasMoreTokens())
	    return null;

	String val = st.nextToken();
	if (val.equals("#"))
	    return null;

	//deserialize using pre-order tranversal
	BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(val));
	root.left = deserialize(st);
	root.right = deserialize(st);
	return root;
    }

    public int sumNumbers(BinaryTreeNode root) {
	if (root == null)
	    return 0;

	return sumOfPaths(root, 0);
    }

    public int sumOfPaths(BinaryTreeNode root, int val) {
	val = val*10 + root.value;
	if (root.left == null && root.right == null)
	    return val;

	int sum_left = 0, sum_right = 0; 
	if (root.left != null)
	    sum_left = sumOfPaths(root.left, val);

	if (root.right != null)
	    sum_right = sumOfPaths(root.right, val);

	return sum_left + sum_right;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }



}
