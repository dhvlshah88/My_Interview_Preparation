package datastructures.arrays;

import java.util.*;

public class ListSolutions {
	
	public static class Interval  {
		int start;
		int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Start - " + this.start + " End - " + this.end;
		}
	}
	
	public class StartIntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	}
	
	
	public List<Interval> mergeIntervalList(List<Interval> listOfInterval) {
		listOfInterval.sort(new StartIntervalComparator());
		
		int i = 0;
		
		while(i != listOfInterval.size() -1) {
			Interval currInterval = listOfInterval.get(i);
			Interval nextInterval = listOfInterval.get(i+1);
			
			if (currInterval.end - nextInterval.start >= 0) {
				nextInterval.start = currInterval.start;
				listOfInterval.remove(i);
			} else {
				i++;
			}
		}
		
		return listOfInterval;
	}
	
	public static void main(String[] args) {
		
		List<Interval> theList = new ArrayList<>();
		
		Interval firstInt = new Interval(3, 11);
		theList.add(firstInt);
		Interval secondInt = new Interval(6, 18);
		theList.add(secondInt);
		Interval thirdInt = new Interval(17, 25);
		theList.add(thirdInt);
		Interval fourInt = new Interval(40, 47);
		theList.add(fourInt);
		Interval fifthInt = new Interval(46, 73);
		theList.add(fifthInt);
		
		ListSolutions solutions = new ListSolutions();
		List<Interval> mergedList = solutions.mergeIntervalList(theList);
		
		System.out.println(Arrays.deepToString(mergedList.toArray()));
	}

}
