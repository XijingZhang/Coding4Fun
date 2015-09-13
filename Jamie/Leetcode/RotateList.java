//Rotate List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution 1: O(n) O(1)
public ListNode RotateList1(ListNode head, int k) {
	if ( head == null) {
		return null;
	}
	
	int length = getLength(head);
	k = k % length;
	
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	head = dummy;
	ListNode tail = dummy;
	
	for (int i = 0; i < k; i++) {
		head = head.next;
	}
	
	while (head.next != null) {
		tail = tail.next;
		head = head.next;
	}
	
	head.next = dummy.next;
	dummy.next = tail.next;
	tail.next = null;
	return dummy.next;
}

private int getLength(ListNode head) {
	int length = 0;
	while (head != null) {
		length ++;
		head = head.next;
	}
	return length;
}

// Solution 2: O(n) O(1)
public ListNode RotateList2(ListNode head, int k) {
	if (head == null)
		return head;
	int n = 1;
    ListNode h = head;
	
	// To get the length of List
    while (h.next != null) {
		h = h.next;
	    n++;
	}
	
	h.next = head;
	
	n = n - (k % n);
	while (n!=0) {
		head = head.next;
		h = h.next;
		n--;
	}
	h.next = null;
    return head;
}
