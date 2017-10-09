import static org.junit.Assert.*;

import org.junit.Test;

public class lowestCommonAncestorTest {

	
	/* Functions that will be needed:
	 * new bst
	 * insert node 				Tests written
	 * get node					Tests written
	 * delete node				Tests written
	 * lowestCommonAncestor
	 * printTree				Tests written
	 * (size?)
	 * (isEmpty?)
	 */
	
	@Test
	public void testPrintTree()
	{
		//Testing printing of an empty tree.
	     BST<Character, Character> bst = new BST<Character, Character>();
	     assertEquals("Testing printing of empty tree",
	             "()", bst.printTree());
	     
	     //Testing printing of a one node tree.
	     bst.put('B', 'B');
	     assertEquals("Testing printing of one node tree",
	             "(()B())", bst.printTree());
	     
	     
	     //Testing printing of a multiple node tree/
	     bst.put('A', 'A');
	     bst.put('C', 'C');
	     bst.put('D', 'D');
	     
	     assertEquals("Testing printing of multiple node tree",
	    		 "((()A())B(()C(()D())))", bst.printTree());	     
	}
	
	@Test
	public void testInsert() {
		BST<Character, Character> bst = new BST<Character, Character>();
		
		
		//Testing node creation.
		bst.insert('B', 'B');
		assertEquals("Testing insert on empty tree", 
				"(()B())", bst.printTree());
		
		//Testing nodes get sorted correctly when added.
		bst.insert('A', 'A');
		bst.insert('C', 'C');
		bst.insert('D', 'D');
		
		
		/*
		 * 			B
		 * 		   / \
		 * 		  A   C
		 * 			   \
		 * 				D	  
		 */
		
		assertEquals("Testing insert of multiple nodes into tree", 
				"((()A())B(()C(()D())))", bst.printTree());
		
		//Testing update of value in tree.
		bst.insert('C', 'X');
		assertEquals("Testing insert of multiple nodes into tree", 
				"((()A())B(()X(()D())))", bst.printTree());
		
		//Testing insert of null value. (Should delete node)
		bst.insert('C', null);
		assertEquals("Testing insert of null value into tree", 
				"((()A())B(()D()))", bst.printTree());
		
		//Testing insert of null key. (Should have no effect)
		bst.insert(null, 'Q');
		assertEquals("Testing insert of null key into tree", 
				"((()A())B(()D()))", bst.printTree());

	}
	
	@Test
	public void testGet(){
		BST<Character, Character> bst = new BST<Character, Character>();
//TODO
		assertEquals("Testing get on empty tree", 
				null, bst.get('A'));
	     
	     bst.put('B', 'B');
	     bst.put('C', 'C');
	     bst.put('D', 'D');
	     bst.put('E', 'E');
	     
//TODO
	     assertEquals("Testing get on multiple node tree that doesn't contain key",
	             null, bst.get('A'));   
	     

	     assertEquals("Testing get on multiple node tree that does contain key",
	             'C', (char)bst.get('C'));   //Have to cast to char as will return type of 'Value'.
	     
	}	
	
	@Test
	public void testDelete(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		//Testing delete on an empty tree.
		bst.delete(1);
        assertEquals("Deleting from empty tree", "()", bst.printTree());
        
        
        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
                         //         5
        
        assertEquals("Testing constructed tree is as expected.",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printTree());
        
        //Test deleting key not present in tree. Should have no effect.
        bst.delete(9);
        assertEquals("Deleting non-existent key",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printTree());

        
        //Test deleting leaf.
        bst.delete(8);
        assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printTree());

        //Test deleting node with single child.
        bst.delete(6);
        assertEquals("Deleting node with single child",
                "(((()1(()2()))3(()4(()5())))7())", bst.printTree());

        //Test deleting node with two children
        bst.delete(3);
        assertEquals("Deleting node with two children",
                "(((()1())2(()4(()5())))7())", bst.printTree());
	}

	
	@Test
	public void testLowestCommonAncestor(){
		//Lowest Common Ancestor should require two keys and return a node.
		//Not sure if we'll be able to access nodes once code is written but assuming for now we can.
		
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		//Testing empty tree.
//TODO
		assertEquals("Testing LCA on empty tree", null, bst.testLowestCommonAncestor(//TODO));
		
		
/*		Node testNode = new Node(2, 2, 3); //Node(key, value, N) where N is the number of nodes in its subtree.
		
		bst.put(1,1);
		bst.put(3,3);
		bst.put(2,2);
*/		
		
		
	}
}
