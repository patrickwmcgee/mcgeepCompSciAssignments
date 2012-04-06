package generalTree;

import java.util.HashMap;
import java.util.Map;

public class Graph<T>
{

	private Map<T, Vertex<T>> verticies;
	private int edgeCount;

	public Graph()
	{
		verticies = new HashMap<T, Vertex<T>>();
		edgeCount = 0;
	}

	public boolean isEmpty()
	{
		if (verticies == null)
			return true;
		else
			return false;
	}

	public void clear()
	{
		edgeCount = 0;
		verticies = null;
	}

	public int getNumVerticies()
	{
		return verticies.size();
	}
	public int getNumEdges()
	{
		return edgeCount;
	}
	boolean addVertex(T vertexLabel)
	{
		boolean result = false;
		if (!verticies.containsKey(vertexLabel))
		{
			verticies.put(vertexLabel, new Vertex<T>(vertexLabel));
			result = true;
		}
		return result;
	}

	public void addEdge(T start, T end, double weight)
	{
		Vertex<T> startVertex = verticies.get(start);
		Vertex<T> endVertex = verticies.get(end);
		if (startVertex != null && endVertex != null)
		{
			startVertex.connect(endVertex, weight);
			endVertex.connect(startVertex, weight);
			edgeCount++;
		}
		else
		{
			System.out.println("First add the verticies with the proper labels");
		}
	}
	public void display()
	{
		for(Vertex vertex:verticies.values())
		{
			vertex.display();
		}
		
	}

	public static void main(String[] args)
	{
		Graph<String> roadMap = new Graph<String>();
		
		roadMap.addVertex("Provincetown");
		roadMap.addVertex("Truro");
		roadMap.addVertex("Orleans");
		roadMap.addVertex("Chatham");
		roadMap.addVertex("Barnstable");
		roadMap.addVertex("Hyannis");
		roadMap.addVertex("Sandwich");
		roadMap.addVertex("Falmouth");
		
		roadMap.addEdge("Provincetown", "Truro", 10);
		roadMap.addEdge("Truro", "Orleans", 17);
		roadMap.addEdge("Orleans", "Chatham", 9);
		roadMap.addEdge("Orleans", "Barnstable", 19);
		roadMap.addEdge("Chatham", "Hyannis", 19);
		roadMap.addEdge("Barnstable", "Hyannis", 4);
		roadMap.addEdge("Barnstable", "Sandwich", 12);
		roadMap.addEdge("Hyannis", "Falmouth", 20);
		
		System.out.println("The graph has " +roadMap.getNumEdges()+ " edges and " + roadMap.getNumVerticies()+ " verticies" );
		roadMap.display();

	}

}
