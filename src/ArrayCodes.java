import java.util.ArrayList;
import java.util.Arrays;
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
	
	/*
	 * Permutation
	 * 
	 * Given an array of distinct numbers, return a list of all possible permutations.
	 * 
	 */
	public static List<List<Integer>> permutation (int[] array ) {
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		
		permutationHelper(res, temp, array);
		return res;
	}
	
	private static void permutationHelper(List<List<Integer>> res, List<Integer> temp, int[] array) {
		if ( temp.size() == array.length ) {
			res.add(new ArrayList<>(temp));
		} else {
			for ( int i = 0; i < array.length; i++ ) {
				if ( temp.contains(array[i]) ) {
					continue;
				}
				temp.add(array[i]);
				permutationHelper(res, temp, array);
				temp.remove(temp.size()-1);
			}		
		}
	}
	
	/*
	 * Unique Paths
	 * 
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	 * The robot can only move either down or right at any point in time. 
	 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	 * How many possible unique paths are there?
	 */
	public static int uniquePaths ( int row, int col ) {
		int[][] m = new int[row][col];
		
		for ( int i = 0; i < col; i++ ) {
			m[0][i] = 1;
		}
		
		for ( int j = 0; j < row; j++ ) {
			m[j][0] = 1;
		}
		
		for ( int i = 1; i < row; i++ ) {
			for ( int j = 1; j < col; j++ ) {
				m[i][j] = m[i-1][j] + m[i][j-1];
			}
		}
		return m[row-1][col-1];
	}
	
	/*
	 * 3Sum Closest
	 * 
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, 
	 * target. Return the sum of the three integers. 
	 * You may assume that each input would have exactly one solution.
	 */
	public static int threeSumClosest ( int[] array, int target ) {
		
		Arrays.sort(array);
		int result = array[0] + array[1] + array[array.length-1];
		
		for ( int i = 0; i < array.length; i++ ) {
			int start = i + 1;
			int end = array.length-1;
			
			while ( start < end ) {
				int sum = array[i] + array[start] + array[end];
				
				if (sum > target ) {
					end--;
				} else {
					start++;
				}
				
				if ( Math.abs( sum - target ) < Math.abs(result - target) ) {
					result = sum;
				}
			}
		}
				
		return result;
	}
	
	/*
	 * Peak Element
	 * 
	 * A peak element is an element that is greater than its neighbors.
	 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index
	 */
	public static int peakElement ( int[] array ) {
		int max = 0;
		int index = 0;
		
		for ( int i = 1; i < array.length-2; i++ ) {
			int curr = array[i];
			int prev = array[i-1];
			int next = array[i+1];
			
			if ( curr > prev && curr > next && curr > max ) {
				index = i;
				max = array[i];
			}
			
			if ( array[array.length-1] > max ) {
				return array.length-1;
			}
		}
		
		return index;
	}
	
	
	
	
	//***********************************************************************************************************************
	//***********************************************************************************************************************
	//***********************************************************************************************************************
	
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
		//System.out.println(subsetResult);
		
		/*
		 * Permutation
		 */
		int[] array3 = {1, 2, 3};
		List<List<Integer>> permutationResult = permutation(array2);
		//System.out.println(permutationResult);
		
		/*
		 * Unique Paths
		 */
		int row = 7;
		int col = 3;
		//System.out.println(uniquePaths(row, col));
		
		/*
		 * 3Sum Closest
		 */
		int[] array4 = {-1, 2, 1, 4};
		int target = 1;
		//System.out.println(threeSumClosest(array4, target));
		
		/*
		 * Peak Element
		 */
		int[] array5 = {1, 2, 3, 4};
		int[] array6 = {0, 5, 7, 6, 4, 6, 9, 0};
		//System.out.println("peak element in the first array is: " + peakElement(array5) + " , and in the second array is: " + peakElement(array6));
		
		
		
	}
	
	
}
