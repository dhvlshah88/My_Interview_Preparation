package numberproblems;

import java.util.*;

public class ReversePolishNotation {

	public double evaluate(String[] tokens) {
		if (tokens.length == 0)
			throw new IllegalArgumentException();

		double returnValue = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();
		for (String t : tokens) {
			if (!operators.contains(t)) {
				stack.push(t);
				continue;
			}

			double a = Integer.valueOf(stack.pop());
			double b = Integer.valueOf(stack.pop());
			int index = operators.indexOf(t);
			switch (index) {
			case 0:
				stack.push(String.valueOf(a + b));
				break;
			case 1:
				stack.push(String.valueOf(b - a));
				break;
			case 2:
				stack.push(String.valueOf(a * b));
				break;
			case 3:
				stack.push(String.valueOf(b / a));
				break;
			}
		}

		returnValue = Integer.valueOf(stack.pop());
		return returnValue;
	}
}
