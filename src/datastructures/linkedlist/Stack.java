package datastructures.linkedlist;

// LinkedList implementation of the stack. 
public class Stack {
	
	LinkedListNode stack;
	
	public Stack(){
		this.stack = null;
	}
	
	public void push(int value){
		LinkedListNode stkElement = new LinkedListNode(value);
		stkElement.setNext(stack);
		stack = stkElement;
	}

	public int pop() throws NullPointerException{
		if(stack == null){
			throw new NullPointerException();
		}
		
		LinkedListNode stkElement = stack;
		stack = stack.getNext();
		return stkElement.getData();
	}
	
	public int peek() throws NullPointerException{
		if(stack == null){
			throw new NullPointerException();
		}
		
		return stack.getData();
	}
}
