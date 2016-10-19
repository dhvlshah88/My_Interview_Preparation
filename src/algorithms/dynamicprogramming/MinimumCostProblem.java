package algorithms.dynamicprogramming;

import java.util.Arrays;

/* 
You are given a range [first, last], initially white. You need to paint it black. 
For this purpose you have a set of triples 
[(f, l, cost), ...] - where each triple means that you can paint range [f, l] for `cost` coins (limitations: cost is floating point >= 0, f, l, first, last are integers). 
Find minimum cost needed to paint the whole range [first, last] or return -1 if it's impossible 
Example:


[first, last] = [0, 5] and set of triples is
[[0, 5, 10], [0, 4, 1], [0, 2,5], [2, 5, 1]]
Clearly the answer is to take [0, 4, 1] and [2, 5, 1] - the total cost will be 2. 
Another example:


[first, last] = [0, 5]
triples are [[1,4, 10], [2, 5, 6]]
answer is -1, because it's impossible to color whole range.
*/
public class MinimumCostProblem {
    
    class Triplet implements Comparable<Triplet> {
	private int first;
	private int last;
	private double cost;
    
	public Triplet(int first, int last, double cost) {
	    this.first = first;
	    this.last = last;
	    this.cost = cost;
	}
	
	@Override
	public int compareTo(Triplet obj) {
	    if (last == obj.last) {
		return obj.first - first;
	    }
	    
	    return last - obj.last;
	}
    }

    public double minimumCost(int first, int last, Triplet[] triplets) {
	Arrays.sort(triplets);
	double[] minCostForRange = new double[last+1];
	for (int rangeIndex = first+1; rangeIndex <= last; rangeIndex++) {
	    double minCost = Double.MAX_VALUE;
	    int len = triplets.length-1;
	
	    while (len >= 0) {
		if (triplets[len].first < rangeIndex && triplets[len].last >= rangeIndex) {
		    if (minCostForRange[triplets[len].first] != -1 && minCostForRange[triplets[len].first] + triplets[len].cost < minCost) {
			minCost = minCostForRange[triplets[len].first] + triplets[len].cost;
		    }
		}
		len--;
	    }
	    
	    if (minCost == Double.MAX_VALUE) {
		minCostForRange[rangeIndex] = -1;
	    } else {
		minCostForRange[rangeIndex] = minCost;
	    }
	}
	
	return minCostForRange[last];
    }
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
