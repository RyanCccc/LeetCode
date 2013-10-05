package algorithm;

import program.Testable;
import util.ListNode;

public class ReverseKGroup implements Testable {
	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		int count = 0;
		while (head != null) {
			count++;
			if (count == k) {
				pre = reverseK(pre, head.next);
				head = pre.next;
				count = 0;
			} else {
				head = head.next;
			}
		}
		return fakeHead.next;
	}

	public ListNode reverseK(ListNode pre, ListNode next) {
		ListNode last = pre.next;
		ListNode cur = last.next;
		while(cur!=next){
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
	}

	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		return reverseKGroup((ListNode) args[0], (Integer) args[1]).equals(
				(ListNode) res);
	}
}
