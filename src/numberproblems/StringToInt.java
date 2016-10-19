package numberproblems;

public class StringToInt {

    public static int convertToInt(String strInput) throws NumberFormatException {
	int num = 0;
	for (int i = 0; i < strInput.length(); i++) {
	    if ((int) strInput.charAt(i) >= 48 && (int) strInput.charAt(i) <= 67) {
		num = num * 10 + strInput.charAt(i) - 48;
	    } else {
		throw new NumberFormatException();
	    }
	}

	return num;
    }

    public static void main(String[] args) {
	int test = StringToInt.convertToInt("123");
	test++;
	System.out.println(test);

    }

}
