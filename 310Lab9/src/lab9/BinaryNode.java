package lab9;

/*
 * BinaryNode class written by Patrick McGee
 * 
 */
public class BinaryNode<T>
{
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	public BinaryNode(T Data)
	{
		data = Data;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public BinaryNode<T> getLeft()
	{
		return left;
	}

	public void setLeft(BinaryNode<T> left)
	{
		this.left = left;
	}

	public BinaryNode<T> getRight()
	{
		return right;
	}

	public void setRight(BinaryNode<T> right)
	{
		this.right = right;
	}

	public boolean hasLeft()
	{
		return (left != null);
	}

	public boolean hasRight()
	{
		return (right != null);
	}

	public boolean isLeaf()
	{
		if (hasRight() == false & hasLeft() == false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getHeight()
	{
		int leftNumber = 0;
		int rightNumber = 0;
		if (this == null)
		{
			return 0;
		}
		else if (this.hasLeft())
		{
			leftNumber = left.getHeight();
		}
		else if (this.hasRight())
		{
			rightNumber = right.getHeight();
		}

		return 1 + Math.max(leftNumber, rightNumber);
	}

	public int getNumNodes()
	{
		if (this == null)
		{
			return 0;
		}

		int leftNumber = 0;
		int rightNumber = 0;

		if (this.hasLeft())
		{
			leftNumber = left.getNumNodes();
		}
		if (this.hasRight())
		{
			rightNumber = right.getNumNodes();
		}
		return leftNumber + rightNumber + 1;

	}

	public int getNumLeaves()
	{
		int rightNumberLeaves = 0;
		int leftNumberLeaves = 0;
		if (this == null)
		{
			return 0;
		}
		else if (!this.hasLeft() & !this.hasRight())
		{
			return 1;
		}
		else if (this.hasLeft() == true)
		{
			leftNumberLeaves += left.getNumLeaves();
		}
		else if (this.hasRight())
		{
			rightNumberLeaves = right.getNumLeaves();
		}

		return rightNumberLeaves + leftNumberLeaves;
	}

	public BinaryNode<T> copy()
	{

		if (this == null)
		{
			return null;
		}
		BinaryNode<T> newRoot = new BinaryNode<T>(this.data);

		if (this.hasLeft())
		{
			newRoot.left = left.copy();
		}
		if (this.hasRight())
		{
			newRoot.right = right.copy();
		}

		return newRoot;

	}

}
