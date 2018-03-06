import java.util.List;

/*
 * A variation on Fibonacci: write a function that takes a number "n" and returns a string that contains all the first "n" Fibonacci numbers, in order, with a space separating them.  For example:
For n = 6, the string would be "1 1 2 3 5 8"
For n = 2, the string would be "1 1"
For n = 1, the string would be "1"
For n = 0, the string would be empty ""
 */
public class Fibonacci {
	
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
		
		for ( int i = 0; i <= 10; i++ ) {
			String res = fibonacciIterative ( i );
			System.out.println( res );
		}
		
	}
}
