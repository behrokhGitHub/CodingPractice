package LiangJavaBook;
public class LiangJavaPractice {
	
	/*
	 * Dec2Hex
	 */
	public static String dec2Hex ( int dec ) {
		
		String output = "";
		
		while ( dec != 0 ) {
			
			// Starting from modules first
			int hexVal = dec % 16;
			
			char hexDigit = ( hexVal >= 0 && hexVal <= 9 ) ? (char) ( hexVal + '0' ) : (char) ( hexVal - 10 + 'A' );
			
			output = hexDigit + output;
			
			dec = dec / 16;
			
		}
		
		return output;
	}
	
	/*
	 * Hex2Dec AB4D
	 */
	public static int hex2Dec ( String hex ) {
		
		int decimal = 0;
		
		for ( int i = 0; i < hex.length(); i++ ) {
			char c = hex.charAt(i);
			int n = dec (c);
			decimal += n * Math.pow(16, hex.length() - 1 - i );
		}
		
		return decimal;
	}
	
	public static int dec ( char hex ) {
		
		if ( hex >= 'A' && hex <= 'F' ) {
			return hex - 'A' + 10;
		} else {
			return hex - '0';
		}
	}
	
	/*
	 * GCD Greatest Common Divisor
	 */
	public static int gcd ( int n1, int n2 ) {
		
		int gcd = 1;
		int divisor = 2;
		
		while ( divisor <= n1 && divisor <= n2 ) {
			if ( n1 % divisor == 0 && n2 % divisor == 0 ) {
				gcd = divisor;
				divisor++;
			}
		}
		
		return gcd;
	}
	
	/*
	 * Prime Numbers
	 */
	public static boolean isPrime ( int num ) {
		
		for ( int i = 2; i < num/2; i++ ) {
			if ( num % i == 0 ) {
				return false;
			}
		}
		return true;
	}
	
	
	/*
	 * linearSearch ( p.266 )
	 */
	public static void linearSearch ( int[] array ) {
		
		
	}	
	
	/*
	 * binarySearch ( p. 268 )
	 */
	public static int binarySearch ( int[] array, int k ) {
		
		int low = 0; 
		int high = array.length - 1;
		
		while ( low < high ) {
			
			int mid = ( low + high ) / 2;
			
			if ( k < array[mid] ) {
				high = mid - 1;
			} else if ( k > array[mid] ) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	/*
	 * selectionSort ( page 270 )
	 */
	public static void selectionSort ( int[] array ) {
		
		for ( int i = 0; i < array.length; i++ ) {
			int min = array[i];
			int minInd = i;
			
			for ( int j = i + 1; j < array.length; j++ ) {
				if ( array[j] < min ) {
					min = array[j];
					minInd = j;
				}
			}
			
			if ( minInd != i ) {
				array[minInd] = array[i];
				array[i] = min;
			}
		}
		
	}
	
	/*
	 * StackofIntegers ( p. 379 )
	 */
	// This is a class not a function
	
	/*
	 * factorial ( p. 385 )
	 */
	public static int factorial ( int n ) {
		if ( n == 1 ) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
	
	public static void main ( String[] args ) {
		
		System.out.println(factorial(5));
		
		int[] nums = {2, 9, 5, 4, 8, 1, 6};
		selectionSort(nums);
		for ( int i = 0; i < nums.length; i++ ) {
			System.out.print ( nums[i] + " ");
		}
		
		System.out.println ();
		int decimal = hex2Dec ("AB8C");
		System.out.println( "decimal value is: " + decimal);
		
		
		int dec = 96;
		System.out.println( "hex value is: " + dec2Hex ( dec ));
		
		
		String s1 = "Java";
		
		char[] array = s1.toCharArray();
		for ( int i = 0; i < array.length; i++ ) {
			System.out.print ( array[i] + " ");
			System.out.println();
		}
		
		String s2 = String.valueOf( array );
		System.out.print ( s2 );
	}

}
