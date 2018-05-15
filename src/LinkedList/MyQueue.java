package LinkedList;
public class MyQueue {

	private ListNode head;
	private ListNode tail;
	private int size;
	
	public MyQueue() {
		this.size = 0;
	}
	
	// same implementation as addFirst() in linked list class
	public void enqueue( Integer val ) {
		ListNode newNode = new ListNode(val);
		
		if ( tail == null ) {
			head = tail = newNode;
		} else {
			
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public Integer dequeue () {
		if ( isEmpty() ) {
			return null;
		}
		
		Integer removed = head.data;
		
		if ( head == tail ) {
			head = tail = null;
		} else {
			head = head.next;
		}
		size--;
		return removed;
	}
	
	public Integer peek() {
		if ( isEmpty() ) {
			return null;
		}
		return head.data;
	}
	
	public boolean isEmpty() {
		if ( size == 0 ) {
			return true;
		}
		return false;
	}
	
	public int size () {
		return size;
	}
	
	// get ( int index )
	public Integer get ( int index ) {
		ListNode curr = head;
		
		for ( int i = 0; i < index; i++ ) {
			curr = curr.next;
		}
		
		return curr.data;
	}
	
	public Integer getFirst () {
		if ( head == null ) {
			return null;
		}
		
		return head.data;
	}
	
	public Integer getLast () {
		if ( tail == null ) {
			return null;
		}
		
		return tail.data;
	}
	
}
