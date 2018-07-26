package CodingPractice;

import java.util.Iterator;

public class FooTest {
	
	public static void main ( String[] args ) {
		
		Foo foo = new Foo();
		
		/*
		 * foo.Add(value): insert the "value" string if it's not already in
		 */

		foo.add("1");
		foo.add("2");
		foo.add("3");
		foo.add("4");
		foo.add("5");
		foo.add("6");
		foo.add("7");
		foo.add("8");

		System.out.println(foo.size());
		
		
		/*
		 * foo.Remove(value): remove the "value" string
		 */
		
		foo.remove("4");
		System.out.println(foo.size());
		
		foo.remove("1");
		System.out.println(foo.size());
		
		foo.remove("8");
		System.out.println(foo.size());
		
		/*
		 * foo.Contains(value): return True if the "value" string is in, otherwise return False
		 */
		
		System.out.println(foo.contains("6"));
		System.out.println(foo.contains("4"));
		
		System.out.println(foo.contains("1"));
		System.out.println(foo.contains("8"));
		
		/*
		 * foo.Iterator(): return an iterator "it" used to loop chronologically over the strings
		 * it.Value(): return the value string at the current iterator's position
		 * it.Next(): advance the iterator to the next chronological position and indicate whether the iteration has finished
		 */
		
		Iterator<String> it = foo.iterator();		
		
		while ( it.hasNext() ) {
			System.out.println( it.next() );
		}
		
	}
	
	
	

}
