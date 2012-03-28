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
		int leftNumber = 0;
		int rightNumber = 0;

		if (this == null)
		{
			return 0;
		}
		if (this.hasLeft())
		{
			leftNumber = 1 + left.getNumNodes();
		}
		if (this.hasRight())
		{
			rightNumber = 1 + right.getNumNodes();
		}
		return leftNumber + rightNumber ;

	}

	public int getNumLeaves()
	{
		int numLeaves = 0;
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
			numLeaves += this.getNumLeaves();
		}
		else if (this.hasRight())
		{
			numLeaves += this.getNumLeaves();
		}

		return numLeaves;
	}

	public BinaryNode<T> copy(BinaryNode<T> copyRoot)
	{
		BinaryNode<T> newRoot = null;
		if (copyRoot == null)
		{
			return null;
		}
		else
		{
			newRoot.setData(copyRoot.getData());
			newRoot.setLeft(copyRoot.getLeft());
			newRoot.setRight(copyRoot.getRight());
			if (copyRoot.hasLeft())
			{
				copy(copyRoot.getLeft());
			}
			if (copyRoot.hasRight())
			{
				copy(copyRoot.getRight());
			}
		}

		return newRoot;

	}

}
