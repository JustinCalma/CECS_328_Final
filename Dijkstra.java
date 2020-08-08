import java.util.*;

public class Dijkstra {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Dijkstra dijkstra = new Dijkstra();
		
		System.out.println("THE GRAPH G = { {a,b}, {a,c}, {a,d}, {b,a}, {b,c}, {b,e}, {b,f}, {c,a}, {c,b}, {c,f}, {c,g}, {d,a}, {d,e}, {e,d}, {e,b}, {f,b}, {f,c}, {f,g}, {g,c}, {g,f}, {g,h}, {h} }");
		
		Node a = new Node();
		a.name = "a";
		
		Node b = new Node();
		b.name = "b";
		
		Node c = new Node();
		c.name = "c";
		
		Node d = new Node();
		d.name = "d";
		
		Node e = new Node();
		e.name = "e";
		
		Node f = new Node();
		f.name = "f";
		
		Node g = new Node();
		g.name = "g";
		
		Node h = new Node();
		h.name = "h";

		// NODE A:
		ArrayList<Node> a_Adjacent = new ArrayList<Node>();
		a_Adjacent.add(b);
		a_Adjacent.add(c);
		a_Adjacent.add(d);
		a.setAdjacent(a_Adjacent);
		
		ArrayList<Edge> a_Edges =  new ArrayList<Edge>();
		Edge a_Edge1 = new Edge(a, b, 15);
		Edge a_Edge2 = new Edge(a, c, 2);
		Edge a_Edge3 = new Edge(a, d, 3);
		
		a_Edges.add(a_Edge1);
		a_Edges.add(a_Edge2);
		a_Edges.add(a_Edge3);
		a.setEdges(a_Edges);
		
		// NODE B:
		ArrayList<Node> b_Adjacent = new ArrayList<Node>();
		b_Adjacent.add(a);
		b_Adjacent.add(c);
		b_Adjacent.add(e);
		b_Adjacent.add(f);
		b.setAdjacent(b_Adjacent);
		
		ArrayList<Edge> b_Edges = new ArrayList<Edge>();
		Edge b_Edge1 = new Edge(b, a, 15);
		Edge b_Edge2 = new Edge(b, c, 8);
		Edge b_Edge3 = new Edge(b, e, 2);
		Edge b_Edge4 = new Edge(b, f, 1);
		
		b_Edges.add(b_Edge1);
		b_Edges.add(b_Edge2);
		b_Edges.add(b_Edge3);
		b_Edges.add(b_Edge4);
		b.setEdges(b_Edges);
		
		// NODE C:
		ArrayList<Node> c_Adjacent = new ArrayList<Node>();
		c_Adjacent.add(a);
		c_Adjacent.add(b);
		c_Adjacent.add(f);
		c_Adjacent.add(g);
		c.setAdjacent(c_Adjacent);
		
		ArrayList<Edge> c_Edges = new ArrayList<Edge>();
		Edge c_Edge1 = new Edge(c, a, 2);
		Edge c_Edge2 = new Edge(c, b, 8);
		Edge c_Edge3 = new Edge(c, f, 7);
		Edge c_Edge4 = new Edge(c, g, 5);
		
		c_Edges.add(c_Edge1);
		c_Edges.add(c_Edge2);
		c_Edges.add(c_Edge3);
		c_Edges.add(c_Edge4);
		c.setEdges(c_Edges);
		
		// NODE D:
		ArrayList<Node> d_Adjacent = new ArrayList<Node>();
		d_Adjacent.add(a);
		d_Adjacent.add(e);
		d.setAdjacent(d_Adjacent);
		
		ArrayList<Edge> d_Edges = new ArrayList<Edge>();
		Edge d_Edge1 = new Edge(d, a, 3);
		Edge d_Edge2 = new Edge(d, e, 1);
		
		d_Edges.add(d_Edge1);
		d_Edges.add(d_Edge2);
		d.setEdges(d_Edges);

		// NODE E:
		ArrayList<Node> e_Adjacent = new ArrayList<Node>();
		e_Adjacent.add(b);
		e_Adjacent.add(d);
		e.setAdjacent(e_Adjacent);
		
		ArrayList<Edge> e_Edges = new ArrayList<Edge>();
		Edge e_Edge1 = new Edge(e, b, 2);
		Edge e_Edge2 = new Edge(e, d, 1);
		
		e_Edges.add(e_Edge1);
		e_Edges.add(e_Edge2);
		e.setEdges(e_Edges);

		// NODE F:
		ArrayList<Node> f_Adjacent = new ArrayList<Node>();
		f_Adjacent.add(b);
		f_Adjacent.add(c);
		f_Adjacent.add(g);
		f.setAdjacent(f_Adjacent);
		
		ArrayList<Edge> f_Edges = new ArrayList<Edge>();
		Edge f_Edge1 = new Edge(f, b, 1);
		Edge f_Edge2 = new Edge(f, c, 7);
		Edge f_Edge3 = new Edge(f, g, 2);
		
		f_Edges.add(f_Edge1);
		f_Edges.add(f_Edge2);
		f_Edges.add(f_Edge3);
		f.setEdges(f_Edges);
		
