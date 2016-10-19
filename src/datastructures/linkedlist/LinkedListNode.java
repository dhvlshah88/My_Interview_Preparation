package datastructures.linkedlist;

public class LinkedListNode {

	private int data;
	private LinkedListNode next;
	private int size;

	public LinkedListNode(int data){
		this.data = data;
		this.next = null;
		size = 1;
	}

	public void setNext(LinkedListNode next){
		this.next = next;
	}

	public LinkedListNode getNext(){
		return next;
	}

	public int getData(){
		return data;
	}

	public int size(){
		return size;
	}

	public void addNode(LinkedListNode root, int data){
		LinkedListNode head = root;

		while(head != null){
			if(head.next == null){
				LinkedListNode node = new LinkedListNode(data);
				head.next = node;
				++root.size;
				break;
			}

			head = head.next;
		}
	}

	public void printNodes(){
		LinkedListNode head = this;

		while(head!=null){
			System.out.print(head.data +" -> " );
			head = head.getNext();
		}	
		System.out.println("NULL");
		System.out.println();
	}

	public static LinkedListNode nthFromLast(LinkedListNode head, int n) 
	{
		if (head == null || n < 1) 
			return head;

		if (head.size < n)
			throw new IllegalArgumentException();

		LinkedListNode p1 = head;
		LinkedListNode p2 = head;

		for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
			p2 = p2.next;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;

		/* Alternative better approach to this problem.
		 * 
		LinkedListNode current = head; //current node
		LinkedListNode currentK = head; //node at index k

		int counter = 0;

		while(current.next!=null)
		{
			counter++;

			if(counter>=n)
			{
				currentK = currentK.next;
			}

			current = current.next;
		}

		//reached end
		return currentK;
		* 
		* */
	}
		
	public static LinkedListNode nthFromLastRecursive(LinkedListNode head, LinkedListNode end, int n)
	{
		if(end == null)
			return n > 0 ? null : head;
		else if (n > 0)
			return nthFromLastRecursive(head, end.next, --n);
		else
			return nthFromLastRecursive(head.next, end.next, 0);
	}

	//delete a node in the middle of a single linked list, given only access to that node.
	public boolean deleteNode(LinkedListNode node){

		if(node == null || node.next == null){
			return false;
		}

		LinkedListNode nextNode = node.next;
		node.data  = nextNode.data;
		node.next = nextNode.next;

		return true;
	}

	public LinkedListNode retrieveNode(LinkedListNode head, int data){
		while(head != null){
			if(head.data == data){
				return head;
			}
			head = head.next;
		}

		return null;
	}

	public LinkedListNode recursiveRetrieval(LinkedListNode head, int data){
		if(head == null)
			return null;


		if(head.data != data){
			recursiveRetrieval(head.next, data);
		}

		return head;
	}

