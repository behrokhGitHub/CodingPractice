import java.util.HashSet;

public class MyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int size;
	
	public MyLinkedList() {
		this.size = 0;
	}

	// addFirst ( Integer val )
	public void addFirst ( Integer val ) {
		ListNode newNode = new ListNode(val);
		
		newNode.next = head;
		head = newNode;
		
		if ( tail == null ) {
			tail = head;
		}
		size++;
	}
	
	// addLast ( Integer val )
	public void addLast ( Integer val ) {
		ListNode newNode = new ListNode(val);
		
		if ( tail == null ) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}
	
	// add ( Integer val,  int index  )
	public void add ( Integer val,  int index ) {
		
		if ( index == 0 ) {
			addFirst(val);
		} else if  ( index >= size ) {
			addLast(val);
		} else {
			ListNode curr = head;
			ListNode newNode = new ListNode(val);
			
			for ( int i = 1; i < index ; i++ ) {
				curr = curr.next;
			}
			
			newNode.next = curr.next;
			curr.next = newNode;
			size++;
		}
	
	}
	
	// removeFirst()
	public Integer removeFirst() {
	
		if ( size == 0 ) {
			return null;
		} else {
			Integer val = head.data;
			
			ListNode temp = head.next;
			head = temp;
			
			size--;
			
			if ( head == null ) {
				tail = null;
			}
			return val;
		}
	}
	
	// removeLast()
	public Integer removeLast() {
		
		if ( size == 0 ) {
			
			return null;
			
		} else if ( size == 1 ) {
			
			ListNode temp = head;
			
			head = tail = null;
			size = 0;
			
			return temp.data;
			
		} else {
			
			ListNode curr = head;
			
			for ( int i = 0; i < size - 2; i++ ) {
				curr = curr.next;
			}	
			
			Integer removedData = tail.data;
			
			tail = curr;
			curr.next = null;
			
			size--;
			return removedData;	
		}
	}
	
	// remove (  int index  )
	public Integer remove ( int index ) {
		if ( index < 0 || index >= size ) {
			return null;
		}
		if ( index == 0 ) {
			return removeFirst();
		} else if ( index >= size -1 ) {
			return removeLast();
		} else {
			ListNode pre = head;
			
			for ( int i = 0; i < index-1; i++ ) {
				pre = pre.next;
			}
			
			ListNode curr = pre.next;
			pre.next = curr.next;
			
			size--;
			return curr.data;
		}
	}
	
	// removeDups()
	public void removeDuplicates () {
		HashSet<Integer> set = new HashSet<>();
		
		ListNode curr = head;
		ListNode prev = null;
		
		while ( curr != null ) {
			if ( !set.contains(curr.data) ) {
				set.add(curr.data);
				prev = curr;
				curr = curr.next;
			} else {
				curr = curr.next;
				prev.next = curr;
				size--;
			}
			
		}
	}
	
	// reverse ()
	public void reverse() {
		ListNode curr = head;
		tail = head;
		ListNode pre = null;
		ListNode next = null;
		
		while ( curr != null ) {
			
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		
		head = pre;
	}
	
	// size ()
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
	
	
	
}
