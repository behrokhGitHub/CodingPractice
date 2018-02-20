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
			System.out.println( "USING memo ");
			return memo.get(amount);
		}
			
		if ( amount == 0 ) {
			System.out.println( "amount is zero. ");
			return new ArrayList<>();
		}
			
		List<Integer> best = new ArrayList<>();
		
		for ( int unit : currencies ) {
			List<Integer> curr = new ArrayList<>();
			if ( unit <= amount ) {
				System.out.println( "amount is: " + amount + " and unit is: " + unit );
				curr.add(unit);
				System.out.println( "curr is: " + curr);
				
				List<Integer> scenario = changeHelperI ( currencies, amount - unit, memo );
				System.out.println( "scenario is: " + scenario );
				
				for ( int element : scenario ) {
					curr.add(element);
					System.out.println( "curr after is: " + curr);
				}
				
				if ( best.size() == 0 || curr.size() <= best.size() ) {
					System.out.println( "deciding on best ..." );
					best = curr;
					System.out.println( "best is: " + best );
				}
			}
		}
		
		memo.put( amount, best );
		System.out.println( "memo is: " + memo ); 
		
		return best;
	}


	public static void main ( String[] args ) {
		
		int[] currencies = {10, 7, 1};
		int amount = 14;
		List<Integer> result = change ( currencies, amount );
		System.out.println( result );
	}

}
