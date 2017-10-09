import static org.junit.Assert.*;

import org.junit.Test;

public class lowestCommonAncestorTest {

	
	/* Functions that will be needed:
	 * new bst
	 * put node
	 * get node
	 * delete node
	 * lowestCommonAncestor
	 * printTree
	 * (size?)
	 * 
	 */
	
	@Test
	public void testPut() {
		//Using character-character tree to simplify testing.
		BST<Character, Character> bst = new BST<Character, Character>();
		
		
		//Testing node creation.
		bst.put('B', 'B');
		assertEquals("Checking put on empty tree", "(()B())", bst.printTree());
		
		//Testing nodes get sorted correctly when added.
		bst.put('A', 'A');
		bst.put('C', 'C');
		bst.put('D', 'D');
		
		
		/*
		 * 			B
		 * 		   / \
		 * 		  A   C
		 * 			   \
		 * 				D	  
		 */
		
		assertEquals("Checking put of multiple nodes into tree", "((()A())B(()C(()D())))", bst.printTree());
		
		//Testing update of value in tree.
		bst.put('C', 'X');
		assertEquals("Checking put of multiple nodes into tree", "((()A())B(()X(()D())))", bst.printTree());
		
		//Testing put of null value. (Should delete node)
		bst.put('C', null);
		assertEquals("Checking put of null value into tree", "((()A())B(()D()))", bst.printTree());
		
		//Testing put of null key. (Should have no effect)
		bst.put(null, 'Q');
		assertEquals("Checking put of null key into tree", "((()A())B(()D()))", bst.printTree());

	}
	
	@Test
	public void testGet(){
		
	}	
		

}
