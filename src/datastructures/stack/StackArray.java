package datastructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackArray {
	
	private static final int INITSIZE = 10;
	//private static final float LOADFACTOR = .8f;
	private Object[] items;
	private int itemCount = 0;
	//private int threshold;
	
	//Constructor
	public StackArray()
	{
		items = new Object[INITSIZE];
	}
	
	public StackArray(int capacity)
	{
		items = new Object[capacity];
	}

	//Push/Add object item on the stack.
	public void push(Object newItem) throws Exception
	{
		if (newItem == null)
			throw new IllegalArgumentException("Items pushed on stack must not be null.");
	
		
		if (items.length == itemCount)
			throw new ArrayIndexOutOfBoundsException(itemCount);
		
		items[itemCount++] = newItem;
	}
	
	//Pop/Remove top item from stack.
	public Object pop() throws EmptyStackException
	{
		Object topItem = peek();
		//items[--itemCount] = null;
		--itemCount;
		
		return topItem;
	}
	
	//Retrieve but not remove the top item from stack.
	public Object peek() throws EmptyStackException
	{
		if  (itemCount == 0)
			throw new EmptyStackException();
		
		int topIndex = itemCount;
		
		return items[topIndex-1];
	}
	
	// Return the number of the item on stack.
	public int size()
	{
		return itemCount;
	}
	
	
	// Checks whether the stack is empty or not.
	public boolean isEmpty()
	{
		return (itemCount == 0);
	}
	
	
	/*public void expandArray()
	{
		Object[] newItemArray = new Object[];
		
	}*/
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(items);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StackArray))
			return false;
		StackArray other = (StackArray) obj;
		if (!Arrays.equals(items, other.items))
			return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
	}

}
