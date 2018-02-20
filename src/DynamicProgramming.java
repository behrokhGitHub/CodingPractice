import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {

	/*
	 * You visit a country where the currency has these bills: [$1, $7, $10].  You want to give somebody change 
	 * with the minimum number of bills returned.  Write a function that takes the amount desired and returns 
	 * that optimal combination of bills.  For example, if the input value is $14, the optimal solution is 2 bills of $7
	 *  (i.e. [0, 2, 0]) instead of a $10 and four $1 ([4, 0, 1]).
	 */
	
	public static List<Integer> change ( int[] currencies, int amount ) {
		List<Integer> curr = new ArrayList<>();
		List<Integer> best = new ArrayList<>();
		return changeHelper ( currencies, amount, curr, best );
	}
	
	public static List<Integer> changeHelper ( int[] currencies, int amount, List<Integer> curr, List<Integer> best ) {
		
			
		for ( int unit : currencies ) {
			
			if ( amount == 0 ) {
				return curr;
			}
			
			if ( unit <= amount ) {
				curr.add(unit);
				List<Integer> senario = changeHelper ( currencies, amount - unit, curr, best );
			
				if ( best.size() == 0 || senario.size() <= best.size() ) {
					best = new ArrayList<>(senario);
				}
				curr.remove( curr.size() - 1 );
			}
			
		}
		
		
		return best;
}

	



	public static void main ( String[] args ) {
		
		
		int[] currencies = {10, 7, 1};
		int amount = 14;
		List<Integer> result = change ( currencies, amount );
		System.out.println( result );
	}

}
