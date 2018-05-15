package CodingPractice;
import java.util.ArrayList;
import java.util.List;

public class BitManipulation {
	/*
	 * Power of Two
	 * Using n&(n-1) trick!
	 * Power of 2 means only one bit of n is ‘1’, so use the trick n&(n-1)==0 to judge whether that is the case 
	 */
	public static boolean powerOfTwo ( int n ) {
		
		if ( n <= 0 ) {
			return false;
		}
		
		if ( (n&(n-1)) == 0 ) {
			return true;
		}
		return false;
	}
	
	/*
	 * Sum of Two Integers
	 */
	public static int sumTwoIntegers ( int a, int b ) {
		if ( a == 0 || b == 0 ) {
			return 0;
		}
		
		while ( b != 0 ) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
	
	/*
	 * Sum of Two Integers
	 * Calculate the sum of two integers a and b, 
	 * but you are not allowed to use the operator + and - 
	 */
	public static int plusOperator ( int x, int y ) {
		
		int MASK = 0x0001;
		
		int x_bit = 0;
		int y_bit = 0;
		
		int c = 0;
		int z = 1;
		
		for ( int i = 0; i < Integer.SIZE; i++  ) {
		
			x_bit = ( ( x & MASK ) == MASK ) ? 1 : 0;
			y_bit = ( ( y & MASK ) == MASK ) ? 1 : 0;
			
			int d_bit = ( x_bit ^ y_bit ^ c );
			
			c = ( x_bit & y_bit ) | ( y_bit & c ) | ( x_bit & c );
			
			if ( d_bit != 0 ) {
				z = z | MASK;
			}
		
			MASK = MASK << 1;
			
		}
		
		return z;
	}
	
	
	public static void main ( String[] args ) {
		
		
		System.out.println( "plusOperator" );
		int result = plusOperator ( 6, 7 );
		System.out.println( "result is: " + result );

//		System.out.println();
//		System.out.println();
//		System.out.println();
//		
//		List<Integer> res = new ArrayList<>();
//		
//		int[] array = { 1, 8, 9, 7, 4, 5, 9, 7, 3};
//		
//		int sum = array[0];
//		
//		for ( int i = 1; i < array.length; i++ ) {
//			
//			sum ^= array[i];
//			
//			if ( sum != 0 ) {
//				res.add(sum);
//				sum = 0;
//			}
//		}
//		
//		System.out.println("res is: " + res);
//		
//		for ( int i = 1; i < 100; i++ ) {
//			if ( powerOfTwo(i) ) {
//				System.out.println( i + " " ); 
//			}
//		}
//		
//		System.out.println( "Sum of 6 plus 7 is: " + sumTwoIntegers(6, 7) ); 
//		
	}
}
