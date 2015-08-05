// Partition List
public ListNode partition(ListNode head, int x) {
	if (head == null) {
		return null;
	}
	ListNode helper = new ListNode(0);
	helper.next = head;
	ListNode slow = helper;
	ListNode fast = helper;
	while (fast.next != null) {
		if (fast.next.val < x) {
			if(slow != fast) {
				ListNode next = fast.next.next;
				fast.next.next = slow.next;
				slow.next = fast.next;
				fast.next = next;
			}
			else {
				fast = fast.next;
			}
			slow = slow.next;
			
		}
		else {
			fast = fast.next;
		}
		
	}
	return helper.next;
}