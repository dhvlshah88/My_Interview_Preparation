package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Graph {
	
	@SuppressWarnings("unused")
	private HashMap<Integer, UndirectedGraphVertex> adjacencyList;
	private HashMap<UndirectedGraphVertex, UndirectedGraphVertex> visitedVertices;
	@SuppressWarnings("unused")
	private int nVertices, nEdges;
	
	public static class UndirectedGraphVertex implements Comparable<UndirectedGraphVertex>
	{
		private int label;
		private ArrayList<UndirectedGraphVertex> neighbours;
		
		public UndirectedGraphVertex(int value)
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
		public ArrayList<UndirectedGraphVertex> getNeighbours() {
			return neighbours;
		}

		@Override
		public int compareTo(UndirectedGraphVertex o) {
			return label - o.getLabel();
		}	
	}
	
	public Graph(int nVertices)
	{	
		this.nVertices = nVertices;
		nEdges = 0;
		adjacencyList = new HashMap<>();
	}
	
	public void addEdge(int vertex, int neighbour)
	{
		UndirectedGraphVertex node = new UndirectedGraphVertex(vertex);		
		UndirectedGraphVertex neighbourNode = new UndirectedGraphVertex(neighbour);
		
		nEdges++;
		
		if(adjacencyList.containsKey(vertex))
			adjacencyList.get(vertex).getNeighbours().add(neighbourNode);
		else
			adjacencyList.put(vertex, node);
	}
	
	/**
	 * Below method clone's the graph using DFS traversal. Runtime complexity: O(|V|+|E|)
	 * @param vertex
	 * @return cloned graph 
	 */
	public UndirectedGraphVertex cloneDFS(UndirectedGraphVertex vertex)
	{
		if(vertex == null)
			return vertex;
		
		UndirectedGraphVertex vertex_copy = new UndirectedGraphVertex(vertex.getLabel());
		visitedVertices.put(vertex, vertex_copy);
		
		for(UndirectedGraphVertex nb : vertex.getNeighbours())
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
	public UndirectedGraphVertex cloneBFS(UndirectedGraphVertex vertex)
	{
		if(vertex == null)
			return vertex;

		Queue<UndirectedGraphVertex> q = new LinkedList<>();
		q.add(vertex);
		
		UndirectedGraphVertex vertex_copy = new UndirectedGraphVertex(vertex.getLabel());
		visitedVertices.put(vertex, vertex_copy);
		
		while(!q.isEmpty())
		{
			vertex = q.remove();
			UndirectedGraphVertex temp_vertex_copy = visitedVertices.get(vertex);
			
			for(UndirectedGraphVertex nb : vertex.getNeighbours())
			{
				if(visitedVertices.containsKey(nb))
				{
					temp_vertex_copy.getNeighbours().add(visitedVertices.get(nb));
				}
				else
				{
					UndirectedGraphVertex nb_copy = new UndirectedGraphVertex(nb.label);
					temp_vertex_copy.getNeighbours().add(nb_copy);
					visitedVertices.put(nb, nb_copy);
					q.add(nb);
				}
			}
			
		}
		return vertex_copy;
	}
	
	public UndirectedGraphVertex cloneGraph(String traversalType, UndirectedGraphVertex node)
	{
		UndirectedGraphVertex copy;
		
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
