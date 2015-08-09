// Sort List

//O(nlgn)
// Merge Sort
public ListNode sortList(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}
	
	ListNode mid = findMiddle(head);
	
	ListNode right = sortList(mid.next);
	mid.next = null;
	ListNode left = sortList(head);
	
	return merge(left, right);
}
public ListNode findMiddle(ListNode head) {
	ListNode slow = head, fast = head.next;
	while (fast != null && fast.next != null) {
		fast = fast.next.next;
		slow = slow.next;
	}
	return slow;
}

private ListNode merge(ListNode head1, ListNode head2) {
	ListNode dummy = new ListNode(0);
	ListNode tail = dummy;
	while (head1 != null && head2 != null) {
		if (head1.val < head2.val) {
			tail.next = head1;
			head1 = head1.next;
		} else {
			tail.next = head2;
			head2 = head2.next;
		}
		tail = tail.next;
	}
	if (head1 != null) {
		tail.next = head1;
	} else {
		tail.next = head2;
	}
	
	return dummy.next;
}


// Quick Sort1
public ListNode sortList(ListNode head) {
	if (head == null || head.next == null) {
		return head;
	}
	
	ListNode mid = findMiddle(head);// )(n)
	
	ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
	ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
	ListNode middleDummy = new ListNode(0), middleTail = middleDummy;
	
	while (head != null) {
		if (head.val < mid.val) {
			leftTail.next = head;
			leftTail = head;
		} else if (head.val > mid.val) {
			rightTail.next = head;
			rightTail = head;
		} else {
			middleTail.next = head;
			middleTail = head;
		}
		head = head.next;
	}
	
	leftTail.next = null;
	middleTail.next = null;
	rightTail.next = null;
	
	ListNode left = sortList(leftDummy.next);
	ListNode right = sortList(rightDummy.next);
	return concat(left, middleDummy.next, right);
}

private ListNode concat(ListNode left, ListNode middle, ListNode right) {
	ListNode dummy = new ListNode(0), tail = dummy;
	tail.next = left; 
	tail = getTail(tail);
	tail.next = middle;
	tail = getTail(tail);
	tail.next = right;
	tail = getTail(tail);
	return dummy.next;
}

private ListNode getTail(ListNode head) {
	if (head == null) {
		return null;
	}
	
	while (head.next != null) {
		head = head.next;
	}
	return head;
}
