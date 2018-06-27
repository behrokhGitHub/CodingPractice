package Kazuhm;

import java.util.Comparator;

public class VelocityComparator implements Comparator<Pair> {

	@Override
	public int compare( Pair  p1, Pair p2 ) {
		Double diff = p2.velocity - p1.velocity;
		return diff.intValue();
	}

}
