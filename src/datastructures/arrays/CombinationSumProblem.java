package datastructures.arrays;

import java.util.*;

public class CombinationSumProblem {

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	if (candidates == null || candidates.length == 0)
	    return result;

	ArrayList<Integer> current = new ArrayList<Integer>();
	Arrays.sort(candidates);

	combinationSum(candidates, target, 0, current, result);

	return result;
    }

    public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr,
	    ArrayList<ArrayList<Integer>> result) {
	if (target == 0) {
	    result.add(new ArrayList<Integer>(curr));
	    return;
	}

	for (int i = j; i < candidates.length; i++) {
	    if (candidates[i]>target)
		return;

	    curr.add(candidates[i]);
	    combinationSum(candidates, target - candidates[i], i+1, curr, result);
	    curr.remove(curr.size() - 1);
	}
    }
    
    public ArrayList<ArrayList<Integer>> combinationSumII(int[] candidates, int target) {
  	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

  	if (candidates == null || candidates.length == 0)
  	    return result;

  	ArrayList<Integer> current = new ArrayList<Integer>();
  	Arrays.sort(candidates);

  	combinationSumII(candidates, target, 0, current, result);

  	return result;
      }

    public void combinationSumII(int[] candidates, int target, int j, ArrayList<Integer> curr,
	    ArrayList<ArrayList<Integer>> result) {
	if (target == 0) {
	    result.add(new ArrayList<Integer>(curr));
	    return;
	}
	
	if (target < 0)
	    return;

	int prev = -1;
	for (int i = j; i < candidates.length; i++) {
	    if (prev != candidates[i]) {
		curr.add(candidates[i]);
		combinationSumII(candidates, target - candidates[i], i+1, curr, result);
		curr.remove(curr.size() - 1);
		prev = candidates[i];
	    }
	}
    }
    
    public static void main(String[] args) {
	CombinationSumProblem csp = new CombinationSumProblem();
	int [] candidates = {10, 1, 2, 7, 6, 1, 5};
	int target = 8;
	
	ArrayList<ArrayList<Integer>> results = csp.combinationSumII(candidates, target);
	for (ArrayList<Integer> comb : results) {
	    System.out.println(comb);
	}
    }

}
