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

	// public boolean connect(Vertex<T> endVertex);
	protected class Vertex<T>
	{

	}

}
