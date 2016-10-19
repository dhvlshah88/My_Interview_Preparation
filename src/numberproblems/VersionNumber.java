package numberproblems;

/**
 * 
 * @author Dhaval
 * 
 * This program compares two version numbers and accordingly prints out which one of them is latest or same.
 */

public class VersionNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int output = VersionNumber.compare("10.5", "10.3.4");
		
		switch (output) {
		case -1:
			System.out.println("Version 1 is latest.");
			break;

		case 1:
			System.out.println("Version 2 is latest.");
			break;
			
		case 0:
			System.out.println("Both version are same.");
			break;
			
		default:
			break;
		}
	}

	public static int compare(String v1, String v2){
		String[] sp1 = v1.split("\\.");
		String[] sp2 = v2.split("\\.");
		
	    int min = sp1.length > sp2.length ? sp2.length : sp1.length;
	    
	    for(int i=0; i<min; i++){
	    	int n1 = Integer.parseInt(sp1[i]);
	    	int n2 = Integer.parseInt(sp2[i]);
	    	if(n1==n2)
	    		continue;
	    	else{
	    		return (n1-n2)>0?-1:1;
	    	}
	    }
	    
	    if(sp1.length!=sp2.length)
	    {
	    	return sp1.length>sp2.length?-1:1;
	    }
	    else
	    {
	    	return 0;
	    }
	}
	
	
}
