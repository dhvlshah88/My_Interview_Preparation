package datastructures.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Heap {
	
	private static int[] arr;
	private static int len;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	        Random randomGenerator = new Random();
	        
	        try
	        {
	            System.out.print("Please enter array size : ");
	            len = Integer.parseInt(read.readLine());
	            //len = 10;
	        	
	            System.out.print("Please enter the random range : ");
	            int random = Integer.parseInt(read.readLine());
	            
	            // create array
	            arr = new int[len];
	            //arr = new int[] {8,57,36,68,52,0,68,42,40,33};
	            
	            // fill array
	            for(int i=0; i<len-1; i++) {
	                arr[i] = randomGenerator.nextInt(random);
	            }
	            
	            Heap heapStructure = new Heap();
	            
	            //Before using heap sort on array.
	            heapStructure.printArray();
	            
	            heapStructure.sort();
	            
	            heapStructure.insert(1);
	            
	            //After using heap sort on array.
	            heapStructure.printArray();
	            
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
			}
		
	}

	private void buildHeap(){
	
		for(int i = (arr.length/2) - 1; i >= 0; --i)
			heapify(i);
	}

	private void heapify(int n){

		int larger, left, right;
		
		larger = n;
		left = 2 * n;
		right = 2 * n + 1;

		if (left < len && arr[larger] < arr[left])
			larger = left;

		if (right < len && arr[larger] < arr[right])
			larger = right;

		if (larger != n)
		{
			exchange(n, larger);
			heapify(larger);
		}

	}
	
	
	private void insert(int value)
	{
		
		int pos = arr.length-1;
		Integer ins = value;
		
		for(; pos>1 && ins.compareTo(arr[pos/2])<0; pos/=2)
			arr[pos] = arr[pos/2];
		
		arr[pos] = value;
		
	}

	private void exchange(int n, int larger)
	{
		arr[n] = arr[larger] - arr[n];
		arr[larger] -=  arr[n];
		arr[n] += arr[larger];
	}
	
	public void sort()
	{
		buildHeap();
		
		--len;
		
		while(len > 1)
		{
			exchange(len, 0);
			--len;
			heapify(0);
		}
	}
	
	public void printArray()
	{
		System.out.println();
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i] + ",");
		}
	}
	
}