	public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){


		if(l1==null && l2==null){
			if(carry == 1){
				LinkedListNode lastCarry = new LinkedListNode(carry);
				return lastCarry;
			}
			return null;
		}

		int value =  carry;

		if(l1 != null){
			value += l1.data; 
		}

		if(l2 != null){
			value += l2.data;
		}

		LinkedListNode result = new LinkedListNode(value % 10);
		result.next = addLists(l1 == null? null : l1.next, l2 == null? null : l2.next, value >= 10 ? 1 : 0);

		return result;
	}

	public LinkedListNode insertInAscendingOrder(LinkedListNode head, LinkedListNode insertNode){
		if(head == null){
			return null;
		}

		LinkedListNode previous = head;
		LinkedListNode current = head.next;

		if(current == null){
			if(previous.data <= insertNode.data){
				previous.next = insertNode;
			}
			else
			{
				insertNode.next = previous;
				head = insertNode;
			}
			return head;
		}

		while(current != null){
			if(previous.data <= insertNode.data && current.data >= insertNode.data){
				previous.next = insertNode;
				insertNode.next = current;
				break;
			}

			previous = previous.next;
			current = current.next;
		}

		//current =  insertNode;
		return head;
	}

	public static LinkedListNode reverse(LinkedListNode head){
		
		if(head == null || head.next == null)
			return head;
		
		LinkedListNode previous = null;
		LinkedListNode current = head;
		LinkedListNode foward;

		while(current != null){
			foward = current.next;
			current.next = previous;
			previous = current;
			current = foward;
		}

		return previous;
	}

	public static LinkedListNode reverseRecursive(LinkedListNode head){

		if(head == null || head.next == null)
			return head;

		LinkedListNode last = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;

		return last;
	}

	public static void reverseRecursive1(LinkedListNode head){

		if(head == null || head.next == null)
			return;

		reverseRecursive1(head.next);
		head.next.next = head;
		head.next = null;

	}

	public boolean hasCycle(LinkedListNode head){
		LinkedListNode fastPtr = head;
		LinkedListNode slowPtr = head;

		while(fastPtr!=null && slowPtr!=null && fastPtr.next != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if(slowPtr == fastPtr){
				return true;
			}
		}

		return false;
	}

	public static LinkedListNode reverseKNodes(LinkedListNode head, int k)
	{
		LinkedListNode current = head;
		LinkedListNode next = null;
		LinkedListNode prev = null;
		int count = 0;

		while (current != null && count < k)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null)
		{
			head.next = reverseKNodes(next, k);
		}
		
		head = prev;
		return prev;
	}

	public static void deleteDups(LinkedListNode head) {
		if (head == null) return;
		
		LinkedListNode previous = head;
		LinkedListNode current = head.next;
		LinkedListNode runner = null;
		
		while (current != null) 
		{
			runner = head;
			
			while (runner != current) 
			{ 
				// Check for earlier dups
				if (runner.data == current.data) 
				{
					LinkedListNode tmp = current.next; // remove current
					previous.next = tmp;
					current = tmp; // update current to next node
					break; // all other dups have already been removed
				}
				runner = runner.next;
			}
			
			if (runner == current) { // current not updated - update now
				previous = current;
				current = current.next;
			}
		}
	}
	
	public static LinkedListNode rotateRight(LinkedListNode head, int nPosition)
	{
		LinkedListNode current = head;
		int nodeCount = 1;
	
		if(nPosition<=0 || head == null || head.next == null)
			return head;
		
		while(current.next != null)
		{
			nodeCount++;
			current = current.next;
		}
		
		nPosition = nPosition % nodeCount;
		
		if(nPosition==0)
			return head;
		
		current.next = head;
		current = head;
		
		while(nodeCount>nPosition+1)
		{
			nPosition++;
			current = current.next;
		}
		
		head = current.next;
		current.next = null;
		
	
		return head;
	}
	
	public static LinkedListNode intersectionNode(LinkedListNode a, LinkedListNode b) {
	    if (a == null || b == null)
		return null;
	
	    LinkedListNode firstNode = a;
	    LinkedListNode secondNode = b;
	    
	    while (firstNode != secondNode) {
		firstNode = firstNode == null ? b : firstNode.next;
		secondNode = secondNode == null ? a : secondNode.next;
	    }
	    
	    return firstNode;
	}
	
	public static LinkedListNode intersectionNodeUsingLength(LinkedListNode a, LinkedListNode b) {
	    int lenA = length(a), lenB = length(b);
	    
	    while (lenA > lenB) {
		a = a.next;
		lenA--;
	    }
	    
	    while (lenB > lenA) {
		b = b.next;
		lenB--;
	    }
	    
	    while(a != b) {
		a = a.next;
		b = b.next;
	    }
	    
	    return a;
	}
	
	public static int length(LinkedListNode head) {
	    int count = 0;
	    while (head != null) {
		head = head.next;
		count++;
	    }
	    return count;
	}
}
