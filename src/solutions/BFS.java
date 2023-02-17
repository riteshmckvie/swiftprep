package solutions;

import java.util.LinkedList;

public class BFS {

	private int totalVertex;
	private LinkedList<Integer> adj[];

	// Constructor
	BFS(int v) {
		this.totalVertex = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BreadthFastSearch(int s) {
		boolean visited[] = new boolean[totalVertex];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");

			adj[s].forEach(k -> {
				if (!visited[k]) {
					visited[k] = true;
					queue.add(k);
				}
			});
		}
	}

	public static void main(String args[]) {
		BFS g = new BFS(6);

		//   Below is the graph
		//   0--1--3--4
		//   | / /
		//   |//
		//   2--5
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(3, 4);
		g.addEdge(2, 5);



		System.out.println("Following is Breadth First Traversal ");
		g.BreadthFastSearch(2);
	}

}
