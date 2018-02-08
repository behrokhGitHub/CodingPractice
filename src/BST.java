import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.lang.Comparable;

public class BST {
	
	private TreeNode root;
	private Integer size;
	
	public BST() {
		this.size = 0;
	}
	
	public Integer getSize() {
		return this.size;
	}
	
	public void preOrder ( ) {
		
		
	}
	
	public void inOrder ( ) {
		
	}
	
	/*
	 * 1) Create an empty queue (q) to store tree nodes
	 * 2) Create an empty list (result)  
	 * 2) temp_node = root /*start from root
	 * 3) Loop while the queue is not empty:
	    	a) remove the peek from the queue and name it curr.
	    b) add curr's data to the result list
	    c) if curr's left child is not null, add the left child to the queue
	    d) if curr's right child is not null, add the right child to the queue
	 * 4) return result 
	 */
	public void levelOrder ( TreeNode root ) {
		
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode dummy = new TreeNode(null, null);
		
		
		if ( root != null ) {
			q.add(root);
			q.add(dummy);
		}
		
		while ( !q.isEmpty() ) {
			
			TreeNode curr = q.poll();
			
			if ( curr != null ) {
				System.out.println(curr);
				
				if ( curr.left() != null ) {
					q.add(curr.left());
				}
				
				if ( curr.right() != null ) {
					q.add(curr.right());
				}
			} else {
				
				if ( !q.isEmpty() ) {
					q.add(dummy);
				}
			}
			
		}
	}

	
	public boolean insert ( Integer toInsert ) {
		if ( root == null ) {
			root = new TreeNode(null, toInsert);
			return true;
		}
		TreeNode curr = root;
		int comp = toInsert.compareTo(curr.getData());
		
		while ( curr != null ) {
			if ( comp > 0 ) {
				curr = curr.right();
			} else if ( comp < 0 ) {
				curr = curr.left();
			} 
			comp = toInsert.compareTo(curr.getData());
		}
		
		if ( comp > 0 ) {
			curr.addRight(toInsert);
		} else if ( comp < 0 ) {
			curr.addLeft(toInsert);
		} else {
			return false;
		}
		size++;
		return false;
	}
	
	public void search ( Integer toFind ) {
		
	}
	
	public static void main ( String[] args ) {
		BST myBST = new BST();
		myBST.insert(10);
		
		for ( int i = 0; i < myBST.getSize(); i++ ) {
			System.out.println(myBST.root);
		}
	}

}
