import static org.junit.Assert.*;

import org.junit.Test;

public class TestBinaryTree {

	//Tested Created by Tanmay Kaushik Oct 2020
	@Test
	public void testNullTree() {
		BinarySearchTree tree = new BinarySearchTree();
		assertTrue(tree.root == null);
		tree.root = new Node(5);
		assertTrue(tree.root != null);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testBranch() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(5);
		assertTrue(tree.root.left == null);
		assertTrue(tree.root.right == null);
		tree.root.left = new Node(4);
		assertTrue(tree.root.left != null);
		tree.root.right = new Node(6);
		assertTrue(tree.root.right != null);
		//fail("Not yet implemented");
	}
	
	@Test
	public void LCA() {
		BinarySearchTree tree = new BinarySearchTree();
    	tree.root = new Node(5);
    	tree.root.left = new Node(4);
    	tree.root.left.right = new Node(3);
    	tree.root.right = new Node(6);
    	tree.root.right.right = new Node(7);
    	tree.root.left.left = new Node(2);
    	//print2D(tree.root);
    	/*
    	 
               7     
			 / 
           6  
		  /	
		5
		  \		3
           4 /      
			 \
   				2

               
		LCA of 3 and 7 is : 5
		LCA of 2 and 4 is : 4
		LCA of 6 and 3 is : 5
		LCA of 2 and 3 is : 4
		LCA of 5 and 6 is : 5
		LCA of 5 and 5 is : 5
		LCA of 7 and 7 is : 7

    	 */
    	assertEquals("LCA of 3 and 7 is : ",5, tree.findLCA(3,7));
    	assertEquals("LCA of 2 and 4 is : ",4, tree.findLCA(2,4));
    	assertEquals("LCA of 6 and 3 is : ",5, tree.findLCA(6,3));
    	assertEquals("LCA of 2 and 3 is : ",4, tree.findLCA(2,3));
    	assertEquals("LCA of 5 and 6 is : ",5, tree.findLCA(5,6));
    	assertEquals("LCA of 5 and 5 is : ",5, tree.findLCA(5,5));
    	assertEquals("LCA of 7 and 7 is : ",7, tree.findLCA(7,7));
    	assertEquals("LCA of 4 and null entry is : ",-1, tree.findLCA(7,11));

		//fail("Not yet implemented");
	}
	
}
