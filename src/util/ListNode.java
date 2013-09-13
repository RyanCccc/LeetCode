package util;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		this.val = x;
		this.next = null;
	}
	
	public static ListNode genList(int[] A){
		ListNode head = new ListNode(A[0]);
		ListNode cur = head;
		for(int i=1; i<A.length; i++){
			cur.next = new ListNode(A[i]);
			cur = cur.next;
		}
		return head;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		ListNode temp = this;
		while(temp!=null){
			sb.append(temp.val+"->");
			temp = temp.next;
		}
		return sb.toString();
	}
}