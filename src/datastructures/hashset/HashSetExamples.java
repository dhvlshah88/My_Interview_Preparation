package datastructures.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExamples
{
	public static void main( String[] args )
	{
		HashSet<Integer> set = new HashSet<>();
		
		set.add( new Integer( 6 ) );
		set.add( new Integer( 1 ) );
		set.add( new Integer( 4 ) );
		System.out.println( set );

		System.out.println( "Show that duplicates cannot be added." );
		
		Boolean value = set.add( new Integer( 8 ) );
		if ( !value )
			System.out.println( "Could not add 8." );
		else
		{
			System.out.println( "Added 8" );
			System.out.println( "New contents are " + set );
		}

		value = set.add( new Integer( 4 ) );
		if ( !value )
			System.out.println( "Could not add 4." );
		else
		{
			System.out.println( "Added 4." );
			System.out.println( "New contents are " + set );
		}
		
		System.out.println("Does hashset contains 8: " + set.contains(8));	
		System.out.println("Hashset size: " + set.size());
		
		Iterator<Integer> iterator = set.iterator();
		
		while(iterator.hasNext())
			System.out.println(iterator.next());
		
		HashSet<String> setStr = new HashSet<>(Arrays.asList("Java","C++"));
		System.out.println(setStr);
		//setStr.clear();
		String[] str = setStr.toArray(new String[0]);
		System.out.println(Arrays.toString(str));
	}
}