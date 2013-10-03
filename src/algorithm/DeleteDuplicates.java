package algorithm;

import util.ListNode;

public class DeleteDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if(head==null)
			return null;
        ListNode fake = new ListNode(head.val-1);
        fake.next = head;
        ListNode prev = fake;
        ListNode cur = head;
        while(cur!=null){
            while(cur.next!=null && cur.val==cur.next.val){
                cur=cur.next;
            }
            if(prev.next!=cur){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        return fake.next;
    }
	
	public void test(){
		ListNode head = ListNode.genList(new int[]{1,2,3,3,4,4,5});
		System.out.println(deleteDuplicates(head));
		head = ListNode.genList(new int[]{1,1,1,2,3,3,5,5});
		System.out.println(deleteDuplicates(head));
		head = ListNode.genList(new int[]{1});
		System.out.println(deleteDuplicates(head));
	}
}
