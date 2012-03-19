public class BinaryTree<T>
{
	private BinaryNode<T> root;
	private BinaryNode<T> currentNode;

	public BinaryTree(BinaryNode<T> root)
	{
		this.root = root;
		currentNode=root;
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
	
}
