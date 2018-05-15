package LinkedList;
/*
 * Test will be in My LinkedListTest.java
 */
public class MyStack {
	public ListNode head;
	public ListNode tail;
	public int size;
	
	public MyStack() {
		this.size = 0;
	}
	
	// same implementation as addLast() for linkedlist class
	public void push( Integer val ) {
		ListNode newNode = new ListNode(val);
		
		if ( tail == null ) {
			tail = head = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	// same implementation as removeLast() in linkedlist class
	public Integer pop() {
		
		if ( isEmpty() ) {
			return null;
		}
		
		Integer removed = tail.data;
		
		if ( size == 1 ) {
			
			head = tail = null;
			size = 0;
			
		} else {
			
			ListNode curr = head;
			
			while ( curr.next.next != null ) {
				curr = curr.next;
			}
			
			tail = curr;
			curr.next = null;
			size--;
		}
		
		return removed;
		
	}
	
	public Integer peek() {
		if ( tail == null ) {
			return null;
		} 
		return tail.data;
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
	
	public Integer getFirst() {
		if ( head == null ) {
			return null;
		}
		return head.data;
	}
}
