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
		if (this.left != null)
		{
			return true;
		}
		else
			return false;
	}

	public boolean hasRight()
	{
		if (this.right != null)
		{
			return true;
		}
		else
			return false;
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
}
