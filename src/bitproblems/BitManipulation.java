package bitproblems;

public class BitManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(BitManipulation.numOnesInBinary(256));
		//System.out.println(BitManipulation.powerOf2(7));
		//System.out.println(BitManipulation.powerOf2(256));

		System.out.println(numOnesInBinary(-11));
		System.out.println(reverseBit(-11));
		System.out.println(Integer.toBinaryString(-170));
		System.out.println(Integer.toBinaryString(Integer.reverseBytes(-170)));
		
		System.out.println(addBinary("11", "1"));
		
		
		//System.out.println(Integer.toBinaryString(-7));
	}



	public static int numOnesInBinary( int number ) {
		int numOnes = 0;
		while( number != 0 ){
			if( ( number & 1 ) == 1 ) {
				numOnes++;
			}
			number = number >>> 1;
		}
		return numOnes;
	}
	
	public static boolean powerOf2(int number){
		boolean ans =  false;
		
		if((number & -number) == number){
			ans = true;
		}
		
		return ans;
	}
	
	
	public static int reverseBit(int number)
	{
		System.out.println(Integer.toBinaryString(number));
		int result = 0;
		
		while(number != 0)
		{
			result <<= 1;
			result |= (number & 1);
			number >>>= 1;
		}
		
		System.out.println(Integer.toBinaryString(result));
		return result;
	}

	public static boolean isMultipleOf5(int number)
	{
		int mask = 5; 
		while((mask << 1) < number)
		{
			mask <<= 1;
		}
		
		while(mask >= 5)
		{
			if(number>=mask)
			{
				number -= mask;
			}
			
			mask >>= 1;
		}
		
		return number == 0;
	}
	
	
	public static String makeLengthEqual(String str1, String str2)
	{
		int len1 = str1.length();
		int len2 = str2.length();
		
		int diff = len1-len2;
		
		if(diff > 0)
		{
			for(int i = 0; i<diff; i++)
				str2 = "0" + str2;
		}
		
		return str2;
	}
	
	public static String addBitStrings(String str1, String str2)
	{
		str2 = makeLengthEqual(str1, str2);
		
		int len = str2.length();
		int sum = 0, carry = 0;
		int firstStrBit, secStrBit;
		
		String result = null;
		
		for(int i = len - 1; i >= 0; i--)
		{
			firstStrBit = str1.charAt(i) - '0';
			secStrBit = str2.charAt(i) - '0';
			
			sum = (firstStrBit ^ secStrBit ^ carry) + '0';
			carry = (firstStrBit & secStrBit) | (secStrBit & carry) | (firstStrBit & carry);
			
			result = (char) sum + result;
		}
		
		if(carry == 1)
			result = "1" + result; 
		
		return result;
	}
	
	 public static String addBinary(String a, String b) {
       if (a==null ||a.length()==0){
           return b;
       }
       
       if (b==null || b.length()==0){
           return a;
       }
       
      StringBuilder sb=new StringBuilder();
      
       
       int lastA=a.length()-1;
       int lastB=b.length()-1;
       int carry=0;
       
       
       while (lastA>=0 || lastB>=0) {
           int num1=lastA>=0?a.charAt(lastA--)-'0':0;
           int num2=lastB>=0?b.charAt(lastB--)-'0':0;
           int current=(num1+num2+carry)%2;
           carry=(num1+num2+carry)/2;
           
           sb.insert(0, current);
       }
       
       if (carry == 1)
    	   		sb.insert(0, carry);
       
       return sb.toString();
   }
}
