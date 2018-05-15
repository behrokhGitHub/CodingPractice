package CodingPractice;

import java.util.Comparator;

public class MyComparator implements Comparator<Pair> {
	
    @Override
    public int compare( Pair objOne, Pair ObjTwo ) {
    		
    		Integer countOne = objOne.getCount();
    		Integer countTwo = ObjTwo.getCount();
    		
    		if ( countOne.compareTo( countTwo ) > 0 ) {
    			return 1;
    		} else if ( countOne.compareTo( countTwo ) < 0 ) {
    			return -1;
    		}
        return 0;
    }
}
