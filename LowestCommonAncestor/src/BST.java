
//Adapting binary search tree code from 2nd year assignment for Algorithms & Data Structures


/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.1 10/10/17 10:50 am
 *
 *  @author Benjamin Colwell
 *
 *************************************************************************/

import java.lang.StringBuilder;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    
    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }   
    
    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }
    
    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void insert(Key key, Value val) {
		if (key == null) { return; }
        if (val == null) { delete(key); return; }
        root = insert(root, key, val);
    }

    private Node insert(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = insert(x.left,  key, val);
        else if (cmp > 0) x.right = insert(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }
    
    /**
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear before the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesised.
     */
    public String printTree() {
      if (isEmpty()) return "()";
      
      StringBuilder output = new StringBuilder();
      output.append("(");
      printTree(root, output);
      
      String result = output.toString();
      return result;
      
    }
    
    private StringBuilder printTree(Node x, StringBuilder output){
    	if(x == null)
    	{
    		return (output.append(")"));
    	}
    	output.append("(");
    	printTree(x.left, output);
    	output.append(x.key);
    	output.append("(");
    	printTree(x.right, output);
    	output.append(")");
    	return output;
    	
    }
    
    
  
    
    private Node delete(Node x, Key key){
    	if(x == null) return null;
    	int cmp = key.compareTo(x.key);
    	if		(cmp < 0) x.left  = delete(x.left, key);	//Search for key
    	else if	(cmp > 0) x.right = delete(x.right, key);
    	else
    	{
    		if(x.right 	== null) return x.left;				//No right child
    		if(x.left 	== null) return x.right;			//No left child
    		
    		Node t = x;
    		x = t.left;
    		while(x.right != null)
    		{
    			x = x.right;
    		}
    		x.left = deleteMax(t.left);
    		x.right = t.right; 		
    	}
    	x.N = size(x.left) + size(x.right) + 1;
    	return x;
    }
    
    /*Deletes the maximum key from a BST rooted at a given node*/    
    private Node deleteMax(Node x)
    {
    	if(x.right == null) return x.left;
    	x.right = deleteMax(x.right);
    	x.N = 1 + size(x.left) + size(x.right);
    	return x;
    }
