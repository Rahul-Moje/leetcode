/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/
public class AddTwoNumbers {

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode();
		l1.val = 9;
		ListNode s1 = l1;
		ListNode l2 = new ListNode();
		ListNode s2 = l2;
		l2.val = 1;
		l2.next = new ListNode();
		l2 = l2.next;
		l2.val = 9;
		l2.next = new ListNode();
		l2 = l2.next;
		l2.val = 9;
		l2.next = new ListNode();
		l2 = l2.next;
		l2.val = 9;
		l2.next = new ListNode();
		l2 = l2.next;
		l2.val = 9;
		l2.next = new ListNode();
		l2 = l2.next;
		l2.val = 9;
		l2.next = new ListNode();
		l2 = l2.next;
		l2.val = 9;
		l2.next = new ListNode();
		l2 = l2.next;
		l2.val = 9;
		
		ListNode lres = new Solution().addTwoNumbers(s1,s2);
	}
	
	

}
class ListNode {
	
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode res = new ListNode();
    	ListNode startPoint = res;
    	int carry = 0;
    	int digit = 0;
    	while(l1 != null || l2!= null) {
    		int num1 = l1 == null ? 0 : l1.val;
    		int num2 = l2 == null ? 0 : l2.val;
    		digit = num1 + num2 + carry;
    		if(digit >= 10){
    			digit %= 10;
    			carry = 1;
    		}
    		else
    			carry = 0;
    		res.val = digit;
    		if(l1 != null)
    			l1 = l1.next;
    		if(l2 != null)
    			l2 = l2.next;
    		if(l1 !=null || l2 != null) {
    			res.next = new ListNode();
    			res = res.next;
    		}
    	}
    	if(carry != 0 ) {
    		res.next = new ListNode();
    		res = res.next;
    		res.val = carry;
    	}
    	return startPoint;
    }

	
}
 
