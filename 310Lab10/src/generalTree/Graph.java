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

	public void addEdge(T start, T end, double weight)
	{
		Vertex<T> startVertex = verticies.get(start);
		Vertex<T> endVertex = verticies.get(end);
		if (startVertex != null && endVertex != null)
		{
			startVertex.connect(endVertex, weight);
			endVertex.connect(startVertex, weight);
		}
		else
		{
			System.out.println("First add the verticies with the proper labels");
		}
	}

	// public boolean connect(Vertex<T> endVertex);
	
}
