
public class MyLinkedListTest {

	public static void main ( String[] args ) {
		MyLinkedList ll = new MyLinkedList();
		
		ll.addFirst(2);
		ll.addFirst(1);
		
		ll.addLast(5);
		ll.addLast(6);
		
		ll.add(3, 2);
		ll.add(4, 3);
	
		ll.addLast(7);
		ll.addLast(8);
		ll.add(9, 8);
		
		System.out.println("Test add, addFirst, addLast: ");
		System.out.println("LinkedList Size after adding elements is : " + ll.size());
		
		for ( int i = 0; i < ll.size(); i++ ) {
			System.out.println(ll.get(i));
		}
		
		System.out.println("\nTest remove, removeFirst, removeLast: ");
		
		Integer removeFirst = ll.removeFirst();
		System.out.println("Testing removeFirst: " + removeFirst);
		
		Integer removeLast = ll.removeLast();
		System.out.println("Testing removeFirst: " + removeLast);
		
		System.out.println("LinkedList Size after removing(First,Last) elements is : " +ll.size());
		for ( int i = 0; i < ll.size(); i++ ) {
			System.out.println(ll.get(i));
		}
		
		// testing "remove" with index: 0, size-1, and random
		Integer remove = ll.remove(0);
		remove = ll.remove(ll.size()-1);
		remove = ll.remove(3);
		System.out.println("LinkedList Size after removing elements is : " +ll.size());
		
		for ( int i = 0; i < ll.size(); i++ ) {
			System.out.println(ll.get(i));
		}
		
		System.out.println("\nTest reverse: ");
		ll.reverse();
		for ( int i = 0; i < ll.size(); i++ ) {
			System.out.println(ll.get(i));
		}
		
	}
}
