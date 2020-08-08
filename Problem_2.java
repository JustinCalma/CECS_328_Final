import java.util.ArrayList;

public class Problem_2 {
	
	public static int counter = 0;
	
	public static int TIME = 0;

	public static void main (String[] args) {
		// Object created for program
		Problem_2 dfs = new Problem_2();
		
		// Create Example arrays
		// Examples that produce cycles
		String[] a = {"smurf", "funny", "oreos", "yoyo"};
//		String[] a = {"soup", "hey", "yes", "push"};
//		String[] a = {"abc", "cdx", "xpc", "cga"};

		// Examples that do not produce cycles
//		String[] a = {"hi", "honey", "yellow", "word"};
//		String[] a = {"giraffe", "cyborg", "eccentric", "oops", "gelato"};
//		String[] a = {"ab", "ba", "xy", "yx"};

		// Create the Nodes Nodes 
		ArrayList<Node> Vertices = dfs.createNodes(a);
			
		// Calls DFS on the list of Vertices
		dfs.DFS(Vertices);

	}
	
	// Method to create the Nodes and their adjacencies
	public ArrayList<Node> createNodes(String[] a) { 
		
		// ArrayList storing the vertices of the graph
		ArrayList<Node> Vertices = new ArrayList<Node>();
			
		// Get the first word from the array
		String firstWord = a[0];
			
		// Get the first and last character of the String
		String firstChar = String.valueOf(firstWord.charAt(0));
		String lastChar = String.valueOf(firstWord.charAt(firstWord.length() - 1));
						
		// Create the nodes of the first and last characters 
		Node firstCharNode = new Node();
		firstCharNode.name = firstChar;
			
		Node lastCharNode = new Node();
		lastCharNode.name = lastChar;
						
		// Add the last char of the first string to the adjacency list of the first char
		firstCharNode.adjacent.add(lastCharNode);
			
		// Add the vertices into the list 
		Vertices.add(firstCharNode);
		Vertices.add(lastCharNode);
			
		// Iterate though the list of Strings and create the nodes
		for (int i = 1; i < a.length; i++) {			
				
			// Get the current String element
			String currentString = a[i];
				
			// Get the first and last chars of the current String element
			firstChar = String.valueOf(currentString.charAt(0));
			lastChar = String.valueOf(currentString.charAt(currentString.length() - 1));				
				
			// Check if the last char in the string is already a node
			Node returnedNode_Last = alreadyCreatedNode(Vertices, lastChar);
					
			// If node has not already been created, then create it
			if (returnedNode_Last == null) {
				returnedNode_Last = new Node();
				returnedNode_Last.name = lastChar;
				Vertices.add(returnedNode_Last);
			}				
				
			// Check if the first char in the string is already a node
			Node returnedNode_First = alreadyCreatedNode(Vertices, firstChar);
				
			// If it is already a node, then add it to the adjacency list of the last char's node
			if (returnedNode_First != null) {
				returnedNode_First.adjacent.add(returnedNode_Last);
					
			} else { // Else, create the node and set it's adjacency
				returnedNode_First = new Node();
				returnedNode_First.name = firstChar;
				returnedNode_First.adjacent.add(returnedNode_Last);
				Vertices.add(returnedNode_First);
			}
				
		}		
			
		// Return the list of the vertices that have been created
		return Vertices;
			
	}
		
	// Helper Method to check if the Node has already been created
	public Node alreadyCreatedNode(ArrayList<Node> Vertices, String name) {			
			
		// Iterate through the list of Vertices
		for (int i = 0; i < Vertices.size(); i++) {
				
			// Check if there is already a node that exists
			if (Vertices.get(i).name.equals(name)) {
				return Vertices.get(i);
			}
		}	
			
		// Return false, a node does not exist with the passed in name s
		return null;
			
	}	
			
	// DFS Method
	public void DFS(ArrayList<Node> Vertices) {
			
		// Sets the starting vertex to be the ancestor of the graph
		Node ancestor = Vertices.get(0);
			
		// Iterate through each vertex in the list of vertices
		for (Node vertex : Vertices) {
				
			// Checks if the vertex has already been explored then call DFS_Visit
			if (vertex.parent == null) {
				vertex.parent = vertex;
				DFS_Visit(vertex, ancestor, Vertices);
			}
		}
		
		System.out.println("Yes! "); // A cycle has been created: ALL vertices are in the cycle
			
	}
		
	// DFS_Visit Method
	public void DFS_Visit(Node vertex, Node ancestor, ArrayList<Node> Vertices) {
		
		// Increment global variable TIME
		TIME++;
		
		// Set the start time for each vertex when reached
		vertex.startTime = TIME;
					
		// Checks if a node is not adjacent to other nodes
		if (vertex.adjacent.isEmpty()) {
			System.out.println("No! "); //A cycle has not been created: A node does not have a neighbor
			System.exit(0);
			
		// Checks if the current vertex's neighbor is the ancestor and all nodes have been visited
		} else if (vertex.adjacent.get(0).name.equals(ancestor.name) && counter == Vertices.size() - 1) {
			System.out.println("Yes! "); // A cycle has been created: ALL vertices are in the cycle
			System.exit(0);
			
		// Checks if the current vertex's neighbor is the ancestor & not all nodes have been visited (Example 4)
		} else if (vertex.adjacent.get(0).name.equals(ancestor.name)) {
			System.out.println("No! "); // A cycle has not been created: SOME of the vertices are in a cycle but not all 
			System.exit(0);
		}
		
		// Visit each of the neighbors for the passed in vertex
		for (Node neighbors : vertex.adjacent) {
			
			// If the neighbors  start time is 0 then visit it 
			if (neighbors.startTime == 0) {
				counter++;
				neighbors.parent = vertex;
				DFS_Visit(neighbors, ancestor, Vertices);
				
			} 						
		}		
	}
}

// Justin Calma CECS 328 - 14 F 8:00 AM - 12:45 PM