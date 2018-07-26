package CodingPractice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/*
 * Implement a data structure "Foo" that holds a set of strings and also have an iterator over its contents 
 * that traverses the strings in chronological order (the order in which they were added).  
 * The API should support these methods (you design the interfaces), and analyze each method's big-O performance:
 * foo.Add(value): insert the "value" string if it's not already in
 * foo.Remove(value): remove the "value" string
 * foo.Contains(value): return True if the "value" string is in, otherwise return False
 * foo.Iterator(): return an iterator "it" used to loop chronologically over the strings
 * it.Value(): return the value string at the current iterator's position
 * it.Next(): advance the iterator to the next chronological position and indicate whether the iteration has finished
 */


public class Foo {
	
	private LinkedList<String> list;
	private ListNode<String> head;
	private Set<String> set;
	private int size;
	
	public Foo() {
		list = new LinkedList<>();
		set = new HashSet<>();
		head = null;
	}
	
	/*
	 * foo.Add(value): insert the "value" string if it's not already in
	 */
	public void add ( String value ) {
		
		if ( !set.contains( value ) ) {
			
			set.add( value );
			ListNode<String> newNode = new ListNode<>( value );
			
			if ( size == 0 ) {
				newNode.next = head;
				head = newNode;
			} else {
				ListNode<String> next = head;
				
				while ( next.next != null ) {
					next = next.next;
				}
				
				next.next = newNode;
				
			}
			size++;
		} 
	}
	
	/*
	 * foo.Remove(value): remove the "value" string
	 */
	public void remove ( String value ) {
		
		if ( size == 1 ) {
			head = null;
		} else {
		
			ListNode<String> curr = head;
			ListNode<String> pre = null;
		
			while ( curr.data != value ) {
				pre = curr;
				curr = curr.next;
			}
		
			if ( curr == head ) {
				ListNode<String> temp = head.next;
				head = temp;
			} else {
				pre.next = curr.next;
			}
	
		}
		
		set.remove( value );
		size--;
			
	}
	
	/*
	 * foo.Contains(value): return True if the "value" string is in, otherwise return False
	 */
	public boolean contains ( String value ) {
		
		if ( set.contains( value ) ) {
			return true;
		}
		
		return false;
	}
	
	public int size () {
		return size;
	}
	
	/*
	 * foo.Iterator(): return an iterator "it" used to loop chronologically over the strings
	 */
	public Iterator<String> iterator () {
		
		return new LinkedListIterator();
	}
	
	
	private class LinkedListIterator implements Iterator<String> {
		
		private ListNode<String> curr;
		private ListNode<String> pre;
		
		public LinkedListIterator () {
			curr = head;
			pre = null;
		}
		
		/*
		 * it.Next(): advance the iterator to the next chronological position and indicate whether the iteration has finished
		 */
		@Override
		public String next() {
			
			if ( curr == null ) {
				return null;
			}
			
			String result = curr.data;
			pre = curr; 
			curr = curr.next;
			
			return result;
		}
		
		
		/*
		 * it.Value(): return the value string at the current iterator's position
		 */
		public String value() {
			return curr.data;
		}

		@Override
		public boolean hasNext() {
			return curr != null;
		}
		
	}
	
	
	
}
