
import java.util.*;


public class graph {
	
	@SuppressWarnings("unused")
	private HashMap<Integer, undirectedGraphVertex> adjacencyList;
	private HashMap<undirectedGraphVertex, undirectedGraphVertex> visitedVertices;
	@SuppressWarnings("unused")
	private int nVertices, nEdges;
	
	public static class undirectedGraphVertex implements Comparable<undirectedGraphVertex>
	{
		private int label;
		
		private ArrayList<undirectedGraphVertex> neighbours;
		
		public undirectedGraphVertex(int value)
		{
			label = value;
			neighbours = new ArrayList<>();
		}

		/**
		 * @return the label
		 */
		public int getLabel() {
			return label;
		}

		/**
		 * @return the neighbors of the node in graph
		 */
		public ArrayList<undirectedGraphVertex> getNeighbours() {
			return neighbours;
		}

		@Override
		public int compareTo(undirectedGraphVertex o) {

			return 0;
		}	
	}
	
	public graph(int nVertices)
	{	
		this.nVertices = nVertices;
		nEdges = 0;
		adjacencyList = new HashMap<>();
	}
	
	/*public void addEdge(int vertex, int neighbour)
	{
		undirectedGraphNode node = new undirectedGraphNode(vertex);		
		undirectedGraphNode neighbourNode = new undirectedGraphNode(neighbour);
		
		if(adjacencyList.containsKey(vertex))
			adjacencyList.get(vertex).getNeighbours().add(neighbourNode);
		else
			adjacencyList.put(vertex, node);
		

	}*/
	
	
	/**
	 * Below method clone's the graph using DFS traversal. Runtime complexity: O(|V|+|E|)
	 * @param vertex
	 * @return cloned graph 
	 */
	public undirectedGraphVertex cloneDFS(undirectedGraphVertex vertex)
	{
		if(vertex == null)
			return vertex;
		
		undirectedGraphVertex vertex_copy = new undirectedGraphVertex(vertex.getLabel());
		visitedVertices.put(vertex, vertex_copy);
		
		for(undirectedGraphVertex nb : vertex.getNeighbours())
		{
			if(visitedVertices.containsKey(nb))
				vertex_copy.getNeighbours().add(visitedVertices.get(nb));
			else
				vertex_copy.getNeighbours().add(cloneDFS(nb));
		}
		
		return vertex_copy;
	}
	
	
	/**
	 * Below method clone's the graph using BFS traversal. Runtime complexity: O(|V|+|E|)
	 * @param vertex
	 * @return cloned graph 
	 */
	public undirectedGraphVertex cloneBFS(undirectedGraphVertex vertex)
	{
		if(vertex == null)
			return vertex;

		Queue<undirectedGraphVertex> q = new LinkedList<>();
		q.add(vertex);
		
		undirectedGraphVertex vertex_copy = new undirectedGraphVertex(vertex.getLabel());
		visitedVertices.put(vertex, vertex_copy);
		
		while(!q.isEmpty())
		{
			vertex = q.remove();
			undirectedGraphVertex temp_vertex_copy = visitedVertices.get(vertex);
			
			for(undirectedGraphVertex nb : vertex.getNeighbours())
			{
				
				if(visitedVertices.containsKey(nb))
				{
					temp_vertex_copy.getNeighbours().add(visitedVertices.get(nb));
				}
				else
				{
					undirectedGraphVertex nb_copy = new undirectedGraphVertex(nb.label);
					temp_vertex_copy.getNeighbours().add(nb_copy);
					visitedVertices.put(nb, nb_copy);
					q.add(nb);
				}
			}
			
		}
		
		
		return vertex_copy;
	}
	
	public undirectedGraphVertex cloneGraph(String traversalType, undirectedGraphVertex node)
	{
		undirectedGraphVertex copy;
		
		switch(traversalType)
		{
		case "DFS":
			copy = cloneDFS(node);
			break;
		case "BFS":
			copy = cloneBFS(node);
			break;

		default:
			copy = null;	
		}
		
		visitedVertices.clear();
		return copy;
	}
	

}
