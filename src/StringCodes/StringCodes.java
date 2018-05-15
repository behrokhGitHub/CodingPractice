package StringCodes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringCodes {
	
	/*
	 * Reverse words in an String " sky is blue "
	 */
	public static String reverseWords(String s) {
		
		
		if ( s == null || s.length() == 0 ) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		String[] array = s.split(" ");
		
		for ( int i = array.length - 1; i >= 0; i-- ) {
			if ( !array[i].equals( " " ) ) {
				sb.append( array[i] );
				sb.append( " ");
			}
		}
		
		
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1 );	
    }
	
	/*
	 * Reverse words in an String II, without allocating extra space!
	 * given is a char[] array!
	 */
	public static String reverseWordsII(char[] s) {
		
		reverseArray( s, 0, s.length - 1 );
		
		int index = 0;
		
		for ( int i = 0; i < s.length; i++ ) {
			
			if ( i == s.length || s[i] == ' ' ) {
				reverseArray( s, index, i - 1 );
				index = i + 1;
			}
		}
		
		reverseArray( s, index, s.length - 1 );
		return new String ( s );
	}
	
	/*
	 * reverse an array of char.
	 */
	
	public static void reverseArray ( char[] array, int low, int high ) {
		while ( low < high ) {
			char temp = array[high];
			array[high] = array[low];
			array[low] = temp;
			low++;
			high--;
		}
		
	}
	
	/*
	 * Check Permutation
	 */
	public static boolean permutation ( String s1, String s2 ) {
		// Check both s1, and s2 have the same length.
		// compare s1 and s2 one moving forward, one moving backward.
		return false;
	}
	
	
	/*
	 * Palindrome Permutation
	 * We need to have even number of almost all characters, and one an odd count.
	 */
	public static boolean palindromePermutation ( String s ) {
		
		int[] array = new int[26];
		
		for ( int i = 0; i < s.length(); i++ ) {
			if ( s.charAt(i) != ' ' ) {
				array[s.charAt(i) - 'a']++;
			}
		}
			
		int oddOcc = 0;
			
		for ( int i = 0; i < array.length; i++ ) {
			if ( array[i] % 2 == 1 ) {
				oddOcc++;
			}
			
			if ( oddOcc > 1 ) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/*
	 * Valid Anagram
	 */
	public static boolean isAnagram(String s, String t) {
	       
        int[] array = new int[26];
        
        for ( int i = 0; i < s.length(); i++ ) {
            array[ s.charAt(i) - 'a' ]++;
        }
        
        for ( int i = 0; i < t.length(); i++ ) {
            array[ t.charAt(i) - 'a' ]--;
        }
        
        for ( int i = 0; i < array.length; i++ ) {
            if ( array[i] != 0 ) {
                return false;
            }
        }
        return true;
    }
	
	
	/*
	 * Write a program to remove the duplicates from a string
	 */
	public static String removeDuplicates ( String str ) {
		str = str.toLowerCase();
		char[] array = str.toCharArray();
		Set<Character> set = new HashSet<>();
		String newStr = "";
		
		for (int i = 0; i < array.length; i++ ) {
			if ( !set.contains( ( array[i] ) ) ) {
				set.add(array[i]);
				newStr += array[i];
			}
		}
		
		return newStr;
	}
	
	
	/*
	 * Write a program to return the longest common prefix in an array of String
	 */
	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String pre = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	    return pre;
	}
	
	/*
	 * Longest Substring without repeating character.
	 * 
	 * an example: "abdajklmnd"
	 *                       |
	 *                       why?
	 */
	public static int longestSubstring ( String s ) {
		
		char[] array = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		int j = 0;
		
		for ( int i = 0; i < array.length; i++ ) {
			
			if ( map.containsKey(array[i]) ) {
				j = Math.max(j, map.get(array[i]) + 1 );
			}
			
			map.put(array[i], i);
			maxLen = Math.max(maxLen, i - j + 1 );
		}
		
		return maxLen;
	}
	
	
	
	
	
	//***********************************************************************************************************************
	//***********************************************************************************************************************
	//***********************************************************************************************************************
	
	public static void main ( String[] args ) {
		
		/*
		 * reverseWordsII : given an array of characters
		 */
//		char[] array = {'s', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u','e' };
//		System.out.print("The reversed String is: "+ reverseWordsII ( array ) );
		
		/*
		 * Test reverseWords
		 */
//		String sRW = "sky is blue";
//		System.out.print("The reversed String is: "+ reverseWords( sRW ) );
		
		/*
		 * Test longestSubstring
		 */
//		String slcss = "abdajklmnd";
//		System.out.print("The longest substring wo repeating character has a length of "+ longestSubstring( slcss ) + "." );
		 
		/*
		 * TEST: removeDuplicates ( String str )
		 */
//		String str = "aaaaabbbbbBcCcccdDddddmmmmmttttyyyklgvrtil";
//		String newStr = removeDuplicates(str);
//		System.out.print("The new String without duplicates: "+ newStr);
		
		
		/*
		 * isAnagram
		 */
//		System.out.println(" nagaram is a valid anagram of anagram:" + isAnagram("nagaram", "anagram"));
		
		
		/*
		 * test palindromePermutation
		 */
//		String strPP1 = "tact coa";
//		String strPP2 = "tact coac";
//		System.out.println( "strPP1 is a Palindrome Permutation: " + palindromePermutation(strPP1) );
//		System.out.println( "strPP1 is a Palindrome Permutation: " + palindromePermutation(strPP2) );
		
		/*
		 * Test longestCommonPrefix	
		 */
//		String[] array = { "abc", "abcdlk", "abcd", "abc", "abfcd"};
//		System.out.println("The Longest Common Prefix is: "+ longestCommonPrefix( array ));
	    
		
//		String s = "abcabcbb";
//		
//        HashMap < Character, Integer > map = new HashMap<Character, Integer>();
//        
//        int max = 0;
//        
//        for ( int i = 0, j = 0; i < s.length(); ++i ){
//        	
//        		System.out.println( "i and j are: "+ i + j );
//        		
//            if ( map.containsKey ( s.charAt(i) ) ) {
//            		
//                j = Math.max( j, map.get ( s.charAt(i) ) + 1 );
//                System.out.println("s.charAt(i): " +  s.charAt(i) );
//                System.out.println("j: " + j );
//            }
//            map.put ( s.charAt(i), i );
//            max = Math.max ( max, i - j + 1 );
//        }
//        System.out.println("max is: "+ max);
//		
		        
	}

}
