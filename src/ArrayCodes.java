import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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
	
	/*
	 * Missing Number
	 */
	public static int missingNumber ( int[] array ) {
		
		int n = array.length;
		int actual_sum = (n * (n+1))/2;
		
		int sum = 0;
		for ( int i = 0; i < array.length; i++ ) {
			sum += array[i];
		}
		return actual_sum - sum;
	}
	
	/*
	 * Find the duplicate Number
	 * Given an array containing n + 1 integers where each integer is between 1 and n (inclusive), 
	 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
	 * find the duplicate one.
	 * Note:
	 *	You must not modify the array (assume the array is read only).
	 *	You must use only constant, O(1) extra space.
	 *	Your runtime complexity should be less than O(n2).
	 *	There is only one duplicate number in the array, but it could be repeated more than once.
	 */
	public static int findDuplicateNumber ( int[] array ) {
		int slow = array[0];
	    int fast = array[array[0]];
	 
	    // making sure there is a loop
	    while ( slow != fast ) {
	        slow = array[slow];
	        fast = array[array[fast]];
	    }
	 
	    fast = 0;
	 
	    while(fast != slow){
	        slow = array[slow];
	        fast = array[fast];
	    }
	    return fast;
	}
	
	/*
	 * Find All Duplicates in an Array 
	 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
	 * Find all the elements that appear twice in this array.
	 * Could you do it without extra space and in O(n) runtime?
	 */
	public static List<Integer> findDuplicatesI ( int[] array ) {
		List<Integer> res = new ArrayList<>();
		
		// *IMPORTANT* 
		//because a[i] could be equal to n, means array.length, we have to minimize it with 1
		for ( int i = 0; i < array.length; i++ ) {
			int index = Math.abs(array[i])-1;
			if ( array[index] < 0 ) {
				res.add(index+1);
			}
			array[index] = -array[index];
		}
		
		return res;
	}
	
	/*
	 * Contains Duplicate
	 * Given an array of integers, find if the array contains any duplicates. 
	 * Your function should return true if any value appears at least twice in the array, 
	 * and it should return false if every element is distinct.
	 */
	public static boolean containsDuplicate ( int[] array ) {
		Arrays.sort(array);
		
		for ( int i = 1; i < array.length; i++ ) {
			if ( array[i] == array[i-1] ) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Contains Duplicate II
	 * Given an array of integers and an integer k, 
	 * find out whether there are two distinct indices i and j in the array such that "array[i] = array[j]" 
	 * and the absolute difference between i and j is at most k.
	 */
	public static boolean containsDuplicateII ( int[] array, int k ) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for ( int i = 0; i < array.length; i++ ) {
			if ( map.containsKey(array[i])) {
				int index = map.get(array[i]);
				if ( i - index <= k ) {
					return true;
				}
			}
			map.put(array[i], i);
		}
		return false;
	}
	
	/*
	 * Remove Duplicates from Sorted Array
	 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	 */
	public static int removeDuplicatesSortedArray ( int[] array ) {
		// *IMPORTANT* 
		// Both index and iteration start from 1.
		int index = 1;
		
		for ( int i = 1; i < array.length; i++ ) {
			if ( array[i] != array[i-1] ) {
				array[index++] = array[i];
			}
		}
		return index;
	}
	
	/*
	 * Given a array of integers which is sorted. write a function to square each number of the Array in sorted way.
	 */
	/* Solution: 
	* Considered 3 different cases, the input array contains: 
	* 1. only positive integers, 2. only negative integers, 3. Both positive and negative integers.
	* For the first and second cases, loop through the array, for the first case, from 0 to 
	* (array.length - 1), and for the second one from (array.length - 1) to 0, squared each element     
	*  and set the result in the newArray, and return it.
	* For the case that we have both positive, and negative integers, I have 2 pointers, one 
	* (posIndex) which keeps track of positive integers and moves forward, the other (negIndex)      
	* which keeps track of negative integers, and moves backward. At each step, I compare the       
	* absolute value of the array’s element at pos/negIndex, and construct the newArray.
	*/

	public static int[] squareSortedArray ( int[] array ) {
		int len = array.length;
		int[] newArray = new int[len];
		int index = 0;
		
		int posIndex = 0;
		int negIndex = 0;
		
		if ( array[0] >= 0 ) {
			for ( int i = 0; i < len - 1; i++ ) {
				newArray[index++] = array[i]*array[i];
			}
			return newArray;
		} else if ( array[len - 1] < 0 ){
			for ( int i = len - 1; i >= 0; i-- ) {
				newArray[index++] = array[i]*array[i];
			}
			return newArray;
		} else {
			while ( array[posIndex] < 0 ) {
				posIndex++;
			}
			negIndex = posIndex-1;
		}
		
		while ( posIndex < array.length && negIndex >= 0 ) {
			if ( Math.abs(array[posIndex]) < Math.abs(array[negIndex] )) {
				newArray[index++] = array[posIndex]*array[posIndex];
				posIndex++;
			} else if ( Math.abs(array[posIndex]) > Math.abs(array[negIndex]) ) {
				newArray[index++] = array[negIndex]*array[negIndex];
				negIndex--;
			} else {
				newArray[index++] = array[posIndex]*array[posIndex];
				newArray[index++] = array[negIndex]*array[negIndex];
				posIndex++;
				negIndex--;
			}
		}

		if ( posIndex < array.length ) {
			while ( posIndex < array.length ) {
				newArray[index++] = array[posIndex]*array[posIndex];
				posIndex++;
			}
		}
		
		if ( negIndex >= 0 ) {
			while ( negIndex >= 0 ) {
				newArray[index++] = array[negIndex]*array[negIndex];
				negIndex--;
			}
		}
		return newArray;
	}
	
	//***********************************************************************************************************************
	//***********************************************************************************************************************
	//***********************************************************************************************************************
	
	public static void main ( String[] args ) {
		int[] arrayI = {0, 3, 8, 9, 10};
		int[] arrayII = {-9, -7, -4};
		int[] arrayIII = {-9, -7, -4, 0, 3, 8, 9, 10};
		int[] newArrayI = squareSortedArray(arrayI);
		int[] newArrayII = squareSortedArray(arrayII);
		int[] newArrayIII = squareSortedArray(arrayIII);
	
		for ( int i = 0; i < newArrayI.length; i++ ) {
			System.out.print( newArrayI[i] + " " );
		}
		System.out.print( "\n");
		for ( int i = 0; i < newArrayII.length; i++ ) {
			System.out.print(newArrayII[i] + " "  );
		}
		System.out.print( "\n");
		for ( int i = 0; i < newArrayIII.length; i++ ) {
			System.out.print(newArrayIII[i] + " "  );
		}
		
		/*
		 * Best Time to Buy and Sell Stock I
		 */
		//int[] array1 = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		//System.out.print(buySellStock(array1));
		
		/*
		 * Subsets
		 */
		//int[] array2 = {1, 2, 3};
		//List<List<Integer>> subsetResult = subsets(array2);
		//System.out.println(subsetResult);
		
		/*
		 * Permutation
		 */
		//int[] array3 = {1, 2, 3};
		//List<List<Integer>> permutationResult = permutation(array2);
		//System.out.println(permutationResult);
		
		/*
		 * Unique Paths
		 */
		//int row = 7;
		//int col = 3;
		//System.out.println(uniquePaths(row, col));
		
		/*
		 * 3Sum Closest
		 */
		//int[] array4 = {-1, 2, 1, 4};
		//int target = 1;
		//System.out.println(threeSumClosest(array4, target));
		
		/*
		 * Peak Element
		 */
		//int[] array5 = {1, 2, 3, 4};
		//int[] array6 = {0, 5, 7, 6, 4, 6, 9, 0};
		//System.out.println("peak element in the first array is: " + peakElement(array5) + " , and in the second array is: " + peakElement(array6));
		
		/*
		 * Missing Number
		 */
		//int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		//System.out.println("The missing number is: " + missingNumber(array)); 
		
		
		/*
		 * Find the duplicate Number
		 * Given an array containing n + 1 integers where each integer is between 1 and n (inclusive)
		 */
		//int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 7};
		//int[] array = {1,1,2};
		//System.out.println("The duplicate number is: " +	findDuplicateNumber(array));
		
		/*
		 * Find All Duplicates in an Array 
		 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
		 */
		//int[] array = {4,3,2,7,8,2,3,1};
		//System.out.println("The duplicate numbers are: " +	findDuplicatesI(array));
		
		/*
		 * containsDuplicate
		 */
		//int[] array = {1,1,2};
		//System.out.println("Array Contains Duplicates? " +	containsDuplicate(array));
		
		/*
		 * containsDuplicateII
		 */
		//int[] array = {1, 2, 3, 7, 5, 6, 8, 9, 7, 10};
		//System.out.println("Is there any i and j: " +	containsDuplicateII(array, 5));
		
		/*
		 * removeDuplicatesSortedArray
		 */
		//int[] array = {1, 1, 1, 2, 3, 3, 5, 6, 6, 7};
		//System.out.println("The new Length is: " +	removeDuplicatesSortedArray(array));
		
//		String s = "AF71";
//		int decimal = 0;
//		
//		for ( int i = 0; i < s.length(); i++ ) {
//			char hex = s.charAt(i);
//			
//			int digit = (hex >= 'A' && hex <= 'F') ? (hex - 'A' + 10) : ( hex - '0' );
//			decimal += ( digit * Math.pow(16,  s.length() - 1 - i));
//		}
//		
//		System.out.println(decimal);
	}
	
	
}
