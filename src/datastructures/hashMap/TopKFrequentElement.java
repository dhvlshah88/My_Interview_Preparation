package datastructures.hashMap;

import java.util.*;

public class TopKFrequentElement {

    public static void main(String[] args) {
	int [] nums = {1,1,1,2,2,2,3,3,3,4};
	TopKFrequentElement top = new TopKFrequentElement();
	System.out.println(Arrays.asList(top.topKFrequent(nums, 2)));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
	Map<Integer, Integer> mp = new HashMap<>();
	int maxFreq = 0;
	
	for (int n : nums)  {
	    int freq = mp.getOrDefault(n, 0)+1;
	    mp.put(n, freq);
	    maxFreq = Math.max(maxFreq, freq);
	}
	
	List<List<Integer>> bucketList = new ArrayList<>(maxFreq);
	while(maxFreq-- >= 0) {
	    bucketList.add(new ArrayList<Integer>());
	}
	
	for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
	    int freq = entry.getValue();
	    bucketList.get(freq).add(entry.getKey());
	}
	
	List<Integer> result = new ArrayList<>();
	for (int pos = bucketList.size() -1; pos >= 0 && result.size() < k; pos--) {
	    result.addAll(bucketList.get(pos));
	}
	
	return result.subList(0, k);
    }
    
}
