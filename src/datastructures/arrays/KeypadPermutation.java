package datastructures.arrays;

public class KeypadPermutation {
    
    static int count = 0;
    
    private char[] getCharSetForNumber(int num) {
	switch(num) {
		case 2:  return "abc".toCharArray();
		case 3:  return "def".toCharArray();
		case 4:  return "ghi".toCharArray();
		case 5:  return "jkl".toCharArray();
		case 6:  return "mno".toCharArray();
		case 7:  return "pqrs".toCharArray();
		case 8:  return "tuv".toCharArray();
		case 9:  return "wxyz".toCharArray();
	}
	
	throw new IllegalArgumentException();
    }
    
    public void permutate(int input[]) {
	char[] result = new char[input.length];
	permutate(input, 0 , result);
    }
    
    public void permutate(int input[], int pos, char result[]) {
	if (pos == input.length) {
	    for (char c : result) 
		System.out.print(c);
	    
	    System.out.println();
	    count++;
	    return;
	}
	
	char[] keyChars = getCharSetForNumber(input[pos]);
	for (char keyChar : keyChars) {
	    result[pos] = keyChar;
	    permutate(input, pos+1, result);
	}
    }
  
    public static void main(String args[]) {
	int input[] = {2,3,2,5};
	KeypadPermutation kp = new KeypadPermutation();
	kp.permutate(input);
	System.out.println("Total Output:" + count);
    }
    
    
}
