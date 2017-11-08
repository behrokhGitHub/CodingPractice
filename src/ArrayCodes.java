import java.util.ArrayList;
import java.util.List;

public class ArrayCodes {
	
	/*
	 * Best Time to Buy and Sell Stock I
	 * 
	 * TO DO: Best Time to Buy and Sell Stock II
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
	
	/*
	 * Subsets
	 * 
	 * TO DO: Subsets with having Duplicates
	 * 
	 * Given a set of distinct integers, nums, return all possible subsets (the power set).
	 * Note: The solution set must not contain duplicate subsets.
	 */
	public static List<List<Integer>> subsets (int[] array ) {
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		
		subsetsHelper(res, temp, array, 0);
		return res;
	}
	
	private static void subsetsHelper(List<List<Integer>> res, List<Integer> temp, int[] array, int start) {
		res.add(new ArrayList<>(temp));
		
		for ( int i = start; i < array.length; i++ ) {
			temp.add(array[i]);
			subsetsHelper(res, temp, array, i+1);
			temp.remove(temp.size()-1);
		}
	}

	public static void main ( String[] args ) {
		
		/*
		 * Best Time to Buy and Sell Stock I
		 */
		int[] array1 = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		//System.out.print(buySellStock(array1));
		
		/*
		 * Subsets
		 */
		int[] array2 = {1, 2, 3};
		List<List<Integer>> subsetResult = subsets(array2);
		System.out.println(subsetResult);
	}
	
	
}