		// NODE G: 
		ArrayList<Node> g_Adjacent = new ArrayList<Node>();
		g_Adjacent.add(c);
		g_Adjacent.add(f);
		g_Adjacent.add(h);
		g.setAdjacent(g_Adjacent);
		
		ArrayList<Edge> g_Edges = new ArrayList<Edge>();
		Edge g_Edge1 = new Edge(g, c, 5);
		Edge g_Edge2 = new Edge(g, f, 2);
		Edge g_Edge3 = new Edge(g, h, 1);
		
		g_Edges.add(g_Edge1);
		g_Edges.add(g_Edge2);
		g_Edges.add(g_Edge3);
		g.setEdges(g_Edges);
		
		// NODE H:
		ArrayList<Node> h_Adjacent = new ArrayList<Node>();
		h_Adjacent.add(g);
		h.setAdjacent(h_Adjacent);
		
		ArrayList<Edge> h_Edges = new ArrayList<Edge>();
		Edge h_Edge1 = new Edge(h, g, 1);
		
		h_Edges.add(h_Edge1);
		h.setEdges(h_Edges);
		
		// Adds each vertex into an ArrayList 
		ArrayList<Node> Vertices = new ArrayList<Node>();
		Vertices.add(a);
		Vertices.add(b);
		Vertices.add(c);
		Vertices.add(d);
		Vertices.add(e);
		Vertices.add(f);
		Vertices.add(g);
		Vertices.add(h);
		
		dijkstra.setDistances(Vertices);
		
		dijkstra.Dijkstra(a, Vertices);
		
	}
	
	// Dijkstra Method
	public void Dijkstra(Node vertex, ArrayList<Node> Vertices) {
		
		// Creates a copy of the list of Vertices
		List<Node> verticesCopy = new ArrayList<>(Vertices);
		
		// Sets the starting vertex's distance to 0 and it's parent pointer to itself
		vertex.distance = 0;
		vertex.parent = vertex;
		
		// Call build Min Heap and create a min heap of the node's distances
		build_MinHeap(Vertices);
		
		// Keep looping until all vertices have been removed from the heap
		while (Vertices.size() > 0) {
			
			// Remove the root from the min heap
			Node next = Vertices.remove(0);
			
			// Iterate through the root's adjacency list
			for (Node n : next.adjacent) {
				
				// Check If the path taken is a less than the distance of the current node's distance
				if ((next.distance + next.getWeight(n)) < n.distance) {
					// Update the parent pointer to be the root
					n.parent = next;
					
					// Update the distance to be the shorter path distance
					n.distance = next.distance + next.getWeight(n);
					
					// Call min heapify to update the distances of the remaining vertices
					min_Heapify(Vertices, 0, Vertices.size());
				}
			}
		}
		
		// For loop to iterate through a copy of the list of Vertices and print the result
		for (Node node : verticesCopy) {
			System.out.println("The shortest path from " + vertex.name + " to " + node.name + " is " + node.distance);
		}
		
	}
	
	// Build Min Heap Method
	public void build_MinHeap(ArrayList<Node> a) { // Build Min heap function. Only takes in the passed array as a parameter
		Dijkstra heap = new Dijkstra(); // Creates an object called heap
		
		int arrLength = 0; // Instantiates the variable for array length
		
		arrLength = a.size(); // Gets the length of the array and saves it into a variable
		
		for (int i = arrLength / 2; i >= 0; i--) {
			heap.min_Heapify(a, i , arrLength); // Calls Min Heapify function and passes in the array, index, and length
		}
		
	}
	
	// Min Heapify Method
	public void min_Heapify(ArrayList<Node> a, int i, int arrLength) {
		Dijkstra heap = new Dijkstra(); // Create an object called heap
		
		int leftIdx = 2*i + 1; // Finds the index of the left child and the parent is index i
		
		int rightIdx = 2*i + 2; // Finds the index of the right child and the parent is index i
		
		int midIdx = i; // Index of the parent
		
		if (leftIdx < arrLength && a.get(leftIdx).distance < a.get(midIdx).distance) { // Compares if the left child is less than the parent
			midIdx = leftIdx;
		}
		if (rightIdx < arrLength && a.get(rightIdx).distance < a.get(midIdx).distance) { // Compares if the right child is less than parent
			midIdx = rightIdx;
		}
		if (midIdx != i) {
			// Call swap helper method to switch the element at index i and the mid element
			heap.swap(a, i, midIdx);
			heap.min_Heapify(a, midIdx, arrLength);
		}
		
	}
	
	// Helper method to swap two elements in the array
	public void swap(ArrayList<Node> a, int x, int y) { 
		Node temp = a.get(x);
		a.set(x, a.get(y));
		a.set(y, temp);
		
	}
	
	// Helper method to set the inital distances of each vertex to INF
	public void setDistances(ArrayList<Node> Vertices) {
		for (Node node : Vertices) {
			node.distance = Integer.MAX_VALUE;
		}
	}	
}

// Justin Calma CECS 328 - 14 F 8:00 AM - 12:45 PM