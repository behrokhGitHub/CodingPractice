package CodingPractice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicProgramming {

	/*
	 * You visit a country where the currency has these bills: [$1, $7, $10].  You want to give somebody change 
	 * with the minimum number of bills returned.  Write a function that takes the amount desired and returns 
	 * that optimal combination of bills.  For example, if the input value is $14, the optimal solution is 2 bills of $7
	 *  (i.e. [0, 2, 0]) instead of a $10 and four $1 ([4, 0, 1]).
	 */
	
	public static List<Integer> change ( int[] currencies, int amount ) {
		HashMap<Integer, List<Integer>> memo = new HashMap<>();
		return changeHelperI ( currencies, amount, memo );
	}
	
	public static List<Integer> changeHelperI ( int[] currencies, int amount, HashMap<Integer, List<Integer>> memo ) {
			
		if ( memo.containsKey( amount )) {
			System.out.println("memo contains " + amount + ".");
			return memo.get(amount);
		}
			
			
		List<Integer> best = new ArrayList<>();
		int count = 0;
		
		for ( int unit : currencies ) {
			
			count++;
			List<Integer> curr = new ArrayList<>();
			List<Integer> scenario = new ArrayList<>();
			
			if ( unit <= amount ) {
				curr.add(unit);
				
				if ( amount - unit == 0 ) {
					System.out.println( "amount is zero, and curr is: " + curr );
					best = curr;
				} else {
					scenario = changeHelperI ( currencies, amount - unit, memo );
					if ( scenario.size() > 0 ) {
						for ( int element : scenario ) {
							curr.add(element);
						}
					}
					
					if ( best.size() == 0 || curr.size() <= best.size() ) {
						best = curr;
					} 
				}
			} 
			
			if ( count == currencies.length - 1 && best.size() == 0 ) {
				return best;
			}
		}
		
		
		memo.put(amount,  best);
		
		System.out.println( "memo is: " + memo ); 
		return best;
	}
	
	public static void main ( String[] args ) {
		
		int[] currencies = {3, 2};
		int amount = 5;
		List<Integer> result = change ( currencies, amount );
		System.out.println( result );
	}

}
