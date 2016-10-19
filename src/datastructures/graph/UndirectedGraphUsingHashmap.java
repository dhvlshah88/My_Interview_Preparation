package datastructures.graph;

import java.util.*;


public class UndirectedGraphUsingHashmap {

    /* Contains total no of vertices. */
    private int nVertices;

    /* Contains total no of edges. */
    private int nEdges;

    /* Makes use of Map collection to store the adjacency list for each vertex.*/
    private HashMap<Integer, List<Integer>> Adjacency_List;	
    //private HashMap<Integer, List<Integer>> Adjacency_List_Copy = new HashMap<>();	

    /*
     * Initializes the map to with size equal to number of vertices in a graph
     * Maps each vertex to a given List Object 
     */
    public UndirectedGraphUsingHashmap(int number_of_vertices)
    {
	nVertices = number_of_vertices;
	nEdges = 0;
	Adjacency_List = new HashMap<Integer, List<Integer>>();	

	for (int i = 1 ; i <= number_of_vertices ; i++)
	{ 
	    Adjacency_List.put(i, new ArrayList<Integer>());
	}
    }

    /** Returns total no of vertices.
     * @return the nVertices
     */
    public int getnVertices() {
	return nVertices;
    }


    /** Returns total no of edges.
     * @return the nEdges
     */
    public int getnEdges() {
	return nEdges;
    }


    /* Adds nodes in the Adjacency list for the corresponding vertex */
    public void setEdge(int source , int destination)
    {
	if (source < 0 || source > Adjacency_List.size() || destination < 0 || destination > Adjacency_List.size())
	{
	    System.out.println("the vertex entered in not present ");
	    return;
	}

	nEdges++;
	List<Integer> slist = Adjacency_List.get(source);
	slist.add(destination);
	List<Integer> dlist = Adjacency_List.get(destination);
	dlist.add(source);
    }

    /* Returns true if edge is present. */
    public boolean hasEdge(int source, int destination)
    {
	List<Integer> sList = Adjacency_List.get(source);

	if(sList.size() == 0)
	    return false;

	return sList.contains(destination);
    }

    /* Returns the List containing the vertex joining the source vertex */		
    public List<Integer> getEdge(int source)
    {
	if (source < 0 || source > Adjacency_List.size())
	    throw new IllegalArgumentException("the vertex entered is not present");

	return Adjacency_List.get(source);
    }


    /* public HashMap<Integer, List<Integer>> cloneDFS()
    {

    	for(int neighbour : Adjacency_List.get(key))
    	{
    		if(adj)
    	}



    	return adj_list_copy;
    }

    public HashMap<Integer, List<Integer>> cloneGraph()
    {
    	for(Integer vertex : Adjacency_List.keySet())
    	{
    		Adjacency_List_Copy.put(vertex, new ArrayList<Integer>());	
    	}


    	return Adjacency_List_Copy;
    }*/




    /*
     * Main Function reads the number of vertices and edges in a graph.
     * then creates a Adjacency List for the graph and prints it  
     */
    public static void main(String...arg)
    {
	int source , destination;
	int number_of_edges,number_of_vertices;
	int count = 1;
	Scanner scan = new Scanner(System.in);
	try
	{
	    /* Read the number of vertices and edges in graph */
	    System.out.println("Enter the number of vertices and edges in graph");
	    number_of_vertices = scan.nextInt();
	    number_of_edges = scan.nextInt();
	    UndirectedGraphUsingHashmap adjacencyList = new UndirectedGraphUsingHashmap(number_of_vertices);

	    /* Reads the edges present in the graph */
	    System.out.println("Enter the edges in graph Format : <source index> <destination index>");
	    while (count <= number_of_edges)
	    {
		source = scan.nextInt();
		destination = scan.nextInt();
		adjacencyList.setEdge(source, destination);
		count++;
	    }

	    /* Prints the adjacency List representing the graph.*/
	    System.out.println ("the given Adjacency List for the graph \n");
	    for (int i = 1 ; i <= number_of_vertices ; i++)
	    {
		System.out.print(i+"->");
		List<Integer> edgeList = adjacencyList.getEdge(i);
		for (int j = 1 ; ; j++ )
		{
		    if (j != edgeList.size())
		    {
			System.out.print(edgeList.get(j - 1 )+"->");
		    }else
		    {
			System.out.print(edgeList.get(j - 1 ));
			break;
		    }						 
		}
		System.out.println();					
	    }
	} 
	catch(InputMismatchException inputMismatch)
	{
	    System.out.println("Error in Input Format. \nFormat : <source index> <destination index>");
	}
	scan.close();
    }

}
