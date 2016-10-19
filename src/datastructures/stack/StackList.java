package datastructures.stack;

import datastructures.linkedlist.LinkedListNode;


public class StackList {

	Object value;
	LinkedListNode top;

	public StackList(){
		this.top = null;
	}
	
	public void push(Object item){
		LinkedListNode stkElement = new LinkedListNode((int) item);
		stkElement.setNext(top);
		top = stkElement;	
	}

	public Object pop(){
		if(top!= null){
			value = top.getData();
			top = top.getNext();
			return value;
		}
		return null;
	}

	public Object peek(){
		if(top != null){
			value = top.getData();
			return value;
		}
		return null;
	}

}
