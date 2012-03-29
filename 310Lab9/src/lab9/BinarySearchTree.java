package lab9;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>
{
	public BinarySearchTree()
	{
		super();
	}
	
	public BinaryNode<T> search(T entry)
	{
		return search(getRoot(), entry);
	}

	private BinaryNode<T> search(BinaryNode<T> rootNode, T entry)
	{
		BinaryNode<T> result = null;
		if (rootNode != null)
		{
			if (entry == rootNode.getData())
			{
				result = rootNode;
			}
			else if (entry.compareTo(rootNode.getData()) < 0)
			{
				result = search(rootNode.getLeft(), entry);
			}
			else
			{
				result = search(rootNode.getRight(), entry);
			}
		}
		
		return result;
	}

	public boolean contains(T entry)
	{
		return search(entry) != null;
	}

	public boolean add(T newEntry)
	{
		if (newEntry == null)
			return false;
		else
		{
			return add(getRoot(), newEntry);
		}
	}

	private boolean add(BinaryNode<T> rootNode, T newEntry)
	{
		boolean result = false;
		int comparison = newEntry.compareTo(rootNode.getData());

		if (comparison == 0)
		{
			result = false; // the element is the same and is not added
		}
		else if (comparison < 0)
		{
			if (rootNode.hasLeft())
			{
				result = add(rootNode.getLeft(), newEntry);
			}
			else
			{
				rootNode.setLeft(new BinaryNode<T>(newEntry));
				result = true;
			}
		}
		else if (comparison > 0)
		{
			if (rootNode.hasRight())
			{

				result = add(rootNode.getRight(), newEntry);
			}
			else
			{
				rootNode.setRight(new BinaryNode<T>(newEntry));
				result = true;
			}
		}
		return result;
	}

	public BinaryNode<T> findMax()
	{
		if (isEmpty())
			return null;
		return findMax(getRoot());
	}

	private BinaryNode<T> findMax(BinaryNode<T> rootNode)
	{
		if (rootNode == null)
			return null;
		if (rootNode.hasRight())
		{
			rootNode = findMax(rootNode.getRight());
		}
		return rootNode;
	}

	public BinaryNode<T> findMin()
	{

		if (isEmpty())
			return null;
		return findMin(getRoot());
	}

	private BinaryNode<T> findMin(BinaryNode<T> rootNode)
	{
		if (rootNode == null)
			return null;
		if (rootNode.hasLeft())
		{
			rootNode = findMax(rootNode.getLeft());
		}
		return rootNode;
	}
	
	public static void main(String args[])
	{
	}
	
}
