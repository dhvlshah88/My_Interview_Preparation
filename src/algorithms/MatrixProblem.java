package algorithms;

public class MatrixProblem {

    public static void main(String[] args) {
	
	int[][] m = {{0,0,0,1},{0,0,1,1},{0,1,1,1}};
	
	MatrixProblem mp = new MatrixProblem();
	int result = mp.countZeros(m);
	System.out.println("No of zeroes are " + result);
    }

    /* Question: 
       You are given a matrix with N rows and N columns. Elements in matrix can be either 1 or 0. Each row and column of matrix is sorted in ascending order. 
   	Find number of 0-s in the given matrix. 
    	Example:
	
    	0 0 1
    	0 1 1
    	1 1 1
    	Answer: 3
	
    	0 0
    	0 0
    	Answer: 4
    */
    
    public int countZeros(int[][] matrix) {
	int row = matrix.length-1, col = 0, count = 0;
	
	while(col < matrix[0].length) {
	    while (matrix[row][col] != 0) {
		if (--row < 0) {
		    return count;
		}
	    }
	    
	    count += row + 1;
	    col++;
	}
	
	return count;
    }
    	
}
