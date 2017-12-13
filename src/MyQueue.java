
public class MyQueue {

	public ListNode first;
	public ListNode last;
	public int size;
	
	public MyQueue() {
		this.size = 0;
	}
	
	public void enqueue( Integer val ) {
		ListNode newNode = new ListNode(val);
		
		if ( last == null ) {
			first = last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}
	
	public Integer dequeue () {
		if ( isEmpty() ) {
			return null;
		}
		
		Integer removed = first.data;
		first = first.next;
		size--;
		return removed;
	}
	
	public Integer peek() {
		if ( isEmpty() ) {
			return null;
		}
		return first.data;
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
	
	public Integer getFirst () {
		if ( first == null ) {
			return null;
		}
		
		return first.data;
	}
	
	public Integer getLast () {
		if ( last == null ) {
			return null;
		}
		
		return last.data;
	}
	
}
