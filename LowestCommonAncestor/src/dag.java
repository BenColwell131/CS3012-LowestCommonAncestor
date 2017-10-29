import java.util.*;


/*
 * public class Digraph
 * 
 * Digraph(int V) create an empty digraph with V vertices
 *  
 * void addEdge(int v, int w) add a directed edge v->w
 * 
 * Iterable<Integer> adj(int v) vertices pointing from v
 * 
 * int V() number of vertices
 * 
 * int E() number of edges
 *  
 * String toString() string representation
 * 
 */

public class dag {

	private final int V;
	private final Bag<Integer>[] adj;

public dag(int V)
{
	this.V = V;
	adj = (Bag<Integer>[]) new Bag[V];
	
	for (int v = 0; v < V; v++)
	{
		adj[v] = new Bag<Integer>();
	}
}

public boolean addEdge(int v, int w)
{
	// acyclic -> If will not create a cycle -> add edge
	// 1. not self loop
	// 2. !hasPath w -> v
	if(v >= this.V || w >= this.V || v < 0 || w < 0){
		return false;
	}
	DirectedDFS dfsObject = new DirectedDFS(this, w);

	if(v != w && !dfsObject.visited(v)){
		adj[v].add(w);
		return true;
	}	
	else{
		return false;
	}
}

public int V(){
	return V;
}

public Iterable<Integer> adj(int v)
{ return adj[v]; }


//Class to create a depth first search object on a directed graph.
private class DirectedDFS
{
	private boolean[] marked;
	
	public DirectedDFS(dag G, int s)
	{
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	
	//standard dfs - in the flow of direction.
	private void dfs(dag G, int v)
	{
		marked[v] = true;
		for (int w : G.adj(v))
		if (!marked[w]) dfs(G, w);
	}
	
	public boolean visited(int v)
	{ return marked[v]; }
	
}

}