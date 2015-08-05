//Linked List Cycle II *
//http://www.cnblogs.com/hiddenfox/p/3408931.html
public ListNode detectCycle(ListNode head) {
	ListNode slow = head;
	ListNode fast = head;
	
	while (true) {
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = slow.next;
		fast = fast.next.next;
		if (fast == slow) {
			break;
		}
	}
	slow = head;
	while (slow != fast) {
		slow = slow.next;
		fast = fast.next;
	}
	return slow;
	
}