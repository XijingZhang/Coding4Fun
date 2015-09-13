//Palindrome Linked List 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Solution 1: O(n) O(n)
public boolean isPalindrome1(ListNode head) {
	if(head == null || head.next == null) {
		return true;
	}
	
	ListNode p = head;
	ListNode prev = new ListNode(head.val);
	
	while (p.next != null) {
		ListNode temp = new ListNode(p.next.val);
		temp.next = prev;
		prev = temp;
		p = p.next;
	}
	
	ListNode p1 = head;
	ListNode p2 = prev;
	
	while(p1 != null) {
		if (p1.val != p2.val) {
			return false;
		}
		
		p1 = p1.next;
		p2 = p2.next;
	}
	return true;
}


//Solution 2: O(n) O(1) *

public boolean isPalindrome2(ListNode head) {
	if (head == null || head.next == null) {
		return true;
	}
	
	ListNode fast = head;
	ListNode slow = head;
	
	while (fast.next != null && fast.next.next != null) {
		fast = fast.next.next;
		slow = slow.next;
	}
	
	ListNode secondHead = slow.next;
	slow.next = null;
	
	ListNode p1 = secondHead;
	ListNode p2 = p1.next;
	
	while (p1 != null && p2 != null) {
		ListNode temp = p2.next;
		p2.next = p1;
		p1 = p2;
		p2 = temp;
	}
	
	secondHead.next = null;
	
	ListNode p = (p2 == null ? p1 : p2);
	ListNode q = head;
	while (p != null) {
		if (p.val != q.val){
			return false;
		}
		p = p.next;
		q = q.next;
	}
	
	return true;
}

// Solution 3 : Using stack

public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }