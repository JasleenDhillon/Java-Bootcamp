package lecture30thApril;

public class GraphClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "B", 10);
		g.addEdge("A", "D", 40);
		g.addEdge("B", "C", 10);
		g.addEdge("C", "D", 10);
		g.addEdge("D", "E", 2);
		g.addEdge("E", "G", 8);
		g.addEdge("E", "F", 3);
		g.addEdge("F", "G", 3);

		g.display();

		// System.out.println(g.HasPathFrom("A", "G"));
		// System.out.println(g.hasPathBFS1("A", "G"));
		// System.out.println(g.HasPath("A", "G"));

		System.out.println(g.hasPathDFS("A", "G"));
		g.removeEdge("A", "D");
		g.removeEdge("E", "F");
		System.out.println(g.IsAcyclic());
		// g.dft();
		System.out.println("~~~~~~~~~~~~~~");
		g.removeEdge("E", "D");
		System.out.println(g.isConnected());
		// g.bft();
		// g.removeEdge("E", "G");
		// g.display();
		//
		// g.removeVertex("C");
		// g.display();

	}

}
