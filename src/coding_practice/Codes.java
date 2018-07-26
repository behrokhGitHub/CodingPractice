package CodingPractice;

public class Codes {
	
	/*
	 * Given a array of integers which is sorted. write a function to square each number of the Array in sorted way.
	 */
	public static int[] squareSortedArrayII ( int[] array ) {
		int len = array.length;
		int[] newArray = new int[len];
		int index = 0;
		
		int tempInd = 0;
		
		while ( tempInd < len ) {
			if ( array[tempInd] >= 0 ) {
				break;
			} else {
				tempInd++;
			}
		}
		
		int posIndex = tempInd;
		int negIndex = tempInd - 1;
		
		while ( posIndex < array.length && negIndex >= 0 ) {
			if ( array[posIndex]*array[posIndex] <= array[negIndex]*array[negIndex] ) {
				newArray[index++] = array[posIndex]*array[posIndex];
				posIndex++;
			} else {
				newArray[index++] = array[negIndex]*array[negIndex];
				negIndex--;
			} 
		}

		while ( posIndex < array.length ) {
				newArray[index++] = array[posIndex]*array[posIndex];
				posIndex++;
		}
		
		
		while ( negIndex >= 0 ) {
				newArray[index++] = array[negIndex]*array[negIndex];
				negIndex--;
		}
		
		return newArray;
	}
	
	
	/*
	 * A variation on Fibonacci: write a function that takes a number "n" and returns a string that contains all the first "n" Fibonacci numbers, in order, with a space separating them.  For example:
	For n = 6, the string would be "1 1 2 3 5 8"
	For n = 2, the string would be "1 1"
	For n = 1, the string would be "1"
	For n = 0, the string would be empty ""
	 */
	public static String fibonacciIterative ( int n ) {
		
		String res = "";
		
		if ( n < 0 ) {
			return null;
		}
		
		if ( n == 0 ) {
			return "\"\"";
		}
		
		int curr = 0;
		int pre = 1;
		
		for ( int i = 1; i <= n; i++ ) {
			int temp = curr;
			curr += pre;
			pre = temp;
			res = res + curr + " ";
		}
		
		res = res.substring(0, res.length()-1);
		return "\"" + res + "\"";
	}


	public static void main ( String[] args ) {
		
		/*
		 * squareSortedArray && squareSortedArrayII 
		 */		
//		int[] arrayI = {0, 3, 8, 9, 10};
//		int[] arrayII = {-9, -7, -4};
//		int[] arrayIII = {-9, -7, -4, 0, 3, 8, 9, 10};
//		int[] newArrayI = squareSortedArrayII(arrayI);
//		int[] newArrayII = squareSortedArrayII(arrayII);
//		int[] newArrayIII = squareSortedArrayII(arrayIII);
//	
//		for ( int i = 0; i < newArrayI.length; i++ ) {
//			System.out.print( newArrayI[i] + " " );
//		}
//		System.out.print( "\n");
//		for ( int i = 0; i < newArrayII.length; i++ ) {
//			System.out.print(newArrayII[i] + " "  );
//		}
//		System.out.print( "\n");
//		for ( int i = 0; i < newArrayIII.length; i++ ) {
//			System.out.print(newArrayIII[i] + " "  );
//		}
		
		/*
		 * fibonacciIterative test
		 */
//		for ( int i = 0; i <= 10; i++ ) {
//			String res = fibonacciIterative ( i );
//			System.out.println( res );
//		}
	
	}

}
