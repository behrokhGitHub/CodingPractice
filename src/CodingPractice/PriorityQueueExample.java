package CodingPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class PriorityQueueExample {
	
	/*
	 * Given a large log file that records the request activities for 1 day on a busy website, containing over 1 billion records.  
	 * Each record is a separate line in the file.  Each line is of the form:
	 * 
	 * <timestamp>:<user_id>:<url-path>
	 * 
	 * For example:
	 * 
	 * 2018-04-18-16-30-24:00012345:/foo/bar/baz.html
	 * 
	 * Process that log file and print out the top K active users for that day, 
	 * where K is an input parameter (e.g. top 100 users), sorted from the most active to the least,
	 * along with their number of requests, e.g.
	 * 
	 * # Req    User ID
	 * 526        00012345
	 * 481        76523009
	 * ...
	 * 
	 */
	public static List<Pair> topKUsers ( String file, int k ) {
	
		String[] array = file.split(":");
		
		HashMap<String, Integer> map = new HashMap<>();
		
		MyComparator comparator = new MyComparator();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>( k, comparator );
		
		for ( String s : array ) {
			if ( s.matches("[0-9]+") ) {
				
				int count = map.getOrDefault( s, 0 ) + 1;
				map.put( s, count );
			}
		}
		
	    for ( Map.Entry< String, Integer > entry : map.entrySet() ) {
	    	
	    		Pair p = new Pair(entry.getKey(), entry.getValue());
	    		pq.offer(p); 
	    		if ( pq.size() > k ) {
	    			pq.poll();
	    		}
	    }
	    
	    List<Pair> result = new LinkedList<>();      
	            
	    while ( pq.size() > 0 ) {
	    		result.add(pq.poll());
	    }
	    
	    Collections.reverse( result );
	    return result;
	}

	
	public static void main ( String[] args ) {
		
		int k = 3;
		String file = "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00000123:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:01234567:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:01234567:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00001234:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00123456:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00001234:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00001234:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00123456:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00001234:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00123456:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00001234:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00123456:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00001234:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00123456:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00001234:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00123456:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00001234:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00123456:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00001234:/foo/bar/baz.html"
				+ "2018-04-18-16-30-24:00012345:/foo/bar/baz.html";
		
		List<Pair> result = topKUsers( file, k );
		System.out.println();
	    System.out.println("Count" + "   	     " + "UserId");
	    
	    for ( int i = 0; i < result.size(); i++ ) {
	    		System.out.println( result.get(i).getUserId() + "       	" + result.get(i).getCount() );
	    }
				
	}
}

	

class Pair {
	private String userId;
	private Integer count;
	
	public Pair( String userId, Integer count ) {
		this.userId = userId;
		this.count = count;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public Integer getCount() {
		return count;
	}
}
    

