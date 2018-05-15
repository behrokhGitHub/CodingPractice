package CodingPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
	
	public static void main ( String[] args ) {
				
		String[] input = {"2018-04-18-16-30-24:00012345:/foo/bar/baz.html", "2018-04-18-16-30-24:00012345:/foo/bar/baz.html",
				"2018-04-18-16-30-24:00000123:/foo/bar/baz.html", "2018-04-18-16-30-24:01234567:/foo/bar/baz.html",
				"2018-04-18-16-30-24:01234567:/foo/bar/baz.html", "2018-04-18-16-30-24:00012345:/foo/bar/baz.html",
				"2018-04-18-16-30-24:00001234:/foo/bar/baz.html", "2018-04-18-16-30-24:00123456:/foo/bar/baz.html",
				"2018-04-18-16-30-24:00001234:/foo/bar/baz.html", "2018-04-18-16-30-24:00012345:/foo/bar/baz.html",
				"2018-04-18-16-30-24:00012345:/foo/bar/baz.html", "2018-04-18-16-30-24:00001234:/foo/bar/baz.html",
				"2018-04-18-16-30-24:00123456:/foo/bar/baz.html", "2018-04-18-16-30-24:00012345:/foo/bar/baz.html" };
		
		
		int timeStampLen = 19;
		int userIdLen = 8;
		int k = 3;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		MyComparator comparator = new MyComparator();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>( k, comparator );
		
		for ( String s : input ) {
		
			int userId = Integer.valueOf( s.substring( timeStampLen + 1, timeStampLen + userIdLen + 1) );
			
			if ( map.containsKey( userId ) ) {
				map.put( userId, map.get(userId) + 1 );
			} else {
				map.put( userId, 1 );
			}
			
		}
	
        for ( Map.Entry< Integer, Integer > entry : map.entrySet() ) {
        	
        		Pair p = new Pair(entry.getKey(), entry.getValue());
        		
            pq.offer(p);
            
            if( pq.size() > k ){
                pq.poll();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        Iterator<Pair> it = pq.iterator();
        
        while ( it.hasNext() ) {
        		Pair curr = (Pair) it.next();
        		System.out.println( curr.getUserId() + ", " +  curr.getCount() );
        		result.add( curr.getUserId() );
        }
        
        Collections.reverse( result );
        
        System.out.println();
        System.out.println("Count" + "   " + "UserId");
        
        for ( int i = 0; i < result.size(); i++ ) {
        		System.out.println( map.get( result.get(i) ) + "       " + result.get(i));
        }
	}
}

class Pair {
	private Integer userId;
	private Integer count;
	
	public Pair( Integer userId, Integer count ) {
		this.userId = userId;
		this.count = count;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public Integer getCount() {
		return count;
	}
}
    

