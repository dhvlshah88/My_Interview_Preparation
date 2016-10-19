package datastructures.linkedlist;

public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		LinkedListNode head = new LinkedListNode(4);
		/*
		for(int i = 1; i < 10; i++){
			head.addNode(i+1);
		}

		head.printNodes();
		
		int n = 5;
		System.out.println(n + "th node from last node is " + head.nthToLast(head, n).getData());
		
		
		head.deleteNode(head.retrieveNode(head, 9));
		
		head.printNodes();
		*/
		head.addNode(head, 5);
		head.addNode(head, 6);
		head.addNode(head, 3);
		head.addNode(head, 8);
		head.addNode(head, 9);
		head.addNode(head, 10);
		
		head.printNodes();
		
		System.out.println((LinkedListNode.nthFromLast(head, 3)).getData());
		
		System.out.println((LinkedListNode.nthFromLastRecursive(head, head, 3)).getData());
	}

}
