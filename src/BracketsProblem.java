import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BracketsProblem {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	for (int a0 = 0; a0 < t; a0++) {
	    String s = in.next();
	    if (isBalanced(s)) {
		System.out.println("YES");
	    } else {
		System.out.println("NO");
	    }
	}
	in.close();
    }

    public static boolean isBalanced(String brackets) {
	if (brackets == null || brackets.isEmpty())
	    return false;
	
	// odd number would always result in false
        if (brackets.length() % 2 != 0)
            return false;

	Deque<Character> brStack = new LinkedList<>();
	for (int i = 0; i < brackets.length(); i++) {
	    char c = brackets.charAt(i);
	    if (c == '{' || c == '[' || c == '(') {
		brStack.push(c);
	    } else if (!brStack.isEmpty() && (c == '}' || c == ']' || c == ')')) {
		if (brStack.peek() == '{' && c == '}' || brStack.peek() == '[' && c == ']' || brStack.peek() == '(' && c == ')')
		    brStack.pop();
		else
		    return false;
	    } else 
		return false;
	}

	return brStack.isEmpty();
    }
}
