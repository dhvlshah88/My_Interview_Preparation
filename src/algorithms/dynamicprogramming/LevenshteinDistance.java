package algorithms.dynamicprogramming;

public class LevenshteinDistance {

	private static int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
 
	public static int computeLevenshteinDistance(String str1,String str2) {
		int[][] distance = new int[str1.length() + 1][str2.length() + 1];
 
		for (int i = 0; i <= str1.length(); i++)
			distance[i][0] = i;
		
		for (int j = 1; j <= str2.length(); j++)
			distance[0][j] = j;
  
		for (int i = 1; i <= str1.length(); i++)  {
			for (int j = 1; j <= str2.length(); j++)  {
				distance[i][j] = minimum(
	 					distance[i - 1][j] + 1,     //Delete
						distance[i][j - 1] + 1,     //Insert
						distance[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1) //Replace
						);
			}
		} 
 
		return distance[str1.length()][str2.length()];    
	}
	
	static int computeLevenshteinDistanceRecursive(String str1, String str2, int i, int j) {
		
		if (i == 0 && j == 0) 
			return 0;
		
		if (i == 0)
			return j;
		
		if (j == 0)
			return i;
		
		int insert = computeLevenshteinDistanceRecursive(str1, str2, i, j-1) + 1; //insert
		int delete = computeLevenshteinDistanceRecursive(str1, str2, i-1, j) + 1; //delete
		int substi = computeLevenshteinDistanceRecursive(str1, str2, i-1, j-1) + (str1.charAt(i-1) != str2.charAt(j-1) ? 1 : 0); // Replace
		
		return minimum(insert, delete, substi);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String [] data = { "intention", "execution"};
        
		for (int i = 0; i < data.length; i += 2) {
            System.out.println("distance(" + data[i] + ", " + data[i+1] + ") = " + computeLevenshteinDistance(data[i], data[i+1]));
        		System.out.println("distance(" + data[i] + ", " + data[i+1] + ") = " + computeLevenshteinDistanceRecursive(data[i], data[i+1], data[i].length(), data[i+1].length()));
		}
		
	}

}
