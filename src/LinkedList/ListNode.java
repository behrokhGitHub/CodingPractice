package LinkedList;

public class ListNode<T> {
	public ListNode next;
	public Integer data;
	
	public ListNode() {
		this.next = null;
	}
	
	public ListNode(Integer val) {
		this.data = val;
	} 
}
