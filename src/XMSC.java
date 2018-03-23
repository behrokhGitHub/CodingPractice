import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	public static double powerStack ( int x, int y ) {
		
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
		
		Stack<Integer> s = new Stack<>();
		
		while ( pow > 0 ) {
			s.push( pow );
			pow = pow / 2;
		}
		
		int res = 1 ;
		int curr = 1; 
		
		while ( !s.isEmpty() ) {
			pow = s.pop();
			curr = res;
			
			if ( pow % 2 == 1 ) {
				res = x * curr * curr;
			} else {
				res = curr * curr;
			}
		}
		
        if ( y < 0 ) {
        		return 1/res;
        }
        
        return res;
	}
	
	public static double powerIterativeBit ( int x, int y ) {
		
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
		
		int pow = Math.abs(y);
		
		int product = 1;
		int component = x; 
		
		while ( pow > 0 ) {
			
			if ( pow % 2 == 1 ) {
				product *= component;
			}
			component *= component;
			pow = pow / 2;
		}
		
        if ( y < 0 ) {
        		return 1/product;
        }
        
        return product;
	}
	
	public static double powerBit ( int x, int y ) {
		
		if ( x == 0 && y != 0 ) {
			return 0;
		}
		
		if ( x == 0 && y == 0 ) {
			throw new ArithmeticException( "Zero to the zero power is undefined." );
		}
		
		if ( y == 0 ) {
			return 1;
		}
		
		int pow = Math.abs(y);
		
		int product = 1;
		int component = x; 
		
		while ( pow > 0 ) {
			
			if ( (pow & 1) == 1 ) {
				product *= component;
			}
			component *= component;
			pow = pow >> 1;
		}
     
        if ( y < 0 ) {
        		return 1/product;
        }
        
        return product;
	}
	
	
	/*
	 * Write a function that takes an integer and returns the count of its '1' bits
	 */
	public static int countNumOneBit ( int input ) {
		
		int count = 0;
		int res = 0;
		
		while ( input >= 1 ) {
			res = input % 2;
			
			if ( res == 1 ) {
				count++;
			}
			
			input /= 2;
		}
		
		return count;
	}
	
	// AND with 1:
	public static int countNumOneBitII ( int input ) {
		
		int count = 0;
		
		while ( input >= 1 ) {
			
			if ( (input & 1) == 1 ) {
				count++;
			}
			
			input = input >> 1;
		}
		
		return count;
	}
	
	public static int countNumOneBitRec ( int input ) {
		
		if ( input == 1 ) {
			return 1;
		} else {
			return ( input & 1 ) + countNumOneBitRec (input >> 1 );
		}
		
	}
	
	public static void main ( String[] args ) {
		
		/*
		 * Test "countNumOneBit"
		 */
//		int input = 15;
//		System.out.println(countNumOneBitRec(input));
		
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
		
		for ( int i = 1; i < 30; i++ ) {
			double resRec = powerRec ( 2, i);
			double resItr = powerBit ( 2, i);
			System.out.println( "2^"+ i + " = " +  resRec + ", " + resItr );
		}
//		
//		int x = 2;
//		int y = 15;
//		
//		Stack<Integer> s = new Stack<>();
//		
//		while ( y > 0 ) {
//			s.push( y );
//			y = y / 2;
//		}
//		
//		int curr = 1;
//		int res = 1;
//		
//		while ( !s.isEmpty() ) {
//			curr = res;
//			int pow = s.pop();
//			
//			if ( pow % 2 == 1 ) {
//				res = x * curr * curr;
//			} else {
//				res = curr * curr;
//			}
//		}
//		System.out.println( "res: " +  res );
//		
		
    
////        
//		double result1 = powerRec ( 2, 2 );
//		double result1p = powerIterative ( 2, 2 );
//		System.out.println( "powerRec: " +  result1 + ", powerIterative: " + result1p);
//		
//		double result2 = powerRec ( 2, 10 );
//		double result2p = powerIterative ( 2, 10 );
//		
//		double result3 = powerRec ( -3, 2 );
//		double result3p = powerIterative ( -3, 2 );
//		
//		double result4 = powerRec ( -3, -2 );
//		double result4p = powerIterative ( -3, -2 );
//		
//		double result5 = powerRec ( 2, -3 );
//		double result5p = powerIterative ( 2, -3 );
//		
//		double result6 = powerRec ( -2, 3 );
//		double result6p = powerIterative ( -2, 3 );
//		
//		double result7 = powerRec ( -2, -3 );
//		double result7p = powerIterative ( -2, -3 );
		
//		System.out.println( "result1: " + result1 + ", \n" + "result1p: " + result1p + ", \n\n"
//				+ "result2: " + result2 + ", \n" + "result2p: " + result2p + ", \n\n"
//				+ "result3: " + result3 + ", \n" + "result3p: " + result3p + ", \n\n"
//				+ "result4: " + result4 + ", \n" + "result4p: " + result4p + ", \n\n"
//				+ "result5: " + result5 + ", \n" + "result5p: " + result5p + ", \n\n"
//				+ "result6: " + result6 + ", \n" + "result6p: " + result6p + ", \n\n"
//				+ "result7: " + result7 + ", \n" + "result7p: " + result7p + "." );
////		
	}
	
}

