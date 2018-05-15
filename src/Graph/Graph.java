package Graph;

import java.util.List;

public abstract class Graph {
	
	int numVerticies;
	int numEdges;
	
	public Graph () {
		numVerticies = 0;
		numEdges = 0;
	}
	
	public int getNumVerticies ( ) {
		return numVerticies;
	}
	
	public int getNumEdges ( ) {
		return numEdges;
	}
	
	public void addVertices ( ) {
		implementAddVerticies ( );
		numVerticies++;
	}

	public void addEdges ( int v, int w ) {
		implementAddEdges ( v, w );
		numEdges++;
	}
	
	abstract void implementAddEdges( int v, int w );

	abstract void implementAddVerticies();
	
	abstract List<Integer> getNeighbors( int v );

	abstract List<Integer> getInNeighbors( int v );
	
	abstract List<Integer> distanceTwo ( int v );
	
}
