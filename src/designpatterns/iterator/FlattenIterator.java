package designpatterns.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class FlattenIterator implements Iterator<Object>{
	
	
	private final Stack<Iterator<?>> iterators = new Stack<>();
	private boolean hasNextCalled;
	private boolean hasNextValue;
	private Object next;
		
	public FlattenIterator(Iterator<?> iterator)
	{
		if(iterator == null)
			throw new RuntimeException("Exception");
		
		iterators.push(iterator);
	}

	@Override
	public boolean hasNext() {
	
		boolean hasNext = false;
		
		if(hasNextCalled)
			hasNext = hasNextValue;
		else
		{
			iterateNext();
			hasNextCalled = true;
			hasNext = (next != null);
			hasNextValue = hasNext;
		}
		
		return hasNext;
	}

	private void iterateNext()
	{
		if(!iterators.empty())
		{
			if(iterators.peek().hasNext())
			{
				next = iterators.peek().next();
				if(next instanceof Iterator)
				{
					iterators.push((Iterator<?>) next);
					iterateNext();
				}
				else if(next instanceof Iterable)
				{
					iterators.push(((Iterable<?>)next).iterator());
					iterateNext();
				}
					
			}
			else
			{
				iterators.pop();
				iterateNext();
			}
		}
		else
		{
			next = null;
		}
	}
	
	@Override
	public Object next() {
		Object returnValue = null;
		
		if(hasNextCalled)
		{
			hasNextCalled = false;
		}
		else
		{
			iterateNext();
		}
		
		returnValue = next;
		
		if(returnValue == null)
			throw new RuntimeException();
		
		return returnValue;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		
		ArrayList<String> arr1 = new ArrayList<>();
		arr1.add("A");
		arr1.add("B");
		arr1.add("C");
		map.put(1, arr1);
		
		ArrayList<String> arr2 = new ArrayList<>();
		arr2.add("D");
		arr2.add("E");
		arr2.add("F");
		map.put(2, arr2);

		ArrayList<String> arr3 = new ArrayList<>();
		arr3.add("G");
		arr3.add("H");
		arr3.add("I");
		map.put(3, arr3);
		
		
		Iterator<?> it = new FlattenIterator(map.values().iterator());
		
		while(it.hasNext())
			System.out.println(it.next());
	}
	
	
	
	
	
	
	

}
