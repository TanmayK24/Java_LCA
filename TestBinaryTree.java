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
	public void testBinaryTree() {
						/*
				        0
				       / \
				      1   3
				     / \
				    7   4
				         \
				          5
						 */
		
		Node[] nodes = new Node[8];
		for (int i = 0; i < nodes.length; i++) nodes[i] = new Node(i);
		Node root0 = nodes[0];
		root0.children = new Node[] {nodes[1], nodes[3]};
		nodes[1].children = new Node[] {nodes[7], nodes[4]};
		nodes[4].children = new Node[] {nodes[5]};

		BinarySearchTree g1 = new BinarySearchTree(root0);
		assertEquals("LCA of 0 and 5 is", "0", g1.findLCA(nodes[0], nodes[5]).toString());
		assertEquals("LCA of 7 and 4 is", "1", g1.findLCA(nodes[7], nodes[4]).toString());
		assertEquals("LCA of 1 and 3 is", "0", g1.findLCA(nodes[1], nodes[3]).toString());
		assertEquals("LCA of 5 and 7 is", "1", g1.findLCA(nodes[5], nodes[7]).toString());
		assertEquals("LCA of 3 and 4 is", "0", g1.findLCA(nodes[3], nodes[4]).toString());
	}

	@Test
	public void testTreeMultipleParents() {

		/*

			 		 1					 1
				   / |  \ 
				  2  |    3
				  \  |  / |
				   \ | /  |
				     4	  |
				     \	  |
				      \	  |
				       \  |
				      	  5

		 */

		Node[] nodes4 = new Node[6];
		for (int i = 0; i < nodes4.length; i++) nodes4[i] = new Node(i);
		Node root3 = nodes4[1];
		root3.children = new Node[] {nodes4[2], nodes4[4], nodes4[3], nodes4[5]};
		nodes4[2].children = new Node[] {nodes4[4]};
		nodes4[3].children = new Node[] {nodes4[4], nodes4[5]};
		nodes4[4].children = new Node[] {nodes4[5]};
		nodes4[5].children = null;

		BinarySearchTree g1 = new BinarySearchTree(root3);
		assertEquals("LCA of 1 and 3 is", "1", g1.findLCA(nodes4[1], nodes4[3]).toString());
		assertEquals("LCA of 3 and 3 is", "3", g1.findLCA(nodes4[3], nodes4[3]).toString());
		assertEquals("LCA of 2 and 3 is", "1", g1.findLCA(nodes4[2], nodes4[3]).toString());
	}
	
	
	@Test
	public void LCA() {
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
		Node[] nodes = new Node[8];
		for (int i = 0; i < nodes.length; i++) nodes[i] = new Node(i);
		Node root0 = nodes[5];
		root0.children = new Node[] {nodes[4], nodes[6]};
		nodes[4].children = new Node[] {nodes[2], nodes[3]};
		nodes[6].children = new Node[] {nodes[7]};

		BinarySearchTree g1 = new BinarySearchTree(root0);
		assertEquals("LCA of 3 and 7 is", "5", g1.findLCA(nodes[3], nodes[7]).toString());
		assertEquals("LCA of 2 and 4 is", "4", g1.findLCA(nodes[2], nodes[4]).toString());
		assertEquals("LCA of 6 and 3 is", "5", g1.findLCA(nodes[6], nodes[3]).toString());
		assertEquals("LCA of 2 and 3 is", "4", g1.findLCA(nodes[2], nodes[3]).toString());
		assertEquals("LCA of 5 and 6 is", "5", g1.findLCA(nodes[5], nodes[6]).toString());
		assertEquals("LCA of 5 and 5 is", "5", g1.findLCA(nodes[5], nodes[5]).toString());
		assertEquals("LCA of 7 and 7 is", "7", g1.findLCA(nodes[7], nodes[7]).toString());
		
		
		
	}
}	
