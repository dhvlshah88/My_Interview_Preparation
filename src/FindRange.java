import java.util.*;

public class FindRange {
	
	private static int maxValue = Integer.MIN_VALUE;
	private static PriorityQueue<Data> pq;

	public static class Range {
		public int low;
		public int high;
		
		public Range(int low, int high) {
			this.low = low;
			this.high = high;
		}
		
		public int getRange() {
			int range = this.high > this.low ? (this.high - this.low) : (this.low - this.high);
			return range+1;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Range [low=");
			builder.append(low);
			builder.append(", high=");
			builder.append(high);
			builder.append("]");
			return builder.toString();
		}
	}
	
	public static class Data implements Comparable<Data> {
		
		public int value;
		public int listNo;
		
		public Data(int value, int listNo) {
			this.value = value;
			this.listNo =  listNo;
		}

		@Override
		public int compareTo(Data o) {
			return this.value - o.value;
		}
	}
	
	public static Range findMinimumRange(Vector<List<Integer>> lists) {
		if (lists.size() == 0) 
			throw new IllegalArgumentException("Empty vector of lists");
		
		pq = new PriorityQueue<>();
		Data minValue = null;
		int minRange = Integer.MAX_VALUE;
		int low= 0, high = 0;
		
		//Add every the first element from all the list in min heap.
		int i = 0;
		for (List<Integer> list : lists) {
			int value = ((LinkedList<Integer>)list).poll();
			addNumber(value, i);
			i++;
		}
		
		while (!pq.isEmpty()) {
			minValue = pq.poll();
			//Calculate the range and store it.
			int newRange = maxValue - minValue.value + 1;
			if (minRange >= newRange) {
				low = minValue.value;
				high = maxValue;
				minRange = newRange;
			}
			
			LinkedList<Integer> currentList = (LinkedList<Integer>)lists.get(minValue.listNo);
			if (currentList.size() > 0) {
				addNumber(currentList.poll(), minValue.listNo);
			} else 	if (currentList.size() == 0) {
				break;
			}
		}	
		
		return new Range(low, high);
	}

	public static void addNumber(int value, int listNo) {
		maxValue = Math.max(maxValue, value);
		pq.add(new Data(value, listNo));
	}
	
	public static void main(String[] args) {
		Vector<List<Integer>>  lists = new Vector<>();
		
		List<Integer> list1 = new LinkedList<>();
		list1.add(4);
		list1.add(10);
		list1.add(15);
		list1.add(24);
		list1.add(26);
		lists.add(list1);
		
		List<Integer> list2 = new LinkedList<>();
		list2.add(0);
		list2.add(9);
		list2.add(12);
		list2.add(20);
		lists.add(list2);

		List<Integer> list3 = new LinkedList<>();
		list3.add(5);
		list3.add(18);
		list3.add(22);
		list3.add(30);
		lists.add(list3);

		Range minimumRange = findMinimumRange(lists);
		System.out.println(minimumRange.toString());
	}
	
	
}
