package Sort;
import java.util.Arrays;

public class MergeSort {
	
	public static void mergeSort ( int[] array ) {
		if ( array.length > 1 ) {
			
			int[] firstHalf = new int[array.length/2];
			System.arraycopy(array,  0, firstHalf, 0, array.length/2);
			mergeSort(firstHalf);
			
			int secLen = array.length-array.length/2;
			int[] secHalf = new int[secLen];
			System.arraycopy(array,  array.length/2, secHalf, 0, secLen);
			mergeSort(secHalf);
			
			merge(array, firstHalf, secHalf);
			
		}
	}
	
	public static void merge ( int[] array, int[] firstHalf, int[] secHalf ) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		while ( i <  firstHalf.length && j < secHalf.length ) {
			
			if ( firstHalf[i] < secHalf[j] ) {
				array[k++] = firstHalf[i++];
			} else  {
				array[k++] = secHalf[j++];
			}
		}
		
		while ( i < firstHalf.length ) {
			array[k++] = firstHalf[i++];
		}
		
		while ( j < secHalf.length ) {
			array[k++] = secHalf[j++];
		}
	}
	
	public static void main ( String[] args ) {
		int[] array = {5, 1, 7, 3};
		mergeSort(array);
		for ( int i = 0; i < array.length; i++ ) {
			System.out.println(array[i]);
		}
	}

}
