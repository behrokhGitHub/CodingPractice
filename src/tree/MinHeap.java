package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MinHeap <T extends Comparable<T> > {
	
	private List<T> list;
	
	public MinHeap() {
		list = new ArrayList<>();
	}
	
	private void siftUp() {
		
		int k = list.size() - 1;
	
		while ( k > 0 ) {
			
			int p = ( k - 1 ) / 2;
			
			T child = list.get( k );
			T parent = list.get( p );
			
			if ( child.compareTo( parent ) > 0 ) {
				
				list.set( p, child );
				list.set( k, parent );
				
				k = p;
			} else {
				break;
			}
		}
		
	}
	
	private void siftDown () {
		
		int k = 0;
		int left = 2 * k + 1;
		
		while ( left < list.size() ) {
			
			int max = left;
			int right = left + 1;
			
			if ( right < list.size() ) {
				
				if ( list.get( right ).compareTo( list.get(left) ) > 0 ) {
					max++;
				}
				
			}
			
			if ( list.get( k ).compareTo( list.get( max )) < 0 ) {
				
				T temp = list.get(k);
				
				list.set( k, list.get(max) );
				list.set( max, temp );
				
				k = max;
				left = 2 * k + 1;
			} else {
				break;
			}
		}
	}
	
	
	public void insert ( T item ) {
		list.add( item );
		siftUp();
	}
	
	
	public T delete () {
		
		if ( list.size() == 1 ) {
			return list.remove( 0 );
		}
		
		T removedItem = list.get( 0 );
		list.set( 0, list.remove( list.size() - 1 ) );
		siftDown();
		
		return removedItem;
	}
	
	
	public int size () {
		return list.size();
	}
	
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	
	public String toString() {
		return list.toString();
	}
}
