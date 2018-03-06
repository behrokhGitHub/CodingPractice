import java.util.ArrayList;
import java.util.List;

public class XMSC {
	/*
	 * Write a function that prints out the numbers from 1 to 100, each on one line, except that,
	 * if the number is a multiple of 3, print "Fizz" instead of the number, and if the number 
	 * if a multiple of 5, print "Buzz" instead, and if it's a multiple of both 3 and 5,
	 *  print "FizzBuzz" instead of the number.  In all other cases, print the number itself.
	 */
	public static String fizzBuzz ( int n ) {
		String res = "";

		if ( n  % 15 == 0 ) {
			res = "FizzBuzz";
		} else if ( n  % 5 == 0 ) {
			res = "Buzz";
		} else if ( n  % 3 == 0 ) {
			res = "Fizz";
		} else {
			Integer num = new Integer(n );
			res = num.toString();
		}
			
		return res;
	}
	
	
	
	/*
	 * program to count the number of one bits in an integer.
	 */
	
	/*
	 * Write a function that computes x^y (x to the power y) where x and y are integers.  
	 * Determine its runtime and think about possible optimizations.
	 */
	
	public static double powerRec ( int x, int y ) {
		
			if ( x == 0 && y != 0 ) {
				return 0;
			}
			
			if ( x == 0 && y == 0 ) {
				throw new ArithmeticException( "Zero to the zero power is undefined." );
			}
			
			if ( y == 0 ) {
				return 1;
			}
			
		    double res = 0;
			int pow = 0;
			
			if ( y < 0 ) {
      		   pow = -y;
      	    } else {
      		   pow = y;
      	    }
			 
	       double curr =  powerRec ( x, pow/2 ); 
	       
           if( pow % 2 == 0 ) {
        	       res = curr * curr;
           } else {
        	       res = x * curr * curr;
           }    
	        
	     
	        if ( y < 0 ) {
	        		return 1/res;
	        }
	        
	        return res;
	}
	
	public static double powerIterative ( int x, int y ) {
		
		if ( x == 0 ) {
			if ( y > 0 ) {
				return 0;
			} else {
				throw new ArithmeticException( "Zero to the zero power is undefined." );
			}
		}
		
		if ( y == 0 ) {
			return 1;
		}
		
		if ( y == 1 ) {
			return x;
		}
		
		
		int pow = Math.abs(y);
		if ( Math.abs(y) % 2 == 1 ) {
			pow = pow - 1;
		}
     
		int count = 0;
		double res = 1; 
		
		while ( count < pow/2 ) {
			res *= ( x * x );
			count++;
		}
		
		if ( Math.abs(y) % 2 == 1 ) {
			res *= x;
		}
		
        if ( y < 0 ) {
        		return 1/res;
        }
        
        return res;
	}
	
	public static void main ( String[] args ) {
		
		/*
		 * Test "FizzBuzz"
		 */
//		int input = 100;
//		int count = 0;
//		
//		while ( count++ < input ) {
//			System.out.println( fizzBuzz(count) );
//		}
		
		
		/*
		 * Test power functions
		 */
		
		for ( int i = 1; i < 30; i ++ ) {
			double resRec = powerRec ( 2, i);
			double resItr = powerIterative ( 2, i);
			System.out.println( "2^"+ i + " = " +  resRec + ", " + resItr );
		}
		
		int x = 2;
		int y = 5;
		
		int pow = Math.abs(y);
		System.out.println( "pow: " + pow);
		
		if ( pow % 2 == 1 ) {
			System.out.println( "pow is odd" );
			pow = pow - 1;
			System.out.println( "pow: " + pow);
		}
     
		int res = 1 ;
		int count = 0; 
		
		while ( count <  pow / 2 ) {
			res *= x * x;
			System.out.println( "res is: " +  res );
			
			count++;
		}
		
		if ( y % 2 == 1 ) {
			System.out.println( "here: " );
			res *= x;
		}
		
        if ( y < 0 ) {
        		System.out.println( "y is less than 0; The Test Code Result is: " +  1/res );
        }
        
        System.out.println( "Test Code Result is: " + res );
        
		double result1 = powerRec ( 2, 2 );
		double result1p = powerIterative ( 2, 2 );
		System.out.println( "powerRec: " +  result1 + ", powerIterative: " + result1p);
		
		double result2 = powerRec ( 2, 10 );
		double result2p = powerIterative ( 2, 10 );
		
		double result3 = powerRec ( -3, 2 );
		double result3p = powerIterative ( -3, 2 );
		
		double result4 = powerRec ( -3, -2 );
		double result4p = powerIterative ( -3, -2 );
		
		double result5 = powerRec ( 2, -3 );
		double result5p = powerIterative ( 2, -3 );
		
		double result6 = powerRec ( -2, 3 );
		double result6p = powerIterative ( -2, 3 );
		
		double result7 = powerRec ( -2, -3 );
		double result7p = powerIterative ( -2, -3 );
		
		System.out.println( "result1: " + result1 + ", \n" + "result1p: " + result1p + ", \n\n"
				+ "result2: " + result2 + ", \n" + "result2p: " + result2p + ", \n\n"
				+ "result3: " + result3 + ", \n" + "result3p: " + result3p + ", \n\n"
				+ "result4: " + result4 + ", \n" + "result4p: " + result4p + ", \n\n"
				+ "result5: " + result5 + ", \n" + "result5p: " + result5p + ", \n\n"
				+ "result6: " + result6 + ", \n" + "result6p: " + result6p + ", \n\n"
				+ "result7: " + result7 + ", \n" + "result7p: " + result7p + "." );
//		
	}
	
}

