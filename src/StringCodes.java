import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringCodes {
	/*
	 * Write a program to remove the duplicates from a string
	 */
	public static String removeDuplicates ( String str ) {
		str = str.toLowerCase();
		char[] array = str.toCharArray();
		Set<Character> set = new HashSet<>();
		
		for (int i = 0; i < array.length; i++ ) {
			set.add(array[i]);
		}
		
		String newStr = "";
		Iterator<Character> it = set.iterator();
		while (it.hasNext() ) {
			newStr += it.next();
		}
		
		return newStr;
	}
	
	//***********************************************************************************************************************
	//***********************************************************************************************************************
	//***********************************************************************************************************************
	
	public static void main ( String[] args ) {
		/*
		 * TEST: removeDuplicates ( String str )
		 */
		String str = "aaaaabbbbbBcCcccdDddddmmmmmttttyyyklgvrtil";
		String newStr = removeDuplicates(str);
		System.out.print("The new String without duplicates: "+ newStr);
	}

}
