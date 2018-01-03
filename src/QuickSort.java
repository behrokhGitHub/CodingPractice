
public class QuickSort {
	
	public static void quickSort( int[] array ) {
		quickSortHlper ( array, 0, array.length - 1);
	}
	
	public static void quickSortHlper ( int[] array, int first, int last ) {
		
		if ( last > first ) {
			int pivotInd = partition ( array, first, last );
			quickSortHlper ( array, first, pivotInd - 1 );
			quickSortHlper ( array, pivotInd + 1, last );
		}
	}
	
	public static int partition ( int[] array, int first, int last) {
		
		int pivot = array[first];
		int low = first + 1;
		int high = last;
		
		
		while ( low < high ) {
			
			while ( low <= high && pivot >= array[low] ) {
				low++;
			}
			
			while ( low <= high && pivot < array[high] ) {
				high--;
			}
			
			if ( low < high ) {
				int temp = array[high];
				array[high] = array[low];
				array[low] = temp;
			}
		}
		
		while ( high > first && array[high] >= pivot ) {
			high--;
		}
		
		if ( pivot > array[high] ) {
			array[first] = array[high];
			array[high] = pivot;
			return high;
		} else {
			return first;
		}
	}
	
	public static void main ( String[] args ) {
		int[] array = {5, 1, 7, 3};
		quickSort(array);
		for ( int i = 0; i < array.length; i++ ) {
			System.out.println(array[i]);
		}
	}
}
