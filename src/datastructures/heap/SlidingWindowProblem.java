package datastructures.heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowProblem {

    public static void main(String[] args) {
	int[] nums = {3,1,-1,-3,5,3,6,7};
	int k = 3;
	int[] result;
	
	SlidingWindowProblem sw = new SlidingWindowProblem();
	result = sw.maxValueUsingDeque(nums, k);
	
	System.out.println(Arrays.toString(result));
	
    }

    public int[] maxValue(int[] nums, int k) {
	if (nums == null || nums.length == 0) 
	    return new int[0];

	int[] result = new int[nums.length-k+1];
	PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, Collections.reverseOrder());
	for (int i = 0; i < k; i++) {
	    pq.offer(nums[i]);
	}

	int startIndex = 0;
	result[startIndex] = pq.peek();

	for (int i = k; i <nums.length; i++) {
	    pq.remove(nums[startIndex]);
	    pq.offer(nums[i]);
	    result[++startIndex] = pq.peek();
	}

	return result;
    }

    /** Different approach using Double Ended Queue data-structure to solve max sliding window problem. 
     * 
     *  Reason:
     *  
     *  Using deque :
     *  
     *  The idea is to use deque to hold the index of maximum element and restrict deque size to k. 
     *  In first while loop, we make sure that we remove the elements which are not longer in the sliding k range. 
     *  In second loop is we make sure that the elements in the deque is not smaller than the current element. 
     *  Then we add the element to the deque. 
     *  
     *  The if(i >= k - 1) is just to skip the first few elements that is less than k. For example, if k = 3, then we don't 
     *  want the first two elements added to the array. Also notice that our array is arr = new int[nums.length - k + 1] , as for 
     *  the fact that when we have k as the size of sliding windows, then the end result of sliding windows array 
     *  will be nums.length - k + 1.
     * 
     */
    public int[] maxValueUsingDeque(int[] nums, int k) {
	if (nums == null || nums.length == 0) 
	    return new int[0];

	int len = nums.length;
	int[] result = new int[len - k +1];
	int startIndex = 0;

	Deque<Integer> dq = new ArrayDeque<>();
	for (int i = 0; i < nums.length; i++) {

	    if (!dq.isEmpty() &&  dq.peek() < i-k+1) 
		dq.poll();
	    

	    while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) 
		dq.pollLast();
	    

	    dq.offer(i);
	    if (i >= k -1) 
		result[startIndex++] = nums[dq.peek()];
	}

	return result;
    }
}


