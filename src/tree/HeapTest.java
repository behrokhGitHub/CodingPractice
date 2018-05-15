package tree;

import java.util.Scanner;

public class HeapTest {
	
	
	public static void main ( String[] args ) {
		
//		MinHeap<Integer> minHeap = new MinHeap<Integer>();
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println( "Enter next int, done to stop " );
//		String line = sc.nextLine();
//		
//		while ( !line.equals("done") ) {
//			minHeap.insert( Integer.parseInt( line ) );
//			
//			System.out.println( minHeap );
//			System.out.println( "insert next int, done to stop " );
//			
//			line = sc.nextLine();
//		}
//
//		int max = minHeap.delete();
//		System.out.println( max + " " + minHeap );
//		
//		
//		max = minHeap.delete();
//		System.out.println( max + " " + minHeap );
//		
//		max = minHeap.delete();
//		System.out.println( max + " " + minHeap );
		
		
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println( "Enter next int, done to stop " );
		String input = scanner.nextLine();
		
		while ( !input.equals("done") ) {
			maxHeap.insert( Integer.parseInt( input ) );
			
			System.out.println( maxHeap );
			System.out.println( "insert next int, done to stop " );
			
			input = scanner.nextLine();
		}

		int min = maxHeap.delete();
		System.out.println( min + " " + maxHeap );
		
		min = maxHeap.delete();
		System.out.println( min + " " + maxHeap );

	}
}
