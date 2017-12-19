
/*
 * Test will be in My LinkedListTest.java
 */
public class MyStack {
	public ListNode top;
	public ListNode first;
	public int size;
	
	public MyStack() {
		this.size = 0;
	}
	
	public void push( Integer val ) {
		ListNode newNode = new ListNode(val);
		
		if ( top == null ) {
			top = first = newNode;
		} else {
			top.next = newNode;
			top = newNode;
		}
		size++;
	}
	
	public Integer pop() {
		
		if ( isEmpty() ) {
			return null;
		}
		
		ListNode prev = first;
		Integer removed = top.data;
		
		for ( int i = 0; i < size-1; i++ ) {
			prev = prev.next;
		}
		// OR:
		/*
		 * while ( first != last && prev.next.next != null ) {
		 * 		prev = prev.next;
		 */
		
		prev.next = null;
		top = prev;
		size--;
		return removed;
		
	}
	
	public Integer peek() {
		if ( top == null ) {
			return null;
		} 
		return top.data;
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
		ListNode curr = first;
		
		for ( int i = 0; i < index; i++ ) {
			curr = curr.next;
		}
		
		return curr.data;
	}
	
	public Integer getFirst() {
		return first.data;
	}
}
