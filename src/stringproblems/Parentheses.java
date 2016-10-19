package stringproblems;

import java.util.*;

public class Parentheses {

	public static void main(String[] args) {
		Parentheses p = new Parentheses();
		String str1 = "(a)())()";
		System.out.println(Arrays.deepToString(p.removeInvalidParentheses(str1).toArray()));
		str1 = "()())()";
		System.out.println(Arrays.deepToString(p.removeInvalidParentheses(str1).toArray()));
		str1 = "(";
		System.out.println(Arrays.deepToString(p.removeInvalidParentheses(str1).toArray()));

//		p.removeInvalidParenthesesRecursive(str1, "", 0);
	}

	public List<String> removeInvalidParentheses(String s) {
		if (s == null)
			return null;
		
		List<String> listOfValidString = new ArrayList<>();
		String remainingStr = null;

		// if the string is already valid, add to list and return as there is no
		// need to remove any parentheses.
		if (this.isStringValid(s)) {
			listOfValidString.add(s);
			return listOfValidString;
		}

		// if the string is not valid, check for invalid parentheses, remove it
		// and add the valid string to list.
		for (int i = 0; i < s.length(); i++) {
			char singleChar = s.charAt(i);
			if (singleChar != '(' && singleChar != ')')
				continue;

			remainingStr = s.substring(0, i) + s.substring(i + 1, s.length());

			if (this.isStringValid(remainingStr) && !listOfValidString.contains(remainingStr)) {
				listOfValidString.add(remainingStr);
			}
		}

		if (listOfValidString.size() == 0)
			listOfValidString.add("");
		
		return listOfValidString;
	}

	public void removeInvalidParenthesesRecursive(String s, String result, int excludedIndex) {
		if (s.length() == 0 || s.length() == 1)
			throw new IllegalArgumentException("Empty parameter value!!!");

		if (s.length() == excludedIndex) {
			return;
		}

		if (this.isStringValid(result)) {
			System.out.println(result);
		}

		removeInvalidParenthesesRecursive(s, s.substring(0, excludedIndex) + s.substring(excludedIndex + 1, s.length()),
				++excludedIndex);
	}

	private Boolean isStringValid(String str) {
		int counter = 0;

		for (char singleChar : str.toCharArray()) {
			if (singleChar == '(')  
				++counter;
			
			if (singleChar == ')' &&  counter-- == 0) return false;
		}

		return counter == 0;
	}

}
