////  Definition for singly-linked list.
//class ListNode {
//	int val;
//	ListNode next;
// 
//	ListNode(int x) {
//		val = x;
//		next = null;
//	}
//}
// 
//// Definition for binary tree
//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
// 
//	TreeNode(int x) {
//		val = x;
//	}
//}
// 
//public class Solution {
//	static ListNode h;
// 
//	public TreeNode sortedListToBST(ListNode head) {
//		if (head == null)
//			return null;
// 
//		h = head;
//		int len = getLength(head);
//		return sortedListToBST(0, len - 1);
//	}
// 
//	// get list length
//	public int getLength(ListNode head) {
//		int len = 0;
//		ListNode p = head;
// 
//		while (p != null) {
//			len++;
//			p = p.next;
//		}
//		return len;
//	}
// 
//	// build tree bottom-up
//	public TreeNode sortedListToBST(int start, int end) {
//		if (start > end)
//			return null;
// 
//		// mid
//		int mid = (start + end) / 2;
//		
//		//System.out.println("Mid =" + mid + ", Start = " + start + ", End = " + end);
//		
//		TreeNode left = sortedListToBST(start, mid - 1);
//		TreeNode root = new TreeNode(h.val);
//		h = h.next;
//		TreeNode right = sortedListToBST(mid + 1, end);
// 
//		root.left = left;
//		root.right = right;
// 
//		return root;
//	}
//
//	public static void main(String[] args) {
//		
//		ListNode head = new ListNode(12);
//		head.next = new ListNode(37);
//		head.next.next = new ListNode(99);
//		
//		
//		Solution sn = new Solution();
//		TreeNode root = sn.sortedListToBST(head);
//		
//
//	}
//	
//	
//
//}

import java.util.*;
import java.text.*;

public class Solution {

    private static SimpleDateFormat twentyFourHrFormat = new SimpleDateFormat("HH:mm:ss");
    private static  SimpleDateFormat twelveHrFormat = new SimpleDateFormat("hh:mm:ssa");

    public static void main(String[] args) {
	//        Scanner in = new Scanner(System.in);
	//        String time = in.next();
	//        System.out.println(convertTo24HrFormat(time));
	//        in.close();

	String str = "JAVABC😀";
	for (int i = 0; i < str.length(); i++) {
	    int cp = str.codePointAt(i);
	    System.out.println(Character.charCount(cp) == 1? "not special" : "special");
	    System.out.println(str.charAt(i) + " - " + cp + " - " + new String(Character.toChars(cp)));
	}

    }

    public static String convertTo24HrFormat(String time12Hr) {
	Calendar cal = Calendar.getInstance();
	try {
	    cal.setTime(twelveHrFormat.parse(time12Hr));     
	} catch(Exception ex) {
	    System.err.println(ex.getMessage());
	}

	int am_pm = cal.get(Calendar.AM_PM);
	int hour = 0;
	if (am_pm == Calendar.PM) {
	    hour = cal.get(Calendar.HOUR);
	    hour += 12;
	    cal.set(Calendar.HOUR_OF_DAY, hour);
	}

	System.out.println(cal.get(Calendar.HOUR_OF_DAY));

	return twentyFourHrFormat.format(cal.getTime());
    }
}

