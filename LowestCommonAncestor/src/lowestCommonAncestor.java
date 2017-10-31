
public class lowestCommonAncestor {
	public static void main(String[] args){
		dag testDag = new dag(7);

		
		testDag.addEdge(0, 3);			
		testDag.addEdge(1, 3);
		testDag.addEdge(1, 4);
		testDag.addEdge(2, 5);
		testDag.addEdge(2, 6);
		testDag.addEdge(3, 5);
		testDag.addEdge(3, 6);
		testDag.addEdge(4, 6);
		

		Iterable<Integer> testing;
		testing = testDag.adj(0);
		String temp = testing.iterator().toString();
		//for( int i : testing ){ System.out.println(i); }
		System.out.println(temp);
	}
}
