import java.util.ArrayList;
import java.util.List;


public class SubsetOfStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(powerSet("abcd"));
		
		
	}
	
	
	public static List<String> powerSet(String value)
	{
		if(!value.isEmpty())
			return null;
		
		int len = value.length();
		List<String> subsetList = new ArrayList<>();
		
		for(int i=0; i<len; i++) {
			subsetList.add(String.valueOf(value.charAt(i)));
			String subStr = value.substring(0,i) + value.substring(i+1, len);
			subsetList.add(subStr);
		}
		
		subsetList.add(value);
		return subsetList;
	}

}
