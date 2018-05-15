package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Stack;

public class AdjListGraph extends Graph {

	HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	
	public AdjListGraph () {
		map = new HashMap<>();
	}
	
	@Override
	void implementAddVerticies( ) {
		int v = getNumVerticies();
		ArrayList<Integer> neighbors = new ArrayList<>();
		map.put(v, neighbors );
	}
	
	@Override
	void implementAddEdges( int v, int w ) {
		map.get(v).add(w);
	}

	@Override
	List<Integer> getNeighbors( int v ) {
		List<Integer> neighbors = map.get(v);
		return neighbors;
	}

	@Override
	List<Integer> getInNeighbors( int v ) {
		List<Integer> inComingNeighbors = new ArrayList<>();
		Set<Integer> neighbors = map.keySet();
		
		for ( Integer neighbor : neighbors ) {
			List<Integer> temp = map.get(neighbor);
			
			for ( Integer t : temp ) {
				if ( t == v ) {
					inComingNeighbors.add(t);
				}
			}
		}
		return inComingNeighbors;
	}

	@Override
	List<Integer> distanceTwo( int v ) {
		List<Integer> firstDegreeNeighbor = map.get( v );
		List<Integer> secDegreeNeighbor = new ArrayList<>();
		
		for ( Integer n : firstDegreeNeighbor ) {
			List<Integer> neighbors = map.get(n);
			for ( Integer neighbor : neighbors ) {
				if ( neighbor != v ) {
					secDegreeNeighbor.add(neighbor);
				}
			}
		}
		return secDegreeNeighbor;
	}
	
	HashMap<Integer, Integer> dfs ( Integer goal, Integer start ) {
		HashMap<Integer, Integer> parents = new HashMap<>();
		List<Integer> visited = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		visited.add(start);
		stack.push( start );
		
		while ( !stack.isEmpty() ) {
			
			Integer curr = stack.pop();
			
			if ( curr == goal ) {
				return parents;
			}
			
			List<Integer> neighbors = map.get(curr);
			ListIterator<Integer> it = neighbors.listIterator ( neighbors.size() );
			
			while ( it.hasPrevious() ) {
				Integer currNeighbor = it.previous();
				
				if ( !visited.contains(currNeighbor) ) {
					visited.add(currNeighbor);
					parents.put(currNeighbor, curr);
					stack.push(currNeighbor);
				}
			}
		}
		return parents;
	}
	
	HashMap<Integer, Integer> bfs ( Integer goal, Integer start ) {
		HashMap<Integer, Integer> parents = new HashMap<>();
		
		return parents;
	}
	
	List<Integer> constructPath ( Integer goal, Integer start, HashMap<Integer, Integer> parents ) {
		
		List<Integer> path = new LinkedList<>();
		path.add(goal);
		
		Integer curr = goal;
		
		while ( curr != start ) {
			Integer next = parents.get(curr);
			path.add(0, next);
			curr = parents.get(curr);
		}
		path.add( 0, start );
		return path;
	}

}
