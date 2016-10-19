package designpatterns.iterator;

import java.util.Iterator;
import java.util.LinkedList;

public class CustomIterator implements Iterator<Integer> {
	
	private LinkedList<Integer> head;
	private int currentIndex;
	
	public CustomIterator(LinkedList<LinkedList<Integer>> node)
	{
		head = flatten(node);
		currentIndex =0;
	}
	
	@Override
	public boolean hasNext() {
		// Returns true if the iteration has more elements
		return currentIndex < head.size();
	}

	@Override
	public Integer next() {
		// 
		return head.get(currentIndex++);
	}

	@Override
	public void remove() {
		// 
		head.remove(currentIndex--);
	}
	
	public LinkedList<Integer> flatten(LinkedList<LinkedList<Integer>> nestedNode)
	{
		LinkedList<Integer> flattenList = new LinkedList<>();
		
		for(LinkedList<Integer> node : nestedNode)
		{
			flattenList.addAll(node);
		}
			
		return flattenList;
	}
}
