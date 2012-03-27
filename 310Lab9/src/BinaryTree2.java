import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinaryTree2<T>
{
	private BinaryNode<T> root;
	private BinaryNode<T> currentNode;

	public BinaryTree2(BinaryNode<T> root)
	{
		this.root = root;
		currentNode = root;
	}

	public BinaryTree2()
	{
		this.root = null;
		currentNode = null;
	}

	public BinaryNode<T> getRoot()
	{
		return root;
	}

	public void setRoot(BinaryNode<T> root)
	{
		this.root = root;
	}

	public BinaryNode<T> getCurrentNode()
	{
		return currentNode;
	}

	public void setCurrentNode(BinaryNode<T> currentNode)
	{
		this.currentNode = currentNode;
	}

	public void advanceLeft()
	{
		if (currentNode.hasLeft())
		{
			currentNode = currentNode.getLeft();
		}
	}

	public void advanceRight()
	{
		if (currentNode.hasRight())
		{
			currentNode = currentNode.getRight();
		}
	}

	public void resetCurrentNode()
	{
		currentNode = root;
	}

	public boolean isEmpty()
	{
		if (currentNode == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

//	private class LevelOrderIterator implements Iterator<T>
//	{
//		private Queue<BinaryNode<T>> nodeQueue;
//
//		public LevelOrderIterator()
//		{
//			nodeQueue = new LinkedList<BinaryNode<T>>();
//			if (root != null)
//			{
//
//			}
//		}
//
//		public T next()
//		{
//			BinaryNode<T> nextNode;
//			if (hasNext())
//			{
//				nextNode = nodeQueue.remove();
//				BinaryNode<T> leftChild=nextNode.getLeft();
//				BinaryNode<T> rightChild=nextNode.getRight();
//				
//				if(!rightChild)
//				{
//					
//				}
//			}
//			else
//			{
//				throw new NoSuchElementException();
//			}
//			return nextNode.getData();
//		}
//
//	}
}
