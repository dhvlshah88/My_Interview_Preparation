package datastructures.linkedlist;

public class DoubleLinkedList {
	
	private Node head;
	private Node tail;
	private int size = 1;

	//Node class defines node of double linked list.
	class Node {
	    
	    public int data;
	    public Node next;
	    public Node prev;
	    
	    public Node (int data) {
		this.data = data;
		this.next  = null;
		this.prev = null;
	    }
	    
	    public Node (Node prev, int data, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	    }
	}
	
	public DoubleLinkedList () {
		this.head = this.tail = null;
	}
		
	public void add(int data) {
		if (head == null ) {
			head =  new Node(data);
			tail = head;
			return;
		}
		
		Node newNode = new Node(data);
		Node currentNode = head;
		
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		
		currentNode.next = newNode;
		newNode.prev = currentNode;
		tail = newNode;
		size++;
	}
	
	public void addToFront(int data) {
		Node newNode = new Node(data);
		Node f = head;
		newNode.next = f;
		head = newNode;
		
		if (f == null) 
			tail = newNode;
		else
			f.prev = newNode;
		
		size++;
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		Node currentNode = head;
		while (currentNode != null) {
			sb.append(currentNode.data + " -- ");
			currentNode = currentNode.next;
		}
		System.out.println(sb.toString());
	}
	
	public void printFromBack() {
		StringBuilder sb = new StringBuilder();
		Node currentNode = tail;
		while (currentNode != null) {
			sb.append(currentNode.data + " -- ");
			currentNode = currentNode.prev;
		}
		System.out.println(sb.toString());
	}
	
	public int size() {
	    return size;
	}
	
	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.add(1);
		dll.add(2);
		dll.add(3);
		dll.add(4);
		
		dll.print();
		
		dll.printFromBack();
	}

}
