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
		int rightNumber=0;
		if(this==null)
		{
			return 0;
		}
		else if(this.hasLeft())
		{
			leftNumber=left.getHeight();
		}
		else if ( this.hasRight())
		{
			rightNumber= right.getHeight();
		}
		
		return 1 + Math.max(leftNumber, rightNumber);
	}
	
	
	
	
}
