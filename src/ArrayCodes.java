
public class ArrayCodes {
	
	/*
	 * Best Time to Buy and Sell Stock I
	 * 
	 * Say you have an array for which the i-th element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction (buy one and sell one share of the stock), 
	 * design an algorithm to find the maximum profit.
	 */
	public static int buySellStock ( int[] array ) {
		
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		
		int minPrice_in_array = 0;
		int maxPrice_in_array = 0;
		
		for ( int i = 0; i < array.length; i++ ) {
			maxProfit = Math.max(array[i] - minPrice, maxProfit);
			minPrice = Math.min(array[i], minPrice);
		}
		
		return maxProfit;
	}
	
	
	
	public static void main ( String[] args ) {
		
		/*
		 * Best Time to Buy and Sell Stock I
		 */
		int[] array1 = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		System.out.print(buySellStock(array1));
	}
	

}
