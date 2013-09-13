package algorithm;

import program.Testable;
import util.ListNode;

public class Partition_List implements Testable {
	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(head==null)
			return null;
		ListNode small = null;
		ListNode cur_small = null;
		ListNode large = null;
		ListNode cur_large = null;
		while (head != null) {
			if (head.val < x) {
				if (small == null) {
					small = head;
					cur_small = head;
				} else {
					cur_small.next = head;
					cur_small = cur_small.next;
				}
			} else {
				if (large == null) {
					large = head;
					cur_large = head;
				} else {
					cur_large.next = head;
					cur_large = cur_large.next;
				}
			}
			head = head.next;
		}
		if (small == null) {
			return large;
		} 
		else if(large==null){
			return small;
		}else {
			cur_small.next = large;
			cur_large.next = null;
			return small;
		}
	}

	@Override
	public boolean test(Object[] args, Object res) {
		// TODO Auto-generated method stub
		System.out.println(partition((ListNode) args[0], (Integer) args[1]));
		return true;
	}

}
