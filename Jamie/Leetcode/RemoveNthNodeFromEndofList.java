//Remove Nth Node From End of List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public ListNode removeNthFromEnd(ListNode head, int n) {
	if (n <= 0) {
		return null;
	}
	
	if (head == null || head.next == null) {
		return null;
	}
	
	ListNode faster = head;
	ListNode slower = head;
	
	for (int i = 0; i < n; i++) {
		faster = faster.next;
	}
	
	if(faster == null) {
		head = head.next;
		return head;
	}
	
	while (faster.next != null) {
		slower = slower.next;
		faster = faster.next;
	}
	
	slower.next = slower.next.next;
	return head;
}
	