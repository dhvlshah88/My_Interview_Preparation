public class Driver {

    public static void main(String[] args) {

	//		long epoch = System.currentTimeMillis()/1000;
	//		System.out.println(epoch);
	//		
	//		long unixtime = epoch;
	//		Date date = new Date(unixtime * 1000);
	//		System.out.println(date);
	//
	//		int b = 3 % 256;
	//		System.out.println(b);
	//		
	//		
	//		// Stub for calling Palindrome's isPalindrome method.
	//		boolean answer = false;
	//		Palindrome palindromeObj = new Palindrome(); 
	//
	//		answer = palindromeObj.isPalindrome("Abuttuba");
	//	    System.out.println("The given string " + (answer ? "is" : "is not") + " palindrome.");
	//	    
	//	   String[] arr = new String[9];

	/*
		//Stub for calling BubbleSort's sort method.
		int i;
		int array[] = {12, 9, 4, 99, 120, 1, 3, 2, 3, 5};

		System.out.print("Values Before the sort:\n");
		for(i = 0; i < array.length; i++)
			System.out.print( array[i]+"  ");

		BubbleSort.sort(array, array.length);
		System.out.println();
		System.out.println();

		System.out.print("Values after the sort:\n");
		for(i = 0; i <array.length; i++)
			System.out.print(array[i]+"  ");
	 */
	//int b = -1;
	//System.out.println(Integer.toBinaryString(b) + " " + Integer.bitCount(b));
	/*
		BinaryTreeNode bn = new BinaryTreeNode(0);
	 	String[] colors = {"white", "pink", "red", "green", "red", "orange","Aa","BB"};
 	        HashSet<String> hs = new HashSet<String>();

	      for(int i = 0; i < colors.length; i++)  hs.add(colors[i]);

	      System.out.println(hs);

	      System.out.println("Does it contain green?  " + hs.contains("green"));

	      java.util.Iterator<String> itr = hs.iterator();

	      while(itr.hasNext())
	         System.out.print(itr.next()+" ");
	      System.out.println();


	      for(String str : hs)
	         System.out.print(str +" ");
	      System.out.println();
	 */       

	/*	
     BinaryTreeNode root = new BinaryTreeNode(8);
     root.insertNode(root, 5);
     root.insertNode(root, 4);
     root.insertNode(root, 10);
     root.insertNode(root, 12);
     root.insertNode(root, 6);
     root.insertNode(root, 11);

     root.preorderTraversal(root);

	 */


	/*	
	int[] abc = {1,2,3,6};

     for(int number : Arrays.copyOfRange(abc, abc.length/2 - 1, abc.length))
    	 System.out.println(number);


    System.out.println("abc".substring(0, 1));
    System.out.print("\n");
    System.out.print("end");


    long a = 1000 * 60 * 60 * 24 * 365L;
    long b = 1000 * 60 * 60 * 24 * 365;

    System.out.println(a);
    System.out.println(Integer.MAX_VALUE);


    long max=Integer.MAX_VALUE+1;
    for(int i=0;i<=10;i++)
    {
        max++; 
        System.out.println(max);
    }
	 *
	 *
	 */

	Driver d = new Driver();
	boolean ans = d.isValidSerialization("91,13,14,#,#,10");
	System.out.println(ans);

    }


    public boolean isValidSerialization(String preorder) {

	if (preorder.isEmpty())
	    return false;

	String[] node = preorder.split(",");
	int count = 0;
	for (int i = node.length - 1; i >= 0; i--) {
	    String temp = node[i];

	    if (temp.equals("#")) {
		count++;
	    } else {
		if (count < 2)
		    return false;
		else 
		    count--;
	    }
	}

	if (count == 1) {
	    return true;
	} else {
	    return false;
	}

	//	        int total = deserialize(node, 0);
	//	        return (node.length - 1) == total;
    }

    public int deserialize(String[] node, int i) {
	if (i > node.length-1 || node[i].equals("#")) {
	    return i;
	}

	i = deserialize(node, ++i);
	i = deserialize(node, ++i);
	return i;
    }

}
