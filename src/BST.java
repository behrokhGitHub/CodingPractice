import java.util.ArrayList;
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
		
		List<TreeNode> temp = new ArrayList<>();
		
		if ( root != null ) {
			temp.add(root);
		}
		
		while ( temp.size() != 0 ) {
			
			for ( int i = 0; i < temp.size(); i++ ) {
				TreeNode curr = temp.get(i);
				System.out.print(curr.getData() + " ");
			}
			System.out.println();
			
			List<TreeNode> parents = temp;
			temp = new ArrayList<>();
			
			for ( TreeNode par : parents ) {
				if ( par.left() != null ) {
					temp.add(par.left());
				}
				
				if ( par.right() != null ) {
					temp.add(par.right());
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
