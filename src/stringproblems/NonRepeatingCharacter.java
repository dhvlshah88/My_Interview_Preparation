package stringproblems;

import java.util.HashMap;

public class NonRepeatingCharacter {

    public static void main(String[] args) {
	String str = "JAVAV😀";
	NonRepeatingCharacter nrc = new NonRepeatingCharacter();
	System.out.println(nrc.firstNonRepeatingChar(str));
    }

    // Works for UTF 16 as well UTF 32.
    public String firstNonRepeatingChar(String str) {
	if (str == null || str.isEmpty())
	    return null;

	Object seenOnce = new Object(), seenMultiple = new Object();
	Object seen = null;

	HashMap<Integer, Object> map = new HashMap<>();
	for (int i = 0; i < str.length();) {
	    final int cp = str.codePointAt(i);
	    i += Character.charCount(cp);

	    seen = map.get(cp);
	    if (seen == null) {
		map.put(cp, seenOnce);
	    } else {
		if (seen == seenOnce) {
		    map.put(cp, seenMultiple);
		}
	    }
	}

	for (int i = 0; i < str.length();) {
	    final int cp = str.codePointAt(i);
	    i += Character.charCount(cp);

	    if (map.get(cp) == seenOnce) {
		return new String(Character.toChars(cp));
	    }
	}
	return null;
    }
}
