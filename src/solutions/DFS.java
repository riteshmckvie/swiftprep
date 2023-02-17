package solutions;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class DFS {

	private Integer verticesNo;
	
	private LinkedList<Integer> adj[];

	DFS(Integer v) {
		this.verticesNo = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void depthFirstSearch(int v) {
		
        Vector<Boolean> visited = new Vector<Boolean>(verticesNo); 
        for (int i = 0; i < verticesNo; i++) 
            visited.add(false); 
  
        Stack<Integer> stack = new Stack<>(); 
          
        stack.push(v); 
          
        while(!stack.isEmpty()) 
        { 
            //v = stack.peek(); 
            v = stack.pop(); 
              
            if(visited.get(v) == false) 
            { 
                System.out.print(v + " "); 
                visited.set(v, true); 
            } 
            
            adj[v].forEach(elem -> {
            	if(!visited.get(elem)) 
                    stack.push(elem);
            });
        } 	
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public static void main(String[] args) {
		
		//   Below is the graph
		//   0--1--3
		//   | / /
		//   |//
		//   2
		
		DFS g = new DFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 0);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(2, 1);
		g.addEdge(3, 2);
		g.addEdge(3, 1);

		System.out.println("Following is Depth First Traversal with Edge count");

		g.depthFirstSearch(3);
	}

}
