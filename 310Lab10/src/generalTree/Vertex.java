package generalTree;

import generalTree.Graph.Edge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex<T>
{
	ArrayList<Edge> edgeList = new ArrayList<Edge>();
	T label;

	public Vertex(T label)
	{
		this.label = label;
		edgeList = null;
	}

	public boolean connect(Vertex<T> endVertex, double edgeWeight)
	{
		boolean isConnected = false;
		boolean result = false;
		
		if (this.equals(endVertex))
		{
			isConnected = true;
			result = false;
		}

		if (!this.equals(endVertex))
		{
			for (Edge edge : edgeList)
			{
				if (edge.getEndVertex().equals(endVertex))
				{
					isConnected = true;
					result=false;
				}
			}
		}
	

		if (!isConnected)
		{
			edgeList.add(new Edge(endVertex, edgeWeight));
			result=true;
		}
		return result;

	}

	public T getLabel()
	{
		return label;
	}

	public void display()
	{

	}
	public class Edge
	{
		private Vertex<T> vertex;
		private double weight;

		public Edge(Vertex<T> endVertex, double edgeWeight)
		{
			vertex = endVertex;
			weight = edgeWeight;
		}

		protected Vertex<T> getEndVertex()
		{
			return vertex;
		}

		protected double getWeight()
		{
			return weight;
		}

	}
}
