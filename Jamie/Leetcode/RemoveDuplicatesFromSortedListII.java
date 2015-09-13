//Remove Duplicates from Sorted List II 
public ListNode deleteDuplicates (ListNode head) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	
	ListNode node = dummy;
	while (node.next != null && node.next.next != null) {
		if (node.next.val == node.next.next.val) {
			int dup = node.next.val;
			while (node.next != null && node.next.val == dup) {
				node.next = node.next.next;
			}
		} else {
			node = node.next;
		}
	}
	return dummy.next;
}