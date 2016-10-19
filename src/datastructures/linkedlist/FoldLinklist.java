package datastructures.linkedlist;

public class FoldLinklist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedListNode head = new LinkedListNode(1);
		head.addNode(head, 2);
		head.addNode(head, 3);
		head.addNode(head, 4);
		head.addNode(head, 5);
		head.addNode(head, 6);
		head.addNode(head, 7);
		head.addNode(head, 8);

		head.printNodes();
		FoldLinklist.fold(head);
		head.printNodes();
	}

	public static void fold(LinkedListNode head) {
		LinkedListNode slowPtr = head;
		LinkedListNode fastPtr = head;

		while (fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext();

			if (fastPtr.getNext() != null) {
				fastPtr = fastPtr.getNext();
			}
		}

		LinkedListNode middlePtr = slowPtr;
		LinkedListNode reversedRightHalf = LinkedListNode.reverseRecursive(slowPtr);

		while (reversedRightHalf != null && head != middlePtr) {
			LinkedListNode tempNode = head.getNext();
			LinkedListNode reverseTempNode = reversedRightHalf.getNext();

			head.setNext(reversedRightHalf);
			reversedRightHalf.setNext(tempNode);
			head = tempNode;
			reversedRightHalf = reverseTempNode;
		}

		if (reversedRightHalf != null) {
			reversedRightHalf.setNext(null);
		} else {
			head.setNext(null);
		}

	}

}
