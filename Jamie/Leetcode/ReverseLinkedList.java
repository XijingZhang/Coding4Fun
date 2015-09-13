// Reverse Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution 1 Iterative
public ListNode reverseList(ListNode head) {
	ListNode prev = null;
	while (head != null) {
		ListNode temp = head.next;
		head.next = prev;
		prev = head;
		head = temp;
	}
	return prev
}

//Solution 2 Recursive
public ListNode reverseList(ListNode head) {
    if(head==null || head.next == null)
        return head;
 
    //get second node    
    ListNode second = head.next;
    //set first's next to be null
    head.next = null;
 
    ListNode rest = reverseList(second);
    second.next = head;
 
    return rest;
}