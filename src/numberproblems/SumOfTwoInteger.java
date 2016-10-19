package numberproblems;

public class SumOfTwoInteger {

    public static int add(int leftOperand, int rightOperand) {
	if (leftOperand == 0) return rightOperand;
	if (rightOperand == 0) return leftOperand;
	
	while (rightOperand != 0) {
	    int carry = leftOperand & rightOperand;
	    leftOperand = leftOperand ^ rightOperand;
	    rightOperand = carry << 1;
	}
	
	return leftOperand;
    }
    
    public static int subtract(int leftOperand, int rightOperand) {
	while (rightOperand != 0) {
	    	//~leftOperand - It's called two's complement
		int borrow = (~leftOperand) & rightOperand;
		leftOperand = leftOperand ^ rightOperand;
		rightOperand = borrow << 1;
	}
	
	return leftOperand;
}
    
    public static void main(String[] args) {
	System.out.println("Result :" + SumOfTwoInteger.add(8, 9));
	System.out.println("Result :" + SumOfTwoInteger.subtract(8, 9));
    }
}
