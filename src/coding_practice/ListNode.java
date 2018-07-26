package CodingPractice;

public class ListNode<String> {
	
	public ListNode<String> next;
	public String data;
	
	public ListNode() {
		this.next = null;
	}
	
	public ListNode(String val) {
		this.data = val;
	} 
}